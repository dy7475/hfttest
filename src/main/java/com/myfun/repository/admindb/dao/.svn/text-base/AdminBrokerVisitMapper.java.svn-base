package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.admindb.dto.AdminBrokerVisitDto;
import com.myfun.repository.admindb.param.AdminBrokerVisitParam;
import com.myfun.repository.admindb.po.AdminBrokerVisit;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminBrokerVisitMapper extends BaseMapper<AdminBrokerVisit, Integer> {
	
	/** 
	 * @Fields 查询表
	 */
	List<AdminBrokerVisitDto> getBrokerVisit(AdminBrokerVisitParam adminBrokerVisitParam);

	AdminBrokerVisit getBvById(Integer bvId);
	
	
	/**
	 * 查询当天登记次数
	 * **/ 
	Integer getCountCurrentMastTime(Map<String, Object> paramMap);
	
	/**
	 * 跟进条件查询数量
	 * **/
	Integer getCountByCondition(AdminBrokerVisit bv);

	void updateBrokerVisitByBvPhone(AdminBrokerVisit updateModel);
}