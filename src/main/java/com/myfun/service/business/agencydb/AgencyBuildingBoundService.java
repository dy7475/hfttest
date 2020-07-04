package com.myfun.service.business.agencydb;

import java.util.List;

import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.agencydb.po.AgencyBuildingBound;
import com.myfun.repository.agencydb.po.AgencyBuildingBoundKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
*/
public interface AgencyBuildingBoundService extends BaseMapper<AgencyBuildingBound, AgencyBuildingBoundKey>{

	List<SelectDto> getBuildingBoundList(Integer buildId, Integer cityId);

	Integer updateCityList(String cityIds, Integer buildId, Integer cityId, AdminCrmUser adminCrmUser);

}
