package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.businesstools.Attendance.param.GetMgrFineListParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFineDto;
import com.myfun.repository.erpdb.po.ErpFine;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFineMapper extends BaseMapper<ErpFine, ErpFine> {

	List<ErpFineDto> getFineTotal(@Param("shardCityId")Integer integer, @Param("param")Map<String, Object> map);
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpFine> selectMgrFineList(@Param("shardCityId")Integer integer, @Param("param") GetMgrFineListParam param);


}