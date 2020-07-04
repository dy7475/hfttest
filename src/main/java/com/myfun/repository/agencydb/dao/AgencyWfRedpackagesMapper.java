package com.myfun.repository.agencydb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyWfRedpackages;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfRedpackagesMapper extends BaseMapper<AgencyWfRedpackages, Integer> {
	/**
	 * 优优好房查询红包
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @param type 红包类型(1,普通红包(专属红包,代金券),2补贴红包)
	 * @return
	 */
	AgencyWfRedpackages getRecordForUUMobile(@Param("cityId")Integer cityId, @Param("caseId")Integer caseId, 
			@Param("caseType")Integer caseType, @Param("type")int type);
}