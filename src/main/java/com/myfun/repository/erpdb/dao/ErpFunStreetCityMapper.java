package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.vo.ErpFunStreetCityVO;
import com.myfun.repository.erpdb.po.ErpFunStreetCity;
import com.myfun.repository.erpdb.po.ErpFunStreetCityExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStreetCityMapper extends BaseMapper<ErpFunStreetCity, ErpFunStreetCity> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunStreetCityExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunStreetCityExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunStreetCity> selectByExample(ErpFunStreetCityExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunStreetCity record, @Param("example") ErpFunStreetCityExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunStreetCity record, @Param("example") ErpFunStreetCityExample example);

    List<ErpFunStreetCityVO> getStreetCityList(@Param("shardCityId") Integer shardCityId,
                                               @Param("compId") Integer compId, @Param("streetProvinceId") Integer streetProvinceId);

    int deleteStreetCityById(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId,
                                 @Param("id") Integer id, @Param("delUserId") Integer delUserId);

    int getMaxId(@Param("shardCityId") Integer shardCityId);

    ErpFunStreetCityVO getStreetCity(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("streetCityId") Integer streetCityId);
}