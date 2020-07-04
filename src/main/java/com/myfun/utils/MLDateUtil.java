package com.myfun.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Date类工具类
 * @author Administrator
 *
 */
public class MLDateUtil {
	
	public final static String GENERAL_FORMATTER="yyyy-MM-dd";
	public final static String GENERAL_FORMHMS="yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_YYYY_MM = "yyyy-MM";
	public final static String FORMAT_HH_MM_SS = "HH:mm:ss";
	public final static String FORMAT_OLD = "yyyy/MM/dd";
	public final static String FORMAT_YYYY_NIAN_MM_YUE_MM_RI = "yyyy年MM月dd日";
	public final static String FORMAT_YYYY_NIAN_M_YUE_M_RI = "yyyy年M月d日";
	
	public final static String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm" ;

	public final static String FORMAT_YYYY_MM_DD_HH = "yyyy-MM-dd HH" ;
	
	public final static String FORMAT_MM_YUE_MM_RI = "MM月dd日";

	/**
	 * 将时间字符串变成date
	 * @param dateStr
	 * @return
	 */
	public static Date convertStrToDate(String dateStr, String formatter){
		if(StringUtils.isEmpty(dateStr)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("请确认时间的格式为"+formatter);
		}
		
		return date;
	}
	
	/**
	 * 将字符串 变成时间
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String convertDateToStr(Date date, String formatter){
		if(null == date){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		String  dateStr = sdf.format(date);
		return dateStr;
	}
	
	/**
	 * 将字符串 变成时间,格式为yyyy-MM-dd
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String convertDateToStr(Date date){
		if(date==null) return null;
		return convertDateToStr(date,GENERAL_FORMATTER);
	}
	
	/**
	 * 将字符串 变成时间,格式为yyyy-MM-dd
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static Date convertStrToDate(String dateStr){
		if(StringUtils.isEmpty(dateStr)) return null;
		return convertStrToDate(dateStr,GENERAL_FORMATTER);
	}
	
	/**
	 * 将字符串 变成时间,格式为yyyy-MM-dd hh:mm:ss
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static Date convertStrToDateHms(String dateStr){
		if(StringUtils.isEmpty(dateStr)) return null;
		return convertStrToDate(dateStr,GENERAL_FORMHMS);
	}
	
	/**
	 * 判断日期是否在strartTime日期和endTime日期之间  大于startTime,小于endTime
	 * 将时间变为字符串,格式为yyyy-MM-dd hh:mm:ss
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String convertDateToStrHms(Date date){
		if(date != null){
			return convertDateToStr(date,GENERAL_FORMHMS);
		}
		return null;
	}
	
	/**
	 * 判断日期是否在strartTime日期和endTime日期之间
	 * @param startTime
	 * @param endTime
	 * @param needJudgeDate
	 * @return
	 */
	public static boolean judgeDateBetweenStartTimeAndEndTime(Date startTime, Date endTime, Date needJudgeDate){
		Date newStartTime = MLDateUtil.convertStrToDate(MLDateUtil.convertDateToStr(startTime, "yyyy-MM-dd"), "yyyy-MM-dd");
		Date newEndTime = MLDateUtil.convertStrToDate(MLDateUtil.convertDateToStr(endTime, "yyyy-MM-dd"), "yyyy-MM-dd");
		Date newNeedJudgeDate = MLDateUtil.convertStrToDate(MLDateUtil.convertDateToStr(needJudgeDate, "yyyy-MM-dd"), "yyyy-MM-dd");
		return ((newNeedJudgeDate.after(newStartTime)) && (newNeedJudgeDate.before(newEndTime)));
	}
	
