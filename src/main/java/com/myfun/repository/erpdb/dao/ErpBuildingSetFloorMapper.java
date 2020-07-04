package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.param.BuildingSetFloorParam;
import com.myfun.erpWeb.businesstools.builddic.param.DeleteIdParam;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.repository.erpdb.param.ErpBuildingSetFloorParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.repository.erpdb.po.ErpBuildingSetFloor;
import com.myfun.repository.erpdb.po.ErpBuildingSetFloorExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildingSetFloorMapper extends BaseMapper<ErpBuildingSetFloor, ErpBuildingSetFloor> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetFloorExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetFloorExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingSetFloor> selectByExample(ErpBuildingSetFloorExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingSetFloor record,
			@Param("example") ErpBuildingSetFloorExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingSetFloor record,
			@Param("example") ErpBuildingSetFloorExample example);

	/**
	 * 通过楼层获取是否有修改过
	 * @author 张宏利
	 * @since 2017年10月10日
	 * @param param
	 * @return
	 */
	List<ErpBuildingSetFloor> selectByBuildFloor(ErpBuildingSetFloorParam param);

	void delBuildById(ErpBuildingSetParam param);

	/**
	 * 获取楼层信息列表
	 *
	 * @param floorIds List<Integer>
	 * @author czq
	 * @since 2018年12月17日
	 */
	List<ErpBuildingSetFloor> selectFloorByIds(List<Integer> floorIds);

    /**
     * 删除楼盘楼层信息
     *
     * @param cityId Integer
     * @param param DeleteIdParam
     * @param compId Integer
     * @author czq
     * @since 2018年12月17日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void delBuildFloor(@Param("shardCityId") Integer cityId, @Param("param") DeleteIdParam param, @Param("compId") Integer compId);

	/**
	 * 通过楼层获取是否有修改过
	 *
	 * @param cityId Integer
	 * @param param BuildingSetFloorParam
	 * @author czq
	 * @since 2018年12月18日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetFloor> selectBuildFloor(@Param("shardCityId") Integer cityId, @Param("param") BuildingSetFloorParam param, @Param("compId") Integer compId);
	/**
	 *
	 * @param  * @param cityId
	 * @param compId
	 * @param buildingSetRoofId
	 * @param buildUnit
	 * @param buildFloor
	 * @author 黄建海
	 * @since 2018/12/20 0020
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetFloor selectByRoofIdAndUnitAndBuildFloor(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("buildSetRoofId") Integer buildingSetRoofId,@Param("buildUnit") String buildUnit,@Param("buildFloor") String buildFloor);
	/**
	 *	根据
	 * @param  * @param cityId
	 * @param compId
	 * @param id
	 * @param buildUnit
	 * @param buildFloor
	 * @author 黄建海
	 * @since 2018/12/20 0020
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetFloor selectByRoofIdAndUnitAndBuildFloors(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("buildSetUnitId") Integer id,@Param("buildUnit") String buildUnit,@Param("buildFloor") String buildFloor);
	/**
	 *	根据栋和单元查询楼层
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @param buildRoof
	 * @param buildUnit
	 * @author 黄建海
	 * @since 2018/12/21 0021
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpRegisterBuildFloorAndRoomListVO> selectByBuildAndBuildRoofAndBuildUnit(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("buildId") Integer buildId,@Param("buildingSetRoofId") Integer buildingSetRoofId,@Param("buildingSetUnitId") Integer buildingSetUnitId,@Param("floorUseage")Integer floorUseage);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<MLErpRegisterBuildFloorAndRoomListVO> selectByBuildAndBuildRoofAndBuildUnitML(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId, @Param("buildingSetUnitId") Integer buildingSetUnitId, @Param("floorUseage")Integer floorUseage);

	/**
	 * 获取单元下楼层列表
	 *
	 * @param cityId Integer
	 * @author czq
	 * @since 2018年12月18日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetFloorVo> selectFloorVos(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
											   @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId,
											   @Param("buildingSetUnitId") Integer buildingSetUnitId);

	/**
	 * 获取该层楼最大的 SYS_BUILD_FLOOR
	 *
	 * @param cityId Integer
	 * @author czq
	 * @since 2018年12月18日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	String selectMaxSysRoomIdInFloor(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
									 @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId,
									 @Param("buildingSetUnitId") Integer buildingSetUnitId, @Param("buildingSetFloorId") Integer buildingSetFloorId);

	/**
	 * 获取楼层信息
	 *
	 * @param cityId Integer
	 * @author czq
	 * @since 2018年12月18日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getFloorById(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
						@Param("buildId") Integer buildId, @Param("buildingSetFloorId") Integer buildingSetFloorId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void delBuildFloorBySysBuildFloor(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId,
									  @Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId,
									  @Param("needDelFloors") List<Integer> needDelFloors);

	void insetWithSysBuildFloor(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId,
								@Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId,
								@Param("needAddSysBuildFloor") Integer needAddSysBuildFloor);

	ErpBuildingSetFloor selectRoofAndUnitNameInFloor(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
								@Param("buildId") Integer buildId, @Param("buildingSetFloorId") Integer buildingSetFloorId);

	/**
	 * @author wangchun
	 * @return
	 */
	List<BuildingRoofUnitFloorNameDto> getRoofAndUnitNameInFloor(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
																 @Param("buildId") Integer buildId, @Param("buildingSetRoomIds") String buildingSetRoomIds);

	void batchAddBuildFloor(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId,
								@Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId,
								@Param("needAddFloors") List<Integer> needAddFloors);
	/**
	 *	筛选楼层
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @param houseUseage
	 * @author 黄建海
	 * @since 2018/12/29 0029
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingSetFloor> selectByHouseUseage(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("houseUseage") Integer houseUseage);
	/**
	 *号室筛选楼层
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @param houseUseage
	 * @author 黄建海
	 * @since 2018/12/29 0029
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetFloor> selectByNumHouseUseage(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("houseUseage") Integer houseUseage);
	/**
	 *	根据单元id和楼层查询楼层
	 * @param  * @param cityId
	 * @param compId
	 * @param id
	 * @param buildFloor
	 * @author 黄建海
	 * @since 2019/1/5 0005
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetFloor selectByUnitIdandBuildFloor(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("id") Integer id,@Param("buildFloor") String buildFloor);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetFloor> selectByHouseUseageAndRoof(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer selectCountInFloor(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
							   @Param("buildingSetUnitId")Integer buildingSetUnitId, @Param("buildingSetFloorId")Integer buildingSetFloorId,
							   @Param("buildFloor") String buildFloor);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpRegisterBuildingSetUnitVO> selectMaxSysFloorInUnits(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
																@Param("buildId") Integer buildId, @Param("unitIds") List<Integer> unitIds);
	List<ErpRegisterBuildingSetUnitVO> selectMinSysFloorInUnits(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
																@Param("buildId") Integer buildId, @Param("unitId") Integer unitId);
}


