package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.usercenter.param.UcenterIncomePayRecordParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyAmountHistoryDto;
import com.myfun.repository.agencydb.param.AgencyAmountHistoryparam;
import com.myfun.repository.agencydb.po.AgencyAmountHistory;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyAmountHistoryMapper extends BaseMapper<AgencyAmountHistory, Integer> {
	 /**
     * 获取提现需求列表
     * @param agencyAgencyAmountHistoryparam
     * @return
     */
	List<AgencyAmountHistory> getCashList(AgencyAmountHistoryparam agencyAgencyAmountHistoryparam);
	
	/**
	 * 获取提现记录
	 * @param userId
	 * @param compFlag
	 * @return
	 */
	List<AgencyAmountHistory> getCashHistory(@Param("archiveId")String archiveId, @Param("compFlag")String compFlag);

	List<AgencyAmountHistoryDto> getDistAmountHistory(Map<String, Object> pMap);

    List<Map<String,Object>> getAmountHistoryList(@Param("param")UcenterIncomePayRecordParam param);
}