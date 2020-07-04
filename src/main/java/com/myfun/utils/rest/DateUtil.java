package com.myfun.utils.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
    private static final Object object = new Object();
	/**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd
     */
	public static final int DEFAULT = 0;
	public static final int YM = 1;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd
     * 
     */
    public static final int YMR_SLASH = 11;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMdd
     * 
     */
    public static final int NO_SLASH = 2;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMM
     * 
     */
    public static final int YM_NO_SLASH = 3;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm:ss
     * 
     */
    public static final int DATE_TIME = 4;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMddHHmmss
     * 
     */
    public static final int DATE_TIME_NO_SLASH = 5;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm
     * 
     */
    public static final int DATE_HM = 6;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm:ss
     * 
     */
    public static final int TIME = 7;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm
     * 
     */
    public static final int HM = 8;
    
    /**
     * 变量：日期格式化类型 - 格式:HHmmss
     * 
     */
    public static final int LONG_TIME = 9;
    /**
     * 变量：日期格式化类型 - 格式:HHmm
     * 
     */
    
    public static final int SHORT_TIME = 10;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd HH:mm:ss
     */
    public static final int DATE_TIME_LINE = 12;
	public static String dateToStr(Date date, int type) {
        switch (type) {
        case DEFAULT:
            return dateToStr(date);
        case YM:
            return dateToStr(date, "yyyy/MM");
        case NO_SLASH:
            return dateToStr(date, "yyyyMMdd");
        case YMR_SLASH:
        	return dateToStr(date, "yyyy-MM-dd");
        case YM_NO_SLASH:
            return dateToStr(date, "yyyyMM");
        case DATE_TIME:
            return dateToStr(date, "yyyy/MM/dd HH:mm:ss");
        case DATE_TIME_NO_SLASH:
            return dateToStr(date, "yyyyMMddHHmmss");
        case DATE_HM:
            return dateToStr(date, "yyyy/MM/dd HH:mm");
        case TIME:
            return dateToStr(date, "HH:mm:ss");
        case HM:
            return dateToStr(date, "HH:mm");
        case LONG_TIME:
            return dateToStr(date, "HHmmss");
        case SHORT_TIME:
            return dateToStr(date, "HHmm");
        case DATE_TIME_LINE:
            return dateToStr(date, "yyyy-MM-dd HH:mm:ss");
        default:
            throw new IllegalArgumentException("Type undefined : " + type);
        }
    }
	public static String dateToStr(Date date,String pattern) {
	       if (date == null || date.equals(""))
	    	 return null;
	       SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	       return formatter.format(date);
    } 

    public static String dateToStr(Date date) {
        return dateToStr(date, "yyyy/MM/dd");
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


}
