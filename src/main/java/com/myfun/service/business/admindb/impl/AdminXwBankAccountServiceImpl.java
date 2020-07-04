package com.myfun.service.business.admindb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.managecenter.sysmanager.param.UserPhoneValidParam;
import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.service.business.admindb.AdminXwBankAccountService;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title 新网银账户业务处理类
 * @author lcb
 * @since 2019/8/24
 * @param
 * @return
 */
@Service
public class AdminXwBankAccountServiceImpl extends AbstractService<AdminXwBankAccount, Integer> implements AdminXwBankAccountService {

	@Autowired
	AdminXwBankAccountMapper adminXwBankAccountMapper;
	@Autowired
	AdminCaseCooperateMapper adminCaseCooperateMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	AdminOnlinePaymentOrderMapper adminOnlinePaymentOrderMapper;
	@Autowired
	AdminMobileKeyService adminMobileKeyService;
	@Autowired
	AdminOnlinePaymentOrderPayeeMapper adminOnlinePaymentOrderPayeeMapper;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminXwBankAccountMapper;
	}

	@Override
	public AdminXwBankAccount checkXwBankAccountStatus(CheckAccountStatusParam param) {
		Byte accountType = param.getAccountType();
		Integer cityId = param.getCityId();
		Assert.isNullThrow(accountType, "账户类型必传");
		// 组装数据查银行账户表
		Integer accountHftIdentification = null;
		if(1 == accountType) {
			accountHftIdentification = param.getArchiveId();
		}else {
			accountHftIdentification = param.getCompId();
		}
		Assert.isNullThrow(accountHftIdentification, "账户凭证有误");

		AdminXwBankAccountExample adminXwBankAccountExample = new AdminXwBankAccountExample();
		AdminXwBankAccountExample.Criteria criteria = adminXwBankAccountExample.createCriteria();
		criteria.andCityIdEqualTo(cityId).andAccountTypeEqualTo(accountType).andAccountHftIdentificationEqualTo(accountHftIdentification);

		List<AdminXwBankAccount> adminXwBankAccounts = adminXwBankAccountMapper.selectByExample(adminXwBankAccountExample);
		// 目前逻辑是只能开唯一一个账户
		return adminXwBankAccounts.size() > 0 ? adminXwBankAccounts.get(0) : null;
	}

	@Override
	public PaymentOrderVO createOrder(PaymentOrderParam param) {
		PaymentOrderVO returnVO = new PaymentOrderVO();

		// 根据参数请求adminWeb
		String businessUrlPath = AppConfig.getAdminWebUrl() + "/onlinePay/xwBankModule/businessProcessing/onlinePayment";
//		businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/onlinePayment";

		Assert.isNullThrow(param.getOrderPaymentType(), "支付方式有误");
		if(1 == param.getOrderPaymentType()) {
			// 处理业务参数
			Assert.isNullThrow(param.getBusinessType(), "订单类型有误");
			Assert.isNullThrow(param.getBusinessId(), "订单业务有误");
			Assert.isNullThrow(param.getPfPayer(), "订单付款方信息有误");
			Byte businessType = param.getBusinessType();
			Integer businessId = param.getBusinessId();

			if(1 == businessType) {
				// 合作
				AdminCaseCooperate adminCaseCooperate = adminCaseCooperateMapper.selectByPrimaryKey(businessId);
				if(null == adminCaseCooperate) {
					throw new BusinessException("业务数据有误");
				}
				this.setBusinessInfoForCooperate(param, adminCaseCooperate);
			}else if(2 == businessType) {
				// 合同
				ErpFunDeal erpFunDeal = erpFunDealMapper.getBaseDealInfo(param.getCityId(), businessId);
				if(null == erpFunDeal) {
					throw new BusinessException("业务数据有误");
				}
				Assert.isNullThrow(param.getPfId(), "订单款项有误");

				this.setBusinessInfoForContract(param, erpFunDeal);

			}

		}else {
			Assert.isNullThrow(param.getOrderNo(), "订单编号有误");
		}

		String result = HttpUtil.postJson(businessUrlPath, param);
		if(StringUtil.isNotBlank(result)) {
			JSONObject jsonObject = JSON.parseObject(result);
			if(null != jsonObject) {
				String data = jsonObject.get("data") + "";
				returnVO = JSON.parseObject(data, PaymentOrderVO.class);
				returnVO.setResult(1);
			}
		}

		return returnVO;
	}

	/**
	 * @title 合通楼盘信息
	 * @author lcb
	 * @date 2019/8/27
	 * @param
	 * @return
	 */
	private void setBusinessInfoForContract(PaymentOrderParam param, ErpFunDeal erpFunDeal) {
		param.setBuildId(erpFunDeal.getBuildId());
		param.setBuildName(erpFunDeal.getBuildName());

		if(0 == erpFunDeal.getDealBuyStyle()) {
			param.setCustCompId(erpFunDeal.getCompId());
			param.setCustCityId(param.getCityId());
		}

		if(0 == erpFunDeal.getDealSellStyle()) {
			param.setHouseCompId(erpFunDeal.getCompId());
			param.setHouseCityId(param.getCityId());
		}

		Integer pfId = param.getPfId();
		ErpProcessFinanc erpProcessFinanc = new ErpProcessFinanc();
		erpProcessFinanc.setShardCityId(param.getCityId());
		erpProcessFinanc.setPfId(pfId);
		erpProcessFinanc = erpProcessFinancMapper.selectByPrimaryKey(erpProcessFinanc);

		// 支付方 1:客户2:业主
		Byte pfPayer = param.getPfPayer();

		String saleLeaseDes = "";
		Byte dealType = erpFunDeal.getDealType();

		String  summaryOfReceipt = "";
		if(1 == pfPayer) {

			if(101 == dealType) {
				saleLeaseDes = " 购买 ";
			}else {
				saleLeaseDes = " 租赁 ";
			}
			param.setPayerName(erpFunDeal.getBuyOwnerName());
			summaryOfReceipt = "客户 " + param.getPayerName() + " 支付 " + erpFunDeal.getSellAddress()+" 房屋" + saleLeaseDes + erpProcessFinanc.getPfName();
		}else if (2 == pfPayer) {
			if(101 == dealType) {
				saleLeaseDes = " 售卖 ";
			}else {
				saleLeaseDes = " 租赁 ";
			}
			param.setPayerName(erpFunDeal.getSellOwnerName());
			summaryOfReceipt = "业主 " + param.getPayerName() + " 支付 " +erpFunDeal.getSellAddress()+" 房屋" + saleLeaseDes +erpProcessFinanc.getPfName();
		}

		String orderBody = "";
		// 商品名称 合作是双方公司名字加佣金
		ErpFunComp houseComp = erpFunCompMapper.selectByCompId(param.getCityId(), erpFunDeal.getCompId());

		if(null != houseComp) {
			orderBody += houseComp.getCompName() + "-";
		}

		orderBody += erpProcessFinanc.getPfName();
		param.setOrderBody(orderBody);


		param.setPfName(erpProcessFinanc.getPfName());
		param.setOrderSummary(summaryOfReceipt);


//		String orderRemark = erpFunDeal.getBuildName() + " ";
//		BigDecimal area = erpFunDeal.getArea();
//		if(null != area) {
//			orderRemark += area.doubleValue() +"m² ";
//		}


//		if(101 == dealType) {
//			BigDecimal price = erpFunDeal.getSellDealMoney().divide(new BigDecimal(10000));
//			if(null != price) {
//				orderRemark += price.doubleValue()+"万";
//			}
//			param.setOrderRemark(orderRemark);
//		}else {
//			BigDecimal price = erpFunDeal.getRentDealMoney();
//			if(null != price) {
//				orderRemark += price.doubleValue()+" ";
//			}
//
//			Byte priceUnit =  erpFunDeal.getRentPriceUnit();
//			if(null != priceUnit) {
//				String priceUnitDic = erpDicDefinitionsMapper.getDicCnMsg(param.getCityId(), "PRICE_UNIT", priceUnit + "");
//
//				if(StringUtils.isNotBlank(priceUnitDic)) {
//					orderRemark += priceUnitDic;
//				}
//			}
			param.setCaseType(dealType);
//			param.setOrderRemark(orderRemark);
//		}
	}

	/**
	  * @title 合作楼盘信息
	  * @author lcb
	  * @date 2019/8/27
	  * @param
	  * @return
	  */
	private void setBusinessInfoForCooperate(PaymentOrderParam param, AdminCaseCooperate adminCaseCooperate) {

		Byte cooperateType = adminCaseCooperate.getCooperateType();
		Integer houseCityId = adminCaseCooperate.getHouseCityId();
		Integer houseId = adminCaseCooperate.getHouseId();

		Integer buildId = null;
		String buildName = "";

		// 业主
		String ownerName = "";
		String sellAdress = "";
		// 客户
		String custName = "";
		if(1 == cooperateType) {
			ErpFunSale houseBaseInfo = erpFunSaleMapper.getHouseBaseInfo(houseCityId, houseId);
			if(null == houseBaseInfo) {
				throw new BusinessException("业务数据有误");
			}
			buildId = houseBaseInfo.getBuildId();
			buildName = houseBaseInfo.getBuildName();
			ownerName = houseBaseInfo.getSaleOwner();
			sellAdress = houseBaseInfo.getTradeAddr();
			if(StringUtils.isBlank(sellAdress)) {
				sellAdress = buildName;
			}
		}else if(2 == cooperateType) {
			ErpFunLease houseBaseInfo = erpFunLeaseMapper.getHouseBaseInfo(houseCityId, houseId);
			if(null == houseBaseInfo) {
				throw new BusinessException("业务数据有误");
			}
			buildId = houseBaseInfo.getBuildId();
			buildName = houseBaseInfo.getBuildName();
			ownerName = houseBaseInfo.getLeaseOwner();
			sellAdress = houseBaseInfo.getTradeAddr();
			if(StringUtils.isBlank(sellAdress)) {
				sellAdress = buildName;
			}
		}

		param.setBuildId(buildId);
		param.setBuildName(buildName);
		param.setHouseCompId(adminCaseCooperate.getHouseCompId());
		param.setCustCompId(adminCaseCooperate.getCustCompId());
		param.setCustCityId(adminCaseCooperate.getCustCityId());
		param.setHouseCityId(adminCaseCooperate.getHouseCityId());
		// 支付方 1:客户2:业主
		Byte pfPayer = param.getPfPayer();
		String  summaryOfReceipt = "";

		if(1 == pfPayer) {
			Integer custCityId = adminCaseCooperate.getCustCityId();
			Integer custId = adminCaseCooperate.getCustId();

			String saleLeaseDes = "";
			if(1 == adminCaseCooperate.getCooperateType()) {
				ErpFunBuyCustomer funBuyCustByCustId = erpFunBuyCustomerMapper.getFunBuyCustByCustId(custCityId, custId);
				if(null == funBuyCustByCustId) {
					throw new BusinessException("业务数据有误");
				}
				custName = funBuyCustByCustId.getBuyCustName();
				saleLeaseDes = " 售卖 ";
			} else {
				ErpFunRentCustomer funRentCustByRentId = erpFunRentCustomerMapper.getFunRentCustByRentId(custCityId, custId);
				if(null == funRentCustByRentId) {
					throw new BusinessException("业务数据有误");
				}

				custName = funRentCustByRentId.getRentCustName();
				saleLeaseDes = " 租赁 ";
			}
			param.setPayerName(custName);
			summaryOfReceipt = "客户 " + custName + " 支付 " + sellAdress + " 房屋" + saleLeaseDes;
		}else if (2 == pfPayer) {
			param.setPayerName(ownerName);

			String saleLeaseDes = "";
			if(1 == adminCaseCooperate.getCooperateType()) {
				saleLeaseDes = " 购买 ";
			} else {
				saleLeaseDes = " 租赁 ";
			}
			summaryOfReceipt = "业主 "+ ownerName+" 支付 " + sellAdress + " 房屋"+ saleLeaseDes + saleLeaseDes;
		}

		String orderBody = "";
		// 商品名称 合作是双方公司名字加佣金
		ErpFunComp houseComp = erpFunCompMapper.selectByCompId(adminCaseCooperate.getHouseCityId(), adminCaseCooperate.getHouseCompId());

		if(null != houseComp) {
			orderBody += houseComp.getCompName() + "-";
		}
		ErpFunComp custComp = erpFunCompMapper.selectByCompId(adminCaseCooperate.getCustCityId(), adminCaseCooperate.getCustCompId());
		if(null != custComp) {
			orderBody += custComp.getCompName() + "-";
		}
		orderBody += "佣金";
		param.setOrderBody(orderBody);

		param.setPfName("佣金");
		summaryOfReceipt = summaryOfReceipt+param.getPfName();

		param.setOrderSummary(summaryOfReceipt);

//		String orderRemark = buildName + " ";
//		if(null != houseArea) {
//			orderRemark+=houseArea.doubleValue()+"m² ";
//		}
//
//		if(1 == cooperateType) {
//			orderRemark += totalPrice.doubleValue()+"万";
//		}else {
//			orderRemark += totalPrice.doubleValue();
//			if(null != priceUnit) {
//				String priceUnitDic = erpDicDefinitionsMapper.getDicCnMsg(adminCaseCooperate.getHouseCityId(), "PRICE_UNIT", priceUnit + "");
//				if(StringUtils.isNotBlank(priceUnitDic)) {
//					orderRemark += priceUnitDic;
//				}
//			}
//		}
		param.setCaseType(cooperateType);
//		param.setOrderRemark(orderRemark);
	}

	@Override
	public void updateNotifyStatus(UpdateNotifyStatusParam param) {
//		ErpSysParaKey erpSysParaKey = new ErpSysParaKey();
//		erpSysParaKey.setShardCityId(param.getCityId());
//		erpSysParaKey.setCompId(param.getCompId());
//		erpSysParaKey.setParamId("ONLINE_PAYMENT_NOTIFY_STATUS");
//		ErpSysPara erpSysPara = erpSysParaMapper.selectByPrimaryKey(erpSysParaKey);

		ErpSysPara erpSysPara = erpSysParaMapper.getValueById(param.getCityId(), param.getCompId(), "ONLINE_PAYMENT_NOTIFY_STATUS");

		if(null == erpSysPara) {
			erpSysPara = new ErpSysPara();
			erpSysPara.setParamId("ONLINE_PAYMENT_NOTIFY_STATUS");
			erpSysPara.setCompId(param.getCompId());
			erpSysPara.setParamValue(param.getNotifyStatus());
			erpSysPara.setParamDesc("新网在线收款通知开关");
			erpSysPara.setShardCityId(param.getCityId());
			erpSysParaMapper.insertSelective(erpSysPara);
		}else {
			erpSysPara.setParamValue(param.getNotifyStatus());
			erpSysPara.setShardCityId(param.getCityId());
			erpSysParaMapper.updateByPrimaryKey(erpSysPara);
		}
	}

	@Override
	public XwAccountPasswordVO updateXwBankAccountPassword(XwAccountPasswordParam param) {

		XwAccountPasswordVO returnVO = new XwAccountPasswordVO();

		// 根据参数请求adminWeb
		String businessUrlPath = AppConfig.getAdminWebUrl() + "/onlinePay/xwBankModule/businessProcessing/updatePassword";
//		businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/updatePassword";

		String result = HttpUtil.postJson(businessUrlPath, param);
		if(StringUtil.isNotBlank(result)) {
			JSONObject jsonObject = JSON.parseObject(result);
			if(null != jsonObject) {
				String data = jsonObject.get("data") + "";
				returnVO = JSON.parseObject(data, XwAccountPasswordVO.class);
			}
		}

		return returnVO;
	}

	@Override
	public AccountInfoVO checkAccountBankInfo(AccountBankInfoParam param) throws Exception{
		AccountInfoVO returnVO = new AccountInfoVO();
		// 请求adminWeb获取公司账户
		String businessUrlPath = AppConfig.getAdminProjectDomain() + "/onlinePay/xwBankModule/businessProcessing/accountInfo";
//		businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/accountInfo";

		String result = HttpUtil.postJson(businessUrlPath, param);
		if(StringUtils.isBlank(result)) {
			// 错误数据
			return returnVO;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Integer errCode = jsonObject.getInteger("errCode");
		if(200 != errCode) {
			return returnVO;
		}

		String data = jsonObject.getString("data");
		returnVO = JSON.parseObject(data, AccountInfoVO.class);
		if(null == returnVO || 1 != returnVO.getResult() || null == returnVO.getBankInfo()) {
			// 错误数据
			return returnVO;
		}


		// 1：个人账户 2：企业账户
		Byte accountType = returnVO.getAdminXwBankAccount().getAccountType();
		String xwBankWithdrawalServiceFee = "8";
		if(1 == accountType.intValue()) {
			// 设置费率
			xwBankWithdrawalServiceFee = adminSysParaMapper.selectParamVlue("XW_BANK_WITHDRAWAL_SERVICE_FEE_COMP");
			if(StringUtils.isBlank(xwBankWithdrawalServiceFee)) {
				xwBankWithdrawalServiceFee = "1";
			}
		}else {
			xwBankWithdrawalServiceFee = adminSysParaMapper.selectParamVlue("XW_BANK_WITHDRAWAL_SERVICE_FEE_PERSON");
			if(StringUtils.isBlank(xwBankWithdrawalServiceFee)) {
				xwBankWithdrawalServiceFee = "8";
			}
		}

		returnVO.setServiceFee(xwBankWithdrawalServiceFee);

		return returnVO;
	}

	@Override
	public WithDrawVO withDraw(WithDrawParam param) {

		WithDrawVO returnVO = new WithDrawVO();

		// 请求adminWeb获取公司账户
		String businessUrlPath = AppConfig.getAdminProjectDomain() + "/onlinePay/xwBankModule/businessProcessing/withDraw";
//		businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/withDraw";

		String result = HttpUtil.postJson(businessUrlPath, param);
		if(StringUtils.isBlank(result)) {
			// 错误数据
			return returnVO;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Integer errCode = jsonObject.getInteger("errCode");
		if(null == errCode || 200 != errCode) {
			return returnVO;
		}

		String data = jsonObject.getString("data");
		WithDrawVO accountInfoVO = JSON.parseObject(data, WithDrawVO.class);
		if(null == accountInfoVO || 1 != accountInfoVO.getResult()) {
			// 错误数据
			return returnVO;
		}
		returnVO.setRedirectUrl(accountInfoVO.getRedirectUrl());
		returnVO.setResult(accountInfoVO.getResult());
		return returnVO;
	}

	@Override
	public UpdateAccountBankInfoVO updateAccountBankInfo(UpdateAccountBankInfoParam param) {
		UpdateAccountBankInfoVO returnVO = new UpdateAccountBankInfoVO();

		// 请求adminWeb获取公司账户
		String businessUrlPath = AppConfig.getAdminProjectDomain() + "/onlinePay/xwBankModule/businessProcessing/updateAccountBankInfo";
		String result = HttpUtil.postJson(businessUrlPath, param);
		if(StringUtils.isBlank(result)) {
			// 错误数据
			return returnVO;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Integer errCode = jsonObject.getInteger("errCode");
		if(null == errCode || 200 != errCode) {
			return returnVO;
		}

		String data = jsonObject.getString("data");
		WithDrawVO accountInfoVO = JSON.parseObject(data, WithDrawVO.class);
		if(null == accountInfoVO || 1 != accountInfoVO.getResult()) {
			// 错误数据
			return returnVO;
		}
		returnVO.setRedirectUrl(accountInfoVO.getRedirectUrl());
		returnVO.setResult(accountInfoVO.getResult());
		return returnVO;
	}

	@Override
	public PreCollectOrderInfoVO queryPreCollectOrderInfo(OrderInfoParam param) {
		PreCollectOrderInfoVO returnVO = new PreCollectOrderInfoVO();

		AdminOnlinePaymentOrderExample adminOnlinePaymentOrderExample = new AdminOnlinePaymentOrderExample();
		adminOnlinePaymentOrderExample.createCriteria().andOrderNoEqualTo(param.getOrderNo()).andCityIdEqualTo(param.getCityId());
		List<AdminOnlinePaymentOrder> adminOnlinePaymentOrders = adminOnlinePaymentOrderMapper.selectByExample(adminOnlinePaymentOrderExample);
		Assert.isEmptyThrow(adminOnlinePaymentOrders, "订单信息有误");
		AdminOnlinePaymentOrder adminOnlinePaymentOrder = adminOnlinePaymentOrders.get(0);
		if(null != adminOnlinePaymentOrder.getPaymentStatus() && 1 == adminOnlinePaymentOrder.getPaymentStatus()) {
			returnVO.setPaymentStatus(adminOnlinePaymentOrder.getPaymentStatus());
			returnVO.setPaymentTime(adminOnlinePaymentOrder.getPaymentTime());
		}

		Integer compId = adminOnlinePaymentOrder.getCompId();
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(param.getCityId(), compId);

		// 查询一个accountId
		AdminOnlinePaymentOrderPayeeExample adminOnlinePaymentOrderPayeeExample = new AdminOnlinePaymentOrderPayeeExample();
		adminOnlinePaymentOrderPayeeExample.createCriteria().andOrderIdEqualTo(adminOnlinePaymentOrder.getId());
		List<AdminOnlinePaymentOrderPayee> adminOnlinePaymentOrderPayees = adminOnlinePaymentOrderPayeeMapper.selectByExample(adminOnlinePaymentOrderPayeeExample);


		returnVO.setCityId(param.getCityId());
		returnVO.setOrderNo(param.getOrderNo());
		returnVO.setOrderRemark(adminOnlinePaymentOrder.getOrderRemark());
		returnVO.setOrderAmount(adminOnlinePaymentOrder.getOrderAmount());
		returnVO.setPfName(adminOnlinePaymentOrder.getPfName());
		returnVO.setPayeeName(erpFunComp.getCompName());

		if(adminOnlinePaymentOrderPayees.size() > 0) {
			returnVO.setAccountId(adminOnlinePaymentOrderPayees.get(0).getXwBankAccountId());
		}


		return returnVO;
	}

	@Override
	public PretieCardVO pretieCard(PretieCardParam param) {
		PretieCardVO returnVO = new PretieCardVO();
		// 请求adminWeb获取公司账户
		String businessUrlPath = AppConfig.getAdminProjectDomain() + "/onlinePay/xwBankModule/businessProcessing/pretieCard";
//		businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/pretieCard";

		String result = HttpUtil.postJson(businessUrlPath, param);
		if(StringUtils.isBlank(result)) {
			// 错误数据
			return returnVO;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Integer errCode = jsonObject.getInteger("errCode");
		if(null == errCode || 200 != errCode) {
			return returnVO;
		}

		String data = jsonObject.getString("data");
		returnVO = JSON.parseObject(data, PretieCardVO.class);
		return returnVO;
	}

	@Override
	public BankTypeInfoVO cardBinQuery(BankTypeInfoParam param) {
		BankTypeInfoVO returnVO = new BankTypeInfoVO();
		// 请求adminWeb获取公司账户
		String businessUrlPath = AppConfig.getAdminProjectDomain() + "/onlinePay/xwBankModule/businessProcessing/cardBinQuery";
//        businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/cardBinQuery";
		String result = HttpUtil.postJson(businessUrlPath, param);
		if(StringUtils.isBlank(result)) {
			// 错误数据
			return returnVO;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Integer errCode = jsonObject.getInteger("errCode");
		if(null == errCode || 200 != errCode) {
			return returnVO;
		}

		String data = jsonObject.getString("data");
		returnVO = JSON.parseObject(data, BankTypeInfoVO.class);
		return returnVO;
	}

	@Override
	public ApplyAccountVO applyAccount(ApplyAccountParam param) {
		String businessUrlPath = AppConfig.getAdminWebUrl() + "/onlinePay/xwBankModule/businessProcessing/applyAccount";
//		businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/applyAccount";

		String result = HttpUtil.post(businessUrlPath, param);
		ApplyAccountVO applyAccountVO = new ApplyAccountVO();
		applyAccountVO.setResult((byte) 4);
		applyAccountVO.setReturnMsg("申请失败，请联系在线客服");
		if(StringUtil.isNotBlank(result)) {
			JSONObject jsonObject = JSON.parseObject(result);
			if(null != jsonObject) {
				String data = jsonObject.get("data") + "";
				applyAccountVO = JSON.parseObject(data, ApplyAccountVO.class);
			}
		}

		return applyAccountVO;
	}

	@Override
	public ValidateMessageVO validateMessage(ValidateMessageParam param) {
		ValidateMessageVO returnVO = new ValidateMessageVO();
		Boolean validKey = isValidKey(param);
		returnVO.setResult(validKey? 1 : 0);
		return returnVO;
	}

	/**
	 * @title  短信验证
	 * @author lcb
	 * @date   2018/9/8 18:29
	 * @desc
	 **/
	private Boolean isValidKey(ValidateMessageParam param) {
		String userMobile = param.getPhone();
		String validateKey = param.getMessageKey();
		Boolean checked = false;
		validateKey = validateKey == null ? "" : validateKey;
		Map<String, Object> resultMap = new HashMap<>();
		boolean isValid = false;
		if (!"".equals(validateKey)) {// 检测电话号码是否通过
			// 这里判断是否有定制参数
			String notValidteMsgCodeTime = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "NOT_VALIDTE_MSG_CODE_TIME");
			// 时间未过期
			if(StringUtils.isNotBlank(notValidteMsgCodeTime)) {
				boolean notValidMsgCode = DateUtil.StringToDate(notValidteMsgCodeTime).after(new Date());

				if(notValidMsgCode) {
					String commonMsgCode = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "COMMON_MSG_CODE");
					if(StringUtils.isNotBlank(commonMsgCode) && commonMsgCode.equals(validateKey)) {
						isValid = true;
					}
				}
			}

			// 如果用了通用码就不再验证了
			if (!isValid){
				isValid = adminMobileKeyService.validateSmsCode(validateKey, userMobile);
			}
		} else {// 如果没有输入验证码 检测是否打过电话认证
			isValid = adminMobileKeyService.checkMobileDialToday(userMobile);
		}
		if (isValid) {
			checked = true;
		}
		return checked;
	}
}
