package com.myfun.repository.agencydb.dao;

import com.myfun.erpWeb.usercenter.param.UcenterIncomePayRecordParam;
import com.myfun.repository.agencydb.po.AgencyPaFinance;
import com.myfun.repository.agencydb.po.AgencyPaFinanceExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import com.myfun.repository.support.param.GeneralParam;
import org.apache.ibatis.annotations.Param;

public interface AgencyPaFinanceMapper extends BaseMapper<AgencyPaFinance, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AgencyPaFinanceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AgencyPaFinanceExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyPaFinance> selectByExample(AgencyPaFinanceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgencyPaFinance record, @Param("example") AgencyPaFinanceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgencyPaFinance record, @Param("example") AgencyPaFinanceExample example);

    Float getPaFianceAmount(@Param("type")int type, @Param("param") GeneralParam param);

    List<Map<String,Object>> getFinanceList(@Param("param")UcenterIncomePayRecordParam param);
}