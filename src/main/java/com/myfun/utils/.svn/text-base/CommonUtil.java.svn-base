package com.myfun.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


public class CommonUtil {
	
	/**
	 * 酷家乐的md5加密
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String KJL_MD5(final String input) throws NoSuchAlgorithmException {
		final MessageDigest md = MessageDigest.getInstance("MD5");
		final byte[] digest = md.digest(input.getBytes());
		final String result = byte2hex(digest);
		return result;
	}
	
	/**
	 * 酷家乐使用的
	 * @param digest
	 * @return
	 */
	private static String byte2hex(final byte[] digest) {
		String des = "";
		String tmp = null;
		for (final byte element : digest) {
			tmp = (Integer.toHexString(element & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
	
	/**
	 * 两个数相加，异常时返回0，
	 * @author 张宏利
	 * @since 2016年4月26日
	 * @param a 
	 * @param b 
	 * @return
	 */
	public static String add(String a, String b) {
		return String.valueOf(StringUtil.paseInteger(a, 0) + StringUtil.paseInteger(b, 0));
	}
	/**
	 * 判断两个字符串是否相同。并且都不能为null
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equals(String a, String b) {
		boolean flg = false;
		try {
			if (!isnull(a) && !isnull(b) && a.equals(b)) {
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flg;
	}
	/**
	 * 判断对象是否不为空，如果对象为ArrayList，且不为空，则还要判断是否有长度
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj) {
		return !isnull(obj);
	}
	/**
	 * 判断对象是否为空，如果对象为ArrayList，且不为空，则还要判断是否有长度
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isnull(Object obj) {
		List<?> list = null;
		String str = null;
		boolean flag = false;
		String[] strs = null;
		Long l;
		if (obj == null) {
			flag = true;
		} else {
			if ("ArrayList".equals(obj.getClass().getSimpleName())) {
				list = (ArrayList<?>) obj;
				if (list.size() == 0) {
					flag = true;
				}
			}
			if ("String[]".equals(obj.getClass().getSimpleName())) {
				strs = (String[]) obj;
				if (strs.length == 1) {
					if (isnull(strs[0].trim())) {
						flag = true;
					}
				}
			}
			if ("String".equals(obj.getClass().getSimpleName())) {
				str = (String) obj;
				str=str.trim();
				if (str.equals("")||str.toLowerCase().equals("null")||str.equals("undefined")) {
					flag = true;
				}
			}
			if ("Long".equals(obj.getClass().getSimpleName())) {
				l = (Long) obj;
				if (l == 0) {
					flag = true;
				}
			}
			// 为数组的情况,同时判断是否不存在任何元素
			if(obj.getClass().isArray()){
				Object[] objs = (Object[]) obj;
				return objs == null || objs.length <= 0;
			}
			// 为Map的情况,同时判断是否不存在任何键值对
			if(obj instanceof Map){
				Map<?,?> map = (Map<?,?>) obj;
				return map == null || map.size() <= 0;
			}
			// 为Collection的情况,同时判断是否不存在任何元素
			if(obj instanceof Collection){
				if(obj instanceof Set){
					Set<?> set = (Set<?>) obj;
					return set == null || set.size() <= 0;
				}
				if(obj instanceof List){
					List<?> paramList = (List<?>) obj;
					return paramList == null || paramList.size() <= 0;
				}
			}
		}
		return flag;
	}
	public static String toString(Object object){
		if(object==null){
			return "";
		}
		else {
			return object.toString();
		}
	}
	public static <T> T checkReturn(T object) throws Exception{
		if(object==null){
			throw new Exception("返回值不能为空");
		}
		return object; 
	}
	/**
	 * 将字符串解析为 double,空或者非法字符串将 解析为 0
	 * @author 朱春平
	 * @param param
	 * @return
	 */
	public static double parseToDouble(String param){
		if(isnull(param)){
			return 0;
		}
		try {
			return Double.valueOf(param);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 将字符串解析为 int,空或者非法字符串将 解析为 0
	 * @author 朱春平
	 * @param param
	 * @return
	 */
	public static int parseToInt(String param){
		if(isnull(param)){
			return 0;
		}
		try {
			return Integer.valueOf(param);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 获取下月第一天(用于按月的时间段查询,比如查5月数据,实际上查询的是 5-1 到 6-1 的数据)
	 * @author 朱春平
	 */
	public static String getFirstDateOfNextMonth() {
		return getFirstDateOfNextMonth(new Date());
	}
	/**
	 * 获取本月第一天
	 * @author 朱春平
	 */
	public static String getFirstDateOfMonth() {
		return getFirstDateOfMonth(new Date());
	}
	/**
	 * 获取下月第一天(用于按月的时间段查询,比如查5月数据,实际上查询的是 5-1 到 6-1 的数据)
	 * @author 朱春平
	 */
	public static String getFirstDateOfNextMonth(String dateTimeStr) {
		return getFirstDateOfNextMonth(DateTimeHelper.parseToDate(dateTimeStr));
	}
	/**
	 * 获取本月第一天
	 * @author 朱春平
	 */
	public static String getFirstDateOfMonth(String dateTimeStr) {
		return getFirstDateOfMonth(DateTimeHelper.parseToDate(dateTimeStr));
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
	/**
	 * 获取本月第一天
	 * @author 朱春平
	 */
	public static String getFirstDateOfMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH,1);
		return DateTimeHelper.formatDateTimetoString(ca.getTime(), DateTimeHelper.FMT_yyyyMMdd);
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
	
	/**
	 * 用于分割过长的IDs，用于解决in查询时超过2000个ID就会报错的问题
	 * @param keys 需要分割的长数组
	 * @param cutLen 分割后的小数组长度，如果 <=0 则默认1500
	 * @return
	 * @author 张宏利
	 */
	public static String[][] getCutArr(String[] keys, int cutLen){
		int subCloumLen = 1500;
		if(cutLen > 0) {
			subCloumLen = cutLen;
		}
		if(keys == null || keys.length <= 0){
			return new String[0][0];
		}
		int length = keys.length;
		int count = length / subCloumLen;
		int lastCount = length % subCloumLen;
		if(lastCount > 0) {
			count++;
		}
		String[][] arrResult = new String[count][];
		for (int i = 0; i < count; i++) {
			String[] subIds;
			if(i == count-1 && lastCount > 0) {
				subIds = new String[lastCount];// 末尾剩余的不足1500的部分
			} else {
				subIds = new String[subCloumLen];// 长度为1500的部分
			}
			for (int j = 0; j < subIds.length; j++) {
				subIds[j] = keys[(i*subCloumLen)+j];// 分割数组
			}
			arrResult[i] = subIds;
		}
		return arrResult;
	}
	
	/**
	 * 获取楼层信息,属于 低层/中层/高层/超高层
	 * @author 何传强
	 * @since 2017年6月22日
	 * @return
	 */
	public static Integer getBuildFloorType(Integer floor, Integer totalFloor) {
		Integer floorType = 1;
		if (null ==  floor || null == totalFloor) {
			return null;
		}
//		int intFloors = StringUtil.paseInteger(totalFloor, 0);
//		int intFloor = StringUtil.paseInteger(floor, 0);
////		缩短了的代码
//		if ((intFloors <= 10 && intFloor <= 3)
//				|| (intFloors >= 11 && intFloors <= 40 && intFloor <= intFloors / 3)
//				|| (intFloors > 40 && intFloor <= 40 / 3)
//			) {
//			// 底层
//		}
//		if ((intFloors <= 10 && 3 < intFloor && intFloor <= 6)
//				|| (intFloors >= 11 && intFloors <= 40 && intFloors / 3 < intFloor && intFloor <= intFloors * (2 / 3))
//				|| (intFloors > 40 && 40 / 3 < intFloor && intFloor <= (40 / 3) * 2)
//				) {
//			// 中层
//		}
//		if ((intFloors <= 10 && intFloor > 6)
//				|| (intFloors >= 11 && intFloors <= 40 && intFloor > intFloors * (2 / 3))
//				|| (intFloors > 40 && (40 / 3) * 2 < intFloor && intFloor <= 40)
//				) {
//			// 高层
//		}
//		if (intFloor > 40) {
//			// 超高层
//		}
		// 总楼层低于10
		// 低层 = 1, 中层 = 2, 高层 = 3, 4 = 超高层
		if (totalFloor <= 10) {
			if (floor <= 3) {
				floorType = 1;
			} else if (3 < floor && floor <= 6) {
				floorType = 2;
			} else {
				floorType = 3;
			}
		} else if (totalFloor >= 11 && totalFloor <= 40) {// 总楼层11--40
			int result = totalFloor / 3;
			if (floor <= result) {
				floorType = 1;
			} else if (result < floor && floor <= totalFloor * (2 / 3)) {
				floorType = 2;
			} else {
				floorType = 3;
			}
		} else if (totalFloor > 40) {// 总楼层>40
			if (floor <= 40 / 3) {
				floorType = 1;
			} else if (40 / 3 < floor && floor <= (40 / 3) * 2) {
				floorType = 2;
			} else if ((40 / 3) * 2 < floor && floor <= 40) {
				floorType = 3;
			} else {
				floorType = 4;
			}
		}
		return floorType;
	}


}
