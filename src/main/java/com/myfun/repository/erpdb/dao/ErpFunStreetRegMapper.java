package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.vo.ErpFunStreetRegVO;
import com.myfun.repository.erpdb.po.ErpFunStreetReg;
import com.myfun.repository.erpdb.po.ErpFunStreetRegExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStreetRegMapper extends BaseMapper<ErpFunStreetReg, ErpFunStreetReg> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunStreetRegExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunStreetRegExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunStreetReg> selectByExample(ErpFunStreetRegExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunStreetReg record, @Param("example") ErpFunStreetRegExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunStreetReg record, @Param("example") ErpFunStreetRegExample example);

    List<ErpFunStreetRegVO> getStreetRegList(@Param("shardCityId") Integer shardCityId,
                                              @Param("compId") Integer compId, @Param("streetCityId") Integer streetCityId);

    int deleteStreetRegById(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId,
                             @Param("id") Integer id, @Param("delUserId") Integer delUserId);

    int getMaxId(@Param("shardCityId") Integer shardCityId);

    ErpFunStreetRegVO getStreetReg(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("streetRegId") Integer streetRegId);

}