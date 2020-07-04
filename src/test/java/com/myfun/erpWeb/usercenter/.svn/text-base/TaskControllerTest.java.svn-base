package com.myfun.erpWeb.usercenter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpUpdateHouseBuildParam;

public class TaskControllerTest  extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.175:8080/erpWeb", "http://192.168.0.175:80/hftWebService/web/api/authentication/per.do", "506504", "15114014557");
//		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.0.249:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.0.179:8001/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
//		init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
		init("http://192.168.200.155:8068/erpWeb", "http://testapp.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281304", "15100009999");
	}
	
	/**
	 * 获取审核任务列表
	 * @author 臧铁
	 * @param param  time 时间（全部=空 一周=2 一月=3 一季=4）	taskStatus   未审=1 已审=3 失效=4 全部=空
	 * @param param  deptId  部门ID	caseType   出售=1 出租=2 求购=3 求租=4 出售合同=101 出租合同=102
	 * @param param  trackType  跟进类型 	caseNO   任务编号
	 * @param param  userId  员工ID	userType   申请方还是接收方0=申请1=接收
	 * @since 2017年7月5日
	 * @throws Exception
	 */
	@Test
	public void getTaskList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("time", "4");
		pMap.put("taskStatus", "1");
		pMap.put("deptId", "12001");
		pMap.put("caseType", "1");
		pMap.put("trackType", "KEY");
//		pMap.put("caseNO", "");
//		pMap.put("userId", "20059104");
		pMap.put("userType", "1");
		System.out.println(postNewErp(pMap,"/usercenter/getTaskList"));
	}
	
	/**
	 * 获取提醒任务列表
	 * @author 臧铁
	 * @since 2017年7月5日
	 * @throws Exception
	 */
	@Test
	public void getMyCreateWarmList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("time", "4");
//		pMap.put("areaId", "12001");
//		pMap.put("regId", "12001");
//		pMap.put("deptId", "12001");
//		pMap.put("grId", "12001");
//		pMap.put("userId", "12001");
		pMap.put("caseType", "1,2");
//		pMap.put("caseNo", "23123123");
//		pMap.put("isRead", "1");
		pMap.put("remindType", "1");
//		pMap.put("keyword", "2121");
		System.out.println(postNewErp(pMap,"/usercenter/getMyCreateWarmList"));
	}
	
	/**
	 * 获取提醒任务列表
	 * @author 臧铁
	 * @since 2017年7月5日
	 * @throws Exception
	 */
	@Test
	public void getWarmMyTaskList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("time", "4");
//		pMap.put("areaId", "12001");
//		pMap.put("regId", "12001");
//		pMap.put("deptId", "12001");
//		pMap.put("grId", "12001");
//		pMap.put("userId", "12001");
		pMap.put("caseType", "1,2");
//		pMap.put("caseNo", "23123123");
//		pMap.put("isRead", "1");
		pMap.put("remindType", "1");
//		pMap.put("keyword", "2121");
		System.out.println(postNewErp(pMap,"/usercenter/getWarmMyTaskList"));
	}
	
	/**
	 * 获取提醒任务列表
	 * @author 张宏利
	 * @since 2017年12月12日
	 * @throws Exception
	 */
	@Test
	public void getWarmTaskList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("time", "4");
		pMap.put("areaId", "12001");
//		pMap.put("regId", "12001");
//		pMap.put("deptId", "12001");
//		pMap.put("grId", "12001");
//		pMap.put("userId", "12001");
		pMap.put("caseType", "1,2");
//		pMap.put("caseNo", "23123123");
//		pMap.put("isRead", "1");
		pMap.put("remindType", "1");
//		pMap.put("keyword", "2121");
		System.out.println(postNewErp(pMap,"/usercenter/getWarmTaskList"));
	}

	/**
	 * 修改楼盘房源的所属楼盘
	 * @author 
	 * @since 2017年8月23日
	 * @return
	 */
	@Test
	public void updateHouseBuild() throws Exception{
		ErpUpdateHouseBuildParam param = new ErpUpdateHouseBuildParam();
		param.setCaseId(6635662);// 房源ID
		param.setCaseNo("CSCD1706211248707");// 房源编号
		param.setCaseType(1);// 房源类型
		param.setBuildId(1178);// 需要更新成的楼盘ID
		param.setBuildName("芳草地");// 需要更新成的楼盘名称
		param.setReasons("改来试试");// 修改原因
		param.setCaseDeptId(12001);// 房源门店ID
		param.setCaseUserId(20319440);// 房源用户ID
		param.setCaseStatus(1);// 房源状态
		System.out.println(postNewErp(param,"/house/updateHouseBuild"));
	}

	@Test
	public void updateTaskWarmState() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("operType","BAT_TASK");
		pMap.put("taskIds","32598627");
		System.out.println(postNewErp(pMap,"/usercenter/updateTaskWarmState"));
	}

	/**
	 * 获取任务数量
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	@Test
	public void getTaskCount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/usercenter/getTaskCount"));
	}
}


