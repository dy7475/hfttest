package com.myfun.erpWeb.openApi.suport;

import java.util.HashMap;
import java.util.Map;

/**
 * 开放接口配置
 * 
 * @author jsg
 *
 */
public class OpenApiConfig {
	/** 商家配置 **/
	public static final Map<String, ThirdUserData> THIRD_USER_DATA = new HashMap<String, ThirdUserData>();

	static {
		// 初始化商家信息 G1AT9S=优客 
		THIRD_USER_DATA.put("G1AT9S", new ThirdUserData("G1AT9S", "968431345921"));
		// JA9H81=水滴 
		THIRD_USER_DATA.put("JA9H81", new ThirdUserData("JA9H81", "194161328543"));
		// LZ8KU1=爱上租品牌公寓 
		THIRD_USER_DATA.put("LZ8KU1", new ThirdUserData("LZ8KU1", "529815134514"));
		// LZ8KU2=爱上租服务公寓 
		THIRD_USER_DATA.put("LZ8KU2", new ThirdUserData("LZ8KU2", "183485351867"));
		// NSI2YQ=嗨住 
		THIRD_USER_DATA.put("NSI2YQ", new ThirdUserData("NSI2YQ", "404731947912"));
		// C7FG2X=美丽屋
		THIRD_USER_DATA.put("C7FG2U", new ThirdUserData("C7FG2U", "159614363859"));
	}

	/**
	 * 用户信息
	 * 
	 * @author jsg
	 *
	 */
	public static class ThirdUserData {
		/** 用户名 **/
		private String appId;
		/** 密码 **/
		private String appSecret;
		/** 单台访问频率设置 **/
		private int accessLimit = 50;
		/** 当前访问次数 **/
		public volatile int currentAccessCount = 0;

		public ThirdUserData() {
		}

		public ThirdUserData(String appId, String appSecret) {
			super();
			this.appId = appId;
			this.appSecret = appSecret;
		}

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getAppSecret() {
			return appSecret;
		}

		public void setAppSecret(String appSecret) {
			this.appSecret = appSecret;
		}

		public int getAccessLimit() {
			return accessLimit;
		}

		public void setAccessLimit(int accessLimit) {
			this.accessLimit = accessLimit;
		}

		public int getCurrentAccessCount() {
			return currentAccessCount;
		}

		public void setCurrentAccessCount(int currentAccessCount) {
			this.currentAccessCount = currentAccessCount;
		}

	}
}
