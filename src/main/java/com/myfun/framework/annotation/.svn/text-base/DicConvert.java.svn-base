package com.myfun.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 目前用于自动转换数据字典对应的值
 * @author 陈文超
 * @date 2016年6月1日 上午10:16:54
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DicConvert {
	public String dicTypeStr() default "";
	public String fromFieldName() default "";
}
