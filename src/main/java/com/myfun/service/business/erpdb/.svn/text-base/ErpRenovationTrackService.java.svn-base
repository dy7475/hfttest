package com.myfun.service.business.erpdb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.RenovationCustomerParam;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpRenovationTrackService extends BaseMapper<ErpRenovationCustomerTrack, ErpRenovationCustomerTrack>{

	/**
	 * 装修客户写跟进
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月26日
	 */
	void createTrack(Integer cityId, Integer compId, Integer userId, Integer archiveId, BaseMapParam param);
	
	/**
	 * 编辑装修客户资料写跟进
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年3月1日
	 */
	void createUpdateCustomeTrack(RenovationCustomerParam param);
}
