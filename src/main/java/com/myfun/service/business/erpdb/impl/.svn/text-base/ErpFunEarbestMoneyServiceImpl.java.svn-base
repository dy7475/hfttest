package com.myfun.service.business.erpdb.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunBillCodelog;
import com.myfun.service.business.erpdb.ErpEarbestDepositCommService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.transaction.param.CancelAuditParam;
import com.myfun.erpWeb.managecenter.transaction.param.CancellationParam;
import com.myfun.erpWeb.managecenter.transaction.param.RefundMoneyParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestHouseParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestToBrokerageParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestToProprietorParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransToDepositParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateEarbestStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.updateDealFunEarbestParam;
import com.myfun.erpWeb.managecenter.transaction.vo.CustInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.HouseInfoVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunBillCodelogMapper;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDepositLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunDepositMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyrecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunFinancPaymentMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpPosPaymentOrderMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.po.ErpEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunBill;
import com.myfun.repository.erpdb.po.ErpFunBillExample;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.erpdb.po.ErpFunDepositLog;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyrecord;
import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.erpdb.po.ErpFunFinancPaymentExample;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBillCodeService;
import com.myfun.service.business.erpdb.ErpFunBillCodelogService;
import com.myfun.service.business.erpdb.ErpFunBillService;
import com.myfun.service.business.erpdb.ErpFunDealRecordService;
import com.myfun.service.business.erpdb.ErpFunDepositService;
import com.myfun.service.business.erpdb.ErpFunEarbestMoneyService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpProcessFinanceService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateEarbestMoneyParam;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;
import com.myfun.utils.Assert;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SyncUtil;

