package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.vo.ErpFunStreetProvinceVO;
import com.myfun.erpWeb.businesstools.builddic.vo.StreetTerritoryVo;
import com.myfun.repository.erpdb.po.ErpFunStreetProvince;
import com.myfun.repository.erpdb.po.ErpFunStreetProvinceExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStreetProvinceMapper extends BaseMapper<ErpFunStreetProvince, ErpFunStreetProvince> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunStreetProvinceExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunStreetProvinceExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunStreetProvince> selectByExample(ErpFunStreetProvinceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunStreetProvince record, @Param("example") ErpFunStreetProvinceExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunStreetProvince record, @Param("example") ErpFunStreetProvinceExample example);

    List<ErpFunStreetProvinceVO> getStreetProvinceList(@Param("shardCityId") Integer shardCityId,
                                                       @Param("compId") Integer compId, @Param("streetTerritoryId") Integer streetTerritoryId);

    int deleteStreetProvinceById(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId,
                                  @Param("id") Integer id, @Param("delUserId") Integer delUserId);

    int getMaxId(@Param("shardCityId") Integer shardCityId);

    ErpFunStreetProvinceVO getStreetProvince(@Param("shardCityId") Integer shardCityId,
                                             @Param("compId") Integer compId, @Param("streetProvinceId") Integer streetProvinceId);

}