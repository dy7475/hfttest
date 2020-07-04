package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.businesstools.builddic.param.BuildFloorAddParam;
import com.myfun.erpWeb.businesstools.builddic.param.BuildFloorIdParam;
import com.myfun.erpWeb.businesstools.builddic.param.BuildingSetFloorParam;
import com.myfun.erpWeb.businesstools.builddic.param.UnitSingleAddParam;
import com.myfun.repository.erpdb.po.ErpBuildingSetFloor;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

/**
 * @author czq
 * @since 2018/12/18
 */
public interface ErpBuildingSetFloorService extends BaseMapper<ErpBuildingSetFloor, ErpBuildingSetFloor> {

    /**
     * 修改楼层信息
     *
     * @param param ErpBuildingGetRoomInfoListIdParam
     * @author czq
     * @since 2018年12月18日
     */
    void updateBuildFloor(BuildingSetFloorParam param, Integer cityId, Integer compId, Integer userId);

    /**
     * 增加单元或者号位
     *
     * @param param        BuildFloorAddParam
     * @param generalParam GeneralParam
     *
     * @author czq
     * @since 2019年3月26日
     */
    void addBuildFloor(BuildFloorAddParam param, GeneralParam generalParam);

    /**
     * 增加单元或者号位
     *
     * @param param        BuildFloorAddParam
     * @param generalParam GeneralParam
     *
     * @author czq
     * @since 2019年3月26日
     */
    void delBuildFloorById(BuildFloorIdParam param, GeneralParam generalParam);

}
