package com.myfun.erpWeb.usercenter.payment.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 支付相关公用接口类
 * 
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/common")
public class PaymentCommonController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentCommonController.class);

	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;

	/**
	 * 余额支付订单
	 * 
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/autoOrderPayment")
	public Map<String, Object> autoOrderPayment(String ptId) {
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("ptId", ptId);
		parameterMap.put("source", "0");
		String url = AppConfig.getCrmWebUrl() + "/contractManager/finance/contract/orderPayment";
		// String url =
		// "http://192.168.5.165:8089/crmWeb/contractManager/finance/contract/orderPayment";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>() {
		});
		return parseObject;
	}

	/**
	 * 获取账户余额
	 * 
	 * @author 张宏利
	 * @since 2018年6月12日
	 * @param ptId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getUserAmount")
	public ResponseJson getUserAmount(HttpServletRequest request) {
		Integer uaIdSelect = 0;
		Integer selfUaId = getOperator().getUaId();
		Integer compUaId = getOperator().getCompUaId();
		Integer isCompAccount = StringUtil.parseInteger(request.getParameter("isCompAccount"), 0);
		
		// 查询公司的资金账户
		if (isCompAccount != null && isCompAccount == 1) {
			if (compUaId != null && compUaId > 0) {
				uaIdSelect = compUaId;
			}
		} else if (selfUaId != null && selfUaId > 0) {
			// 查询个人的
			uaIdSelect = selfUaId;
		}
		if (uaIdSelect == null || uaIdSelect <= 0) {
			return ErpResponseJson.ok();
		}
		AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaIdSelect);
		AdminFunUserAccount resultAccount = new AdminFunUserAccount();
		resultAccount.setCashMoney(funUserAccount.getCashMoney());
		resultAccount.setHaofangAmount(funUserAccount.getHaofangAmount());
		resultAccount.setTrueHouseDeposit(funUserAccount.getTrueHouseDeposit());
		return ErpResponseJson.ok(resultAccount);
	}
}
