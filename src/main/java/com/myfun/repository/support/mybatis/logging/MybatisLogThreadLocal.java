package com.myfun.repository.support.mybatis.logging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 记录mybatis日志
 * 
 * @ClassName: MybatisLogThreadLocal
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年5月6日 下午8:31:30
 *
 */
public class MybatisLogThreadLocal {
	private static ThreadLocal<List<Object>> LOG_RECORD_THREADLOCAL = new ThreadLocal<List<Object>>();
	private static HashMap<Integer, List<String>> logMap = new HashMap<Integer, List<String>>();
	//private static ThreadLocal<String> LOG_SQL_STACK = new ThreadLocal<String>();
	
	public static List<Object> getLogRecord() {
		return LOG_RECORD_THREADLOCAL.get();
	}

	public static void setLogRecord(Object[] obj) {
		if (obj == null) {
			return;
		}
		for (Object o : obj) {
			setLogRecord(o);
		}
	}

	
	public static void setLogRecord(Object obj) {
		List<Object> objects = getLogRecord();
		if (objects == null) {
			objects = new ArrayList<Object>();
			LOG_RECORD_THREADLOCAL.set(objects);
		}
		objects.add(obj);
	}

	public static String getLogRecordByStr() {
		List<Object> objects = getLogRecord();
		if (objects != null) {
			StringBuilder sb = new StringBuilder();
			for (Object o : objects) {
				sb.append(o.toString()).append("\n");
			}
			return sb.toString();
		}
		return null;
	}
	
	/*public static void pushLogStack(String str){
		LOG_SQL_STACK.set(LOG_SQL_STACK.get()+"\n" + str);
	}
	
	public static String getStackLogRecordByStr() {
		StringBuilder sb = new StringBuilder();
		while(!LOG_SQL_STACK.isEmpty()){
			sb.append(LOG_SQL_STACK.pop());
		}
		sb.append(LOG_SQL_STACK.get());
		return sb.toString();
	}*/

	public static void printLogRecord() {
		String logStr = getLogRecordByStr();
		if (logStr != null) {
			System.out.println(logStr);
		}
	}
	
	/**
	 * 给日志文件设置用户的Sql
	 * @param userId
	 * @param method
	 * @param str
	 */
	public static void setLogMap(Integer userId, String  method, String str){
		List<String> list = logMap.get(userId);
		if(str != null && !"".equals(str)){
			if(list != null && list.size() > 0){
				list.add(method + "#method#" + str);
			}else{
				list = new ArrayList<String>();
				list.add(method + "#method#" + str);
			}
			logMap.put(userId, list);
		}
	}
	
	/**
	 * 返回指定用户的log文件信息
	 * @param userId
	 * @return
	 */
	public static List<String> getLogMapByUserId(Integer userId){
		List<String> list = logMap.get(userId);
		if(list == null){
			return null;
		}
		return list;
	}
	
	/**
	 * 情况日志map
	 * @param userId
	 */
	public static void cleatLogMap(Integer userId){
		if(userId == null){
			logMap = new HashMap<Integer, List<String>>();
		}else{
			logMap.remove(userId);
		}
		
	}
	
	public static void clear() {
		LOG_RECORD_THREADLOCAL.set(null);
	}
}
