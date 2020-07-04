package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoof;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

import java.util.List;

/**
 * @author czq
 * @since 2018/12/11
 */
public interface ErpBuildingSetRoofService extends BaseMapper<ErpBuildingSetRoof, ErpBuildingSetRoof> {

    /**
     * 修改楼盘栋座信息
     *
     * @param param ErpBuildingSetRoofParam
     * @author czq
     * @since 2018年12月11日
     */
    void updateBuildingSetRoof(ErpBuildingSetRoofUpdateParam param, Integer cityId, Integer compId, Integer userId);

    /**
     * 删除楼盘栋座信息
     *
     * @param param ErpBuildingSetRoofParam
     * @author czq
     * @since 2018年12月11日
     */
    void delBuildRoofById(ErpBuildingSetRoofIdParam param, Integer cityId, Integer compId, Integer userId);

    /**
     * 获取楼盘栋座列表
     *
     * @param param BuildIdParam
     * @author czq
     * @since 2018年12月17日
     */
    List<ErpBuildingSetRoofNameVo> getBuildRoofList(BuildIdParam param, Integer cityId, Integer compId);

    /**
     * 根据楼栋ID获取楼盘栋座信息
     *
     * @param param ErpBuildingSetRoofIdParam
     * @param cityId Integer
     * @param compId Integer
     * @author czq
     * @since 2018年12月17日
     */
    ErpBuildingSetRoofRuleVo getBuildRoofById(ErpBuildingSetRoofIdParam param, Integer cityId, Integer compId);

    /**
     * 根据楼栋ID获取楼盘栋座信息
     *
     * @param param ErpBuildingGetRoomInfoListIdParam
     * @author czq
     * @since 2018年12月17日
     */
    ErpBuildingSetRoomListVo getRoomInfoList(ErpBuildingGetRoomInfoListIdParam param, Integer cityId, Integer compId);


    /**
     * 添加楼盘栋座信息
     *
     * @param param ErpBuildingSetRoofAddParam
     * @param cityId Integer
     * @param compId Integer
     * @author czq
     * @since 2018年12月18日
     */
    String addBuildRoof(ErpBuildingSetRoofAddParam param, Integer cityId, Integer compId, Integer userId, Integer provinceId, String compNo);

    /**
     *
     * @param cityId
     * @param compId
     * @param param
     * @author 黄建海
     * @since 2018年12月20日
     * @return
     */
    Integer getBuildingLockDate(Integer cityId, Integer compId, ErpBuildingLockDataParam param);

    /**
     * 清空楼盘规则
     *
     * @param buildId Integer
     * @param cityId Integer
     * @param compId Integer
     * @param userId Integer
     *
     * @author czq
     * @since 2018年12月22日
     */
    void delBuildRuleById(Integer cityId, Integer compId, Integer buildId, Integer userId);

    /**
     * 首次创建楼盘规则
     *
     * @param param        BuildRuleAddParam
     * @param generalParam GeneralParam
     * @return units 用逗号分隔开的单元ID的字符串
     * @author czq
     * @since 2019年3月25日
     */
    String addBuildRule(BuildRuleAddParam param, GeneralParam generalParam);

    /**
     * 单独添加栋座
     *
     * @param param        BuildRuleAddParam
     * @param generalParam GeneralParam
     * @return units 用逗号分隔开的单元ID的字符串
     * @author czq
     * @since 2019年3月25日
     */
    String addBuildRoofV2(RoofSingleAddParam param, GeneralParam generalParam, boolean isCopy);

    String batchAddBuildRoofV2(BuildRuleAddParam param, GeneralParam generalParam);

    RoomRuleDto generateRoomRule(Byte roomSortRule, Byte roomCompositionRule);

    RoomRuleDto generateRoomRuleWhenShow(Byte numberRule, Byte addedByAllUnits, Byte numberType, Byte compriseRule);

    /**
     * 编辑栋座
     *
     * @param param        RoofEditParam
     * @param generalParam GeneralParam
     * @return units 用逗号分隔开的单元ID的字符串
     * @author czq
     * @since 2019年3月27日
     */
    String updateBuildRoofV2(RoofEditParam param, GeneralParam generalParam);

    /**
     * 获取栋座详情(编辑或者复制时使用)
     *
     * @param param        RoofEditParam
     * @param generalParam GeneralParam
     * @return RoofDetailsVo
     * @author czq
     * @since 2019年3月28日
     */
    RoofDetailsVo getBuildRoofRuleV2(ErpBuildingSetRoofIdParam param, GeneralParam generalParam);

    /**
     * 移动端获取栋座规则列表
     *
     * @param param        BuildIdInMobileParam
     * @param generalParam GeneralParam
     * @return BuildRoofRuleInMobileVo
     * @author czq
     * @since 2019年4月8日
     */
    BuildRoofRuleInMobileVo getBuildRoofListInMobile(BuildIdInMobileParam param, GeneralParam generalParam);

    /**
     * 移动端获取栋座规则列表
     *
     * @param param        BuildRoofIdParam
     * @param generalParam GeneralParam
     * @return BuildRoofDetailsInMobileVo
     * @author czq
     * @since 2019年4月8日
     */
    BuildRoofDetailsInMobileVo getBuildRoofDetailsInMobile(BuildRoofIdParam param, GeneralParam generalParam);


    void deleteBuildingInfo(Integer cityId, Integer compId, Integer buildId, Integer userId);

}
