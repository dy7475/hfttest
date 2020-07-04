package com.myfun.erpWeb.usercenter.payment.hfBeans;

import java.util.Date;
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
import com.alipay.api.domain.DataEntry;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.admindb.dao.AdminDiscountConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunPaidMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.po.AdminDiscountConfig;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunPaidExample;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 好房豆兑换相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/hfBeans")
public class HfBeansController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(HfBeansController.class);
	
	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired AdminDiscountConfigMapper adminDiscountConfigMapper;
	@Autowired AdminFunCityMapper adminFunCityMapper;
	@Autowired AdminFunUserAccountService adminFunUserAccountService;
	@Autowired AdminFunPaidMapper adminFunPaidMapper;
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	
	/**
	 * 购买页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/buyBeans")
	public ModelAndView buyBail(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		Integer compType = operator.getCompType();
		// 展示型营销版-冲1800送会员的支付页面
		String showBuySend = request.getParameter("showBuySend");
		// 11=公司好房豆，12=个人好房豆
		String ptType = request.getParameter("ptType");
		ptType = "11".equals(ptType) ? "11" : "12";
		view.addObject("archiveId", operator.getArchiveId());
		view.addObject("adminDeptId", operator.getAdminDeptId());
		view.addObject("clientKey", operator.getClientKey());
		view.addObject("ptType", ptType);
		// 获取余额
		AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.getAccountByArchiveId(operator.getArchiveId());
		if (funUserAccount != null) {
			view.addObject("cashMoney", funUserAccount.getCashMoney());
			view.addObject("shareMoney", adminFunUserAccountService.getAvailableShareMoney(operator.getArchiveId()));
		}
		Byte cityLevel = (byte) 0;
		String paidTypeStr = "HFCOIN";
		// 新营销版，且不是会员，则可以买1800好房币送会员(非重点1200)
		if (!"1".equals(operator.getSUPER_USER()) && "11".equals(ptType)) {
			if (compType.equals(4)) {
				paidTypeStr = "HFT_COIN";
				view.addObject("showBuySend", showBuySend);
				AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(operator.getCityId());
				cityLevel = adminFunCity.getCityLevel();
			} 
		}
		//物业版预存好房豆
		if ("11".equals(ptType)) {
			if(compType.equals(5)){
				paidTypeStr = "PROPERTY_HFT_COIN";
				view.addObject("isMarketSendVip", 1);// 买好房豆送VIP标记
				view.addObject("showBuySend", showBuySend);
				AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(operator.getCityId());
				cityLevel = adminFunCity.getCityLevel();
			}
		}
		AdminDiscountConfig discountConfig = adminDiscountConfigMapper.getRecordByCityLevelAndType(cityLevel, paidTypeStr);
		if(discountConfig != null) {
			view.addObject("buyConfigJson", discountConfig.getExtJson());
		} else {
			view.addObject("isMarketSendVip", 0);// 没有查询到时去掉这个标记
			view.addObject("buyConfigJson", "[{price:20,giftBean:0}, {price:50,giftBean:0}, {price:100,giftBean:0}]");
		}
		//是否首冲 coinPayCount：0 为首冲 大于1 则不是
		AdminFunPaidExample adminFunPaidExample = new AdminFunPaidExample();
        adminFunPaidExample.createCriteria().andArchiveIdEqualTo(operator.getArchiveId()).andPaidTypeEqualTo("COIN");
        int coinPayCount = adminFunPaidMapper.countByExample(adminFunPaidExample);
        view.addObject("coinPayCount", coinPayCount);
        //1为精英版 0门店版
        view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
        
        String isPersonalVersion = operator.isPersonalVersion()? "1" : "0";
		view.addObject("isPersonalVersion", isPersonalVersion);
		 
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(operator.getArchiveId());
		//是否实名认证
		Integer userRight = adminFunArchive.getUserRight();
		view.addObject("userRight", userRight);
		//是否是plus
		Integer isVip = 0;
		Integer superUser = adminFunArchive.getSuperUser();
		Date superEnd = adminFunArchive.getSuperEnd();
		if(superUser !=null && "1".equals(superUser.toString())){
			if(DateUtil.dateCompare(superEnd,new Date()) > 0){
				isVip = 1;
			}
		}
		view.addObject("isVip", isVip);
		
		//半折优惠
		Integer bzyh = 0;
		if(isVip == 1 || (coinPayCount == 0 && userRight == 1)){
			bzyh = 1;
		}
		view.addObject("bzyh", bzyh);
		
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		
		
		
		view.setViewName("ucenter/hfBeans/buyBeans");
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
		Integer compType = operator.getCompType();
		
		Map<String, String> parameterMap = getParameterMap(request);
		parameterMap.put("cityId", String.valueOf(operator.getCityId()));
		parameterMap.put("archiveId", String.valueOf(operator.getArchiveId()));
		parameterMap.put("source", "0");
		Integer bzyh = StringUtil.parseInteger(parameterMap.get("bzyh"), 0);
		Integer totalMoney = StringUtil.parseInteger(parameterMap.get("totalMoney"), 0);
		
		// 新营销版，且不是会员，则可以买1800好房币送会员(非重点1200)
		
		Integer ptType = StringUtil.parseInteger(parameterMap.get("ptType"), 0);
		boolean isNeedSendVip = (totalMoney == 1200 || totalMoney == 1800);
		isNeedSendVip = (isNeedSendVip && ptType == 11 && !"1".equals(operator.getSUPER_USER()));
		parameterMap.put("isMarketSendVip", isNeedSendVip ? "1" : "0");// 买好房豆送VIP标记
		if("1".equals(bzyh.toString()) && ptType == 12){
			parameterMap.put("isFirstRecharge", bzyh+"");// 打半折
			parameterMap.put("totalMoney", (totalMoney/2)+"");// 打半折
		}
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createHftCoinOrder";
		//String url = "http://192.168.5.165:8081/crmWeb/crmOpenApi/contractOpenApi/createHftCoinOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
}



