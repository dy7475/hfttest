package com.myfun.framework.utils;

import org.apache.commons.lang.StringUtils;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;

import java.util.*;

/**
 * service层一些通用的帮助类
 * @author 张宏利
 * @since 2017年8月4日
 */
public class CommonUtil {
	
	/**
	 * 转换跟进的核心信息
	 * @author 张宏利
	 * @since 2017年8月4日
	 * @param trackContent
	 * @param caseType
	 * @param phoneShow
	 * @return
	 */
	public static String convertSecretInfo(String trackContent, String caseType, boolean phoneShow) {
		String result = "";
		if (StringUtils.isBlank(trackContent)) {
			return result;
		}
		String[] contents = StringUtil.split(trackContent, "\n");
		if (contents.length <= 0) {
			result = trackContent;
		}
		Set<String> decodeFieldsSet = new HashSet<>();
		for (int i = 0; i < Const.decodeFieldsCN.length; i++) {
			String enCodeField = Const.decodeFieldsCN[i];// 需要加密的字段
			if ("楼".equals(enCodeField) && (Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)
					|| Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType))) {
				// 客源数据楼不属于加密范围
				continue;
			}
			for (int j = 0; j < contents.length; j++) {
				String[] items = StringUtil.split(contents[j], ":");
				if (items.length > 0) {
					if (items[0].contains("核验编号") || items[0].contains("权证编号") || items[0].contains("产权证号")) {
						continue;
					}
					if ((items[0].endsWith(enCodeField) && contents[j].indexOf(">>") >= 0)
							|| (!phoneShow && items[0].contains("电话") && contents[j].indexOf(">>") >= 0)) {
						if (!decodeFieldsSet.contains(items[0])) {
							contents[j] = items[0] + ": *** >> ***";
							if (contents.length > 2) {
								contents[j] += "<br/>";
							}
							if (!items[0].contains("电话")) {
								decodeFieldsSet.add(enCodeField);
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < contents.length; i++) {
			result += contents[i] + "\n";
		}
		return result;
	}
	
	/**
	 * 搜搜获取上下架的值，进行处理，
	 * 返回判断中介，虚假房源标识
	 * @param tatusFlag 上下架的值
	 * @return 1.中介房源，2虚假房源
	 */
	public static Integer getHouseFlg(Integer tatusFlag) {
		Integer houseFlag = 0;
		if(tatusFlag == null) {
			return houseFlag;
		}
		if (51 <= tatusFlag && tatusFlag <= 100) {
			houseFlag = 1;
		} else if (101 <= tatusFlag && tatusFlag <= 198) {
			houseFlag = 2;
		}
		return houseFlag;
	}

	/**
	 * 依据时间段获取对应的表明和详细数据表名（出售）
	 * @author 熊刚
	 * @since 2017年8月24日
	 * @param time
	 * @return tbName, tbNameDetail
	 */
	public static String[] getSaleTableNameAndDetailName(String time){
		String tbName = "SALE_IN";
		String tbNameDetail = "sale_in_detail";
		if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR.equals(time)) { // 两年前
			tbName = "SALE_4";
			tbNameDetail = "sale_4_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR.equals(time)) { // 一年前
			tbName = "SALE_3";
			tbNameDetail = "sale_3_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR.equals(time)) { // 半年至一年
			tbName = "SALE_2";
			tbNameDetail = "sale_2_detail";
		}
		return new String[]{tbName, tbNameDetail};
	}
	
	/**
	 * 获取上一张表的表明和详情表名，暂时兼容使用
	 * @author 张宏利
	 * @since 2017年11月07日
	 * @param nowTableName 上一个表名
	 * @return tbName, tbNameDetail
	 */
	public static String[] getUpTableNameByTableName(String[] nowTables) {
		// 出售
		if("SALE_2".equals(nowTables[0]))return new String[]{"SALE_IN", "sale_in_detail"};
		if("SALE_3".equals(nowTables[0]))return new String[]{"SALE_2", "sale_2_detail"};
		if("SALE_4".equals(nowTables[0]))return new String[]{"SALE_3", "sale_3_detail"};
		// 租
		if("LEASE_2".equals(nowTables[0]))return new String[]{"LEASE_IN", "lease_in_detail"};
		if("LEASE_3".equals(nowTables[0]))return new String[]{"LEASE_2", "lease_2_detail"};
		if("LEASE_4".equals(nowTables[0]))return new String[]{"LEASE_3", "lease_3_detail"};
		// 求购
		if("SHOP_2".equals(nowTables[0]))return new String[]{"SHOP_MAIN", "shop_detail"};
		if("SHOP_3".equals(nowTables[0]))return new String[]{"SHOP_2", "shop_2_detail"};
		if("SHOP_4".equals(nowTables[0]))return new String[]{"SHOP_3", "shop_3_detail"};
		// 求租
		if("HEZU_2".equals(nowTables[0]))return new String[]{"HEZU", "hezu_detail"};
		if("HEZU_3".equals(nowTables[0]))return new String[]{"HEZU_2", "hezu_2_detail"};
		if("HEZU_4".equals(nowTables[0]))return new String[]{"HEZU_3", "hezu_3_detail"};
		return nowTables;
	}
	
	/**
	 * 依据时间段获取对应的表明和详细数据表名（出租）
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param time
	 * @return tbName, tbNameDetail
	 */
	public static String[] getLeaseTableNameAndDetailName(String time) {
		String tbName = "LEASE_IN";
		String tbNameDetail = "lease_in_detail";
		if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR.equals(time)) { // 两年前
			tbName = "LEASE_4";
			tbNameDetail = "lease_4_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR.equals(time)) { // 一年前
			tbName = "LEASE_3";
			tbNameDetail = "lease_3_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR.equals(time)) { // 半年至一年
			tbName = "LEASE_2";
			tbNameDetail = "lease_2_detail";
		}
		return new String[]{tbName, tbNameDetail};
	}
	
	/**
	 * 通过名字日期获取对应的表名和详细表名(商铺)
	 * @author 熊刚
	 * @since 2017年8月24日
	 * @param time
	 * @return
	 */
	public static String[] getShopTableNameAndDetailName(String time) {
		String tbName = "SHOP_MAIN";
		String tbNameDetail = "shop_detail";
		if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR.equals(time)) { // 两年前
			tbName = "SHOP_4";
			tbNameDetail = "shop_4_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR.equals(time)) { // 一年前
			tbName = "SHOP_3";
			tbNameDetail = "shop_3_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR.equals(time)) { // 半年前
			tbName = "SHOP_2";
			tbNameDetail = "shop_2_detail";
		}
		return new String[]{tbName, tbNameDetail};
	}
	
