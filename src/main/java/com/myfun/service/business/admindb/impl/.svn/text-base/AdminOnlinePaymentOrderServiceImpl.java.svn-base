package com.myfun.service.business.admindb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminCaseCooperateMapper;
import com.myfun.repository.admindb.dao.AdminOnlinePaymentOrderMapper;
import com.myfun.repository.admindb.dao.AdminOnlinePaymentOrderPayeeMapper;
import com.myfun.repository.admindb.dao.AdminXwBankAccountMapper;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminOnlinePaymentOrderService;
import com.myfun.utils.Assert;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.NumberHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 城市
 * 
 * @author Administrator
 *
 */
@Service
public class AdminOnlinePaymentOrderServiceImpl extends AbstractService<AdminOnlinePaymentOrder, Integer>implements AdminOnlinePaymentOrderService {

	@Autowired
	AdminOnlinePaymentOrderMapper adminOnlinePaymentOrderMapper;
	@Autowired
	AdminXwBankAccountMapper adminXwBankAccountMapper;
	@Autowired
	AdminCaseCooperateMapper adminCaseCooperateMapper;
	@Autowired
	ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	AdminOnlinePaymentOrderPayeeMapper adminOnlinePaymentOrderPayeeMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	AdminFunDeptsServiceImpl adminFunDeptsService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminOnlinePaymentOrderMapper;
	}


	@Override
	public List<OnlinePaymentOrderVO> selectOrderList(DealRecordListParam param) {
		List<OnlinePaymentOrderVO> resList = adminOnlinePaymentOrderMapper.selectOrderList(param);
		return resList;
	}

	@Override
	public List<Map<String, BigDecimal>> countWeekAmount(DealRecordListParam param) {

		List<Map<String, BigDecimal>> resList = adminOnlinePaymentOrderMapper.selectReceiveAmountList(param);
		return resList;

	}

	private Integer getAccountId(Integer cityId, Byte accountType, Integer accountHftIdentification) {
		// 为了避免多个表关联查询，这先查询账户信息
		AdminXwBankAccountExample adminXwBankAccountExample = new AdminXwBankAccountExample();
		adminXwBankAccountExample.createCriteria().andCityIdEqualTo(cityId).andAccountTypeEqualTo(accountType).
				andAccountHftIdentificationEqualTo(accountHftIdentification).andOpenAccountStatusEqualTo((byte) 3);
		List<AdminXwBankAccount> adminXwBankAccounts = adminXwBankAccountMapper.selectByExample(adminXwBankAccountExample);
		return adminXwBankAccounts.size() == 0 ? null : adminXwBankAccounts.get(0).getId();
	}

	@Override
	public CollectAmountFlagVO queryCollectAmountFlag(CollectAmountFlagParam param) {
		CollectAmountFlagVO returnVO = new CollectAmountFlagVO();
		AdminCaseCooperate adminCaseCooperate = adminCaseCooperateMapper.selectByPrimaryKey(param.getCooperateId());
		if(null == adminCaseCooperate) {
			throw new BusinessException("数据有误");
		}
		BigDecimal totalBrokerage = adminCaseCooperate.getTotalBrokerage();
		totalBrokerage = null==totalBrokerage ? BigDecimal.ZERO : totalBrokerage;

		BigDecimal bigDecimal = adminOnlinePaymentOrderMapper.sumOrderAmount(param.getCityId(), param.getCooperateId(), (byte) 1);
		bigDecimal = null == bigDecimal ? BigDecimal.ZERO : bigDecimal;

		if(bigDecimal.doubleValue() >= totalBrokerage.doubleValue()) {
			returnVO.setResult(1);
		}
		return returnVO;
	}

	@Override
	public NeedCollectAmountVO queryNeedCollectAmount(NeedCollectAmountParam param) {

		BigDecimal needCollectAmount = BigDecimal.ZERO;
		NeedCollectAmountVO returnVO = new NeedCollectAmountVO();

		Byte businessType = param.getBusinessType();
		Integer businessId = param.getBusinessId();
		if(1 == businessType) {
			// 合作
			AdminCaseCooperate adminCaseCooperate = getAdminCaseCooperate(businessId);
			BigDecimal bigDecimal = adminOnlinePaymentOrderMapper.sumOrderAmount(param.getCityId(), adminCaseCooperate.getId(), (byte) 1);
			bigDecimal = null == bigDecimal ? BigDecimal.ZERO : bigDecimal;

			needCollectAmount = adminCaseCooperate.getTotalBrokerage().subtract(bigDecimal);
		}else if(2 == businessType) {
			// 合同
			Integer pfId = param.getPfId();
			Assert.isNullThrow(pfId, "参数错误");

			ErpProcessFinanc erpProcessFinanc = new ErpProcessFinanc();
			erpProcessFinanc.setShardCityId(param.getCityId());
			erpProcessFinanc.setPfId(pfId);
			erpProcessFinanc = erpProcessFinancMapper.selectByPrimaryKey(erpProcessFinanc);
			// 查询已收的
			BigDecimal bigDecimal = erpProcessFinancMapper.sumPayAmount(param.getCityId(), erpProcessFinanc);
			bigDecimal = null == bigDecimal ? BigDecimal.ZERO : bigDecimal;

			needCollectAmount = erpProcessFinanc.getPayAmount().subtract(bigDecimal);
		}
		needCollectAmount = needCollectAmount.doubleValue() <= 0 ? BigDecimal.ZERO : needCollectAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
		returnVO.setNeedCollectAmount(needCollectAmount);
		return returnVO;
	}

	private AdminCaseCooperate getAdminCaseCooperate(Integer cooperateId) {
		return adminCaseCooperateMapper.selectByPrimaryKey(cooperateId);
	}

	@Override
	public QuickPayVO quickCollect(QuickPayParam param) {
		QuickPayVO returnVO = new QuickPayVO();
		// 请求adminWeb获取公司账户
		String businessUrlPath = AppConfig.getAdminProjectDomain() + "/onlinePay/xwBankModule/businessProcessing/quickPay";
//		businessUrlPath = "http://192.168.200.175:8089/adminWeb/onlinePay/xwBankModule/businessProcessing/quickPay";
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
		returnVO = JSON.parseObject(data, QuickPayVO.class);
		return returnVO;
	}

	@Override
	public void paySuccessCallDoBusiness(PaySuccessCallParam param) {
		// 查询订单
		AdminOnlinePaymentOrder adminOnlinePaymentOrder = adminOnlinePaymentOrderMapper.selectByPrimaryKey(param.getOrderId());
		if(null == adminOnlinePaymentOrder) {
			return;
		}
		Integer cityId = adminOnlinePaymentOrder.getCityId();
		Integer dealId = adminOnlinePaymentOrder.getBusinessId();

		ErpFunDeal dealBaseInfo = erpFunDealMapper.getBaseDealInfo(cityId, dealId);
		if(null == dealBaseInfo) {
			return;
		}

		Byte dealType = dealBaseInfo.getDealType();

		Integer pfId = adminOnlinePaymentOrder.getPfId();
		ErpProcessFinanc erpProcessFinanc = new ErpProcessFinanc();
		erpProcessFinanc.setShardCityId(adminOnlinePaymentOrder.getCityId());
		erpProcessFinanc.setPfId(pfId);

		erpProcessFinanc = erpProcessFinancMapper.selectByPrimaryKey(erpProcessFinanc);

		if(null == erpProcessFinanc) {
			return;
		}
		AdminOnlinePaymentOrderPayeeExample example = new AdminOnlinePaymentOrderPayeeExample();
		example.createCriteria().andOrderIdEqualTo(param.getOrderId());
		List<AdminOnlinePaymentOrderPayee> adminOnlinePaymentOrderPayees = adminOnlinePaymentOrderPayeeMapper.selectByExample(example);

		for (AdminOnlinePaymentOrderPayee adminOnlinePaymentOrderPayee : adminOnlinePaymentOrderPayees) {

			ErpProcessFinanc addFinancPo = new ErpProcessFinanc();
			addFinancPo.setPfName(adminOnlinePaymentOrder.getPfName());
			addFinancPo.setShardCityId(adminOnlinePaymentOrder.getCityId());
			addFinancPo.setAuditStatus("1");
			addFinancPo.setAuditTime(new Date());
			addFinancPo.setPaymentId(erpProcessFinanc.getPaymentId());
			addFinancPo.setCompId(adminOnlinePaymentOrderPayee.getCompId());
			addFinancPo.setCreateTime(adminOnlinePaymentOrder.getPaymentTime());
			addFinancPo.setCreateUid(999);
			addFinancPo.setDealId(adminOnlinePaymentOrder.getBusinessId());
			addFinancPo.setPayAmount(adminOnlinePaymentOrderPayee.getReceivedAmount());
			addFinancPo.setPfTime(new Date());
			addFinancPo.setPfActual((byte) 1);
			addFinancPo.setPayType(3);
			addFinancPo.setPfPayer(adminOnlinePaymentOrder.getPayer() + "");
			addFinancPo.setPfGeter(Const.DIC_PFMAN_BROKER);
			if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType.intValue())){
				addFinancPo.setPerformanceType((byte)2);//二手佣金
			}else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType.intValue())){
				addFinancPo.setPerformanceType((byte)4);//租赁佣金
			}

			addFinancPo.setReceiptMoneyUser(adminOnlinePaymentOrder.getUserId());
			addFinancPo.setReceiptMoneyDept(adminOnlinePaymentOrder.getDeptId());
			addFinancPo.setPayTypeDesc("在线支付");
			addFinancPo.setOnlinePaymentReceiptFileId(param.getReceiptFileId());

			erpProcessFinancMapper.insertSelective(addFinancPo);
		}


	}

	@Override
	public SmallProgramInfoParamVO getQuickCollectSmallProgramInfo(SmallProgramInfoParam param) {
		SmallProgramInfoParamVO returnVO = new SmallProgramInfoParamVO();

		String orderNo = param.getOrderNo();

		String title = "";
		AdminOnlinePaymentOrderExample onlinePaymentOrderExample = new AdminOnlinePaymentOrderExample();
		onlinePaymentOrderExample.createCriteria().andOrderNoEqualTo(orderNo);
		List<AdminOnlinePaymentOrder> adminOnlinePaymentOrders = adminOnlinePaymentOrderMapper.selectByExample(onlinePaymentOrderExample);
		if(adminOnlinePaymentOrders.size() > 0) {
			AdminOnlinePaymentOrder adminOnlinePaymentOrder = adminOnlinePaymentOrders.get(0);
			String deptName = adminOnlinePaymentOrder.getDeptName();
			String pfName = adminOnlinePaymentOrder.getPfName();
			BigDecimal orderAmount = adminOnlinePaymentOrder.getOrderAmount();
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(adminOnlinePaymentOrder.getCityId(), adminOnlinePaymentOrder.getUserId());


			title = deptName + erpFunUsers.getUserName()+"邀请您支付"+pfName+orderAmount.doubleValue()+"元";

			String appIdByVersion = adminFunDeptsService.getAppIdByVersion(adminOnlinePaymentOrder.getArchiveId());
			returnVO.setAppId(appIdByVersion);
		}

		returnVO.setTitle(title);
		returnVO.setShareAppPath("packageShare/pages/quickPay/quickPay");
		returnVO.setShareUrl("packageShare/pages/quickPay/quickPay");
		returnVO.setImgUrl("http://img01-uat.m1200.com.cn/oss/online/nihao/2019/09/17/95d7ae1858954ccbbcb81ea944b0f131.png");

		return returnVO;
	}

	public static void main(String[] args) {
		BigDecimal needCollectAmount = new BigDecimal(0.53);
		needCollectAmount = needCollectAmount.doubleValue() <= 0 ? BigDecimal.ZERO : needCollectAmount;

		NumberHelper.formatNumber(needCollectAmount.doubleValue(), NumberHelper.NUMBER_IN_2);
		System.out.println(needCollectAmount);
	}
}
