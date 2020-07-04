package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminBuildingInfoTmp;
import com.myfun.repository.admindb.po.AdminBuildingInfoTmpExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

public interface AdminBuildingInfoTmpMapper extends BaseMapper<AdminBuildingInfoTmp, Integer> {
	/**
	 *
	 * @mbggenerated
	 */
	int countByExample(AdminBuildingInfoTmpExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int deleteByExample(AdminBuildingInfoTmpExample example);

	/**
	 *
	 * @mbggenerated
	 */
	List<AdminBuildingInfoTmp> selectByExample(AdminBuildingInfoTmpExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminBuildingInfoTmp record,
			@Param("example") AdminBuildingInfoTmpExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminBuildingInfoTmp record,
			@Param("example") AdminBuildingInfoTmpExample example);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param conditionModel
	 */
	AdminBuildingInfoTmp selectBuildInfoTmp(@Param("conditionModel") AdminBuildingInfoTmp conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param param
	 * @param conditionModel
	 */
	void updateAdminBuildingInfoTmp(@Param("updateModel") DaoBaseParam param, @Param("conditionModel") AdminBuildingInfoTmp conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param param
	 */
	void insertAdminBuildingInfoTmp(@Param("insertModel") DaoBaseParam param);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param buildId
	 * @return
	 */
	AdminBuildingInfoTmp selectTopOneBuildInfoTmp(@Param("buildId") Integer buildId);

	Integer getCheckFlag(@Param("param") Map<String, Object> param);
}