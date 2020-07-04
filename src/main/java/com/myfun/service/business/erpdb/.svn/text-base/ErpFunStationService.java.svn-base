package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunStation;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月30日 下午4:11:31 
 * 类说明 
*/
public interface ErpFunStationService extends BaseMapper<ErpFunStation, Integer>{
	/**
	 * 查询地铁站点
	 * @param cityId
	 * @param stationId
	 * @return
	 */
	List<ErpFunStation> getStationList(String cityId, String stationId);
	
	/**
	 * 查询指定的站点
	 * @param cityId
	 * @param stationIds
	 * @return
	 */
	List<ErpFunStation> formatStation(String cityId, String stationIds);

}
