package com.myfun.erpWeb.statisticalAnalysis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.HouseCustAddCountDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.reportdb.dao.ReportFunBuyCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunCustDemandSplitMapper;
import com.myfun.repository.reportdb.dao.ReportFunLeaseMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunRentCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunSaleMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunStatisticDetail1Mapper;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.reportdb.dao.ReportHouseorcustFlowAnalysistotalMapper;
import com.myfun.service.business.admindb.AdminFunCityService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.SortUtil;
import com.myfun.utils.StringUtil;

/**
 * 统计分析-数据分析控制器
 * @author 张宏利
 * @since 2017年7月14日
 */
@Controller
@RequestMapping("/statisticalAnalysis/dataAnalysis")
public class DataAnalysisController extends BaseController{

	@Autowired
	private ReportFunStatisticDetail1Mapper reportFunStatisticDetail1Mapper;
	@Autowired
	private ReportFunSaleMinMapper reportFunSaleMinMapper;
	@Autowired
	private ReportFunLeaseMinMapper reportFunLeaseMinMapper;
	@Autowired
	private ReportFunBuyCustomerMinMapper reportFunBuyCustomerMinMapper;
	@Autowired
	private ReportFunRentCustomerMinMapper reportFunRentCustomerMinMapper;
	@Autowired
	private AdminFunCityService adminFunCityService;
	@Autowired
	private ReportFunCustDemandSplitMapper reportFunCustDemandSplitMapper;
	@Autowired
	private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunUsersService erpFunUsersService;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ReportHouseorcustFlowAnalysistotalMapper reportHouseorcustFlowAnalysistotalMapper;
	@Autowired
	private ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;

	/**
	 * 房客源存量分析--房客源基本情况
	 * @author 臧铁
	 * @since 2017年7月28日
	 * @param param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustBasicStatus")
	public ResponseJson getHouseCustBasicStatus(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		param.setInteger("compId", getOperator().getCompId());
		changeSerchRange(param);
		makeStoreDataAnalysisParam(param);
		Map<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> resultList = new LinkedList<>();
		if("101".equals(caseType)) {// 买卖，查询出售和求购
			resultMap = reportFunSaleMinMapper.getHouseCustBasicStatus(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			resultMap = reportFunLeaseMinMapper.getHouseCustBasicStatus(cityId, param.getMap());
		}
		if (resultMap != null) {
			resultList.add(resultMap);
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 房客源存量分析--按用途-住宅商铺写字供需对比
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * useage		1=住宅  2=商铺 3=写字
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataAnalysisByUseage")
	public ResponseJson getStoreDataAnalysisByUseage(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		param.setInteger("compId", getOperator().getCompId());
		changeSerchRange(param);
		List<Map<String, Object>> custData = null;
		if("101".equals(caseType)) {// 买卖，查询出售和求购
			custData = reportFunBuyCustomerMinMapper.getStoreDataAnalysisByUseage(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			custData = reportFunRentCustomerMinMapper.getStoreDataAnalysisByUseage(cityId, param.getMap());
		}
		// 先把客源的查出来，不为空再查询前四的维度的房源数据
		if(custData != null && !custData.isEmpty()) {
			Set<Object> idSet = new HashSet<>();
			for (Map<String, Object> map : custData) {
				idSet.add(String.valueOf(map.get("byName")));
				if(idSet.size() >= 4) {break;}
			}
			param.setObject("idSet", idSet);
			List<Map<String, Object>> houseData = null;
			if("101".equals(caseType)) {// 买卖，查询出售和求购
				houseData = reportFunSaleMinMapper.getStoreDataAnalysisByUseage(cityId, param.getMap());
			} else {// 租赁，查询出租和求租
				houseData = reportFunLeaseMinMapper.getStoreDataAnalysisByUseage(cityId, param.getMap());
			}
			// 数据合并到一起
			Map<String, Map<String, Object>> collectMap = custData.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("byName")), val -> val));
			if (houseData != null && !houseData.isEmpty()) {
				for (Map<String, Object> map : houseData) {
					Map<String, Object> mapTemp = collectMap.get(String.valueOf(map.get("byName")));
					if (mapTemp != null) {
						map.put("house", mapTemp.get("counts"));
					}
				}
			}
			// 处理字段名和减少字段
			List<Map<String, Object>> linkedList = new LinkedList<>(collectMap.values());
			for (Map<String, Object> map : linkedList) {
				map.put("cust", map.get("counts"));
				map.put("counts", null);
			}
			return ErpResponseJson.ok(linkedList);
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 房客源存量分析--按户型-房价、面积、行政区分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * queryDim		统计维度，AREA=面积 PRICE=价格 REG=行政区
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataAnalysisByRoom")
	public ResponseJson getStoreDataAnalysisByRoom(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		makeStoreDataAnalysisParam(param);
		List<Map<String, Object>> houseCustData = null;
		if("101".equals(caseType)) {// 买卖，查询出售和求购
			houseCustData = reportFunSaleMinMapper.getStoreDataAnalysisByRoom(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			houseCustData = reportFunLeaseMinMapper.getStoreDataAnalysisByRoom(cityId, param.getMap());
		}
		Map<Object, Map<String, Object>> resultMapLast = new LinkedHashMap<>();
		if (houseCustData != null) {
			resultMapLast = makeStoreDataAnalysisResult(houseCustData);
		}
		return ErpResponseJson.ok(resultMapLast);
	}
	
	/**
	 * 房客源存量分析--按面积-房价、户型、行政区分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * queryDim		统计维度， PRICE=价格 ROOM=户型 REG=行政区
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataAnalysisByArea")
	public ResponseJson getStoreDataPriceArea(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		makeStoreDataAnalysisParam(param);
		List<Map<String, Object>> houseCustData = null;
		if("101".equals(caseType)) {// 买卖，查询出售和求购
			houseCustData = reportFunSaleMinMapper.getStoreDataAnalysisByArea(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			houseCustData = reportFunLeaseMinMapper.getStoreDataAnalysisByArea(cityId, param.getMap());
		}
		// 对数据进行分组
		Map<Object, Map<String, Object>> resultMapLast = new LinkedHashMap<>();
		if (houseCustData != null) {
			resultMapLast = makeStoreDataAnalysisResult(houseCustData);
		}
		return ErpResponseJson.ok(resultMapLast);
	}
	
	/**
	 * 房客源存量分析--按价格-面积、户型、行政区分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * queryDim		统计维度， AREA=面积 ROOM=户型 REG=行政区
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataAnalysisByPrice")
	public ResponseJson getStoreDataAnalysisByPrice(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		makeStoreDataAnalysisParam(param);
		List<Map<String, Object>> houseCustData = null;
		if("101".equals(caseType)) {// 买卖，查询出售和求购
			houseCustData = reportFunSaleMinMapper.getStoreDataAnalysisByPrice(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			houseCustData = reportFunLeaseMinMapper.getStoreDataAnalysisByPrice(cityId, param.getMap());
		}
		// 对数据进行分组
		Map<Object, Map<String, Object>> resultMapLast = new LinkedHashMap<>();
		if (houseCustData != null) {
			resultMapLast = makeStoreDataAnalysisResult(houseCustData);
		}
		return ErpResponseJson.ok(resultMapLast);
	}
	
	/**
	 * 房客源存量分析--按价格、面积、户型分析
	 * 组装存量分析统计的参数
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param param
	 */
	private void makeStoreDataAnalysisParam(BaseMapParam param) {
		String caseType = param.getString("caseType");
		param.setInteger("compId", getOperator().getCompId());
		changeSerchRange(param);
		boolean isSale = "101".equals(caseType);
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(getOperator().getCityId().shortValue());
		String caseArea = isSale ? "SALE_AREA" : "LEASE_AREA";
		String casePrice = isSale ? "SALE_TOTAL_PRICE*10000" : "iif(PRICE_UNIT=2,ISNULL(LEASE_TOTAL_PRICE,0)*30,iif(PRICE_UNIT=3,ISNULL(LEASE_TOTAL_PRICE,0)*LEASE_AREA,iif(PRICE_UNIT=4,ISNULL(LEASE_TOTAL_PRICE,0)*30*LEASE_AREA,iif(PRICE_UNIT=5,ISNULL(LEASE_TOTAL_PRICE,0)/12,LEASE_TOTAL_PRICE))))";
		String areaUnit = isSale ? adminFunCity.getStatisticsAreaSaleOption() : adminFunCity.getStatisticsAreaLeaseOption();
		String priceUnit = isSale ? adminFunCity.getStatisticsPriceSaleOption() : adminFunCity.getStatisticsPriceLeaseOption();
		String housePriceSql = DataAnalysisUtil.getCaseWhenSql(priceUnit, casePrice);
		param.setString("housePriceSql", housePriceSql);
		String houseAreaSql = DataAnalysisUtil.getCaseWhenSql(areaUnit, caseArea);
		param.setString("houseAreaSql", houseAreaSql);
	}
	
	/**
	 * 房客源存量分析--按房价、面积、户型分析
	 * 组装统计的结果集数据
	 * @author 张宏利
	 * @return 
	 * @since 2017年7月26日
	 */
	private Map<Object, Map<String, Object>> makeStoreDataAnalysisResult(List<Map<String, Object>> houseCustData) {
		// 对数据进行分组
		Map<Object, List<Map<String, Object>>> collectMap = houseCustData.stream().collect(Collectors.groupingBy(map -> map.get("dim")));
		Map<Object, Map<String, Object>> resultMap = new HashMap<>();
		List<Map<String, Integer>> priceKey = new LinkedList<>();
		for (Entry<Object, List<Map<String, Object>>> mapEntry : collectMap.entrySet()) {
			Map<String, Object> tempMap = new HashMap<>();
			resultMap.put(String.valueOf(mapEntry.getKey()), tempMap);
			int countTmp = 0;
			// 合并数据到一个对象
			for (Map<String, Object> mapVal : mapEntry.getValue()) {
				tempMap.put("name_" + mapVal.get("byName"), mapVal.get("counts"));
				Integer counts = Integer.valueOf(String.valueOf(mapVal.get("counts")));
				countTmp += counts;
			}
			// 组装key和对应的条数，用于排序找前四
			Map<String, Integer> tempKeyMap = new HashMap<>();
			tempKeyMap.put("key", Integer.valueOf(String.valueOf(mapEntry.getKey())));
			tempKeyMap.put("val", countTmp);
			priceKey.add(tempKeyMap);
		}
		// 排序找前4
		priceKey.sort((val1, val2) -> {return val2.get("val").compareTo(val1.get("val"));});
		// 拼前4的数据
		Map<Object, Map<String, Object>> resultMapLast = new HashMap<>();
		for (Map<String, Integer> mapTmp : priceKey) {
			String key = String.valueOf(mapTmp.get("key"));
			resultMapLast.put(key, resultMap.get(key));
			if(resultMapLast.size() >= 4) {
				break;
			}
		}
		return resultMapLast;
	}
	