@Service
public class ErpFunEarbestMoneyServiceImpl extends AbstractService<ErpFunEarbestMoney, ErpFunEarbestMoney> implements ErpFunEarbestMoneyService{
	@Autowired
	ErpFunEarbestMoneyMapper erpFunEarbestMoneyMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpUserOpersService erpUserOpersService;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunEarbestMoneyrecordMapper erpFunEarbestMoneyrecordMapper;
	@Autowired
	ErpPosPaymentOrderMapper erpPosPaymentOrderMapper;
	@Autowired
	ErpFunBillMapper erpFunBillMapper;
	@Autowired
	ErpFunBillCodeService erpFunBillCodeService;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpFunBillService erpFunBillService;
	@Autowired
	ErpFunBillCodelogService erpFunBillCodelogService;
	@Autowired
	ErpFunDepositLogMapper erpFunDepositLogMapper;
	@Autowired
	ErpFunBillCodelogMapper erpFunBillCodelogMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpEarbestDepositCommService erpEarbestDepositCommService;
	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunEarbestMoneyMapper;
	}
	
	/**
	 * 查询诚意金列表需要分页时调用的方法
	 */
	@Override
	public PageInfo<ErpFunEarbestMoneyDto> getEarbestMoneyList(
			QueryErpEarbestMoneyListParam param) throws Exception {
		if(StringUtils.isNotBlank(param.getReceiptNo())){
			param.setReceiptNo("%"+param.getReceiptNo()+"%");
		}
		if(StringUtils.isNotBlank(param.getBuildId())){
			param.setBuildIds(param.getBuildId().split(","));
			param.setBuildName(null);
		}else if(StringUtils.isNotBlank(param.getBuildName())){
			param.setBuildName("%"+param.getBuildName()+"%");
		}
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getStartTime(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getEndTime(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("A."+param.getDateType()+" DESC,A.EARBEST_ID DESC");
		param.setDateType("A."+param.getDateType());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunEarbestMoneyDto> list =  erpFunEarbestMoneyMapper.selectEarbestMoneyList(param.getCityId(),param);
		PageInfo<ErpFunEarbestMoneyDto> page = new PageInfo<>(list);
		return page;
	}
	
	/**
	 * 导出诚意金列表时调用的方法
	 */
	@Override
	public List<ErpFunEarbestMoneyDto> getEarbestMoneyListExport(
			QueryErpEarbestMoneyListParam param) throws Exception {
		if(StringUtils.isNotBlank(param.getReceiptNo())){
			param.setReceiptNo("%"+param.getReceiptNo()+"%");
		}
		if(StringUtils.isNotBlank(param.getBuildId())){
			param.setBuildIds(param.getBuildId().split(","));
			param.setBuildName(null);
		}else if(StringUtils.isNotBlank(param.getBuildName())){
			param.setBuildName("%"+param.getBuildName()+"%");
		}
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getStartTime(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getEndTime(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("A."+param.getDateType()+" DESC,A.EARBEST_ID DESC");
		param.setDateType("A."+param.getDateType());
		List<ErpFunEarbestMoneyDto> list =  erpFunEarbestMoneyMapper.selectEarbestMoneyList(param.getCityId(),param);
		return list;
	}
	/**
	 * 新增诚意金
	 */
	@Transactional
	@Override
	public void createDealFunEarbestMoney(CreateOrUpdateEarbestMoneyParam param) throws Exception {
		Date date = new Date();
		ErpFunEarbestMoney erpFunEarbestMoney = new ErpFunEarbestMoney();
		BeanUtils.copyProperties(param, erpFunEarbestMoney);
		erpFunEarbestMoney.setShardCityId(param.getCityId());
		erpFunEarbestMoney.setCompId(param.getCompId());
		erpFunEarbestMoney.setCreateUser(param.getUserId());
		erpFunEarbestMoney.setCreateUserName(param.getUserName());
		erpFunEarbestMoney.setDeptId(param.getDeptId());
		erpFunEarbestMoney.setCreateTime(date);
		erpFunEarbestMoney.setIsDel((byte) 0);////0代表未删除，1代表已删除
		erpFunEarbestMoney.setUpdateTime(date);
        erpFunEarbestMoney.setPaymentType(param.getPaymentType());
		erpFunEarbestMoney.setEarbestStatus((byte) 0);
		erpFunEarbestMoney.setOperationType((byte)0);

		if (param.getReceiptTime() == null) {
			erpFunEarbestMoney.setReceiptTime(param.getReceiptTime());
		}
		erpFunEarbestMoney.setBillCodeNo(param.getReceiptNo());

		//增加产权地址
		erpFunEarbestMoney.setPropertyAddress(param.getPropertyAddress());
		//默认：操作类型为0 表示新增状态
		erpFunEarbestMoney.setOperationType((byte)0);
		if(erpFunBillService.checkBillCodeRepeat(param.getCityId(),param.getCompId(),param.getReceiptNo())){
			throw new BusinessException("该收据编号重复！");
		}
		if (param.getBuildId() == null) {
			Integer caseType = param.getCaseType() == null ? getCaseType(param.getCaseNo()) : param.getCaseType();
			if (caseType == null) {
				throw new BusinessException("房源信息不完善");
			}
			if (caseType == 1) {
				ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(param.getCityId(), param.getCaseId());
				if (Objects.isNull(funSale)) {
					throw new BusinessException("房源信息有误");
				}
				erpFunEarbestMoney.setBuildId(funSale.getBuildId());
				erpFunEarbestMoney.setBuildName(funSale.getBuildName());
			}
			if (caseType == 2) {
				ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(param.getCityId(), param.getCaseId());
				if (Objects.isNull(funLease)) {
					throw new BusinessException("房源信息有误");
				}
				erpFunEarbestMoney.setBuildId(funLease.getBuildId());
				erpFunEarbestMoney.setBuildName(funLease.getBuildName());
			}
		}

		StringBuilder sb = new StringBuilder("");
		if(StringUtils.isNotBlank(erpFunEarbestMoney.getCustName())) {
            sb.append(erpFunEarbestMoney.getCustName()).append(",");
        }
		if(StringUtils.isNotBlank(erpFunEarbestMoney.getReceiptNo())) {
            sb.append(erpFunEarbestMoney.getReceiptNo()).append(",");
        }
		if(StringUtils.isNotBlank(erpFunEarbestMoney.getCustIdcardDecode())) {
            sb.append(erpFunEarbestMoney.getCustIdcardDecode()).append(",");
        }
		erpFunEarbestMoney.setIntelligentSearch(sb.toString());
		erpFunEarbestMoneyMapper.insertSelective(erpFunEarbestMoney);

		List<ErpFunEarbestMoney> earbestMoneyList = new ArrayList<>();
		earbestMoneyList.add(erpFunEarbestMoney);
		erpFunBillService.createBill(param.getCityId(), param.getCompId(), param.getAreaId(), param.getRegId(), param.getDeptId(), param.getDeptId(), param.getUserId(),
				null, null, null, null, null, earbestMoneyList,null, false);
		//收到诚意金xx元，票据号xxx
		String money = new DecimalFormat("0.##").format(param.getReceiptMoney());
		writeOperationRecord(param.getCityId(),param.getCompId(),erpFunEarbestMoney.getEarbestId(),param.getUserId(),"收到诚意金"+ money +"元，票据号"+param.getReceiptNo());

		//修改房源状态 写房源跟进
		if (param.isFJD()) {
			erpEarbestDepositCommService.writeCaseStatusAndTrackForEarbestAdd(param.getCityId(),erpFunEarbestMoney);
		}
	}

	/**
	 * 判断编号是否重复
	 * @return
	 * @throws Exception
	 */
	private boolean checkDealReceiptNoRepeat(ErpFunEarbestMoney param) throws Exception {
		ErpEarbestMoney erpEarbestMoney = new ErpEarbestMoney();
		erpEarbestMoney.setCompId(param.getCompId());
		erpEarbestMoney.setIsDel(Byte.valueOf("0"));
		erpEarbestMoney.setReceiptNo(param.getReceiptNo());
		Integer count = erpFunEarbestMoneyMapper.count(param.getShardCityId(),erpEarbestMoney);
		if(count > 0){
			return true;//true 代表重复
		}
		return false;
	}

	/**
	 * 判断编号是否重复
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deleteEarbestMoney(BaseMapParam param) throws Exception {
		ErpFunEarbestMoney erpFunEarbestMoney = new ErpFunEarbestMoney();
		erpFunEarbestMoney.setShardCityId(param.getInteger("cityId"));
		erpFunEarbestMoney.setEarbestId(param.getInteger("earbestId"));
		erpFunEarbestMoney.setIsDel(Byte.valueOf("1"));//1代表删除
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(erpFunEarbestMoney);
	}

	/**
	 * 修改诚意金状态（0待确认,1已收,2.作废）
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updateEarbestMoneyStatus(UpdateEarbestStatusParam baseParam) throws Exception {

		GeneralParam generalParam = baseParam.getGeneralParam();
		ErpFunEarbestMoney oldModel = new ErpFunEarbestMoney();
		oldModel.setShardCityId(generalParam.getCityId());
		oldModel.setEarbestId(baseParam.getId());
		oldModel = erpFunEarbestMoneyMapper.selectByPrimaryKey(oldModel);
		if (!baseParam.getEarbestStatus().equals(oldModel.getEarbestStatus())) {
			if ((Byte.valueOf("0").equals(baseParam.getEarbestStatus()) && Byte.valueOf("1").equals(oldModel.getEarbestStatus()) && oldModel.getDealId()==null)
					|| ((Byte.valueOf("1").equals(baseParam.getEarbestStatus()) && Byte.valueOf("0").equals(oldModel.getEarbestStatus())))
					|| (Byte.valueOf("2").equals(baseParam.getEarbestStatus()) && Byte.valueOf("0").equals(oldModel.getEarbestStatus())
					&& Byte.valueOf("0").equals(oldModel.getOperationType()))) {

				if (baseParam.getEarbestStatus() == 0 && oldModel.getEarbestStatus() == 1 && oldModel.getOperationType()>0) {
					throw new BusinessException("该笔诚意金不能撤销审核");
				}
				oldModel.setShardCityId(generalParam.getCityId());
				ErpFunBill funbill = erpFunBillMapper.getRecordByEarnestId(generalParam.getCityId(),generalParam.getCompId(), oldModel.getEarbestId());
				if (funbill != null) {
					funbill.setShardCityId(generalParam.getCityId());
				}
				String logContent = "";
				if (baseParam.getEarbestStatus() == 0) {
					if (oldModel.getEarbestStatus() != 1) {
						throw new BusinessException("取消审核失败");
					}
					if (oldModel.getEarbestStatus() == 1 && oldModel.getOperationType() > 0) {
						throw new BusinessException("取消审核失败");
					}
					oldModel.setEarbestStatus((byte)0);
					oldModel.setConfirmDeptName(null);
					oldModel.setConfirmDeptId(null);
					oldModel.setConfirmUserName(null);
					oldModel.setConfirmUserId(null);
					oldModel.setConfirmTime(null);
					erpFunEarbestMoneyMapper.updateByPrimaryKey(oldModel);
					if (funbill != null) {
						funbill.setBillStatus((byte)0);
						erpFunBillMapper.updateByPrimaryKey(funbill);
					}
					logContent = "撤销审核";

				} else if (baseParam.getEarbestStatus() == 1) {
					if (oldModel.getEarbestStatus() != 0) {
						throw new BusinessException("审核失败");
					}
					if (oldModel.getOperationType() == 1) {
						throw new BusinessException("该记录已转房源");
					}
					if (oldModel.getOperationType() == 7) {
						throw new BusinessException("该记录已转定金");
					}
					validateRecordCust(oldModel);
					validateRecordHouse(oldModel);
					oldModel.setEarbestStatus((byte)1);
					oldModel.setConfirmTime(new Date());
					oldModel.setConfirmUserId(generalParam.getUserId());
					oldModel.setConfirmUserName(generalParam.getUserName());
					oldModel.setConfirmDeptId(generalParam.getDeptId());
					oldModel.setConfirmDeptName(generalParam.getDeptName());
					erpFunEarbestMoneyMapper.updateByPrimaryKey(oldModel);
					if (funbill != null) {
						funbill.setBillStatus((byte)1);
						erpFunBillMapper.updateByPrimaryKey(funbill);
					}
					logContent = "审核通过";
				} else if (baseParam.getEarbestStatus() ==2) {
					if (oldModel.getEarbestStatus()!=0) {
						throw new BusinessException("作废失败");
					}
					oldModel.setOperationType((byte)5);
					oldModel.setEarbestStatus((byte)1);//转佣标记文审核
					erpFunEarbestMoneyMapper.updateByPrimaryKey(oldModel);
					logContent = "作废该单";
					String invalidBillNoCanUseAgain = erpSysParaMapper.getParamValue(generalParam.getCityId(), generalParam.getCompId(), "INVALID_BILLNO_CAN_USE_AGAIN");
					if ("1".equals(invalidBillNoCanUseAgain)) {
						List<ErpFunBillCodelog> record = erpFunBillCodelogMapper.getFunBillCodelogByCodeNo(generalParam.getCityId(), generalParam.getCompId(), oldModel.getReceiptNo());
						if (!record.isEmpty()) {
							ErpFunBillCodelog billCodelog = record.get(0);
							billCodelog.setUseStatus((byte)0);
							billCodelog.setShardCityId(generalParam.getCityId());
							erpFunBillCodelogMapper.updateByPrimaryKeySelective(billCodelog);
						}
					}
					//作废诚意金检查是否需要重置关联房源状态
					if (baseParam.isFJD()) {
						erpEarbestDepositCommService.judgeAndResetHouseEarbestStatus(generalParam.getCityId(),oldModel);
					}
				}

				String currentUserName = baseParam.getCurrentUserName();
				ErpFunEarbestMoneyrecord log = new ErpFunEarbestMoneyrecord();
				log.setCompId(generalParam.getCompId());
				log.setEarbestId(baseParam.getId());
				log.setCreateTime(new Date());
				log.setCreateUser(generalParam.getUserId());
				log.setLogContent(currentUserName + logContent);
				log.setShardCityId(generalParam.getCityId());
				erpFunEarbestMoneyrecordMapper.insertSelective(log);
			} else {
				throw new BusinessException("此诚意金不能操作"+ Const.depositTransMap.get(baseParam.getEarbestStatus()) +"!");
			}
		}
	}

	@Override
	public ErpFunEarbestMoneyDto getDealFunEarbestMoneyDetail(BaseMapParam param) {
		return erpFunEarbestMoneyMapper.selectEarbestMoneyDetail(param.getInteger("cityId"),param.getInteger("earbestId"));
	}

	/**
	 * 更新诚意金
	 * flj
	 * 2017-10-12
	 */
	@Transactional
	@Override
	public void updateEarbestMoney(CreateOrUpdateEarbestMoneyParam param, ErpFunEarbestMoney updateEarbestMoney) {
		Integer cityId = param.getCityId();
		Byte status = param.getStatus();
		Integer earbestId = param.getEarbestId();
		Date currentDate = new Date();
		ErpFunEarbestMoney erpFunEarbestMoney = erpFunEarbestMoneyMapper.selectEarbestMoneyDetail(cityId, earbestId);
		if (Objects.isNull(erpFunEarbestMoney)) {
			throw new BusinessException("数据不存在");
		}
		if (Objects.nonNull(status)) {
			if (status < 0 || status > 1) {
				throw new BusinessException("参数异常");
			}
			updateEarbestMoney.setEarbestStatus(status);
		}
		updateEarbestMoney.setUpdateTime(currentDate);
		boolean modifyFlag = false;
		String currUserName = erpFunUsersService.getCurrUserName(cityId, param.getUserId(), param.getDeptId());
		String logContent =  " 修改了诚意金";
		// 收据编号
		if (Objects.nonNull(param.getReceiptNo())) {
			if((StringUtil.isBlank(param.getReceiptNo()) && StringUtil.isNotBlank(erpFunEarbestMoney.getReceiptNo()))
					||(StringUtil.isNotBlank(param.getReceiptNo()) && !param.getReceiptNo().equals(erpFunEarbestMoney.getReceiptNo()))){
				String newReceiptNo = param.getReceiptNo();
				updateEarbestMoney.setReceiptNo(newReceiptNo);
				String oldReceiptNo = erpFunEarbestMoney.getReceiptNo();
				//检查编号重复
				if (!Objects.equals(newReceiptNo, oldReceiptNo)) {
					boolean flag = erpFunBillService.checkBillCodeRepeat(param.getCityId(), param.getCompId(), param.getReceiptNo());
					if (flag) {
						throw new BusinessException("该收据编号重复！");
					}
				}
				erpFunBillCodelogService.deduceCodeNoEmptyToRepeatUse(oldReceiptNo,param.getReceiptNo(), param.getCompId(), param.getCityId());
				if(StringUtil.isBlank(oldReceiptNo)){
					oldReceiptNo = "空";
				}
				if(StringUtil.isBlank(newReceiptNo)){
					newReceiptNo = "空";
				}
				logContent = logContent + " " + "收据编号:" + oldReceiptNo + " >> " + newReceiptNo;
				modifyFlag = true;
				ErpFunBill funBill = erpFunBillMapper.getRecordByEarnestId(param.getCityId(), param.getCompId(), param.getEarbestId());
				if (Objects.nonNull(funBill)) {
					funBill.setBillNo(param.getReceiptNo());
					funBill.setShardCityId(param.getCityId());
					erpFunBillMapper.updateByPrimaryKey(funBill);
				}
			}
		}
		// 收款金额
		if((param.getReceiptMoney() != null && !param.getReceiptMoney().equals(erpFunEarbestMoney.getReceiptMoney()))){
			Integer oldReceiptMoney = erpFunEarbestMoney.getReceiptMoney() == null ?0:erpFunEarbestMoney.getReceiptMoney();
			Integer newReceiptMoney = param.getReceiptMoney() == null ?0:param.getReceiptMoney();
			updateEarbestMoney.setReceiptMoney(param.getReceiptMoney());
			logContent = logContent + " " + "收款金额:" + oldReceiptMoney + " >> " + newReceiptMoney;
			modifyFlag = true;
		}
		// 出票方式  0电子票据 1纸质票薄 2手动录入
		if((param.getBillWay() != null && !param.getBillWay().equals(erpFunEarbestMoney.getBillWay()))){
			String oldBillWay = getBillWayString(erpFunEarbestMoney.getBillWay());
			String newBillWay = getBillWayString(param.getBillWay());
			updateEarbestMoney.setBillWay(param.getBillWay().byteValue());
			logContent = logContent + " " + "出票方式:" + oldBillWay + " >> " + newBillWay;
			modifyFlag = true;
		}
		// 房源编号
		if((Objects.nonNull(param.getCaseNo()) && StringUtil.isBlank(param.getCaseNo()) && StringUtil.isNotBlank(erpFunEarbestMoney.getCaseNo()))
				||(StringUtil.isNotBlank(param.getCaseNo()) && !param.getCaseNo().equals(erpFunEarbestMoney.getCaseNo()))){
			String newCaseNo = param.getCaseNo();
			String oldCaseNo = erpFunEarbestMoney.getCaseNo();
			updateEarbestMoney.setCaseNo(newCaseNo);
			if(StringUtil.isBlank(oldCaseNo)){
				oldCaseNo = "空";
			}
			if(StringUtil.isBlank(newCaseNo)){
				newCaseNo = "空";
			}
			logContent = logContent + " " + "房源编号:" + oldCaseNo + " >> " + newCaseNo;
			modifyFlag = true;
		}
		// 客源编号
//		if((StringUtil.isBlank(param.getCustNo()) && StringUtil.isNotBlank(erpFunEarbestMoney.getCustNo()))
//				||(StringUtil.isNotBlank(param.getCustNo()) && !param.getCustNo().equals(erpFunEarbestMoney.getCustNo()))){
//			String newCustNo = param.getCustNo();
//			String oldCustNo = erpFunEarbestMoney.getCustNo();
//			updateEarbestMoney.setCustNo(newCustNo);
//			if(StringUtil.isBlank(newCustNo)){
//				newCustNo = "空";
//			}
//			if(StringUtil.isBlank(oldCustNo)){
//				oldCustNo = "空";
//			}
//			logContent = logContent + " " + "客源编号:" + oldCustNo + ">>" + newCustNo;
//		}
		// 备注
		if (Objects.nonNull(param.getEarbestRemark())) {
			if((StringUtil.isBlank(param.getEarbestRemark()) && StringUtil.isNotBlank(erpFunEarbestMoney.getEarbestRemark()))
					||(StringUtil.isNotBlank(param.getEarbestRemark()) && !param.getEarbestRemark().equals(erpFunEarbestMoney.getEarbestRemark()))){
				String newEarbestRemark = param.getEarbestRemark();
				String oldEarbestRemark = erpFunEarbestMoney.getEarbestRemark();
				updateEarbestMoney.setEarbestRemark(newEarbestRemark);
				if(StringUtil.isBlank(oldEarbestRemark)){
					oldEarbestRemark = "空";
				}
				if(StringUtil.isBlank(newEarbestRemark)){
					newEarbestRemark = "空";
				}
				logContent = logContent + " " + "备注:" + oldEarbestRemark + " >> " + newEarbestRemark;
				modifyFlag = true;
			}
		}


		//产权地址
		if (Objects.nonNull(param.getPropertyAddress())) {
			if((StringUtil.isBlank(param.getPropertyAddress()) && StringUtil.isNotBlank(erpFunEarbestMoney.getPropertyAddress()))
					||(StringUtil.isNotBlank(param.getPropertyAddress()) && !param.getPropertyAddress().equals(erpFunEarbestMoney.getPropertyAddress()))){
				String newPropertyAddress = param.getPropertyAddress();
				String oldPropertyAddress = erpFunEarbestMoney.getPropertyAddress();
				updateEarbestMoney.setPropertyAddress(newPropertyAddress);
				if(StringUtil.isBlank(oldPropertyAddress)){
					oldPropertyAddress = "空";
				}
				if(StringUtil.isBlank(newPropertyAddress)){
					newPropertyAddress = "空";
				}
				logContent = logContent + " " + "产权地址:" + oldPropertyAddress + " >> " + newPropertyAddress;
				modifyFlag = true;
			}
		}

		if (Objects.nonNull(param.getCustName())) {
			if((StringUtil.isBlank(param.getCustName()) && StringUtil.isNotBlank(erpFunEarbestMoney.getCustName()))
					||(StringUtil.isNotBlank(param.getCustName()) && !param.getCustName().equals(erpFunEarbestMoney.getCustName()))){
				String custName = param.getCustName();
				String oldCustName = erpFunEarbestMoney.getCustName();
				updateEarbestMoney.setCustName(custName);
				if(StringUtil.isBlank(oldCustName)){
					oldCustName = "空";
				}
				if(StringUtil.isBlank(custName)){
					custName = "空";
				}
				logContent = logContent + " " + "付款人:" + oldCustName + " >> " + custName;
				modifyFlag = true;
			}
		}

		if (Objects.nonNull(param.getCustMobile())) {
			if((StringUtil.isBlank(param.getCustMobile()) && StringUtil.isNotBlank(erpFunEarbestMoney.getCustMobile()))
					||(StringUtil.isNotBlank(param.getCustMobile()) && !param.getCustMobile().equals(erpFunEarbestMoney.getCustMobile()))){
				String newCustMobile = param.getCustMobile();
				String oldCustMobile = erpFunEarbestMoney.getCustMobile();
				updateEarbestMoney.setCustMobile(newCustMobile);
				if(StringUtil.isBlank(oldCustMobile)){
					oldCustMobile = "空";
				}
				if(StringUtil.isBlank(newCustMobile)){
					newCustMobile = "空";
				}
				logContent = logContent + " " + "付款人电话:" + oldCustMobile + " >> " + newCustMobile;
				modifyFlag = true;
			}
		}

		updateEarbestMoney.setEarbestId(earbestId);
		updateEarbestMoney.setShardCityId(cityId);
		if (!modifyFlag) {
			//未修改
			return;
		}
		StringBuilder sb = new StringBuilder("");
		if(StringUtils.isNotBlank(updateEarbestMoney.getCustName())) {
			sb.append(updateEarbestMoney.getCustName()).append(",");
		}
		if(StringUtils.isNotBlank(updateEarbestMoney.getReceiptNo())) {
			sb.append(updateEarbestMoney.getReceiptNo()).append(",");
		}
		if(StringUtils.isNotBlank(updateEarbestMoney.getCustIdcardDecode())) {
			sb.append(updateEarbestMoney.getCustIdcardDecode()).append(",");
		}
		updateEarbestMoney.setIntelligentSearch(sb.toString());
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(updateEarbestMoney);
		// 写日志
		ErpFunEarbestMoneyrecord erpFunEarbestMoneyrecord = new ErpFunEarbestMoneyrecord();
		erpFunEarbestMoneyrecord.setCompId(param.getCompId());
		erpFunEarbestMoneyrecord.setEarbestId(earbestId);
		erpFunEarbestMoneyrecord.setCreateTime(currentDate);
		erpFunEarbestMoneyrecord.setCreateUser(param.getUserId());
		erpFunEarbestMoneyrecord.setLogContent(currUserName + logContent);
		erpFunEarbestMoneyrecord.setShardCityId(cityId);
		erpFunEarbestMoneyrecordMapper.insertSelective(erpFunEarbestMoneyrecord);
	}

	private String getBillWayString(Byte billWay){
		String billWayName = "电子票据";
		if(1 == billWay){
			billWayName = "纸质票簿";
		} else if(2 == billWay){
			billWayName = "手动录入";
		}
		return billWayName;
	}

	/**
	 * 创建票据.如果是更新票据，那么则将以前的票据状态标记为删除，并且将
	 * @throws Exception
	 */
	private void createBill(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, ErpFunEarbestMoney erpEarbestMoney, Byte billWay, String billCodeNo) {
		if (StringUtils.isBlank(erpEarbestMoney.getReceiptNo())) {
			return ;
		}
		if (erpEarbestMoney.getEarbestId()!=null) {
			if (!billCodeNo.equals(erpEarbestMoney.getReceiptNo()) || !erpEarbestMoney.getBillWay().equals(billWay)) {
				//删除关联，修改状态
				ErpFunBillExample example = new ErpFunBillExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(erpEarbestMoney.getCompId()).andEarbestIdEqualTo(erpEarbestMoney.getEarbestId());
				ErpFunBill updateModel = new ErpFunBill();
				updateModel.setBillStatus(Byte.valueOf("2"));
				erpFunBillMapper.updateByExampleSelective(updateModel, example);
				erpFunBillMapper.deleteEarbestBillPrintRelative(cityId, erpEarbestMoney.getCompId(), erpEarbestMoney.getEarbestId());
				erpFunBillCodeService.updateBillCodeLogStatus(cityId, compId, deptId, billCodeNo,2);
				int count = erpFunBillCodeService.judgeBillCodeLogIsReapt(cityId, compId, deptId, Byte.valueOf("0"), billWay, erpEarbestMoney.getBillCodeId(),null, erpEarbestMoney.getReceiptNo());
				if (count > 0) {
					throw new BusinessException("该票据号已经被使用！");
				}
				ErpFunBill record = new ErpFunBill();
				record.setShardCityId(cityId);
				record.setCompId(compId);
				record.setAreaId(areaId);
				record.setRegId(regId);
				record.setDeptId(deptId);
				record.setGrId(grId);
				record.setUserId(userId);
				record.setEarbestId(erpEarbestMoney.getEarbestId());
				record.setCreationTime(new Date());
				record.setBillNo(erpEarbestMoney.getReceiptNo());
				record.setBillStatus(Byte.valueOf("0"));//设置为未确认
				record.setBillType(Byte.valueOf("0"));//这里是诚意金
				record.setPayCustomer(erpEarbestMoney.getCustName());
				record.setPayMoney(new BigDecimal(erpEarbestMoney.getReceiptMoney()));
				record.setIntelligentSearch(erpEarbestMoney.getReceiptNo()+","+(StringUtils.isBlank(erpEarbestMoney.getCustName())?"":erpEarbestMoney.getCustName()));
				record.setReceiptMoneyDept(erpEarbestMoney.getReceiptDeptId());
				record.setReceiptMoneyUser(erpEarbestMoney.getReceiptUserId());
				record.setReceiptTime(erpEarbestMoney.getReceiptTime());
				erpFunBillMapper.insertSelective(record);
				erpFunBillCodeService.updateBillCodeLogStatus(cityId, compId, deptId, erpEarbestMoney.getReceiptNo(),1);

			}
		}
	}

	/**
	 * 创建日志对比记录 flj 2017-10-12
	 * @param param
	 * @param erpFunEarbestMoney
	 * @return
	 */
	private String buildCompareEarbestMoneyContent(CreateOrUpdateEarbestMoneyParam param,
			ErpFunEarbestMoney erpFunEarbestMoney) {
		String updateContent = "";
		String newReceiptNo = param.getReceiptNo();
		String oldReceiptNo = erpFunEarbestMoney.getReceiptNo();
		Integer newReceiptMoney = param.getReceiptMoney();
		Integer oldReceiptMoney = erpFunEarbestMoney.getReceiptMoney();
		if (!oldReceiptNo.equals(newReceiptNo)) {
			updateContent += " 收据编号：" + oldReceiptNo + "->" + newReceiptNo;
		}
		if (!oldReceiptMoney.equals(newReceiptMoney)) {
			updateContent += " 收款金额：" + oldReceiptMoney + "->" + newReceiptMoney;
		}
		if (param.getCaseNo() != null && !param.getCaseNo().equals(erpFunEarbestMoney.getCaseNo())) {
			updateContent += " 意向房源：" + erpFunEarbestMoney.getCaseNo() + "->" + param.getCaseNo();
		}
		if (param.getEarbestRemark() != null && !param.getEarbestRemark().equals(erpFunEarbestMoney.getEarbestRemark())) {
			updateContent += " 备注：" + erpFunEarbestMoney.getEarbestRemark() + "->" + param.getEarbestRemark();
		}
		return updateContent;
	}

	/**
	 * @tag 删除诚意金
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	@Transactional
	@Override
	public void deleteDealFunEarbestMoney(GeneralParam generalParam, Integer earbestId) {
		Integer cityId = generalParam.getCityId();
		ErpFunEarbestMoney earbestMoney = new ErpFunEarbestMoney();
		earbestMoney.setShardCityId(cityId);
		earbestMoney.setEarbestId(earbestId);
		earbestMoney.setIsDel((byte) 1);
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(earbestMoney);
		erpFunBillMapper.DelByEarbestId(cityId, earbestId);
		earbestMoney = erpFunEarbestMoneyMapper.selectByPrimaryKey(earbestMoney);
		if (earbestMoney != null && StringUtils.isNotBlank(earbestMoney.getReceiptNo())) {
			erpFunBillCodeService.updateBillCodeLogStatus(cityId, generalParam.getCompId(), generalParam.getDeptId(), earbestMoney.getReceiptNo(), 2);
		}
	}

	/**
	 * @tag 修改诚意金状态
	 * @author wangchun
	 * @since 2018/11/26
	 */
	@Transactional
	@Override
	public void updateDealFunEarbestMoney(updateDealFunEarbestParam param, ErpFunEarbestMoney earbestMoney, String currUserName) {
		Byte status = param.getStatus();
		ErpFunEarbestMoney updateModel=new ErpFunEarbestMoney();
		Date now = new Date();
		updateModel.setShardCityId(param.getCityId());
		updateModel.setEarbestStatus(status);
		updateModel.setUpdateTime(now);
		ErpFunBillExample billExample=new ErpFunBillExample();
		billExample.setShardCityId(param.getCityId());
		ErpFunBillExample.Criteria billExampleCriteria = billExample.createCriteria();
		Integer earbestId = param.getEarbestId();
		billExampleCriteria.andEarbestIdEqualTo(earbestId);
		String logContent =  " 于今日修改了诚意金";

		if(1==status){
			updateModel.setConfirmDeptId(param.getDeptId());
			updateModel.setConfirmDeptName(param.getDeptName());
			updateModel.setConfirmUserId(param.getUserId());
			updateModel.setConfirmUserName(param.getUserName());
			updateModel.setConfirmTime(now);
			ErpFunBill funBill=new ErpFunBill();
			funBill.setShardCityId(param.getCityId());
			funBill.setBillStatus((byte)1);
			erpFunBillMapper.updateByExampleSelective(funBill,billExample);
			logContent = " 于今日收讫了该诚意金";
		}else if (2==status){
			updateModel.setRefundDeptId(param.getDeptId());
			updateModel.setRefundDeptName(param.getDeptName());
			updateModel.setRefundUserId(param.getUserId());
			updateModel.setRefundUserName(param.getUserName());
			updateModel.setRefundTime(now);
			String refundExplain = param.getRefundExplain();
			updateModel.setRefundExplain(refundExplain);
			ErpFunBill funBill=new ErpFunBill();
			funBill.setShardCityId(param.getCityId());
			funBill.setBillStatus((byte)2);
			erpFunBillMapper.updateByExampleSelective(funBill,billExample);
			if (StringUtils.isNotBlank(earbestMoney.getReceiptNo())) {
				erpFunBillCodelogService.updateBillCodeLogStatus(param.getCityId(), param.getCompId(), earbestMoney.getReceiptNo(), "2");
			}
			logContent = " 于今日操作了退款, 退款说明:"+ refundExplain;
		}else if (3==status){
			updateModel.setDepositDeptId(param.getDeptId());
			updateModel.setDepositDeptName(param.getDeptName());
			updateModel.setDepositUserId(param.getUserId());
			updateModel.setDepositUserName(param.getUserName());
			updateModel.setDepositTime(now);
			Integer dealId = param.getDealId();
			String dealNo = param.getDealNo();
			updateModel.setDealId(dealId);
			updateModel.setDealNo(dealNo);
			// 关联的合同编号到票据上
			billExampleCriteria.andCompIdEqualTo(param.getCompId()).andBillTypeEqualTo((byte)0);
			ErpFunBill funBill=new ErpFunBill();
			funBill.setShardCityId(param.getCityId());
			funBill.setDealId(dealId);
			funBill.setContractNo(dealNo);
			erpFunBillMapper.updateByExampleSelective(funBill,billExample);
			logContent = " 于今日操作了转定金";
		}
		updateModel.setEarbestId(earbestId);
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(updateModel);
		// 写日志
		ErpFunEarbestMoneyrecord insertModel = new ErpFunEarbestMoneyrecord();
		insertModel.setCompId(param.getCompId());
		insertModel.setEarbestId(earbestId);
		insertModel.setCreateTime(now);
		insertModel.setCreateUser(param.getUserId());
		insertModel.setLogContent(currUserName + logContent);
		insertModel.setShardCityId(param.getCityId());
		erpFunEarbestMoneyrecordMapper.insertSelective(insertModel);
	}



	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunDepositMapper erpFunDepositMapper;

	@Transactional
	@Override
	public void transEarnestHouse(TransEarnestHouseParam param) throws Exception {
		ErpFunEarbestMoney id = new ErpFunEarbestMoney();
		id.setEarbestId(param.getEarbestId());
		id.setShardCityId(param.getCityId());
		ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(id);
		checkOldRecord(record);
		if (Objects.isNull(record)) {
			throw new BusinessException("数据不存在");
		}
		Assert.isTrueThrow(Objects.equals(record.getCaseId(), param.getCaseId()),"已绑定该房源");
		Assert.isTrueThrow(record.getEarbestStatus()>1 || record.getOperationType()>0,"该状态不能转房源");

//		List<ErpFunEarbestMoney> list = erpFunEarbestMoneyMapper.selectEarbestListByHouseCustId(param.getCityId(), param.getCompId(), record.getCustNo(), record.getCustId(), record.getCaseNo(), record.getCaseId());
		//可能包含补充诚意金的记录 修改所有
//		Integer banance = 0;
//		for (ErpFunEarbestMoney erpFunEarbestMoney : list) {
//			Assert.isTrueThrow(Objects.equals(erpFunEarbestMoney.getCaseId(), param.getCaseId()),"数据异常");
//			Assert.isTrueThrow(erpFunEarbestMoney.getEarbestStatus()>1 || erpFunEarbestMoney.getOperationType()>0,"数据异常");
//			erpFunEarbestMoney.setOperationType(Byte.valueOf("1"));
//			erpFunEarbestMoney.setShardCityId(param.getCityId());
//			erpFunEarbestMoneyMapper.updateByPrimaryKey(erpFunEarbestMoney);
//			banance += erpFunEarbestMoney.getReceiptMoney();
//		}
		//来自转房源
		ErpFunUsers funUsers = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getUserId());
		Object newHouse = getHouse(param.getCityId(),param.getCaseId(),param.getCaseType());
		if (Objects.isNull(newHouse)) {
			throw new BusinessException("房源不存在");
		}
		ErpFunEarbestMoney updateRecord = getUpdateRecord(param, newHouse, record);
//		updateRecord.setIsPrint((byte)0);
//        updateRecord.setSourceType((byte)1);
        //转房源后 多条补充诚意金的加在一起
//        updateRecord.setReceiptMoney(banance);
        //分库标识
        updateRecord.setShardCityId(param.getCityId());
		StringBuilder sb = new StringBuilder("");
		if(StringUtils.isNotBlank(updateRecord.getCustName())) {
			sb.append(updateRecord.getCustName()).append(",");
		}
		if(StringUtils.isNotBlank(updateRecord.getReceiptNo())) {
			sb.append(updateRecord.getReceiptNo()).append(",");
		}
		if(StringUtils.isNotBlank(updateRecord.getCustIdcardDecode())) {
			sb.append(updateRecord.getCustIdcardDecode()).append(",");
		}
		updateRecord.setIntelligentSearch(sb.toString());
        erpFunEarbestMoneyMapper.insertSelective(updateRecord);

        record.setShardCityId(param.getCityId());
        record.setOperationType(Byte.valueOf("1"));//转房源
		record.setEarbestStatus(Byte.valueOf("1"));//标记审核 查询收诚意金时又要过滤掉
		erpFunEarbestMoneyMapper.updateByPrimaryKey(record);
        //关联fun_bill表 更新earbestId
		ErpFunBill funBill = erpFunBillMapper.getRecordByEarnestId(param.getCityId(), param.getCompId(),record.getEarbestId());
		if(Objects.isNull(funBill)){
			throw new BusinessException("票据明细不存在");
		}
		funBill.setEarbestId(updateRecord.getEarbestId());
		funBill.setBillStatus((byte)0);
		funBill.setShardCityId(param.getCityId());
		erpFunBillMapper.updateByPrimaryKey(funBill);

        //写操作记录
        String logContent = funUsers.getUserName() + " 将票据号为%s诚意金更换了房源";
        writeOperationRecord(param, record,funUsers,String.format(logContent,record.getReceiptNo()));
        Integer caseType = getCaseType(record.getCaseNo());
        if (Objects.isNull(caseType)) {
            throw new BusinessException("原记录数据无房源编号");
        }
        Object oldHouse = getHouse(param.getCityId(), record.getCaseId(), caseType);
        logContent = funUsers.getUserName() + " 转房源：" +record.getCaseNo()+ " >> " + updateRecord.getCaseNo();
		writeOperationRecord(param,updateRecord,funUsers,logContent);
		if (param.isFJD()) {
			//取消原房源预定状态
			erpEarbestDepositCommService.cancelHouseEarbest(param.getCityId(),record);
			//更新当前房源状态
			erpEarbestDepositCommService.writeCaseStatusAndTrackForEarbestAdd(param.getCityId(),updateRecord);
		}
	}

	private void checkOldRecord(ErpFunEarbestMoney record) {
		if (Objects.isNull(record)) {
			throw new BusinessException("数据不存在");
		}
		if (null == getCustType(record.getCustNo())) {
			throw new BusinessException("数据记录不完整");
		}
		if (null == getCaseType(record.getCaseNo())) {
			throw new BusinessException("数据记录不完整");
		}
	}

	private Integer getCaseType(String caseNo) {
        if (StringUtil.isBlank(caseNo)) {
            return null;
        }
	    if(caseNo.startsWith("CS")) {
	        return 1;
        }
	    if(caseNo.startsWith("CZ")){
	        return 2;
        }
        return null;
    }
	private Integer getCustType(String custNo) {
		if (StringUtil.isBlank(custNo)) {
			return null;
		}
		if(custNo.startsWith("QG")) {
			return 3;
		}
		if(custNo.startsWith("QZ")){
			return 4;
		}
		return null;
	}

    private Object getHouse(int cityId, int caseId,int caseType) {
        Object house;
        if (Objects.equals(Const.DIC_CASE_TYPE_SALE_FUN, caseType)) {
            house = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
        }else{
            //出租
            house = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
        }
        if (Objects.isNull(house)) {
            throw new BusinessException("数据不存在");
        }
        return house;
    }

    private void writeOperationRecord(TransEarnestHouseParam param, ErpFunEarbestMoney funEarnestMoney,ErpFunUsers funUsers,String logContent) {
		ErpFunEarbestMoneyrecord erpFunEarbestMoneyrecord = new ErpFunEarbestMoneyrecord();
		erpFunEarbestMoneyrecord.setCompId(param.getCompId());
		erpFunEarbestMoneyrecord.setEarbestId(funEarnestMoney.getEarbestId());
		erpFunEarbestMoneyrecord.setCreateTime(new Date());
		erpFunEarbestMoneyrecord.setCreateUser(param.getUserId());
		erpFunEarbestMoneyrecord.setLogContent(logContent);
		erpFunEarbestMoneyrecord.setShardCityId(param.getCityId());
		erpFunEarbestMoneyrecordMapper.insertSelective(erpFunEarbestMoneyrecord);
	}



	private ErpFunEarbestMoney getUpdateRecord(TransEarnestHouseParam param,Object house,ErpFunEarbestMoney record) throws Exception {

		ErpFunEarbestMoney newRecord = new ErpFunEarbestMoney();
		BeanUtil.copyObject(record,newRecord);
		newRecord.setEarbestId(null);
		newRecord.setEarbestStatus((byte)0);
		//出售
		if(house instanceof ErpFunSale){
			ErpFunSale funSale = (ErpFunSale) house;
			newRecord.setCaseId(funSale.getSaleId());
			newRecord.setCaseNo(funSale.getSaleNo());
			newRecord.setBuildId(funSale.getBuildId());
			newRecord.setBuildName(funSale.getBuildName());
		}else {
			//出租
			ErpFunLease funLease = (ErpFunLease) house;
			newRecord.setCaseId(funLease.getLeaseId());
			newRecord.setCaseNo(funLease.getLeaseNo());
			newRecord.setBuildId(funLease.getBuildId());
			newRecord.setBuildName(funLease.getBuildName());
		}
		//操作类型转房源
		newRecord.setOperationType(Byte.valueOf("0"));
		newRecord.setCreateTime(new Date());
		return newRecord;
	}

	@Transactional
	@Override
	public void cancelAudit(CancelAuditParam param){
        ErpFunEarbestMoney record = getErpFunEarbestMoneyAndThrow(param.getCityId(),param.getEarnestId());
        //诚意金状态 0待确认,1已收,2已退,3转定金
		if (!Objects.equals(record.getEarbestStatus(), (byte)1)) {
			throw new BusinessException("不可撤销");
		}
		record.setShardCityId(param.getCityId());
		record.setEarbestStatus((byte)0);
		record.setConfirmDeptId(null);
		record.setConfirmDeptName(null);
		record.setConfirmUserId(null);
		record.setConfirmUserName(null);
		record.setConfirmTime(null);
		erpFunEarbestMoneyMapper.updateByPrimaryKey(record);
		ErpFunBillExample erpFunBillExample = new ErpFunBillExample();
		erpFunBillExample.setShardCityId(param.getCityId());
		erpFunBillExample.createCriteria().andEarbestIdEqualTo(record.getEarbestId());
		List<ErpFunBill> erpFunBills = erpFunBillMapper.selectByExample(erpFunBillExample);
		if (erpFunBills.isEmpty()) {
			throw new BusinessException("数据异常");
		}
		ErpFunBill erpFunBill = erpFunBills.get(0);
		erpFunBill.setBillStatus((byte)0);
		erpFunBill.setShardCityId(param.getCityId());
		erpFunBillMapper.updateByPrimaryKeySelective(erpFunBill);
		writeOperationRecord(param.getCityId(),param.getCompId(),record.getEarbestId(),param.getUserId(),param.getCurrUserName() + " 撤销审核");
	}

    @Override
    @Transactional
    public void transToDeposit(TransToDepositParam param){
        ErpFunEarbestMoney record = getErpFunEarbestMoneyAndThrow(param.getCityId(), param.getEarbestId());
		if (record.getOperationType() != 0) {
			throw new BusinessException("该记录不能转定金");
		}
		validateRecordCust(record);
		validateRecordHouse(record);
		//默认0,  1.转房源，2.代付，3.客户转拥，4.退款，5.作废，6.业主,7.转定金
		record.setOperationType((byte)7);
		record.setShardCityId(param.getCityId());
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(record);

		createDepositRecord(param,record);
		String logContent = String.format("将票据号为%s 诚意金转为定金",record.getReceiptNo());
		writeOperationRecord(param.getCityId(),param.getCompId(),param.getEarbestId(),param.getUserId(),param.getUserName() + logContent);
    }

	public void cancellationEarnest(CancellationParam param){
		ErpFunEarbestMoney record = getErpFunEarbestMoneyAndThrow(param.getCityId(), param.getEarnestId());
		//作废 earbestStatus=4:作废
		Assert.isTrueThrow(Objects.equals(record.getEarbestStatus(),(byte)4),"该记录已作废");
		//未审核才能作为 诚意金状态 0待确认,1已收,2已退,3转定金,4已作废
		Assert.isTrueThrow(!Objects.equals(record.getEarbestStatus(),(byte)0),"不可作废");
		record.setEarbestStatus((byte)4);
		record.setShardCityId(param.getCityId());
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(record);
		ErpFunBill funBill = erpFunBillMapper.getRecordByEarnestId(param.getCityId(), param.getCompId(),param.getEarnestId());
		Assert.isNullThrow(funBill,"数据异常");
		//2 = 作废
		funBill.setBillStatus((byte)2);
		funBill.setShardCityId(param.getCityId());
		erpFunBillMapper.updateByPrimaryKeySelective(funBill);
		//票据编号
		erpFunBillCodelogService.updateBillCodeLogStatus(param.getCityId(), param.getCompId(), record.getReceiptNo(), "2");
		writeOperationRecord(param.getCityId(),param.getCompId(),param.getEarnestId(),param.getUserId(),param.getCurrUserName() + " 作废了该单据.");
	}

	/**
	 * 创建定金单号 票据单号和诚意金相同
	 * @param param
	 * @param record
	 */
	private void createDepositRecord(TransToDepositParam param, ErpFunEarbestMoney record) {
		ErpFunDeposit erpFunDeposit = new ErpFunDeposit();
		erpFunDeposit.setIsPrint((byte)0);
		erpFunDeposit.setDepositStatus(record.getEarbestStatus());

		erpFunDeposit.setBillCodeId(record.getBillCodeId());
		erpFunDeposit.setBillCodeNo(record.getReceiptNo());
		erpFunDeposit.setCaseId(record.getCaseId());
		Integer type = getCaseType(record.getCaseNo());
		if (Objects.isNull(type)) {
			throw new BusinessException("房源信息不完善，不能转定金");
		}
		erpFunDeposit.setCaseType(type.byteValue());
		erpFunDeposit.setCaseNo(record.getCaseNo());

		erpFunDeposit.setCompId(record.getCompId());
		erpFunDeposit.setDeptId(record.getDeptId());
		erpFunDeposit.setCreateTime(new Date());
		erpFunDeposit.setCreateUserId(record.getCreateUser());

		erpFunDeposit.setBillPhoto(record.getBillPhoto());
		erpFunDeposit.setIsDel((byte)0);
		erpFunDeposit.setBillWay(record.getBillWay());
		erpFunDeposit.setUpdateTime(new Date());

		erpFunDeposit.setCustId(record.getCustId());
		erpFunDeposit.setCustName(record.getCustName());
		erpFunDeposit.setCustIdcard(record.getCustIdcard());
		erpFunDeposit.setCustNo(record.getCustNo());
		erpFunDeposit.setCustMobile(record.getCustMobile());
		Integer custType = getCustType(record.getCustNo());
		if (Objects.isNull(custType)) {
			throw new BusinessException("客源信息不完善，不能转定金");
		}
		erpFunDeposit.setCustType(custType.byteValue());
		erpFunDeposit.setCustIdCardType(Optional.ofNullable(record.getCustIdCardType()).map(Integer::byteValue).orElse(null));
		erpFunDeposit.setShardCityId(param.getCityId());


		erpFunDeposit.setReceiptMoney(new BigDecimal(record.getReceiptMoney()));
		erpFunDeposit.setReceiptDeptId(record.getReceiptDeptId());
		erpFunDeposit.setReceiptUserId(record.getReceiptUserId());
		erpFunDeposit.setReceiptTime(record.getReceiptTime());

		erpFunDeposit.setAuditDeptId(record.getConfirmDeptId());
		erpFunDeposit.setAuditUserId(record.getConfirmUserId());
		erpFunDeposit.setAuditTime(record.getConfirmTime());

		erpFunDeposit.setPropertyAddress(record.getPropertyAddress());//产权地址
		erpFunDeposit.setDepositRemark(record.getEarbestRemark());//备注
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(erpFunDeposit.getCustName())) {
			sb.append(erpFunDeposit.getCustName()).append(",");
		}
		if (StringUtils.isNotBlank(erpFunDeposit.getBillCodeNo())) {
			sb.append(erpFunDeposit.getBillCodeNo()).append(",");
		}
		if (StringUtils.isNotBlank(erpFunDeposit.getCustIdcard())) {
			sb.append(erpFunDeposit.getCustIdcard()).append(",");
		}
		erpFunDeposit.setIntelligentSearch(sb.toString());

		erpFunDepositMapper.insertSelective(erpFunDeposit);
		//写日志
		ErpFunDepositLog log = new ErpFunDepositLog();
		log.setCompId(param.getCompId());
		log.setCreateTime(new Date());
		log.setDepositId(erpFunDeposit.getId());
		log.setCreateUserId(param.getUserId());
		log.setLogContent(param.getUserName() + "操作了从诚意金转定金.");
		log.setShardCityId(param.getCityId());
		erpFunDepositLogMapper.insertSelective(log);

		//修改fun_bill
		ErpFunBill funBill = erpFunBillMapper.getRecordByEarnestId(param.getCityId(), param.getCompId(),param.getEarbestId());
		if (funBill == null) {
			throw new BusinessException("票据明细不存在");
		}
		funBill.setEarbestId(null);
		funBill.setDepositId(erpFunDeposit.getId());
		funBill.setBillPrintId(null);
		funBill.setShardCityId(param.getCityId());
		erpFunBillMapper.updateByPrimaryKey(funBill);
		//转定金修改房源状态及写跟进
		if (param.isFJD()) {
			erpEarbestDepositCommService.writeCaseStatusAndTrackForDepositAdd(param.getCityId(), erpFunDeposit, true);
		}
	}

	private ErpFunEarbestMoney getErpFunEarbestMoneyAndThrow(int cityId, int earnestId) {
        ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(cityId,earnestId));
        if (Objects.isNull(record)) {
            throw new BusinessException("记录不存在");
        }
        return record;
    }

	private void writeOperationRecord(int cityId,int compId,int earnestId,int userId,String logContent) {
		ErpFunEarbestMoneyrecord erpFunEarbestMoneyrecord = new ErpFunEarbestMoneyrecord();
		erpFunEarbestMoneyrecord.setCompId(compId);
		erpFunEarbestMoneyrecord.setEarbestId(earnestId);
		erpFunEarbestMoneyrecord.setCreateTime(new Date());
		erpFunEarbestMoneyrecord.setCreateUser(userId);
		erpFunEarbestMoneyrecord.setLogContent(logContent);
		erpFunEarbestMoneyrecord.setShardCityId(cityId);
		erpFunEarbestMoneyrecordMapper.insertSelective(erpFunEarbestMoneyrecord);
	}

    private Map<String,Object> getHouseInfo(Object house) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //出售
        String houseDesc = "";
        if(house instanceof ErpFunSale){
            ErpFunSale funSale = (ErpFunSale) house;
            houseDesc = String.format("%s %d室 %d㎡",funSale.getBuildName(),funSale.getSaleRoom(),
                    Optional.ofNullable(funSale.getSaleArea()).map(BigDecimal::intValue).orElse(null));
        }else {
            //出租
            ErpFunLease funLease = (ErpFunLease) house;
            houseDesc = String.format("%s %d室 %d㎡",funLease.getBuildName(),funLease.getLeaseRoom(),
                    Optional.ofNullable(funLease.getLeaseArea()).map(BigDecimal::intValue).orElse(null));
        }
        houseDesc = houseDesc.replaceAll("null.\\s?", "");
        map.put("houseDesc",houseDesc);
        //操作类型转房源
        return map;
    }



	@Autowired
	ErpFunDealMapper erpFunDealMapper;

	@Autowired
	ErpProcessFinanceService erpProcessFinanceService;
	@Autowired
	ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	ErpFunDealRecordService erpFunDealRecordService;
	@Autowired
	ErpFunDepositService erpFunDepositService;
	@Autowired
	ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
	@Override
	@Transactional
	public void transEarnestToBroker(TransEarnestToBrokerageParam param) throws Exception {

		Integer earnestId = param.getEarbestId();
		ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(param.getCityId(), earnestId));
		Assert.isNullThrow(record,"数据不存在");
		Assert.isTrueThrow (!Objects.equals(record.getEarbestStatus(), (byte) 1),"不能转拥");
		Assert.isNullThrow(record.getDeptId(), "转成交之前不能操作转佣金！");
		ErpFunDeal dealInfo = erpFunDealMapper.selectByDealId(param.getCityId(), record.getDealId(), new String[]{"DEAL_AUDIT_STATUS","DEAL_STATUS"});
		if (Objects.isNull(dealInfo)) {
			throw new BusinessException("合同信息不存在");
		}
		//合同结算之后，不能操作转佣
		if (Byte.valueOf("2").equals(dealInfo.getDealStatus())) {
			throw new BusinessException("合同结算之后，不能操作转佣！");
		}
		//合同作废之后，不能操作转佣
		if (Byte.valueOf("3").equals(dealInfo.getDealAuditStatus())) {
			throw new BusinessException("合同已作废，不能操作转佣！");
		}
		validateRecordHouse(record);
		validateRecordCust(record);
		//1.转佣金的时候 a.是否所有审核通过 a.验证余额还能够转佣金 b.生成财务款项c.写合同日志d.生成一条转佣的记录，状态已经审核，已转佣
		Integer caseType = getCaseType(record.getCaseNo());
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		ErpProcessFinanc insertModel = new ErpProcessFinanc();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			insertModel.setPfName("佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("佣金",cityId,compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
			insertModel.setPerformanceType((byte)2);//二手佣金
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			insertModel.setPfName("租赁佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("租赁佣金", cityId, compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
			insertModel.setPerformanceType((byte)4);//租赁佣金
		}else {
			throw new BusinessException("房源信息不完善，不能转佣金");
		}
		insertModel.setPfPayer(param.getPfPayer().toString());
		insertModel.setCompId(compId);
		insertModel.setDealId(record.getDealId());
		insertModel.setIsProfit((byte)1);
		insertModel.setPfActual((byte)1);
		//单门店直接审核
		insertModel.setAuditStatus("1");
		insertModel.setPfGeter(Const.DIC_PFMAN_BROKER);
		insertModel.setPayAmount(param.getCommssion());
		insertModel.setPfTime(new Date());
		insertModel.setDiscount(new BigDecimal(100));
		insertModel.setSourceId(record.getEarbestId());
		insertModel.setItemSource(Byte.valueOf("1"));
		insertModel.setShardCityId(cityId);
		insertModel.setPfDesc("诚意金转佣金-" + param.getEarbestRemark()==null?"":param.getEarbestRemark());
		erpProcessFinancMapper.insertSelective(insertModel);

		Integer pfId = insertModel.getPfId();//财务款项Id 用于发送JMS
		param.setPfId(pfId);
		//更新合同上应收实收金额
		erpProcessFinanceService.updateNeedandRealIncomeOffDeal(param.getCityId(),param.getCompId(),record.getDealId());
		String currentDeptUserName = param.getCurrentUserName();
		ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getBaseDealInfo(cityId,record.getDealId());
		String trackContent = currentDeptUserName+" 操作了诚意金转佣金：  "+insertModel.getPfName()+" "+insertModel.getPayAmount()+"元 "+DateTimeHelper.formatDateTimetoString(insertModel.getPfTime(),DateTimeHelper.FMT_yyyyMMdd);
		erpFunDealRecordService.writeDealRecord(param.getGeneralParam(),record.getDealId(), null,
				Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACUPDATE, (byte)1, trackContent, 1,
				(byte)1, false,null);
		//生成一条转佣金记录
		//写日志

		ErpFunEarbestMoney model = new ErpFunEarbestMoney();
		BeanUtils.copyProperties(record, model);
		model.setShardCityId(param.getCityId());
		model.setEarbestId(null);
		model.setEarbestStatus(Byte.valueOf("1")); //默认已审核
		model.setOperationType(Byte.valueOf("3")); //客户佣金
		model.setConfirmTime(new Date());
		model.setConfirmUserName(param.getUserName());
		model.setConfirmUserId(param.getUserId());
		model.setConfirmDeptId(param.getDeptId());
		model.setConfirmDeptName(param.getDeptName());

		model.setReceiptMoney(param.getCommssion().intValue());

		//业主佣金 客户姓名存业主
		String logContent = currentDeptUserName + " 于今日操作了转%s佣金%d元";
		if (Objects.equals((byte)2, param.getPfPayer())) {
			Map<Integer, HouseInfoVO> map = getHouseInfoByHouseIds(cityId, compId, Collections.singletonList(record.getCaseId()), getCaseType(record.getCaseNo()));
			HouseInfoVO houseInfoVO = map.get(record.getCaseId());
			if (Objects.nonNull(houseInfoVO)) {
				model.setCustName(houseInfoVO.getOwnerName());
			}
			model.setOperationType(Byte.valueOf("6"));//业主佣金
			logContent = String.format(logContent, "业主", model.getReceiptMoney());
		}else {
			logContent = String.format(logContent, "客户", model.getReceiptMoney());
		}

		String custName;
		String custMobile;
		String custIdcard;
		Byte idCardType;

		Map<Integer,HouseInfoVO> houseInfoMap = getHouseInfoByHouseIds(param.getCityId(), param.getCompId(), Collections.singletonList(record.getCaseId()), getCaseType(record.getCaseNo()));
		HouseInfoVO houseInfoVO = houseInfoMap.get(record.getCaseId());
		if ("1".equals(insertModel.getPfPayer())) {
			//客户
			if (null == getCustType(record.getCustNo())) {
				throw new BusinessException("客源信息不完善，不能转佣金");
			}
			Map<Integer, CustInfoVO> custInfoMap = getCustInfoByCustIds(param.getCityId(), param.getCompId(), Collections.singletonList(record.getCustId()), getCustType(record.getCustNo()));
			CustInfoVO custInfo = custInfoMap.get(record.getCustId());
			custName = custInfo.getCustomerName();
			custMobile = custInfo.getCustomerCellPhone();
			custIdcard = custInfo.getCustomerIdCard();
			idCardType = custInfo.getCustomerIdCardType();
		} else {
			//业主
			HouseInfoVO houseInfo = houseInfoVO;
			if (Objects.isNull(houseInfo)) {
				throw new BusinessException("房源信息不完善，不能转佣金");
			}
			custName = houseInfo.getOwnerName();
			custMobile = houseInfo.getHouseCellPhone();
			custIdcard = houseInfo.getHouseIdCard();
			idCardType = houseInfo.getHouseIdCardType();
		}
		custMobile = decodePhoneForHouseDetailOfFirst(custMobile, true);
		model.setCustMobile(custMobile);
		custIdcard = SyncUtil.decodeIDCARDDetail(custIdcard);
		model.setCustIdcard(custIdcard);
		model.setCustName(custName);
		model.setCustIdCardType(idCardType.intValue());
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(model.getCustName())) {
			sb.append(model.getCustName()).append(",");
		}
		if (StringUtils.isNotBlank(model.getCustIdcard())) {
			sb.append(model.getCustIdcard()).append(",");
		}
		model.setIntelligentSearch(sb.toString());
		model.setEarbestStatus((byte)1);
		model.setReceiptNo(null);
		model.setBillCodeNo(null);
		model.setBillCodeId(null);
		model.setBillWay(null);
		model.setBillPhoto(null);
		model.setReceiptNo(null);
		model.setCreateTime(new Date());
		erpFunEarbestMoneyMapper.insertSelective(model);
		//写日志
		writeOperationRecord(param.getCityId(),param.getCompId(),param.getEarbestId(),param.getUserId(), logContent);
		//
		record.setShardCityId(param.getCityId());
		erpFunEarbestMoneyMapper.updateByPrimaryKey(record);
	}

	private Map<Integer,CustInfoVO> getCustInfoByCustIds (Integer cityId, Integer compId, List<Integer> custIds ,Integer caseType) {
		if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			List<CustInfoVO> custList = erpFunBuyCustomerMapper.selectCustInfoListByIds(cityId, compId, custIds);
			return custList.stream().collect(Collectors.toMap(CustInfoVO::getCustId, a->a));
		} else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			List<CustInfoVO> custList = erpFunRentCustomerMapper.selectCustInfoListByIds(cityId, compId, custIds);
			return custList.stream().collect(Collectors.toMap(CustInfoVO::getCustId, a->a));
		}
		return Collections.emptyMap();
	}
	public ErpFunFinancPayment getDefaultProcessFinanc(String name, Integer cityId, Integer compId) {
		ErpFunFinancPaymentExample funFinancPaymentExample = new ErpFunFinancPaymentExample();
		funFinancPaymentExample.setShardCityId(cityId);
		funFinancPaymentExample.createCriteria().andCompIdEqualTo(compId).andCanDelEqualTo(0).andPaymentNameEqualTo(name);
		List<ErpFunFinancPayment> erpFunFinancPayments = erpFunFinancPaymentMapper.selectByExample(funFinancPaymentExample);
		if(erpFunFinancPayments.size() > 0) {
			return erpFunFinancPayments.get(0);
		}
		return null;
	}

	/**
	 * 代付业主
	 * @param param s
	 */
	public void transEarnestToProprietor(TransEarnestToProprietorParam param) throws InvocationTargetException, IllegalAccessException {

		ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(param.getCityId(), param.getEarbestId()));
