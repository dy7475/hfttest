package com.myfun.service.business.agencydb;

import com.github.pagehelper.Page;
import com.myfun.repository.agencydb.dto.AgencyDayDetallDto;
import com.myfun.repository.agencydb.po.AgencyDayDetail;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyDayDetallService extends BaseMapper<AgencyDayDetail, Integer>{
	/**
	 * 获取日志列表
	 * @param cityID
	 * @param caseId
	 * @param caseType
	 * @return
	 */
	public Page<AgencyDayDetallDto> getLogList(String cityID, String caseId, String caseType);
}
