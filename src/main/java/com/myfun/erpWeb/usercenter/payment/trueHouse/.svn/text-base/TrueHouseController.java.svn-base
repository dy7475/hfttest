package com.myfun.erpWeb.usercenter.payment.trueHouse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminTruehouseBondRecordMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.agencydb.dao.AgencyWfUserbMapper;
import com.myfun.repository.agencydb.po.AgencyWfUserb;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;

/**
 * 保证金购买相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/trueHouse")
public class TrueHouseController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(TrueHouseController.class);

	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired AgencyWfUserbMapper agencyWfUserbMapper;
	@Autowired AdminTruehouseBondRecordMapper adminTruehouseBondRecordMapper;
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	
	/**
	 * 购买页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/buyBail")
	public ModelAndView buyBail(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		String superUser = operator.getSUPER_USER();
		view.addObject("archiveId", operator.getArchiveId());
		view.addObject("adminDeptId", operator.getAdminDeptId());
		view.addObject("clientKey", operator.getClientKey());
		
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(operator.getArchiveId());
		if(adminFunArchive.getSuperUser() == 1 && DateUtil.dateCompare(adminFunArchive.getSuperEnd(), new Date()) > 0){
			superUser = "1";
		}else{
			superUser = "0";
		}
		// 获取余额
		AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.getAccountByArchiveId(operator.getArchiveId());
		if (funUserAccount != null) {
			BigDecimal cashMoney = funUserAccount.getCashMoney();
			if (cashMoney.compareTo(BigDecimal.ZERO) < 0) {
				cashMoney = BigDecimal.ZERO;
			}
			view.addObject("amount", cashMoney);
		}
		// 100元可点亮数量，会员20条，非会员5条
		view.addObject("lightUpCount", 5);
		view.addObject("lightUpCountForVip", 20);
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		view.addObject("superUser", superUser);
		String isPersonalVersion = operator.isPersonalVersion()? "1" : "0";
		view.addObject("isPersonalVersion", isPersonalVersion);
		view.setViewName("ucenter/trueHouse/buyBail");
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
		view.setViewName("ucenter/trueHouse/result");
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
		// 一次只能充值100
		parameterMap.put("totalMoney", "100");
		parameterMap.put("source", "0");
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createBondOrder";
//		String url = "http://192.168.5.165:8089/crmWeb/crmOpenApi/contractOpenApi/createBondOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
	
	/**
	 * 保证金退还页面查询可提现金额等
	 * @author 张宏利
	 * @since 2018年4月4日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTrueAmountInfo")
	public ResponseJson getTrueAmountInfo(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Map<String, String> resultMap = new HashMap<>();
		Integer validTureCount = adminTruehouseBondRecordMapper.getValidTureCount(operator.getArchiveId());
		AgencyWfUserb agencyWfUserb = agencyWfUserbMapper.getByArchiveId(operator.getArchiveId());
		resultMap.put("tureCount", String.valueOf(validTureCount));// 真房源数量
		resultMap.put("canReturnAmount", "0");// 可提现金额
		resultMap.put("frozenAmount", "0");// 冻结金额
		// 关注好房精英会
		resultMap.put("followJyh", (agencyWfUserb != null) ? "1" : "0");
		if (agencyWfUserb != null) {
			resultMap.put("wfNickname", agencyWfUserb.getWfNickname());
			resultMap.put("wfPhoto", agencyWfUserb.getWfPhoto());
		}
		return ErpResponseJson.ok(resultMap);
	}
	
	/**
	 * 退还保证金
	 * @author 张宏利
	 * @since 2018年4月10日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/applyTransMoney")
	public ResponseJson applyTransMoney(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		String money = param.getString("money");
		
		AgencyWfUserb agencyWfUserb = agencyWfUserbMapper.getByArchiveId(operator.getArchiveId());
		if(agencyWfUserb == null) {
			return ErpResponseJson.warn("提现失败，请先绑定好房精英会公众号");
		}
		String payUrl = AppConfig.getAdminWebUrl()+"/cashMoneyApply/applyTransMoneyNoTaxation";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("archiveId", getOperator().getArchiveId());
		paramMap.put("money", money);
		paramMap.put("uaId", operator.getUaId());
		paramMap.put("openId", agencyWfUserb.getWfOpenid());
		paramMap.put("recipient", "1");
		try {
			// 调用admin接口提现
			String payResult = HttpUtil.post(payUrl, paramMap);
			DefaultResponseJson adminResult = JSON.parseObject(payResult, DefaultResponseJson.class);
			if(adminResult.getErrCode() == 200) {
				return ErpResponseJson.ok();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ErpResponseJson.warn("提现失败，请联系在线客服");
	}
}



