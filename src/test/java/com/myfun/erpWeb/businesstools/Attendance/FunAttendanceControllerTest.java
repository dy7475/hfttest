package com.myfun.erpWeb.businesstools.Attendance;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.param.ChangeAttendanceResultParam;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateAttendanceParam;
import com.myfun.service.business.erpdb.bean.param.CreateOutLogParam;
import com.myfun.service.business.erpdb.bean.param.QueryAttendanceListParam;
import com.myfun.service.business.erpdb.bean.param.QueryOutLogParam;
import com.myfun.service.business.erpdb.bean.param.UpdateAttenceOffCountParam;

public class FunAttendanceControllerTest extends BaseTestController {
	@Before
	public void init(){
		//init("http://192.168.0.183:8001/erpWeb","http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
		//init("http://192.168.5.182:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.108:8080/hftWebService/web/api/authentication/per.do", "670452", "15982820924");
		init("http://192.168.5.159:9001/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/openLogin", "1280610", "18888866666");
	}
	/**
	 * 获取考勤列表
	 * @author 方李骥
	 * @since 2016年10月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	//{"BUILD_NAME":"A","CLIENTKEY":"ee464e6763d449472ac1b3cfa12fd636","PAGE_OFFSET":"1","PAGE_ROWS":"10","PAGE_ROW_TOTAL":"0"}
	@Test
	public void getAttendanceList() throws Exception{
		String jsonStr = "{\"startTime\":\"2016-08-01\",\"endTime\":\"2016-10-20\",\"CLIENTKEY\":\"f29ab2f871542d3a7f99343c00a0a119\",\"compId\":\"12001\",\"deptId\":\"12001\",\"SOURCE_deptId\":\"12001\",\"userId\":\"\",\"workStatus\":\"\"}";
		QueryAttendanceListParam  param = JSON.parseObject(jsonStr, QueryAttendanceListParam.class);
		param.setPageOffset(1);
		param.setPageRows(50);
		System.out.println(postNewErp(param,"staffAttendance/getAttendanceList"));
	}
	/**
	 * 打考勤
	 * @author 方李骥
	 * @since 2016年10月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void insertAttendance() throws Exception{
		String jsonStr = "{\"attLateReason\":\"dfffffffffffffffffffffffffffffffffffff\",\"attUser\":\"20124799\",\"CLIENTKEY\":\"f29ab2f871542d3a7f99343c00a0a119\",\"compId\":\"12001\",\"deptId\":\"12001\",\"lateTimeSkip\":\"1\",\"loginPassword\":\"123456\",\"onTime\":\"9:00\",\"workType\":\"1\"}";
		CreateOrUpdateAttendanceParam  param = JSON.parseObject(jsonStr, CreateOrUpdateAttendanceParam.class);
		System.out.println(postNewErp(param,"/businesstools/attendance/insertAttendance"));
	}
	/**
	 * 写外出日志
	 * @author 方李骥
	 * @since 2016年10月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test 
	public void createOutLog() throws Exception{
		String jsonStr = "{\"CLIENTKEY\":\"0bc6399552362c27496628a6c3c95b17\",\"compId\":\"12001\",\"deptId\":\"12001\",\"expectBacktime\":\"120\",\"outDesc\":\"dfffffffffffffffffffffffffffffff\",\"outUser\":\"2018\"}";
		CreateOutLogParam  param = JSON.parseObject(jsonStr, CreateOutLogParam.class);
		System.out.println(postNewErp(param,"staffAttendance/createOutLog"));
	}
	/**
	 * 外出日志列表
	 * @author 方李骥
	 * @since 2016年10月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test 
	public void getMgrOutLogList() throws Exception{
		String jsonStr = "{\"CLIENTKEY\":\"93f3b8cc818abef5d5293f75e9ead3db\",\"compId\":\"12001\",\"deptId\":\"12001\",\"orderBy\":\"OUT_TIME DESC\",\"outTime1\":\"2016-10-20\",\"outTime2\":\"2019-10-20\",\"userId\":\"\",\"grId\":\"253227\"}";
		QueryOutLogParam  param = JSON.parseObject(jsonStr, QueryOutLogParam.class);
		System.out.println(postNewErp(param,"businesstools/attendance/getMgrOutLogList"));
	}
	/**
	 * 考勤统计列表
	 * @author 方李骥
	 * @since 2016年10月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test 
	public void getMgrStatList() throws Exception{
		String jsonStr = "{\"CLIENTKEY\":\"93f3b8cc818abef5d5293f75e9ead3db\",\"compId\":\"12001\",\"deptId\":\"12001\",\"attendanceDate\":\"2017-01\"}";
		Map<String,String>  param = JSON.parseObject(jsonStr,new TypeReference<Map<String, String>>() {});
		System.out.println(postNewErp(param,"staffAttendance/getMgrStatList"));
	}
	/**
	 * 统计门店上下班人数
	 * @author 何传强
	 * @since 2017年6月16日
	 * @throws Exception
	 */
	@Test
	public void getMgrAttendanceOnAndOff() throws Exception {
		Map<String, String> paramMap=new HashMap<String,String>();
		System.out.println(postNewErp(paramMap,"/businesstools/attendance/getAttendanceOnAndOff"));
  	}
	/**
	 * 获取员工考勤列表
	 * @author 何传强
	 * @since 2017年6月16日
	 * @throws Exception
	 */
	@Test
	public void getAttendanceList1() throws Exception {
		String jsonStr = "{\"startTime\":\"2016-08-01\",\"endTime\":\"2017-06-16\","
				+ "\"CLIENTKEY\":\"622d4fe21b8f3c367c101b5e56320406\",\"compId\":\"12001\","
				+ "\"deptId\":\"12001\",\"SOURCE_deptId\":\"12001\",\"userId\":\"\",\"workStatus\":\"\"}";
		QueryAttendanceListParam  param = JSON.parseObject(jsonStr, QueryAttendanceListParam.class);
		param.setPageOffset(1);
		param.setPageRows(50);
		System.out.println(postNewErp(param,"/businesstools/attendance/getMgrAttendanceList"));
	}
	/**
	 * 获取外出登记列表
	 * @author 何传强
	 * @since 2017年6月16日
	 * @throws Exception
	 */
	@Test
	public void getMgrOutLogList1() throws Exception {
		String jsonStr="{ \"startTime\": \"2016-08-01\", \"endTime\": \"2017-06-16\", "
				+ "\"CLIENTKEY\": \"e55b0f2ba1728d39be048fd3eddc19d5\","
				+ "\"compId\": \"12001\",\"deptId\": \"12001\",\"outTime1\":\"2016-06-16 10:50:00\",\"outTime2\":\"2017-06-16 16:50:00\"}";
		QueryOutLogParam param=JSON.parseObject(jsonStr, QueryOutLogParam.class);
		param.setPageOffset(1);
		param.setPageRows(50);
		System.err.println(postNewErp(param, "/businesstools/attendance/getMgrOutLogList"));
	}
	/**
	 * 新增外出登记日志
	 * @author 何传强
	 * @since 2017年6月16日
	 * @throws Exception
	 */
	@Test
	public void createOutLog1() throws Exception {
		CreateOutLogParam param=new CreateOutLogParam();
		param.setCityId(12001);
		param.setCompId(12001);
		param.setCurrentDeptId(12001);
		param.setExpectBackTime(121);
		param.setOutDesc("为振兴中华");
		System.err.println(postNewErp(param, "/businesstools/attendance/createOutLog"));
	}
	
