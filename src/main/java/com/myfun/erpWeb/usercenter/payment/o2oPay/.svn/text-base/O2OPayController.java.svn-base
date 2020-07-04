package com.myfun.erpWeb.usercenter.payment.o2oPay;

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
import com.myfun.repository.admindb.dao.AdminDiscountConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminDiscountConfig;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.utils.HttpUtil;

/**
 * O2O购买相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/o2oPay")
public class O2OPayController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(O2OPayController.class);
	
	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired AdminDiscountConfigMapper adminDiscountConfigMapper;
	@Autowired AdminFunCityMapper adminFunCityMapper;
	@Autowired AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired AdminSysParaMapper adminSysParaMapper;
	@Autowired AdminFunUserAccountService adminFunUserAccountService;
	
	/**
	 * 购买页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView buyBail(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		Integer adminDeptId = operator.getAdminDeptId();
		String deptNo = request.getParameter("deptNo");
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
			view.addObject("cashMoney", funUserAccount.getCashMoney());
			view.addObject("shareMoney", adminFunUserAccountService.getAvailableShareMoney(operator.getArchiveId()));
		}
		// 金额配置
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(operator.getCityId().shortValue());
		AdminDiscountConfig discountConfig = adminDiscountConfigMapper.getRecordByCityLevelAndType(adminFunCity.getCityLevel(), "O2O");
		if(discountConfig != null) {
			view.addObject("buyConfigJson", discountConfig.getExtJson());
		}
		// 花呗配置
		String huabeiRepaymentRate = adminSysParaMapper.selectParamVlue("HUABEI_REPAYMENT_RATE");
		view.addObject("huabeiRepaymentRate", huabeiRepaymentRate);
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		String isPersonalVersion = operator.isPersonalVersion()? "1" : "0";
		view.addObject("isPersonalVersion", isPersonalVersion);
		view.setViewName("ucenter/o2oPay/o2oPay");
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
		view.setViewName("ucenter/o2oPay/result");
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
		parameterMap.put("source", "0");
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createO2OOrder";
//		String url = "http://192.168.5.165:8089/crmWeb/crmOpenApi/contractOpenApi/createO2OOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
}



