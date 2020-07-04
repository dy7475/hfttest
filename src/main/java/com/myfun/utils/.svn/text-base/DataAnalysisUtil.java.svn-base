package com.myfun.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 统计方面的公用方法，补数据等各种操作
 * @author 张宏利
 * @since 2017年7月21日
 */
public final class DataAnalysisUtil {
	
	public static final Map<String,String> HOUSEORCUST_FLOWANALYSISADD_MAP = new HashMap<>();
	public static final Map<String,String> HOUSEORCUST_FLOWANALYSISSAVE_MAP = new HashMap<>();
	static{
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("effectiveAddCount", "1");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("sealingplateAddCount", "2");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("bookAddCount", "4");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("innderdealAddCount", "5");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("outdealAddCount", "6");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("cancellAddCount", "7");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("transfertosaleAddCount", "101");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("transfertoleaseAddCount", "102");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("transfertoshareAddCount", "105");
		HOUSEORCUST_FLOWANALYSISADD_MAP.put("transfertopublicAddCount", "106");
		
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("effectiveSaveCount", "1");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("sealingplateSaveCount", "2");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("bookSaveCount", "4");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("innderdealSaveCount", "5");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("outdealSaveCount", "6");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("cancellSaveCount", "7");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("transfertosaleSaveCount", "101");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("transfertoleaseSaveCount", "102");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("transfertoshareSaveCount", "105");
		HOUSEORCUST_FLOWANALYSISSAVE_MAP.put("transfertopublicSaveCount", "106");
	}

	/**
	 * 补时间，日期的key为date
	 * 
	 * @author 张宏利
	 * @since 2017年7月21日
	 * @param resultList
	 *            数据集<br/>
	 *            比如有：2017-07-01 2017-07-03，处理之后就会：2017-07-01 2017-07-02 2017-07-03
	 * @param baseMap
	 *            初始化的map的初始值，put到新对象里面去
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param dateCountType
	 *            0=日统计 1=周统计 2=月统计
	 * @param dateField
	 *            时间字段
	 */
	public static void repairDateForListMap(List<Map<String, Object>> resultList, Map<String, Object> baseMap, String startTime, String endTime, String dateCountType, String dateField) {
		List<String> dateRangeBetween = getDateList(startTime, endTime, dateCountType);
		// 先排序，不然有乱序的
		SortUtil.sortForDateForListMap(resultList, dateField, dateCountType);
		for (int i = 0; i < dateRangeBetween.size(); i++) {
			Map<String, Object> dtoTemp = null;
			if (resultList.size() > i) {
				dtoTemp = resultList.get(i);
			}
			if (dtoTemp == null || !dateRangeBetween.get(i).equals(dtoTemp.get(dateField))) {
				Map<String, Object> voInsert = new HashMap<String, Object>();
				voInsert.putAll(baseMap);
				voInsert.put(dateField, dateRangeBetween.get(i));
				resultList.add(i, voInsert);
			}
		}
	}
	/**
	 * 补时间，日期的key为date
	 * 
	 * @author 张宏利
	 * @since 2017年7月21日
	 * @param resultList
	 *            数据集<br/>
	 *            比如有：2017-07-01 2017-07-03，处理之后就会：2017-07-01 2017-07-02 2017-07-03
	 * @param baseMap
	 *            初始化的map的初始值，put到新对象里面去
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param dateCountType
	 *            0=日统计 1=周统计 2=月统计
	 */
	public static void repairDateForListMap(List<Map<String, Object>> resultList, Map<String, Object> baseMap, String startTime, String endTime, String dateCountType) {
		repairDateForListMap(resultList, baseMap, startTime, endTime, dateCountType, "date");
	}
	
