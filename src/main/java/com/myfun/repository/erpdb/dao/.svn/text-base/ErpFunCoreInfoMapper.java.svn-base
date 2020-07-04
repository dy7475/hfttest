package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunCoreInfo;
import com.myfun.repository.erpdb.po.ErpFunCoreInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunCoreInfoMapper extends BaseMapper<ErpFunCoreInfo, ErpFunCoreInfo> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunCoreInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunCoreInfoExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunCoreInfo> selectByExample(ErpFunCoreInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunCoreInfo record, @Param("example") ErpFunCoreInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunCoreInfo record, @Param("example") ErpFunCoreInfoExample example);

    List<Map<String,Object>> getSaleLeaseCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("buildId") Integer buildId,
                                               @Param("caseRoof") String caseRoof,@Param("caseUnit")  String caseUnit);
    
	void updateByCaseInfo(ErpFunCoreInfo erpFunCoreInfo);
}