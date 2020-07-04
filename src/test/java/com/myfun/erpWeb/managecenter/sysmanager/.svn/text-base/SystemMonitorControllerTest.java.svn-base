package com.myfun.erpWeb.managecenter.sysmanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.FunAdsParam;
import org.junit.Before;
import org.junit.Test;
import scala.annotation.meta.param;

import java.util.HashMap;
import java.util.Map;

public class SystemMonitorControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		//init("http://192.168.0.249:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1279612", "14411114444");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "18782923250");// zt门店
		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "a123456", "13350007000");// ios胡门店
//		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "13123213123");// 王六

	}

	/**
	 * 添加广告房源
	 *
	 * @return
	 * @throws Exception
	 * @author 黎桂良
	 * @since 2019年8月1日
	 */
	@Test
	public void addCaseAds() throws Exception {
		FunAdsParam param = new FunAdsParam();

		param.setCaseId(6641606);
		param.setAdsContent("对五个赴日威哥");
		param.setCaseType(1);
		param.setCaseNo("CSCD1901221533269");
		param.setRecommendPrice("211");
        param.setNewspapperTel("18408274184");

		System.out.println(postNewErp(param, "managerCenter/systemMonitor/addCaseAds"));
	}

	/**
	 * 删除广告房源
	 *
	 * @return
	 * @throws Exception
	 * @author 黎桂良
	 * @since 2019年8月6日
	 */
	@Test
	public void cancelFunAds() throws Exception {
		FunAdsParam param = new FunAdsParam();

		param.setCaseId(6641606);
		param.setCaseType(1);
		param.setAdsContentIds("1546");
		System.out.println(postNewErp(param, "managerCenter/systemMonitor/cancleAdsCase"));
	}

	/**
	 * 批量删除广告房源
	 *
	 * @return
	 * @throws Exception
	 * @author 黎桂良
	 * @since 2019年8月6日
	 */
	@Test
	public void cancelManyFunAds() throws Exception {
		FunAdsParam param = new FunAdsParam();

		param.setCaseId(6641606);
		param.setCaseType(1);
		param.setAdsContentIds("1546,1547,1548");

		System.out.println(postNewErp(param, "managerCenter/systemMonitor/cancleAdsCase"));
	}

	/**
	 * 删除全部广告房源
	 *
	 * @return
	 * @throws Exception
	 * @author 黎桂良
	 * @since 2019年8月6日
	 */
	@Test
	public void cancelAllFunAds() throws Exception {
		FunAdsParam param = new FunAdsParam();
		param.setCaseId(6641606);
		param.setCaseType(1);

		System.out.println(postNewErp(param, "managerCenter/systemMonitor/cancleAdsCase"));
	}
	/**
	 * 查询系统监控安装列表
	 * @author 方李骥
	 * @since 2016年10月21日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getMgrInstallList() throws Exception{
		Map<String, Object> param =new HashMap<>();
//		param.put("compId", 47588);
//		param.put("deptId", 893901);
		param.put("organizationId", 204961);// 有
		param.put("organizationId", 204965);


//		param.put("userId", 20321302);
//		param.put("startTime", "2016-01-12");
//		param.put("endTime", "2017-07-12");
		System.out.println(postNewErp(param,"managerCenter/systemMonitor/getMgrInstallList"));
	}

	/**
	 * 查询系统监控跟进日志列表
	 * @author 方李骥
	 * @since 2016年10月21日
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getMgrTrackList() throws Exception{
		String jsonStr = "{\"caseStatus\":\"4\",\"caseType\":\"1\",\"CLIENTKEY\":\"c2d2415b380d40e69f99c16b02d9ce04\",\"date1\":\"2017-03-01\",\"date2\":\"2017-03-20\",\"deptId\":\"12001\",\"operateType\":\"BY_INFO\",\"orderEnum\":\"CREATION_TIME\",\"orderRule\":\"1\",\"pageOffset\":\"1\",\"pageRows\":\"50\",\"SOURCE_deptId\":\"12001\",\"trackType\":\"11,NORMAL,16,6,KEY,VIDEO,OUT_FINISH,CORE\",\"userId\":\"ALL\"}";
		BaseMapParam param = new BaseMapParam();
		Map<String, Object> parseObject = JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>(){});
		param.setParam(parseObject);
		//		param.setPageOffset(1);
//		param.setPageRows(50);
		System.out.println(postNewErp(param,"managerCenter/SystemMonitor/getMgrTrackList"));
	}

	/**
	 * 修改备注
	 * @author 方李骥
	 * @since 2016年10月30日
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void updateMgrReg() throws Exception{
		String jsonStr = "{\"CLIENTKEY\":\"0049071f7ba5de6b7fe477017456758a\",\"macaddr\":\"00,0B,2F,83,49,98\",\"owner\":\"dfassssssssssssssgggggg\"}";
		BaseMapParam param = new BaseMapParam();
		Map<String, Object> parseObject = JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>(){});
		param.setParam(parseObject);
		System.out.println(postNewErp(param,"managerCenter/SystemMonitor/updateMgrReg"));
	}

	/**
	 * 允许和禁止登录
	 * @author 方李骥
	 * @since 2016年10月30日
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Test 
	public void updateMgrchgLoginType() throws Exception{
		String jsonStr = "{\"CLIENTKEY\":\"0049071f7ba5de6b7fe477017456758a\",\"loginType\":\"1\",\"macaddr\":\"E0,3F,49,7B,52,4E\"}";
		BaseMapParam param = new BaseMapParam();
		Map<String, Object> parseObject = JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>(){});
		param.setParam(parseObject);
		System.out.println(postNewErp(param,"managerCenter/SystemMonitor/updateMgrchgLoginType"));
	}

	/**
	 * 电话查看列表
	 * @author 何传强
	 * @since 2017年8月26日
	 * @throws Exception
	 */
	@Test
	public void getMgrPhoneList() throws Exception{
		Map<String, String> pMap = new HashMap<>();
		pMap.put("targetType", "3");
		pMap.put("date1", "2017-07-16");
		pMap.put("date2", "2017-08-26");
		System.err.println(postNewErp(pMap,"managerCenter/systemMonitor/getMgrPhoneList"));
	}

	/**
	* 获取操作日志列表
	*/
	@Test
	public void getMgrOperateLog() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("deptId", "893901");
		pMap.put("modular", "2");
		pMap.put("time1", "2019-12-01");
		pMap.put("time2", "2019-12-05");
		pMap.put("organizationId", 204961);// 有  销售中心
