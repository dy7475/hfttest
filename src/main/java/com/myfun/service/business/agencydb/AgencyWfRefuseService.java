package com.myfun.service.business.agencydb;

import com.myfun.repository.agencydb.po.AgencyWfRefuse;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年6月21日 下午12:44:27 
 * 类说明 
*/
public interface AgencyWfRefuseService extends BaseMapper<AgencyWfRefuse, Integer> {
	/**
	 * 拒绝经纪人
	 * @param param
	 */
	void reFuseBroker(AgencyWfRefuse param);

}
