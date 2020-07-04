package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencySpreadDto;
import com.myfun.repository.agencydb.param.AgencySpreadParam;
import com.myfun.repository.agencydb.po.AgencySpread;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencySpreadMapper extends BaseMapper<AgencySpread, Integer> {
    /**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AgencySpread record);

	/**
     * 推广审核列表
     * @param agencySpreadParam
     * @return
     */
	List<AgencySpread> getList(AgencySpreadParam agencySpreadParam);
	
	/**
	 * 查询推广统计
	 * @param timeStart
	 * @param timeEnd
	 * @return
	 */
	AgencySpreadDto getCountSpread(@Param("timeStart")String timeStart, @Param("timeEnd")String timeEnd);

	List<AgencySpreadDto> getDistSystemMessage(Map<String, Object> pMap);
}