//		pMap.put("organizationId", 204965);// 研发中心
//		pMap.put("organizationId", 204966);// 销售一组
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getMgrOperateLog"));
	}

	/**
	 * 广告房源列表
	 *
	 * **/
	@Test
	public void getAdsCaseList() throws Exception{
		/*
		* {"CASE_TYPE":"1","CLIENTKEY":"eb58dd5f5e204cf12609a74034e4b3bb","DATE1":"2018-07-01","DATE2":"2018-07-04","DEPT_ID":"888227","OPERATE_TYPE":"BELONG_USER","PAGE_OFFSET":"1","PAGE_ROWS":"50","SOURCE_DEPT_ID":"888227","TOTAL":"0","USER_ID":""}
		* */
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", 893569);
		pMap.put("date1", "2018-07-01");
		pMap.put("date2","2019-08-04");
		pMap.put("caseType", 1);
		pMap.put("operateType", "BELONG_USER");
		pMap.put("sourceDeptId",893569);
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getAdsCaseList"));
	}

	/**
	* 系统登陆日志列表
	*/
	@Test
	public void getSysLogList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("organizationId", 204961);// 有
		pMap.put("organizationId", 204965);
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getMgrSysLoginLogs"));
	}

	/**
	 * 考勤修改日志列表
	 */
	@Test
	public void getAttendanceRecordList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("organizationId", 204961);// 有
		pMap.put("organizationId", 204965);
		System.out.println(postNewErp(pMap,"managerCenter/systemMonitor/getAttendanceRecordList"));
	}
	
	/**
	 * 删除跟进日志
	 */
	@Test
	public void deleteFunTrack() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("trackId", 45030636);
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/deleteFunTrack"));
	}
	
	/**
	 * 获取安装密码
	 */
	@Test
	public void getMgrInstallPwd() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", 12001);
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getMgrInstallPwd"));
	}
	
	/**
	 * 获取注册管理员信息
	 */
	@Test
	public void getMgrRegistManagerUser() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getMgrRegistManagerUser"));
	}
	
	/**
	 *获取指定公司的注册标记
	 */
	@Test
	public void getMgrRegistFlag() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getMgrRegistFlag"));
	}
	
	/**
	 *获取指定公司的注册标记
	 */
	@Test
	public void setRegistManager() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userId", 10089643);
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/setRegistManager"));
	}
	
	/**
	 *允许或者禁止注册
	 */
	@Test
	public void chgRegist() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("registFlag", 1);
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/chgRegist"));
	}

	/**
	 * 钥匙借用日志
	 */
	@Test
	public void getMgrBorrowKeyLog() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getMgrBorrowKeyLog"));
	}

	/**
	 * 手机app登陆日志
	 */
	@Test
	public void getAppLoginLogs() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("organizationId", 204961);// 有
		pMap.put("organizationId", 204965);
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/getAppLoginLogs"));
	}

	/**
	 * 开启漫游
	 */
	@Test
	public void updateMgrchgCruise() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("roamUser", "20289880");
		pMap.put("roam", "1");
		pMap.put("macaddr", "00,00,00,00,00,00");
		System.out.println(postNewErp(pMap,"/managerCenter/systemMonitor/updateMgrchgCruise"));
	}

	/**
	 * 获取移交出售数据列表
	 * @author 张宏利
	 * @since 2017年12月8日
	 * @param
	 * @return
	 */
	@Test
	public void getTransSaleDataList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("id", "19614");
		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/getTransSaleDataList"));
	}
	
	/**
	 * 获取移交出租数据列表
	 * @author 张宏利
	 * @since 2017年12月8日
	 * @param
	 * @return
	 */
	@Test
	public void getTransLeaseDataList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("id", "19614");
		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/getTransLeaseDataList"));
	}
	
	/**
	 * 获取移交求购数据列表
	 * @author 张宏利
	 * @since 2017年12月8日
	 * @param
	 * @return
	 */
	@Test
	public void getTransBuyDataList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("id", "19614");
		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/getTransBuyDataList"));
	}
	
	/**
	 * 获取移交求租数据列表
	 * @author 张宏利
	 * @since 2017年12月8日
	 * @param
	 * @return
	 */
	@Test
	public void getTransRentDataList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("id", "19614");
		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/getTransRentDataList"));
	}
	
	
	@Test
	public void getOperateLogDetail() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("id", "25039");
		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/getOperateLogDetail"));
	}

	@Test
	public void getAuthRoamUserList() throws Exception{
		Map<String, Object> param = new HashMap<>();

		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/getAuthRoamUserList"));
	}

	@Test
	public void cancleAdsCase() throws Exception{
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/cancleAdsCase"));
	}
	
	@Test
	public void getSelfCompSysParamList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/sysPara/getSelfCompSysParamList"));
	}

}
