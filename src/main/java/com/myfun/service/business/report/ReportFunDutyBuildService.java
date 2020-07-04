package com.myfun.service.business.report;

import java.util.List;

import com.myfun.repository.reportdb.po.ReportFunDutyBuild;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ReportFunDutyBuildService extends BaseMapper<ReportFunDutyBuild, Integer> {
	/**
	 * 责任盘的增删改
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param 
	 */
	public void updateDeptDutyBuild(Integer cityId, Integer compId, Integer deptId, List<ReportFunDutyBuild> dutyList);
}
