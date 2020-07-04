package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAliRenthouseDialingrecord;
import com.myfun.repository.erpdb.po.ErpAliRenthouseDialingrecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAliRenthouseDialingrecordMapper extends BaseMapper<ErpAliRenthouseDialingrecord, ErpAliRenthouseDialingrecord> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpAliRenthouseDialingrecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpAliRenthouseDialingrecordExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpAliRenthouseDialingrecord> selectByExample(ErpAliRenthouseDialingrecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpAliRenthouseDialingrecord record, @Param("example") ErpAliRenthouseDialingrecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpAliRenthouseDialingrecord record, @Param("example") ErpAliRenthouseDialingrecordExample example);
}