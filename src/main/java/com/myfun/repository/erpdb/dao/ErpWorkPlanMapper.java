package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpWorkPlan;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpWorkPlanMapper extends BaseMapper<ErpWorkPlan, ErpWorkPlan> {

	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 * @param cityId
	 * @param wlId
	 * @return
	 */
	List<ErpWorkPlan> selectWorKPlanListByWlid(@Param("shardCityId")Integer cityId, @Param("wlId")Integer wlId);
	/**
	 * 删除原有工作计划
	 * @author 何传强
	 * @since 2017年6月15日
	 * @param cityId
	 * @param wlId
	 */
	void deleteOldWorkPlan(@Param("shardCityId") Integer cityId, @Param("wlId") Integer wlId);
}