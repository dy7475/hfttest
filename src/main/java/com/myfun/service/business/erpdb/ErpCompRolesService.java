package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.sysmanager.param.CompRolesParam;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Set;


public interface ErpCompRolesService extends BaseMapper<ErpCompRoles, ErpCompRoles>{
	
	String addCompRoles(Integer cityId, Integer compId, Integer deptId, Integer userId, String roleName, Integer manageLevel, String beforRoleId, Byte partStatistCount);
	
	/**
	 * 修改管理层级
	 * @param cityId
	 * @param compId
	 * @param roleId
	 * @param manageLevel
	 */
	void updateRoleManageLevel(Integer cityId, Integer compId, String roleId, Byte manageLevel);
	
	/**
	 * 修改已有角色名字
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年3月6日
	 */
	void updateCompRolesName(Integer cityId, Integer compId, Integer deptId, Integer userId, String roleId, String roleName, String userName, Byte partStatistCount);

    void updateUserOpers(Integer cityId,Integer compId, String tmpField, String columnName, String columnValue, String roleId, Set<String> deleteOpers, Set<String> ptOperAdd, List<Byte> flagList);

	void deleteCompRoles(CompRolesParam param, Integer autoId, String roleName, String roleId);
}