	/**
	 * 
	 * @author 熊刚
	 * @since 2017年9月26日
	 * @throws Exception
	 */
	@Test
	public void updateMgrAtt() throws Exception {
		UpdateAttenceOffCountParam param=new UpdateAttenceOffCountParam();
		param.setAttDate("2017-09-19");
		param.setAttReason("说明");
		param.setAttStatus("5");
		param.setFineTime("2017-09-19");
		param.setFlag("up");
		param.setSourceDeptId(12001);
		param.setSourceUserId(20321078);
		param.setSourceUserName("熊刚");
		param.setSourceWorkStatus("5");
		param.setTargetWorkStatus("5");
		param.setUpdateUser("20321078");
		param.setWorkType("1");
		param.setWorkDetailType("5");
		System.err.println(postNewErp(param, "/businesstools/attendance/updateMgrAtt"));
	}
	/**
	 * 新增外出登记日志
	 * @author 何传强
	 * @since 2017年6月16日
	 * @throws Exception
	 */
	@Test
	public void getAttendanceRecordDetailList() throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countType", 0);//0日统计 1月统计
		param.put("searchRange", "COMP");//0日统计 1月统计
		param.put("searchRangeId", "");//0日统计 1月统计
		System.err.println(postNewErp(param, "/managerCenter/attendanceStatisticalAnalysisModule/attendanceStatisticalAnalysisModule/getAttendanceRecordDetailList"));
	}
	/**
	 * 新增外出登记日志
	 * @author 何传强
	 * @since 2017年6月16日
	 * @throws Exception
	 */
	@Test
	public void changeAttendanceResult() throws Exception {
		ChangeAttendanceResultParam param = new ChangeAttendanceResultParam();
		param.setAttAttribute(Byte.valueOf("1"));
		param.setAttClassClocktime("09:00-18:00");
		param.setAttClassId(1);
		param.setAttNum(Byte.valueOf("3"));
		param.setAttSumCount(Byte.valueOf("3"));
		param.setAttClassName("我总算学会了如何去爱，可惜你早已消失在人海");
		param.setAttGrId(1);
		param.setAttOughtDate("2017-12-01");
		param.setAttResult(Byte.valueOf("4"));
		param.setUserId(2001);
		System.err.println(postNewErp(param, "/managerCenter/attendanceStatisticalAnalysisModule/changeAttendanceResult"));
	}
	/**
	 * 新增外出登记日志
	 * @author 何传强
	 * @since 2017年6月16日
	 * @throws Exception
	 */
	@Test
	public void getAttendanceRecordDetailList1() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("attDate", "2018-08");
		param.put("attResult", "4");
		param.put("isOutAtt", "1");
		param.put("userId", "20322814");
		System.err.println(postNewErp(param, "/managerCenter/attendanceStatisticalAnalysisModule/getAttendanceRecordDetailList"));
	}
	
	/**
	 * 获取权限角色列表
	 * @author 胡坤
	 * @since 2018年4月17日
	 * @throws Exception
	 */
	@Test
	public void getMgrRoleList() throws Exception {
		Map<String,Object> param=new HashMap<>();
		System.err.println(postNewErp(param, "/businesstools/attendance/getMgrRoleList"));
	}
	
	/**
	 * 获取用户列表
	 * @author 胡坤
	 * @since 2018年4月17日
	 * @throws Exception
	 */
	@Test
	public void getMgrUserList() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("deptId",882711);
		System.err.println(postNewErp(param, "/businesstools/attendance/getMgrUserList"));
	}
	

}
