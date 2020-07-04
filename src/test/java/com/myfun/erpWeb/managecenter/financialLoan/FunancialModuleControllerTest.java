package com.myfun.erpWeb.managecenter.financialLoan;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeListParam;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeModifyParam;
import com.myfun.repository.erpdb.po.ErpFunDeptFee;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunancialModuleControllerTest extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.181:8080", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.5.175:8080/erpWeb", "http://192.168.5.175:8090/hftWebService/web/api/authentication/per.do", "670087", "15824205070");
//		init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "670452", "15982820924");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
		init("http://localhost:9001/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/per.do", "46470", "18782920347");
	}

	@Test
	public void addDeptFee() throws Exception{
		ErpFunDeptFeeListParam erpFunDeptFeeListParam = new ErpFunDeptFeeListParam();
		erpFunDeptFeeListParam.setCountTimeStr("2019-07-01");
		erpFunDeptFeeListParam.setDeptIds("892130,892131");
		erpFunDeptFeeListParam.setFeeNote("备注LGL");

		String stringParam = "[{\"feeAmount\":100,\"feeId\":364,\"feeName\":\"水费\",\"billPicUrl\":\"https://img.alicdn.com/bao/uploaded/i3/2261044161/TB19TsKSFXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_220x220q90.jpg\"}," +
				"{\"feeAmount\":200,\"feeId\":365,\"feeName\":\"电费\",\"billPicUrl\":\"https://img.alicdn.com/bao/uploaded/i3/2261044161/TB19TsKSFXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_220x220q90.jpg\"}]";
		erpFunDeptFeeListParam.setDeptFeeList(stringParam);
		System.out.println(postNewErp(erpFunDeptFeeListParam,"/managecenter/financeModule/addDeptFee"));
	}

	/**
	 * 门店费用批量导入
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/17
	 */
	@Test
	public void importDeptFee() throws Exception{
		/*
		[{\"countTimeStr\":\"2018-07\",\"deptIds \":\"892554\",\"deptName\":\"CC门店\",\"feeAmount\":\"100\",\"feeId\":\"166\",\"feeName\":\"水电气费门店费用项目\",\"feeNote \":\"\"}]
		 */
		ErpFunDeptFeeListParam erpFunDeptFeeListParam = new ErpFunDeptFeeListParam();
		erpFunDeptFeeListParam.setDeptFeeListJson("[{\"countTimeStr\":\"2018-07\",\"deptIds\":\"892131\",\"deptName\":\"CC门店\",\"feeAmount\":\"100\",\"feeId\":\"166\",\"feeName\":\"水电气费门店费用项目\",\"feeNote \":\"\",\"billPicUrl\":\"https://img.alicdn.com/bao/uploaded/i3/2261044161/TB19TsKSFXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_220x220q90.jpg\"}]");
		System.out.println(postNewErp(erpFunDeptFeeListParam,"/managecenter/financeModule/importDeptFee"));
	}

	/**
	 * 门店费用信息修改
	 *
	 * @param
	 * @return
	 * @auther 黎桂良
	 * @since 2019/7/31
	 */
	@Test
	public void modifyDeptFee() throws Exception {
		ErpFunDeptFeeModifyParam param = new ErpFunDeptFeeModifyParam();
		param.setFeeDetailListId(5483);
		param.setCountTimeStr("2019-7-30");
		param.setFeeNote("LGL修改备注");
		param.setFeeAmount(new BigDecimal(114));
		System.out.println(postNewErp(param, "/managecenter/financeModule/modifyDeptFee"));
	}

	/**
	 * 门店图片单独添加
	 *
	 * @param
	 * @return
	 * @auther 黎桂良
	 * @since 2019/7/31
	 */
	@Test
	public void updateDeptFeeBillPic() throws Exception {
		ErpFunDeptFeeModifyParam param = new ErpFunDeptFeeModifyParam();
		param.setFeeDetailListId(5483);
		param.setBillPicUrl("https://gw.alicdn.com/imgextra/i3/64/O1CN01XPlEtt1CLLtactJxL_!!64-0-lubanu.jpg");
		System.out.println(postNewErp(param, "/managecenter/financeModule/updateDeptFeeBillPic"));
	}

	/**
	 * 门店图片单独删除
	 *
	 * @param
	 * @return
	 * @auther 黎桂良
	 * @since 2019/7/31
	 */
	@Test
	public void updateDeptFeeBillPic2() throws Exception {
		ErpFunDeptFeeModifyParam param = new ErpFunDeptFeeModifyParam();
		param.setFeeDetailListId(5483);
		System.out.println(postNewErp(param, "/managecenter/financeModule/updateDeptFeeBillPic"));
	}
	/**
	 *  门店月报列表
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/10
	 * @return
	 *
	 */
	@Test
	public void getFinancialStatementsMonthlyShopReport() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("countDate", "2018-05");
		pMap.put("dateType", "TRANSFER_DATE");
		pMap.put("compId",12001);
		System.err.println(postNewErp(pMap,"/managecenter/financeModule/getFinancialStatementsMonthlyShopReport"));
	
	}
	
	/**
	 * 获取业绩核算表
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/11
	 * @return
	 *
	 */
	@Test
	public void getPayAccountingList() throws Exception{
		//{"CLIENTKEY":"b98d44364be3cb8d323f0b67758c3be2","dateType":"SHISHOU_TIME","deptId":"893552","endTime":"2019-07-02","pageOffset":"1","pageRows":"50","startTime":"2019-01-01","total":"0","userType":"1"}
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", "892130");
		pMap.put("dateType", "SHISHOU_TIME");
		pMap.put("endTime","2019-07-02");
		pMap.put("startTime","2019-01-01");
		pMap.put("total","0");
		pMap.put("userType","1");
		System.err.println(postNewErp(pMap,"/managecenter/financeModule/getPayAccountingList"));
		
	}

	/**
	 * 获取收款结算表数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/14
	 * @return
	 *
	 */
	@Test
	public void getPaySettlementList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("deptId", "12001");
		pMap.put("dateType", "SIGN_DATE");
		pMap.put("endTime","2018-05-11");
		pMap.put("startTime","2018-05-01");
		pMap.put("total","0");
		pMap.put("userType","1");
		System.err.println(postNewErp(pMap,"/managecenter/financeModule/getPaySettlementList"));

	}

	@Test
	public void getDeptFeeList() throws Exception{
		ErpFunDeptFeeListParam erpFunDeptFeeListParam = new ErpFunDeptFeeListParam();
        erpFunDeptFeeListParam.setPageOffset(1);
        erpFunDeptFeeListParam.setCompId(46470);
        erpFunDeptFeeListParam.setPageRows(20);
		erpFunDeptFeeListParam.setTimeType(2);
		erpFunDeptFeeListParam.setStartTime("2018-08-01 00:00:00");
		erpFunDeptFeeListParam.setEndTime("2018-09-01 00:00:00");
//		erpFunDeptFeeListParam.setFeeId(286);
		System.out.println(postNewErp(erpFunDeptFeeListParam,"/managecenter/financeModule/getDeptFeeList"));
	}
	@Test
	public void auditDeptFee() throws Exception{
		ErpFunDeptFeeListParam erpFunDeptFeeListParam = new ErpFunDeptFeeListParam();
        erpFunDeptFeeListParam.setDeptFeeListIds("5088,5087");
		erpFunDeptFeeListParam.setAuditStatus((byte) 0);

		System.out.println(postNewErp(erpFunDeptFeeListParam,"/managecenter/financeModule/auditDeptFee"));
	}
	@Test
	public void updateDeptFee() throws Exception{
		ErpFunDeptFeeListParam erpFunDeptFeeListParam = new ErpFunDeptFeeListParam();
        erpFunDeptFeeListParam.setDeptFeeListIds("5045,5046");
		erpFunDeptFeeListParam.setStatus((byte) 1);
		System.out.println(postNewErp(erpFunDeptFeeListParam,"/managecenter/financeModule/updateDeptFee"));
	}
	@Test
	public void summaryFunFeeList() throws Exception{
		ErpFunDeptFeeListParam erpFunDeptFeeListParam = new ErpFunDeptFeeListParam();
		erpFunDeptFeeListParam.setCompId(46470);
		erpFunDeptFeeListParam.setTimeType(1);
		erpFunDeptFeeListParam.setStartTime("2018-05-01 00:00:00");
		System.out.println(postNewErp(erpFunDeptFeeListParam,"/managecenter/financeModule/summaryFunFeeList"));
	}

	@Test
	public void getPercentProfitList() throws Exception {
		Map<String,Object> paramMap=new HashMap<>();
		paramMap.put("dateType","DEAL_VERIFY_TIME");
		paramMap.put("dealType",101);
		paramMap.put("startTime","2018-01-01");
		paramMap.put("endTime","2018-1-31");
		paramMap.put("searchRange","COMP");
		/*ProfitPercentParam param= new ProfitPercentParam();
		param.setDateType("DEAL_VERIFY_TIME");
		param.setDealType("101");
		param.setStartTime("2018-05-01");
		param.setEndTime("2018-5-31");
		param.setSearchRange("COMP");*/
		System.out.println(postNewErp(paramMap, "managecenter/financeModule/getPercentProfitList"));
	}


	@Test
	public void addEditSysFunDept() throws Exception {
		ErpFunDeptFeeListParam erpFunDeptFeeListParam = new ErpFunDeptFeeListParam();
		erpFunDeptFeeListParam.setDeptFeeList("[{\"feeAmount\":\"100.00\",\"feeId\":\"288\",\"feeName\":\"物业费\"}," +
				"{\"feeAmount\":\"200.00\",\"feeId\":\"289\",\"feeName\":\"操作费\"}]");
		System.out.println(postNewErp(erpFunDeptFeeListParam,"/managecenter/financeModule/addEditSysFunDept"));
	}

	@Test
	public void getSysDeptFeeList() throws Exception {
		Map<String,Object> param=new HashMap<>();
		System.out.println(postNewErp(param,"/managecenter/financeModule/getSysDeptFeeList"));
	}

	@Test
	public void delSysDeptFee() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("feeId",306);
		System.out.println(postNewErp(param,"/managecenter/financeModule/delSysDeptFee"));
	}
}
