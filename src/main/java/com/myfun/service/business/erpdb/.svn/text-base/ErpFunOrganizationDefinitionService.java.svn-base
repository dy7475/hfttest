package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinition;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunOrganizationDefinitionService extends BaseMapper<ErpFunOrganizationDefinition, ErpFunOrganizationDefinition>{
	
	List<ErpFunOrganizationDefinition> getAllEffectiveOrganizationDefinition(Integer cityId, Integer compId);
	
	String getCurrentPathLevelId(Integer cityId,Integer compId,String orgPath,Integer defId);
	
	boolean currentUserHasOneLevelOperOffCaseOrgPath(Integer cityId,Integer compId,Integer userId,String userPath,String casePath,Integer caseUserId,Integer operDefId);
	
	/**
	 * 通过数据的组织架构路径判断是否有权限操作数据
	 * @param cityId 城市id
	 * @param compId erp公司id
	 * @param userId erp用户id
	 * @param casePath 数据上的组织架构路径
	 * @param operDefId 权限上的组织架构层级id
	 * @return boolean
	 */
	@Deprecated
	boolean judgePermissionByOrganizationPath(Integer cityId,Integer compId,Integer userId, String casePath, Integer operDefId);
}
