package com.myfun.repository.erpdb.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunHousePublishLog;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunHousePublishLogMapper extends BaseMapper<ErpFunHousePublishLog, Integer> {
	/**
	 * 获取根据列表
	 * @param cityId
	 * @param pubId
	 * @return
	 */
	public ArrayList<ErpFunHousePublishLog> getListInfo(@Param("shardCityId")String cityId, @Param("pubId")String pubId);
}