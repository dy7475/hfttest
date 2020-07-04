package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.myfun.repository.agencydb.dto.AgencyFunCompRealDto;
import com.myfun.repository.agencydb.param.AgencyFunCompRealParam;
import com.myfun.repository.agencydb.po.AgencyFunCompReal;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunCompRealMapper extends BaseMapper<AgencyFunCompReal, Integer> {

	Page<AgencyFunCompReal> selectByCompRealList(AgencyFunCompReal agencyFunCompReal);
	//AgencyFunCompRealParam
	List<AgencyFunCompRealDto> getFunCompRealList(AgencyFunCompRealParam adminFunCompRealParam);
	
	List<AgencyFunCompReal> getDeveloperList(Map<String, Object> paramMap);
	List<AgencyFunCompReal> getFunCompRealDevelopList(Map<String, Object> pMap);
	// 通用查询
	List<AgencyFunCompReal> selectByCondition(Map<String, Object> pMap);
}