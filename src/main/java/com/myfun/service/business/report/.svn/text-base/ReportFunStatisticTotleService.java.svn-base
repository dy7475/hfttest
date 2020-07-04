package com.myfun.service.business.report;

import com.myfun.repository.reportdb.po.ReportFunStatisticTotle;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Map;

public interface ReportFunStatisticTotleService extends BaseMapper<ReportFunStatisticTotle, Long> {
	/**
	 * 增加工作量统计条数，供JMS消费端调用
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @throws Exception
	 */
	public void addWorkCount(ReportFunStatisticTotle adminRptFunStatisticTotle);

	Map<String,Object> getHouseCustRanking(Integer cityId,  Map<String,Object> param);
}
