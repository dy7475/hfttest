package com.myfun.service.business.agencydb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.po.AgencyBuildLayout;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface AgencyBuildLayoutService extends BaseMapper<AgencyBuildLayout, Integer>{

	Integer addOrEditBuildLayout(AgencyBuildLayout agencyBuildLayout, AdminCrmUser adminCrmUser);

	AgencyBuildLayout selectByBuildLayoutId(Integer layoutId);

	List<AgencyBuildLayout> selectBuildLayoutByBuildAndCity(Integer buildId, Integer cityId);

	Integer deleteBuildLayout(Integer layoutId);

	Integer saveOrUpdateDistBuildLayout(BaseMapParam param);

	PageInfo<AgencyBuildLayout> getBuildLayoutList(BaseMapParam param);


}
