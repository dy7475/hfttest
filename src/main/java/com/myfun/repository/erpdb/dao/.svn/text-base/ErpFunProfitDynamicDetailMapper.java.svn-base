package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.vo.CompPerformanceRankingVO;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicDetail;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ErpFunProfitDynamicDetailMapper extends BaseMapper<ErpFunProfitDynamicDetail, ErpFunProfitDynamicDetail> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunProfitDynamicDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunProfitDynamicDetailExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunProfitDynamicDetail> selectByExample(ErpFunProfitDynamicDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunProfitDynamicDetail record, @Param("example") ErpFunProfitDynamicDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunProfitDynamicDetail record, @Param("example") ErpFunProfitDynamicDetailExample example);

    /**
     * 查询个人实收业绩总和
     * @param cityId
     * @param compId
     * @param userId
     * @param queryMonth
     * @return
     */
    BigDecimal selectSumUserIncome(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("archiveId") Integer archiveId, @Param("queryMonth") String queryMonth);

    /**
     * 查询整个公司的业绩排名
     * @param cityId
     * @param compId
     * @param queryMonth
     * @return
     */
    List<CompPerformanceRankingVO> selectCompPerformanceRanking(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("queryMonth") String queryMonth);
}