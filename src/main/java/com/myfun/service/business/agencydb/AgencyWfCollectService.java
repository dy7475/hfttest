package com.myfun.service.business.agencydb;

import com.myfun.repository.agencydb.po.AgencyWfCollect;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfCollectService extends BaseMapper<AgencyWfCollect, Integer> {
	
	/**
	 * 查询房源是否已被收藏
	 * @author 陈文超
	 * @date 2016年6月4日 上午11:39:17
	 */
	AgencyWfCollect getWfCollectInfo(Integer caseId, Byte caseType, String wxId, Integer cityId) throws Exception;
}
