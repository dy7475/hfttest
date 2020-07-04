package com.myfun.erpWeb.managecenter.sysmanager;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.managecenter.sysmanager.param.AddDeptParam;
import com.myfun.erpWeb.usercenter.param.CashRecordParam;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewDeptParam;
import com.myfun.erpWeb.managecenter.userOpers.param.CreateOrUpdatePermissionTemplateParam;
import com.myfun.erpWeb.managecenter.userOpers.param.DeletePermissionTemplateParam;

public class OrganizationControllerTest  extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.137:8085/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.0.137:8081",     "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.5.173:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
		//init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.200.159:8080/erpWeb", "http://erpVerify.51vfang.cn/hftWebService/web/api/authentication/per.do", "582402", "13350000888");
		//init("http://192.168.200.197:8080/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280789", "18888811111");
		
//		init("http://192.168.200.197:9007/erpWeb", "http://gray.51vfang.cn/hftWebService/web/api/authentication/per.do", "1374353", "15619041351");
		initNew("http://localhost:8068/erpWeb", "http://mldev.51vfang.cn/erpWeb/usercenter/session/openLogin", "13988880001", "123456");
	}
	
	// 组织机构  --获取公司信息  --未开大区时的默认显示信息
	@Test
	public void updateUserRole() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("userId",20023866);
//		param.put("inviteId",919);
		param.put("roleId","BIZ_MANAGER");
		//param.put("countUser",1);
		System.out.println(postNewErp(param, "managerCenter/organization/updateUserRole"));
	}
	@Test
	public void compNotInviteUserRole() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"managerCenter/organization/compNotInviteUserRole"));
	}
	@Test
	public void deleteCompRoles() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("autoId",64871);
		System.out.println(postNewErp(pMap,"managerCenter/organization/deleteCompRoles"));
	}
	@Test
	public void changeFirstIn() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"managerCenter/organization/changeFirstIn"));
	}
	@Test
	public void shareRegisterUrl() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"managerCenter/organization/shareRegisterUrl"));
	}
	@Test
	public void getInvitationRegList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"managerCenter/organization/getInvitationRegList"));
	}
	@Test
	public void findUser() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userName", "阿");
		pMap.put("roleId", "HUO_JI");
		System.out.println(postNewErp(pMap,"managerCenter/organization/findUser"));
	}
	@Test
	public void splitConfiguration() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"managerCenter/organization/splitConfiguration"));
	}
	@Test
	public void levelInformation() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"managerCenter/organization/levelInformation"));
	}
	@Test
	public void deletePaymentFailureDept() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", 894241);
		System.out.println(postNewErp(pMap,"managerCenter/organization/deletePaymentFailureDept"));
	}
	@Test
	public void addDeptInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptName", "新加大区下新加片区新加门店");
		pMap.put("areaName", "新加大区1");
		pMap.put("areaId", "19539");
		pMap.put("deptAddr", "分店地址");
		pMap.put("deptContact", "旺达");
		pMap.put("deptTele", "13262629652");
		pMap.put("editAllareaInfo", "0");
		pMap.put("editAllregInfo", "0");
		pMap.put("haveArea", "1");
		pMap.put("regId", "46930");
		pMap.put("regName", "新加大区下片区1");
		pMap.put("regionId", "2");
		System.out.println(postNewErp(pMap,"managerCenter/organization/addDeptInfo"));
	}
	@Test
	public void updateGroupInformation() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("grName", "钢铁侠反手一巴掌打到了你");//传grId就是修改分组名字，传deptId就是新建分组，灵性
		pMap.put("deptId", "894237");
