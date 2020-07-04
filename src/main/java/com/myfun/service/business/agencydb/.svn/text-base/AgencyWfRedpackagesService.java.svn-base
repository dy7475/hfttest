package com.myfun.service.business.agencydb;

import com.myfun.repository.agencydb.po.AgencyWfRedpackages;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年6月21日 下午2:45:44 
 * 类说明 
*/
public interface AgencyWfRedpackagesService extends BaseMapper<AgencyWfRedpackages, Integer> {
	/**
	 * 查询红包情况
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @param type 红包类型(1,普通红包(专属红包,代金券),2补贴红包)
	 * @return
	 */
	AgencyWfRedpackages getRecordForUUMobile(Integer cityId, Integer caseId, Integer caseType, int type);

}