//		record.setShardCityId(param.getCityId());
//		record.setOperationType((byte)2);//代付
//		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(record);
		//新增代付记录
		validateRecordCust(record);
		validateRecordHouse(record);
		ErpFunEarbestMoney model = new ErpFunEarbestMoney();
		org.apache.commons.beanutils.BeanUtils.copyProperties(model,record);
		BeanUtils.copyProperties(record, model);
		model.setShardCityId(param.getCityId());
		model.setEarbestId(null);
		model.setEarbestStatus(Byte.valueOf("1")); //默认审核
		model.setOperationType(Byte.valueOf("2")); //代付业主
		model.setBillCodeId(null);
		model.setBillCodeNo(null);
		model.setBillPhoto(null);
		model.setBillWay(null);
		model.setConfirmTime(null);
		model.setConfirmUserId(null);
		model.setConfirmUserName(null);
		model.setConfirmDeptId(null);
		model.setConfirmDeptName(null);
		Date dateNow = new Date();
		model.setCreateTime(dateNow);
		model.setCreateUser(param.getUserId());
		model.setUpdateTime(dateNow);
		model.setReceiptMoney(param.getPayMoney().intValue());
		String custName = null;
		String custMobile = null;
		String custIdcard = null;
		Integer idCardType = null;
		//业主
		Map<Integer, HouseInfoVO> map = getHouseInfoByHouseIds(param.getCityId(), param.getCompId(), Collections.singletonList(record.getCaseId()), getCaseType(record.getCaseNo()));
		HouseInfoVO houseInfo = map.get(record.getCaseId());
		if (Objects.isNull(houseInfo)) {
			throw new BusinessException("该房源不存在");
		}
		custName = houseInfo.getOwnerName();
		custMobile = houseInfo.getHouseCellPhone();
		custIdcard = houseInfo.getHouseIdCard();
		idCardType = Optional.ofNullable(houseInfo.getHouseIdCardType()).map(Byte::intValue).orElse(null);
		custMobile = decodePhoneForHouseDetailOfFirst(custMobile, true);
		model.setCustMobile(custMobile);
		custIdcard = EnCodeHelper.decode(custIdcard);
		model.setEarbestRemark(param.getEarbestRemark());
		model.setCustIdcard(custIdcard);
		model.setCustName(custName);
		model.setCustIdCardType(idCardType);
		model.setEarbestStatus((byte)1);//代付标记为审核
		StringBuilder sb = new StringBuilder("");
		if (StringUtils.isNotBlank(model.getCustName())) {
			sb.append(model.getCustName()).append(",");
		}
		if (StringUtils.isNotBlank(model.getCustIdcard())) {
			sb.append(model.getCustIdcard()).append(",");
		}
		model.setIntelligentSearch(sb.toString());
		model.setReceiptNo(null);
		model.setBillCodeNo(null);
		model.setBillCodeId(null);
		model.setBillWay(null);
		model.setBillPhoto(null);
		model.setReceiptNo(null);
		erpFunEarbestMoneyMapper.insertSelective(model);
