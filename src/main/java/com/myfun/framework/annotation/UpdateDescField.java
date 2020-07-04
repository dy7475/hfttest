package com.myfun.framework.annotation;

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
	 * 数据字典策略名称
	 * @return
	 */
	public String dateForMat() default "";
	/**
	 * 用于处理字典的对应值，将字典与字典值描述对应
	 * 格式：1:审核成功,2:审核失败
	 * @author 陈文超
	 * @date 2018年2月8日 上午11:54:14
	 */
	public String dicValueStr() default "";
}
