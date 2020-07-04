package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpKpiUserAssociateConfig;
import com.myfun.repository.erpdb.po.ErpKpiUserAssociateConfigExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpKpiUserAssociateConfigMapper extends BaseMapper<ErpKpiUserAssociateConfig, ErpKpiUserAssociateConfig> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpKpiUserAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpKpiUserAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpKpiUserAssociateConfig> selectByExample(ErpKpiUserAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpKpiUserAssociateConfig record, @Param("example") ErpKpiUserAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpKpiUserAssociateConfig record, @Param("example") ErpKpiUserAssociateConfigExample example);

    void insertHalfKPITarget(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId, @Param("idNo") String idNo, @Param("month") String month,
                             @Param("activeType") int activeType, @Param("now") Date createTime);

    void initKpiStatisticRecord(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId, @Param("currentDayStart") Date currentDayStart,
                                @Param("monthStart")Date monthStart);

    void notExistThenInsert(@Param("shardCityId") Integer cityId,@Param("po") ErpKpiUserAssociateConfig userAssociateConfig);

    void invalidConfig(@Param("shardCityId")Integer cityId,  @Param("userId")Integer userId,  @Param("updateTime")Date updateTime);
}