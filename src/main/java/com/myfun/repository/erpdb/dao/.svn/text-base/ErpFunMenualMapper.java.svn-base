package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.dto.ErpFunMenualDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunMenual;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunMenualMapper extends BaseMapper<ErpFunMenual, ErpFunMenual> {

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunMenual record);

	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param cityId
	 * @param dicValue
	 * @return
	 */
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpFunMenual> getBizMnaualList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dicValue") String dicValue);
	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpFunMenual> selectListByTypes(@Param("pMap")Map<String, Object> pMap, @Param("shardCityId")Integer cityId);
}