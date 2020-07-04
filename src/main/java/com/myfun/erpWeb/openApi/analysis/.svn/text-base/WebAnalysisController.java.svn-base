package com.myfun.erpWeb.openApi.analysis;

import com.myfun.erpWeb.openApi.analysis.param.AnalysisForWebParam;
import com.myfun.erpWeb.openApi.analysis.vo.*;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminCrmDeptsMapMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.po.AdminCrmDeptsMap;
import com.myfun.repository.admindb.po.AdminCrmDeptsMapExample;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunDeptsExample;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.erpdb.po.ErpFunSaleExample;
import com.myfun.repository.reportdb.dao.ReportFunBuyCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunLeaseMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunRentCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunSaleMinMapper;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateTimeHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "网站部-好房在线统计")
@RestController
@RequestMapping(value = "/web/analysis")
public class WebAnalysisController extends BaseController {
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ReportFunSaleMinMapper reportFunSaleMinMapper;
	@Autowired
	ReportFunLeaseMinMapper reportFunLeaseMinMapper;
	@Autowired
	ReportFunBuyCustomerMinMapper reportFunBuyCustomerMinMapper;
	@Autowired
	ReportFunRentCustomerMinMapper reportFunRentCustomerMinMapper;
	@Autowired
	AdminCrmDeptsMapMapper adminCrmDeptsMapMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;

