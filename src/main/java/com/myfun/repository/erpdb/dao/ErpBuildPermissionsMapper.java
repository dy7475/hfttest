package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpBuildPermissions;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpBuildPermissionsMapper extends BaseMapper<ErpBuildPermissions, ErpBuildPermissions> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildPermissionsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildPermissionsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildPermissions> selectByExample(ErpBuildPermissionsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildPermissions record,
			@Param("example") ErpBuildPermissionsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildPermissions record,
			@Param("example") ErpBuildPermissionsExample example);

	List<ErpBuildPermissions> getBuildPermissionsList(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("organizationId") Integer organizationId,@Param("buildId") Integer buildId,@Param("buildRegion") Integer buildRegion,@Param("houseUseage") Integer houseUseage);
	
	ErpBuildPermissions getBuildPermissions(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("organizationId") Integer organizationId,@Param("buildId") Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildPermissions> selectByorgIds(@Param("shardCityId")Integer cityId,@Param("orgIdList") List<Integer> orgIdList,@Param("buildId") Integer buildId);
}