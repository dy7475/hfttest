package com.myfun.service.business.agencydb;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.agencydb.po.AgencyVipQueue;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyVipQueueService extends BaseMapper<AgencyVipQueue, Integer> {
	
	/**
	 * 点击我的委托查询委托列表信息
	 * @author 陈文超
	 * @date 2016年6月15日 下午3:28:28
	 */
	PageInfo<AgencyVipQueue> queryAgencyVipQueueList(Integer cityId, Integer wxId , Integer pageNum ,Integer pageSize)throws Exception;
}
