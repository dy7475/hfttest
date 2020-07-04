package com.myfun.erpWeb.managecenter.attendance;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.util.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.param.MaxApplyClassParam;
import com.myfun.repository.erpdb.param.*;
import com.myfun.repository.erpdb.po.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AttendanceControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.5.169:8080/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "671966", "15254444555");
	}



	/**
	 * 获取公司应用最大的打卡次数
	 **/
	@Test
	public void getMaxApplyClass() throws Exception{
		MaxApplyClassParam param = new MaxApplyClassParam();
		System.out.println(postNewErp(param,"/managerCenter/attendanceClassModule/getMaxApplyClass"));
	}
	/**
	 * @Title 班次列表
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param keyWords 关键字查询
	 **/
	@Test
	public void getAttendanceClassList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		Map<String, Object> map = new ConcurrentHashMap();
		map.put("keyWords", "测试");
		param.put("keyWords", "测试");
		param.put("devModel", "webTest");
		System.out.println(postNewErp(param,"/managerCenter/attendanceClassModule/getAttendanceClassList"));
	}

	/**
	 * @Title 班次详情
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param id 查询班次的主键
	 **/
	@Test
	public void getAttendanceClassDetail() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("id", "121");
		System.out.println(postNewErp(param, "/managerCenter/attendanceClassModule/getAttendanceClassDetail"));
	}

	/**
	 * @Title 删除班次
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param id 查询班次的主键
	 **/
	@Test
	public void delEditAttendanceClass() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setId(26);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceClassModule/delAttendanceClass"));
	}

	/**
	 * @Title 班次新增编辑
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param id 查询班次的主键
	 **/
	@Test
	public void addEditAttendanceClass() throws Exception{
		ErpFunAttendanceClass erpFunAttendanceClass = new ErpFunAttendanceClass();
//		erpFunAttendanceClass.setId(3);
		erpFunAttendanceClass.setCalssNumber(1);
		erpFunAttendanceClass.setClassName("行政班次2");
		erpFunAttendanceClass.setFirstUp("04:06");
		erpFunAttendanceClass.setFirstDown("09:08");
		erpFunAttendanceClass.setClassType((byte)1);

		System.out.println(postNewErp(erpFunAttendanceClass,"/managerCenter/attendanceClassModule/addEditAttendanceClass"));
	}


	/**
	 * @Title 考勤地点列表
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getAttendanceScopeList() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setKeyWords("");
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceScopeModule/getAttendanceScopeList"));
	}

	/**
	 * @Title 考勤地点详情
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getAttendanceScopeDetail() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setAttScopeId(1);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceScopeModule/getAttendanceScopeDetail"));
	}

	/**
	 * @Title 考勤组
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getAttendanceGroupList() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setKeyWords("");
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceGroupModule/getAttendanceGroupList"));
	}

	/**
	 * @Title 考勤地点详情
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void delAttendanceScope() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setAttScopeId(5);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceScopeModule/delAttendanceScope"));
	}

	/**
	 * @Title 考勤地点详情
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void updateScopeWifiStatus() throws Exception{
		ErpAttendanceScopeParam attendanceModuleParam = new ErpAttendanceScopeParam();
		attendanceModuleParam.setWifiId(1);
		attendanceModuleParam.setWifiStatus((byte)1);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceScopeModule/updateScopeWifiStatus"));
	}

	/**
	 * @Title 删除考勤组
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void delAttendanceGroup() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setId(1);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceGroupModule/delAttendanceGroup"));
	}

	/**
	 * @Title 考勤组详情
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getAttendanceGroupDetail() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setId(1);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceGroupModule/getAttendanceGroupDetail"));
	}

	/**
	 * @Title 排班制考勤组
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getAttendanceUserClassList() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setScheduleMonth("2017-11");
		attendanceModuleParam.setId(2);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceGroupModule/getAttendanceUserClassList"));
	}

	/**
	 * @Title 排班制考勤组
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getFunAttfestivalList() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceGroupModule/getFunAttfestivalList"));
	}

	/**
	 * @Title 考勤地点新增编辑
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void addEditAttendanceScope() throws Exception{
		ErpAttendanceScopeParam erpAttendanceScopeParam = new ErpAttendanceScopeParam();
//		erpAttendanceScopeParam.setAttScopeId(5);
		erpAttendanceScopeParam.setAttScopeX("102X");
		erpAttendanceScopeParam.setAttScopeY("102Y");
		erpAttendanceScopeParam.setAttDistance(200);
		erpAttendanceScopeParam.setLocationDescAbb("xxxxx");
		erpAttendanceScopeParam.setLocationDesc("修改全称");

		List<ErpFunAttendanceScopeBiz> bizList = new ArrayList<>();

		ErpFunAttendanceScopeBiz erpFunAttendanceScopeBiz1 = new ErpFunAttendanceScopeBiz();
		erpFunAttendanceScopeBiz1.setBizId(12002);
		erpFunAttendanceScopeBiz1.setChooseType(1);
		bizList.add(erpFunAttendanceScopeBiz1);

		ErpFunAttendanceScopeBiz erpFunAttendanceScopeBiz2 = new ErpFunAttendanceScopeBiz();
		erpFunAttendanceScopeBiz2.setBizId(252483);
		erpFunAttendanceScopeBiz2.setChooseType(2);
		bizList.add(erpFunAttendanceScopeBiz2);

		ErpFunAttendanceScopeBiz erpFunAttendanceScopeBiz3 = new ErpFunAttendanceScopeBiz();
		erpFunAttendanceScopeBiz3.setBizId(10085696);
		erpFunAttendanceScopeBiz3.setChooseType(3);
		bizList.add(erpFunAttendanceScopeBiz3);

		erpAttendanceScopeParam.setAttdanceScopeBizList(JSONObject.toJSONString(bizList));

		System.out.println(postNewErp(erpAttendanceScopeParam,"/managerCenter/attendanceScopeModule/addEditAttendanceScope"));
	}

	/**
	 * @Title行政班
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void addEditAttendanceFixGroup() throws Exception{

		ErpFunAttendanceGroupParam erpAttendanceScopeParam = new ErpFunAttendanceGroupParam();
//		erpAttendanceScopeParam.setId(3);
		erpAttendanceScopeParam.setClassType((byte) 1);
		erpAttendanceScopeParam.setFestivals((byte) 1);
		erpAttendanceScopeParam.setGroupName("测试行政班l");
		erpAttendanceScopeParam.setIsUpdateUser(1);

		erpAttendanceScopeParam.setFirClass(1);
		erpAttendanceScopeParam.setWebClass(1);
		erpAttendanceScopeParam.setTuesCalss(1);
		erpAttendanceScopeParam.setSunClass(1);
		erpAttendanceScopeParam.setStaClass(1);
		erpAttendanceScopeParam.setMonClass(1);
		erpAttendanceScopeParam.setThurClass(1);

		// 特殊考勤时间
		List<ErpFunAttendanceFestival> festivalList = new ArrayList<>();
		ErpFunAttendanceFestival funAttendanceFestival = new ErpFunAttendanceFestival();
		funAttendanceFestival.setAttClassId(1);
		funAttendanceFestival.setFestivalData(new Date());
		festivalList.add(funAttendanceFestival);
		ErpFunAttendanceFestival funAttendanceFestival2 = new ErpFunAttendanceFestival();
		funAttendanceFestival2.setAttClassId(2);
		funAttendanceFestival2.setFestivalData(new Date());
		festivalList.add(funAttendanceFestival2);
		erpAttendanceScopeParam.setAttendanceFestivalList(JSONObject.toJSONString(festivalList));

		List<ErpFunAttendanceGroupBiz> groupBizList = new ArrayList<>();

//		ErpFunAttendanceGroupBiz erpFunAttendanceGroupBiz1 = new ErpFunAttendanceGroupBiz();
//		erpFunAttendanceGroupBiz1.setBizId(12001);
//		erpFunAttendanceGroupBiz1.setChooseType(1);
//		groupBizList.add(erpFunAttendanceGroupBiz1);
		ErpFunAttendanceGroupBiz erpFunAttendanceGroupBiz2 = new ErpFunAttendanceGroupBiz();
		erpFunAttendanceGroupBiz2.setBizId(2003);
		erpFunAttendanceGroupBiz2.setChooseType(3);
		groupBizList.add(erpFunAttendanceGroupBiz2);
		erpAttendanceScopeParam.setGroupBizList(JSONObject.toJSONString(groupBizList));



		List<ErpFunAttendanceUserClassDetail> userClassDetails = new ArrayList<>();

		ErpFunAttendanceUserClassDetail erpFunAttendanceUserClassDetail = new ErpFunAttendanceUserClassDetail();
		erpFunAttendanceUserClassDetail.setCompId(12001);
		erpFunAttendanceUserClassDetail.setRegId(40143);
		erpFunAttendanceUserClassDetail.setDeptId(12001);
		erpFunAttendanceUserClassDetail.setUserId(20289880);
		erpFunAttendanceUserClassDetail.setAreaId(12001);
		erpFunAttendanceUserClassDetail.setAttClassId(2);
		erpFunAttendanceUserClassDetail.setAttTime(new Date());
		userClassDetails.add(erpFunAttendanceUserClassDetail);
		erpAttendanceScopeParam.setAttendanceScheduleList(JSONObject.toJSONString(userClassDetails));

		System.out.println(postNewErp(erpAttendanceScopeParam,"/managerCenter/attendanceGroupModule/addEditAttendanceGroup"));
	}

	/**
	 * @Title 排班
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void addEditAttendanceSchduleGroup() throws Exception{

		ErpFunAttendanceGroupParam erpAttendanceScopeParam = new ErpFunAttendanceGroupParam();
//		erpAttendanceScopeParam.setId(3);
		erpAttendanceScopeParam.setClassType((byte) 2);
		erpAttendanceScopeParam.setGroupName("终极版排班制考勤组");
		erpAttendanceScopeParam.setIsUpdateUser(1);


		List<ErpFunAttendanceGroupBiz> groupBizList = new ArrayList<>();
		ErpFunAttendanceGroupBiz erpFunAttendanceGroupBiz2 = new ErpFunAttendanceGroupBiz();
		erpFunAttendanceGroupBiz2.setBizId(2003);
		erpFunAttendanceGroupBiz2.setChooseType(3);
		groupBizList.add(erpFunAttendanceGroupBiz2);
		erpAttendanceScopeParam.setGroupBizList(JSONObject.toJSONString(groupBizList));

		List<ErpFunAttendanceUserClassDetail> userClassDetails = new ArrayList<>();
		ErpFunAttendanceUserClassDetail erpFunAttendanceUserClassDetail = new ErpFunAttendanceUserClassDetail();
		erpFunAttendanceUserClassDetail.setCompId(12001);
		erpFunAttendanceUserClassDetail.setRegId(40143);
		erpFunAttendanceUserClassDetail.setDeptId(12001);
		erpFunAttendanceUserClassDetail.setUserId(20289880);
		erpFunAttendanceUserClassDetail.setAreaId(12001);
		erpFunAttendanceUserClassDetail.setAttClassId(2);
		erpFunAttendanceUserClassDetail.setAttTime(new Date());
		userClassDetails.add(erpFunAttendanceUserClassDetail);
		erpAttendanceScopeParam.setAttendanceScheduleList(JSONObject.toJSONString(userClassDetails));

		System.out.println(postNewErp(erpAttendanceScopeParam,"/managerCenter/attendanceGroupModule/addEditAttendanceGroup"));
	}

	/**
	 * @Title 考勤配置
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getAttendanceSettingList() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceSettingModule/getAttendanceSettingList"));
	}

	/**
	 * @Title 修改保存考勤配置
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void saveSettingList() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setId(1);
		attendanceModuleParam.setRuleValue("2222222");
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceSettingModule/saveSetting"));
	}
	
	/**
	 * @Title 查询是否被应用
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void getAttendanceClassApplyCount() throws Exception{
		ErpAttendanceModuleParam attendanceModuleParam = new ErpAttendanceModuleParam();
		attendanceModuleParam.setId(1);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/attendanceClassModule/getAttendanceClassApplyCount"));
	}

	/**
	 * @Title 查询是否被应用
	 * @Author lcb
	 * @Date 2017/11/22
	 **/
	@Test
	public void updateMonthCountDayAttendance() throws Exception{
		ChangeAttendanceResultParam p = new ChangeAttendanceResultParam();
		p.setAttOughtDate("2018-03-15");
		p.setAttResult((byte) 4);
		p.setOldAttRecordStatus((byte) 8);
		p.setEditRemark("x");
		p.setUserId(20059067);
		System.out.println(postNewErp(p,"/managerCenter/attendanceStatisticalAnalysisModule/updateMonthCountDayAttendance"));
	}
	
	@Test
	public void getOutLog() throws Exception{
//		Map<String, Object> param = new HashMap<>();
		OutLogRecordParam param = new OutLogRecordParam();
//		param.put("assessmentMonth", "2018-07");
		param.setAssessmentMonth("2018-07");
		System.out.println(postNewErp(param,"/managerCenter/attendanceSignInModule/getOutLog"));
	}



}
