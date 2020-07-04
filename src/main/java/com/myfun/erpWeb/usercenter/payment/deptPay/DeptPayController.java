package com.myfun.erpWeb.usercenter.payment.deptPay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.usercenter.payment.softPay.SoftPayController;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.dto.SoftContractDto;
import com.myfun.repository.admindb.po.AdminCrmPaymentTasks;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value = "/usercenter/payment/deptPay")
public class DeptPayController extends BaseController {
	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	AdminCrmFunContractMapper adminCrmFunContractMapper;
	@Autowired
	SoftPayController softPayController;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	AdminCrmPaymentTasksMapper adminCrmPaymentTasksMapper;
	@Autowired 
	AdminFunUserAccountService adminFunUserAccountService;
	@RequestMapping(value = "/index")
	public ModelAndView buyBail(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		//Integer adminDeptId = operator.getAdminDeptId();
		String deptNo = request.getParameter("deptNo");

		if(StringUtils.isBlank(deptNo)) {
			throw new BusinessException("参数错误");
		}
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), deptNo);
		Integer adminDeptId=adminFunDepts.getDeptId();
		if (adminFunDepts != null) {
			view.addObject("deptName", adminFunDepts.getDeptName());
			view.addObject("deptAddr", adminFunDepts.getDeptAddr());
			view.addObject("deptTele", adminFunDepts.getDeptTele());
			view.addObject("deptContact", adminFunDepts.getDeptContact() + "-" + adminFunDepts.getContactPhone());
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
		//AdminFunDepts currentAdminFunDepts = adminFunDeptsMapper.getFunDeptsById(adminDeptId);
		view.addObject("contractId", adminFunDepts.getContractId());
		view.addObject("deptFlag", adminFunDepts.getDeptFlag());
		view.addObject("deptType", adminFunDepts.getDeptType());

		SoftContractDto softContractDto = adminCrmFunContractMapper.getSoftContract(adminDeptId);
		if (softContractDto==null){
			softContractDto=new SoftContractDto();
		}
		//AdminCrmPaymentTasks crmPaymentTasks = adminCrmPaymentTasksMapper.getCrmPaymentTasks(adminDeptId);
		if(softContractDto == null) {
			view.addObject("softContractError", "请联系你的销售顾问生成合同或订单!");
		} else {
			Double totalPrice = softContractDto.getTotalPrice();
			Double weiTotalPrice = Optional.ofNullable(softContractDto.getWeiTotalPrice()).orElse(0.0);
			view.addObject("bindOpenWeixin", softContractDto.getBindOpenWeixin());
			view.addObject("weiContractNo", softContractDto.getWeiContractNo());
			view.addObject("contractHtml", softPayController.buildContractUrl(softContractDto));
			view.addObject("weiContractHtml", softContractDto.getWeiContractHtml());
			view.addObject("totalPrice", totalPrice);
			view.addObject("weiTotalPrice", weiTotalPrice);
			view.addObject("contractNo", softContractDto.getContractNo());
			view.addObject("contractId", softContractDto.getContractId());
			view.addObject("totalAmount", softContractDto.getTotalAmount());
			Double unitPrice = softContractDto.getUnitPrice();
			//KA公司用完后默认原价为9800
			Integer packageType = StringUtil.paseInteger((String) operator.getAttribute("PACKAGE_TYPE"),0);
			Integer kaDeptNums = StringUtil.paseInteger((String) operator.getAttribute("KA_DEPT_NUMS"),0);
			if (packageType == 3 && kaDeptNums == 0) {
				unitPrice = new Double(9800);
			}
			if (!totalPrice.equals(unitPrice)) {
				view.addObject("unitPrice", unitPrice + "元");//原价
			}
		}
		// 花呗配置
		String huabeiRepaymentRate = adminSysParaMapper.selectParamVlue("HUABEI_REPAYMENT_RATE");
		view.addObject("huabeiRepaymentRate", huabeiRepaymentRate);
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		String isPersonalVersion = operator.isPersonalVersion()? "1" : "0";
		view.addObject("isPersonalVersion", isPersonalVersion);
		//AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), deptNo);
		view.addObject("deptNo",operator.getCompNo()+adminFunDepts.getDeptNo());
		view.addObject("pwdDesc",adminFunDepts.getPwdDesc());
		view.setViewName("ucenter/deptPay/index");
		return  view ;
	}

	@RequestMapping(value = "/result")
	public ModelAndView result(HttpServletRequest request, ModelAndView view) {
		Operator operator = getOperator();
		Integer adminDeptId = operator.getAdminDeptId();
		String deptNo = request.getParameter("deptNo");
		if(StringUtils.isNotBlank(deptNo)) {
			AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), deptNo);
			view.addObject("deptNo",operator.getCompNo()+adminFunDepts.getDeptNo());
			view.addObject("pwdDesc",adminFunDepts.getPwdDesc());
			view.addObject("deptName", adminFunDepts.getDeptName());
			view.addObject("deptAddr", adminFunDepts.getDeptAddr());
			view.addObject("deptTele", adminFunDepts.getDeptTele());
			view.addObject("deptContact", adminFunDepts.getDeptContact() + "-" + adminFunDepts.getContactPhone());
		}
		view.setViewName("ucenter/deptPay/result");
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/createPaymentTask")
	public Map<String, Object> createPaymentTask(HttpServletRequest request) {
		Operator operator = getOperator();
		Map<String, String> parameterMap = getParameterMap(request);
		parameterMap.put("cityId", String.valueOf(operator.getCityId()));
		parameterMap.put("archiveId", String.valueOf(operator.getArchiveId()));
		parameterMap.put("source", "0");
		String url = AppConfig.getCrmWebUrl() + "/crmOpenApi/contractOpenApi/createSoftOrder";
//		String url = "http://192.168.5.165:8089/crmWeb/crmOpenApi/contractOpenApi/createVipOrder";
		String postResult = HttpUtil.post(url, parameterMap);
		Map<String, Object> parseObject = JSON.parseObject(postResult, new TypeReference<Map<String, Object>>(){});
		return parseObject;
	}

	public static void main(String[] args) {
		Map<String, Object> parseObject = JSON.parseObject("{\n" +
				"  \"code\": 500,\n" +
				"  \"msg\": \"\\n### Error querying database.  Cause: java.sql.SQLException: 列名 'SOURCE' 无效。\\n### The error may exist in file [/data/project/crmWeb/WEB-INF/classes/com/myfun/repository/admindb/mapper/AdminCrmFunContractMapper.xml]\\n### The error may involve com.myfun.repository.admindb.dao.AdminCrmFunContractMapper.selectByPrimaryKey-Inline\\n### The error occurred while setting parameters\\n### SQL: select                 CONTRACT_ID, CRM_COMP_ID, DEPT_ID, CONTRACT_NO, PARTY_A, PARTY_A_ADDR, PARTY_A_TEL,      PARTY_A_LINKMAN, PARTY_A_LINKMOBILE, PARTY_A_AGENT, PARTY_B, PARTY_B_ADDR, PARTY_B_TEL,      PARTY_B_ID, PARTY_B_AGENT, SPACE_PRICE, SPACE_PAY_YEAR, SPACE_FREE_YEAR, SOFT_SUIT,      UNIT_PRICE, TOTAL_PRICE, TOTAL_PRICE_CN, TOTAL_AMOUNT, TOTAL_AMOUNT_CN, PAY_RATE,      SIGN_DATE, SIGN_EXAM, SIGN_STATUS, CONTRACT_PATH, CONTRACT_HTML, SAFETY_PATH, UPGRADE_PROTOCOL,      PAY_TYPE, SERVICE_GIFT, SRV_GIFT_EXTRA, STAGE_YEAR, PAY_GIFTED, GIFT_TYPE, GIFT_PRICE,      SIGN_USER, SIGN_TIME, REQ_UID, REQ_TIME, EXAM_UID, GIFT_TIME, CREATION_UID, TRAIN,      TICKET, CONTRACT_VERSION, BIND_OPEN_WEIXIN, YOU_DISCOUNT_EXAM, CONTRACT_TIME, BIND_CUST_LEVEL,      PAY_MODEL, IS_REFUND_PAY, PAY_MODEL_EXAMFLAG, PAY_MODEL_EXAMTIME, CUST_LEVEL_PRICE,      ACTIVITY_NUM, GIFT_VR_NUM, TRAIN_TICKET, [STATUS], CONTRACT_TYPE, SOFT_RATE, GIFT_WSK_MONEY,      SOFT_DISCOUNT_MONEY, KA_DEPT_NUMS, OLD_SOFT_INVOICE_NO, OPENING_BANK, OPENING_BANK_NUMBER,      OPENING_BANK_NAME, [SOURCE]         ,                CONTRACT_JSON         from CRM_FUN_CONTRACT     where CONTRACT_ID = ?\\n### Cause: java.sql.SQLException: 列名 'SOURCE' 无效。\\n; bad SQL grammar []; nested exception is java.sql.SQLException: 列名 'SOURCE' 无效。\",\n" +
				"  \"data\": null\n" +
				"}", new TypeReference<Map<String, Object>>(){});
		System.out.println("");
	}

}
