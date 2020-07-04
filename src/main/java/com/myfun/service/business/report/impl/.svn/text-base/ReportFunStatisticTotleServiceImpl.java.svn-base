package com.myfun.service.business.report.impl;

import javax.annotation.PostConstruct;

import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.reportdb.po.ReportFunStatisticTotle;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.report.ReportFunStatisticTotleService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportFunStatisticTotleServiceImpl extends AbstractService<ReportFunStatisticTotle, Long> implements ReportFunStatisticTotleService {
	@Autowired
	private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = reportFunStatisticTotleMapper;
	}

	@Override
	public void addWorkCount(ReportFunStatisticTotle reportFunStatisticTotle) {
		reportFunStatisticTotleMapper.addWorkCount(reportFunStatisticTotle);
	}


	/**
	 * @author 邓永洪
	 * @tag 获取门店/员工房客源新增排名和本门店/本人新增数量
	 * @since 2018/4/11
	 */
	@Override
	public Map<String, Object> getHouseCustRanking(Integer cityId, Map<String, Object> param) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String dateTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		param.put("dateTime", dateTime);
		Map<String, Object> houseParam = param;
		houseParam.put("caseType1", Constants_DIC.DIC_CASE_TYPE_SALE_FUN);
		houseParam.put("caseType2", Constants_DIC.DIC_CASE_TYPE_LEASE_FUN);
		List<Map<String, Object>> houseList = reportFunStatisticTotleMapper.getModelDataList(cityId, houseParam);
		Map<String, Object> custParam = param;
		custParam.put("caseType1", Constants_DIC.DIC_CASE_TYPE_BUY_CUST);
		custParam.put("caseType2", Constants_DIC.DIC_CASE_TYPE_RENT_CUST);
		List<Map<String, Object>> custList = reportFunStatisticTotleMapper.getModelDataList(cityId, param);
		List<Object> houseUser = houseList.stream().map(val -> val.get(param.get("range").toString().split(" ")[1])).collect(Collectors.toList());
		List<Object> custUser = custList.stream().map(val -> val.get(param.get("range").toString().split(" ")[1])).collect(Collectors.toList());
		List<Map<String, Object>> houseDataList = new LinkedList<>();
		List<Map<String, Object>> custDataList = new LinkedList<>();
		if (null != houseUser && houseUser.size() > 0) {
			// 从数据库获取房源新增数据
			houseParam.put("rangeIds", houseUser);
			houseParam.put("caseType1", Constants_DIC.DIC_CASE_TYPE_SALE_FUN);
			houseParam.put("caseType2", Constants_DIC.DIC_CASE_TYPE_LEASE_FUN);
			houseDataList = reportFunStatisticTotleMapper.getAddDataList(cityId, houseParam);
		}
		if (null != custUser && custUser.size() > 0) {
			// 从数据库获取客源新增数据
			houseParam.put("rangeIds", custUser);
			custParam.put("caseType1", Constants_DIC.DIC_CASE_TYPE_BUY_CUST);
			custParam.put("caseType2", Constants_DIC.DIC_CASE_TYPE_RENT_CUST);
			custDataList = reportFunStatisticTotleMapper.getAddDataList(cityId, custParam);
		}
		//房源数据处理
		List<Map<String, String>> resultCustList = houseCustDataHanle(houseDataList, param.get("range").toString().split(" ")[1]);
		//客源数据处理
		List<Map<String, String>> resultHouseList = houseCustDataHanle(custDataList, param.get("range").toString().split(" ")[1]);
		// 查询当前用户的房客源新增数量
		List<Map<String, Object>> myHouseCustList = reportFunStatisticTotleMapper.getCurrentUserDataList(cityId, (Integer) param.get("compId"), dateTime, (String) param.get("realRange"), param.get("rangeId").toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("houseList", resultHouseList);
		resultMap.put("custList", resultCustList);
		resultMap.put("myCount", myHouseCustList);
		return resultMap;
	}


	/**
	 * @author 邓永洪
	 * @tag 房客源数据处理
	 * @since 2018/4/12
	 */
	private List<Map<String, String>> houseCustDataHanle(List<Map<String, Object>> DataList, String groupBy) {

		List<Map<String, String>> resultHouseList = null;
		if (!DataList.isEmpty()) {
			Map<String, Map<String, String>> resultHouseMap = new HashMap<String, Map<String, String>>();
			for (Map<String, Object> houseMap : DataList) {
				String djCount = houseMap.get("djCount").toString();
				if (!"0".equals(djCount) && !"".equals(djCount)) {
					String key = houseMap.get(groupBy).toString();
					Map<String, String> map = resultHouseMap.get(key);
					if (map == null) {
						map = new HashMap<String, String>();
						resultHouseMap.put(key, map);
					}
					map.put(groupBy, key);
					map.put("caseType" + houseMap.get("caseType"), (houseMap.get("djCount")).toString());
					int totleCount = StringUtil.paseInteger(map.get("caseType" + Constants_DIC.DIC_CASE_TYPE_SALE_FUN), 0) + StringUtil.paseInteger(map.get("caseType" + Constants_DIC.DIC_CASE_TYPE_LEASE_FUN), 0);
					map.put("totalCount", String.valueOf(totleCount));
				}
			}
			// 数据排序
			resultHouseList = new ArrayList<Map<String, String>>(resultHouseMap.values());
			Collections.sort(resultHouseList, new Comparator<Map<String, String>>() {
				@Override
				public int compare(Map<String, String> o1, Map<String, String> o2) {
					int id1 = StringUtil.paseInteger(o1.get("totalCount"), 0);
					int id2 = StringUtil.paseInteger(o2.get("totalCount"), 0);
					return id2 - id1;
				}
			});
		}
		return resultHouseList;
	}

}