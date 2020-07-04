package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunSubway;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月30日 下午3:58:05 
 * 类说明 
*/
public interface ErpFunSubWayService extends BaseMapper<ErpFunSubway, Integer>{
	/**
	 * 查询城市地铁
	 * @param cityId
	 * @return
	 */
	List<ErpFunSubway> getSubwayList(String cityId);
	
	/**
	 * 查询指定的地铁线
	 * @param cityId
	 * @param split
	 * @return
	 */
	List<ErpFunSubway> getSubwayListByCityIdAndSubId(String cityId, String subIds);

}
