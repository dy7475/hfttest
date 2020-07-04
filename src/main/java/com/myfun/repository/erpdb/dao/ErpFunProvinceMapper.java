package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunProvince;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpFunProvinceMapper extends BaseMapper<ErpFunProvince, ErpFunProvince> {

    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunProvince> getProvinceList(@Param("shardCityId") Integer cityId);

}