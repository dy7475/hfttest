package com.myfun.repository.agencydb.dao;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.myfun.repository.agencydb.dto.AgencyBorkerComplaintDto;
import com.myfun.repository.agencydb.po.AgencyBorkerComplaint;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBorkerComplaintMapper extends BaseMapper<AgencyBorkerComplaint, Integer> {
	/**
	 * 查询列表
	 * @param cityId
	 * @param caseType
	 * @param caseId
	 * @return
	 */
	public Page<AgencyBorkerComplaintDto> getList(@Param("cityId")String cityId, @Param("caseType")String caseType, 
			@Param("caseId")String caseId);
	
	/**
	 * 更新最新投诉标记
	 * @param cityId
	 * @param caseId
	 * @return
	 */
	public int updateFlag(@Param("tableName")String tableName, @Param("fieldName")String fieldName, @Param("cityId")String cityId, @Param("caseId")String caseId);
}