package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.param.DeleteIdParam;
import com.myfun.erpWeb.businesstools.builddic.param.GetBuildUnitRuleParam;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.repository.erpdb.po.ErpBuildingSetUnit;
import com.myfun.repository.erpdb.po.ErpBuildingSetUnitExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpBuildingSetUnitMapper extends BaseMapper<ErpBuildingSetUnit, ErpBuildingSetUnit> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetUnitExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetUnitExample example);

	/**
	 * @mbggenerated
	 */List<ErpBuildingSetUnit> selectByExample(ErpBuildingSetUnitExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpBuildingSetUnit record,@Param("example") ErpBuildingSetUnitExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpBuildingSetUnit record,@Param("example") ErpBuildingSetUnitExample example);

	/**
	 * 删除楼盘单元信息
	 *
	 * @param cityId Integer
	 * @param param DeleteIdParam
	 * @param compId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void delBuildUnit(@Param("shardCityId") Integer cityId, @Param("param") DeleteIdParam param, @Param("compId") Integer compId);

	/**
	 * 楼盘单元信息
	 *
	 * @param cityId Integer
	 * @param compId Integer
	 * @param buildId Integer
	 * @param buildingSetRoofId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetUnitVo> getBuildUnitListVo(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
												  @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId);

	/**
	 * 楼盘单元信息,带销控表数量
	 *
	 * @param cityId Integer
	 * @param compId Integer
	 * @param buildId Integer
	 * @param buildingSetRoofId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetUnitVo> getUnitNameAndMarketingControlCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
												  @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId);

	/**
	 *
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @param buildUnit
	 * @author 黄建海
	 * @since 2018/12/20 0020
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetUnit selectByBuildAndBuildUnit(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("buildUnit") String buildUnit);
	/**
	 *	号位规则时根据楼盘id查询单元
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @author 黄建海
	 * @since 2018/12/21 0021
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpRegisterBuildingSetUnitVO> selectByBuildId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("list")List<Integer> list);
	/**
	 * 根据楼盘id和栋座id查询出单元
	 * @param  * @param
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @param roofIds
	 * @author 黄建海
	 * @since 2018/12/21 0021
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpRegisterBuildingSetUnitVO> selectByBuildIdAndUnitIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("roofIds") List<Integer> roofIds);

	/**
	 * 获取单元或者号位规则详情
	 *
	 * @param cityId Integer
	 * @param compId Integer
	 * @param param GetBuildUnitRuleParam
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetUnitDetailsVO getBuildUnitRule(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
												 @Param("param") GetBuildUnitRuleParam param);

	ErpBuildingSetUnit getUnitDoors(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId , @Param("buildId")Integer buildId, @Param("buildingSetUnit")String buildingSetUnit);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void delRoomCountInUnit(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
							@Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId, @Param("changeCount") Integer changeCount);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void addRoomCountInUnit(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
							@Param("buildingSetUnitId") Integer buildingSetUnitId, @Param("changeCount") Integer changeCount);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateRoomCountInUnit(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
							@Param("buildingSetUnitId") Integer buildingSetUnitId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchAddUnit(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
					  @Param("insertUnitList") List<ErpBuildingSetUnit> insertUnitList);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getNewAddUnitIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
								   @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId,
								   @Param("unitList") List<String> unitList);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetUnit getBuildUnitDetailsWhenSingleAdd(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
														@Param("param") GetBuildUnitRuleParam param);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    Integer checkHasRule(@Param("shardCityId") Integer cityId, @Param("buildId") Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void createTemp(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("compNo") String compNo,@Param("provinceId") Integer provinceId,@Param("buildId") Integer buildId);
	/**
	 *根据栋id和单元查询单元表
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @param buildingSetRoofId
	 * @param buildUnit
	 * @author 黄建海
	 * @since 2019/1/5 0005
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetUnit selectByRoofIdAndBuildUnit(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("buildId")Integer buildId,@Param("buildingSetRoofId") Integer buildingSetRoofId,@Param("buildUnit") String buildUnit);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateRoofIdInUnit(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("buildId") Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getUnitIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetUnit getRepeatUnit(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,
						  @Param("buildId") Integer buildId, @Param("condition") String condition);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetUnit getBuildUnitRoomGenerated(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
												  @Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId);

	/**
	 * 查询新添加的栋座的单元ID集合
	 *
	 * @param cityId     Integer
	 * @param compId     Integer
	 * @param buildId    Integer
	 * @param buildRoofs List<String>
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getUnitIdsByBuildRoofs(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
							 @Param("buildId") Integer buildId, @Param("buildRoofs") List<String> buildRoofs);

	List<BuildUnitNameInMobileVo> getBuildUnitNames(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
													@Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId);


}