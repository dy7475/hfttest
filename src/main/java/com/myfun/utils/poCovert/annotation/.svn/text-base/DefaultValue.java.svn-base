package com.myfun.utils.poCovert.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 目前用于标记VO中租售共存的属性名，用于PO转换成VO时使用
 * 添加被标记的默认值
 * @author 陈文超
 * @date 2016年6月1日 上午10:16:54
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
	public String value() default "";
}
