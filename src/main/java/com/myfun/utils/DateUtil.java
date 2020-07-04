package com.myfun.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;




/**
 * 时间转换帮助类
 * 
 * @ClassName: DateUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午10:51:28
 *
 */
public class DateUtil {

	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();

	private static final Object object = new Object();

	/**
	 * 获取SimpleDateFormat
	 * 
	 * @param pattern
	 *            日期格式
	 * @return SimpleDateFormat对象
	 * @throws RuntimeException
	 *             异常：非法日期格式
	 */
	private static SimpleDateFormat getDateFormat(String pattern) throws RuntimeException {
		SimpleDateFormat dateFormat = threadLocal.get();
		if (dateFormat == null) {
			synchronized (object) {
				if (dateFormat == null) {
					dateFormat = new SimpleDateFormat(pattern);
					dateFormat.setLenient(false);
					threadLocal.set(dateFormat);
				}
			}
		}
		dateFormat.applyPattern(pattern);
		return dateFormat;
	}
	
	public static String[] getTimeRange(String timeRange) throws Exception{
		if(StringUtils.isNotBlank(timeRange)) {
			String startTime = timeRange.split("~")[0];
			String endTime = timeRange.split("~")[1];
			if (StringUtils.isNotBlank(startTime)) {
				DateUtil.validateFormat(startTime, "yyyy-MM-dd");
			}
			if (StringUtils.isNotBlank(endTime)) {
				DateUtil.validateFormat(endTime, "yyyy-MM-dd");
			}
			return new String[]{startTime+" 00:00:00", endTime+" 23:59:59"};
		}
		return null;
	}
	
	public static void validateFormat(String data, String pattern) throws Exception {
		DateFormat formatter = new SimpleDateFormat(pattern);
		formatter.parse(data);
	}
	 
