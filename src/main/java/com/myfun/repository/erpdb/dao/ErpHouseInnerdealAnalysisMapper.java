package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpHouseInnerdealAnalysisDto;
import com.myfun.repository.erpdb.po.ErpHouseInnerdealAnalysis;
import com.myfun.repository.erpdb.po.ErpHouseInnerdealAnalysisExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpHouseInnerdealAnalysisMapper extends BaseMapper<ErpHouseInnerdealAnalysis, ErpHouseInnerdealAnalysis> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpHouseInnerdealAnalysisExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpHouseInnerdealAnalysisExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpHouseInnerdealAnalysis> selectByExample(ErpHouseInnerdealAnalysisExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpHouseInnerdealAnalysis record, @Param("example") ErpHouseInnerdealAnalysisExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpHouseInnerdealAnalysis record, @Param("example") ErpHouseInnerdealAnalysisExample example);

    /**
     * 获取房源内成交统计分析数据
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/5
     */
	List<ErpHouseInnerdealAnalysisDto> getHouseInnerDealAnalysisCountList(@Param("shardCityId") Integer cityId, @Param("param") Map<String,Object> param);
}