package com.myfun.erpWeb.usercenter.payment.cashRecharge;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.utils.HttpUtil;

/**
 * 现金充值相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/cashRecharge")
public class CashRechargeController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(CashRechargeController.class);
	
	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	
	/**
	 * 充值现金余额页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		String superUser = operator.getSUPER_USER();
		// 0=个人现金余额，1=公司现金余额
		String isRechargeComp = request.getParameter("isRechargeComp");
		isRechargeComp = "1".equals(isRechargeComp) ? "1" : "0";
		// 是否来自真房源
		String isFromTrueHouse = request.getParameter("isFromTrueHouse");
		isFromTrueHouse = "1".equals(isFromTrueHouse) ? "1" : "0";
		String isPersonalVersion = operator.isPersonalVersion()? "1" : "0";
		// 100元可点亮数量，会员10条，非会员5条
		view.addObject("lightUpCount", "1".equals(superUser) ? 10 : 5);
		view.addObject("archiveId", operator.getArchiveId());
		view.addObject("adminDeptId", operator.getAdminDeptId());
		view.addObject("clientKey", operator.getClientKey());
		view.addObject("isRechargeComp", isRechargeComp);
		view.addObject("isFromTrueHouse", isFromTrueHouse);
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		view.addObject("isPersonalVersion", isPersonalVersion);
		view.setViewName("ucenter/cashRecharge/index");
		return view;
	}
	
	/**
	 * 购买结果页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/result")
	public ModelAndView result(HttpServletRequest request, ModelAndView view) {
		view.setViewName("ucenter/cashRecharge/result");
		return view;
	}

	/**
	 * 创建订单和支付
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/createPaymentTask")
	public Map<String, Object> createPaymentTask(HttpServletRequest request) {
		Operator operator = getOperator();
		Map<String, String> parameterMap = getParameterMap(request);
		parameterMap.put("cityId", String.valueOf(operator.getCityId()));
		parameterMap.put("archiveId", String.valueOf(operator.getArchiveId()));
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createRechargeBalanceOrder";
//		String url = "http://192.168.5.165:8089/crmWeb/crmOpenApi/contractOpenApi/createRechargeBalanceOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
}



