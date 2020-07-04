package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.deal.param.DealAuditCommonParam;
import com.myfun.erpWeb.managecenter.deal.param.DealBussinessCommonParam;
import com.myfun.erpWeb.managecenter.transaction.param.ProcessFinancStatusParam;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.erpdb.dto.CreateAuditResultDto;
import com.myfun.repository.erpdb.dto.ErpAuditUserRuntimeDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.ErpOaLeaveAuditParam;
import com.myfun.repository.erpdb.param.ErpOaOutAuditParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.Assert;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpAuditRuntimeServiceImpl extends AbstractService<ErpAuditRuntime, ErpAuditRuntime> implements ErpAuditRuntimeService{
	@Autowired private ErpAuditRuntimeMapper erpAuditRuntimeMapper;
	@Autowired private ErpAuditTemplateMapper erpAuditTemplateMapper;
	@Autowired private ErpAuditUserTemplateMapper erpAuditUserTemplateMapper;
	@Autowired private ErpAuditUserRuntimeMapper erpAuditUserRuntimeMapper;
	@Autowired private ErpFunKeyService erpFunKeyService;
	@Autowired private ErpFunTrackExtendMapper erpFunTrackExtendMapper;
	@Autowired private ErpFunMsgMapper erpFunMsgMapper;
	@Autowired private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired private ErpAuditTrackMapper erpAuditTrackMapper;
	@Autowired private ErpAuditRuntimeCaseMapper erpAuditRuntimeCaseMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunTaskService erpFunTaskService;
	@Autowired private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired private ErpOutLogService erpOutLogService;
	@Autowired private ErpFunTrackService erpFunTrackService;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpFunDealService erpFunDealService;
	@Autowired private ErpFunDealMapper erpFunDealMapper;
	@Autowired private ActiveMqPublisher activeMqPublisher;
	@Autowired private ErpFunContractService erpFunContractService;
	@Resource private ErpSsqContractMapper erpSsqContractMapper;
	@Resource private ErpAuditClassMapper erpAuditClassMapper;
	@Resource private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Resource private ErpFunOrganizationMapper erpFunOrganizationMapper;

	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAuditRuntimeMapper;
	}
	
	@Transactional
	@Override
	public CreateAuditResultDto createAuditRuntimeForOaOut(ErpOaOutAuditParam param) {
		Integer isMobileApi = param.getIsMobileApi();
		boolean isFromMobile = (isMobileApi != null && isMobileApi == 1);
		
		ErpAuditRuntime auditRuntime = new ErpAuditRuntime();
		// 初始信息
		auditRuntime.setShardCityId(param.getCityId());
		auditRuntime.setUserId(param.getSelfUserId());
		auditRuntime.setAuditResource((byte) 3);
		// 信息来源，app还是erp
		auditRuntime.setAuditFrom(isFromMobile ? (byte) 1 : 0);
		// 审核信息
		auditRuntime.setAuditType(param.getOutType());// 外出类型
		auditRuntime.setAuditExplain(param.getOutReason());// 外出原因
		auditRuntime.setTargetIds(param.getTargetIds());// 目标IDs，多个以英文逗号分隔
		auditRuntime.setTargetTypes(param.getTargetTypes());// 目标类型
		auditRuntime.setTargetStartTime(param.getOutStartTime());// 外出时间
		auditRuntime.setTargetEndTime(param.getOutEndTime());// 外出返回时间
		double differDay = DateTimeHelper.getDaysOfTwoDate(param.getOutEndTime(), param.getOutStartTime());
		auditRuntime.setTargetDay(new BigDecimal(differDay).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 创建审核
		Integer auditResult = this.createAuditRuntime(auditRuntime, null);
		CreateAuditResultDto createAuditResult = new CreateAuditResultDto();
		// 1=无需审核，2=已全部通过且处理完成(全部是自己审核，一路自动通过)，3=创建审核成功，4=没有审核人
		if (auditResult == 1) {
			String auditExplain = auditRuntime.getAuditExplain();
//			String auditTypeStr = Const.AUDIT_OA_OUT_TYPE_MAP.get(auditRuntime.getAuditType().byteValue());
//			if(StringUtils.isNotBlank(auditTypeStr) && !"其他".equals(auditTypeStr)) {
//				auditExplain = auditTypeStr + "：" + auditExplain;
//			}
			// 实际返回时间为经纪人回店后登陆软件的时间，这里不写backTime
			erpOutLogService.createOutLog(param.getCityId(), auditRuntime.getCompId(), auditRuntime.getDeptId(),
					auditRuntime.getUserId(), auditExplain, auditRuntime.getTargetStartTime(),
					auditRuntime.getTargetEndTime(), auditRuntime.getId());
		} else if (auditResult == 2) {
			createAuditResult.setNeedAudit(0);
		} else if (auditResult == 3 || auditResult == 4) {
			createAuditResult.setNeedAudit(1);
			createAuditResult.setAuditId(auditRuntime.getId());
			createAuditResult.setWithoutAuditUser((auditResult == 4) ? 1 : 0);// 4代表没有审核人
		}
		return createAuditResult;
	}
	
	@Transactional
	@Override
	public CreateAuditResultDto createAuditRuntimeForOaLeave(ErpOaLeaveAuditParam param) {
		Integer isMobileApi = param.getIsMobileApi();
		boolean isFromMobile = (isMobileApi != null && isMobileApi == 1);
		
		ErpAuditRuntime auditRuntime = new ErpAuditRuntime();
		// 初始信息
		auditRuntime.setShardCityId(param.getCityId());
		auditRuntime.setUserId(param.getSelfUserId());
		// 信息来源，app还是erp
		auditRuntime.setAuditFrom(isFromMobile ? (byte) 1 : 0);
		// 审核信息
		auditRuntime.setAuditResource((byte) 2);
		auditRuntime.setAuditType(param.getLeaveType());// 请假类型
		auditRuntime.setAuditExplain(param.getLeaveReason());// 请假原因
		auditRuntime.setPhotoUrls(param.getEnclosureUrls());// 附件列表urls，多个以英文逗号分隔
		auditRuntime.setTargetStartTime(param.getLeaveStartTime());
		auditRuntime.setTargetEndTime(param.getLeaveEndTime());
		auditRuntime.setTargetDay(param.getLeaveDay());
		if(null != param.getLeaveStartType()){
			auditRuntime.setTargetStartType(param.getLeaveStartType().byteValue()); // 开始天上午或下午
		}
		if(null != param.getLeaveEndType()){
			auditRuntime.setTargetEndType(param.getLeaveEndType().byteValue()); // 结束天上午或下午
		}
		// 创建审核
		Integer auditResult = this.createAuditRuntime(auditRuntime, null);
		CreateAuditResultDto createAuditResult = new CreateAuditResultDto();
		// 1=无需审核，2=已全部通过且处理完成(全部是自己审核，一路自动通过)，3=创建审核成功，4=没有审核人
		if (auditResult == 1) {
			throw new ConfirmException("您公司未配置此项审批流程，请联系管理员开通");
		} else if (auditResult == 2) {
			// TODO 请假申请审核成功处理
//			erpAttendanceSerice.updateMgrAttForLeaveAudit(param.getCityId(), param.getCompId(), param.getSelfUserId(),
//					param.getSelfUserName(), param.getLeaveReason(), param.getCreateAuditUserId(),
//					param.getCreateAuditDeptId(), param.getLeaveStartTime(), param.getLeaveEndTime(),param.getLeaveStartType(),param.getLeaveEndType());
			createAuditResult.setNeedAudit(0);
		} else if (auditResult == 3 || auditResult == 4) {
			createAuditResult.setNeedAudit(1);
			createAuditResult.setAuditId(auditRuntime.getId());
			createAuditResult.setWithoutAuditUser((auditResult == 4) ? 1 : 0);// 4代表没有审核人
		}
		return createAuditResult;
	}

	@Transactional
	@Override
	public Integer createAuditRuntimeForTrack(ErpCreateTrackInfoParam param, Integer mustAuditUserType) {
		Integer isMobileApi = param.getIsMobileApi();
		boolean isFromMobile = (isMobileApi != null && isMobileApi == 1);

		ErpAuditRuntime auditRuntime = new ErpAuditRuntime();
		// 初始信息
		auditRuntime.setShardCityId(param.getCityId());
		auditRuntime.setUserId(param.getSelfUserId());
		auditRuntime.setAuditResource((byte) 1);
		// 信息来源，app还是erp
		auditRuntime.setAuditFrom(isFromMobile ? (byte) 1 : 0);
		// 审核信息
		auditRuntime.setCaseId(param.getCaseId());
		auditRuntime.setCaseType(param.getCaseType());
		auditRuntime.setCaseNo(param.getCaseNo());
		auditRuntime.setAuditType(param.getTrackType().intValue());
		if(Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(param.getTrackType())){
			param.setTrackContent("钥匙注销");
		}
		auditRuntime.setAuditExplain(param.getTrackContent());
		// 业务相关
		auditRuntime.setTargetType(param.getTargetType());
		auditRuntime.setTargetTime(param.getTargetTime());
		auditRuntime.setTargetId(param.getTargetId());
		auditRuntime.setTargetNo(param.getTargetNo());
		auditRuntime.setTargetUseage(param.getTargetUseage());
		auditRuntime.setWarmTime(param.getWarmTime());
		auditRuntime.setWarmContent(param.getWarmContent());
		auditRuntime.setPhotoUrls(param.getPhotoUrls());
		auditRuntime.setUserIds(param.getUserIds());
		auditRuntime.setUserNames(param.getUserNames());
		auditRuntime.setDeptNames(param.getDeptNames());
		auditRuntime.setTargetIds(param.getTargetIds());
		auditRuntime.setTrackNo(param.getTrackNo());
		auditRuntime.setVideoIds(param.getVideoIds());
		auditRuntime.setVrIds(param.getVrIds());
		auditRuntime.setPhotoIds(param.getPhotoIds());
		auditRuntime.setKeyDeptId(param.getKeyDeptId());
		auditRuntime.setVideoUrls(param.getVideoUrls());
		auditRuntime.setLowestPrice(param.getLowestPrice());
		auditRuntime.setPriceUnit(param.getPriceUnit());
		auditRuntime.setTotalPrice(param.getTotalPrice());
		auditRuntime.setMakeSure(param.getMakeSure());
		ErpFunTrackExtend erpFunTrackExtend = null;
		setCaseStatus(param.getCityId(), param.getCaseId(), param.getCaseType(), auditRuntime);
		// 房堪，而且填了扩展字段
		if(auditRuntime.getAuditResource() == 1 && Const.DIC_TRACK_TYPE_FUNCAN.equals(param.getTrackType())) {
			if(StringUtils.isNotBlank(param.getCoreSellPoint())
					|| StringUtils.isNotBlank(param.getLayoutIntroduce())
					|| StringUtils.isNotBlank(param.getFitmentDescribe())
					|| StringUtils.isNotBlank(param.getPropertyRights())) {
				erpFunTrackExtend = new ErpFunTrackExtend();
				erpFunTrackExtend.setCompId(param.getCompId());
				erpFunTrackExtend.setCoreSellPoint(param.getCoreSellPoint());
				erpFunTrackExtend.setFitmentDescribe(param.getFitmentDescribe());
				erpFunTrackExtend.setLayoutIntroduce(param.getLayoutIntroduce());
				erpFunTrackExtend.setPropertyRights(param.getPropertyRights());
				erpFunTrackExtend.setCreationTime(new Date());
			}
		}
		Integer result = this.createAuditRuntime(auditRuntime, erpFunTrackExtend, mustAuditUserType);
		param.setAuditRuntime(auditRuntime);
		// 1=无需审核，2=已全部通过且处理完成
		if (result != 1 && result != 2) {
			// 写申请跟进
			erpFunTrackService.createTrackForCreateAudit(param, erpFunTrackExtend, auditRuntime);
			// 修改审批的跟进ID
			ErpAuditRuntime auditUp = new ErpAuditRuntime();
			auditUp.setShardCityId(param.getCityId());
			auditUp.setId(auditRuntime.getId());
			auditUp.setTrackId(param.getTrackId());
			erpAuditRuntimeMapper.updateByPrimaryKeySelective(auditUp);
		}
		// 自动通过把跟进ID赋值
		if(result == 2) {
			param.setTrackId(auditRuntime.getTrackId());
		}
		return result;
	}

	private void setCaseStatus(Integer cityId, Integer caseId, Integer caseType, ErpAuditRuntime auditRuntime) {
		// 判断封盘预定
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if(erpFunSale != null && (Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(erpFunSale.getSaleStatus()+"")) || Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(erpFunSale.getSaleStatus()+"")) {
				auditRuntime.setCaseStatus(erpFunSale.getSaleStatus());
			}
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if(erpFunLease != null && (Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(erpFunLease.getLeaseStatus()+"")) || Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(erpFunLease.getLeaseStatus()+"")) {
				auditRuntime.setCaseStatus(erpFunLease.getLeaseStatus().byteValue());
			}
		}
	}
	
	/**
	 * 通用创建审核任务的方法
	 * @author 张宏利
	 * @since 2018年1月2日
	 * @param auditRuntime
	 * @param mustAuditUserType
	 * @param auditResource
	 * @return 1=无需审核，2=已全部通过且处理完成，3=创建审核成功，4=创建审核成功且第一个环节没有审核人
	 */
	public Integer createAuditRuntime(ErpAuditRuntime auditRuntime,Integer mustAuditUserType) {
		return createAuditRuntime(auditRuntime, null, mustAuditUserType);
	}
	
	/**
	 * 通用创建审核任务的方法
	 * @author 张宏利
	 * @since 2018年1月2日
	 * @param auditRuntime
	 * @param mustAuditUserType
	 * @param auditResource
	 * @return 1=无需审核，2=已全部通过且处理完成，3=创建审核成功，4=创建审核成功且第一个环节没有审核人
	 */
	private Integer createAuditRuntime(ErpAuditRuntime auditRuntime, ErpFunTrackExtend erpFunTrackExtend, Integer mustAuditUserType) {
		Integer cityId = auditRuntime.getShardCityId();
		Integer auditType = auditRuntime.getAuditType();
		Integer caseId = auditRuntime.getCaseId();
		Integer caseType = auditRuntime.getCaseType();
		Date targetTime = auditRuntime.getTargetTime();
		String targetNo = auditRuntime.getTargetNo();
		Integer userId = auditRuntime.getUserId();
		Integer keyDeptId = auditRuntime.getKeyDeptId();
		Byte auditResource = auditRuntime.getAuditResource();
		
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		Assert.isNullThrow(erpFunUsers, "未找到该用户");
		// 用户信息
		auditRuntime.setCompId(erpFunUsers.getCompId());
		auditRuntime.setAreaId(erpFunUsers.getAreaId());
		auditRuntime.setRegId(erpFunUsers.getRegId());
		auditRuntime.setDeptId(erpFunUsers.getDeptId());
		auditRuntime.setGrId(erpFunUsers.getGrId());
		auditRuntime.setUserId(erpFunUsers.getUserId());
		auditRuntime.setArchiveId(erpFunUsers.getArchiveId());
		auditRuntime.setOrganizationPath(erpFunUsers.getTissueLine());//zt组织机构
		// 初始信息
		auditRuntime.setCreationTime(new Date());
		auditRuntime.setLastAuditTime(new Date());
		auditRuntime.setAuditStatus((byte) 0);
		
		List<ErpAuditUserTemplate> auditUserTemplateList = new LinkedList<>();
		boolean needAudit = true;
		ErpAuditTemplate erpAuditTemplate = erpAuditTemplateMapper.selectByAuditType(cityId, erpFunUsers.getCompId(), auditResource, auditType, caseType);
		if(erpAuditTemplate == null || erpAuditTemplate.getNeedAudit() == 0) {
			needAudit = false;// 该类型没配置或指定无需审核则无需审核
		} else {
			auditRuntime.setOverdueAuditTime(erpAuditTemplate.getOverdueAuditTime());
			auditUserTemplateList = erpAuditUserTemplateMapper.selectByAuditId(cityId, erpAuditTemplate.getId());
			if(auditUserTemplateList == null || auditUserTemplateList.isEmpty()) {
				needAudit = false;// 该类型没配置审核人则无需审核
			}
		}
		// 如果无需审核
		if(!needAudit) {
			// 强制要审核的，6=信息归属方有权限的人，创造一条需要审核的数据
			if(mustAuditUserType != null && 6 == mustAuditUserType.intValue()) {
				ErpAuditUserTemplate auditUserTemplate = new ErpAuditUserTemplate();
				auditUserTemplate.setExamineType((byte) 0);
				auditUserTemplate.setAuditSeq(1);
				auditUserTemplate.setAuditUserType(6);
				auditUserTemplateList.add(auditUserTemplate);
			} else if(3 == auditRuntime.getAuditResource()){ // 外出登记无需审核写自己审核的审核记录
				ErpAuditUserTemplate auditUserTemplate = new ErpAuditUserTemplate();
				auditUserTemplate.setExamineType((byte) 0);
				auditUserTemplate.setAuditSeq(1);
				auditUserTemplate.setAuditUserType(1);
				auditUserTemplate.setAuditUserId(userId);
				auditUserTemplateList.add(auditUserTemplate);
			} else {
				return 1;// 无需审核
			}
		}
		int resultVal = 4;// 创建审核任务成功
		boolean auditUserIsSelf = false;// 第一个审核人是自己
		// 创建相关审核人
		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		List<ErpAuditUserRuntime> nowAuditUserList = new LinkedList<>();
		//Map<Integer, List<ErpAuditUserRuntime>> newUserListMap = new HashMap<>();
		//Optional<Integer> minRange = Optional.of(0);
		for (int i = 0; i < auditUserTemplateList.size(); i++) {
			ErpAuditUserTemplate template = auditUserTemplateList.get(i);
			ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
			runtime.setAuditStatus((byte) 0);
			runtime.setExamineType(template.getExamineType() == null ? (byte)0 : template.getExamineType());
			runtime.setAuditSeq(template.getAuditSeq());
			runtime.setAuditUserType(template.getAuditUserType());
			runtime.setCreationTime(new Date());
			runtime.setAuditRoleId(template.getAuditRoleId());
			runtime.setAuditUserId(template.getAuditUserId());
			// 第一个就是角色审核，生成该角色所有人
			if(template.getAuditSeq() == 1) {
				Optional<Integer> nowRange = Optional.of(0);
				List<ErpAuditUserRuntime> auditUserList = this.createAuditUser(auditType.byteValue(), runtime, cityId, caseId,
						caseType, userId, keyDeptId, nowRange);
				// 角色没有审核人，则改为等待审核
				//List<ErpAuditUserRuntime> listTemp = newUserListMap.get(nowRange.get());
				//if(listTemp == null) {
				//	listTemp = new LinkedList<>();
				//}
				if(auditUserList.isEmpty()) {
					runtime.setAuditStatus((byte) 1);
					auditUserRuntimeList.add(runtime);
					nowAuditUserList.add(runtime);
					//listTemp.add(runtime);
				} else {
					resultVal = 3;// 创建成功且第一个环节有审核人
					// 第一个改为待审核
					for (ErpAuditUserRuntime erpAuditUserRuntime : auditUserList) {
						erpAuditUserRuntime.setAuditStatus((byte) 1);
						if(!auditUserIsSelf && userId.equals(erpAuditUserRuntime.getAuditUserId())) {
							auditUserIsSelf = true;
						}
					}
					auditUserRuntimeList.addAll(auditUserList);
					nowAuditUserList.addAll(auditUserList);
					//listTemp.addAll(auditUserList);
				}
				// 数值大的范围小
				//minRange = (nowRange.get() > minRange.get()) ? nowRange : minRange;
				//newUserListMap.put(nowRange.get(), listTemp);
			} else {
				auditUserRuntimeList.add(runtime);
			}
		}
		//auditUserRuntimeList.addAll(newUserListMap.get(minRange.get()));
		//nowAuditUserList.addAll(newUserListMap.get(minRange.get()));
		// 当前审核人信息
		String nowAuditInfo = this.getNowAuditInfo(cityId, auditRuntime.getCompId(), nowAuditUserList);
		auditRuntime.setNowAuditInfo(nowAuditInfo);
		
		erpAuditRuntimeMapper.insertSelective(auditRuntime);
		// 设置审核ID
		for (ErpAuditUserRuntime runtime : auditUserRuntimeList) {
			runtime.setAuditId(auditRuntime.getId());
		}
		// 插入关联的房客源
		this.createRuntimeCaseList(auditRuntime);
		// ---分批次插入---
		List<ErpAuditUserRuntime> tempUserList = new LinkedList<>();
		for (ErpAuditUserRuntime erpAuditUserRuntime : auditUserRuntimeList) {
			tempUserList.add(erpAuditUserRuntime);
			// 插入再清空，再来(150插入一次，最多支持2000/150=13个字段，字段增加要调整这个值)
			if(tempUserList.size() >= 150) {
				erpAuditUserRuntimeMapper.insertList(cityId, tempUserList);
				tempUserList.clear();
			}
		}
		// 里面剩下没插入的在插入一次
		if(tempUserList.size() > 0) {
			erpAuditUserRuntimeMapper.insertList(cityId, tempUserList);
		}
		// ---分批次插入---
		if(erpFunTrackExtend != null) {
			erpFunTrackExtend.setAuditId(auditRuntime.getId());
			erpFunTrackExtend.setShardCityId(cityId);
			erpFunTrackExtendMapper.insertSelective(erpFunTrackExtend);
		}
		// 第一个审核人是自己则自动通过
		if(auditUserIsSelf) {
			boolean auditIsEnd = this.auditRuntime(cityId, auditRuntime, userId, (byte) 1, "自动通过", targetTime, targetNo, 1);
			if(auditIsEnd) {
				return 2;// 审核已全部通过且处理完成
			}
		} else {// 提醒审核人
			// 要用再打开
//			JmsPublisher.sendJmsMessageForAudit(cityId, auditRuntime.getId(), 1, 1, 3);
		}
		return resultVal;
	}
	
	/**
	 * 创建审批的房源列表
	 * @author 张宏利
	 * @since 2018年1月17日
	 * @param auditRuntime
	 */
	private void createRuntimeCaseList(ErpAuditRuntime auditRuntime) {
		if (StringUtils.isBlank(auditRuntime.getTargetIds())) {
			return;
		}
		// 外出审核才需要记录房客源信息，其他的有了再加
		if(auditRuntime.getAuditResource() != 3) {
			return;
		}
		String[] targetIdArr = auditRuntime.getTargetIds().split(",");
		String[] targetTypeArr = null;
		if (StringUtils.isNotBlank(auditRuntime.getTargetTypes())) {
			targetTypeArr = auditRuntime.getTargetTypes().split(",");
		}
		List<ErpAuditRuntimeCase> runtimeCaseList = new LinkedList<>();
		for (int i = 0; i < targetIdArr.length; i++) {
			Integer targetId = StringUtil.parseInteger(targetIdArr[i], 0);
			if (targetId <= 0) {
				continue;
			}
			ErpAuditRuntimeCase runtimeCase = new ErpAuditRuntimeCase();
			runtimeCase.setCaseId(targetId);
			// 有一一对应的房源类型则赋值，否则用目标类型
			if (targetTypeArr != null && targetTypeArr.length > i) {
				runtimeCase.setCaseType(StringUtil.parseInteger(targetTypeArr[i], 0));
			} else {
				runtimeCase.setCaseType(auditRuntime.getTargetType());
			}
			runtimeCase.setAuditId(auditRuntime.getId());
			runtimeCase.setCompId(auditRuntime.getCompId());
			runtimeCaseList.add(runtimeCase);
		}
		if (runtimeCaseList.isEmpty()) {
			return;
		}
		erpAuditRuntimeCaseMapper.insertList(auditRuntime.getShardCityId(), runtimeCaseList);
	}

	@Transactional
	@Override
	public void createAuditTrack(Integer cityId, Integer auditId, Integer userId, Byte trackType, String trackContent) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		Assert.isNullThrow(erpFunUsers, "未找到该用户");
		// 判断是否存在和是否有权限跟进
		ErpAuditRuntime erpAuditRuntime = new ErpAuditRuntime();
		erpAuditRuntime.setShardCityId(cityId);
		erpAuditRuntime.setId(auditId);
		ErpAuditRuntime auditRuntime = erpAuditRuntimeMapper.selectByPrimaryKey(erpAuditRuntime);
		Assert.isTrueThrow(auditRuntime == null || !auditRuntime.getCompId().equals(erpFunUsers.getCompId()), "您无权跟进该任务");
		// 写跟进
		erpAuditTrackMapper.createAuditTrack(cityId, auditId, userId, trackType, null, trackContent);
		// 提醒提交人
		erpFunMsgMapper.createMsg(cityId, auditRuntime.getCompId(), 999, 4,auditRuntime.getUserId(), 
				"有人对您的审核任务进行跟进", auditId, auditRuntime.getAuditType());
	}
	
	@Transactional
	@Override
	public void auditRevokeRuntime(Integer cityId, Integer auditId, Integer userId, String trackContent) {
		// 判断是否存在和是否有审核权限（是否已经审核）
		ErpAuditRuntime erpAuditRuntime = new ErpAuditRuntime();
		erpAuditRuntime.setShardCityId(cityId);
		erpAuditRuntime.setId(auditId);
		ErpAuditRuntime auditRuntime = erpAuditRuntimeMapper.selectByPrimaryKey(erpAuditRuntime);
		Assert.isNullThrow(auditRuntime, "该审核任务不存在");
		Assert.isTrueThrow(auditRuntime.getAuditStatus() != 0, "该审核任务已被其他人关闭！");
		// 本人才可以撤销
		Assert.isTrueThrow(!auditRuntime.getUserId().equals(userId), "您无权撤回该任务");
		erpAuditRuntime.setLastAuditTime(new Date());
		erpAuditRuntime.setAuditStatus((byte) 3);// 撤回
		erpAuditRuntimeMapper.updateByPrimaryKeySelective(erpAuditRuntime);
//		// 写跟进
//		erpAuditTrackMapper.createAuditTrack(cityId, auditId, userId, (byte) 4, null, trackContent);
	}

	@Transactional
	@Override
	public boolean auditRuntime(Integer cityId, ErpAuditRuntime erpAuditRuntimeParam, Integer auditUserId, Byte auditStatus,
			String trackContent, Date targetTime, String targetNo, Integer sureToAviliable) {
		Integer auditId = erpAuditRuntimeParam.getId();
		Integer deptId = erpAuditRuntimeParam.getKeyDeptId();
		Integer compId = erpAuditRuntimeParam.getCompId();
		// 判断是否存在和是否有审核权限（是否已经审核）
		ErpAuditRuntime erpAuditRuntimeUp = new ErpAuditRuntime();
		erpAuditRuntimeUp.setShardCityId(cityId);
		erpAuditRuntimeUp.setId(auditId);
		ErpAuditRuntime auditRuntime = erpAuditRuntimeMapper.selectByPrimaryKey(erpAuditRuntimeUp);
		Assert.isNullThrow(auditRuntime, "该审核任务不存在");
		Assert.isTrueThrow(auditRuntime.getAuditStatus() != 0, "该审核任务已被其他人关闭！");
		List<ErpAuditUserRuntime> auditUserList = erpAuditUserRuntimeMapper.selectNowAuditUser(cityId, auditId, auditUserId, 1);
		Assert.isTrueThrow(auditUserList == null || auditUserList.isEmpty(), "该审核任务已被其他人关闭！");
		erpAuditRuntimeUp.setLastAuditTime(new Date());
		Integer nextAutoPassUserId = null;
		boolean auditIsEnd = false;// 审核是否结束
		// 审核通过
		if(1 == auditStatus) {
			if(Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditRuntime.getAuditType().byteValue())) {
				// 没有钥匙编号自动生成一个
				if (StringUtils.isBlank(targetNo)) {
					
					ErpFunDepts erpFunDept = erpFunDeptsMapper.getByDeptId(cityId, deptId);
					targetNo = erpFunKeyService.getNewKeyNum(cityId, compId, deptId, erpFunDept.getDeptNo(),null);
				}
			}
			Set<Integer> idSet = auditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toSet()));
			erpAuditUserRuntimeMapper.updateAuditStatusByIds(cityId, idSet, 2, trackContent, new Date());
			// 同意该流程的所有任务
			erpAuditUserRuntimeMapper.updateAuditStatusBySeq(cityId, auditId, idSet, auditUserList.get(0).getAuditSeq(), 3);
			// 审核时候修改信息（使用的对象和待更新对象都修改）
			if (StringUtils.isNotBlank(targetNo)) {
				auditRuntime.setTargetNo(targetNo);
				erpAuditRuntimeUp.setTargetNo(targetNo);
			}
			if (targetTime != null) {
				auditRuntime.setTargetTime(targetTime);
				erpAuditRuntimeUp.setTargetTime(targetTime);
			}
			// 查询下一环节审核人
			List<ErpAuditUserRuntime> waiteAuditUserList = erpAuditUserRuntimeMapper.selectNowAuditUser(cityId, auditId, null, 0);
			if(waiteAuditUserList != null && waiteAuditUserList.size() > 0) {
				// 重新生成一次
				List<ErpAuditUserRuntime> nowAuditUserList = new LinkedList<>();
				//Optional<Integer> minRange = Optional.of(0);
				//Map<Integer, List<ErpAuditUserRuntime>> newUserListMap = new HashMap<>();
				for (ErpAuditUserRuntime erpAuditUserRuntime : waiteAuditUserList) {
					Optional<Integer> nowRange = Optional.of(0);
					List<ErpAuditUserRuntime> newUserListTemp = this.createAuditUser(auditRuntime.getAuditType().byteValue(),
							erpAuditUserRuntime, cityId, auditRuntime.getCaseId(), auditRuntime.getCaseType(),
							auditRuntime.getUserId(), auditRuntime.getKeyDeptId(), nowRange);
					nowAuditUserList.addAll(newUserListTemp);
					// 数值大的范围小
					//minRange = (nowRange.get() > minRange.get()) ? nowRange : minRange;
					//List<ErpAuditUserRuntime> listTemp = newUserListMap.get(nowRange.get());
					//if(listTemp == null) {
					//	listTemp = newUserListTemp;
					//} else {
					//	listTemp.addAll(newUserListTemp);
					//}
					//newUserListMap.put(nowRange.get(), listTemp);
				}
				// 使用最小范围的列表，比如3个角色审核，角色1：递归找到公司层级才有人审核，角色2：递归找到门店层级才有人审核，角色3：递归找到门店层级才有人审核
				// minRange存的是角色2和角色3的人员列表，忽略掉角色1公司层级的（又不要这个逻辑了。。。）
				//nowAuditUserList.addAll(newUserListMap.get(minRange.get()));
				// 这一批角色没有人则等待
				if(nowAuditUserList == null || nowAuditUserList.isEmpty()) {
					// 修改为等待审核，等待有人的时候来审
					Set<Integer> auditNowId = waiteAuditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toSet()));
					erpAuditUserRuntimeMapper.updateAuditStatusByIds(cityId, auditNowId, 1, null, null);
					String dicCnMsg = erpDicDefinitionsMapper.getDicCnMsg(cityId, "TRACK_TYPE", String.valueOf(auditRuntime.getAuditType()));
					erpFunMsgMapper.createMsg(cityId, auditRuntime.getCompId(), 999, 4, auditRuntime.getUserId(),
							"您发起的" + dicCnMsg + "申请暂未配置审核人，请联系管理员配置！", auditRuntime.getId(), null);
					// 提醒发送审核的人，该环节没有审核人
					JmsPublisher.sendJmsMessageForAudit(cityId, auditRuntime.getId(), waiteAuditUserList.get(0).getAuditSeq(), 4, 3);
				} else {
					List<Integer> oldAuditIdList = waiteAuditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toList()));
					// 删除之前的角色记录，新增成新角色用户列表
					for (ErpAuditUserRuntime runtime : nowAuditUserList) {
						runtime.setAuditStatus((byte)1);
					}
					ErpAuditUserRuntimeExample example = new ErpAuditUserRuntimeExample();
					example.setShardCityId(cityId);
					example.createCriteria().andIdIn(oldAuditIdList);
					erpAuditUserRuntimeMapper.deleteByExample(example);
					erpAuditUserRuntimeMapper.insertList(cityId, nowAuditUserList);
					// 如果有自己或者还是当前审核人=则自动通过审核
					List<Integer> newAuditUserIdList = nowAuditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getAuditUserId, Collectors.toList()));
					if(newAuditUserIdList.contains(auditRuntime.getUserId())) {
						// 下一个审核人是申请提交人
						nextAutoPassUserId = auditRuntime.getUserId();
					} else if(newAuditUserIdList.contains(auditUserId)) {
						// 下一个审核人是当前审核人
						nextAutoPassUserId = auditUserId;
					} else {
						// 异步消息通知，下一个人不是自己才提醒，因为有自己整个步骤都自动通过了
						JmsPublisher.sendJmsMessageForAudit(cityId, auditId, nowAuditUserList.get(0).getAuditSeq(), 1, 3);
					}
					// 当前审核人信息，用重新生成之前的列表
					String nowAuditInfo = this.getNowAuditInfo(cityId, auditRuntime.getCompId(), nowAuditUserList);
					erpAuditRuntimeUp.setNowAuditInfo(nowAuditInfo);
				}
			} else {
				auditIsEnd = true;
				erpAuditRuntimeUp.setAuditStatus((byte) 1);// 通过
				// 审核完成了！执行审核完成之后的逻辑
				if (auditRuntime.getAuditResource() == 1) {// 跟进
					ErpCreateTrackInfoParam trackInfoParam = erpFunTrackService.auditEndExec(auditRuntime, cityId, auditUserId, 3, sureToAviliable);
					erpAuditRuntimeParam.setTrackId(trackInfoParam.getTrackId());
				} else if (auditRuntime.getAuditResource() == 2) {// 请假
					// TODO 请假申请审核成功处理
				} else if (auditRuntime.getAuditResource() == 3) {// 外出
//					String auditExplain = auditRuntime.getAuditExplain();
//					String auditTypeStr = Const.AUDIT_OA_OUT_TYPE_MAP.get(auditRuntime.getAuditType().byteValue());
//					if(StringUtils.isNotBlank(auditTypeStr) && !"其他".equals(auditTypeStr)) {
//						auditExplain = auditTypeStr + "：" + auditExplain;
//					}
					erpOutLogService.createOutLog(cityId, auditRuntime.getCompId(), auditRuntime.getDeptId(),
							auditRuntime.getUserId(), auditRuntime.getAuditExplain(), auditRuntime.getTargetStartTime(),
							auditRuntime.getTargetEndTime(), auditRuntime.getId());
				}
				// 提醒提交人
				this.addAuditMsg(cityId, auditRuntime, true);
				// 异步消息通知
				JmsPublisher.sendJmsMessageForAudit(cityId, auditId, null, 2, 3);
			}
		} else {// 审核不通过
			//加密和推荐 审核失败房源自动变为普通
			byte trackType=auditRuntime.getAuditType().byteValue();
			if (trackType==Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD||trackType==Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND){
				this.judgeAndUpdateHouseLevel(cityId, auditRuntime.getCaseId(), auditRuntime.getCaseType(), trackType);
			}

			Set<Integer> idSet = auditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toSet()));
			erpAuditUserRuntimeMapper.updateAuditStatusByIds(cityId, idSet, 5, trackContent, new Date());
			erpAuditRuntimeUp.setAuditStatus((byte) 2);// 未通过
			// 提醒提交人
			this.addAuditMsg(cityId, auditRuntime, false);
			// 异步消息通知
			erpFunTrackService.writeFailAuditTrack(auditRuntime, cityId, auditUserId, 6, trackContent);
			JmsPublisher.sendJmsMessageForAudit(cityId, auditId, null, 3, 3);
		}
		erpAuditRuntimeMapper.updateByPrimaryKeySelective(erpAuditRuntimeUp);
		// 具有权限自动通过
		if(nextAutoPassUserId != null) {
			auditIsEnd = this.auditRuntime(cityId, erpAuditRuntimeParam, nextAutoPassUserId, (byte) 1, "自动通过", targetTime, targetNo, 1);
		}
		return auditIsEnd;
	}

	/**
	 * @tag 审核不通过时，修改HOUSE_LEVEL为普通
	 * @author 邓永洪
	 * @since 2018/6/8
	 */
	private void judgeAndUpdateHouseLevel(Integer cityId, Integer caseId, Integer caseType, byte trackType) {
		Date now = new Date();
		CaseInfoDto caseInfoDto = erpFunTrackService.getCaseInfoById(cityId, caseId, caseType);
		switch (caseType) {
			case 1://出售
				ErpFunSale funSale = caseInfoDto.getErpFunSale();
				//跟进类型和数据原本等级都为加密或推荐时才修改
				if ((Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funSale.getSaleLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funSale.getSaleLevel() == Const.DIC_HOUSE_LEVEL_COMMEND)) {
					ErpFunSale sale = new ErpFunSale();
					sale.setSaleId(caseId);
					sale.setSaleLevel(Const.DIC_HOUSE_LEVEL_COMMON);
					sale.setUpdateTime(now);
					sale.setTrackTime(now);
					sale.setShardCityId(cityId);
					erpFunSaleMapper.updateByPrimaryKeySelective(sale);
				}
				break;
			case 2://出租
				ErpFunLease funLease = caseInfoDto.getErpFunLease();
				if ((Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funLease.getLeaseLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funLease.getLeaseLevel() == Const.DIC_HOUSE_LEVEL_COMMEND)) {
					ErpFunLease lease = new ErpFunLease();
					lease.setLeaseId(caseId);
					lease.setLeaseLevel(Const.DIC_HOUSE_LEVEL_COMMON);
					lease.setUpdateTime(now);
					lease.setTrackTime(now);
					lease.setShardCityId(cityId);
					erpFunLeaseMapper.updateByPrimaryKeySelective(lease);
				}
				break;
			case 3://求购
				ErpFunBuyCustomer funBuyCustomer = caseInfoDto.getErpFunBuyCustomer();
				if ((Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funBuyCustomer.getBuyCustLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funBuyCustomer.getBuyCustLevel() == Const.DIC_HOUSE_LEVEL_COMMEND)) {
					ErpFunBuyCustomer customer = new ErpFunBuyCustomer();
					customer.setBuyCustId(caseId);
					customer.setBuyCustLevel(Const.DIC_HOUSE_LEVEL_COMMON);
					customer.setTrackTime(DateTimeHelper.getTimeNow());
					customer.setUpdateTime(now);
					customer.setShardCityId(cityId);
					erpFunBuyCustomerMapper.updateByPrimaryKeySelective(customer);
				}
				break;
			case 4://求租
				ErpFunRentCustomer funRentCustomer = caseInfoDto.getErpFunRentCustomer();
				if ((Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funRentCustomer.getRentCustLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funRentCustomer.getRentCustLevel() == Const.DIC_HOUSE_LEVEL_COMMEND)) {
					ErpFunRentCustomer rentCustomer = new ErpFunRentCustomer();
					rentCustomer.setRentCustId(caseId);
					rentCustomer.setRentCustLevel(Const.DIC_HOUSE_LEVEL_COMMON);
					rentCustomer.setTrackTime(now);
					rentCustomer.setUpdateTime(now);
					rentCustomer.setShardCityId(cityId);
					erpFunRentCustomerMapper.updateByPrimaryKeySelective(rentCustomer);
				}
				break;
		}
	}

	/**
	 * 审核成功或失败之后提醒发起人
	 * @author 张宏利
	 * @since 2018年1月29日
	 * @param cityId
	 * @param auditRuntime
	 * @param isAgree
	 */
	private void addAuditMsg(Integer cityId, ErpAuditRuntime auditRuntime, boolean isAgree) {
		String auditTypeStr = "";
		// 1=跟进类审核 2=请假审核 3=外出审核 4=合同审核
		byte auditType = auditRuntime.getAuditType().byteValue();
		if (auditRuntime.getAuditResource() == 1) {
			auditTypeStr = Const.AUDIT_TRACK_TYPE_MAP.get(auditType);
		} else if (auditRuntime.getAuditResource() == 2) {
			auditTypeStr = Const.AUDIT_OA_LEAVE_TYPE_MAP.get(auditType);
		} else if (auditRuntime.getAuditResource() == 3) {
			auditTypeStr = Const.AUDIT_OA_OUT_TYPE_MAP.get(auditType);
		} else if (auditRuntime.getAuditResource() == 4) {
			auditTypeStr = Const.AUDIT_DEAL_TYPE_MAP.get((int) auditType);

			switch (auditType) {
				case 8: {
					auditTypeStr = "应收应付";
					break;
				}
				case 9: {
					auditTypeStr = "实收实付";
					break;
				}
				case 10: {
					auditTypeStr = "撤销应收应付";
					break;
				}
				case 11: {
					auditTypeStr = "撤销实收实付";
					break;
				}
				default: {
				}
			}
		}
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, auditRuntime.getUserId());
		// 标题
		String taskSubject = erpFunUsers.getUserName() + "发起的" 	+ auditTypeStr + "申请" + (isAgree ? "已审核通过" : "被拒绝");
		// 提醒描述
		String taskDesc = erpFunUsers.getUserName() + "于"
				+ DateTimeHelper.formatDateTimetoString(auditRuntime.getCreationTime(), "yyyy-MM-dd HH:mm") + "发起的"
				+ auditTypeStr + "申请" + (isAgree ? "已审核通过" : "被拒绝") + "，<a href='" + auditRuntime.getId()
				+ "' style='color:rgb(37,156,243);text-decoration:none;'>点击查看审核详情</a>";
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
		ErpFunTask erpFunTask = new ErpFunTask();
		erpFunTask.setCompId(auditRuntime.getCompId());
		erpFunTask.setCaseNo(auditRuntime.getCaseNo());
		// OA审批没有类型
		Integer caseId = Optional.ofNullable(auditRuntime.getCaseId()).orElse(0);
		Integer caseType = Optional.ofNullable(auditRuntime.getCaseType()).orElse(0);
		erpFunTask.setCaseId(caseId);
		erpFunTask.setCaseType(caseType.byteValue());
		erpFunTask.setTaskSubject(taskSubject);
		erpFunTask.setTaskDesc(taskDesc);
		erpFunTask.setTaskOwner(auditRuntime.getUserId());
		erpFunTask.setTrackWarm(false);
		erpFunTask.setDeptId(erpFunUsers.getDeptId());
		if (auditRuntime.getAuditResource() == 4) {
			erpFunTask.setTaskType(Const.DIC_TASK_TYPE_CONTRACT_REMIND);
		} else {
			erpFunTask.setTaskType(Const.DIC_TASK_TYPE_BUSINESS_TRACKING);
		}
		erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
		erpFunTask.setIsRead(false);
		erpFunTask.setIndexShow(1);
		erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
		erpFunTask.setCreatorUid(999);
		erpFunTask.setWarmTime(timeNow);
		erpFunTask.setCreationTime(timeNow);
		erpFunTask.setShardCityId(cityId);
		erpFunTaskService.insertTask(cityId, erpFunTask, (byte) 0);
