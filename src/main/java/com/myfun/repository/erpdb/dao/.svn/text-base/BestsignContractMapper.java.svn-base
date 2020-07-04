package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.BestsignContract;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@SwitchDB
public interface BestsignContractMapper {
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insert(BestsignContract bestsignContract);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	BestsignContract getById(@Param("shardCityId") Integer cityId, @Param("id") String id);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	BestsignContract getByContractId(@Param("shardCityId") Integer cityId, @Param("contractId") String contractId,@Param("ownerCardNo") String ownerCardNo);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	BestsignContract getListByparam(Map map);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateSignState(Map<String, String> map);
	
}