	/**
	 * 补时间，日期的key为date
	 * 
	 * @author 张宏利
	 * @since 2017年7月21日
	 * @param resultList
	 *            数据集<br/>
	 *            比如有：2017-07-01 2017-07-03，处理之后就会：2017-07-01 2017-07-02 2017-07-03
	 * @param baseMap
	 *            初始化的map的初始值，put到新对象里面去
	 * @param dateName
	 *            日期的名字
	 * @param baseObj
	 *            初始化的对象
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param dateCountType
	 *            0=日统计 1=周统计 2=月统计
	 */
	public static <T> void repairDateForListObj(List<T> resultList, String dateName, T baseObj, String startTime, String endTime, String dateCountType) {
		try {
			List<String> dateRangeBetween = getDateList(startTime, endTime, dateCountType);
			// 先排序，不然有乱序的
			SortUtil.sortForDateForListObj(resultList, dateName, dateCountType);
			for (int i = 0; i < dateRangeBetween.size(); i++) {
				Object dtoTemp = null;
				if (resultList.size() > i) {
					dtoTemp = resultList.get(i);
				}
				if (dtoTemp == null || !dateRangeBetween.get(i).equals(BeanUtils.getProperty(dtoTemp, dateName))) {
					Object cloneBean = BeanUtils.cloneBean(baseObj);
					BeanUtils.setProperty(cloneBean, dateName, dateRangeBetween.get(i));
					resultList.add(i, (T) cloneBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取时间周期
	 * 
	 * @author 张宏利
	 * @since 2017年7月21日
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param dateCountType
	 *            0=日统计 1=周统计 2=月统计
	 */
	public static List<String> getDateList(String startTime, String endTime, String dateCountType) {
		if ("0".equals(dateCountType)) {
			return DateTimeHelper.getBetweenDays(startTime, endTime);
		}
		if ("1".equals(dateCountType)) {
			return DateTimeHelper.getBetweenWeeks(startTime, endTime, null);
		}
		if ("2".equals(dateCountType)) {
			return DateTimeHelper.getMonthBetween(startTime, endTime);
		}
		throw new RuntimeException("日期获取方式错误");
	}
	
	/**
	 * 获取时间段的员工人数sql
	 * @author 张宏利
	 * @since 2017年7月29日
	 * @param startTime
	 * @param endTime
	 * @param dateCountType
	 * @return
	 */
	public static String getUserCountDateListSql(String startTime, String endTime, String dateCountType) {
		List<String> dateList = getDateList(startTime, endTime, dateCountType);
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < dateList.size(); i++) {
			String date = dateList.get(i);
			String offDate = null, jobDate = null;
			if("0".equals(dateCountType)) {
				offDate = date;
				Calendar calendar = Calendar.getInstance();
				try {
					calendar.setTime(DateTimeHelper.parseToDate(offDate));
				} catch (Exception e) {
					e.printStackTrace();
				}
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				jobDate = DateTimeHelper.formatDatetoString(calendar.getTime());
				jobDate += " 23:59:59";
			} else if("1".equals(dateCountType)) {
				offDate = date.substring(0, 10);
				jobDate = date.substring(11, date.length());
				jobDate += " 23:59:59";
			} else if("2".equals(dateCountType)) {
				offDate = date + "-01";
				Calendar calendar = Calendar.getInstance();
				try {
					calendar.setTime(DateTimeHelper.parseToDate(offDate));
				} catch (Exception e) {
					e.printStackTrace();
				}
				calendar.add(Calendar.MONTH, 1);
				jobDate = DateTimeHelper.formatDatetoString(calendar.getTime());
				jobDate += " 23:59:59";
			}
			if(i > 0) {
				sBuilder.append(",");
			}
			sBuilder.append("sum(iif(JOIN_DEPT_TIME<'").append(jobDate)
				.append("' and (USER_WRITEOFF=0 or (USER_WRITEOFF !=0 and WRITEOFF_TIME>'")
				.append(offDate).append("')),1,0)) as count_").append(i+1);
		}
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getUserCountDateListSql("2017-01-02", "2017-02-01", "1"));
	}
	
	/**
	 * 获取价格和面积的区间case when 条件
	 * @author 张宏利
	 * @since 2017年7月15日
	 * @param dataStr fun_city上配置的价格或面积区间
	 * @param column 字段名
	 * @return
	 */
	public static String getCaseWhenSql(String dataStr, String column) {
		StringBuilder caseWhen = new StringBuilder();
		String[] strArr = dataStr.split(",");
		for (int i = 0; i < strArr.length; i++) {
			if(i == 0) {
				caseWhen.append("CASE WHEN ").append(column).append(" <").append(strArr[i]);
			} else {
				caseWhen.append(" WHEN ").append(column).append(" >= ").append(strArr[i-1])
				.append(" AND ").append(column).append(" < ").append(strArr[i]);
			}
			caseWhen.append(" THEN ").append(i+1);
			if(i == strArr.length-1) {
				caseWhen.append(" ELSE ").append(i+2).append(" END ");
			}
		}
		return caseWhen.toString();
	}
	
	/**
	 * 获取价格和面积的区间case when 条件
	 * @author 张宏利
	 * @since 2017年7月15日
	 * @param dataStr fun_city上配置的价格或面积区间
	 * @param column 字段名
	 * @return
	 * SUM(IIF(HOUSE_AREA < 50,1,0)) as area1,SUM(IIF(HOUSE_AREA >= 50 AND HOUSE_AREA < 80,1,0)) as area2,SUM(IIF(HOUSE_AREA > 80,1,0)) as area3
	 */
	public static String getCaseWhenSumSql(String dataStr, String column) {
		StringBuilder caseWhen = new StringBuilder();
		String[] strArr = dataStr.split(",");
		for (int i = 0; i < strArr.length; i++) {
			if (i == 0) {
				caseWhen.append("SUM(IIF(").append(column).append(" < ").append(strArr[i]);
			} else {
				caseWhen.append(",SUM(IIF(").append(column).append(" >= ").append(strArr[i - 1])
					.append(" AND ").append(column).append(" < ").append(strArr[i]);
			}
			caseWhen.append(",1,0)) as area").append(i + 1);
			if (i == strArr.length - 1) {
				caseWhen.append(",SUM(IIF(").append(column).append(" >= ").append(strArr[i]);
				caseWhen.append(",1,0)) as area").append(i + 2);
			}
		}
		return caseWhen.toString();
	}

	/**
	 * 设置员工人数
	 * @author 张宏利
	 * @since 2017年7月29日
	 * @param source 用于获取和设置userCount，最多会获取areaId到userId
	 * @param dimension 维度，AREA 大区 REG 片区 DEPT 门店 GROUP 分组 USER 员工
	 * @param userCountMap 员工对应的人数
	 */
	public static void setUserCount(Map<String, Object> source, String dimension, Map<String, Integer> userCountMap){
		if(userCountMap == null || userCountMap.isEmpty()) {
			return;
		}
		// user时就是一个人
		if ("USER".equals(dimension)) {
			source.put("userCount", "1");
			return;
		}
		String dimId = null;
		String dimensionName = DataAnalysisUtil.getRangeHump(dimension);
		// 分组时要加上门店ID
		if ("grId".equals(dimensionName)) {
			dimId = String.valueOf(source.get("deptId")) + "_" + String.valueOf(source.get(dimensionName));
		} else {
			dimId = String.valueOf(source.get(dimensionName));
		}
		source.put("userCount", userCountMap.get(dimId));
	}
	
	/**
	 * 将前端参数转化成驼峰字段
	 * @author 张宏利
	 * @since 2017年7月20日
	 * @param groupby 前端参数
	 * @return
	 */
	public static String getRangeHump(String groupby){
		if("COMP".equals(groupby)){
			return "compId";
		} else if("AREA".equals(groupby)){
			return "areaId";
		} else if("REG".equals(groupby)){
			return "regId";
		} else if("DEPT".equals(groupby)){
			return "deptId";
		} else if("GROUP".equals(groupby)){
			return "grId";
		} else if("USER".equals(groupby)){
			return "userId";
		}
		return "compId";
	}
	
	/**
	 * 将前端参数转化成数据库字段
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param groupby 前端参数
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
	 * 获取需要查询的组织机构列
	 * @param dimension
	 * @return
	 */
	public static String getRangeQueryStr(String dimension,String areaFlag,String columnffix) {
		// return groupby+"_ID";
		if(StringUtil.isBlank(columnffix)){
			columnffix = "";
		}
		// return groupby+"_ID";
		String resultStr = "";
		if("COMP".equals(dimension)){
			resultStr = columnffix+"COMP_ID as range";
		} else if("AREA".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'') as range";
		} else if("REG".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'') as range";
		} else if("DEPT".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'_',"+columnffix+"DEPT_ID) as range";
		} else if("GROUP".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'_',"+columnffix+"DEPT_ID,'_',"+columnffix+"GR_ID) as range";
		} else if("USER".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'_',"+columnffix+"DEPT_ID,'_',"+columnffix+"GR_ID,'_',"+columnffix+"USER_ID)  as range";
		}
		if(!"1".equals(areaFlag)){
			resultStr = resultStr.replaceAll(columnffix+"AREA_ID,'_',", "");
		}
		return resultStr;
	}
	
	/**
	 * 需要分组维度的列
	 * @param groupby
	 * @return
	 */
	public static String getRangeGroupbyStr(String dimension,String areaFlag,String columnffix){
		if(StringUtil.isBlank(columnffix)){
			columnffix = "";
		}
		// return groupby+"_ID";
		String resultStr = "";
		if("COMP".equals(dimension)){
			resultStr = columnffix+"COMP_ID";
		} else if("AREA".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'')";
		} else if("REG".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'')";
		} else if("DEPT".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'_',"+columnffix+"DEPT_ID)";
		} else if("GROUP".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'_',"+columnffix+"DEPT_ID,'_',"+columnffix+"GR_ID)";
		} else if("USER".equals(dimension)){
			resultStr = "CONCAT("+columnffix+"AREA_ID,'_',"+columnffix+"REG_ID,'_',"+columnffix+"DEPT_ID,'_',"+columnffix+"GR_ID,'_',"+columnffix+"USER_ID)";
		}
		if(!"1".equals(areaFlag)){
			resultStr = resultStr.replaceAll(columnffix+"AREA_ID,'_',", "");
		}
		return resultStr;
	}
	public static String getRangeGroupbyTargetStr(String groupby,String areaFlag){
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "COMP_ID";
		} else if("AREA".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,CONCAT(AREA_ID,'')";
		} else if("REG".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,CONCAT(AREA_ID,'_',REG_ID,'')";
		} else if("DEPT".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID)";
		} else if("GROUP".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,GR_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID)";
		} else if("USER".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,GR_ID,USER_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID,'_',USER_ID)";
		}
		if(!"1".equals(areaFlag)){
			resultStr = resultStr.replaceAll("AREA_ID,'_',", "").replaceAll("AREA_ID,", "");
		}
		return resultStr;
	}
	
	public static String getRangeGroupbyTargetStrMin(String groupby,String areaFlag){
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "COMP_ID compId,COMP_ID";
		} else if("AREA".equals(groupby)){
			resultStr = "COMP_ID compId,AREA_ID areaId,CONCAT(AREA_ID,'')";
		} else if("REG".equals(groupby)){
			resultStr = "COMP_ID compId,AREA_ID areaId,REG_ID regId,CONCAT(AREA_ID,'_',REG_ID,'')";
		} else if("DEPT".equals(groupby)){
			resultStr = "COMP_ID compId,AREA_ID areaId,REG_ID regId,DEPT_ID deptId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID)";
		} else if("GROUP".equals(groupby)){
			resultStr = "COMP_ID compId,AREA_ID areaId,REG_ID regId,DEPT_ID deptId,GR_ID grId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID)";
		} else if("USER".equals(groupby)){
			resultStr = "COMP_ID compId,AREA_ID areaId,REG_ID regId,DEPT_ID deptId,GR_ID grId,USER_ID userId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID,'_',USER_ID)";
		}
		if(!"1".equals(areaFlag)){
			resultStr = resultStr.replaceAll("AREA_ID,'_',", "").replaceAll("AREA_ID areaId,", "");
		}
		return resultStr;
	}
	
}
