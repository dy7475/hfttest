package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.usercenter.param.UcenterIncomePayRecordParam;
import com.myfun.repository.admindb.po.AdminFunPaidAduit;
import com.myfun.repository.admindb.po.AdminFunPaidAduitExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminFunPaidAduitMapper extends BaseMapper<AdminFunPaidAduit, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunPaidAduitExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunPaidAduitExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunPaidAduit> selectByExampleWithBLOBs(AdminFunPaidAduitExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunPaidAduit> selectByExample(AdminFunPaidAduitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunPaidAduit record, @Param("example") AdminFunPaidAduitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") AdminFunPaidAduit record, @Param("example") AdminFunPaidAduitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunPaidAduit record, @Param("example") AdminFunPaidAduitExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminFunPaidAduit record);

    List<Map<String,Object>> getAduitRecordList(@Param("param")UcenterIncomePayRecordParam param);
}