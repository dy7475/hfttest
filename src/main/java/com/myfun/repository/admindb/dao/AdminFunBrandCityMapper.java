package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.admindb.dto.AdminFunBrandCityDto;
import com.myfun.repository.admindb.po.AdminFunBrandCity;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunBrandCityMapper extends BaseMapper<AdminFunBrandCity, Integer> {

	List<AdminFunBrandCityDto> getAdminFunBrandCityByBrandId(Integer brandId);
	
	List<AdminFunBrandCity> getFunBrandCityByCityIds(Map<String, Object> paramMap);

	Integer updateFunBrandCityToOff(Integer brandId);

	Integer updateFunBrandCityToOff(Map<String, Object> paramMap2);

	Integer updateAdminFunBrandCity(Map<String, Object> paramMap);

	AdminFunBrandCity getFunBrandCityByCityIdAndBrandId(Map<String, Object> paramMap);
}