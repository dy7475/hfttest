package com.myfun.utils;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

public class PhoneUtil {
	
	/**
	 * 入参：15856487897 15856478979<br/>
	 * 出参：&&&座机|||6313?3?3?330:3:3=384<:&&&手机|||93;313?3731442=3540145&&&<br/>
	 * @param phoneStr
	 * @return
	 */
	public static String dealPhoneForSpace(String phoneStr){
		if (StringUtils.isBlank(phoneStr)) {
			return "";
		}
		String phone = "&&&";
		String[] phones = StringHelper.split(phoneStr, " ");
		for (int i = 0; i < phones.length; i++) {
			if (StringUtils.isBlank(phones[i])) {
				continue;
			}
			String phoneType = "座机";
			if(phones[i].startsWith("1") && phones[i].length() == 11) {
				phoneType = "手机";
			}
			String newPhone = EnCodeHelper.encode(phones[i]);
			phone += phoneType + "|||" + newPhone + "&&&";
		}
		return phone;
	}

	/**
	 * 同步HouseCustSuperAction.procePhone<br/>
	 * 入参：手机:15856487897 手机:15856478979<br/>
	 * 出参：&&&座机|||6313?3?3?330:3:3=384<:&&&手机|||93;313?3731442=3540145&&&<br/>
	 * @param phoneStr
	 * @return
	 */
	public static String procePhone(String phoneStr){
		if (StringUtils.isBlank(phoneStr)) {
			return "";
		}
		String phone = "&&&";
		String[] phones = StringHelper.split(phoneStr, " ");
		for (int i = 0; i < phones.length; i++) {
			String[] phoneValues = StringHelper.split(phones[i], ":");
			if (phoneValues.length > 1) {
				phoneValues[1] = EnCodeHelper.encode(phoneValues[1]);
				phone += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
			}
		}
		return phone;
	}
	
	/**
	 * 电话解密公用方法<br/>
	 * 入参：手机|||935333=313=7<4=7500645&&&<br/>
	 * 出参：[15751946594]<br/>
	 * @param phoneStr 电话号码
	 * @param encrypt 是否加密成*号
	 * @return
	 */
	public static String[] decodePhoneToArr(String phoneStr, boolean encrypt){
		if (StringUtils.isBlank(phoneStr)) {
			return null;
		}
		String[] phones = StringHelper.split(phoneStr, "&&&");
		try {
			for (int i = 0; i < phones.length; i++) {
				String[] phoneValues = StringHelper.split(phones[i], "|||");
				phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
				if (encrypt) {
					ecodePhoneToArr(phoneValues);
				}
				phones[i] = phoneValues[1];
			}
		} catch (Exception e) {
			return null;
		}
		return phones;
	}
	
	/**
	 * 电话中间加密成*号公用方法<br/>
	 * 入参：手机:15462194685
	 * 出参：手机:154*****685
	 * @param phoneStr 电话号码
	 * @param encrypt 是否加密成*号
	 * @return
	 */
	public static void ecodePhoneToArr(String[] phoneStr){
		int len = phoneStr[1].trim().length();
		if("手机".equals(phoneStr[0])){
			if(phoneStr[1].length()>7){
				phoneStr[1] = phoneStr[1].trim().substring(0, 3) + "****" + phoneStr[1].trim().substring(len-4, len);
			}
		} else if("座机".equals(phoneStr[0])){
			if(phoneStr[1].length()>4){
				phoneStr[1] = phoneStr[1].trim().substring(0, len-4) + "****";
			}
		} else if("小灵通".equals(phoneStr[0])){
			if(phoneStr[1].length()>4){
				phoneStr[1] = phoneStr[1].trim().substring(0, len-4) + "****";
			}
		} else {
			phoneStr[1] = "*****";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(PhoneUtil.dealPhoneForSpace("&&&手机|||>35353?3:;:1819;46064;&&&"));
	}
}
