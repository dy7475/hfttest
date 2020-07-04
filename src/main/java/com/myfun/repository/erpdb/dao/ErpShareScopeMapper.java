package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpShareScope;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ErpShareScopeMapper extends BaseMapper<ErpShareScope, ErpShareScope> {
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpShareScope getShareScopeByCompId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);
}