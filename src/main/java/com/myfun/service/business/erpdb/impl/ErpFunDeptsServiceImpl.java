package com.myfun.service.business.erpdb.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.alibaba.fastjson.JSON;
import com.extension.framework.mq.context.MqUtil;
import com.myfun.repository.admindb.dao.AdminCrmTrackMapper;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.jms.bean.UpdateFunUserMessage;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.managecenter.sysmanager.param.FunDeptsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewDeptParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminPropertyBuildMapMapper;
import com.myfun.repository.erpdb.dao.ErpCompRolesMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunEcardsMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunLogsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegionMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSalaryTypeRelativeMapper;
import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunLogs;
import com.myfun.repository.erpdb.po.ErpFunReg;
import com.myfun.repository.erpdb.po.ErpFunRegion;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.erpdb.po.ErpSalaryTypeRelative;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.service.business.AbstractService;
import com.myfun.utils.Assert;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil;

@Service
public class ErpFunDeptsServiceImpl extends AbstractService<ErpFunDepts, ErpFunDepts>implements ErpFunDeptsService {
	Logger logger = LoggerFactory.getLogger(ErpFunDeptsServiceImpl.class);
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpUserOpersService erpUserOpersService;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpFunRegionMapper erpFunRegionMapper;
	@Autowired
	private ErpFunRegMapper erpFunRegMapper;
	@Autowired
	private ErpFunLogsMapper erpFunLogsMapper;
	@Autowired
	private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	private ErpFunEmployeeLogService erpFunEmployeeLogService;
	@Autowired
	private ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	MqUtil mqUtil;
	@Autowired
	private AdminPropertyBuildMapMapper adminPropertyBuildMapMapper;
	@Autowired
	ErpFunWageService erpFunWageService;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	AdminCrmTrackMapper adminCrmTrackMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunDeptsMapper;
	}

	@Override
	public int count(Integer cityId, String compNo, String deptNo) {
		return erpFunDeptsMapper.count(cityId, compNo, deptNo);
	}

	@Override
	public ErpFunDepts queryDept(Integer archiveId) {
		return erpFunDeptsMapper.queryDept(archiveId);
	}

	//*****获取门店列表
	@Override
	public List<ErpFunDeptsDto> getDeptsList(Integer cityId, Integer regId) {
		// 查询数量
//		Integer res = erpFunUsersMapper.getAgentNum(cityId);
		List<ErpFunDeptsDto> resList = erpFunDeptsMapper.getFunDeptsList(cityId, regId);
		return resList;
	}

	@Override
	public List<ErpFunDepts> getDeptListByRange(Integer cityId, ErpFunDepts conditon) {
		return erpFunDeptsMapper.getDeptListByRange(cityId, conditon);
	}

	/**
	 * @TODO 门店列表
	 * @author lcb
	 * @2016-10-20 下午2:28:18
	 */
	@Override
	public List<ErpFunDeptsDto> getDeptListByReg(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		Integer compId = Integer.valueOf(pMap.get("compId") + "");
		Integer regId = Integer.valueOf(pMap.get("regId") + "");
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setCompId(compId);
		if(null != regId) {
			erpFunDepts.setRegId(regId);
		}
		erpFunDepts.setShardCityId(param.getInteger("cityId"));
		List<ErpFunDepts> tempList= erpFunDeptsMapper.getDeptListByCompId(erpFunDepts);
		
		List<ErpFunDeptsDto> list = new ArrayList<ErpFunDeptsDto>(tempList.size());
		ErpFunDeptsDto vo = new ErpFunDeptsDto();
		for (ErpFunDepts temp : tempList) {
			ErpFunReg pReg = new ErpFunReg();
			pReg.setRegId(temp.getRegionId());
			pReg.setShardCityId(param.getInteger("cityId"));
			ErpFunReg regPO = erpFunRegMapper.selectByPrimaryKey(pReg);
			Map<String, Object> beanMap = BeanUtilsHelper.bean2Map(temp);
			if(regPO==null){
				logger.warn("FunReg >>REG_ID:{}为空",temp.getRegionId());
			}else {
				beanMap.put("regionName", regPO.getRegName());
			}
			vo = BeanUtil.map2Bean(beanMap, ErpFunDeptsDto.class);
			if(temp.getDeptId().equals(param.getInteger("deptId"))){
				list.add(0,vo);
			}else {
				list.add(vo);
			}
		}
		return list;
	}

	@Override
	public List<ErpFunDepts> getDeptListByArea(Integer cityId,Integer compId,Integer areaId) {
		ErpFunDepts record = new ErpFunDepts();
		record.setCompId(compId);
		record.setAreaId(areaId);
		List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByRange(cityId, record);
		return list;
	}

	@Override
	public Map<Object, ErpFunDepts> getAllDeptListByRange(Integer cityId, ErpFunDepts conditon) {
		List<ErpFunDepts> list = erpFunDeptsMapper.getAllDeptListByRange(cityId, conditon);
		return BeanUtilsHelper.listToMapObjectOffKeyType(list, "deptId");
	}

	@Override
	public List<ErpFunDepts> getDeptListByDeptIds(Integer cityId, Set<Integer> deptIds) {
		if (CollectionUtils.isEmpty(deptIds)) {
			return Collections.emptyList();
		}
		return erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIds);
	}

	@Override
	public ErpFunDepts getDeptListByDeptId(Integer cityId, Integer deptIds) {
		Set<Integer> deptIdsSet = new HashSet<Integer>();
		deptIdsSet.add(deptIds);
		List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdsSet);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Transactional
	@Override
	public void moveUserToNewDept(MoveUserToNewDeptParam param) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(param.getCityId(), param.getUserId());

		ErpFunDepts newFunDepts = erpFunDeptsMapper.getByDeptId(param.getCityId(), param.getNewDeptId());
		Assert.isNullThrow(newFunDepts, "门店不存在");

		// 判断版本
		// 查询门店是否是租用或者新营销版
		AdminFunDepts deptByCompNoAndDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(newFunDepts.getCompNo(), newFunDepts.getDeptNo());

		Integer deptUserCount = null;
		if ((null != deptByCompNoAndDeptNo.getDeptType() && 4 == deptByCompNoAndDeptNo.getDeptType().intValue()) ||
				(null != deptByCompNoAndDeptNo.getPayType() && 5 == deptByCompNoAndDeptNo.getPayType().intValue())) {
			// 总经理就不判断人数
			if(!"GENERAL_MANAGER".equals(erpFunUsers.getUserPosition()) || !"COMMON_ADMIN".equals(erpFunUsers.getUserPosition())) {
				deptUserCount = erpFunUsersMapper.countUserNumberForRentDept(param.getCityId(), param.getNewDeptId());
			}
		}else {
			deptUserCount = erpFunUsersMapper.getDeptUserCount(param.getCityId(), param.getCompId(), param.getNewDeptId(), null);
		}

		if (null != deptUserCount && deptUserCount >= newFunDepts.getUserNum()) {
			throw new ConfirmException("目标门店人数已经达到系统上限，不可向该店调配员工！");
		}


		ErpFunDepts oldFunDepts = erpFunDeptsMapper.getByDeptId(param.getCityId(), erpFunUsers.getDeptId());
		String dateTimeNow = DateTimeHelper.formatDateTimetoString(new Date());
		if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(erpFunUsers.getUserPosition())) {
			if (!erpUserOpersService.judgeBranchManager(param.getCityId(), param.getCompId(), param.getNewDeptId(),
					param.getCompType(), param.getNewDeptId())) {
				throw new ConfirmException("你是赢销版用户，1个门店最多只能创建3个分行经理账号！");
			}
		}
		// 新增一条已删除的用户数据
		erpFunUsers.setUpdateTime(dateTimeNow);
		erpFunUsers.setWriteoffTime(dateTimeNow);
		erpFunUsers.setUserWriteoff(true);
		erpFunUsers.setWriteoffType(Const.DIC_USER_WRITEOFF_TYPE_1);
		erpFunUsers.setShardCityId(param.getCityId());
		erpFunUsersMapper.insertSelective(erpFunUsers);
		// 修改为新的门店
		ErpFunUsers updateUser= new ErpFunUsers();
		updateUser.setUserId(param.getUserId());
		// 修改新的分组
		if (param.getNewGrId() != null) {
			updateUser.setGrId(param.getNewGrId());
		} else {
			updateUser.setGrId(Const.DIC_DEFAULT_GROUP_ID);
		}
		updateUser.setDeptId(newFunDepts.getDeptId());
		updateUser.setRegId(newFunDepts.getRegId());
		updateUser.setAreaId(newFunDepts.getAreaId());
		updateUser.setUpdateUid(param.getSelfUserId());
		updateUser.setUpdateTime(dateTimeNow);
		updateUser.setShardCityId(param.getCityId());
		updateUser.setPartnerId(newFunDepts.getPartnerId());// story#11307 调店组织机构id处理，门店，分组，人员所属加盟id处理
		erpFunUsersMapper.updateByPrimaryKeySelective(updateUser);
		// 薪资处理
		Calendar calendar = Calendar.getInstance();
		String endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);

		// 修改组织机构后同步修改薪资数据
		// 传入新对象
		//添加角色和职级的原因是因为updateWageData中需要使用-陈文超
		updateUser.setUserPosition(erpFunUsers.getUserPosition());
		updateUser.setRoleLevelId(erpFunUsers.getRoleLevelId());
		erpFunWageService.updateWageData(param.getCityId(), param.getCompId(), updateUser);

		// 员工调店后的相关表更新, 这些表里面没有grId
		erpFunUsersMapper.updateDeptByChangeDept(param.getCityId(), param.getNewDeptId(), erpFunUsers.getDeptId(),
				erpFunUsers.getArchiveId(), param.getUserId(), endTime, startTime);
		// 写调店日志
		String logDesc = erpFunUsers.getUserName() + "[" + erpFunUsers.getUserNo() + "] : " + oldFunDepts.getDeptName()
				+ "[" + oldFunDepts.getDeptNo() + "] => " + newFunDepts.getDeptName() + "[" + newFunDepts.getDeptNo() + "]";
		ErpFunLogs erpFunLogs = new ErpFunLogs();
		erpFunLogs.setCompId(param.getCompId());
		erpFunLogs.setCityId(param.getCityId());
		erpFunLogs.setDeptId(newFunDepts.getDeptId());
		erpFunLogs.setOperatorId(param.getSelfUserId());
		erpFunLogs.setOperatorName(Const.DIC_STAFF_MOVE_TO_NEWDEPTSTRING);
		erpFunLogs.setLogtime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunLogs.setLogtype(Const.DIC_STAFF_MOVE_TO_MANAGE);
		erpFunLogs.setLogDesc(logDesc);
		erpFunLogs.setShardCityId(param.getCityId());
		erpFunLogsMapper.insertSelective(erpFunLogs);
		// 修改电子名片
