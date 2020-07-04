package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.po.AgencyWfCollect;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.agencydb.po.AgencyWfCollectExample;
import org.apache.ibatis.annotations.Param;

public interface AgencyWfCollectMapper extends BaseMapper<AgencyWfCollect, Integer> {
	/**
	 * @mbggenerated
	 */
	int countByExample(AgencyWfCollectExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AgencyWfCollectExample example);

	/**
	 * @mbggenerated
	 */List<AgencyWfCollect> selectByExample(AgencyWfCollectExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AgencyWfCollect record,@Param("example") AgencyWfCollectExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AgencyWfCollect record,@Param("example") AgencyWfCollectExample example);

	/**
	 * 根据CASE_ID/CASE_TYPE/CITY_ID/WX_ID查询用户是否收藏数据
	 * @author 陈文?
	 * @date 2016?6?4? 上午11:27:33
	 */
	List<AgencyWfCollect> queryWfCollectInfoByCondition(AgencyWfCollect condition);

	void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> fastdfsFileList);
}