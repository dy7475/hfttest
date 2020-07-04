package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyWebClient;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWebClientMapper extends BaseMapper<AgencyWebClient, Integer> {
	
	/**
	 * 查询ClientId
	 * @param phone1
	 * @param phone2
	 * @return
	 */
	public List<AgencyWebClient> getWebClient(@Param("phone1")String phone1, @Param("phone2")String phone2);
	
	/**
	 * 获取本次ID
	 * @param record
	 * @return
	 */
	public Integer getId();
	
	/**
	 * 获取电话号码
	 * @param cityId
	 * @param caseId
	 * @return
	 */
	public AgencyWebClient getClientMobile(@Param("cityId")String cityId, @Param("caseId")String caseId);

	public AgencyWebClient getClientSex(@Param("cityId")Integer getfIdHFT, @Param("caseId")Integer getfProId);
	
	/**
	 * 跟进电话号码更新客户性别
	 * @param record
	 */
	public void updateByMobile(AgencyWebClient record);
}