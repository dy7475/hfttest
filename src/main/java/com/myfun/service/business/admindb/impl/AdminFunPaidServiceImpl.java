package com.myfun.service.business.admindb.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.usercenter.param.CashRecordParam;
import com.myfun.erpWeb.usercenter.param.GetPaidListParam;
import com.myfun.erpWeb.usercenter.vo.AdminFunPaidVo;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.dto.AdminFunPaidDto;
import com.myfun.repository.admindb.param.AdminPaidCountParam;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunPaidService;
import com.myfun.utils.DateConvert;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 消费查询
 * @author lcb
 *
 */
@Service
public class AdminFunPaidServiceImpl extends AbstractService<AdminFunPaid, AdminFunPaidKey> implements AdminFunPaidService {
	@Autowired
	private AdminFunPaidMapper adminFunPaidMapper;
	@Autowired
	private AdminDicDefinitionsMapper adminDicDefinitionsMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminFunPaidMapper;
	}

	@Override
	public List<AdminFunPaidDto> selectByTypeAndOther(AdminPaidCountParam adminPaidCountParam, String paidSource) {
		PageHelper.startPage(adminPaidCountParam.getPageNum(), adminPaidCountParam.getPageSize(), true);
		List<AdminFunPaidDto> list = adminFunPaidMapper.selectByTypeAndOther(adminPaidCountParam.getFaaType(), paidSource, adminPaidCountParam);
		return list;
	}

	@Override
	public List<AdminFunPaid> getFunPaidByArchiveId(Integer archiveId) {
		
		return adminFunPaidMapper.getFunPaidByArchiveId(archiveId);
	}

	@Override
	public PageInfo<AdminFunPaidVo> getPaidList(GetPaidListParam param) {
		if(StringUtil.isNotBlank(param.getDateRange())){
			String[] val = param.getDateRange().split("~");
			if (val.length == 2 && StringUtil.isNotBlank(val[0]) && StringUtil.isNotBlank(val[1])) {
				param.setPaidTimeGreater(val[0]);
				param.setPaidTimeLess(val[1] + " 23:59:59");
			}
		} else if(StringUtil.isNotBlank(param.getDate())) {
			String[] conStr = DateConvert.getConditionDate(param.getDate());
			param.setPaidTimeGreater(conStr[0]);
			param.setPaidTimeLess(conStr[1]);
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidVo> adminFunPaidList = adminFunPaidMapper.getPaidList(param);
		Map<String, AdminDicDefinitions> dicDefinitionsMap = adminDicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
		if(!adminFunPaidList.isEmpty()){
			for(AdminFunPaidVo adminFunPaid : adminFunPaidList){
				AdminDicDefinitions adminDicDefinitions = dicDefinitionsMap.get(adminFunPaid.getPaidType());
				if(null != adminDicDefinitions){
					adminFunPaid.setPaidTypeMsg(adminDicDefinitions.getDicCnMsg());
				}
				//交易账户 1=个人 2=公司
				if(((null != param.getSelfUaId()) && param.getSelfUaId().equals(adminFunPaid.getUaId())) || param.getSelfArchiveId().equals(adminFunPaid.getArchiveId())){
					adminFunPaid.setAccountType(1);
				}else{
					adminFunPaid.setAccountType(2);
				}
			}
		}
		return new PageInfo<AdminFunPaidVo>(adminFunPaidList);
	}

	@Override
	public PageInfo<AdminFunPaidVo> getCashRecordList(CashRecordParam param) {
		String dateType = param.getDateType(); // 时间类型
		Integer uaType = param.getUaType(); // 账户类型 1 = 个人 2 = 公司
		if(StringUtil.isNotBlank(dateType)){
			String[] dateArr = DateConvert.getConditionDate(dateType);
			param.setStartTime(dateArr[0]);
			param.setEndTime(dateArr[1]);
		}
		if ((1 == uaType && null == param.getSelfUaId())
				|| (2 == uaType && null == param.getSelfCompUaId())) {
			return null;
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidVo> adminFunPaidList = adminFunPaidMapper.getCashRecordList(param);
		Map<String, AdminDicDefinitions> dicDefinitionsMap = adminDicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
		if(null != adminFunPaidList && !adminFunPaidList.isEmpty()){
			for(AdminFunPaidVo adminFunPaid : adminFunPaidList){
				String paidCatigory = adminFunPaid.getPaidCatigory();
				AdminDicDefinitions adminDicDefinitions = dicDefinitionsMap.get(adminFunPaid.getPaidType());
				if(null != adminDicDefinitions){
					adminFunPaid.setPaidTypeMsg(adminDicDefinitions.getDicCnMsg());
				}
				//交易账户 1=个人 2=公司
				if(((null != param.getSelfUaId()) && param.getSelfUaId().equals(adminFunPaid.getUaId())) || param.getSelfArchiveId().equals(adminFunPaid.getArchiveId())){
					adminFunPaid.setAccountType(1);
				}else{
					adminFunPaid.setAccountType(2);
				}
				if("INCOME".equals(paidCatigory) || "GIFT".equals(paidCatigory) || "CRMVIRE".equals(paidCatigory)){
					adminFunPaid.setIncomeType(1);
				} else if("PAY".equals(paidCatigory)){
					adminFunPaid.setIncomeType(2);
				} else {
					adminFunPaid.setIncomeType(0);
				}
			}
		}
		return new PageInfo<AdminFunPaidVo>(adminFunPaidList);
	}

	@Override
	public PageInfo<AdminFunPaidVo> getHfCoinRecordList(CashRecordParam param) {
		String dateType = param.getDateType(); // 时间类型
		Integer uaType = param.getUaType(); // 账户类型 1 = 个人 2 = 公司
		if(StringUtil.isNotBlank(dateType)){
			String[] dateArr = DateConvert.getConditionDate(dateType);
			param.setStartTime(dateArr[0]);
			param.setEndTime(dateArr[1]);
		}
		if ((1 == uaType && null == param.getSelfUaId())
				|| (2 == uaType && null == param.getSelfCompUaId())) {
			return null;
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidVo> adminFunPaidList = adminFunPaidMapper.getHfCoinRecordList(param);
		Map<String, AdminDicDefinitions> dicDefinitionsMap = adminDicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
		List<AdminFunPaidVo> finalList = new ArrayList<>();
		if(null != adminFunPaidList && !adminFunPaidList.isEmpty()){
			for(AdminFunPaidVo adminFunPaid : adminFunPaidList){
				String paidCatigory = adminFunPaid.getPaidCatigory();
				if (StringUtils.isNotBlank(adminFunPaid.getDesc()) && adminFunPaid.getDesc().contains("现金")) {
					continue;
				}
				AdminDicDefinitions adminDicDefinitions = dicDefinitionsMap.get(adminFunPaid.getPaidType());
				if(null != adminDicDefinitions){
					adminFunPaid.setPaidTypeMsg(adminDicDefinitions.getDicCnMsg());
				}
				if("INCOME".equals(paidCatigory) || "GIFT".equals(paidCatigory) || "CRMVIRE".equals(paidCatigory)){
					adminFunPaid.setIncomeType(1);
				} else if("PAY".equals(paidCatigory)){
					adminFunPaid.setIncomeType(2);
				} else {
					adminFunPaid.setIncomeType(0);
				}
				if("GIFT".equals(paidCatigory)){
					adminFunPaid.setPerAmountPrice(adminFunPaid.getAmount());
				}
				finalList.add(adminFunPaid);
			}
		}
		return new PageInfo<AdminFunPaidVo>(finalList);
	}

	@Override
	public PageInfo<AdminFunPaidVo> getTrueHouseLightRecordList(CashRecordParam param) {
		String dateType = param.getDateType(); // 时间类型
		Integer uaType = param.getUaType(); // 账户类型 1 = 个人 2 = 公司
		if(StringUtil.isNotBlank(dateType)){
			String[] dateArr = DateConvert.getConditionDate(dateType);
			param.setStartTime(dateArr[0]);
			param.setEndTime(dateArr[1]);
		}
		if ((1 == uaType && null == param.getSelfUaId())
				|| (2 == uaType && null == param.getSelfCompUaId())) {
			return null;
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidVo> adminFunPaidList = adminFunPaidMapper.getTrueHouseLightRecordList(param);
		Map<String, AdminDicDefinitions> dicDefinitionsMap = adminDicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
		if(null != adminFunPaidList && !adminFunPaidList.isEmpty()){
			for(AdminFunPaidVo adminFunPaid : adminFunPaidList){
				String paidCatigory = adminFunPaid.getPaidCatigory();
				AdminDicDefinitions adminDicDefinitions = dicDefinitionsMap.get(adminFunPaid.getPaidType());
				if(null != adminDicDefinitions){
					adminFunPaid.setPaidTypeMsg(adminDicDefinitions.getDicCnMsg());
				}
				if("INCOME".equals(paidCatigory) || "GIFT".equals(paidCatigory) || "CRMVIRE".equals(paidCatigory)){
					adminFunPaid.setIncomeType(1);
				} else if("PAY".equals(paidCatigory)){
					adminFunPaid.setIncomeType(2);
				} else {
					adminFunPaid.setIncomeType(0);
				}
			}
		}
		return new PageInfo<AdminFunPaidVo>(adminFunPaidList);
	}

	@Override
	public PageInfo<AdminFunPaidVo> getBrokerInvitePrizeRecordList(CashRecordParam param) {
		String dateType = param.getDateType(); // 时间类型
		Integer uaType = param.getUaType(); // 账户类型 1 = 个人 2 = 公司
		if(StringUtil.isNotBlank(dateType)){
			String[] dateArr = DateConvert.getConditionDate(dateType);
			param.setStartTime(dateArr[0]);
			param.setEndTime(dateArr[1]);
		}
		if ((1 == uaType && null == param.getSelfUaId())
				|| (2 == uaType && null == param.getSelfCompUaId())) {
			return null;
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidVo> adminFunPaidList = adminFunPaidMapper.getBrokerInvitePrizeRecordList(param);
		Map<String, AdminDicDefinitions> dicDefinitionsMap = adminDicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
		if(null != adminFunPaidList && !adminFunPaidList.isEmpty()){
			for(AdminFunPaidVo adminFunPaid : adminFunPaidList){
				String paidCatigory = adminFunPaid.getPaidCatigory();
				AdminDicDefinitions adminDicDefinitions = dicDefinitionsMap.get(adminFunPaid.getPaidType());
				if(null != adminDicDefinitions){
					adminFunPaid.setPaidTypeMsg(adminDicDefinitions.getDicCnMsg());
				}
				if("INCOME".equals(paidCatigory) || "GIFT".equals(paidCatigory) || "CRMVIRE".equals(paidCatigory)){
					adminFunPaid.setIncomeType(1);
				} else if("PAY".equals(paidCatigory)){
					adminFunPaid.setIncomeType(2);
				} else {
					adminFunPaid.setIncomeType(0);
				}
			}
		}
		return new PageInfo<AdminFunPaidVo>(adminFunPaidList);
	}

	@Override
	public PageInfo<AdminFunPaidVo> getO2ORecordList(CashRecordParam param) {
		String dateType = param.getDateType(); // 时间类型
		if(StringUtil.isNotBlank(dateType)){
			String[] dateArr = DateConvert.getConditionDate(dateType);
			param.setStartTime(dateArr[0]);
			param.setEndTime(dateArr[1]);
		}
		if (null == param.getSelfCompUaId()) {
			return null;
		}
		if(0 == param.getIsGeneralManager()){
			AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(param.getSelfCompNo(), param.getSelfDeptNo());
			param.setSelfAdminDeptId(adminFunDepts.getDeptId());
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidVo> adminFunPaidList = adminFunPaidMapper.getO2ORecordList(param);
		Map<String, AdminDicDefinitions> dicDefinitionsMap = adminDicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
		if(null != adminFunPaidList && !adminFunPaidList.isEmpty()){
			for(AdminFunPaidVo adminFunPaid : adminFunPaidList){
				String paidCatigory = adminFunPaid.getPaidCatigory();
				AdminDicDefinitions adminDicDefinitions = dicDefinitionsMap.get(adminFunPaid.getPaidType());
				if(null != adminDicDefinitions){
					adminFunPaid.setPaidTypeMsg(adminDicDefinitions.getDicCnMsg());
				}
				if("INCOME".equals(paidCatigory) || "GIFT".equals(paidCatigory) || "CRMVIRE".equals(paidCatigory)){
					adminFunPaid.setIncomeType(1);
				} else if("PAY".equals(paidCatigory)){
					adminFunPaid.setIncomeType(2);
				} else {
					adminFunPaid.setIncomeType(0);
				}
			}
		}
		return new PageInfo<AdminFunPaidVo>(adminFunPaidList);
	}

	@Override
	public PageInfo<AdminFunPaidVo> getSRVRecordList(CashRecordParam param) {
		String dateType = param.getDateType(); // 时间类型
		if(StringUtil.isNotBlank(dateType)){
			String[] dateArr = DateConvert.getConditionDate(dateType);
			param.setStartTime(dateArr[0]);
			param.setEndTime(dateArr[1]);
		}
		if (null == param.getSelfUaId()) {
			return null;
		}
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(param.getSelfArchiveId());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidVo> SRVRecordList = adminFunPaidMapper.getSRVRecordList(param);
		Map<String, AdminDicDefinitions> dicDefinitionsMap = adminDicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
		if(null != SRVRecordList && !SRVRecordList.isEmpty()){
			for(AdminFunPaidVo adminFunPaid : SRVRecordList){
				adminFunPaid.setIsFreeUser(adminFunArchive.getIsFreeUser());
				String paidCatigory = adminFunPaid.getPaidCatigory();
				AdminDicDefinitions adminDicDefinitions = dicDefinitionsMap.get(adminFunPaid.getPaidType());
				if(null != adminDicDefinitions){
					adminFunPaid.setPaidTypeMsg(adminDicDefinitions.getDicCnMsg());
				}
				if("INCOME".equals(paidCatigory) || "GIFT".equals(paidCatigory) || "CRMVIRE".equals(paidCatigory)){
					adminFunPaid.setIncomeType(1);
				} else if("PAY".equals(paidCatigory)){
					adminFunPaid.setIncomeType(2);
				} else {
					adminFunPaid.setIncomeType(0);
				}
			}
		} else {
			SRVRecordList = new ArrayList<>();
			AdminFunPaidVo adminFunPaidVo = new AdminFunPaidVo();
			adminFunPaidVo.setIsFreeUser(adminFunArchive.getIsFreeUser());
			SRVRecordList.add(adminFunPaidVo);
		}
		return new PageInfo<AdminFunPaidVo>(SRVRecordList);
	}
	@Override
	public void peopleSaleGiftUserRight(Integer archiveId) {
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.createCriteria().andArchiveIdEqualTo(archiveId).andUserWriteoffEqualTo(false);
		erpFunUsersExample.setShardArchiveId(archiveId);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		ErpFunUsers erpFunUsers = userList.get(0);
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setDeptId(erpFunUsers.getDeptId());
		erpFunDepts.setShardCityId(erpFunUsers.getCityId().intValue());
		erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(erpFunDepts);
		String compNo = erpFunDepts.getCompNo();
		String deptNo = erpFunDepts.getDeptNo();
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		Byte compType = adminFunComp.getCompType();
		// 如果是不是营销版就返回
		if (compType != Const.DIC_COMP_TYPE_4.intValue()) {
			return;
		}
		// 判断赠送了没有
		String paidType = "BROKER_SALES_RIGHT";
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
		Integer pushArchiveId = adminFunDepts.getCreatePusherId();
		if (pushArchiveId == null) {
			return;
		}
		AdminFunPaidExample adminFunPaidExample = new AdminFunPaidExample();
		adminFunPaidExample.createCriteria().andPaidTypeEqualTo(paidType).andDealIdEqualTo(adminFunDepts.getDeptId());
		int count = adminFunPaidMapper.countByExample(adminFunPaidExample);
		if (count > 0) {
			return;
		}
		// 实名达到多少人送奖励金
		Integer rightCount = 3;
		// 赠送奖励金
		Integer giftMoney = Integer.parseInt(adminSysParaMapper.getAdminSysParas("USER_RIGHT_SALES_MONEY"));
		List<Integer> archiveList = new ArrayList<>();
		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.createCriteria().andDeptIdEqualTo(erpFunUsers.getDeptId()).andUserWriteoffEqualTo(false);
		usersExample.setShardCityId(erpFunUsers.getCityId().intValue());
		List<ErpFunUsers> erpUserList = erpFunUsersMapper.selectByExample(usersExample);
		for (ErpFunUsers funUsers : erpUserList) {
			archiveList.add(funUsers.getArchiveId());
		}
		List<Integer> isRightArchiveList = new ArrayList<>();// 已实名的人
		AdminFunArchiveExample adminFunArchiveExample = new AdminFunArchiveExample();
		adminFunArchiveExample.createCriteria().andArchiveIdIn(archiveList);
		List<AdminFunArchive> list = adminFunArchiveMapper.selectByExample(adminFunArchiveExample);
		for (int i = 0; i < list.size(); i++) {
			AdminFunArchive adminFunArchive = list.get(i);
			if (adminFunArchive.getUserRight() == 1) {
				isRightArchiveList.add(adminFunArchive.getArchiveId());
			}
		}
		// 总人数大于3人
		if (isRightArchiveList.size() >= rightCount) {
			AdminFunUserAccount pushFunUserAccount = adminFunUserAccountMapper.getAccountByArchiveId(pushArchiveId);
			if (pushFunUserAccount == null) {
				return;
			}
			// 写消费记录
			AdminFunPaid adminFunPaid = new AdminFunPaid();
			adminFunPaid.setAmount(giftMoney.doubleValue());
			adminFunPaid.setAmountAfter(pushFunUserAccount.getSalesMoney().doubleValue() + giftMoney.doubleValue());
			adminFunPaid.setAmountBefore(pushFunUserAccount.getSalesMoney().doubleValue());
			adminFunPaid.setArchiveId(pushArchiveId);
			adminFunPaid.setCityId(pushFunUserAccount.getCityId());
			adminFunPaid.setDealId(adminFunDepts.getDeptId());
			adminFunPaid.setPadiTime(new Date());
			adminFunPaid.setPaidCatigory("ERPVIRE");
			adminFunPaid.setPaidType(paidType);
			adminFunPaid.setStatus(0);
			adminFunPaid.setUaId(pushFunUserAccount.getUaId());
			adminFunPaid.setDesc(adminFunDepts.getDeptCname() + rightCount + "人通过实名认证，您获得" + giftMoney + "元奖励");
			adminFunPaid.setDeptId(adminFunDepts.getDeptId());
			adminFunPaidMapper.insertSelective(adminFunPaid);
		}
	}

}
