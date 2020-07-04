package com.myfun.erpWeb.businesstools.renovation;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.erpWeb.statisticalAnalysis.DataAnalysisController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerMapper;
import com.myfun.repository.erpdb.po.ErpRenovationCustomer;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateUtil;

/**
 * 装修客户统计
 * @author 张宏利
 * @since 2018年2月26日
 */
@RestController
@RequestMapping("/renovation")
public class RenovationStatisticController extends BaseController{

	@Autowired ErpRenovationCustomerMapper erpRenovationCustomerMapper;
	@Autowired AdminFunCityMapper adminFunCityMapper;
	
	/**
	 * 获取装修客户统计
	 * @author 张宏利
	 * @since 2018年2月26日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getRenovationStatistic")
	public ResponseJson getRenovationStatistic(@RequestBody BaseMapParam param) {
		// 门店范围，维度（按员工、按楼盘）、统计类型（状态、来源、面积、进度）、时间（今日、本周、本月、上月、半年、全部、自定义）
		Operator operator = getOperator();
		param.setInteger("compId", operator.getCompId());
		DataAnalysisController.changeSerchRange(param);
		String serchRange = param.getString("serchRange");
		Integer serchRangeId = param.getInteger("serchRangeId");
		String dimension = param.getString("dimension");// 维度
		String dateType = param.getString("dateType");// 日期类型，今日、本周、本月、上月、半年
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		Integer statisticType = param.getInteger("statisticType");
		if(StringUtils.isNotBlank(dateType)) {
			String[] date = DateUtil.getConditionDate(dateType);
			startTime = date[0];
			endTime = date[1];
		}
		// 面积分段
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(getOperator().getCityId().shortValue());
		String houseAreaSql = DataAnalysisUtil.getCaseWhenSumSql(adminFunCity.getStatisticsAreaSaleOption(), "HOUSE_AREA");
		// 数据统计
		List<ErpRenovationCustomer> customerStatisticList = erpRenovationCustomerMapper.getRenovationStatistic(
				operator.getCityId(), operator.getCompId(), serchRange, serchRangeId, dimension, startTime, endTime,
				statisticType, houseAreaSql);
		return ErpResponseJson.ok(customerStatisticList);
	}
}


