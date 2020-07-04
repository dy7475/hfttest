package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunCity;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunCityMapper extends BaseMapper<ErpFunCity, ErpFunCity> {
	
	/**
	 * 依据省份ID获取城市列表
	 * @author 张宏利
	 * @param cityId 
	 * @since 2017年9月21日
	 * @param provinceId
	 * @return
	 */
	List<ErpFunCity> getCityListByProvince(@Param("shardCityId") Integer cityId, @Param("provinceId") String provinceId);

	List<ErpFunCity> selectCityList(@Param("shardDbName")String dbName);

	List<ErpFunCity> getCityInfoByCityIds(@Param("shardCityId") Integer cityId, @Param("cityIdList") List<Integer> cityIdList);
}