//		//fun_bill
//		ErpFunBill funBill = erpFunBillMapper.getRecordByEarnestId(param.getCityId(),param.getCompId(), record.getEarbestId());
//		Assert.isNullThrow(funBill,"数据异常");
//		ErpFunBill updateModel = new ErpFunBill();
//		org.apache.commons.beanutils.BeanUtils.copyProperties(updateModel, funBill);
//		updateModel.setBillStatus((byte)1);//设置为已审核
//		updateModel.setBillPrintId(null);
//		updateModel.setEarbestId(model.getEarbestId());
//		erpFunBillMapper.insertList(param.getCityId(), Collections.singletonList(updateModel));
		String logContent = param.getUserName() + " 转业主" + param.getPayMoney().intValue() +"元";
		writeOperationRecord(param.getCityId(),param.getCompId(),record.getEarbestId(),param.getUserId(),logContent);
	}
	private Map<Integer, HouseInfoVO> getHouseInfoByHouseIds (Integer cityId, Integer compId, List<Integer> houseIds , Integer caseType) {
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			List<HouseInfoVO> custList = erpFunSaleMapper.selectHouseInfoListByIds(cityId, compId, houseIds);
			return custList.stream().collect(Collectors.toMap(HouseInfoVO::getHouseId, a->a));
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			List<HouseInfoVO> custList = erpFunLeaseMapper.selectHouseInfoListByIds(cityId, compId, houseIds);
			return custList.stream().collect(Collectors.toMap(HouseInfoVO::getHouseId, a->a));
		}
		return Collections.emptyMap();
	}
	/**
	 * 退款
	 * @param param
	 */
	@Override
	public void refundEarnestHouse(RefundMoneyParam param) throws InvocationTargetException, IllegalAccessException {

		ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(param.getCityId(), param.getEarbestId()));
		//新增代付记录
		//新增代付记录
		ErpFunEarbestMoney model = new ErpFunEarbestMoney();
		org.apache.commons.beanutils.BeanUtils.copyProperties(model,record);

		model.setShardCityId(param.getCityId());
		model.setEarbestId(null);
		model.setEarbestStatus(Byte.valueOf("1")); //默认审核
		model.setOperationType(Byte.valueOf("4")); //退款
		model.setBillCodeId(null);
		model.setBillCodeNo(null);
		model.setBillPhoto(null);
		model.setBillWay(null);
		model.setConfirmDeptName(null);
		model.setConfirmDeptId(null);
		model.setConfirmUserId(null);
		model.setConfirmUserName(null);
		model.setConfirmTime(null);
		model.setCreateUser(param.getUserId());
		Date now = new Date();
		model.setCreateTime(now);
		model.setUpdateTime(now);
		model.setReceiptMoney(param.getRefundMoney().intValue());
		model.setEarbestRemark(param.getEarbestRemark());
		//客户
		if (null == getCustType(record.getCustNo())) {
			throw new BusinessException("客源信息不完善");
		}
		Map<Integer, CustInfoVO> map = getCustInfoByCustIds(param.getCityId(), param.getCompId(), Collections.singletonList(record.getCustId()), getCustType(record.getCustNo()));
		CustInfoVO custInfo = map.get(record.getCustId());
		if (Objects.isNull(custInfo)) {
			throw new BusinessException("客源信息不存在");
		}
		String custName = custInfo.getCustomerName();
		String custMobile = custInfo.getCustomerCellPhone();
		String custIdcard = custInfo.getCustomerIdCard();
		Integer idCardType = Optional.ofNullable(custInfo.getCustomerIdCardType()).map(Byte::intValue).orElse(null);
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
		if (StringUtils.isNotBlank(model.getCustIdcard())) {
			sb.append(model.getCustIdcard()).append(",");
		}
		model.setIntelligentSearch(sb.toString());
		model.setEarbestStatus((byte)1);//退款标记审核
		model.setReceiptNo(null);
		model.setBillCodeNo(null);
		model.setBillCodeId(null);
		model.setBillWay(null);
		model.setBillPhoto(null);
		model.setReceiptNo(null);
		erpFunEarbestMoneyMapper.insertSelective(model);

		//fun_bill
