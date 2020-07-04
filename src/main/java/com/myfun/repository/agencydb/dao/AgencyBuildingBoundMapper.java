package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.dto.AgencyCompListDto;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.agencydb.po.AgencyBuildingBound;
import com.myfun.repository.agencydb.po.AgencyBuildingBoundKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildingBoundMapper extends BaseMapper<AgencyBuildingBound, AgencyBuildingBoundKey> {
	List<AgencyBuildingBound> getBuildingBoundList(Integer cityId);

	List<SelectDto> getCityList(Map<String, Object> paramMap);

	List<AgencyCompListDto> getSelectCityList(Map<String, Object> paramMap);
}