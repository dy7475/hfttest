package com.myfun.repository.erpdb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpBuildingInfoTmp;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * admin库去维护
 * @author 张宏利
 * @since 2017年7月13日
 */
@Deprecated
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpBuildingInfoTmpMapper extends BaseMapper<ErpBuildingInfoTmp, ErpBuildingInfoTmp> {

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param conditionModel
	 */
	ErpBuildingInfoTmp selectBuildInfoTmp(@Param("shardCityId")Short cityId,@Param("conditionModel") ErpBuildingInfoTmp conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param param
	 * @param conditionModel
	 */
	
	
	void updateErpBuildingInfoTmp(@Param("shardCityId")Short cityId,@Param("updateModel") DaoBaseParam param, @Param("conditionModel")ErpBuildingInfoTmp conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param param
	 */
	
	
	void insertErpBuildingInfoTmp(@Param("shardCityId")Short cityId,@Param("insertModel") DaoBaseParam param);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param buildId
	 * @return
	 */
	
	
	ErpBuildingInfoTmp selectTopOneBuildInfoTmp(@Param("shardCityId")Short cityId, @Param("buildId")Integer buildId);
	
	Integer getCheckFlag(@Param("shardCityId")Integer cityId,@Param("param")Map<String,Object> param);
}