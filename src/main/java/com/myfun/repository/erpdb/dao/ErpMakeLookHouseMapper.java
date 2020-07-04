package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpMakeLookHouse;
import com.myfun.repository.erpdb.po.ErpMakeLookHouseExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpMakeLookHouseMapper extends BaseMapper<ErpMakeLookHouse, ErpMakeLookHouse> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpMakeLookHouseExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpMakeLookHouseExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpMakeLookHouse> selectByExample(ErpMakeLookHouseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpMakeLookHouse record, @Param("example") ErpMakeLookHouseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpMakeLookHouse record, @Param("example") ErpMakeLookHouseExample example);
}