package com.myfun.repository.erpdb.mapper.sqlProvider;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.myfun.repository.erpdb.param.QueryProfitCountReportParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateUtil;

public class ErpFunProfitSqlProvider {
	public String getProfitCount(Map<String, Object> para){
		/*Object obj = para.get("param");
		QueryProfitCountReportParam param = (QueryProfitCountReportParam)obj;
		StringBuilder sbBuilder = new StringBuilder();
		//sbBuilder.append("sum(PROFIT_MONEY) as TOTLE_AMOUNT,");
		//"a."+dateType, ">=", startTime
		sbBuilder.append("select "+para.get("queryStr"))//+",a.DEAL_TYPE,a.DEAL_ID,"
		.append(" sum(iif(A.DEAL_TYPE=101,PROFIT_MONEY,0)) as SALE_ALLOT_PROFIT_COUNT,")
		.append("sum(iif(A.DEAL_TYPE=102,PROFIT_MONEY,0)) as LEASE_ALLOT_PROFIT_COUNT,")
		.append("sum(iif(A.DEAL_TYPE=101 and A.DEAL_STATUS=2,PROFIT_MONEY,0)) as SALE_ALLOT_VERIFY_COUNT,")
		.append("sum(iif(A.DEAL_TYPE=102 and A.DEAL_STATUS=2,PROFIT_MONEY,0)) as LEASE_ALLOT_VERIFY_COUNT,")
		.append(" from fun_deal a join FUN_PROFIT b on b.deal_id=a.deal_id ")
		.append("where a.comp_id = "+para.get("compId"))
		.append(" and a.ISBYHAND = 0 ")//排除手动录入业绩的
		.append("a."+param.getDateType()+" >= '"+param.getStartTime()+" 00:00:00'")
		.append("a."+param.getDateType()+" <= '"+param.getEndTime()+" 23:59:59'")
		.append(" and a.DEAL_AUDIT_STATUS = "+Const.DIC_DEAL_COMPLETE_FAIL);//排除废除了的合同，不计入套数，且废除了的合同需要
		sbBuilder.append(" GROUP BY "+getRangeGroupbyStr(param.getDimension()));
		if("USER".equals(param.getSerchRange())){
			sbBuilder.append(" and b.ARCHIVE_ID = "+param.getSerchRangeId());
		}else {
			sbBuilder.append(" b."+getRange(param.getSerchRange()+" = "+param.getSerchRangeId()));
		}
		.append("")
		.append("")
		.append("")
		.append("")
		.append("")
		.append("")
		.append("")
		.append("")
		.append("");
		return null;*/
		return null;
		
	}
	
	public String getOperationsAndProfitCountOffReport(Map<String, Object> pMap) throws Exception{
		BaseMap param = (BaseMap)pMap.get("param");
		String dateType = param.getString("dateType");
		String caseType = param.getString("caseType");
		String serchRange = param.getString("serchRange");
		Integer userId = param.getInteger("userId");
		if("GROUP".equals(serchRange)){
			serchRange = "GR";
		}
		String dimension = param.getString("dimension");
		String areaFlag = param.getString("areaFlag");
		String queryDimensionColumn = DataAnalysisUtil.getRangeGroupbyStr(dimension, areaFlag, "a.");
		String dateQueryColumn = DateUtil.getDateDimensionGroupBy(dateType, "b.SIGN_DATE", new String[]{param.getString("startTime"),param.getString("endTime")});
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SET DATEFIRST 1;")
		.append("SELECT ")
		.append(" SUM (a.PROFIT_MONEY) AS profitCount, ")
		.append(dateQueryColumn)
		.append(" AS countDate,")
		.append(queryDimensionColumn)
		.append(" AS range FROM FUN_PROFIT a LEFT JOIN FUN_DEAL b ON a.DEAL_ID = b.DEAL_ID ")
		.append(" where ")
		.append(" a.COMP_ID =#{param.compId}");
		if(userId!=null){
			sqlBuilder.append(" and a.USER_ID =#{param.userId}");
		}
		if("101".equals(caseType)){
			sqlBuilder.append(" and b.DEAL_TYPE =101");
		}
		if("102".equals(caseType)){
			sqlBuilder.append(" and b.DEAL_TYPE =102");
		}
		if(!"COMP".equals(serchRange)){
			if("USER".equals(serchRange)){
				sqlBuilder.append(" and a.")
				.append(serchRange).append("_ID = #{param.userId}");
			}else{
				sqlBuilder.append(" and a.")
				.append(serchRange).append("_ID = #{param.serchRangeId}");
			}
		}
		sqlBuilder.append(" AND b.SIGN_DATE >=#{param.startTime}  AND b.SIGN_DATE<=#{param.endTime}")
		.append(" group by ")
		.append(dateQueryColumn)
		.append(",")
		.append(queryDimensionColumn);
		return sqlBuilder.toString();
	}
	
