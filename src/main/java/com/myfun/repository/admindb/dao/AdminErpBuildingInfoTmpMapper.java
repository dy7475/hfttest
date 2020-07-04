package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminErpBuildingInfoTmp;
import com.myfun.repository.admindb.po.AdminErpBuildingInfoTmpExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

public interface AdminErpBuildingInfoTmpMapper extends BaseMapper<AdminErpBuildingInfoTmp, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminErpBuildingInfoTmpExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminErpBuildingInfoTmpExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminErpBuildingInfoTmp> selectByExample(AdminErpBuildingInfoTmpExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminErpBuildingInfoTmp record,
			@Param("example") AdminErpBuildingInfoTmpExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminErpBuildingInfoTmp record,
			@Param("example") AdminErpBuildingInfoTmpExample example);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param conditionModel
	 */
	AdminErpBuildingInfoTmp selectBuildInfoTmp(@Param("conditionModel") AdminErpBuildingInfoTmp conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param param
	 * @param conditionModel
	 */
	void updateAdminErpBuildingInfoTmp(@Param("updateModel") DaoBaseParam param, @Param("conditionModel") AdminErpBuildingInfoTmp conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param param
	 */
	void insertAdminErpBuildingInfoTmp(@Param("insertModel") DaoBaseParam param);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param buildId
	 * @return
	 */
	AdminErpBuildingInfoTmp selectTopOneBuildInfoTmp(@Param("buildId") Integer buildId);

	Integer getCheckFlag(@Param("param") Map<String, Object> param);

	void insertBuilInfoTmp(BuildingInfoTmpParam param);
}