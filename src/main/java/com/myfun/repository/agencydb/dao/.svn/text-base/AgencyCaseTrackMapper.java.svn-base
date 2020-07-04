package com.myfun.repository.agencydb.dao;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.myfun.repository.agencydb.dto.AgencyCommentDto;
import com.myfun.repository.agencydb.param.AgencyTrackParam;
import com.myfun.repository.agencydb.po.AgencyCaseTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyCaseTrackMapper extends BaseMapper<AgencyCaseTrack, Integer> {
	
	/**
	 * Id自增
	 * @param caseTrack
	 * @return
	 */
	public Integer getid();
	
	/**
	 * 查询基本信息
	 * @param cityId
	 * @param caseId
	 * @return
	 */
	public AgencyCommentDto getObject(@Param("tableName")String tableName, @Param("regField")String regField, @Param("sectionField")String sectionField, @Param("cityId")String cityId, @Param("caseId")String caseId, @Param("fieldName")String fieldName);
	
	/**
	 * 更新相应表跟踪人和跟踪时?
	 * @param userId
	 * @param fieldName
	 * @param caseId
	 */
	public void updateTrackUserAndTime(@Param("tableName")String tableName,
			@Param("now")String now, 
			@Param("userId")Integer userId, @Param("fieldName")String fieldName, 
			@Param("caseId")Integer caseId, @Param("cityId")String cityId);
	
	/**
	 * 获取查询跟进列表
	 * @param city
	 * @param caseTypr
	 * @param caseId
	 * @return
	 */
	public Page<AgencyCaseTrack> getListTrack(@Param("cityId")String cityId, @Param("caseType")String caseType, @Param("caseId")String caseId);

	/**
	 * 更新相应表信?
	 * @param tabName
	 * @param userId
	 * @param cityId
	 * @param caseId
	 * @return
	 */
	public int updateRecord(@Param("tabName")String tabName, @Param("userId")String userId,
			@Param("cityId")String cityId, @Param("caseId")String caseId, @Param("tableField")String tableField);
	
	/**
	 * 房源上架修改
	 * @param param
	 * @return
	 */
	public int updateTrackForUpHouse(@Param("track")AgencyTrackParam track, 
			@Param("tableName")String tableName, @Param("fieldName")String fieldName, 
			@Param("caseId")String caseId, @Param("cityId")String cityId);
	
	/**
	 * 房源下架修改
	 * @param param
	 * @return
	 */
	public int updateTrackForDownHouse(@Param("track")AgencyTrackParam param, @Param("tableName")String tableName, 
			@Param("fieldName")String fieldName, 
			@Param("caseId")String caseId, @Param("cityId")String cityId);
}