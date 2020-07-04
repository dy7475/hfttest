package com.myfun.utils.poCovert.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于对返回到前端的VO字段URL编码
 * 默认：utf-8
 * @author 陈文超
 * @date 2017年2月14日 下午1:42:18
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CharsetUrlEncode {
	public String charset() default "";
}
