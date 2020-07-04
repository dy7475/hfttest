package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.param.BatchUpdateRoomMd5;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpBuildingMarketingControlDto;
import com.myfun.erpWeb.businesstools.builddic.vo.GetRoofInfoVo;
import com.myfun.repository.erpdb.po.ErpBuildingMarketingControl;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpBuildingMarketingControlMapper extends BaseMapper<ErpBuildingMarketingControl, ErpBuildingMarketingControl> {

    List<ErpBuildingMarketingControlDto> getRoomConInfo(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,@Param("buildId")Integer buildId,
                                                        @Param("buildingSetRoof")String buildingSetRoof, @Param("buildingSetUnit")String buildingSetUnit);

    /**
     * 查询栋销控信息
     */
    GetRoofInfoVo getRoofConInfo(@Param("shardCityId") Integer cityId, @Param("buildId")Integer buildId,
                              @Param("compId")Integer compId, @Param("buildingSetRoof")String buildingSetRoof);

    /**
     * 查询户销控信息
     */
    GetRoofInfoVo getUnitConInfo(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,
                              @Param("buildId")Integer buildId, @Param("buildingSetUnit")String buildingSetUnit);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void batchUpdateRoomMd5(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
                            @Param("batchUpdateRoomMd5s") List<BatchUpdateRoomMd5> batchUpdateRoomMd5s);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void deleteById(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId);

    void delete(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
                @Param("marketingControl") ErpBuildingMarketingControl marketingControl);
}