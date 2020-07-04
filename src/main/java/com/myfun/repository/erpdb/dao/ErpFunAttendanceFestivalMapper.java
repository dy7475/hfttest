package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceFestival;
import com.myfun.repository.erpdb.po.ErpFunAttendanceFestivalExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceFestivalMapper extends BaseMapper<ErpFunAttendanceFestival, ErpFunAttendanceFestival> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceFestivalExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceFestivalExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceFestival> selectByExample(ErpFunAttendanceFestivalExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceFestival record,
								 @Param("example") ErpFunAttendanceFestivalExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceFestival record,
						@Param("example") ErpFunAttendanceFestivalExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertBatch(@Param("shardCityId") Integer cityId,
					 @Param("festivalList") List<ErpFunAttendanceFestival> festivalList, @Param("groupId") Integer groupId,
					 @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceFestival> getFestivalDate(@Param("shardCityId") Integer cityId);

	/**
	 * 查询特殊考勤日是否有排班
	 *
	 * @author liucheng
	 * @date 2017年12月4日 下午3:25:57
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceFestival> getFestivalDateClass(@Param("shardCityId") Integer cityId, @Param("attDateStr") String attDateStr, @Param("compId") Integer compId);

	/**
	 * 如果返回值不为0，查询特殊考勤日的班次
	 *
	 * @author liucheng
	 * @date 2017年12月4日 下午5:54:07
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceFestival> getFestivalDateClassId(@Param("shardCityId") Integer cityId, @Param("attDateStr") String attDateStr);

	/**
	 * 根据日期查询，今天是否为国家规定节假日
	 *
	 * @author liucheng
	 * @date 2017年12月4日 下午5:54:28
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceFestival> getFestivalCount(@Param("shardCityId") Integer cityId, @Param("attDateStr") String attDateStr);

	/**
	 * 如果是在查询是否休息，，，如果不休息查询classId
	 *
	 * @author liucheng
	 * @date 2017年12月4日 下午5:54:38
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer getFestivalClassId(@Param("shardCityId") Integer cityId, @Param("attDateStr") String attDateStr);

}