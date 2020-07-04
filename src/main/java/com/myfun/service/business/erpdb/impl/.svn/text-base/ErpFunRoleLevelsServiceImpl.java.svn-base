package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.erpWeb.managecenter.sysmanager.param.RoleLevelParam;
import com.myfun.repository.erpdb.dao.ErpFunRoleLevelsMapper;
import com.myfun.repository.erpdb.po.ErpFunRoleLevels;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunRoleLevelsService;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpFunRoleLevelsServiceImpl extends AbstractService<ErpFunRoleLevels, ErpFunRoleLevels> implements ErpFunRoleLevelsService {
	
	@Autowired 
	ErpFunRoleLevelsMapper erpFunRoleLevelsMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunRoleLevelsMapper;
	}

	@Override
	public ErpFunRoleLevels updateRoleLevelInfo(Integer compId, Integer userId, Integer roleLevelId) {
		//TODO 暂未通用业务实现
		
		return null;
	}
	
	@Override
	@Transactional
	public void addOrEditRoleLevelData(Integer cityId, Integer compId, String roleId, List<RoleLevelParam> roleLevelList) {
		Integer maxLevelsSeqNO = this.getMaxRoleLevelSeqNO(cityId, compId, roleId);
		for (RoleLevelParam roleLevelParam : roleLevelList){
			ErpFunRoleLevels erpFunRoleLevels = new ErpFunRoleLevels();
			erpFunRoleLevels.setShardCityId(cityId);
			erpFunRoleLevels.setRoleLevelId(roleLevelParam.getRoleLevelId());
			erpFunRoleLevels.setRoleLevelName(roleLevelParam.getRoleLevelName());
			erpFunRoleLevels.setSeqNo(roleLevelParam.getSeqNo());
			if (erpFunRoleLevels.getRoleLevelId() != null){
				erpFunRoleLevelsMapper.updateByPrimaryKeySelective(erpFunRoleLevels);
			}else {
				erpFunRoleLevels.setRoleId(roleId);
				erpFunRoleLevels.setSeqNo(maxLevelsSeqNO);
				erpFunRoleLevels.setCreationTime(DateTimeHelper.getSystemDate());
				erpFunRoleLevels.setCompId(compId);
				erpFunRoleLevels.setRoleLevelStatus((byte) 1);
				erpFunRoleLevelsMapper.insertSelective(erpFunRoleLevels);
				maxLevelsSeqNO++;
			}
		}
	}
	
	/**
	 * 生成职级序号
	 * @Package com.myfun.service.business.erpdb.impl 
	 * @author 陈文超   
	 * @date 2019年7月30日 下午8:03:41
	 */
	private Integer getMaxRoleLevelSeqNO(Integer cityId, Integer compId, String roleId) {
		Integer maxSeqInt = 1;
		Integer maxSeq = erpFunRoleLevelsMapper.getMaxRoleLevelSeqNo(cityId, compId, roleId);
		if(null != maxSeq) {
			maxSeqInt = maxSeq + 1;
		}
		return maxSeqInt;
	}
}


