package com.myfun.erpWeb.managecenter.transaction;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.transaction.param.*;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DealBuinessControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.5.175:8080/erpWeb", "http://192.168.5.175:8090/hftWebService/web/api/authentication/per.do", "670087", "15824205070");
//		init("http://192.168.200.168:9007/erpWeb", "http://gray.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280649", "18311111120");
		init("http://localhost:8081/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "15982083618");
	}


	@Test
	public void financAuditList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("pfActual",0);
//		param.put("endTime","2019-09");
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/financAuditList"));
	}
	@Test
	public void signStatisticsList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("statisticsType","2");
		param.put("startTime","2019-09");
		param.put("endTime","2019-09");
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/signStatisticsList"));
	}
	@Test
	public void getMatchNotAllocatedDealCodeList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("dealType",101);
		//param.put("contractNo","");
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/getMatchNotAllocatedDealCodeList"));
	}

	@Test
	public void updateProcessFinancStatus() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("auditStatus",1);
		param.put("dealId",7080);
		param.put("pfActual",0);
		param.put("pfIds",10114);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/updateProcessFinancStatus"));
	}

	@Test
	public void delDealProfit() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("profitId",9662);
		param.put("dealId",7080);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/delDealProfit"));
	}

	/**
	 * 审核税费
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/16
	 */
	@Test
	public void updateDealTaxesAuditStatus() throws Exception {
		/*
		* {"CLIENTKEY":"5cbe2c72c7e76ffde38ba322fd50fc87","DEAL_ID":"7078","PAY_TYPE":"1","TAXES_AUDIT_STATUS":"1"}
		* */
		Map<String, Object> param = new HashMap<>();
		param.put("dealId",7078);
		param.put("payType",1);
		param.put("taxesAuditStatus",1);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/updateDealTaxesAuditStatus"));
	}

	/**
	 *
	 * @param:
	 * @return:
	 * @auther: 胡坤
	 * @date: 2018/9/5
	 */
	@Test
	public void getMgrOutDealList() throws Exception {
		/*
		* {"DATE_RANGE":"2018-09-01~2018-09-05","DEAL_TYPE":"102","PAGE_ROW_TOTAL":"0"}
		* */
		Map<String, Object> param = new HashMap<>();
		param.put("dateRange","2018-09-01~2018-09-05");
		param.put("dealType",101);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/getMgrOutDealList"));
	}

	@Test
	public void getContractDealList() throws Exception {
		/*
		 * {"DATE_RANGE":"2018-09-01~2018-09-05","DEAL_TYPE":"102","PAGE_ROW_TOTAL":"0"}
		 * {"CLIENTKEY":"b5f4a488f0076abe3399f35b597edc18","caseType":"0","compNo":"","dateRange":"2018-09-01~2018-09-08","dealType":"101","houseCustType":"0","pageOffset":"1","pageRowTotal":"0","pageRows":"50","userId":""}
		 * */
		Map<String, Object> param = new HashMap<>();
		param.put("dateRange","2018-09-01~2018-09-08");
		param.put("houseCustType",0);
		param.put("dealType",101);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/getContractDealList"));
	}

	/**
	 * @auther: wangchun
	 * @date: 2018/11/23
	 * @throws Exception
	 */
	@Test
	public void settlementDeal() throws Exception {
		SettlementDealParam param = new SettlementDealParam();
		param.setDealId(52136);
		param.setDealVerifyTime("2019-11-08");

		System.out.println(postNewErp(param,"managerCenter/transaction/deal/settlementDeal"));
	}


	/**
	 * @Title 变更流程
	 * @Author lcb
	 * @Time 2019/6/24 10:37
	 * @Desc
	 **/
	@Test
	public void updateRuntimeStepSeq() throws Exception {
		UpdateRuntimeStepSeqParam p1 = new UpdateRuntimeStepSeqParam();
		p1.setRunStepId(14162);
		p1.setStepSeq(1);

		UpdateRuntimeStepSeqParam p2 = new UpdateRuntimeStepSeqParam();
		p2.setRunStepId(14161);
		p2.setStepSeq(2);
		List<UpdateRuntimeStepSeqParam> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		UpdateRuntimeStepParam param = new UpdateRuntimeStepParam();
		param.setStepList(list);
		param.setDealId(10034);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateRuntimeStepSeq"));
	}

	/**
	 * @Title 变更流程
	 * @Author lcb
	 * @Time 2019/6/24 10:37
	 * @Desc
	 **/
	@Test
	public void insertRunTimeStep() throws Exception {
		InsertRunTimeStepParam param = new InsertRunTimeStepParam();
		param.setDealId(10034);
		param.setStepId(3706);
		param.setStepSeq(1);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/insertRunTimeStep"));
	}

	@Test
	public void getMgrAllStepModelList() throws Exception {
		WarrantStepParam param = new WarrantStepParam();
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getMgrAllStepModelList"));
	}
//	号段分配
	@Test
	public  void getNotUseBillCodeNoListTest() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setByte("billWay",(byte)1);
		param.setByte("billType",(byte)1);
		param.setString("dealId","52148");
		System.out.println(postNewErp(param,"managerCenter/funBillModule/getNotUseBillCodeNoList"));
	}
}
