package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.extension.framework.mq.context.MqUtil;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.jms.bean.UpdateFunUserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.managecenter.sysmanager.param.DeleteGroupParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewGroupParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil.SSL_TYPE;

@Service
public class ErpFunDeptsGroupServiceImpl extends AbstractService<ErpFunDeptsgroup, ErpFunDeptsgroup> implements ErpFunDeptsGroupService {

	@Autowired
	private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunUsersService erpFunUsersService;
	@Autowired
	private ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	private ErpFunEmployeeLogService erpFunEmployeeLogService;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	MqUtil mqUtil;
	@Autowired
	ErpFunWageService erpFunWageService;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunDeptsgroupMapper;
	}

	@Transactional
	@Override
	public Integer moveUserToNewGroup(MoveUserToNewGroupParam param) {
		// 目标成员userId
		String grMember = param.getGrMember();
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer grId = param.getGrId();
		Integer deptId = param.getDeptId();
		boolean changeFlag = false;
		Set<Integer> allChangedUserSet = new HashSet<>();
		List<Integer> userIdsList = StringUtil.toIntList(grMember);
		// 调动员工
		Integer groupId = null;
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		if(null != grId){
			groupId = grId;
			if (userIdsList.size() < 1) {
				userIdsList = null;
			}
			List<ErpFunUsers> funUsersList = erpFunUsersMapper.getFunUsersByGrId(cityId, compId, grId, userIdsList);
			ErpFunDeptsgroup oldFunDeptsgroup = erpFunDeptsgroupMapper.getDataByGrId(cityId, grId);
			if (null == oldFunDeptsgroup) {
				return groupId;
			}
			Integer seqNo = (null == oldFunDeptsgroup.getSeqNo()) ? 0 : oldFunDeptsgroup.getSeqNo();
			String grName = StringUtil.isBlank(oldFunDeptsgroup.getGrName()) ? "" : oldFunDeptsgroup.getGrName();
			String grContact = StringUtil.isBlank(oldFunDeptsgroup.getGrContact()) ? "" : oldFunDeptsgroup.getGrContact();
			String grTele = StringUtil.isBlank(oldFunDeptsgroup.getGrTele()) ? "" : oldFunDeptsgroup.getGrTele();
			String grDesc = StringUtil.isBlank(oldFunDeptsgroup.getGrDesc()) ? "" : oldFunDeptsgroup.getGrDesc();
			// 改分组名、改编号、改负责人、联系电话、分组描述
			if((!grName.equals(param.getGrName()))
					|| (!seqNo.equals(param.getSeqNo()))
					|| (!grContact.equals(param.getGrContact()))
					|| (!grTele.equals(param.getGrTele()))
					|| (!grDesc.equals(param.getGrDesc()))){
				changeFlag = true;
			}
			if (!oldFunDeptsgroup.getGrName().equals(param.getGrName())) {
				// 编辑分组判重复分组
				Integer groupCount = erpFunDeptsgroupMapper.countGroupByGrName(cityId, compId, deptId, param.getGrName());
				if (groupCount > 0) {
//					ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
					if(null != erpFunDepts.getIsHeadquarters() && "1".equals(erpFunDepts.getIsHeadquarters().toString())){
						throw new BusinessException("部门名称重复请重新输入");
					} else {
						throw new BusinessException("分组名称重复请重新输入");
					}
				}
			}
			if (null != funUsersList && funUsersList.size() > 0) {
				// 清空分组下用户
				erpFunUsersMapper.clearUserForGroup(cityId, compId, deptId, grId, null, Const.DIC_DEFAULT_GROUP_ID);
				// 清空缓存
				erpFunUsersService.evictBaseInfoByCompId(cityId,compId);
				Map<Integer, ErpFunUsers> usersMap = funUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
				List<Integer> orginUserIdsList = funUsersList.stream().filter(val -> grId.equals(val.getGrId()))
						.collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
				Set<Integer> grIdsList = funUsersList.stream().collect(Collectors.mapping(ErpFunUsers::getGrId, Collectors.toSet()));
				grIdsList.add(grId);
				// 查询分组
				List<ErpFunDeptsgroup> deptGroupsByGrIds = erpFunDeptsgroupMapper.getDeptGroupsByGrIds(cityId, compId, grIdsList);
				Map<Integer, ErpFunDeptsgroup> deptsGroupMap = deptGroupsByGrIds.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, val -> val));
				if (null !=userIdsList && userIdsList.size() > 0) {
					// 分组插入用户
					erpFunUsersMapper.clearUserForGroup(cityId, compId, null, null, userIdsList, grId);
					// 清空缓存
					erpFunUsersService.evictBaseInfoByCompId(cityId, compId);
				}
				List<Integer> removeUserIdList = new ArrayList<>();
				List<Integer> addUserIdList = new ArrayList<>();
				// 分组信息修改比较
				this.compareList(userIdsList, orginUserIdsList, removeUserIdList, addUserIdList);
				if ((CommonUtil.isnull(removeUserIdList) && CommonUtil.isnull(addUserIdList)) && (!changeFlag)) {
					return groupId;
				}
				String changeContent = param.getSelfUserName() + " 修改了分组信息";
				BaseMapParam dataParam = new BaseMapParam();
				dataParam.setInteger("compId", compId);
				dataParam.setInteger("cityId", cityId);
				dataParam.setInteger("deptId", deptId);
				dataParam.setInteger("userId", param.getSelfUserId());
				erpSystemSettingLogsService.insertLog(SSL_TYPE.UPDATE_GR_DATA, null, changeContent, null, null, dataParam);
				ErpFunDeptsgroup erpFunDeptsgroup = deptsGroupMap.get(grId);
				// 调离分组写日志
				if (null != removeUserIdList && removeUserIdList.size() > 0) {
					for (Integer removeUserId : removeUserIdList) {
						ErpFunUsers erpFunUsers = usersMap.get(removeUserId);
						String removeContent = "将员工从" + erpFunDepts.getDeptName() + "-" + erpFunDeptsgroup.getGrName() + "调至" + erpFunDepts.getDeptName() + "- 未分组";
						erpFunEmployeeLogService.insertLog(cityId, compId, Const.DIC_STAFF_MOVE_TO_NEWGROUP, removeContent,
								erpFunUsers.getArchiveId(), param.getSelfUserId(), erpFunUsers.getDeptId(),
								erpFunUsers.getDeptId(), erpFunUsers.getUserPosition(), erpFunUsers.getUserPosition(),
								erpFunDeptsgroup.getGrId(), Const.DIC_DEFAULT_GROUP_ID);

					}
				}
				// 写调店记录
				// 原来的分组名
				String groupName = (null == erpFunDeptsgroup) ? "未分组" : erpFunDeptsgroup.getGrName();
				if (addUserIdList != null && addUserIdList.size() > 0) {
					for (Integer addUserId : addUserIdList) {
						// 找原来的分组
						ErpFunUsers erpFunUsers = usersMap.get(addUserId);
						ErpFunDeptsgroup funDeptsgroup = deptsGroupMap.get(erpFunUsers.getGrId());
						Integer beforeGrid =erpFunDeptsgroup==null?null: erpFunDeptsgroup.getGrId();
						Integer afterGrid =funDeptsgroup==null?null: funDeptsgroup.getGrId();
						String beforeGrName = null;
						if(null != funDeptsgroup){
							beforeGrName = funDeptsgroup.getGrName();
						}
						beforeGrName = (beforeGrName == null) ? "未分组":beforeGrName;
						String addContent = "将员工从" + erpFunDepts.getDeptName() + "-" + beforeGrName + "调至" + erpFunDepts.getDeptName() + "- " + groupName;
						erpFunEmployeeLogService.insertLog(cityId, compId, Const.DIC_STAFF_MOVE_TO_NEWGROUP, addContent, erpFunUsers.getArchiveId(), param.getSelfUserId(), erpFunUsers.getDeptId(), erpFunUsers.getDeptId(), erpFunUsers.getUserPosition(), erpFunUsers.getUserPosition(), beforeGrid, afterGrid);
					}
				}
				allChangedUserSet.addAll(usersMap.keySet());

				Set<Integer> needUpdateUserIdSet = new HashSet<>(removeUserIdList);
				needUpdateUserIdSet.addAll(addUserIdList);
				if(needUpdateUserIdSet.size() > 0) {
					List<ErpFunUsers> userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, needUpdateUserIdSet);
					userListByUserIds.stream().forEach(val-> {
						erpFunWageService.updateWageData(cityId, compId, val);
					});
				}

				// 全部取消的情况
				if(null == userIdsList || userIdsList.size() == 0 ) {

					// 这里其实是取消分组的操作
					funUsersList.stream().forEach(val-> {
						val.setGrId(0);
						erpFunWageService.updateWageData(cityId, compId, val);
					});
				}



			}
			// 清空缓存
			erpFunUsersService.evictBaseInfoByCompId(cityId, compId);
			//erpFunDeptsgroupMapper.updateByDeptGrId(cityId, param);
			ErpFunDeptsgroup erpFunDeptsgroup = new ErpFunDeptsgroup();
			erpFunDeptsgroup.setShardCityId(cityId);
			erpFunDeptsgroup.setGrId(param.getGrId());
			erpFunDeptsgroup.setGrName(param.getGrName());
			erpFunDeptsgroup.setSeqNo(param.getSeqNo());
			erpFunDeptsgroup.setDeptId(param.getDeptId());
			erpFunDeptsgroup.setAdminUser(param.getAdminUser());
			erpFunDeptsgroup.setGrContact(param.getGrContact());
			erpFunDeptsgroup.setGrTele(param.getGrTele());
			erpFunDeptsgroup.setGrDesc(param.getGrDesc());
			erpFunDeptsgroup.setUpdateUid(param.getSelfUserId());
			erpFunDeptsgroup.setUpdateTime(DateTimeHelper.getTimeNow());
			erpFunDeptsgroup.setPartnerId(erpFunDepts.getPartnerId());
			erpFunDeptsgroupMapper.updateByPrimaryKeySelective(erpFunDeptsgroup);
		} else {// 新建分组
			Integer groupCount = erpFunDeptsgroupMapper.countGroupByGrName(cityId, compId, deptId, param.getGrName());
			if (groupCount > 0 ) {
//				ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
				if(null != erpFunDepts.getIsHeadquarters() && "1".equals(erpFunDepts.getIsHeadquarters().toString())){
					throw new BusinessException("部门名称重复请重新输入");
				} else {
					throw new BusinessException("分组名称重复请重新输入");
				}
			}
			ErpFunDeptsgroup insertModel = new ErpFunDeptsgroup();
			insertModel.setAdminUser(param.getAdminUser());
			insertModel.setCompId(compId);
			insertModel.setDeptId(deptId);
			insertModel.setGrContact(param.getGrContact());
			insertModel.setGrDesc(param.getGrDesc());
			insertModel.setGrName(param.getGrName());
			insertModel.setGrTele(param.getGrTele());
			insertModel.setIsDel((byte) 0);
			insertModel.setSeqNo(param.getSeqNo());
			insertModel.setUpdateUid(param.getSelfUserId());
			insertModel.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
			insertModel.setShardCityId(cityId);
			insertModel.setPartnerId(erpFunDepts.getPartnerId());
			erpFunDeptsgroupMapper.insertSelective(insertModel);
			// 查询原来的分组
			if (userIdsList.size() > 0) {
				List<ErpFunUsers> funUsesrList = erpFunUsersMapper.getErpFunUsersList(cityId, userIdsList);
				Map<Integer, ErpFunUsers> usersMap = funUsesrList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
				Set<Integer> grIdsList = funUsesrList.stream().collect(Collectors.mapping(ErpFunUsers::getRegId, Collectors.toSet()));
				grIdsList.add(insertModel.getGrId());
				List<ErpFunDeptsgroup> deptGroupsByGrIds = erpFunDeptsgroupMapper.getDeptGroupsByGrIds(cityId, compId, grIdsList);
				Map<Integer, String> grNameMap = deptGroupsByGrIds.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, ErpFunDeptsgroup::getGrName));
				for (Integer users : userIdsList) {
					ErpFunUsers erpFunUsers = usersMap.get(users);
					ErpFunDepts erpFunDeptsTmp = erpFunDeptsMapper.getDeptByCompIdAndDeptId(cityId,compId, erpFunUsers.getDeptId());
					// 原来分组
					String grName = (null != grNameMap.get(erpFunUsers.getGrId()))?grNameMap.get(erpFunUsers.getGrId()):"未分组";
					String addContent = "将员工从"+erpFunDeptsTmp.getDeptName()+"-"+ grName+"调至"+erpFunDeptsTmp.getDeptName()+"-"+ param.getGrName();
					erpFunEmployeeLogService.insertLog(cityId, compId, Const.DIC_STAFF_MOVE_TO_NEWGROUP, addContent,
							erpFunUsers.getArchiveId(), param.getSelfUserId(), erpFunUsers.getDeptId(),
							erpFunUsers.getDeptId(), erpFunUsers.getUserPosition(), erpFunUsers.getUserPosition(),
							erpFunUsers.getGrId(), insertModel.getGrId());
				}
				allChangedUserSet.addAll(usersMap.keySet());
				// 分组插入用户
				erpFunUsersMapper.clearUserForGroup(cityId, compId, deptId, null, userIdsList,  insertModel.getGrId());
				funUsesrList.stream().forEach(val-> {
					erpFunWageService.updateWageData(cityId, compId, val);
				});

			}
			groupId = insertModel.getGrId();
			//清理缓存
			evictCacheableModelData(compId, cityId);
		}
		if(allChangedUserSet.size() > 0) {
			// 异步执行，发送jms消息修改数据所属
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
					sendForUpdateUser(param.getCityId(), new ArrayList<>(allChangedUserSet), param.getCompId(), param.getCompId(), null, null);
				}
			});
		}
		return groupId;
	}

	/**
	 * 分组信息修改比较
	 * @param userIdsList
	 * @param orginUserIdsList
	 * @param removeUserIdList
	 * @param addUserIdList
	 */
	private void compareList(List<Integer> userIdsList, List<Integer> orginUserIdsList, List<Integer> removeUserIdList,
			List<Integer> addUserIdList) {
		// 两个都为空，只是修改空分组的资料
		if (userIdsList == null && orginUserIdsList.isEmpty()) {
		} else if (userIdsList == null && orginUserIdsList.size() > 0) {
			// 全部移走
			removeUserIdList = orginUserIdsList;
		} else if (userIdsList.size() > 0 && orginUserIdsList.isEmpty()) {
			// 全部新增
			addUserIdList.addAll(userIdsList);
		} else if (userIdsList.size() > 0 && orginUserIdsList.size() > 0) {
			// 修改
			for (Integer targertUserid : userIdsList) {
				// 判断在原来的分组中是否有此人
				if (!orginUserIdsList.contains(targertUserid)) {
					addUserIdList.add(targertUserid);
				}
			}
			for (Integer orignUserId : orginUserIdsList) {
				// 判断在原来的分组中是否有此人
				if (!userIdsList.contains(orignUserId)) {
					removeUserIdList.add(orignUserId);
				}
			}
		}
	}

	@Transactional
	@Override
	public void deleteGroup(DeleteGroupParam param) {
		ErpFunDeptsgroup updateModel = new ErpFunDeptsgroup();
		updateModel.setIsDel((byte) 1);
		updateModel.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
		updateModel.setUpdateUid(param.getSelfUserId());
		updateModel.setDeptId(param.getDeptId());
		updateModel.setGrId(param.getGrId());
		updateModel.setShardCityId(param.getCityId());
		updateModel.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunDeptsgroupMapper.updateByPrimaryKeySelective(updateModel);
		// 删除分组写员工调动记录
		ErpFunUsersExample example = new ErpFunUsersExample();
		example.createCriteria().andGrIdEqualTo(param.getGrId()).andDeptIdEqualTo(param.getDeptId()).andCompIdEqualTo(param.getCompId()).andUserWriteoffEqualTo(false);
		example.setShardCityId(param.getCityId());
		List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectByExample(example);
		// 删除分组的员工userId
		List<Integer> removeUserIds = funUsersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
		Map<Integer, ErpFunUsers> usersMap = funUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
		// 查询门店
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setDeptId(param.getDeptId());
		erpFunDepts.setShardCityId(param.getCityId());
		erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(erpFunDepts);
		// 删除分组写日志
		ErpFunDeptsgroup erpFunDeptsgroup = erpFunDeptsgroupMapper.getDataByGrId(param.getCityId(), param.getGrId());
		String grName = (null == erpFunDeptsgroup.getGrName()) ? "未分组" : erpFunDeptsgroup.getGrName();
		if (null != removeUserIds && removeUserIds.size() > 0) {
			for (Integer removeUserId : removeUserIds) {
				ErpFunUsers erpFunUsers = usersMap.get(removeUserId);
				String removeContent = "将员工从" + erpFunDepts.getDeptName() + "-" + grName + "调至" + erpFunDepts.getDeptName() + "- 未分组";
				erpFunEmployeeLogService.insertLog(param.getCityId(), param.getCompId(), Const.DIC_STAFF_MOVE_TO_NEWGROUP, removeContent,
						erpFunUsers.getArchiveId(), param.getSelfUserId(), erpFunUsers.getDeptId(),
						erpFunUsers.getDeptId(), erpFunUsers.getUserPosition(), erpFunUsers.getUserPosition(),
						erpFunDeptsgroup.getGrId(), Const.DIC_DEFAULT_GROUP_ID);
			}
		}
		erpFunUsersMapper.clearUserForGroup(param.getCityId(), param.getCompId(), param.getDeptId(), param.getGrId(), null, Const.DIC_DEFAULT_GROUP_ID);
		if(removeUserIds.size() > 0) {
			// 异步执行，发送jms消息修改数据所属
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
					sendForUpdateUser(param.getCityId(), removeUserIds, param.getCompId(), param.getCompId(), null, null);
				}
			});
		}
		// 清理分组缓存
		evictCacheableModelData(param.getCompId(),param.getCityId());
	}

	@Override
	public void evictCacheableModelData(Integer compId,Integer cityId) {
	    cacheUtil.del(CacheStructure.hfterpdb_funDeptsgroupCache_by_COMP_ID + compId+"_CITY_ID_"+cityId);
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