//		erpFunMsgMapper.createMsg(cityId, auditRuntime.getCompId(), 999, 4, auditRuntime.getUserId(), warmInfo,
//				auditRuntime.getId(), auditRuntime.getAuditType());
	}
	
	/**
	 * 获取当前审核信息
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param userType 审核人类型
	 * @param userId 用户ID
	 * @param roleId 角色ID
	 * @return
	 */
	private String getNowAuditInfo(Integer cityId, Integer compId, List<ErpAuditUserRuntime> newUserList) {
		StringBuilder resultStr = new StringBuilder();
		Set<String> auditSeqSet = new HashSet<>();
		for (ErpAuditUserRuntime userRuntime : newUserList) {
			Integer userType = userRuntime.getAuditUserType();
			// 指定角色审批
			if (userRuntime.getAuditUserType() != 1 && userRuntime.getAuditUserId()==null) {
				// 顺序+角色=多角色单条唯一，多个SEQ相同的则为角色审核类型，只需要保留一个即可
				String tempSeq = userRuntime.getAuditSeq() + "_" + userRuntime.getAuditRoleId();
				if (auditSeqSet.contains(tempSeq)) {
					continue;
				}
				auditSeqSet.add(tempSeq);
			}
			if(resultStr.length() > 0) {
				resultStr.append("、");
			}
			if (userType == 1 || (userRuntime.getAuditUserId()!=null && userRuntime.getAuditUserId()>0)) {
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userRuntime.getAuditUserId());
				resultStr.append(erpFunUsers.getUserName());
			} else {
				if (userType == 2) {
					resultStr.append("申请方");
				} else if (userType == 3) {
					resultStr.append("信息所属方");
				} else if (userType == 4) {
					resultStr.append("钥匙所在门店");
				} else if (userType == 5) {
					resultStr.append("直接上级");
				} else if (userType == 6) {
					resultStr.append("信息所属方有权限的人");
				} else if (userType == 7) {
					resultStr.append("钥匙所在门店有权限的人");
				}
				ErpCompRoles compRoles = erpCompRolesMapper.getByRoleId(cityId, compId, userRuntime.getAuditRoleId());
				if(compRoles != null) {
					resultStr.append(compRoles.getRoleName());
				}
			}
		}
		return resultStr + "审核中";
	}
	
	/**
	 * 判断角色是否有管理范围
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param cityId 城市ID
	 * @param userRuntime 运行时用户模板
	 * @param compId 公司ID
	 * @return
	 */
	@Override
	public void judgeHaveAuditUser(Integer cityId, ErpAuditUserTemplate userRuntime, Integer compId) {
		Integer auditUserType = userRuntime.getAuditUserType();
		String auditRoleId = userRuntime.getAuditRoleId();
		
		List<Integer> userList = null;
		if(auditUserType == 2) {// 2=申请方
			ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, auditRoleId);
			// 角色没有管理层级
			if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
				throw new ConfirmException("该角色没有审核层级");
			} else {
				userList = erpFunUserManageRangeMapper.getAllManageRange(cityId, compId, auditRoleId);
			}
		} else if(auditUserType == 3) {// 3=房客源所属方
			ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, auditRoleId);
			// 角色没有管理层级
			if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
				throw new ConfirmException("该角色没有审核层级");
			} else {
				userList = erpFunUserManageRangeMapper.getAllManageRange(cityId, compId, auditRoleId);
			}
		}
		if(userList != null && userList.isEmpty()) {
			throw new ConfirmException("该角色没有一个管理范围");
		}
	}
	
	/**
	 * 创建一个环节的所有审核人，只适用于非指定员工审核
	 * @author 张宏利
	 * @since 2017年11月8日
	 * @param template
	 */
	@Transactional
	@Override
	public List<ErpAuditUserRuntime> createAuditUser(Byte auditType, ErpAuditUserRuntime template, Integer cityId, Integer caseId, Integer caseType, 
			Integer createAuditUserId, Integer keyDeptId, Optional<Integer> nowRange) {
		Byte examineType = template.getExamineType();
		Integer auditSeq = template.getAuditSeq();
		Integer auditUserType = template.getAuditUserType();
		Integer auditUserId = template.getAuditUserId();
		String auditRoleId = template.getAuditRoleId();
		Integer auditId = template.getAuditId();
		
		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
		// 初始
		runtime.setAuditStatus((byte) 0);
		runtime.setAuditId(auditId);
		runtime.setExamineType(examineType == null ? (byte)0 : examineType);
		runtime.setAuditSeq(auditSeq);
		runtime.setAuditUserType(auditUserType);
		runtime.setCreationTime(new Date());
		if(auditUserType == 1) {// 1=指定员工审核
			runtime.setAuditUserId(auditUserId);
			auditUserRuntimeList.add(runtime);
		} else {
			List<Integer> userList = new LinkedList<>();
			if(auditUserType == 2) {// 2=申请方
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, erpFunUsers.getCompId(), auditRoleId);
				// 角色没有管理层级，找管理的上一层级
				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
					userList = erpFunUsersService.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId(), nowRange);
				} else {
					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
				}
			} else if(auditUserType == 3) {// 3=房客源所属方
				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, caseId, caseType);
				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, caseInfo.get("compId"), auditRoleId);
				// 角色没有管理层级，找管理的上一层级
				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
					userList = erpFunUsersService.getManageUserByUp(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"), nowRange);
				} else {
					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
				}
			} else if (auditUserType == 4) {// 4=钥匙所在门店
				ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
				if (erpFunDepts == null) {
					throw new ConfirmException("获取钥匙所在门店失败");
				}
				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, erpFunDepts.getCompId(), auditRoleId);
				// 角色没有管理层级，找管理的上一层级
				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
					userList = erpFunUsersService.getManageUserByUp(cityId, erpFunDepts.getCompId(), auditRoleId, erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null, nowRange);
				} else {
					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, erpFunDepts.getCompId(), auditRoleId, erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
				}
			} else if(auditUserType == 5) {// 5=直接上级
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
				Integer userIdNow = erpFunUserManageRangeMapper.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
				if(userIdNow != null) {
					userList.add(userIdNow);
				}
			// 系统参数无需审核到需要审核时，该类型的审核人默认改成6（隐藏逻辑）
			} else if(auditUserType == 6) {// 6=信息归属方有权限的人
				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, caseId, caseType);
				if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
					userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
				} else {
					userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
				}
			} else if(auditUserType == 7) {// 7=钥匙归属方有权限的人（暂时没用上）
				ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
				if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
					userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, erpFunDepts.getCompId(), erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
				} else {
					userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, erpFunDepts.getCompId(), erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
				}
			}
			if(userList != null && !userList.isEmpty()) {
				// 批量生成一个环节的所有人
				Set<Integer> userIdSet = new HashSet<>(userList);
				for (Integer userId : userIdSet) {
					if(auditUserRuntimeList.size() >= 1500) {
						break;// 超过2000会插入失败，也没必要那么多人来审批
					}
					ErpAuditUserRuntime runtimeTmp = new ErpAuditUserRuntime();
					runtimeTmp.setAuditStatus((byte) 0);
					runtimeTmp.setCreationTime(new Date());
					runtimeTmp.setAuditId(auditId);
					runtimeTmp.setExamineType(examineType == null ? (byte)0 : examineType);
					runtimeTmp.setAuditSeq(auditSeq);
					runtimeTmp.setAuditUserType(auditUserType);
					runtimeTmp.setAuditUserId(userId);
					runtimeTmp.setAuditRoleId(auditRoleId);
					auditUserRuntimeList.add(runtimeTmp);
				}
			}
		}
		return auditUserRuntimeList;
	}


	public List<ErpAuditUserRuntime> createAuditUserNoTransactional(Byte auditType, ErpAuditUserRuntime template, Integer cityId, Integer caseId, Integer caseType,
													 Integer createAuditUserId, Integer keyDeptId, Optional<Integer> nowRange, boolean isFangJidi) {
		Byte examineType = template.getExamineType();
		Integer auditSeq = template.getAuditSeq();
		Integer auditUserType = template.getAuditUserType();
		Integer auditUserId = template.getAuditUserId();
		String auditRoleId = template.getAuditRoleId();
		Integer auditId = template.getAuditId();

		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
		// 初始
		runtime.setAuditStatus((byte) 0);
		runtime.setAuditId(auditId);
		runtime.setExamineType(examineType == null ? (byte)0 : examineType);
		runtime.setAuditSeq(auditSeq);
		runtime.setAuditUserType(auditUserType);
		runtime.setCreationTime(new Date());
		if(auditUserType == 1) {// 1=指定员工审核
			runtime.setAuditUserId(auditUserId);
			auditUserRuntimeList.add(runtime);
		} else {
			List<Integer> userList = new LinkedList<>();
			if (isFangJidi) {
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
				userList = erpFunUsersMapper.selectByRoleNotWrriteUserList(cityId, erpFunUsers.getCompId(), auditRoleId);
			} else {
				if(auditUserType == 2) {// 2=申请方
					ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
					ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, erpFunUsers.getCompId(), auditRoleId);
					// 角色没有管理层级，找管理的上一层级
					if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
						userList = erpFunUsersService.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId(), nowRange);
					} else {
						userList = erpFunUserManageRangeMapper.getManageUserList(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
					}
				} else if(auditUserType == 3) {// 3=房客源所属方
					Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, caseId, caseType);
					ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, caseInfo.get("compId"), auditRoleId);
					// 角色没有管理层级，找管理的上一层级
					if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
						userList = erpFunUsersService.getManageUserByUp(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"), nowRange);
					} else {
						userList = erpFunUserManageRangeMapper.getManageUserList(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
					}
				} else if (auditUserType == 4) {// 4=钥匙所在门店
					ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
					if (erpFunDepts == null) {
						throw new ConfirmException("获取钥匙所在门店失败");
					}
					ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, erpFunDepts.getCompId(), auditRoleId);
					// 角色没有管理层级，找管理的上一层级
					if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
						userList = erpFunUsersService.getManageUserByUp(cityId, erpFunDepts.getCompId(), auditRoleId, erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null, nowRange);
					} else {
						userList = erpFunUserManageRangeMapper.getManageUserList(cityId, erpFunDepts.getCompId(), auditRoleId, erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
					}
				} else if(auditUserType == 5) {// 5=直接上级
					ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
					Integer userIdNow = erpFunUserManageRangeMapper.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
					if(userIdNow != null) {
						userList.add(userIdNow);
					}
					// 系统参数无需审核到需要审核时，该类型的审核人默认改成6（隐藏逻辑）
				} else if(auditUserType == 6) {// 6=信息归属方有权限的人
					Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, caseId, caseType);
					if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
							|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
							|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
							|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
						userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
					} else {
						userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
					}
				} else if(auditUserType == 7) {// 7=钥匙归属方有权限的人（暂时没用上）
					ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
					if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
							|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
							|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
							|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
						userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, erpFunDepts.getCompId(), erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
					} else {
						userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, erpFunDepts.getCompId(), erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
					}
				}
			}
			if(userList != null && !userList.isEmpty()) {
				// 批量生成一个环节的所有人
				Set<Integer> userIdSet = new HashSet<>(userList);
				for (Integer userId : userIdSet) {
					if(auditUserRuntimeList.size() >= 1500) {
						break;// 超过2000会插入失败，也没必要那么多人来审批
					}
					ErpAuditUserRuntime runtimeTmp = new ErpAuditUserRuntime();
					runtimeTmp.setAuditStatus((byte) 0);
					runtimeTmp.setCreationTime(new Date());
					runtimeTmp.setAuditId(auditId);
					runtimeTmp.setExamineType(examineType == null ? (byte)0 : examineType);
					runtimeTmp.setAuditSeq(auditSeq);
					runtimeTmp.setAuditUserType(auditUserType);
					runtimeTmp.setAuditUserId(userId);
					runtimeTmp.setAuditRoleId(auditRoleId);
					auditUserRuntimeList.add(runtimeTmp);
				}
			}
		}
		return auditUserRuntimeList;
	}

	@Override
	public void cancelAuditTask4InnerOrOutBargain(Integer cityId, Integer compId, Integer caseType, Integer caseId, Byte trackType) {
		Byte[] trackTypes = new Byte[] {
				Const.DIC_TRACK_TYPE_STATUS_SCHEDULE,Const.DIC_TRACK_TYPE_STATUS_SPECIAL,
				Const.DIC_TRACK_TYPE_STATUS_INNERDEAL, Const.DIC_TRACK_TYPE_STATUS_OUTDEAL,
				Const.DIC_TRACK_TYPE_STATUS_WRITEOFF
		};
		String caseTypeStr = (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)
				|| caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) ? "房源" : "客源";
		String content = "该" + caseTypeStr + "于任务审核期间被" + this.getCNMsgByStatus(trackType);
		erpAuditRuntimeMapper.cancelAuditTask(cityId, compId, caseId, caseType, trackTypes, content);
	}

	@Transactional
	@Override
	public void createAuditUserForUserChange(Integer cityId, Integer compId, String roleId, Integer userId) {
		// 删除老的所有的审批范围，userId改为空
		erpAuditUserRuntimeMapper.deleteAllAuditByUser(cityId, compId, userId);
		// 查询需要处理的列表
		List<ErpAuditUserRuntimeDto> needProcessUserList = erpAuditUserRuntimeMapper.getAuditUserByRole(cityId, compId, roleId);
		if(needProcessUserList.isEmpty()) {
			return;
		}
		Map<Integer, List<ErpAuditUserRuntimeDto>> userListMap = needProcessUserList.stream()
				.collect(Collectors.groupingBy(val -> val.getAuditId()));
		for (List<ErpAuditUserRuntimeDto> userRuntimeList : userListMap.values()) {
			Set<String> dealAuditIds = new HashSet<>();
			List<ErpAuditUserRuntime> newUserListInsert = new LinkedList<>();
			for (ErpAuditUserRuntimeDto userRuntime : userRuntimeList) {
				// 保证角色唯一性
				String auditKey = userRuntime.getAuditId() + "_" + userRuntime.getAuditUserType() + "_" + userRuntime.getAuditRoleId();
				if(dealAuditIds.contains(auditKey)) {
					continue;
				}
				dealAuditIds.add(auditKey);
				Optional<Integer> nowRange = Optional.of(0);
				List<ErpAuditUserRuntime> newUserList = this.createAuditUser(userRuntime.getAuditType().byteValue(),
						userRuntime, cityId, userRuntime.getCaseId(), userRuntime.getCaseType(), userRuntime.getUserId(),
						userRuntime.getKeyDeptId(), nowRange);
				if(newUserList == null || newUserList.isEmpty()) {
					userRuntime.setAuditUserId(null);
					newUserList.add(userRuntime);
				}
				// 改为审核中
				for (ErpAuditUserRuntime userRuntimeNew : newUserList) {
					userRuntimeNew.setAuditStatus((byte)1);
				}
				newUserListInsert.addAll(newUserList);
			}
			// 审批人中没有自己则不用重新生成
			Set<Integer> auditUserIdSet = newUserListInsert.stream().filter(val -> val.getAuditUserId() != null)
					.collect(Collectors.mapping(ErpAuditUserRuntime::getAuditUserId, Collectors.toSet()));
			if(!auditUserIdSet.contains(userId)) {
				continue;
			}
			// 删除当前seq所有的人
			ErpAuditUserRuntimeExample example = new ErpAuditUserRuntimeExample();
			example.setShardCityId(cityId);
			example.createCriteria().andAuditIdEqualTo(userRuntimeList.get(0).getAuditId())
			.andAuditSeqEqualTo(userRuntimeList.get(0).getAuditSeq()).andAuditStatusEqualTo((byte)1);
			erpAuditUserRuntimeMapper.deleteByExample(example);
			// 再重新插入
			if (newUserListInsert.size() > 0) {
				for (int i = 0,baseCount = 100,lengh = newUserListInsert.size(); i < lengh; i += baseCount) {
					List<ErpAuditUserRuntime> current = newUserListInsert.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						erpAuditUserRuntimeMapper.insertList(cityId, current);
					}
				}
			}
		}
	}

	/**
	 * 管理范围变更之后处理审批逻辑
	 * flj 修改于2020-06-24
	 * @param cityId
	 * @param compId
	 * @param userId
	 */
	public void createAuditUserForOrgManagerChange(Integer cityId, Integer compId, Integer userId) {
		//先查询出，该员工作为主管的审批，且在审核中的主管有哪些
		List<ErpAuditUserRuntimeDto> needProcessUserList = erpAuditUserRuntimeMapper.getThisUserAsOrgManagerAuditList(cityId, compId, userId);
		if (needProcessUserList.isEmpty()) {
			return;
		}
		Map<Integer, List<ErpAuditUserRuntimeDto>> userListMap = needProcessUserList.stream()
				.collect(Collectors.groupingBy(val -> val.getAuditId()));
		for (List<ErpAuditUserRuntimeDto> userRuntimeList : userListMap.values()) {
			Set<String> dealAuditIds = new HashSet<>();
			List<ErpAuditUserRuntime> newUserListInsert = new LinkedList<>();
			for (ErpAuditUserRuntimeDto userRuntime : userRuntimeList) {
				// 保证角色唯一性
				String auditKey = userRuntime.getAuditId() + "_" + userRuntime.getAuditUserType() + "_" + userRuntime.getAuditRoleId();
				if(dealAuditIds.contains(auditKey)) {
					continue;
				}
				dealAuditIds.add(auditKey);
				Optional<Integer> nowRange = Optional.of(0);
				List<ErpAuditUserRuntime> newUserList = this.createAuditUserNewOrg(userRuntime.getAuditType().byteValue(),
						userRuntime, cityId, userRuntime.getCaseId(), userRuntime.getCaseType(), userRuntime.getUserId(),
						userRuntime.getKeyDeptId(), nowRange);
				if(newUserList == null || newUserList.isEmpty()) {
					userRuntime.setAuditUserId(null);
					newUserList.add(userRuntime);
				}
				// 改为审核中
				for (ErpAuditUserRuntime userRuntimeNew : newUserList) {
					userRuntimeNew.setAuditStatus((byte)1);
					userRuntimeNew.setCompId(compId);
				}
				newUserListInsert.addAll(newUserList);
			}
			// 审批人中没有自己则不用重新生成
	/*		Set<Integer> auditUserIdSet = newUserListInsert.stream().filter(val -> val.getAuditUserId() != null)
					.collect(Collectors.mapping(ErpAuditUserRuntime::getAuditUserId, Collectors.toSet()));
			if (!auditUserIdSet.contains(userId)) {
				continue;
			}*/
			// 删除当前seq所有的人,并且是主管审核的
			ErpAuditUserRuntimeExample example = new ErpAuditUserRuntimeExample();
			example.setShardCityId(cityId);
			example.createCriteria().andAuditIdEqualTo(userRuntimeList.get(0).getAuditId())
			.andAuditSeqEqualTo(userRuntimeList.get(0).getAuditSeq()).andAuditStatusEqualTo((byte)1).andOrganizationDefinitionIdGreaterThan(0);
			erpAuditUserRuntimeMapper.deleteByExample(example);
			// 再重新插入
			if (newUserListInsert.size() > 0) {
				for (int i = 0,baseCount = 100,lengh = newUserListInsert.size(); i < lengh; i += baseCount) {
					List<ErpAuditUserRuntime> current = newUserListInsert.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						erpAuditUserRuntimeMapper.insertList(cityId, current);
					}
				}
			}
			List<ErpAuditUserRuntime> auditRuntimeList = erpAuditUserRuntimeMapper.selectByExample(example);
			String auditInfo = getNowAuditInfoV2(cityId, compId, auditRuntimeList, "等待 ", " 审核");
			ErpAuditRuntime record = new ErpAuditRuntime();
			record.setShardCityId(cityId);
			record.setId(userRuntimeList.get(0).getAuditId());
			record.setNowAuditInfo(auditInfo);
			erpAuditRuntimeMapper.updateByPrimaryKeySelective(record);
		}
	}
	
	@Override
	public void createAuditUserForUserChangeNoTransactional(Integer cityId, Integer compId, String roleId, Integer userId, boolean isFangJidi) {
		// 删除老的所有的审批范围，userId改为空
		erpAuditUserRuntimeMapper.deleteAllAuditByUser(cityId, compId, userId);
		// 查询需要处理的列表
		List<ErpAuditUserRuntimeDto> needProcessUserList = erpAuditUserRuntimeMapper.getAuditUserByRole(cityId, compId, roleId);
		if(needProcessUserList.isEmpty()) {
			return;
		}
		Map<Integer, List<ErpAuditUserRuntimeDto>> userListMap = needProcessUserList.stream()
				.collect(Collectors.groupingBy(val -> val.getAuditId()));
		for (List<ErpAuditUserRuntimeDto> userRuntimeList : userListMap.values()) {
			Set<String> dealAuditIds = new HashSet<>();
			List<ErpAuditUserRuntime> newUserListInsert = new LinkedList<>();
			for (ErpAuditUserRuntimeDto userRuntime : userRuntimeList) {
				// 保证角色唯一性
				String auditKey = userRuntime.getAuditId() + "_" + userRuntime.getAuditUserType() + "_" + userRuntime.getAuditRoleId();
				if(dealAuditIds.contains(auditKey)) {
					continue;
				}
				dealAuditIds.add(auditKey);
				Optional<Integer> nowRange = Optional.of(0);
				List<ErpAuditUserRuntime> newUserList = this.createAuditUserNoTransactional(userRuntime.getAuditType().byteValue(),
						userRuntime, cityId, userRuntime.getCaseId(), userRuntime.getCaseType(), userRuntime.getUserId(),
						userRuntime.getKeyDeptId(), nowRange, isFangJidi);
				if(newUserList == null || newUserList.isEmpty()) {
					userRuntime.setAuditUserId(null);
					newUserList.add(userRuntime);
				}
				// 改为审核中
				for (ErpAuditUserRuntime userRuntimeNew : newUserList) {
					userRuntimeNew.setAuditStatus((byte)1);
				}
				newUserListInsert.addAll(newUserList);
			}
			// 审批人中没有自己则不用重新生成
			Set<Integer> auditUserIdSet = newUserListInsert.stream().filter(val -> val.getAuditUserId() != null)
					.collect(Collectors.mapping(ErpAuditUserRuntime::getAuditUserId, Collectors.toSet()));
			if(!auditUserIdSet.contains(userId)) {
				continue;
			}
			// 删除当前seq所有的人
			ErpAuditUserRuntimeExample example = new ErpAuditUserRuntimeExample();
			example.setShardCityId(cityId);
			example.createCriteria().andAuditIdEqualTo(userRuntimeList.get(0).getAuditId())
					.andAuditSeqEqualTo(userRuntimeList.get(0).getAuditSeq()).andAuditStatusEqualTo((byte)1);
			erpAuditUserRuntimeMapper.deleteByExample(example);
			// 再重新插入
			if (newUserListInsert.size() > 0) {
				for (int i = 0,baseCount = 100,lengh = newUserListInsert.size(); i < lengh; i += baseCount) {
					List<ErpAuditUserRuntime> current = newUserListInsert.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						erpAuditUserRuntimeMapper.insertList(cityId, current);
					}
				}
			}
		}
	}
	
	@Override
	public void createAuditUserForFangJiDiRoleChangeNoTransactional(Integer cityId, Integer compId, String roleId, Integer userId, boolean isFangJidi) {
		// 删除老的所有的审批范围，userId改为空
		erpAuditUserRuntimeMapper.deleteAllAuditByUser(cityId, compId, userId);
		// 查询需要处理的列表
		List<ErpAuditUserRuntimeDto> needProcessUserList = erpAuditUserRuntimeMapper.getAuditUserByRole(cityId, compId, roleId);
		if(needProcessUserList.isEmpty()) {
			return;
		}
		Map<Integer, List<ErpAuditUserRuntimeDto>> userListMap = needProcessUserList.stream()
				.collect(Collectors.groupingBy(val -> val.getAuditId()));
		for (List<ErpAuditUserRuntimeDto> userRuntimeList : userListMap.values()) {
			Set<String> dealAuditIds = new HashSet<>();
			List<ErpAuditUserRuntime> newUserListInsert = new LinkedList<>();
			for (ErpAuditUserRuntimeDto userRuntime : userRuntimeList) {
				// 保证角色唯一性
				String auditKey = userRuntime.getAuditId() + "_" + userRuntime.getAuditUserType() + "_" + userRuntime.getAuditRoleId();
				if(dealAuditIds.contains(auditKey)) {
					continue;
				}
				dealAuditIds.add(auditKey);
				Optional<Integer> nowRange = Optional.of(0);
				List<ErpAuditUserRuntime> newUserList = this.createAuditUserNoTransactional(userRuntime.getAuditType().byteValue(),
						userRuntime, cityId, userRuntime.getCaseId(), userRuntime.getCaseType(), userRuntime.getUserId(),
						userRuntime.getKeyDeptId(), nowRange, isFangJidi);
				if(newUserList == null || newUserList.isEmpty()) {
					userRuntime.setAuditUserId(null);
					newUserList.add(userRuntime);
				}
				// 改为审核中
				for (ErpAuditUserRuntime userRuntimeNew : newUserList) {
					userRuntimeNew.setAuditStatus((byte)1);
				}
				newUserListInsert.addAll(newUserList);
			}
			// 审批人中没有自己则不用重新生成
			Set<Integer> auditUserIdSet = newUserListInsert.stream().filter(val -> val.getAuditUserId() != null)
					.collect(Collectors.mapping(ErpAuditUserRuntime::getAuditUserId, Collectors.toSet()));
			if(!auditUserIdSet.contains(userId)) {
				continue;
			}
			// 删除当前seq所有的人
			ErpAuditUserRuntimeExample example = new ErpAuditUserRuntimeExample();
			example.setShardCityId(cityId);
			example.createCriteria().andAuditIdEqualTo(userRuntimeList.get(0).getAuditId())
			.andAuditSeqEqualTo(userRuntimeList.get(0).getAuditSeq()).andAuditStatusEqualTo((byte)1);
			erpAuditUserRuntimeMapper.deleteByExample(example);
			// 再重新插入
			if (newUserListInsert.size() > 0) {
				for (int i = 0,baseCount = 100,lengh = newUserListInsert.size(); i < lengh; i += baseCount) {
					List<ErpAuditUserRuntime> current = newUserListInsert.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						erpAuditUserRuntimeMapper.insertList(cityId, current);
					}
				}
			}
		}
	}

	/**
	 * 获取状态的中文说明
	 * @author 张宏利
	 * @since 2017年11月3日
	 * @param status
	 * @return
	 */
	private String getCNMsgByStatus(Byte trackType) {
		if (Const.DIC_TRACK_TYPE_STATUS_TRANSSALE.equals(trackType)) {
			return "转售";
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE.equals(trackType)) {
			return "转租";
		} else if (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(trackType)) {
			return "转加密";
		} else if (Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
			return "内成交";
		} else if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)) {
			return "外成交";
		} else if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)) {
			return "注销";
		} else if (Const.DIC_TRACK_TYPE_BORROW_KEY.equals(trackType)) {
			return "借出";
		} else if (Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(trackType)) {
			return "注销";
		} else if (Const.DIC_TRACK_TYPE_CASE_TRANSFER.equals(trackType)) {
			return "移交";
		}
		return "";
	}

	@Transactional
	@Override
	public Boolean audit(Integer cityId, Integer id, Integer auditUserId, Byte auditStatus, String trackContent, boolean isNewOrg) throws Exception{
		// 判断是否存在和是否有审核权限（是否已经审核）
		ErpAuditRuntime erpAuditRuntimeUp = new ErpAuditRuntime();
		erpAuditRuntimeUp.setShardCityId(cityId);
		erpAuditRuntimeUp.setId(id);
		erpAuditRuntimeUp = erpAuditRuntimeMapper.selectByPrimaryKey(erpAuditRuntimeUp);
		erpAuditRuntimeUp.setShardCityId(cityId);
		Assert.isNullThrow(erpAuditRuntimeUp, "该审核任务不存在");
		// 防止前端调用错误
		Assert.isTrueThrow(4 != erpAuditRuntimeUp.getAuditResource().intValue(), "审核类型有误，请联系客服");
		Assert.isTrueThrow(erpAuditRuntimeUp.getAuditStatus() != 0, "该审核任务已被其他人关闭！");
		List<ErpAuditUserRuntime> auditUserList = erpAuditUserRuntimeMapper.selectNowAuditUser(cityId, id, auditUserId, 1);
		Assert.isTrueThrow(auditUserList == null || auditUserList.isEmpty(), "该审核任务已被其他人关闭！");
		erpAuditRuntimeUp.setLastAuditTime(new Date());
		Integer nextAutoPassUserId = null;
		boolean auditIsEnd = false;// 审核是否结束
		// 审核通过
		if(1 == auditStatus) {
			Set<Integer> idSet = auditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toSet()));
			erpAuditUserRuntimeMapper.updateAuditStatusByIds(cityId, idSet, 2, trackContent, new Date());
			// 同意该流程的所有任务
			erpAuditUserRuntimeMapper.updateAuditStatusBySeq(cityId, id, idSet, auditUserList.get(0).getAuditSeq(), 3);

			// 查询下一环节审核人
			List<ErpAuditUserRuntime> waiteAuditUserList = erpAuditUserRuntimeMapper.selectNowAuditUser(cityId, id, null, 0);
			if(waiteAuditUserList != null && waiteAuditUserList.size() > 0) {
				// 重新生成一次
				List<ErpAuditUserRuntime> nowAuditUserList = new LinkedList<>();
				//Optional<Integer> minRange = Optional.of(0);
				//Map<Integer, List<ErpAuditUserRuntime>> newUserListMap = new HashMap<>();
				for (ErpAuditUserRuntime erpAuditUserRuntime : waiteAuditUserList) {
					Optional<Integer> nowRange = Optional.of(0);
					List<ErpAuditUserRuntime> newUserListTemp = this.createAuditUserForDealAuditNewOrg(erpAuditUserRuntime, cityId, erpAuditRuntimeUp.getUserId(), nowRange);
					nowAuditUserList.addAll(newUserListTemp);
				}

				// 这一批角色没有人则等待
				if(nowAuditUserList == null || nowAuditUserList.isEmpty()) {
					// 修改为等待审核，等待有人的时候来审
					Set<Integer> auditNowId = waiteAuditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toSet()));
					erpAuditUserRuntimeMapper.updateAuditStatusByIds(cityId, auditNowId, 1, null, null);
					String dicCnMsg = erpDicDefinitionsMapper.getDicCnMsg(cityId, "TRACK_TYPE", String.valueOf(erpAuditRuntimeUp.getAuditType()));
					erpFunMsgMapper.createMsg(cityId, erpAuditRuntimeUp.getCompId(), 999, 4, erpAuditRuntimeUp.getUserId(),
							"您发起的" + dicCnMsg + "申请暂未配置审核人，请联系管理员配置！", erpAuditRuntimeUp.getId(), null);
					// 提醒发送审核的人，该环节没有审核人
