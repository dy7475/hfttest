package com.myfun.service.business.erpdb.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;


import com.myfun.repository.erpdb.dao.ErpFunBillCodelogMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunBillCodelog;
import com.myfun.service.business.erpdb.ErpEarbestDepositCommService;
import com.myfun.service.business.erpdb.ErpFunBillCodelogService;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.erpWeb.managecenter.transaction.param.ConvertDepositHouseParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToCommssionParam;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToOwnerParam;
import com.myfun.erpWeb.managecenter.transaction.param.RefundDepositParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDepositStatusParam;
import com.myfun.erpWeb.managecenter.transaction.vo.CustInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.DepositVO;
import com.myfun.erpWeb.managecenter.transaction.vo.HouseInfoVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.util.rijindael.AESHelper;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDepositLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunDepositMapper;
import com.myfun.repository.erpdb.dao.ErpFunFinancPaymentMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.po.ErpFunBill;
import com.myfun.repository.erpdb.po.ErpFunBillExample;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.erpdb.po.ErpFunDepositLog;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyrecord;
import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.erpdb.po.ErpFunFinancPaymentExample;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBillService;
import com.myfun.service.business.erpdb.ErpFunDealRecordService;
import com.myfun.service.business.erpdb.ErpFunDepositService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpProcessFinanceService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SyncUtil;

import io.swagger.annotations.ApiModelProperty;

@Service
@Transactional
public class ErpFunDepositServiceImpl extends AbstractService<ErpFunDeposit, ErpFunDeposit> implements ErpFunDepositService {
	
