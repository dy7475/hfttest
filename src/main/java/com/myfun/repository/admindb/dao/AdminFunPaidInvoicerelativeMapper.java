package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunPaidInvoicerelative;
import com.myfun.repository.admindb.po.AdminFunPaidInvoicerelativeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunPaidInvoicerelativeMapper extends BaseMapper<AdminFunPaidInvoicerelative, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunPaidInvoicerelativeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunPaidInvoicerelativeExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunPaidInvoicerelative> selectByExample(AdminFunPaidInvoicerelativeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunPaidInvoicerelative record, @Param("example") AdminFunPaidInvoicerelativeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunPaidInvoicerelative record, @Param("example") AdminFunPaidInvoicerelativeExample example);
}