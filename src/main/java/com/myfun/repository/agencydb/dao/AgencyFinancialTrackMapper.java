package com.myfun.repository.agencydb.dao;

import java.util.List;

import com.myfun.repository.agencydb.po.AgencyFinancialTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFinancialTrackMapper extends BaseMapper<AgencyFinancialTrack, Integer> {
	/**
	 * 查询跟进列表
	 * @param detailId
	 * @return
	 */
	List<AgencyFinancialTrack> getFinancialTrack(String detailId);
}