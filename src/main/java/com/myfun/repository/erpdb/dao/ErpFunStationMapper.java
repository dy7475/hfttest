package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.erpWeb.common.param.AppInitDataParam;
import com.myfun.erpWeb.common.vo.StationVO;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunStation;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type=SwitchDBType.CITY_ID)
public interface ErpFunStationMapper extends BaseMapper<ErpFunStation, Integer> {
	/**
	 * 查询地铁站点
	 * @param cityId
	 * @param split
	 * @return
	 */
	List<ErpFunStation> getStationList(@Param("shardCityId")String cityId, @Param("staIds")String[] staIds);
	
	/**
	 * 查询站点
	 * @param cityId
	 * @param stationIds
	 * @return
	 */
	List<ErpFunStation> formatStation(@Param("shardCityId")String cityId, @Param("stationIds")String[] stationIds);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<StationVO> getStationVOList(@Param("shardCityId")Integer cityId, @Param("param") AppInitDataParam param);
}