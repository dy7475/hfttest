package com.myfun.erpWeb.usercenter.payment.o2oRenewal;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.HttpUtil;

/**
 * o2o续期支付相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/o2oRenewal/account")
public class AddAccountController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(AddAccountController.class);

	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired AdminFunDeptsMapper adminFunDeptsMapper;
	
	/**
	 * 购买页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/addAccount")
	public ModelAndView index(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		String deptNo = request.getParameter("deptNo");
		Integer adminDeptId = operator.getAdminDeptId();
		if(StringUtils.isNotBlank(deptNo)) {
			AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), deptNo);
			if(adminFunDepts != null) {
				adminDeptId = adminFunDepts.getDeptId();
			}
		}
		// 11=公司好房豆，12=个人好房豆
		view.addObject("adminDeptId", adminDeptId);
		view.addObject("archiveId", operator.getArchiveId());
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
		view.setViewName("ucenter/o2oRenewal/addAccount");
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
		view.setViewName("ucenter/o2oRenewal/result");
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
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createRenewSoftOrder";
//		String url = "http://192.168.5.165:8089/crmWeb/crmOpenApi/contractOpenApi/createRenewSoftOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
}



