package com.myfun.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.Null;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 基础工具类
 * 
 * @ClassName: BaseUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年6月19日 上午11:22:42
 *
 */
public class BaseUtil {
	private BaseUtil() {
	}

	public static boolean isPrimitiveType(Object obj) {
		return obj instanceof Byte || obj instanceof Boolean || obj instanceof Short || obj instanceof Integer || obj instanceof Long || obj instanceof Float || obj instanceof Double;
	}

	public static boolean isString(Object obj) {
		return obj instanceof Character || obj instanceof String;
	}

	public static boolean isDate(Object obj) {
		return obj instanceof Date;
	}
	
	public static boolean isEmpty(Collection collection){
		if(collection==null){
			return true;
		}else{
			if(collection.size()==0){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isEmpty(Object[] object){
		if(object==null){
			return true;
		}else{
			if(object.length==0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断是否相等
	 * @author 臧铁
	 * @since 2017年7月13日
	 * @param source 原始对象
	 * @param compareTO 对比的对象
	 * @return
	 */
	public static boolean equal(Object source, Object compareTO){
		if(source == null || compareTO == null) {
			return false;
		}
		// byte类型处理
		if (source instanceof Byte || compareTO instanceof Byte) {
			return (byte)source == (byte)compareTO;
		}
		return false;
	}
	
	/**
	 * 复制PO
	 * @author HeWei
	 * @since 2018年7月19日 下午4:49:18
	 * @param dest
	 * @param orig
	 * Modified XXX HeWei 2018年7月19日
	 */
	public static void copyPropertiesExt(Object dest, Object orig){
	    try {
	    	BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
	}
}