//		pMap.put("grId", "253433");
		System.out.println(postNewErp(pMap,"managerCenter/organization/updateGroupInformation"));
	}
	@Test
	public void getCompanyData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("compId", 12001);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getCompanyData"));
	}
	
	//  员工信息
	@Test
	public void getUserInfoData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("archiveId", 506970);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getUserInfoData"));
	}
	
	//  职级列表
	@Test
	public void getPersonnelLevelList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getPersonnelLevelList"));
	}
	
	//  渠道列表
	@Test
	public void getRecruitmentChannelList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getRecruitmentChannelList"));
	}
	
	//  删除渠道
	@Test
	public void delRecruitmentChannel() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("channelId", 55);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/delRecruitmentChannel"));
	}
	
	//  删除职级
	@Test
	public void delPersonnelLevel() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("levelId", 55);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/delPersonnelLevel"));
	}
	
	//  大区列表
	@Test
	public void getAreaList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("countUser",1);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getAreaList"));
	}
	
	//  片区列表
	@Test
	public void getRangeList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("compId",46470);
		pMap.put("countUser",1);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getRangeList"));
	}
	
	//  片区列表
	@Test
	public void getDeptListByReg() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("compId", 12001);
		pMap.put("regId", 40143);
		pMap.put("countUser",1);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getDeptListByReg"));
	}
	
	//  片区列表
	@Test
	public void insertMgrGroupData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("adminUser", 10086823);
		pMap.put("compId", 12001);
		pMap.put("deptId", 12001);
		pMap.put("deptame", "好房通测试A店");
		pMap.put("grContact", "小小");
		pMap.put("grDesc", "车站");
		pMap.put("grMember", "10086823");
		pMap.put("grName", "ERP测试2");
		pMap.put("grTele", "18782920000");
		pMap.put("seqNo", "10");
		pMap.put("grId", "252968");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/insertMgrGroupData"));
	}

	//  重置密码
	@Test
	public void updateMgrResetUserPWData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userId", "10091572");
		pMap.put("mobile", "17810000007");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/updateMgrResetUserPWData"));
	}
	//  冻结用户
	@Test
	public void updateMgrUserUseState() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userId", "10091572");
		pMap.put("userStatus", "0");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/updateMgrUserUseState"));
	}

	/***
	 * 组织机构 --更新分店
	 * */
	@Test
	public void updateMgrDeptData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("regId", "44233");
		pMap.put("deptId", 891289);
		pMap.put("areaId", "12001");
		pMap.put("areaName", "测试");
		pMap.put("compNo", "AA01");
		pMap.put("deptDddr", "成都市佳灵路3号红牌楼广场2号写字楼901室");
		pMap.put("deptCname", "小红长大了");
		pMap.put("deptCode", "cs");
		pMap.put("deptDesc", "测试2222");
		pMap.put("regId", "40143");
		pMap.put("deptContact", "屌丝");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/updateMgrDeptData"));
	}

	/***
	 * 分组信息
	 * */
	@Test
	public void getGroupData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", "12001");
		//pMap.put("grId", "252446");

		System.out.println(postNewErp(pMap,"/managerCenter/organization/getGroupData"));
	}

	/***
	 * 组织机构 --获取用户信息列表
	 * */
	@Test
	public void getUserListInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("allUsersFlag", "1");
//		pMap.put("deptId",57430);
		pMap.put("countUser",1);
		pMap.put("isNeedOpers",1);
		pMap.put("isNeedRoleAndDeptName",1);
		pMap.put("userWriteoff",0);
////		pMap.put("isNeedRoleAndDeptName",1);
////		pMap.put("pageOffset",0);
////		pMap.put("pageSize",5);
//		/*pMap.put("keyWord","d");
//		pMap.put("sortType","5");
//		/*pMap.put("userWriteoff","1");*/
		pMap.put("pageOffset",1);
		pMap.put("pageRows",15);
//		pMap.put("keyWord","cyh");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getUserListInfo"));
	}
	
	/***
	 * 依据角色获取员工列表
	 * */
	@Test
	public void getUserListByRoleId() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("roleId", "DEPUTY_MANAGER");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getUserListByRoleId"));
	}
	
	/***
	 * 给员工配置管理范围
	 * */
	@Test
	public void updateUserManageRange() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userId", "20147429");
		pMap.put("rangeType", "5");
		pMap.put("roleId","REGION_MANAGER");
		StringBuilder builder = new StringBuilder();
		for(int i=1001; i<1300; i++){
			builder.append(","+i);
		}
		String s = builder.toString().replaceFirst(",","");
