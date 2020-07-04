package com.myfun.service.business.agencydb;

import java.util.List;

import com.myfun.repository.agencydb.po.AgencyFunCity;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunCityService extends BaseMapper<AgencyFunCity, Integer> {
	/**
	 * 获取所有城市列表
	 * @return
	 */
	List<AgencyFunCity> getCityList();
	
	/**
	 * 批量查询省份对应的城市
	 * @param ids
	 * @return
	 */
	List<AgencyFunCity> getBatchCityList(String[] ids);

}
