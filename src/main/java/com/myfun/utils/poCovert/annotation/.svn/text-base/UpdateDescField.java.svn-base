package com.myfun.utils.poCovert.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UpdateDescField {
	/**
	 * 字段名称
	 * @return
	 */
	public String fieldValue() default "";
	/**
	 * 字段描述
	 * @return
	 */
	public String fieldDesc() default "";
	/**
	 * 数据字典名称
	 * @return
	 */
	public String dicType() default "";
	
	/**
	 * 数据字典是否是多个值
	 * @return
	 */
	public boolean dicIsMult() default false;
	
	/**
	 * 数据字典多个值的时候以什么分隔的
	 * @return
	 */
	public String dicIsMultSplit() default "";
	
	
	/**
	 * 用于富文本最大长度限制
	 * @return
	 */
	public int maxLength() default 0;
	/**
	 * 数据字典策略class
	 * @return
	 */
	public Class<?> dicCnConvertStrategy() default Object.class;
	/**
	 * 数据字典策略名称
	 * @return
	 */
	public String dicCnConvertMethod() default "";
	/**
	 * 数据字典策略名称
	 * @return
	 */
	public String dateForMat() default "";
	/**
	 * 数字类型转换格式说明
	 * @return
	 */
	public String numberForMat() default "";
	
	/**
	 * 数字类型转换格式说明
	 * @return
	 */
	public String prefixName() default "";
}
