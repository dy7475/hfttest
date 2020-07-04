package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.erpWeb.common.param.AppInitDataParam;
import com.myfun.erpWeb.common.vo.SubwayVO;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunSubway;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@SwitchDB(type=SwitchDBType.CITY_ID)
public interface ErpFunSubwayMapper extends BaseMapper<ErpFunSubway, Integer> {
	
	/**
	 * 跟进城市查询地铁
	 * @param cityId
	 * @return
	 */
	List<ErpFunSubway> getSubwayList(@Param("shardCityId")String cityId);
	
	/**
	 * 查询指定的地铁线信息
	 * @param cityId
	 * @param subIds
	 * @return
	 */
	List<ErpFunSubway> getSubwayListByCityIdAndSubId(@Param("shardCityId")String cityId, @Param("subIds")String[] subIds);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<SubwayVO> getSubwayVOList(@Param("shardCityId")Integer cityId, @Param("param") AppInitDataParam param);
}