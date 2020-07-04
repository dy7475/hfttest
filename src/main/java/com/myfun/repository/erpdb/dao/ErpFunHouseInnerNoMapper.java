package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunHouseInnerNo;
import com.myfun.repository.erpdb.po.ErpFunHouseInnerNoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunHouseInnerNoMapper extends BaseMapper<ErpFunHouseInnerNo, ErpFunHouseInnerNo> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunHouseInnerNoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunHouseInnerNoExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunHouseInnerNo> selectByExample(ErpFunHouseInnerNoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunHouseInnerNo record, @Param("example") ErpFunHouseInnerNoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunHouseInnerNo record, @Param("example") ErpFunHouseInnerNoExample example);
}