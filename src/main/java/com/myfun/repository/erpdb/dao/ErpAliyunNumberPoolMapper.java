package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.AliyunNumberPoolDto;
import com.myfun.repository.erpdb.po.ErpAliyunNumberPool;
import com.myfun.repository.erpdb.po.ErpAliyunNumberPoolExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAliyunNumberPoolMapper extends BaseMapper<ErpAliyunNumberPool, ErpAliyunNumberPool> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpAliyunNumberPoolExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpAliyunNumberPoolExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpAliyunNumberPool> selectByExample(ErpAliyunNumberPoolExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpAliyunNumberPool record, @Param("example") ErpAliyunNumberPoolExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpAliyunNumberPool record, @Param("example") ErpAliyunNumberPoolExample example);
    
    List<AliyunNumberPoolDto> getNumberPoolList(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId);
    
    ErpAliyunNumberPool getNumberPool(@Param("shardCityId") Integer shardCityId, @Param("numberPoolKey") String numberPoolKey);
    
    
    ErpAliyunNumberPool getNumberPoolByOrgId(@Param("shardCityId") Integer shardCityId, @Param("orgId") Integer orgId);
    
}