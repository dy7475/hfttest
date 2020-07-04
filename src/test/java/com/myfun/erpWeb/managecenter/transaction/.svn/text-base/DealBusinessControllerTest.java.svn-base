package com.myfun.erpWeb.managecenter.transaction;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.param.AppMgrWarrantStepListParam;
import com.myfun.erpWeb.managecenter.transaction.param.*;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.QueryDealListParam;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class DealBusinessControllerTest extends BaseTestController {
	@Before
	public void init(){
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "670483", "18381306721");
		//init("http://192.168.5.246:9007/erpWeb", "http://gray.51vfang.cn/hftWebService/web/api/authentication/per.do", "594485", "17866666666");
//		init("http://127.0.0.1:8088/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");

		//initOnlyAddr("http://192.168.5.145:8087/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/openLogin", "8", "17800000009");
		init("http://localhost:8081/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "15528168106");
		//super.setClientKey("27d33079086a2c403bd97e7c99965614");
	}

	@Test
	public void getDealContractTaskList() throws Exception {
		DealContractParam param =new DealContractParam();
		param.setStartTime("2018-01-17");
		param.setEndTime("2018-05-14");
		param.setDateType("SIGN_DATE");
		param.setModelId(1167);
		param.setPageOffset(1);
		param.setPageRows(50);
		param.setUserType(4);
		param.setDeptId(12001);
		//param.setUserId(10086823);
		param.setStepName("签约收定金");
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getDealContractTaskList"));
	}

	@Test
	public void insertMgrStepModelToPro() throws Exception {
		InsertMgrStepModelParam param =new InsertMgrStepModelParam();
		param.setModelId(2377);
		param.setStepSeq((byte)4);
		param.setStepIds("4971,4972");
		param.setCancelStepIds("4949,4951");
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/insertMgrStepModelToPro"));
	}

	@Test
	public void getDealContractTaskListOfTransact() throws Exception {
		/*
		* {"CLIENTKEY":"034c9a4ea728642bae004aeab191da0b","DATE_TYPE":"SIGN_DATE","END_TIME":"2018-06-28","INTELLIGENT_SEARCH":"","MODEL_ID":"","PAGE_OFFSET":"1","PAGE_ROWS":"50","START_TIME":"2017-06-01","STATUS":"1","STEP_NAME":"","TOTAL":"0","USER_ID":"","USER_TYPE":"1"}
		* */
		Map<String,Object> param =new HashMap<>();
		param.put("userType",1);
		param.put("dateType","SIGN_DATE");
		param.put("intelligentSearch","");
		param.put("endTime","2018-06-28");
		param.put("startTime","2017-06-01");
		param.put("status",1);

		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getDealContractTaskListOfTransact"));
	}


	@Test
	public void updateMgrProStepSortTest() throws Exception {
		InsertMgrStepModelParam param =new InsertMgrStepModelParam();
		param.setModelId(3193);
		param.setStepIds("10025,10026");
		param.setConditionStepIds("10025,10026");
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateMgrProStepSort"));
	}

	@Test
	public void createProcessModel() throws Exception {
		CreateProcessModelParam param = new CreateProcessModelParam();
		param.setProName("测试");
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/createProcessModel"));
	}
	
	@Test
	public void getAppProcessModelList() throws Exception {
		System.out.println(postNewErp(null,"managerCenter/transaction/deal/getProcessModelList"));
	}
	
	@Test
	public void getAppMgrWarrantStepList() throws Exception {
		AppMgrWarrantStepListParam param = new AppMgrWarrantStepListParam();
		param.setDealId(49341);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getAppMgrWarrantStepList"));
	}

	@Test
	public void getMgrWarrantStepListInMobile() throws Exception {
		WarrantStepParam param = new WarrantStepParam();
		param.setDealIds("88,95,211,9396");
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getMgrWarrantStepListInMobile"));
	}

//	erp流程步凑是否被选中
	@Test
	public void geterpMgrWarrantStepList() throws Exception {
		AppMgrWarrantStepListParam param = new AppMgrWarrantStepListParam();
		param.setDealId(52136);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getMgrWarrantStepList"));
	}
	//	掌通流程步凑是否被选中
	@Test
	public void getMgrWarrantStepList() throws Exception {
		AppMgrWarrantStepListParam param = new AppMgrWarrantStepListParam();
		param.setDealId(52136);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getAppMgrWarrantStepList"));
	}
	@Test
	public void updateMgrWarrantStepData() throws Exception {
		UpdateMgrWarrantStepDataParam param = new UpdateMgrWarrantStepDataParam();
		param.setDealId(10409);
		param.setFlowcontent("AAA");
		param.setReminderId(10107444);
		param.setReminderName("孟鹭CC");
		param.setRunstepId(14693);
		param.setRunstepName("出新证");
		param.setRunstepStatus((byte)1);
		param.setTimelimitdate("2019-07-12");
		param.setUpdateTime("2019-03-12");
		param.setUpdateUser(20329868);
		param.setUpdateUsername("李国印123");
		param.setWarmContent("BBB");
		param.setWarmFlag((byte)1);
		param.setWarnType((byte)1);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateMgrWarrantStepData"));
	}

	@Test
	public void dynamicInsertProcessStep() throws Exception {
		DynamicInsertProcessStepParam param = new DynamicInsertProcessStepParam();
		param.setDealId(49341);
		param.setExecutor(20059419);
		param.setExecutorName("静娴");
		param.setFlowcontent("12321321");
		param.setReminderId(20066390);
		param.setReminderName("大圆");
		param.setStepName("签约收定金");
		param.setStepSeq(1);
		param.setTimelimitdate("2019-03-21");
		param.setUpdateTime("2019-03-20");
		param.setUpdateUser(20059419);
		param.setUpdateUsername("静娴");
		param.setWarmContent("132dfdfsdfs");
		param.setWarmFlag((byte)1);
		param.setWarnTime("2019-03-14");
		param.setWarnType((byte)1);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/dynamicInsertProcessStep"));
	}

	@Test
	public void getAppMgrAllStepModelList() throws Exception {
		System.out.println(postNewErp(null,"managerCenter/transaction/deal/getAppMgrAllStepModelList"));
	}
	
	@Test
	public void getAppDealProfitList() throws Exception {
		AppDealProfitListParam appDealProfitListParam = new AppDealProfitListParam();
		appDealProfitListParam.setDealId(49341);
		System.out.println(postNewErp(appDealProfitListParam,"managerCenter/transaction/deal/getAppDealProfitList"));
	}
	
	@Test
	public void getAppDealContractTaskList() throws Exception {
		DealContractParam dealContractParam = new DealContractParam();
		dealContractParam.setDateType("SIGN_DATE");
//		dealContractParam.setDate(4);
		dealContractParam.setStartTime("2018-02-12 00:00:00");
		dealContractParam.setEndTime("2019-03-17 00:00:00");
		dealContractParam.setUserType(1);
		dealContractParam.setProcessStatus(2);
		dealContractParam.setPageOffset(1);
		dealContractParam.setPageRows(20);
		System.out.println(postNewErp(dealContractParam,"managerCenter/transaction/deal/getAppDealContractTaskList"));
	}

	@Test
	public void saveBillPhotoInMobileTest() throws Exception {
		BillPhotoParam param = new BillPhotoParam();
		param.setDealId(9396);
		param.setBillNo("AD58");
		param.setPhotoUrl("oss/dev/tmp/2019/03/12/aa53c58b0f624e62bc6dc2649aab7db1.jpg");
		param.setFinancId(11275);
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/saveBillPhotoInMobile"));
	}

	@Test
	public void delBillPhotoInMobileTest() throws Exception {
		BillPhotoParam param = new BillPhotoParam();
		param.setDealId(9396);
		param.setBillNo("AD58");
		param.setFinancId(11275);
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/delBillPhotoInMobile"));
	}

	/**
	 * 获取合同列表单元测试
	 * @throws Exception
	 */
	@Test
	public void getDealListTest() throws Exception {
		QueryDealListParam param = new QueryDealListParam();
		param.setDealType("101");
		param.setDateType("SIGN_DATE");
		param.setPageOffset(1);
		param.setPageRows(50);
		param.setOrderBy("SIGN_DATE DESC");
		param.setIsWideList(Byte.valueOf("1"));
		param.setOperLevel(2);
		param.setUserId(20331954);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/getDealList"));
	}

	// 新增应收款项
	@Test
	public void updateAppMgrFinaDataOfReceivableTest() throws Exception {
		FinaDataOfReceivableInMobileParam param = new FinaDataOfReceivableInMobileParam();
        param.setDealId(9412);
        param.setPfActual(0);
        List<ErpProcessFinanc> financJson;
        String jsonStr = "[\n" +
                "{\n" +
                "\"orderId\":\"\",\n" +
                "\"payAmount\":\"1200\",\n" +
                "\"paymentId\":\"26623\",\n" +
                "\"performanceType\":\"2\",\n" +
                "\"pfActual\":\"0\",\n" +
                "\"pfDesc\":\"4444444\",\n" +
                "\"pfGeter\":\"3\",\n" +
                "\"pfId\":\"11273\",\n" +
                "\"pfName\":\"佣金\",\n" +
                "\"pfPayer\":\"1\",\n" +
                "\"pfTime\":\"2019-03-12\"\n" +
                "},\n" +
                "{\n" +
                "\"orderId\":\"\",\n" +
                "\"payAmount\":\"200\",\n" +
                "\"paymentId\":\"26623\",\n" +
                "\"performanceType\":\"0\",\n" +
                "\"pfActual\":\"0\",\n" +
                "\"pfDesc\":\"测试添加应收款项\",\n" +
                "\"pfGeter\":\"3\",\n" +
                "\"pfId\":\"11280\",\n" +
                "\"pfName\":\"过户代办费\",\n" +
                "\"pfPayer\":\"1\",\n" +
                "\"pfTime\":\"2019-03-15\"\n" +
                "},\n" +
                "{\n" +
                "\"orderId\":\"\",\n" +
                "\"payAmount\":\"122\",\n" +
                "\"paymentId\":\"26628\",\n" +
                "\"performanceType\":\"0\",\n" +
                "\"pfActual\":\"0\",\n" +
                "\"pfDesc\":\"测试添加应收3\",\n" +
                "\"pfGeter\":\"3\",\n" +
                "\"pfId\":\"\",\n" +
                "\"pfName\":\"过户代办费\",\n" +
                "\"pfPayer\":\"1\",\n" +
                "\"pfTime\":\"2019-03-14\"\n" +
                "}\n" +
                "]";
        financJson = JSON.parseArray(jsonStr, ErpProcessFinanc.class);
        param.setFinancJson(financJson);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateAppMgrFinaDataOfReceivable"));
	}

    // 编辑应收款项
    @Test
    public void updateAppMgrFinaDataOfReceivableModifyTest() throws Exception {
        FinaDataOfReceivableInMobileParam param = new FinaDataOfReceivableInMobileParam();
        param.setDealId(9412);
        param.setPfActual(0);
        List<ErpProcessFinanc> financJson;
        String jsonStr = "[\n" +
                "{\n" +
                "\"orderId\":\"\",\n" +
                "\"payAmount\":\"1200\",\n" +
                "\"paymentId\":\"26623\",\n" +
                "\"performanceType\":\"2\",\n" +
                "\"pfActual\":\"0\",\n" +
                "\"pfDesc\":\"4444444444456654\",\n" +
                "\"pfGeter\":\"3\",\n" +
                "\"pfId\":\"11273\",\n" +
                "\"pfName\":\"佣金\",\n" +
                "\"pfPayer\":\"1\",\n" +
                "\"pfTime\":\"2019-03-12\"\n" +
                "},\n" +
                "{\n" +
                "\"orderId\":\"\",\n" +
                "\"payAmount\":\"200\",\n" +
                "\"paymentId\":\"26627\",\n" +
                "\"performanceType\":\"0\",\n" +
                "\"pfActual\":\"0\",\n" +
                "\"pfDesc\":\"测试添加应收款项3333\",\n" +
                "\"pfGeter\":\"3\",\n" +
                "\"pfId\":\"11280\",\n" +
                "\"pfName\":\"按揭代办费\",\n" +
                "\"pfPayer\":\"1\",\n" +
                "\"pfTime\":\"2019-03-15\"\n" +
                "}]";
        financJson = JSON.parseArray(jsonStr, ErpProcessFinanc.class);
        param.setFinancJson(financJson);
        System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateAppMgrFinaDataOfReceivable"));
    }

    // 删除应收款项
    @Test
    public void updateAppMgrFinaDataOfReceivableDeleteTest() throws Exception {
        FinaDataOfReceivableInMobileParam param = new FinaDataOfReceivableInMobileParam();
        param.setDealId(9412);
        param.setPfActual(0);
        param.setDelFinancIds("11285,11286");
        List<ErpProcessFinanc> financJson;
        String jsonStr = "[{\"orderId\":\"\",\"payAmount\":\"1200\",\"paymentId\":\"26623\",\"performanceType\":\"2\",\"pfActual\":\"0\",\"pfDesc\":\"4444444444456654\",\"pfGeter\":\"3\",\"pfId\":\"11273\",\"pfName\":\"佣金\",\"pfPayer\":\"2\",\"pfTime\":\"2019-03-12\"},{\"orderId\":\"\",\"payAmount\":\"200\",\"paymentId\":\"26627\",\"performanceType\":\"0\",\"pfActual\":\"0\",\"pfDesc\":\"?????????????3333\",\"pfGeter\":\"3\",\"pfId\":\"11280\",\"pfName\":\"按揭代办费\",\"pfPayer\":\"1\",\"pfTime\":\"2019-03-15\"},{\"orderId\":\"\",\"payAmount\":\"233\",\"paymentId\":\"27681\",\"performanceType\":\"0\",\"pfActual\":\"0\",\"pfDesc\":\"啊啊啊啊啊啊啊啊啊\",\"pfGeter\":\"3\",\"pfId\":\"11287\",\"pfName\":\"6000\",\"pfPayer\":\"2\",\"pfTime\":\"2019-03-14\"}]";
        financJson = JSON.parseArray(jsonStr, ErpProcessFinanc.class);
        param.setFinancJson(financJson);
        System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateAppMgrFinaDataOfReceivable"));
    }

	// 新增实收数据
	@Test
	public void updateAppMgrFinaDataOfReceiveAddTest() throws Exception {
		FinaDataOfReceivableInMobileParam param = new FinaDataOfReceivableInMobileParam();
		param.setDealId(9412);
		param.setPfActual(1);
		List<ErpProcessFinanc> financJson = new ArrayList<>();
		ErpProcessFinanc financ = new ErpProcessFinanc();
		financ.setPayAccount("微信（15228861532");
		financ.setPayAmount(BigDecimal.valueOf(100));
		financ.setPayTypeDesc("支付宝");
		financ.setPaymentId(26627);
		financ.setPerformanceType(Byte.valueOf("0"));
		financ.setPfActual(Byte.valueOf("1"));
		financ.setPfDesc("12334");
		financ.setPfGeter("3");
		financ.setPfName("按揭代办费");
		financ.setPfPayer("1");
		financ.setPfTime(new Date());
		financ.setReceiptMoneyUser(10095135);
		financJson.add(financ);
		param.setFinancJson(financJson);
		System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateAppMgrFinaDataOfReceive"));
	}

    // 编辑实收数据
    @Test
    public void updateAppMgrFinaDataOfReceiveModifyTest() throws Exception {
        FinaDataOfReceivableInMobileParam param = new FinaDataOfReceivableInMobileParam();
        param.setDealId(9412);
		param.setPfActual(1);
        List<ErpProcessFinanc> financJson;
		String jsonStr = "[\n" +
                "{\n" +
                "\"billCodeId\":\"\",\n" +
                "\"billCodeNo\":\"\",\n" +
                "\"billWay\":\"0\",\n" +
                "\"orderId\":\"\",\n" +
                "\"payAccount\":\"微信（15228861532）\",\n" +
                "\"payAmount\":\"100\",\n" +
                "\"payTypeDesc\":\"支付宝\",\n" +
                "\"paymentId\":\"26627\",\n" +
                "\"performanceType\":\"0\",\n" +
                "\"pfActual\":\"1\",\n" +
                "\"pfDesc\":\"123\",\n" +
                "\"pfGeter\":\"3\",\n" +
                "\"pfId\":\"11281\",\n" +
                "\"pfName\":\"按揭代办费\",\n" +
                "\"pfPayer\":\"1\",\n" +
                "\"pfTime\":\"2019-03-14\",\n" +
                "\"receiptMoneyUser\":\"10095135\"\n" +
                "},\n" +
                "{\n" +
                "\"billCodeId\":\"\",\n" +
                "\"billCodeNo\":\"\",\n" +
                "\"billWay\":\"0\",\n" +
                "\"orderId\":\"\",\n" +
                "\"payAccount\":\"微信（15228861532）\",\n" +
                "\"payAmount\":\"100\",\n" +
                "\"payTypeDesc\":\"支付宝\",\n" +
                "\"paymentId\":\"26627\",\n" +
                "\"performanceType\":\"0\",\n" +
                "\"pfActual\":\"1\",\n" +
                "\"pfDesc\":\"test edit 2\",\n" +
                "\"pfGeter\":\"3\",\n" +
                "\"pfId\":\"11282\",\n" +
                "\"pfName\":\"租赁佣金\",\n" +
                "\"pfPayer\":\"1\",\n" +
                "\"pfTime\":\"2019-03-14\",\n" +
                "\"receiptMoneyUser\":\"10095135\"\n" +
                "}\n" +
                "]";
		financJson = JSON.parseArray(jsonStr, ErpProcessFinanc.class);
        param.setFinancJson(financJson);
        System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateAppMgrFinaDataOfReceive"));
    }

    @Test
    public void updateAppMgrFinaDataOfReceiveDeleteTest() throws Exception {
        FinaDataOfReceivableInMobileParam param = new FinaDataOfReceivableInMobileParam();
        param.setDealId(9412);
        param.setPfActual(1);
        param.setDelFinancIds("11281");
        List<ErpProcessFinanc> financJson;
        String jsonStr = "[]";
        financJson = JSON.parseArray(jsonStr, ErpProcessFinanc.class);
        param.setFinancJson(financJson);
        System.out.println(postNewErp(param,"managerCenter/transaction/deal/updateAppMgrFinaDataOfReceive"));
    }

	@Test
	public void getAppPrintDataofTaxAndFee() throws Exception {
		PrintDataofTaxAndFeeParam param = new PrintDataofTaxAndFeeParam();
		param.setDealId(49360);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/getAppPrintDataofTaxAndFee"));
	}

	@Test
	public void insertMgrWarrantProcess() throws Exception {
		InsertWarrantProcessParam param = new InsertWarrantProcessParam();
		param.setDealUserId(20329983);
		param.setDealUserName("胡毅");
		param.setModelId(1670);
		param.setModelName("该合同流程");
		param.setDealId(9400);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/insertMgrWarrantProcess"));
	}

	@Test
	public void getDealFianacByPerformance() throws Exception {
		DealFianacByPerformanceParam param = new DealFianacByPerformanceParam();
		param.setDealId(11173);
		param.setPerformanceType(Byte.valueOf("2"));
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/getDealFianacByPerformance"));
	}
	
	@Test
	public void getDealCustomizedProfitList() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("dealId", 11768);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/getDealCustomizedProfitList"));
	}
	@Test
	public void getCompCommissionByDealId() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("dealId", 11213);
		System.out.println(postNewErp(param,"/managerCenter/transaction/deal/getCompCommissionByDealId"));
	}

}
