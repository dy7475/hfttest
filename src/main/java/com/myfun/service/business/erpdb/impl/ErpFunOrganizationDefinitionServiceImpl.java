package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunOrganizationDefinitionMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationManagerMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunUserManageRangeMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinition;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinitionExample;
import com.myfun.repository.erpdb.po.ErpFunOrganizationExample;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.repository.erpdb.po.ErpFunUserManageRange;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunOrganizationDefinitionService;
import com.myfun.utils.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ErpFunOrganizationDefinitionServiceImpl extends AbstractService<ErpFunOrganizationDefinition, ErpFunOrganizationDefinition> implements ErpFunOrganizationDefinitionService {

	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;
	@Autowired
	ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunOrganizationDefinitionMapper;
	}

	@Override
	public List<ErpFunOrganizationDefinition> getAllEffectiveOrganizationDefinition(Integer cityId, Integer compId) {
		ErpFunOrganizationDefinitionExample erpFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
		erpFunOrganizationDefinitionExample.setShardCityId(cityId);
		erpFunOrganizationDefinitionExample.createCriteria().andCompIdEqualTo(compId).andDelFlagEqualTo((byte) 0);
		erpFunOrganizationDefinitionExample.setOrderByClause(" DEFINITION_LEVEL ASC ");
		List<ErpFunOrganizationDefinition> erpFunOrganizationDefinitions = erpFunOrganizationDefinitionMapper.selectByExample(erpFunOrganizationDefinitionExample);
		return erpFunOrganizationDefinitions;
	}

	
	
	/**
	 * 获取当前层级路径中orgPath中，层级id为tmpId的组织机构id
	 */
	@Override
	public String getCurrentPathLevelId(Integer cityId, Integer compId, String orgPath, Integer tmpId) {
		if (tmpId==null) {
			return null;
		}
		if (StringUtils.isNotBlank(orgPath)) {
			String[] orgIds = orgPath.split(":");
			List<Integer> orgIdList = new ArrayList<>();
			boolean flag = false;
			for (String orgIdStr:orgIds) {
				if (StringUtils.isNotBlank(orgIdStr) && !":".equals(orgIdStr)) {
					orgIdList.add(StringUtil.parseInteger(orgIdStr,0));
					flag = true;
				}
			}
			if (flag) {
				ErpFunOrganizationExample example = new ErpFunOrganizationExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId).andOrganizationIdIn(orgIdList);
				List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectByExample(example);
				Map<Integer,Integer> orgIdMap = orgList.stream().filter(org->org.getOrganizationDefinitionId()!=null).collect(Collectors.toMap(ErpFunOrganization::getOrganizationDefinitionId, ErpFunOrganization::getOrganizationId));
				return orgIdMap.get(tmpId)!=null?orgIdMap.get(tmpId).toString():null;
			}
		}
		return null;
	}
	
	/**
	 * 判断一个经济人所属的组织机构path的是否能够看到房源，或者客源的path
	 * @author Administrator
	 * @param cityId:城市id compId:当前用户的公司id,userId：要检查的人员的userId,
	 * 有些地方能够取到人员的path的时候用userPath,casePath信息所在的路径，人员的层级
	 */
	@Override
	public boolean currentUserHasOneLevelOperOffCaseOrgPath(Integer cityId, Integer compId, Integer userId,
			String userPath, String casePath,Integer caseUserId, Integer operDefId) {
		if (userId==null) {
			return false;
		}
		//先判断是否是公司
		if (Integer.valueOf("0").equals(operDefId)) {
			return true;
		}
		if (userId.equals(caseUserId)) {
			return true;
		}
		if (StringUtil.isBlank(userPath)) {
			ErpFunUsers users = erpFunUsersMapper.selectByUserId(cityId, userId);
			userPath = users.getTissueLine();
		}
		
		List<ErpFunUserManageRange> orgManagers = erpFunUserManageRangeMapper.selectByCompIdAndUserId(cityId, compId, userId);
		if (!orgManagers.isEmpty()) {
			for (ErpFunUserManageRange org:orgManagers) {
				Integer orgId = org.getRangeId();
				if (casePath.contains(":"+orgId+":")) {
					return true;
				}
			}
		}
		//判断是否是个人
		if (operDefId ==null) {
			return false;
		}
		String orgId = getCurrentPathLevelId(cityId, compId, casePath, operDefId);
		if (StringUtils.isNotBlank(orgId)) {
			if (StringUtils.isNotBlank(userPath)) {
				return userPath.contains(":"+orgId+":");
			}
		} else {
			Integer userFirstLevelId = getLatestLevelOrgIdLessthanOperDefId(cityId, compId, userPath,operDefId);
			Integer caseFirstLevelId = getLatestLevelOrgIdLessthanOperDefId(cityId, compId, casePath,operDefId);
			if (Objects.equals(caseFirstLevelId, userFirstLevelId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean judgePermissionByOrganizationPath(Integer cityId, Integer compId, Integer userId, String casePath, Integer operDefId) {
		//管理权限为全司
		if (Objects.equals(operDefId, 0)) {
			return true;
		}
		ErpFunUsers users = erpFunUsersMapper.selectByUserId(cityId, userId);
		String userPath = null != users ? users.getTissueLine() : null;
		String operOrganizationId = getCurrentPathLevelId(cityId, compId, userPath, operDefId);
		if (StringUtils.isNotBlank(operOrganizationId) && StringUtils.isNotBlank(casePath)) {
			return casePath.contains(":"+operOrganizationId+":");
		}
		return false;
	}
	
	public Integer getLatestLevelOrgIdLessthanOperDefId(Integer cityId, Integer compId, String orgPath, Integer operDefId) {
		if (StringUtils.isNotBlank(orgPath)) {
			String[] orgArr = orgPath.split(":");
			List<Integer> orgIds = new ArrayList<>();
			boolean flag = false;
			for (String orgId:orgArr) {
				if (StringUtils.isNotBlank(orgId) && !":".equals(orgId)) {
					flag = true;
					orgIds.add(StringUtil.parseInteger(orgId, 0));
				}
				
			}
			if (flag) {
				return erpFunOrganizationMapper.getLatestLevelOrgIdLessthanDefId(cityId,compId,orgIds,operDefId);
			}
		}
		return null;
	}
}
