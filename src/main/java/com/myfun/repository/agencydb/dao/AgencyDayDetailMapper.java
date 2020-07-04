package com.myfun.repository.agencydb.dao;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.myfun.repository.agencydb.dto.AgencyDayDetallDto;
import com.myfun.repository.agencydb.po.AgencyDayDetail;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyDayDetailMapper extends BaseMapper<AgencyDayDetail, Integer> {
	/**
	 * 获取日志列表
	 * @param cityID
	 * @param caseId
	 * @param caseType
	 * @return
	 */
	public Page<AgencyDayDetallDto> getLogList(@Param("cityId")String cityId, @Param("caseId")String caseId,
			@Param("caseType")String caseType);
}