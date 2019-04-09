package com.jd.springboot.exception;

import com.jd.springboot.response.ErrorResult;
import com.jd.springboot.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 请填写类的描述
 * 全局异常处理
 * @author wangruxing
 * @date 2018-04-09 20:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result resolveException(HttpServletRequest request, Exception e){
        logger.error("报错请求路径:"+request.getRequestURL().toString(),e);
        return new ErrorResult("9999",e.getMessage());
    }
}
