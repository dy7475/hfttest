package com.myfun.erpWeb.openApi.manage;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.openApi.manage.aspect.TokenValidate;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.service.business.erpdb.ErpFunMacService;
import com.myfun.utils.HttpUtil;

/**
 * 系统管理-会话控制相关
 * @author 张宏利
 * @since 2017年5月19日
 */
@Controller
@RequestMapping("/openApi/sysManage")
public class SessionController {
	
	/**通用登录密码**/
	private static String PWD = "c47181ab8a0d45d5b4ae24479d6e50a5";

	@Autowired
	ErpFunMacService erpFunMacService;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private CacheUtil cacheUtil;

	/**
	 * 简单的登录机制
	 * @author 张宏利
	 * @since 2017年5月19日
	 * @param pwd
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public ErpResponseJson login(String pwd, HttpServletRequest request) {
		if (PWD.equals(pwd)) {
			String accessToken = request.getRequestedSessionId();
			cacheUtil.put(CacheStructure.MANAGE_USER_ID + accessToken, "1");
			return ErpResponseJson.ok();
		}
		return ErpResponseJson.warn("失败");
	}
	
	/**
	 * 临时修改密码，重新启动后失效
	 * @author 张宏利
	 * @since 2017年5月19日
	 * @param pwd
	 * @param request
	 * @return
	 */
	@ResponseBody
	@TokenValidate
	@RequestMapping("/repwd")
	public ErpResponseJson repwd(String pwd, HttpServletRequest request) {
		if (StringUtils.isBlank(pwd)) {
			return ErpResponseJson.warn("失败");
		}
		PWD = pwd;
		return ErpResponseJson.ok();
	}

	/**
	  * @title  漫游mac到公司
	  * @author lcb  
	  * @date   2018/10/16 19:30
	  * @desc 
	  **/
	@ResponseBody
	@RequestMapping("/addRoamMac")
	public ErpResponseJson addRoamMac(String localMac, String routeMac, String compNo, String deptNo, Integer archiveId ) throws Exception{
		// 调用admin注册mac
		String adminWebUrl = AppConfig.getAdminWebUrl()+"/LicenseRegisterCommon.do";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("compNo", compNo);
		paramMap.put("deptNo", deptNo);
		paramMap.put("diskNo", "00000000");
		paramMap.put("registStep", "2");
		paramMap.put("macAddr", localMac);
		paramMap.put("pcId", "00000000");
		String s = UUID.randomUUID().toString().toUpperCase();
		paramMap.put("pcName", "DESKTOP-"+s.substring(0, 7));
		paramMap.put("routeMac", routeMac);
		paramMap.put("timestamp", Calendar.getInstance().getTimeInMillis());
		String post = HttpUtil.post(adminWebUrl, paramMap);
		JSONObject resJson = JSON.parseObject(post);
		if(null != resJson) {
			String action = resJson.getString("ACTION");
			if("SUCCESS".equals(action)) {
				ErpFunComp compByCompNo = erpFunCompMapper.getCompByCompNo(compNo);
				if(null != compByCompNo) {
					ErpFunUsers usersByArchiveId = erpFunUsersMapper.getUserInfoByArchiveId(compByCompNo.getCityId().intValue(), archiveId);
					// 漫游账号
					erpFunMacService.updateMgrRoamUser(compByCompNo.getCityId().intValue(), 1, compByCompNo.getCompId(), usersByArchiveId.getUserId(), localMac);
				}
			}else {
				return ErpResponseJson.warn(resJson.getString("ERRCODE"));
			}
		}else {
			return ErpResponseJson.warn("请联系技术");
		}
		// 修改mac地址
		return ErpResponseJson.ok();
	}
	
	public static void main(String[] args) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("localMac", "24,9E,AB,9A,3D,55");
		paramMap.put("routeMac", "76,54,32,10,98,76");
		paramMap.put("compNo", "C1799");
		paramMap.put("deptNo", "D1");
		paramMap.put("archiveId", 670087);
		String post = HttpUtil.post("http://192.168.5.175:8080/erpWeb/openApi/sysManage/addRoamMac", paramMap);
		System.out.println(post);
	}
}
