package com.myfun.service.business.taskJob;

import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.myfun.framework.config.AppConfig;
import com.myfun.utils.HttpUtil;

/**
 * 用户相关的任务
 * 
 * @author 张宏利
 * @since 2018年7月27日
 */
@Component
public class HttpRequestTask {

	@Async
	public void postToMobileWeb(String url, Map<String, Object> userInfo) {
		try {
			HttpUtil.post(AppConfig.getHftMoblieUrl() + url, userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Async
	public void postToTaskWeb(String url, Map<String, Object> userInfo) {
		try {
			HttpUtil.post(AppConfig.getHftMoblieUrl() + url, userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
