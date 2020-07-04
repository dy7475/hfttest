package com.myfun.repository.admindbRpt.dao;

import com.myfun.repository.admindbRpt.po.AdminRptHouseorcustFlowAnalysistotal;
import com.myfun.repository.admindbRpt.po.AdminRptHouseorcustFlowAnalysistotalExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminRptHouseorcustFlowAnalysistotalMapper extends BaseMapper<AdminRptHouseorcustFlowAnalysistotal, Long> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminRptHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminRptHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminRptHouseorcustFlowAnalysistotal> selectByExample(AdminRptHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminRptHouseorcustFlowAnalysistotal record, @Param("example") AdminRptHouseorcustFlowAnalysistotalExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminRptHouseorcustFlowAnalysistotal record, @Param("example") AdminRptHouseorcustFlowAnalysistotalExample example);
}