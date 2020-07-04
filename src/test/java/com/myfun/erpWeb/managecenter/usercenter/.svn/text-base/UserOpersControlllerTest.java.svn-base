package com.myfun.erpWeb.managecenter.usercenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.userOpers.param.GetUsersOpersListParam;
import com.myfun.erpWeb.managecenter.userOpers.param.OperListParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.utils.UrlUtils;
import com.myfun.utils.rijindael.AESHelper;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.param.AddCompInviteRegistParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.RoleLevelListParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.RoleLevelParam;
import com.myfun.erpWeb.managecenter.userOpers.param.GetPermissionTemplateParam;
import com.myfun.erpWeb.managecenter.userOpers.param.GetTemplatePermissionInfoParam;
import com.myfun.erpWeb.managecenter.userOpers.param.UpdateRolePermissionTemplateParam;

public class UserOpersControlllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.5.175:8080/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
//		init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.5.186:8080/erpWeb", "http://192.168.5.186:8081/hftWebService/web/api/authentication/per.do", "506504", "18566547985");
//		init("http://192.168.200.145:9001/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281028", "15812345600");
		initNew("http://192.168.200.194:8068/erpWeb", "http://192.168.200.194:8068/erpWeb/usercenter/session/openLogin", "18778789989", "123456");
	}


	/**
	 * 员工权限-高级权限说明
	 * @author ZangTie
	 * @since 2018年7月24日 下午2:28:15
	 * @throws Exception
	 * Modified XXX ZangTie 2018年7月24日
	 */
	@Test
	public void getMgrRoleDescription() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("cityId",1);
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/getMgrRoleDescription"));
	}

	@Test
	public void updateUsersOpers() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("delOpers","VIEW_WARRANT_INFO");
