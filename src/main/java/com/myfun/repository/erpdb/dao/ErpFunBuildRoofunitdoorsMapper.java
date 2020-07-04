package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunBuildRoofunitdoorsDto;
import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.repository.erpdb.po.ErpFunBuildRoofunitdoors;
import com.myfun.repository.erpdb.po.ErpFunBuildRoofunitdoorsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunBuildRoofunitdoorsMapper extends BaseMapper<ErpFunBuildRoofunitdoors, ErpFunBuildRoofunitdoors> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBuildRoofunitdoorsExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBuildRoofunitdoorsExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunBuildRoofunitdoors> selectByExample(ErpFunBuildRoofunitdoorsExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBuildRoofunitdoors record,
			@Param("example") ErpFunBuildRoofunitdoorsExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBuildRoofunitdoors record,
			@Param("example") ErpFunBuildRoofunitdoorsExample example);
	String selectRoofUnitDoors(@Param("shardCityId")Integer cityId,@Param("buildId")Integer buildId);
	ErpFunBuildRoofunitdoors geterpFunBuildRoofunitdoorsByBuild(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("buildId")Integer buildId);
	
	/**
	 * 通过楼盘删除之前的记录信息
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 */
	void deleteByBuildId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId);
	
	/**
	 * 获取单元、栋号、房间数
	 * @author 张宏利
	 * @since 2017年8月28日
	 * @param param
	 * @return
	 */
	ErpFunBuildRoofunitdoorsDto getRoofUnitRoomCount(ErpBuildingSetParam param);
	
	/**
	 * 通过楼盘ID修改
	 * @author 张宏利
	 * @since 2017年8月28日
	 * @param insertRecord
	 * @return
	 */
	int updateByBuildId(ErpFunBuildRoofunitdoors insertRecord);

	ErpFunBuildRoofunitdoors getRoUnDoCounts(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void addRoomCountInBuildRoofUnitDoors(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
										  @Param("buildId") Integer buildId, @Param("roomChangeCount") Integer roomChangeCount,
										  @Param("unitChangeCount") Integer unitChangeCount, @Param("roofChangeCount") Integer roofChangeCount);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void delRoomCountInBuildRoofUnitDoors(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
										  @Param("roomChangeCount") Integer roomChangeCount);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateRoomAndUnitCountInRoofUnitDoors(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId);
}