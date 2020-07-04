package com.myfun.service.business.report.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.reportdb.dao.ReportFunDutyBuildMapper;
import com.myfun.repository.reportdb.po.ReportFunDutyBuild;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.report.ReportFunDutyBuildService;

@Service
public class ReportFunDutyBuildServiceImpl extends AbstractService<ReportFunDutyBuild, Integer>implements ReportFunDutyBuildService {
	@Autowired
	private ReportFunDutyBuildMapper reportFunDutyBuildMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = reportFunDutyBuildMapper;
	}

	/**
	 * 责任盘的增删改
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param 
	 */
	@Override
	public void updateDeptDutyBuild(Integer cityId, Integer compId, Integer deptId, List<ReportFunDutyBuild> dutyList) {
		// 先删除门店所有
		reportFunDutyBuildMapper.deleteDeptDutyBuild(cityId, compId, deptId);
		if(dutyList == null || dutyList.isEmpty()) {
			return;
		}
		Set<Integer> buildIdSet = dutyList.stream().collect(Collectors.mapping(ReportFunDutyBuild::getBuildId, Collectors.toSet()));
		List<Map<String, Object>> countList = reportFunDutyBuildMapper.getBuildCountList(cityId, compId, buildIdSet);
		if(countList != null && countList.size() > 0) {
			throw new ConfirmException("该楼盘已有其他责任门店");
		}
		// 再新增
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		for (ReportFunDutyBuild reportFunDutyBuild : dutyList) {
			reportFunDutyBuild.setCityId(cityId);
			reportFunDutyBuild.setCompId(compId);
			reportFunDutyBuild.setAreaId(erpFunDepts.getAreaId());
			reportFunDutyBuild.setRegId(erpFunDepts.getRegId());
			reportFunDutyBuild.setDeptId(erpFunDepts.getDeptId());
			reportFunDutyBuild.setCreationTime(new Date());
			reportFunDutyBuildMapper.insertSelective(reportFunDutyBuild);
		}
	}

}