//		param.put("addOpers","VIEW_WARRANT_INFO");
		param.put("isCompRole","0");
		param.put("rangeIds","17179");
		param.put("rangeType","2");
		param.put("roleId","BIZ_GENERAL");
		param.put("userId","20324146");
		param.put("userRoleChange","0");
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/updateUsersOpers"));
	}

	@Test
	public void getUsersOpersList() throws Exception {
		GetUsersOpersListParam param = new GetUsersOpersListParam();
		param.setUserId(20333416);
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/getUsersOpersList"));
	}

	@Test
	public void getRoleOpersList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("roleId","DEPUTY_MANAGER");
		param.put("isCompRole","0");
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/getRoleOpersList"));
	}

	@Test
	public void getInviteLink() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"/managerCenter/organization/getInviteLink"));
	}

	@Test
	public void getInviteLinkUrl() throws Exception {
		String erpWebUrl = AppConfig.getErpWebUrl() + "openApi/inviteRegist/getCompInvite.htm?param=";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("cityId", 1);
		paramMap.put("compId", 47937);
		paramMap.put("compNo", "CFY9");
		paramMap.put("leaguesType", 1);
		erpWebUrl += AESHelper.encode(JSON.toJSONString(paramMap));
		String s = UrlUtils.genShortUrl(erpWebUrl);
		System.out.println(s);
	}

	@Test
	public void addInviteUserInfo() throws Exception {
		AddCompInviteRegistParam addCompInviteRegistParam = new AddCompInviteRegistParam();
		addCompInviteRegistParam.setUserMobile("18811110321");
		addCompInviteRegistParam.setCurrentPId(20333471);
		addCompInviteRegistParam.setOrganizationId(204999);
		addCompInviteRegistParam.setDeptId(894307);
//		addCompInviteRegistParam.setGrId(252995);
//		addCompInviteRegistParam.setLevelsId(24);
//		addCompInviteRegistParam.setPersonnelLevels("测试工程师");
//		addCompInviteRegistParam.setRangeIds("892130");
//		addCompInviteRegistParam.setRangeType(4);
//		addCompInviteRegistParam.setRegId(45363);
//		addCompInviteRegistParam.setServiceReg("45363");
//		addCompInviteRegistParam.setServiceZone("市区");
//		addCompInviteRegistParam.setUserName("张三疯");
//		addCompInviteRegistParam.setServiceZoneIds("11");
		addCompInviteRegistParam.setUserPosition("BIZ_GENERAL");
		addCompInviteRegistParam.setUserSex((byte) 1);
		System.out.println(postNewErp(addCompInviteRegistParam,"/managerCenter/organization/addInviteUserInfo"));
	}
	
	
	@Test
	public void createOrUpdateRoleLevel() throws Exception {
		
		RoleLevelListParam roleLevelListParam = new RoleLevelListParam();
		List<RoleLevelParam> roleLevelList = new ArrayList<RoleLevelParam>();
		RoleLevelParam tmp1 = new RoleLevelParam();
		tmp1.setRoleId("d2b706418c584fc7aed3405a7e1fe6ba1");
		tmp1.setRoleLevelName("aaa");
		tmp1.setSeqNo(1);
		roleLevelList.add(tmp1);
		
		RoleLevelParam tmp2 = new RoleLevelParam();
		tmp2.setRoleId("d2b706418c584fc7aed3405a7e1fe6ba1");
		tmp2.setRoleLevelName("aaa");
		tmp2.setSeqNo(2);
		roleLevelList.add(tmp2);
		
		RoleLevelParam tmp3 = new RoleLevelParam();
		tmp3.setRoleId("d2b706418c584fc7aed3405a7e1fe6ba1");
		tmp3.setRoleLevelName("bbb");
		tmp3.setSeqNo(3);
		roleLevelList.add(tmp3);
		
		roleLevelListParam.setRoleLevelList(roleLevelList);
		System.out.println(postNewErp(roleLevelListParam, "/managerCenter/organization/createOrUpdateRoleLevel"));
	}
	
	/**
	 * 获取角色模板权限		单元测试
	 * @throws Exception
	 */
	@Test
	public void getPermissionTemplateTest() throws Exception {
		GetPermissionTemplateParam param = new GetPermissionTemplateParam();
		param.setPermissionTemplateId(53);
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/getPermissionTemplate"));
	}
	
	/**
	 * 房基地两端-权限配置与角色配置区分：查询公司所有权限模板应用范围列表	单元测试
	 * @throws Exception
	 */
	@Test
	public void getPermissionTemplateScopeTest() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/getPermissionTemplateScope"));
	}
	
	/**
	 * 房基地两端-权限配置与角色配置区分：保存角色选择权限模板，同步经纪人权限	单元测试
	 * @throws Exception
	 */
	@Test
	public void updateRolePermissionTemplateTest() throws Exception {
		UpdateRolePermissionTemplateParam param = new UpdateRolePermissionTemplateParam();
		param.setEffectRange(0);
		param.setPartStatistCount(Byte.valueOf("0"));
		param.setPermissionTemplateId(53);
		param.setRoleId("3620ec72b6184172893c8609c26983b3");
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/updateRolePermissionTemplate"));
	}
	
	/**
	 * 房基地两端-权限配置与角色配置区分：获取模板权限信息	单元测试
	 * @throws Exception
	 */
	@Test
	public void getTemplatePermissionInfoTest() throws Exception {
		GetTemplatePermissionInfoParam param = new GetTemplatePermissionInfoParam();
		param.setPermissionTemplateId(53);
		System.out.println(postNewErp(param,"/manageCenter/userOpersModule/getTemplatePermissionInfo"));
	}
	
	//获取所有组织
	@Test
	public void getAllOrganizationList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "/manageCenter/userOpersModule/getAllOrganizationList"));
	}
	
	//获取对应组织下的所有人员
	@Test
	public void getOrgUsersList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		//param.put("compId", 47963);
		//param.put("organizationId", 894702);
		param.put("userName", "李成兵");
		System.out.println(postNewErp(param, "/manageCenter/userOpersModule/getOrgUsersList"));
	}
	
	//保存对应用户的跨城权限列表（新增、修改）
	@Test
	public void saveCrossCompOper() throws Exception {
		/*  {
		  "operList":[
		    {"compId":"10001","addOpers":"sfd,sde","delOpers":""},
		    {"compId":"10002","addOpers":"","delOpers":""}
		  ],
		  "openCityManage"[
		    {"compId":10001,"isOpen":1},
		    {"compId":10002,"isOpen":0}
		  ]
		}
	 */
		List<Map<String, Object>> operList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("compId", 47963);
		map1.put("addOpers","GUEST_VIEW,NEW_HOUSE_VIEW");
		map1.put("delOpers", "ORGANIZATION_MANAGE,HOUSE_VIEW");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("compId", 47967);
		map2.put("addOpers","GUEST_VIEW,NEW_HOUSE_VIEW");
		map2.put("delOpers", "ORGANIZATION_MANAGE,HOUSE_VIEW");
		operList.add(map1);
		operList.add(map2);
		
		List<Map<String, Object>> openCityManage = new ArrayList<Map<String, Object>>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("compId", 47963);
		map3.put("isOpen", 1);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("compId", 47967);
		map4.put("isOpen", 0);
		openCityManage.add(map3);
		openCityManage.add(map4);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("operList", operList);
		param.put("openCityManage", openCityManage);
		param.put("userId", 20333878);
		
		System.out.println(postNewErp(param, "/manageCenter/userOpersModule/saveCrossCompOper"));
	}
	
	//获取所有跨城管理员列表
	@Test
	public void getCrossCompUserList() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		System.out.println(postNewErp(param, "/manageCenter/userOpersModule/getCrossCompUserList"));
	}
	
	//获取对应用户的跨城权限列表
	@Test
	public void getCrossCompUserOper() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", 20333878);
		System.out.println(postNewErp(param, "/manageCenter/userOpersModule/getCrossCompUserOper"));
	}
	
	
}
