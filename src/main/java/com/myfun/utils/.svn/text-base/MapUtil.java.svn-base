package com.myfun.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {

	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null) {
			return null;
		}

		Object obj = beanClass.newInstance();

		org.apache.commons.beanutils.BeanUtils.populate(obj, map);

		return obj;
	}

	public static Map<String, Object> objectToMap(Object obj) throws Exception {
		if(obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (key.compareToIgnoreCase("class") == 0) {
				continue;
			}
			Method getter = property.getReadMethod();
			Object value = getter!=null ? getter.invoke(obj) : null;
			map.put(key, value);
		}

		return map;
	}

	/**
	* @author 邓永洪
	* @since 2018/4/18
	* @tag 把list中的对象转成Map
	*/
	public static List<Map<String, Object>> listObjTolistMap(List<?> list){

		List<Map<String, Object>> retList=new ArrayList<>();
		if (list!=null&&list.size()>0){
			for (Object obj:list){
				Map<String, Object> map = new HashMap();
				Field[] declaredFields = obj.getClass().getDeclaredFields();
				for (Field field : declaredFields) {
					field.setAccessible(true);
					try {
						map.put(field.getName(), field.get(obj));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				retList.add(map);
			}
		}

		return retList;
	}

}
