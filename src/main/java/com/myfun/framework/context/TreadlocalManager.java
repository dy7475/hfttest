package com.myfun.framework.context;

import java.util.Map;

public class TreadlocalManager {
	/** 存储用户会话信息在本地线程 (注意:当请求结束注意清空) **/
	private static final ThreadLocal<Map<String, Object>> SESSION_HOLDER = new ThreadLocal<Map<String, Object>>();

	public static ThreadLocal<Map<String, Object>> getSessionHolder() {
		return SESSION_HOLDER;
	}

	public static void clear() {
		SESSION_HOLDER.set(null);
	}

}
