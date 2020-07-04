package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetail;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetailExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceUserClassDetailMapper extends BaseMapper<ErpFunAttendanceUserClassDetail, ErpFunAttendanceUserClassDetail> {

    /**
     * @mbggenerated
     */
    int countByExample(ErpFunAttendanceUserClassDetailExample example);

    /**
     * @mbggenerated
     */
    int deleteByExample(ErpFunAttendanceUserClassDetailExample example);

    /**
     * @mbggenerated
     */
    List<ErpFunAttendanceUserClassDetail> selectByExample(ErpFunAttendanceUserClassDetailExample example);

    /**
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunAttendanceUserClassDetail record,
                                 @Param("example") ErpFunAttendanceUserClassDetailExample example);

    /**
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunAttendanceUserClassDetail record,
                        @Param("example") ErpFunAttendanceUserClassDetailExample example);

    List<ErpFunAttendanceUserClassDetail> getUserClassList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("groupId") Integer id, @Param("month") String month);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunAttendanceUserClassDetail>  getClassId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("groupId") Integer groupId, @Param("userId") Integer userId, @Param("attDate") String attDateStr);


	Integer countHshApplied(@Param("shardCityId") Integer cityId,@Param("compId")  Integer compId, @Param("attendanceClassId")Integer attendanceClassId);

    List<ErpFunAttendanceUserClassDetail>  getUserClassListByUsers(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("userIds") String userIds);

}