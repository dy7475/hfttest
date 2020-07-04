package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyFunCity;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunCityMapper extends BaseMapper<AgencyFunCity, Integer> {
	/**
	 * 获取城市列表
	 * @return
	 */
	List<AgencyFunCity> getCityList();
	
	/**
	 * 批量获取省份对应的城市
	 * @param ids
	 * @return
	 */
	List<AgencyFunCity> getBatchCityList(@Param("ids")String[] ids);
}