package com.myfun.erpWeb.statisticalAnalysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateUtil;
/**
 * 成交周期统计接口控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/statisticalAnalysis/dealAnalysis")
public class DealCountAnalysisController  extends BaseController{
	@Autowired ErpFunDealMapper erpFunDealMapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	
	/**
	 * 查询房源成交分布情况等
	 * @param serchRange:查询范围 serchRangeId:查询范围id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDealHouseDistributionSituation")
	public ResponseJson getDealHouseDistributionSituation(@RequestBody BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		//判断时间是否为空
		if (StringUtils.isBlank(param.getString("startTime"))) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		}
	
		if ("USER".equals(param.getString("serchRange"))) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		//查询数据
		List<Map<String,Object>> topFourList = erpFunDealMapper.getDealHouseDistributionSituationOffTopFour(getOperator().getCityId(), param.getMap());
		if (topFourList!=null && !topFourList.isEmpty()) {
			Integer fourAreaTotal = 0;
			for (Map<String, Object> dataMap : topFourList) {
				fourAreaTotal+=Integer.valueOf(dataMap.get("houseCount").toString());
			}
			//查询总的数据
			Map<String,Object> totalData = erpFunDealMapper.getDealHouseDistributionSituationOffTotal(getOperator().getCityId(), param.getMap());
			if(Integer.valueOf(totalData.get("totalCount").toString())-fourAreaTotal>0){
				Map<String,Object> otherAreaData = new HashMap<String, Object>();
				otherAreaData.put("regName", "其他");
				otherAreaData.put("houseCount", Integer.valueOf(totalData.get("totalCount").toString())-fourAreaTotal);
				topFourList.add(otherAreaData);
			}
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(topFourList);
		return responseJson;
	}
	
	/**
	 * 门店周期最短排名情况
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTransactionCycleDeptRank")
	public ResponseJson getTransactionCycleDeptRank(@RequestBody BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		// 判断前端是否传了时间段，如果没有传时间段，那么后台按本月来计算
		if (StringUtils.isBlank(param.getString("startTime"))) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else {
			String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		}
	
		if ("USER".equals(param.getString("serchRange"))) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		// 查询数据
		List<Map<String, Object>> deptCycleRankList = erpFunDealMapper.getTransactionCycleDeptRank(getOperator().getCityId(), param.getMap());
		//如果有数据才去组装门店名称
		if (deptCycleRankList == null || deptCycleRankList.isEmpty()) {
			return ErpResponseJson.ok(deptCycleRankList);
		}
		Set<Integer> deptIds = BeanUtilsHelper.buildQueryKeysOffListMap(deptCycleRankList, "deptId");
		List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(getOperator().getCityId(), deptIds);
		Map<String, ErpFunDepts> deptMap = BeanUtilsHelper.listToMapObject(deptList, "deptId");
		//组装门店名称
		for (Map<String, Object> dataMap : deptCycleRankList) {
			ErpFunDepts erpFunDepts = deptMap.get(String.valueOf(dataMap.get("deptId")));
			if (erpFunDepts != null) {
				dataMap.put("deptName", erpFunDepts.getDeptCname());
			}
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(deptCycleRankList);
		return responseJson;
	}
	
}
