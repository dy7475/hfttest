package com.myfun.repository.agencydb.dao;

import com.myfun.erpWeb.usercenter.param.UcenterIncomePayRecordParam;
import com.myfun.repository.agencydb.po.AgencyPaFinanceCashaudit;
import com.myfun.repository.agencydb.po.AgencyPaFinanceCashauditExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AgencyPaFinanceCashauditMapper extends BaseMapper<AgencyPaFinanceCashaudit, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AgencyPaFinanceCashauditExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AgencyPaFinanceCashauditExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyPaFinanceCashaudit> selectByExampleWithBLOBs(AgencyPaFinanceCashauditExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyPaFinanceCashaudit> selectByExample(AgencyPaFinanceCashauditExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgencyPaFinanceCashaudit record, @Param("example") AgencyPaFinanceCashauditExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") AgencyPaFinanceCashaudit record, @Param("example") AgencyPaFinanceCashauditExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgencyPaFinanceCashaudit record, @Param("example") AgencyPaFinanceCashauditExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyPaFinanceCashaudit record);

    List<Map<String,Object>> getFinanceAduitList(@Param("param")UcenterIncomePayRecordParam param);

    List<Map<String,Object>> getFinanceAduitList2(@Param("param")UcenterIncomePayRecordParam param);
}