package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.QueryPrintBuillInfoParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpFunBillExample.Criteria;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBillCodeService;
import com.myfun.service.business.erpdb.ErpFunBillCodelogService;
import com.myfun.service.business.erpdb.ErpFunBillService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ErpFunBillServiceImpl extends AbstractService<ErpFunBill, ErpFunBill> implements ErpFunBillService{
	@Autowired ErpFunBillMapper erpFunBillMapper;
	@Autowired ErpFunBillPrintMapper erpFunBillPrintMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired ErpEarbestMoneyMapper erpEarbestMoneyMapper;
	@Autowired ErpFunDealMapper erpFunDealMapper;
	@Autowired ErpFunDealRecordMapper erpFunDealRecordMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunEarbestMoneyrecordMapper erpFunEarbestMoneyrecordMapper;
	@Autowired ErpFunBillCodeService erpFunBillCodeService;
	@Autowired
    ErpFunBillCodelogMapper erpFunBillCodelogMapper;
	@Autowired
    ErpFunBillCodelogService erpFunBillCodelogService;
	@Autowired
	ErpFunDepositMapper erpFunDepositMapper;
	@Autowired
	ErpFunDepositLogMapper erpFunDepositLogMapper;
	@Autowired
	private ErpFunEarbestMoneyMapper erpFunEarbestMoneyMapper;

	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunBillMapper;
	}
	
	/**
	 * 打印票据
	 */
	@Transactional
	@Override
	public void printBill(QueryPrintBuillInfoParam param) {
		String billNo = param.getBillNo();
		String earBestMoneyIds = param.getEarBestMoneyIds();
		String financIds = param.getFinancIds();
		Byte printType = param.getPrintType();//0没有打印过 1是打印过的
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();
		Integer grId = param.getGrId();
		Integer userId = param.getUserId();
		Integer dealId = param.getDealId();
		ErpFunDeal dealInfo = null;
		String billCodeNo = param.getBillNo();
		Integer billCodeId = param.getBillCodeId();
		Byte billType = Byte.valueOf("0");
		if (dealId!=null) {
			dealInfo = erpFunDealMapper.selectByDealId(cityId, dealId, null);
			if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealInfo.getDealType().intValue())) {
				billType = Byte.valueOf("1");
			} else {
				billType = Byte.valueOf("2");
			}
		}
		String[] financIdArr = null;
		String[] earBestIdArr = null;
		List<Integer> financIdList = null;
		List<Integer> earBestIdList = null;
		List<Integer> depositIdList = null;
		if (StringUtils.isNotBlank(financIds)) {
			financIdList = new ArrayList<>();
			financIdArr = financIds.split(",");
			for (String financId:financIdArr) {
				financIdList.add(Integer.valueOf(financId));
			}
		} else if (StringUtils.isNotBlank(earBestMoneyIds)) {
			earBestIdList = new ArrayList<>();
			earBestIdArr = earBestMoneyIds.split(",");
			for (String earBestId:earBestIdArr) {
				earBestIdList.add(Integer.valueOf(earBestId));
			}
		}else if(StringUtils.isNotBlank(param.getDepositIds())){
			//定金
			depositIdList = Arrays.stream(param.getDepositIds().replaceAll("\\s","").split(",")).map(Integer::parseInt).collect(Collectors.toList());
		}
		//已经打印过了，更新打印次数
		if (Byte.valueOf("1").equals(printType)) {
			ErpFunBillExample example = new ErpFunBillExample();
			example.setShardCityId(cityId);
			ErpFunBillExample.Criteria criteria = example.createCriteria();
			criteria.andCompIdEqualTo(compId);
			if (financIdList!=null) {
				criteria.andFianacIdIn(financIdList);
			} else if (earBestIdList!=null) {
				criteria.andEarbestIdIn(earBestIdList);
			} else if (depositIdList != null) {
				//定金
				criteria.andDepositIdIn(depositIdList);
			}
			criteria.andBillStatusNotEqualTo(Byte.valueOf("2"));
			List<ErpFunBill> billList = erpFunBillMapper.selectByExample(example);
			if (!billList.isEmpty()) {
				Integer printId = billList.get(0).getBillPrintId();//获取最新的打印id
				erpFunBillPrintMapper.updateBillPrintCountAndUserInfo(cityId,printId,userId);
			}
		}
		if (Byte.valueOf("0").equals(param.getBillWay()) && Byte.valueOf("0").equals(printType) && (dealId!=null)) {
			List<ErpFunBill> billList = new ArrayList<ErpFunBill>();
			if (financIdList!=null) {
				int count = erpFunBillCodeService.judgeBillCodeLogIsReapt(cityId, compId, deptId, billType, param.getBillWay(), billCodeId, financIdList, billNo);
				if (count>0) {
					throw new BusinessException("该票据编号已被使用了！");
				}
				ErpProcessFinancExample example = new ErpProcessFinancExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId).andPfIdIn(financIdList);
				List<ErpProcessFinanc> erpProcessFinancList = erpProcessFinancMapper.selectByExample(example);
				for (ErpProcessFinanc erpProcessFinanc:erpProcessFinancList) {
					billCodeNo =  erpProcessFinanc.getBillCodeNo();
					String pfPayer = erpProcessFinanc.getPfPayer().toString();
					String payCustomer = null;
					if ("1".equals(pfPayer)) {
						payCustomer = dealInfo.getBuyOwnerName();
					} else {
						payCustomer = dealInfo.getSellOwnerName();
					}
					//erppro
					ErpFunBill record = new ErpFunBill();
					record.setShardCityId(cityId);
					record.setCompId(compId);
					record.setCreationTime(new Date());
					record.setAreaId(areaId);
					record.setRegId(regId);
					record.setDeptId(deptId);
					record.setGrId(grId);
					record.setUserId(userId);
					record.setDealId(dealId);
					record.setFianacId(erpProcessFinanc.getPfId());
					record.setContractNo(dealInfo.getContractNo());
					record.setBillNo(billNo);
//					record.setBillStatus(Byte.valueOf("0"));//设置为未确认
					if ("1".equals(erpProcessFinanc.getAuditStatus())){
						record.setBillStatus((byte)1);
					}else {
						record.setBillStatus((byte)0);
					}
					record.setBillType(billType);//这里是诚意金
					record.setBillWay(param.getBillWay());
					record.setPayCustomer(payCustomer);
					record.setPayMoney(erpProcessFinanc.getPayAmount());
					record.setIntelligentSearch(erpProcessFinanc.getBillCodeNo() +","+dealInfo.getContractNo()+ ","+(StringUtils.isBlank(payCustomer)?"":payCustomer));
					record.setReceiptMoneyDept(erpProcessFinanc.getReceiptMoneyDept());
					record.setReceiptMoneyUser(erpProcessFinanc.getReceiptMoneyUser());
					record.setReceiptTime(erpProcessFinanc.getPfTime());
					record.setBillPrintWay(param.getBillPrintWay());
					record.setFianacPayment(erpProcessFinanc.getPfName());
					billList.add(record);
				}
			}
			erpFunBillMapper.insertList(cityId,billList);
			erpFunBillCodeService.updateBillCodeLogStatus(cityId, compId, deptId, billNo, 1);
		}
		if (Byte.valueOf("0").equals(printType)) {
			ErpFunBillPrint erpFunBillPrint = new ErpFunBillPrint();
			erpFunBillPrint.setShardCityId(cityId);
			erpFunBillPrint.setCreatorUid(userId);
			erpFunBillPrint.setCreationTime(new Date());
			erpFunBillPrint.setPrintCount(1);
			erpFunBillPrint.setPrintCountUser(userId);
			erpFunBillPrint.setLastPrintTime(new Date());
			erpFunBillPrintMapper.insertSelective(erpFunBillPrint);
			Integer printId = erpFunBillPrint.getId();
			//更新关联
			ErpFunBill erpFunBill = new ErpFunBill();
			ErpFunBillExample updateExample = new ErpFunBillExample();
			updateExample.setShardCityId(cityId);
			Criteria criteria = updateExample.createCriteria();
			criteria.andCompIdEqualTo(compId).andBillStatusNotEqualTo(Byte.valueOf("2"));
			erpFunBill.setBillPrintId(printId);
			erpFunBill.setBillPrintWay(param.getBillPrintWay());
			if (financIdList!=null) {
				criteria.andFianacIdIn(financIdList);
			} else if (earBestIdList!=null) {
				criteria.andEarbestIdIn(earBestIdList);
			}else if(depositIdList!=null){
				criteria.andDepositIdIn(depositIdList);
			}
			erpFunBillMapper.updateByExampleSelective(erpFunBill, updateExample);
		}
		String currentUserName = erpFunUsersMapper.getCurrUserName(cityId, userId, deptId);
		if (financIdList!=null) {
			ErpFunDealRecord record = new ErpFunDealRecord();
			record.setShardCityId(cityId);
			record.setCompId(compId);
			record.setUpdateClassic("票据打印");
			record.setUpdateType(Byte.valueOf("1"));
			record.setTrackContent(currentUserName + " 打印了票据号" +billCodeNo+ "的票据");
			record.setAgreementNo(dealId.toString());
			record.setUpdateDate(DateTimeHelper.formatDateTimetoString(new Date()));
			record.setUpdateUid(userId);
			record.setUpdateUserName(param.getUserName());
			erpFunDealRecordMapper.insertSelective(record);
			ErpProcessFinancExample updateProcessExample = new ErpProcessFinancExample();
			updateProcessExample.setShardCityId(cityId);
			updateProcessExample.createCriteria().andCompIdEqualTo(compId).andPfIdIn(financIdList);
			if (billCodeId != null) {
				ErpProcessFinanc processFinanc = new ErpProcessFinanc();
				processFinanc.setIsPrint(Byte.valueOf("1"));
				processFinanc.setBillCodeId(billCodeId);
				processFinanc.setBillCodeNo(billNo);
				erpProcessFinancMapper.updateByExampleSelective(processFinanc, updateProcessExample);
			}
		} else if(earBestIdList != null){
			for (Integer id : earBestIdList) {
				ErpFunEarbestMoneyrecord record = new ErpFunEarbestMoneyrecord();
				record.setShardCityId(cityId);
				record.setCompId(compId);
				record.setEarbestId(id);
				record.setCreateTime(new Date());
				record.setCreateUser(userId);
				record.setLogContent(currentUserName + " 打印了票据号" +billCodeNo+ "的票据");
				erpFunEarbestMoneyrecordMapper.insertSelective(record);
				ErpEarbestMoney updateModel = new ErpEarbestMoney();
				updateModel.setShardCityId(cityId);
				updateModel.setIsPrint(Byte.valueOf("1"));
				updateModel.setEarbestId(id);
				erpEarbestMoneyMapper.updateByPrimaryKeySelective(updateModel);
			}
		} else if (depositIdList != null) {
			for (Integer id : depositIdList) {
				ErpFunDepositLog record = new ErpFunDepositLog();
				record.setShardCityId(cityId);
				record.setCompId(compId);
				record.setDepositId(id);
				record.setCreateTime(new Date());
				record.setCreateUserId(userId);
				record.setLogContent(currentUserName + " 打印了票据号" +billCodeNo+ "的票据");
				erpFunDepositLogMapper.insertSelective(record);
				ErpFunDeposit updateModel = new ErpFunDeposit();
				updateModel.setShardCityId(cityId);
				updateModel.setIsPrint(Byte.valueOf("1"));
				updateModel.setId(id);
				erpFunDepositMapper.updateByPrimaryKeySelective(updateModel);
			}
		}
	}

	@Transactional
	@Override
	public void saveBillPhoto(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, Integer earbestId,
			Integer financId,Integer dealId , Integer depositId, String photoUrl, String billNo) {
		String currentUserName = erpFunUsersMapper.getCurrUserName(cityId, userId, deptId);
		if (financId!=null) {
			//更新财务上的票据图片地址
			ErpProcessFinancExample processExample = new ErpProcessFinancExample();
			processExample.setShardCityId(cityId);
			processExample.createCriteria().andCompIdEqualTo(compId).andPfIdEqualTo(financId);
			ErpProcessFinanc updateModel = new ErpProcessFinanc();
			updateModel.setBillPhoto(photoUrl);
			erpProcessFinancMapper.updateByExampleSelective(updateModel, processExample);
			//更新票据上的图片地址
			ErpFunBillExample billExample = new ErpFunBillExample();
			billExample.setShardCityId(cityId);
			billExample.createCriteria().andCompIdEqualTo(compId).andFianacIdEqualTo(financId).andBillStatusNotEqualTo(Byte.valueOf("2"));
			ErpFunBill erpFunBill = new ErpFunBill();
			erpFunBill.setBillPhoto(photoUrl);
			erpFunBillMapper.updateByExampleSelective(erpFunBill, billExample);
			ErpFunDealRecord record = new ErpFunDealRecord();
			record.setShardCityId(cityId);
			record.setCompId(compId);
			record.setUpdateClassic("票据上传");
			record.setUpdateType(Byte.valueOf("1"));
			record.setTrackContent(currentUserName + " 上传了票据号" + billNo + "的票据照片");
			record.setAgreementNo(dealId.toString());
			record.setUpdateDate(DateTimeHelper.formatDateTimetoString(new Date()));
			record.setUpdateUid(userId);
			record.setUpdateUserName(userName);
			erpFunDealRecordMapper.insertSelective(record);
		} else if(earbestId!=null) {
			//更新诚意金上的票据图片地址
			ErpEarbestMoneyExample example = new ErpEarbestMoneyExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId).andEarbestIdEqualTo(earbestId);
			ErpEarbestMoney updateModel = new ErpEarbestMoney();
			updateModel.setBillPhoto(photoUrl);
			erpEarbestMoneyMapper.updateByExampleSelective(updateModel, example);
			//更新票据上的图片地址
			ErpFunBillExample billExample = new ErpFunBillExample();
			billExample.setShardCityId(cityId);
			billExample.createCriteria().andCompIdEqualTo(compId).andEarbestIdEqualTo(earbestId);
			ErpFunBill erpFunBill = new ErpFunBill();
			erpFunBill.setBillPhoto(photoUrl);
			erpFunBillMapper.updateByExampleSelective(erpFunBill, billExample);
			ErpFunEarbestMoneyrecord record = new ErpFunEarbestMoneyrecord();
			record.setShardCityId(cityId);
			record.setCompId(compId);
			record.setEarbestId(earbestId);
			record.setCreateTime(new Date());
			record.setCreateUser(userId);
			record.setLogContent(currentUserName + " 上传了票据号" + billNo + "的票据照片");
			erpFunEarbestMoneyrecordMapper.insertSelective(record);
		} else if(depositId!=null) {
			erpFunDepositMapper.updateDepositBillPhoto(cityId,depositId,photoUrl);
			ErpFunBillExample billExample = new ErpFunBillExample();
			billExample.setShardCityId(cityId);
			billExample.createCriteria().andCompIdEqualTo(compId).andDepositIdEqualTo(depositId);
			ErpFunBill erpFunBill = new ErpFunBill();
			erpFunBill.setBillPhoto(photoUrl);
			erpFunBillMapper.updateByExampleSelective(erpFunBill, billExample);
			ErpFunDepositLog record = new ErpFunDepositLog();
			record.setShardCityId(cityId);
			record.setCompId(compId);
			record.setDepositId(depositId);
			record.setCreateTime(new Date());
			record.setCreateUserId(userId);
			record.setLogContent(currentUserName + " 上传了票据号" + billNo + "的票据照片");
			erpFunDepositLogMapper.insertSelective(record);
		}
		/*//更新诚意金上的票据图片地址
		ErpEarbestMoneyExample example = new ErpEarbestMoneyExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andEarbestIdEqualTo(earbestId);
		ErpEarbestMoney updateModel = new ErpEarbestMoney();
		updateModel.setBillPhoto(photoUrl);
		erpEarbestMoneyMapper.updateByExampleSelective(updateModel, example);
		//更新票据上的图片地址
		ErpFunBillExample billExample = new ErpFunBillExample();
		billExample.setShardCityId(cityId);
		billExample.createCriteria().andCompIdEqualTo(compId).andEarbestIdEqualTo(earbestId);
		ErpFunBill erpFunBill = new ErpFunBill();
		erpFunBill.setBillPhoto(photoUrl);
		erpFunBillMapper.updateByExampleSelective(erpFunBill, billExample);
		ErpFunEarbestMoneyrecord record = new ErpFunEarbestMoneyrecord();
		record.setShardCityId(cityId);
		record.setCompId(compId);
		record.setEarbestId(earbestId);
		record.setCreateTime(new Date());
		record.setCreateUser(userId);
		record.setLogContent(currentUserName + " 上传了票据号" + billNo + "的票据照片");
		erpFunEarbestMoneyrecordMapper.insertSelective(record);*/
	}

	@Transactional
	@Override
	public void delBillPhoto(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, Integer earbestId,
			Integer financId,Integer dealId ,Integer depositId, String billNo) {
		String currentUserName = erpFunUsersMapper.getCurrUserName(cityId, userId, deptId);
		if (financId!=null) {
			erpFunBillMapper.delBillPhoto(cityId,compId,null,financId,null);
			erpProcessFinancMapper.delBillPhoto(cityId,financId);
			ErpFunDealRecord record = new ErpFunDealRecord();
			record.setShardCityId(cityId);
			record.setCompId(compId);
			record.setUpdateClassic("票据删除");
			record.setUpdateType(Byte.valueOf("1"));
			record.setTrackContent(currentUserName + " 删除了票据号" + billNo + "的票据照片");
			record.setAgreementNo(dealId.toString());
			record.setUpdateDate(DateTimeHelper.formatDateTimetoString(new Date()));
			record.setUpdateUid(userId);
			record.setUpdateUserName(userName);
			erpFunDealRecordMapper.insertSelective(record);
		} else if(earbestId!=null) {
			erpFunBillMapper.delBillPhoto(cityId,compId,earbestId,null,null);
			erpEarbestMoneyMapper.delBillPhoto(cityId,earbestId);
			ErpFunEarbestMoneyrecord record = new ErpFunEarbestMoneyrecord();
			record.setShardCityId(cityId);
			record.setCompId(compId);
			record.setEarbestId(earbestId);
			record.setCreateTime(new Date());
			record.setCreateUser(userId);
			record.setLogContent(currentUserName + " 删除了票据号" + billNo + "的票据照片");
			erpFunEarbestMoneyrecordMapper.insertSelective(record);
			
		} else if(depositId!=null) {
			erpFunBillMapper.delBillPhoto(cityId,compId,null,null,depositId);
			erpFunDepositMapper.delBillPhoto(cityId,depositId);
			ErpFunDepositLog record = new ErpFunDepositLog();
			record.setShardCityId(cityId);
			record.setCompId(compId);
			record.setDepositId(depositId);
			record.setCreateTime(new Date());
			record.setCreateUserId(userId);
			record.setLogContent(currentUserName + " 删除了票据号" + billNo + "的票据照片");
			erpFunDepositLogMapper.insertSelective(record);
		}
	}

	@Transactional
	@Override
	public void createBill(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, Integer dealId, String contractNo , Byte dealType, Byte billWay, List<ErpProcessFinanc> processFinancList, List<ErpFunEarbestMoney> earbestMoneyList, ErpFunDeposit deposit,
						   boolean isPrint)  {
		String printWay = erpSysParaMapper.getParamValue(cityId,compId,"BILL_PRINT_WAY");
		ErpFunDeal erpFunDeal = new ErpFunDeal();

		erpFunDeal.setShardCityId(cityId);
		if (null != dealId) {
			erpFunDeal.setDealId(dealId);
			erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDeal);
		}
		if (processFinancList!=null) {
			for (ErpProcessFinanc financPo : processFinancList) {
				ErpFunBill funBillPO = new ErpFunBill();
				funBillPO.setShardCityId(cityId);
				if (null != dealId) {
					String pfPayer = financPo.getPfPayer();
					if ("1".equals(pfPayer)) {
						funBillPO.setPayCustomer(erpFunDeal.getBuyOwnerName());
					} else {
						funBillPO.setPayCustomer(erpFunDeal.getSellOwnerName());
					}
				}
				createBillRecord(cityId, compId, areaId, regId, deptId, grId, userId, funBillPO, dealId, contractNo, dealType, printWay, isPrint, financPo, null, null);
				erpFunBillCodelogService.updateBillCodeLogStatus(cityId, compId, financPo.getBillCodeNo(), "1");
			}
		} else if (earbestMoneyList!=null){
			for (ErpFunEarbestMoney earbestMoneyPO : earbestMoneyList) {
				ErpFunBill billPO = new ErpFunBill();
				billPO.setPayCustomer(earbestMoneyPO.getCustName());
				createBillRecord(cityId, compId, areaId, regId, deptId, grId, userId, billPO, dealId, contractNo, dealType, printWay, isPrint, null, earbestMoneyPO,null);
				erpFunBillCodelogService.updateBillCodeLogStatus(cityId, compId, earbestMoneyPO.getReceiptNo(), "1");
			}
		} else if (deposit!=null) {
			ErpFunBill billPO = new ErpFunBill();
			billPO.setPayCustomer(deposit.getCustName());
			createBillRecord(cityId, compId, areaId, regId, deptId, grId, userId, billPO, dealId, contractNo, dealType, printWay, isPrint, null, null,deposit);
			erpFunBillCodelogService.updateBillCodeLogStatus(cityId, compId, deposit.getBillCodeNo(), "1");
		}
	}


	/**
	 *
	 * @param cityId
	 * @param compId
	 * @param codeNo
	 * @param useCancellation 是否可用已作废票据单号
	 * @return
	 */
	@Override
	public boolean checkBillCodeRepeat(Integer cityId, Integer compId,String codeNo){
		String invalidBillNoCanUseAgain = erpSysParaMapper.getParamValue(cityId, compId, "INVALID_BILLNO_CAN_USE_AGAIN");
		boolean useCancellation = "1".equals(invalidBillNoCanUseAgain);
		if (checkEarnestBillNoRepeat(cityId, compId, codeNo, useCancellation)) return true;
		if (checkDepositBillNoRepeat(cityId, compId, codeNo, useCancellation)) return true;
		return false;
	}

	/**
	 *
	 * @param cityId
	 * @param compId
	 * @param codeNo 票据单号
	 * @param useCancellation 是否可用已作废票据单号
	 * @param specialTable 1表示诚意金表 2表示定金表
	 * @return
	 */
	public boolean checkBillRepeatSpecialTable(Integer cityId, Integer compId,String codeNo,boolean useCancellation,Byte specialTable) {
		if (specialTable == 1) {
			//仅检查诚意金表
			return checkEarnestBillNoRepeat(cityId, compId, codeNo, useCancellation);
		} else if (specialTable == 2) {
			//仅检查定金金表
			return checkDepositBillNoRepeat(cityId, compId, codeNo, useCancellation);
		}
		return false;
	}


	private boolean checkDepositBillNoRepeat(Integer cityId, Integer compId, String codeNo, boolean useCancellation) {
		int count;//检查定金表
		ErpFunDepositExample erpFunDepositExample = new ErpFunDepositExample();
		erpFunDepositExample.setShardCityId(cityId);
		ErpFunDepositExample.Criteria criteria1 = erpFunDepositExample.createCriteria().andCompIdEqualTo(compId).andBillCodeNoEqualTo(codeNo).andIsDelEqualTo((byte)0);
		if (useCancellation) {
			//2表示作废
			criteria1.andOperationTypeNotEqualTo((byte)5);
		}
		count = erpFunDepositMapper.countByExample(erpFunDepositExample);
		if (count > 0) {
			return true;
		}
		return false;
	}

	private boolean checkEarnestBillNoRepeat(Integer cityId, Integer compId, String codeNo, boolean useCancellation) {
		//检查诚意金和定金表
		ErpFunEarbestMoneyExample example = new ErpFunEarbestMoneyExample();
		example.setShardCityId(cityId);
		ErpFunEarbestMoneyExample.Criteria criteria = example.createCriteria().andCompIdEqualTo(compId).andReceiptNoEqualTo(codeNo).andIsDelEqualTo((byte)0);
		if (useCancellation) {
			//4表示作废
			criteria.andOperationTypeNotEqualTo((byte)5);
		}
		int count = erpFunEarbestMoneyMapper.countByExample(example);
		if (count > 0) {
			return true;
		}
		return false;
	}


	/**
	 * 日志
	 * @author lcb
	 * @date 2018/7/13
	 * @return
	 */
	private void createBillRecord(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId,
								  Integer userId, ErpFunBill billPO, Integer dealId,String contractNo ,Byte dealType, String billPrintWay,boolean isPrint, ErpProcessFinanc financPO, ErpFunEarbestMoney earbestMoney , ErpFunDeposit deposit) {
		Integer billType = 0;
		Integer receiptMoneyUser = null;
		Integer receiptMoneyDept = null;
		String fianacPayment = null;
		String billNo = null;
		BigDecimal payMoney = null;
		Integer fianacId = null;
		Integer earbestId = null;
		Integer depositId = null;
		Byte billWay = null;
		Integer billCodeId = null;
		
		Date receiptTime = null;
		if (financPO!=null) {
			billCodeId = financPO.getBillCodeId();
			receiptMoneyUser = financPO.getReceiptMoneyUser();
			receiptMoneyDept = financPO.getReceiptMoneyDept();
			billNo = financPO.getBillCodeNo();
			fianacPayment = financPO.getPfName();
			payMoney = financPO.getPayAmount();
			billWay = financPO.getBillWay();
			receiptTime = financPO.getPfTime();
			fianacId = financPO.getPfId();
		} else if ( earbestMoney!=null ) {
			billCodeId = earbestMoney.getBillCodeId();
			receiptMoneyUser = earbestMoney.getReceiptUserId();
			receiptMoneyDept = earbestMoney.getReceiptDeptId();
			billNo = earbestMoney.getReceiptNo();
			if(null != earbestMoney.getReceiptMoney()) {
				payMoney = new BigDecimal(earbestMoney.getReceiptMoney());
			}
			billWay = earbestMoney.getBillWay();
			billPO.setPayCustomer(earbestMoney.getCustName());
			receiptTime = earbestMoney.getReceiptTime();
			earbestId = earbestMoney.getEarbestId();
		} else if (deposit!=null) {
			billCodeId = deposit.getBillCodeId();
			receiptMoneyUser = deposit.getReceiptUserId();
			receiptMoneyDept = deposit.getReceiptDeptId();
			billNo = deposit.getBillCodeNo();
			if(null != deposit.getReceiptMoney()) {
				payMoney = deposit.getReceiptMoney();
			}
			billWay = deposit.getBillWay();
			billPO.setPayCustomer(deposit.getCustName());
			receiptTime = deposit.getReceiptTime();
			depositId = deposit.getId();
		}
		if (null != dealType) {
			billType = Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType) ? 1 : 2;
		}
		//判重
		Integer result = erpFunBillCodelogService.judgeBillCodeNoRepeat(cityId, compId, billCodeId, billNo, billType.byteValue());
		if (result>0) {
			throw new BusinessException("该票据号已被使用！");
		}
		//只有写两套，原因是不在一个事务里面，判不了重
		billPO.setReceiptMoneyUser(receiptMoneyUser);
		billPO.setReceiptMoneyDept(receiptMoneyDept);
		billPO.setBillType(billType.byteValue());
		billPO.setCompId(compId);
		billPO.setAreaId(areaId);
		billPO.setRegId(regId);
		billPO.setDeptId(deptId);
		billPO.setGrId(grId);
		billPO.setUserId(userId);
		billPO.setCreationTime(new Date());
		billPO.setReceiptTime(receiptTime);
		billPO.setBillNo(billNo);
		billPO.setFianacPayment(fianacPayment);
		billPO.setContractNo(contractNo );
		billPO.setDealId(dealId);
		billPO.setPayMoney(payMoney);
		billPO.setIntelligentSearch(billPO.getBillNo()+","+(StringUtils.isBlank(billPO.getPayCustomer())?"":billPO.getPayCustomer())+","+(StringUtils.isBlank(contractNo)?"":contractNo));
		billPO.setFianacId(fianacId);
		billPO.setEarbestId(earbestId);
		billPO.setDepositId(depositId);
		billPO.setBillStatus((byte) 0);
		billPO.setBillWay(billWay);
		if (isPrint) {
			if (StringUtils.isNotBlank(billPrintWay)) {
				billPO.setBillPrintWay(new Byte(billPrintWay));
			}
		}

		billPO.setShardCityId(cityId);
		erpFunBillMapper.insertSelective(billPO);

	}

	@Transactional
	@Override
	public void createBill(GeneralParam generalParam, Integer dealId, String contractNo, Byte dealType, String billWay, List<ErpProcessFinanc> processFinancList, List<ErpFunEarbestMoney> earbestMoneyList, ErpFunDeposit deposit, boolean isPrint) {
		Integer cityId=generalParam.getCityId();
		Integer compId=generalParam.getCompId();
		Integer deptId=generalParam.getDeptId();
		String printWay = erpSysParaMapper.getParamValue(cityId,compId,"BILL_PRINT_WAY");
		ErpFunDeal dealPO = null;
		if (dealId!=null) {
			dealPO = erpFunDealMapper.getBaseDealInfo(cityId,dealId);
		}
		if (processFinancList!=null) {
			for (ErpProcessFinanc financPo:processFinancList) {
				ErpFunBill billPO = new ErpFunBill();
				billPO.setShardCityId(cityId);
				if (processFinancList!=null) {
					String pfPayer = financPo.getPfPayer();
					if ("1".equals(pfPayer)) {
						billPO.setPayCustomer(dealPO.getBuyOwnerName());
					} else {
						billPO.setPayCustomer(dealPO.getSellOwnerName());
					}
				}
				this.createBillRecordNew(generalParam,billPO, dealId, contractNo, dealType, StringUtil.parseByte(printWay), isPrint, financPo, null, null);
				erpFunBillMapper.insertSelective(billPO);
				erpFunBillCodelogService.updateBillCodeLogStatus(cityId, compId,  financPo.getBillCodeNo(), "1");
			}
		} else if (earbestMoneyList!=null){
			for (ErpFunEarbestMoney earbestMoneyPO:earbestMoneyList) {
				ErpFunBill billPO = new ErpFunBill();
				billPO.setPayCustomer(earbestMoneyPO.getCustName());
				this.createBillRecord(generalParam,billPO, dealId, contractNo, dealType, StringUtil.parseByte(printWay), isPrint, null, earbestMoneyPO, null);
				erpFunBillMapper.insertSelective(billPO);
				erpFunBillCodelogService.updateBillCodeLogStatus(cityId, compId,  earbestMoneyPO.getBillCodeNo(), "1");
			}
		} else if (deposit!=null) {
			ErpFunBill billPO = new ErpFunBill();
			billPO.setPayCustomer(deposit.getCustName());
			this.createBillRecord(generalParam,billPO, dealId, contractNo, dealType, StringUtil.parseByte(printWay), isPrint, null, null, deposit);
			erpFunBillCodelogService.updateBillCodeLogStatus(cityId, compId, deposit.getBillCodeNo(), "1");
		}
	}

	private void createBillRecord(GeneralParam generalParam, ErpFunBill billPO, Integer dealId, String contractNo, Byte dealType, Byte billPrintWay, boolean isPrint, ErpProcessFinanc financPo, ErpFunEarbestMoney earbestMoney, ErpFunDeposit deposit) {
		Integer compId = generalParam.getCompId();
		Integer cityId=generalParam.getCityId();
		Integer areaId = generalParam.getAreaId();
		Integer regId = generalParam.getRegId();
		Integer deptId = generalParam.getDeptId();
		Integer grId = generalParam.getGrId();
		Integer userId = generalParam.getArchiveId();
		Integer billType = 0;
		Integer receiptMoneyUser = null;
		Integer receiptMoneyDept = null;
		String fianacPayment = null;
		String billNo = null;
		BigDecimal payMoney = null;
		Integer fianacId = null;
		Integer earbestId = null;
		Byte billWay = null;
		Integer billCodeId = null;
		Integer depositId = null;
		Date receiptTime = null;
		if (financPo!=null) {
			billCodeId = financPo.getBillCodeId();
			receiptMoneyUser = financPo.getReceiptMoneyUser();
			receiptMoneyDept = financPo.getReceiptMoneyDept();
			billNo = financPo.getBillCodeNo();
			fianacPayment = financPo.getPfName();
			payMoney = financPo.getPayAmount();
			billWay = financPo.getBillWay();
			receiptTime = financPo.getPfTime();
			fianacId = financPo.getPfId();
		} else if ( earbestMoney!=null ) {
			billCodeId = earbestMoney.getBillCodeId();
			receiptMoneyUser = earbestMoney.getReceiptUserId();
			receiptMoneyDept = earbestMoney.getReceiptDeptId();
			billNo = earbestMoney.getReceiptNo();
			payMoney = new BigDecimal(earbestMoney.getReceiptMoney());
			billWay = earbestMoney.getBillWay();
			billPO.setPayCustomer(earbestMoney.getCustName());
			receiptTime = earbestMoney.getReceiptTime();
			earbestId = earbestMoney.getEarbestId();
		} else if (deposit!=null) {
			billCodeId = deposit.getBillCodeId();
			receiptMoneyUser = deposit.getReceiptUserId();
			receiptMoneyDept = deposit.getReceiptDeptId();
			billNo = deposit.getBillCodeNo();
			if(null != deposit.getReceiptMoney()) {
				payMoney = deposit.getReceiptMoney();
			}
			billWay = deposit.getBillWay();
			billPO.setPayCustomer(deposit.getCustName());
			receiptTime = deposit.getReceiptTime();
			depositId = deposit.getId();
		}
		if (dealType!=null) {
			billType = Const.DIC_CASE_TYPE_SALE_DEAL == dealType.intValue() ?1:2;
		}
		//判重

		int	result = erpFunBillCodelogService.judgeBillCodeNoRepeat(cityId,compId, billCodeId,  billNo, billType.byteValue());

		if (result>0) {
			throw new BusinessException("该票据号已被使用！");
		}
		//只有写两套，原因是不在一个事务里面，判不了重
		billPO.setReceiptMoneyUser(receiptMoneyUser);
		billPO.setReceiptMoneyDept(receiptMoneyDept);
		billPO.setBillType(billType.byteValue());
		billPO.setCompId(compId);
		billPO.setAreaId(areaId);
		billPO.setRegId(regId);
		billPO.setDeptId(deptId);
		billPO.setGrId(grId);
		billPO.setUserId(userId);
		billPO.setCreationTime(new Date());
		billPO.setReceiptTime(receiptTime);
		billPO.setBillNo(billNo);
		billPO.setFianacPayment(fianacPayment);
		billPO.setContractNo(contractNo );
		billPO.setDealId(dealId);
		billPO.setPayMoney(payMoney);
		billPO.setIntelligentSearch(billPO.getBillNo()+","+(StringUtils.isBlank(billPO.getPayCustomer())?"":billPO.getPayCustomer())+","+(StringUtils.isBlank(contractNo)?"":contractNo));
		billPO.setFianacId(fianacId);
		billPO.setEarbestId(earbestId);
		billPO.setDepositId(depositId);
		billPO.setBillStatus((byte)0);
		billPO.setBillWay(billWay);
		if(isPrint){
			billPO.setBillPrintWay(billPrintWay);
		}
	}

	private void createBillRecordNew(GeneralParam generalParam, ErpFunBill billPO, Integer dealId, String contractNo, Byte dealType, Byte billPrintWay, boolean isPrint, ErpProcessFinanc financPo, ErpFunEarbestMoney earbestMoney, ErpFunDeposit deposit) {
		Integer compId = generalParam.getCompId();
		Integer cityId=generalParam.getCityId();
		Integer areaId = generalParam.getAreaId();
		Integer regId = generalParam.getRegId();
		Integer deptId = generalParam.getDeptId();
		Integer grId = generalParam.getGrId();
		Integer userId = generalParam.getArchiveId();
		Integer billType = 0;
		Integer receiptMoneyUser = null;
		Integer receiptMoneyDept = null;
		String fianacPayment = null;
		String billNo = null;
		BigDecimal payMoney = null;
		Integer fianacId = null;
		Integer earbestId = null;
		Byte billWay = null;
		Integer billCodeId = null;
		Integer depositId = null;
		Date receiptTime = null;
		if (financPo!=null) {
			billCodeId = financPo.getBillCodeId();
			receiptMoneyUser = financPo.getReceiptMoneyUser();
			receiptMoneyDept = financPo.getReceiptMoneyDept();
			billNo = financPo.getBillCodeNo();
			fianacPayment = financPo.getPfName();
			payMoney = financPo.getPayAmount();
			billWay = financPo.getBillWay();
			receiptTime = financPo.getPfTime();
			fianacId = financPo.getPfId();
		} else if ( earbestMoney!=null ) {
			billCodeId = earbestMoney.getBillCodeId();
			receiptMoneyUser = earbestMoney.getReceiptUserId();
			receiptMoneyDept = earbestMoney.getReceiptDeptId();
			billNo = earbestMoney.getReceiptNo();
			payMoney = new BigDecimal(earbestMoney.getReceiptMoney());
			billWay = earbestMoney.getBillWay();
			billPO.setPayCustomer(earbestMoney.getCustName());
			receiptTime = earbestMoney.getReceiptTime();
			earbestId = earbestMoney.getEarbestId();
		} else if (deposit!=null) {
			billCodeId = deposit.getBillCodeId();
			receiptMoneyUser = deposit.getReceiptUserId();
			receiptMoneyDept = deposit.getReceiptDeptId();
			billNo = deposit.getBillCodeNo();
			if(null != deposit.getReceiptMoney()) {
				payMoney = deposit.getReceiptMoney();
			}
			billWay = deposit.getBillWay();
			billPO.setPayCustomer(deposit.getCustName());
			receiptTime = deposit.getReceiptTime();
			depositId = deposit.getId();
		}
		if (dealType!=null) {
			billType = Const.DIC_CASE_TYPE_SALE_DEAL == dealType.intValue() ?1:2;
		}
		//判重

		int	result = erpFunBillCodelogService.judgeBillCodeNoRepeatByDeal(cityId,compId, billCodeId,  billNo, billType.byteValue(),dealId);

		if (result>0) {
			throw new BusinessException("该票据号已被使用！");
		}
		//只有写两套，原因是不在一个事务里面，判不了重
		billPO.setReceiptMoneyUser(receiptMoneyUser);
		billPO.setReceiptMoneyDept(receiptMoneyDept);
		billPO.setBillType(billType.byteValue());
		billPO.setCompId(compId);
		billPO.setAreaId(areaId);
		billPO.setRegId(regId);
		billPO.setDeptId(deptId);
		billPO.setGrId(grId);
		billPO.setUserId(userId);
		billPO.setCreationTime(new Date());
		billPO.setReceiptTime(receiptTime);
		billPO.setBillNo(billNo);
		billPO.setFianacPayment(fianacPayment);
		billPO.setContractNo(contractNo );
		billPO.setDealId(dealId);
		billPO.setPayMoney(payMoney);
		billPO.setIntelligentSearch(billPO.getBillNo()+","+(StringUtils.isBlank(billPO.getPayCustomer())?"":billPO.getPayCustomer())+","+(StringUtils.isBlank(contractNo)?"":contractNo));
		billPO.setFianacId(fianacId);
		billPO.setEarbestId(earbestId);
		billPO.setDepositId(depositId);
		billPO.setBillStatus((byte)0);
		billPO.setBillWay(billWay);
		if(isPrint){
			billPO.setBillPrintWay(billPrintWay);
		}
	}

}
