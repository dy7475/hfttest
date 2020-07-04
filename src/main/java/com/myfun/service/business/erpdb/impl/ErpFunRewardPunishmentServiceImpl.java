package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunRewardPunishmentService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.KafkaBizUtils;
import com.myfun.utils.StringUtil;

@Service
public class ErpFunRewardPunishmentServiceImpl extends AbstractService<ErpFunRewardPunishment, ErpFunRewardPunishment> implements ErpFunRewardPunishmentService {

	@Autowired
	ErpFunRewardPunishmentMapper erpFunRewardPunishmentMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunRewardPunishmentClassMapper erpFunRewardPunishmentClassMapper;
	@Autowired
	ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	ErpFunTaskService erpFunTaskService;
	@Autowired
	ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	ErpFunWageMapper erpFunWageMapper;
	@Autowired ErpFunWageLogMapper erpFunWageLogMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunRewardPunishmentMapper;
	}

	@Transactional
	@Override
	public Integer addRewardPunishment(Integer cityId, Integer compId, Integer userId, String userName, ErpFunRewardPunishmentParam param) {

		if(null == param.getAmount()) {
			param.setAmount(new BigDecimal(0));
		}
		// 处理时间
		Date occurrenceTime = param.getOccurrenceTime();
		if(null == occurrenceTime) {
			throw new BusinessException("请填写奖罚日期！");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(occurrenceTime);
		Integer year = calendar.get(Calendar.YEAR);
		Integer month = calendar.get(Calendar.MONTH) + 1;
		String assessmentMonth = "";
		if(month < 10) {
			assessmentMonth = year+"-0"+month;
		}else {
			assessmentMonth = year+"-"+month;
		}
		param.setAssessmentMonth(assessmentMonth);

		Set<Integer> userList = new HashSet<>();
		// 查询员工List
		List<ErpFunUsers> userListByUserIds = new ArrayList<>();
		if(StringUtils.isNotBlank(param.getUserIds())) {
			List<String> userIdStrList = Arrays.asList(param.getUserIds().split(","));
			userList = userIdStrList.stream().map(Integer::valueOf).collect(Collectors.toSet());
			userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userList);
			param.setUserIdList(userList);
			if(userList.size() == 0) {
				return 1;
			}
		} else {
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			ErpFunUsersExample.Criteria criteria = erpFunUsersExample.createCriteria();

			if(null != param.getDeptId()) {
				criteria.andDeptIdEqualTo(param.getDeptId());
			}
			if (null != param.getGrId()) {
				criteria.andGrIdEqualTo(param.getGrId());
			}
			if (StringUtil.isNotBlank(param.getUserPosition())) {
				criteria.andUserPositionEqualTo(param.getUserPosition());
			}
			if (null != param.getUserId()) {
				criteria.andUserIdEqualTo(param.getUserId());
			}
			if (null != param.getOrganizationId()) {
				criteria.andTissueLineLike("%:" + param.getOrganizationId() + ":%");
			}
			criteria.andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
			userListByUserIds = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		}
		// 一级一级的判断
		if(param.getNewOrganization()) {
			erpFunRewardPunishmentMapper.insertBatchNewOrg(cityId, compId, userId, param);
		} else {
			erpFunRewardPunishmentMapper.insertBatch(cityId, compId, userId, param);
		}
		final  ErpFunRewardPunishmentClass  erpFunRewardPunishmentClass = erpFunRewardPunishmentClassMapper.getClassById(cityId, param.getRewardPunishmentClass());
		if(null == erpFunRewardPunishmentClass) {
			return 1;
		}

		userListByUserIds.forEach(erpFunUsers -> {
			// 任务提醒
			createGenerationTask(cityId, compId, erpFunUsers, DateUtil.DateToString(param.getOccurrenceTime(), "yyyy-MM-dd"), erpFunRewardPunishmentClass, param.getAmount());
		});

		List<Integer> userIdList = userListByUserIds.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toList()));
		if(userIdList.size() > 0) {
			// 写薪资日志
			Map<Integer, ErpFunUsers> usersMap = userListByUserIds.stream().collect(Collectors.toMap(val -> val.getUserId(), val -> val));

			ErpFunWageExample erpFunWageExample = new ErpFunWageExample();
			erpFunWageExample.setShardCityId(cityId);
			erpFunWageExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIdList).andAssessmentMonthEqualTo(assessmentMonth);
			List<ErpFunWage> erpFunWages = erpFunWageMapper.selectByExample(erpFunWageExample);
			Map<Integer, ErpFunWage> wageMap = erpFunWages.stream().collect(Collectors.toMap(val -> val.getUserId(), val -> val));
			userIdList.stream().forEach(uId-> {
				ErpFunWageLog erpFunWageLog = new ErpFunWageLog();
				Integer logType = 3;
				String content = erpFunRewardPunishmentClass.getClassName() +" "+ param.getAmount() +"元";
				if(2 == param.getRewardPunishmentType()) {
					// 罚款
					logType = 4;
					content = erpFunRewardPunishmentClass.getClassName() +" "+ param.getAmount() +"元";
					erpFunWageLog.setReduceWage(param.getAmount());
				}else {
					// 奖励
					erpFunWageLog.setAddWage(param.getAmount());
				}
				erpFunWageLog.setLogType(logType);
				if(StringUtils.isNotBlank(param.getRemarks())) {
					content += " 备注：" + param.getRemarks();
				}
				erpFunWageLog.setExplain(content);
				erpFunWageLog.setCompId(compId);
				erpFunWageLog.setShardCityId(cityId);
				ErpFunWage erpFunWage = wageMap.get(uId);
				if(null != erpFunWage) {
					erpFunWageLog.setWageId(erpFunWage.getWageId());
					if(null != erpFunWage.getRealWageCk()) {
						// 增加或者减少调整数据
						BigDecimal realWageCk = erpFunWage.getRealWageCk();
						if(4 == logType) {
							realWageCk = realWageCk.subtract(param.getAmount());
						}else {
							realWageCk = realWageCk.add(param.getAmount());
						}
						erpFunWage.setRealWageCk(realWageCk);
						erpFunWage.setShardCityId(cityId);
						erpFunWageMapper.updateByPrimaryKeySelective(erpFunWage);
					}
				}

				erpFunWageLog.setWageUserId(uId);
				erpFunWageLog.setUserId(userId);
				erpFunWageLog.setUpdateTime(new Date());
				erpFunWageLog.setIsDel((byte) 0);
				erpFunWageLog.setUserName(userName);

				ErpFunUsers erpFunUsers = usersMap.get(userId);
				if(null != erpFunUsers) {
					erpFunWageLog.setAreaId(erpFunUsers.getAreaId());
					erpFunWageLog.setRegId(erpFunUsers.getRegId());
					erpFunWageLog.setDeptId(erpFunUsers.getDeptId());
					erpFunWageLog.setGrId(erpFunUsers.getGrId());
				}
				erpFunWageLogMapper.insertSelective(erpFunWageLog);
			});
		}


		return null;
	}


	/**
	 * 批量导入
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/17
	 */
	@Transactional
	@Override
	public Integer importRewardPunishment(Integer cityId, Integer compId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {
		String rewardPunishmentListJson=erpFunRewardPunishmentParam.getRewardPunishmentListJson();
		Integer index = 0;
		Set<Integer> userList = new HashSet<>();
		Set<Integer> rewardPunishmentClassSet = new HashSet<>();

		List<ErpFunUsers> userListByUserIds = new ArrayList<>();
		List<ErpFunRewardPunishmentClass> erpFunRewardPunishmentClassList = new ArrayList<>();


		if (rewardPunishmentListJson!=null){
			List<ErpFunRewardPunishment> list = JSON.parseArray(rewardPunishmentListJson, ErpFunRewardPunishment.class);
			userList=list.stream().collect(Collectors.mapping(ErpFunRewardPunishment::getUserId,Collectors.toSet()));
			userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userList);
			Map<Integer,ErpFunUsers> erpFunUsersMap=userListByUserIds.stream().collect(Collectors.toMap(ErpFunUsers::getUserId,val->val));

			rewardPunishmentClassSet=list.stream().collect(Collectors.mapping(ErpFunRewardPunishment::getRewardPunishmentClass,Collectors.toSet()));
			erpFunRewardPunishmentClassList=erpFunRewardPunishmentClassMapper.getClassByIds(cityId,rewardPunishmentClassSet);
			Map<Integer,ErpFunRewardPunishmentClass> erpFunRewardPunishmentClassMap=erpFunRewardPunishmentClassList.stream().collect(Collectors.toMap(ErpFunRewardPunishmentClass::getId,val->val));

			for (ErpFunRewardPunishment erpFunRewardPunishment:list){
				ErpFunRewardPunishmentClass erpFunRewardPunishmentClass=erpFunRewardPunishmentClassMap.get(erpFunRewardPunishment.getRewardPunishmentClass());
				ErpFunUsers erpFunUsers=erpFunUsersMap.get(erpFunRewardPunishment.getUserId());
				if (erpFunUsers==null){
					continue;
				}
				//非本公司不导入
				if (!erpFunUsers.getCompId().equals(compId)){
					continue;
				}
				if (erpFunRewardPunishmentClass==null){
					throw new BusinessException("奖罚类别不存在");
				}
				// 处理时间
				Date occurrenceTime = erpFunRewardPunishment.getOccurrenceTime();
				if(null == occurrenceTime) {
					throw new BusinessException("请填写奖罚日期！");
				}
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(occurrenceTime);
				Integer year = calendar.get(Calendar.YEAR);
				Integer month = calendar.get(Calendar.MONTH) + 1;
				String assessmentMonth = "";
				if(month < 10) {
					assessmentMonth = year+"-0"+month;
				}else {
					assessmentMonth = year+"-"+month;
				}
				erpFunRewardPunishment.setAssessmentMonth(assessmentMonth);

				erpFunRewardPunishment.setCreateUid(userId);
				erpFunRewardPunishment.setCreateTime(new Date());
				erpFunRewardPunishment.setShardCityId(cityId);
				erpFunRewardPunishment.setCompId(compId);
				erpFunRewardPunishment.setAreaId(erpFunUsers.getAreaId());
				erpFunRewardPunishment.setRegId(erpFunUsers.getRegId());
				erpFunRewardPunishment.setDeptId(erpFunUsers.getDeptId());
				erpFunRewardPunishment.setGrId(erpFunUsers.getGrId());
				erpFunRewardPunishment.setIsDel((byte)0);
				erpFunRewardPunishment.setRewardPunishmentType(erpFunRewardPunishmentClass.getRewardPunishmentType());
				erpFunRewardPunishmentMapper.insertSelective(erpFunRewardPunishment);
				// 任务提醒
				createGenerationTask(cityId, compId, erpFunUsers, DateUtil.DateToString(erpFunRewardPunishment.getOccurrenceTime(), "yyyy-MM-dd"), erpFunRewardPunishmentClass, erpFunRewardPunishment.getAmount());
				index++;
			}
		}
		return index;
	}

	// 奖励（或罚款）通知：你于xx（发生日期）因xxx（类型）奖励（或罚款）xx元
	// REWARD_PUNISHMENT_TYPE 1:奖励 2：罚款
	private void createGenerationTask(Integer cityId, Integer compId, ErpFunUsers erpFunUsers, String occDate, ErpFunRewardPunishmentClass erpFunRewardPunishmentClass, BigDecimal totalAmount) {
		String taskSubject = "";
		String feeTypeStr = "";
		if(1 == erpFunRewardPunishmentClass.getRewardPunishmentType().intValue()) {
			taskSubject = Const.DIC_TASK_TYPE_REWARD_REMIND_STR;
			feeTypeStr = "奖励";
		}else {
			taskSubject = Const.DIC_TASK_TYPE_PUNISHMENT_REMIND_STR;
			feeTypeStr = "罚款";
		}
		taskSubject += " 你于"+occDate+" 因 "+erpFunRewardPunishmentClass.getClassName()+" "+feeTypeStr+" "+totalAmount+"元";

		ErpFunMsg erpFunMsg = new ErpFunMsg();
		erpFunMsg.setShardCityId(cityId);
		erpFunMsg.setMsgContent(taskSubject);
		erpFunMsg.setCompId(compId);
		erpFunMsg.setReceiveDept(erpFunUsers.getDeptId());
		erpFunMsg.setReceiveUser(erpFunUsers.getUserId());
		erpFunMsg.setReadFlag(false);
		erpFunMsg.setSendTime(new Date());
		erpFunMsg.setSendUser(Const.DIC_SYSTEM_USERID_999);
		erpFunMsg.setSendDept(1);
		erpFunMsg.setMsgType(0);
		erpFunMsgMapper.insertFunMsg(erpFunMsg);

		// 推送小秘书
		// 同步推送掌通
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("templateId", "95");
		jsonObject.put("receiver", erpFunUsers.getArchiveId());
		jsonObject.put("content", taskSubject);
		KafkaBizUtils.pushMsgByTemplate(jsonObject);
		
	}

	@Transactional
	@Override
	public Integer editRewardPunishment(Integer cityId, Integer compId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {

		List<ErpFunRewardPunishment> erpFunAttendanceGroupBizList = JSON.parseObject(erpFunRewardPunishmentParam.getRewardPunishmentList(), new TypeReference<List<ErpFunRewardPunishment>>() {});
		for (ErpFunRewardPunishment erpFunRewardPunishment :erpFunAttendanceGroupBizList ) {
			if(null == erpFunRewardPunishment.getAmount()) {
				erpFunRewardPunishment.setAmount(new BigDecimal(0));
			}
			erpFunRewardPunishment.setUpdateTime(new Date());
			erpFunRewardPunishment.setShardCityId(cityId);
			erpFunRewardPunishmentMapper.updateByPrimaryKeySelective(erpFunRewardPunishment);
		}
		return null;
	}

	/**
	 * @Title 删除奖罚数据
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Override
	public Integer delRewardPunishmentInfo(Integer cityId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {

		String[] split = erpFunRewardPunishmentParam.getIds().split(",");
		List<Integer> idsList = new ArrayList<>();

		for (String s : split) {
			idsList.add(Integer.valueOf(s));
		}

		if(idsList.size() > 0) {
			ErpFunRewardPunishment funRewardPunishment = new ErpFunRewardPunishmentParam();

			funRewardPunishment.setIsDel((byte) 1);
			funRewardPunishment.setDelTime(new Date());
			funRewardPunishment.setDelUid(userId);
			funRewardPunishment.setUpdateTime(new Date());
			funRewardPunishment.setUpdateUid(userId);
			ErpFunRewardPunishmentExample erpFunRewardPunishmentExample = new ErpFunRewardPunishmentExample();
			erpFunRewardPunishmentExample.setShardCityId(cityId);
			erpFunRewardPunishmentExample.createCriteria().andIdIn(idsList);

			return erpFunRewardPunishmentMapper.updateByExampleSelective(funRewardPunishment, erpFunRewardPunishmentExample);

		}
		return 0;

	}

	/**
	 * @Title 审核
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Override
	public Integer auditRewardPunishmentInfo(Integer cityId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {
		ErpFunRewardPunishment erpFunRewardPunishment = new ErpFunRewardPunishmentParam();


		erpFunRewardPunishment.setId(erpFunRewardPunishmentParam.getId());
		Byte auditStatus = erpFunRewardPunishmentParam.getAuditStatus();

		erpFunRewardPunishment.setAuditStatus(auditStatus);
		erpFunRewardPunishment.setShardCityId(cityId);
		erpFunRewardPunishment.setUpdateTime(new Date());
		erpFunRewardPunishment.setAuditTime(new Date());
		erpFunRewardPunishment.setAuditUid(userId);
		return erpFunRewardPunishmentMapper.auditRewardPunishmentInfo(erpFunRewardPunishment);
	}
}
