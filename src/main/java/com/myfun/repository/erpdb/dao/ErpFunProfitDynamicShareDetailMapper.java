package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.vo.UserProfitVo;
import com.myfun.repository.erpdb.dto.ErpLeaderAssessCountDataDto;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicShareDetail;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicShareDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunProfitDynamicShareDetailMapper extends BaseMapper<ErpFunProfitDynamicShareDetail, ErpFunProfitDynamicShareDetail> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunProfitDynamicShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunProfitDynamicShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunProfitDynamicShareDetail> selectByExample(ErpFunProfitDynamicShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunProfitDynamicShareDetail record, @Param("example") ErpFunProfitDynamicShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunProfitDynamicShareDetail record, @Param("example") ErpFunProfitDynamicShareDetailExample example);

    /**
	 * 个人战绩-直接培育和间接培育提成统计列表数据
	 * compId：erp库的compId
	 * queryMonth：格式：2019-01
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年9月3日 下午3:53:43
	 */
    List<ErpLeaderAssessCountDataDto> getLeaderAssessCountData(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("queryMonth") String queryMonth);

	

    /**
     * 查询直接领导和发展人的业绩总和
     * @param cityId
     * @param compId
     * @param pIds
     * @param queryMonth
     * @return
     */
    BigDecimal selectSumDirectIncome(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId, @Param("queryMonth") String queryMonth);

    /**
     * 查询传承培育人的业绩总和
     * @param cityId
     * @param compId
     * @param userId
     * @param queryMonth
     * @return
     */
    BigDecimal selectSumIndirectIncome(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId,@Param("queryMonth") String queryMonth);
}