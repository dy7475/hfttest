package com.myfun.framework.web.controller;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.ThreadLocalHelper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.StringUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装控制器公用方法
 * 
 * @ClassName: BaseController
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午5:00:19
 *
 */
public abstract class BaseController {
	/**
	 * 组装错误信息
	 * 
	 * @param errors
	 * @return
	 */
	public static Map<String, Object> errorsToMap(Errors errors) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (errors != null && errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}
		return map;
	}
	
	/**
	 * 获取参数Map
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @param request
	 * @return
	 */
	public Map<String, String> getParameterMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		for (Object key : request.getParameterMap().keySet()) {
			String[] object = request.getParameterMap().get(key);
			if (object != null) {
				paramMap.put(key.toString(), object[0]);
			}
		}
		return paramMap;
	}

	/**
	 * 依据参数获取对象，只适用于参数是@RequestBody的情况
	 * @author 张宏利
	 * @since 2018年5月2日
	 * @param clazz 目标对象
	 * @return
	 */
	public static <T> T getParamObj(Class<T> clazz) {
		return JSON.parseObject(ThreadLocalHelper.getACTION_URL_LOCAL().getParams(), clazz);
	}
	
	/**
	 * 组装错误信息
	 * 
	 * @param errors
	 * @return
	 */
	public static String errorsToString(Errors errors) {
		StringBuilder builder = new StringBuilder();
		if (errors != null && errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
			for (int i = 0; i < fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				builder.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(",");
			}
		}
		return builder.toString().replace(",$", "");
	}

	/**
	 * 获得客户端访问的IP地址
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getClientIpAddr(HttpServletRequest request) {
		if (request == null) {
			return "";
		}
		String ipString = request.getHeader("x-forwarded-for");
		if (StringUtil.isEmpty(ipString) || "unknown".equalsIgnoreCase(ipString)) {
			ipString = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtil.isEmpty(ipString) || "unknown".equalsIgnoreCase(ipString)) {
			ipString = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtil.isEmpty(ipString) || "unknown".equalsIgnoreCase(ipString)) {
			ipString = request.getRemoteAddr();
		}
		final String[] arr = ipString.split(",");
		for (final String str : arr) {
			if (!"unknown".equalsIgnoreCase(str)) {
				ipString = str;
				break;
			}
		}
		return ipString;
	}

	/**
	 * 获得服务器的IP地址
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getServerIpAddr(HttpServletRequest request) {
		if (request == null) {
			return "";
		}
		return request.getRemoteAddr();
	}

	/**
	 * 获取访问域名
	 * 
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String domain = url.toString().replace(uri, "");
		return domain;
	}

	public static String generateXmlReturn(int code, String msg) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><result><response>").append(code)
				.append("</response><msg>").append(msg).append("</msg></result>");
		return sb.toString();
	}

	/**
	 * 获取请求参数
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestParamToString(HttpServletRequest request) {
		Enumeration<String> enumeration = request.getParameterNames();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			Object value = request.getParameter(key);
			sb.append(key).append(":").append(value).append(",");
		}
		if (sb.length() > 1) {
			sb.replace(sb.length() - 1, sb.length(), "");
		}
		sb.append("}");
		return sb.toString();
	}
	
	public Operator getOperator(){
		return ThreadLocalHelper.getOperator();
	}
	
	public String getCurrentUserName(){
		String currUname = getOperator().getUserName();
		String currDeptName = "";
		//不是纯精英版也不是专业版  才写门店名称
		if(!Const.DIC_COMP_TYPE_2.equals(getOperator().getCompType()) && !getOperator().isPersonalVersion()){
//		if(Constants_DIC.DIC_IS_HONGJI_COMP_MODEL.equals(getOperator().getHongJICompModel())){
			currDeptName = getOperator().getOrganizationName();
			currUname = currDeptName + " " + currUname;
		}
		return currUname;
	}

	public static void main(String[] args) {
		String s = "{\"CLIENTKEY\":\"b947de3d8a8909425f79a5dabe97c654\",\"areaId\":\"12001\",\"baseMoney\":\"\",\"compId\":\"12001\",\"compNo\":\"AA01\",\"deptId\":\"903457\",\"flag\":\"NOTEXIST\",\"grId\":\"\",\"isRegister\":\"0\",\"levelsId\":\"\",\"loginPassword\":\"lcb123\",\"oldUserPosition\":\"\",\"oldUserStatus\":\"\",\"personnelLevels\":\"\",\"regId\":\"45449\",\"reson\":\"NOTEXIST\",\"roleName\":\"经纪人\",\"serviceReg\":\"1\",\"serviceZone\":\"川音\",\"serviceZoneIds\":\"35633\",\"userId\":\"\",\"userMobile\":\"18521211654\",\"userName\":\"李成兵3\",\"userPosition\":\"279869c88a984ae8b4acabeaac047baa\",\"userSex\":\"1\",\"userStatus\":\"1\"}";
		ErpFunUsers erpFunUsers = JSON.parseObject(s, ErpFunUsers.class);
		System.out.println(erpFunUsers.getCompId());
	}

}
