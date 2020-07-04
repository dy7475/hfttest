package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunCompPermissionTemplate;
import com.myfun.repository.erpdb.po.ErpFunCompRolesPermissionTemplateRelate;
import com.myfun.repository.erpdb.po.ErpFunCompRolesPermissionTemplateRelateExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunCompRolesPermissionTemplateRelateMapper extends BaseMapper<ErpFunCompRolesPermissionTemplateRelate, ErpFunCompRolesPermissionTemplateRelate> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunCompRolesPermissionTemplateRelateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunCompRolesPermissionTemplateRelateExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunCompRolesPermissionTemplateRelate> selectByExample(
			ErpFunCompRolesPermissionTemplateRelateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunCompRolesPermissionTemplateRelate record,
			@Param("example") ErpFunCompRolesPermissionTemplateRelateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunCompRolesPermissionTemplateRelate record,
			@Param("example") ErpFunCompRolesPermissionTemplateRelateExample example);
	
	Integer getTemplateIdByRoleId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("roleId") String roleId);
}