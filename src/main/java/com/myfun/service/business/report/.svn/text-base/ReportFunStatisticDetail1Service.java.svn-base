package com.myfun.service.business.report;

import com.myfun.repository.reportdb.po.ReportFunStatisticDetail1;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ReportFunStatisticDetail1Service extends BaseMapper<ReportFunStatisticDetail1, Long> {
	/**
	 * 增加工作量统计条数，供JMS消费端调用
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @throws Exception
	 */
	public void addWorkCount(ReportFunStatisticDetail1 erpFunStatisticDetail, Integer jmsMsgId, int index);
	/**
	 * 增加工作量统计条数，供Admin打电话回调后调用
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @throws Exception
	 */
	public void adminAddWorkCount(String sessionId);
}
