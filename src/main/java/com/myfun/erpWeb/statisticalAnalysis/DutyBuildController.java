package com.myfun.erpWeb.statisticalAnalysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.reportdb.dao.ReportFunDutyBuildMapper;
import com.myfun.repository.reportdb.dao.ReportFunStatisticDetail1Mapper;
import com.myfun.repository.reportdb.po.ReportFunDutyBuild;
import com.myfun.service.business.report.ReportFunDutyBuildService;
import com.myfun.utils.DateUtil;

/**
 * 运营分析-责任盘相关
 * @author 张宏利
 * @since 2017年9月28日
 */
@RestController
@RequestMapping("/statisticalAnalysis/dutyBuild")
public class DutyBuildController extends BaseController{
	@Autowired ReportFunDutyBuildMapper reportFunDutyBuildMapper;
	@Autowired ReportFunDutyBuildService reportFunDutyBuildService;
	@Autowired ReportFunStatisticDetail1Mapper reportFunStatisticDetail1Mapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	
	/**
	 * 责任盘的增删改
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param param
	 * @return
	 */
	@NotBlank("deptId")
	@RequestMapping("/updateDeptDutyBuild")
	public ResponseJson updateDeptDutyBuild(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		String dutyBuildJson = param.getString("dutyBuildJson");
		Integer deptId = param.getInteger("deptId");
		List<ReportFunDutyBuild> dutyList = new LinkedList<>();
		if(StringUtils.isNotBlank(dutyBuildJson)) {
			dutyList = JSON.parseObject(dutyBuildJson, new TypeReference<List<ReportFunDutyBuild>>(){});
		}
		reportFunDutyBuildService.updateDeptDutyBuild(operator.getCityId(), operator.getCompId(), deptId, dutyList);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取责任盘列表
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getDeptDutyBuild")
	public ResponseJson getDeptDutyBuild(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		param.setInteger("compId", operator.getCompId());
		DataAnalysisController.changeSerchRange(param);
		String serchRange = param.getString("serchRange");
		Integer serchRangeId = param.getInteger("serchRangeId");
		List<ReportFunDutyBuild> dutyBuildList = reportFunDutyBuildMapper.getDeptDutyBuild(operator.getCityId(), operator.getCompId(), serchRange, serchRangeId);
		// 把没有配置的补到列表里面去
		List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptList(operator.getCityId(), operator.getCompId(), null, serchRange, serchRangeId);
		Set<Integer> deptIdSet = dutyBuildList.stream().collect(Collectors.mapping(ReportFunDutyBuild::getDeptId, Collectors.toSet()));
		for (ErpFunDepts depts : deptList) {
			if(!deptIdSet.contains(depts.getDeptId())) {
				ReportFunDutyBuild dutyBuild = new ReportFunDutyBuild();
				dutyBuild.setDeptId(depts.getDeptId());
				dutyBuildList.add(dutyBuild);
			}
		}
		return ErpResponseJson.ok(dutyBuildList);
	}
	
	/**
	 * 获取责任盘列表
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param param
	 * serchRange	查询范围 COMP,AREA,REG,DEPT
	 * serchRangeId	查询范围ID
	 * caseType	房源类型（1：出售，2：出租，其他或不传：全部）
	 * startTime	起始时间
	 * endTime	结束时间
	 * dateType	0=日统计 1= 周统计 2=月统计
	 * @return
	 */
	@NotBlank({"dateType"})
	@RequestMapping("/getDutyBuildStatistic")
	public ResponseJson getDutyBuildStatistic(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		param.setInteger("cityId", operator.getCityId());
		param.setInteger("compId", operator.getCompId());
		DataAnalysisController.changeSerchRange(param);
		// 门店量
		param.setString("statisticType", "1");// 新增
		List<Map<String, Object>> deptDjList = reportFunStatisticDetail1Mapper.getDeptDutyBuildStatistic(param.getMap());
		param.setString("statisticType", "11");// 钥匙
		List<Map<String, Object>> deptYsList = reportFunStatisticDetail1Mapper.getDeptDutyBuildStatistic(param.getMap());
		param.setString("statisticType", "8");// 委托
		List<Map<String, Object>> deptWtList = reportFunStatisticDetail1Mapper.getDeptDutyBuildStatistic(param.getMap());
		// 查询范围内所有的责任盘列表
		String serchRange = param.getString("serchRange");
		Integer serchRangeId = param.getInteger("serchRangeId");
		List<ReportFunDutyBuild> dutyBuildList = reportFunDutyBuildMapper.getDeptDutyBuild(operator.getCityId(), operator.getCompId(), serchRange, serchRangeId);
		Set<Object> buildIdSet = dutyBuildList.stream().collect(Collectors.mapping(ReportFunDutyBuild::getBuildId, Collectors.toSet()));
		// 总共的
		List<Map<String, Object>> totalDjList = null, totalYsList = null, totalWtList = null;
		if(buildIdSet != null && !buildIdSet.isEmpty()) {
			param.setObject("buildIds", buildIdSet);
			param.setString("statisticType", "1");// 新增
			totalDjList = reportFunStatisticDetail1Mapper.getTotalDutyBuildStatistic(param.getMap());
			param.setString("statisticType", "11");// 钥匙
			totalYsList = reportFunStatisticDetail1Mapper.getTotalDutyBuildStatistic(param.getMap());
			param.setString("statisticType", "8");// 委托
			totalWtList = reportFunStatisticDetail1Mapper.getTotalDutyBuildStatistic(param.getMap());
		}
		// 周统计要把日统计出来的数据组装成周统计
		if ("1".equals(param.getString("dateType"))) {
			Set<String> addSet = new HashSet<>();
			addSet.add("counts");
			String[] consignGroupKey = new String[] { "houseConsign", "buildId" };// 委托需要时间+委托类型进行分组
			String[] commonGroupKey = new String[] { "buildId" };// 委托需要时间+委托类型进行分组
			String startTime = param.getString("startTime");
			String endTime = param.getString("endTime");
			List<String> weeksList = DateUtil.getBetweenWeeks(startTime, endTime, "~");
			deptDjList = DateUtil.changeDayToWeekList(deptDjList, "dateTime", addSet, commonGroupKey, weeksList);
			deptYsList = DateUtil.changeDayToWeekList(deptYsList, "dateTime", addSet, commonGroupKey, weeksList);
			deptWtList = DateUtil.changeDayToWeekList(deptWtList, "dateTime", addSet, consignGroupKey, weeksList);
			totalDjList = DateUtil.changeDayToWeekList(totalDjList, "dateTime", addSet, commonGroupKey, weeksList);
			totalYsList = DateUtil.changeDayToWeekList(totalYsList, "dateTime", addSet, commonGroupKey, weeksList);
			totalWtList = DateUtil.changeDayToWeekList(totalWtList, "dateTime", addSet, consignGroupKey, weeksList);
		}
		// 组装数据
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("deptDjList", deptDjList);
		resultMap.put("deptYsList", deptYsList);
		resultMap.put("deptWtList", deptWtList);
		resultMap.put("totalDjList", totalDjList);
		resultMap.put("totalYsList", totalYsList);
		resultMap.put("totalWtList", totalWtList);
		resultMap.put("dutyBuildList", dutyBuildList);
		return ErpResponseJson.ok(resultMap);
	}
}

