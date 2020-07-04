package com.myfun.utils.poCovert.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 目前用于标记VO中出租字段的属性名，用于PO转换成VO时使用
 * @author Administrator
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LeaseField {
	public String poFieldValue() default "";
}
