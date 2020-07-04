package com.myfun.erpWeb.usercenter.payment.vipPay;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.myfun.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.admindb.dao.AdminDiscountConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminDiscountConfig;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * vip购买相关外部接口
 * @author 张宏利
 * @since 2018年3月6日
 */
@Controller
@RequestMapping(value = "/usercenter/payment/vipPay")
public class VipPayController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(VipPayController.class);
	
	@Autowired AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired AdminDiscountConfigMapper adminDiscountConfigMapper;
	@Autowired AdminFunCityMapper adminFunCityMapper;
	@Autowired AdminSysParaMapper adminSysParaMapper;
	@Autowired AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired AdminFunUserAccountService adminFunUserAccountService;
	@Autowired
	private CacheUtil cacheUtil;
	
	/**
	 * 购买页面
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView buyBail(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		// 11=公司好房豆，12=个人好房豆
		view.addObject("archiveId", operator.getArchiveId());
		view.addObject("adminDeptId", operator.getAdminDeptId());
		view.addObject("clientKey", operator.getClientKey());
		// 获取余额
		AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.getAccountByArchiveId(operator.getArchiveId());
		if (funUserAccount != null) {
			view.addObject("cashMoney", funUserAccount.getCashMoney());
//			BigDecimal shareMoney = funUserAccount.getShareMoney();
//			Map<String, Object> param = new HashMap<>();
//			param.put("archiveId", operator.getArchiveId());
//			param.put("amountType", 1);
//			String postResult = HttpUtil.post(AppConfig.getAdminWebUrl() +"lookShareTrueHouse/getMoneyInfo", param);
//			//String postResult = HttpUtil.post("http://192.168.5.165:8083/adminWeb/lookShareTrueHouse/getMoneyInfo", param);
//			if(StringUtil.isNotBlank(postResult)){
//				Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
//				if(null != parseObject && null != parseObject.get("data")){
//					Map<String, Object> data = JSON.parseObject(parseObject.get("data").toString(), new TypeReference<Map<String, Object>>(){});
//					if(null != data && null != data.get("availableMoney")){
//						BigDecimal availableMoney = new BigDecimal(data.get("availableMoney").toString());
//						if(null != availableMoney && availableMoney.compareTo(shareMoney) < 0){
//							shareMoney = availableMoney;
//						}
//					}
//				}
//			}
//			AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(operator.getArchiveId());
//			if(adminFunArchive != null){
//				if(null == adminFunArchive.getSuperUser() || null == adminFunArchive.getSuperEnd()){
//					shareMoney = new BigDecimal("0");
//				}else if(adminFunArchive.getSuperUser() !=1 ||  DateUtil.dateCompare(adminFunArchive.getSuperEnd(),new Date()) < 0){
//					shareMoney = new BigDecimal("0");
//				}
//			}

			view.addObject("shareMoney", adminFunUserAccountService.getAvailableShareMoney(operator.getArchiveId()));
		}
		// 金额配置
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(operator.getCityId().shortValue());
		AdminDiscountConfig discountConfig = adminDiscountConfigMapper.getRecordByCityLevelAndType(adminFunCity.getCityLevelVip().byteValue(), "SOUFA");
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
		view.setViewName("ucenter/vipPay/vipPay");
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
		Operator operator = getOperator();
		Integer archiveId = operator.getArchiveId();
		String compNo = operator.getCompNo();
		String deptNo = operator.getDeptNo();
		Integer cityId = operator.getCityId();
		boolean isPerLogin = operator.isPerLogin();
		Integer oldSuperUser = StringUtil.parseInteger(operator.getAttribute("SUPER_USER"), 0);
		
		Integer superUser = this.getSuperUser(cityId, archiveId, compNo, deptNo, isPerLogin);
		if(!oldSuperUser.equals(superUser)) {
			operator.setAttribute("SUPER_USER", StringUtil.toString(superUser));
			cacheUtil.put(CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId(), operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);
		}
		view.addObject("superUser", superUser);
		view.setViewName("ucenter/vipPay/result");
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
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createVipOrder";
		//String url = "http://192.168.5.161:8081/crmWeb/crmOpenApi/contractOpenApi/createVipOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}
	
	/**
	 * 获取是不是VIP用户
	 * @author 张宏利
	 * @since 2018年4月27日
	 * @param archiveId
	 * @return
	 */
	private Integer getSuperUser(Integer cityId, Integer archiveId, String compNo, String deptNo, boolean isPerLogin) {
		AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
		AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(cityId);
		
		Integer superUser = funArchive.getSuperUser();
		Date nowDate = DateTimeHelper.getSystemDate();
		long currentTime = System.currentTimeMillis();
		// 个人增值服务
		if (superUser != null && funArchive.getSuperEnd() != null) {
			if (DateTimeHelper.compareTwoDate(nowDate, funArchive.getSuperEnd()) < 0) {
				superUser = 0;
			}
		} else {
			superUser = 0;
		}
		Integer deptFlag = adminFunDepts.getDeptFlag();
		// 门店用户 试用到期、O2O服务到期、门店暂停：可登录，但不继承增值服务 门店版用户默认是付费用户
		if (superUser == 0) {
			superUser = 1;
			if (Const.DeptCustStatus.DIC_DEPT_FLAG_PAUSAL.equals(deptFlag)
					|| Const.DeptCustStatus.DIC_DEPT_FLAG_SUSPEND.equals(deptFlag)) {
				superUser = 0;
			} else if (Const.DeptCustStatus.DIC_DEPT_FLAG_TRY.equals(deptFlag)) {
				if (DateTimeHelper.compareTwoDate(nowDate, adminFunDepts.getTryEnd()) < 0) {
					superUser = 0;
				}
			} else if (Const.DeptCustStatus.DIC_DEPT_FLAG_FORMAL.equals(deptFlag)) {
				if (DateTimeHelper.compareTwoDate(nowDate, adminFunDepts.getSpaceEnd()) < 0) {
					superUser = 0;
				}
			}
		}
		long tryDays = -1;
		Integer o2oFlag = 0;
		if (Const.DeptCustStatus.DIC_DEPT_FLAG_TRY.equals(deptFlag) && adminFunDepts.getTryEnd() != null) {
			tryDays = (adminFunDepts.getTryEnd().getTime() - currentTime) / (1000 * 60 * 60 * 24);
		} else if (Const.DeptCustStatus.DIC_DEPT_FLAG_FORMAL.equals(deptFlag) && adminFunDepts.getSpaceEnd() != null) {
			if (adminFunDepts.getOtoEnd() != null) {
				if (adminFunDepts.getOtoEnd().getTime() >= currentTime) {// OTO服务到期时间大于或等于空间到期时间则OTO服务开启 and O2O服务时间大于当前时间
					o2oFlag = 1;
				}
			}
		}
		// 如果城市不限制
		if (adminFunCity.getSuperUser()) {
			superUser = 1;
		} else if (o2oFlag == 0) {
			// 非精英版登录才判断OTO标记，精英版登录不判断o2oFlag来改superUser
			if (!isPerLogin) {
				superUser = 0;
			}
		}
		// 试用用户默认开启所有功能
		if (Const.DeptCustStatus.DIC_DEPT_FLAG_TRY.equals(deptFlag)) {
			if (tryDays >= 0) {
				superUser = 1;
			}
		}
		return superUser;
	}
}



