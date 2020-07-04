package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Set;

import com.myfun.repository.agencydb.po.AgencyWfPushLog;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyWfRecomHouseDto;
import com.myfun.repository.agencydb.po.AgencyWfRecomHouse;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfRecomHouseMapper extends BaseMapper<AgencyWfRecomHouse, Integer> {
	
	List<AgencyWfRecomHouseDto> getWfRecomHouseListByPushLogIds(@Param("caseType") Integer caseType , @Param("pushLogIds") Set<Integer> pushLogIds);

	AgencyWfRecomHouse getWfRecomHouseInfoByCaseId(@Param("caseId") String caseId, @Param("caseType") Integer caseType);
	/**
	 * 查询已看房源列表
	 * @author 何传强
	 * @since 2017年8月22日
	 * @param cityId
	 * @param pushLogId
	 * @param caseType
	 * @return
	 */
	List<AgencyWfRecomHouseDto> getWfRecomHouseByPushLogId(@Param("cityId")Integer cityId, @Param("pushLogId")Integer pushLogId);

	AgencyWfRecomHouseDto getIntentionRateByArchiveId(@Param("cityId")Integer cityId,@Param("archiveId")Integer archiveId);
	
	AgencyWfRecomHouse getWfRecomHouseTimeForCust(@Param("cityId")Integer cityId,@Param("pushLogId")Integer pushLogId);
}