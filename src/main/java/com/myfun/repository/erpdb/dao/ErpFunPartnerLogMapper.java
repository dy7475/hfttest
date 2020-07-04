package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunPartnerLog;
import com.myfun.repository.erpdb.po.ErpFunPartnerLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPartnerLogMapper extends BaseMapper<ErpFunPartnerLog, ErpFunPartnerLog> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunPartnerLogExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunPartnerLogExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunPartnerLog> selectByExampleWithBLOBs(ErpFunPartnerLogExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunPartnerLog> selectByExample(ErpFunPartnerLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunPartnerLog record, @Param("example") ErpFunPartnerLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ErpFunPartnerLog record, @Param("example") ErpFunPartnerLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunPartnerLog record, @Param("example") ErpFunPartnerLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ErpFunPartnerLog record);
}