//		System.out.println(s);
		pMap.put("rangeIds", s);
		System.out.println(postNewErp(pMap,"/managerCenter/organization/updateUserManageRange"));
	}
	
	/***
	 * 增加公司角色
	 * */
	@Test
	public void addCompRoles() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("roleName", "测试");
		pMap.put("manageLevel", "2");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/addCompRoles"));
	}
	
	/***
	 * 修改角色顺序
	 * */
	@Test
	public void updateRoleSeq() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("roleIds", "GENERAL_MANAGER,ddf13f5ef3944b0cb0a7558a036318c3,3045b49c75474afe99519f7dcd77a64a,55f40ccb3ed24fd2ad2f42f05f0eb092,5ec3cf9536b345ea9a824dfd019da290,387d19ec07604f468366ac046f509282,DEPUTY_MANAGER,BIZ_GENERAL,261758b636fe44289cdf60eb0bb90831,c1e559de53764d3bbf407305b275976e,REGION_MANAGER,BRANCH_MANAGER,SECRETARIAL,SYSTEM_MANAGE,BIZ_MANAGER,CUST_SERVER,PROPERTY_SERVER,cf17cb4b20404982974ac0847c96f467,COMMON_BIZ,PRACTY_BIZ,effc00a5e50e4ec1b0f3768a536c0af5,9d6bf0a4d5bc4434897820683a81f7b0,091808ced92049d58166b4329f4eb713,46c2e1afab1f456eadb0ee7fdf395ce6");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/updateRoleSeq"));
	}
	
	/***
	 * 获取公司所有角色
	 * */
	@Test
	public void getAllCompRole() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("roleIds", "");
		System.out.println(postNewErp(pMap,"/managerCenter/organization/getAllCompRole"));
	}
	
	/**
	 * 编辑片区信息
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/21
	 */
	@Test
	public void updateMgrRangeData() throws Exception {
		/*"REG_ID":"45329","REG_NAME":"高新片区3","REG_TELE":"456789","SEQ_NO":"3","UPDATE_TIME":"2017-12-07 14:11:57.127","UPDATE_UID":"20319440"}*/
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("regId", "47328");
//		pMap.put("areaId", "18279");//陈学芳
//		pMap.put("adminUser", "10089643");
//		pMap.put("araeName", "小白菜测试权限");
//		pMap.put("areaName", "好房通总部");
//		pMap.put("deptName", "好房通测试D店");
//
//		pMap.put("editAllareaInfo", "1");
//		pMap.put("haveArea", "1");
//		pMap.put("regAdmin", "罗浩");
//		pMap.put("regDesc", "测试片区编辑");

		pMap.put("regName", "钢铁侠，正在修改片区2");
//		pMap.put("regTele", "456789");
//		pMap.put("seqNo", "3");
//		pMap.put("updateUid", "20319440");
		System.out.println(postNewErp(pMap, "/managerCenter/organization/updateMgrRangeData"));
	}
	
	/**
	 * 删除片区
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	@Test
	public void deleteMgrRangeData() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("regId", "47323");
		System.out.println(postNewErp(pMap, "/managerCenter/organization/deleteMgrRangeData"));
	}

	/**
	 * 删除分组
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/17
	 * @return
	 *
	 */
	@Test
	public void deleteGroupInformation() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", "894228");
//		pMap.put("grId", "253431");
		System.out.println(postNewErp(pMap, "/managerCenter/organization/deleteGroupInformation"));
	}

	/**
	 *  组织机构 --更新分店
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/17
	 * @return
	 *
	 */
	@Test
	public void updateDeptInformation() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("areaId", "12001");
