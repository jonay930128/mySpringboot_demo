package com.jd.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2020/5/18 10:34 上午
 */

@Target(value = ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LineConvertHump {
}
