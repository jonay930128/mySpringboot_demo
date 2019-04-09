package com.jd.springboot.filter;

import com.jd.springboot.util.Jsons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class MyFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(MyFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    String contextPath = httpServletRequest.getRequestURI();

    ServletRequest requestWrapper = new RequestWrapper(httpServletRequest);
    Map m = request.getParameterMap();
//    System.out.println(httpServletRequest.getContentType());
    logger.info("url : " + contextPath);
    logger.info("body : " + Jsons.objToJson(m));
    chain.doFilter(requestWrapper, response);
  }

  @Override
  public void destroy() {

  }
}