	@ApiOperation("成交统计,需求=8527，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealAnalysisForWebResultDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getDealAnalysisForWeb")
	public ResponseJson getDealAnalysisForWeb(@RequestBody AnalysisForWebParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		String startTime = param.getStartTime();
		String endTime = param.getEndTime();
		DealAnalysisForWebResultDto resultDto = new DealAnalysisForWebResultDto();
		if (StringUtils.isNotBlank(startTime)) {
			param.setStartTime(startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setEndTime(endTime + " 23:59:59");
		}
		List<Map<String, Object>> saleCountMapList = erpFunDealMapper.countSaleDeal(operator.getCityId(), param);
		List<Map<String, Object>> leaseCountMapList = erpFunDealMapper.countLeaseDeal(operator.getCityId(), param);
		DataAnalysisUtil.repairDateForListMap(saleCountMapList, new HashMap<>(), startTime, endTime, param.getDateCountType());
		DataAnalysisUtil.repairDateForListMap(leaseCountMapList, new HashMap<>(), startTime, endTime, param.getDateCountType());
		List<DealAnalysisForWebDto> sale = new ArrayList<>();
		saleCountMapList.forEach(map -> {
			DealAnalysisForWebDto saleDto = new DealAnalysisForWebDto();
			saleDto.setDate((String) map.get("date"));
			Object data = map.get("data");
			data = data == null ? 0 : data;
			saleDto.setData((Integer) data);
			sale.add(saleDto);
		});
		resultDto.setSale(sale);
		List<DealAnalysisForWebDto> lease = new ArrayList<>();
		leaseCountMapList.forEach(map -> {
			DealAnalysisForWebDto leaseDto = new DealAnalysisForWebDto();
			leaseDto.setDate((String) map.get("date"));
			Object data = map.get("data");
			data = data == null ? 0 : data;
			leaseDto.setData((Integer) data);
			lease.add(leaseDto);
		});
		resultDto.setLease(lease);
		return ErpResponseJson.ok(resultDto);
	}

	@ApiOperation("区域租售房源统计,需求=8527，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = RegHouseCountDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getRegHouseCount")
	public ResponseJson getRegHouseCount(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setCompId(operator.getCompId());
		erpFunDepts.setShardCityId(operator.getCityId());
		List<RegHouseCountDto> regHouseCountDtoList = erpFunDeptsMapper.getDeptAndPositionList(erpFunDepts);
		List<String> deptNoList = regHouseCountDtoList.stream().collect(Collectors.mapping(dto -> dto.getDeptNo(), Collectors.toList()));
		Map<String, AdminFunDepts> adminFunDeptsMap = new HashMap<>();
		Map<Integer, AdminCrmDeptsMap> adminCrmDeptsMapMap = new HashMap<>();
		//获取门店定位的信息
		if (deptNoList != null && !deptNoList.isEmpty()) {
			AdminFunDeptsExample adminFunDeptsExample = new AdminFunDeptsExample();
			adminFunDeptsExample.createCriteria().andCompNoEqualTo(operator.getCompNo()).andDeptNoIn(deptNoList);
			List<AdminFunDepts> adminFunDepts = adminFunDeptsMapper.selectByExample(adminFunDeptsExample);
			adminFunDeptsMap = adminFunDepts.stream().collect(Collectors.toMap(dept -> dept.getDeptNo(), dept -> dept));
			List<Integer> adminDeptIds = adminFunDepts.stream().collect(Collectors.mapping(dept -> dept.getDeptId(), Collectors.toList()));
			if (adminDeptIds.size() > 0) {
				AdminCrmDeptsMapExample adminCrmDeptsMapExample = new AdminCrmDeptsMapExample();
				adminCrmDeptsMapExample.createCriteria().andDeptIdIn(adminDeptIds);
				List<AdminCrmDeptsMap> adminCrmDeptsMaps = adminCrmDeptsMapMapper.selectByExample(adminCrmDeptsMapExample);
				adminCrmDeptsMapMap = adminCrmDeptsMaps.stream().collect(Collectors.toMap(crmDept -> crmDept.getDeptId(), crmDept -> crmDept));
			}
		}
		List<Map<String, Object>> saleCountMapList = erpFunSaleMapper.getSaleCountGoupByDept(cityId, compId);
		Map<Integer, Map<String, Object>> saleDeptMap = saleCountMapList.stream().collect(Collectors.toMap(map -> (Integer) map.get("deptId"), map -> map));
		List<Map<String, Object>> leaseCountMapList = erpFunLeaseMapper.getLeaseCountGoupByDept(cityId, compId);
		Map<Integer, Map<String, Object>> leaseDeptMap = leaseCountMapList.stream().collect(Collectors.toMap(map -> (Integer) map.get("deptId"), map -> map));
		for (RegHouseCountDto houseCountDto :regHouseCountDtoList){
			houseCountDto.setSaleCount(0);
			houseCountDto.setLeaseCount(0);
			Integer deptId = houseCountDto.getDeptId();
			Map<String, Object> saleMap = saleDeptMap.get(deptId);
			if (saleMap != null) {
				houseCountDto.setSaleCount((Integer) saleMap.get("data"));
			}
			Map<String, Object> leaseMap = leaseDeptMap.get(deptId);
			if (leaseMap != null) {
				houseCountDto.setLeaseCount((Integer) leaseMap.get("data"));
			}
			AdminFunDepts adminFunDepts = adminFunDeptsMap.get(houseCountDto.getDeptNo());
			if (adminFunDepts != null) {
				AdminCrmDeptsMap adminCrmDeptsMap = adminCrmDeptsMapMap.get(adminFunDepts.getDeptId());
				if (adminCrmDeptsMap != null) {
					houseCountDto.setRegPositionX(adminCrmDeptsMap.getPositionX());
					houseCountDto.setRegPositionY(adminCrmDeptsMap.getPositionY());
				}
			}
		}
		return ErpResponseJson.ok(regHouseCountDtoList);
	}

	@ApiOperation("获取公司房源总量,需求=8527，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = CompHouseTotalDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getCompHouseTotal")
	public ResponseJson getCompHouseTotal(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		//房源状态包括 有效，封盘，暂缓，预定
		ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
		funSaleExample.setShardCityId(cityId);
		funSaleExample.createCriteria().andCompIdEqualTo(compId).andSaleStatusLessThanOrEqualTo((byte) 4);
		int saleCount = erpFunSaleMapper.countByExample(funSaleExample);
		ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
		funLeaseExample.setShardCityId(cityId);
		funLeaseExample.createCriteria().andCompIdEqualTo(compId).andLeaseStatusLessThanOrEqualTo(4);
		int leaseCount = erpFunLeaseMapper.countByExample(funLeaseExample);

		CompHouseTotalDto result = new CompHouseTotalDto();
		result.setSaleCount(saleCount);
		result.setLeaseCount(leaseCount);
		return ErpResponseJson.ok(result);
	}

	@ApiOperation("统计公司房源昨日和今日新增量,需求=8527，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = CompHouseNewCountDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getCompNewHouseCount")
	public ResponseJson getCompNewHouseCount(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Date startTime = getBeforeDateByDay(1);
		List<Map<String, Object>> saleMapList = erpFunSaleMapper.getCompSaleAddCountByDate(cityId, compId, startTime);
		List<Map<String, Object>> leaseMapList = erpFunLeaseMapper.getCompLeaseAddCountByDate(cityId, compId, startTime);
		String yesterdayKey = DateTimeHelper.formatDateTimetoString(startTime, DateTimeHelper.FMT_yyyyMMdd);
		String todayKey = DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMdd);
		CompHouseNewCountDto result = new CompHouseNewCountDto();
		saleMapList.forEach(map -> {
			String date = (String) map.get("date");
			if (yesterdayKey.equals(date)) {
				result.setSaleYesterdayCount((Integer) map.get("data"));
			} else if (todayKey.equals(date)) {
				result.setSaleTotayCount((Integer) map.get("data"));
			}
		});
		leaseMapList.forEach(map -> {
			String date = (String) map.get("date");
			if (yesterdayKey.equals(date)) {
				result.setLeaseYesterdayCount((Integer) map.get("data"));
			} else if (todayKey.equals(date)) {
				result.setLeaseTotayCount((Integer) map.get("data"));
			}
		});
		return ErpResponseJson.ok(result);
	}

