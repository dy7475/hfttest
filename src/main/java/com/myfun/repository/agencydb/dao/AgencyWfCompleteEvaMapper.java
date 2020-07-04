package com.myfun.repository.agencydb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyWfCompleteEvaDto;
import com.myfun.repository.agencydb.po.AgencyWfCompleteEva;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfCompleteEvaMapper extends BaseMapper<AgencyWfCompleteEva, Integer> {

	AgencyWfCompleteEva getCompleteEvaInfoByPushLogId(@Param("pushLogId") Integer pushLogId);
	
	AgencyWfCompleteEvaDto getRateByArchiveId(@Param("cityId")Integer cityId,@Param("archiveId")Integer archiveId);
}