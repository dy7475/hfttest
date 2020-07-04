package com.myfun.erpWeb.usercenter.payment.weidian;

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
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.HttpUtil;

/**
 * 企业微店支付相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/weidian")
public class WeidianController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(WeidianController.class);

	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	
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
		// 获取余额
		AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.getAccountByArchiveId(operator.getArchiveId());
		if (funUserAccount != null) {
			view.addObject("amount", funUserAccount.getCashMoney());
		}
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		String isPersonalVersion = operator.isPersonalVersion()? "1" : "0";
		view.addObject("isPersonalVersion", isPersonalVersion);
		view.setViewName("ucenter/weidian/index");
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
		view.setViewName("ucenter/weidian/result");
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
		parameterMap.put("compId", String.valueOf(operator.getAdminCompId()));
		parameterMap.put("deptId", String.valueOf(operator.getAdminDeptId()));
		parameterMap.put("archiveId", String.valueOf(operator.getArchiveId()));
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createWeixinOrderAction";
//		String url = "http://192.168.200.199:8081/crmWeb/crmOpenApi/contractOpenApi/createWeixinOrderAction";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
}



