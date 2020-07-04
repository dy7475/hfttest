package com.myfun.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;

public class DateConvert implements Converter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object convert(Class type, Object value) {
		if(value instanceof Date) {
			return value;
		}
		String p = (String) value;
		if (p == null || p.trim().length() == 0) {
			return null;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.parse(p.trim());
		} catch (Exception e) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return df.parse(p.trim());
			} catch (java.text.ParseException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

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
	 * @param dataStr 日期参数，值为0~9
	 * @param dateColumn 数据库日期的列名
	 * @return Condition
	 */
	public static String[] getConditionDateForSoso(String dataStr){
		Date date = DateTimeHelper.getSystemDate();//, "yyyy-MM-dd 00:00:00");
		String start = "";
		String end = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 23:59:59");
		if(StringUtils.isBlank(dataStr)){
			start = "1985-03-20 00:00:00";//陈文超添加，防止其实时间为空的。
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_ALL)){
			start = "1985-03-20 00:00:00";
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_DAY)){
			//一天24小时以内
			date = DateTimeHelper.addHours(date, -23);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd HH:mm:ss");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_WEEK)){
			date = DateTimeHelper.addDays(date, -6);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_MONTH)){
			//30天以内
			date = DateTimeHelper.addDays(date, -29);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_SEASON)){
			//一季  90天以内
			date = DateTimeHelper.addDays(date, -89);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_HALFYEAR)){
			//半年180天以内
			date = DateTimeHelper.addDays(date, -179);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR)){
			//半年前的 180天以前的
			date = DateTimeHelper.addDays(date, -179);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_YEAR)){
			//一年内365天
			date = DateTimeHelper.addDays(date, -365);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR)){
			//一年前365天以前
			date = DateTimeHelper.addDays(date, -365);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR)){
			date = DateTimeHelper.addDays(date, -730);
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
			//本季 ?
			SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			Date  endDate= getLastDayOfQuarter(date);
			Date  startDate= getFirstDayOfQuarter(date);
			end = endSdf.format(endDate);
			start = startSdf.format(startDate);
		}
		return new String[]{start, end};
	}

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
		} else if (dataStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENSEASON)) {
			// 本季
			SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			Date startDate = getFirstDayOfQuarter(date);
			Date endDate = getLastDayOfQuarter(date);
			start = startSdf.format(startDate);
			end = endSdf.format(endDate);
		}else if(Constants_DIC.DIC_DATE_SEARCH_TYPE_THREEDAYS.equals(dataStr)){
			//三天内
			date = DateTimeHelper.addDays(date, -2);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_FIFTEENDAYS.equals(dataStr)) {
			// 15天内
			date = DateTimeHelper.addDays(date, -14);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		} else {
			try {
				int year = Integer.valueOf(dataStr);
				if (year > 2000) {// 代表根据年来查
					start = DateTimeHelper.formatDateTimetoString(year + "-01-01", "yyyy-MM-dd 00:00:00");
					end = DateTimeHelper.formatDateTimetoString(year + "-12-31", "yyyy-MM-dd 23:59:59");
				}
			} catch (Exception e) {
			}
		}
		return new String[]{start, end};
	}

	//本季的最后一天
	public static Date getLastDayOfQuarter(Date date) {
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
	//本季的最初一天
	public static Date getFirstDayOfQuarter(Date date)   {
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

	/**
	 * 将时间转换成数字时间
	 * @param inTime
	 * @return
	 * @throws Exception
	 */
	public static String convertInTimeToDigit(String inTime) {
		Date date = DateTimeHelper.parseToDate(inTime);
		long time = Math.abs(System.currentTimeMillis() - date.getTime());  
		long intervalDay = time/(24 * 60 * 60 * 1000);  
		String rangeType = "";
		if(intervalDay >= 2*365){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR;
		}else if(intervalDay >= 365){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR;
		}else if(intervalDay >= 180){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR;
		}else if(intervalDay <= 1){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_DAY;
		}else if(intervalDay <= 7){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_WEEK;
		}else if(intervalDay <= 30){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_MONTH;
		}else if(intervalDay <= 90){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_SEASON;
		}else if(intervalDay < 180){
			rangeType = Constants_DIC.DIC_DATE_SEARCH_TYPE_HALFYEAR;
		}
		return rangeType;
	}
	
	/**
	 * 获取某年某月的最后一天
	 * @author 朱科
	 * @since 2018年9月3日
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
	}

	/**
	 * 获取某年某月的第一天
	 * @author 陈志强
	 * @since 2018年12月4日
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
	}
}
