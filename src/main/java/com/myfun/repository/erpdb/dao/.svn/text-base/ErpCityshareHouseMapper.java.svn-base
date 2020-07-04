package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpCityshareHouse;
import com.myfun.repository.erpdb.po.ErpCityshareHouseExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpCityshareHouseMapper extends BaseMapper<ErpCityshareHouse, ErpCityshareHouse> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpCityshareHouseExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpCityshareHouseExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpCityshareHouse> selectByExample(ErpCityshareHouseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpCityshareHouse record, @Param("example") ErpCityshareHouseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpCityshareHouse record, @Param("example") ErpCityshareHouseExample example);
    
    /**
     * 城市大公盘分享数据分佣比例
     * @param cityId
     * @param caseType
     * @param caseIds
     * @return
     */
    List<ErpCityshareHouse> getHouseByCaseIds(@Param("shardCityId")Integer cityId, @Param("caseType")Integer caseType, @Param("caseIds")Set<Integer> caseIds);
    
    /**
     * 数据移交改城市大公盘数据
     *@author 朱科
     *@param 
     *@return void
     *@since 2018年6月14日
     */
    void transDataByCaseId(@Param("shardCityId")Integer cityId, @Param("param")ErpCityshareHouse cityshareHouse);
}