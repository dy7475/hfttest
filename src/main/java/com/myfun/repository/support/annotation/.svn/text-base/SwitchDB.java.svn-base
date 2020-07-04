package com.myfun.repository.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.myfun.repository.support.datasource.SwitchDBType;

/**
 * 切换数据库标识
 * 
 * @ClassName: SwitchDB
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月13日 下午7:48:34
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface SwitchDB {
	public String value() default "";

	public SwitchDBType type() default SwitchDBType.CITY_ID;
}
