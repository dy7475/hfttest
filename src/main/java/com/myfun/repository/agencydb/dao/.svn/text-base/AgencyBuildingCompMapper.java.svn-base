package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.dto.AgencyCompListDto;
import com.myfun.repository.agencydb.po.AgencyBuildingComp;
import com.myfun.repository.agencydb.po.AgencyBuildingCompKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildingCompMapper extends BaseMapper<AgencyBuildingComp, AgencyBuildingCompKey> {

	List<AgencyCompListDto> getCompList(Map<String, Object> paramMap);

	Integer countComp(Map<String, Object> paramMap);
}