package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.attendance.vo.AttendanceGroupDto;
import com.myfun.repository.erpdb.dto.ErpFunAttendanceGroupDto;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroup;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetail;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceGroupMapper extends BaseMapper<ErpFunAttendanceGroup, ErpFunAttendanceGroup> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceGroupExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceGroupExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceGroup> selectByExample(ErpFunAttendanceGroupExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceGroup record,
			@Param("example") ErpFunAttendanceGroupExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceGroup record,
			@Param("example") ErpFunAttendanceGroupExample example);

	List<ErpFunAttendanceGroup> getGroupList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("deptId")Integer deptId, @Param("keyWords")String keyWords);

	ErpFunAttendanceGroupDto selectGroupById(@Param("shardCityId")Integer cityId, @Param("groupId")Integer id);

    Integer countHshApplied(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("attClassId")Integer attClassId);
    
    @SwitchDB(type = SwitchDBType.CITY_ID)
    ErpFunAttendanceGroup findClassType(@Param("shardCityId")Integer cityId,@Param("id") Integer id);


    Set<ErpFunAttendanceGroup> getGroupListByClassId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("attClassId")Integer classId);
    Set<ErpFunAttendanceGroup> getGroupListByClassId2(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("attClassId")Integer classId);

    List<AttendanceGroupDto> getAttenGroupList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	List<ErpFunAttendanceUserClassDetail> getUserClassDetailList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);



}