	/**
	 * 判断日期是否在strartTime日期和endTime日期之间  大于等于startTime,小于等于endTime
	 * @param startTime
	 * @param endTime
	 * @param needJudgeDate
	 * @return
	 */
	public static boolean judgeDateBetweenStartTimeAndEndTimeAndEquals(Date startTime, Date endTime, Date needJudgeDate){
		Date newStartTime = MLDateUtil.convertStrToDate(MLDateUtil.convertDateToStr(startTime, "yyyy-MM-dd"), "yyyy-MM-dd");
		Date newEndTime = MLDateUtil.convertStrToDate(MLDateUtil.convertDateToStr(endTime, "yyyy-MM-dd"), "yyyy-MM-dd");
		Date newNeedJudgeDate = MLDateUtil.convertStrToDate(MLDateUtil.convertDateToStr(needJudgeDate, "yyyy-MM-dd"), "yyyy-MM-dd");
		return ((!newNeedJudgeDate.before(newStartTime)) && (!newNeedJudgeDate.after(newEndTime)));
	}
	
	/**
	 * 得到只有年和月的Date
	 * @param date
	 * @return
	 */
	public static Date getDateYyyyMmDd(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 *得到连个时间相差的秒钟时间
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDifferSecound(Date date1, Date date2){
		return (date1.getTime() - date2.getTime())/1000;
	}
	
	/**
	 * 得到两个时间相差的分钟时间
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDifferMinute(Date date1, Date date2){
		long time = date1.getTime() - date2.getTime();
		long minute = time/(60*1000);
		return minute;
	}
	
	/**
	 * 得到两个时间相差的小时
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDifferHour(Date date1, Date date2){
		long time = date1.getTime() - date2.getTime();
		long hour = time/(60*60*1000);
		return hour;
	}
	
	/**
	 * 得到两个时间相差的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Long getDifferDay(Date date1, Date date2){
		return getDifferDay(date1, date2, false);
	}
	
	public static Long getDifferDay(Date date1, Date date2,boolean isNoHMS){
		if(date1==null || date2==null){
			return 0L;
		}
		if(isNoHMS){ // 去除时分秒所得的天数,否则算出来不对
			date1 = convertStrToDate(convertDateToStr(date1));
			date2 = convertStrToDate(convertDateToStr(date2));
		}
		long time = date1.getTime() - date2.getTime();
		long day = time/(60*60*1000*24);
		return day;
	}
	
	/**
	 * 得到两个时间相差的年
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDifferYear(Date date1, Date date2){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		int year1 = calendar.get(Calendar.YEAR);
		calendar.setTime(date2);
		int year2 = calendar.get(Calendar.YEAR);
		return Math.abs(year1-year2);
	}
	/**
	 * 得到两个时间相差的小时数
	 * @param time1 格式为：HH:mm
	 * @param time2 格式为: HH:mm
	 * @return
	 */
	public static long getDifferHour(String time1, String time2){
		Integer hour1 = Integer.parseInt(time1.split(":")[0]);
		Integer minute1 = Integer.parseInt(time1.split(":")[1]);
		Integer hour2 = Integer.parseInt(time2.split(":")[0]);
		Integer minute2 = Integer.parseInt(time2.split(":")[1]);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.HOUR_OF_DAY, hour1);
		calendar1.set(Calendar.MINUTE, minute1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.HOUR_OF_DAY, hour2);
		calendar2.set(Calendar.MINUTE, minute2);
		return getDifferHour(calendar1.getTime(), calendar2.getTime());
	}
	
