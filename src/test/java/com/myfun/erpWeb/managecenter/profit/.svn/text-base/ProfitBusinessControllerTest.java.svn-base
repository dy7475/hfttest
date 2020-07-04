package com.myfun.erpWeb.managecenter.profit;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.profit.param.*;
import com.myfun.repository.erpdb.param.AuditConfigParam;
import com.myfun.repository.erpdb.param.AuditParam;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.utils.DateUtil;
import org.junit.Before;
import org.junit.Test;
import scala.annotation.meta.param;

import java.math.BigDecimal;
import java.util.*;

public class ProfitBusinessControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.137:8080/erpWeb", "http://192.168.0.249:80/hftWebService/web/api/authentication/per.do", "670087", "17180493881");
//		init("http://192.168.5.173:8080/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "506357", "15982667547");
//		init("http://localhost:9001/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "626518", "18202864324");
//		init("http://192.168.200.197:9007/erpWeb", "http://gray.51vfang.cn/hftWebService/web/api/authentication/per.do", "626518", "18202864324");
		init("http://192.168.200.169:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/openLogin", "1281399", "18811110331");
//		initOnlyAddr("http://192.168.5.175:9001/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/openLogin", "1279752", "18782920347");
		
//		super.setClientKey("37a69964fb1bb7059550714dde024c42");
	}
	
	@Test
	public void getPersonProfit() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userId", 20163849);
		System.out.println(postNewErp(pMap,"profitDistribution/getPersonProfit"));
	}
	@Test
	public void getRrofitList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", 892130);
		System.out.println(postNewErp(pMap,"/profit/getRrofitList"));
	}
	
	@Test
	public void appUpdateWorkCountTargetDetail() throws Exception{
		AppFunWorkCountTargetParam param = new AppFunWorkCountTargetParam();
		AppFunWorkCountTargetSubParam subParam = new AppFunWorkCountTargetSubParam();
		subParam.setBzwtCount(1);
		subParam.setCustomerAdd(1);
		param.setUserPosition("DEPUTY_MANAGER");
		param.setDayTargetList(subParam);
		System.out.println(postNewErp(param,"/profit/appUpdateWorkCountTargetDetail"));
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/17
	 * @tag 获取业绩类别列表
	 */
	@Test
	public void getFunPerformanceTypeList() throws Exception {
		Map<String, String> param = new HashMap<>();
		System.err.println(postNewErp(param,"profit/getFunPerformanceTypeList"));
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/17
	 * @tag 获取业绩目标列表
	 */
	@Test
	public void getMgrProfiTarget() throws Exception {
		MgrProfiTargetParam param = new MgrProfiTargetParam();
//		param.put("profitType","4");
//		param.put("time","2018-04-01");
		param.setDefId(-2);
		param.setOrganizationId(0);
		System.err.println(postNewErp(param,"profit/getMgrProfiTarget"));
	}

	/**
	* @author 邓永洪
	* @since 2018/4/18
	* @tag 业绩信息-获取某个人的业绩详细信息
	*/
	@Test
	public void getProfitDetailInfoList() throws Exception {
		Map<String, String> param = new HashMap<>();
		param.put("date1","2018-04");
		param.put("date2","2018-04");
		param.put("deptId","12001");
		param.put("userId","20059130");
		System.err.println(postNewErp(param,"profit/getProfitDetailInfoList"));
	}

	/**
	* @author 邓永洪
	* @since 2018/4/18
	* @tag 获取业绩信息
	*/
	@Test
	public void getProfitBaseInfoList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("date1","2018-04");
		param.put("date2","2018-04");
		param.put("deptId","12001");
		//param.put("userId","20059130");
		param.put("pageOffset",1);
		param.put("pageRows",40);
		param.put("sourceDeptId",12001);

		System.err.println(postNewErp(param,"profit/getProfitBaseInfoList"));
	}

	@Test
	public void insertMgrProfiTarget() throws Exception {
		InsertProfitTargetListParam  param = new InsertProfitTargetListParam();
		param.setTargetDate("2018-11-01");
		List<MgrProfiTargetParamForInsert> targetList = new ArrayList<>();
		MgrProfiTargetParamForInsert  target=new MgrProfiTargetParamForInsert();
//		target.setAreaId(12001);
//		target.setRegId(40143);
//		target.setDeptId(892924);
//		target.setProfitType((byte)2);
		target.setTargetProfit("20");
		target.setOrganizationId(205289);
		target.setDefId(407);
		targetList.add(target);
		param.setTargetList(targetList);
		System.err.println(postNewErp(param,"profit/insertMgrProfiTarget"));
	}
	
	@Test
	public void getWorkCountTargetDetailTest() throws Exception {
		AppFunWorkCountTargetDetailParam param = new AppFunWorkCountTargetDetailParam();
		param.setRangeId(892130);
		param.setRangeType(Byte.valueOf("4"));
//		param.setUserPosition("GENERAL_MANAGER");
		System.out.println(postNewErp(param,"/profit/getWorkCountTargetDetail"));
	}
	
	@Test
	public void getAppFunPerformanceTypeList() throws Exception {
		System.out.println(postNewErp(null,"/profit/getAppFunPerformanceTypeList"));
	}

	@Test
	public void insertMgrProfi() throws Exception {
		//profitJson":[{"agreementNo":"","areaId":"19556","dealType":"","deptId":"893552","performanceId":"42342","performanceName":"����","performanceType":"2","profitMoney":"16050","profitProportion":"50","profitType":"0","receivableMoney":"6150","regId":"46816","remark":"","roleId":"","roleName":"���ܾ���","userId":"20329907"},{"agreementNo":"","areaId":"19573","dealType":"","deptId":"893558","performanceId":"42345","performanceName":"��Դά����","performanceType":"2","profitMoney":"16050","profitProportion":"50","profitType":"0","receivableMoney":"6150","regId":"46833","remark":"","roleId":"","roleName":"�ͷ�רԱ","userId":"20330097"}],"realTotalprice":"250","secondhandNeedPerformance":"12300","secondhandRealPerformance":"32100","signDate":"2019-07-01","totalNeedPerformance":"12300","totalRealPerformance":"32100"}
		InsertDealInfoParam param = new InsertDealInfoParam();
		param.setPfTime("2019-07-17");
		param.setArea(new BigDecimal(243));
		param.setBuildId(2017413);
		param.setBuildName("cesssss小区");
		param.setContractNo("aa177777");
		param.setCustDeptId(893552);
		param.setCustPlate((byte) 2);
		param.setCustUserUid(20329900);
		param.setDealVerifyTime("2019-07-01");
		param.setFitment((byte) 3);
		param.setHouseDeptId(893552);
		param.setDealType((byte) 101);
		param.setDealSellStyle((byte) 0);
		param.setDealBuyStyle((byte) 0);
		param.setDealCustomerNo("QGCD1905131632098");
		param.setDealCustomerId(2273077);
		param.setDealHouseId(6643193);
		param.setDealHouseNo("CSCD1905141944103");
		param.setHousePlate((byte) 2);
		param.setHouseUseage((byte) 1);
		param.setHouseUserUid(20329900);
		param.setHouseaddress("百寿巷小区30楼222平米");
		param.setTotalRealPerformance(new BigDecimal(2000));
		param.setTotalNeedPerformance(new BigDecimal(2000));
		param.setSignDate(DateUtil.DateToString(new Date()));
		param.setSecondhandNeedPerformance(new BigDecimal(2000));
		param.setSecondhandRealPerformance(new BigDecimal(2000));
		param.setRealTotalprice(new BigDecimal(222));

		param.setSignUserId(20322125);
		param.setSignUserName("李成兵");
		param.setSignUserDeptId(892130);
		param.setSignUserDeptName("门店");

		List<ErpFunProfit> list = new ArrayList<>();
		ErpFunProfit profit1 = new ErpFunProfit();
		profit1.setDeptId(893552);
		profit1.setPerformanceId(42342);
		profit1.setPerformanceName("楼盘责任人");
		profit1.setPerformanceType((byte) 2);
		profit1.setProfitMoney(new BigDecimal(16050));
		profit1.setProfitProportion(new BigDecimal(50));
		profit1.setProfitType((byte) 0);
		profit1.setReceivableMoney(new BigDecimal(1000));
		profit1.setRegId(45363);
		profit1.setRoleName("总经理");
		profit1.setUserId(20322125);
		list.add(profit1);

		ErpFunProfit profit2 = new ErpFunProfit();
		profit2.setDeptId(893558);
		profit2.setPerformanceId(42342);
		profit2.setPerformanceName("楼盘责任人");
		profit2.setPerformanceType((byte) 2);
		profit2.setProfitMoney(new BigDecimal(1000));
		profit2.setProfitProportion(new BigDecimal(50));
		profit2.setProfitType((byte) 0);
		profit2.setReceivableMoney(new BigDecimal(1000));
		profit2.setRegId(45363);
		profit2.setRoleName("总经理");
		profit2.setUserId(20330190);
		list.add(profit2);

		param.setProfitJson(JSON.toJSONString(list));
		System.out.println(postNewErp(param,"/profit/insertMgrProfi"));
	}

	/**
	 * @author lcb
	 * @since 2019-07-02
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getDealAuditConfigList() throws Exception{
		AuditConfigParam param = new AuditConfigParam();
		param.setAuditResource(4);
		System.out.println(postNewErp(param,"/managerCenter/auditTask/getAuditConfigList"));
	}

	/**
	 * @author lcb
	 * @since 2019-07-02
	 * @return
	 * @throws Exception
	 */
	@Test
	public void audit() throws Exception{
		AuditParam param = new AuditParam();
		param.setId(12343);
		param.setAuditStatus((byte) 0);
		param.setTrackContent("不通过");

		System.out.println(postNewErp(param,"/managerCenter/auditTask/audit"));
	}

}