	/**
	 * 房客源存量分析--房客源存量排名
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * rankType		排名类型：1=员工排名，2=门店排名
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataRanking")
	public ResponseJson getStoreDataRanking(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		String rankType = param.getString("rankType");
		param.setInteger("compId", getOperator().getCompId());
		changeSerchRange(param);
		List<Map<String, Object>> resultList = null;
		if("101".equals(caseType)) {// 买卖，查询出售和求购
			resultList = reportFunSaleMinMapper.getStoreDataRanking(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			resultList = reportFunLeaseMinMapper.getStoreDataRanking(cityId, param.getMap());
		}
		if (resultList != null && resultList.size() > 0) {
			if ("1".equals(rankType)) {// 员工排名
				Set<Integer> userIdSet = new HashSet<>();
				Set<Integer> deptIdset = new HashSet<>();
				// 员工id集合
				resultList.stream().forEach(map -> {
					Object object = map.get("rankId");
					if (null != object) {
						userIdSet.add(Integer.valueOf(object.toString()));
					}
				});
				if (userIdSet.size() > 0) {
					// 员工列表
					List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
					// 员工所在门店id集合
					userList.stream().forEach(user -> {
						deptIdset.add(user.getDeptId());
					});
					// 员工所在门店列表
					List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdset);
					Map<Integer, ErpFunDepts> deptMap = deptList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, dept -> dept));
					Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
					// 组装数据
					resultList.stream().forEach(map -> {
						Object object = map.get("rankId");
						if (null != object) {
							ErpFunUsers erpFunUsers = userMap.get(Integer.valueOf(object.toString()));
							if (null != erpFunUsers) {
								map.put("userName", erpFunUsers.getUserName());
								ErpFunDepts erpFunDepts = deptMap.get(erpFunUsers.getDeptId());// 员工所在门店
								if (null != erpFunDepts) {
									map.put("ownDeptName", erpFunDepts.getDeptName());
								}
							}
						}
					});
				}
			} else {// 门店排名
				Set<Integer> deptIdset = new HashSet<>();
				// 门店id集合
				resultList.stream().forEach(map -> {
					Object object = map.get("rankId");
					if (null != object) {
						deptIdset.add(Integer.valueOf(object.toString()));
					}
				});
				if (deptIdset.size() > 0) {
					// 公司门店列表
					List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdset);
					Map<Integer, ErpFunDepts> deptMap = deptList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, dept -> dept));
					// 组装数据
					resultList.stream().forEach(map -> {
						Object object = map.get("rankId");
						if (null != object) {
							ErpFunDepts erpFunDepts = deptMap.get(Integer.valueOf(object.toString()));
							if (null != erpFunDepts) {
								map.put("deptName", erpFunDepts.getDeptName());
							}
						}
					});
				}
			}
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 房客源存量分析--房客源带看、房勘分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * regionId		行政区域ID，只能一个
	 * sectionId	商圈ID，只能一个
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataDaiKan")
	public ResponseJson getStoreDataDaiKan(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		param.setInteger("compId", getOperator().getCompId());
		changeSerchRange(param);
		Map<String, Object> houseData = null;
		Map<String, Object> custData = null;
		if ("101".equals(caseType)) {// 买卖，查询出售和求购
			houseData = reportFunSaleMinMapper.getStoreDataDaiKan(cityId, param.getMap());
			custData = reportFunBuyCustomerMinMapper.getStoreDataDaiKan(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			houseData = reportFunLeaseMinMapper.getStoreDataDaiKan(cityId, param.getMap());
			custData = reportFunRentCustomerMinMapper.getStoreDataDaiKan(cityId, param.getMap());
		}
		List<Map<String, Object>> resultList = new LinkedList<>();
		if (null != houseData) {
			resultList.add(houseData);
		}
		if (null != custData) {
			resultList.add(custData);
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 房客源存量分析--统计房客源存量
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataCount")
	public ResponseJson getStoreDataCount(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		String caseType = param.getString("caseType");
		param.setInteger("compId", getOperator().getCompId());
		changeSerchRange(param);
		Integer houseCount = 0;
		Integer custCount = 0;
		Map<String, Object> countMap = new HashMap<>();
		if ("101".equals(caseType)) {// 买卖，查询出售和求购
			houseCount = reportFunSaleMinMapper.getStoreDataCount(cityId, param.getMap());
			custCount = reportFunBuyCustomerMinMapper.getStoreDataCount(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			houseCount = reportFunLeaseMinMapper.getStoreDataCount(cityId, param.getMap());
			custCount = reportFunRentCustomerMinMapper.getStoreDataCount(cityId, param.getMap());
		}
		countMap.put("house", houseCount);
		countMap.put("cust", custCount);
		List<Map<String, Object>> resultList = new LinkedList<>();
		resultList.add(countMap);
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 房客源存量分析--按各维度进行统计
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * queryDim		统计维度，STATUS=状态 PRICE=价格 AREA=面积 ROOM=户型 REG=行政区 SECTION=商圈  USEAGE=用途 BELONG=所属
	 * regionId		行政区域ID，只能一个
	 * sectionId	商圈ID，只能一个
	 * isChart		是否是图表：1=是
	 * dimension	维度 AREA 大区 REG 片区 DEPT 门店 GROUP 分组 USER 员工
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStoreDataAnalysis")
	public ResponseJson getStoreDataAnalysis(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String caseType = param.getString("caseType");
		String queryDim = param.getString("queryDim");
		String dimension = param.getString("dimension");
		boolean isChart = "1".equals(param.getString("isChart"));
		param.setInteger("compId", compId);
		changeSerchRange(param);
		List<Map<String, Object>> dataAnalysisHouse = null;
		List<Map<String, Object>> dataAnalysisCust = null;
		boolean isSale = "101".equals(caseType);
		if (isChart) {
			param.setInteger("topCount", 15);
		}
		AdminFunCity adminFunCity = adminFunCityService.getCity(getOperator().getCityId());
		String caseArea = isSale ? "SALE_AREA" : "LEASE_AREA";
		String casePrice = isSale ? "SALE_TOTAL_PRICE*10000" : "iif(PRICE_UNIT=2,ISNULL(LEASE_TOTAL_PRICE,0)*30,iif(PRICE_UNIT=3,ISNULL(LEASE_TOTAL_PRICE,0)*LEASE_AREA,iif(PRICE_UNIT=4,ISNULL(LEASE_TOTAL_PRICE,0)*30*LEASE_AREA,iif(PRICE_UNIT=5,ISNULL(LEASE_TOTAL_PRICE,0)/12,LEASE_TOTAL_PRICE))))";
		String areaUnit = isSale ? adminFunCity.getStatisticsAreaSaleOption() : adminFunCity.getStatisticsAreaLeaseOption();
		String priceUnit = isSale ? adminFunCity.getStatisticsPriceSaleOption() : adminFunCity.getStatisticsPriceLeaseOption();
		if ("PRICE".equals(queryDim)) {
			String housePriceSql = DataAnalysisUtil.getCaseWhenSql(priceUnit, casePrice);
			param.setString("housePriceSql", housePriceSql);
			String custPriceSql = DataAnalysisUtil.getCaseWhenSql(priceUnit, isSale ? "HOUSE_PRICE_HIGH*10000" : "HOUSE_PRICE_HIGH");
			param.setString("custPriceSql", custPriceSql);
		} else if("AREA".equals(queryDim)) {
			String housePriceSql = DataAnalysisUtil.getCaseWhenSql(areaUnit, caseArea);
			param.setString("houseAreaSql", housePriceSql);
			String custPriceSql = DataAnalysisUtil.getCaseWhenSql(areaUnit, "HOUSE_AREA_HIGH");
			param.setString("custAreaSql", custPriceSql);
		} else if("BELONG".equals(queryDim)) {
			String dimensionColumnSql = null, dimensionGroupSql = null;
			if ("AREA".equals(dimension)) {
				dimensionColumnSql = "isnull(AREA_ID,0) areaId,(convert(varchar,isnull(AREA_ID,0)))";
				dimensionGroupSql = "isnull(AREA_ID,0),(convert(varchar,isnull(AREA_ID,0)))";
			} else if("REG".equals(dimension)) {
				dimensionColumnSql = "isnull(AREA_ID,0) areaId,isnull(REG_ID,0) regId,(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0)))";
				dimensionGroupSql = "isnull(AREA_ID,0),isnull(REG_ID,0),(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0)))";
			} else if("DEPT".equals(dimension)) {
				dimensionColumnSql = "isnull(AREA_ID,0) areaId,isnull(REG_ID,0) regId,isnull(DEPT_ID,0) deptId,(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0))+'_'+convert(varchar,isnull(DEPT_ID,0)))";
				dimensionGroupSql = "isnull(AREA_ID,0),isnull(REG_ID,0),isnull(DEPT_ID,0),(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0))+'_'+convert(varchar,isnull(DEPT_ID,0)))";
			} else if("GROUP".equals(dimension)) {
				dimensionColumnSql = "isnull(AREA_ID,0) areaId,isnull(REG_ID,0) regId,isnull(DEPT_ID,0) deptId,isnull(GR_ID,0) grId,(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0))+'_'+convert(varchar,isnull(DEPT_ID,0))+'_'+convert(varchar,isnull(GR_ID,0)))";
				dimensionGroupSql = "isnull(AREA_ID,0),isnull(REG_ID,0),isnull(DEPT_ID,0),isnull(GR_ID,0),(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0))+'_'+convert(varchar,isnull(DEPT_ID,0))+'_'+convert(varchar,isnull(GR_ID,0)))";
			} else if("USER".equals(dimension)) {
				dimensionColumnSql = "isnull(AREA_ID,0) areaId,isnull(REG_ID,0) regId,isnull(DEPT_ID,0) deptId,isnull(GR_ID,0) grId,isnull(USER_ID,0) userId,(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0))+'_'+convert(varchar,isnull(DEPT_ID,0))+'_'+convert(varchar,isnull(GR_ID,0))+'_'+convert(varchar,isnull(USER_ID,0)))";
				dimensionGroupSql = "isnull(AREA_ID,0),isnull(REG_ID,0),isnull(DEPT_ID,0),isnull(GR_ID,0),isnull(USER_ID,0),(convert(varchar,isnull(AREA_ID,0))+'_'+convert(varchar,isnull(REG_ID,0))+'_'+convert(varchar,isnull(DEPT_ID,0))+'_'+convert(varchar,isnull(GR_ID,0))+'_'+convert(varchar,isnull(USER_ID,0)))";
			}
			// 没开启大区时大区ID用0替换
			if (!"1".equals(getOperator().getAreaFlag())) {
				dimensionColumnSql = dimensionColumnSql.replaceAll("AREA_ID", "0");
				dimensionGroupSql = dimensionGroupSql.replaceAll("AREA_ID", "0");
				dimensionGroupSql = dimensionGroupSql.replace("isnull(0,0),", "");
			}
			param.setString("dimensionColumnSql", dimensionColumnSql);
			param.setString("dimensionGroupSql", dimensionGroupSql);
		}
		
		if ("101".equals(caseType)) {// 买卖，查询出售和求购
			dataAnalysisHouse = reportFunSaleMinMapper.getStoreDataAnalysis(cityId, param.getMap());
			dataAnalysisCust = reportFunBuyCustomerMinMapper.getStoreDataAnalysis(cityId, param.getMap());
		} else {// 租赁，查询出租和求租
			dataAnalysisHouse = reportFunLeaseMinMapper.getStoreDataAnalysis(cityId, param.getMap());
			dataAnalysisCust = reportFunRentCustomerMinMapper.getStoreDataAnalysis(cityId, param.getMap());
		}
		// 将客源转换成map好取值
		Map<Object, Map<String, Object>> custMap = dataAnalysisCust.stream().collect(Collectors.toMap(map -> map.get("dim") == null ? 0 : map.get("dim"), val -> val));
		Map<String, Integer> userCountMap = null;
		Map<Object, Map<String, Object>> userRangeMap = null;
		if ("BELONG".equals(queryDim)) {// 所属
			String serchRange = param.getString("serchRange");
			Integer serchRangeId = param.getInteger("serchRangeId");
			String dimensionName = DataAnalysisUtil.getRange(dimension);
			userCountMap = erpFunUsersService.getUserCountByRange(cityId, compId, serchRange, serchRangeId, dimensionName, 0,param.getInteger("userId"));
			//查询需要扑数据的
			List<Map<String, Object>> rangeList = erpFunUsersMapper.getRangeListDaTaOfCompAreaToZero(cityId, compId,
					getOperator().getArchiveId(), dimension, serchRange, serchRangeId, 
					getOperator().getAreaFlag(), "1",param.getString("userId"));
			userRangeMap = rangeList.stream().collect(Collectors.toMap(map -> map.get("range"), val -> val));
		}
		// 将客源和房源合并到一起
		for (Map<String, Object> house : dataAnalysisHouse) {
			Object counts = house.get("counts");
			house.put("house", counts);
			house.put("counts", null);
			if(house.get("dim") == null) {
				house.put("dim", 0);
			}
			Map<String, Object> cust = custMap.get(house.get("dim"));
			if(cust != null) {
				house.put("cust", cust.get("counts"));
				custMap.remove(house.get("dim"));
			}
			if("BELONG".equals(queryDim)) {// 所属时设置员工人数
				DataAnalysisUtil.setUserCount(house, dimension, userCountMap);
			}
		}
		// 补客源多的数据
		if(!isChart) {
			for (Map<String, Object> cust : custMap.values()) {
				cust.put("cust", cust.get("counts"));
				cust.put("counts", null);
				if(cust.get("dim") == null) {
					cust.put("dim", 0);
				}
				dataAnalysisHouse.add(cust);
				if("BELONG".equals(queryDim)) {// 所属时设置员工人数
					DataAnalysisUtil.setUserCount(cust, dimension, userCountMap);
				}
			}
		}
		if("BELONG".equals(queryDim) && !isChart) {// 所属时补齐用户
			for (Map<String, Object> house : dataAnalysisHouse) {
				userRangeMap.put(house.get("dim"), house);
			}
			for (Map<String, Object> house : userRangeMap.values()) {
				house.put("dim", null);
				house.put("range", null);
			}
			dataAnalysisHouse = new LinkedList<>(userRangeMap.values());
			SortUtil.collectionsSort(dataAnalysisHouse, new String[]{"areaId", "regId", "deptId", "grId", "userId"}, true);
		}
		dataAnalysisHouse.sort((m1,m2)->{
			Integer dim1 = (Integer)m1.get("dim");
			Integer dim2 = (Integer)m2.get("dim");
			return dim1.compareTo(dim2);
		});
		ErpResponseJson responseJson = ErpResponseJson.ok(dataAnalysisHouse);
		responseJson.setExtra(queryDim);
		return responseJson;
	}

	/**
	 * 房客源新增分析(图表)
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId	搜索范围的值
	 * caseType	数据类型：101=买卖业务（默认），102=租赁业务
	 * regionIds	行政区域ID，多个英文逗号分隔
	 * queryDim	统计维度，ROOM_DIM=户型 REG_DIM=行政区 AREA_DIM=面积 SECTION_DIM=板块 USEAGE_DIM=用途 PRICE_DIM=价格
	 * dateCountType	0=日统计 1=周统计 2=月统计
	 * startTime	开始时间
	 * endTime	结束时间
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustAddCountData")
	public ResponseJson getHouseCustAddCountData(@Valid @RequestBody BaseMapParam param){
		Map<String, List<?>> resultList = getHouseCustAddCountDataIndex(param);
		ErpResponseJson responseJson = ErpResponseJson.ok(resultList);
		responseJson.setExtra(param.getString("queryDim"));
		return responseJson;
	}
	
	/**
	 * 房客源新增分析(报表)
	 * @author 臧铁
	 * @since 2017-07-26
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId	搜索范围的值
	 * caseType	数据类型：101=买卖业务（默认），102=租赁业务
	 * regionIds	行政区域ID，多个英文逗号分隔
	 * queryDim	统计维度，ROOM_DIM=户型 REG_DIM=行政区 AREA_DIM=面积 SECTION_DIM=板块 USEAGE_DIM=用途 PRICE_DIM=价格
	 * dateCountType	0=日统计 1=周统计 2=月统计
	 * startTime	开始时间
	 * endTime	结束时间
	 * order 1=员工排名 2=门店排名
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustAddCountDataForReport")
	public ResponseJson getHouseCustAddCountDataForReport(@Valid @RequestBody BaseMapParam param){
		Map<String, List<?>> resultList = getHouseCustAddCountDataIndex(param);
		ErpResponseJson responseJson = ErpResponseJson.ok(resultList);
		responseJson.setExtra(param.getString("queryDim"));
		return responseJson;
	}
	
	/**
	 * 房客源新增分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId	搜索范围的值
	 * caseType	数据类型： 101=买卖  102=租赁
	 * regionIds	行政区域ID，多个英文逗号分隔
	 * queryDim	统计维度，ROOM_DIM=户型 REG_DIM=行政区 AREA_DIM=面积 SECTION_DIM=板块 USEAGE_DIM=用途 PRICE_DIM=价格
	 * dateCountType	0=日统计 1=周统计 2=月统计
	 * startTime	开始时间
	 * endTime	结束时间
	 * @return
	 * @throws Exception
	 */
	private Map<String, List<?>> getHouseCustAddCountDataIndex(BaseMapParam param) {
		String caseType = param.getString("caseType");
		String queryDim = param.getString("queryDim");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String serchRange = param.getString("serchRange");
  		boolean isChart = "1".equals(param.getString("isChart"));
		String dateCountType = param.getString("dateCountType");
		String regionId = param.getString("regionId");
		String sectionIds = param.getString("sectionIds");// 默认行政区  -- 维度
		param.setInteger("compId", getOperator().getCompId());
		this.setTimeParam(param);
		if (StringUtils.isBlank(queryDim)) {
			param.setString("queryDim", "REG");
		}
		if (StringUtils.isNotBlank(sectionIds)) {
			param.setObject("sectionIdsArr", sectionIds.split(","));
			param.setObject("sourceType", "1");
		}
		if (StringUtils.isNotBlank(regionId)) {
			param.setObject("regionIdsArr", regionId.split(","));// 默认行政区 -- 维度
			param.setObject("sourceType", "2");
		}
		// 设置真实的serchRange
		changeSerchRange(param, serchRange);
		// 图表而且是行政区、商圈只取前四 TODO 看需不需要全部只返回前4
		boolean olnyTop4 = isChart && ("REG".equals(queryDim)||"SECTION".equals(queryDim));

		Map<String, Map<String, Map<String, Object>>> houseResultMap = new HashMap<>();
		Map<String, Map<String, Map<String, Object>>> custResultMap = new HashMap<>();
		AdminFunCity adminFunCity = adminFunCityService.getCity(getOperator().getCityId());
		if ("101".equals(caseType)) {
			param.setInteger("caseType", 1);
			List<HouseCustAddCountDto> houseData = getHouseAddCountData(param, adminFunCity);
			param.setInteger("caseType", 3);
			List<HouseCustAddCountDto> custData = getCustAddCountData(param, adminFunCity);
			packageData(houseResultMap, houseData, "house", queryDim.toLowerCase(), olnyTop4);
			packageData(custResultMap, custData, "cust", queryDim.toLowerCase(), olnyTop4);
		} else if ("102".equals(caseType)) {
			param.setInteger("caseType", 2);
			List<HouseCustAddCountDto> houseData = getHouseAddCountData(param, adminFunCity);
			param.setInteger("caseType", 4);
			List<HouseCustAddCountDto> custData = getCustAddCountData(param, adminFunCity);
			packageData(houseResultMap, houseData, "house", queryDim.toLowerCase(), olnyTop4);
			packageData(custResultMap, custData, "cust", queryDim.toLowerCase(), olnyTop4);
		}
		Map<String, List<?>> resultListMap = new LinkedHashMap<>();
		if (!houseResultMap.isEmpty()) {
			for (Entry<String, Map<String, Map<String, Object>>> element : houseResultMap.entrySet()) {
				List<Map<String, Object>> linkedList = new LinkedList<>(element.getValue().values());
				// 补时间
				Map<String, Object> baseMap = new HashMap<String, Object>();
				DataAnalysisUtil.repairDateForListMap(linkedList, baseMap, startTime, endTime, dateCountType);
				resultListMap.put("house" + element.getKey(), linkedList);
			}
		}
		if (!custResultMap.isEmpty()) {
			for (Entry<String, Map<String, Map<String, Object>>> element : custResultMap.entrySet()) {
				List<Map<String, Object>> linkedList = new LinkedList<>(element.getValue().values());
				// 补时间
				Map<String, Object> baseMap = new HashMap<String, Object>();
				DataAnalysisUtil.repairDateForListMap(linkedList, baseMap, startTime, endTime, dateCountType);
				resultListMap.put("cust" + element.getKey(), linkedList);
			}
		}
		return resultListMap;
	}

