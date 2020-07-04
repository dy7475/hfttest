<%@page language="java" contentType="text/html; charset=utf-8"  isErrorPage="true" %>
<%@page import="org.fto.jthink.exception.*"%>
<%
	String siteRoot = request.getContextPath();
	String message = exception.getMessage();
	if(exception instanceof JThinkException){
		JThinkException e1 = (JThinkException)exception;
		if(e1.getCode() != 0){
			message = "系统错误，请重新登录或联系在线客服！";
		}
	}else if(exception instanceof JThinkRuntimeException){
		JThinkRuntimeException e2 = (JThinkRuntimeException)exception;
//		if(e2.getMessage().indexOf("违反了 PRIMARY KEY 约束") != -1){
		if(e2.getMessage().indexOf("Violation of PRIMARY KEY constraint") != -1
			|| e2.getMessage().indexOf("违反了 PRIMARY KEY 约束") != -1){
			message = "网络忙，请重新点击保存！";
		}else if(e2.getCode() != 0){
			message = "系统错误，请重新登录或联系在线客服！";
		}
	}else{
		message = "系统错误，请重新登录或联系在线客服！";
	}
	response.setStatus(500);
	exception.printStackTrace();
	request.setAttribute("IS_ERROR_PAGE", "YES");
	out.print(message.trim());
%>
