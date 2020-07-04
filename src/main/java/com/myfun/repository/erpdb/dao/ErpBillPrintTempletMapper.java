package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpBillPrintTempletDto;
import com.myfun.repository.erpdb.po.ErpBillPrintTemplet;
import com.myfun.repository.erpdb.po.ErpBillPrintTempletExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBillPrintTempletMapper extends BaseMapper<ErpBillPrintTemplet, ErpBillPrintTemplet> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpBillPrintTempletExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpBillPrintTempletExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpBillPrintTemplet> selectByExample(ErpBillPrintTempletExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpBillPrintTemplet record, @Param("example") ErpBillPrintTempletExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpBillPrintTemplet record, @Param("example") ErpBillPrintTempletExample example);
    
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBillPrintTempletDto> getModelById(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId);
}