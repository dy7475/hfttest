package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWfBuildHistory;
import com.myfun.repository.agencydb.po.AgencyWfBuildHistoryExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface AgencyWfBuildHistoryMapper extends BaseMapper<AgencyWfBuildHistory, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AgencyWfBuildHistoryExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AgencyWfBuildHistoryExample example);

	/**
	 * @mbggenerated
	 */List<AgencyWfBuildHistory> selectByExample(AgencyWfBuildHistoryExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AgencyWfBuildHistory record,@Param("example") AgencyWfBuildHistoryExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AgencyWfBuildHistory record,@Param("example") AgencyWfBuildHistoryExample example);

	void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> fastdfsFileList);
}