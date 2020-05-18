package com.jd.springboot.config;

import com.jd.springboot.annotation.LineConvertHump;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2020/5/18 10:34 上午
 */

public class LineToHumpHandler implements HandlerMethodArgumentResolver {
    private static MappingJackson2HttpMessageConverter converter;
    public static final Pattern PATTERN = Pattern.compile("_(\\w)");

    static {
        converter = new MappingJackson2HttpMessageConverter();
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LineConvertHump.class);
    }

    private String underLineToCamel(String str) {
        Matcher matcher = PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest servletRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(servletRequest);
        Object result = null;
        try {
            Type genericParameterType = methodParameter.getGenericParameterType();
            String contentType = servletRequest.getContentType();
            if (MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
                result = converter.read(Class.forName(genericParameterType.getTypeName()), inputMessage);
            } else {
                Object obj = BeanUtils.instantiate(methodParameter.getParameterType());
                BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(obj);
                Map<String, String[]> parameterMap = nativeWebRequest.getParameterMap();
                for (Map.Entry<String, String[]> map : parameterMap.entrySet()) {
                    String paramName = map.getKey();
                    String[] paramValue = map.getValue();
                    Field[] declaredFields = obj.getClass().getDeclaredFields();
                    //如果pojo里有带下划线则直接设置
                    for (Field declaredField : declaredFields) {
                        if (declaredField.getName().contains("_") && paramName.equals(declaredField.getName())) {
                            wrapper.setPropertyValue(paramName, paramValue);
                            break;
                        }
                        String underLineParamName = underLineToCamel(paramName);
                        if (declaredField.getName().equals(underLineParamName)) {
                            wrapper.setPropertyValue(underLineParamName, paramValue);
                            break;
                        }
                    }
                }
                result = obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}