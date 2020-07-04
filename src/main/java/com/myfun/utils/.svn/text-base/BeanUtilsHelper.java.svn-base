package com.myfun.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
/**
 * javabean帮助类
 * 
 * @ClassName: BeanUtilsHelper
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午10:47:38
 *
 */
public class BeanUtilsHelper extends BeanUtils {
	static {
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
		ConvertUtils.register(new DateConvert(), java.sql.Date.class);
	}

	/**
	 * @see BeanUtilsHelper#bean2Map(Object, Map)
	 * @param object
	 * @return
	 */
	public static Map<String, Object> bean2Map(Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		bean2Map(object, map);
		return map;
	}

	/**
	 * 将bean转换正map
	 * 
	 * @param object
	 *            需要转化的bean
	 * @param map
	 */
	public static void bean2Map(Object object, Map<String, Object> map) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!"class".equals(key)) {
					Method getter = property.getReadMethod();
					Object value = getter.invoke(object);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
		}
	}

	public static void setProperty(Object bean, String name, Object value) {
		try {
			BeanUtilsBean.getInstance().setProperty(bean, name, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将map转化成字符串用separator分割
	 * 
	 * @param map
	 * @param separator
	 *            默认&
	 */
	public static String map2Str(Map<String, Object> map, String... separator) {
		if (map == null || map.isEmpty()) {
			return "";
		}
		String sep = "&";
		if (separator.length != 0) {
			sep = separator[0];
		}

		StringBuilder sb = new StringBuilder();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Object value = map.get(key);
			sb.append(key).append("=").append(value).append(sep);
		}

		return sb.toString().replaceAll(sep + "$", "");
	}

	/**
	 * 从list中取出所需字段构造成数组
	 * @throws Exception 
	 */
	public static <T> String[] buildQueryKeys(List<T> tempList,String fieldName) throws Exception {
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

	private static <T> Object invokeMethodByBaseBeanField(String fieldName, T t) {
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, t.getClass());
			Method method = pd.getReadMethod();
			return method.invoke(t);
		} catch (Exception e) {
			return null;
		}
	}

	public static  <T> T convertClass(Object obj,Class<T> cla) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {  
        Map<String,Object> maps = new HashMap<String,Object>();  
        T  dataBean = null;  
        if(null==obj) {  
            return null;  
        }  
        Class<?> cls = obj.getClass();  
        dataBean = cla.newInstance();  
        Field[] fields = cls.getDeclaredFields();  
        Field[] beanFields = cla.getDeclaredFields();  
        for(Field field:fields){  
            String fieldName = field.getName();  
            String strGet = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());  
            Method methodGet = cls.getDeclaredMethod(strGet);  
            Object object = methodGet.invoke(obj);  
            maps.put(fieldName,object==null?"":object);  
        }  
  
        for(Field field:beanFields){  
            field.setAccessible(true);  
            String fieldName = field.getName();  
            Class<?> fieldType = field.getType();  
            String fieldValue = maps.get(fieldName)==null?null:maps.get(fieldName).toString();  
            if(fieldValue!=null){  
                try {  
                    if(String.class.equals(fieldType)){  
                        field.set(dataBean, fieldValue);  
                    }else if(byte.class.equals(fieldType)){  
                        field.setByte(dataBean, Byte.parseByte(fieldValue));  
  
                    }else if(Byte.class.equals(fieldType)){  
                        field.set(dataBean, Byte.valueOf(fieldValue));  
  
                    }else if(boolean.class.equals(fieldType)){  
                        field.setBoolean(dataBean, Boolean.parseBoolean(fieldValue));  
  
                    }else if(Boolean.class.equals(fieldType)){  
                        field.set(dataBean, Boolean.valueOf(fieldValue));  
  
                    }else if(short.class.equals(fieldType)){  
                        field.setShort(dataBean, Short.parseShort(fieldValue));  
  
                    }else if(Short.class.equals(fieldType)){  
                        field.set(dataBean, Short.valueOf(fieldValue));  
  
                    }else if(int.class.equals(fieldType)){  
                        field.setInt(dataBean, Integer.parseInt(fieldValue));  
  
                    }else if(Integer.class.equals(fieldType)){  
                        field.set(dataBean, Integer.valueOf(fieldValue));  
  
                    }else if(long.class.equals(fieldType)){  
                        field.setLong(dataBean, Long.parseLong(fieldValue));  
  
                    }else if(Long.class.equals(fieldType)){  
                        field.set(dataBean, Long.valueOf(fieldValue));  
  
                    }else if(float.class.equals(fieldType)){  
                        field.setFloat(dataBean, Float.parseFloat(fieldValue));  
  
                    }else if(Float.class.equals(fieldType)){  
                        field.set(dataBean, Float.valueOf(fieldValue));  
  
                    }else if(double.class.equals(fieldType)){  
                        field.setDouble(dataBean, Double.parseDouble(fieldValue));  
  
                    }else if(Double.class.equals(fieldType)){  
                        field.set(dataBean, Double.valueOf(fieldValue));  
  
                    }else if(Date.class.equals(fieldType)){  
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");  
                        field.set(dataBean, sdf.parse(fieldValue));  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                } 
  
            }  
        }  
        return dataBean;  
  
    }  
	
	
	public static<T> Map<String, List<T>> listObjToMapObjPackForList(List<T> list, String fieldName) throws Exception{
		Map<String, List<T>> map=new HashMap<String, List<T>>();
		List<T> pack=null;
		if(list.size()>0){
			for(T t:list){
				Object obj=invokeMethodByBaseBeanField(fieldName, t);
				String fieldValue=null;
				if(obj!=null){
					fieldValue=obj.toString();
				}
				if(map.get(fieldValue)==null){
					pack=new ArrayList<T>();
					map.put(fieldValue, pack);
				}else {
					pack=map.get(fieldValue);
				}
				pack.add(t);
			}
		}
		return map;

	}

	public static<T> Map<String, T> listToMapObject(
			List<T> list, String fieldName) throws Exception {
		Map<String, T> map = new HashMap<String, T>();
		if (list.size() > 0) {
			for (T t : list) {
				Object obj = invokeMethodByBaseBeanField(fieldName, t);
				String fieldValue = null;
				if (obj != null) {
					fieldValue = obj.toString();
				}
				if (map.get(fieldValue) == null) {
					map.put(fieldValue, t);
				}
			}
		}
		return map;
	}
	public static Map<String,Object> listMapToMapObject(
			List<Map<String,Object>> list, String fieldName) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		if (list.size() > 0) {
			for (Map<String,Object> t : list) {
				Object obj = map.get(fieldName);
				String fieldValue = null;
				if (obj != null) {
					fieldValue = obj.toString();
					map.put(fieldValue, t);
				}
			}
		}
		return map;
	}
	public static Map<String,Object> listMapToKeyMapObject(List<Map<String,Object>> list, String fieldName) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		if (list.size() > 0) {
			for (Map<String,Object> t : list) {
				Object obj = t.get(fieldName);
				if (obj != null) {
					map.put(obj.toString(),t);
				}
			}
		}
		return map;
	}
	
	/**
	 * 将list转为map时，fieldName 存真实类型不转换为String类型
	 * @param list
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static<T> Map<Object, T> listToMapObjectOffKeyType(List<T> list, String fieldName) {
		Map<Object, T> map = new HashMap<Object, T>();
		if (list.size() > 0) {
			for (T t : list) {
				Object obj = invokeMethodByBaseBeanField(fieldName, t);
				if (obj != null) {
					map.put(obj, t);
				}
			}
		}
		return map;
	}

	public static Set<Integer> buildQueryKeysOffListMap(List<Map<String, Object>> deptCycleRankList, String fieldName) {
		Set<Integer> keyIds = new HashSet<>();
		for(Map<String, Object> dataMap:deptCycleRankList){
			Integer keyId = StringUtil.parseInteger(String.valueOf(dataMap.get(fieldName)), 0);
			if (keyId >= 0) {
				keyIds.add(keyId);
			}
		}
		// 可以尝试简化成下面这句话
		// Set<Object> collect = deptCycleRankList.stream().collect(Collectors.mapping(map -> map.get(fieldName), Collectors.toSet()));
		return keyIds;
	}
	
	/**
	 * 转换成KEY 对应的 LIST
	 * @author 陈文超
	 * @date 2016年6月20日 下午8:33:04
	 */
	public static <T> Map<String,List<T>> beanToPackListKeyMap(List<T> beans, String keyId) throws Exception{
		Map<String,List<T>> map = new HashMap<String,List<T>>();
		for(T tmp : beans){
			//来源对象
			Class srcClass = tmp.getClass();
			List<Class> classList = new ArrayList<Class>();
			boolean isExit = false;
			while(!isExit){
				srcClass =  srcClass.getSuperclass();
				srcClass.getName();

				if(srcClass.getName().lastIndexOf("ShardDb") != -1 || srcClass.getName().lastIndexOf("Object") != -1){
					isExit = true;
				}else{
					classList.add(srcClass);
				}
			}
			classList.add(tmp.getClass());

			for(Class clazz : classList) {
				try {
					Field field = clazz.getDeclaredField(keyId);
					field.setAccessible(true);
					String key = String.valueOf(field.get(tmp));
					List<T> list = null;
					if (map.containsKey(key)) {
						map.get(key).add(tmp);
					} else {
						list = new ArrayList<T>();
						list.add(tmp);
						map.put(key, list);
					}
					break;
				} catch (Exception ignored) {}
			}
		}
		return map;
	}
	
	/**
	 * 转换成复合KEY 对应的 LIST
	 * @author 陈文超
	 * @date 2016年6月20日 下午8:33:04
	 */
	public static <T> Map<String,List<T>> beanToPackListRecombinaisonKeyMap(List<T> beans, String [] keyIds, String separatorStr) throws Exception{
		Map<String,List<T>> map = new HashMap<String,List<T>>();
		for(T tmp : beans){
			StringBuilder key = new StringBuilder();
			for(String keyId : keyIds){
				Field field = tmp.getClass().getDeclaredField(keyId);
				field.setAccessible(true);
				key.append(separatorStr).append(String.valueOf(field.get(tmp)));
			}
			String tmpKey = key.toString().replaceFirst(separatorStr, "");
			List<T> list = null;
			if(map.containsKey(tmpKey)){
				map.get(tmpKey).add(tmp);
			}else{
				list = new ArrayList<T>();
				list.add(tmp);
				map.put(tmpKey, list);
			}
		}
		return map;
	}
}
