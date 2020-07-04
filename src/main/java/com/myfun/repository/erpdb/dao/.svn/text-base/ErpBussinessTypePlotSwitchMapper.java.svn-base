package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBussinessTypePlotSwitch;
import com.myfun.repository.erpdb.po.ErpBussinessTypePlotSwitchExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBussinessTypePlotSwitchMapper extends BaseMapper<ErpBussinessTypePlotSwitch, ErpBussinessTypePlotSwitch> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpBussinessTypePlotSwitchExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpBussinessTypePlotSwitchExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpBussinessTypePlotSwitch> selectByExample(ErpBussinessTypePlotSwitchExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpBussinessTypePlotSwitch record, @Param("example") ErpBussinessTypePlotSwitchExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpBussinessTypePlotSwitch record, @Param("example") ErpBussinessTypePlotSwitchExample example);

    void updatePlotSwitch(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("bussinessType") Integer bussinessType, @Param("plotSwitch") Byte plotSwitch);

    void deleteBussinessPlotSwitch(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);

    void addBussinessPlotSwitch(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("plotSwitch") boolean plotSwitch);

}