//		pMap.put("areaName", "好房通总部");
//		pMap.put("compId", "12001");
//		pMap.put("regId", "47349");
//		pMap.put("custLeveL", "1");
//		pMap.put("ddhaorangFlag", "1");
//		pMap.put("deptAddr", "测试地址");
//
		pMap.put("deptId", "894961");
		pMap.put("regId", "46714");

//		pMap.put("deptFlag", "2");
//		pMap.put("deptType", "2");

//		pMap.put("deptNo", "A3");
//		pMap.put("regionId", "1");
		pMap.put("seqNo", "1");
//		pMap.put("deptName", "12001");

		pMap.put("deptCode", "HFTCSCD");
		pMap.put("deptTele", "1800000");
		pMap.put("deptContact", "好房通4");
		pMap.put("deptDesc", "PPP");
		pMap.put("deptcName", "钢铁侠，正在修店名称");
		System.out.println(postNewErp(pMap, "/managerCenter/organization/updateDeptInformation"));
	}

	/**
	 *  组织机构 --获取门店是否还能新建员工账号
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/17
	 * @return
	 *
	 */
	@Test
	public void getRegisterUserStatus() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", "891740");
		pMap.put("roleId", "COMMON_ADMIN");
		System.out.println(postNewErp(pMap, "/managerCenter/organization/getRegisterUserStatus"));
	}

	/**
	 * 注销用户帐号
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/21
	 */
	@Test
	public void updateMgrLogOffUserInfoData() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userId", 20334207);
		System.out.println(postNewErp(pMap, "/managerCenter/organization/deleteUser"));
	}

	
	/**
	 * 新建片区信息
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return
	 *
	 */
	@Test
	public void insertMgrRangeData() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("regName", "钢铁侠↓小基地");
		System.out.println(postNewErp(pMap, "/managerCenter/organization/insertMgrRangeData"));
	}

	/**
	 * 获取用户操作权限列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/20
	 */
	@Test
	public void getMgrUserOpersList() throws Exception {
		/*
{"CLIENTKEY":"1267288dd0f7221966bf87bdd168ccee","COMP_TYPE":"1","DEPT_ID":"12001","IS_COMP_ROLE":"1","OPER_TYPE":"1","PARA_Value":"0","ROLE_ID":"acb6c50d5edf4958880971686704064a","USER_ID":"20321855"}
		* */
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("compType", 1);
		pMap.put("deptId", 12001);
		pMap.put("isCompRole", 1);
		pMap.put("operType", 1);
		pMap.put("paraValue", 0);
		pMap.put("roleId", "acb6c50d5edf4958880971686704064a");
		pMap.put("userId", "20321855");
		System.out.println(postNewErp(pMap, "/managerCenter/organization/getMgrUserOpersList"));
	}
	
	/**
	 * 员工调店
	 * @param
	 * @auther 朱科
	 * @since 2018/4/27
	 * @return
	 *
	 */
	@Test
	public void moveUserToNewDept() throws Exception {
		MoveUserToNewDeptParam param = new MoveUserToNewDeptParam();
//		param.setSelfUserId(20319440);
//		param.setCompId(12001);
//		param.setCityId(1);
		param.setNewDeptId(894385);
		param.setUserId(20332422);
		param.setNewGrId(253767);
		System.out.println(postNewErp(param, "/managerCenter/organization/moveUserToNewDept"));
	}

	@Test
	public void inviteRegist() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("userSex","男");
		param.put("deptId",12001);
		param.put("userMobile","18782920377");
		System.out.println(postNewErp(param, "/managerCenter/organization/inviteRegist"));
	}

	@Test
	public void validKey() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("mobile","18121321321");
		param.put("key","132456");
		param.put("flag",1);
		System.out.println(postNewErp(param, "/managerCenter/organization/validKey"));
	}

	@Test
	public void addDept() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("regionId","123");
		param.put("areaId","123");
		param.put("deptName","测试门店2");
		param.put("deptTele","13520636213");
		param.put("deptAddr","成都高新");
		param.put("deptDesc","测试一波");
		param.put("deptContact","王二小");
		param.put("regId","42032");
		System.out.println(postNewErp(param, "/managerCenter/organization/addDept"));
	}

	@Test
	public void getCityRegList() throws Exception {
		Map<String, Object> param = new HashMap<>();
//		param.put("regId",1);
		param.put("vertifyFlag",1);
		System.out.println(postNewErp(param, "/managerCenter/organization/getCityRegList"));
	}

	@Test
	public void getRegSectionList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("regId",1);
		param.put("vertifyFlag",1);
		//param.put("sectionId",43);
		//param.put("sectionCode","WJL");
		System.out.println(postNewErp(param, "/managerCenter/organization/getRegSectionList"));
	}

	@Test
	public void getDeptGroupList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("deptId",12001);
		param.put("countUser",1);
		System.out.println(postNewErp(param, "/managerCenter/organization/getDeptGroupList"));
	}

	@Test
	public void checkMap() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("checkId",329);
		//param.put("countUser",1);
		System.out.println(postNewErp(param, "/attendance/checkMap?outId=510119"));
	}

	@Test
	public void getUserOpers() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("userId",2001);
		System.out.println(postNewErp(param, "managerCenter/organization/getUserOpers"));
	}

	@Test
	public void editUserInfo() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("archiveId",670521);
		param.put("userId",20322911);
		//param.put("userSex",1);
		param.put("userPosition","DEPUTY_MANAGER");
		/*param.setArchiveId(670483);
		param.setUserId(20322814);
		*//*param.setGrId(252446);*//*
		param.setUserName("邓永洪1");
		param.setServiceReg("1 4");
		param.setServiceZoneIds("35740 35742 60");
		param.setServiceZone("好望角 武侯立交 磨子桥");*/
		/*param.setUserSex(true);*/
		System.out.println(postNewErp(param, "/managerCenter/organization/editUserInfo"));
	}


	@Test
	public void getFunRolesList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "/managerCenter/organization/getFunRolesList"));
	}


	@Test
	public void updateCompConmmonAdmin() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("userId","20023866");
		System.out.println(postNewErp(param, "/managerCenter/organization/updateCompConmmonAdmin"));
	}

	@Test
	public void getHfCoinRecordListTest() throws Exception {
		CashRecordParam param = new CashRecordParam();
		param.setDateType("5");
		param.setUaType(1);
		param.setPageOffset(1);
		param.setPageRows(20);
		System.out.println(postNewErp(param, "usercenter/getHfCoinRecordList"));
	}
	
	/**
	 * 房基地两端-权限配置与角色配置区分：查询权限模板列表	单元测试
	 * @throws Exception
	 */
	@Test
	public void getPermissionTemplateListTest() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "/managerCenter/organization/getPermissionTemplateList"));
	}
	
	/**
	 * 房基地两端-权限配置与角色配置区分：新增或编辑权限模板（增加、修改权限模板名字）	单元测试
	 * @throws Exception
	 */
	@Test
	public void createOrUpdatePermissionTemplateTest() throws Exception {
		CreateOrUpdatePermissionTemplateParam param = new CreateOrUpdatePermissionTemplateParam();
//		param.setPermissionTemplateId(53);
		param.setPermissionTemplateName("单元测试权限模板");
		System.out.println(postNewErp(param,"/managerCenter/organization/createOrUpdatePermissionTemplate"));
	}
	
	/**
	 * 房基地两端-权限配置与角色配置区分：删除权限模板	单元测试
	 * @throws Exception
	 */
	@Test
	public void deletePermissionTemplateTest() throws Exception {
		DeletePermissionTemplateParam param = new DeletePermissionTemplateParam();
		param.setPermissionTemplateId(52);
		System.out.println(postNewErp(param,"/managerCenter/organization/deletePermissionTemplate"));
	}
}