	/**
	 * 得到两个时间相差的分钟数
	 * @param time1 格式为：HH:mm
	 * @param time2 格式为: HH:mm
	 * @return
	 */
	public static long getDifferMinute(String time1, String time2){
		Integer hour1 = Integer.parseInt(time1.split(":")[0]);
		Integer minute1 = Integer.parseInt(time1.split(":")[1]);
		Integer hour2 = Integer.parseInt(time2.split(":")[0]);
		Integer minute2 = Integer.parseInt(time2.split(":")[1]);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.HOUR_OF_DAY, hour1);
		calendar1.set(Calendar.MINUTE, minute1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.HOUR_OF_DAY, hour2);
		calendar2.set(Calendar.MINUTE, minute2);
		return getDifferMinute(calendar1.getTime(), calendar2.getTime());
	}
	
	/**
	 * 将分钟转换成小时
	 * @param minute
	 * @return
	 */
	public static BigDecimal getHour(long minute){
		return new BigDecimal(minute).divide(new BigDecimal(60),2,BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 比较两个日期 
	 * 结果如果大于0则date1大于date2 小于0则是date1小于date2, 0则是相等
	 * @param date1
	 * @param date2
	 * @return 
	 */
	public static int compareDate(Date date1, Date date2){
		return date1.compareTo(date2);
	}
	
	public static boolean isCommonOneDay(Date date1, Date date2){
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		
		return ((calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR))
				&& (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH))
				&& (calendar1.get(Calendar.DATE) == calendar2.get(Calendar.DATE)));
	}
	
	/**
	 * 获取2个日期之间的天数(flag=1时，间隔的天数； flag=1时，去掉周日的间隔天数)
	 * @param begin
	 * @param end
	 * @param flag
	 * @return
	 * @author linyongan
	 * 2012-11-22
	 * @return int
	 */
	public static int countDays(String begin,String end,int flag){  
		int days = 1;    
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar c_b = Calendar.getInstance();  
		Calendar c_e = Calendar.getInstance();    
		try{   
			c_b.setTime(df.parse(begin));   
			c_e.setTime(df.parse(end));      
			while(c_b.before(c_e)){   
				days++;  
				if(flag==1 && c_b.get(Calendar.DAY_OF_WEEK)==1){
					days--;
				}
				c_b.add(Calendar.DAY_OF_YEAR, 1);   
			}     
		}catch(ParseException pe){   
//			System.out.println("日期格式必须为：yyyy-MM-dd；如：2012-1-1.");
			pe.printStackTrace();
		}   
		return days; 
	}

	/**
	 * 将日期转换成字符串
	 * @param date
	 * @param format
	 * @return 
	 * @return
	 */
	public static final  <T extends Date>String dateConvertStr(T date,String format){
		Assert.notNull(date, "日期为空！");
		SimpleDateFormat sd=new SimpleDateFormat(format);
		String str=sd.format(date);
		return str;
	}
	
	public static final <T extends Date>int getYear(T date){
		return getDateItems(date, Calendar.YEAR);
	}
	
	/**
	 * 功能说明：返回日期中的任何元素
	 * @param field：Calendar类中的常数，如YEAR/MONTH/DAY_OF_MONTH...
	 * <br><b><big>注意返回的month一月份是从0开始的！</big></b>
	 */
	public static final <T extends Date>int getDateItems(Date dDate, int field) {
		GregorianCalendar cl = new GregorianCalendar();
		cl.setTime(dDate);
		return cl.get(field);
	}

	/**
	 * 功能说明：得到日期
	 * @param dDate 传日的日期对象
	 * @return int日
	 */
	public static final <T extends Date>int getDay(Date dDate) {
		return getDateItems(dDate, Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 功能说明：得到月份
	 * @param dDate 传日的日期对象
	 * @return int得到月份
	 */
	public static int getMonth(Date dDate) {
		return getDateItems(dDate, Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取当前服务器日期
	 * @return
	 */
	public static Date getCurDate(){
		return new Date();
	}
	
	public static Date getCurDate(String format){
		Date date = new Date();
		date  = convertStrToDate(convertDateToStr(date, format),format);
		return date;
	}
	
	/**
	 * 获得时间差[分,秒,毫秒]
	 * @param begTime
	 * @param endTime
	 * @return
	 */
	public static String getDiffTime(Date begTime,Date endTime){
		 SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String begDate= dfs.format(begTime);
		String endDate= dfs.format(endTime);
	     long between = 0;
	     try {
	         Date begin = dfs.parse(begDate);
	         Date end = dfs.parse(endDate);
	         between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
	     } catch (Exception ex) {
	         ex.printStackTrace();
	     }
	     long day = between / (24 * 60 * 60 * 1000);
	     long hour = (between / (60 * 60 * 1000) - day * 24);
	     long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
	     long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
	     long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
	             - min * 60 * 1000 - s * 1000);
	    return  min + "分" + s + "秒" + ms + "毫秒";
	}
	
	/**
	 * 得到向前计算相隔多少天的日期
	 * @param d
	 * @param diff
	 * @return
	 */
	public static Date getDateByDays(Date d,int diff){		
		if(diff >=24855){			//大于这个就会往整数走
			diff =24855;
		}
		if(null==d) d = new Date();
		long t = (d.getTime()/1000-diff*24 * 60 * 60) * 1000;
		Date nd = new Date(t);
		return nd;
	}

	
	/**
	 * 日期月 的第一天
	 * @param d
	 * @return
	 */
	public static Date getFirstDay(Date d){		
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	/**
	 * 日期月 的最后一天
	 * @param d
	 * @return
	 */
	public static Date getLastDay(Date d){
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.MONTH, 1);//加一个月  得到下一下月
		 cal.set(Calendar.DAY_OF_MONTH, 1);//下一个月的第一天
		 cal.add(Calendar.DAY_OF_MONTH, -1);//减一天 给出日期的最后一天
		return cal.getTime();
	}
	
	/**
	 * 取日期的下一天
	 * @param d
	 * @return
	 */
	public static Date getNextDay(Date d){
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.DAY_OF_MONTH, 1);//下一天
		return cal.getTime();
	}
	
	/**
	 * 取日期的后N天
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getNextDay(Date d,int day){
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.DAY_OF_MONTH, day);//下一天
		return cal.getTime();
	}
	
	/**
	 * 取日期的上一天
	 * @param d
	 * @return
	 */
	public static Date getPrevDay(Date d){
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.DAY_OF_MONTH, -1);//上一天
		return cal.getTime();
	}
	
	public static Date getLastMonth(Date d){
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 int m = cal.get(Calendar.MONTH);
		 if(m>=0){
			 cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
			 cal.set(Calendar.DAY_OF_MONTH, 1);
		 }else{
			 cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)-1);
			 cal.set(Calendar.MONTH, 11);
			 cal.set(Calendar.DAY_OF_MONTH, 1);
		 }
			 
		 return cal.getTime();
	}
	
	public static Date getNextMonth(Date d){
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 int m = cal.get(Calendar.MONTH);
		 if(m<11){
			 cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
			 cal.set(Calendar.DAY_OF_MONTH, 1);
		 }else{
			 cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)+1);
			 cal.set(Calendar.MONTH, 0);
			 cal.set(Calendar.DAY_OF_MONTH, 1);
		 }
			 
		 return cal.getTime();
	}
	/**
	 * 按日期返回目录 2014/1/5
	 * @param d
	 * @return
	 */
	public static String getDirByDay(Date d){
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
	    int day = cal.get(Calendar.DATE);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int year = cal.get(Calendar.YEAR);
	    return year+File.separator+month+File.separator+day;
	}
	
	public static String getTimeDiffDesc(Date a,Date b){
		long s = MLDateUtil.getDifferSecound(a, b);
		if(s<30)  return "刚刚";
		long n = s/60;
		if(n<60) return n+"分钟前";
		if(n/60<24) return ((n%60==0)?n/60:(n/60+1)) +"小时前";
		if(n/(60*24)<30) return (n%(60*24)==0?(n/60*24):(n/(60*24)+1))+"天前";
		if(n/(60*24*30)<12) return (n%(60*24*30)==0?(n/(60*24*30)):(n/(60*24*30)+1))+"月前";
		return (n/(60*24*30*12)+1)+"年前"; 
	}
	
	public static String getTimeDesc(Date a,Date b){
		Long diffDay = getDifferDay(a, b,true);
		String hourSecond  = MLDateUtil.convertDateToStr(b, "HH:mm");
		int hour = Integer.parseInt(hourSecond.substring(0, hourSecond.indexOf(":")));
		String min = hourSecond.substring(hourSecond.indexOf(":")+1, hourSecond.length());
		String noonStr = hour>12?"下午":"上午";
		hour= hour>12?hour-12:hour;
		String dateStr=noonStr+" "+hour+":"+min;
		if(diffDay==1){//昨天
			dateStr = "昨天"+dateStr;
		}else if(diffDay==2){//前天
			dateStr = "前天"+dateStr;
		}else if(diffDay>2){
			if(diffDay<=5){
				dateStr = diffDay+"天前"+dateStr;
			}else{
				dateStr = MLDateUtil.convertDateToStr(b, "yy/MM/dd HH:mm");
			}
		}
		return dateStr;
	}
	public static String getTimeDesc(Date b){
		return getTimeDesc(new Date(),b);
	}
	
	/**
	 * 得到本周星期一
	 * @param d
	 * @return
	 */
	public static Date getCurrWeekMonday(Date d){
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int week=cal.get(Calendar.DAY_OF_WEEK)-1;  
	    if(week==0){//0代表周日
	    	cal.add(Calendar.DAY_OF_WEEK, -7);
	    }
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	
	/**
	 * 得到本周星期天
	 * @param d
	 * @return
	 */
	public static Date getCurrWeekSunday(Date d){
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int week=cal.get(Calendar.DAY_OF_WEEK)-1;  
	    if(week!=0){//0代表周日
	    	cal.add(Calendar.DAY_OF_WEEK, 7);
	    }
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}
	/**
	 * 一周前
	 * @param d
	 * @return
	 */
	public static Date getLastWeek(Date d){
		Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_WEEK, -7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}
	/**
	 * 一周后
	 * @param d
	 * @return
	 */
	public static Date getNextWeek(Date d){
		Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_WEEK, 7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}
	
	/**
	 * 获得当天0点时间
	 */
	public static Date getTimesmorning(){
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.MILLISECOND, 0);
	return cal.getTime();
	} 
	
	/**
	 * 得到时间特定的前后几个月
	 * @param d 时间
	 * @param index 跳动几个月
	 * @return
	 */
	public static Date getMonth(Date d,int index){
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
    	cal.add(Calendar.MONTH, index);
		return cal.getTime();
	}
	
	/**
	 * 取日期的前N个小时
	 */
	public static Date getPrevHour(Date time, int hour) {
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(time);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
		return calendar.getTime();
	} 
	public static void main(String[] args) {
		MLDateUtil.getDateByDays(
				MLDateUtil.getCurDate(), 3000);
		
		System.out.println(MLDateUtil.getDifferDay(MLDateUtil.convertStrToDate("2015-08-26"), MLDateUtil.convertStrToDate("2017-10-18")));
		System.out.println(MLDateUtil.convertDateToStr(MLDateUtil.getMonth(new Date(), -12)));
	}
	
	/**
	 * 将时间字符串变成date 加一天
	 * @param dateStr
	 * @return
	 */
	public static Date convertStrToDateVAddOne(String dateStr, String formatter){
		return convertStrToDateVAdd(dateStr,formatter,1);
	}
	
	/** 
	 * 将时间字符串变成date 并且加days天数 
	 * @param dateStr
	 * @return
	 */
	public static Date convertStrToDateVAdd(String dateStr, String formatter,Integer days){
		if(StringUtils.isEmpty(dateStr)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH,days==null?0:days);  
			date=cal.getTime(); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("请确认时间的格式为"+formatter);
		}
		
		return date;
	}
	
	public static String format(Date date, String formatter){
		return convertDateToStr(date, formatter);
	}
	public static Date format(String dateStr, String formatter){
		return convertStrToDate(dateStr, formatter);
	}
	/**
	 * 日期的加减秒
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date addSec(Date d,int sec){
		if(d==null){
			d = new Date();//参数日期为空 默认当前日期
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.SECOND, sec);//
		return cal.getTime();
	}
}
