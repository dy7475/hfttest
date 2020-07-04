package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyFunRewardLogDto;
import com.myfun.repository.agencydb.po.AgencyFunRewardLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunRewardLogMapper extends BaseMapper<AgencyFunRewardLog, Integer> {
	/**
	 * 统计已经拿到了带看奖励的人数
	 * @param bcityId
	 * @param buildId
	 * @param string
	 * @return
	 */
	int count(@Param("bcityId")short bcityId, @Param("buildId")Integer buildId, @Param("staus")String staus);
	
	/**
	 * 修改奖励表记录
	 * @param string
	 * @param cityId
	 * @param custId
	 * @param buildId
	 */
	void updateStatus(@Param("status")String status, @Param("cityId")String cityId, @Param("custId")String custId, @Param("buildId")Integer buildId);

	/**
	 * @TODO 带看奖励记录
	 * @author lcb
	 * @2016-9-19 下午3:09:01
	 */
	List<AgencyFunRewardLogDto> getDistDaikanRewardsList( Map<String, Object> pMap);
}