package com.myfun.framework.session;

import java.util.Map;

/**
 * 用户回话信息
 * 
 * @ClassName: Session
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午4:30:23
 *
 */
public class Session {
	/** 存储用户会话信息在本地线程 (注意:当请求结束注意清空) **/
	private static final ThreadLocal<Map<String, Object>> SESSION_HOLDER = new ThreadLocal<Map<String, Object>>();

	public static Map<String, Object> getSessionMap() {
		return SESSION_HOLDER.get();
	}

	public static void setSessionMap(Map<String, Object> sessionMap) {
		SESSION_HOLDER.set(sessionMap);
	}

	public static void clear() {
		SESSION_HOLDER.set(null);
	}
}
