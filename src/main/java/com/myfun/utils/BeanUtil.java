package com.myfun.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;

import net.sourceforge.jtds.jdbc.DateTime;
import org.springframework.beans.BeanWrapperImpl;


public class BeanUtil {
	private transient static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);

	public static void beanToMap(Object object, Map<String, Object> map) {

		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(object.getClass());
		} catch (IntrospectionException e1) {
			e1.printStackTrace();
		}
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			try {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					Method getter = property.getReadMethod();
					Object value = getter.invoke(object);
					map.put(key, value);
				}
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * 将map转化为bean
	 * 
	 * @param map
	 * @param objClass
	 * @return
	 */
	public static <T> T map2Bean(@SuppressWarnings("rawtypes") Map map, Class<T> objClass) {
		T t = null;
		try {
			t = objClass.newInstance();
			map2Bean(map, t, null);
		} catch (Exception e) {
		}
		return t;
	}
	
	/**
	 * 将map转化为bean
	 * @param map
	 * @param object
	 * @param defultVal map里面get为null的就使用这个值
	 */
	
	public static void map2Bean(@SuppressWarnings("rawtypes") Map map, Object object, Object defultVal) {
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(object.getClass());
		} catch (IntrospectionException e1) {
			e1.printStackTrace();
		}
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			try {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					Method setter = property.getWriteMethod();
					Object val = map.get(key);
					if(val == null){val = defultVal;}
					setter.invoke(object, val);
				}
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * 下划线的类转换成驼峰类
	 * @author 张宏利
	 * @since 2016年2月27日
	 * @param resouceObj
	 * @param clazz
	 * @return
	 */
	public static <T> T underlineObjToCamelObj(Object resouceObj, Class<T> clazz) {
		BeanInfo beanInfo;
		try {
			T resultObj = clazz.newInstance();
			Class<?> clazzObj = resouceObj.getClass();
			beanInfo = Introspector.getBeanInfo(clazzObj);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName(); 
				if (!"class".equals(propertyName)) {
					Method method = descriptor.getReadMethod();
					if(method == null){
						method = clazzObj.getMethod("get" + propertyName);
					}
					String data = (String) method.invoke(resouceObj);
					propertyName = underlineToCamel(propertyName);
					propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
					method = clazz.getMethod("set" + propertyName, String.class);
					method.invoke(resultObj, data);
				}
			}
			return resultObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> Map<String,Object> objToKeyMap(T obj) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());

			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					Method readMethod = descriptor.getReadMethod();
					Object result =  readMethod.invoke(obj,
							new Object[0]);
					if (result != null) {
						hashMap.put(propertyName, result);
					} else {
						// hashMap.put(propertyName, "");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	
	/**
	 * 驼峰类转换成下划线的类
	 * @author 张宏利
	 * @since 2016年2月27日
	 * @param resouceObj
	 * @param clazz
	 * @return
	 */
	public static <T> T camelObjToUnderlineObj(Object resouceObj, Class<T> clazz) {
		try {
			T resultObj = clazz.newInstance();
			Class<?> clazzObj = resouceObj.getClass();
			BeanInfo beanInfo = Introspector.getBeanInfo(clazzObj);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName(); 
				if (!"class".equals(propertyName)) {
					Method method = descriptor.getReadMethod();
					if(method == null){
						method = clazzObj.getMethod("get" + propertyName);
					}
					String data = (String) method.invoke(resouceObj);
					method = clazz.getMethod("set" + camelToUnderline(propertyName), String.class);
					method.invoke(resultObj, data);
				}
			}
			return resultObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将驼峰命名法的Bean转换成下划线的bean
	 * @author 张宏利
	 * @since 2016年2月27日
	 * @return
	 */
	public static String camelToUnderline(String param){
		if (param==null||"".equals(param.trim())){
			return "";
		}
		int len=param.length();
		StringBuilder sb=new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)){
				sb.append("_");
			}
			sb.append(Character.toUpperCase(c));
		}
		return sb.toString();
	}
	
	/**
	 * 将下划线的bean转换成驼峰命名法的Bean
	 * @author 张宏利
	 * @since 2016年2月27日
	 * @return
	 */
	public static String underlineToCamel(String param){
		if (param==null||"".equals(param.trim())){
			return "";
		}
		int len=param.length();
		StringBuilder sb=new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == '_'){
				if (++i < len){
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString();
	}

	public static String underlineToCamelKey(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		return JSON.toJSONString(jsonStrToMap(param));
	}

	public static Map<String, Object> jsonStrToMap(String json) {
		JSONObject jsonResult = JSONObject.parseObject(json);
		Map<String, Object> result = jsonOjbToMap(jsonResult);
		return result;
	}

	private static Map<String, Object> jsonOjbToMap(JSONObject jsonResult) {
		Map<String, Object> result = new HashMap<String, Object>();
		Iterator<String> keyIt = jsonResult.keySet().iterator();
		while (keyIt.hasNext()) {
			String key = keyIt.next();
			Object val = jsonResult.get(key);
			key = underlineToCamel(key);
			if (!(val instanceof JSONObject) && !(val instanceof JSONArray)) {
				result.put(key, val);
				continue;
			}
			if (val instanceof JSONObject) {
				Map<String, Object> valMap = jsonOjbToMap((JSONObject) val);
				result.put(key, valMap);
				continue;
			}
			if (val instanceof JSONArray) {
				JSONArray ja = (JSONArray) val;
				result.put(key, jsonArrToList(ja));
			}
		}
		return result;
	}

	private static List<Object> jsonArrToList(JSONArray jsonArray) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < jsonArray.size(); i++) {
			Object val = jsonArray.get(i);
			if (!(val instanceof JSONObject) && !(val instanceof JSONArray)) {
				list.add(val);
				continue;
			}
			if (val instanceof JSONObject) {
				Map<String, Object> map = jsonOjbToMap((JSONObject) val);
				list.add(map);
				continue;
			}
			if (val instanceof JSONArray) {
				list.add(jsonArrToList((JSONArray) val));
				continue;
			}
		}
		return list;
	}

	/**
	 * 将下划线的bean转换成驼峰命名法的Bean
	 * @author 张宏利
	 * @since 2016年2月27日
	 * @return
	 */
	public static String underlineToCamel2(String param){
		if (param==null||"".equals(param.trim())){
			return "";
		}
		StringBuilder sb=new StringBuilder(param);
		Matcher mc= Pattern.compile("_").matcher(param);
		int i=0;
		while (mc.find()){
			int position=mc.end()-(i++);
			sb.replace(position-1,position+1,sb.substring(position,position+1).toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将List集合 转换为  以指定Field 为key的Map集合
	 * @param dataList
	 * @param clazz
	 * @param key
	 * @return
	 * @author 胡飞龙
	 */
	public static <T> Map<String,T> BaseBeanListToObjMap(List<T> dataList, Class<T> clazz,String key) {
		Map<String,T> objmap = new HashMap<String,T>();
		if(dataList == null || dataList.size() <= 0) {
			return objmap;
		}
		for (T data : dataList) {
			try {
				Object obj=invokeMethodByBaseBeanField(key,data);
				String value=null;
				if(obj!=null){
					value=obj.toString();
				}
				objmap.put(value,data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return objmap;
	}
	/**
	 * 将Map集合 转换为List集合
	 * @param map
	 * @return
	 * @author 胡飞龙
	 */
	public static <T> List<T> objectMapToObjectList(Map<String, T> map) {
		List<T> list =new ArrayList<T>();
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			T value = map.get(key);
			list.add(value);
		}
		return list;
	} 

	/**
	 * 是否是基本类型
	 * @param clazz
	 * @return
	 * @author 胡飞龙
	 */
	public static boolean isBaseDataType(Class<?> clazz)  
	 {   
	     return 
	     (   
	         clazz.equals(String.class) ||   
	         clazz.equals(Integer.class)||   
	         clazz.equals(Byte.class) ||   
	         clazz.equals(Long.class) ||   
	         clazz.equals(Double.class) ||   
	         clazz.equals(Float.class) ||   
	         clazz.equals(Character.class) ||   
	         clazz.equals(Short.class) ||   
	         clazz.equals(BigDecimal.class) ||   
	         clazz.equals(BigInteger.class) ||   
	         clazz.equals(Boolean.class) ||   
	         clazz.equals(Date.class) ||   
	         clazz.equals(DateTime.class) ||
	         clazz.isPrimitive()   
	     );   
	 }
	/**
	 * Map转Obj
	 * @param map
	 * @param thisObj
	 * @author 胡飞龙
	 */
	public static Object mapToObj(Map<String, String> map, Object thisObj) {
		
		if(thisObj==null){
			return thisObj;
		}
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		if(isBaseDataType(thisObj.getClass())){
			while (iterator.hasNext()) {
				thisObj= map.get(iterator.next());
			}
			return thisObj;
		}
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object val = map.get(key);
			try {
				setMethod(key, val, thisObj,new Class[] { Class.forName("java.lang.String") });
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return thisObj;
	}
	public static<T> T mapToObj(Map<String, String> map, Class<T> clazz) throws Exception {
		T thisObj =clazz.newInstance();
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object val = map.get(key);
			try {
				setMethod(key, val, thisObj,new Class[] { Class.forName("java.lang.String") });
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return thisObj;
	}
	
	/**
	 * obj 转map 不可包含自定义类型
	 * @param obj
	 * @return
	 * @author 胡飞龙
	 */
	public static <T> Map<String, Object> objToObjMap(T obj) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(obj, new Object[0]);
					if (result != null) {
						hashMap.put(propertyName, result);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	
	/**
	 * obj 转map 不可包含自定义类型
	 * @param obj
	 * @return
	 * @author 胡飞龙
	 */
	public static <T> Map<String, String> objToMap(T obj) {
		Map<String, String> hashMap = new HashMap<String, String>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(obj, new Object[0]);
					if (result != null) {
						hashMap.put(propertyName, result.toString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	
	/**
	 * obj 转map 不可包含自定义类型
	 * @param obj
	 * @return
	 * @author 胡飞龙
	 */
	public static <T> Map<String, Object> objToMapObject(T obj) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(obj, new Object[0]);
					if (result != null) {
						hashMap.put(propertyName, result);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}

	public static <T> List<String> getBeanPropertyName(Class<T> clazz) {
		List<String> list=new ArrayList<String>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					list.add(propertyName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} 
	public static <T> String getBeanPropertyNameString(Class<T> clazz) {
		List<String> list=new ArrayList<String>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					list.add(propertyName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String value=list.toString();
		return value=value.substring(1, value.length()-1);
	} 

	public static String getMethodFieldForString(String fieldName, Object thisObj){
		try {
			Class<?> c;
			if(thisObj==null){
				logger.warn("当前操作对象为空");
				return null;
			}
			c = Class.forName(thisObj.getClass().getName());
			String met;
			if (!String.valueOf(fieldName).startsWith("get")) {
				met = "get" + StringUtils.capitalize(fieldName);
			}else {
				met= fieldName.toString();
			}
			Method m = c.getMethod(met, null);
			return (String) m.invoke(thisObj, null);
		} catch (NoSuchMethodException e) {
			// 方法未找到的直接忽略
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void setMethodForStringType(String fieldNameOrMethodName, Object value, Object thisObj){
		try {
		    Class<?> c;
		    if(thisObj==null){
		    	logger.warn("当前操作对象为空");
		    	return;
		    }
			c = Class.forName(thisObj.getClass().getName());
			String met;
			if (!String.valueOf(fieldNameOrMethodName).startsWith("set")) {
				met = "set" + StringUtils.capitalize(fieldNameOrMethodName);
			}else {
				met= fieldNameOrMethodName.toString();
			}
			Method m;
				m = c.getMethod(met, String.class);
				m.invoke(thisObj, value);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				/**
				 * 方法未找到的直接忽略
				 */
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	public static void setMethod(String fieldNameOrMethodName, Object value, Object thisObj,
			Class<?> types[]) {
		try {
		    Class<?> c;
			c = Class.forName(thisObj.getClass().getName());
			String met;
			if (!String.valueOf(fieldNameOrMethodName).startsWith("set")) {
				met = "set" + StringUtils.capitalize(fieldNameOrMethodName);
			}else {
				met= fieldNameOrMethodName.toString();
			}
			Method m;
				m = c.getMethod(met, types);
				m.invoke(thisObj, value);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				/**
				 * 方法未找到的直接忽略
				 */
				// e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
	}
	public static void setMethodForStringParameterTypes(String fieldNameOrMethodName, Object value, Object thisObj) {
		try {
		    Class<?> c;
			c = Class.forName(thisObj.getClass().getName());
			String met;
			if (!String.valueOf(fieldNameOrMethodName).startsWith("set")) {
				met = "set" + StringUtils.capitalize(fieldNameOrMethodName);
			}else {
				met= fieldNameOrMethodName.toString();
			}
			Method m;
				m = c.getMethod(met,String.class);
				m.invoke(thisObj, value);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				/**
				 * 方法未找到的直接忽略
				 */
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
	}
	public static Object invokeMethodByBaseBeanField( String fieldName, Object thisObj) {
		try {
		    Class<?> c;
			c = Class.forName(thisObj.getClass().getName());
			Method m;
			
				m = c.getMethod("get"+StringUtils.capitalize(fieldName));
				return m.invoke(thisObj);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				/**
				 * 方法未找到的直接忽略
				 */
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		return null;
			
	}
	public interface QueryCondition<T,M>{
		public M callback(T t)throws Exception;
	}
	public static <T,M> List<M> queryOneToMayCollectionByCondition(
			Collection<T> collection, QueryCondition<T,M> condition) throws Exception{
		logger.debug("集合大小为{}",collection.size());
		if(collection.size()==0){
			return new ArrayList<M>();
		}
		List<M> list=new ArrayList<M>();
		for(T t:collection){
			M m=condition.callback(t);
			if(m!=null){
				list.add(m);
			}
		}
		if(list.size()==0)
		logger.warn("集合中未找到符合条件的值");
		return list;
	}
	public interface QueryExecutor<T>{
		public T execute(T node);
	} 
	public static <T> T queryCollectionBykey(
			Collection<T> collection, QueryExecutor<T> queryExecutor) {
		logger.debug("集合大小为{}",collection.size());
		if(collection.size()==0){
			return null;
		}
		for(T t:collection){
			T node=queryExecutor.execute(t);
			if(node!=null){
				return node;
			}
		}
		logger.warn("集合中未找到记录");
		return null;
	}
	
	public static <T> T queryCollectionBykey(
			Collection<T> collection, String keyField, Object value) {
		logger.debug("集合大小为{}",collection.size());
		if(collection.size()==0){
			return null;
		}
		for(T t:collection){
			Object object=invokeMethodByBaseBeanField(keyField, t);
			if(object.equals(value)){
				return t;
			}
		}
		logger.warn("集合中未找到 keyField：{} 值为：{} 的记录",keyField,value);
		return null;
	}
	public static <T> List<T> queryCollectionForListBykey(
			Collection<T> collection,QueryExecutor<T> queryExecutor) {
		logger.debug("集合大小为{}",collection.size());
		List<T> list=new ArrayList<T>();
		if(collection.size()==0){
			return list;
		}
		for(T t:collection){
			T node=queryExecutor.execute(t);
			if(node!=null){
				list.add(node);
			}
		}
		if(list.size()==0)
		logger.info("集合中未找到记录");
		return list;
	}
	public static <T> List<T> queryCollectionForListBykey(
			Collection<T> collection, String keyField, Object value) {
		logger.debug("集合大小为{}",collection.size());
		if(collection.size()==0){
			return new ArrayList<T>();
		}
		List<T> list=new ArrayList<T>();
		for(T t:collection){
			Object object=invokeMethodByBaseBeanField(keyField, t);
			if(object!=null&&object.equals(value)){
				list.add(t);
			}
		}
		return list;
	}
	public static <T> List<String> queryCollectionForFeildListBykey(
			Collection<T> collection, String keyField) {
		logger.debug("集合大小为{}",collection.size());
		if(collection.size()==0){
			return new ArrayList<String>();
		}
		List<String> list=new ArrayList<String>();
		for(T t:collection){
			Object obj=invokeMethodByBaseBeanField(keyField, t);
			String value=null;
			if(obj!=null){
				value=obj.toString();
			}
			list.add(value);
		}
		return list;
	}
	public static <T>List<T> subList(List<T> tempList,
			int page_OFFSET, int page_ROWS) {
		int size=tempList.size();
		if(size==0){
			return tempList;
		}
	
		int start=(page_OFFSET-1)*page_ROWS;
		if(start<0||start>=size){
			start=0;
		}
		int end=page_OFFSET*page_ROWS;
		if(end>=size){
			end=size;
		}
		
		return tempList.subList(start,end);
	}
  
	public static <T>List<T> compareToSameValueCollection(
			List<T> ones, List<T> twos,
			String fieldName) {
		List<T> sameList=new ArrayList<T>();
		for(T one:ones){
			for (T two:twos ) {
				Object oneObject=invokeMethodByBaseBeanField(fieldName, one);
				Object twoObject=invokeMethodByBaseBeanField(fieldName, two);
				if(oneObject.equals(twoObject)){
					sameList.add(two);
				}
			}
		}
		return sameList;
	}
	public static <T>Map<String,T> compareToSameValueForMapCollection(
			List<T> ones, List<T> twos,
			String fieldName) {
		Map<String,T> sameMap=new HashMap<String,T>();
		for(T one:ones){
			for (T two:twos ) {
				Object oneObject=invokeMethodByBaseBeanField(fieldName, one);
				Object twoObject=invokeMethodByBaseBeanField(fieldName, two);
				if(oneObject.equals(twoObject)){
					if(oneObject!=null){
						sameMap.put(oneObject.toString(),two);
					}
				}
			}
		}
		return sameMap;
	}
	public static <T> String[] buildQueryKeysNoRepeat(List<T> tempList,String fieldName) {
		Set<String> list = new LinkedHashSet<String>();
		for(T t: tempList){
			Object obj = invokeMethodByBaseBeanField(fieldName, t);
			if(obj != null){
				list.add(obj.toString());
			}
		}
		return list.toArray(new String[list.size()]);
	}
	
	public static <T> List buildQueryKeysOffList(List<T> tempList,String fieldName) {
		List<String> list = new ArrayList<String>();
		for(T t: tempList){
			Object obj = invokeMethodByBaseBeanField(fieldName, t);
			if(obj != null){
				list.add(obj.toString());
			}
		}
		return list;
	}
	
	public static <T> String[] buildQueryKeysNoRepeat(Map<String,T> tempMap,String fieldName) {
		Set<String> list=new HashSet<String>();
		for(String key: tempMap.keySet()){
			T t=tempMap.get(key);
			Object obj=invokeMethodByBaseBeanField(fieldName, t);
			String val=null;
			if(obj!=null){
				val=obj.toString();
			}
			list.add(val);
		}
		return  list.toArray(new String[list.size()]);
	}
	public static <T> String[] buildQueryKeys(List<T> tempList,String fieldName) {
		List<String> list=new ArrayList<String>();
		for(T t: tempList){
			Object obj=invokeMethodByBaseBeanField(fieldName, t);
			String value=null;
			if(obj!=null){
				value=obj.toString();
			}
			list.add(value);
		}
		return  list.toArray(new String[list.size()]);
	}
	/**
	 * 
	 * @param tempList
	 * @param fieldName
	 * @return
	 */
	public static <T> List<Integer> buildQueryTempKeys(List<T> tempList,String fieldName) {
		List<Integer> list=new ArrayList<Integer>();
		for(T t: tempList){
			Object obj = invokeMethodByBaseBeanField(fieldName, t);
			if (obj != null) {
				list.add(Integer.valueOf(obj.toString()));
			}
		}
		return  list;
	}
	public static <T> String[] buildQueryKeys(Map<String,T> tempMap,String fieldName) {
		List<String> list=new ArrayList<String>();
		for(String key: tempMap.keySet()){
			T t=tempMap.get(key);
			Object obj=invokeMethodByBaseBeanField(fieldName, t);
			String val=null;
			if(obj!=null){
				val=obj.toString();
			}
			list.add(val);
		}
		return  list.toArray(new String[list.size()]);
	}
	public static boolean allIsNullBuilder(String ... values){
		for (String temp:values) {
			if(StringUtils.isNotBlank(temp)){
				return false;
			}
		}
		return true;
	}

	public static boolean containsBuilder(String value,String ... strings ){
		for (String temp:strings) {
			if(value.contains(temp)){
				return true;
			}
		}
		return false;
	}
	public static boolean endWithBuilder(String value,String ... strings ){
		for (String temp:strings) {
			if(value.endsWith(temp)){
				return true;
			}
		}
		return false;
	}
	public static <T> T buildBaseBean(T model,Map<String, String> map) throws IllegalArgumentException, IllegalAccessException{
		Field[] fields = model.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			if ("serialVersionUID".equals(field.getName())) {
				continue;
			}
			field.setAccessible(true);
			String valueString = map.get(field.getName());
			if (valueString == null) {
				field.set(model, null);
			} else {
				field.set(model, valueString);
			}
		}
		return model;
		
	}
	public static <T> T createBaseBean(Class<T> clazz,Map<String, String> map){
		T model=null;
		try {
			model = clazz.newInstance();
			Field[] fields = model.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if ("serialVersionUID".equals(field.getName())) {
					continue;
				}
				String valueString = map.get(field.getName());
				if (valueString == null) {
					field.set(model, null);
				} else {
					field.set(model, valueString);
				}
			}
			return model;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return model;
	}

	public static<T> Map<String, T> listObjToMapObj(
			List<T> list, String fieldName) {
		Map<String, T> map=new HashMap<String, T>();
		if(list.size()>0){
			for(T t:list){
				Object obj=invokeMethodByBaseBeanField(fieldName, t);
				String val=null;
				if(obj!=null){
					val=obj.toString();
				}
				map.put(val, t);
			}
		}
		return map;
	}
	public static<T> List<T>  MapObjTolistObj(Map<String, T> map,Comparator<T> comparator) {
		List<T> list=new ArrayList<T>();
		if(map.size()>0){
			for (T value : map.values()) {
				list.add(value);
			}
		}
		Collections.sort(list,comparator);
		return list;
	}
	public static<T> List<T>  MapObjTolistObj(Map<String, T> map) {
		List<T> list=new ArrayList<T>();
		if(map.size()>0){
			for (T value : map.values()) {
				list.add(value);
			}
		}
		return list;
	}
	
	public static<T> Map<String, List<T>> listObjToMapObjPackForList(List<T> list, String fieldName){
		Map<String, List<T>> map=new HashMap<String, List<T>>();
		List<T> pack=null;
		if(list.size()>0){
			for(T t:list){
				Object obj=invokeMethodByBaseBeanField(fieldName, t);
				String fieldKey = null;
				if(obj!=null){
					fieldKey=obj.toString();
				}
				if(map.get(fieldKey)==null){
					pack=new ArrayList<T>();
					map.put(fieldKey, pack);
				}else {
					pack=map.get(fieldKey);
				}
				pack.add(t);
			}
		}
		return map;

	}
	public static<T> Map<String, Map<String,T>> listObjToMapObjPack(
			List<T> list, String fieldName,String packFieldName) {
		Map<String, Map<String,T>> map=new HashMap<String, Map<String,T>>();
		Map<String, T> pack = null;
		if(list.size()>0){
			for(T t:list){
				Object obj=invokeMethodByBaseBeanField(fieldName, t);
				String fieldValue=null;
				if(obj!=null){
					fieldValue=obj.toString();
				}
				Object obj2=invokeMethodByBaseBeanField(packFieldName, t);
				String packfieldValue=null;
				if(obj!=null){
					packfieldValue=obj2.toString();
				}
				if(map.get(fieldValue)==null){
					pack=new HashMap<String, T>();
					map.put(fieldValue, pack);
				}else {
					pack=map.get(fieldValue);
				}
				pack.put(packfieldValue, t);
			}
		}
		return map;
	}



	public static Object convertMapToBean(Map<String, Object> map,
			Class<?> class1) {
		Object obj = null;
		try {
			obj = class1.getConstructor().newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
		Field[] fields = class1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			Object value = map.get(field.getName());
			field.setAccessible(true);
			try {
				field.set(class1, value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static Object convertObjectToObject(Object object, Class<?> class1) {
		Object object2 = null;
		try {
			object2 = class1.getConstructor().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			try {
				Field field2 = class1.getDeclaredField(field.getName());
				if (field2 != null) {
					field2.setAccessible(true);
					try {
						field2.set(object2, field.get(object));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		return object2;
	}

	/**
	 * 获取类属性 包括父类的
	 * @param cla
	 * @param attName
	 * @return
	 */
	public static Field getClassField(Class<? extends Object> cla, String attName){
		Field field = null;
		do {
			try {
				field = cla.getDeclaredField(attName);
			} catch (Exception e) {
			}
		} while (field == null && ((cla = cla.getSuperclass()) != null));
		return field;
	}
	
	/**
	 * List<Map<String,Object>>转换为Map<String,Map<String,Object>>转换方法
	 * @param list
	 * @param keyName
	 * @return
	 */
	public static Map<String, Map<String, Object>> listMapObjecttoMap(List<Map<String, Object>> list,
			String keyName) {
		Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
		for(Map<String,Object> obj : list){
			Object val = obj.get(keyName);
			if ( val!= null ) {
				map.put(val.toString(), obj);
			}
		}
		return map;
	}
	
	/**
	 * List<Map<String,Object>>转换为Map<String,Map<String,Object>>转换方法
	 * @param list
	 * @param keyName
	 * @return
	 */
	public static Map<String, List<Map<String, Object>>> listMapObjecttoMapList(List<Map<String, Object>> list,
			String keyName) {
		Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
		for(Map<String,Object> obj : list){
			Object val = obj.get(keyName);
			if ( val!= null ) {
				List<Map<String, Object>> returnList = map.get(val.toString());
				if (returnList == null) {
					List<Map<String,Object>> dataList = new ArrayList<>();
					dataList.add(obj);
					map.put(val.toString(), dataList);
				} else {
					returnList.add(obj);
				}
			}
		}
		return map;
	}
	
	/**
	 * List<Map<String,Object>>转换为Map<String,Map<String,Object>>转换方法
	 * @param list
	 * @param keyName
	 * @return
	 */
	public static Map<String, Map<String, Object>> listMapObjecttoMap(List<Map<String, Object>> list,
			String[] keyNames) {
		Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
		for(Map<String,Object> obj : list){
			StringBuilder sbBuilder = new StringBuilder();
			int index = 0;
			for(String keyName:keyNames){
				Object val = obj.get(keyName);
				if ( val!= null ) {
					if (index == 0) {
						sbBuilder.append(val);
					} else {
						sbBuilder.append("#").append(val);
					}
				} else {
					if (index == 0) {
						sbBuilder.append("");
					} else {
						sbBuilder.append("#").append("");
					}
				}
				index++;
			}
			map.put(sbBuilder.toString(), obj);
		}
		return map;
	}
	
	/**
	 * 从List<Map<String,Object>>里面获取某一个key的val的组合
	 * @param list
	 * @param keyName
	 * @return
	 */
	public static List<String> buildQueryKeysOffMapObject(List<Map<String, Object>> list, String[] keyNames) {
		List<String> keyValList = new ArrayList<String>(list.size());
		for(Map<String,Object> obj : list){
			StringBuilder sbBuilder = new StringBuilder();
			int index = 0;
			for(String keyName:keyNames){
				Object val = obj.get(keyName);
				if ( val!= null ) {
					if (index == 0) {
						sbBuilder.append(val);
					} else {
						sbBuilder.append("#").append(val);
					}
				} else {
					if (index == 0) {
						sbBuilder.append("");
					} else {
						sbBuilder.append("#").append("");
					}
				}
				index++;
			}
			keyValList.add(sbBuilder.toString());
		}
		return keyValList;
	}
	
	/**
	 * 从List<Map<String,Object>>里面获取某一个key的val的组合
	 * @param list
	 * @param keyName
	 * @return
	 */
	public static List<String> buildQueryKeysOffMapObject(List<Map<String, Object>> list, String keyName) {
		List<String> keyValList = new ArrayList<String>(list.size());
		for(Map<String,Object> obj : list){
			Object val = obj.get(keyName);
			if ( val!= null ) {
				keyValList.add(val.toString());
			}
		}
		return keyValList;
	}
	
	/**
	 * 将字段拷贝到对象上去
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @param bean
	 * @param properties
	 */
	public static <T> T populate(Object bean, Class<T> clazz) {

		return JSON.parseObject(JSON.toJSONString(bean), clazz);
	}

	public static Map<String, Object> object2Map(Object object){
		JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
		Set<Map.Entry<String,Object>> entrySet = jsonObject.entrySet();
		Map<String, Object> map=new HashMap<String,Object>();
		for (Map.Entry<String, Object> entry : entrySet) {
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}
	
	/**
	 * 两个不同对象的值赋值，主要用于售转租，租转售的PO相互设置值
	 * @param fromSrc 来源
	 * @param srcCaseTypeStr 来源的替换类型
	 * @param toAim 赋值的目标
	 * @param aimCaseTypeStr 目标的替换类型
	 * @author 陈文超
	 * @throws Exception
	 */
	public static void diffTwoPoValueCopy(BaseBean fromSrc,String srcCaseTypeStr,BaseBean toAim,String aimCaseTypeStr) throws Exception{
		Class<?> clazzSrc = fromSrc.getClass();
		Class<?> clazzAim = toAim.getClass();
		BeanInfo beanInfoSrc = Introspector.getBeanInfo(clazzSrc);
		PropertyDescriptor [] propertyDescriptorsSrc = beanInfoSrc.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptorsSrc.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptorsSrc[i];
			String propertyName = descriptor.getName();
			Object srcValue = descriptor.getReadMethod().invoke(fromSrc, null);
			String aimPropertyName = propertyName.replaceAll(srcCaseTypeStr, aimCaseTypeStr);
			try{
				Method aimMethod = clazzAim.getMethod("set"+aimPropertyName, new Class[] { Class.forName("java.lang.String") });
				if(!CommonUtil.isnull(aimMethod) && !CommonUtil.isnull(srcValue)){
					aimMethod.invoke(toAim,srcValue);
				}
			}catch(Exception e){
				//没有找到方法直接忽略
			}
		}
	}
	
	/**
	 * 设置对象的整形字段值
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param source
	 * @param name
	 * @return
	 */
	public static void setProperty(Object source, String name, String value) {
		try {
			BeanUtils.setProperty(source, name, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取对象的整形字段值
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param source
	 * @param name
	 * @return
	 */
	public static Integer getProperty(Object source, String name) {
		try {
			return StringUtil.parseInteger(BeanUtils.getProperty(source, name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * title ：单对象转Map
	 * athor：lcb
	 * date  : 2017/11/7
	 */
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
			if(null == value || "".equals(value.toString())) {
				continue;
			}
			map.put(key, value);
		}

		return map;
	}
	
	/**
	 * title ：对象内容复制 author：lcb date : 2017/11/10
	 * 
	 * @throws Exception
	 */
	public static void diffTwoPoValueCopy(Object fromSrc, String srcReplaceedStr, Object toAim, String toObReplaceStr) throws Exception {
		Class<?> clazzSrc = fromSrc.getClass();
		BeanInfo beanInfoSrc = Introspector.getBeanInfo(clazzSrc);
		PropertyDescriptor[] propertyDescriptorsSrc = beanInfoSrc.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptorsSrc.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptorsSrc[i];
			String propertyName = descriptor.getName();
			Object srcValue = BeanUtils.getProperty(fromSrc, propertyName);
			String aimPropertyName = propertyName.replaceAll(srcReplaceedStr, toObReplaceStr);
			try {
				if (StringUtils.isNotBlank(aimPropertyName) && null != srcValue) {
					BeanUtils.setProperty(toAim, aimPropertyName, srcValue);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static <T>List<Map<String, String>> listObjToMapAndunPackBaseBean(List<T> list){
		List<Map<String, String>> mapList=new ArrayList<Map<String, String>>();
		Map<String, String> map;
		for(T obj:list){
			map=new HashMap<String, String>();
			mapList.add(objToMapAndunPackBaseBean(map,obj));
		}
		return mapList;
	}
	
	public static <T> Map<String, String> objToMapAndunPackBaseBean(Map<String, String> map,T obj) {
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				Class<?> propertyType=descriptor.getPropertyType();
				if(propertyType.isArray()){//数组排除
					break;
				}
				if(BaseBean.class.isAssignableFrom(propertyType)){
					Method method=descriptor.getReadMethod();
					Object object=method.invoke(obj);
					if(object!=null){
						objToMapAndunPackBaseBean(map, object);
					}
				}else if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object object=readMethod.invoke(obj,
							new Object[0]);
					if(object!=null){
						String result=object.toString();
						map.put(propertyName, result);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 对象参数拷贝
	 * 复制的对象必须同时拥有setter和getter方法，只有一个的时候会报异常，都没有的时候就不复制
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/4
	 * @return
	 *
	 */
	public static void copyObject(Object source, Object dest) throws Exception {
		//获取属性
		BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), java.lang.Object.class);
		PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();
		
		BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), java.lang.Object.class);
		PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
		
		try {
			for (int i = 0; i < sourceProperty.length; i++) {
				
				for (int j = 0; j < destProperty.length; j++) {
					
					if (sourceProperty[i].getName().equals(destProperty[j].getName())) {
						//调用source的getter方法和dest的setter方法
						destProperty[j].getWriteMethod().invoke(dest, sourceProperty[i].getReadMethod().invoke(source));
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("属性复制失败:" + e.getMessage());
		}
	}

	public static  String[] buildQueryKeysOffDataObject(List<Map<String,Object>> tempList,String fieldName) {
		Set<String> list=new HashSet<String>();
		for(Map<String,Object> t: tempList){
			Object obj=t.get(fieldName);
			String value=null;
			if(obj!=null){
				value=obj.toString();
			}
			list.add(value);
		}
		return  list.toArray(new String[list.size()]);
	}

	/**
	 * 获取为null的属性名
	 * @param obj target object
	 * @return arr
	 */
	public static String[] getNullPropertyNames(Object obj) {
		if (Objects.isNull(obj)) {
			return new String[0];
		}
		BeanWrapperImpl beanWrapper = new BeanWrapperImpl(obj);
		PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
		HashSet<String> names = new HashSet<>();
		for (PropertyDescriptor pd : pds) {
			Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
			if (Objects.isNull(propertyValue)) {
				names.add(pd.getName());
			}
		}
		return names.toArray(new String[0]);
	}

	/**
	 * 获取非null属性名
	 * @param obj target object
	 * @return arr
	 */
	public static String[] getNonNullPropertyNames(Object obj) {
		if (Objects.isNull(obj)) {
			return new String[0];
		}
		BeanWrapperImpl beanWrapper = new BeanWrapperImpl(obj);
		PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
		HashSet<String> names = new HashSet<>();
		for (PropertyDescriptor pd : pds) {
			Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
			if (Objects.nonNull(propertyValue)) {
				names.add(pd.getName());
			}
		}
		return names.toArray(new String[0]);
	}

	public static void main(String[] args) {
		try {
			/*ErpFunSale erpFunSale = new ErpFunSale();
			erpFunSale.setActionTime(new Date());
			ErpFunLease erpFunLease = new ErpFunLease();
			erpFunLease.setLeaseId(111);
			erpFunLease.setLeaseConsign(12);
			erpFunLease.setBuildId(12);
			diffTwoPoValueCopy(erpFunLease, "lease", erpFunSale, "sale");
			System.out.println(erpFunSale.getSaleId() + "yy");
			System.out.println(erpFunSale.getBuildId() + "buildId");
			System.out.println(erpFunSale.getSaleConsign() + "xxx");*/
			System.out.println(camelToUnderline("a.dealId,b.dealId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将类型为Map<String, Object>转换为单对象
	 * @auther 程二狗
	 * @since 2019/1/9
	 * @param paramMap
	 * @param cls
	 * @return
	 */
	public static <T> T parseMap2Object(Map<String, Object> paramMap, Class<T> cls) {
		return JSONObject.parseObject(JSONObject.toJSONString(paramMap), cls);
	}
}

