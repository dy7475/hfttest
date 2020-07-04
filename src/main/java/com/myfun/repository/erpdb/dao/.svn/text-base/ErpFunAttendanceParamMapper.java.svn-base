package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceParam;
import com.myfun.repository.erpdb.po.ErpFunAttendanceParamExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceParamMapper extends BaseMapper<ErpFunAttendanceParam, ErpFunAttendanceParam> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunAttendanceParamExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunAttendanceParamExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunAttendanceParam> selectByExample(ErpFunAttendanceParamExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunAttendanceParam record, @Param("example") ErpFunAttendanceParamExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunAttendanceParam record, @Param("example") ErpFunAttendanceParamExample example);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void addDataList( @Param("shardCityId")Integer shardCityId,@Param("compId")Integer compId);
}