//					JmsPublisher.sendJmsMessageForAudit(cityId, erpAuditRuntimeUp.getId(), waiteAuditUserList.get(0).getAuditSeq(), 4, 3);
					activeMqPublisher.sendJmsMessageForAudit(cityId, id, waiteAuditUserList.get(0).getAuditSeq(), 4, 10L);
				} else {
					List<Integer> oldAuditIdList = waiteAuditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toList()));
					// 删除之前的角色记录，新增成新角色用户列表
					for (ErpAuditUserRuntime runtime : nowAuditUserList) {
						runtime.setAuditStatus((byte)1);
					}
					ErpAuditUserRuntimeExample example = new ErpAuditUserRuntimeExample();
					example.setShardCityId(cityId);
					example.createCriteria().andIdIn(oldAuditIdList);
					erpAuditUserRuntimeMapper.deleteByExample(example);
					erpAuditUserRuntimeMapper.insertList(cityId, nowAuditUserList);
					// 如果有自己或者还是当前审核人=则自动通过审核
					List<Integer> newAuditUserIdList = nowAuditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getAuditUserId, Collectors.toList()));
					if(newAuditUserIdList.contains(erpAuditRuntimeUp.getUserId())) {
						// 下一个审核人是申请提交人
						nextAutoPassUserId = erpAuditRuntimeUp.getUserId();
					} else if(newAuditUserIdList.contains(auditUserId)) {
						// 下一个审核人是当前审核人
						nextAutoPassUserId = auditUserId;
					} else {
						// 异步消息通知，下一个人不是自己才提醒，因为有自己整个步骤都自动通过了
//						JmsPublisher.sendJmsMessageForAudit(cityId, id, nowAuditUserList.get(0).getAuditSeq(), 1, 3);
						activeMqPublisher.sendJmsMessageForAudit(cityId, id, nowAuditUserList.get(0).getAuditSeq(), 1, 10L);
					}
					// 当前审核人信息，用重新生成之前的列表
					String nowAuditInfo = this.getNowAuditInfo(cityId, erpAuditRuntimeUp.getCompId(), nowAuditUserList);
					erpAuditRuntimeUp.setNowAuditInfo(nowAuditInfo);
				}
			} else {
				auditIsEnd = true;
				erpAuditRuntimeUp.setAuditStatus((byte) 1);// 通过
				// 审核完成了！执行审核完成之后的逻辑
				if (erpAuditRuntimeUp.getAuditResource() == 4) {// 合同类审批
					// 组装auditParam参数
					DealBussinessCommonParam dealParam = JSON.parseObject(erpAuditRuntimeUp.getParamJson(), DealBussinessCommonParam.class);
					erpFunDealService.doBussiness(dealParam);
				}
				// 提醒提交人
//				this.addAuditMsg(cityId, erpAuditRuntimeUp, true);
				// 异步消息通知
//				JmsPublisher.sendJmsMessageForAudit(cityId, id, null, 2, 3);
				activeMqPublisher.sendJmsMessageForAudit(cityId, id, null, 2, 10L);

				// 审核通过撤销初审, 合同作废需要发送微信模板消息和短信
				boolean needSend = (erpAuditRuntimeUp.getCaseType() == 101 || erpAuditRuntimeUp.getCaseType() == 102) &&
						(erpAuditRuntimeUp.getAuditType() == 4 || erpAuditRuntimeUp.getAuditType() == 5);

				if (needSend) {
					erpFunContractService.sendMsg(cityId, erpAuditRuntimeUp.getCaseId(), erpAuditRuntimeUp.getAuditType());
				}
			}
		} else {// 审核不通过
			// 审核不通过的把审核中修改为未审核
			DealBussinessCommonParam dealParam = JSON.parseObject(erpAuditRuntimeUp.getParamJson(), DealBussinessCommonParam.class);
			erpFunDealService.doUpdateBussinessStatus(dealParam, 0);

			Set<Integer> idSet = auditUserList.stream().collect(Collectors.mapping(ErpAuditUserRuntime::getId, Collectors.toSet()));
			erpAuditUserRuntimeMapper.updateAuditStatusByIds(cityId, idSet, 5, trackContent, new Date());
			erpAuditRuntimeUp.setAuditStatus((byte) 2);// 未通过
			// 提醒提交人
//			this.addAuditMsg(cityId, erpAuditRuntimeUp, false);
			activeMqPublisher.sendJmsMessageForAudit(cityId, id, null, 3, 10L);
		}
		erpAuditRuntimeMapper.updateByPrimaryKeySelective(erpAuditRuntimeUp);
		// 具有权限自动通过
		if(nextAutoPassUserId != null) {
			auditIsEnd = this.audit(cityId, id, nextAutoPassUserId, (byte) 1, "自动通过", isNewOrg);
		}
		return auditIsEnd;
	}


	/**
	 * @Title 创建合同类审核
	 * @Author lcb
	 * @Time 2019/7/3 15:51
	 * @Desc
	 **/
	public Integer createAuditRuntimeForDeal(ErpAuditRuntime auditRuntime, Integer classId, boolean isFangJidi, boolean isNewOrg) throws Exception {
		Integer cityId = auditRuntime.getShardCityId();
		Integer auditType = auditRuntime.getAuditType();
		Integer userId = auditRuntime.getUserId();
		Byte auditResource = auditRuntime.getAuditResource();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		Assert.isNullThrow(erpFunUsers, "未找到该用户");
		// 用户信息
		auditRuntime.setCompId(erpFunUsers.getCompId());
		auditRuntime.setAreaId(erpFunUsers.getAreaId());
		auditRuntime.setRegId(erpFunUsers.getRegId());
		auditRuntime.setDeptId(erpFunUsers.getDeptId());
		auditRuntime.setGrId(erpFunUsers.getGrId());
		auditRuntime.setUserId(erpFunUsers.getUserId());
		auditRuntime.setArchiveId(erpFunUsers.getArchiveId());
		auditRuntime.setOrganizationPath(erpFunUsers.getTissueLine());//zt组织机构
		// 初始信息
		auditRuntime.setCreationTime(new Date());
		auditRuntime.setLastAuditTime(new Date());
		auditRuntime.setAuditStatus((byte) 0);

		List<ErpAuditUserTemplate> auditUserTemplateList = new LinkedList<>();
		boolean needAudit = true;

		ErpAuditTemplate erpAuditTemplate = null;

		// 表示选择了共享中心审核配置中的一条
		if (isFangJidi && classId != null) {
			ErpAuditClass condition = new ErpAuditClass(cityId, classId);
			ErpAuditClass erpAuditClass = erpAuditClassMapper.selectByPrimaryKey(condition);

			if (erpAuditClass != null) {
				Integer processId = erpAuditClass.getAuditProcessId();

				ErpAuditTemplateExample erpAuditTemplateExample = new ErpAuditTemplateExample();
				erpAuditTemplateExample.setShardCityId(cityId);
				erpAuditTemplateExample.createCriteria().andCompIdEqualTo(erpFunUsers.getCompId()).andAuditProcessIdEqualTo(processId)
						.andAuditResourceEqualTo(auditResource).andAuditTypeEqualTo(auditType).andNeedAuditEqualTo((byte) 1);
				List<ErpAuditTemplate> templates = erpAuditTemplateMapper.selectByExample(erpAuditTemplateExample);
				if (CollectionUtils.isNotEmpty(templates)) {
					erpAuditTemplate = templates.get(0);
				}
			}
		} else {
			erpAuditTemplate = erpAuditTemplateMapper.selectByAuditType(cityId, erpFunUsers.getCompId(), auditResource, auditType, null);
		}

		if(erpAuditTemplate == null || erpAuditTemplate.getNeedAudit() == 0) {
			needAudit = false;// 该类型没配置或指定无需审核则无需审核
		} else {
			auditRuntime.setOverdueAuditTime(erpAuditTemplate.getOverdueAuditTime());

            if (isFangJidi) {
                if (classId == null) {
                    Integer auditProcessId = erpAuditTemplate.getAuditProcessId();
                    if (auditProcessId != null) {
                        erpAuditTemplate = erpAuditTemplateMapper.selectByAuditTypeByClassId(cityId, erpFunUsers.getCompId(), auditResource, auditType, 0, null);
                        auditUserTemplateList = erpAuditUserTemplateMapper.selectByClassId(cityId, erpAuditTemplate.getClassId());
                    }
                } else {
                    auditUserTemplateList = erpAuditUserTemplateMapper.selectByClassId(cityId, classId);
                }
            } else {
                auditUserTemplateList = erpAuditUserTemplateMapper.selectByClassId(cityId, erpAuditTemplate.getClassId());
            }

			if(auditUserTemplateList == null || auditUserTemplateList.isEmpty()) {
				needAudit = false;// 该类型没配置审核人则无需审核
			}

			List<ErpAuditUserTemplate> erpAuditUserTemplateTmp = auditUserTemplateList.stream().filter(val -> 2 == val.getAuditUserType()).collect(Collectors.toList());
			// 根据步骤转成map
			Map<Integer, List<ErpAuditUserTemplate>> seqAuditMapTmp = erpAuditUserTemplateTmp.stream().collect(Collectors.groupingBy(val -> val.getAuditSeq(), Collectors.toList()));
			Set<Integer> seqSet = seqAuditMapTmp.keySet();

			Iterator<Integer> iterator = seqSet.iterator();
			while (iterator.hasNext()) {
				Integer next = iterator.next();
				List<ErpAuditUserTemplate> erpAuditUserTemplates = seqAuditMapTmp.get(next);

				Boolean needConfig = true;
				// 判断模板里面有无角色上无人的情况
				for (ErpAuditUserTemplate erpAuditUserTemplate : erpAuditUserTemplates) {
					// 检查有无员工
					ErpAuditUserRuntime runtimeTmp = new ErpAuditUserRuntime();
					runtimeTmp.setAuditStatus((byte) 0);
					runtimeTmp.setExamineType(erpAuditUserTemplate.getExamineType() == null ? (byte)0 : erpAuditUserTemplate.getExamineType());
					runtimeTmp.setAuditSeq(erpAuditUserTemplate.getAuditSeq());
					runtimeTmp.setAuditUserType(erpAuditUserTemplate.getAuditUserType());
					runtimeTmp.setCreationTime(new Date());
					runtimeTmp.setAuditRoleId(erpAuditUserTemplate.getAuditRoleId());
					runtimeTmp.setAuditUserId(erpAuditUserTemplate.getAuditUserId());
					runtimeTmp.setAuditUserType(erpAuditUserTemplate.getAuditUserType());
					runtimeTmp.setOrganizationDefinitionId(erpAuditUserTemplate.getOrganizationDefinitionId());
					Optional<Integer> nowRange = Optional.of(0);
					List<ErpAuditUserRuntime> auditUserList = null;
					if (isNewOrg) {
						auditUserList = this.createAuditUserForDealAuditNewOrg(runtimeTmp, cityId, userId, nowRange);
					} else {
						auditUserList = this.createAuditUserForDealAudit(runtimeTmp, cityId, userId, nowRange);
					}
					if(auditUserList.size() > 0) {
						needConfig = false;
						break;
					}
				}

				if(needConfig) {
					return 6;
				}
			}

		}
		// 如果无需审核
		if(!needAudit) {
			return 1;// 无需审核
		}
		Integer resultVal = 4;// 创建审核任务成功
		boolean auditUserIsSelf = false;// 第一个审核人是自己
		// 创建相关审核人
		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		List<ErpAuditUserRuntime> nowAuditUserList = new LinkedList<>();
		//Map<Integer, List<ErpAuditUserRuntime>> newUserListMap = new HashMap<>();
		//Optional<Integer> minRange = Optional.of(0);
		for (int i = 0; i < auditUserTemplateList.size(); i++) {
			ErpAuditUserTemplate template = auditUserTemplateList.get(i);
			ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
			runtime.setAuditStatus((byte) 0);
			runtime.setExamineType(template.getExamineType() == null ? (byte)0 : template.getExamineType());
			runtime.setAuditSeq(template.getAuditSeq());
			runtime.setAuditUserType(template.getAuditUserType());
			runtime.setCreationTime(new Date());
			runtime.setAuditRoleId(template.getAuditRoleId());
			runtime.setAuditUserId(template.getAuditUserId());
			runtime.setOrganizationDefinitionId(template.getOrganizationDefinitionId());
			// 第一个就是角色审核，生成该角色所有人
			if(template.getAuditSeq() == 1) {
				Optional<Integer> nowRange = Optional.of(0);
				List<ErpAuditUserRuntime> auditUserList = null;
				if (isNewOrg) {
					auditUserList = this.createAuditUserForDealAuditNewOrg(runtime, cityId, userId, nowRange);
				} else {
					auditUserList = this.createAuditUserForDealAudit(runtime, cityId, userId, nowRange);
				}
				if(auditUserList.isEmpty()) {
					runtime.setAuditStatus((byte) 1);
					auditUserRuntimeList.add(runtime);
					nowAuditUserList.add(runtime);
					//listTemp.add(runtime);
				} else {
					resultVal = 3;// 创建成功且第一个环节有审核人
					// 第一个改为待审核
					for (ErpAuditUserRuntime erpAuditUserRuntime : auditUserList) {
						erpAuditUserRuntime.setAuditStatus((byte) 1);
						if(!auditUserIsSelf && userId.equals(erpAuditUserRuntime.getAuditUserId())) {
							auditUserIsSelf = true;
						}
					}
					auditUserRuntimeList.addAll(auditUserList);
					nowAuditUserList.addAll(auditUserList);
				}

			} else {
				auditUserRuntimeList.add(runtime);
			}
		}

		// 当前审核人信息
		String nowAuditInfo = this.getNowAuditInfo(cityId, auditRuntime.getCompId(), nowAuditUserList);
		auditRuntime.setNowAuditInfo(nowAuditInfo);
		auditRuntime.setIsShareAudit(classId == null ? (byte) 0 : (byte) 1);

		erpAuditRuntimeMapper.insertSelective(auditRuntime);
		// 设置审核ID
		for (ErpAuditUserRuntime runtime : auditUserRuntimeList) {
			runtime.setAuditId(auditRuntime.getId());
		}
		// ---分批次插入---
		List<ErpAuditUserRuntime> tempUserList = new LinkedList<>();
		for (ErpAuditUserRuntime erpAuditUserRuntime : auditUserRuntimeList) {
			tempUserList.add(erpAuditUserRuntime);
			// 插入再清空，再来(150插入一次，最多支持2000/150=13个字段，字段增加要调整这个值)
			if(tempUserList.size() >= 150) {
				erpAuditUserRuntimeMapper.insertList(cityId, tempUserList);
				tempUserList.clear();
			}
		}
		// 里面剩下没插入的在插入一次
		if(tempUserList.size() > 0) {
			erpAuditUserRuntimeMapper.insertList(cityId, tempUserList);
		}

		// 第一个审核人是自己则自动通过
		if(auditUserIsSelf) {
			boolean auditIsEnd = this.audit(cityId, auditRuntime.getId(), userId, (byte) 1, "自动通过",isNewOrg);
			if(auditIsEnd) {
				return 2;// 审核已全部通过且处理完成
			}
		} else {// 提醒审核人
			activeMqPublisher.sendJmsMessageForAudit(cityId, auditRuntime.getId(), 1, 1, 5L);
		}

		if(3 == resultVal ||  4 == resultVal) {
			DealBussinessCommonParam dealParam = JSON.parseObject(auditRuntime.getParamJson(), DealBussinessCommonParam.class);
			erpFunDealService.doUpdateBussinessStatus(dealParam, 1);
		}
		return resultVal;
	}

	/**
	 * 创建合同审核的审核人实例
	 * @author 张宏利
	 * @since 2017年11月8日
	 * @param template
	 */
	public List<ErpAuditUserRuntime> createAuditUserForDealAudit(ErpAuditUserRuntime template, Integer cityId, Integer createAuditUserId, Optional<Integer> nowRange) {
		Byte examineType = template.getExamineType();
		Integer auditSeq = template.getAuditSeq();
		Integer auditUserType = template.getAuditUserType();
		Integer auditUserId = template.getAuditUserId();
		String auditRoleId = template.getAuditRoleId();
		Integer auditId = template.getAuditId();

		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
		// 初始
		runtime.setAuditStatus((byte) 0);
		runtime.setAuditId(auditId);
		runtime.setExamineType(examineType == null ? (byte)0 : examineType);
		runtime.setAuditSeq(auditSeq);
		runtime.setAuditUserType(auditUserType);
		runtime.setCreationTime(new Date());
		if(auditUserType == 1) {// 1=指定员工审核
			runtime.setAuditUserId(auditUserId);
			auditUserRuntimeList.add(runtime);
		} else {
			List<Integer> userList = new LinkedList<>();
			if(auditUserType == 2) {// 2=申请方
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, erpFunUsers.getCompId(), auditRoleId);
				// 角色没有管理层级，找管理的上一层级
				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
					userList = erpFunUsersService.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId(), nowRange);
				} else {
					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
				}
			}
