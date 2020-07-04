package com.myfun.erpWeb.managecenter.transaction;

import com.atomikos.util.DateHelper;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosPayControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
	}

	/**
	 * title ：erp发起pos支付
	 * auhor：lcb
	 * date  : 2017/10/24
	 */
	@Test
	public void initiationOfPayments() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("financeType", "1");
		param.put("financeIds", "196");
//		param.put("dealId", "6271");
		System.out.println(postNewErp(param,"/managerCenter/transaction/posPay/initiationOfPayments"));
	}

	/**
	 * title ：erp发起pos支付
	 * auhor：lcb
	 * date  : 2017/10/24
	 */
	@Test
	public void getOrderList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("queryTimeType", "0");
		param.put("queryTimeStart", "2016-08-01");
		param.put("queryTimeEnd", "2019-08-01");
		param.put("isGroupByContract", "1");
		param.put("deptId", "12001");
		param.put("paymentId", "-1");
		System.out.println(postNewErp(param,"/managerCenter/transaction/posPay/getOrderList"));
	}

	/**
	 * title ：erp发起pos支付
	 * auhor：lcb
	 * date  : 2017/10/24
	 */
	@Test
	public void asynchronousNotify() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("orderNo", "12001");
		param.put("cityId", "1");
		param.put("payStatus", "1");
		param.put("financeType", "2");
		param.put("compId", "12001");
		param.put("deptId", "12001");
		param.put("paymentTime", "2017-08-08 20:00:00");
		// param.put("payAccount", "xxxxxx");
		param.put("financeIds", "193");
		param.put("posMachineId", "CD10234AJXS");
		param.put("financeMoney", "1502");
		System.out.println(HttpUtil.post("http://192.168.0.137:8080/erpWeb/managerCenter/transaction/posPay/posAsynchronousNotify", param));
///		(postNewErp(param,"/managerCenter/transaction/posPay/posAsynchronousNotify"));
	}

	/**
	 * title ：拉卡拉订单汇总
	 * auhor：lcb
	 * date  : 2017/10/24
	 */
	@Test
	public void countPosOrderList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("deptId", "12001");
		param.put("startTime", "2016-06-01");
		param.put("endTime", "2018-06-01");
		System.out.println(postNewErp(param,"/managerCenter/transaction/posPay/countPosOrderList"));
	}

	/**
	 * title ：拉卡拉订单汇总
	 * auhor：lcb
	 * date  : 2017/10/24
	 */
	@Test
	public void getAmountDetail() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("deptId", "12001");
		param.put("paymentId", "-3");
		System.out.println(postNewErp(param,"/managerCenter/transaction/posPay/getAmountDetail"));
	}
	/**
	 * title ：拉卡拉订单汇总
	 * auhor：lcb
	 * date  : 2017/10/24
	 */
	@Test
	public void delPosOrder() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("orderID", "3");
		System.out.println(postNewErp(param,"/managerCenter/transaction/posPay/delPosOrder"));
	}

}
