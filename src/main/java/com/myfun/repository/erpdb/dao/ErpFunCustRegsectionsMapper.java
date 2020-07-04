package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunCustRegsections;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunCustRegsectionsMapper extends BaseMapper<ErpFunCustRegsections, ErpFunCustRegsections> {

	/**
	 * 数据分析首页-买卖楼盘供需量对比-热点商圈客户、房源排名
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @return
	 */
	List<Map<String,Object>> getBuildSupplyDemandComparisonForBuy(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 数据分析首页-租赁楼盘供需量对比-热点商圈客户、房源排名
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @return
	 */
	List<Map<String,Object>> getBuildSupplyDemandComparisonForRent(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	List<Map<String,String>> selectCustSectionIdsByRegionIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("caseType") Integer caseType,
															 @Param("caseId") Integer caseId, @Param("regionIdList") List<Integer> regionIdList);
}