	/**
	 * 获取查询
	 * @param groupby
	 * @return
	 */
	public static String getRangeQueryStr(String groupby,String areaFlag){
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "b.COMP_ID";
		} else if("AREA".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,CONCAT(b.AREA_ID,'') AS RANGE";
		} else if("REG".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'') AS RANGE";
		} else if("DEPT".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID) AS RANGE";
		} else if("GROUP".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID) AS RANGE";
		} else if("USER".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,b.USER_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID,'_',b.USER_ID) AS RANGE";
		}
		if(!"1".equals(areaFlag)){
			resultStr = resultStr.replaceAll("b.AREA_ID,'_',", "").replaceAll("b.AREA_ID,", "");
		}
		return resultStr;
	}
	
	/**
	 * 根据查询范围转换成对应的字段名
	 * @param groupby
	 * @return
	 */
	public static String getRange(String groupby){
		if("COMP".equals(groupby)){
			return "COMP_ID";
		} else if("AREA".equals(groupby)){
			return "AREA_ID";
		} else if("REG".equals(groupby)){
			return "REG_ID";
		} else if("DEPT".equals(groupby)){
			return "DEPT_ID";
		} else if("GROUP".equals(groupby)){
			return "GR_ID";
		} else if("USER".equals(groupby)){
			return "USER_ID";
		}
		return "COMP_ID";
	}

	/**
	 * @tag 反结算时更新实收分配比例
	 * @author 邓永洪
	 * @since 2018/6/30
	 */
	public String updateProfitProportion(Map<String, Object> pMap) throws Exception {
		Integer dealId = (Integer) pMap.get("dealId");
		Integer compId = (Integer) pMap.get("compId");
		Integer performanceType = (Integer) pMap.get("performanceType");
		Integer profitPercentRule = (Integer) pMap.get("profitPercentRule");
		String needFieldName = (String) pMap.get("needFieldName");

		StringBuilder selectSqlBuilder = new StringBuilder();
		StringBuilder dealIdBuilder = new StringBuilder();
		dealIdBuilder.append(" select DEAL_ID from FUN_PROFIT where COMP_ID =");
		dealIdBuilder.append(compId);
		dealIdBuilder.append(" and PERFORMANCE_TYPE =");
		dealIdBuilder.append(performanceType);
		if (dealId != null) {
			dealIdBuilder.append(" and DEAL_ID =");
			dealIdBuilder.append(dealId);
		} else {
			dealIdBuilder.append(" and SETTLE_FLAG!=2 ");
		}
		dealIdBuilder.append("  and USER_ID>0 group by DEAL_ID ");
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("(select A.DEAL_ID,IIF(B." + needFieldName + "=0,1,B." + needFieldName + ") as TOTAL_NEED_PERFORMANCE,SUM(iif(USER_ID is null,ISNULL(RECEIVABLE_MONEY,0.0),0)) as COMP_PROFIT_MONEY from FUN_PROFIT A left join FUN_DEAL B ON A.DEAL_ID = B.DEAL_ID where A.DEAL_ID IN(")
				.append(dealIdBuilder)
				.append(") and A.PERFORMANCE_TYPE=")
				.append(performanceType);
		if (dealId != null) {
			sqlBuilder.append(" and A.DEAL_ID =");
			sqlBuilder.append(dealId);
		}
		sqlBuilder.append(" group by A.DEAL_ID,B." + needFieldName + ") as B");
		StringBuilder profitIdBuilder = new StringBuilder();
		profitIdBuilder.append(" select PROFIT_ID from FUN_PROFIT where COMP_ID =");
		profitIdBuilder.append(compId);
		profitIdBuilder.append(" and PERFORMANCE_TYPE =");
		profitIdBuilder.append(performanceType);
		if (null != dealId) {
			profitIdBuilder.append(" and DEAL_ID =");
			profitIdBuilder.append(dealId);
		} else {
			profitIdBuilder.append("  and SETTLE_FLAG!=2 ");
		}
		profitIdBuilder.append(" and USER_ID>0 group by PROFIT_ID ");
		selectSqlBuilder.append("select ");
		if (profitPercentRule == 0) {
			selectSqlBuilder.append(" (ISNULL(A.RECEIVABLE_MONEY,0.0)/ISNULL(B.TOTAL_NEED_PERFORMANCE,1.0))*100 as PROFIT_PERCENT,A.PROFIT_ID ");
		} else if (profitPercentRule == 1) {
			selectSqlBuilder.append(" iif( ISNULL(B.TOTAL_NEED_PERFORMANCE,0)=ISNULL(B.COMP_PROFIT_MONEY, 0),0, (ISNULL(A.RECEIVABLE_MONEY, 0.0) / (ISNULL(B.TOTAL_NEED_PERFORMANCE,1.0) - ISNULL(B.COMP_PROFIT_MONEY, 0))) * 100 ) as PROFIT_PERCENT,A.PROFIT_ID ");
		}
		selectSqlBuilder.append("from FUN_PROFIT A left join ");
		selectSqlBuilder.append(sqlBuilder);
		selectSqlBuilder.append(" ON A.DEAL_ID = B.DEAL_ID where A.PROFIT_ID IN(");
		selectSqlBuilder.append(profitIdBuilder);
		selectSqlBuilder.append(")");
		selectSqlBuilder.append(" and PERFORMANCE_TYPE =");
		selectSqlBuilder.append(performanceType);
		if (dealId != null) {
			selectSqlBuilder.append(" and A.DEAL_ID =");
			selectSqlBuilder.append(dealId);
		}
		StringBuilder updateSqlBuilder = new StringBuilder();
		updateSqlBuilder.append("UPDATE D SET D.PROFIT_PROPORTION = A.PROFIT_PERCENT ");
		updateSqlBuilder.append(" from FUN_PROFIT D left join  ");
		updateSqlBuilder.append("(");
		updateSqlBuilder.append(selectSqlBuilder);
		updateSqlBuilder.append(") as A on D.PROFIT_ID = A.PROFIT_ID where D.PROFIT_ID = A.PROFIT_ID");
		updateSqlBuilder.append(" and D.PERFORMANCE_TYPE = ");
		updateSqlBuilder.append(performanceType);
		return updateSqlBuilder.toString();
	}

}
