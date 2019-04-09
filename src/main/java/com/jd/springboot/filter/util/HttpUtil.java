package com.jd.springboot.filter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpUtil {
  private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

  public static InputStream getUrlInputStream(String urlStr) {
    URL url = null;
    try {
      url = new URL(urlStr);
      return url.openConnection().getInputStream();
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("getUrlInputStream error " + e);
    }
    return null;
  }
}
