package com.myfun.erpWeb.managecenter.transaction;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToCommssionParam;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToOwnerParam;
import com.myfun.erpWeb.managecenter.transaction.param.QueryDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.RefundDepositParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDepositStatusParam;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class EarnestMoneyControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		init("http://192.168.200.101:8080/erpWeb", "http://testapp.51vfang.cn/hftWebService/web/api/authentication/per.do", "506970", "18782920347");

	}
	
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void getEarbestMoneyList() throws Exception {
		QueryErpEarbestMoneyListParam param = new QueryErpEarbestMoneyListParam();
//		param.setReceiptNo("g");
		param.setDateType("RECEIPT_TIME");
		param.setUserType("CREATE_USER");
		param.setStartTime("2017-10-01");
		param.setEndTime("2018-10-10");
		param.setPageOffset(1);
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/getEarbestMoneyList"));
	}

	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void getDealFunEarbestMoneyDetail() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("earbestId", 193);
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/getDealFunEarbestMoneyDetail"));
	}
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void getDepositList() throws Exception {
		QueryErpEarbestMoneyListParam param = new QueryErpEarbestMoneyListParam();
//		param.setReceiptNo("g");
		param.setDateType("RECEIPT_TIME");
		param.setUserType("CREATE");
		param.setStartTime("2017-10-01");
		param.setEndTime("2019-10-10");
		param.setPageOffset(1);
		param.setPageRows(50);
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/getDepositList"));
	}
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void getDepositDetail() throws Exception {
		QueryDepositDetailParam param = new QueryDepositDetailParam();
		param.setId(4);
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/getDepositDetail"));
	}
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void refundDeposit() throws Exception {
		RefundDepositParam param = new RefundDepositParam();
		param.setId(1);
		param.setRefundMoney(BigDecimal.TEN);
		param.setDepositRemark("m");
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/refundDeposit"));
	}
	
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void payDepositToOwner() throws Exception {
		PayDepositToOwnerParam param = new PayDepositToOwnerParam();
		param.setId(1);
		param.setCommssion(BigDecimal.TEN);
		param.setDepositRemark("mjkfsdflsdfksdfjksdkfkf");
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/payDepositToOwner"));
	}
	
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void getDepositLogList() throws Exception {
		PayDepositToOwnerParam param = new PayDepositToOwnerParam();
		param.setId(1);
		param.setCommssion(BigDecimal.TEN);
		param.setDepositRemark("mjkfsdflsdfksdfjksdkfkf");
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/getDepositLogList"));
	}
	
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void updateDepositStatus() throws Exception {
		/*{\"CLIENTKEY\":\"62d7867a8591bb0a651afba777ceb0de\",\"depositStatus\":\"1\",\"id\":\"7\"}
*/		UpdateDepositStatusParam param = new UpdateDepositStatusParam();
		param.setId(7);
		param.setDepositStatus(Byte.valueOf("1"));
		System.err.println(postNewErp(param,"/managerCenter/transaction/earbestMoney/updateDepositStatus"));
	}
	
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void getPrintContentInfo() throws Exception {
		String paramJson ="{\"CLIENTKEY\":\"47a21997fe5c8eff71931f043b9e4ce4\",\"billWay\":\"0\",\"depositIds\":\"4\",\"printType\":\"0\"}";
		Map<String,Object> paramObject = JSON.parseObject(paramJson, Map.class);
		System.err.println(postNewErp(paramObject,"/managerCenter/funBillModule/getPrintContentInfo"));
	}
	
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void convertDepositHouse() throws Exception {
		//"buildId": "(int32)楼盘id", "buildName": "(string)楼盘名称", "caseId": "(int32)房源id", "caseNo": "(string)楼盘id", "caseType": "(int32)房源类型 1=出售 2=出租",  "id": "(int32)定金id"}
		String paramJson ="{\"CLIENTKEY\":\"47a21997fe5c8eff71931f043b9e4ce4\",\"billWay\":\"0\",\"depositIds\":\"4\",\"printType\":\"0\"}";
		Map<String,Object> paramObject = JSON.parseObject(paramJson, Map.class);
		paramObject.put("buildId", "2017491");
		paramObject.put("buildName", "绿地世纪城");
		paramObject.put("caseId", "6626340");
		paramObject.put("caseNo", "CSCD1603231712553");
		paramObject.put("caseType", "1");
		paramObject.put("id", "1");
	
		System.err.println(postNewErp(paramObject,"/managerCenter/transaction/earbestMoney/convertDepositHouse"));
	}
	
	/**
	 * 查询诚意金列表
	 * @author 熊刚
	 * @since 2017年10月10日
	 * @throws Exception
	 */
	@Test
	public void payDepositToCommssion() throws Exception {
		//"buildId": "(int32)楼盘id", "buildName": "(string)楼盘名称", "caseId": "(int32)房源id", "caseNo": "(string)楼盘id", "caseType": "(int32)房源类型 1=出售 2=出租",  "id": "(int32)定金id"}
		String paramJson ="{\"CLIENTKEY\":\"47a21997fe5c8eff71931f043b9e4ce4\",\"billWay\":\"0\",\"depositIds\":\"4\",\"printType\":\"0\"}";
		PayDepositToCommssionParam paramObject = new PayDepositToCommssionParam();
		/*Map<String,Object> paramObject = JSON.parseObject(paramJson, Map.class);
		paramObject.put("buildId", "2017491");
		paramObject.put("buildName", "绿地世纪城");
		paramObject.put("caseId", "6626340");
		paramObject.put("caseNo", "CSCD1603231712553");
		paramObject.put("caseType", "1");
		paramObject.put("id", "1");*/
		paramObject.setPfPayer(Byte.valueOf("1"));
		paramObject.setCommssion(BigDecimal.TEN);
		paramObject.setDepositRemark("测试mini的范德萨发");
		paramObject.setId(1);
		System.err.println(postNewErp(paramObject,"/managerCenter/transaction/earbestMoney/payDepositToCommssion"));
	}
}
