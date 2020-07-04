package com.myfun.service.business.adminRpt;

import com.myfun.repository.admindbRpt.po.AdmindbRptTrackCountInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminRptTrackCountInfoService extends BaseMapper<AdmindbRptTrackCountInfo, Integer> {
	/**
	 * 增加工作量统计条数，供JMS消费端调用
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @throws Exception
	 */
	public void addWorkCount(AdmindbRptTrackCountInfo admindbRptTrackCountInfo, Integer jmsMsgId) throws Exception;
}
