package com.myfun.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达工具类
 * @author 陈文超
 * @date 2016年7月16日 下午4:06:01
 */
public class RegExUtils {
	
	/**
	 * 分组抓取一组字符串
	 * 意思：从字符串第一个字符开始搜索到第一个数字出现时，前面的所有匹配字符
	 * reg：([^\d]+), text:AAAA123BBBB2321CCCC12312 = AAAA
	 * 
	 * 如果没有匹配到则返回null
	 * @author 陈文超
	 * @date 2016年7月16日 下午4:07:01
	 */
	public static String getMatchText(String reg, String page) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(page);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	/**
     * 分组抓取匹配字符串的集合
     * 意思：从字符串第一个字符开始搜索到第一个数字出现时，前面的所有匹配字符
     * reg：([^\d]+), text:AAAA123BBBB2321CCCC12312 = AAAA,BBBB,CCCC
     * 
     * 如果没有匹配到则返回null
     * @author 陈文超
     * @date 2016年7月16日 下午4:07:01
     */
	public static List<String> getMatchAllTexts(String reg, String page) {
		List<String> list = new ArrayList<String>();
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(page);
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}
	
	
	public static List<String[]> getMatchTexts(String reg, String page, int count) {
		List<String[]> list = new ArrayList<String[]>(5);
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(page);
		while (matcher.find()) {
			String[] pos = new String[count];
			for (int index = 1; index <= count; index++) {
				pos[index - 1] = matcher.group(index);
			}
			list.add(pos);
		}
		return list;
	}
	
	/**
	 * 判断字符串中是否有匹配的结果
	 * @author 陈文超
	 * @date 2016年7月16日 下午4:06:33
	 */
	public static boolean isMatch(String reg, String page) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(page);
		return matcher.find();
	}
}
