package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.extension.framework.mybatis.type.WrapMap;
import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpBuildingSetRoomDetailsVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpBuildingSetRoomShowInTableVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpRegisterBuildingSetRoomVO;
import com.myfun.erpWeb.businesstools.builddic.vo.MLErpRegisterBuildingSetRoomVO;
import com.myfun.repository.erpdb.dto.RoomWithBuildFloorDto;
import com.myfun.repository.erpdb.param.BuildingSetRoomParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetRoomParam;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoom;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoomExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface ErpBuildingSetRoomMapper extends BaseMapper<ErpBuildingSetRoom, ErpBuildingSetRoom> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetRoomExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetRoomExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingSetRoom> selectByExample(ErpBuildingSetRoomExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingSetRoom record,
			@Param("example") ErpBuildingSetRoomExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingSetRoom record,
			@Param("example") ErpBuildingSetRoomExample example);

	/**
	 * 通过用户输入的房间ID查询该房间
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param param
	 * @return
	 */
	ErpBuildingSetRoom selectByUserRoomId(ErpBuildingSetRoomParam param);

	/**
	 * 通过前端生成的房间ID查询该房间
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param param
	 * @return
	 */
	ErpBuildingSetRoom selectBySysRoomId(ErpBuildingSetRoomParam param);

	/**
	 * 通过单元获取所有房间列表
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param param
	 * @return
	 */
	List<ErpBuildingSetRoom> getRoomInfoList(ErpBuildingSetRoomParam param);

	/**
	 * 删除栋座
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座
	 * @return
	 */
	void delBuildRoofById(ErpBuildingSetParam param);

	/**
	 * 删除单元
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元
	 */
	void delBuildUnitById(ErpBuildingSetParam param);

	/**
	 * 获取所有的房间数量，删除的和有效的
	 * @author 张宏利
	 * @since 2017年8月28日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @return
	 */
	Map<String, Object> getDoorAllCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId);

	List<ErpBuildingSetRoom> getRoomInfoListBySysRoomIds(@Param("shardCityId")Integer cityId, @Param("param") ErpBuildingSetRoomParam param, @Param("sysRoomIdsList")String[] sysRoomIdsarr);

	/**
	 * 修改房间的单元
	 * @author 张宏利
	 * @since 2017年9月7日
	 * @param param
	 */
	void updateRoomUnit(ErpBuildingSetParam param);

	/**
	 * 通过老的roof修改成新的roof
	 * @author 张宏利
	 * @since 2017年9月27日
	 * @param param
	 */
	void updateRoofByOldRoof(ErpBuildingSetParam param);

	ErpBuildingSetRoom getErpBuildingSetRoom(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId,@Param("houseRoof")String houseRoof,@Param("houseUnit")String houseUnit,@Param("houseFloor")String houseFloor,@Param("houseNum")String houseNum,@Param("delFlag")Integer delFlag);

	List<ErpBuildingSetRoom> getRoomList(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId,@Param("houseRoof")String houseRoof,@Param("houseUnit")String houseUnit,@Param("houseFloor")String houseFloor,@Param("houseNum")String houseNum,@Param("delFlag")Integer delFlag);

	/**
	 * 获取合并的房间号
	 * @author 张宏利
	 * @since 2017年11月2日
	 * @param roomParam
	 * @return
	 */
	Integer getUnitMergeRoom(ErpBuildingSetRoomParam roomParam);

	/**
	 * 获取在sysRoomIdSet内的存在的系统ID列表
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @return
	 */
	List<String> getContainSysIdList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("buildId") Integer buildId, @Param("buildRoof") String buildRoof,
			@Param("buildUnit") String buildUnit, @Param("sysRoomIdSet") List<String> sysRoomIdSet);

	/**
	 * 批量增加房间
	 * @author 张宏利
	 * @since 2018年1月30日
	 */
	void insertList(@Param("shardCityId") Integer cityId, @Param("roomList") List<ErpBuildingSetRoom> roomList);

	void delBuildById(ErpBuildingSetParam param);

	/**
	 * 获取该房间是否已经被合并(mergeRoom值不为空)
	 * @author czq
	 * @since 2018年12月12日
	 * @param param ErpBuildingSetRoomParam
	 * @return 大于0则该房间已经处于合并状态
	 */
	Integer checkExistsMergeRoom(ErpBuildingSetRoomParam param);

	/**
	 * 删除楼盘房间信息
	 *
	 * @param cityId Integer
	 * @param param DeleteIdParam
	 * @param compId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void delBuildRoom(@Param("shardCityId") Integer cityId, @Param("param") DeleteIdParam param, @Param("compId") Integer compId);

	/**
	 * 获取房间信息
	 *
	 * @param cityId Integer
	 * @param buildId Integer
	 * @param buildingSetRoomId Integer
	 * @param compId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetRoomDetailsVo getBuildRoomDetailsVo(@Param("shardCityId") Integer cityId, @Param("buildId") Integer buildId,
													  @Param("buildingSetRoomId") Integer buildingSetRoomId, @Param("compId") Integer compId);

	/**
	 * 查询房号是否被占用
	 * @author wangchun
	 */
	Integer checkExistsRoomId(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId,
							  @Param("buildingSetUnitId")Integer buildingSetUnitId,@Param("roomId")String roomId,
							  @Param("buildingSetRoomId") Integer buildingSetRoomId, @Param("buildingSetFloorId") Integer buildingSetFloorId);

	/**
	 * 查询房间是否存在
	 * @author wangchun
	 */
	ErpBuildingSetRoom checkExistsRoom(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("id")Integer id);

	/**
	 * 编辑单条房间信息
     * @author wangchun
	 * @since 2018年12月18日
	 * @param cityId
	 * @param param
	 */
	void updateRoomInfo(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("param")UpdateRoomInfoParam param,@Param("addrMd5")String addrMd5);

    /**
     * 同步同单元同楼号的房间信息
     * @author wangchun
	 * @since 2018年12月18日
     */
    void syncRoomInfo(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("param")UpdateRoomInfoParam param,@Param("ids")List<Integer> ids);


	/**
	 *
	 * 根据房间id查询房间合并与删除状态
	 */
	List<ErpBuildingSetRoom> getAimRooms(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId, @Param("ids")String ids,
										 @Param("buildingSetRoofId")Integer buildingSetRoofId,@Param("buildingSetUnitId")Integer buildingSetUnitId);

	/**
	 * 修改合并房间信息
	 * @author wangchun
	 * @since 2018年12月19日
	 */
	void updateMergeRomms(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId, @Param("ids")String ids,@Param("mergeRoom")Integer mergeRoom);

	/**
	 * 获取合并的房间号
	 * @author wangchun
	 * @since 2018年12月19日
	 */
	Integer getMergeRoom(@Param("shardCityId") Integer cityId,@Param("param") RoomIdsParam param);

	/**
	 * 取消房间合并
	 * @author wangchun
	 * @param param
	 */
	void cancelMergeRoomInfo(@Param("shardCityId") Integer cityId,@Param("param") CancelMergeRoomInfoParam param);

	/**
	 * 取消房间合并后把之后的合并序号往前移一位
	 * @author wangchun
	 * @param param
	 */
	void cancelMergeReduceMergeRoom(@Param("shardCityId") Integer cityId,@Param("param")CancelMergeRoomInfoParam param);

	/**
	 *根据栋id和栋房间获取
	 * @param cityId
	 * @param compId
	 * @param buildRoom
	 * @param buildingSetRoofId
	 * @author 黄建海
	 * @since 2018年12月20日
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetRoom getBuildRoomByRoofIdAndRoomId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("buildRoom") String buildRoom,@Param("buildSetRoofId") Integer buildingSetRoofId);
	/**
	 *
	 * @param  * @param cityId
	 * @param compId
	 * @param buildingSetRoofId
	 * @param buildingSetFloorId
	 * @param buildRoom
	 * @author 黄建海
	 * @since 2018/12/20 0020
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetRoom selectByRoofIdAndFloorIdAndBuildRoom(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("buildingSetRoofId") Integer buildingSetRoofId,@Param("buildingSetFloorId") Integer buildingSetFloorId,@Param("buildRoom") String[] buildRoom);
	/**
	 *	根据楼层获取房间id
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @param floorIds
	 * @author 黄建海
	 * @since 2018/12/21 0021
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpRegisterBuildingSetRoomVO> selectByBuildIdAndFloorIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("floorIds") List<Integer> floorIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<MLErpRegisterBuildingSetRoomVO> selectByBuildIdAndFloorIdsML(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId, @Param("floorIds") List<Integer> floorIds);

	/**
	 * 获取房间列表信息
	 *
	 * @param cityId Integer
	 * @param buildId Integer
	 * @param compId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoomShowInTableVo> selectRoomShowInTableVos(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
																   @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId,
																   @Param("buildingSetUnitId") Integer buildingSetUnitId);
	/**
	 *根据楼层id和房间查询是否存在
	 * @param  * @param cityId
	 * @param compId
	 * @param id
	 * @param buildRoom
	 * @author 黄建海
	 * @since 2018/12/21 0021
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingSetRoom selectByfloorIdAndBuildRoom(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("buildId") Integer buildId,
												   @Param("buildingSetFloorId") Integer buildingSetFloorId,@Param("buildRoom") String buildRoom);

	/**
	 * 将房间户型,建筑面积,套内面积,朝向,户型图应用到本栋本单元同房号
	 *
	 * @param cityId Integer
	 * @param param ErpBuildingSetRoom
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchUpdateRoom(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
						 @Param("param") BuildingSetRoomParam param, @Param("buildingSetRoomIds") List<Integer> buildingSetRoomIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void delBuildRoomByRoomFloor(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
								 @Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId,
								 @Param("needDelFloors") List<Integer> needDelFloors);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void delBuildRoomBySysRoomId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
								 @Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId,
								 @Param("notDelSysRoomIds") List<String> notDelSysRoomIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void addRoomBySourceSysRoomId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
						 @Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId,
						 @Param("sysRoomIdInAdd") String sysRoomIdInAdd, @Param("sourceSysRoomId") String sourceSysRoomId,
								  @Param("roomFloor") Integer roomFloor, @Param("roomId") String roomId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateFloorIdInRoom(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
							 @Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId);

	Integer getCountByMerRoom(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("buildId") Integer buildId,
							  @Param("buildingSetUnitId") Integer buildingSetUnitId, @Param("mergeRoom") Integer mergeRoom);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchAddRooms(@Param("shardCityId") Integer cityId, @Param("batchAddRooms") List<ErpBuildingSetRoom> batchAddRooms);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoom> getRoomBySys(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
										  @Param("buildId") Integer buildId, @Param("buildingSetUnitId") Integer buildingSetUnitId,
										  @Param("sourceSysRoomId") String sourceSysRoomId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchUpdateRoomMd5(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
							@Param("batchUpdateRoomMd5s") List<BatchUpdateRoomMd5> batchUpdateRoomMd5s);

	/**
	 * 获取房间列表信息,包含用户填写的楼层(用于md5加密)
	 *
	 * @param cityId Integer
	 * @param buildId Integer
	 * @param compId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<RoomWithBuildFloorDto> selectRoomWithBuildFloor(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
														 @Param("buildId") Integer buildId, @Param("buildingSetRoofId") Integer buildingSetRoofId,
														 @Param("buildingSetUnitId") Integer buildingSetUnitId);
    @SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetRoom selectByUnitIdAndBuildRoom(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("id") Integer id,@Param("room") String[] room);


    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingSetRoom> getRoomListById(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("ids") String ids);

	List<ErpBuildingSetRoom> getRoomListByMd5s(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
											   @Param("buildId") Integer buildId, @Param("md5s") Set<String> md5s);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoom> getDistinctBuildId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchUpdateRoomMd5InAddZero(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId, @Param("rooms") List<ErpBuildingSetRoom> rooms);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingSetRoom> getDistinctBuildIdLessTenFloor(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("buildId") Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoom> getBuildWithoutRoom(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoom> getBuildWithBrackets1(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoom> getBuildWithBrackets2(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoom> getBuildWithBrackets3(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingSetRoom> getBuildWithBrackets4(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@Select(value="SELECT ID id,BUILD_ID buildId, BUILD_ROOF buildRoof,BUILD_UNIT buildUnit,ROOM_FLOOR roomFloor, ROOM_ID roomId,ADDR_MD5 addrMd5 FROM BUILDING_SET_ROOM where ID >= #{minId} and  ID < #{maxId}")
	List<ErpBuildingSetRoom> selectBuildingSetUnitTmpMaxMinId(@Param("shardCityId") Integer cityId, @Param("minId") Integer minId, @Param("maxId") Integer maxId);
}
