package com.myfun.erpWeb.managecenter.contract;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.constract.param.*;
import com.myfun.erpWeb.managecenter.profit.param.HandProfitListParam;
import com.myfun.repository.erpdb.param.CreateOrUpdateByHandProfitParam;
import com.myfun.repository.erpdb.param.ErpFunContractTemplaeParam;
import com.myfun.repository.erpdb.param.ErpFunDealParam;
import com.myfun.repository.erpdb.po.ErpFunBrokerage;
import com.myfun.repository.erpdb.po.ErpFunContractCategory;
import com.myfun.repository.erpdb.po.ErpFunContractIndex;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunContractControllerTest extends BaseTestController{

	@Before
	public void init(){
//		init("http://192.168.5.175:9001/erpWeb",
//				"http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
		init("http://localhost:8068/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do",
				"123456", "18811110320");

//		super.setClientKey("7a95a0e5da4e9c4c1bba6afca1f49b2e");
	}

	/**
	 * 
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getTemplateParamList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getTemplateParamList"));
	}

	/**
	 *
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getContractTemplateList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("templateType", 101);
		System.out.println(postNewErp(param,"managerCenter/contract/getContractTemplateList"));
	}

	/**
	 *
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getTemplate() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("templateId", 21);
		System.out.println(postNewErp(param,"managerCenter/contract/getTemplate"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getSystemIndexList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("caseType", 101);
		System.out.println(postNewErp(param,"managerCenter/contract/getSystemIndexList"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getContract() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("contractIds", 41);
		System.out.println(postNewErp(param,"managerCenter/contract/getContract"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void checkContractStatus() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", 5926);
		param.put("contentType", 1);
		System.out.println(postNewErp(param,"managerCenter/contract/checkContractStatus"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void delTemplateParam() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("indexId", 85);
		System.out.println(postNewErp(param,"managerCenter/contract/delTemplateParam"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void delContractTemplate() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("templateId", 85);
		System.out.println(postNewErp(param,"managerCenter/contract/delContractTemplate"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void addOrEditTemplateParam() throws Exception{
		Map<String, Object> param =new HashMap<>();
		List<ErpFunContractIndex> paramList = new ArrayList<>();
		ErpFunContractIndex erpFunContractIndex = new ErpFunContractIndex();
		erpFunContractIndex.setIndexName("测试添加指标5544");
		erpFunContractIndex.setCaseType(new Byte("1"));
		erpFunContractIndex.setTemplateId(20);
		erpFunContractIndex.setIndexId(7806);
		paramList.add(erpFunContractIndex);
		System.out.println(JSONObject.toJSON(paramList));
		param.put("indexList", JSONObject.toJSON(paramList));
		System.out.println(postNewErp(param,"managerCenter/contract/addOrEditTemplateParam"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getMgrDealDetailedData() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", 52128);
		System.out.println(postNewErp(param,"managerCenter/contract/getMgrDealDetailedData"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getFunDealPhotoList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", 11828);
		System.out.println(postNewErp(param,"managerCenter/contract/getFunDealPhotoList"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 收佣设置
	 * @throws Exception
	 */
	@Test
	public void getBrokerageIncomeByComp() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getBrokerageIncomeByComp"));
	}
	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 分佣设置
	 * @throws Exception
	 */
	@Test
	public void getBrokerageByComp() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getBrokerageByComp"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getFunContractCategoryList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getFunContractCategoryList"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 删除合同类别
	 * @throws Exception
	 */
	@Test
	public void deleteContractProfit() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("categoryId", 12930);
		System.out.println(postNewErp(param,"managerCenter/contract/deleteContractProfit"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 添加编辑合同类别
	 * @throws Exception
	 */
	@Test
	public void createOrUpdateFunContractCategory() throws Exception{
		FunContractCategoryListParam param =new FunContractCategoryListParam();
		List<ErpFunContractCategory> list =new ArrayList<>();
		ErpFunContractCategory contractCategory=new ErpFunContractCategory();
		contractCategory.setCategoryName("AA");
		contractCategory.setSignType((byte)0);
		list.add(contractCategory);
		param.setCategoryList(list);
		System.out.println(postNewErp(param,"managerCenter/contract/createOrUpdateFunContractCategory"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 查询财务款项配置
	 * @throws Exception
	 */
	@Test
	public void getFinancePaymentList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getFinancePaymentList"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 财务状态配置列表
	 * @throws Exception
	 */
	@Test
	public void getFunFinancStatusList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getFunFinancStatusList"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 添加编辑财务款项列表
	 * @throws Exception
	 */
	@Test
	public void updateFinancPaymentList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		List<Map<String, Object>> paramList = new ArrayList<>();
		Map<String, Object> paramMap =new HashMap<>();
		paramMap.put("paymentName", "二2手222房合同2");
		paramMap.put("beneficiary", 2);
		paramList.add(paramMap);

		param.put("paymentJson", paramList);
		System.out.println(postNewErp(param,"managerCenter/contract/updateFinancPaymentList"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 添加编辑财务款项列表
	 * @throws Exception
	 */
	@Test
	public void createFunFinancStatus() throws Exception{
		Map<String, Object> param =new HashMap<>();
		List<Map<String, Object>> paramList = new ArrayList<>();
		Map<String, Object> paramMap =new HashMap<>();
		paramMap.put("financName", "二2手2222房合同2");
//		paramMap.put("paymentId", 26630);
		paramList.add(paramMap);

		param.put("financstatusJson", paramList);
		System.out.println(postNewErp(param,"managerCenter/contract/createFunFinancStatus"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 获取支付方式列表
	 * @throws Exception
	 */
	@Test
	public void getFunDealPaytypeList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getFunDealPaytypeList"));
	}


	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 添加编辑财务款项列表
	 * @throws Exception
	 */
	@Test
	public void updateFunDealPaytype() throws Exception{
		Map<String, Object> param =new HashMap<>();
		List<Map<String, Object>> paramList = new ArrayList<>();
		Map<String, Object> paramMap =new HashMap<>();
		paramMap.put("paytypeName", "测试");
		paramMap.put("paytypeId", 3886);
		paramList.add(paramMap);

		param.put("paytypeList", paramList);
		System.out.println(postNewErp(param,"managerCenter/contract/updateFunDealPaytype"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 添加编辑财务款项列表
	 * @throws Exception
	 */
	@Test
	public void addEditLoanBank() throws Exception{
		Map<String, Object> param =new HashMap<>();
		List<Map<String, Object>> paramList = new ArrayList<>();
		Map<String, Object> paramMap =new HashMap<>();
		paramMap.put("bankName", "中国工商银行");
		paramMap.put("id", 2255);
		paramList.add(paramMap);

		Map<String, Object> paramMap2 =new HashMap<>();
		paramMap2.put("bankName", "中国建设银行");
		paramMap2.put("id", 2256);
		paramList.add(paramMap2);

		Map<String, Object> paramMap3 =new HashMap<>();
		paramMap3.put("bankName", "中国农业银行");
		paramMap3.put("id", 2257);
		paramList.add(paramMap3);


		Map<String, Object> paramMap4 =new HashMap<>();
		paramMap4.put("bankName", "中国邮政储蓄银行");
		paramMap4.put("id", 2258);
		paramList.add(paramMap4);



		Map<String, Object> paramMap5 =new HashMap<>();
		paramMap5.put("bankName", "测试1");
		paramMap5.put("id", 3255);
		paramList.add(paramMap5);

		Map<String, Object> paramMap6 =new HashMap<>();
		paramMap6.put("bankName", "测试2");
		paramMap6.put("id", 3256);
		paramList.add(paramMap6);


		param.put("bankList", paramList);
		System.out.println(postNewErp(param,"managerCenter/contract/addEditLoanBank"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 贷款银行查询
	 * @throws Exception
	 */
	@Test
	public void getLoanBankList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("bankName","农业,邮政");
		System.out.println(postNewErp(param,"managerCenter/contract/getLoanBankList"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 贷款银行查询
	 * @throws Exception
	 */
	@Test
	public void delLoandBank() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("id","2254");
		System.out.println(postNewErp(param,"managerCenter/contract/delLoandBank"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 查询公司logo
	 * @throws Exception
	 */
	@Test
	public void getDealLogoByComp() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/contract/getDealLogoByComp"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 查询优家合同过户信息
	 * @throws Exception
	 */
	@Test
	public void getFinanceTransferInfo() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", 6119);
		System.out.println(postNewErp(param,"managerCenter/contract/getFinanceTransferInfo"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 查询优家合同过户信息
	 * @throws Exception
	 */
	@Test
	public void checkMaualContractNoAvailable() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("contractNo", 6119);
		System.out.println(postNewErp(param,"managerCenter/contract/checkMaualContractNoAvailable"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 查询优家合同过户信息
	 * @throws Exception
	 */
	@Test
	public void getTemplateListNew() throws Exception{
		Map<String, Object> param =new HashMap<>();
		// param.put("caseType", "101");
		param.put("templateId", "2080");
		System.out.println(postNewErp(param,"managerCenter/contract/getTemplateListNew"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 查询优家合同过户信息
	 * @throws Exception
	 */
	@Test
	public void getContractNew() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", "6507");
		param.put("caseType", "101");
		System.out.println(postNewErp(param,"managerCenter/contract/getContractNew"));
	}
	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 查询优家合同过户信息
	 * @throws Exception
	 */
	@Test
	public void resetContract() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", "6507");
		param.put("caseType", "101");
		System.out.println(postNewErp(param,"/managerCenter/contract/resetContract"));
	}

	/**
	 * @author lcb
	 * @since 2017-09-20
	 * @return 删除合同财务类别配置
	 * @throws Exception
	 */
	@Test
	public void deleteFinancPayment() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("paymentId", "1");
		System.out.println(postNewErp(param,"/managerCenter/contract/deleteFinancPayment"));
	}

	/**
	 * @tag 上传水印
	 * @author 邓永洪
	 * @since 2018/6/7
	 */
	@Test
	public void dealPhotoSave () throws Exception {
		Map<String, Object> param =new HashMap<>();
		//param.put("photoPath", "test3333");
		param.put("photoType", 8);
		param.put("pellucidity", 100);
		System.out.println(postNewErp(param,"/managerCenter/contract/dealPhotoSave"));
	}

	/**
	 * @tag 删除合同照片
	 * @author 邓永洪
	 * @since 2018/6/11
	 */
	@Test
	public void delDealPhoto () throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("photoType", 8);
		System.out.println(postNewErp(param,"/managerCenter/contract/delDealPhoto"));
	}

	/**
	 * @tag 合同收佣标准保存
	 * @author 邓永洪
	 * @since 2018/7/5
	 */
	@Test
	public void saveBrokerage () throws Exception {
		SaveBrokerageParamAndVo param =new SaveBrokerageParamAndVo();
		ErpFunBrokerage saleBrokerage = new ErpFunBrokerage();
		ErpFunBrokerage leaseBrokerage = new ErpFunBrokerage();
		param.setLeaseBrokerage(saleBrokerage);
		param.setSaleBrokerage(leaseBrokerage);
		String json="{\n" +
				"        \"leaseBrokerage\":{\n" +
				"            \"brokerCustRate\":50,\n" +
				"            \"brokerHouseRate\":50,\n" +
				"            \"brokerageCountType\":2,\n" +
				"            \"brokerageRate\":2,\n" +
				"            \"chargeCustRate\":1,\n" +
				"            \"chargeHouseRate\":1,\n" +
				"            \"compId\":12001,\n" +
				"            \"id\":8,\n" +
				"            \"saleLease\":102\n" +
				"        },\n" +
				"        \"saleBrokerage\":{\n" +
				"            \"brokerCustRate\":50,\n" +
				"            \"brokerHouseRate\":50,\n" +
				"            \"brokerageCountType\":2,\n" +
				"            \"brokerageRate\":3,\n" +
				"            \"chargeCustRate\":2,\n" +
				"            \"chargeHouseRate\":1,\n" +
				"            \"compId\":12001,\n" +
				"            \"id\":7,\n" +
				"            \"saleLease\":101\n" +
				"        }\n" +
				"    }";

		param=JSON.parseObject(json,SaveBrokerageParamAndVo.class);
		System.out.println(postNewErp(param,"/managerCenter/contract/saveBrokerage"));
	}

	@Test
	public void getMgrDealNoteData () throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", 7094);
		param.put("recordId", 64367);
		System.out.println(postNewErp(param,"/managerCenter/contract/getMgrDealNoteData"));
	}

	@Test
	public void updateByHandProfit () throws Exception {
		CreateOrUpdateByHandProfitParam param =new CreateOrUpdateByHandProfitParam();
		param.setDealId(9047);
		param.setDealVerifyTime("2018-12-04");
		param.setProfitJson("[{\"agreementNo\":\"\",\"archiveId\":\"671995\",\"areaId\":\"12001\",\"compId\":\"12001\",\"createDate\":\"2018-12-04 15:29:52\",\"dealId\":\"9047\",\"dealType\":\"101\",\"dealVerifyTime\":\"2018-12-04\",\"deptId\":\"12001\",\"deptName\":\"测试A店\",\"grId\":\"0\",\"grName\":\"\",\"performanceId\":\"15656\",\"performanceName\":\"房源（租）\",\"performanceType\":\"1\",\"profitId\":\"10273\",\"profitMoney\":\"0\",\"profitProportion\":\"20\",\"profitType\":\"0\",\"receivableMoney\":\"24.6\",\"regId\":\"40143\",\"remark\":\"\",\"roleId\":\"DEPUTY_MANAGER\",\"roleName\":\"副总经理\",\"settleFlag\":\"1\",\"signDate\":\"\",\"userId\":\"20325467\",\"userName\":\"王淳\",\"validFlag\":\"0\"}]");
		param.setTransferNeedPerformance(new BigDecimal(123));
		param.setTransferRealPerformance(new BigDecimal(123));
		System.out.println(postNewErp(param,"profit/updateByHandProfit"));
	}

	@Test
	public void updateHouseOrCustInfo () throws Exception {
		UpdateHouseOrCustInfoParam param =new UpdateHouseOrCustInfoParam();
		param.setDealId(7094);
		param.setDealType((byte) 101);
		param.setUpdateFlag(1);
		param.setDealHouseId(6639229);
		param.setDealCustomerId(2271462);
		System.out.println(postNewErp(param,"/managerCenter/contract/updateHouseOrCustInfo"));
	}

	@Test
	public void updateDealLockFlag () throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("dealId", 7092);
		param.put("lockFlag", 0);
		System.out.println(postNewErp(param,"/managerCenter/contract/updateDealLockFlag"));
	}

	@Test
	public void getDealAnalysis () throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("caseType", 101);
		param.put("dateType", "SIGN_DATE");
		param.put("dimension", "REG");
		param.put("serchRange", "COMP");
		param.put("endTime", "2018-07-24");
		param.put("startTime", "2018-07-01");
		System.out.println(postNewErp(param,"statisticalAnalysis/profitCount/getDealAnalysis"));
	}


	@Test
	public void updateYouJiaDealAduitStatus () throws Exception {
		YouJiaDealAduitStatusParam param = new YouJiaDealAduitStatusParam();
		param.setDealId(7482);
		param.setContentType((byte)2);
		System.out.println(postNewErp(param,"/managerCenter/contract/updateYouJiaDealAduitStatus"));
	}


	@Test
	public void getByHandProfitLogList () throws Exception {
		HandProfitListParam param = new HandProfitListParam();
		param.setDealId(7094);
		System.out.println(postNewErp(param,"/managerCenter/contract/getByHandProfitLogList"));
	}


	@Test
	public void updateMgrDealAduitStatus () throws Exception {
		// {"CLIENTKEY":"ae13083248ec308d32486359f08c9090","contractNo":"lb091","dealAuditStatus":"1","dealId":"10338","dealType":"101","dealVerifyCon":"1111111111111"}
		UpdateDealAuditStatusParam param = new UpdateDealAuditStatusParam();
		param.setDealId(10336);
		param.setContractNo("lb090");
		param.setDealAuditStatus(3);
		param.setDealType((byte)101);
		param.setDealVerifyCon("1111111111111");
		System.out.println(postNewErp(param,"managerCenter/contract/updateMgrDealAduitStatus"));
	}

	/**
	 * 合同写跟进单元测试
	 */
	@Test
	public void createDealTrackTest () throws Exception {
		CreateDealTrackParam param = new CreateDealTrackParam();
		param.setDealId(10417);
		param.setRunstepId(2934);
		param.setRunstepName("卖方结算");
		param.setTrackContent("卖方结算完成");
		param.setWarmContent("hello warm");
		param.setWarmUser("10116188,11222,1111,14541");
		System.out.println(postNewErp(param,"/managerCenter/contract/createDealTrack"));
	}
	
	/**
	 * 获取合同跟进单元测试
	 */
	@Test
	public void getDealTrackTest () throws Exception {
		GetDealTrackParam param = new GetDealTrackParam();
		param.setDealId(10366);
		System.out.println(postNewErp(param,"/managerCenter/contract/getDealTrack"));
	}

	/**
	 * 新增合同单元测试
	 * @throws Exception
	 */
	@Test
	public void insertIntoDealInfoTest() throws Exception {

		InsertDealInfoParam param = new InsertDealInfoParam();
		param.setArea(BigDecimal.valueOf(116));
		param.setBuildId(2069);
		param.setBuildName("英郡");
		param.setBuildRegId(4);
		param.setBuyCallPhone("15982083618");
		param.setBuyCustomerCommsion(BigDecimal.valueOf(20000));
		param.setBuyIdCardBakType(1);
		param.setBuyIdCardType(1);
		param.setBuyMortgageType(Byte.valueOf("0"));
		param.setBuyOwnerName("未合作");
		param.setCodeId(2198);
		param.setCodeType(Byte.valueOf("1"));
		param.setContractNo("AC0018");
		param.setCustDeptname("新组织架构测试1");
		param.setCustDeptId(894628);
		param.setCustPlate(Byte.valueOf("2"));
		param.setCustUserUid(20333471);
		param.setCustUsername("张晨");
		param.setDealBuyStyle(Byte.valueOf("0"));
		param.setDealCustomerId(2273279);
		param.setDealCustomerNo("QGCD1907091815168");
		param.setDealHouseId(6643422);
		param.setDealHouseNo("CSCD1906251556161");
		param.setDealSellStyle(Byte.valueOf("0"));
		param.setDealType(Byte.valueOf("101"));
		param.setFitment(Byte.valueOf("2"));
		param.setHaveLandcard(false);
		param.setHouseDeptId(894628);
		param.setDealHouseId(6643422);
		param.setHousePlate(Byte.valueOf("2"));
		param.setHouseUseage(Byte.valueOf("1"));
		param.setHouseUserUid(20333471);
		param.setHouseUsername("张晨");
		param.setHouseaddress("英郡测试栋座2栋A01乙单元1楼102号116㎡普通");
		param.setMangementTax(true);
		param.setOwnerStyle(1);
		param.setOwnerTax(true);
		param.setOwnerType(Byte.valueOf("0"));
		param.setPaytypeId(3884);
		param.setPaytypeName("一次性");
		param.setRealTotalprice(BigDecimal.valueOf(105));
		param.setSalePriceUnit(Byte.valueOf("0"));
		param.setSellAddress("ABCDEFSSSS");
		param.setSellCallPhone("15911111111");
		param.setSellDealMoney(BigDecimal.valueOf(1000000));
		param.setSellIdCardBakType(1);
		param.setSellIdCardType(1);
		param.setSellIshaveLoan(false);
		param.setSellOwnerCommsion(BigDecimal.valueOf(10000));
		param.setSellOwnerName("吃肉");
		param.setSignDate("2019-07-10");
		param.setSignManagerDeptName("去盎司");
		param.setSignManagerId(20333471);
		param.setSignManagerName("张晨");
		param.setSignUserDeptName("全公司");
		param.setSignUserId(20333471);
		param.setSignUserName("张晨");
		param.setTax("1");
		System.out.println(postNewErp(param,"managerCenter/contract/insertIntoDealInfo"));
	}
	/**
	 *  合同保存
	 */
	@Test
	public void saveContract() throws Exception {
		ErpFunContractTemplaeParam param = new ErpFunContractTemplaeParam();
		param.setContractSubContent("1666");
//		param.setContractId(2955);
		param.setCaseType(101);
		param.setContentType(1);
		param.setDealId(10693);
		param.setLineHeight(new BigDecimal(10));
		param.setLogoPosition("0.0");
		param.setSealPosition("0.0");
		param.setIndexList("[{\"contractId\":\"2955\",\"indexId\":\"10759\",\"indexName\":\"请输入法定代表人联系方式\",\"indexValue\":\"\",\"uniqueKey\":\"1565256214049\",\"valueId\":\"81428\"},{\"contractId\":\"2955\",\"indexId\":\"10758\",\"indexName\":\"合同logo\",\"indexValue\":\"\",\"uniqueKey\":\"1542857527667\",\"valueId\":\"81427\"},{\"contractId\":\"2955\",\"funDealField\":\"sellOwnerCommsion\",\"indexId\":\"10757\",\"indexName\":\"业主佣金\",\"indexValue\":\"230\",\"uniqueKey\":\"1542856018572\",\"valueId\":\"81426\"},{\"contractId\":\"2955\",\"funDealField\":\"buyCustomerCommsion\",\"indexId\":\"10756\",\"indexName\":\"客户佣金\",\"indexValue\":\"320\",\"uniqueKey\":\"1542856016807\",\"valueId\":\"81425\"},{\"contractId\":\"2955\",\"funDealField\":\"dealMoney\",\"indexId\":\"10755\",\"indexName\":\"成交价格\",\"indexValue\":\"1800000\",\"uniqueKey\":\"1542856012616\",\"valueId\":\"81424\"},{\"contractId\":\"2955\",\"funDealField\":\"contractNo\",\"indexId\":\"10754\",\"indexName\":\"合同编号\",\"indexValue\":\"AD108\",\"uniqueKey\":\"1542856010929\",\"valueId\":\"81423\"}]");
		param.setTemplateContent("<!DOCTYPE HTML PUBLIC \\\"-//W3C//DTD HTML 4.0//EN\\\" \\\"http://www.w3.org/TR/REC-html40/strict.dtd\\\">\\n<html><head><meta name=\\\"qrichtext\\\" content=\\\"1\\\" /><style type=\\\"text/css\\\">\\np, li { white-space: pre-wrap; }\\n</style></head><body style=\\\" font-family:'宋体'; font-size:15px; font-weight:400; font-style:normal;\\\">\\n<p align=\\\"center\\\" style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-family:'微软雅黑'; font-size:20pt; color:#000000;\\\">存量房（二手房）买卖合同</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:12px; color:#000000;\\\"><br /></span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">合同编号：</span><span style=\\\" font-size:15px; color:#000000;\\\">_</span><a href=\\\"1559207942506\\\"><span style=\\\" font-size:12pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\"> 请输入合同编号 </span></a><span style=\\\" font-size:15px; color:#000000;\\\">_</span><span style=\\\" font-size:12px; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">甲方（出售方）：_</span><span style=\\\" font-size:15px; color:#000000;\\\">_</span><a href=\\\"1559207899049\\\"><span style=\\\" font-size:12pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\"> 请输入业主姓名 </span></a><span style=\\\" font-size:15px; color:#000000;\\\">_</span><span style=\\\" font-size:11pt; color:#000000;\\\">_</span><span style=\\\" font-family:'Calibri'; font-size:11pt; color:#000000;\\\"> </span><span style=\\\" font-size:11pt; color:#000000;\\\">证件类型：</span><span style=\\\" font-size:12pt; text-decoration: underline; color:#000000;\\\">       身份证      </span><span style=\\\" font-size:11pt; color:#000000;\\\">证件号码：</span><span style=\\\" font-size:15px; color:#000000;\\\">_</span><a href=\\\"1559207935934\\\"><span style=\\\" font-size:12pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\"> 请输入业主身份证 </span></a><span style=\\\" font-size:15px; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">    （共有人）：_</span><a href=\\\"1513064445709\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入共有人姓名 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件类型：_</span><a href=\\\"1513064392078\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入证件类型 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件号码：_</span><a href=\\\"1513064572939\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入共有人证件号 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">    （代理人）：_</span><a href=\\\"1513064531693\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入代理人姓名 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件类型：_</span><a href=\\\"1513064412910\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入证件类型 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件号码：_</span><a href=\\\"1513064615913\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入共有人证件号 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">乙方（买受方）：</span><span style=\\\" font-size:15px; color:#000000;\\\">_</span><a href=\\\"1559207967033\\\"><span style=\\\" font-size:12pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\"> 请输入客户姓名 </span></a><span style=\\\" font-size:15px; color:#000000;\\\">_</span><span style=\\\" font-size:11pt; color:#000000;\\\">_证件类型：_</span><a href=\\\"1513064416517\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入证件类型 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件号码：_</span><span style=\\\" font-size:15px; color:#000000;\\\">_</span><a href=\\\"1559207974611\\\"><span style=\\\" font-size:12pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\"> 请输入客户身份证 </span></a><span style=\\\" font-size:15px; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">    （共有人）：_</span><a href=\\\"1513064552839\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入共有人姓名 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件类型：_</span><a href=\\\"1513064419339\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入证件类型 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件号码：_</span><a href=\\\"1513064564721\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入共有人证件号 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">    （代理人）：_</span><a href=\\\"1513064581699\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入代理人姓名 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件类型：_</span><a href=\\\"1513064422734\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入证件类型 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_证件号码：_</span><a href=\\\"1513064608884\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入代理人证件号 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">丙方 (居间方</span><span style=\\\" font-size:12pt; color:#000000;\\\">）</span><span style=\\\" font-size:11pt; color:#000000;\\\">：_</span><a href=\\\"1513064751557\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入签约门店 </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_营业执照号：_</span><a href=\\\"1513064769886\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入营业执照号码                            </span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">法定代表人：_</span><a href=\\\"1513064796469\\\"><span style=\\\" font-size:11pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入法定代表人姓名</span></a><span style=\\\" font-size:11pt; color:#000000;\\\">_联系方式：</span><span style=\\\" font-size:15px;\\\">_</span><a href=\\\"1565256214049\\\"><span style=\\\" font-size:12pt; text-decoration: underline; color:#aaaaaa; background-color:#d9f1fe;\\\">请输入请输入法定代表人联系方式</span></a><span style=\\\" font-size:15px;\\\">_</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; color:#000000;\\\">根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：根据《中华人民共和国合同法》、《中华人民共和国城市房地产管理法》及其他相关法律、法规的规定，甲方和乙方在平等、自愿、公平、协商一致的基础上就存量房屋买卖事宜达成以下协议：</span></p>\\n<p style=\\\" margin-top:12px; margin-bottom:12px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-spacing:10px;\\\"><span style=\\\" font-size:11pt; font-weight:600; color:#000000;\\\">第一条 交易房屋基本信息</span></p></body></html>\n");
		System.out.println(postNewErp(param,"managerCenter/contract/saveContract"));
	}

	@Test
	public void canSeeFunDealPhoto() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("dealId", 11884);
		System.out.println(postNewErp(param, "managerCenter/contract/canSeeFunDealPhoto"));
	}

	/**
	 * @author 黎桂良
	 * @since 2019-11-08
	 * @return 查询合同附件
	 * @throws Exception
	 */
	@Test
	public void getFunDealPhotoListInMobile() throws Exception{
		ErpFunDealParam param = new ErpFunDealParam();
		/*
		{"CLIENTKEY":"f24b8be9f66239abc26cf77a2f1346cf","dealId":"52061","photoType":"0,1,2"}
		*/
		param.setDealId(52061);
		param.setPhotoType("0,1,2");
		System.out.println(postNewErp(param,"managerCenter/contract/getFunDealPhotoList"));
	}
}