	@ApiOperation("公司房客源统计,需求=8527，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = HouseCustNewCountDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getHouseCustAnalysisForWeb")
	public ResponseJson getHouseCustAnalysisForWeb(@RequestBody AnalysisForWebParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		param.setCityId(operator.getCityId());
		String startTime = param.getStartTime();
		String endTime = param.getEndTime();
		HouseCustNewCountDto resultDto = new HouseCustNewCountDto();
		if (StringUtils.isNotBlank(startTime)) {
			param.setStartTime(startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setEndTime(endTime + " 23:59:59");
		}
		List<Map<String, Object>> saleCountMapList = reportFunSaleMinMapper.getCompSaleCountByDate(param);
		DataAnalysisUtil.repairDateForListMap(saleCountMapList, new HashMap<>(), startTime, endTime, param.getDateCountType());
		Map<String, Map<String, Object>> saleCountMap = saleCountMapList.stream().collect(Collectors.toMap(map -> (String) map.get("date"), map -> map));
		List<Map<String, Object>> leaseCountMapList = reportFunLeaseMinMapper.getCompLeaseCountByDate(param);
		DataAnalysisUtil.repairDateForListMap(leaseCountMapList, new HashMap<>(), startTime, endTime, param.getDateCountType());
		Map<String, Map<String, Object>> leaseCountMap = leaseCountMapList.stream().collect(Collectors.toMap(map -> (String) map.get("date"), map -> map));
		List<Map<String, Object>> buyCustomerCountMapList = reportFunBuyCustomerMinMapper.getCompBuyCustomerCountByDate(param);
		DataAnalysisUtil.repairDateForListMap(buyCustomerCountMapList, new HashMap<>(), startTime, endTime, param.getDateCountType());
		Map<String, Map<String, Object>> buyCustomerCountMap = buyCustomerCountMapList.stream().collect(Collectors.toMap(map -> (String) map.get("date"), map -> map));
		List<Map<String, Object>> rentCustomerCountMapList = reportFunRentCustomerMinMapper.getCompRentCustomerCountByDate(param);
		DataAnalysisUtil.repairDateForListMap(rentCustomerCountMapList, new HashMap<>(), startTime, endTime, param.getDateCountType());
		Map<String, Map<String, Object>> rentCustomerCountMap = rentCustomerCountMapList.stream().collect(Collectors.toMap(map -> (String) map.get("date"), map -> map));

		Set<String> dateSet = saleCountMap.keySet();
		List<String> dateList = new ArrayList<>(dateSet);
		dateList.sort((s1, s2) -> {
			return s1.compareTo(s2);
		});
		List<DealAnalysisForWebDto> houseCount = new ArrayList<>();
		List<DealAnalysisForWebDto> custCount = new ArrayList<>();
		dateList.forEach(date -> {
			DealAnalysisForWebDto houseDto = new DealAnalysisForWebDto();
			DealAnalysisForWebDto custDto = new DealAnalysisForWebDto();
			houseDto.setDate(date);
			custDto.setDate(date);
			Integer houseData = 0;
			Integer custData = 0;
			Map<String, Object> saleMap = saleCountMap.get(date);
			if (saleMap != null) {
				Object data = saleMap.get("data");
				houseData += data == null ? 0 : (Integer) data;
			}
			Map<String, Object> leaseMap = leaseCountMap.get(date);
			if (leaseMap != null) {
				Object data = leaseMap.get("data");
				houseData += data == null ? 0 : (Integer) data;
			}
			Map<String, Object> buyCustomerMap = buyCustomerCountMap.get(date);
			if (buyCustomerMap != null) {
				Object data = buyCustomerMap.get("data");
				custData += data == null ? 0 : (Integer) data;
			}
			Map<String, Object> rentCustomerMap = rentCustomerCountMap.get(date);
			if (rentCustomerMap != null) {
				Object data = rentCustomerMap.get("data");
				custData += data == null ? 0 : (Integer) data;
			}
			houseDto.setData(houseData);
			custDto.setData(custData);
			houseCount.add(houseDto);
			custCount.add(custDto);
		});
		resultDto.setCustCount(custCount);
		resultDto.setHouseCount(houseCount);
		return ErpResponseJson.ok(resultDto);
	}

	private Date getBeforeDateByDay(Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = calendar.getTime();
		return date;
	}
}
