package com.myfun.erpWeb.usercenter.payment.smallProgram;

import java.util.HashMap;
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
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.HttpUtil;

/**
 * 小程序支付相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/smallProgram")
public class SmallProgramController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(SmallProgramController.class);
	
	@Autowired ErpFunDealPhotoService erpFunDealPhotoService;
	
	/**
	 * 购买页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		view.addObject("archiveId", operator.getArchiveId());
		view.addObject("adminDeptId", operator.getAdminDeptId());
		view.addObject("clientKey", operator.getClientKey());
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		view.setViewName("ucenter/smallProgram/index");
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
		view.setViewName("ucenter/smallProgram/result");
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
	public Map<String, String> createPaymentTask(HttpServletRequest request) {
		Map<String, String> parameterMap = getParameterMap(request);
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createVipOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, String> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, String>>(){});
		return parseObject;
	}
}



