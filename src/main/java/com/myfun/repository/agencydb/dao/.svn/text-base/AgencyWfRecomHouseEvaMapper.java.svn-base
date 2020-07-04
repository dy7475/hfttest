package com.myfun.repository.agencydb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyWfRecomHouseEvaDto;
import com.myfun.repository.agencydb.po.AgencyWfRecomHouseEva;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfRecomHouseEvaMapper extends BaseMapper<AgencyWfRecomHouseEva, Integer> {
	AgencyWfRecomHouseEvaDto getTrueRateByArchiveId(@Param("cityId")Integer cityId,@Param("archiveId")Integer archiveId);
}