//		ErpFunBill funBill = erpFunBillMapper.getRecordByEarnestId(param.getCityId(),param.getCompId(), record.getEarbestId());
//		Assert.isNullThrow(funBill,"数据异常");
//		ErpFunBill updateModel = new ErpFunBill();
//		org.apache.commons.beanutils.BeanUtils.copyProperties(updateModel, funBill);
//		updateModel.setBillStatus((byte)1);//设置为已审核
//		updateModel.setBillPrintId(null);
//		updateModel.setEarbestId(model.getEarbestId());
//		erpFunBillMapper.insertList(param.getCityId(), Collections.singletonList(updateModel));
		String logContent = param.getUserName() + " 退款 "+ param.getRefundMoney().intValue() + "元";
		writeOperationRecord(param.getCityId(),param.getCompId(),record.getEarbestId(),param.getUserId(),logContent);

		//判断是否有余额 确定是否需要取消房源预定状态
		if (param.isFJD()) {
			erpEarbestDepositCommService.judgeAndResetHouseEarbestStatus(param.getCityId(), record);
		}
	}

	/**
	 * 需要重新审核
	 * @param newRecord x
	 */
	private void createTransEarnestRecord(ErpFunEarbestMoney newRecord) {
		newRecord.setEarbestStatus((byte)0);
		newRecord.setConfirmTime(null);
		newRecord.setConfirmUserId(null);
		newRecord.setConfirmUserName(null);
		newRecord.setConfirmDeptName(null);
		newRecord.setConfirmDeptId(null);
		erpFunEarbestMoneyMapper.insertSelective(newRecord);
	}

	public void updateEarnestDeal(GeneralParam generalParam, Integer dealId, String contractNo,Integer earbestId) {
		if (Objects.isNull(earbestId) || Objects.isNull(dealId) || Objects.isNull(contractNo) || Objects.isNull(generalParam)) {
			return;
		}
		List<ErpFunEarbestMoney> list;
		ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(generalParam.getCityId(), earbestId));
		if (Objects.isNull(record)) {
			return;
		}
		if(record.getDealId()!=null){
			list = erpFunEarbestMoneyMapper.selectEarbestListByDealId(generalParam.getCityId(), generalParam.getCompId(), record.getDealId());
		}else {
			list = erpFunEarbestMoneyMapper.selectEarbestListByHouseCustId(generalParam.getCityId(), generalParam.getCompId(), record.getCustNo(), record.getCustId(), record.getCaseNo(), record.getCaseId(), false);
		}
		for (ErpFunEarbestMoney obj : list) {
			//审核之前不能转成交
			if(Objects.equals((byte)0,obj.getEarbestStatus())){
				return;
			}
		}
		String currentDeptUserName = getCurrUserName(generalParam.getCompType(),generalParam.getUserName(),generalParam.getDeptName(),generalParam.isPersonalVersion());
