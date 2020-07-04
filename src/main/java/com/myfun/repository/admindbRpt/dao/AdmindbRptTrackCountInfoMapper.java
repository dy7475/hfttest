package com.myfun.repository.admindbRpt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindbRpt.dto.AdmindbRptMarketingCountInfoDto;
import com.myfun.repository.admindbRpt.po.AdmindbRptTrackCountInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdmindbRptTrackCountInfoMapper extends BaseMapper<AdmindbRptTrackCountInfo, Integer> {
	/**
	 * 增加工作量统计条数，供JMS消费端调用
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @throws Exception
	 */
	public void addWorkCount(AdmindbRptTrackCountInfo admindbRptTrackCountInfo) throws Exception;
}