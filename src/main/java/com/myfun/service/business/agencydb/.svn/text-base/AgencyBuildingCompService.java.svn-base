package com.myfun.service.business.agencydb;

import java.util.List;

import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.agencydb.dto.AgencyCompListDto;
import com.myfun.repository.agencydb.po.AgencyBuildingComp;
import com.myfun.repository.agencydb.po.AgencyBuildingCompKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildingCompService extends BaseMapper<AgencyBuildingComp, AgencyBuildingCompKey>{

	List<AgencyCompListDto> getFunCompList(Integer buildId, Integer cityId);

	AdminFunComp getCompListByCompNoAction(String compNo);

	Integer updateComp(String compNos, Integer buildId, Integer cityId, AdminCrmUser adminCrmUser);

	List<AgencyCompListDto> getFunCityList(Integer buildId, Integer cityId);

}
