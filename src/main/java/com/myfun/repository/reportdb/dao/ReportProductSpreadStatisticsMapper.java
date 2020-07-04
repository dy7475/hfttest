package com.myfun.repository.reportdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.reportdb.po.ReportProductSpreadStatistics;
import com.myfun.repository.reportdb.po.ReportProductSpreadStatisticsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ReportProductSpreadStatisticsMapper extends BaseMapper<ReportProductSpreadStatistics, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ReportProductSpreadStatisticsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ReportProductSpreadStatisticsExample example);

    /**
     *
     * @mbggenerated
     */
    List<ReportProductSpreadStatistics> selectByExample(ReportProductSpreadStatisticsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ReportProductSpreadStatistics record, @Param("example") ReportProductSpreadStatisticsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ReportProductSpreadStatistics record, @Param("example") ReportProductSpreadStatisticsExample example);

}