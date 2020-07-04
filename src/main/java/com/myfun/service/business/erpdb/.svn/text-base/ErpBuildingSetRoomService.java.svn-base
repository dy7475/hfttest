/**
 * @author 方李骥
 * @since 2016年9月2日
 */
package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.BuildingSetRoomParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetFloorParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetRoomParam;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoom;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

import java.util.List;

public interface ErpBuildingSetRoomService extends BaseMapper<ErpBuildingSetRoom, ErpBuildingSetRoom> {

	/**
	 * 修改或者创建房间
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param param
	 */
	void updateOrCreateRoom(BaseMapParam param);

	/**
	 * 删除房间
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元  sysRoomId前端计算出的房间号
	 * @return
	 */
	void delBuildRoomById(BaseMapParam param);

	/**
	 * 复制房间信息到整列
	 * @param param
	 * @param sysRoomIdsList
	 */
	void updateRoomInfoToLine(Integer cityId, ErpBuildingSetRoomParam param, String[] sysRoomIdsList);

	/**
	 * 修改楼盘楼层名
	 * @author 张宏利
	 * @since 2017年10月10日
	 * @param
	 * @param param
	 */
	void updateBuildFloor(ErpBuildingSetFloorParam param);
	public void judgeHouseRuleAndThrow(Integer cityId,Integer compId,Integer currUserId, Integer buildId, String houseRoof, String houseUnit, String houseNum,
			String houseFloor, Integer caseType, Byte useage);

	/**
	 * 专门用于依据规则生成房间编号
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @param floor
	 * @param door
	 * @param numberRule
	 * @param compriseRule
	 * @param numberType
	 * @param doorStart
	 * @param roomTemp
	 * @param
	 * @return
	 */
	public String createBuildRuleNumber(int floor, int door, Byte numberRule, Byte compriseRule, Byte numberType,
			int doorStart, int roomTemp);

	/**
	 * 删除楼盘房间信息
	 *
	 * @param param DeleteIdParam
	 * @param cityId Integer
	 * @param compId Integer
	 * @param userId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	void delBuildRoom(DeleteIdParam param, Integer cityId, Integer compId, Integer userId);


	/**
	 * 删除本列房间信息
	 *
	 * @param param RoomIdsParam
	 * @param cityId Integer
	 * @param compId Integer
	 * @param userId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	void deleteRoomInColumn(RoomIdsParam param, Integer cityId, Integer compId, Integer userId);

	/**
	 * 删除本行房间信息
	 *
	 * @param param RoomIdsParam
	 * @param cityId Integer
	 * @param compId Integer
	 * @param userId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	void deleteRoom(RoomIdsParam param, Integer cityId, Integer compId, Integer userId);

	/**
	 * 删除本行房间信息
	 *
	 * @param param BuildingSetRoomParam
	 * @param cityId Integer
	 * @param compId Integer
	 * @param userId Integer
	 * @author czq
	 * @since 2018年12月17日
	 */
	void addBuildRoom(BuildingSetRoomParam param, Integer cityId, Integer compId, Integer userId);

	/**
	 * 获取房间详情
	 *
	 * @param param ErpBuildingSetRoomIdParam
	 * @param cityId Integer
	 * @param compId Integer
	 * @author czq
	 * @since 2018年12月18日
	 */
	ErpBuildingSetRoomDetailsVo getBuildRoomDetails(ErpBuildingSetRoomIdParam param, Integer cityId, Integer compId);

	/**
	 * 合并房间
	 *
	 * @param param RoomIdsParam
	 * @author wangchun
	 * @since 2018年12月19日
	 */
	void mergeRoomInfo(RoomIdsParam param);

	/**
	 * 编辑房间
	 * @author wangchun
	 * @param param
	 */
	void updateRoomInfo(UpdateRoomInfoParam param,String addrMd5,Integer cityId,Integer compId,String oldMd5);

	/**
	 * 替换已登记房源户型图
	 * @param param
	 */
	void insertHouseLayoutSync(UpdateRoomInfoParam param,String addrMd5,Integer cityId,Integer compId);

	/**
	 * 取消合并房间
	 * @author wangchun
	 * @param param
	 */
	void cancelMergeRoomInfo(CancelMergeRoomInfoParam param);

	/**
	 * 普通栋座加密
	 */
	String encodeToMD5(Integer buildId, String roof, String unit, String floor, String num);

	/**
	 * 号位加密
	 */
	String encodeToMD5ByUnit(Integer buildId, String unit, String num);

	/**
	 * 获取销控房间信息
	 *
	 * @param param        RoomConInfoByCaseParam
	 * @param generalParam GeneralParam
	 * @return
	 * @author czq
	 * @since 2019年3月27日
	 */
	List<RoomConInfoVo> getRoomConInfoByCase(RoomConInfoByCaseParam param, GeneralParam generalParam);

	/**
	 * 获取房间销控信息(出售,出租,租售)数量
	 *
	 * @param param        RoomConInfoByCaseParam
	 * @param generalParam GeneralParam
	 * @return RoomConInfoCountVo
	 * @author czq
	 * @since 2019年3月30日
	 */
	RoomConInfoCountVo getRoomConInfoCount(RoomConInfoCountParam param, GeneralParam generalParam);

	/**
	 * 移动端获取房间列表(包含销控信息)
	 *
	 * @param param        ErpBuildingGetRoomInfoListIdParam
	 * @param generalParam GeneralParam
	 * @return FloorListVo
	 * @author czq
	 * @since 2019年4月8日
	 */
	FloorListVo getRoomInfoListInMobile(ErpBuildingGetRoomInfoListIdParam param, GeneralParam generalParam);

	/**
	 * 移动端楼盘字典房间查看房源列表
	 *
	 * @param param        CaseIdsParam
	 * @param generalParam GeneralParam
	 * @return FunListByCaseIdsVo
	 * @author czq
	 * @since 2019年4月11日
	 */
	FunListByCaseIdsVo getFunListByCaseIdsInMobile(CaseIdsParam param, GeneralParam generalParam);

	/**
	 * 查看客源列表
	 *
	 * @param param        CaseIdsParam
	 * @param generalParam GeneralParam
	 * @return CustomersByCaseIdsVo
	 * @author czq
	 * @since 2019年6月1日
	 */
	CustomersByCaseIdsVo getCustomersByCaseIds(CaseIdsParam param, GeneralParam generalParam);

	void generateBuildRuleByExcel(GenerateBuildRuleByExcelParam param);

	void buildRuleAddZero(GenerateBuildRuleByExcelParam param);

	void delBuildRule(GenerateBuildRuleByExcelParam param);

}
