package com.myfun.service.business.erpdb.impl;

import com.github.pagehelper.PageHelper;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.param.ErpFunWageParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.reportdb.dto.ReportFunStatisticTotleDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunRoleWageConfigService;
import com.myfun.service.business.erpdb.ErpFunWageService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpFunWageServiceImpl extends AbstractService<ErpFunWage, ErpFunWage> implements ErpFunWageService {
	@Autowired private ErpFunWageMapper erpFunWageMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunMsgMapper erpFunMsgMapper;
	@Autowired private ErpFunProfitDetailMapper erpFunProfitDetailMapper;
	@Autowired private ErpFunProfitTargetMapper erpFunProfitTargetMapper;
	@Autowired private ErpFunProfitMapper erpFunProfitMapper;
	@Autowired private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired private ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	@Autowired private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired private ErpFunWageLogMapper erpFunWageLogMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Autowired private ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Autowired private ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired private ErpFunRoleWageConfigService erpFunRoleWageConfigService;
	@Autowired private ErpFunRewardPunishmentMapper erpFunRewardPunishmentMapper;
	@Autowired private ErpFunGenerationPaymentMapper erpFunGenerationPaymentMapper;
	@Autowired private ErpFunProfitShareDetailMapper erpFunProfitShareDetailMapper;
	@Autowired private ErpSysParaService erpSysParaService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunWageMapper;
	}

	@Transactional
	@Override
	public List<AuditWageVO> auditFunWage(Integer cityId, Integer compId, Integer userId, String userName, String wageIds ) {
		List<AuditWageVO> resList = new ArrayList<>();

		// 先查询出list wage
		List<Integer> wageIdList = StringUtil.toIntList(wageIds);
		if(wageIdList.size() == 0) {
			return resList;
		}
		ErpFunWageExample wageExample = new ErpFunWageExample();
		wageExample.setShardCityId(cityId);
		wageExample.createCriteria().andCompIdEqualTo(compId).andWageIdIn(wageIdList);
		List<ErpFunWage> erpFunWages = erpFunWageMapper.selectByExample(wageExample);
		// 把人筛选出来
		Set<Integer> userIdSet = erpFunWages.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
		if(userIdSet.size() == 0) {
			return resList;
		}

		// 先审核薪资数据
		ErpFunWage erpFunWage= new ErpFunWage();
		erpFunWage.setCheckStatus((byte)1);
		erpFunWage.setCheckTime(new Date());
		erpFunWage.setCheckUser(userId);
		erpFunWageMapper.updateByExampleSelective(erpFunWage, wageExample);
		// 这里审核都是同样的月份  所以在list找一个就好了
		// 处理流水数据
		String settlementType = erpSysParaMapper.getParamValue(cityId, compId, "PAYROLL_SETTLEMENT_TYPE");


		// 发送小秘书
		List<ErpFunUsers> userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
		Map<Integer, Integer> userIdArchiveIdMap = userListByUserIds.stream().collect(Collectors.toMap(val -> val.getUserId(), val -> val.getArchiveId()));


		for (ErpFunWage funWage : erpFunWages) {
			Set<Integer> signUserIdSet = new HashSet<>();
			signUserIdSet.add(funWage.getUserId());
			Set<String> assessMonthSet = new HashSet<>();
			assessMonthSet.add(funWage.getAssessmentMonth());
			// 统计加上奖罚数据
			List<FunWageTmpDataDto> rewardPuinshmentList = erpFunRewardPunishmentMapper.getAllUserRewardPuishmentData(cityId, compId, signUserIdSet, assessMonthSet);
			Map<Integer, FunWageTmpDataDto> userRewardPunishmentMap  = new HashMap<>();
			if(rewardPuinshmentList.size() > 0) {
				userRewardPunishmentMap = rewardPuinshmentList.stream().collect(Collectors.toMap(FunWageTmpDataDto::getUserId, val -> val));
			}

			// 统计加上代扣代缴的数据
			List<FunWageTmpDataDto> generationList = erpFunGenerationPaymentMapper.getAllUserGenerationData(cityId, compId, signUserIdSet, assessMonthSet);
			Map<Integer, FunWageTmpDataDto> userGenerationMap = new HashMap<>();
			if(generationList.size() > 0) {
				userGenerationMap = generationList.stream().collect(Collectors.toMap(FunWageTmpDataDto::getUserId, val -> val));
			}

			createFunMsg(cityId, compId, funWage.getWageId(), funWage.getUserId(), funWage.getAssessmentMonth());
			// 组装外面需要的数据
			AuditWageVO auditWageVO = new AuditWageVO();

			Integer archiveId = userIdArchiveIdMap.get(funWage.getUserId());
			if(null != archiveId) {
				auditWageVO.setArchiveId(archiveId);
				auditWageVO.setMonth(funWage.getAssessmentMonth());
				auditWageVO.setUserId(funWage.getUserId());
				resList.add(auditWageVO);
			}

			// 写审核日志
			BigDecimal otherAnount = BigDecimal.ZERO;
			FunWageTmpDataDto rewardPunishment = userRewardPunishmentMap.get(funWage.getUserId());
			FunWageTmpDataDto userGeneration = userGenerationMap.get(funWage.getUserId());
			if(null != rewardPunishment && null != rewardPunishment.getAmount1()) {
				otherAnount = otherAnount.add(rewardPunishment.getAmount1());
			}

			if(null != rewardPunishment && null != rewardPunishment.getAmount2()) {
				otherAnount = otherAnount.subtract(rewardPunishment.getAmount2());
			}

			if(null != userGeneration && null != userGeneration.getAmount1()) {
				otherAnount = otherAnount.subtract(userGeneration.getAmount1());
			}

			writeFunWageLog(cityId, compId, userId, userName, otherAnount, funWage);

			ErpFunProfitDetailExample erpFunProfitDetailExample = new ErpFunProfitDetailExample();
			erpFunProfitDetailExample.setShardCityId(cityId);
			ErpFunProfitDetailExample.Criteria criteria = erpFunProfitDetailExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(new ArrayList<>(signUserIdSet)).andGrantFlagEqualTo((byte) 0);
			if (Const.realSettlementTypeList.contains(settlementType)) {
				criteria.andIncomeMonthEqualTo(funWage.getAssessmentMonth());
			} else if (Const.settlementTypeList.contains(settlementType)) {
				criteria.andSettlementMonthEqualTo(funWage.getAssessmentMonth());
			}
			ErpFunProfitDetail erpFunProfitDetail = new ErpFunProfitDetail();
			erpFunProfitDetail.setGrantFlag((byte)1);
			erpFunProfitDetailMapper.updateByExampleSelective(erpFunProfitDetail, erpFunProfitDetailExample);
			//因为只有房基地模式下，才会生成这条表的记录，所以房基地的分成更新， 
			erpFunProfitShareDetailMapper.auditFunWage(cityId,compId,signUserIdSet,funWage.getAssessmentMonth());
		}

		return resList;
	}

	private void writeFunWageLog(Integer cityId, Integer compId, Integer userId, String userName, BigDecimal otherAnount, ErpFunWage erpFunWage) {
		ErpFunWageLog erpFunWageLog = new ErpFunWageLog();

		// 计算金额
		erpFunWageLog.setLogType(5);
		erpFunWageLog.setCompId(compId);
		erpFunWageLog.setShardCityId(cityId);
		erpFunWageLog.setWageId(erpFunWage.getWageId());
		erpFunWageLog.setWageUserId(erpFunWage.getUserId());
		erpFunWageLog.setUserId(userId);
		erpFunWageLog.setUpdateTime(new Date());
		erpFunWageLog.setIsDel((byte) 0);
		erpFunWageLog.setUserName(userName);

		BigDecimal needGiveAmount = otherAnount;
		if(null != erpFunWage.getRealWageCk() && erpFunWage.getRealWageCk().doubleValue() > 0) {
			needGiveAmount = needGiveAmount.add(erpFunWage.getRealWageCk());
		}else {
			// 加薪资
			BigDecimal baseWageMoney = null != erpFunWage.getWageMoney() ? erpFunWage.getWageMoney() : BigDecimal.ZERO;
			BigDecimal personWorkCountAmount = null != erpFunWage.getPersonWorkcountAmount() ? erpFunWage.getPersonWorkcountAmount() : BigDecimal.ZERO;
			BigDecimal manageWorkCountAmount = null != erpFunWage.getManageWorkcountAmount() ? erpFunWage.getManageWorkcountAmount() : BigDecimal.ZERO;
			BigDecimal personProfitAmount = null != erpFunWage.getPersonProfitWage() ? erpFunWage.getPersonProfitWage() : BigDecimal.ZERO;
			BigDecimal manageProfitAmount = null != erpFunWage.getManageProfitWage() ? erpFunWage.getManageProfitWage() : BigDecimal.ZERO;
			BigDecimal personCommsionAmount = null != erpFunWage.getPersonCommsionAmount() ? erpFunWage.getPersonCommsionAmount() : BigDecimal.ZERO;
			BigDecimal manageCommsionAmount = null != erpFunWage.getManageCommsionAmount() ? erpFunWage.getManageCommsionAmount() : BigDecimal.ZERO;

			needGiveAmount = needGiveAmount.add(baseWageMoney).add(personWorkCountAmount).add(manageWorkCountAmount).add(personProfitAmount).add(manageProfitAmount)
					.add(personCommsionAmount).add(manageCommsionAmount);
		}
		if(needGiveAmount.doubleValue() >0) {
			erpFunWageLog.setAddWage(needGiveAmount);
		}else {
			erpFunWageLog.setReduceWage(BigDecimal.ZERO.subtract(needGiveAmount));
		}
		String content = "应发工资合计 "+ needGiveAmount +"元";
		erpFunWageLog.setExplain(content);

		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, erpFunWage.getUserId());
		if(null != erpFunUsers) {
			erpFunWageLog.setAreaId(erpFunUsers.getAreaId());
			erpFunWageLog.setRegId(erpFunUsers.getRegId());
			erpFunWageLog.setDeptId(erpFunUsers.getDeptId());
			erpFunWageLog.setGrId(erpFunUsers.getGrId());
			erpFunWageLog.setOrganizationPath(erpFunUsers.getTissueLine());
		}
		erpFunWageLogMapper.insertSelective(erpFunWageLog);
	}

	private void createFunMsg(Integer cityId, Integer compId, Integer wageId, Integer userId, String assessmentMonth) {
		ErpFunUsers funUsersBaseInfo = erpFunUsersMapper.getFunUsersBaseInfo(userId, cityId);
		ErpFunMsg erpFunMsg = new ErpFunMsg();
		erpFunMsg.setShardCityId(cityId);
		erpFunMsg.setCaseId(wageId);
		erpFunMsg.setCompId(compId);
		erpFunMsg.setSendUser(Constants_DIC.DIC_SYSTEM_USERID_999_INT);
		erpFunMsg.setMsgContent("您"+assessmentMonth+"的月工资单已发放，请查收");
		erpFunMsg.setReadFlag(false);
		erpFunMsg.setSendTime(new Date());
		erpFunMsg.setReceiveDept(funUsersBaseInfo.getDeptId());
		erpFunMsg.setMsgType(Constants_DIC.FunMsgType.MSG_TYPE_6);
		erpFunMsg.setReceiveUser(userId);
		erpFunMsgMapper.insertSelective(erpFunMsg);

		List<AdminFunUserMessage> userMessageList= new ArrayList<>();
		AdminFunUserMessage userMessage = new AdminFunUserMessage();
		userMessage.setMsgModule(Constants_DIC.MsgModule.FUN_WAGE_PUSH);
		userMessage.setModuleType(Constants_DIC.MsgModuleType.FUN_WAGE_BILL);
		userMessage.setCityId(cityId);
		userMessage.setTargetId(erpFunMsg.getMsgId());
		userMessage.setAppType(1);
		userMessage.setArchiveId(funUsersBaseInfo.getArchiveId());
		userMessage.setCompId(funUsersBaseInfo.getCompId());
		userMessageList.add(userMessage);
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				TaskQueueThread.sendMessageList(userMessageList);
			}
		});

	}
	/**
	 * @Title 1.修改薪资应发工资与备注说明
	 * 2.增加薪资日志记录
	 * @Author lcb
	 * @Date 2018/1/30
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer updateFunWageRealWage(Integer cityId, Integer userId, String userName, ErpFunWageParam param) {
		Integer resCode = 0;

		ErpFunWage erpFunWage = new ErpFunWage();
		erpFunWage.setWageId(param.getWageId());
		erpFunWage.setShardCityId(cityId);
		erpFunWage = erpFunWageMapper.selectByPrimaryKey(erpFunWage);
		// 应发参考值，如果修改了就以这个为准，否则就是各项相加
		erpFunWage.setRealWageCk(param.getRealWage());

        BigDecimal delWage = param.getDelWage();
        BigDecimal addWage = param.getOtherWage();
        String explain = param.getExplain();

        //第一次保存，如果三个字段都为空，不给保存
        if (null == delWage && null == addWage && StringUtil.isBlank(explain)) {
            return -1;
        } else {			
			ErpFunWageLogExample logExample = new ErpFunWageLogExample();
			logExample.setShardCityId(cityId);
			logExample.createCriteria().andWageIdEqualTo(param.getWageId()).andLogTypeEqualTo(1);
        	List<ErpFunWageLog> oldLogList = erpFunWageLogMapper.selectByExample(logExample);

			//新增薪资调整操作日志记录
			ErpFunWageLog funWageLog = new ErpFunWageLog();
			funWageLog.setCompId(erpFunWage.getCompId());
			funWageLog.setShardCityId(cityId);
			funWageLog.setExplain(param.getExplain());
			funWageLog.setUserId(userId);
			funWageLog.setUserName(userName);
			funWageLog.setWageId(param.getWageId());
			funWageLog.setUpdateTime(new Date());

			delWage = null == delWage ? new BigDecimal("0.00") : delWage;
			addWage = null == addWage ? new BigDecimal("0.00") : addWage;
			funWageLog.setAddWage(addWage);
			funWageLog.setReduceWage(delWage);
			BigDecimal currentAdjustWage = addWage.subtract(delWage);

			// 再累计老数据
			for (ErpFunWageLog erpFunWageLog : oldLogList) {
				BigDecimal addWage1 = erpFunWageLog.getAddWage();
				BigDecimal reduceWage = erpFunWageLog.getReduceWage();
				if(null != addWage1) {
					currentAdjustWage = currentAdjustWage.add(addWage1);
				}
				if(null != reduceWage) {
					currentAdjustWage = currentAdjustWage.subtract(reduceWage);
				}
			}

			funWageLog.setAdjustWage(currentAdjustWage);
			funWageLog.setLogType(1);
			funWageLog.setWageUserId(erpFunWage.getUserId());
			erpFunWage.setAdjustWage(currentAdjustWage);
			String content = "";
			if(null != addWage && addWage.doubleValue() > 0) {
				content += "增加" + addWage + "元 ";
			}

			if(null != delWage && delWage.doubleValue() > 0) {
				if(StringUtils.isNotBlank(content)) {
					content = content + " ";
				}
				content += "减少" + delWage + "元";
			}

			if(StringUtils.isNotBlank(content)) {
				if(StringUtils.isNotBlank(param.getExplain())) {
					param.setExplain(content + ",备注说明:" + param.getExplain());
				}else {
					param.setExplain(content);
				}

			}
			funWageLog.setExplain(param.getExplain());
			erpFunWage.setShardCityId(cityId);
			resCode = erpFunWageMapper.updateByPrimaryKeySelective(erpFunWage);

			ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, erpFunWage.getUserId());
			if(null != erpFunUsers) {
				funWageLog.setAreaId(erpFunUsers.getAreaId());
				funWageLog.setRegId(erpFunUsers.getRegId());
				funWageLog.setDeptId(erpFunUsers.getDeptId());
				funWageLog.setGrId(erpFunUsers.getGrId());
				funWageLog.setOrganizationPath(erpFunUsers.getTissueLine());
			}
			erpFunWageLogMapper.insertSelective(funWageLog);
			return resCode;
        }
	}

	@Override
	public List<ErpFunWageDto> getStaticWageVOListForUser(Integer cityId, Integer compId,Integer grId, Integer userId, String startDate, String subDate,Integer pageOffSet, Integer pageRows, Map<Integer, ErpFunCountwageDto> wageCountMap) {
		// 薪资的报表--FUN_WAGE
		PageHelper.startPage(pageOffSet, pageRows, true);
		List<ErpFunWage> list = erpFunWageMapper.getStaticWageInfoList(cityId, compId,grId,userId, startDate, subDate);
		List<Integer> userIds=new ArrayList<>();
		if (!list.isEmpty()){
			userIds=list.stream().collect(Collectors.mapping(ErpFunWage::getUserId,Collectors.toList()));
		}
		userIds.add(userId);
		// 获取业绩目标--FUN_PROFIT_TARGET
		Map<Integer,ReportFunStatisticTotleDto> workCountMap = null;

		List<ErpFunProfitTarget> erpFunProfitTargetList =erpFunProfitTargetMapper.getProfitTarget(cityId,compId,startDate,subDate,userIds);
		Map<Date,ErpFunProfitTarget> erpFunProfitTargetMap=erpFunProfitTargetList.stream().collect(Collectors.toMap(ErpFunProfitTarget::getTargetDate,ErpFunProfitTarget->ErpFunProfitTarget));
		Map<Integer,Integer> userArchiveMap = new HashMap<>();
		if(!list.isEmpty()) {
			List<ErpFunUsersDto> userList=erpFunUsersMapper.getUserArchiveList(cityId,compId,userIds.toArray(new String[userIds.size()]));
			for(ErpFunUsersDto userPo:userList){
				userArchiveMap.put(userPo.getArchiveId(), userPo.getUserId());
			}
		}
		// 该用户的基本信息
		ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(cityId,userId);
		DecimalFormat df = new DecimalFormat("#.0");
		List<ErpFunWageDto> resultList = new ArrayList<>();
		// 设置目标业绩，设置用户名，未审核的业绩动态计算提成
		for(ErpFunWage wagePO : list){
			startDate = CommonUtil.getFirstDateOfMonth(wagePO.getCreateDate());// 时间为当时的1号到下月1号
			String endDate = CommonUtil.getFirstDateOfNextMonth(wagePO.getCreateDate());// 时间为当时的1号到下月1号

			// 本月完成业绩金额和数量，本月发放业绩金额和数量，本月以前完成但是未发放业绩金额和数量
			Map<Integer, ErpFunWageDto> profitCountMap = this.getProfitWageMap(cityId,compId,userArchiveMap, null, userId, startDate, endDate);// 查询当时的业绩组成
			ErpFunWageDto vo = profitCountMap.get(userId);
			if (vo==null) {
				vo = new ErpFunWageDto();
			}
			resultList.add(vo);
			try {
				BeanUtilsHelper.copyProperties(vo,wagePO);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			// 目标业绩
			ErpFunProfitTarget funProfitTargetPO = erpFunProfitTargetMap.get(CommonUtil.getFirstDateOfMonth(wagePO.getCreateDate()));
			if(funProfitTargetPO!=null){
				vo.setProfitTarget(funProfitTargetPO.getTargetProfit());
			}
			// 名字等信息
			if(vo.getHisProfitCount() > 0 && wagePO.getWageId()!=null && wagePO.getCheckStatus()!=1){
				vo.setUserName(usersPO.getUserName() + " (未结" + vo.getHisProfitCount() + ")");
			}else{
				vo.setUserName(usersPO.getUserName());
			}
			// 如果是未审核的业绩,则要动态计算提成
			if (wagePO.getCheckStatus()==0) {// 未审核的实际上不用计算提成
				ErpFunSalaryTypeDto salaryInfoVo = null;
				Map<Integer,Integer> ysProfitMap = null;
				//1.查询薪资方案的最新配置时间,为了以前的薪资不受影响，所以需要时间比对
				List<ErpFunUserManageRange> roleManageRangeList = erpFunUserManageRangeMapper.getUserManageRange(cityId,compId,userId);
				Map<Integer,Integer> userManageMap=roleManageRangeList.stream().collect(Collectors.toMap(ErpFunUserManageRange::getUserId,ErpFunUserManageRange::getRangeId));
				Map<Integer, ErpFunUserManageRange> userManagePoMap = roleManageRangeList.stream().collect(Collectors.toMap(ErpFunUserManageRange::getUserId,val->val));
				ErpFunSalaryTypeDto erpFunSalaryTypeDto = erpSalaryTypeRelativeMapper.getLatestConfigureTime(cityId,compId,userIds,DateTimeHelper.formatDateTimetoString(new Date()));
				Date latestConfigureTime=erpFunSalaryTypeDto.getCreationTime();
				if(latestConfigureTime!=null){
					Date latestDate = latestConfigureTime;
					int dateCompareFlag = DateTimeHelper.compareTwoDate(latestDate,new Date());
					//2.如果当前时间是在薪资方案分配之前，那么就应该应用考核薪资方案,那么查询当前应用的薪资考核方案的标准id,以及实收的业绩,考核的业绩目标,考核薪资,任务比例返回回去
					//查询这些人对应的薪资考核方案ReportFunStatisticTotleDao
					if(dateCompareFlag==1){
						List<ReportFunStatisticTotleDto> reportFunStatisticTotleDtoList= reportFunStatisticTotleMapper.getSalaryWorkCountInfoByUserIds(cityId,compId,new Integer[]{userId}, startDate, endDate);
						workCountMap=reportFunStatisticTotleDtoList.stream().collect(Collectors.toMap(ReportFunStatisticTotleDto::getUserId,val->val));
						salaryInfoVo = erpSalaryTypeRelativeMapper.getSalaryTypeRelativeInfoOffUserId(userId,compId, startDate ,endDate);
						ysProfitMap = this.getYsProfitList(cityId,compId,userArchiveMap, null, userId, startDate, endDate);
						if (salaryInfoVo!=null) {
							Byte manageLevel = salaryInfoVo.getManageLevel();
							Byte countType = salaryInfoVo.getCountType();
							Byte profitCountType = salaryInfoVo.getProfitCountType();
							vo.setSalaryMoney(salaryInfoVo.getSalaryMoney());
							vo.setTaskMoney(salaryInfoVo.getTaskMoney());
							vo.setSalaryProfit(salaryInfoVo.getTragetProfit());
							vo.setProfitTarget(salaryInfoVo.getTragetProfit());
							vo.setHouseAssessmentCount(salaryInfoVo.getHouseAddCount());
							vo.setPerHouseMoney(salaryInfoVo.getPerHouseMoney());
							vo.setCustAssessmentCount(salaryInfoVo.getCustAddCount());
							vo.setPerCustMoney(salaryInfoVo.getPerCustMoney());
							vo.setDaikanAssessmentCount(salaryInfoVo.getDaikanCount());
							vo.setPerDaikanMoney(salaryInfoVo.getPerDaikanMoney());
							vo.setFankanAssessmentCount(salaryInfoVo.getFankanCount());
							vo.setPerFankanMoney(salaryInfoVo.getPerFankanMoney());
							if (manageLevel==0) {
								vo.setProfitMoney(new BigDecimal(ysProfitMap.get(userId)));
								ReportFunStatisticTotleDto workData = workCountMap.get(userId);
								if(workData!=null){
									vo.setHouseAddCount(workData.getHouseAddCount());
									vo.setCustAddCount(workData.getCustAddCount());
									vo.setFankanCount(workData.getFankanCount());
									vo.setDaikanCount(workData.getDaikanCount());
								}
							} else {
								String rangeColumn = this.transManageLevelToColumn(manageLevel);
								if (!roleManageRangeList.isEmpty()) {
									Integer rangeList = userManageMap.get(userId);
									boolean personCountFlag = true;
									int userCount = 1;
									List<Integer> ranges=new ArrayList<>();
									ranges.add(rangeList);
									String profitData = erpFunProfitMapper.getProfitTotalOffRangeList(cityId,compId,rangeColumn,ranges, startDate, endDate);
									//todo
									ReportFunStatisticTotleDto totalWorkData = reportFunStatisticTotleMapper.getSalaryWorkCountInfoByUserIds2(cityId,compId,rangeList, rangeColumn, startDate, endDate);
									if ("0".equals(profitCountType)) {
										if (profitData != null) {
											vo.setProfitMoney(new BigDecimal(profitData));
										}
									} else {
										if (profitData != null) {
											double profitMoney = StringUtil.paseDouble(profitData, 0.0);
											//todo
											ErpFunUsersDto userCountData = erpFunUsersMapper.getUsersCountOffRangeList(cityId,compId,rangeList, rangeColumn, startDate, endDate);
											if (userCountData != null) {
												userCount =  userCountData.getUserCount();
												personCountFlag = true;
												vo.setProfitMoney(new BigDecimal(df.format(profitMoney/userCount)));
											}
										}
									}
									if (countType==0) {
										if (totalWorkData != null) {
											vo.setHouseAddCount(totalWorkData.getHouseAddCount());
											vo.setCustAddCount(totalWorkData.getCustAddCount());
											vo.setDaikanCount(totalWorkData.getDaikanCount());
											vo.setFankanCount(totalWorkData.getFankanCount());
										}
									} else {
										if (totalWorkData != null) {
											double houseAddCount = totalWorkData.getHouseAddCount().doubleValue();
											double custAddCount = totalWorkData.getCustAddCount();
											double daikanCount = totalWorkData.getDaikanCount();
											double fankanCount = totalWorkData.getDaikanCount();
											if (!personCountFlag) {
												ErpFunUsersDto userCountData = erpFunUsersMapper.getUsersCountOffRangeList(cityId,compId,rangeList, rangeColumn, startDate, endDate);
												if (userCountData != null) {
													userCount =  userCountData.getUserCount();
												}
											}
											if (userCount>1) {
												vo.setHouseAddCount(StringUtil.paseInteger(df.format(houseAddCount/userCount)));
												vo.setCustAddCount(StringUtil.paseInteger(df.format(custAddCount/userCount)));
												vo.setDaikanCount(StringUtil.paseInteger(df.format(daikanCount/userCount)));
												vo.setFankanCount(StringUtil.paseInteger(df.format(fankanCount/userCount)));
											}
										}
									}
								}
							}
						}

					}

				}
				//todo
//				String[] timeRange = new String[] { startDate, endDate };
//				// 算出每一个人的各种类型的业绩金额
//				Map<String, ErpUserPerFomanceTypeMoney> userPerFormanceTypeMap = getProfitMoneyByPerformanceType(timeRange, archiveMap);
//				// 获取某每一个人的提成方案
//				Map<String, List<WagetypeUserRelative>> wageTypeUserMap = getUsersWageTypeMap(userIds);
//				double profitMoneySum = CommonUtil.parseToDouble(vo.getSET_PROFIT_WAGE());
//				double bonus = countOneBonus(userId, timeRange, wageTypeUserMap, userPerFormanceTypeMap, wageCountMap,profitMoneySum,userManageMap,userManagePoMap);
//				DecimalFormat doubleFormat = new DecimalFormat("0.##");
//				wagePO.setPROFIT_WAGE(doubleFormat.format(profitMoneySum));// 总业绩
//				wagePO.setOTHER_WAGE(doubleFormat.format(bonus));// 提成
//				// 计算实际薪资
//				double realWage = CommonUtil.parseToDouble(wagePO.getWAGE_MONEY()) + bonus - CommonUtil.parseToDouble(wagePO.getDEL_WAGE());
//				wagePO.setREAL_WAGE(doubleFormat.format(realWage));
			}

		}
		return null;
	}

	private String transManageLevelToColumn(Byte manageLevel) {
		//1=公司 2=大区 3=片区 4=门店 5=分组
		if (manageLevel==null) {
			return null;
		}
		String result = null;
		switch (manageLevel) {
			case 1:
				result = "COMP_ID";
				break;
			case 2:
				result = "AREA_ID";
				break;
			case 3:
				result = "REG_ID";
				break;
			case 4:
				result = "DEPT_ID";
				break;
			case 5:
				result = "GR_ID";
				break;
		}
		return result;
	}

	/**
	 * 查询签约时间内对应的每一个人实收业绩是多少
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/1
	 */	
	private Map<Integer,Integer> getYsProfitList(Integer cityId, Integer compId, Map<Integer,Integer> userArchiveMap, Object o, Integer userId, String startDate, String endDate) {
		return null;
	}

	/**
	 * 获取指定范围内经纪人的总业绩和业绩个数
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/1
	 */
	private Map<Integer,ErpFunWageDto> getProfitWageMap(Integer cityId, Integer compId, Map<Integer,Integer> userArchiveMap, Integer deptId, Integer userId, String startDate, String endDate) {
		// 本月完成业绩金额和数量
		List<ErpFunProfitDto> profitList = this.getProfitList(cityId,compId,(byte)1,userArchiveMap, deptId, userId, startDate, endDate);
		// 本月发放业绩金额和数量
		List<ErpFunProfitDto> setProfitList = this.getProfitList(cityId,compId,(byte)2,userArchiveMap, deptId, userId, startDate, endDate);

		// 本月以前完成但是未发放业绩金额和数量
		List<ErpFunProfitDto> hisProfitList = this.getProfitList(cityId,compId,(byte)3,userArchiveMap, deptId, userId, startDate, endDate);

		Map<Integer, ErpFunWageDto> resultMap = new HashMap<>();
		for (ErpFunProfitDto tempVO : profitList) {
			Integer archiveId = tempVO.getArchiveId();
			userId = userArchiveMap.get(archiveId);
			ErpFunWageDto vo = resultMap.get(userId);
			if (vo==null) {
				vo = new ErpFunWageDto();
				resultMap.put(userId, vo);
			}
			vo.setProfitWage(tempVO.getProfitWage());// 本月完成业绩金额
			BigDecimal proiftCount = tempVO.getProfitCount() == null ? new BigDecimal("0.00") : new BigDecimal(tempVO.getProfitCount());
			vo.setProfitCount(proiftCount);// 本月完成业绩数
		}
		for (ErpFunProfitDto tempVO : setProfitList) {
			Integer archiveId = tempVO.getArchiveId();
			userId = userArchiveMap.get(archiveId);
			ErpFunWageDto vo = resultMap.get(userId);
			if (vo==null) {
				vo = new ErpFunWageDto();
				resultMap.put(userId, vo);
			}
			Integer setProfitWage = tempVO.getSetProfitWage() == null ? 0 : tempVO.getSetProfitWage().ROUND_HALF_UP;
			vo.setSetProfitWage(setProfitWage);// 本月发放业绩金额
			vo.setSetProfitCount(tempVO.getSetProfitCount());// 本月发放业绩数
		}
		for (ErpFunProfitDto tempVO : hisProfitList) {
			Integer archiveId = tempVO.getArchiveId();
			userId = userArchiveMap.get(archiveId);
			ErpFunWageDto vo = resultMap.get(userId);
			if (vo==null) {
				vo = new ErpFunWageDto();
				resultMap.put(userId, vo);
			}
			Integer hisProfitWage = tempVO.getHisProfitWage() == null ? 0 : tempVO.getHisProfitWage().ROUND_HALF_UP;
			vo.setHisProfitWage(hisProfitWage);// 本月以前完成但是未发放业绩金额
			vo.setHisProfitCount(tempVO.getHisProfitCount());// 本月以前完成但是未发放业绩数
		}
		return resultMap;
	}

	/**
	 * 本月完成的业绩
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/1
	 */
	private List<ErpFunProfitDto> getProfitList(Integer cityId, Integer compId,Byte flag, Map<Integer,Integer> userArchiveMap, Integer deptId, Integer userId, String startDate, String endDate) {
		Set<Integer> archiveIds=new HashSet<>();
		if (userId!=null){
			ErpFunUsers users = erpFunUsersMapper.getUserInfoByUserId(cityId,userId);
			archiveIds.add(users.getArchiveId());
		}else {
			if (userArchiveMap != null && userArchiveMap.size() > 0) {
				archiveIds=userArchiveMap.keySet();
			}
		}
		List<ErpFunProfitDto> erpFunWageDtoList=new ArrayList<>();
		if (!archiveIds.isEmpty()){
			erpFunWageDtoList = erpFunProfitMapper.getProfitListByArchiveIds(cityId,compId,flag,startDate,endDate,archiveIds);
		}
		return erpFunWageDtoList;
	}

	/**
	 * 调店处理薪资数据
	 *
	 * **/
	@Override
	public void updateWageData(Integer cityId, Integer compId, ErpFunUsers erpFunUsers) {

		String wstWageAccountingDay = erpSysParaMapper.getParamValue(cityId, compId, "WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(wstWageAccountingDay, 0);
		ErpFunRoleWageConfigDto roleWageConfig = erpFunRoleWageConfigService.getRoleWageConfigInfo(cityId, compId,  erpFunUsers.getUserPosition(), erpFunUsers.getRoleLevelId(), assessMentMonth);
		// 为了处理数据吧
		if(null == roleWageConfig) {
			ErpFunRoleWageConfig erpFunRoleWageConfig = new ErpFunRoleWageConfig();
			erpFunRoleWageConfig.setAssessmentMonth(assessMentMonth);
			erpFunRoleWageConfig.setCompId(compId);
			erpFunRoleWageConfig.setCreateTime(Calendar.getInstance().getTime());
			erpFunRoleWageConfig.setIsCheck((byte) 1);
			erpFunRoleWageConfig.setRoleId(erpFunUsers.getUserPosition());
			erpFunRoleWageConfig.setShardCityId(cityId);
			erpFunRoleWageConfig.setBaseWage(BigDecimal.ZERO);
			erpFunRoleWageConfig.setCreateUid(erpFunUsers.getUserId());
			erpFunRoleWageConfigMapper.insertSelective(erpFunRoleWageConfig);
			roleWageConfig = new ErpFunRoleWageConfigDto();
			roleWageConfig.setId(erpFunRoleWageConfig.getId());
		}

		ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, erpFunUsers.getUserId(), assessMentMonth);
		if(null != erpFunWage) {

			Integer effectiveStatus = null == erpFunWage.getEffectiveStatus() ? 1 : erpFunWage.getEffectiveStatus().intValue();

			ErpFunAssessmentStatisticsExample assessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
			assessmentStatisticsExample.setShardCityId(cityId);
			ErpFunAssessmentStatisticsExample.Criteria criteria = assessmentStatisticsExample.createCriteria();

			criteria.andCompIdEqualTo(compId);
			if(null != erpFunUsers.getAreaId()) {
				criteria.andAreaIdEqualTo(erpFunUsers.getAreaId());
			}
			if(null != erpFunUsers.getRegId()) {
				criteria.andRegIdEqualTo(erpFunUsers.getRegId());
			}

			if(null != erpFunUsers.getDeptId()) {
				criteria.andDeptIdEqualTo(erpFunUsers.getDeptId());
			}

			criteria.andGrIdEqualTo(null != erpFunUsers.getGrId() ? erpFunUsers.getGrId() : 0).andCheckTypeEqualTo((byte) 1).andUserIdEqualTo(erpFunUsers.getUserId()).andAssessmentMonthEqualTo(assessMentMonth);
			Integer count = erpFunAssessmentStatisticsMapper.countByExample(assessmentStatisticsExample);
			// 查询系统参数，看人数算在哪个门店
			String updateOrgUserCountBelong = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId,erpFunUsers.getUserId(), "UPDATE_ORG_USER_COUNT_BELONG");
			// 默认算新门店 1：新门店  0=算老门店
			Integer newDeptCount = 1;
			// 查询系统参数 新员工是否参与配置
			if(StringUtil.isNotBlank(updateOrgUserCountBelong) && StringUtil.parseInteger(updateOrgUserCountBelong, 0 ) > 0) {
				// 判断经纪人配置参数
				Integer day = StringUtil.parseInteger(updateOrgUserCountBelong, 0);

				Calendar calendar = Calendar.getInstance();
				Integer nowDay = calendar.get(Calendar.DAY_OF_MONTH);
				if(nowDay >= day) {
					newDeptCount = 0;
				}
			}

			if(1 == newDeptCount) {
				// 老门店的这个人的个数置为0,这里就不指定哪个门店了，避免多次调动出现userCount> 1的情况
				assessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
				assessmentStatisticsExample.setShardCityId(cityId);
				assessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(erpFunUsers.getUserId()).andAssessmentMonthEqualTo(assessMentMonth);

				ErpFunAssessmentStatistics updateAssessmentStatistPO = new ErpFunAssessmentStatistics();
				updateAssessmentStatistPO.setUserCount(BigDecimal.ZERO);
				erpFunAssessmentStatisticsMapper.updateByExampleSelective(updateAssessmentStatistPO, assessmentStatisticsExample);

			}

			if(count > 0) {
				// 目标门店有配置数据就说明管理员调动比较频繁

				if(1 == newDeptCount) {
					// 老门店的这个人的个数置为0
					assessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
					assessmentStatisticsExample.setShardCityId(cityId);
					assessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andAreaIdEqualTo(erpFunUsers.getAreaId()).andRegIdEqualTo(erpFunUsers.getRegId()).
							andDeptIdEqualTo(erpFunUsers.getDeptId()).andGrIdEqualTo(erpFunUsers.getGrId()).andUserIdEqualTo(erpFunUsers.getUserId()).andAssessmentMonthEqualTo(assessMentMonth);

					ErpFunAssessmentStatistics updateAssessmentStatistPO = new ErpFunAssessmentStatistics();
					updateAssessmentStatistPO.setUserCount(new BigDecimal(1));
					erpFunAssessmentStatisticsMapper.updateByExampleSelective(updateAssessmentStatistPO, assessmentStatisticsExample);
				}

			} else {
				// 新门店数据
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), assessMentMonth, roleWageConfig.getId(),1, 1, effectiveStatus, newDeptCount);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), assessMentMonth, roleWageConfig.getId(),1, 2, effectiveStatus, newDeptCount);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), assessMentMonth, roleWageConfig.getId(),2, 1, effectiveStatus, newDeptCount);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), assessMentMonth, roleWageConfig.getId(),2, 2, effectiveStatus, newDeptCount);
			}
		}
	}
}
