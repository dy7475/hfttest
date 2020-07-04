package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyBuildLayout;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.agencydb.po.AgencyBuildLayoutExample;

public interface AgencyBuildLayoutMapper extends BaseMapper<AgencyBuildLayout, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AgencyBuildLayoutExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AgencyBuildLayoutExample example);

	/**
	 * @mbggenerated
	 */List<AgencyBuildLayout> selectByExampleWithBLOBs(AgencyBuildLayoutExample example);

	/**
	 * @mbggenerated
	 */List<AgencyBuildLayout> selectByExample(AgencyBuildLayoutExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AgencyBuildLayout record,@Param("example") AgencyBuildLayoutExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleWithBLOBs(@Param("record") AgencyBuildLayout record,@Param("example") AgencyBuildLayoutExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AgencyBuildLayout record,@Param("example") AgencyBuildLayoutExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AgencyBuildLayout record);

	List<AgencyBuildLayout> selectBuildLayoutByBuildAndCity(Map<String, Object> paramMap);

	AgencyBuildLayout selectMaxSeqNo(@Param("cityId")Integer cityId, @Param("buildId")String buildId);

	void insertSelectiveMap(Map<String, Object> pMap);

	void updateBySelectiveMap(Map<String, Object> pMap);
	
	List<AgencyBuildLayout> getBuildLayoutList(Map<String, Object> pMap);

	void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> fastdfsFileList);
}