	/**
	 * 获取日期中的某数值。如获取月份
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            日期格式
	 * @return 数值
	 */
	private static int getInteger(Date date, int dateType) {
		int num = 0;
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
			num = calendar.get(dateType);
		}
		return num;
	}

	/**
	 * 增加日期中某类型的某数值。如增加日期
	 * 
	 * @param date
	 *            日期字符串
	 * @param dateType
	 *            类型
	 * @param amount
	 *            数值
	 * @return 计算后日期字符串
	 */
	private static String addInteger(String date, int dateType, int amount) {
		String dateString = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			myDate = addInteger(myDate, dateType, amount);
			dateString = DateToString(myDate, dateStyle);
		}
		return dateString;
	}

	/**
	 * 增加日期中某类型的某数值。如增加日期
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            类型
	 * @param amount
	 *            数值
	 * @return 计算后日期
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	/**
	 * 获取精确的日期
	 * 
	 * @param timestamps
	 *            时间long集合
	 * @return 日期
	 */
	private static Date getAccurateDate(List<Long> timestamps) {
		Date date = null;
		long timestamp = 0;
		Map<Long, long[]> map = new HashMap<Long, long[]>();
		List<Long> absoluteValues = new ArrayList<Long>();

		if (timestamps != null && timestamps.size() > 0) {
			if (timestamps.size() > 1) {
				for (int i = 0; i < timestamps.size(); i++) {
					for (int j = i + 1; j < timestamps.size(); j++) {
						long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
						absoluteValues.add(absoluteValue);
						long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
						map.put(absoluteValue, timestampTmp);
					}
				}

				// 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的。此时minAbsoluteValue为0
				// 因此不能将minAbsoluteValue取默认值0
				long minAbsoluteValue = -1;
				if (!absoluteValues.isEmpty()) {
					minAbsoluteValue = absoluteValues.get(0);
					for (int i = 1; i < absoluteValues.size(); i++) {
						if (minAbsoluteValue > absoluteValues.get(i)) {
							minAbsoluteValue = absoluteValues.get(i);
						}
					}
				}

				if (minAbsoluteValue != -1) {
					long[] timestampsLastTmp = map.get(minAbsoluteValue);

					long dateOne = timestampsLastTmp[0];
					long dateTwo = timestampsLastTmp[1];
					if (absoluteValues.size() > 1) {
						timestamp = Math.abs(dateOne) > Math.abs(dateTwo) ? dateOne : dateTwo;
					}
				}
			} else {
				timestamp = timestamps.get(0);
			}
		}

		if (timestamp != 0) {
			date = new Date(timestamp);
		}
		return date;
	}

	/**
	 * 判断字符串是否为日期字符串
	 * 
	 * @param date
	 *            日期字符串
	 * @return true or false
	 */
	public static boolean isDate(String date) {
		boolean isDate = false;
		if (date != null) {
			if (getDateStyle(date) != null) {
				isDate = true;
			}
		}
		return isDate;
	}

	/**
	 * 获取日期字符串的日期风格。失敗返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 日期风格
	 */
	public static DateStyle getDateStyle(String date) {
		DateStyle dateStyle = null;
		Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
		List<Long> timestamps = new ArrayList<Long>();
		for (DateStyle style : DateStyle.values()) {
			if (style.isShowOnly()) {
				continue;
			}
			Date dateTmp = null;
			if (date != null) {
				try {
					ParsePosition pos = new ParsePosition(0);
					dateTmp = getDateFormat(style.getValue()).parse(date, pos);
					if (pos.getIndex() != date.length()) {
						dateTmp = null;
					}
				} catch (Exception e) {
				}
			}
			if (dateTmp != null) {
				timestamps.add(dateTmp.getTime());
				map.put(dateTmp.getTime(), style);
			}
		}
		Date accurateDate = getAccurateDate(timestamps);
		if (accurateDate != null) {
			dateStyle = map.get(accurateDate.getTime());
		}
		return dateStyle;
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 日期
	 */
	public static Date StringToDate(String date) {
		DateStyle dateStyle = getDateStyle(date);
		return StringToDate(date, dateStyle);
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return 日期
	 */
	public static Date StringToDate(String date, String pattern) {
		Date myDate = null;
		if (date != null) {
			try {
				myDate = getDateFormat(pattern).parse(date);
			} catch (Exception e) {
			}
		}
		return myDate;
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param dateStyle
	 *            日期风格
	 * @return 日期
	 */
	public static Date StringToDate(String date, DateStyle dateStyle) {
		Date myDate = null;
		if (dateStyle != null) {
			myDate = StringToDate(date, dateStyle.getValue());
		}
		return myDate;
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式
	 * @return 日期字符串
	 */
	public static String DateToString(Date date, String pattern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(pattern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	public static String DateToString(Date date) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dateStyle
	 *            日期风格
	 * @return 日期字符串
	 */
	public static String DateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null) {
			dateString = DateToString(date, dateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param newPattern
	 *            新日期格式
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, String newPattern) {
		DateStyle oldDateStyle = getDateStyle(date);
		return StringToString(date, oldDateStyle, newPattern);
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param newDateStyle
	 *            新日期风格
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, DateStyle newDateStyle) {
		DateStyle oldDateStyle = getDateStyle(date);
		return StringToString(date, oldDateStyle, newDateStyle);
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param olddPattern
	 *            旧日期格式
	 * @param newPattern
	 *            新日期格式
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, String olddPattern, String newPattern) {
		return DateToString(StringToDate(date, olddPattern), newPattern);
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param olddDteStyle
	 *            旧日期风格
	 * @param newParttern
	 *            新日期格式
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, DateStyle olddDteStyle, String newParttern) {
		String dateString = null;
		if (olddDteStyle != null) {
			dateString = StringToString(date, olddDteStyle.getValue(), newParttern);
		}
		return dateString;
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param olddPattern
	 *            旧日期格式
	 * @param newDateStyle
	 *            新日期风格
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, String olddPattern, DateStyle newDateStyle) {
		String dateString = null;
		if (newDateStyle != null) {
			dateString = StringToString(date, olddPattern, newDateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param olddDteStyle
	 *            旧日期风格
	 * @param newDateStyle
	 *            新日期风格
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {
		String dateString = null;
		if (olddDteStyle != null && newDateStyle != null) {
			dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * 增加日期的年份。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负数
	 * @return 增加年份后的日期字符串
	 */
	public static String addYear(String date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/**
	 * 增加日期的年份。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负数
	 * @return 增加年份后的日期
	 */
	public static Date addYear(Date date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/**
	 * 增加日期的月份。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param monthAmount
	 *            增加数量。可为负数
	 * @return 增加月份后的日期字符串
	 */
	public static String addMonth(String date, int monthAmount) {
		return addInteger(date, Calendar.MONTH, monthAmount);
	}

	/**
	 * 增加日期的月份。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param monthAmount
	 *            增加数量。可为负数
	 * @return 增加月份后的日期
	 */
	public static Date addMonth(Date date, int monthAmount) {
		return addInteger(date, Calendar.MONTH, monthAmount);
	}

	/**
	 * 增加日期的天数。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加天数后的日期字符串
	 */
	public static String addDay(String date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/**
	 * 增加日期的天数。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加天数后的日期
	 */
	public static Date addDay(Date date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/**
	 * 增加日期的小时。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param hourAmount
	 *            增加数量。可为负数
	 * @return 增加小时后的日期字符串
	 */
	public static String addHour(String date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/**
	 * 增加日期的小时。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param hourAmount
	 *            增加数量。可为负数
	 * @return 增加小时后的日期
	 */
	public static Date addHour(Date date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/**
	 * 增加日期的分钟。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param minuteAmount
	 *            增加数量。可为负数
	 * @return 增加分钟后的日期字符串
	 */
	public static String addMinute(String date, int minuteAmount) {
		return addInteger(date, Calendar.MINUTE, minuteAmount);
	}

	/**
	 * 增加日期的分钟。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加分钟后的日期
	 */
	public static Date addMinute(Date date, int minuteAmount) {
		return addInteger(date, Calendar.MINUTE, minuteAmount);
	}

	/**
	 * 增加日期的秒钟。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加秒钟后的日期字符串
	 */
	public static String addSecond(String date, int secondAmount) {
		return addInteger(date, Calendar.SECOND, secondAmount);
	}

	/**
	 * 增加日期的秒钟。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加秒钟后的日期
	 */
	public static Date addSecond(Date date, int secondAmount) {
		return addInteger(date, Calendar.SECOND, secondAmount);
	}

	/**
	 * 获取日期的年份。失败返回0。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 年份
	 */
	public static int getYear(String date) {
		return getYear(StringToDate(date));
	}

	/**
	 * 获取日期的年份。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 年份
	 */
	public static int getYear(Date date) {
		return getInteger(date, Calendar.YEAR);
	}

	/**
	 * 获取日期的月份。失败返回0。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 月份
	 */
	public static int getMonth(String date) {
		return getMonth(StringToDate(date));
	}

	/**
	 * 获取日期的月份。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		return getInteger(date, Calendar.MONTH) + 1;
	}

	/**
	 * 获取日期的天数。失败返回0。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 天
	 */
	public static int getDay(String date) {
		return getDay(StringToDate(date));
	}

	/**
	 * 获取日期的天数。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 天
	 */
	public static int getDay(Date date) {
		return getInteger(date, Calendar.DATE);
	}

	/**
	 * 获取日期的小时。失败返回0。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 小时
	 */
	public static int getHour(String date) {
		return getHour(StringToDate(date));
	}

	/**
	 * 获取日期的小时。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 小时
	 */
	public static int getHour(Date date) {
		return getInteger(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期的分钟。失败返回0。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 分钟
	 */
	public static int getMinute(String date) {
		return getMinute(StringToDate(date));
	}

	/**
	 * 获取日期的分钟。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 分钟
	 */
	public static int getMinute(Date date) {
		return getInteger(date, Calendar.MINUTE);
	}

	/**
	 * 获取日期的秒钟。失败返回0。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 秒钟
	 */
	public static int getSecond(String date) {
		return getSecond(StringToDate(date));
	}

	/**
	 * 获取日期的秒钟。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 秒钟
	 */
	public static int getSecond(Date date) {
		return getInteger(date, Calendar.SECOND);
	}

	/**
	 * 获取日期 。默认yyyy-MM-dd格式。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 日期
	 */
	public static String getDate(String date) {
		return StringToString(date, DateStyle.YYYY_MM_DD);
	}

	/**
	 * 获取日期。默认yyyy-MM-dd格式。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @return 日期
	 */
	public static String getDate(Date date) {
		return DateToString(date, DateStyle.YYYY_MM_DD);
	}

	/**
	 * 获取日期的时间。默认HH:mm:ss格式。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 时间
	 */
	public static String getTime(String date) {
		return StringToString(date, DateStyle.HH_MM_SS);
	}

	/**
	 * 获取日期的时间。默认HH:mm:ss格式。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @return 时间
	 */
	public static String getTime(Date date) {
		return DateToString(date, DateStyle.HH_MM_SS);
	}

	/**
	 * 获取日期的星期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 星期
	 */
	public static Week getWeek(String date) {
		Week week = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			week = getWeek(myDate);
		}
		return week;
	}

	/**
	 * 获取日期的星期。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @return 星期
	 */
	public static Week getWeek(Date date) {
		Week week = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekNumber) {
		case 0:
			week = Week.SUNDAY;
			break;
		case 1:
			week = Week.MONDAY;
			break;
		case 2:
			week = Week.TUESDAY;
			break;
		case 3:
			week = Week.WEDNESDAY;
			break;
		case 4:
			week = Week.THURSDAY;
			break;
		case 5:
			week = Week.FRIDAY;
			break;
		case 6:
			week = Week.SATURDAY;
			break;
		}
		return week;
	}

	/**
	 * 获取两个日期相差的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @param otherDate
	 *            另一个日期字符串
	 * @return 相差天数。如果失败则返回-1
	 */
	public static int getIntervalDays(String date, String otherDate) {
		return getIntervalDays(StringToDate(date), StringToDate(otherDate));
	}

	/**
	 * @param date
	 *            日期
	 * @param otherDate
	 *            另一个日期
	 * @return 相差天数。如果失败则返回-1
	 */
	public static int getIntervalDays(Date date, Date otherDate) {
		int num = -1;
		Date dateTmp = DateUtil.StringToDate(DateUtil.getDate(date), DateStyle.YYYY_MM_DD);
		Date otherDateTmp = DateUtil.StringToDate(DateUtil.getDate(otherDate), DateStyle.YYYY_MM_DD);
		if (dateTmp != null && otherDateTmp != null) {
			long time = Math.abs(dateTmp.getTime() - otherDateTmp.getTime());
			num = (int) (time / (24 * 60 * 60 * 1000));
		}
		return num;
	}

	/**
	 * 当天设置时间<br/>
	 * today+09:00
	 * 
	 * @param time
	 */
	public static Date setTodayTime(String time) {
		String todayDate = DateToString(new Date(), DateStyle.YYYY_MM_DD);
		todayDate += " " + time;
		return StringToDate(todayDate);
	}

	public enum DateStyle {

		YYYY_MM("yyyy-MM", false), YYYY_MM_DD("yyyy-MM-dd", false), YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm",
				false), YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss", false),

		YYYY_MM_EN("yyyy/MM", false), YYYY_MM_DD_EN("yyyy/MM/dd", false), YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm",
				false), YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss", false),

		YYYY_MM_CN("yyyy年MM月", false), YYYY_MM_DD_CN("yyyy年MM月dd日", false), YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm",
				false), YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss", false),

		HH_MM("HH:mm", true), HH_MM_SS("HH:mm:ss", true),

		MM_DD("MM-dd", true), MM_DD_HH_MM("MM-dd HH:mm", true), MM_DD_HH_MM_SS("MM-dd HH:mm:ss", true),

		MM_DD_EN("MM/dd", true), MM_DD_HH_MM_EN("MM/dd HH:mm", true), MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss", true),

		MM_DD_CN("MM月dd日", true), MM_DD_HH_MM_CN("MM月dd日 HH:mm", true), MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss", true);

		private String value;

		private boolean isShowOnly;

		DateStyle(String value, boolean isShowOnly) {
			this.value = value;
			this.isShowOnly = isShowOnly;
		}

		public String getValue() {
			return value;
		}

		public boolean isShowOnly() {
			return isShowOnly;
		}
	}

	public enum Week {

		MONDAY("星期一", "Monday", "Mon.", 1), TUESDAY("星期二", "Tuesday", "Tues.", 2), WEDNESDAY("星期三", "Wednesday", "Wed.",
				3), THURSDAY("星期四", "Thursday", "Thur.", 4), FRIDAY("星期五", "Friday", "Fri.", 5), SATURDAY("星期六",
						"Saturday", "Sat.", 6), SUNDAY("星期日", "Sunday", "Sun.", 7);

		String name_cn;
		String name_en;
		String name_enShort;
		int number;

		Week(String name_cn, String name_en, String name_enShort, int number) {
			this.name_cn = name_cn;
			this.name_en = name_en;
			this.name_enShort = name_enShort;
			this.number = number;
		}

		public String getChineseName() {
			return name_cn;
		}

		public String getName() {
			return name_en;
		}

		public String getShortName() {
			return name_enShort;
		}

		public int getNumber() {
			return number;
		}
	}

	/**
	 * 获取2个时间相差多少条 张卓
	 * 
	 * @param destTime
	 * @return
	 */
	public static String getSubTime(String destTime) {
		Date nowDate = new Date();
		Date inDate = DateUtil.StringToDate(destTime);
		
		double dateSub = (nowDate.getTime() - inDate.getTime())/(1000*60);
		if (dateSub < 24 * 60D) {
			if (destTime.indexOf("00:00:00") >= 0 && DateUtil.getMonth(inDate) == DateUtil.getMonth(nowDate)) {
				return "当天";
			} else if (destTime.indexOf("00:00:00") >= 0) {
				return "昨天";
			} else {
				if (dateSub < 60D) {
					return (int) dateSub + "分钟前";
				} else {
					return (int) dateSub / 60 + "小时前";
				}
			}
		} else if (dateSub < 30 * 24 * 60D) {
			return (int) (dateSub / 60 / 24) + "天前";
		} else if (dateSub < 6 * 30 * 24 * 60D) {
			return (int) (dateSub / 60 / 24 / 30) + "个月前";
		} else if (dateSub < 12 * 30 * 24 * 60D) {
			return "半年前";
		} else {
			return (int) (dateSub / 60 / 24 / 30 / 12) + "年前";
		}
	}
	
	/**
	 * 获取时间间隔
	 * @return
	 */
	public static String[] getDtateTimes(String dateStr){
		if(StringUtils.isBlank(dateStr)){
			return new String[]{};
		}
		String date = DateToString(new Date(), "yyyy-MM-dd");
		if("0".equals(dateStr)){
			String now = addDay(date, -7);
			return new String[]{now+" 00:00:00", date+" 23:59:59"};
		}else if("1".equals(dateStr)){
			String now = addDay(date, -30);
			return new String[]{now+" 00:00:00", date+" 23:59:59"};
		}else if("2".equals(dateStr)){
			String now = addDay(date, -90);
			return new String[]{now+" 00:00:00", date+" 23:59:59"};
		}else if("3".equals(dateStr)){
			String now = addDay(date, -180);
			return new String[]{now+" 00:00:00", date+" 23:59:59"};
		}else if("4".equals(dateStr)){
			String now = addDay(date, -365);
			return new String[]{now+" 00:00:00", date+" 23:59:59"};
		}
		return new String[]{};
	}

	/**
	 * 返回两个日期之间的毫秒数的差距
	 * @param d1
	 * @param d2
	 * @return 二者至1970年1.1后的毫秒数的差值
	 */
	public static long getMillisecondsOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long dI1 = d1.getTime();
		long dI2 = d2.getTime();
		return (dI1-dI2);
	}

	/**
	 * 获得两个日期之间相差的秒数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的秒数
	 */
	public static Double getSecondsOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long i = getMillisecondsOfTwoDate(d1,d2);

		return (double)i/1000;
	}

	/**
	 * 获得两个日期之间相差的分钟数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的分钟数
	 */
	public static double getMinutesOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/60/1000;
	}

	/**
	 * 获得两个日期之间相差的小时数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的小时数
	 */
	public static double getHoursOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/60/60/1000;
	}

	/**
	 * 获得两个日期之间相差的天数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的天数
	 */
	public static double getDaysOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/24/60/60/1000;
	}
	
	/**
	 * 时间比较
	 * @return Integer -5:参数空 -1 d1小于d2 0:相等 1:d1大于d2
	 * **/
	public static Integer dateCompare(String dateStr1, String dateStr2, String pattern) {
		Integer res = -5;
		if(StringUtil.isNotBlank(dateStr1, dateStr2)) {
			Date d1 = StringToDate(dateStr1, pattern);
			Date d2 = StringToDate(dateStr2, pattern);
			return dateCompare(d1, d2);
		}
		return res;
	}
	public static Integer dateCompare(Date dateStr1, Date dateStr2) {
		Integer res = -5;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateStr1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(dateStr2);
		
		if(calendar.before(calendar2)) {
			res = -1;
		}else if(calendar.after(calendar2)) {
			res = 1;
		}else{
			res = 0;
		}
		return res;
	}

	
	 public static String getTime(int count) {
		  int days = 7;
		  if(count==1){
			  days = 30;
		  }else if(count>=2){
			  return "2099-01-01 00:00:00";
		  }
		  Calendar day=Calendar.getInstance();
		  day.add(Calendar.DATE,days);
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		  String endTime = sdf.format(day.getTime());
		  return endTime;
	}
	 
	 /**
	  * 获取某年某月的最后一天
	  * @param year
	  * @param month
	  * @return
	  */
	 public static String getLastDayOfMonth(String yearStr,String monthStr)
		{
		 	int year = StringUtil.parseInteger(yearStr);
		 	int month = StringUtil.parseInteger(monthStr);
			Calendar cal = Calendar.getInstance();
			//设置年份
			cal.set(Calendar.YEAR,year);
			//设置月份
			cal.set(Calendar.MONTH, month-1);
			//获取某月最大天数
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			//设置日历中月份的最大天数
			cal.set(Calendar.DAY_OF_MONTH, lastDay);
			//格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String lastDayOfMonth = sdf.format(cal.getTime());
			return lastDayOfMonth;
		}
	 
	 /**
	  * 获取本月的第一天和最后一天
	  * @return
	  */
	public static String[] getFirstAndLastDay(){
		try{
			
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
//			//获取当前月第一天：
	        Calendar c = Calendar.getInstance();    
	        Date time = c.getTime();
	        c.add(Calendar.SECOND, 1);
	        Date time2 = c.getTime();
	        double daysOfTwoDate = getDaysOfTwoDate(time2, time2);
	        System.out.println(daysOfTwoDate);
	        return null;
//	        c.add(Calendar.MONTH, 0);
//	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
//	        String first = format.format(c.getTime());
//	        
//	        //获取当前月最后一天
//	        Calendar ca = Calendar.getInstance();    
//	        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
//	        String last = format.format(ca.getTime());
//	        return new String[]{first, last};
		}catch(Exception e){
			 return new String[]{"", ""};
		}
		
	}
	
	/**
	 * 根据给出的Date值和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
	 * @param date
	 * @param formatStr
	 * @return 如果为null，返回字符串""
	 */
	public static String formatDateTimetoString(Date date, String formatStr) {
		String reStr = "";
		if (date == null || formatStr == null || formatStr.trim().length() < 1) {
			return reStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(formatStr);
		reStr = sdf.format(date);
		return reStr == null ? "" : reStr;
	}

	public static Integer getIntervalHour(String biddstartTime, String sysDate, int remainsDays) throws Exception{
		int tmpMinu = (int) Math.floor(DateTimeHelper.getMinutesOfTwoDate(
				DateTimeHelper.parseToDate(sysDate, "yyyy-MM-dd HH:mm"),
				DateTimeHelper.addDays(DateTimeHelper.parseToDate(
						biddstartTime, "yyyy-MM-dd HH:mm"), remainsDays)));
		if (tmpMinu % 60 == 0) {
			tmpMinu = tmpMinu + 1;
		}
		tmpMinu = (tmpMinu / 60);
		if (tmpMinu > 24) {
			tmpMinu = tmpMinu - 24;
		}
		return tmpMinu;
	}
	
	/**
	* 某月第一天
	* @return
	* @throws Exception 
	*/
	public static String getFirstDay(String dateStr) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(df.parse(dateStr));
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
		return str.toString();
	}
	/**
	*某月最后一天
	* @return
	* @throws Exception 
	*/
	public static String getLastDay(String dateStr) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(df.parse(dateStr));
		gcLast.set(Calendar.DAY_OF_MONTH,gcLast.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first).append(" 23:59:59");
		return str.toString();
	}
	
	/**
	 * 根据时间统计方式来计算返回的时间坐标
	 * @param dateCountType
	 * @param dateRange
	 * @return
	 * @throws Exception 
	 */
	public static List<String> createDateDic(String dateCountType, String dateRange) throws Exception {
		if(StringUtils.isBlank(dateRange)||!dateRange.contains("~")){
			return null;
		}
		String[] dateArr = dateRange.split("~");
		List<String> list = new ArrayList<String>();
		int total = 0;
		if(dateArr.length==2){
			//日统计
			if("0".equals(dateCountType)){
				return DateUtil.getBetweenDays(dateArr[0], dateArr[1]);
			}else if("1".equals(dateCountType)){//周统计
				return	DateUtil.getBetweenWeeks(dateArr[0],dateArr[1],null);
			}else if("2".equals(dateCountType)){//月统计
				return	DateUtil.getMonthBetween(dateArr[0], dateArr[1]);
			}
		}
		return null;
	}
	/**
	 * 根据时间统计方式来计算返回的时间坐标
	 * @param dateCountType
	 * @param dateRange
	 * @return
	 * @throws Exception 
	 */
	public static Map<String,String> createDateDicOffConstomOffMap(String dateCountType, String dateRange,String customStr,boolean flag) throws Exception {
		if(StringUtils.isBlank(dateRange)||!dateRange.contains("~")){
			return null;
		}
		String[] dateArr = dateRange.split("~");
		List<String> list = new ArrayList<String>();
		int total = 0;
		if(dateArr.length==2){
			//日统计
			if("0".equals(dateCountType)){
				return DateUtil.getBetweenDaysOffMap(dateArr[0], dateArr[1],flag);
			}else if("1".equals(dateCountType)){//周统计
				return	DateUtil.getBetweenWeeksOffMap(dateArr[0],dateArr[1],customStr,flag);
			}else if("2".equals(dateCountType)){//月统计
				return	DateUtil.getMonthBetweenOffMap(dateArr[0], dateArr[1],flag);
			}
		}
		return null;
	}
	/**
	 * 获取两个时间之间所有的月份包含两个其实时间所在的月份
	 * @param minDate
	 * @param maxDate
	 * @athor flj
	 * @return
	 * @throws Exception
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) throws Exception {
		List<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		min.setTime(sdf.parse(minDate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		max.setTime(sdf.parse(maxDate));
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}
		return result;
	}
	/**
	 * 获取两个时间之间所有的月份包含两个其实时间所在的月份
	 * @param minDate
	 * @param maxDate
	 * @athor flj
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> getMonthBetweenOffMap(String minDate, String maxDate,boolean flag) throws Exception {
		Map<String,String> result = new HashMap<String,String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		min.setTime(sdf.parse(minDate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		max.setTime(sdf.parse(maxDate));
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		Calendar curr = min;
		int i = 1;
		while (curr.before(max)) {
			if(!flag){
				result.put(String.valueOf(i), sdf.format(curr.getTime()));
			}else{
				result.put(sdf.format(curr.getTime()),String.valueOf(i));				
			}
			curr.add(Calendar.MONTH, 1);
			i++;
		}
		return result;
	}
	/**
	 * 获取两个时间之间的之间包含的天数
	 * @param stime
	 * @param etime
	 * @athor flj
	 * @return
	 * @throws Exception
	 */
	public static List<String> getBetweenDays(String stime,String etime) throws Exception{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date sdate=null;
		Date eDate=null;
		sdate=df.parse(stime);
		eDate=df.parse(etime);
		Calendar c = Calendar.getInstance();
		List<String> list=new ArrayList<String>();
		while (sdate.getTime()<=eDate.getTime()) {
			list.add(df.format(sdate));
			c.setTime(sdate);
			c.add(Calendar.DATE, 1); // 日期加1天
			sdate = c.getTime();
		}
		return list;
	}
	/**
	 * 获取两个时间之间的之间包含的天数
	 * @param stime
	 * @param etime
	 * @athor flj
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> getBetweenDaysOffMap(String stime,String etime,boolean flag) throws Exception{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date sdate=null;
		Date eDate=null;
		sdate=df.parse(stime);
		eDate=df.parse(etime);
		Calendar c = Calendar.getInstance();
		Map<String,String> map=new HashMap<String,String>();
		int i=1;
		while (sdate.getTime()<=eDate.getTime()) {
			if(!flag){
				map.put(String.valueOf(i),df.format(sdate));
			}else{
				map.put(df.format(sdate),String.valueOf(i));
			}
			c.setTime(sdate);
			c.add(Calendar.DATE, 1); // 日期加1天
			sdate = c.getTime();
			i++;
		}
		return map;
	}
	
	/**
	 * 获取两个时间之间的之间包含的周数
	 * @param stime
	 * @param etime
	 * @athor flj
	 * @return
	 * @throws Exception
	 */
	public static List<String> getBetweenWeeks(String minDate,String maxDate,String customStr) {
		int weeks = getTwoDatesDifOfWeek(DateTimeHelper.parseToDate(maxDate), DateTimeHelper.parseToDate(minDate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(minDate));
		// 设置星期一为一周的第一天，因为美国是以星期日为一周的第一天，所以这里需要手动设置
		calendar.setFirstDayOfWeek(calendar.MONDAY);
		List<String> list = new ArrayList<String>();
		if (StringUtils.isBlank(customStr)) {
			customStr = "-";
		}
		maxDate = DateTimeHelper.formatDateTimetoString(maxDate, DateTimeHelper.FMT_yyyyMMdd);
		if (weeks == 0) {
			list.add(minDate + customStr + maxDate);
		}
		String lastDate = minDate;
		for (int i = 0; i < weeks; i++) {
			if (i != weeks - 1) {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				String date = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
				list.add(lastDate + customStr + date);
				calendar.add(calendar.DAY_OF_MONTH, 1);
				lastDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
			} else {
				list.add(lastDate + customStr + maxDate);
			}
		}
		return list;
	}
	/**
	 * 获取两个时间之间的之间包含的周数
	 * @param stime
	 * @param etime
	 * @athor flj
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> getBetweenWeeksOffMap(String minDate,String maxDate,String customStr,boolean flag) throws Exception{
		Map<String,String> returnMap = new HashMap<String,String>();
		int weeks = getTwoDatesDifOfWeek(DateTimeHelper.parseToDate(maxDate),DateTimeHelper.parseToDate(minDate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(minDate));
		//设置星期一为一周的第一天，因为美国是以星期日为一周的第一天，所以这里需要手动设置
		calendar.setFirstDayOfWeek(calendar.MONDAY);
		/*List<String> list = new ArrayList<String>();*/
		maxDate = DateTimeHelper.formatDateTimetoString(maxDate, DateTimeHelper.FMT_yyyyMMdd);
		if(StringUtils.isBlank(customStr)){
			customStr = "-";
		}
		if(weeks==0){
			if(!flag){
				returnMap.put("1", minDate+customStr+maxDate);
			}else{
				returnMap.put(minDate+customStr+maxDate,"1");				
			}
			return returnMap;
		}
		String lastDate = minDate;
		for(int i = 0;i<weeks;i++){
			if(i!=weeks-1){
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				String date = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
				if(!flag){
					returnMap.put(String.valueOf(i+1),lastDate+customStr+date);
				}else{					
					returnMap.put(lastDate+customStr+date,String.valueOf(i+1));
				}
				calendar.add(calendar.DAY_OF_MONTH,1);
				lastDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
			}else{
				if(!flag){
					returnMap.put(String.valueOf(i+1),lastDate+customStr+maxDate);
				}else{
					returnMap.put(lastDate+customStr+maxDate,String.valueOf(i+1));
				}
			}
		}
		return returnMap;
	}
	
	/**
	 * 获取两个时间之间的之间包含的周数
	 * 这个是没有中横线分割的方法
	 * @param stime
	 * @param etime
	 * @athor flj
	 * @return
	 * @throws Exception
	 */
	public static List<String> getBetweenWeeksList(String minDate, String maxDate) {
		int weeks = getTwoDatesDifOfWeek(DateTimeHelper.parseToDate(maxDate), DateTimeHelper.parseToDate(minDate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(minDate));
		// 设置星期一为一周的第一天，因为美国是以星期日为一周的第一天，所以这里需要手动设置
		calendar.setFirstDayOfWeek(calendar.MONDAY);
		List<String> list = new ArrayList<String>();
		if (weeks == 0) {
			list.add(minDate);
		}
		String lastDate = minDate;
		for (int i = 0; i < weeks; i++) {
			if (i != weeks - 1) {
				list.add(lastDate);
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				calendar.add(calendar.DAY_OF_MONTH, 1);
				lastDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
			}else{
				list.add(lastDate);
			}
		}
		return list;
	}
	
	/**
	* 获取两个日期相差的周数
	* @param big
	* @param small
	* @return
	*/
	public static int getTwoDatesDifOfWeek(Date big,Date small){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(small);
		//设置星期一为一周的第一天，因为美国是以星期日为一周的第一天，所以这里需要手动设置
		calendar.setFirstDayOfWeek(calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		small = calendar.getTime();
		calendar.setTime(big);
		calendar.setFirstDayOfWeek(calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		big = calendar.getTime();
		long from = small.getTime();
		long to = big.getTime();
		if((to-from+0.0)%(1000*3600*24*7.0)==0){
			return(int) ((to-from+0.0)/(1000*3600*24*7.0));
		}
		return (int) ((to-from+0.0)/(1000*3600*24*7.0)+1);
	}
	
	/**
	 * 获取根据type转换成对应的范围
	 * @param big
	 * @param small
	 * @return
	 */
	public static String getPriceOrAreaRangeByType(String type,String rangeStr,String caseType,boolean priceFlag) throws Exception{
		String returnStr = "";
		String[] rangeArr = rangeStr.split(",");
		String unit = "㎡";
		boolean saleUnitFlag = false;
		if(priceFlag){
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)||Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
				unit = "万元";
				saleUnitFlag = true;
			}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)||Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
				unit = "元";				
			}
		}
		if("1".equals(type)){
			if(saleUnitFlag){
				returnStr = StringUtil.paseInteger(rangeArr[0],0)/10000+unit+"以下";
			}else {
				returnStr = rangeArr[0]+unit+"以下";
			}
		}else if(((rangeArr.length+1)+"").equals(type)){
			if(saleUnitFlag){
				returnStr = StringUtil.paseInteger(rangeArr[rangeArr.length-1], 0)/10000+unit+"以上";
			}else{
				returnStr =rangeArr[rangeArr.length-1]+unit+"以上";
			}
		}
		for(int i=1;i<rangeArr.length;i++){
			if((i+1+"").equals(type)){
				if(saleUnitFlag){
					returnStr = (StringUtil.paseInteger(rangeArr[i-1],0)/10000)+"-"+(StringUtil.paseInteger(rangeArr[i],0)/10000)+unit;					
				}else{
					returnStr = rangeArr[i-1]+"-"+rangeArr[i]+unit;
				}
			}
		}
		return returnStr;
	}
	
	public static Date getMonday()throws Exception{
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if(week>2){
		    cal.add(Calendar.DAY_OF_MONTH,-(week-2)+7);
		}else{
		    cal.add(Calendar.DAY_OF_MONTH,2-week+7);
		}
		return cal.getTime();
	}
	
	/**
	 * 以今天为结束点，向前推4周
	 * @param customStr：周之间的间隔符
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getFrontFourWeeksEndByToday(String customStr) throws Exception{
		//获取开始时间和结束时间
		String[] timeArr = getFrontFourWeeksEndByTodayTimeArr();
		return getBetweenWeeks(timeArr[0], timeArr[1], customStr);
	}
	
	/**
	 * 以今天为结束点，向前推4周,获取开始时间和结束时间
	 * @return
	 * @throws Exception 
	 */
	public static String[] getFrontFourWeeksEndByTodayTimeArr() throws Exception{
		Calendar calendar = Calendar.getInstance();
		String endDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		// 设置星期一为一周的第一天，因为美国是以星期日为一周的第一天，所以这里需要手动设置
		calendar.setFirstDayOfWeek(calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.add(Calendar.DAY_OF_YEAR, -21);
		String startDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		return new String[]{
				startDate,endDate
		};	
	}
	
	/**
	 * 时间统计维度（0 = 日统计 1 = 周统计 2月统计）
	 * @return
	 */
	public static String getDateDimensionGroupBy(String dateCountType,String timeField,String[] dateArr) throws Exception{
		String groupBy = null;
		if("0".equals(dateCountType)){
			groupBy = "convert(nvarchar(10),"+timeField+",120)";
		}else if("1".equals(dateCountType)){
			dateArr[0] = DateTimeHelper.formatDateTimetoString(dateArr[0],DateTimeHelper.FMT_yyyyMMdd);
			dateArr[1] = DateTimeHelper.formatDateTimetoString(dateArr[1],DateTimeHelper.FMT_yyyyMMdd);
			groupBy = "(CONVERT (VARCHAR (10),iif (CONVERT (VARCHAR (10),"+timeField+",120) >= '"+dateArr[0]+"' AND CONVERT (VARCHAR (10),"+timeField+",120) <=DATEADD( WEEK,1,DATEADD(DAY, 1 - DATEPART(WEEKDAY, '"+dateArr[0]+"')-1,'"+dateArr[0]+"')),'"+dateArr[0]+"',DATEADD( WEEKDAY,1 - DATEPART(WEEKDAY, "+timeField+"), "+timeField+")),120) + '-' + iif (CONVERT (VARCHAR (10),"+timeField+",120) >= CONVERT (VARCHAR (10),DATEADD( WEEKDAY,1 - DATEPART(WEEKDAY, '"+dateArr[1]+"'),'"+dateArr[1]+"'),120),'"+dateArr[1]+"',CONVERT (VARCHAR (10),DATEADD(WEEK,1,DATEADD(DAY,1 - DATEPART(WEEKDAY, "+timeField+")-1,"+timeField+" )),120)))";
			//groupBy = "(CONVERT (VARCHAR (10),DATEADD(WEEKDAY,1 - DATEPART(WEEKDAY, "+timeField+") + 1,"+timeField+"),120) + '-' + CONVERT (VARCHAR (10),DATEADD(WEEK,1,DATEADD(DAY,1 - DATEPART(WEEKDAY, "+timeField+"),"+timeField+")),120))";
		}else if("2".equals(dateCountType)){
			groupBy = "convert(VARCHAR(7),"+timeField+",20)";
		}
		return groupBy;
	}

	/**
	 * 时间统计维度（0 = 日统计 1 = 周统计 2月统计）
	 * @return
	 */
	public static String getDateDimensionGroupBy2(String dateCountType,String timeField,String[] dateArr) throws Exception{
		String groupBy = null;
		if("0".equals(dateCountType)){
			groupBy = "convert(nvarchar(10),"+timeField+",120)";
		}else if("1".equals(dateCountType)){
			dateArr[0] = DateTimeHelper.formatDateTimetoString(dateArr[0],DateTimeHelper.FMT_yyyyMMdd);
			dateArr[1] = DateTimeHelper.formatDateTimetoString(dateArr[1],DateTimeHelper.FMT_yyyyMMdd);
			groupBy = "(CONVERT (VARCHAR (10),iif (CONVERT (VARCHAR (10),"+timeField+",120) >= '"+dateArr[0]+"' AND CONVERT (VARCHAR (10),"+timeField+",120) <=DATEADD( WEEK,1,DATEADD(DAY, 1 - DATEPART(WEEKDAY, '"+dateArr[0]+"')-1,'"+dateArr[0]+"')),'"+dateArr[0]+"',DATEADD( WEEKDAY,1 - DATEPART(WEEKDAY, "+timeField+"), "+timeField+")),120) + '~' + iif (CONVERT (VARCHAR (10),"+timeField+",120) >= CONVERT (VARCHAR (10),DATEADD( WEEKDAY,1 - DATEPART(WEEKDAY, '"+dateArr[1]+"'),'"+dateArr[1]+"'),120),'"+dateArr[1]+"',CONVERT (VARCHAR (10),DATEADD(WEEK,1,DATEADD(DAY,1 - DATEPART(WEEKDAY, "+timeField+")-1,"+timeField+" )),120)))";
			//groupBy = "(CONVERT (VARCHAR (10),DATEADD(WEEKDAY,1 - DATEPART(WEEKDAY, "+timeField+") + 1,"+timeField+"),120) + '-' + CONVERT (VARCHAR (10),DATEADD(WEEK,1,DATEADD(DAY,1 - DATEPART(WEEKDAY, "+timeField+"),"+timeField+")),120))";
		}else if("2".equals(dateCountType)){
			groupBy = "convert(VARCHAR(7),"+timeField+",20)";
		}
		return groupBy;
	}
	
	/**
	 * 以今天为结束点，向前推6月
	 * @return
	 * @throws Exception 
	 */
	public static String[] getFrontHalfYearEndByTodayTimeArr() throws Exception{
		Calendar calendar = Calendar.getInstance();
		String endDate = DateUtil.DateToString(calendar.getTime(),  DateTimeHelper.FMT_yyyyMMdd + " 23:59:59");
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, -5);
		String startDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		return new String[]{
				startDate,endDate
		};	
	}
	
	/**
	 * 以今天为结束点，获取当月时间范围
	 * @return
	 * @throws Exception 
	 */
	public static String[] getCurrentMonthByTodayTimeArr() {
		Calendar calendar = Calendar.getInstance();
		String endDate = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		return new String[] { startDate, endDate };
	}
	
	/**
	 * 以今天为结束点，获取当月时间范围
	 * @return
	 * @throws Exception 
	 */
	public static String[] getLastMonthByTodayTimeArr() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String endDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59";
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd)+ " 00:00:00";
		return new String[] { startDate, endDate };
	}
	
	/**
	 * 以今天为结束点，获取本周时间范围
	 * @return
	 * @throws Exception 
	 */
	public static String[] getCurrentWeekByTodayTimeArr() throws Exception{
		Calendar calendar = Calendar.getInstance();
		String endDate = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.setFirstDayOfWeek(calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String startDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		return new String[]{
				startDate,endDate
		};	
	}

	public static String[] getDateRangeOffTwoMonth(String startTime, String endTime) {
		startTime = startTime.substring(0, 7) + "-01";
		endTime = endTime.substring(0, 7) + "-01";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(endTime));
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59";
		return new String[] { startTime, endTime };
	}
	
	/**
	 * 当前月的第一天
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		return getFirstDayOfMonth(new Date());
	}
	
	/**
	 * 当前月的第一天
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);// someDate 为你要获取的那个月的时间
		ca.set(Calendar.DAY_OF_MONTH, 1);
		return DateToString(ca.getTime(), "yyyy-MM-dd");
	}
	
	/**
	 * 当前月的第一天
	 * @param date
	 * @return
	 */
	public static String getFirstdayOfMonth(String datestr) {
		Date date = StringToDate(datestr,"yyy-mm-dd hh:dd:ss");
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);// someDate 为你要获取的那个月的时间
		ca.set(Calendar.DAY_OF_MONTH, 1);
		// 第一天
		Date firstDate = ca.getTime();
		return DateToString(firstDate, "yyyy-MM-dd");
	}
	/**
	 * 当前月的最后一天
	 * @param date
	 * @return
	 */
	public static String getLastdayOfMonth(String datestr) {
		Date date = StringToDate(datestr,"yyy-mm-dd hh:dd:ss");
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);// someDate 为你要获取的那个月的时间
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DAY_OF_MONTH, -1);
		// 最后一天
		Date lastDate = ca.getTime();
		return DateToString(lastDate, "yyyy-MM-dd");
		}

	/**
	 * 获取本月第一天
	 * @author 朱春平
	 */
	public static String getFirstDateOfMonth() {
		return getFirstDateOfMonth(new Date());
	}
	
	/**
	 * 获取本月第一天
	 * @author 朱春平
	 */
	public static String getFirstDateOfMonth(String dateTimeStr) {
		return getFirstDateOfMonth(DateTimeHelper.parseToDate(dateTimeStr));
	}
	
	/**
	 * 获取本月第一天
	 * @author 朱春平
	 */
	public static String getFirstDateOfMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH,1);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE,0);
		ca.set(Calendar.SECOND,0);
		ca.set(Calendar.MILLISECOND,0);
		return DateTimeHelper.formatDateTimetoString(ca.getTime(), DateTimeHelper.FMT_yyyyMMdd);
	}
	

	/**
	 * 获取下月第一天(用于按月的时间段查询,比如查5月数据,实际上查询的是 5-1 到 6-1 的数据)
	 * @author 朱春平
	 */
	public static String getFirstDateOfNextMonth(String dateTimeStr) {
		return getFirstDateOfNextMonth(DateTimeHelper.parseToDate(dateTimeStr));
	}
	/**
	 * 获取下月第一天(用于按月的时间段查询,比如查5月数据,实际上查询的是 5-1 到 6-1 的数据)
	 * @author 朱春平
	 */
	public static String getFirstDateOfNextMonth() {
		return getFirstDateOfNextMonth(new Date());
	}
	/**
	 * 获取下月第一天(用于按月的时间段查询,比如查5月数据,实际上查询的是 5-1 到 6-1 的数据)
	 * @author 朱春平
	 */
	public static String getFirstDateOfNextMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.MONTH, 1);
		ca.set(Calendar.DAY_OF_MONTH,1);
		return DateTimeHelper.formatDateTimetoString(ca.getTime(), DateTimeHelper.FMT_yyyyMMdd);
	}

	public static String[] getConditionDate(String dateStr) {
		Date date = DateTimeHelper.getSystemDate();//, "yyyy-MM-dd 00:00:00");
		String start = "";
		String end = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 23:59:59");
		if(StringUtils.isBlank(dateStr)){
			start = "1985-03-20 00:00:00";//陈文超添加，防止其实时间为空的。
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_ALL)){
			start = "1985-03-20 00:00:00";
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_DAY)){
			//当天date = DateTimeHelper.addDays(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_WEEK)){
			date = DateTimeHelper.addDays(date, -6);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_MONTH)){
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, -1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			start = DateTimeHelper.formatDateTimetoString(calendar.getTime(), "yyyy-MM-dd 00:00:00");
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			end = DateTimeHelper.formatDateTimetoString(calendar.getTime(),"yyyy-MM-dd 23:59:59");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_SEASON)){
			date = DateTimeHelper.addMonths(date, -3);
			date = DateTimeHelper.addDays(date, 1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_HALFYEAR)){
			date = DateTimeHelper.addMonths(date, -6);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR)){
			date = DateTimeHelper.addMonths(date, -6);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_YEAR)){
			date = DateTimeHelper.addYears(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR)){
			date = DateTimeHelper.addYears(date, -1);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR)){
			date = DateTimeHelper.addYears(date, -2);
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_TODAY)){
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_YESTERDAY)){
			date = DateTimeHelper.addDays(date, -1);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
			end = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 23:59:59");
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENWEEK)){
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
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENMONTH)){
			//本月
			SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	        Calendar cc2 = Calendar.getInstance();
	        int maxMonthDay = cc2.getActualMaximum(Calendar.DAY_OF_MONTH);
	        cc2.set(cc2.get(Calendar.YEAR), cc2.get(Calendar.MONTH),maxMonthDay,23,59,59);
	        end = endSdf.format(cc2.getTime());
	        cc2.set(cc2.get(Calendar.YEAR), cc2.get(Calendar.MONTH),1,0,0,0);
	        start = startSdf.format(cc2.getTime());
		}else if(dateStr.equals(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENSEASON)){
			//本季
			SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			Date  startDate= getFirstDayOfQuarter(date);
			Date  endDate= getLastDayOfQuarter(date);
			start = startSdf.format(startDate);
			end = endSdf.format(endDate);
		}else if(Constants_DIC.DIC_DATE_SEARCH_TYPE_THREEDAYS.equals(dateStr)){
			//三天内
			date = DateTimeHelper.addDays(date, -2);
			start = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd 00:00:00");
		} else {
			try{
				int year = Integer.valueOf(dateStr);
				if(year > 2000) {// 代表根据年来查
					start = DateTimeHelper.formatDateTimetoString(year+"-01-01", "yyyy-MM-dd 00:00:00");
					end = DateTimeHelper.formatDateTimetoString(year+"-12-31", "yyyy-MM-dd 23:59:59");
				}
			} catch(Exception e){}
		}
		return new String[]{start, end};
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
	
	/**
	 * 获取下一天
	 * @author 朱春平
	 */
	public static String getNextDate(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DATE, 1);
		return DateTimeHelper.formatDateTimetoString(ca.getTime(), DateTimeHelper.FMT_yyyyMMdd);
	}
	
	/**
	 * 获取下一天
	 * @author 朱春平
	 */
	public static String getNextDate() {
		return getNextDate(new Date());
	}
	
	/**
	 * 获取下一天
	 * @author 朱春平
	 */
	
	public static String getNextDate(String dateTimeStr) {
		Date date = DateTimeHelper.parseToDate(dateTimeStr);
		return getNextDate(date);
	}
	
	public static String getWeekday(String date){//必须yyyy-MM-dd
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = null;
		try {
			d = sd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdw.format(d);
	}
	
	/**
	 * 将日统计处理成周统计
	 * @author 张宏利
	 * @since 2017年9月29日
	 * @param dataList 待处理列表
	 * @param dateColumn 日期字段名
	 * @param addSet 需要相加的字段则和之前的值加起来
	 * @param groupKey 需要再次分组的字段（默认是按时间维度分组，但可能还不够，要时间+类型才表示唯一，则需要传这个字段，可传null）
	 * @param weeksList 周维度列表，必须格式：[2017-07-01~2017-07-02, 2017-07-03~2017-07-09]
	 * @return
	 */
	public static List<Map<String, Object>> changeDayToWeekList(List<Map<String, Object>> dataList, String dateColumn, Set<String> addSet, String[] groupKey, List<String> weeksList) {
		// 列表为空或字段名没传
		if (dataList == null || dataList.isEmpty() || StringUtils.isBlank(dateColumn)) {
			return dataList;
		}
		// 日期分组
		Map<String, List<Map<String, Object>>> dataGroupMap = dataList.stream().collect(Collectors.groupingBy(map -> {
			String dateStr = String.valueOf(map.get(dateColumn)).substring(0, 10);
			for (String weekDay : weeksList) {
				String[] weekArr = weekDay.split("~");
				if (dateStr.compareTo(weekArr[0]) >= 0 && dateStr.compareTo(weekArr[1]) <= 0) {
					if(groupKey != null) {
						weekDay += "&";
						for (String key : groupKey) {
							weekDay += map.get(key) + "_";
						}
					}
					return weekDay;
				}
			}
			return "";
		}));
		// 把相同日期的合并到一个项
		List<Map<String, Object>> resultList = new LinkedList<>();
		for (Entry<String, List<Map<String, Object>>> mapEntry : dataGroupMap.entrySet()) {
			Map<String, Object> tmpMap = new HashMap<>();
			for (Map<String, Object> map : mapEntry.getValue()) {
				for (Entry<String, Object> columnEntry : map.entrySet()) {
					if (addSet.contains(columnEntry.getKey())) {// 需要相加的字段则和之前的值加起来
						Integer oldVal = StringUtil.parseInteger(tmpMap.get(columnEntry.getKey()));
						Integer nowVal = StringUtil.parseInteger(columnEntry.getValue());
						tmpMap.put(columnEntry.getKey(), oldVal + nowVal);
					} else if (!tmpMap.containsKey(columnEntry.getKey())) {// 其它字段之前没有put过才put
						if (dateColumn.equals(columnEntry.getKey())) {
							tmpMap.put(columnEntry.getKey(), mapEntry.getKey().split("&")[0]);
						} else {
							tmpMap.put(columnEntry.getKey(), columnEntry.getValue());
						}
					}
				}
			}
			resultList.add(tmpMap);
		}
		return resultList;
	}

	/**
	 * @Title 计算薪资周期的工具
	 * 			格式1 XX，YY 上个周期的结算日，本周期结算日
	 * 			格式2 YY 本周期结算日
	 *
	 * @Author lcb
	 * @Date 2018/3/1
	 * @Param
	 **/
	public static Date[] getWageCycleDate(String lastWageCountDay, String wageAccountingDay) {
		// 直接查询当前考核周期内的配置，因为数据库每天在匹配数据
		if(StringUtils.isBlank(wageAccountingDay)) {
			wageAccountingDay = "01";
		}else {
			if(StringUtils.isNotBlank(lastWageCountDay)) {
				// 有修改情况
				return getWageCycleDate2(lastWageCountDay, wageAccountingDay);
			}
		}
		return getWageCycleDate1(Integer.valueOf(wageAccountingDay));
	}


	private static Date[] getWageCycleDate2(String lastMonthCountDayStr, String thisMonthCountDayStr) {

		// 组装核算月数据
		Calendar calendar = Calendar.getInstance();
		// 判断是否是29,30,31号
		Integer thisMonthCountDay = Integer.valueOf(thisMonthCountDayStr);
		Integer actualMaximum = calendar.getActualMaximum(Calendar.DATE);
		if (thisMonthCountDay > actualMaximum) {
			thisMonthCountDay = actualMaximum;
		}

		// 组装核算月数据
		Calendar lastCalendar = Calendar.getInstance();
		lastCalendar.add(Calendar.MONTH, -1);
		// 判断是否是29,30,31号
		Integer lastMonthCountDay = Integer.valueOf(lastMonthCountDayStr);
		Integer lastMaximun = lastCalendar.getActualMaximum(Calendar.DATE);
		if (lastMonthCountDay > lastMaximun) {
			lastMonthCountDay = lastMaximun;
		}

		// 组装核算月数据
		Calendar wageAccountDayEnd = Calendar.getInstance();
		wageAccountDayEnd.set(Calendar.DAY_OF_MONTH, thisMonthCountDay);
		wageAccountDayEnd.set(Calendar.HOUR_OF_DAY, 0);
		wageAccountDayEnd.set(Calendar.MINUTE, 0);
		wageAccountDayEnd.set(Calendar.SECOND, 0);
		Calendar wageAccountDayStart = Calendar.getInstance();
		wageAccountDayStart.add(Calendar.MONTH, -1);
		wageAccountDayStart.set(Calendar.DAY_OF_MONTH, lastMonthCountDay);
		wageAccountDayStart.set(Calendar.HOUR_OF_DAY, 0);
		wageAccountDayStart.set(Calendar.MINUTE, 0);
		wageAccountDayStart.set(Calendar.SECOND, 0);

		if(calendar.after(wageAccountDayEnd)) {
			wageAccountDayStart.add(Calendar.MONTH, 1);
			Integer maxDay = wageAccountDayStart.getActualMaximum(Calendar.DATE);
			if(lastMonthCountDay < maxDay) {
				wageAccountDayStart.set(Calendar.DAY_OF_MONTH, maxDay);
			}
			wageAccountDayEnd.add(Calendar.MONTH, 1);
		}
		return new Date[]{wageAccountDayStart.getTime(), wageAccountDayEnd.getTime()};
	}

	public static Date[] getWageCycleDate1(Integer wageAccountingDayInteger) {

		// 组装核算月数据
		Calendar calendar = Calendar.getInstance();
		// 判断是否是29,30,31号
		Integer actualMaximum = calendar.getActualMaximum(Calendar.DATE);
		if (wageAccountingDayInteger > actualMaximum) {
			wageAccountingDayInteger = actualMaximum;
		}

		// 组装核算月数据
		Calendar wageAccountDayEnd = Calendar.getInstance();
		wageAccountDayEnd.set(Calendar.DAY_OF_MONTH, wageAccountingDayInteger);
		wageAccountDayEnd.set(Calendar.HOUR_OF_DAY, 0);
		wageAccountDayEnd.set(Calendar.MINUTE, 0);
		wageAccountDayEnd.set(Calendar.SECOND, 0);
		Calendar wageAccountDayStart = Calendar.getInstance();
		wageAccountDayStart.set(Calendar.DAY_OF_MONTH, wageAccountingDayInteger);
		wageAccountDayStart.add(Calendar.MONTH, -1);
		wageAccountDayStart.set(Calendar.HOUR_OF_DAY, 0);
		wageAccountDayStart.set(Calendar.MINUTE, 0);
		wageAccountDayStart.set(Calendar.SECOND, 0);

		if(calendar.after(wageAccountDayEnd)) {
			wageAccountDayStart.add(Calendar.MONTH, 1);
			wageAccountDayEnd.add(Calendar.MONTH, 1);
		}
		return new Date[]{wageAccountDayStart.getTime(), wageAccountDayEnd.getTime()};
	}


	public static String getAssessMentMonth(String wageAccountingDay, Integer addMonth) {
		if(StringUtils.isBlank(wageAccountingDay)) {
			wageAccountingDay = "01";
		}
		// 15号为中间点 大于15号算下月 15号以内算当月

		Calendar calendar = Calendar.getInstance();

		Integer accountDay = StringUtil.parseInteger(wageAccountingDay);
		// 获取系统参数

		if(calendar.get(Calendar.DAY_OF_MONTH) < accountDay) {
			// 上月
		}else {
			// 本月
			calendar.add(Calendar.MONTH, 1);
		}

		Integer month = calendar.get(Calendar.MONTH);
		if(null != addMonth && addMonth > 0) {
			month = month + addMonth;
		}
		if(month == 0) {
			month =  12;
			calendar.add(Calendar.YEAR, -1);
		}

		String m = month + "";
		if(month < 10) {
			m = "0"+month;
		}
		return calendar.get(Calendar.YEAR)+"-"+m;
	}

	public static Date getThisWeekMonday() {
		Calendar cal = Calendar.getInstance();
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}

	/**
	 * @tag 获取今天0点
	 * @author 邓永洪
	 * @since 2018/5/19
	 */
	public static Date todayFirstDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * @tag 获取今天 23:59:59
	 * @author 邓永洪
	 * @since 2018/5/19
	 */
	public static Date todayLastDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static String[] convertTimeRangeToFrontYear(String startTime, String endTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(startTime));
		calendar.add(Calendar.YEAR, -1);
		String resultOneTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		calendar.setTime(DateTimeHelper.parseToDate(endTime));
		calendar.add(Calendar.YEAR, -1);
		String resultTwoTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd)+" 23:59:59";
		return new String[]{resultOneTime, resultTwoTime};
	}

	public static void main(String[] args) throws Exception {
		String[] recentHalfYear = getRecentHalfYear();
		System.out.println(recentHalfYear[0]);
		System.out.println(recentHalfYear[1]);

	}


	public static String[] getToDayTime() {
		Date date1 = todayFirstDate();
		Date date2 = todayLastDate();
		return new String[]{DateUtil.DateToString(date1), DateUtil.DateToString(date2)};
	}

	/**
	 * lcb
	 * 以今天为结束点，向前推6月
	 * @return
	 * @throws Exception
	 */
	public static String[] getRecentWeek() {
		Calendar calendar = Calendar.getInstance();
		String endDate = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, -6);
		String startDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd + " 00:00:00");
		return new String[]{ startDate,endDate};
	}

	/**
	 * lcb
	 * 以今天为结束点，向前推6月
	 * @return
	 * @throws Exception
	 */
	public static String[] getRecentHalfYear() {
		Calendar calendar = Calendar.getInstance();
		String endDate = DateTimeHelper.formatDateTimetoString(calendar.getTime());

		calendar.add(Calendar.MONTH, -5);
		String startDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(), "yyyy-MM-01 00:00:00");
		return new String[]{ startDate,endDate};
	}


	/**
	 * 时间段格式化
	 * @param stringDate
	 * @return lcb
	 * @throws Exception
	 */
	public static Date[] formateStringDate(String stringDate) {
		try {
			Date[] date= new Date[]{null,null};
			if(org.apache.commons.lang3.StringUtils.isNotBlank(stringDate) && stringDate.contains(" - ")){
				String[] time = stringDate.split(" - ");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				/***起始时间***/
				Date date1 = sdf.parse(time[0]+" 00:00:00" );
				/***结束时间***/
				Date date2 = sdf.parse(time[1]+" 23:59:59");
				date = new Date[] {date1, date2};
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 时间段格式化不带时分秒
	 * @param stringDate
	 * @return lcb
	 * @throws Exception
	 */
	public static Date[] formateStringDateTwo(String stringDate) {
		try {
			Date[] date= new Date[]{null,null};
			if(org.apache.commons.lang3.StringUtils.isNotBlank(stringDate) && stringDate.contains(" - ")){
				String[] time = stringDate.split(" - ");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				/***起始时间***/
				Date date1 = sdf.parse(time[0]);
				/***结束时间***/
				Date date2 = sdf.parse(time[1]);
				date = new Date[] {date1, date2};
			}
			return date;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public static Date[] getToDayDate() {
		Date date1 = todayFirstDate();
		Date date2 = todayLastDate();
		return new Date[]{date1, date2};
	}

	/**
	 * 获取当前时间的年月 例如 2020-1-13 返回 20201
	 */
//	public static String getYearAndMoth(String stringDate) {
//		return "" + getYear(stringDate) + getMonth(stringDate);
//	}

	/**
	 * 获取两个时间段内的年月 例如 Arrays.asList("202001", "201912")
	 */
	public static List<String> getTimeList(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		int calendarType = Calendar.MONTH;

		List<String> result = new ArrayList<>();
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		try {
			min.setTime(sdf.parse(startDate));
			min.add(calendarType, 0);
			max.setTime(sdf.parse(endDate));
			max.add(calendarType, 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		while (min.before(max)) {
			result.add(sdf.format(min.getTime()).replace("-", ""));
			min.add(calendarType, 1);
		}

		return result;
	}

	//判断选择的日期是否是本月
	public static boolean isThisMonth(long time) {
		return isThisTime(time, "yyyy-MM");
	}

	private static boolean isThisTime(long time, String pattern) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String param = sdf.format(date);//参数时间
		String now = sdf.format(new Date());//当前时间
		if (param.equals(now)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取某一天的第一秒 00:00:00
	 * @param date
	 * @return
	 */
	public static Date getFirstSecondOfDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取某一天的最后一秒  23:59:59
	 * @param date
	 * @return
	 */
	public static Date getLastSecondOfDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
	}


}


