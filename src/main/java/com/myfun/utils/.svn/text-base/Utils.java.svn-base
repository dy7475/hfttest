package com.myfun.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
 * @ClassName: Utils
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年1月9日 下午3:45:03
 *
 */
public class Utils {
	public static String getStackTrace(Throwable ex) {
		StringWriter buf = new StringWriter();
		ex.printStackTrace(new PrintWriter(buf));

		return buf.toString();
	}

	public static String toString(StackTraceElement[] stackTrace) {
		StringBuilder buf = new StringBuilder();
		for (StackTraceElement item : stackTrace) {
			buf.append(item.toString());
			buf.append("\n");
		}
		return buf.toString();
	}

	public static String getCurrentMethodCallChain() {
		return getStackTrace(new Throwable());
	}
}