	@Autowired private ErpFunDepositMapper erpFunDepositMapper;
	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired private ErpFunDepositLogMapper erpFunDepositLogMapper;
	@Autowired private ErpFunBillService erpFunBillService;
	@Autowired private ErpFunBillMapper erpFunBillMapper;
	@Autowired private ErpProcessFinanceService erpProcessFinanceService;
	@Autowired private ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
	@Autowired private ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired private ErpFunDealMapper erpFunDealMapper;
	@Autowired private ErpFunDealRecordService erpFunDealRecordService;
	@Autowired private ErpFunBillCodelogService erpFunBillCodelogService;
	@Autowired private ErpFunBillCodelogMapper erpFunBillCodelogMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Autowired private ErpEarbestDepositCommService erpEarbestDepositCommService;

	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunDepositMapper;
	}
	
	public void updateFunDepositDetail(UpdateDepositDetailParam param) {
		Date currentDate = new Date();
		ErpFunDeposit updateModel = new ErpFunDeposit();
		updateModel.setShardCityId(param.getCityId());
		updateModel.setId(param.getId());
		updateModel.setUpdateTime(new Date());
		updateModel.setBillCodeId(param.getBillCodeId());
		updateModel.setBillWay(param.getBillWay());
		updateModel.setBillPhoto(param.getBillPhoto());
		updateModel.setDepositRemark(param.getDepositRemark());
		updateModel.setBillCodeNo(param.getBillCodeNo());
		updateModel.setReceiptMoney(param.getReceiptMoney());
		updateModel.setCustMobile(param.getCustMobile());
		updateModel.setCustName(param.getCustName());
		ErpFunDeposit oldModel = new ErpFunDeposit();
		oldModel.setShardCityId(param.getCityId());
		oldModel.setId(param.getId());
		oldModel = erpFunDepositMapper.selectByPrimaryKey(oldModel);
		String currUserName = erpFunUsersService.getCurrUserName(param.getCityId(), param.getUserId(), param.getDeptId());
		String logContent =  " 修改了定金";
		// 收据编号
		boolean isEditFlag = false;
		if (Objects.nonNull(param.getBillCodeNo())) {
			if ((StringUtil.isBlank(param.getBillCodeNo()) && StringUtil.isNotBlank(oldModel.getBillCodeNo()))
					||(StringUtil.isNotBlank(param.getBillCodeNo()) && !param.getBillCodeNo().equals(oldModel.getBillCodeNo()))){
				String newReceiptNo = param.getBillCodeNo();
				String oldReceiptNo = oldModel.getBillCodeNo();
				if (StringUtil.isBlank(oldReceiptNo)) {
					oldReceiptNo = "空";
				}
				if (StringUtil.isBlank(newReceiptNo)) {
					newReceiptNo = "空";
				}
				logContent = logContent + " " + "收据编号:" + oldReceiptNo + " >> " + newReceiptNo;
				isEditFlag = true;
				if (erpFunBillService.checkBillCodeRepeat(param.getCityId(),param.getCompId(),newReceiptNo)) {
					throw new BusinessException("该收据编号重复！");
				}
				erpFunBillCodelogService.deduceCodeNoEmptyToRepeatUse(oldReceiptNo,newReceiptNo,param.getCompId(),param.getCityId());
				erpFunBillMapper.updateDepositBillNo(param.getCityId(), param.getCompId(), param.getBillCodeNo(), oldModel.getId());
			}
		}
		// 收款金额
		if ((param.getReceiptMoney() != null && !param.getReceiptMoney().equals(oldModel.getReceiptMoney()))){
			BigDecimal oldReceiptMoney = oldModel.getReceiptMoney() == null ?BigDecimal.ZERO:oldModel.getReceiptMoney();
			BigDecimal newReceiptMoney = param.getReceiptMoney() == null ?BigDecimal.ZERO:param.getReceiptMoney();
			if (!NumberHelper.formatNumber(oldReceiptMoney.toString(), NumberHelper.NUMBER_IN_2).equals(NumberHelper.formatNumber(newReceiptMoney.toString(), NumberHelper.NUMBER_IN_2))) {
				isEditFlag = true;
				logContent = logContent + " " + "金额:" + NumberHelper.formatNumber(oldReceiptMoney.toString(), NumberHelper.NUMBER_IN_2) + " >> " + NumberHelper.formatNumber(newReceiptMoney.toString(), NumberHelper.NUMBER_IN_2);
			}
		}
		// 出票方式  0电子票据 1纸质票薄 2手动录入
		if ((param.getBillWay() != null && !param.getBillWay().equals(oldModel.getBillWay()))){
			isEditFlag = true;
			String oldBillWay = getBillWayString(oldModel.getBillWay());
			String newBillWay = getBillWayString(param.getBillWay());
			logContent = logContent + " " + "出票方式:" + oldBillWay + " >> " + newBillWay;
		}
		// 出票方式  0电子票据 1纸质票薄 2手动录入
		if (Objects.nonNull(param.getCustMobile())) {
			if ((param.getCustMobile() == null && oldModel.getCustMobile() != null)
					|| (param.getCustMobile() != null && !param.getCustMobile().equals(oldModel.getCustMobile()))){
				isEditFlag = true;
				String newRemark = param.getCustMobile();
				String oldRemark = oldModel.getCustMobile();
				if(StringUtil.isBlank(oldRemark)){
					oldRemark = "空";
				}
				if(StringUtil.isBlank(newRemark)){
					newRemark = "空";
				}
				logContent = logContent + " " + "付款人电话:" + oldRemark + " >> " + newRemark;
			}
		}

		// 出票方式  0电子票据 1纸质票薄 2手动录入
		if (Objects.nonNull(param.getCustName())) {
			if ((param.getCustName() == null && oldModel.getCustName() != null)
					|| (param.getCustName() != null && !param.getCustName().equals(oldModel.getCustName()))){
				isEditFlag = true;
				String newRemark = param.getCustName();
				String oldRemark = oldModel.getCustName();
				if(StringUtil.isBlank(oldRemark)){
					oldRemark = "空";
				}
				if(StringUtil.isBlank(newRemark)){
					newRemark = "空";
				}
				logContent = logContent + " " + "付款人:" + oldRemark + " >> " + newRemark;
			}
		}
		
		// 定金备注
		if (Objects.nonNull(param.getDepositRemark())) {
			if ((param.getDepositRemark() == null && oldModel.getDepositRemark() != null)
					|| (param.getDepositRemark() != null && !param.getDepositRemark().equals(oldModel.getDepositRemark()))){
				isEditFlag = true;
				String newRemark = param.getDepositRemark();
				String oldRemark = oldModel.getDepositRemark();
				if(StringUtil.isBlank(oldRemark)){
					oldRemark = "空";
				}
				if(StringUtil.isBlank(newRemark)){
					newRemark = "空";
				}
				logContent = logContent + " " + "备注:" + oldRemark + " >> " + newRemark;
			}
		}
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(param.getCustName())) {
            sb.append(param.getCustName()).append(",");
        } else if (StringUtils.isNotBlank(oldModel.getCustName())) {
        	sb.append(oldModel.getCustName()).append(",");
        }
		if (StringUtils.isNotBlank(oldModel.getCustIdcard())) {
			sb.append(oldModel.getCustIdcard()).append(",");
		}
		if (StringUtils.isNotBlank(param.getBillCodeNo())) {
            sb.append(param.getBillCodeNo()).append(",");
        } else if (StringUtils.isNotBlank(oldModel.getBillCodeNo())) {
        	sb.append(oldModel.getBillCodeNo()).append(",");
        }
		updateModel.setIntelligentSearch(sb.toString());
		erpFunDepositMapper.updateByPrimaryKeySelective(updateModel);
		//写日志
		if (isEditFlag) {
			ErpFunDepositLog log = new ErpFunDepositLog();
			log.setCompId(param.getCompId());
			log.setDepositId(param.getId());
			log.setCreateTime(currentDate);
			log.setCreateUserId(param.getUserId());
			log.setLogContent(currUserName + logContent);
			log.setShardCityId(param.getCityId());
			erpFunDepositLogMapper.insertSelective(log);
		}
	}
	
	/**
	 * 新增定金
	 * @param param
	 * @throws Exception
	 */
	public ErpFunDeposit insertDepositDetail(InsertDepositDetailParam param) throws Exception {
		//1.判重
		Date dateNow = new Date();
		ErpFunDeposit deposit = new ErpFunDeposit();
		BeanUtils.copyProperties(param, deposit);
		deposit.setOperationType(Byte.valueOf("0"));
		deposit.setDepositStatus(Byte.valueOf("0"));
		deposit.setShardCityId(param.getCityId());
		deposit.setCreateTime(dateNow);
		deposit.setUpdateTime(dateNow);
		deposit.setCreateUserId(param.getUserId());
		
		deposit.setDeptId(param.getDeptId());
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(deposit.getCustName())) {
			sb.append(deposit.getCustName()).append(",");
		}
		if (StringUtils.isNotBlank(deposit.getBillCodeNo())) {
			sb.append(deposit.getBillCodeNo()).append(",");
		}
		if (StringUtils.isNotBlank(deposit.getCustIdcard())) {
			sb.append(deposit.getCustIdcard()).append(",");
		}
		deposit.setIntelligentSearch(sb.toString());
		if (erpFunBillService.checkBillCodeRepeat(param.getCityId(),param.getCompId(),param.getBillCodeNo())) {
			throw new BusinessException("该收据编号重复！");
		}
		erpFunDepositMapper.insertSelective(deposit);
		erpFunBillService.createBill(param.getCityId(), param.getCompId(), param.getAreaId(), param.getRegId(), param.getDeptId(), param.getDeptId(), param.getUserId(),
				null, null, null, null, null, null,deposit, false);

		ErpFunDepositLog log = new ErpFunDepositLog();
		log.setShardCityId(param.getCityId());
		log.setCompId(param.getCompId());
		log.setCreateUserId(param.getUserId());
		log.setCreateTime(dateNow);
		log.setDepositId(deposit.getId());
		String money = new DecimalFormat("0.##").format(param.getReceiptMoney());
		log.setLogContent("收到定金"+money+"元，票据号"+param.getBillCodeNo());
		erpFunDepositLogMapper.insertSelective(log);
		if (param.isFJD()) {
			erpEarbestDepositCommService.writeCaseStatusAndTrackForDepositAdd(param.getCityId(), deposit, false);
		}
		return deposit;
	}
	
	private String getBillWayString(Byte billWay) {
		String billWayName = "电子票据";
		if (1 == billWay) {
			billWayName = "纸质票簿";
		} else if (2 == billWay) {
			billWayName = "手动录入";
		}
		return billWayName;
	}

	@Override
	public ErpFunDeposit payDepositToCommssion(PayDepositToCommssionParam param) throws Exception {
		//1.转佣金的时候 a.是否所有审核通过 a.验证余额还能够转佣金 b.生成财务款项c.写合同日志d.生成一条转佣的记录，状态已经审核，已转佣
		//进入service层,那么就是应该从第3步开始走
		//[{\"billCodeId\":\"\",\"billCodeNo\":\"\",\"orderId\":\"\",\"payAccount\":\"\",\"payAmount\":\"10000\",\"payTypeDesc\":\"\",\"paymentId\":\"8627\",\"performanceType\":\"2\",\"pfActual\":\"1\",\"pfDesc\":\"\",\"pfGeter\":\"3\",\"pfGeterText\":\"中介\",\"pfId\":\"92145\",\"pfName\":\"佣金\",\"pfPayer\":\"1\",\"pfPayerText\":\"客户\",\"pfTime\":\"2019-09-24\",\"receiptMoneyUser\":\"\"},{\"billCodeId\":\"\",\"billCodeNo\":\"\",\"orderId\":\"\",\"payAccount\":\"\",\"payAmount\":\"10000\",\"payTypeDesc\":\"\",\"paymentId\":\"8627\",\"performanceType\":\"2\",\"pfActual\":\"1\",\"pfDesc\":\"\",\"pfGeter\":\"3\",\"pfGeterText\":\"中介\",\"pfId\":\"92146\",\"pfName\":\"佣金\",\"pfPayer\":\"2\",\"pfPayerText\":\"业主\",\"pfTime\":\"2019-09-24\",\"receiptMoneyUser\":\"\"},{\"billCodeId\":\"\",\"billCodeNo\":\"\",\"orderId\":\"\",\"payAccount\":\"\",\"payAmount\":\"2000\",\"payTypeDesc\":\"\",\"paymentId\":\"20848\",\"performanceType\":\"0\",\"pfActual\":\"1\",\"pfDesc\":\"\",\"pfGeter\":\"3\",\"pfGeterText\":\"中介\",\"pfId\":\"\",\"pfName\":\"租赁佣金\",\"pfPayer\":\"1\",\"pfPayerText\":\"客户\",\"pfTime\":\"2019-09-18\",\"receiptMoneyUser\":\"20072914\"}]","pfActual":"1"}
		ErpFunDeposit deposit = param.getDeposit();
		Byte caseType = deposit.getCaseType();
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		GeneralParam  generalParam = param.getGeneralParam();
		ErpProcessFinanc insertModel = new ErpProcessFinanc();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType.intValue())) {
			insertModel.setPfName("佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("佣金",cityId,compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
			insertModel.setPerformanceType((byte)2);//二手佣金
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType.intValue())){
			insertModel.setPfName("租赁佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("租赁佣金", cityId, compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
			insertModel.setPerformanceType((byte)4);//租赁佣金
		}
		insertModel.setPfPayer(param.getPfPayer().toString());
		insertModel.setCompId(compId);
		insertModel.setDealId(deposit.getDealId());
		insertModel.setIsProfit((byte)1);
		insertModel.setPfActual((byte)1);
		//单门店直接审核
		insertModel.setAuditStatus("1");
		insertModel.setPfGeter(Const.DIC_PFMAN_BROKER);
		insertModel.setPayAmount(param.getCommssion());
		insertModel.setPfTime(new Date());
		insertModel.setDiscount(new BigDecimal(100));
		insertModel.setSourceId(deposit.getId());
		insertModel.setItemSource(Byte.valueOf("2"));
		insertModel.setShardCityId(cityId);
		insertModel.setCreateTime(new Date());
		insertModel.setCreateUid(generalParam.getUserId());
		insertModel.setPfDesc("定金转佣金-" + param.getDepositRemark()==null?"":param.getDepositRemark());
		erpProcessFinancMapper.insertSelective(insertModel);
		param.setPfId(insertModel.getPfId());
		//更新合同上应收实收金额
		erpProcessFinanceService.updateNeedandRealIncomeOffDeal(param.getCityId(),param.getCompId(),deposit.getDealId());
		String  currentDeptUserName = getCurrUserName(generalParam.getCompType(), generalParam.getUserName(), generalParam.getDeptName(), generalParam.isPersonalVersion());
		//ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getBaseDealInfo(cityId,deposit.getDealId());
		String trackContent = currentDeptUserName+" 操作了定金转佣金：  "+insertModel.getPfName()+" "+NumberHelper.formatNumber(insertModel.getPayAmount().toString(), NumberHelper.NUMBER_IN_2)+" "+DateTimeHelper.formatDateTimetoString(insertModel.getPfTime(),DateTimeHelper.FMT_yyyyMMdd);
		erpFunDealRecordService.writeDealRecord(generalParam,deposit.getDealId(), null,
				Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACUPDATE, (byte)1, trackContent, 1,
				(byte)1, false,null);
		//生成一条转佣金记录
		//写日志
		ErpFunDeposit model = new ErpFunDeposit();
		BeanUtils.copyProperties(deposit, model);
		model.setShardCityId(param.getCityId());
		model.setId(null);
		model.setBillCodeId(null);
		model.setBillCodeNo(null);
		model.setBillPhoto(null);
		model.setBillWay(null);
		model.setAuditDeptId(null);
		model.setAuditTime(null);
		model.setAuditUserId(null);
		model.setDepositStatus(Byte.valueOf("1")); //默认已审核
		model.setOperationType(Byte.valueOf("3")); //转佣
		model.setCreateTime(new Date());
		model.setCreateUserId(generalParam.getUserId());
		model.setReceiptMoney(param.getCommssion());
		model.setDepositRemark(param.getDepositRemark());
		String custName = null;
		String custMobile = null;
		String custIdcard = null;
		Byte idCardType = null;
		if ("1".equals(insertModel.getPfPayer())) {
			//客户
			CustInfoVO custInfo = param.getCustInfo();
			custName = custInfo.getCustomerName();
			custMobile = custInfo.getCustomerCellPhone();
			custIdcard = custInfo.getCustomerIdCard();
			idCardType = custInfo.getCustomerIdCardType();
			model.setOperationType(Byte.valueOf("3"));//转客户佣金
		} else {
			//业主
			HouseInfoVO houseInfo = param.getHouseInfo();
			custName = houseInfo.getOwnerName();
			custMobile = houseInfo.getHouseCellPhone();
			custIdcard = houseInfo.getHouseIdCard();
			idCardType = houseInfo.getHouseIdCardType();
			model.setOperationType(Byte.valueOf("6"));//转客户佣金
		}
		custMobile = decodePhoneForHouseDetailOfFirst(custMobile, true);
		model.setCustMobile(custMobile);
		custIdcard = EnCodeHelper.decode(custIdcard);
		custIdcard = SyncUtil.decodeIDCARDDetail(custIdcard);
		model.setCustIdcard(custIdcard);
		model.setCustName(custName);
		model.setCustIdCardType(idCardType);
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(model.getCustName())) {
			sb.append(model.getCustName()).append(",");
		}
		if (StringUtils.isNotBlank(model.getBillCodeNo())) {
			sb.append(model.getBillCodeNo()).append(",");
		}
		if (StringUtils.isNotBlank(model.getCustIdcard())) {
			sb.append(model.getCustIdcard()).append(",");
		}
		model.setIntelligentSearch(sb.toString());
		erpFunDepositMapper.insertSelective(model);
		ErpFunDepositLog log = new ErpFunDepositLog();
		log.setCompId(param.getCompId());
		log.setDepositId(param.getId());
		log.setCreateTime(new Date());
		log.setCreateUserId(param.getUserId());
		log.setShardCityId(param.getCityId());
		if ("1".equals(insertModel.getPfPayer())) {
			log.setLogContent(currentDeptUserName + " 转客户佣金"+NumberHelper.formatNumber(param.getCommssion().toString(), NumberHelper.NUMBER_IN_2)+"元");
		} else {
			log.setLogContent(currentDeptUserName + " 转业主佣金"+NumberHelper.formatNumber(param.getCommssion().toString(), NumberHelper.NUMBER_IN_2)+"元");
		}
		erpFunDepositLogMapper.insertSelective(log);
		return model;
	} 
	
		/**
		 * 通用的获取部门加用户名的方法
		 * @param
		 * @return
		 * @auther 胡坤
		 * @since 2018/7/11
		 */
	private String getCurrUserName(Integer compType, String userName, String deptName, Boolean personalVersion) {
		// 不是纯精英版也不是专业版 才写门店名称
		if (!Constants_DIC.DIC_COMP_TYPE_2.equals(compType) && !personalVersion) {
			userName = deptName + " " + userName;
		}
		return userName;
	}
	
	private ErpFunFinancPayment getDefaultProcessFinanc(String name, Integer cityId, Integer compId) {
		ErpFunFinancPaymentExample funFinancPaymentExample = new ErpFunFinancPaymentExample();
		funFinancPaymentExample.setShardCityId(cityId);
		funFinancPaymentExample.createCriteria().andCompIdEqualTo(compId).andCanDelEqualTo(0).andPaymentNameEqualTo(name);
		List<ErpFunFinancPayment> erpFunFinancPayments = erpFunFinancPaymentMapper.selectByExample(funFinancPaymentExample);
		if(erpFunFinancPayments.size() > 0) {
			return erpFunFinancPayments.get(0);
		}
		return null;
	}

	@Override
	public void updateDepositStatus(UpdateDepositStatusParam param) {
		
		GeneralParam generalParam = param.getGeneralParam();
		ErpFunDeposit oldModel = new ErpFunDeposit();
		oldModel.setShardCityId(generalParam.getCityId());
		oldModel.setId(param.getId());
		oldModel = erpFunDepositMapper.selectByPrimaryKey(oldModel);
		if (!param.getDepositStatus().equals(oldModel.getDepositStatus())) {
			if (
					(Byte.valueOf("0").equals(param.getDepositStatus()) && Byte.valueOf("1").equals(oldModel.getDepositStatus()) && oldModel.getDealId()==null) 
					|| ((Byte.valueOf("1").equals(param.getDepositStatus()) && Byte.valueOf("0").equals(oldModel.getDepositStatus())))
					|| (Byte.valueOf("2").equals(param.getDepositStatus()) && Byte.valueOf("0").equals(oldModel.getDepositStatus()) && Byte.valueOf("0").equals(oldModel.getOperationType()))) {
				ErpFunDeposit record = new ErpFunDeposit();
				record.setShardCityId(generalParam.getCityId());
				record.setId(param.getId());
				if (!Byte.valueOf("2").equals(param.getDepositStatus())) {
					record.setDepositStatus(param.getDepositStatus());
				} else {
					record.setOperationType(Byte.valueOf("5"));//作废
					record.setDepositStatus(param.getDepositStatus());
					record.setDepositStatus(Byte.valueOf("1"));
					String invalidBillNoCanUseAgain = erpSysParaMapper.getParamValue(generalParam.getCityId(), generalParam.getCompId(), "INVALID_BILLNO_CAN_USE_AGAIN");
					if ("1".equals(invalidBillNoCanUseAgain)) {
						List<ErpFunBillCodelog> list = erpFunBillCodelogMapper.getFunBillCodelogByCodeNo(generalParam.getCityId(), generalParam.getCompId(), record.getBillCodeNo());
						if (!list.isEmpty()) {
							ErpFunBillCodelog billCodelog = list.get(0);
							billCodelog.setUseStatus((byte)0);
							billCodelog.setShardCityId(generalParam.getCityId());
							erpFunBillCodelogMapper.updateByPrimaryKeySelective(billCodelog);
						}
					}
				}
				if (Byte.valueOf("1").equals(param.getDepositStatus())) {
					record.setAuditUserId(generalParam.getUserId());
					record.setAuditDeptId(generalParam.getDeptId());
					record.setAuditTime(new Date());
				}
				if (Byte.valueOf("0").equals(param.getDepositStatus())) {
					erpFunDepositMapper.clearAuditInfo(generalParam.getCityId(),param.getId());
				}
				erpFunDepositMapper.updateByPrimaryKeySelective(record);
				String currentDeptUserName = getCurrUserName(generalParam.getCompType(), generalParam.getUserName(), generalParam.getDeptName(), generalParam.isPersonalVersion());
				ErpFunDepositLog log = new ErpFunDepositLog();
				log.setCompId(generalParam.getCompId());
				log.setDepositId(param.getId());
				log.setCreateTime(new Date());
				log.setCreateUserId(generalParam.getUserId());
				log.setLogContent(currentDeptUserName + " " + Const.depositTransMap.get(param.getDepositStatus()) +"票据号为"+oldModel.getBillCodeNo()+"定金");
				log.setShardCityId(generalParam.getCityId());
				erpFunDepositLogMapper.insertSelective(log);
				if (Objects.equals((byte) 5, record.getOperationType()) && param.isFJD()) {
					//作废该单据判断是否需要重置房源状态
					erpEarbestDepositCommService.judgeAndResetHouseDepositStatus(generalParam.getCityId(), oldModel);
				}
			} else {
				throw new BusinessException("此定金不能操作"+ Const.depositTransMap.get(param.getDepositStatus()) +"!");
			}
		}
	}

	@Override
	public void convertDepositHouse(ConvertDepositHouseParam param) {
		GeneralParam generalParam = param.getGeneralParam();
		ErpFunDeposit oldModel = new ErpFunDeposit();
		Date dateNow = new Date();
		oldModel.setShardCityId(generalParam.getCityId());
		oldModel.setId(param.getId());
		oldModel = erpFunDepositMapper.selectByPrimaryKey(oldModel);
		if (!(Byte.valueOf("0").equals(oldModel.getOperationType()) && Byte.valueOf("0").equals(oldModel.getDepositStatus()))) {
			throw new BusinessException("此定金不能转房源！");
		}
		if (Objects.equals(param.getCaseId(), oldModel.getCaseId())) {
			throw new BusinessException("已绑定当前房源！");
		}
		ErpFunDeposit model = new ErpFunDeposit();
		BeanUtils.copyProperties(oldModel, model);
		model.setShardCityId(generalParam.getCityId());
		model.setId(null);
		model.setDepositStatus(Byte.valueOf("0")); //默认未审核
		model.setOperationType(Byte.valueOf("0")); //转房源佣
		model.setAuditUserId(null);
		model.setAuditTime(null);
		model.setAuditDeptId(null);
		model.setCreateTime(dateNow);
		model.setUpdateTime(dateNow);
		model.setCaseId(param.getCaseId());
		model.setCaseType(param.getCaseType().byteValue());
		model.setBuildId(param.getBuildId());
		model.setCaseNo(param.getCaseNo());
		model.setBuildName(param.getBuildName());
		model.setCreateUserId(generalParam.getUserId());
		erpFunDepositMapper.insertSelective(model);
		ErpFunDeposit record = new ErpFunDeposit();
		record.setShardCityId(generalParam.getCityId());
		record.setUpdateTime(dateNow);
		record.setId(param.getId());
		record.setOperationType(Byte.valueOf("1"));
		record.setDepositStatus(Byte.valueOf("1"));
		erpFunDepositMapper.updateByPrimaryKeySelective(record);
		ErpFunBillExample example = new ErpFunBillExample();
		example.setShardCityId(generalParam.getCityId());
		example.createCriteria().andCompIdEqualTo(generalParam.getCompId()).andDepositIdEqualTo(param.getId());
		List<ErpFunBill> billList = erpFunBillMapper.selectByExample(example);
		if (!billList.isEmpty()) {
			ErpFunBill bill = billList.get(0);
			ErpFunBill newBill = new ErpFunBill();
			newBill.setId(bill.getId());
			newBill.setShardCityId(generalParam.getCityId());
			newBill.setDepositId(model.getId());
			erpFunBillMapper.insertSelective(newBill);
		}
		
		String currentDeptUserName = getCurrUserName(generalParam.getCompType(), generalParam.getUserName(), generalParam.getDeptName(), generalParam.isPersonalVersion());
		ErpFunDepositLog log = new ErpFunDepositLog();
		log.setCompId(generalParam.getCompId());
		log.setDepositId(param.getId());
		log.setCreateTime(new Date());
		log.setCreateUserId(generalParam.getUserId());
		//将票据号为xxxs定金更换了房源
		log.setLogContent(currentDeptUserName + " 将票据号为" + oldModel.getBillCodeNo() + "定金更换了房源");
		log.setShardCityId(generalParam.getCityId());
		erpFunDepositLogMapper.insertSelective(log);
		if (param.isFJD()) {
			//原房源取消收定
			erpEarbestDepositCommService.cancelHouseDeposit(generalParam.getCityId(),oldModel);
			//新房源添加收定
			erpEarbestDepositCommService.writeCaseStatusAndTrackForDepositAdd(generalParam.getCityId(), model, false);
		}
	}

	@Override
	public void refundDeposit(RefundDepositParam param) {
		Date dateNow = new Date();
		GeneralParam generalParam = param.getGeneralParam();
		ErpFunDeposit deposit = param.getDeposit();
		ErpFunDeposit model = new ErpFunDeposit();
		BeanUtils.copyProperties(deposit, model);
		model.setShardCityId(generalParam.getCityId());
		model.setId(null);
		model.setDepositStatus(Byte.valueOf("1")); //默认审核
		model.setOperationType(Byte.valueOf("4")); //退款
		model.setBillCodeId(null);
		model.setBillCodeNo(null);
		model.setBillPhoto(null);
		model.setBillWay(null);
		model.setAuditUserId(null);
		model.setAuditTime(null);
		model.setAuditDeptId(null);
		model.setCreateUserId(generalParam.getUserId());
		model.setCreateTime(dateNow);
		model.setUpdateTime(dateNow);
		model.setReceiptMoney(param.getRefundMoney());
		model.setDepositRemark(param.getDepositRemark());
		String custName = null;
		String custMobile = null;
		String custIdcard = null;
		Byte idCardType = null;
		//客户
		CustInfoVO custInfo = param.getCustInfo();
		custName = custInfo.getCustomerName();
		custMobile = custInfo.getCustomerCellPhone();
		custIdcard = custInfo.getCustomerIdCard();
		idCardType = custInfo.getCustomerIdCardType();
		custMobile = decodePhoneForHouseDetailOfFirst(custMobile, true);
		model.setCustMobile(custMobile);
		custIdcard = EnCodeHelper.decode(custIdcard);
		custIdcard = SyncUtil.decodeIDCARDDetail(custIdcard);
		model.setCustIdcard(custIdcard);
		model.setCustName(custName);
		model.setCustIdCardType(idCardType);
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(model.getCustName())) {
			sb.append(model.getCustName()).append(",");
		}
		if (StringUtils.isNotBlank(model.getBillCodeNo())) {
			sb.append(model.getBillCodeNo()).append(",");
		}
		if (StringUtils.isNotBlank(model.getCustIdcard())) {
			sb.append(model.getCustIdcard()).append(",");
		}
		model.setIntelligentSearch(sb.toString());
		erpFunDepositMapper.insertSelective(model);
		String currentDeptUserName = getCurrUserName(generalParam.getCompType(), generalParam.getUserName(), generalParam.getDeptName(), generalParam.isPersonalVersion());
		ErpFunDepositLog log = new ErpFunDepositLog();
		log.setCompId(generalParam.getCompId());
		log.setDepositId(param.getId());
		log.setCreateTime(new Date());
		log.setCreateUserId(generalParam.getUserId());
		log.setLogContent(currentDeptUserName + " 退款" +NumberHelper.formatNumber(param.getRefundMoney().toString(), NumberHelper.NUMBER_IN_2)+"元");
		log.setShardCityId(generalParam.getCityId());
		erpFunDepositLogMapper.insertSelective(log);
		if (param.isFJD()) {
			erpEarbestDepositCommService.judgeAndResetHouseDepositStatus(generalParam.getCityId(), deposit);
		}
	}

	@Override
	public ErpFunDeposit payDepositToOwner(PayDepositToOwnerParam param) {
		Date dateNow = new Date();
		GeneralParam generalParam = param.getGeneralParam();
		ErpFunDeposit deposit = param.getDeposit();
		ErpFunDeposit model = new ErpFunDeposit();
		BeanUtils.copyProperties(deposit, model);
		model.setShardCityId(generalParam.getCityId());
		model.setId(null);
		model.setDepositStatus(Byte.valueOf("1")); //默认审核
		model.setOperationType(Byte.valueOf("2")); //退款
		model.setBillCodeId(null);
		model.setBillCodeNo(null);
		model.setBillPhoto(null);
		model.setBillWay(null);
		model.setAuditUserId(null);
		model.setAuditTime(null);
		model.setAuditDeptId(null);
		model.setCreateTime(dateNow);
		model.setCreateUserId(generalParam.getUserId());
		model.setUpdateTime(dateNow);
		model.setReceiptMoney(param.getCommssion());
		String custName = null;
		String custMobile = null;
		String custIdcard = null;
		Byte idCardType = null;
		//业主
		HouseInfoVO houseInfo = param.getHouseInfo();
		custName = houseInfo.getOwnerName();
		custMobile = houseInfo.getHouseCellPhone();
		custIdcard = houseInfo.getHouseIdCard();
		idCardType = houseInfo.getHouseIdCardType();
		custMobile = decodePhoneForHouseDetailOfFirst(custMobile, true);
		model.setCustMobile(custMobile);
		custIdcard = EnCodeHelper.decode(custIdcard);
		custIdcard = SyncUtil.decodeIDCARDDetail(custIdcard);
		
		model.setDepositRemark(param.getDepositRemark());
		model.setCustIdcard(custIdcard);
		model.setCustName(custName);
		model.setCustIdCardType(idCardType);
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(model.getCustName())) {
			sb.append(model.getCustName()).append(",");
		}
		if (StringUtils.isNotBlank(model.getBillCodeNo())) {
			sb.append(model.getBillCodeNo()).append(",");
		}
		if (StringUtils.isNotBlank(model.getCustIdcard())) {
			sb.append(model.getCustIdcard()).append(",");
		}
		model.setIntelligentSearch(sb.toString());
		erpFunDepositMapper.insertSelective(model);
		String currentDeptUserName = getCurrUserName(generalParam.getCompType(), generalParam.getUserName(), generalParam.getDeptName(), generalParam.isPersonalVersion());
		ErpFunDepositLog log = new ErpFunDepositLog();
		log.setCompId(generalParam.getCompId());
		log.setDepositId(param.getId());
		log.setCreateTime(new Date());
		log.setCreateUserId(generalParam.getUserId());
		log.setLogContent(currentDeptUserName + " 转业主" +NumberHelper.formatNumber(param.getCommssion().toString(), NumberHelper.NUMBER_IN_2)+"元");
		log.setShardCityId(generalParam.getCityId());
		erpFunDepositLogMapper.insertSelective(log);
		return model;
	}
	
	@Override
	public void updateDepositDeal(GeneralParam generalParam, Integer dealId, String contractNo, Integer depositId) {
        if (Objects.isNull(depositId) || Objects.isNull(dealId) || Objects.isNull(contractNo)) {
            return;
        }
		ErpFunDeposit oldModel = new ErpFunDeposit();
		oldModel.setShardCityId(generalParam.getCityId());
		oldModel.setId(depositId);
		oldModel = erpFunDepositMapper.selectByPrimaryKey(oldModel);
		List<DepositVO> list = null;
		if (oldModel.getDealId()!=null) {
			list = erpFunDepositMapper.selectDepositListByDealId(generalParam.getCityId(), generalParam.getCompId(), oldModel.getDealId(), null);
		} else {
			list = erpFunDepositMapper.selectDepositListByHouseCustId(generalParam.getCityId(), generalParam.getCompId(), oldModel.getCustId(), oldModel.getCustType(), oldModel.getCaseId(), oldModel.getCaseType(), null);
		}
		for (DepositVO vo : list) {
			//审核之前不能转成交
			if (Byte.valueOf("0").equals(vo.getDepositStatus())) {
				return;
			}
		}
		String currentDeptUserName = getCurrUserName(generalParam.getCompType(), generalParam.getUserName(), generalParam.getDeptName(), generalParam.isPersonalVersion());
		List<Integer> depositIds = list.stream().collect(Collectors.mapping(DepositVO::getId, Collectors.toList()));
		//更新关联的流水上的合同id合同编号字段
		erpFunDepositMapper.updateDealInfoByIds(generalParam.getCityId(),generalParam.getCompId(),dealId,contractNo,depositIds);
		//更新票据上的合同id，合同编号字段
		erpFunBillMapper.updateBillDealInfoByIds(generalParam.getCityId(),generalParam.getCompId(),dealId,contractNo,depositIds);
		ErpFunDepositLog log = new ErpFunDepositLog();
		log.setCompId(generalParam.getCompId());
		log.setDepositId(depositId);
		log.setCreateTime(new Date());
		log.setCreateUserId(generalParam.getUserId());
		log.setLogContent(currentDeptUserName + " 将定金转为成交");
		log.setShardCityId(generalParam.getCityId());
		erpFunDepositLogMapper.insertSelective(log);
		//设置房源为成交状态
		if (generalParam.getFJD()) {
			//房基地
			erpEarbestDepositCommService.makeDepositBargainSuccess(generalParam.getCityId(), oldModel);
		}
	}
	public static String decodePhoneForHouseDetailOfFirst(String phoneStr, boolean encrypt){
		if(StringUtils.isBlank(phoneStr)){
			return null;
		}
		String phone = "";
		String[] phones = StringHelper.split(phoneStr, "&&&");
		try {
			if(phones.length>=1){
				String[] phoneValues = StringHelper.split(phones[0], "|||");
				phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
				if(encrypt){
					SyncUtil.ecodePhoneToArr(phoneValues);
				}
				phone += phoneValues[1];
			}
		} catch (Exception e) {

		}
		phone = phone.trim();
		return phone;
	}
	public static void main(String[] args) {
		System.out.println(EnCodeHelper.encode("hftapp"));
	}
}
