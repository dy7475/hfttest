package com.myfun.erpWeb.usercenter.payment.softPay;

import java.util.Map;
import java.util.Optional;

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
import com.myfun.repository.admindb.dao.AdminCrmFunContractMapper;
import com.myfun.repository.admindb.dao.AdminDiscountConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dto.SoftContractDto;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.service.business.admindb.AdminCrmFunContractService;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.utils.EncryptHelper;
import com.myfun.utils.HttpUtil;

/**
 * 软件购买相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/softPay")
public class SoftPayController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(SoftPayController.class);
	
	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired AdminDiscountConfigMapper adminDiscountConfigMapper;
	@Autowired AdminFunCityMapper adminFunCityMapper;
	@Autowired AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired AdminCrmFunContractMapper adminCrmFunContractMapper;
	@Autowired AdminCrmFunContractService adminCrmFunContractService;
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
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getFunDeptsById(adminDeptId);
		view.addObject("contractId", adminFunDepts.getContractId());
		view.addObject("deptFlag", adminFunDepts.getDeptFlag());
		view.addObject("deptType", adminFunDepts.getDeptType());
		
		SoftContractDto softContractDto = adminCrmFunContractMapper.getSoftContract(adminDeptId);
		if(softContractDto == null) {
			view.addObject("softContractError", "请联系你的销售顾问生成合同!");
		} else {
			Double totalPrice = Optional.ofNullable(softContractDto.getTotalPrice()).orElse(0.0);
			Double weiTotalPrice = Optional.ofNullable(softContractDto.getWeiTotalPrice()).orElse(0.0);
			view.addObject("bindOpenWeixin", softContractDto.getBindOpenWeixin());
			view.addObject("weiContractNo", softContractDto.getWeiContractNo());
			view.addObject("contractHtml", this.buildContractUrl(softContractDto));
			view.addObject("weiContractHtml", softContractDto.getWeiContractHtml());
			view.addObject("totalPrice", totalPrice);
			view.addObject("weiTotalPrice", weiTotalPrice);
			view.addObject("contractNo", softContractDto.getContractNo());
			view.addObject("contractId", softContractDto.getContractId());
			view.addObject("totalAmount", softContractDto.getTotalAmount());
		}
		// 花呗配置
		String huabeiRepaymentRate = adminSysParaMapper.selectParamVlue("HUABEI_REPAYMENT_RATE");
		view.addObject("huabeiRepaymentRate", huabeiRepaymentRate);
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		String isPersonalVersion = operator.isPersonalVersion()? "1" : "0";
		view.addObject("isPersonalVersion", isPersonalVersion);
		view.setViewName("ucenter/softPay/softPay");
		return view;
	}
	
	public String buildContractUrl(SoftContractDto softContractDto) {
		String contractPath = softContractDto.getContractPath();
		String contractHtml = softContractDto.getContractHtml();
		String contractVersion = softContractDto.getContractVersion();
		Integer deptId = softContractDto.getDeptId();
		String token = EncryptHelper.encryptMD5(String.valueOf(deptId));
		String param = "?deptId=" + deptId + "&token=" + token;
		String crmWebUrl = AppConfig.getCrmWebUrl();
		String picRoot = AppConfig.getPicDomainUrl();
		String url = "";
		if (StringUtils.isNotBlank(contractPath)) {
			if (contractPath.indexOf("|") > -1) {
				url = crmWebUrl + "/contractManager/finance/contract/template/showContractImg" + param;
			} else {
				url = picRoot + contractPath + param;
			}
		} else if (StringUtils.isNotBlank(contractVersion)) {
			contractVersion += param;
			url = crmWebUrl + "/contractManager/finance/contract/template/" + contractVersion;
		} else if (StringUtils.isNotBlank(contractHtml)) {
			url = picRoot + contractHtml + param;
		}
		return url;
	}
	
	/**
	 * 购买结果页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/result")
	public ModelAndView result(HttpServletRequest request, ModelAndView view) {
		view.setViewName("ucenter/softPay/result");
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
		//不传代表直接扣总经理的
		//parameterMap.put("archiveId", String.valueOf(operator.getArchiveId()));
		parameterMap.put("source", "0");
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createSoftOrder";
//		String url = "http://192.168.5.165:8089/crmOpenApi/contractOpenApi/createSoftOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
}



