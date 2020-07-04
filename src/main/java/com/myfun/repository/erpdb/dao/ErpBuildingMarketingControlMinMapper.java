package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.vo.GetRoofInfoVo;
import com.myfun.repository.erpdb.po.ErpBuildingMarketingControlMin;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpBuildingMarketingControlMinMapper extends BaseMapper<ErpBuildingMarketingControlMin, ErpBuildingMarketingControlMin> {

    List<ErpBuildingMarketingControlMin> getControlInfo(@Param("shardCityId") Integer cityId, @Param("buildIds")List<Integer> buildIds,@Param("compId")Integer compId);

    ErpBuildingMarketingControlMin getBuildOnSaleLeaseCount(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void deleteById(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId);
}