//		List<Integer> earbestIds = list.stream().map(ErpFunEarbestMoney::getEarbestId).collect(Collectors.toList());
		//更新关联的流水上的合同id合同编号字段
		erpFunEarbestMoneyMapper.updateDealInfoByIds(generalParam.getCityId(),generalParam.getCompId(),contractNo,dealId,Collections.singletonList(earbestId));
		//更新票据上的合同id，合同编号字段
		erpFunBillMapper.updateBillDealInfoByEarbestIds(generalParam.getCityId(),generalParam.getCompId(),contractNo,dealId,Collections.singletonList(earbestId));

		String logContent = currentDeptUserName + " 于今日将诚意金转为成交，合同编号:" + contractNo;
//		for (Integer id : earbestIds) {
		//写日志
		writeOperationRecord(generalParam.getCityId(),generalParam.getCompId(),earbestId, generalParam.getUserId(),logContent);
//		}
		if (generalParam.getFJD()) {
			//房基地
			erpEarbestDepositCommService.makeEarbestBargainSuccess(generalParam.getCityId(), record);
		}
	}

	private String getCurrUserName(Integer compType, String userName, String deptName, Boolean personalVersion) {
		// 不是纯精英版也不是专业版 才写门店名称
		if (compType!=null && !Constants_DIC.DIC_COMP_TYPE_2.equals(compType.toString()) && !personalVersion) {
			userName = deptName + " " + userName;
		}
		return userName;
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

	public void validateRecordCust(ErpFunEarbestMoney old) {
		if (StringUtils.isNotBlank(old.getCustNo()) && old.getCustId() != null) {
			return;
		}

		if (StringUtils.isNotBlank(old.getCustNo())) {
			Integer custType = getCaseType(old.getCustNo());
			if (custType == null) {
				if ("1".equals(old.getPerformanceName())) {
					custType = 3;
				}else if ("2".equals(old.getPerformanceName())) {
					custType = 4;
				}else{
					throw new BusinessException("客源信息不完善");
				}
			}
		}else {
			if(old.getCustId()==null || !"1".equals(old.getPerformanceName()) && !"2".equals(old.getPerformanceName())){
				throw new BusinessException("客源信息不完善");
			}
		}
	}


	public void validateRecordHouse(ErpFunEarbestMoney old) {

		if (StringUtils.isNotBlank(old.getCaseNo()) && old.getCaseId() != null) {
			return;
		}

		if (StringUtils.isNotBlank(old.getCaseNo())) {
			Integer caseType = getCaseType(old.getCaseNo());
			if (caseType == null) {
				if ("1".equals(old.getPerformanceName())) {
					caseType = 1;
				}else if ("2".equals(old.getPerformanceName())) {
					caseType = 2;
				}else{
					throw new BusinessException("房源信息不完善");
				}
			}
		}else {
			if(old.getCaseId()==null || !"1".equals(old.getPerformanceName()) && !"2".equals(old.getPerformanceName())){
				throw new BusinessException("房源信息不完善");
			}
		}
	}


}
