package com.myfun.erpWeb.managecenter.financialStatements;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.financialStatements.param.PaySettlementListParam;
import com.myfun.repository.erpdb.param.ErpFunWageParam;

public class FinanceModuleControllerTest extends BaseTestController {

	@Before
	public void init(){
		init("http://192.168.5.207:8080/statistWeb/", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/per.do", "1279612", "14411114444");
	}
	
	@Test
	public void getFunWageList() throws Exception {
		PaySettlementListParam param = new PaySettlementListParam();
		/*{"CLIENTKEY":"cae6c66645947a82ac63d742d74c6fa3",
			"dateType":"SIGN_DATE",
			"endTime":"2019-03-31",
			"pageOffset":"1",
			"pageRows":"50",
			"startTime":"2019-03-01",
			"total":"0",
			"userType":"1"}*/
		param.setDateType("SIGN_DATE");
		param.setEndTime("2019-04-30");
		param.setPageOffset(1);
		param.setPageRows(3);
		param.setStartTime("2019-01-11");
		param.setTotal(0);
		param.setIsExport(1);
		param.setUserType(1);
		System.out.println(postNewErp(param, "/managecenter/financeModule/getPayAccountingList"));
	}
}
