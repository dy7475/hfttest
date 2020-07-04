package com.myfun.repository.support.mybatis.query;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;

public final class ConditionUtil {
	/**
	 * 根据参数，选择日期查询条件范围
	 * 0-----全部
	 * 1-----一天
	 * 2-----一周
	 * 3-----一月
	 * 4-----一季
	 * 5-----半年
	 * 6-----半年前
	 * 7-----一年
	 * 8-----一年前
	 * 9-----两年前
	 * 10----三天内
	 * @param dataStr 日期参数，值为0~9
	 * @param dateColumn 数据库日期的列名
	 * @return Condition
	 */
	public static String[] getConditionDate(String dataStr){
		Date date = DateTimeHelper.getSystemDate();//, "yyyy-MM-dd 00:00:00");
		String start = "";
		String end = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 23:59:59");
		if(dataStr == null || dataStr.equals("")){
			start = "1985-03-20 00:00:00";//陈文超添加，防止其实时间为空的。
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_ALL)){
			start = "1985-03-20 00:00:00";
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_DAY)){
			//当天date = DateTimeHelper.addDays(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_WEEK)){
			date = DateTimeHelper.addDays(date, -6);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_MONTH)){
			date = DateTimeHelper.addMonths(date, -1);
			date = DateTimeHelper.addDays(date, 1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_SEASON)){
			date = DateTimeHelper.addMonths(date, -3);
			date = DateTimeHelper.addDays(date, 1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_HALFYEAR)){
			date = DateTimeHelper.addMonths(date, -6);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR)){
			date = DateTimeHelper.addMonths(date, -6);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_YEAR)){
			date = DateTimeHelper.addYears(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR)){
			date = DateTimeHelper.addYears(date, -1);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR)){
			date = DateTimeHelper.addYears(date, -2);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_TODAY)){
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_YESTERDAY)){
			date = DateTimeHelper.addDays(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENWEEK)){
			//本周
			SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	        Calendar ca = Calendar.getInstance();
	        ca.setFirstDayOfWeek(Calendar.MONDAY);
	        ca.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
	        ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH),ca.get(Calendar.DATE),23,59,59);
	        end = endSdf.format(ca.getTime());
	        ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	        ca.set(Calendar.HOUR_OF_DAY,0);
	        ca.set(Calendar.MINUTE, 0);
	        ca.set(Calendar.SECOND,0);
	        start = startSdf.format(ca.getTime());
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENMONTH)){
			//本月
			SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	        Calendar cc2 = Calendar.getInstance();
	        int maxMonthDay = cc2.getActualMaximum(Calendar.DAY_OF_MONTH);
	        cc2.set(cc2.get(Calendar.YEAR), cc2.get(Calendar.MONTH),maxMonthDay,23,59,59);
	        end = endSdf.format(cc2.getTime());
	        cc2.set(cc2.get(Calendar.YEAR), cc2.get(Calendar.MONTH),1,0,0,0);
	        start = startSdf.format(cc2.getTime());
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENSEASON)){
			//本季
			SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			Date  startDate= getFirstDayOfQuarter(date);
			Date  endDate= getLastDayOfQuarter(date);
			start = startSdf.format(startDate);
			end = endSdf.format(endDate);
		}else if(Constants_DIC.DIC_DATE_SEARCH_TYPE_THREEDAYS.equals(dataStr)){
			//三天内
			date = DateTimeHelper.addDays(date, -2);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		} else {
			try{
				int year = Integer.valueOf(dataStr);
				if(year > 2000) {// 代表根据年来查
					start = DateTimeHelper.formatDateTimetoString(year+"-01-01", "yyyy-MM-dd 00:00:00");
					end = DateTimeHelper.formatDateTimetoString(year+"-12-31", "yyyy-MM-dd 23:59:59");
				}
			} catch(Exception e){}
		}
		return new String[]{start, end};
	}
	 //本季的最初一天
	 public	static Date getFirstDayOfQuarter(Date date)   {     
	        Calendar cDay = Calendar.getInstance();     
	        cDay.setTime(date);  
	        int curMonth = cDay.get(Calendar.MONTH);  
	        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH){    
	            cDay.set(Calendar.MONTH, Calendar.JANUARY);  
	        }  
	        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE){    
	            cDay.set(Calendar.MONTH, Calendar.APRIL);  
	        }  
	        if (curMonth >= Calendar.JULY && curMonth <= Calendar.AUGUST) {    
	            cDay.set(Calendar.MONTH, Calendar.JULY);  
	        }  
	        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {    
	            cDay.set(Calendar.MONTH, Calendar.OCTOBER);  
	        }  
	        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMinimum(Calendar.DAY_OF_MONTH));  
	        return cDay.getTime();     
	}  
	public static void getConditionDate(Condition condition,String fieldName,String dataStr) throws Exception{
		Date date = DateTimeHelper.getSystemDate();//, "yyyy-MM-dd 00:00:00");
		String start = "";
		String end = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 23:59:59");
		if(dataStr == null || dataStr.equals("")){
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_ALL)){
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_DAY)){
			date = DateTimeHelper.addDays(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_WEEK)){
			date = DateTimeHelper.addDays(date, -7);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_MONTH)){
			date = DateTimeHelper.addMonths(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_SEASON)){
			date = DateTimeHelper.addMonths(date, -3);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_HALFYEAR)){
			date = DateTimeHelper.addMonths(date, -6);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR)){
			date = DateTimeHelper.addMonths(date, -6);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_YEAR)){
			date = DateTimeHelper.addYears(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR)){
			date = DateTimeHelper.addYears(date, -1);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR)){
			date = DateTimeHelper.addYears(date, -2);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}
		builderTimeAreaCondition(condition,start,end,fieldName);
	}
	//本季的最后一天
	 public static Date getLastDayOfQuarter(Date date)   {     
	        Calendar cDay = Calendar.getInstance();     
	        cDay.setTime(date);  
	        int curMonth = cDay.get(Calendar.MONTH);  
	        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH){    
	            cDay.set(Calendar.MONTH, Calendar.MARCH);  
	        }  
	        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE){    
	            cDay.set(Calendar.MONTH, Calendar.JUNE);  
	        }  
	        if (curMonth >= Calendar.JULY && curMonth <= Calendar.AUGUST) {    
	            cDay.set(Calendar.MONTH, Calendar.AUGUST);  
	        }  
	        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {    
	            cDay.set(Calendar.MONTH, Calendar.DECEMBER);  
	        }  
	        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));  
	        return cDay.getTime();     
	 }
	 /**
		 * 构造时间区间条件
		 * @param condition
		 * @param beforeTime
		 * @param afterTime
		 * @param fieldName
		 * @author 胡飞龙
	 * @throws Exception 
		 */
	public static void builderTimeAreaCondition(Condition condition, String beforeTime, String afterTime, String fieldName) throws Exception {
		if (StringUtils.isNotBlank(beforeTime)) {
			condition.add(new ConditionItem(fieldName, ">=", DateTimeHelper.formatDateTimetoString(beforeTime, "yyyy-MM-dd 00:00:00")));
		}
		if (StringUtils.isNotBlank(afterTime)) {
			condition.add(new ConditionItem(fieldName, "<=", DateTimeHelper.formatDateTimetoString(afterTime, "yyyy-MM-dd 23:59:59")));
		}
	}
}

