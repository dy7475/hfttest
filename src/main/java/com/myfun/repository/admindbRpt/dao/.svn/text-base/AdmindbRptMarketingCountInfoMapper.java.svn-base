package com.myfun.repository.admindbRpt.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.admindbRpt.dto.AdmindbRptMarketingCountInfoDto;
import com.myfun.repository.admindbRpt.po.AdmindbRptMarketingCountInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateUtil;

public interface AdmindbRptMarketingCountInfoMapper extends BaseMapper<AdmindbRptMarketingCountInfo, Integer> {
	
	public Map<String, Object>  getCurrentWeekXqzjCount(@Param("param")Map<String, Object> param);
	public Map<String, Object>  getCurrentMonthXqzjCount(@Param("param")Map<String, Object> param);
	public Map<String, Object> getCurrentWeekhouseTgandPublishDataCount(@Param("param")Map<String, Object> map);
	public List<Map<String, Object>>  getXqTfytFfCount(@Param("param")Map<String, Object> param);
	@SelectProvider(type=AdmindbRptMarketingCountInfoSelectProvider.class,method="getOperationsAndProfitCountOffReport")
	@ResultType(value=Map.class)
	public List<Map<String, Object>> getOperationsAndProfitCountOffReport(@Param("param")Map<String, Object> param);
	class AdmindbRptMarketingCountInfoSelectProvider{
		public String getOperationsAndProfitCountOffReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String dateType = param.getString("dateType");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			Integer deptId = param.getInteger("deptId");
			if("GROUP".equals(serchRange)){
				serchRange = "GR";
			}
			String dimension = param.getString("dimension");
			String areaFlag = param.getString("areaFlag");
			System.out.println("areaFlag"+areaFlag);
			String queryDimensionColumn = DataAnalysisUtil.getRangeGroupbyStr(dimension, areaFlag, "");
			String dateQueryColumn = DateUtil.getDateDimensionGroupBy(dateType, "CREATION_DATE", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1; ")
			.append("SELECT " )
			.append("SUM (XQ_COUNT) AS xqzjCount, SUM (TFYT_COUNT) AS houseTgCount, SUM (FF_COUNT) AS housePublishCount, ")
			.append(dateQueryColumn)
			.append(" AS countDate,")
			.append(queryDimensionColumn)
			.append(" AS range from MARKETING_COUNT_INFO ")
			.append(" where CITY_ID =#{param.cityId} ")
			.append(" and COMP_ID =#{param.compId}");
			if ("101".equals(caseType)) {
				sqlBuilder.append(" and CASE_TYPE =1");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" and CASE_TYPE =2");
			}
			if (!"COMP".equals(serchRange)) {
				sqlBuilder.append(" and ").append(serchRange).append("_ID = #{param.serchRangeId}");
			}
			if (deptId != null) {
				sqlBuilder.append(" and DEPT_ID = #{param.deptId}");
			}
			sqlBuilder.append(" AND CREATION_DATE >=#{param.startTime}  AND CREATION_DATE<=#{param.endTime}")
			.append(" group by ")
			.append(dateQueryColumn)
			.append(",")
			.append(queryDimensionColumn);
			return sqlBuilder.toString();
			
		}
	}

}