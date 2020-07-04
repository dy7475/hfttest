package com.myfun.erpWeb.managecenter.sysmanager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.ErpOaLeaveAuditParam;
import com.myfun.repository.erpdb.param.ErpOaOutAuditParam;

/**
 * 系统参数控制接口
 * 
 * @author 张宏利
 * @since 2017年10月16日
 */
public class AuditTaskControllerTest extends BaseTestController {
	@Before
	public void init() {
//		initOnlyAddr("http://192.168.200.145:8087/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/openLogin", "1172207", "13322221111");
//		
//		super.setClientKey("e380424c0e4d2484040f9ca32005c419");
		//initNew("http://192.168.200.155:8068/erpWeb", "http://192.168.200.155:8068/erpWeb/usercenter/session/openLogin", "15100009999", "123456");
		
		init("http://192.168.200.155:8068/erpWeb", "http://testapp.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281304", "15100009999");
	}

	/**
	 * 获取业务审核流程信息
	 */
	@Test
	public void getAuditTemplate() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("caseType", 1);
		System.out.println(postNewErp(param, "/managerCenter/auditTask/getAuditTemplate"));
	}

	/**
	 * 保存业务审核流程信息
	 */
	@Test
	public void saveAuditTemplate() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("templateList", "[{\"caseType\":1,\"auditType\":1,\"overdueAuditTime\":40,\"auditUser\":[{\"auditUserType\":1,\"auditUserId\":6515},{\"auditUserType\":1,\"auditUserId\":6515}]},{\"caseType\":1,\"auditType\":2,\"overdueAuditTime\":40,\"auditUser\":[{\"auditUserType\":1,\"auditUserId\":6515},{\"auditUserType\":1,\"auditUserId\":6515}]}]");
		System.out.println(postNewErp(param, "/managerCenter/auditTask/saveAuditTemplate"));
	}
	
	/**
	 * 拷贝审核流程配置
	 */
	@Test
	public void copyAuditTemplate() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("fromCaseType", "1");
		param.put("toCaseType", "2");
		System.out.println(postNewErp(param, "/managerCenter/auditTask/copyAuditTemplate"));
	}
	
	/**
	 * 对流程进行跟进操作
	 */
	@Test
	public void createAuditRuntime() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("auditType", 1);
		param.put("caseType", 1);
		param.put("caseId", 123456);
		param.put("auditTitle", "审核测试");
		param.put("auditExplain", "审核测试的说明啦啦啦啦");
		param.put("targetTime", "2017-10-25");
		param.put("targetStatus", 1);
		param.put("targetId", 123456);
		param.put("targetType", 1);
		param.put("targetNo", "CSCD1564653132");
		param.put("targetUseage", 7);
		param.put("warmTime", "2017-10-25");
		param.put("warmContent", "提醒内容到啦");
		System.out.println(postNewErp(param, "/managerCenter/auditTask/createAuditRuntime"));
	}

	/**
	 * 对流程进行跟进操作
	 */
	@Test
	public void createAuditTrack() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("auditId", 4);
		param.put("trackContent", "测试测试测试测试测试");
		System.out.println(postNewErp(param, "/managerCenter/auditTask/createAuditTrack"));
	}

	/**
	 * 对流程进行审核操作
	 */
	@Test
	public void auditRuntime() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("auditId", 4);
		param.put("auditStatus", 1);
		param.put("trackContent", "测试测试测试测试测试");
		System.out.println(postNewErp(param, "/managerCenter/auditTask/auditRuntime"));
	}
	
	/**
	 * 对流程进行撤回操作
	 */
	@Test
	public void auditRevokeRuntime() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("auditId", 4);
		param.put("trackContent", "测试测试测试测试测试");
		System.out.println(postNewErp(param, "/managerCenter/auditTask/auditRevokeRuntime"));
	}

	/**
	 * 获取审核流程跟进列表
	 */
	@Test
	public void getAuditTrackList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("auditId", 4);
		System.out.println(postNewErp(param, "/managerCenter/auditTask/getAuditTrackList"));
	}
	
	/**
	 * 获取待我审核的审核列表
	 */
	@Test
	public void getWaitMyAuditList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "/managerCenter/auditTask/getWaitMyAuditList"));
	}
	
	/**
	 * 获取我审核的审核列表
	 */
	@Test
	public void getMyAuditList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "/managerCenter/auditTask/getMyAuditList"));
	}
	
	/**
	 * 获取我提交的审核列表
	 */
	@Test
	public void getMyCreateAuditList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "/managerCenter/auditTask/getMyCreateAuditList"));
	}
	
	/**
	 * 获取审核详情
	 */
	@Test
	public void getAuditDetailTest() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("auditId", 16059);
		System.out.println(postNewErp(param, "/managerCenter/auditTask/getAuditDetail"));
	}
	/**
	 * 外出申请
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	@Test
	public void createAuditForOaOut() throws Exception {
		ErpOaOutAuditParam param = new ErpOaOutAuditParam();
		param.setOutType(1);
		param.setOutStartTime(new Date());
		param.setOutEndTime(new Date());
		param.setOutReason("测试外出");
		System.out.println(postNewErp(param, "/managerCenter/auditTask/createAuditForOaOut"));
	}
	
	/**
	 * 请假申请
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	@Test
	public void createAuditForOaLeave() throws Exception{
		ErpOaLeaveAuditParam param = new ErpOaLeaveAuditParam();
		param.setLeaveType(1);
		param.setLeaveStartTime(new Date());
		param.setLeaveEndTime(new Date());
		param.setLeaveReason("测试请假");
		param.setLeaveDay(BigDecimal.ONE);
		System.out.println(postNewErp(param, "/managerCenter/auditTask/createAuditForOaLeave"));
	}
	
	/**
	 * 获取审核相关房源
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	@Test
	public void getAuditCaseList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("auditId", 4);
		System.out.println(postNewErp(param, "/managerCenter/auditTask/getAuditCaseList"));
	}
	
	/**
	 * 获取审核相关房源
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	@Test
	public void copyTemplateForOaLeave() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("templateId", 10033);
		param.setInteger("templateAuditType", 1);
		System.out.println(postNewErp(param, "/managerCenter/auditTask/copyTemplateForOaLeave"));
	}
	
	/**
	 * 获取审核相关房源
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	@Test
	public void copyTemplateForOaOut() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("templateId", 10042);
		param.setInteger("templateAuditType", 1);
		System.out.println(postNewErp(param, "/managerCenter/auditTask/copyTemplateForOaOut"));
	}
}


