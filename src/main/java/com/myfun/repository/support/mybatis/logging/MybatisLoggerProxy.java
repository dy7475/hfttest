package com.myfun.repository.support.mybatis.logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * mybatis日志扩展
 * 
 * @ClassName: MybatisLoggerProxy
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年5月6日 下午4:49:28
 *
 */
public class MybatisLoggerProxy implements InvocationHandler {
	private static Set<String> METHOD = new HashSet<String>();
	private Log log;

	static {
		METHOD.add("error");
		METHOD.add("debug");
		METHOD.add("trace");
		METHOD.add("warn");
	}

	private MybatisLoggerProxy(Log log) {
		this.log = log;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (METHOD.contains(method.getName())) {
			MybatisLogThreadLocal.setLogRecord(args);
		}
		return method.invoke(log, args);
	}

	public static Log newInstance(Log log) {

		InvocationHandler handler = new MybatisLoggerProxy(log);
		ClassLoader cl = Log.class.getClassLoader();
		return (Log) Proxy.newProxyInstance(cl, new Class[] { Log.class }, handler);
	}
 
	public Log getLog() {
		return log;
	}

	public static void main(String[] args) {
		Log log = LogFactory.getLog("sdfdsafds");
		Exception ee = new Exception("错误");

		log.error("11", ee);
	}

}
