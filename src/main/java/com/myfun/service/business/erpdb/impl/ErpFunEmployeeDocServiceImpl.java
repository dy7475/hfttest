package com.myfun.service.business.erpdb.impl;

import java.util.*;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.employeeFiles.param.UploadEmployeeFileParam;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Objects;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunArchiveExample;
import com.myfun.repository.erpdb.dto.ErpFunEmployeeDocDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.utils.Assert;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil;
import scala.annotation.meta.param;

@Service
public class ErpFunEmployeeDocServiceImpl extends AbstractService<ErpFunEmployeeDoc, ErpFunEmployeeDoc> implements ErpFunEmployeeDocService {

	@Autowired
	ErpFunEmployeeDocMapper erpFunEmployeeDocMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired 
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired 
	ErpFunEmployeeLogService erpFunEmployeeLogService;
	@Autowired 
	ErpFunRoleLevelsMapper erpFunRoleLevelsMapper;
	@Autowired
	ErpFunEmployeeFileService erpFunEmployeeFileService;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunEmployeeDocMapper;
	}


	/**
	 * title ：编辑员工档案
	 * athor：lcb
	 * date  : 2017/11/7
	 */
	@Transactional
	@Override
	public Integer editEmployeeDoc(Integer cityId,Integer compId ,Integer deptId, Integer userId, ErpFunEmployeeDoc erpFunEmployeeDoc,
								AdminFunArchive adminFunArchive, ErpFunUsers erpFunUsers, Map<String, Object> paramJsonMap, Integer compType, String createUserName) throws Exception{
		Integer docId = null;
		erpFunEmployeeDoc.setShardCityId(cityId);
		erpFunUsers.setShardCityId(cityId);
		// 档案为空
		ErpFunEmployeeDoc oldDataObect = new ErpFunEmployeeDoc();
		if(null != erpFunEmployeeDoc.getId()) {
			oldDataObect = erpFunEmployeeDocMapper.selectByPrimaryKey(erpFunEmployeeDoc);
		}
		AdminFunArchive oldAdminFunarchive = adminFunArchiveMapper.selectByPrimaryKey(adminFunArchive.getArchiveId());
		ErpFunUsers oldFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFunUsers.getUserId());
		// 营销版增加职务COMMON_BIZ、BRANCH_MANAGER、GENERAL_MANAGER
		List<String> roleList = Arrays.asList("COMMON_BIZ","BRANCH_MANAGER","GENERAL_MANAGER");
		String userPosition = (String)paramJsonMap.get("userPosition");
		if(4 == compType && null != userPosition && roleList.contains(userPosition)){
			if(!oldFunUsers.getUserPosition().equals(userPosition)){
				ErpFunUsers updateModel = new ErpFunUsers();
				updateModel.setShardCityId(cityId);
				updateModel.setUserId(erpFunUsers.getUserId());
				updateModel.setUserPosition(userPosition);
				updateModel.setUpdateTime(DateUtil.DateToString(new Date()));
				erpFunUsersMapper.updateByPrimaryKeySelective(updateModel);
			}
		}

		//---------------------------角色变化修改KPI方案-----------------------------
		//根据经纪人角色变化修改KPI配置方案
		if (!Objects.equal(oldFunUsers.getUserPosition(), userPosition)) {
			reConfigureUserKPIScheme(cityId, oldFunUsers, userPosition);
		}
		//---------------------------角色变化修改KPI方案-----------------------------

		// 判断角色是否有变化，有的化应该相应修改个人的权限
