package com.myfun.erpWeb.managecenter.employeeFiles;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.ErpAttendanceStatisticalAnalysisParam;
import com.myfun.repository.erpdb.param.ErpFunEmployeeLogParam;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFilesControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.200.197:9002/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280288", "15982083618");
	}

	/**
	 * 获取员工档案列表
	 * @author 熊刚
	 * @since 2017年11月6日
	 * @throws Exception
	 */
	@Test
	public void getEmployeeFilesList() throws Exception {
		BaseMapParam param = new BaseMapParam();
		//param.setInteger("userStatus", 1);
		param.setString("serchRange", "COMP");
		param.setString("serchRangeId", "12001");
//		param.setString("startTime", "2010-08-01");
//		param.setString("endTime", "2016-10-01");
		param.setInteger("inOrOut", 2);
		param.setInteger("userFlag",3);
		//param.setString("matchStr", "四川");
		System.out.println(postNewErp(param,"/manageCenter/employeeFiles/getEmployeeFilesList"));

	}

	/**
	 * 获取员工档案详情
	 * @author 熊刚
	 * @since 2017年11月6日
	 * @throws Exception
	 */
	@Test
	public void getEmployeeInfo() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("userId",10114097);
		System.out.println(postNewErp(param,"/manageCenter/employeeFiles/getEmployeeInfo"));
	}

	/**
	 * 获取员工档案附件
	 * @author 熊刚
	 * @since 2017年11月6日
	 * @throws Exception
	 */
	@Test
	public void getEmployeeFile() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("employeeDocId",5 );//
		System.out.println(postNewErp(param,"/manageCenter/employeeFiles/getEmployeeFile"));
	}

	/**
	 * 获取员工动态
	 * @author 熊刚
	 * @since 2017年11月6日
	 * @throws Exception
	 */
	@Test
	public void getEnclosureLogs() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("id",241 );//
		System.out.println(postNewErp(param,"/manageCenter/employeeFiles/getEnclosureLogs"));
	}
	/**
	 * 获取改变
	 * @author 熊刚
	 * @since 2017年11月6日
	 * @throws ExceptionEPT门店 REG片区 AREA 大区 COMP 公司**//*
	    private String searchRange;
	 */
        @Test
        public void getChangeEnclosureLogs() throws Exception {
            BaseMapParam param = new BaseMapParam();
            param.setInteger("systemSettingLogsId",18369 );//
            System.out.println(postNewErp(param,"/manageCenter/employeeFiles/getChangeEnclosureLogs"));
        }
        /**
         * 获取改变
         * @author 熊刚
         * @since 2017年11月6日
         * @throws Exception
         */
        @Test
        public void getAttendanceStatisticlAnalysis() throws Exception {
            /** 0代表每日考勤 1代表每月考勤**//*
	    private Byte countType;
	    *//** 开始时间 **//*
	    private String startTime;
	    *//** 结束时间 **//*
	    private String endTime;
	    *//** 查询范围 USER员工 GROUP 分组 D
	    *//** 查询范围ID**//*
	    private Integer searchRangeId;
	    *//** 是否显示异常情况 1 显示 2不显示**//*
	    private Byte showAbnormalSituation;*/
		ErpAttendanceStatisticalAnalysisParam param = new ErpAttendanceStatisticalAnalysisParam();
		param.setCountType(Byte.valueOf("1"));
		param.setStartTime("2017-11-01");
		param.setEndTime("2017-11-30");
		param.setSearchRange("COMP");
		System.out.println(postNewErp(param,"/managerCenter/attendanceStatisticalAnalysisModule/getAttendanceStatisticlAnalysis"));
	}




	/**
	 * title ：删除员工档案
	 * athor：lcb
	 * date  : 2017/11/6
	 */
	@Test
	public void delEmployeeFile() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("fileIds", "182");
		param.put("refrenceUserId", "20321697");
		System.out.println(postNewErp(param,"/manageCenter/employeeFiles/delEmployeeFile"));

	}
	
	/**
	 * title ：员工异动记录
	 * athor：zhuke
	 * date  : 2017/12/28
	 */
	@Test
	public void getEmployeeLogList() throws Exception {
		ErpFunEmployeeLogParam param = new ErpFunEmployeeLogParam();
		param.setPageRows(50);
		param.setPageOffset(1);
		param.setEndTime("2018-01-18 23:59:59");
		param.setStartTime("2018-01-17 00:00:00");
		System.out.println(postNewErp(param, "/manageCenter/employeeFiles/getEmployeeLogList"));
	}
	@Test
	public void getPersonalModifyRecordList() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 241);
		System.out.println(postNewErp(param, "/manageCenter/employeeFiles/getPersonalModifyRecordList"));
	}
}
