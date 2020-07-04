package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.dto.AgencyBuildingInfoDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.param.AgencyDistributeAdsparam;
import com.myfun.repository.agencydb.po.AgencyDistributeAds;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyDistributeAdsMapper extends BaseMapper<AgencyDistributeAds, Integer> {
    /**
     * 查询分销广告列表
     *
     * @param adminDistributeAdsparam
     * @return
     */
    List<AgencyDistributeAds> getBuildAdvList(AgencyDistributeAdsparam agencyDistributeAdsparam);

    /**
     * 统计条数
     *
     * @param advType
     * @param publishCity
     * @return
     */
    int countSeqNo(@Param("advType") Integer advType, @Param("publishCity") String publishCity);

    /**
     * 修改排序
     *
     * @param advType
     * @param publishCity
     */
    void updateSeqNo(@Param("advType") Integer advType, @Param("publishCity") String publishCity, @Param("seqNo") String seqNo);

    /**
     * 获取最大id
     *
     * @return
     */
    Integer getMaxid();

    /**
     * 修改排序1
     *
     * @param advType
     * @param publishCity
     */
    void updateSeqNo1(@Param("advType") Integer advType, @Param("publishCity") String publishCity, @Param("seqNo") String seqNo);

    /**
     * 修改排序2
     *
     * @param advType
     * @param publishCity
     */
    void updateSeqNo2(@Param("advType") Integer advType, @Param("publishCity") String publishCity,
                      @Param("oldSeqNo") String oldSeqNo, @Param("seqNo") String seqNo);

    /**
     * 修改排序3
     *
     * @param advType
     * @param publishCity
     */
    void updateSeqNo3(@Param("advType") Integer advType, @Param("publishCity") String publishCity,
                      @Param("oldSeqNo") String oldSeqNo, @Param("seqNo") String seqNo);

    /**
     * 获取首页广告列表
     *
     * @param
     * @return
     * @author 胡坤
     * @since 2018年4月9日
     */
    List<AgencyDistributeAds> getDistAdsOnIndex(@Param("cityId") String cityId, @Param("compId") Integer compId, @Param("compNo") String compNo);
}