//		if(!oldFunUsers.getUserPosition().equals(userPosition)){
//			// 先清除个人权限
//			erpUserOpersMapper.deleteByUserId(cityId, oldFunUsers.getUserId());
//			List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
//			flagList.add(Byte.valueOf("0"));
//			erpUserOpersMapper.createByHaveCompRoleOper(cityId, erpFunUsers.getUserId(), userPosition, oldFunUsers.getCompId(), "ORGANIZATION_ID", 0, flagList);
//			// 添加权限
//		}
		try{
			if(!oldFunUsers.getUserPosition().equals(erpFunUsers.getUserPosition()) && StringUtil.isNotBlank(erpFunUsers.getUserPosition())){
//			erpFunUsersService.updateUserRole(cityId, compId, compType, erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), userId);
				ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
				erpFunUsersService.updateUserRole(cityId, compId, erpFunUsers.getUserId(), userPosition,
						null, userId,null, createUserName);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		// 这种情况是因为前端没有传archiveId
		if(null == oldAdminFunarchive){
			oldFunUsers.setShardCityId(cityId);
			oldAdminFunarchive = adminFunArchiveMapper.selectByPrimaryKey(oldFunUsers.getArchiveId());
		}
		// 基础数据对象对象更新
		erpFunEmployeeDoc.setUpdateTime(new Date());
		if(null == erpFunEmployeeDoc.getId()) {
			erpFunEmployeeDoc.setCompId(compId);
			erpFunEmployeeDoc.setCreationTime(new Date());
			erpFunEmployeeDocMapper.insertSelective(erpFunEmployeeDoc);
		}else {
			erpFunEmployeeDocMapper.updateByPrimaryKeySelective(erpFunEmployeeDoc);
		}
		docId = erpFunEmployeeDoc.getId();
		// 编辑admin数据
		if(null != adminFunArchive && null != adminFunArchive.getArchiveId()){
			if(null == adminFunArchive.getUserSex()){
				adminFunArchive.setUserSex(oldAdminFunarchive.getUserSex());
			}
		}

        // 当本门店内从某分组调到未分组的时候,grId传空
		if (!paramJsonMap.containsKey("grId")) {
            erpFunUsers.setGrId(0);
        }
        //是否是房基地掌通邀请注册调用标记
        if (paramJsonMap.containsKey("fjdShareRegister")) {
			erpFunUsers.setUserWriteoff(false);

        }
		adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
		// 编辑funUser数据
		erpFunUsers.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
		// 写日志
		this.insertSystemLog(this.getOldAdminFunArchive(oldAdminFunarchive), this.getOldErpFunUsers(oldFunUsers), oldDataObect,
				paramJsonMap ,userId, erpFunUsers.getUserId(),  cityId, compId, oldFunUsers.getDeptId(), deptId, createUserName);
        //是否是房基地掌通邀请注册调用标记
        if (paramJsonMap.containsKey("fjdShareRegister")) {
			UploadEmployeeFileParam param = new UploadEmployeeFileParam();
			param.setCreatorUid(erpFunUsers.getUserId());
			param.setCityId(cityId);
			param.setCompId(compId);
			param.setDeptId(deptId);
			param.setEmployeeDocId(erpFunEmployeeDoc.getId());
			param.setArchiveId(adminFunArchive.getArchiveId());
        	if(paramJsonMap.containsKey("userIccodeUrl")){
				param.setFileType((byte) 1);
				String userIccodeUrl = (String)paramJsonMap.get("userIccodeUrl");
				String[] split = userIccodeUrl.split(",");
				for (String String : split) {
					param.setFileUrl(String);
					erpFunEmployeeFileService.uploadEmployeeFile(param);
				}
			}
        	if(paramJsonMap.containsKey("educationUrl")){
				param.setFileType((byte) 2);
				String educationUrl = (String)paramJsonMap.get("educationUrl");
				String[] split = educationUrl.split(",");
				for (String String : split) {
					param.setFileUrl(String);
					erpFunEmployeeFileService.uploadEmployeeFile(param);
				}
			}
			ErpFunUsers sendUser = erpFunUsersMapper.selectByUserId(cityId, erpFunUsers.getUserId());
			Integer inviteId = (Integer) paramJsonMap.get("inviteId");
			//员工注册完成 判断公司是否需要审核
			try {
				erpFunUsersService.sendRegistrationAuditMsg(sendUser,inviteId,cityId);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }

		return docId;
	}

	public void reConfigureUserKPIScheme(Integer cityId, ErpFunUsers funUser, String userPosition) {
		//失效之前的配置方案
		erpFunUsersService.invalidOriginKpiConfig(cityId, funUser.getUserId());
		if (StringUtil.isBlank(userPosition)) {
			return;
		}
		//配置新方案
		ErpFunUsers targetUser = new ErpFunUsers();
		org.springframework.beans.BeanUtils.copyProperties(funUser, targetUser);
		targetUser.setUserPosition(userPosition);
		erpFunUsersService.configureUserKPIForPositionModify(cityId, targetUser);
	}

	// 对比特定字段
	private AdminFunArchive getOldAdminFunArchive(AdminFunArchive oldAdminFunarchive) {
		AdminFunArchive adminFunArchive = new AdminFunArchive();

		// 办公电话
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserOfficeph())) {
			adminFunArchive.setUserOfficeph(oldAdminFunarchive.getUserOfficeph());
		}
		// QQ
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserQq())) {
			adminFunArchive.setUserQq(oldAdminFunarchive.getUserQq());
		}
		// mail
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserEmail())) {
			adminFunArchive.setUserEmail(oldAdminFunarchive.getUserEmail());
		}
		// 家庭住址
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserAddress())) {
			adminFunArchive.setUserAddress(oldAdminFunarchive.getUserAddress());
		}
		// 应急电话
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserFixedph())) {
			adminFunArchive.setUserFixedph(oldAdminFunarchive.getUserFixedph());
		}
		// 政治
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserPolity())) {
			adminFunArchive.setUserPolity(oldAdminFunarchive.getUserPolity());
		}
		// 学院
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserSchool())) {
			adminFunArchive.setUserSchool(oldAdminFunarchive.getUserSchool());
		}
		// 专业
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserField())) {
			adminFunArchive.setUserField(oldAdminFunarchive.getUserField());
		}

		// 学历
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserSchlrecord())) {
			adminFunArchive.setUserSchlrecord(oldAdminFunarchive.getUserSchlrecord());
		}

		// 学历
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserName())) {
			adminFunArchive.setUserName(oldAdminFunarchive.getUserName());
		}
		// 性别
		if(null != oldAdminFunarchive.getUserSex()) {
			adminFunArchive.setUserSex(oldAdminFunarchive.getUserSex());
		}
		// 生日
		if(null != oldAdminFunarchive.getUserBirthday()) {
			adminFunArchive.setUserBirthday(oldAdminFunarchive.getUserBirthday());
		}
		// 生日
		if(StringUtils.isNotBlank(oldAdminFunarchive.getUserIccode())) {
			adminFunArchive.setUserIccode(oldAdminFunarchive.getUserIccode());
		}

		return adminFunArchive;
	}

	// 对比特定字段
	private ErpFunUsers getOldErpFunUsers(ErpFunUsers oldFunUsers) {
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		// 入职时间
		if(null != oldFunUsers.getUserJobDate()) {
			erpFunUsers.setUserJobDate(oldFunUsers.getUserJobDate());
		}
		// 职级
		if(StringUtils.isNotBlank(oldFunUsers.getPersonnelLevels())) {
			erpFunUsers.setPersonnelLevels(oldFunUsers.getPersonnelLevels());
		}

		if(StringUtils.isNotBlank(oldFunUsers.getRecruitmentChannel())) {
			// 入职渠道
			erpFunUsers.setRecruitmentChannel(oldFunUsers.getRecruitmentChannel());
		}

		if(null != oldFunUsers.getUserSex()) {
			// 性别
			erpFunUsers.setUserSex(oldFunUsers.getUserSex());
		}
		if(StringUtils.isNotBlank(oldFunUsers.getUserName())) {
			// 名字
			erpFunUsers.setUserName(oldFunUsers.getUserName());
		}

		return erpFunUsers;
	}

	private void insertSystemLog(AdminFunArchive adminFunArchive, ErpFunUsers erpFunUsers
			, ErpFunEmployeeDoc erpFunEmployeeDoc, Map<String, Object> newDataMap, Integer userId,Integer infUserId,
								 Integer cityId, Integer compId, Integer deptId ,Integer logUserDeptId, String createUserName) throws Exception{
		// 三个对象转成新的Map结构
		Map<String, Object> oldDataMap = BeanUtil.objectToMap(adminFunArchive);
		oldDataMap.putAll(BeanUtil.objectToMap(erpFunUsers));
		oldDataMap.putAll(BeanUtil.objectToMap(erpFunEmployeeDoc));
		// 特殊处理出生日志和入职日期
		Object userSex = oldDataMap.get("userSex");
		String sexStr = null;
		if(null != userSex) {
			sexStr = "0";
			if((Boolean) userSex) {
				sexStr = "1";
			}
		}
		if(null != sexStr) {
			oldDataMap.put("userSex", sexStr);
		}
		Map<String, Object> tempOldDataMap = new HashMap<>();
		Map<String, Object> tempNewDataMap = new HashMap<>();
		for(Map.Entry<String, Object> map :newDataMap.entrySet()){
			String key = map.getKey();
			Object value = map.getValue();
			Object oldValue = oldDataMap.get(key);
			if(!Objects.equal(value, oldValue)){
				tempOldDataMap.put(key, oldValue);
				tempNewDataMap.put(key, value);
			}
		}
		// 特殊处理出生日志和入职日期
		String userJobDate = erpFunUsers.getUserJobDate();
		if(null != userJobDate) {
			tempOldDataMap.put("userJobDate", DateTimeHelper.formatDateTimetoString(userJobDate, "yyyy-MM-dd HH:mm:ss"));
		}
		// 特殊处理出生日志和入职日期
		Date userBirthday = adminFunArchive.getUserBirthday();
		if(null != userBirthday ) {
			tempOldDataMap.put("userBirthday", DateTimeHelper.formatDateTimetoString(userBirthday, "yyyy-MM-dd HH:mm:ss"));
		}
		// 特殊处理出生日志和入职日期
		Date graduationTime = erpFunEmployeeDoc.getGraduationTime();
		if(null != graduationTime ) {
			tempOldDataMap.put("graduationTime", DateTimeHelper.formatDateTimetoString(graduationTime, "yyyy-MM-dd HH:mm:ss"));
		}
		// 特殊处理性别
		// 特殊处理出生日志和入职日期
		Object newUserJobDate = tempNewDataMap.get("userJobDate");
		if(null != newUserJobDate && StringUtil.isNotBlank(newUserJobDate.toString())) {
			Date parseToDate = DateTimeHelper.parseToDate(newUserJobDate.toString(), "yyyy-MM-dd");
			tempNewDataMap.put("userJobDate", DateTimeHelper.formatDateTimetoString(parseToDate, "yyyy-MM-dd HH:mm:ss"));
		} else {
			tempNewDataMap.put("userJobDate", DateTimeHelper.formatDateTimetoString(userJobDate, "yyyy-MM-dd HH:mm:ss"));
		}
		// 特殊处理出生日志和入职日期
		Object newUserBirthday = tempNewDataMap.get("userBirthday");
		if(null != newUserBirthday && StringUtil.isNotBlank(newUserBirthday.toString()) ) {
			Date parseToDate = DateTimeHelper.parseToDate(newUserBirthday.toString(), "yyyy-MM-dd");
			tempNewDataMap.put("userBirthday", DateTimeHelper.formatDateTimetoString(parseToDate, "yyyy-MM-dd HH:mm:ss"));
		} else {
			tempNewDataMap.put("userBirthday", DateTimeHelper.formatDateTimetoString(userBirthday, "yyyy-MM-dd HH:mm:ss"));
		}
		// 特殊处理出生日志和入职日期
		Object newGraduationTime = tempNewDataMap.get("graduationTime");
		if(null != newGraduationTime && StringUtil.isNotBlank(newGraduationTime.toString())) {
			Date parseToDate = DateTimeHelper.parseToDate(newGraduationTime.toString(), "yyyy-MM-dd");
			tempNewDataMap.put("graduationTime", DateTimeHelper.formatDateTimetoString(parseToDate, "yyyy-MM-dd HH:mm:ss"));
		} else {
			tempNewDataMap.put("graduationTime", DateTimeHelper.formatDateTimetoString(graduationTime, "yyyy-MM-dd HH:mm:ss"));
		}
//		tempNewDataMap.putAll(tempOldDataMap);
//		tempNewDataMap.putAll(newDataMap);
		String currUserName = erpFunUsersMapper.getCurrUserName(cityId, userId, logUserDeptId);
		//erpFunEmployeeLogService.insertLog(cityId, compId, Const.DIC_STAFF_EDIT_EMPLOYEEDOC, currUserName + "修改了员工档案", adminFunArchive.getArchiveId(), userId, StringUtil.parseInteger(oldDataMap.get("deptId"),StringUtil.parseInteger(newDataMap.get("deptId"))), StringUtil.parseInteger(newDataMap.get("deptId")), (String)oldDataMap.get("userPosition"), (String)newDataMap.get("userPosition"), StringUtil.parseInteger(oldDataMap.get("grId")), StringUtil.parseInteger(newDataMap.get("grId")));
		//erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_EMPLOYEE_DOC, infUserId, deptId,
				//currUserName + "修改了员工档案",  tempOldDataMap, tempNewDataMap, cityId, compId,  logUserDeptId, userId);
		
		
		erpFunEmployeeLogService.insertLogAddCreateUser(cityId, compId, Const.DIC_STAFF_EDIT_EMPLOYEEDOC, currUserName + "修改了员工档案", adminFunArchive.getArchiveId(), userId, StringUtil.parseInteger(oldDataMap.get("deptId"),StringUtil.parseInteger(newDataMap.get("deptId"))), StringUtil.parseInteger(newDataMap.get("deptId")), (String)oldDataMap.get("userPosition"), (String)newDataMap.get("userPosition"), StringUtil.parseInteger(oldDataMap.get("grId")), StringUtil.parseInteger(newDataMap.get("grId")),createUserName);
		erpSystemSettingLogsService.insertSysLogNew(SystemOperateUtil.SSL_TYPE.UPDATE_EMPLOYEE_DOC, infUserId, deptId,
				currUserName + "修改了员工档案",  tempOldDataMap, tempNewDataMap, cityId, compId,  logUserDeptId, userId, createUserName);
	}

	/**
	 * @Title 员工档案修改头像
	 * @Author lcb
	 * @Date 2017/12/28
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer changeUserPhoto(Integer cityId, Integer userId, Integer compId, String photoAddr) {
		Integer res = 0;
		ErpFunEmployeeDoc erpFunEmployeeDoc = erpFunEmployeeDocMapper.getErpFunEmployeeDocByUserId(cityId, compId, userId);
		Assert.isNullThrow(erpFunEmployeeDoc,"无员工档案消息，保存失败！");
		/*if(null == erpFunEmployeeDoc) {
			return res;
		}*/
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setUserId(userId);
		erpFunUsers.setUserPhoto(photoAddr);
		erpFunUsers.setShardCityId(cityId);
		res = erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);

		AdminFunArchiveExample adminFunArchiveExample = new AdminFunArchiveExample();
		adminFunArchiveExample.createCriteria().andArchiveIdEqualTo(erpFunEmployeeDoc.getArchiveId()).andUserPhotoIsNull();
		AdminFunArchive adminFunArchive = new AdminFunArchive();
		adminFunArchive.setUserPhoto(photoAddr);
		adminFunArchiveMapper.updateByExampleSelective(adminFunArchive, adminFunArchiveExample);

		return res;
	}


	@Override
	public ErpFunEmployeeDoc getEmployeeInfo(Integer cityId, Integer compId, ErpFunUsers erpFunUsers) {
		ErpFunEmployeeDocDto erpFunEmployeeDocDto = erpFunEmployeeDocMapper.getEmployeeDocDetail(cityId, erpFunUsers.getUserId(), compId);
		// 为空就新增一条
		if(erpFunEmployeeDocDto == null) {
			ErpFunEmployeeDoc erpFunEmployeeDoc = new ErpFunEmployeeDoc();
			erpFunEmployeeDoc.setArchiveId(erpFunUsers.getArchiveId());
			erpFunEmployeeDoc.setCompId(compId);
			erpFunEmployeeDoc.setCreationTime(new Date());
			erpFunEmployeeDoc.setUserJobDate(DateUtil.StringToDate(erpFunUsers.getUserJobDate()));
			erpFunEmployeeDoc.setUserId(erpFunUsers.getUserId());
			erpFunEmployeeDoc.setShardCityId(cityId);
			erpFunEmployeeDocMapper.insertSelective(erpFunEmployeeDoc);
			return erpFunEmployeeDoc;
		}
		
		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunEmployeeDocDto.getUserPosition());
		if(null != erpCompRoles){
			erpFunEmployeeDocDto.setRoleName(erpCompRoles.getRoleName());
		}
		//邀请人姓名
		if(null != erpFunEmployeeDocDto.getCurrentPId()){
			ErpFunUsers userName = erpFunUsersMapper.selectUserNameByUserId(cityId, erpFunEmployeeDocDto.getCurrentPId());
			if(null != userName && StringUtil.isNotEmpty(userName.getUserName())){
				erpFunEmployeeDocDto.setInviteUserName(userName.getUserName());
			}
		}
		//职级
		ErpFunRoleLevels erpFunRoleLevels = new ErpFunRoleLevels();
		erpFunRoleLevels.setShardCityId(cityId);
		erpFunRoleLevels.setRoleLevelId(erpFunUsers.getRoleLevelId());
		erpFunRoleLevels = erpFunRoleLevelsMapper.selectByPrimaryKey(erpFunRoleLevels);
		
		String userPhoto = erpFunEmployeeDocDto.getUserPhoto();
		erpFunEmployeeDocDto.setUserPhoto(CommonUtil.getPhotoUrl(userPhoto));
		erpFunEmployeeDocDto.setRoleLevelId(erpFunUsers.getRoleLevelId());
		if(erpFunRoleLevels != null){
			erpFunEmployeeDocDto.setRoleLevelName(erpFunRoleLevels.getRoleLevelName());
		}
		return erpFunEmployeeDocDto;
	}

	@Transactional
	@Override
	public void updateOrCreateEmployeeDoc(Integer cityId, ErpFunUsers user) {
		ErpFunEmployeeDocExample employeeDocExample = new ErpFunEmployeeDocExample();
		employeeDocExample.setShardCityId(cityId);
		employeeDocExample.createCriteria().andCompIdEqualTo(user.getCompId()).andArchiveIdEqualTo(user.getArchiveId());
		int count = erpFunEmployeeDocMapper.countByExample(employeeDocExample);
		ErpFunEmployeeDoc erpFunEmployeeDoc = new ErpFunEmployeeDoc();
		if (count > 0) {
			// 以后再写TODO直接打死
			erpFunEmployeeDoc.setWriteoffTime(null);
			erpFunEmployeeDoc.setUserId(user.getUserId());
			erpFunEmployeeDoc.setUserJobDate(DateUtil.StringToDate(user.getUserJobDate()));
			erpFunEmployeeDoc.setUpdateTime(new Date());
			erpFunEmployeeDoc.setShardCityId(cityId);
			erpFunEmployeeDoc.setCompId(user.getCompId());
			erpFunEmployeeDoc.setArchiveId(user.getArchiveId());
			erpFunEmployeeDocMapper.updateWriteoffTime(erpFunEmployeeDoc);
		} else {
			AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(user.getArchiveId());
			// 处理员工档案
			erpFunEmployeeDoc.setUpdateTime(new Date());
			erpFunEmployeeDoc.setArchiveId(user.getArchiveId());
			erpFunEmployeeDoc.setChannelDescription(user.getRecruitmentChannel());
			erpFunEmployeeDoc.setUserId(user.getUserId());
			erpFunEmployeeDoc.setCreationTime(new Date());
			erpFunEmployeeDoc.setUserJobDate(DateUtil.StringToDate(user.getUserJobDate()));
			erpFunEmployeeDoc.setCompId(user.getCompId());
			erpFunEmployeeDoc.setUserSchool(funArchive.getUserSchool());
			erpFunEmployeeDoc.setUserSchlrecord(funArchive.getUserSchlrecord());
			erpFunEmployeeDoc.setShardCityId(cityId);
			erpFunEmployeeDocMapper.insertSelective(erpFunEmployeeDoc);
		}

	}

	@Override
	public ErpFunEmployeeDoc getEmployeeInfoNewOrg(Integer cityId, Integer compId, ErpFunUsers erpFunUsers) {
		ErpFunEmployeeDocDto erpFunEmployeeDocDto = erpFunEmployeeDocMapper.getEmployeeDocDetailNewOrg(cityId, erpFunUsers.getUserId(), compId);
		// 为空就新增一条
		if(erpFunEmployeeDocDto == null) {
			ErpFunEmployeeDoc erpFunEmployeeDoc = new ErpFunEmployeeDoc();
			erpFunEmployeeDoc.setArchiveId(erpFunUsers.getArchiveId());
			erpFunEmployeeDoc.setCompId(compId);
			erpFunEmployeeDoc.setCreationTime(new Date());
			erpFunEmployeeDoc.setUserJobDate(DateUtil.StringToDate(erpFunUsers.getUserJobDate()));
			erpFunEmployeeDoc.setUserId(erpFunUsers.getUserId());
			erpFunEmployeeDoc.setShardCityId(cityId);
			erpFunEmployeeDocMapper.insertSelective(erpFunEmployeeDoc);
			return erpFunEmployeeDoc;
		}

		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunEmployeeDocDto.getUserPosition());
		if(null != erpCompRoles){
			erpFunEmployeeDocDto.setRoleName(erpCompRoles.getRoleName());
		}

		//邀请人姓名
		if(null != erpFunEmployeeDocDto.getCurrentPId()){
			ErpFunUsers userName = erpFunUsersMapper.selectUserNameByUserId(cityId, erpFunEmployeeDocDto.getCurrentPId());
			if(null != userName && StringUtil.isNotEmpty(userName.getUserName())){
				erpFunEmployeeDocDto.setInviteUserName(userName.getUserName());
			}
		}
		//职级
		ErpFunRoleLevels erpFunRoleLevels = new ErpFunRoleLevels();
		erpFunRoleLevels.setShardCityId(cityId);
		erpFunRoleLevels.setRoleLevelId(erpFunUsers.getRoleLevelId());
		erpFunRoleLevels = erpFunRoleLevelsMapper.selectByPrimaryKey(erpFunRoleLevels);

		String userPhoto = erpFunEmployeeDocDto.getUserPhoto();
		erpFunEmployeeDocDto.setUserPhoto(CommonUtil.getPhotoUrl(userPhoto));
		erpFunEmployeeDocDto.setRoleLevelId(erpFunUsers.getRoleLevelId());
		if(erpFunRoleLevels != null){
			erpFunEmployeeDocDto.setRoleLevelName(erpFunRoleLevels.getRoleLevelName());
		}
		return erpFunEmployeeDocDto;
	}
}
