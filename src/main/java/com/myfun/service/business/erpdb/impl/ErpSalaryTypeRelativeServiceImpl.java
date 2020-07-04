package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunRoleWageConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSalaryTypeRelativeMapper;
import com.myfun.repository.erpdb.po.ErpFunRoleWageConfig;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpSalaryTypeRelative;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpSalaryTypeRelativeService;

@Service
public class ErpSalaryTypeRelativeServiceImpl extends AbstractService<ErpSalaryTypeRelative, ErpSalaryTypeRelative> implements ErpSalaryTypeRelativeService{
	
	@Autowired 
	private ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	
	@Autowired 
	private ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	
	@Autowired 
	private ErpFunUsersMapper erpFunUsersMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpSalaryTypeRelativeMapper;
	}

	@Override
	public void initUserBaseSalaryTypeRelative(Integer cityId, Integer compId, String roleId, Integer roleWageConfigId) {
		// 关联到人数据
		// 查询角色上所有人
		if(roleWageConfigId != null && roleWageConfigId > 0){
			ErpFunRoleWageConfig erpFunRoleWageConfig = new ErpFunRoleWageConfig();
			erpFunRoleWageConfig.setShardCityId(cityId);
			erpFunRoleWageConfig.setId(roleWageConfigId);
			erpFunRoleWageConfig = erpFunRoleWageConfigMapper.selectByPrimaryKey(erpFunRoleWageConfig);
			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByRoleAndRoleLevel(cityId, roleId, erpFunRoleWageConfig.getRoleLevelId(), compId);
			if (CollectionUtils.isNotEmpty(userList)) {
				for (ErpFunUsers erpFunUsers : userList) {
					ErpSalaryTypeRelative erpSalaryTypeRelative = new ErpSalaryTypeRelative();
					erpSalaryTypeRelative.setShardCityId(cityId);
					erpSalaryTypeRelative.setCompId(erpFunUsers.getCompId());
					erpSalaryTypeRelative.setSalaryTypeId(roleWageConfigId);
					erpSalaryTypeRelative.setAreaId(erpFunUsers.getAreaId());
					erpSalaryTypeRelative.setDeptId(erpFunUsers.getDeptId());
					erpSalaryTypeRelative.setCreationTime(new Date());
					erpSalaryTypeRelative.setGrId(erpFunUsers.getGrId());
					erpSalaryTypeRelative.setRegId(erpFunUsers.getRegId());
					erpSalaryTypeRelative.setRoleId(erpFunUsers.getUserPosition());
					erpSalaryTypeRelative.setUserId(erpFunUsers.getUserId());
					erpSalaryTypeRelativeMapper.insertSelective(erpSalaryTypeRelative);
				}
			}
		}
	}
}
