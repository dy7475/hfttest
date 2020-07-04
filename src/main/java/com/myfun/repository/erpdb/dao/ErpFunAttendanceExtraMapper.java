package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceExtra;
import com.myfun.repository.erpdb.po.ErpFunAttendanceExtraExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceExtraMapper extends BaseMapper<ErpFunAttendanceExtra, ErpFunAttendanceExtra> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunAttendanceExtraExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunAttendanceExtraExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunAttendanceExtra> selectByExample(ErpFunAttendanceExtraExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunAttendanceExtra record, @Param("example") ErpFunAttendanceExtraExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunAttendanceExtra record, @Param("example") ErpFunAttendanceExtraExample example);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunAttendanceExtra> selectByAttId(@Param("shardCityId") Integer cityId,@Param("attId") Integer attId);
}