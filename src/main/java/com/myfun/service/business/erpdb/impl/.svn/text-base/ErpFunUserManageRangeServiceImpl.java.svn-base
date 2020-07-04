package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunOrganizationManagerMapper;
import com.myfun.repository.erpdb.dao.ErpFunUserManageRangeMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.repository.erpdb.po.ErpFunUserManageRange;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAuditRuntimeService;
import com.myfun.service.business.erpdb.ErpFunUserManageRangeService;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpFunUserManageRangeServiceImpl extends AbstractService<ErpFunUserManageRange, ErpFunUserManageRange> implements ErpFunUserManageRangeService{
	@Autowired private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired private ErpAuditRuntimeService erpAuditRuntimeService;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunUserManageRangeMapper;
	}


	@Override
	public void updateUserManageRange(Integer cityId, Integer compId, Integer userId, Integer rangeType, String rangeIds, String roleId, boolean isFangJidi) {
		// 先删除配置
		erpFunUserManageRangeMapper.deleteByUserId(cityId, compId, userId);
		if (rangeType != null && rangeType == 1) {
			rangeIds = compId.toString();
		}
		if(StringUtils.isNotBlank(rangeIds) && rangeType != null) {
			// 再重新配置
			Date dateNow = new Date();
			List<ErpFunUserManageRange> rangeList = new LinkedList<>();
			String[] rangeIdArr = rangeIds.split(",");
			for (String rangeId : rangeIdArr) {
				ErpFunUserManageRange erpFunUserManageRange = new ErpFunUserManageRange();
				erpFunUserManageRange.setCreationTime(dateNow);
				erpFunUserManageRange.setRangeId(StringUtil.parseInteger(rangeId, 0));
				erpFunUserManageRange.setRangeType(rangeType);
				erpFunUserManageRange.setUserId(userId);
				erpFunUserManageRange.setCompId(compId);
				erpFunUserManageRange.setRoleId(roleId);
				erpFunUserManageRange.setManageType((byte)1);
				rangeList.add(erpFunUserManageRange);
			}
			erpFunUserManageRangeMapper.insertList(cityId, rangeList);
		}
		erpAuditRuntimeService.createAuditUserForUserChangeNoTransactional(cityId, compId, roleId, userId, isFangJidi);
	}
	
	@Override
	public void updateFangjiDiUserManageRange(Integer cityId, Integer compId, Integer userId, Integer rangeType, String rangeIds, String roleId, boolean isFangJidi) {
		// 先删除配置
		erpFunUserManageRangeMapper.deleteByUserId(cityId, compId, userId);
		if (rangeType != null && rangeType == 1) {
			rangeIds = compId.toString();
		}
		if(StringUtils.isNotBlank(rangeIds) && rangeType != null) {
			// 再重新配置
			Date dateNow = new Date();
			List<ErpFunUserManageRange> rangeList = new LinkedList<>();
			String[] rangeIdArr = rangeIds.split(",");
			for (String rangeId : rangeIdArr) {
				ErpFunUserManageRange erpFunUserManageRange = new ErpFunUserManageRange();
				erpFunUserManageRange.setCreationTime(dateNow);
				erpFunUserManageRange.setRangeId(StringUtil.parseInteger(rangeId, 0));
				erpFunUserManageRange.setRangeType(rangeType);
				erpFunUserManageRange.setUserId(userId);
				erpFunUserManageRange.setCompId(compId);
				erpFunUserManageRange.setRoleId(roleId);
				rangeList.add(erpFunUserManageRange);
			}
			erpFunUserManageRangeMapper.insertList(cityId, rangeList);
		}
		erpAuditRuntimeService.createAuditUserForFangJiDiRoleChangeNoTransactional(cityId, compId, roleId, userId, isFangJidi);
	}



	@Transactional
	@Override
	public void createRangeForComp(Integer cityId, String roleId, Integer compId) {
		List<ErpFunUsers> listForRole = erpFunUsersMapper.getUserListForRole(cityId, roleId, null, compId);
		if(listForRole != null && listForRole.size() > 0) {
			List<ErpFunUserManageRange> rangeList = new LinkedList<>();
			for (ErpFunUsers erpFunUsers : listForRole) {
				ErpFunUserManageRange rangTemp = new ErpFunUserManageRange();
				rangTemp.setUserId(erpFunUsers.getUserId());
				rangTemp.setCompId(erpFunUsers.getCompId());
				rangTemp.setCreationTime(new Date());
				rangTemp.setRangeId(compId);
				rangTemp.setRangeType(1);
				rangTemp.setRoleId(roleId);
				rangeList.add(rangTemp);
			}
			erpFunUserManageRangeMapper.insertList(cityId, rangeList);
		}
	}

	/**
	 * @title 新版组织机构修改管理范围
	 * @author Lee
	 * @date 2019/12/6 19:35getWageLogList
	 ***/
	@Override
	public void updateUserManageRangeNewOrg(Integer cityId, Integer compId, Integer userId, String rangeIds, String roleId) {
		// 先删除配置
		erpFunUserManageRangeMapper.deleteByUserId(cityId, compId, userId);
		// 在添加层级
		// 查询管理层级
		List<ErpFunOrganizationManager> managerListByUserId = erpFunOrganizationManagerMapper.getManagerListByUserId(cityId, compId, userId);

		Set<Integer> manageIdSet = new HashSet<>();
		if(StringUtils.isNotBlank(rangeIds)) {
			String[] rangeIdArr = rangeIds.split(",");
			for (String rangeIdStr : rangeIdArr) {
				Integer rangeId = StringUtil.parseInteger(rangeIdStr, null);
				if(null != rangeId) {
					manageIdSet.add(rangeId);
				}
			}
		}



		Date dateNow = new Date();
		List<ErpFunUserManageRange> rangeList = new LinkedList<>();
		for (Integer rangeId : manageIdSet) {
			ErpFunUserManageRange erpFunUserManageRange = new ErpFunUserManageRange();
			erpFunUserManageRange.setCreationTime(dateNow);
			erpFunUserManageRange.setRangeId(rangeId);
			erpFunUserManageRange.setUserId(userId);
			erpFunUserManageRange.setCompId(compId);
			erpFunUserManageRange.setRoleId(roleId);
			erpFunUserManageRange.setManageType((byte) 1);
			rangeList.add(erpFunUserManageRange);
		}

		if(managerListByUserId.size() > 0) {
			Set<Integer> manageOrganizationIdSet = managerListByUserId.stream().collect(Collectors.mapping(val -> val.getOrganizationId(), Collectors.toSet()));
			for (Integer rangeId : manageOrganizationIdSet) {
				ErpFunUserManageRange erpFunUserManageRange = new ErpFunUserManageRange();
				erpFunUserManageRange.setCreationTime(dateNow);
				erpFunUserManageRange.setRangeId(rangeId);
				erpFunUserManageRange.setUserId(userId);
				erpFunUserManageRange.setCompId(compId);
				erpFunUserManageRange.setRoleId(roleId);
				erpFunUserManageRange.setManageType((byte) 2);
				rangeList.add(erpFunUserManageRange);
			}
		}

		if(rangeList.size() > 0) {
			erpFunUserManageRangeMapper.insertList(cityId, rangeList);
		}


		erpAuditRuntimeService.createAuditUserForUserChangeNoTransactionalNewOrg(cityId, compId, roleId, userId);
	}
}