	/**
	 * 通过名字日期获取对应的表名和详细表名（合租）
	 * @author 熊刚
	 * @since 2017年8月24日
	 * @param time
	 * @return
	 */
	public static String[] getHezuTableNameAndDetailName(String time) {
		String tbName = "HEZU";
		String tbNameDetail = "hezu_detail";
		if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR.equals(time)) { // 两年前
			tbName = "HEZU_4";
			tbNameDetail = "hezu_4_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_YEAR.equals(time)) { // 一年前
			tbName = "HEZU_3";
			tbNameDetail = "hezu_3_detail";
		} else if (Constants_DIC.DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR.equals(time)) { // 半年至一年
			tbName = "HEZU_2";
			tbNameDetail = "hezu_2_detail";
		}
		return new String[]{tbName, tbNameDetail};
	}
	
	public static String getHousePeopleRelativeName(Integer num){
		String relativeName = "";
		if(num == 1){
			relativeName = "登记人";
		}else if(num ==2){
			relativeName = "维护人";
		}else if(num ==3){
			relativeName = "钥匙人";
		}else if(num ==4){
			relativeName = "房勘人";
		}else if(num ==5){
			relativeName = "委托人";
		}else{
			relativeName = "议价人";
		}
		return relativeName;
		
	}
	
	/**
	 * 用于分割过长的IDs，用于解决in查询时超过2000个ID就会报错的问题
	 * @param keys 需要分割的长数组
	 * @param cutLen 分割后的小数组长度，如果 <=0 则默认1500
	 * @return
	 * @author 张宏利
	 */
	public static Integer[][] getCutArr(Integer[] keys, int cutLen){
		int subCloumLen = 1500;
		if(cutLen > 0) {
			subCloumLen = cutLen;
		}
		if(keys == null || keys.length <= 0){
			return new Integer[0][0];
		}
		int length = keys.length;
		int count = length / subCloumLen;
		int lastCount = length % subCloumLen;
		if(lastCount > 0) {
			count++;
		}
		Integer[][] arrResult = new Integer[count][];
		for (int i = 0; i < count; i++) {
			Integer[] subIds;
			if(i == count-1 && lastCount > 0) {
				subIds = new Integer[lastCount];// 末尾剩余的不足1500的部分
			} else {
				subIds = new Integer[subCloumLen];// 长度为1500的部分
			}
			for (int j = 0; j < subIds.length; j++) {
				subIds[j] = keys[(i*subCloumLen)+j];// 分割数组
			}
			arrResult[i] = subIds;
		}
		return arrResult;
	}
	
	/**
	 * 拼接头像地址
	 * @author 张宏利
	 * @since 2018年1月8日
	 * @param bbsPhoto
	 * @return
	 */
	public static String getBbsPhoto(String bbsPhoto) {
		String tempUrl = getCommonPhotoUrl(bbsPhoto);
		if (StringUtils.isNotBlank(bbsPhoto) && StringUtils.isBlank(tempUrl)) {
			tempUrl = (AppConfig.getPicDomainUrl() + "pic/" + bbsPhoto).replaceAll("\\\\", "/");
		}
		return tempUrl;
	}
	
	/**
	 * 视频根域名+地址拼接
	 * @author 张宏利
	 * @since 2018年1月8日
	 * @param videoUlr
	 * @return
	 */
	public static String getVideoUrl(String videoUlr) {
		if (StringUtils.isBlank(videoUlr)) {
			return null;
		}
		if (videoUlr.startsWith("http://")) {
			return videoUlr;
		}
		return (AppConfig.getVideoDomainUrl() + videoUlr).replaceAll("\\\\", "/");
	}
	
	/**
	 * 根域名+地址拼接
	 * @author 张宏利
	 * @since 2018年1月8日
	 * @param housePhoto
	 * @return
	 */
	public static String getPhotoUrl(String photoAddr) {
		String tempUrl = getCommonPhotoUrl(photoAddr);
		if (StringUtils.isNotBlank(photoAddr) && StringUtils.isBlank(tempUrl)) {
			tempUrl = (AppConfig.getPicDomainUrl() + photoAddr).replaceAll("\\\\", "/");
		}
		return tempUrl;
	}
	
	/**
	 * 搜搜图片电话的地址
	 * @author 张宏利
	 * @since 2018年1月8日
	 * @param housePhoto
	 * @return
	 */
	public static String getSoSoPhonePicUrl(String photoAddr) {
		String tempUrl = getCommonPhotoUrl(photoAddr);
		if (StringUtils.isNotBlank(photoAddr) && StringUtils.isBlank(tempUrl)) {
			tempUrl = (AppConfig.getHousePicDomainUrl() + "pic/" + photoAddr).replaceAll("\\\\", "/");
		}
		return tempUrl;
	}
	
	/**
	 * 根域名+地址拼接
	 * @author 张宏利
	 * @since 2018年1月8日
	 * @param housePhoto
	 * @return
	 */
	public static String getSoSoPhotoUrl(String photoAddr) {
		String tempUrl = getCommonPhotoUrl(photoAddr);
		if (StringUtils.isNotBlank(photoAddr) && StringUtils.isBlank(tempUrl)) {
			tempUrl = (AppConfig.getSoSoPicUrl() + photoAddr).replaceAll("\\\\", "/");
		}
		return tempUrl;
	}
	
	/**
	 * 图片地址拼接
	 * @author 张宏利
	 * @since 2018年1月8日
	 * @param housePhoto
	 * @return
	 */
	public static String getHousePhoto(String housePhoto) {
		String tempUrl = getCommonPhotoUrl(housePhoto);
		return tempUrl;
	}
	
	/**
	 * 获取通用的图片域名拼接
	 * @author 张宏利
	 * @since 2018年2月11日
	 * @param housePhoto
	 * @return
	 */
	public static String getCommonPhotoUrl(String housePhoto) {
		if (StringUtils.isBlank(housePhoto)) {
			return null;
		}
		if (housePhoto.startsWith("http://")) {
			return housePhoto;
		}

		if (housePhoto.startsWith("oss")) {
			return (AppConfig.getPicDomainUrl() + housePhoto).replaceAll("\\\\", "/");
		}else {
			return (AppConfig.getHousePicDomainUrl() + housePhoto).replaceAll("\\\\", "/");
		}
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
	 * 依据单位获取金额，处理成元每月的价格
	 * @author 张宏利
	 * @since 2017年12月20日
	 * @param priceUnit
	 * @param tatalMoney
	 * @param tatalArea
	 * @return
	 */
	public static double getLeaseMoneyByMonth(Byte priceUnit, double tatalMoney, double tatalArea) {
		if(Const.DIC_PRICE_UNIT_PERCENTIARE.equals(priceUnit)){
			return tatalMoney * tatalArea * 1;
		}else if(Const.DIC_PRICE_UNIT_PERDAY.equals(priceUnit)){
			return tatalMoney * 30;
		}else if(Const.DIC_PRICE_UNIT_PERDAYCENT.equals(priceUnit)){
			return tatalMoney * tatalArea * 30;
		}else if(Const.DIC_PRICE_UNIT_PERMONTH.equals(priceUnit)){
			return tatalMoney;
		}else if(Const.DIC_PRICE_UNIT_PERYEAR.equals(priceUnit)){
			return tatalMoney/12;
		}
		return tatalMoney;
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
			if (obj.getClass().getSimpleName().equals("ArrayList")) {
				list = (ArrayList<?>) obj;
				if (list.size() == 0) {
					flag = true;
				}
			}
			if (obj.getClass().getSimpleName().equals("String[]")) {
				strs = (String[]) obj;
				if (strs.length == 1) {
					if (isnull(strs[0].trim())) {
						flag = true;
					}
				}
			}
			if (obj.getClass().getSimpleName().equals("String")) {
				str = (String) obj;
				str=str.trim();
				if (str.equals("")||str.toLowerCase().equals("null")||str.equals("undefined")) {
					flag = true;
				}
			}
			if (obj.getClass().getSimpleName().equals("Long")) {
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

	/**
	 * 获取楼层信息,属于 低层/中层/高层/超高层
	 * @param floor
	 * @param totalFloor
	 * @return
	 */
	public static Integer getBuildFloorType(Integer floor, Integer totalFloor) {
		Integer floorType = 1;
		if (null ==  floor || null == totalFloor) {
			return null;
		}
//			int intFloors = StringUtil.paseInteger(totalFloor, 0);
//			int intFloor = StringUtil.paseInteger(floor, 0);
//			缩短了的代码
//			if ((intFloors <= 10 && intFloor <= 3)
//					|| (intFloors >= 11 && intFloors <= 40 && intFloor <= intFloors / 3)
//					|| (intFloors > 40 && intFloor <= 40 / 3)
//				) {
//				// 底层
//			}
//			if ((intFloors <= 10 && 3 < intFloor && intFloor <= 6)
//					|| (intFloors >= 11 && intFloors <= 40 && intFloors / 3 < intFloor && intFloor <= intFloors * (2 / 3))
//					|| (intFloors > 40 && 40 / 3 < intFloor && intFloor <= (40 / 3) * 2)
//					) {
//				// 中层
//			}
//			if ((intFloors <= 10 && intFloor > 6)
//					|| (intFloors >= 11 && intFloors <= 40 && intFloor > intFloors * (2 / 3))
//					|| (intFloors > 40 && (40 / 3) * 2 < intFloor && intFloor <= 40)
//					) {
//				// 高层
//			}
//			if (intFloor > 40) {
//				// 超高层
//			}
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

	/**
	 * 获取楼层信息,属于 低层/中层/高层/超高层
	 * @author 何传强
	 * @since 2017年6月22日
	 * @return
	 */
	public static String getBuildFloorsType(Integer floor, Integer totalFloor) {
		String floorType = "低层";
		if (null ==  floor || null == totalFloor) {
			return null;
		}
		int intFloors = totalFloor;
		int intFloor = floor;
//		缩短了的代码
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
		if (intFloors <= 10) {
			if (intFloor <= 3) {
				floorType = "低层";
			} else if (3 < intFloor && intFloor <= 6) {
				floorType = "中层";
			} else {
				floorType = "高层";
			}
		} else if (intFloors >= 11 && intFloors <= 40) {// 总楼层11--40
			int result = intFloors / 3;
			if (intFloor <= result) {
				floorType = "低层";
			} else if (result < intFloor && intFloor <= intFloors * (2 / 3)) {
				floorType = "中层";
			} else {
				floorType = "高层";
			}
		} else if (intFloors > 40) {// 总楼层>40
			if (intFloor <= 40 / 3) {
				floorType = "低层";
			} else if (40 / 3 < intFloor && intFloor <= (40 / 3) * 2) {
				floorType = "中层";
			} else if ((40 / 3) * 2 < intFloor && intFloor <= 40) {
				floorType = "高层";
			} else {
				floorType = "超高层";
			}
		}
		return floorType;
	}
}
