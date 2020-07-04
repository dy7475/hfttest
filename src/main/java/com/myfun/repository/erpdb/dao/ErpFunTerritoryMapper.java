package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.vo.StreetTerritoryVo;
import com.myfun.repository.erpdb.po.ErpFunTerritory;
import com.myfun.repository.erpdb.po.ErpFunTerritoryExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunTerritoryMapper extends BaseMapper<ErpFunTerritory, ErpFunTerritory> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunTerritoryExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunTerritoryExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunTerritory> selectByExample(ErpFunTerritoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunTerritory record, @Param("example") ErpFunTerritoryExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunTerritory record, @Param("example") ErpFunTerritoryExample example);

    List<StreetTerritoryVo> getStreetTerritoryList(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId);

    int deleteStreetTerritoryById(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId,
                                  @Param("id") Integer id, @Param("delUserId") Integer delUserId);

    int getMaxId(@Param("shardCityId") Integer shardCityId);

    StreetTerritoryVo getStreetTerritory(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("streetTerritoryId") Integer streetTerritoryId);

}