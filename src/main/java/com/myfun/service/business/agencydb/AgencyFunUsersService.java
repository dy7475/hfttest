package com.myfun.service.business.agencydb;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.agencydb.dto.AgencyFunUsersDto;
import com.myfun.repository.agencydb.param.AgencyFunUsersParam;
import com.myfun.repository.agencydb.po.AgencyFunUsers;
import com.myfun.repository.agencydb.po.AgencyFunUsersKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunUsersService extends BaseMapper<AgencyFunUsers, AgencyFunUsersKey>{

	Integer checkMobile(String mobile);

	AgencyFunUsers getFunUserByBuildIdAndCityId(Integer buildId, Integer cityId);

	PageInfo<AgencyFunUsersDto> getFunUserListByBuildIdAndCityId(AgencyFunUsersParam agencyFunUsersParam);

}
