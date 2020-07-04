package com.myfun.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.dto.ErpFunTrackDto;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import org.apache.commons.beanutils.BeanUtils;

public class SortUtil {

	/**
	 * 列表排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param resultList 数据集
	 * @param byArrs 以什么排序，可以多个字段排序
	 * @param isAsc true=升序 false=降序
	 */
	public static void collectionsSort(List<? extends Object> resultList, final String[] byArrs, final boolean isAsc){
		Collections.sort(resultList, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Integer[] ids = getArrLastIds(o1, o2, byArrs, new Integer[]{0, 0}, 0);
				if(isAsc){
					return ids[0] - ids[1];
				}
				return ids[1] - ids[0];
			}
		});
	}
	
	/**
	 * 列表排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param resultList 数据集
	 * @param byArrs 以什么排序
	 * @param isAsc true=升序 false=降序
	 */
	public static void collectionsSortMap(List<Map<String,Object>> resultList, final String byStr, final boolean isAsc){
		Collections.sort(resultList, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				if(isAsc){
					return String.valueOf(o1.get(byStr)).compareTo(String.valueOf(o2.get(byStr)));
				}
				return String.valueOf(o2.get(byStr)).compareTo(String.valueOf(o1.get(byStr)));
			}
			
		});
	}
	
	/**
	 * 列表排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param resultList 数据集
	 * @param byArrs 以什么排序，可以多个字段排序
	 * @param isAsc true=升序 false=降序
	 */
	public static void collectionsSortMap(List<Map<String,Object>> resultList, final String[] byArrs, final boolean isAsc){
		Collections.sort(resultList, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				Integer[] ids = getArrLastOffMapIds(o1, o2, byArrs, new Integer[]{0, 0}, 0);
				if(isAsc){
					return ids[0] - ids[1];
				}
				return ids[1] - ids[0];
			}

		});
	}
	private static Integer[] getArrLastOffMapIds(Map<String, Object> o1, Map<String, Object> o2, String[] byArrs,
			Integer[] ids, int index) {
		if(byArrs.length <= index){return ids;}
		try {
			ids[0] = StringUtil.paseInteger(String.valueOf(o1.get(byArrs[index])), 0);
			ids[1] = StringUtil.paseInteger(String.valueOf(o2.get(byArrs[index])), 0);
			if(ids[0].equals(ids[1])){
				return getArrLastIds(o1, o2, byArrs, ids, index+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ids = new Integer[]{0,0};
		}
		return ids;
	}

	/**
	 * 递归获取o1 o2 的byArrs指定的ID，用于排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param o1 对象1
	 * @param o2 对象2
	 * @param byArrs 需要排序的项
	 * @param ids 返回的结果数组
	 * @param index 当前索引
	 * @return
	 */
	private static Integer[] getArrLastIds(Object o1, Object o2, String[] byArrs, Integer[] ids, int index){
		if(byArrs.length <= index){return ids;}
		try {
			ids[0] = StringUtil.paseInteger(BeanUtils.getProperty(o1, byArrs[index]), 0);
			ids[1] = StringUtil.paseInteger(BeanUtils.getProperty(o2, byArrs[index]), 0);
			if(ids[0].equals(ids[1])){
				return getArrLastIds(o1, o2, byArrs, ids, index+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ids = new Integer[]{0,0};
		}
		return ids;
	}
	
	/**
	 * 对日期的list进行排序
	 * @param arrayList 原始数据
	 * @param dateCoulmn 日期名字
	 * @param dateType 日期类型，0=日统计 1=周统计 2=月统计
	 */
	public static void sortForDateForListMap(List<Map<String, Object>> arrayList, String dateCoulmn, String dateType){
		arrayList.sort((val1, val2) -> {
			String date1 = String.valueOf(val1.get(dateCoulmn));
			String date2 = String.valueOf(val2.get(dateCoulmn));
			return compareTwoDateByType(date1, date2, dateType);
		});
	}
	
	/**
	 * 对日期的list进行排序
	 * @param arrayList 原始数据
	 * @param dateCoulmn 日期名字
	 * @param dateType 日期类型，0=日统计 1=周统计 2=月统计
	 */
	public static <T> void sortForDateForListObj(List<T> arrayList, String dateCoulmn, String dateType){
		arrayList.sort((val1, val2) -> {
			try {
				String date1 = BeanUtils.getProperty(val1, dateCoulmn);
				String date2 = BeanUtils.getProperty(val2, dateCoulmn);
				return compareTwoDateByType(date1, date2, dateType);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		});
	}
	
	/**
	 * 处理和对比日期
	 * @author 张宏利
	 * @since 2017年7月31日
	 * @param date1
	 * @param date2
	 * @param dateType
	 * @return
	 */
	private static int compareTwoDateByType(String date1, String date2, String dateType) {
		if("2".equals(dateType)) {
			if(date1.length() > 7) {
				date1 = date1.substring(0, 7);
			}
			if(date2.length() > 7) {
				date2 = date2.substring(0, 7);
			}
			date1 += "-01";
			date2 += "-01";
		} else {
			date1 = date1.substring(0, 10);
			date2 = date2.substring(0, 10);
		}
		return DateTimeHelper.compareTwoDate(DateTimeHelper.parseToDate(date2), DateTimeHelper.parseToDate(date1));
	}

	/**
	 * 列表排序
	 * @param resultList 数据集
	 * @param byArrs 以什么排序
	 * @param isAsc true=升序 false=降序
	 */
	public static void collectionsSortTrackList(List<ErpFunTrackDto> resultList){
		Collections.sort(resultList, new Comparator<ErpFunTrackDto>() {
			@Override
			public int compare(ErpFunTrackDto o1, ErpFunTrackDto o2) {
				// 按照学生的年龄进行升序排列
				if (o1.getTrackStickTime().before(o2.getTrackStickTime())) {
					return 1;
				}
				if (o1.getTrackStickTime().equals(o2.getTrackStickTime())) {
					return 0;
				}
				return -1;
			}

		});
	}
}