//			else if(auditUserType == 3) {// 3=房客源所属方
//				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, null, null);
//				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, caseInfo.get("compId"), auditRoleId);
//				// 角色没有管理层级，找管理的上一层级
//				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
//					userList = erpFunUsersService.getManageUserByUp(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"), nowRange);
//				} else {
//					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
//				}
//			} else if(auditUserType == 5) {// 5=直接上级
//				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
//				Integer userIdNow = erpFunUserManageRangeMapper.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
//				if(userIdNow != null) {
//					userList.add(userIdNow);
//				}
//				// 系统参数无需审核到需要审核时，该类型的审核人默认改成6（隐藏逻辑）
//			} else if(auditUserType == 6) {// 6=信息归属方有权限的人
//				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, null, null);
//				if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
//						|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
//						|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
//						|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
//					userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
//				} else {
//					userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
//				}
//			}

			if(userList != null && !userList.isEmpty()) {
				// 批量生成一个环节的所有人
				Set<Integer> userIdSet = new HashSet<>(userList);
				for (Integer userId : userIdSet) {
					if(auditUserRuntimeList.size() >= 1500) {
						break;// 超过2000会插入失败，也没必要那么多人来审批
					}
					ErpAuditUserRuntime runtimeTmp = new ErpAuditUserRuntime();
					runtimeTmp.setAuditStatus((byte) 0);
					runtimeTmp.setCreationTime(new Date());
					runtimeTmp.setAuditId(auditId);
					runtimeTmp.setExamineType(examineType == null ? (byte)0 : examineType);
					runtimeTmp.setAuditSeq(auditSeq);
					runtimeTmp.setAuditUserType(auditUserType);
					runtimeTmp.setAuditUserId(userId);
					runtimeTmp.setAuditRoleId(auditRoleId);
					auditUserRuntimeList.add(runtimeTmp);
				}
			}
		}
		return auditUserRuntimeList;
	}
	/**
	 * 创建合同审核的审核人实例
	 * @author 张宏利
	 * @since 2017年11月8日
	 * @param template
	 */
	public List<ErpAuditUserRuntime> createAuditUserForDealAuditNewOrg(ErpAuditUserRuntime template, Integer cityId, Integer createAuditUserId, Optional<Integer> nowRange) {
		Byte examineType = template.getExamineType();
		Integer auditSeq = template.getAuditSeq();
		Integer auditUserType = template.getAuditUserType();
		Integer auditUserId = template.getAuditUserId();
		String auditRoleId = template.getAuditRoleId();
		Integer auditId = template.getAuditId();
		Integer auditOrgDefId = template.getOrganizationDefinitionId();
		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
		ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
		// 初始
		runtime.setAuditStatus((byte) 0);
		runtime.setAuditId(auditId);
		runtime.setExamineType(examineType == null ? (byte)0 : examineType);
		runtime.setAuditSeq(auditSeq);
		runtime.setAuditUserType(auditUserType);
		runtime.setCreationTime(new Date());
		if(auditUserType == 1) {// 1=指定员工审核
			runtime.setAuditUserId(auditUserId);
			auditUserRuntimeList.add(runtime);
		} else {
			List<Integer> userList = new LinkedList<>();
			if (auditUserType == 2) {// 2=申请方
				if (auditOrgDefId!=null && auditOrgDefId>0) {
					userList = findOneLevelBeforeUsers(cityId, erpFunUsers.getCompId(), auditOrgDefId, erpFunUsers.getTissueLine());
				} else {
					userList = findOneLevelBeforeUsersOffMangeRange(cityId, erpFunUsers.getCompId(), erpFunUsers.getTissueLine(),auditRoleId);
				}
			}
//			else if(auditUserType == 3) {// 3=房客源所属方
//				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, null, null);
//				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, caseInfo.get("compId"), auditRoleId);
//				// 角色没有管理层级，找管理的上一层级
//				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
//					userList = erpFunUsersService.getManageUserByUp(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"), nowRange);
//				} else {
//					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
//				}
//			} else if(auditUserType == 5) {// 5=直接上级
//				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
//				Integer userIdNow = erpFunUserManageRangeMapper.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
//				if(userIdNow != null) {
//					userList.add(userIdNow);
//				}
//				// 系统参数无需审核到需要审核时，该类型的审核人默认改成6（隐藏逻辑）
//			} else if(auditUserType == 6) {// 6=信息归属方有权限的人
//				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, null, null);
//				if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
//						|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
//						|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
//						|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
//					userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
//				} else {
//					userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
//				}
//			}
			
			if(userList != null && !userList.isEmpty()) {
				// 批量生成一个环节的所有人
				Set<Integer> userIdSet = new HashSet<>(userList);
				for (Integer userId : userIdSet) {
					if(auditUserRuntimeList.size() >= 1500) {
						break;// 超过2000会插入失败，也没必要那么多人来审批
					}
					ErpAuditUserRuntime runtimeTmp = new ErpAuditUserRuntime();
					runtimeTmp.setAuditStatus((byte) 0);
					runtimeTmp.setCreationTime(new Date());
					runtimeTmp.setAuditId(auditId);
					runtimeTmp.setExamineType(examineType == null ? (byte)0 : examineType);
					runtimeTmp.setAuditSeq(auditSeq);
					runtimeTmp.setAuditUserType(auditUserType);
					runtimeTmp.setAuditUserId(userId);
					runtimeTmp.setAuditRoleId(auditRoleId);
					runtimeTmp.setOrganizationDefinitionId(auditOrgDefId);
					auditUserRuntimeList.add(runtimeTmp);
				}
			}
		}
		return auditUserRuntimeList;
	}
	
	public List<ErpAuditUserRuntime> createAuditUserNewOrg(Byte auditType, ErpAuditUserRuntime template, Integer cityId, Integer caseId, Integer caseType, 
			Integer createAuditUserId, Integer keyDeptId, Optional<Integer> nowRange) {
		Byte examineType = template.getExamineType();
		Integer auditSeq = template.getAuditSeq();
		Integer auditUserType = template.getAuditUserType();
		Integer auditUserId = template.getAuditUserId();
		String auditRoleId = template.getAuditRoleId();
		Integer auditId = template.getAuditId();
		Integer auditOrgDefId = template.getOrganizationDefinitionId();
		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
		// 初始
		runtime.setAuditStatus((byte) 0);
		runtime.setAuditId(auditId);
		runtime.setExamineType(examineType == null ? (byte)0 : examineType);
		runtime.setAuditSeq(auditSeq);
		runtime.setAuditUserType(auditUserType);
		runtime.setCreationTime(new Date());
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
		if(auditUserType == 1) {// 1=指定员工审核
			runtime.setAuditUserId(auditUserId);
			auditUserRuntimeList.add(runtime);
		} else {
			List<Integer> userList = new LinkedList<>();
			if (auditUserType == 2) {// 2=申请方
				if (auditOrgDefId!=null && auditOrgDefId>0) {
					userList = findOneLevelBeforeUsers(cityId, erpFunUsers.getCompId(), auditOrgDefId, erpFunUsers.getTissueLine());
				} else {
					userList = findOneLevelBeforeUsersOffMangeRange(cityId, erpFunUsers.getCompId(), erpFunUsers.getTissueLine(),auditRoleId);
				}
			} else if(auditUserType == 3) {// 3=房客源所属方
				String orgPath = erpFunTrackService.getCaseOrgPath(cityId, caseId, caseType);
				if (auditOrgDefId!=null && auditOrgDefId>0) {
					userList = findOneLevelBeforeUsers(cityId, erpFunUsers.getCompId(), auditOrgDefId, orgPath);
				} else {
					userList = findOneLevelBeforeUsersOffMangeRange(cityId, erpFunUsers.getCompId(), orgPath,auditRoleId);
				}
			} else if(auditUserType == 4) {// 4=钥匙所在门店
				ErpFunOrganization orgInfo = erpFunOrganizationMapper.selectOrgByOrgId(cityId, erpFunUsers.getCompId(), keyDeptId);
				if (auditOrgDefId!=null && auditOrgDefId>0) {
					userList = findOneLevelBeforeUsers(cityId, erpFunUsers.getCompId(), auditOrgDefId, orgInfo.getOrganizationPath());
				} else {
					userList = findOneLevelBeforeUsersOffMangeRange(cityId, erpFunUsers.getCompId(), orgInfo.getOrganizationPath(),auditRoleId);
				}
			} 
			if(userList != null && !userList.isEmpty()) {
				// 批量生成一个环节的所有人
				Set<Integer> userIdSet = new HashSet<>(userList);
				for (Integer userId : userIdSet) {
					if(auditUserRuntimeList.size() >= 1500) {
						break;// 超过2000会插入失败，也没必要那么多人来审批
					}
					ErpAuditUserRuntime runtimeTmp = new ErpAuditUserRuntime();
					runtimeTmp.setAuditStatus((byte) 0);
					runtimeTmp.setCreationTime(new Date());
					runtimeTmp.setAuditId(auditId);
					runtimeTmp.setExamineType(examineType == null ? (byte)0 : examineType);
					runtimeTmp.setAuditSeq(auditSeq);
					runtimeTmp.setAuditUserType(auditUserType);
					runtimeTmp.setAuditUserId(userId);
					runtimeTmp.setAuditRoleId(auditRoleId);
					runtimeTmp.setOrganizationDefinitionId(auditOrgDefId);
					auditUserRuntimeList.add(runtimeTmp);
				}
			}
		}
		return auditUserRuntimeList;
	}

	/**
	 * @Title 合同类通用创建审批
	 * @Author lcb
	 * @Time 2019/7/3 19:14
	 * @Desc
	 **/
	@Override
	public Integer commonCreateDealAudit(DealAuditCommonParam param) throws Exception{
		GeneralParam generalParam = param.getGeneralParam();
		Integer classId = param.getClassId();
		boolean isFangJidi = param.isFangJidi();

		Integer isMobileApi = param.getIsMobileApi();
		boolean isFromMobile = (isMobileApi != null && isMobileApi == 1);

		ErpFunDeal erpFunDeal = new ErpFunDeal();
		erpFunDeal.setDealId(param.getDealId());
		erpFunDeal.setShardCityId(generalParam.getCityId());
		erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDeal);

		if(null != erpFunDeal && 0 == erpFunDeal.getDealAuditStatus().intValue()
				&& null != param.getAuditType() && 4 == param.getAuditType()){
			return 1;
		}

		Integer needRefesh = erpFunDealService.doCheckBussinessStatus(param, erpFunDeal);
		if(null != needRefesh && 1 == needRefesh) {
			return 5;
		}
		param.setContractNo(erpFunDeal.getContractNo());

		ErpAuditRuntime auditRuntime = new ErpAuditRuntime();
		// 初始信息
		auditRuntime.setShardCityId(generalParam.getCityId());
		auditRuntime.setUserId(generalParam.getUserId());
		auditRuntime.setAuditResource((byte) 4);
		// 信息来源，app还是erp
		auditRuntime.setAuditFrom(isFromMobile ? (byte) 1 : 0);
		// 审核信息
		auditRuntime.setCaseId(param.getDealId());
		auditRuntime.setCaseType(erpFunDeal.getDealType().intValue());
		auditRuntime.setCaseNo(erpFunDeal.getContractNo());
		auditRuntime.setAuditType(param.getAuditType());
		auditRuntime.setParamJson(JSON.toJSONString(param));
		auditRuntime.setAuditType(param.getAuditType());
		auditRuntime.setTargetNo(param.getContractNo());
		String auditExplain = this.getDealAuditExplain(param);
		auditRuntime.setAuditExplain(auditExplain);
		// 业务相关
		Integer result = this.createAuditRuntimeForDeal(auditRuntime, classId, isFangJidi, generalParam.isNewOrg());

		// 1=无需审核，2=已全部通过且处理完成
		if (result != 1 && result != 2) {
			// 写申请跟进 暂时不定

		}
		param.setId(auditRuntime.getId());
		return result;
	}


	private String getDealAuditExplain(DealAuditCommonParam param) {
		String auditExplain = "";
		String userName = param.getGeneralParam().getUserName();
		String contractNo = param.getContractNo();
		Integer auditType = param.getAuditType();

		if(1 == auditType) {
			// 初审
//			dealFirstAudit();
			auditExplain = userName + "申请为合同 "+contractNo +" 进行合同初审";
		}else if(2 == auditType) {
			//复审
//			dealReviewAudit();
			auditExplain = userName + "申请为合同 "+contractNo +" 进行合同复审";
		}else if(3 == auditType) {
//			dealSettle();
			auditExplain = userName + "申请为合同 "+contractNo +" 进行合同结算";
		}else if(4 == auditType) {
			//合同作废
//			dealObsolete();
			auditExplain = userName + "申请为合同 "+contractNo +" 进行合同作废";
		}else if(5 == auditType) {
			//撤销初审
//			cancleDealFirstAudit();
			auditExplain = userName + "申请为合同 "+contractNo +" 撤销合同初审";
		}else if(6 == auditType) {
			//撤销复审
//			cancleDealReviewAudit();
			auditExplain = userName + "申请为合同 "+contractNo +" 撤销合同复审";
		}else if(7 == auditType) {
			//撤销结算
			auditExplain = userName + "申请为合同 "+contractNo +" 撤销合同结算";
//			cancleDealSettle();
		}else if(8 == auditType) {
			//应收
			auditExplain = userName + "申请为合同 "+contractNo +" 进行应收应付审核";
		}else if(9 == auditType) {
			//实收
			auditExplain = userName + "申请为合同 "+contractNo +" 进行实收实付审核";
		}else if(10 == auditType) {
			//撤销应收审核
			auditExplain = userName + "申请为合同 "+contractNo +" 撤销应收应付审核";
		}else if(11 == auditType) {
			//撤销实收审核
			auditExplain = userName + "申请为合同 "+contractNo +" 撤销实收实付审核";
		}

		return auditExplain;

	}

	public static void main(String[] args) {
		ProcessFinancStatusParam pp = new ProcessFinancStatusParam();
		pp.setAuditStatus(1);
		pp.setDealId(123);
		pp.setIsMobileApi(1);
		pp.setPfActual(2);
		pp.setPfIds("1,2");
		DealAuditCommonParam param = new DealAuditCommonParam();
		param.setProcessFinancStatusParam(pp);
		GeneralParam gp = new GeneralParam();
		gp.setCompId(10213);
		gp.setCurrDeptUserName("哈哈");

		param.setGeneralParam(gp);

		String json = JSON.toJSONString(param);

		DealBussinessCommonParam dealBussinessCommonParam = JSON.parseObject(json, DealBussinessCommonParam.class);

		System.out.println(dealBussinessCommonParam.getAuditType());
		System.out.println(dealBussinessCommonParam.getGeneralParam().getCompId());
		System.out.println(dealBussinessCommonParam.getProcessFinancStatusParam().getPfIds());


	}

	/**
	 * @title
	 * @author Lee
	 * @date 2019/12/6 20:04
	 ***/
	@Override
	public void createAuditUserForUserChangeNoTransactionalNewOrg(Integer cityId, Integer compId, String roleId, Integer userId) {
		// 删除老的所有的审批范围，userId改为空
		erpAuditUserRuntimeMapper.deleteAllAuditByUser(cityId, compId, userId);
		// 查询需要处理的列表
		List<ErpAuditUserRuntimeDto> needProcessUserList = erpAuditUserRuntimeMapper.getAuditUserByRole(cityId, compId, roleId);
		if(needProcessUserList.isEmpty()) {
			return;
		}

		Map<Integer, List<ErpAuditUserRuntimeDto>> userListMap = needProcessUserList.stream().collect(Collectors.groupingBy(val -> val.getAuditId()));
		for (List<ErpAuditUserRuntimeDto> userRuntimeList : userListMap.values()) {
			Set<String> dealAuditIds = new HashSet<>();
			List<ErpAuditUserRuntime> newUserListInsert = new LinkedList<>();
			for (ErpAuditUserRuntimeDto userRuntime : userRuntimeList) {
				// 保证角色唯一性
				String auditKey = userRuntime.getAuditId() + "_" + userRuntime.getAuditUserType() + "_" + userRuntime.getAuditRoleId();
				if(dealAuditIds.contains(auditKey)) {
					continue;
				}
				dealAuditIds.add(auditKey);
				Optional<Integer> nowRange = Optional.of(0);
				List<ErpAuditUserRuntime> newUserList = this.createAuditUserNoTransactionalNewOrg(userRuntime.getAuditType().byteValue(),
						userRuntime, cityId, userRuntime.getCaseId(), userRuntime.getCaseType(), userRuntime.getUserId(),
						userRuntime.getKeyDeptId(), nowRange);
				if(newUserList == null || newUserList.isEmpty()) {
					userRuntime.setAuditUserId(null);
					newUserList.add(userRuntime);
				}
				// 改为审核中
				for (ErpAuditUserRuntime userRuntimeNew : newUserList) {
					userRuntimeNew.setAuditStatus((byte)1);
				}
				newUserListInsert.addAll(newUserList);
			}
			// 审批人中没有自己则不用重新生成
			Set<Integer> auditUserIdSet = newUserListInsert.stream().filter(val -> val.getAuditUserId() != null)
					.collect(Collectors.mapping(ErpAuditUserRuntime::getAuditUserId, Collectors.toSet()));
			if(!auditUserIdSet.contains(userId)) {
				continue;
			}
			// 删除当前seq所有的人
			ErpAuditUserRuntimeExample example = new ErpAuditUserRuntimeExample();
			example.setShardCityId(cityId);
			example.createCriteria().andAuditIdEqualTo(userRuntimeList.get(0).getAuditId())
					.andAuditSeqEqualTo(userRuntimeList.get(0).getAuditSeq()).andAuditStatusEqualTo((byte)1);
			erpAuditUserRuntimeMapper.deleteByExample(example);
			// 再重新插入
			if (newUserListInsert.size() > 0) {
				for (int i = 0,baseCount = 100,lengh = newUserListInsert.size(); i < lengh; i += baseCount) {
					List<ErpAuditUserRuntime> current = newUserListInsert.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						erpAuditUserRuntimeMapper.insertList(cityId, current);
					}
				}
			}
		}
	}

	/**
	 * @title 新版组织创建审批
	 * @author Lee
	 * @date 2019/12/6 20:10
	 ***/
	public List<ErpAuditUserRuntime> createAuditUserNoTransactionalNewOrg(Byte auditType, ErpAuditUserRuntime template, Integer cityId, Integer caseId, Integer caseType,
																	Integer createAuditUserId, Integer keyDeptId, Optional<Integer> nowRange) {
		Byte examineType = template.getExamineType();
		Integer auditSeq = template.getAuditSeq();
		Integer auditUserType = template.getAuditUserType();
		Integer auditUserId = template.getAuditUserId();
		String auditRoleId = template.getAuditRoleId();
		Integer auditId = template.getAuditId();

		List<ErpAuditUserRuntime> auditUserRuntimeList = new LinkedList<>();
		ErpAuditUserRuntime runtime = new ErpAuditUserRuntime();
		// 初始
		runtime.setAuditStatus((byte) 0);
		runtime.setAuditId(auditId);
		runtime.setExamineType(examineType == null ? (byte)0 : examineType);
		runtime.setAuditSeq(auditSeq);
		runtime.setAuditUserType(auditUserType);
		runtime.setCreationTime(new Date());
		if(auditUserType == 1) {// 1=指定员工审核
			runtime.setAuditUserId(auditUserId);
			auditUserRuntimeList.add(runtime);
		} else {

			List<Integer> userList = new LinkedList<>();
			if(auditUserType == 2) {// 2=申请方
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, erpFunUsers.getCompId(), auditRoleId);
				// 角色没有管理层级，找管理的上一层级
				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
					userList = erpFunUsersService.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId(), nowRange);
				} else {
					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
				}
			} else if(auditUserType == 3) {// 3=房客源所属方
				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, caseId, caseType);
				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, caseInfo.get("compId"), auditRoleId);
				// 角色没有管理层级，找管理的上一层级
				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
					userList = erpFunUsersService.getManageUserByUp(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"), nowRange);
				} else {
					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, caseInfo.get("compId"), auditRoleId, caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
				}
			} else if (auditUserType == 4) {// 4=钥匙所在门店
				ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
				if (erpFunDepts == null) {
					throw new ConfirmException("获取钥匙所在门店失败");
				}
				ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, erpFunDepts.getCompId(), auditRoleId);
				// 角色没有管理层级，找管理的上一层级
				if(erpCompRoles != null && (erpCompRoles.getManageLevel() <= 0 || erpCompRoles.getManageLevel() == 6)) {
					userList = erpFunUsersService.getManageUserByUp(cityId, erpFunDepts.getCompId(), auditRoleId, erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null, nowRange);
				} else {
					userList = erpFunUserManageRangeMapper.getManageUserList(cityId, erpFunDepts.getCompId(), auditRoleId, erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
				}
			} else if(auditUserType == 5) {// 5=直接上级
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, createAuditUserId);
				Integer userIdNow = erpFunUserManageRangeMapper.getManageUserByUp(cityId, erpFunUsers.getCompId(), auditRoleId, erpFunUsers.getAreaId(), erpFunUsers.getRegId(), erpFunUsers.getDeptId(), erpFunUsers.getGrId());
				if(userIdNow != null) {
					userList.add(userIdNow);
				}
				// 系统参数无需审核到需要审核时，该类型的审核人默认改成6（隐藏逻辑）
			} else if(auditUserType == 6) {// 6=信息归属方有权限的人
				Map<String, Integer> caseInfo = erpFunTrackService.getCaseInfo(cityId, caseId, caseType);
				if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
					userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
				} else {
					userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, caseInfo.get("compId"), caseInfo.get("areaId"), caseInfo.get("regId"), caseInfo.get("deptId"), caseInfo.get("grId"));
				}
			} else if(auditUserType == 7) {// 7=钥匙归属方有权限的人（暂时没用上）
				ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
				if(Const.DIC_TRACK_TYPE_BORROW_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(auditType)
						|| Const.DIC_TRACK_TYPE_RETURN_KEY.equals(auditType)) {
					userList = erpFunUsersService.getHaveAuditUserListForKey(cityId, erpFunDepts.getCompId(), erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
				} else {
					userList = erpFunUsersService.getHaveAuditUserListForExamin(cityId, erpFunDepts.getCompId(), erpFunDepts.getAreaId(), erpFunDepts.getRegId(), erpFunDepts.getDeptId(), null);
				}
			}

			if(userList != null && !userList.isEmpty()) {
				// 批量生成一个环节的所有人
				Set<Integer> userIdSet = new HashSet<>(userList);
				for (Integer userId : userIdSet) {
					if(auditUserRuntimeList.size() >= 1500) {
						break;// 超过2000会插入失败，也没必要那么多人来审批
					}
					ErpAuditUserRuntime runtimeTmp = new ErpAuditUserRuntime();
					runtimeTmp.setAuditStatus((byte) 0);
					runtimeTmp.setCreationTime(new Date());
					runtimeTmp.setAuditId(auditId);
					runtimeTmp.setExamineType(examineType == null ? (byte)0 : examineType);
					runtimeTmp.setAuditSeq(auditSeq);
					runtimeTmp.setAuditUserType(auditUserType);
					runtimeTmp.setAuditUserId(userId);
					runtimeTmp.setAuditRoleId(auditRoleId);
					auditUserRuntimeList.add(runtimeTmp);
				}
			}
		}
		return auditUserRuntimeList;
	}
	
	/**
	 * 
	 * @param cityId
	 * @param auditOrgDefId
	 * @param erpFunUsers
	 * @param userList
	 */
	private List<Integer> findOneLevelBeforeUsers(Integer cityId, Integer compId, Integer auditOrgDefId,String orgPath) {
		Integer orgDefinitionLevel = erpFunOrganizationDefinitionMapper.getOrgDefinitionIdDescSeq(cityId, compId, auditOrgDefId);
		String[] orgIdArr = orgPath.split(":");
		List<Integer> dealOrgList = new ArrayList<>();
		for (String orgIdStr:orgIdArr) {
			if (StringUtils.isNotBlank(orgIdStr)) {
				dealOrgList.add(StringUtil.parseInteger(orgIdStr, 0));
			}
		}
		List<ErpFunUsers> userPoList = erpFunUsersMapper.selectUserByOrgDefinitionLevel(cityId, compId, dealOrgList, orgDefinitionLevel);
		Map<Integer,List<ErpFunUsers>> usersMap = userPoList.stream().collect(Collectors.groupingBy(ErpFunUsers::getUserLevel));
		if (usersMap!=null) {
			if (!userPoList.isEmpty()) {
				List<ErpFunUsers> userLevelList = usersMap.get(userPoList.get(0).getUserLevel());
				if (userLevelList!=null && !userLevelList.isEmpty()) {
					return userLevelList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
				}
			}
		}
		return new ArrayList<>();
	}
	
	/**
	 * 根据
	 * @param cityId
	 * @param auditOrgDefId
	 * @param orgPath
	 * @param userList
	 */
	private List<Integer> findOneLevelBeforeUsersOffMangeRange(Integer cityId, Integer compId, String orgPath, String userRole) {
		String[] orgIdArr = orgPath.split(":");
		List<Integer> dealOrgList = new ArrayList<>();
		for (String orgIdStr:orgIdArr) {
			if (StringUtils.isNotBlank(orgIdStr)) {
				dealOrgList.add(StringUtil.parseInteger(orgIdStr, 0));
			}
		}
		List<ErpFunUsers> userPoList = erpFunUsersMapper.selectUserByOrgDefinitionLevelAndMangeRange(cityId, compId, dealOrgList, userRole);
		Map<Integer,List<ErpFunUsers>> usersMap = userPoList.stream().collect(Collectors.groupingBy(ErpFunUsers::getUserLevel));
		if (usersMap!=null && !userPoList.isEmpty()) {
			Integer orgDefinitionLevel = userPoList.get(0).getUserLevel();
			while (orgDefinitionLevel>=0  && !userPoList.isEmpty()) {
				List<ErpFunUsers> userLevelList = usersMap.get(orgDefinitionLevel);
				if (userLevelList!=null && !userLevelList.isEmpty()) {
					return userLevelList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
				} 
				orgDefinitionLevel--;
			}
		}
		return new ArrayList<>();
	}
	
	/**
	 * 需求 http://172.16.140.91/zentaopms/www/index.php?m=story&f=view&storyID=9455
	 * @see #getNowAuditInfo(Integer, Integer, List)
	 * @param cityId
	 * @param compId
	 * @param newUserList
	 * @param prefix
	 * @param suffix
	 * @author guohao
	 * @return
	 */

	public String getNowAuditInfoV2(Integer cityId, Integer compId, List<ErpAuditUserRuntime> newUserList,
	                                 String prefix, String suffix) {
		if (CollectionUtils.isEmpty(newUserList)) {
			return prefix + suffix;
		}
		// 现在需要审核所有的人具体信息
		String auditStr;
		Integer auditUserType = newUserList.get(0).getAuditUserType();
		if (auditUserType == 1 || auditUserType == 6 || auditUserType == 7 || (newUserList.get(0).getAuditUserId()!=null && newUserList.get(0).getAuditUserId()>0)) { //指定人员
			auditStr =joinUserName(cityId, newUserList, 3, "", "");
		} else {
			Map<String, List<ErpAuditUserRuntime>> auditMapByRole = newUserList.stream()
					.collect(Collectors.groupingBy(ErpAuditUserRuntime::getAuditRoleId));
			StringJoiner roleJoiner = new StringJoiner(";");
			for (Map.Entry<String, List<ErpAuditUserRuntime>> roleUsers : auditMapByRole.entrySet()) {
				String key = roleUsers.getKey();
				ErpCompRoles compRoles = erpCompRolesMapper.getByRoleId(cityId, compId, key);
				String roleName = compRoles.getRoleName();
				List<ErpAuditUserRuntime> auditUsers = roleUsers.getValue();
				String perRoleUser = joinUserName(cityId, auditUsers, 3, "(", ")");
				roleJoiner.add(roleName + perRoleUser);
			}
			auditStr = roleJoiner.toString();
		}
		return prefix + auditStr + suffix;
	}

	private String joinUserName(Integer cityId, List<ErpAuditUserRuntime> newUserList, int maxCount, String prefix, String suffix) {
		if (CollectionUtils.isEmpty(newUserList)) {
			return "";
		}
		Set<Integer> useIdSet = new HashSet<>();
		for (ErpAuditUserRuntime e : newUserList) {
			Integer auditUserId = e.getAuditUserId();
			useIdSet.add(auditUserId);
			if (useIdSet.size() == maxCount) break;
		}
		List<ErpFunUsers> userListByUserIds = erpFunUsersService.getUserListByUserIds(cityId, useIdSet);
		StringJoiner stringJoiner = new StringJoiner("、");
		for (ErpFunUsers user : userListByUserIds) {
			stringJoiner.add(user.getUserName());
		}
		int userSize = newUserList.size();
		String result = stringJoiner.toString();
		if (StringUtil.isEmpty(result)) {
			return "";
		}
		if (userSize > 3) {
			result += "等";
		}
		return prefix+ result + suffix;
	}
	
}



