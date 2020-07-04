package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.param.GetMgrUsrIsInAtParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpAccountTypeDto;
import com.myfun.repository.erpdb.po.ErpAccountType;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAccountTypeMapper extends BaseMapper<ErpAccountType, ErpAccountType> {

	List<ErpAccountTypeDto> getAccountTypeList(@Param("shardCityId") Integer shardCityId, @Param("param") Map<String, Object> map);
	public Map<String,Object> getMgrUsrIsInAt(@Param("shardCityId") Integer shardCityId,@Param("param")GetMgrUsrIsInAtParam map);
}