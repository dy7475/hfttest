package com.myfun.framework.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.myfun.framework.web.controller.BaseController;

/**
 * 记录当前请求信息
 * 
 * @author jiangsonggui
 * 
 */
@Component
public class SaveRequestInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveRequestInterceptor.class);

	/**
	 * 把当前请求记录到下来
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
		Map<String, Object> data = AccessInfoHolder.getAccessInfo();
		long startTime = (long) data.get("startTime");
		long totalTime = System.currentTimeMillis() - startTime;// 结束时间
		data.put("time", totalTime);
		data.put("endTime", System.currentTimeMillis());
//		long sqlExecTime = MybatisLogThreadLocal.getSqlExecTime();// sql执行时间
		// 日志记录
		LOGGER.info("总耗时：{}ms  URI：{}",
			totalTime,
			request.getRequestURI()
		);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object haddler, ModelAndView modelAndView) throws Exception {
		
	}

	/**
	 * 记录请求信息
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		Map<String, Object> data = AccessInfoHolder.getAccessInfo();
		data.put("startTime", System.currentTimeMillis());
		data.put("ipAddress", BaseController.getClientIpAddr(request));
		data.put("requestPath", request.getRequestURI());
		data.put("queryString", BaseController.getRequestParamToString(request));
		return true;
	}

}
