package com.myfun.repository.reportdb.dao;

import com.myfun.repository.reportdb.po.ReportFunCustDemandSplit;
import com.myfun.repository.reportdb.po.ReportFunCustDemandSplitExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReportFunCustDemandSplitMapper extends BaseMapper<ReportFunCustDemandSplit, Long> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ReportFunCustDemandSplitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ReportFunCustDemandSplitExample example);

    /**
     *
     * @mbggenerated
     */
    List<ReportFunCustDemandSplit> selectByExample(ReportFunCustDemandSplitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ReportFunCustDemandSplit record, @Param("example") ReportFunCustDemandSplitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ReportFunCustDemandSplit record, @Param("example") ReportFunCustDemandSplitExample example);
    
    /**
	 * 数据分析首页-买卖楼盘供需量对比-热点楼盘客户、房源排名
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @return
	 */
	List<Map<String,Object>> getBuildSupplyDemandComparisonForBuy(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 数据分析首页-租赁楼盘供需量对比-热点楼盘客户、房源排名
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @return
	 */
	List<Map<String,Object>> getBuildSupplyDemandComparisonForRent(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
}