//		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(param.getCityId(), param.getCompId(), userPosition);
//		erpFunEcardsMapper.updateCompAndRole(param.getCityId(), param.getCompId(), erpFunUsers.getArchiveId(),newFunDepts.getDeptName(), erpCompRoles.getRoleName());
		// 写日志
		ErpFunDeptsgroup oldDeptsGroup = null;
		if(erpFunUsers.getGrId() != null && erpFunUsers.getGrId() > 0) {
			oldDeptsGroup = erpFunDeptsgroupMapper.getDataByGrId(param.getCityId(), erpFunUsers.getGrId());
		}
		Integer oldGrId = (null != oldDeptsGroup ? oldDeptsGroup.getGrId() : 0);
		String oldGroupName = (null != oldDeptsGroup) ? oldDeptsGroup.getGrName() : "未分组";
		String content;
		if (param.getNewGrId() != null && param.getNewGrId() > 0) {
			ErpFunDeptsgroup newDeptsGroup = erpFunDeptsgroupMapper.getDataByGrId(param.getCityId(), param.getNewGrId());
			String newGroupName = (null != newDeptsGroup) ? newDeptsGroup.getGrName() : "未分组";
			content = "将该员工从" + oldFunDepts.getDeptName() + "-" + oldGroupName + "调动至" + newFunDepts.getDeptName() + "-" + newGroupName;
		} else {
			content = "将该员工从" + oldFunDepts.getDeptName() +"-" + oldGroupName + "调动至" + newFunDepts.getDeptName()+"-未分组";
		}

		// 调组
		erpFunEmployeeLogService.insertLog(param.getCityId(), param.getCompId(), Const.DIC_STAFF_MOVE_TO_NEWDEPT,
				content, erpFunUsers.getArchiveId(), param.getSelfUserId(), erpFunUsers.getDeptId(),
				param.getNewDeptId(), erpFunUsers.getUserPosition(),
				updateUser.getUserPosition(), oldGrId, param.getNewGrId() != null ? param.getNewGrId() : Const.DIC_DEFAULT_GROUP_ID);
		// 清除缓存
		erpFunUsersService.evictBaseInfoByCompId(erpFunUsers.getCityId().intValue(), erpFunUsers.getCompId());
		// 强制退出登录
		erpFunUsersService.endLoginUser(erpFunUsers.getArchiveId(), erpFunUsers.getUserMobile(), LogInEnum.DEPT_CHANGE);
		// 异步执行，发送jms消息修改数据所属
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				sendForUpdateUser(param.getCityId(), Arrays.asList(param.getUserId()), param.getCompId(),
						param.getCompId(), erpFunUsers.getUserId(), "DEPT");
			}
		});
	}

	@Transactional
	@Override
	public void updateDept(FunDeptsParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();
		ErpFunDepts beforeDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		if(null == regId){
			regId = beforeDepts.getRegId();
		}
		if(null == areaId){
			areaId = beforeDepts.getAreaId();
		}
		//---2019-09-05 FJD 逻辑，修改门店只能修改简称，不能修改全称
		if(StringUtil.isEmpty(param.getDeptCname())){
			param.setDeptCname(param.getDeptName());
		}
        param.setDeptName(null);
		ErpFunDepts nowDepts = param;
		nowDepts.setUpdateUid(param.getSelfUserId());
		nowDepts.setShardCityId(cityId);
		nowDepts.setUpdateTime(DateUtil.DateToString(new Date()));
		// 新门店
		erpFunDeptsMapper.updateByPrimaryKeySelective(nowDepts);
		AdminFunDepts adminDept = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(param.getCompNo(), beforeDepts.getDeptNo());
		if (StringUtil.isNotBlank(param.getDeptCname())) {
			AdminFunDepts adminNowDept = new AdminFunDepts();
			adminNowDept.setDeptId(adminDept.getDeptId());
			adminNowDept.setDeptCname(param.getDeptCname());
			adminFunDeptsMapper.updateByPrimaryKeySelective(adminNowDept);
		}
		this.evictDeptInfoByDeptPo(cityId,compId);
		// 改admin库FUN_DEPTS的REGION_ID
		if (null != param.getRegionId() && !param.getRegionId().equals(beforeDepts.getRegionId()) && null != param.getCompNo()) {
			AdminFunDepts updateModel = new AdminFunDepts();
			updateModel.setDeptId(adminDept.getDeptId());
			updateModel.setRegionId(param.getRegionId());
			adminFunDeptsMapper.updateByPrimaryKeySelective(updateModel);
		}
		if (!beforeDepts.getRegId().equals(nowDepts.getRegId())) {
			// 门店下的抢盘和公盘数据，只能跟着门店进行级联更新，其他的通过用户信息修改时级联更新
			erpFunDeptsMapper.updateByDeptInfoChange(cityId, compId, areaId, regId, deptId);
			erpFunUsersService.endLoginDeptUser(cityId, compId, deptId, LogInEnum.DEPT_CHANGE);
		}
		if (param.getPropertyManagerUserId() != null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, param.getPropertyManagerUserId());
			Integer propertyManagerArchiveId = erpFunUsers.getArchiveId();
			Integer propertyManagerCompId = erpFunUsers.getCompId();
			Integer propertyManagerDeptId = erpFunUsers.getDeptId();
			// 所有人更新成非管理员
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			erpFunUsersExample.createCriteria().andCompIdEqualTo(propertyManagerCompId).andDeptIdEqualTo(propertyManagerDeptId);
			try {
				List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
				if (!userList.isEmpty()) {
					// 踢人
					for (ErpFunUsers oldErpFunUsers : userList) {
						HttpUtil.get(AppConfig.getHftMoblieUrl() + "approveOpenApi/yxTeam/deletePropertyCityTeamUser?cityId="+oldErpFunUsers.getCityId()+"&archiveId=" + oldErpFunUsers.getArchiveId(), null);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ErpFunUsers updateUsers = new ErpFunUsers();
			updateUsers.setPropertyManager((byte)0);
			erpFunUsersMapper.updateByExampleSelective(updateUsers, erpFunUsersExample);
			// 更新项目管理员
			ErpFunUsers updateUser = new ErpFunUsers();
			updateUser.setShardCityId(cityId);
			updateUser.setUserId(erpFunUsers.getUserId());
			updateUser.setPropertyManager((byte)1);
			erpFunUsersMapper.updateByPrimaryKeySelective(updateUser);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, propertyManagerDeptId);
			String propertyManagerCompNo = erpFunDepts.getCompNo();
			String propertyManagerDeptNo = erpFunDepts.getDeptNo();
			AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(propertyManagerCompNo, propertyManagerDeptNo);
			AdminPropertyBuildMap adminPropertyBuildMap = new AdminPropertyBuildMap();
			adminPropertyBuildMap.setDeptId(adminFunDepts.getDeptId());
			adminPropertyBuildMap.setArchiveId(propertyManagerArchiveId);
			adminPropertyBuildMapMapper.updateByPrimaryKeySelective(adminPropertyBuildMap);
			// 加入群
			try {
				HttpUtil.get(AppConfig.getHftMoblieUrl() + "approveOpenApi/yxTeam/createPropertyCityTeamUser?cityId="+erpFunUsers.getCityId()+"&archiveId=" + erpFunUsers.getArchiveId(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ErpFunRegion erpFunRegion = erpFunRegionMapper.getDataById(cityId, regId);
		nowDepts.setAreaId(erpFunRegion.getAreaId());
		nowDepts.setUpdateUid(param.getSelfUserId());
		nowDepts.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
		String content = "修改了" + beforeDepts.getDeptName() + "门店信息";
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_DEPT, null, deptId, content,
				beforeDepts, nowDepts, cityId, compId, deptId, param.getSelfUserId());
		// 写CRM跟进
		// String title = "修改" + adminFunDepts.getDeptCname() + "资料：\n";
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(param.getCompNo(), beforeDepts.getDeptNo());
		String trackValue = this.updateTrack(nowDepts, beforeDepts);
		this.createTrackForEdit(adminFunDepts, "SHOP", trackValue,param.getUserName());

		if (!beforeDepts.getRegId().equals(nowDepts.getRegId())) {
			// 处理薪资数据 只要片区有变动就处理
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andUserWriteoffEqualTo(false);
			List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectByExample(usersExample);
			erpFunUsers.stream().forEach(val-> {
				erpFunWageService.updateWageData(cityId, compId, val);
			});
		}
	}


	/**
	 * 修改信息，比较新旧数据
	 *
	 * @param newBean
	 * @param oldBean
	 * @return
	 */
	public static String updateTrack(Object newBean, Object oldBean) {
		String trackStr = "";
		try {
			Map<String, Object> newJsonArray = BeanUtilsHelper.bean2Map(newBean);
			Map<String, Object> oldJsonArray = BeanUtilsHelper.bean2Map(oldBean);
			for (String key : newJsonArray.keySet()) {
				if (key.contains("Name") || key.contains("User") || key.contains("Addr") || key.contains("tele")
						|| key.contains("Contact") || key.contains("Sex") || key.contains("Phone") || key.contains("Qq")
						|| key.contains("Region") || key.contains("deptLevel")) {
					Object oldValue = oldJsonArray.get(key) == null ? "" : oldJsonArray.get(key);
					Object newValue = newJsonArray.get(key) == null ? "" : newJsonArray.get(key);
					if (!oldValue.equals(newValue)) {
						if (key.contains("Sex")) {
							oldValue = "1".equals(String.valueOf(oldValue)) ? "男" : "女";
							newValue = "1".equals(String.valueOf(newValue)) ? "男" : "女";
						}
						trackStr += key + "：" + oldValue + ">>" + newValue + ";";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trackStr;
	}

	/**
	 * 修改公司门店写跟进
	 *
	 * @param funDepts
	 * @param tableType
	 * @param trackValue
	 * @param adminCrmUser
	 */
	private void createTrackForEdit(AdminFunDepts funDepts, String tableType, String trackValue, String updateUserName) {
		Date date = new Date();
		Integer deptId = funDepts.getDeptId();
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByPrimaryKey(deptId);
		String tableName = "";
		String idField = "";
		if (tableType.equals("CUST")) {
			tableName = "FUN_COMP";
			idField = "COMP_ID";
		} else if (tableType.equals("SHOP")) {
			tableName = "FUN_DEPTS";
			idField = "DEPT_ID";
		}

		// 写跟进
		AdminCrmTrack adminCrmTrack = new AdminCrmTrack();
		adminCrmTrack.setCompId(funDepts.getCompId());
		adminCrmTrack.setTypeDesc("[ 修改资料 ]");
		adminCrmTrack.setTrackContent("[ERP]" + updateUserName + "于本日对" + funDepts.getDeptCname() + "进行修改操作！\n" + trackValue);
		adminCrmTrack.setTrackStyle("5");
		adminCrmTrack.setTrackType("3");
		adminCrmTrack.setDeptId(deptId);
		adminCrmTrack.setCompNo(adminFunDepts.getCompNo());
		adminCrmTrack.setDeptNo(adminFunDepts.getDeptNo());
		adminCrmTrack.setCreatorUid(999);
		adminCrmTrack.setCreationTime(date);
		adminCrmTrackMapper.insertSelective(adminCrmTrack);
	}

	@Override
	public void setOrCancleDeptHeadquarters(Integer cityId, Byte isHQ,Integer deptId) {
		ErpFunDepts dept = new ErpFunDepts();
		dept.setShardCityId(cityId);
		dept.setIsHeadquarters(isHQ);
		dept.setDeptId(deptId);
		dept.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunDeptsMapper.updateByPrimaryKey(dept);
	}

	@Override
	public List<ErpFunDepts> getDeptListByUserIds(Integer cityId, Set<Integer> userIds) {
		if (CollectionUtils.isEmpty(userIds)) {
			return Collections.emptyList();
		}
		List<ErpFunUsers> userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
		if (userListByUserIds.isEmpty()) {
			return Collections.emptyList();
		}
		Set<Integer> deptIds = userListByUserIds.stream().map(ErpFunUsers::getDeptId).collect(Collectors.toSet());
		List<ErpFunDepts> deptListByDeptIds = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIds);
		return deptListByDeptIds;
	}

	@Override
	public void evictDeptInfoByDeptPo(Integer cityId, Integer compId) {
	    cacheUtil.del(CacheStructure.hfterpdb_funDeptsCache_by_COMP_ID
				+ compId + "_CITY_ID_" + cityId);
	}


	/**
	 * 员工异动相关的jms消息，用于同步相关房客源等数据组织机构
	 * @author 张宏利
	 * @since 2018年5月29日
	 * @param cityId 城市ID
	 * @param userIds 用户ID，多个以英文逗号分隔
	 * @param oldCompId 老的公司ID
	 * @param newCompId 新的公司ID
	 * @param delUserId 被删除的用户ID，员工调店时才需要
	 * @param updateRange 员工调店的时候才传DEPT，其他情况可以不传
	 */
	public void sendForUpdateUser(Integer cityId, List<Integer> userIds, Integer oldCompId, Integer newCompId, Integer delUserId, String updateRange) {
		Integer[] allChangedUserIdArr = userIds.toArray(new Integer[] {});
		StringBuilder userIdSb = new StringBuilder();
		for (Integer userIdTmp : allChangedUserIdArr) {
			if(userIdSb.length() > 0) {
				userIdSb.append(",");
			}
			userIdSb.append(userIdTmp);
		}

		UpdateFunUserMessage message = new UpdateFunUserMessage();
		message.setUserIds(userIdSb.toString());
		message.setUpdateRange(updateRange);
		message.setOldCompId(oldCompId);
		message.setNewCompId(newCompId);
		message.setDelUserId(delUserId);
		message.setCityId(cityId);
		message.setQueneName(JmsMsgAction.UPDATE_AREA_REG_DEPT_GROUP_INFO);
		mqUtil.sendMessage(message);

	}
}



