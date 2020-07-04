package com.myfun.repository.reportdb.dao;

import com.myfun.repository.reportdb.po.ReportMarketEditionStaticData;
import com.myfun.repository.reportdb.po.ReportMarketEditionStaticDataExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportMarketEditionStaticDataMapper extends BaseMapper<ReportMarketEditionStaticData, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ReportMarketEditionStaticDataExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ReportMarketEditionStaticDataExample example);

    /**
     *
     * @mbggenerated
     */
    List<ReportMarketEditionStaticData> selectByExample(ReportMarketEditionStaticDataExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ReportMarketEditionStaticData record, @Param("example") ReportMarketEditionStaticDataExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ReportMarketEditionStaticData record, @Param("example") ReportMarketEditionStaticDataExample example);
}