	/**
	 * 数据组装到resultMap里面去
	 * @author 张宏利
	 * @since 2017年7月21日
	 * @param resultMap 结果map
	 * @param dtoData 查询出来的数据
	 * @param houseCustStr 房源或客源开头的字符串
	 * @param keyName 封装哪个维度的值
	 */
	private void packageData(Map<String, Map<String, Map<String, Object>>> resultMap, List<HouseCustAddCountDto> dtoData, String houseCustStr, String keyName, boolean olnyTop4) {
		if("user".equals(keyName)) {
			keyName = "userId";
		} else if("reg".equals(keyName)) {
			keyName = "regId";
		}
		if(olnyTop4) {// 只取综合后的前四名
			Map<String, Integer> priceKey = new HashMap<>();
			// 把值相加用于排序
			for (HouseCustAddCountDto houseCustAddCountDto : dtoData) {
				try {
					String keyValue = BeanUtils.getProperty(houseCustAddCountDto, keyName);
					if(keyValue == null) {
						keyValue = "0";
					}
					Integer val = priceKey.get(keyValue);
					if(val == null) {
						val = 0;
					}
					priceKey.put(keyValue, val + Integer.valueOf(houseCustAddCountDto.getNum()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 找到前四名
			List<Integer> valList = new LinkedList<>(priceKey.values());
			valList.sort((val1, val2) -> {return val2.compareTo(val1);});
			Set<String> ketSet = new HashSet<>();
			for (Integer val : valList) {
				for (Entry<String, Integer> entry : priceKey.entrySet()) {
					if(entry.getValue().equals(val)) {
						ketSet.add(entry.getKey());
					}
					if(ketSet.size() > 4){break;}
				}
				if(ketSet.size() > 4){break;}
			}
			// 排除不在范围内的
			for (int i = dtoData.size() - 1; i >= 0; i--) {
				try {
					String keyValue = BeanUtils.getProperty(dtoData.get(i), keyName);
					if(keyValue == null) {
						keyValue = "0";
					}
					if(!ketSet.contains(keyValue)) {// 不在top4里面的设置为0，其他
						BeanUtils.setProperty(dtoData.get(i), keyName, "0");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// 数据组装
		for (HouseCustAddCountDto houseCustAddCountDto : dtoData) {
			try {
				String keyValue = BeanUtils.getProperty(houseCustAddCountDto, keyName);
				keyValue = keyValue == null ? "0" : keyValue;
				houseCustAddCountDto.setTempKeyVal(keyValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map<String, List<HouseCustAddCountDto>> dtoMap = dtoData.stream().collect(Collectors.groupingBy(HouseCustAddCountDto::getTempKeyVal));
		for (Entry<String, List<HouseCustAddCountDto>> dtoEntry : dtoMap.entrySet()) {
			Map<String, Map<String, Object>> tempDateMap = resultMap.get(dtoEntry.getKey());
			if (tempDateMap == null) {
				tempDateMap = new HashMap<>();
				resultMap.put(dtoEntry.getKey(), tempDateMap);
			}
			for (HouseCustAddCountDto houseCustAddCountDto : dtoEntry.getValue()) {
				Map<String, Object> mapTemp = tempDateMap.get(houseCustAddCountDto.getDate());
				if(mapTemp == null) {
					mapTemp = new HashMap<>();
					tempDateMap.put(houseCustAddCountDto.getDate(), mapTemp);
				}
				mapTemp.put("date", houseCustAddCountDto.getDate());
				mapTemp.put(houseCustStr, houseCustAddCountDto.getNum());
			}
		}
	}
	
	/**
	 * 客源新增分析
	 * @author 张宏利
	 * @since 2017年7月15日
	 * @param param
	 * @return
	 */
	private List<HouseCustAddCountDto> getCustAddCountData(BaseMapParam param, AdminFunCity adminFunCityPO) {
		Operator operator = getOperator();
		param.setInteger("compId", operator.getCompId());
		String caseType = param.getString("caseType");
		String queryDim = param.getString("queryDim");
		String isMax = param.getString("isMax");
		boolean isBuy = "3".equals(caseType);
		param.setString("tableName", isBuy ? "FUN_BUY_CUSTOMER_MIN" : "FUN_RENT_CUSTOMER_MIN");
		param.setString("primaryId", isBuy ? "BUY_CUST_ID" : "RENT_CUST_ID");
		
		boolean isMaxB = "1".equals(isMax);
		String casePrice = isMaxB ? "ISNULL(A.HOUSE_PRICE_LOW,0)*10000" : "A.HOUSE_PRICE_HIGH*10000";
		String caseArea = isMaxB ? "ISNULL(A.HOUSE_AREA_LOW,0)" : "A.HOUSE_AREA_HIGH";
		// 求租
		if(!isBuy) {
			casePrice = isMaxB ? "A.HOUSE_PRICE_HIGH" : "A.HOUSE_PRICE_LOW";
		}
		// 价格和面积配置
		String areaUnit = isBuy ? adminFunCityPO.getStatisticsAreaSaleOption() : adminFunCityPO.getStatisticsAreaLeaseOption();
		String priceUnit = isBuy ? adminFunCityPO.getStatisticsPriceSaleOption() : adminFunCityPO.getStatisticsPriceLeaseOption();
		if("AREA".equals(queryDim)){// 面积
			param.setString("areaUnit", DataAnalysisUtil.getCaseWhenSql(areaUnit, caseArea));
		}else if("PRICE".equals(queryDim)){// 价格
			param.setString("priceUnit", DataAnalysisUtil.getCaseWhenSql(priceUnit, casePrice));
		}
//		reportFunSaleMinMapper
		List<HouseCustAddCountDto> dtoList = reportFunSaleMinMapper.getCustAddCountData(operator.getCityId(), param.getMap());
		return dtoList;
	}
	
	/**
	 * 房源新增分析
	 * @author 张宏利
	 * @since 2017年7月15日
	 * @param param
	 * @return
	 */
	private List<HouseCustAddCountDto> getHouseAddCountData(BaseMapParam param, AdminFunCity adminFunCity) {
		Operator operator = getOperator();
		param.setInteger("compId", operator.getCompId());
		String caseType = param.getString("caseType");
		String queryDim = param.getString("queryDim");
		boolean isSale = "1".equals(caseType);
		param.setString("tableName", isSale ? "FUN_SALE_MIN" : "FUN_LEASE_MIN");
		param.setString("primaryId", isSale ? "SALE_ID" : "LEASE_ID");
		param.setString("room", isSale ? "SALE_ROOM" : "LEASE_ROOM");
		param.setString("caseReg", isSale ? "SALE_REG" : "LEASE_REG");
		param.setString("caseUsage", isSale ? "SALE_USEAGE" : "LEASE_USEAGE");
		param.setString("caseSource", isSale ? "SALE_SOURCE" : "LEASE_SOURCE");
		param.setString("caseStatus", isSale ? "SALE_STATUS" : "LEASE_STATUS");
		
		String caseArea = isSale ? "SALE_AREA" : "LEASE_AREA";
		String casePrice = isSale ? "SALE_TOTAL_PRICE*10000" : "iif(PRICE_UNIT=2,ISNULL(LEASE_TOTAL_PRICE,0)*30,iif(PRICE_UNIT=3,ISNULL(LEASE_TOTAL_PRICE,0)*LEASE_AREA,iif(PRICE_UNIT=4,ISNULL(LEASE_TOTAL_PRICE,0)*30*LEASE_AREA,iif(PRICE_UNIT=5,ISNULL(LEASE_TOTAL_PRICE,0)/12,LEASE_TOTAL_PRICE))))";
		String areaUnit = isSale ? adminFunCity.getStatisticsAreaSaleOption() : adminFunCity.getStatisticsAreaLeaseOption();
		String priceUnit = isSale ? adminFunCity.getStatisticsPriceSaleOption() : adminFunCity.getStatisticsPriceLeaseOption();
		if("PRICE".equals(queryDim)){// 价格
			param.setString("priceUnit", DataAnalysisUtil.getCaseWhenSql(priceUnit, casePrice));
		}else if("AREA".equals(queryDim)){// 面积
			param.setString("areaUnit", DataAnalysisUtil.getCaseWhenSql(areaUnit, "A."+caseArea));
		}
		List<HouseCustAddCountDto> dtoList = reportFunSaleMinMapper.getHouseAddCountData(operator.getCityId(), param.getMap());
		return dtoList;
	}
	
	/**
	 * 设置serchRange，这里默认获取serchRange字段，然后设置到serchRange字段
	 * 调用之前必须要先设置compId
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param param 参数
	 */
	public static void changeSerchRange(BaseMapParam param) {
		String serchRange = param.getString("serchRange");
		changeSerchRange(param, serchRange);
	}
	
	/**
	 * 设置serchRange，这里默认设置到：serchRange 字段
	 * 调用之前必须要先设置compId
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param param 参数
	 * @param serchRange 前端传的范围名称，AREA,REG,DEPT,GROUP,USER
	 */
	public static void changeSerchRange(BaseMapParam param, String serchRange) {
		changeSerchRange(param, "serchRange", serchRange);
	}
	
	/**
	 * 设置serchRange
	 * 调用之前必须要先设置compId，没有的时候默认设置成COMP_ID和从参数里面获取compId
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param param 参数
	 * @param rangeName 需要设置到的字段名，设置之后外面就可以get到
	 * @param serchRange 前端传的范围名称，AREA,REG,DEPT,GROUP,USER
	 */
	public static void changeSerchRange(BaseMapParam param, String rangeName, String serchRange) {
		if ("COMP".equals(serchRange)) {
			param.setString(rangeName, "COMP_ID");
			param.setInteger("serchRangeId", param.getInteger("compId"));
		} else if ("AREA".equals(serchRange)) {
			param.setString(rangeName, "AREA_ID");
		} else if ("REG".equals(serchRange)) {
			param.setString(rangeName, "REG_ID");
		} else if ("DEPT".equals(serchRange)) {
			param.setString(rangeName, "DEPT_ID");
		} else if ("GROUP".equals(serchRange)) {
			param.setString(rangeName, "GR_ID");
		} else if ("USER".equals(serchRange)) {
			param.setString(rangeName, "USER_ID");
		} else {
			param.setString(rangeName, "COMP_ID");
			param.setInteger("serchRangeId", param.getInteger("compId"));
		}
	}
	
	/**
	 * 房，客源流转统计表(图表)
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param param  caseType房客源类型           countDate统计时间       searchDimension类型：  NEW=当月  OLD=历史
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustFlowAnalysisCountList")
	public ResponseJson getHouseCustFlowAnalysisCountList(@Valid @RequestBody BaseMapParam param) throws Exception{
		this.setTimeParamForMonth(param);
		List<Map<String, Object>> endList = getHouseCustFlowAnalysisCountListIndex(param);
		return ErpResponseJson.ok(endList);
	}
	
	/**
	 * 房，客源流转统计表(报表)
	 * @author 臧铁
	 * @since 2017年7月26日
	 * @param param  caseType房客源类型           countDate统计时间       searchDimension类型：  NEW=当月  OLD=历史
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustFlowAnalysisCountListForReport")
	public ResponseJson getHouseCustFlowAnalysisCountListForReport(@Valid @RequestBody BaseMapParam param) throws Exception {
		this.setTimeParamForMonth(param);
		// 报表拼接数据
		List<Map<String, Object>> topList = null;
		List<Map<String, Object>> footList = null;
		if ("101".equals(param.getString("caseType"))) {
			param.setString("caseType", "1");
			topList = getHouseCustFlowAnalysisCountListIndex(param);
			param.setString("caseType", "3");
			footList = getHouseCustFlowAnalysisCountListIndex(param);
		} else {
			param.setString("caseType", "2");
			topList = getHouseCustFlowAnalysisCountListIndex(param);
			param.setString("caseType", "4");
			footList = getHouseCustFlowAnalysisCountListIndex(param);
		}
		topList.addAll(footList);
		return ErpResponseJson.ok(topList);
	}
	
	/**
	 * 传入的时间参数处理，0=日统计 1=周统计 2=月统计
	 * @author 臧铁
	 * @since 2017年7月26日
	 * @param param startTime格式2017-01变成2017-01-01 00:00:00 本月一号
	 * @param param endTime格式2017-02变成2017-02-28 23:59:59 本月月末
	 * @return 
	 * @throws Exception 
	 */
	private void setTimeParam(BaseMapParam param) {
		// 传入的时间参数处理
		String startTime = param.getString("startTime");// 统计开始时间
		String endTime = param.getString("endTime");// 统计结束时间
		String dateCountType = param.getString("dateCountType");
		if("2".equals(dateCountType)) {
			startTime = startTime.substring(0, 7) + "-01 00:00:00";
			endTime = endTime.substring(0, 7) + "-01 00:00:00";
			Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);
			calendar.setTime(DateTimeHelper.parseToDate(endTime));
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		} else {
			startTime = startTime.substring(0, 10) + " 00:00:00";
			endTime = endTime.substring(0, 10) + " 23:59:59";
		}
		param.setString("startTime", startTime);
		param.setString("endTime", endTime);
	}
	
	/**
	 * 传入的时间参数处理
	 * @author 臧铁
	 * @since 2017年7月26日
	 * @param param startTime格式2017-01变成2017-01-01 00:00:00 本月一号
	 * @param param endTime格式2017-02变成2017-02-28 23:59:59 本月月末
	 * @return
	 * @throws Exception 
	 */
	private void setTimeParamForMonth(BaseMapParam param) {
		// 传入的时间参数处理
		String startTime = param.getString("startTime");// 统计开始时间
		String endTime = param.getString("endTime");// 统计结束时间
		startTime = startTime.substring(0, 7) + "-01 00:00:00";
		endTime = endTime.substring(0, 7) + "-01 00:00:00";
		Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);
		calendar.setTime(DateTimeHelper.parseToDate(endTime));
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		// 格式：2017-02-28 23:59:59
		endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		param.setString("startTime", startTime);
		param.setString("endTime", endTime);
	}

	/**
	 * 房，客源流转统计表
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param param  caseType房客源类型           countDate统计时间       searchDimension类型：  NEW=当月  OLD=历史
	 * @return
	 * @throws Exception 
	 */
	private List<Map<String, Object>> getHouseCustFlowAnalysisCountListIndex(BaseMapParam param) throws Exception {
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		Integer cityId = param.getInteger("cityId");
		Integer deptId = param.getInteger("deptId");
		Integer userId = param.getInteger("userId");
		Integer areaId = param.getInteger("areaId");
		Integer regId = param.getInteger("regId");
		String caseType = param.getString("caseType");
		String endTime = param.getString("endTime");
		String startTime = param.getString("startTime");
		Date nowDate = new Date();
		if (DateTimeHelper.parseToDate(endTime).after(nowDate)) {
			endTime = DateTimeHelper.formatDateTimetoString(nowDate, DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String currentMonth = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		calendar.setTime(DateTimeHelper.parseToDate(endTime));
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String endMonth = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		Map<String, Object> stockMap = reportFunStatisticDetail1Mapper.getFlowAnalysisStockData(param.getMap());
		boolean currentMonthFlag = false;
		//判断传的时间是否包含当月
		if (currentMonth.equals(endMonth)) {
			currentMonthFlag = true;
		}
		String searchDimension = param.getString("searchDimension");// 类型 NEW=当月  OLD=历史
		Map<String, Object> endMap = new HashMap<>();
		List<Map<String, Object>> endList = new LinkedList<Map<String, Object>>();
		List<Map<String, Object>> list = reportHouseorcustFlowAnalysistotalMapper.getHouseCustFlowAnalysisCountList(cityId, param.getMap());
		/**
		 * 	columnMap.put("1", "effectiveSaveCount");
		columnMap.put("2", "sealingplateSaveCount");
		columnMap.put("4", "bookSaveCount");
		columnMap.put("5", "innderdealSaveCount");
		columnMap.put("6", "outdealSaveCount");
		columnMap.put("101", "transfertosaleSaveCount");
		columnMap.put("102", "transfertoleaseSaveCount");
		columnMap.put("7", "cancellSaveCount");
		columnMap.put("105", "transfertoshareSaveCount");
		columnMap.put("106", "transfertopublicSaveCount");
		 */
		// 当月新增
		if ("NEW".equals(searchDimension)) {
			Map<String,String> addDataMap = DataAnalysisUtil.HOUSEORCUST_FLOWANALYSISADD_MAP;
			List<Map<String,Object>> returnDataList = new ArrayList<Map<String,Object>>();
			list.stream().forEach((Map<String,Object> data)->{
				Object monthOffYear = data.get("monthofyear");
				for(String column:addDataMap.keySet()){
					Map<String,Object> effectiveAddCount = new HashMap<String,Object>();
					effectiveAddCount.put("caseStatus", addDataMap.get(column));
					effectiveAddCount.put("monthofyear", monthOffYear);
					effectiveAddCount.put("statusCount", data.get(column));
					returnDataList.add(effectiveAddCount);
				}
			});
			// 移植时老数据 现在caseType只为单独的1 2 3 4
			if (StringUtils.isNotBlank(caseType)) {
				String[] caseTypeArr = caseType.split(",");
				param.setObject("newSqlCaseTypeIn", caseTypeArr);
			}
			// 上月的新增历史数据
			if(currentMonthFlag){
				// 本月的新数据 最终数据=上月部分新增历史数据+本月部分新数据（当月份不是6-7月这种整月的时候）
				this.addCurrentMonthFlowAnalysisData(areaId, regId, deptId, userId, returnDataList, caseType);
			}
			if ("1".equals(caseType)) {// 出售
				endMap.put("saleFlow", returnDataList);
				endMap.put("saleStock", stockMap);
			} else if ("2".equals(caseType)) {// 出租
				endMap.put("leaseFlow", returnDataList);
				endMap.put("leaseStock", stockMap);
			} else if ("3".equals(caseType)) {// 求购
				endMap.put("buyFlow", returnDataList);
				endMap.put("buyStock", stockMap);
			} else if ("4".equals(caseType)) {// 求租
				endMap.put("rentFlow", returnDataList);
				endMap.put("rentStock", stockMap);
			}
			endList.add(endMap);
			// 历史数据（存量数据）
		} else {
			// 移植时老数据 现在caseType只为单独的1 2 3 4
			if (StringUtils.isNotBlank(caseType)) {
				String[] caseTypeArr = caseType.split(",");
				param.setObject("newSqlCaseTypeIn", caseTypeArr);
			}
			Map<String,String> saveDataMap = DataAnalysisUtil.HOUSEORCUST_FLOWANALYSISSAVE_MAP;
			List<Map<String,Object>> returnDataList = new ArrayList<Map<String,Object>>();
			list.stream().forEach((Map<String,Object> data)->{
				Object monthOffYear = data.get("monthofyear");
				for(String column:saveDataMap.keySet()){
					Map<String,Object> effectiveAddCount = new HashMap<String,Object>();
					effectiveAddCount.put("caseStatus", saveDataMap.get(column));
					effectiveAddCount.put("monthofyear", monthOffYear);
					effectiveAddCount.put("statusCount", data.get(column));
					returnDataList.add(effectiveAddCount);
				}
			});
			list = returnDataList;
			// 将list查询出的caseId组装后经过判断将list查询出的maxId和minId放入trackIdSet集合中
			if(currentMonthFlag){
				calendar = Calendar.getInstance();
				Date endDate = calendar.getTime();
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				Date startDate = calendar.getTime();
				startTime = DateTimeHelper.formatDateTimetoString(startDate, DateTimeHelper.FMT_yyyyMMdd) + " 00:00:00";
				endTime = DateTimeHelper.formatDateTimetoString(endDate, DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59";
				param.setString("startTime", startTime);
				param.setString("endTime", endTime);
				List<Map<String,Object>> dealList = reportFunStatisticDetail1Mapper.getNeedRepairHouseCustFlowAnalysisCountList(param.getMap());
				List<Map<String,Object>> trackList = reportFunStatisticDetail1Mapper.getNeedRepairHouseCustFlowAnalysisTrackList(param.getMap());
				Map<String,Map<String,Object>> trackMap = BeanUtil.listMapObjecttoMap(trackList, "trackId");
				Map<String,Map<String,Object>> returnDataMap = new HashMap<>();
				for(Map<String,Object> dataMap:dealList){
					Object maxTrackId = dataMap.get("maxId");
					Object minTrackId = dataMap.get("minId");
					if(minTrackId!=null){
						String minTrackIdStr = minTrackId.toString();
						String maxTrackIdStr = maxTrackId.toString();
						if(!minTrackIdStr.equals(maxTrackIdStr)){
							Map<String,Object> minTrackData = trackMap.get(minTrackId);
							Map<String,Object> maxTrackData = trackMap.get(maxTrackId);
							Object minTrackStatus = minTrackData.get("caseStaus");
							Object maxTrackStatus = maxTrackData.get("caseStaus");
							if(minTrackStatus!=null && maxTrackStatus!=null){
								String minTrackStatusStr = minTrackStatus.toString();
								String maxTrackStatusStr = maxTrackStatus.toString();
								if(!minTrackStatusStr.equals(maxTrackStatusStr)){
									//String columnName = columnMap.get(maxTrackStatusStr);
									if(StringUtils.isNotBlank(maxTrackStatusStr)){
										Map<String,Object> data = returnDataMap.get(maxTrackStatus);
										if(data!=null){
											data.put("statusCount", StringUtil.parseInteger(String.valueOf(data.get("statusCount")), 0)+1);
										}else{
											data = new HashMap<String,Object>();
											data.put("statusCount", 1);
											data.put("caseStatus", maxTrackStatusStr);
											data.put("monthofyear",dataMap.get("monthoffYear"));
											returnDataMap.put(maxTrackStatusStr, data);
										}
									}
								}
							}									
						}else{
							Map<String,Object> minTrackData = trackMap.get(minTrackId);
							if (null != minTrackData && minTrackData.get("caseStaus") != null) {
								String caseStatusStr = minTrackData.get("caseStaus").toString();
								if (StringUtils.isNotBlank(caseStatusStr)) {
									if (StringUtils.isNotBlank(caseStatusStr)) {
										Map<String, Object> data = returnDataMap.get(caseStatusStr);
										if (data != null) {
											data.put("statusCount", StringUtil.parseInteger(String.valueOf(data.get("statusCount")), 0) + 1);
										} else {
											data = new HashMap<String, Object>();
											data.put("statusCount", 1);
											data.put("caseStatus", caseStatusStr);
											data.put("monthofyear", dataMap.get("monthoffYear"));
											returnDataMap.put(caseStatusStr, data);
										}
									}
								}
							}
						}
					}
					//dataMap.put("key", );
			}
			returnDataList.addAll(returnDataMap.values());
			// 拼装成list数据
			//List<Map<String, Object>> resultDataList = new LinkedList<Map<String, Object>>();
		}
			if ("1".equals(caseType)) {// 出售
				endMap.put("saleFlow", returnDataList);
				endMap.put("saleStock", stockMap);
			} else if ("2".equals(caseType)) {// 出租
				endMap.put("leaseFlow", returnDataList);
				endMap.put("leaseStock", stockMap);
			} else if ("3".equals(caseType)) {// 求购
				endMap.put("buyFlow", returnDataList);
				endMap.put("buyStock", stockMap);
			} else if ("4".equals(caseType)) {// 求租
				endMap.put("rentFlow", returnDataList);
				endMap.put("rentStock", stockMap);
			}
			endList.add(endMap);
		}
		return endList;
	}

	/**
	 * 增加当月历史数据
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param userId
	 * @param list
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> addCurrentMonthFlowAnalysisData(Integer areaId,Integer regId,Integer deptId, Integer userId,List<Map<String, Object>> list,String caseType) {
		if (null == list) {
			list = new ArrayList<>();
		}
		if (StringUtils.isNotBlank(caseType)) {
			Calendar calendar = Calendar.getInstance();
			Date endDate = calendar.getTime();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date startDate = calendar.getTime();
			String startTime = DateTimeHelper.formatDateTimetoString(startDate, DateTimeHelper.FMT_yyyyMMdd) + " 00:00:00";
			String endTime = DateTimeHelper.formatDateTimetoString(endDate, DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59";
			List<Map<String, Object>> dataList = null;
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				dataList = reportFunSaleMinMapper.getFlowAnalysisCountList( getOperator().getCityId(),areaId, regId, deptId, userId, getOperator().getCompId(), startTime, endTime);
				if (dataList != null) {
					list.addAll(dataList);
				}
			} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				dataList = reportFunLeaseMinMapper.getFlowAnalysisCountList( getOperator().getCityId(),areaId, regId, deptId, userId, getOperator().getCompId(), startTime, endTime);
				if (dataList != null) {
					list.addAll(dataList);
				}
			} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
				dataList = reportFunBuyCustomerMinMapper.getFlowAnalysisCountList( getOperator().getCityId(),areaId, regId, deptId, userId, getOperator().getCompId(), startTime, endTime);
				if (dataList != null) {
					list.addAll(dataList);
				}
			} else if (Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
				dataList = reportFunRentCustomerMinMapper.getFlowAnalysisCountList( getOperator().getCityId(),areaId, regId, deptId, userId, getOperator().getCompId(), startTime, endTime);
				if (dataList != null) {
					list.addAll(dataList);
				}
			}
			
		}
		return list;
	}
	
	/**
	 * 获取房源底部统计信息(暂时无用端口)
	 * @author 臧铁
	 * @since 2017年7月18日
	 * @param param  dimension维度（COMP，AREA，REG，DEPT，GROUP，USER）    dataType统计类型（STATUS，SOURCE，REGION，USEAGE）
	 * @param param  serchRange搜索范围（COMP，AREA，REG，DEPT，GROUP，USER）   serchRangeId搜索范围ID
	 * @param param  caseType查询类型（1=出售，2=出租）     status状态（1=有效房源）
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHouseBottomInfo")
	public ResponseJson getHouseBottomInfo(@Valid @RequestBody BaseMapParam param){
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String dataType = param.getString("dataType");
		String serchRange = param.getString("serchRange");
		String caseType = param.getString("caseType");
		Integer status = param.getInteger("status");
		Integer cityId = param.getInteger("cityId");
		Integer perVerUid = getOperator().isPersonalVersion() ? getOperator().getUserId() : null;
		param.setInteger("perVerUid", perVerUid);
		// 获取真实范围
		serchRange = DataAnalysisUtil.getRange(serchRange);
		param.setString("serchRange", serchRange);
		String[] statusArr = new String[]{Constants_DIC.DIC_HOUSE_STATUS_AVAILABLE,Constants_DIC.DIC_HOUSE_STATUS_SPECIAL,
				Constants_DIC.DIC_HOUSE_STATUS_RESPITE,Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE,};
		if (null != status && 1 == status) {
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				param.setObject("sqlSaleStatusIn", statusArr);
			} else {
				param.setObject("sqlLeaseStatusIn", statusArr);
			}
		}
		Map<String, Object> map = null;
		List<Map<String, Object>> resultList = new LinkedList<Map<String, Object>>();
		// 房源状态统计（有钥匙、有图片、有视频、已房勘、微店、真房源、有VR、预订）
		if ("STATUS".equals(dataType)) {
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				map = reportFunSaleMinMapper.getHouseBottomInfoForStatus(cityId, param.getMap());
			} else {
				map = reportFunLeaseMinMapper.getHouseBottomInfoForStatus(cityId, param.getMap());
			}
			resultList.add(map);
		// 房源来源统计（委托方式、房源级别、装修方式）
		} else if ("SOURCE".equals(dataType)) {
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				List<Map<String, Object>> consignMap = reportFunSaleMinMapper.getHouseBottomInfoForSourceConsign(cityId, param.getMap());
				List<Map<String, Object>> levelMap = reportFunSaleMinMapper.getHouseBottomInfoForSourceLevel(cityId, param.getMap());
				List<Map<String, Object>> fitmentMap = reportFunSaleMinMapper.getHouseBottomInfoForSourceFitment(cityId, param.getMap());
				resultList.addAll(consignMap);
				resultList.addAll(levelMap);
				resultList.addAll(fitmentMap);
			} else {
				List<Map<String,Object>> consignMap = reportFunLeaseMinMapper.getHouseBottomInfoForSourceConsign(cityId,param.getMap());
				List<Map<String,Object>> levelMap = reportFunLeaseMinMapper.getHouseBottomInfoForSourceLevel(cityId,param.getMap());
				List<Map<String,Object>> fitmentMap = reportFunLeaseMinMapper.getHouseBottomInfoForSourceFitment(cityId,param.getMap());
				resultList.addAll(consignMap);
				resultList.addAll(levelMap);
				resultList.addAll(fitmentMap);
			}
			// 房源分布区域统计（范围分布、商圈分布、标签占比）
		} else if ("REGION".equals(dataType)) {
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				List<Map<String, Object>> roundMap = reportFunSaleMinMapper.getHouseBottomInfoForRegionRound(cityId, param.getMap());
				List<Map<String, Object>> sectionMap = reportFunSaleMinMapper.getHouseBottomInfoForRegionSection(cityId, param.getMap());
				resultList.addAll(roundMap);
				resultList.addAll(sectionMap);
			} else {
				List<Map<String, Object>> roundMap = reportFunLeaseMinMapper.getHouseBottomInfoForRegionRound(cityId, param.getMap());
				List<Map<String, Object>> sectionMap = reportFunLeaseMinMapper.getHouseBottomInfoForRegionSection(cityId, param.getMap());
				resultList.addAll(roundMap);
				resultList.addAll(sectionMap);
			}
			// 房源用途统计（住宅、别墅、商铺、写字楼）
		} else if ("USEAGE".equals(dataType)) {
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				List<Map<String, Object>> useageMap = reportFunSaleMinMapper.getHouseBottomInfoForUseage(cityId, param.getMap());
				resultList.addAll(useageMap);
			} else {
				List<Map<String, Object>> useageMap = reportFunLeaseMinMapper.getHouseBottomInfoForUseage(cityId, param.getMap());
				resultList.addAll(useageMap);
			}
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 数据分析首页-房客源数据
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param param caseType 买卖=101 租赁=102
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustStatusData")
	public ResponseJson getHouseCustStatusData(@Valid @RequestBody BaseMapParam param){
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		Integer cityId = param.getInteger("cityId");
		Integer compId = param.getInteger("compId");
		String caseType = param.getString("caseType");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		String weekTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String monthTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		Map<String, Object> leftMap = new HashMap<>();
		Map<String, Object> rightMap = new HashMap<>();
		Map<String, Object> leftTempMap = null, rightTempMap = null;
		Integer leftCount = null;
		Integer rightCount = null;
		if ("101".equals(caseType)) {// 买卖
			leftTempMap = reportFunSaleMinMapper.getHouseCustStatusData(cityId, compId, weekTime, monthTime,param.getMap());
			rightTempMap = reportFunBuyCustomerMinMapper.getHouseCustStatusData(cityId, compId, weekTime, monthTime,param.getMap());
			leftCount = reportFunSaleMinMapper.countAvailableHouse(cityId, compId,param.getMap());
			rightCount = reportFunBuyCustomerMinMapper.countAvailableHouse(cityId, compId,param.getMap());
		} else {// 租赁
			leftTempMap = reportFunLeaseMinMapper.getHouseCustStatusData(cityId, compId, weekTime, monthTime,param.getMap());
			rightTempMap = reportFunRentCustomerMinMapper.getHouseCustStatusData(cityId, compId, weekTime, monthTime,param.getMap());
			leftCount = reportFunLeaseMinMapper.countAvailableHouse(cityId, compId,param.getMap());
			rightCount = reportFunRentCustomerMinMapper.countAvailableHouse(cityId, compId,param.getMap());
		}
		leftMap.put("houseCount", leftCount);
		rightMap.put("custCount", rightCount);
		if (leftTempMap != null) {
			leftMap.putAll(leftTempMap);
		}
		if (rightTempMap != null) {
			rightMap.putAll(rightTempMap);
		}
		List<Map<String, Object>> resultList = new LinkedList<Map<String, Object>>();
		leftMap.putAll(rightMap);
		resultList.add(leftMap);
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 数据分析首页/房客源存量分析（按区域商圈）-楼盘供需量对比-热点楼盘客户、房源排名|热点商圈客户、房源排名
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param param caseType 买卖=101 租赁=102
	 * @param param serchRange 搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * @param param serchRangeId 搜索范围Id
	 * @param param statusType 数据类型：1=有效数据 2=全部数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBuildSupplyDemandComparison")
	public ResponseJson getBuildSupplyDemandComparison(@Valid @RequestBody BaseMapParam param) {
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		Integer cityId = param.getInteger("cityId");
		String caseType = param.getString("caseType");
		changeSerchRange(param);
		List<Map<String, Object>> leftList = null;
		List<Map<String, Object>> rightList = null;
//		Map<String, Map<String, Object>> leftMap = null;
		if ("101".equals(caseType)) {// 买卖
			// 1.热点楼盘
			// 先根据客源查出热点楼盘和客源数量
			leftList = reportFunCustDemandSplitMapper.getBuildSupplyDemandComparisonForBuy(cityId, param.getMap());
			// 这里查出来的数据里面只有buildId,需要根据id查询楼盘名称，然后将名称通过buildId关联，补上对应的楼盘名称
			// leftMap = leftList.stream().collect(Collectors.toMap(map ->
			// String.valueOf(map.get("buildId")), val -> val));
			if (leftList != null && leftList.size() > 0) {
				Set<Object> buildIds = leftList.stream().collect(Collectors.mapping(map -> map.get("buildId"), Collectors.toSet()));
				param.setObject("buildIds", buildIds);
				// 查询出id对应的name
				List<Map<String, Object>> buildList = erpBuildingInfoMapper.getBuildingName(getOperator().getCityId(),
						param.getMap());
				// 转换为map
				Map<String, Map<String, Object>> buildsMap = buildList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("buildId")), val -> val));
				for (Map<String, Object> dataMap : leftList) {
					Map<String, Object> buildData = buildsMap.get(dataMap.get("buildId").toString());
					if (buildData != null) {
						Object buildName = buildData.get("buildName");
						if (buildName != null) {
							dataMap.put("buildName", buildName);
						}
					}
				}
				if (buildIds != null && buildIds.size() > 0) {
					// 再根据热点楼盘查出房源数量
					List<Map<String, Object>> leftHouseList = reportFunSaleMinMapper.countByBuildIds(cityId,param.getMap());
					if (leftHouseList != null && leftHouseList.size() > 0) {
						// list转成map
						Map<Object, Map<String, Object>> buildMap = leftHouseList.stream().collect(Collectors.toMap(map -> map.get("buildId"), val -> val));
						// 组装数据
						for (Map<String, Object> map : leftList) {
							Map<String, Object> mapTemp = buildMap.get(map.get("buildId"));
							if (mapTemp != null) {
								map.put("buildHouseCount", mapTemp.get("buildHouseCount"));
							}
						}
					}
				}
			}
			// 2.热点商圈
			// 先根据客源查出热点商圈和客源数量
			//sectionCustCount
			rightList = reportFunSaleMinMapper.countBySectionIds(cityId,param.getMap());
			//rightList = erpFunCustRegsectionsMapper.getBuildSupplyDemandComparisonForBuy(cityId, param.getMap());
			if (rightList != null && rightList.size() > 0) {
				Set<Object> sectionIds = rightList.stream().collect(Collectors.mapping(map -> map.get("sectionId"), Collectors.toSet()));
				if (sectionIds != null && sectionIds.size() > 0) {
					param.setObject("sectionIds", sectionIds);
					// 再根据热点商圈查出房源数量
					List<Map<String, Object>> rightHouseList = reportFunBuyCustomerMinMapper.getBuildSupplyDemandComparisonForBuy(cityId, param.getMap());
					if (rightHouseList != null) {
						// list转成map
						Map<String, Map<String, Object>> sectionMap = BeanUtil.listMapObjecttoMap(rightHouseList, "sectionId");
								//rightHouseList.stream().collect(Collectors.toMap(map -> map.get("sectionId"), val -> val));
						// 组装数据
						for (Map<String, Object> map : rightList) {
							Map<String, Object> mapTemp = sectionMap.get(String.valueOf(map.get("sectionId")));
							if (mapTemp != null) {
								map.put("sectionCustCount", mapTemp.get("sectionCustCount"));
							}
						}
					}
				}
			}
		} else {// 租赁
			// 1.热点楼盘
			// 先根据客源查出热点楼盘和客源数量
			leftList = reportFunCustDemandSplitMapper.getBuildSupplyDemandComparisonForRent(cityId, param.getMap());
			if (leftList != null && leftList.size() > 0) {
				Set<Object> buildIds = leftList.stream().collect(Collectors.mapping(map -> map.get("buildId"), Collectors.toSet()));
				if (buildIds != null && buildIds.size() > 0) {
					param.setObject("buildIds", buildIds);
					// 查询出id对应的name
					List<Map<String, Object>> buildList = erpBuildingInfoMapper.getBuildingName(getOperator().getCityId(), param.getMap());
					// 转换为map
					Map<String, Map<String, Object>> buildsMap = buildList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("buildId")), val -> val));
					for (Map<String, Object> dataMap : leftList) {
						Map<String, Object> buildData = buildsMap.get(dataMap.get("buildId").toString());
						if (buildData != null) {
							Object buildName = buildData.get("buildName");
							if (buildName != null) {
								dataMap.put("buildName", buildName);
							}
						}
					}
					// 再根据热点楼盘查出房源数量
					List<Map<String, Object>> leftHouseList = reportFunLeaseMinMapper.countByBuildIds(cityId,param.getMap());
					if (leftHouseList != null) {
						// list转成map
						Map<Object, Map<String, Object>> buildMap = leftHouseList.stream().collect(Collectors.toMap(map -> map.get("buildId"), val -> val));
						// 组装数据
						for (Map<String, Object> map : leftList) {
							Map<String, Object> mapTemp = buildMap.get(map.get("buildId"));
							if (mapTemp != null) {
								map.put("buildHouseCount", mapTemp.get("buildHouseCount"));
							}
						}
					}
				}
			}
			// 2.热点商圈
			// 先根据客源查出热点商圈和客源数量
			rightList = reportFunLeaseMinMapper.countBySectionIds(cityId,param.getMap());
			//rightList = erpFunCustRegsectionsMapper.getBuildSupplyDemandComparisonForRent(cityId, param.getMap());
			if (rightList != null) {
				Set<Object> sectionIds = rightList.stream().collect(Collectors.mapping(map -> map.get("sectionId"), Collectors.toSet()));
				if (sectionIds != null && sectionIds.size() > 0) {
					param.setObject("sectionIds", sectionIds);
					// 再根据热点商圈查出房源数量
					List<Map<String, Object>> rightHouseList = reportFunRentCustomerMinMapper.getBuildSupplyDemandComparisonForRent(cityId, param.getMap());
					if (rightHouseList != null) {
						// list转成map
						Map<String, Map<String, Object>> sectionMap =  BeanUtil.listMapObjecttoMap(rightHouseList, "sectionId");
						// 组装数据
						for (Map<String, Object> map : rightList) {
							Map<String, Object> mapTemp = sectionMap.get(String.valueOf(map.get("sectionId")));
							if (mapTemp != null) {
								map.put("sectionCustCount", mapTemp.get("sectionCustCount"));
							}
						}
					}
				}
			}
		}
		// 排序暂时去掉
		/*
		 * leftList.sort((val1, val2) -> { Integer key1 =
		 * StringUtil.parseInteger(val1.get("buildCustCount"), 0); Integer key2
		 * = StringUtil.parseInteger(val2.get("buildCustCount"), 0); return
		 * key1.compareTo(key2); }); rightList.sort((val1, val2) -> { Integer
		 * key1 = StringUtil.parseInteger(val1.get("sectionCustCount"), 0);
		 * Integer key2 = StringUtil.parseInteger(val2.get("sectionCustCount"),
		 * 0); return key2.compareTo(key1); });
		 */
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("build", leftList);
		resultMap.put("section", rightList);
		List<Map<String, Object>> endList = new LinkedList<Map<String, Object>>();
		endList.add(resultMap);
		return ErpResponseJson.ok(endList);
	}
	
	/**
	 * 数据分析首页-房价购买力分析
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param param  caseType  买卖=101 租赁=102
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHouseBuyingPowerData")
	public ResponseJson getHouseBuyingPowerData(@Valid @RequestBody BaseMapParam param){
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		Integer cityId = param.getInteger("cityId");
		Integer compId = param.getInteger("compId");
		String caseType = param.getString("caseType");
		boolean isSaleBuy = "101".equals(caseType);// 买卖 =101 租赁 ！=101
		boolean isLeaseRent = "102".equals(caseType);// 买卖 =101 租赁 ！=101
		String casePriceLeaseRent = isLeaseRent ? " HOUSE_PRICE_HIGH*10000 " : " HOUSE_PRICE_HIGH ";
		String casePriceSaleBuy = isSaleBuy ? " SALE_TOTAL_PRICE*10000 " : " LEASE_TOTAL_PRICE ";
		List<Map<String, Object>> resultList = new LinkedList<Map<String, Object>>();
		List<Map<String, Object>> saleLeaseList = new LinkedList<Map<String, Object>>();
		AdminFunCity adminFunCity = adminFunCityService.getCity(cityId);
		String priceUnit = isSaleBuy ? adminFunCity.getStatisticsPriceSaleOption() : adminFunCity.getStatisticsPriceLeaseOption();
		if (StringUtils.isBlank(priceUnit)) {
			throw new BusinessException("该城市价格分段未配置！");
		}
		String caseWhenSqlLeaseRent = DataAnalysisUtil.getCaseWhenSql(priceUnit, casePriceLeaseRent);
		String caseWhenSqlSaleBuy = DataAnalysisUtil.getCaseWhenSql(priceUnit, casePriceSaleBuy);
		if ("101".equals(caseType)) {// 买卖
			resultList = reportFunBuyCustomerMinMapper.getHouseBuyingPowerData(cityId, compId, caseWhenSqlLeaseRent, param.getMap());
			saleLeaseList = reportFunSaleMinMapper.getHouseBuyingPowerData(cityId, compId, caseWhenSqlSaleBuy, param.getMap());
			setResultList(resultList,saleLeaseList);
		} else {// 租赁
			resultList = reportFunRentCustomerMinMapper.getHouseBuyingPowerData(cityId, compId, caseWhenSqlLeaseRent, param.getMap());
			saleLeaseList = reportFunLeaseMinMapper.getHouseBuyingPowerData(cityId, compId, caseWhenSqlSaleBuy, param.getMap());
			setResultList(resultList,saleLeaseList);
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 将resultList扩展
	 * @author 臧铁
	 * @since 2017年8月2日
	 * @param resultList  原来  price  cust   通过price拼接  变成  price cust  house 
	 * @param saleLeaseList  原来    price  house 
	 */
	private void setResultList(List<Map<String, Object>> resultList, List<Map<String, Object>> saleLeaseList) {
		if (resultList != null && saleLeaseList != null) {
			Map<Object, Map<String, Object>> resultMap = saleLeaseList.stream().collect(Collectors.toMap(map -> map.get("price"), val -> val));
			// 组装数据
			for (Map<String, Object> map : resultList) {
				Map<String, Object> mapTemp = resultMap.get(map.get("price"));
				if (mapTemp != null) {
					map.put("house", mapTemp.get("house"));
				}
			}
		}
	}

	/**
	 * 房客源新增分析-房客源新增总量(图表)
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @param param  caseType 买卖=101 租赁=102  endTime结束时间     startTime开始时间
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustAddTotalData")
	public ResponseJson getHouseCustAddTotalData(@Valid @RequestBody BaseMapParam param) {
		List<Map<String, Object>> resultList = getHouseCustAddTotalDataIndext(param);
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 房客源新增分析-房客源新增总量
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @param param  caseType 买卖=101 租赁=102   endTime结束时间     startTime开始时间
	 * @param param serchRange 搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * @param param serchRangeId 搜索范围Id
	 * @return
	 */
	private List<Map<String, Object>> getHouseCustAddTotalDataIndext(BaseMapParam param) {
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		Integer cityId = param.getInteger("cityId");
		String regionId = param.getString("regionId");
		String sectionIds = param.getString("sectionIds");// 默认行政区 -- 维度
		String caseType = param.getString("caseType");
		boolean isSale = "101".equals(caseType);
		param.setString("houseTableName", isSale ? "FUN_SALE_MIN" : "FUN_LEASE_MIN");
		param.setString("custTableName", isSale ? "FUN_BUY_CUSTOMER_MIN" : "FUN_RENT_CUSTOMER_MIN");
		param.setString("caseReg", isSale ? "SALE_REG" : "LEASE_REG");
		param.setString("custId", isSale ? "BUY_CUST_ID" : "RENT_CUST_ID");
		param.setString("houseCaseType", isSale ? "1" : "2");
		param.setString("custCaseType", isSale ? "3" : "4");
		if (StringUtils.isNotBlank(sectionIds)) {
			param.setObject("sectionIdsArr", sectionIds.split(","));
			param.setString("sourceType", "1");
		}
		if (StringUtils.isNotBlank(regionId)) {
			param.setObject("regionIdsArr", regionId.split(","));// 默认行政区 -- 维度
			param.setString("sourceType", "2");
		}
		// 55
		// 判断当前时间是否是月类型 0=日 1=周 2=月 FUN_CUST_DEMAND_SPLIT
		if ("2".equals(param.getString("dateCountType"))) {
			String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else {
			param.setString("endTime", param.getString("endTime") + " 23:59:59");
		}
		changeSerchRange(param);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> houseMap = reportFunStatisticTotleMapper.getHouseAddTotalData(cityId, param.getMap());
		if (houseMap != null) {
			dataList.add(houseMap);
		}
		Map<String, Object> custMap = reportFunStatisticTotleMapper.getCustAddTotalData(cityId, param.getMap());
		if (custMap != null) {
			dataList.add(custMap);
		}
		return dataList;
	}

	/**
	 * 房客源新增分析-房客源新增量排名(图表)
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @param param  caseType 买卖=101 租赁=102   endTime结束时间     startTime开始时间   order1=员工排名 2=门店排名
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustAddRank")
	public ResponseJson getHouseCustAddRank(@Valid @RequestBody BaseMapParam param) {
		List<Map<String, Object>> resultList = getHouseCustAddRankIndex(param);
		return new ErpResponseJson(resultList);
	}

	/**
	 * 房客源新增分析-房客源新增量排名
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @param param  caseType 买卖=101 租赁=102   endTime结束时间     startTime开始时间   order1=员工排名 2=门店排名
	 * @param param serchRange 搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * @param param serchRangeId 搜索范围Id
	 * @return
	 */
	private List<Map<String, Object>> getHouseCustAddRankIndex(BaseMapParam param) {
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String regionId = param.getString("regionId");
		String sectionIds = param.getString("sectionIds");// 默认行政区 -- 维度
		String caseType = param.getString("caseType");
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		boolean isSale = "101".equals(caseType);
		param.setString("houseTableName", isSale ? "FUN_SALE_MIN" : "FUN_LEASE_MIN");
		param.setString("custTableName", isSale ? "FUN_BUY_CUSTOMER_MIN" : "FUN_RENT_CUSTOMER_MIN");
		param.setString("caseReg", isSale ? "SALE_REG" : "LEASE_REG");
		param.setString("custId", isSale ? "BUY_CUST_ID" : "RENT_CUST_ID");
		param.setString("houseId", isSale ? "SALE_ID" : "LEASE_ID");
		param.setString("houseCaseType", isSale ? "1" : "2");
		param.setString("custCaseType", isSale ? "3" : "4");
		if (StringUtils.isNotBlank(sectionIds)) {
			param.setObject("sectionIdsArr", sectionIds.split(","));
			param.setString("sourceType", "1");
		}
		if (StringUtils.isNotBlank(regionId)) {
			param.setObject("regionIdsArr", regionId.split(","));// 默认行政区 -- 维度
			param.setString("sourceType", "2");
		}
		// 判断当前时间是否是月类型 0=日 1=周 2=月 FUN_CUST_DEMAND_SPLIT
		if ("2".equals(param.getString("dateCountType"))) {
			String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else {
			param.setString("endTime", param.getString("endTime") + " 23:59:59");
		}
		changeSerchRange(param);
		List<Map<String, Object>> resultList = reportFunStatisticTotleMapper.getHouseCustAddRank(getOperator().getCityId(), param.getMap());
		return resultList;
	}
}