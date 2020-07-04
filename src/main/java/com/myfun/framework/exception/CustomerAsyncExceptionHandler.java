package com.myfun.framework.exception;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

/**
 * 项目异步任务异常处理器，记录错误日志写入mongodb
 * 
 * @author 陈文超
 * @date 2018年1月24日 下午2:40:39
 */
public class CustomerAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
		System.out.println("==handleUncaughtException==");
	}
}
