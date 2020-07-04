package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunResetSms;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Type;
import java.util.Map;

public interface ErpFunResetSmsMapper extends BaseMapper<ErpFunResetSms, ErpFunResetSms> {
    @SwitchDB(type = SwitchDBType.CITY_ID)
    Integer countMsg(@Param("shardCityId") Integer cityId, @Param("pMap") Map<String, Object> pMap);
}