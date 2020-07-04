package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpYouBorkerComplaintDto;
import com.myfun.repository.erpdb.po.ErpYouBorkerComplaint;
import com.myfun.repository.erpdb.po.ErpYouShareHouseStatus;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouBorkerComplaintMapper extends BaseMapper<ErpYouBorkerComplaint, ErpYouBorkerComplaint> {
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	int getNotComPlainCounts(@Param("shardCityId")Integer cityId, @Param("shareId")Integer shareId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	int getHouseComPlainCounts(@Param("shardCityId")Integer cityId, @Param("shareId")Integer shareId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	int getPurchasePersonNumber(@Param("shardCityId")Integer cityId, @Param("shareId")Integer shareId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpYouBorkerComplaintDto> getCompalinListByShareId(@Param("shardCityId")Integer cityId, @Param("param")ErpYouShareHouseStatus erpYouShareHouseStatus);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	ErpYouBorkerComplaint getByPrimaryKey(@Param("shardCityId")Integer cityId, @Param("complainId")Integer complainId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	int updateComplaint(@Param("shardCityId")Integer cityId, @Param("complaint")ErpYouBorkerComplaint complaint);
}