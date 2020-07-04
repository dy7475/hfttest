package com.myfun.framework.session;

import javax.servlet.http.HttpServletRequest;

public class ThreadLocalHelper {
	
	private final static ThreadLocal<Operator> THREADLOCAL_OPER = new ThreadLocal<Operator>();
	private final static ThreadLocal<HttpServletRequest> HTTP_SERVLET_REQUEST = new ThreadLocal<HttpServletRequest>();
	// 错误信息
	public static ThreadLocal<StringBuilder> ERROR_INFO_LOCAL = new ThreadLocal<StringBuilder>();
	// 访问信息信息
	public static ThreadLocal<ActionUrl> ACTION_URL_LOCAL = new ThreadLocal<ActionUrl>();

	public static ActionUrl getACTION_URL_LOCAL() {
		if(ACTION_URL_LOCAL.get() == null) {
			setACTION_URL_LOCAL(new ActionUrl());
		}
		return ACTION_URL_LOCAL.get();
	}

	public static void setACTION_URL_LOCAL(ActionUrl actionUrl) {
		ACTION_URL_LOCAL.set(actionUrl);
	}

	public static StringBuilder getErrorInfoLocal() {
		if (ERROR_INFO_LOCAL.get() == null) {
			setErrorInfoLocal(new StringBuilder());
		}
		return ERROR_INFO_LOCAL.get();
	}

	public static void setErrorInfoLocal(StringBuilder sb) {
		ERROR_INFO_LOCAL.set(sb);
	}

	public static void addErrorInfoLocal(String errorInfo) {
		getErrorInfoLocal().append(errorInfo).append("\n");
	}
	public static HttpServletRequest getHttpServletRequest() {
		return HTTP_SERVLET_REQUEST.get();
	}
	public static void setHttpServletRequest(HttpServletRequest request) {
		HTTP_SERVLET_REQUEST.set(request);
	}
	
	public static void setOperator(Operator operator){
		THREADLOCAL_OPER.set(operator);
	}
	public static Operator getOperator(){
		return THREADLOCAL_OPER.get();
	}
	
	public static void clear(){
		THREADLOCAL_OPER.set(null);
		HTTP_SERVLET_REQUEST.set(null);
		ERROR_INFO_LOCAL.set(null);
		ACTION_URL_LOCAL.set(null);
	}
}
