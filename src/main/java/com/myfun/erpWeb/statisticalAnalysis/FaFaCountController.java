package com.myfun.erpWeb.statisticalAnalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminWebSiteMapper;
import com.myfun.repository.admindb.po.AdminWebSite;
import com.myfun.repository.fafundb.dao.FafunFafaDetailLogMapper;
import com.myfun.repository.fafundb.dao.FafunTHouseTrendsMapper;
import com.myfun.repository.fafundb.dto.FafaSiteClickRankDto;
import com.myfun.repository.fafundb.dto.FafunFafaDetailLogDto;
import com.myfun.repository.fafundb.dto.FafunTHouseTrendsDto;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.SortUtil;
import com.myfun.utils.StringUtil;

@Controller
@RequestMapping("/statisticalAnalysis/fafaCount")
public class FaFaCountController extends BaseController {

	@Autowired
	private FafunFafaDetailLogMapper fafunFafaDetailLogMapper;
	@Autowired
	private FafunTHouseTrendsMapper fafunTHouseTrendsMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminWebSiteMapper adminWebSiteMapper;
	@Autowired
	private ErpFunRegMapper erpFunRegMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	
	/**
	 * 点击量按时间分析
	 * 
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param dateCountType
	 * dateCountType	0=日统计 2=月统计
	 * serchRange		搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId		搜索范围的值
	 * saleLease		出租出售 1=出售 2 =出租
	 * startTime		开始时间
	 * endTime			结束时间
	 * showType			显示类型（没用-前端要求返回的信息）
	 * dateTime			按天传递给的时间
	 * sort				排序1.desc 2.ASC
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getClickCountByTime")
	public ResponseJson getClickCountByTime(@RequestBody BaseMapParam param) throws Exception {
		Integer countType = param.getInteger("dateCountType");
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		if (0 == countType) {
			String endTime = param.getString("endTime");
			if (StringUtils.isNotBlank(endTime)) {
				param.setString("endTime", endTime + " 23:59:59");
			}
			// 统计一天的
			FafunTHouseTrendsDto fafunTHouseTrendsDto = fafunTHouseTrendsMapper.getClickCountByDateTime(param.getMap());
			if (fafunTHouseTrendsDto == null) {
				return ErpResponseJson.ok();
			}
			// 组装数据
			List<Map<String, Object>> resultList = new ArrayList<>();
			resultList.add(setClickValToMap("07", fafunTHouseTrendsDto.getH7Click()));
			resultList.add(setClickValToMap("08", fafunTHouseTrendsDto.getH8Click()));
			resultList.add(setClickValToMap("09", fafunTHouseTrendsDto.getH9Click()));
			resultList.add(setClickValToMap("10", fafunTHouseTrendsDto.getH10Click()));
			resultList.add(setClickValToMap("11", fafunTHouseTrendsDto.getH11Click()));
			resultList.add(setClickValToMap("12", fafunTHouseTrendsDto.getH12Click()));
			resultList.add(setClickValToMap("13", fafunTHouseTrendsDto.getH13Click()));
			resultList.add(setClickValToMap("14", fafunTHouseTrendsDto.getH14Click()));
			resultList.add(setClickValToMap("15", fafunTHouseTrendsDto.getH15Click()));
			resultList.add(setClickValToMap("16", fafunTHouseTrendsDto.getH16Click()));
			resultList.add(setClickValToMap("17", fafunTHouseTrendsDto.getH17Click()));
			resultList.add(setClickValToMap("18", fafunTHouseTrendsDto.getH18Click()));
			resultList.add(setClickValToMap("19", fafunTHouseTrendsDto.getH19Click()));
			resultList.add(setClickValToMap("20", fafunTHouseTrendsDto.getH20Click()));
			resultList.add(setClickValToMap("21", fafunTHouseTrendsDto.getH21Click()));
			resultList.add(setClickValToMap("22", fafunTHouseTrendsDto.getH22Click()));
			return ErpResponseJson.ok(resultList);
		} else {
			String endTime = param.getString("endTime");
			if (StringUtils.isNotBlank(endTime)) {
				param.setString("endTime", endTime + " 23:59:59");
			}
			// 按月统计
			List<FafunTHouseTrendsDto> fafunTHouseTrendsDtoList = fafunTHouseTrendsMapper.getClickCountByMonthTime(param.getMap());
			if (fafunTHouseTrendsDtoList.isEmpty()) {
				return ErpResponseJson.ok();
			}
			// 补时间
			FafunTHouseTrendsDto baseObj = new FafunTHouseTrendsDto();
			baseObj.setValue(0);
			DataAnalysisUtil.repairDateForListObj(fafunTHouseTrendsDtoList, "name", baseObj,param.getString("startTime"), param.getString("endTime"), "0");
			return ErpResponseJson.ok(fafunTHouseTrendsDtoList);
		}
	}
	
	/**
	 * 封装name和value到map，返回map
	 * @author 熊刚
	 * @since 2017年7月27日
	 */
	private Map<String, Object> setClickValToMap(String name, Object value) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("name", name);
		dataMap.put("value", value);
		return dataMap;
	}

	/**
	 * 点击量按时间分析(报表)
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param dateCountType
	 * 0=日统计 2=月统计 serchRange 搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId 搜索范围的值 houseId 房源id saleLease 出租出售 1=出售 2 =出租
	 * startTime 开始时间 endTime 结束时间 sort 排序方式，这边没用上，DESC,ASC showType
	 * 显示类型（没用-前端要求返回的信息）
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getClickCountByTimeReport")
	public ResponseJson getClickCountByTimeReport(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		param.setInteger("cityId", cityId);
		param.setInteger("compId", compId);
		param.setString("endTime", param.getString("endTime") + " 23:59:59");
		// 查询top5的站点
		List<Map<String, Object>> topFiveSitelist = fafunTHouseTrendsMapper.getTopFiveSitelist(param.getMap());
		if (topFiveSitelist.isEmpty()) {
			return ErpResponseJson.ok();
		}
		List<String> sitesList = topFiveSitelist.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("siteId")), Collectors.toList()));
		// 查询站点名称
		List<Map<String, Object>> webSiteList = adminWebSiteMapper.getSiteName(param.getMap(), sitesList);
		Map<String, Map<String, Object>> webSiteMap = webSiteList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("siteId")), val -> val));
		// 遍历构造查询列
		Map<String, String> columnSiteMap = new HashMap<>();
		StringBuilder columnName = new StringBuilder();
		for (Map<String, Object> dataMap : topFiveSitelist) {
			String siteId = String.valueOf(dataMap.get("siteId"));
			columnName.append("SUM(iif(a.SITE_ID=" + siteId
					+ ",H7_CLICK + H8_CLICK + H9_CLICK + H10_CLICK + H11_CLICK + H12_CLICK + H13_CLICK + H14_CLICK + H15_CLICK + H16_CLICK + H17_CLICK + H18_CLICK + H19_CLICK + H20_CLICK + H21_CLICK + H22_CLICK,0)) as click"
					+ siteId + ",");
			// 站点和别名对应成k-v的形式
			columnSiteMap.put(siteId, "click" + siteId);
		}
		param.setObject("column", columnName.toString());
		// 拼数据，将站点名称替换site_id
		List<Map<String, Object>> fafunTHouseTrendsDtoList = fafunTHouseTrendsMapper.getClickCountByHouseId(param.getMap());
		for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
			int index = 0;
			for (Entry<String, Map<String, Object>> siteEntry : webSiteMap.entrySet()) {
				index++;
				Map<String, Object> webDataMap = siteEntry.getValue();// 获取对应的站点信息
				dataMap.put("siteName" + index, String.valueOf(webDataMap.get("siteName")));
				dataMap.put("clickValue" + index, dataMap.get(columnSiteMap.get(siteEntry.getKey())));
			}
		}
		// 获取出售列表
		Set<Integer> saleIds = fafunTHouseTrendsDtoList.stream().filter(dto -> ((Integer) dto.get("saleLease")) == 1)
				.collect(Collectors.mapping(dto -> (Integer) dto.get("houseId"), Collectors.toSet()));
		String[] queryColumn = new String[] { "SALE_ID", "SALE_USEAGE", "SALE_AREA", "BUILD_NAME", "SALE_ROOM",
				"SALE_HALL", "SALE_TOTAL_PRICE" };
		if (!saleIds.isEmpty()) {
			List<ErpFunSale> saleList = erpFunSaleMapper.selectSaleListByIds(cityId, saleIds.toArray(new Integer[] {}),
					queryColumn, compId);
			Map<Integer, ErpFunSale> saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
				Integer houseId = (Integer) dataMap.get("houseId");
				String primaryName = null;
				// 出售
				ErpFunSale erpFunSale = saleMap.get(houseId);
				if (erpFunSale != null) {
					primaryName = buildSaleTitle(erpFunSale);
					if (primaryName != null) {
						dataMap.put("primaryName", primaryName);
					}
				}
			}
		}
		// 获取出租列表
		Set<Integer> leaseIds = fafunTHouseTrendsDtoList.stream().filter(dto -> ((Integer) dto.get("saleLease")) == 2)
				.collect(Collectors.mapping(dto -> (Integer) dto.get("houseId"), Collectors.toSet()));
		queryColumn = new String[] { "LEASE_ID", "LEASE_USEAGE", "LEASE_AREA", "BUILD_NAME", "LEASE_ROOM", "LEASE_HALL",
				"LEASE_TOTAL_PRICE" };
		if (!leaseIds.isEmpty()) {
			List<ErpFunLease> leaseList = erpFunLeaseMapper.selectLeaseListByIds(cityId,leaseIds.toArray(new Integer[] {}), queryColumn, compId);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
				Integer houseId = (Integer) dataMap.get("houseId");
				String primaryName = null;
				// 出租
				ErpFunLease erpFunLease = leaseMap.get(houseId);
				if (erpFunLease != null) {
					primaryName = buildLeaseTitle(erpFunLease);
				}
				if (primaryName != null) {
					dataMap.put("primaryName", primaryName);
				}
			}
		}
		Integer ranking = 0;
		for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
			++ranking;
			dataMap.put("ranking", ranking);
		}
		return ErpResponseJson.ok(fafunTHouseTrendsDtoList);
	}

	/**
	 * 点击量按站点分析
	 * 
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param dateCountType
	 * 0=日统计 2=月统计 serchRange 搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId 搜索范围的值 houseId 房源id saleLease 出租出售 1=出售 2 =出租
	 * startTime 开始时间 endTime 结束时间 sort 排序方式，这边没用上，DESC,ASC showType
	 * 显示类型（没用-前端要求返回的信息）
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getClickCountBySite")
	public ResponseJson getClickCountBySite(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		param.setString("endTime", param.getString("endTime") + " 23:59:59");
		List<FafunTHouseTrendsDto> fafunTHouseTrendsDtoList = fafunTHouseTrendsMapper.getClickCountBySite(param.getMap());
		if (fafunTHouseTrendsDtoList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		return ErpResponseJson.ok(fafunTHouseTrendsDtoList);
	}

	/**
	 * 点击量按组织机构分析
	 * 
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param serchRange
	 * 搜索范围，COMP,AREA,REG,DEPT,GR,USER serchRangeId 搜索范围的值 saleLease
	 * 出租出售 1=出售 2 =出租 startTime 开始时间 endTime 结束时间 sort
	 * 排序方式，这边没用上，DESC,ASC showType 显示类型（没用-前端要求返回的信息）
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getClickCountByOrg")
	public ResponseJson getClickCountByOrg(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		param.setString("endTime", param.getString("endTime") + " 23:59:59");
		List<FafunTHouseTrendsDto> fafunTHouseTrendsDtoList = fafunTHouseTrendsMapper.getClickCountByOrg(param.getMap());
		if (fafunTHouseTrendsDtoList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		return ErpResponseJson.ok(fafunTHouseTrendsDtoList);
	}
	
	/**
	 * 点击量按组织机构分析报表
	 * 
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param serchRange
	 * 搜索范围，COMP,AREA,REG,DEPT,GR,USER serchRangeId 搜索范围的值 saleLease
	 * 出租出售 1=出售 2 =出租 startTime 开始时间 endTime 结束时间 sort
	 * 排序方式，这边没用上，DESC,ASC showType 显示类型（没用-前端要求返回的信息）
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getClickCountByOrgReport")
	public ResponseJson getClickCountByOrgReport(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		param.setString("endTime", param.getString("endTime") + " 23:59:59");
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		Integer organizationId = param.getInteger("organizationId");
		Integer defId = param.getInteger("defId");
		Integer userId = param.getInteger("userId");
//{"ANALYSIS_TYPE":"ORGANIZATION","CLIENTKEY":"d0c9bd8a1ea223c6821fb851f99e2708","dimension":"GROUP","endTime":"2019-11-27","saleLease":"","serchRange":"AREA","serchRangeId":"19567","startTime":"2019-11-01"}
		//**********************统计分析组织架构改版********************************
		if(operator.newOrganizationType()){       //代表查询新组织架构
			param.setString("dimension","ORGANIZATION");
			if(null != organizationId){//拼装WHERE 条件,如果不是COMP_ID就说明前端传了某个组织的ID，比如传了大区ID，就把这个大区的组织查出来把NAME拿出来拼装成WHERE条件
				GetSelectWhereParam getSelectWhereParam = new GetSelectWhereParam();
				getSelectWhereParam.setCityId(cityId);
				getSelectWhereParam.setUserId(userId);
				getSelectWhereParam.setPrefix("a.");
				getSelectWhereParam.setOrganizationId(organizationId);
				param.setString("rangeColumn", erpFunOrganizationService.getSelectWhereTwo(getSelectWhereParam));
				if(0 == organizationId){//代表查询全公司
					param.setInteger("serchRangeId", compId);
				} else {
					param.setInteger("serchRangeId", organizationId);
				}
				GetSelectWhereParam selectWhereParam = new GetSelectWhereParam();
                selectWhereParam.setCityId(cityId);
                selectWhereParam.setUserId(userId);
                selectWhereParam.setOrganizationId(organizationId);
				param.setString("selectColumn", erpFunOrganizationService.getSelectWhereTwo(selectWhereParam));
				if(0 == organizationId){//代表查询全公司
					param.setInteger("selectColumnId", compId);
				} else {
					param.setInteger("selectColumnId", organizationId);
				}
			}
			//调用方法拼装查询SQL
			GetSelectNmaesParam selectNmaesParam = new GetSelectNmaesParam();//这里就是拼装查询数据和GROUP BY条件，前端查什么都会传一个defId，根据这个组织拿到他和他上级所有的NAME来GROUP BY
            selectNmaesParam.setCompId(compId);
            selectNmaesParam.setCityId(cityId);
			selectNmaesParam.setDefId(defId);
			String selectNames = erpFunOrganizationService.getSelectNames(selectNmaesParam);
            String dbField = selectNames.substring(selectNames.lastIndexOf(",") + 1,selectNames.length());
            param.setString("rangeColumn",dbField + " IS NOT NULL AND a." +  param.getString("rangeColumn"));
			param.setString("dimensionColumnSql",erpFunOrganizationService.getSelectSqlTwo(dbField,null,"a"));
			if("-2".equals(defId.toString())){
				param.setString("dimensionGroupSqlLow",erpFunOrganizationService.getSelectSqlTwo(dbField,"0","a"));
			} else {
				param.setString("dimensionGroupSqlLow",erpFunOrganizationService.getSelectSqlTwo(selectNames,"0","a"));
			}
			//**********************组织架构改版********************************
		}

		// 查询top5的站点
		List<Map<String, Object>> topFiveSitelist = fafunTHouseTrendsMapper.getTopFiveSitelist(param.getMap());
		if (topFiveSitelist.size() == 0) {
			return ErpResponseJson.ok();
		}
		List<String> sitesList = topFiveSitelist.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("siteId")), Collectors.toList()));
		// 查询站点名称
		List<Map<String, Object>> webSiteList = adminWebSiteMapper.getSiteName(param.getMap(), sitesList);
		Map<String, Map<String, Object>> webSiteMap = webSiteList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("siteId")), val -> val));
		// 遍历构造查询列
		Map<String, String> columnSiteMap = new HashMap<>();
		StringBuilder columnName = new StringBuilder();
		for (Map<String, Object> dataMap : topFiveSitelist) {
			String siteId = String.valueOf(dataMap.get("siteId"));
			columnName.append("SUM(iif(a.SITE_ID=" + siteId
					+ ",H7_CLICK + H8_CLICK + H9_CLICK + H10_CLICK + H11_CLICK + H12_CLICK + H13_CLICK + H14_CLICK + H15_CLICK + H16_CLICK + H17_CLICK + H18_CLICK + H19_CLICK + H20_CLICK + H21_CLICK + H22_CLICK,0)) as click"
					+ siteId + ",");
			// 站点和别名对应成k-v的形式
			columnSiteMap.put(siteId, "click" + siteId);
		}
		param.setObject("column", columnName.toString());
		// 拼数据，将站点名称替换site_id
		List<Map<String, Object>> fafunTHouseTrendsDtoList = fafunTHouseTrendsMapper.getClickOrg(param.getMap());
		for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
			int index = 0;
			for (Entry<String, Map<String, Object>> siteEntry : webSiteMap.entrySet()) {
				index++;
				Map<String, Object> webDataMap = siteEntry.getValue();// 获取对应的站点信息
				Object name = webDataMap.get("siteName");
				dataMap.put("siteName" + index, name.toString());
				dataMap.put("clickValue" + index, dataMap.get(columnSiteMap.get(siteEntry.getKey())));
			}
		}
		Integer ranking = 0;
		for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
			++ranking;
			dataMap.put("ranking", ranking);
		}
		if(getOperator().newOrganizationType() && "-2".equals(param.getInteger("defId").toString())){
			Map<String, Object> map = new HashMap<>();
			map.put("dimension","-2");
			fafunTHouseTrendsDtoList.add(map);
		}
		return ErpResponseJson.ok(fafunTHouseTrendsDtoList);
	}

	/**
	 * 点击量按房源分析
	 * 
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param dateCountType
	 * 0=日统计 2=月统计 serchRange 搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId 搜索范围的值 houseId 房源id saleLease 出租出售 1=出售 2 =出租
	 * startTime 开始时间 endTime 结束时间 sort 排序方式，这边没用上，DESC,ASC showType
	 * 显示类型（没用-前端要求返回的信息） countType HOUSE_ROOM户型图 HOUSE_REG行政区
	 * HOUSE_FITMENT装修类型 HOUSE_TYPE类型
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getClickCountByHouse")
	public ResponseJson getClickCountByHouse(@RequestBody BaseMapParam param) throws Exception {
		Integer calculateTotalClick = 0;
		String countType = param.getString("dimension");
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String endTime = param.getString("endTime");
		if(StringUtils.isNotBlank(endTime)){
			param.setString("endTime", endTime + " 23:59:59");
		}
		List<FafunTHouseTrendsDto> fafunTHouseTrendsDtoList = fafunTHouseTrendsMapper.getClickCountByHouse(param.getMap());
		if (fafunTHouseTrendsDtoList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		if ("HOUSE_ROOM".equals(countType)) {
			// 判断统计类型是否是按户型来统计的
			// 首先按户型作为key，转换成一个map
			Map<String, FafunTHouseTrendsDto> dataMap = fafunTHouseTrendsDtoList.stream().collect(Collectors.toMap(FafunTHouseTrendsDto::getName, val -> val));
			// 数据汇总
			for (FafunTHouseTrendsDto fafunTHouseTrendsDto : fafunTHouseTrendsDtoList) {
				if( fafunTHouseTrendsDto.getName() != null && !fafunTHouseTrendsDto.getName().equals("")){
					if (Integer.valueOf(fafunTHouseTrendsDto.getName()) > 6) {
						calculateTotalClick += fafunTHouseTrendsDto.getValue();
						// 移除
						dataMap.remove(String.valueOf(fafunTHouseTrendsDto.getName()));
					}
				}
			}
			FafunTHouseTrendsDto dto = new FafunTHouseTrendsDto();
			if(calculateTotalClick!=0){
				dto.setName("7");
				dto.setValue(calculateTotalClick);
				dto.setCountType("HOUSE_ROOM");
				dataMap.put("7", dto);
			}
			for (FafunTHouseTrendsDto fafunTHouseTrendsDto : fafunTHouseTrendsDtoList) {
				fafunTHouseTrendsDto.setCountType("HOUSE_ROOM");
			}
			return ErpResponseJson.ok(new ArrayList<>(dataMap.values()));
		}
		if ("HOUSE_REG".equals(countType)) {
			// 判断统计类型是否是行政区来统计的
			List<ErpFunReg> erpFunRegList = erpFunRegMapper.getRegListByCityId(getOperator().getCityId());
			Map<String, FafunTHouseTrendsDto> trendDtoMap = fafunTHouseTrendsDtoList.stream()
					.collect(Collectors.toMap(FafunTHouseTrendsDto::getName, dto -> dto));
			// 数据汇总
			for (ErpFunReg erpFunReg : erpFunRegList) {
				String regIdStr = erpFunReg.getRegId().toString();
				FafunTHouseTrendsDto trendDto = trendDtoMap.get(regIdStr);
				if (trendDto != null) {
					trendDto.setName(erpFunReg.getRegName());
					trendDto.setValue(trendDto.getValue());
				} else {
					trendDto = new FafunTHouseTrendsDto();
					trendDto.setName(erpFunReg.getRegName());
					trendDto.setValue(0);
					trendDtoMap.put(regIdStr, trendDto);
				}
			}
			return ErpResponseJson.ok(trendDtoMap.values().toArray());
		}
		for (FafunTHouseTrendsDto fafunTHouseTrendsDto : fafunTHouseTrendsDtoList) {
			if ("HOUSE_REG".equals(countType)) {
				fafunTHouseTrendsDto.setCountType("HOUSE_REG");
			}
			if ("HOUSE_ROOM".equals(countType)) {
				fafunTHouseTrendsDto.setCountType("HOUSE_ROOM");
			}
			if ("HOUSE_FITMENT".equals(countType)) {
				fafunTHouseTrendsDto.setCountType("HOUSE_FITMENT");
			}
			if ("HOUSE_TYPE".equals(countType)) {
				fafunTHouseTrendsDto.setCountType("HOUSE_TYPE");
			}
		}
		return ErpResponseJson.ok(fafunTHouseTrendsDtoList);
	}
	
	/**
	 * 点击量按房源机构分析报表
	 * 
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param serchRange
	 * 搜索范围，COMP,AREA,REG,DEPT,GR,USER serchRangeId 搜索范围的值 saleLease
	 * 出租出售 1=出售 2 =出租 startTime 开始时间 endTime 结束时间 sort
	 * 排序方式，这边没用上，DESC,ASC showType 显示类型（没用-前端要求返回的信息）
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getClickCountByHouseReport")
	public ResponseJson getClickCountByHouseReport(@RequestBody BaseMapParam param) {
		param.setInteger("cityId", getOperator().getCityId());
		param.setString("compId", getOperator().getErpCompId());
		String endTime = param.getString("endTime");
		if(StringUtils.isNotBlank(endTime)){
			param.setString("endTime", endTime + " 23:59:59");
		}
		// 查询top5的站点
		List<Map<String, Object>> topFiveSitelist = fafunTHouseTrendsMapper.getTopFiveSitelist(param.getMap());
		if (topFiveSitelist.size() == 0) {
			return ErpResponseJson.ok();
		}
		List<String> sitesList = topFiveSitelist.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("siteId")), Collectors.toList()));
		// 查询站点名称
		List<Map<String, Object>> webSiteList = adminWebSiteMapper.getSiteName(param.getMap(), sitesList);
		Map<String, Map<String, Object>> webSiteMap = webSiteList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("siteId")), val -> val));
		List<String> siteIds = new ArrayList<>(webSiteMap.keySet());
		siteIds.sort((String a, String b) -> {return b.compareTo(a);});
		Map<String, String> columnSiteMap = new HashMap<>();
		//遍历构造查询列 
		StringBuilder columnName = new StringBuilder();
		for (Map<String, Object> dataMap : topFiveSitelist) {
			Object val = dataMap.get("siteId");
			if (val != null) {
				String siteId = val.toString();
				columnName.append("SUM(iif(a.SITE_ID="+siteId+",H7_CLICK + H8_CLICK + H9_CLICK + H10_CLICK + H11_CLICK + H12_CLICK + H13_CLICK + H14_CLICK + H15_CLICK + H16_CLICK + H17_CLICK + H18_CLICK + H19_CLICK + H20_CLICK + H21_CLICK + H22_CLICK,0)) as click"+siteId+",");
				// 站点和别名对应成k-v的形式
				columnSiteMap.put(siteId, "click" + siteId);
			}
		}
		param.setObject("column", columnName.toString());
		// 拼数据，将站点名称替换site_id
		List<Map<String, Object>> fafunTHouseTrendsDtoList = fafunTHouseTrendsMapper.getSiteByHouseType(param.getMap());
		for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
			int index = 0;
			for (String siteId : siteIds) {
				index++;
				Map<String, Object> webDataMap = webSiteMap.get(siteId);// 获取对应的站点信息
				dataMap.put("siteName" + index, String.valueOf(webDataMap.get("siteName")));
				dataMap.put("clickValue" + index, dataMap.get(columnSiteMap.get(siteId)));
			}
		}
		List<ErpFunReg> erpFunRegList = erpFunRegMapper.getRegListByCityId(getOperator().getCityId());
		Map<Integer, ErpFunReg> regMap = erpFunRegList.stream().collect(Collectors.toMap(ErpFunReg::getRegId, reg -> reg));
		if ("HOUSE_ROOM".equals(param.getString("dimension"))) {
			Map<String, Object> sixAboveData = new HashMap<String, Object>();
			sixAboveData.put("clickOther", 0);
			for (int i = 0; i < siteIds.size(); i++) {
				String siteId = siteIds.get(i);
				Map<String, Object> webDataMap = webSiteMap.get(siteId);// 获取对应的站点信息
				Object name = webDataMap.get("siteName");
				sixAboveData.put("siteName" + (i + 1), name.toString());
				sixAboveData.put("clickValue" + (i + 1), 0);
			}
			int clickValueAll = 0;
			for (int i = fafunTHouseTrendsDtoList.size() - 1; i >= 0; i--) {
				Map<String, Object> dataMap = fafunTHouseTrendsDtoList.get(i);
				Object primaryIdObject = dataMap.get("primaryName");
				if (primaryIdObject != null) {
					Integer primaryId = Integer.valueOf(primaryIdObject.toString());
					//统计6室以上的数据
					if (primaryId > 6) {
						for (int j = 0; j < siteIds.size(); j++) {
							if (dataMap.get("clickValue" + (j + 1)) != null) {
								Integer clickValue = Integer.valueOf(dataMap.get("clickValue" + (j + 1)).toString());
								clickValueAll += clickValue;
								sixAboveData.put("clickValue" + (j + 1),clickValue + Integer.valueOf(sixAboveData.get("clickValue"+(j+1)).toString()));
							}
						}
						sixAboveData.put("clickOther", Integer.valueOf(dataMap.get("clickOther").toString())
								+ Integer.valueOf(sixAboveData.get("clickOther").toString()));
						sixAboveData.put("totalClick", clickValueAll+Integer.valueOf(dataMap.get("clickOther").toString()));
						fafunTHouseTrendsDtoList.remove(i);// 移除
					}
				}
			}
			if (clickValueAll > 0 || (Integer) sixAboveData.get("clickOther") != 0) {
				sixAboveData.put("primaryName", "6室以上");
				fafunTHouseTrendsDtoList.add(sixAboveData);
			}
		}
		if ("HOUSE_REG".equals(param.getString("dimension"))) {
			for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
				// 数据汇总
				Integer primaryId = StringUtil.parseInteger(String.valueOf(dataMap.get("primaryId")), 0);
				ErpFunReg regTemp = regMap.get(primaryId);
				if (regTemp != null) {
					dataMap.put("primaryName", regTemp.getRegName());
					regMap.remove(primaryId);
				}
				dataMap.put("countType", "HOUSE_REG");
			}
			if (!regMap.isEmpty()) {
				for (ErpFunReg erpFunReg : regMap.values()) {
					Map<String, Object> tempMap = new HashMap<>();
					tempMap.put("primaryName", erpFunReg.getRegName());
					tempMap.put("countType", "HOUSE_REG");
					fafunTHouseTrendsDtoList.add(tempMap);
				}
			}
		}
		if ("HOUSE_FITMENT".equals(param.getString("dimension"))) {
			for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
				dataMap.put("countType", "HOUSE_FITMENT");
			}
		}
		if ("HOUSE_TYPE".equals(param.getString("dimension"))) {
			for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
				dataMap.put("countType", "HOUSE_TYPE");
			}
		}
		Integer ranking=0;
		for (Map<String, Object> dataMap : fafunTHouseTrendsDtoList) {
			++ranking;
			dataMap.put("ranking", ranking);
		}
		return ErpResponseJson.ok(fafunTHouseTrendsDtoList);
	}

	/**
	 * 站点统计图表/报表
	 * @author 何传强
	 * @since 2017年7月24日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSiteTableOrChartCount")
	public ResponseJson getSiteTableOrChartCount(@RequestBody BaseMapParam param){
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String showType = param.getString("showType");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		String countType = param.getString("countType");
		List<FafaSiteClickRankDto> resultList = fafunFafaDetailLogMapper.getUserTableOrChartCount(param.getMap());
		if (resultList.size() > 0) {
			if ("USER".equals(countType)) {// 员工
				Set<Integer> archiveIds = new HashSet<>();
				Set<Integer> siteIds = new HashSet<>();
				for (FafaSiteClickRankDto siteClickRankDto : resultList) {
					Integer archiveId = siteClickRankDto.getArchiveId();
					Integer siteId = siteClickRankDto.getSiteId();
					archiveIds.add(archiveId);
					siteIds.add(siteId);
				}
				if (archiveIds.size() > 0) {
					List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByArchiveIds(getOperator().getCityId(),archiveIds);
					Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getArchiveId, user -> user));
					for (FafaSiteClickRankDto siteClickRankDto : resultList) {
						ErpFunUsers erpFunUsers = userMap.get(siteClickRankDto.getArchiveId());
						if (erpFunUsers != null) {
							siteClickRankDto.setUserName(erpFunUsers.getUserName());
						} else {
							siteClickRankDto.setUserName("");
						}
					}
					Map<String, Map<String, Object>> resultMap = new HashMap<>();
					for (FafaSiteClickRankDto dto : resultList) {
						Map<String, Object> tempMap = resultMap.get(dto.getUserName());
						if (tempMap == null) {
							tempMap = new HashMap<>();
							resultMap.put(dto.getUserName(), tempMap);
						}
						Integer siteId = dto.getSiteId();
						tempMap.put("userName", dto.getUserName());
						tempMap.put("pub_" + siteId, dto.getPubCount());
						tempMap.put("del_" + siteId, dto.getDelCount());// 各站点下架量
						tempMap.put("ref_" + siteId, dto.getRefCount());// 各站点刷新量
						tempMap.put("sit_" + siteId, dto.getSiteCount());// 站点量
					}
					if ("CHART".equals(showType)) {// 图表,显示前10条数据
						List<Object> returnList = new ArrayList<>();
						LinkedList<Map<String, Object>> linkedList = new LinkedList<>(resultMap.values());
						if (linkedList.size() > 10) {
							for (int i = 0; i < 10; i++) {
								returnList.add(linkedList.get(i));
							}
							return ErpResponseJson.ok(returnList);
						} else {
							return ErpResponseJson.ok(linkedList);
						}
					} else {
						return ErpResponseJson.ok(new LinkedList<>(resultMap.values()));
					}
				}
			} else if ("SITE".equals(countType)) {// 站点
				Set<Integer> archiveIds = new HashSet<>();
				Set<Integer> siteIds = new HashSet<>();
				for (FafaSiteClickRankDto siteClickRankDto : resultList) {
					Integer archiveId = siteClickRankDto.getArchiveId();
					Integer siteId = siteClickRankDto.getSiteId();
					archiveIds.add(archiveId);
					siteIds.add(siteId);
				}
				SortUtil.collectionsSort(resultList, new String[]{"sumCount"}, false);
				List<AdminWebSite> siteList = adminWebSiteMapper.getSiteMapByCityId(getOperator().getCityId());
				Map<Integer, AdminWebSite> siteMap = siteList.stream().collect(Collectors.toMap(AdminWebSite::getSiteId, site -> site));
				Integer ranking = 0;
				for (FafaSiteClickRankDto siteClickRankDto : resultList) {
					AdminWebSite webSite = siteMap.get(siteClickRankDto.getSiteId());
					if (webSite != null) {
						siteClickRankDto.setRanking(++ranking);
						siteClickRankDto.setSiteName(webSite.getSiteName());
					}
				}
				return ErpResponseJson.ok(resultList);
			}
		}
		return ErpResponseJson.ok();
	}
	/**
	 * 获取各站点房源发布量统计
	 * @author 何传强
	 * @since 2017年7月13日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getEachSiteHousePushCount")
	public ResponseJson getEachSiteHousePushCount(@RequestBody BaseMapParam param){
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		String countType = param.getString("countType");
		List<FafaSiteClickRankDto> resultList = fafunFafaDetailLogMapper.getEachSiteHousePushCount(param.getMap());
		if (resultList.size() > 0) {
			if ("USER".equals(countType)) {// 员工
				Set<Integer> archiveIds = new HashSet<>();
				Set<Integer> siteIds = new HashSet<>();
				for (FafaSiteClickRankDto siteClickRankDto : resultList) {
					Integer archiveId = siteClickRankDto.getArchiveId();
					Integer siteId = siteClickRankDto.getSiteId();
					archiveIds.add(archiveId);
					siteIds.add(siteId);
				}
				if (archiveIds.size() > 0) {
					List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByArchiveIds(getOperator().getCityId(),archiveIds);
					Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getArchiveId, user -> user));
					for (FafaSiteClickRankDto siteClickRankDto : resultList) {
						ErpFunUsers erpFunUsers = userMap.get(siteClickRankDto.getArchiveId());
						if (erpFunUsers != null) {
							siteClickRankDto.setUserName(erpFunUsers.getUserName());
						}
					}
				}
				ErpResponseJson json = new ErpResponseJson();
				if (resultList.size() > 6) {
					List<Object> returnList = new ArrayList<>();
					for (int i = 0; i < 6; i++) {
						returnList.add(resultList.get(i));
					}
					json.setData(returnList);
				}else {
					json.setData(resultList);
				}
				json.setTotal(Long.valueOf(resultList.size()));
				return json;
			} else if ("SITE".equals(countType)) {// 站点
				Set<Integer> archiveIds = new HashSet<>();
				Set<Integer> siteIds = new HashSet<>();
				for (FafaSiteClickRankDto siteClickRankDto : resultList) {
					Integer archiveId = siteClickRankDto.getArchiveId();
					Integer siteId = siteClickRankDto.getSiteId();
					archiveIds.add(archiveId);
					siteIds.add(siteId);
				}
				List<AdminWebSite> siteList = adminWebSiteMapper.getSiteMapByCityId(getOperator().getCityId());
				Map<Integer, AdminWebSite> siteMap = siteList.stream().collect(Collectors.toMap(AdminWebSite::getSiteId, site -> site));
				for (FafaSiteClickRankDto siteClickRankDto : resultList) {
					AdminWebSite webSite = siteMap.get(siteClickRankDto.getSiteId());
					if (webSite != null) {
						siteClickRankDto.setSiteName(webSite.getSiteName());
					}
				}
				return ErpResponseJson.ok(resultList);
			}
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 异常次数异常统计
	 * @author 何传强
	 * @since 2017年7月17日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getExpectionCountStatistic")
	public ResponseJson getExpectionCountStatistic(@RequestBody BaseMapParam param){
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String dimension = param.getString("dimension");//组织维度
		if ("GROUP".equals(dimension)) {
			param.setString("dimension", "GR");
		}
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		List<FafunFafaDetailLogDto> detailLogDtoList=fafunFafaDetailLogMapper.getExpectionCountStatistic(param.getMap());
		if (detailLogDtoList.size() > 0) {
			Map<String, Map<String, String>> logDtoMap = new HashMap<>();
			for (FafunFafaDetailLogDto fafunFafaDetailLogDto : detailLogDtoList) {
				Integer statusIdInt = fafunFafaDetailLogDto.getStatusId();
				String statusId = String.valueOf(statusIdInt);
				Integer exceptionCount = fafunFafaDetailLogDto.getExceptionCount();
				// WARN:异常码判断不完整
				if (isInSet(statusId, SUCCESS_STATUS)) {// 操作成功的忽略统计
					continue;
				}
				if (exceptionCount <= 0) {
					continue;
				}
				String fafaErrorType = getFafaErrorType(statusId).getNameCn();
				Map<String, String> dtoMapGet = logDtoMap.get(fafaErrorType);
				if(dtoMapGet == null) {
					dtoMapGet = new HashMap<>();
					dtoMapGet.put("statusName", fafaErrorType);
					dtoMapGet.put("count", "0");
					logDtoMap.put(fafaErrorType, dtoMapGet);
				}
				exceptionCount += StringUtil.parseInteger(dtoMapGet.get("count"), 0);
				dtoMapGet.put("count", String.valueOf(exceptionCount));
			}
			List<Map<String, String>> logDtoList = new LinkedList<>(logDtoMap.values());
			logDtoList.sort((val1, val2) -> {
				Integer count1 = StringUtil.parseInteger(val1.get("count"), 0);
				Integer count2 = StringUtil.parseInteger(val2.get("count"), 0);
				return count2.compareTo(count1);
			});
			return new ErpResponseJson(logDtoList);
		}
		return ErpResponseJson.ok();
	}
	/**
	 * 按用户统计异常次数
	 * @author 何传强
	 * @since 2017年7月18日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getExpectionCountByUser")
	public ResponseJson getExpectionCountByUser(@RequestBody BaseMapParam param){
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		List<FafunFafaDetailLogDto> detailLogDtoList=fafunFafaDetailLogMapper.getExpectionCountByUser(param.getMap());
		if (detailLogDtoList.size() > 0) {
			Set<Integer> userIds = new HashSet<>();
			for (FafunFafaDetailLogDto fafunFafaDetailLogDto : detailLogDtoList) {
				Integer userId = fafunFafaDetailLogDto.getUserId();
				userIds.add(userId);
			}
			Map<String, Map<String, String>> logDtoMap = new HashMap<>();
			if (userIds.size() > 0) {
				List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIds);
				Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
				for (FafunFafaDetailLogDto fafaDetailLogDto : detailLogDtoList) {
					ErpFunUsers erpFunUsers = userMap.get(fafaDetailLogDto.getUserId());
					if (erpFunUsers != null) {
						fafaDetailLogDto.setUserName(erpFunUsers.getUserName());
						Map<String, String> dtoMapGet = logDtoMap.get(erpFunUsers.getUserName());
						if (dtoMapGet == null) {
							dtoMapGet = new HashMap<>();
							dtoMapGet.put("userName", fafaDetailLogDto.getUserName());
							dtoMapGet.put("count", String.valueOf(fafaDetailLogDto.getExceptionCount()));
							logDtoMap.put(erpFunUsers.getUserName(), dtoMapGet);
						}
					}
				}
			}
			LinkedList<Map<String, String>> returnList = new LinkedList<>(logDtoMap.values());
			SortUtil.collectionsSort(returnList, new String[]{"count"}, false);
			ErpResponseJson json = new ErpResponseJson();
			if (returnList.size() > 5) {
				List<Object> resultList = new ArrayList<>();
				for (int i = 0; i < 5; i++) {
					resultList.add(returnList.get(i));
				}
				json.setData(resultList);
			}else {
				json.setData(returnList);
			}
			json.setTotal(Long.valueOf(detailLogDtoList.size()));
			return json;
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 发布异常分析统计 人员/站点
	 * @author 何传强
	 * @since 2017年7月13日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getPushExpectionCount")
	public ResponseJson getPushExpectionCount(@RequestBody BaseMapParam param){
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String countType = param.getString("countType");
		String showType = param.getString("showType");
		String sort = param.getString("sort");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		if ("SITE".equals(countType)) {//站点
			List<FafunFafaDetailLogDto> detailLogDtoSiteList = fafunFafaDetailLogMapper.getFafaExceptionCountSite(param.getMap());
			Set<Integer> siteIds = new HashSet<>();
			for (FafunFafaDetailLogDto fafunFafaDetailLogDto : detailLogDtoSiteList) {
				Integer siteId = fafunFafaDetailLogDto.getSiteId();
				siteIds.add(siteId);
			}
			if (siteIds.size() > 0) {
				List<AdminWebSite> siteList = adminWebSiteMapper.getSiteMapByCityId(getOperator().getCityId());
				Map<Integer, AdminWebSite> siteMap = siteList.stream().collect(Collectors.toMap(AdminWebSite::getSiteId, site -> site));
				Map<Integer, FafunFafaDetailLogDto> dtoMap = new HashMap<>();
				Map<Integer, Map<String, Object>> resultMap = new HashMap<>();
				for (FafunFafaDetailLogDto fafaDetailLogDto : detailLogDtoSiteList) {
					FafunFafaDetailLogDto fafunFafaDetailLogDto = dtoMap.get(fafaDetailLogDto.getSiteId());
					if (fafunFafaDetailLogDto == null) {
						fafunFafaDetailLogDto = fafaDetailLogDto;
						dtoMap.put(fafaDetailLogDto.getSiteId(), fafunFafaDetailLogDto);
						continue;
					}
					AdminWebSite webSite = siteMap.get(fafunFafaDetailLogDto.getSiteId());
					if (webSite != null) {
						fafunFafaDetailLogDto.setSiteName(webSite.getSiteName());
					}
					Integer statusIdInt = fafaDetailLogDto.getStatusId();
					String statusId = String.valueOf(statusIdInt);
					/* WARN:异常码判断不完整 */
					if (isInSet(statusId, SUCCESS_STATUS)) {// 操作成功的忽略统计
						continue;
					}
					Integer exceptionCount = fafaDetailLogDto.getExceptionCount();
					if (exceptionCount <= 0) {
						continue;
					}
					FaFaErrorInfo errorInfo = getFafaErrorType(statusId);
					Map<String, Object> map = resultMap.get(fafaDetailLogDto.getSiteId());
					if(map == null) {
						map = new HashMap<>();
						map.put(errorInfo.getNameEn(), exceptionCount);
						resultMap.put(fafaDetailLogDto.getSiteId(), map);
					} else {
						Integer val = (Integer) map.get(errorInfo.getNameEn());
						if(val == null) {val = 0;}
						exceptionCount += val;
						map.put(errorInfo.getNameEn(), exceptionCount);
					}
					Integer sum = 0;
					for (Entry<String, Object> entry : map.entrySet()) {
						if(!"sum".equals(entry.getKey()) && !"siteName".equals(entry.getKey())) {
							sum += (Integer)entry.getValue();
						}
					}
					map.put("sum", sum);
					map.put("siteName", webSite.getSiteName());
				}
				LinkedList<Map<String, Object>> returnList = new LinkedList<>(resultMap.values());
				SortUtil.collectionsSort(returnList, new String[]{"sum"}, false);
				ErpResponseJson json = new ErpResponseJson();
				json.setData(returnList);
				json.setExtra(countType + "," + showType + "," + sort);
				json.setTotal(Long.valueOf(detailLogDtoSiteList.size()));
				return json;
			}
		}else if ("USER".equals(countType)) {//员工
			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByCompId(getOperator().getCityId(), param.getMap());
//			Set<Integer> userIds = userList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
//			param.setObject("userIds", userIds);
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<FafunFafaDetailLogDto> detailLogDtoUserList = fafunFafaDetailLogMapper.getFafaExceptionCountUSER(param.getMap());
			PageInfo<FafunFafaDetailLogDto> pageInfo = new PageInfo<>(detailLogDtoUserList);
			Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
			Map<Integer, Map<String, Object>> resultMap = new HashMap<>();
			for (FafunFafaDetailLogDto fafaDetailLogDto : detailLogDtoUserList) {
				Integer statusIdInt = fafaDetailLogDto.getStatusId();
				String statusId = String.valueOf(statusIdInt);
				/* WARN:异常码判断不完整 */
				if (isInSet(statusId, SUCCESS_STATUS)) {// 操作成功的忽略统计
					continue;
				}
				Integer exceptionCount = fafaDetailLogDto.getExceptionCount();
				if (exceptionCount <= 0) {
					continue;
				}
				FaFaErrorInfo errorInfo = getFafaErrorType(statusId);
				Map<String, Object> map = resultMap.get(fafaDetailLogDto.getUserId());
				if(map == null) {
					map = new HashMap<>();
					map.put(errorInfo.getNameEn(), exceptionCount);
					resultMap.put(fafaDetailLogDto.getUserId(), map);
				} else {
					Integer val = (Integer) map.get(errorInfo.getNameEn());
					if(val == null) {val = 0;}
					exceptionCount += val;
					map.put(errorInfo.getNameEn(), exceptionCount);
				}
				ErpFunUsers erpFunUsers = userMap.get(fafaDetailLogDto.getUserId());
				Integer sumErr = 0;
				for (Entry<String, Object> entry : map.entrySet()) {
					if(entry.getKey().endsWith("Err")) {
						sumErr += (Integer)entry.getValue();
					}
				}
				map.put("sum", sumErr);
				if (erpFunUsers != null) {
					map.put("userName", erpFunUsers.getUserName());
					map.put("areaId", erpFunUsers.getAreaId());
					map.put("regId", erpFunUsers.getRegId());
					map.put("deptId", erpFunUsers.getDeptId());
					map.put("grId", erpFunUsers.getGrId());
					map.put("userId", erpFunUsers.getUserId());
//					userMap.remove(fafaDetailLogDto.getUserId());
				}
			}
			/*for (ErpFunUsers erpFunUsers : userMap.values()) {
				Map<String, Object> map = new HashMap<>();
				map.put("userName", erpFunUsers.getUserName());
				map.put("areaId", erpFunUsers.getAreaId());
				map.put("regId", erpFunUsers.getRegId());
				map.put("deptId", erpFunUsers.getDeptId());
				map.put("grId", erpFunUsers.getGrId());
				map.put("userId", erpFunUsers.getUserId());
				resultMap.put(erpFunUsers.getUserId(), map);
			}*/
			List<Map<String, Object>> resultList = new LinkedList<>(resultMap.values());
			SortUtil.collectionsSort(resultList, new String[]{"sum"}, false);
			ErpResponseJson json = new ErpResponseJson(pageInfo);
			json.setData(resultList);
			json.setTotal((long) resultList.size());
			json.setExtra(countType + "," + showType + "," + sort);
			return json;
 		}
		return ErpResponseJson.ok();
	}
	
	
	/**
	 * 综合统计
	 * @author 何传强
	 * @since 2017年7月14日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getFafaComprehensiveStatistic")
	public ResponseJson getFafaComprehensiveStatistic(@RequestBody BaseMapParam param){
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String dimension = param.getString("dimension");//组织维度
		String showType = param.getString("showType");
		String sort = param.getString("sort");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		StringBuilder sqlColumn = new StringBuilder();
		if ("AREA".equals(dimension)) {
			sqlColumn.append("AREA_ID");
			param.setString("sqlColumn", sqlColumn.toString());
			List<FafaSiteClickRankDto> dataAreaList = fafunFafaDetailLogMapper.getFafaComprehensiveStatistic(param.getMap());
			if (dataAreaList.size() > 0) {
				Map<Integer, Map<String, Object>> resultMap = new HashMap<>();
				for (FafaSiteClickRankDto fafaSiteClickRankDto : dataAreaList) {
					Map<String, Object> tempMap = resultMap.get(fafaSiteClickRankDto.getAreaId());
					if (tempMap == null) {
						tempMap = new HashMap<>();
						tempMap.put("areaId", fafaSiteClickRankDto.getAreaId());
						resultMap.put(fafaSiteClickRankDto.getAreaId(), tempMap);
					}
					tempMap.put("delCount", StringUtil.parseInteger(tempMap.get("delCount")+"", 0) + fafaSiteClickRankDto.getDelCount());
					tempMap.put("pubCount", StringUtil.parseInteger(tempMap.get("pubCount")+"", 0) + fafaSiteClickRankDto.getPubCount());
					tempMap.put("refCount", StringUtil.parseInteger(tempMap.get("refCount")+"", 0) + fafaSiteClickRankDto.getRefCount());
					tempMap.put("siteCount",StringUtil.parseInteger(tempMap.get("siteCount")+"", 0) + fafaSiteClickRankDto.getSiteCount());
					tempMap.put("sumCount", StringUtil.parseInteger(tempMap.get("sumCount")+"", 0) + fafaSiteClickRankDto.getSumCount());
					tempMap.put("activeLvl", StringUtil.parseInteger(tempMap.get("sumCount")+"") > 500 ? "A" : "B");
				}
				// 将结果集转换为map进行排序
				LinkedList<Map<String, Object>> returnList = new LinkedList<>(resultMap.values());
				ErpResponseJson json = new ErpResponseJson();
				// 若图表展示,展示前6条
				if ("CHART".equals(showType)) {
					if (returnList.size() > 6) {
						List<Object> resultList = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							resultList.add(returnList.get(i));
						}
						SortUtil.collectionsSort(resultList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(resultList);
					}else {
						SortUtil.collectionsSort(returnList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(returnList);
					}
					return json; 
				}else {
					SortUtil.collectionsSort(returnList, new String[]{"areaId"}, true);
					json.setData(returnList);
					json.setTotal(Long.valueOf(returnList.size()));
					json.setExtra(dimension + "," + showType + "," + sort);
					return json;
				}
			}
			return ErpResponseJson.ok();
		}else if ("REG".equals(dimension)) {
			sqlColumn.append("AREA_ID,REG_ID");
			param.setString("sqlColumn", sqlColumn.toString());
			List<FafaSiteClickRankDto> dataRegList = fafunFafaDetailLogMapper.getFafaComprehensiveStatistic(param.getMap());
			if (dataRegList.size() > 0) {
				Map<Integer, Map<String, Object>> resultMap = new HashMap<>();
				for (FafaSiteClickRankDto fafaSiteClickRankDto : dataRegList) {
					Map<String, Object> tempMap = resultMap.get(fafaSiteClickRankDto.getRegId());
					if (tempMap == null) {
						tempMap = new HashMap<>();
						tempMap.put("areaId", fafaSiteClickRankDto.getAreaId());
						tempMap.put("regId", fafaSiteClickRankDto.getRegId());
						resultMap.put(fafaSiteClickRankDto.getRegId(), tempMap);
					}
					tempMap.put("delCount", StringUtil.parseInteger(tempMap.get("delCount")+"", 0) + fafaSiteClickRankDto.getDelCount());
					tempMap.put("pubCount", StringUtil.parseInteger(tempMap.get("pubCount")+"", 0) + fafaSiteClickRankDto.getPubCount());
					tempMap.put("refCount", StringUtil.parseInteger(tempMap.get("refCount")+"", 0) + fafaSiteClickRankDto.getRefCount());
					tempMap.put("siteCount",StringUtil.parseInteger(tempMap.get("siteCount")+"", 0) + fafaSiteClickRankDto.getSiteCount());
					tempMap.put("sumCount", StringUtil.parseInteger(tempMap.get("sumCount")+"", 0) + fafaSiteClickRankDto.getSumCount());
					tempMap.put("activeLvl", StringUtil.parseInteger(tempMap.get("sumCount")+"") > 500 ? "A" : "B");				}
				// 将结果集转换为map进行排序
				LinkedList<Map<String, Object>> returnList = new LinkedList<>(resultMap.values());
				ErpResponseJson json = new ErpResponseJson();
				// 若图表展示,展示前6条
				if ("CHART".equals(showType)) {
					if (returnList.size() > 6) {
						List<Object> resultList = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							resultList.add(returnList.get(i));
						}
						SortUtil.collectionsSort(resultList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(resultList);
					}else {
						SortUtil.collectionsSort(returnList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(returnList);
					}
					return json; 
				}else {
					SortUtil.collectionsSort(returnList, new String[]{"areaId","regId"}, true);
					json.setData(returnList);
					json.setTotal(Long.valueOf(returnList.size()));
					json.setExtra(dimension + "," + showType + "," + sort);
					return json;
				}
			}
			return ErpResponseJson.ok();
		}else if ("DEPT".equals(dimension)) {
			sqlColumn.append("AREA_ID,REG_ID,DEPT_ID");
			param.setString("sqlColumn", sqlColumn.toString());
			List<FafaSiteClickRankDto> dataDeptList = fafunFafaDetailLogMapper.getFafaComprehensiveStatistic(param.getMap());
			if (dataDeptList.size() > 0) {
				Map<Integer, Map<String, Object>> resultMap = new HashMap<>();
				for (FafaSiteClickRankDto fafaSiteClickRankDto : dataDeptList) {
					Map<String, Object> tempMap = resultMap.get(fafaSiteClickRankDto.getDeptId());
					if (tempMap == null) {
						tempMap = new HashMap<>();
						tempMap.put("areaId", fafaSiteClickRankDto.getAreaId());
						tempMap.put("regId", fafaSiteClickRankDto.getRegId());
						tempMap.put("deptId", fafaSiteClickRankDto.getDeptId());
						resultMap.put(fafaSiteClickRankDto.getDeptId(), tempMap);
					}
					tempMap.put("delCount", StringUtil.parseInteger(tempMap.get("delCount")+"", 0) + fafaSiteClickRankDto.getDelCount());
					tempMap.put("pubCount", StringUtil.parseInteger(tempMap.get("pubCount")+"", 0) + fafaSiteClickRankDto.getPubCount());
					tempMap.put("refCount", StringUtil.parseInteger(tempMap.get("refCount")+"", 0) + fafaSiteClickRankDto.getRefCount());
					tempMap.put("siteCount",StringUtil.parseInteger(tempMap.get("siteCount")+"", 0) + fafaSiteClickRankDto.getSiteCount());
					tempMap.put("sumCount", StringUtil.parseInteger(tempMap.get("sumCount")+"", 0) + fafaSiteClickRankDto.getSumCount());
					tempMap.put("activeLvl", StringUtil.parseInteger(tempMap.get("sumCount")+"") > 500 ? "A" : "B");				}
				// 将结果集转换为map进行排序
				LinkedList<Map<String, Object>> returnList = new LinkedList<>(resultMap.values());
				ErpResponseJson json = new ErpResponseJson();
				// 若图表展示,展示前6条
				if ("CHART".equals(showType)) {
					if (returnList.size() > 6) {
						List<Object> resultList = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							resultList.add(returnList.get(i));
						}
						SortUtil.collectionsSort(resultList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(resultList);
					}else {
						SortUtil.collectionsSort(returnList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(returnList);
					}
					return json; 
				}else {
					SortUtil.collectionsSort(returnList, new String[]{"areaId","regId","deptId"}, true);
					json.setData(returnList);
					json.setTotal(Long.valueOf(returnList.size()));
					json.setExtra(dimension + "," + showType + "," + sort);
					return json;
				}
			}
			return ErpResponseJson.ok();
		}else if ("GROUP".equals(dimension)) {
			param.setString("dimension", "GR");
			sqlColumn.append("AREA_ID,REG_ID,DEPT_ID,GR_ID");
			param.setString("sqlColumn", sqlColumn.toString());
			List<FafaSiteClickRankDto> dataGrList = fafunFafaDetailLogMapper.getFafaComprehensiveStatistic(param.getMap());
			if (dataGrList.size() > 0) {
				Map<Integer, Map<String, Object>> resultMap = new HashMap<>();
				for (FafaSiteClickRankDto fafaSiteClickRankDto : dataGrList) {
					Map<String, Object> tempMap = resultMap.get(fafaSiteClickRankDto.getGrId());
					if (tempMap == null) {
						tempMap = new HashMap<>();
						tempMap.put("areaId", fafaSiteClickRankDto.getAreaId());
						tempMap.put("regId", fafaSiteClickRankDto.getRegId());
						tempMap.put("deptId", fafaSiteClickRankDto.getDeptId());
						tempMap.put("grId", fafaSiteClickRankDto.getGrId());
						resultMap.put(fafaSiteClickRankDto.getGrId(), tempMap);
					}
					tempMap.put("delCount", StringUtil.parseInteger(tempMap.get("delCount")+"", 0) + fafaSiteClickRankDto.getDelCount());
					tempMap.put("pubCount", StringUtil.parseInteger(tempMap.get("pubCount")+"", 0) + fafaSiteClickRankDto.getPubCount());
					tempMap.put("refCount", StringUtil.parseInteger(tempMap.get("refCount")+"", 0) + fafaSiteClickRankDto.getRefCount());
					tempMap.put("siteCount",StringUtil.parseInteger(tempMap.get("siteCount")+"", 0) + fafaSiteClickRankDto.getSiteCount());
					tempMap.put("sumCount", StringUtil.parseInteger(tempMap.get("sumCount")+"", 0) + fafaSiteClickRankDto.getSumCount());
					tempMap.put("activeLvl", StringUtil.parseInteger(tempMap.get("sumCount")+"") > 500 ? "A" : "B");				}
				// 将结果集转换为map进行排序
				ErpResponseJson json = new ErpResponseJson();
				LinkedList<Map<String, Object>> returnList = new LinkedList<>(resultMap.values());
				// 若图表展示,展示前6条
				if ("CHART".equals(showType)) {
					if (returnList.size() > 6) {
						List<Object> resultList = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							resultList.add(returnList.get(i));
						}
						SortUtil.collectionsSort(resultList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(resultList);
					}else {
						SortUtil.collectionsSort(returnList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(returnList);
					}
					return json; 
				}else {
					SortUtil.collectionsSort(returnList, new String[]{"areaId","regId","deptId","grId"}, true);
					json.setData(returnList);
					json.setTotal(Long.valueOf(returnList.size()));
					json.setExtra(dimension + "," + showType + "," + sort);
					return json;
				}
			}
			return ErpResponseJson.ok();
		}else {
			sqlColumn.append("AREA_ID,REG_ID,DEPT_ID,GR_ID,USER_ID");
			param.setString("sqlColumn", sqlColumn.toString());
			List<FafaSiteClickRankDto> dataUserList = fafunFafaDetailLogMapper.getFafaComprehensiveStatistic(param.getMap());
			if (dataUserList.size() > 0) {
				Set<Integer> userIds = new HashSet<>();
				for (FafaSiteClickRankDto siteClickRankDto : dataUserList) {
					Integer userId = siteClickRankDto.getUserId();
					userIds.add(userId);
				}
				if (userIds.size() > 0) {
					List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIds);
					Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
					for (FafaSiteClickRankDto siteClickRankDto : dataUserList) {
						ErpFunUsers erpFunUsers = userMap.get(siteClickRankDto.getUserId());
						if (erpFunUsers != null) {
							siteClickRankDto.setUserName(erpFunUsers.getUserName());
						}else {
							siteClickRankDto.setUserName("");
						}
						siteClickRankDto.setActiveLvl(siteClickRankDto.getSumCount() > 500 ? "A" : "B");
					}
				}
				ErpResponseJson json = new ErpResponseJson();
				// 若图表展示,展示前6条
				if ("CHART".equals(showType)) {
					if (dataUserList.size() > 6) {
						List<Object> resultList = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							resultList.add(dataUserList.get(i));
						}
						SortUtil.collectionsSort(resultList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(resultList);
					}else {
						SortUtil.collectionsSort(dataUserList, new String[]{"sumCount"}, false);
						json.setExtra(dimension + "," + showType + "," + sort);
						json.setData(dataUserList);
					}
					return json; 
				}else {
					SortUtil.collectionsSort(dataUserList, new String[]{"areaId","regId","deptId","grId","userId"}, true);
					json.setData(dataUserList);
					json.setTotal(Long.valueOf(dataUserList.size()));
					json.setExtra(dimension + "," + showType + "," + sort);
					return json;
				}
			}
			return ErpResponseJson.ok();
		} 
	}
	
	/**
	 * 房源发布总量和人员统计
	 * @author 何传强
	 * @since 2017年7月14日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHousePushCountAndUsersCount")
	public ResponseJson getHousePushCountAndUsersCount(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		String startTime = param.getString("startTime");
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime+" 00:00:00");
		}
		String endTime = param.getString("endTime");
		if (StringUtil.isNotBlank(endTime)) {
			param.setString("endTime", endTime+" 23:59:59");
		}
		// 房源发布总量统计
		Integer housePushCount = fafunFafaDetailLogMapper.getHousePushCountData(param.getMap());
		// 人员统计
		if ("GR".equals(serchRange)) {
			param.setString("serchRange", "GROUP");
		}
		Integer userCount = erpFunUsersMapper.getUserCount(getOperator().getCityId(), param.getMap(), startTime, endTime);
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("housePushCount", housePushCount);
		resultMap.put("userCount", userCount);
		return ErpResponseJson.ok(resultMap);
	}
	/**
	 * 首页点击量排名统计
	 * @author 何传强
	 * @since 2017年7月17日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClickedRankCount")
	public ResponseJson getClickedRankCount(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		String dimension = param.getString("dimension");
		if ("GROUP".equals(dimension)) {
			param.setString("dimension", "GR");
		}
		String startTime = param.getString("startTime");
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime+" 00:00:00");
			String endTime = param.getString("endTime");
			if (StringUtil.isNotBlank(endTime)) {
				param.setString("endTime", endTime+" 23:59:59");
			}
		}else{
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		}
		List<FafunTHouseTrendsDto> rankCountList = fafunTHouseTrendsMapper.getClickRankCount(param.getMap());
		if (rankCountList.size() > 0) {
			Set<Integer> userIds = new HashSet<>();
			for (FafunTHouseTrendsDto fafunTHouseTrendsDto : rankCountList) {
				Integer userId = fafunTHouseTrendsDto.getUserId();
				userIds.add(userId);
			}
			if (userIds.size() > 0) {
				List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(),userIds);
				Map<Integer, FafunTHouseTrendsDto> fafunTHouseTrendsMap = rankCountList.stream().collect(Collectors.toMap(FafunTHouseTrendsDto::getUserId, user -> user));
				for (ErpFunUsers userPo : userList) {
					FafunTHouseTrendsDto fafunDto = fafunTHouseTrendsMap.get(userPo.getUserId());
					if (fafunDto != null) {
						fafunDto.setUserName(userPo.getUserName());
					}
				}
			}
			ErpResponseJson json = new ErpResponseJson();
			json.setData(rankCountList);
			json.setTotal(Long.valueOf(rankCountList.size()));
			return json;
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 操作成功 状态码
	 * 101000: 发布成功
	 * 102000: 下架成功
	 * 104000: 刷新成功
	 */
	static final String[] SUCCESS_STATUS = new String[]{
		"101000","102000","104000"
	};
	/**
	 * 信息完整性异常 状态码
	 * 106004: 数据错误
	 * 101001: 标题字数不足
	 * 101002: 标题字数过长
	 * 101003: 非法标题
	 * 101004: 数据错误
	 * 101005: 标题含有数字
	 * 101006: 标题含有电话
	 * 101007: 房源描述超长
	 * 101008: 房源描述字数不足
	 * 101009: 房源描述含有数字
	 * 101010: 房源描述含有电话
	 * 101011: 非法房源描述
	 * 101012: 户型错误(室)
	 * 101013: 户型错误(室)
	 * 101014: 户型错误(厅)
	 * 101015: 户型错误(厅)
	 * 101016: 户型错误(卫)
	 * 101017: 户型错误(卫)
	 * 101018: 重复房源(标题重复)
	 * 101019: 重复房源(其他信息重复)
	 * 106010: 验证码错误
	 */
	static final String[] MSG_INCOMPLETE_EXCEPTION_STATUS = new String[]{
		"106004","101001","101002","101003:","101004","101005","101006","101007","101008","101009","101010",
		"101011","101012","101013","101014","101015","101016","101017","101018","101019","106010","101020",
	};
	/**
	 * 楼盘信息异常 状态码
	 */
	static final String[] BUILD_EXCEPTION_STATUS = new String[]{
	};
	/**
	 * 帐号密码异常 状态码
	 * 106001: 帐号密码错误
	 * 106002: 密码错误
	 * 106003: 帐号错误
	 * 106005: 帐号过期
	 * 106006: 帐号被封
	 * 106007: 非中介帐号
	 * 106008: 房东帐号
	 * 106009: 未开通帐号
	 * 101023: 帐号不支持发布出售数据
	 * 101024: 帐号不支持发布出租数据
	 * 101025: 帐号不支持发布商铺数据
	 * 101026: 帐号不支持发布写字楼数据
	 */
	static final String[] SHOP_INFO_EXCEPTION_STATUS = new String[]{
		"106001","106002","106003","106005","106006","106007","106008","106009","101023","101024","101025","101026"
	};
	/**
	 * 网络异常 状态码
	 */
	static final String[] NETWORK_EXCEPTION_STATUS = new String[]{
			"101999","1010430","1040171"
	};
	/**
	 * 发布超过上限 状态码
	 * 101021: 发布超过上限
	 * 101022: 当日发布超过上限
	 */
	static final String[] PUB_MAX_EXCEPTION_STATUS = new String[]{
	};
	/**
	 * 站点维护 状态码
	 */
	static final String[] SITE_FIX_EXCEPTION_STATUS = new String[]{
	};
	
	
	public static class FaFaErrorInfo{
		private String nameCn;
		private String nameEn;
		public FaFaErrorInfo(String nameCn, String nameEn) {
			this.nameCn = nameCn;
			this.nameEn = nameEn;
		}
		public String getNameCn() {
			return nameCn;
		}
		public void setNameCn(String nameCn) {
			this.nameCn = nameCn;
		}
		public String getNameEn() {
			return nameEn;
		}
		public void setNameEn(String nameEn) {
			this.nameEn = nameEn;
		}
	}
	/**
	 * 站点维护 状态码对应的中文说明
	 */
	static final Map<String, FaFaErrorInfo> SITE_ERROR_STATUS_CN;
	static{
		SITE_ERROR_STATUS_CN = new HashMap<>();
		SITE_ERROR_STATUS_CN.put("0", new FaFaErrorInfo("其他", "otherErr"));
		FaFaErrorInfo errorInfo = new FaFaErrorInfo("服务器错误", "serverErr");
		for (int i = 100; i < 103; i++) {
			SITE_ERROR_STATUS_CN.put(String.valueOf(i), errorInfo);
		}
		errorInfo = new FaFaErrorInfo("账号错误", "accountErr");
		for (int i = 222; i < 227; i++) {
			SITE_ERROR_STATUS_CN.put(String.valueOf(i), errorInfo);
		}
		SITE_ERROR_STATUS_CN.put("023", new FaFaErrorInfo("网络错误", "netErr"));//"network error");
		SITE_ERROR_STATUS_CN.put("024", new FaFaErrorInfo("处理错误", "parseErr"));//"parse response error");
		SITE_ERROR_STATUS_CN.put("025", new FaFaErrorInfo("获取验证码错误", "yzmErr"));//"get yzm error");
		SITE_ERROR_STATUS_CN.put("027", new FaFaErrorInfo("解析错误", "analysisErr"));//"analysis error");
		SITE_ERROR_STATUS_CN.put("028", new FaFaErrorInfo("发布失败", "pubErr"));//"publishing house's data error");
		SITE_ERROR_STATUS_CN.put("029", new FaFaErrorInfo("获取区域错误", "getRegErr"));//"geting region or section error");
		SITE_ERROR_STATUS_CN.put("030", new FaFaErrorInfo("删除失败", "deleteErr"));//"deleting data error");
		SITE_ERROR_STATUS_CN.put("031", new FaFaErrorInfo("匹配错误", "matchingErr"));//"matching building's infomation error");
		SITE_ERROR_STATUS_CN.put("032", new FaFaErrorInfo("房源已存在", "houseExistedErr"));//"house has existed",
		SITE_ERROR_STATUS_CN.put("033", new FaFaErrorInfo("刷新失败", "refreshErr"));//"refreshing error",
		SITE_ERROR_STATUS_CN.put("034", new FaFaErrorInfo("刷新次数上限", "refreshLimitErr"));//"number of refreshing has upper limit",
		SITE_ERROR_STATUS_CN.put("035", new FaFaErrorInfo("房源不存在", "houseNotExistErr"));//"该房源已从网站下架或删除",
		SITE_ERROR_STATUS_CN.put("036", new FaFaErrorInfo("同步状态失败", "statusErr"));//"sync status of acc is error",
	}
	
	/**
	 * 获取错误状态码对应的中文错误
	 * @author 张宏利
	 * @since 2017年7月28日
	 * @param statusId 状态ID
	 * @return
	 */
	public static FaFaErrorInfo getFafaErrorType(String statusId) {
		if(StringUtils.isBlank(statusId) || statusId.length() != 7) {
			return SITE_ERROR_STATUS_CN.get("0");
		}
		String status = statusId.substring(3, 6);
		FaFaErrorInfo errorInfo = SITE_ERROR_STATUS_CN.get(status);
		if(errorInfo == null) {
			return SITE_ERROR_STATUS_CN.get("0");
		}
		return errorInfo;
	}
	
	boolean isInSet(String param,String[] set){
		for(int i=0;i<set.length;i++){
			if(set[i].equals(param)){
				return true;
			}
		}
		return false;
	}
	
	private LinkedHashMap<String, String> getClickCountByHouseHeads() {
		LinkedHashMap<String, String> resultMap = new LinkedHashMap<String, String>();
		resultMap.put("SQE_NO", "排名");
		resultMap.put("PRIMARY_NAME", "房源信息");
		return resultMap;
	}

	/**
	 * 组装出租房源信息标题
	 * @author 熊刚
	 * @since 2017年7月27日
	 * @param funSalePO
	 * @return
	 */
	private String buildLeaseTitle(ErpFunLease funLeasePO) {
		Byte usage = funLeasePO.getLeaseUseage();
		String title = "[租]";
		title += "[" + String.valueOf(transHouseUseage(usage)) + "] ";
		title += funLeasePO.getBuildName() + " ";
		if(funLeasePO.getLeaseRoom() != null) {
			title += funLeasePO.getLeaseRoom() + "室";
		}
		if(funLeasePO.getLeaseHall() != null) {
			title += funLeasePO.getLeaseHall() + "厅 ";
		}
		title += funLeasePO.getLeaseArea() + "平 ";
		title += funLeasePO.getLeaseTotalPrice() + transPriceUnit(funLeasePO.getLeaseUnit()) + " ";
		return title;
	}
	
	/**
	 * 组装出售房源信息标题
	 * @author 熊刚
	 * @since 2017年7月27日
	 * @param funSalePO
	 * @return
	 */
	private String buildSaleTitle(ErpFunSale funSalePO) {
		Byte usage = funSalePO.getSaleUseage();
		String title = "[售]";
		title += "[" + transHouseUseage(usage) + "] ";
		title += funSalePO.getBuildName() + " ";
		if(funSalePO.getSaleRoom() != null) {
			title += funSalePO.getSaleRoom() + "室";
		}
		if(funSalePO.getSaleHall() != null) {
			title += funSalePO.getSaleHall() + "厅 ";
		}
		title += funSalePO.getSaleArea() + "平 ";
		title += funSalePO.getSaleTotalPrice() + "万元 ";
		return title;
	}

	private String transHouseUseage(Object usage) {
		if (Constants_DIC.DIC_HOUSE_USEAGE_HOUSING.equals(usage)) {
			return "住宅";
		} else if (Constants_DIC.DIC_HOUSE_USEAGE_VILLA.equals(usage)) {
			return "别墅";
		} else if (Constants_DIC.DIC_HOUSE_USEAGE_TRADE.equals(usage)) {
			return "商铺";
		} else if (Constants_DIC.DIC_HOUSE_USEAGE_OFFICE.equals(usage)) {
			return "写字";
		} else if (Constants_DIC.DIC_HOUSE_USEAGE_MANUFACT.equals(usage)) {
			return "厂房";
		} else if (Constants_DIC.DIC_HOUSE_USEAGE_STORE.equals(usage)) {
			return "仓库";
		} else if (Constants_DIC.DIC_HOUSE_USEAGE_GARAGE.equals(usage)) {
			return "车库";
		}
		return "住宅";
	}

	/** 翻译价格单位 */
	private String transPriceUnit(String unit) {
		if (Constants_DIC.DIC_PRICE_UNIT_PERDAY.equals(unit)) {
			return "元/天";
		} else if (Constants_DIC.DIC_PRICE_UNIT_PERCENTIARE.equals(unit)) {
			return "元/平米*月";
		} else if (Constants_DIC.DIC_PRICE_UNIT_PERDAYCENT.equals(unit)) {
			return "元/平米*天";
		} else {
			return "元/月";
		}
	}
}
