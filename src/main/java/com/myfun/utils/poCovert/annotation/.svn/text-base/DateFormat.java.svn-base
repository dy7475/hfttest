package com.myfun.utils.poCovert.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 目前用于标记VO中求购字段的属性名，用于PO转换成VO时使用
 * 用于标记需要格式化的数
 * @author 陈文超
 * @date 2016年6月1日 上午10:16:54
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormat {
	public String value() default "";
}
