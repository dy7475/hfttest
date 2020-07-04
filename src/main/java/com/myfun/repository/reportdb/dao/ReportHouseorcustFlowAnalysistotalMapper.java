package com.myfun.repository.reportdb.dao;

import com.myfun.repository.reportdb.po.ReportHouseorcustFlowAnalysistotal;
import com.myfun.repository.reportdb.po.ReportHouseorcustFlowAnalysistotalExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReportHouseorcustFlowAnalysistotalMapper extends BaseMapper<ReportHouseorcustFlowAnalysistotal, Long> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ReportHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ReportHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    List<ReportHouseorcustFlowAnalysistotal> selectByExample(ReportHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ReportHouseorcustFlowAnalysistotal record, @Param("example") ReportHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ReportHouseorcustFlowAnalysistotal record, @Param("example") ReportHouseorcustFlowAnalysistotalExample example);

	/**
	 * 获取符合条件的列表
	 * @author 臧铁
	 * @since 2017年8月7日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getHouseCustFlowAnalysisCountList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);
	@SwitchDB(type = SwitchDBType.DB_NAME)
 	ReportHouseorcustFlowAnalysistotal selectHouseorcustFlowAnalysistotal(@Param("shardCityId")String shardDbName,@Param("cityId")Object cityId, @Param("key")String key);

	void updateByPrimaryKeyAndCityIdSelective(ReportHouseorcustFlowAnalysistotal record);
}