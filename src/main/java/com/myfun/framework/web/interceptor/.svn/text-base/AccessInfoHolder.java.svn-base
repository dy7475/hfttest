package com.myfun.framework.web.interceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 记录访问信息
 * 
 * @ClassName: AccessInfoHolder
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年12月4日 下午4:18:10
 *
 */
public class AccessInfoHolder {
	private static final ThreadLocal<Map<String, Object>> ACCESS_INFO_MAP = new ThreadLocal<Map<String, Object>>();

	public static ThreadLocal<Map<String, Object>> getAccessInfoMap() {
		return ACCESS_INFO_MAP;
	}

	public static void setAccessInfo(Map<String, Object> data) {
		getAccessInfoMap().set(data);
	}

	public static Map<String, Object> getAccessInfo() {
		Map<String, Object> map = getAccessInfoMap().get();
		if (map == null) {
			map = new HashMap<String, Object>();
			setAccessInfo(map);
		}
		return map;
	}
}
