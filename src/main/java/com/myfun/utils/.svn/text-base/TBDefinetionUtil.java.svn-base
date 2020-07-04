package com.myfun.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Allen
 *
 *         To change this generated comment edit the template variable
 *         "typecomment": Window>Preferences>Java>Templates. To enable and
 *         disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */
public class TBDefinetionUtil {

	private static HashMap<String, Object> tableHM = new HashMap<>();
	private static HashMap<String, String> ddHM = new HashMap<>();
	private static HashMap<String, Object> keyValueHM = new HashMap<>();
	private static HashMap<String, String> addHM = new HashMap<>();
	private static Map<String, String> ISSALELEASE_SALETRANSEFER = new HashMap<>();
	private static Map<String, String> ISSALELEASE_LEASETRANSEFER = new HashMap<>();
	private static Map<String, String> ISSALELEASE_COMMON = new HashMap<>();

	private static String[] decodeFields;
	private static String[] decodeFieldsCN;

	public static Map<String, Object> constructTable() {
		return tableHM;
	}

	public static Map<String, String> constructDD() {
		return ddHM;
	}

	public static Iterator constracutAddKey() {
		return addHM.keySet().iterator();
	}

	public static Map<String, Object> constructKeyValue() {
		return keyValueHM;

	}

	public static String[] getSecretFields() {
		return decodeFieldsCN;
	}

	public static String[] getDecodeFields() {
		return decodeFields;

	}

	public static Map<String, String> getSaleLeaseTransferMap(String caseType) {
		if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			return ISSALELEASE_SALETRANSEFER;
		}
		return ISSALELEASE_LEASETRANSEFER;
	}

	static {
		ISSALELEASE_COMMON.put("AREA_ID", "AREA_ID");// 大区ID
		ISSALELEASE_COMMON.put("REG_ID", "REG_ID");// 片区ID
		ISSALELEASE_COMMON.put("DEPT_ID", "DEPT_ID");// 门店ID
		ISSALELEASE_COMMON.put("GR_ID", "GR_ID");// 分组ID
		ISSALELEASE_COMMON.put("USER_ID", "USER_ID");// 所属人
		ISSALELEASE_COMMON.put("OWNER_TYPE", "OWNER_TYPE");// 业主类型，DD:OWNER_TYPE
		ISSALELEASE_COMMON.put("OWNER_SEX", "OWNER_SEX");// 所属人性别，1=先生0=女士
		ISSALELEASE_COMMON.put("QZ_CODE_FUN", "QZ_CODE_FUN");
		ISSALELEASE_COMMON.put("BUILD_ID", "BUILD_ID");
		ISSALELEASE_COMMON.put("BUILD_NAME", "BUILD_NAME");
		ISSALELEASE_COMMON.put("BUILD_CODE", "BUILD_CODE");
		ISSALELEASE_COMMON.put("SECTION_ID", "SECTION_ID");
		ISSALELEASE_COMMON.put("SECTION_NAME", "SECTION_NAME");
		ISSALELEASE_COMMON.put("REGION_NAME", "REGION_NAME");
		ISSALELEASE_COMMON.put("TRADE_ADDR", "TRADE_ADDR");
		ISSALELEASE_COMMON.put("UNIT_FLOOR", "UNIT_FLOOR");
		ISSALELEASE_COMMON.put("UNIT_FLOOR_R", "UNIT_FLOOR_R");
		ISSALELEASE_COMMON.put("HALL_STRUCTURE", "HALL_STRUCTURE");
		ISSALELEASE_COMMON.put("UG_AREA", "UG_AREA");
		ISSALELEASE_COMMON.put("UG_TYPE", "UG_TYPE");
		ISSALELEASE_COMMON.put("GARDEN_AREA", "GARDEN_AREA");
		ISSALELEASE_COMMON.put("GARAGE_AMOUNT", "GARAGE_AMOUNT");
		ISSALELEASE_COMMON.put("THUMB_URL", "THUMB_URL");
		ISSALELEASE_COMMON.put("THUMBPIC_VER", "THUMBPIC_VER");
		ISSALELEASE_COMMON.put("ADDR_MD5", "ADDR_MD5");
		ISSALELEASE_COMMON.put("CELL_PHONE", "CELL_PHONE");
		ISSALELEASE_COMMON.put("JOINT_CELL_PHONE", "JOINT_CELL_PHONE");
		ISSALELEASE_COMMON.put("JOINT_USER_NAME", "JOINT_USER_NAME");
		ISSALELEASE_COMMON.put("JOINT_USER_SEX", "JOINT_USER_SEX");
		ISSALELEASE_COMMON.put("JOINT_ID_CARD", "JOINT_ID_CARD");
		ISSALELEASE_COMMON.put("IS_SALE_LEASE", "IS_SALE_LEASE");
		ISSALELEASE_COMMON.put("HOUSE_BARGAIN", "HOUSE_BARGAIN");
		ISSALELEASE_COMMON.put("TRACK_TIME", "TRACK_TIME");
		ISSALELEASE_COMMON.put("OWNERSHIP_TYPE", "OWNERSHIP_TYPE");
		ISSALELEASE_COMMON.put("VIDEO_NUM", "VIDEO_NUM");
		ISSALELEASE_COMMON.put("PANORAMA_MAP", "PANORAMA_MAP");
		ISSALELEASE_COMMON.put("PLATE_TYPE", "PLATE_TYPE");
		// 可租售房源同步的字段-出售
		ISSALELEASE_LEASETRANSEFER.put("LEASE_ROOF", "SALE_ROOF");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_UNIT", "SALE_UNIT");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_NUM", "SALE_NUM");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_ROOF_R", "SALE_ROOF_R");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_UNIT_R", "SALE_UNIT_R");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_NUM_R", "SALE_NUM_R");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_ROOF_T", "SALE_ROOF_T");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_NUM_T", "SALE_NUM_T");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_UNIT_T", "SALE_UNIT_T");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_REG", "SALE_REG");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_ROUND", "SALE_ROUND");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_LADDER", "SALE_LADDER");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_DOORS", "SALE_DOORS");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_ROOM", "SALE_ROOM");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_HALL", "SALE_HALL");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_WEI", "SALE_WEI");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_YANG", "SALE_YANG");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_TYPE", "SALE_TYPE");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_FLOOR", "SALE_FLOOR");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_FLOORS", "SALE_FLOORS");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_FITMENT", "SALE_FITMENT");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_DIRECT", "SALE_DIRECT");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_YEAR", "SALE_YEAR");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_STREET", "SALE_STREET");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_AREA", "SALE_AREA");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_PROPERTY", "SALE_PROPERTY");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_MAP", "SALE_MAP");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_LEVEL", "SALE_LEVEL");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_INNERAREA", "SALE_INNERAREA");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_KEY", "SALE_KEY");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_KEY_NUM", "SALE_KEY_NUM");
		ISSALELEASE_LEASETRANSEFER.put("LEASE_OWNER", "SALE_OWNER");// 业主姓名
		ISSALELEASE_LEASETRANSEFER.put("LEASE_EXPLRTH", "SALE_EXPLRTH");
		ISSALELEASE_LEASETRANSEFER.putAll(ISSALELEASE_COMMON);
		
		ISSALELEASE_SALETRANSEFER.put("SALE_ROOF", "LEASE_ROOF");
		ISSALELEASE_SALETRANSEFER.put("SALE_UNIT", "LEASE_UNIT");
		ISSALELEASE_SALETRANSEFER.put("SALE_FLOOR", "LEASE_FLOOR");
		ISSALELEASE_SALETRANSEFER.put("SALE_NUM", "LEASE_NUM");
		ISSALELEASE_SALETRANSEFER.put("SALE_ROOF_R", "LEASE_ROOF_R");
		ISSALELEASE_SALETRANSEFER.put("SALE_UNIT_R", "LEASE_UNIT_R");
		ISSALELEASE_SALETRANSEFER.put("SALE_NUM_R", "LEASE_NUM_R");
		ISSALELEASE_SALETRANSEFER.put("SALE_ROOF_T", "LEASE_ROOF_T");
		ISSALELEASE_SALETRANSEFER.put("SALE_NUM_T", "LEASE_NUM_T");
		ISSALELEASE_SALETRANSEFER.put("SALE_UNIT_T", "LEASE_UNIT_T");
		ISSALELEASE_SALETRANSEFER.put("SALE_REG", "LEASE_REG");
		ISSALELEASE_SALETRANSEFER.put("SALE_ROUND", "LEASE_ROUND");
		ISSALELEASE_SALETRANSEFER.put("SALE_LADDER", "LEASE_LADDER");
		ISSALELEASE_SALETRANSEFER.put("SALE_DOORS", "LEASE_DOORS");
		ISSALELEASE_SALETRANSEFER.put("SALE_ROOM", "LEASE_ROOM");
		ISSALELEASE_SALETRANSEFER.put("SALE_HALL", "LEASE_HALL");
		ISSALELEASE_SALETRANSEFER.put("SALE_WEI", "LEASE_WEI");
		ISSALELEASE_SALETRANSEFER.put("SALE_YANG", "LEASE_YANG");
		ISSALELEASE_SALETRANSEFER.put("SALE_TYPE", "LEASE_TYPE");
		ISSALELEASE_SALETRANSEFER.put("SALE_FLOORS", "LEASE_FLOORS");
		ISSALELEASE_SALETRANSEFER.put("SALE_FITMENT", "LEASE_FITMENT");
		ISSALELEASE_SALETRANSEFER.put("SALE_DIRECT", "LEASE_DIRECT");
		ISSALELEASE_SALETRANSEFER.put("SALE_YEAR", "LEASE_YEAR");
		ISSALELEASE_SALETRANSEFER.put("SALE_STREET", "LEASE_STREET");
		ISSALELEASE_SALETRANSEFER.put("SALE_AREA", "LEASE_AREA");
		ISSALELEASE_SALETRANSEFER.put("SALE_PROPERTY", "LEASE_PROPERTY");
		ISSALELEASE_SALETRANSEFER.put("SALE_MAP", "LEASE_MAP");
		ISSALELEASE_SALETRANSEFER.put("SALE_LEVEL", "LEASE_LEVEL");
		ISSALELEASE_SALETRANSEFER.put("SALE_INNERAREA", "LEASE_INNERAREA");
		ISSALELEASE_SALETRANSEFER.put("SALE_KEY", "LEASE_KEY");
		ISSALELEASE_SALETRANSEFER.put("SALE_KEY_NUM", "LEASE_KEY_NUM");
		ISSALELEASE_SALETRANSEFER.put("SALE_OWNER", "LEASE_OWNER");// 业主姓名
		ISSALELEASE_SALETRANSEFER.put("SALE_EXPLRTH", "LEASE_EXPLRTH");
		ISSALELEASE_SALETRANSEFER.putAll(ISSALELEASE_COMMON);
		
		// 房源出租表
		HashMap funLease = new HashMap();
		funLease.put("LEASE_ID", "房源ID");
		funLease.put("LEASE_NO", "房源编码");
		funLease.put("LEASE_SUBJECT", "房源标题");
		funLease.put("LEASE_SOURCE", "来源");
		funLease.put("LEASE_LEVEL", "级别");
		funLease.put("LEASE_CONSIGN", "委托");
		funLease.put("LEASE_CONSIGN_NO", "委托编号");
		funLease.put("LEASE_OWNER", "业主");
		funLease.put("CELL_PHONE", "电话");
		funLease.put("ID_CARD", "身份证");
		funLease.put("LEASE_REGION", "行政区域");
		funLease.put("SECTORS_NAME", "街道");
		funLease.put("SECTION_NAME", "商圈");
		funLease.put("LEASE_ROUND", "范围");
		funLease.put("BUILD_ID", "楼盘ID");
		funLease.put("BUILD_NAME", "楼盘名称");
		funLease.put("LEASE_ROOF", "栋座");
		funLease.put("LEASE_UNIT", "单元");
		funLease.put("UNIT_FLOOR", "楼");
		funLease.put("LEASE_NUM", "号");
		funLease.put("PLATE_TYPE", "盘别");
		funLease.put("LEASE_ROOM", "卧室");
		funLease.put("LEASE_HALL", "客厅");
		funLease.put("LEASE_WEI", "卫生间");
		funLease.put("LEASE_CHU", "厨房");
		funLease.put("LEASE_YANG", "阳台");
		funLease.put("LEASE_LADDER", "几梯");
		funLease.put("LEASE_DOORS", "几户");
		funLease.put("LEASE_TYPE", "类型");
		funLease.put("LEASE_FLOOR", "楼层");
		funLease.put("LEASE_FLOORS", "总楼层");
		funLease.put("LEASE_FITMENT", "装修");
		funLease.put("LEASE_DIRECT", "房源朝向");
		funLease.put("LEASE_YEAR", "房屋年代");
		funLease.put("LEASE_STRUCT", "房屋结构");
		funLease.put("LEASE_USEAGE", "房屋用途");
		funLease.put("LEASE_STREET", "是否邻街");
		funLease.put("LEASE_ROOM_TYPE", "出租方式");
		funLease.put("LEASE_ROOM_CLASSIC", "房间分类");
		funLease.put("FLAT_SHARE_SEX", "合租性别");
		/*
		 * funLease.put("LEASE_RIGHT", "权属");
		 */ funLease.put("LEASE_ACCOUNT", "付款方式");
		funLease.put("LEASE_AREA", "房屋面积");
		funLease.put("LEASE_TOTAL_PRICE", "租金");
		funLease.put("LEASE_UNIT_PRICE", "单价");
		funLease.put("LEASE_LOWEST_PRICE", "底价");
		funLease.put("PRICE_UNIT", "租金单位");
		funLease.put("LEASE_DEPOSIT", "押金");
		funLease.put("LEASE_LEAVE_TIME", "出房日");
		funLease.put("LEASE_LIMITE", "租房期限");
		funLease.put("LEASE_SET", "室内配套");
		funLease.put("LEASE_KEY", "是否有钥匙");
		funLease.put("LEASE_KEY_NUM", "钥匙编号");
		funLease.put("KEY_TIME", "钥匙日期");
		funLease.put("LEASE_EXPLRTH", "房勘");
		funLease.put("EXPLRTH_DATETIME", "房勘日期");
		funLease.put("LEASE_BOOK", "书证号");
		funLease.put("LEASE_MOUND", "权证号");
		funLease.put("LEASE_RECORD", "备案号");
		funLease.put("LEASE_COOPERATE", "是否合作");
		funLease.put("CITY_SHARE_FLAG", "是否合作");
		funLease.put("LEASE_PUBLISH", "网络推广");
		funLease.put("SENDTO_WEIDIAN", "微店");
		funLease.put("SENDTO_YOUYOU", "优优好房");
		funLease.put("LEASE_CHARACT", "房屋优势");
		funLease.put("LEASE_MEMO", "备注");
		funLease.put("LEASE_STATUS", "房屋状态");
		funLease.put("LEASE_MAP", "是否有图片");
		funLease.put("USER_ID", "所属经纪人");
		funLease.put("TRACK_TIME", "最后跟进日期");
		funLease.put("SCHEDULE_TIME", "预订日期");
		funLease.put("DEAL_TIME", "成交日期");
		funLease.put("WRITEOFF_TIME", "注销日期");
		funLease.put("CREATOR_UID", "创建者");
		funLease.put("CREATION_TIME", "创建时间");
		funLease.put("UPDATE_UID", "最后更新者");
		funLease.put("UPDATE_TIME", "最后更新时间");

		funLease.put("LEASE_PROPERTY", "物业费");
		funLease.put("IS_SEPERATOR", "是否可分割");
		funLease.put("OWNER_TYPE", "业主类型");
		funLease.put("OWNER_SEX", "业主性别");
		funLease.put("OFFICE_LEVEL", "写字楼级别");
		funLease.put("SHOP_USAGE", "适合经营");
		funLease.put("HALL_STRUCTURE", "厅结构");
		funLease.put("UG_AREA", "地下面积");
		funLease.put("UG_TYPE", "地下类型");
		funLease.put("GARDEN_AREA", "花园面积");
		funLease.put("GARAGE_AMOUNT", "车位数量");
		funLease.put("TAG_IDS", "房源标签");
		// funLease.put("REPEAT_FLAG", "重复数据");//陈文超添加 暂时去掉
		funLease.put("LEASE_INNERAREA", "套内面积");
		funLease.put("TRUE_FLAG", "真房源");
		funLease.put("SENDTOTENCENT", "发布到腾讯网");
		funLease.put("TRADE_ADDR", "商户地址");
		funLease.put("CHECK_CODE_FUN", "核验编号");// 小方添加2016-11-25
		funLease.put("OWNERSHIP_TYPE", "产权证类型");// 小方添加2016-12-08
		funLease.put("QZ_CODE_FUN", "产权证号");// 小方添加2016-12-08
		funLease.put("EFFECTIVE_DATE", "房源有效期");// 小方添加2016-12-08
		funLease.put("JOINT_CELL_PHONE", "共有人电话");// zt添加2017-06-03
		funLease.put("JOINT_USER_NAME", "共有人姓名");// zt添加2017-06-03
		funLease.put("JOINT_USER_SEX", "共有人性别");// zt添加2017-06-03
		funLease.put("JOINT_ID_CARD", "共有人身份证");// zt添加2017-06-03
		tableHM.put("FUN_LEASE", funLease);

		// 房源出售表
		HashMap funSale = new HashMap();
		funSale.put("SALE_ID", "房源ID");
		funSale.put("SALE_NO", "房源编码");
		funSale.put("SALE_SUBJECT", "房源标题");
		funSale.put("SALE_SOURCE", "来源");
		funSale.put("SALE_LEVEL", "级别");
		funSale.put("SALE_CONSIGN", "委托");
		funSale.put("SALE_CONSIGN_NO", "委托编号");
		funSale.put("SALE_OWNER", "业主");
		funSale.put("CELL_PHONE", "电话");
		funSale.put("ID_CARD", "身份证");
		funSale.put("SALE_REGION", "行政区域");
		funSale.put("SECTORS_NAME", "街道");
		funSale.put("SECTION_NAME", "商圈");
		funSale.put("SALE_ROUND", "范围");
		funSale.put("BUILD_ID", "楼盘ID");
		funSale.put("BUILD_NAME", "楼盘名称");
		funSale.put("SALE_ROOF", "栋座");
		funSale.put("SALE_UNIT", "单元");
		funSale.put("UNIT_FLOOR", "楼");
		funSale.put("SALE_NUM", "号");
		funSale.put("SALE_LADDER", "几梯");
		funSale.put("SALE_DOORS", "几户");
		funSale.put("PLATE_TYPE", "盘别");
		funSale.put("SALE_ROOM", "卧室");
		funSale.put("SALE_HALL", "客厅");
		funSale.put("SALE_WEI", "卫生间");
		funSale.put("SALE_CHU", "厨房");
		funSale.put("SALE_YANG", "阳台");
		funSale.put("SALE_TYPE", "类型");
		funSale.put("SALE_FLOOR", "楼层");
		funSale.put("TRADE_ADDR", "商户地址");
		funSale.put("SALE_FLOORS", "总楼层");
		funSale.put("SALE_FITMENT", "装修");
		funSale.put("SALE_DIRECT", "房源朝向");
		funSale.put("SALE_YEAR", "房屋年代");
		funSale.put("SALE_STRUCT", "房屋结构");
		funSale.put("SALE_USEAGE", "房屋用途");
		funSale.put("SALE_STREET", "是否邻街");
		funSale.put("SALE_RIGHT", "权属");
		funSale.put("SALE_MORTGAGE", "现状");
		funSale.put("SALE_ACCOUNT", "收款");
		funSale.put("SALE_AREA", "房屋面积");
		funSale.put("SALE_TOTAL_PRICE", "总价");
		funSale.put("SALE_UNIT_PRICE", "单价");
		funSale.put("SALE_LOWEST_PRICE", "底价");
		funSale.put("SALE_LEAVE_TIME", "腾房日");
		funSale.put("SALE_CERT_TIME", "出证日");
		funSale.put("SALE_KEY", "是否有钥匙");
		funSale.put("SALE_KEY_NUM", "钥匙编号");
		funSale.put("KEY_TIME", "钥匙日期");
		funSale.put("SALE_EXPLRTH", "房勘");
		funSale.put("EXPLRTH_DATETIME", "房勘日期");
		funSale.put("SALE_BOOK", "书证号");
		funSale.put("SALE_MOUND", "权证号");
		funSale.put("SALE_RECORD", "备案号");
		funSale.put("SALE_COOPERATE", "是否合作");
		funSale.put("CITY_SHARE_FLAG", "是否合作");
		funSale.put("SALE_PUBLISH", "网络推广");
		funSale.put("SENDTO_WEIDIAN", "微店");
		funSale.put("SENDTO_YOUYOU", "优优好房");
		funSale.put("SALE_CHARACT", "核心卖点");
		funSale.put("SALE_MEMO", "备注");
		funSale.put("SALE_STATUS", "房屋状态");
		funSale.put("SALE_MAP", "是否有图片");
		funSale.put("USER_ID", "所属经纪人");
		funSale.put("TRACK_TIME", "最后跟进日期");
		funSale.put("SCHEDULE_TIME", "预订日期");
		funSale.put("DEAL_TIME", "成交日期");
		funSale.put("WRITEOFF_TIME", "注销日期");
		funSale.put("CREATOR_UID", "创建者");
		funSale.put("CREATION_TIME", "创建时间");
		funSale.put("UPDATE_UID", "最后更新者");
		funSale.put("UPDATE_TIME", "最后更新时间");
		funSale.put("SALE_PROPERTY", "物业费");
		funSale.put("IS_SEPERATOR", "是否可分割");
		funSale.put("OWNER_TYPE", "业主类型");
		funSale.put("OWNER_SEX", "业主性别");
		funSale.put("OFFICE_LEVEL", "写字楼级别");
		funSale.put("SHOP_USAGE", "适合经营");
		funSale.put("HALL_STRUCTURE", "厅结构");
		funSale.put("UG_AREA", "地下面积");
		funSale.put("UG_TYPE", "地下类型");
		funSale.put("GARDEN_AREA", "花园面积");
		funSale.put("GARAGE_AMOUNT", "车位数量");
		funSale.put("TAG_IDS", "房源标签");
		// funSale.put("REPEAT_FLAG", "重复数据");//陈文超添加 暂时去掉
		funSale.put("SALE_INNERAREA", "套内面积");// 陈文超添加
		funSale.put("SENDTOTENCENT", "发布到腾讯网");
		funSale.put("TRUE_FLAG", "真房源");
		funSale.put("QZ_CODE_FUN", "权证编号");// 小方添加2016-12-08
		funSale.put("CHECK_CODE_FUN", "核验编号");// 小方添加2016-11-25
		funSale.put("OWNERSHIP_TYPE", "产权证类型");// 小方添加2016-12-08
		funSale.put("QZ_CODE_FUN", "产权证号");// 小方添加2016-12-08
		funSale.put("EFFECTIVE_DATE", "房源有效期");// 小方添加2016-12-08
		funSale.put("JOINT_CELL_PHONE", "共有人电话");// zt添加2017-06-03
		funSale.put("JOINT_USER_NAME", "共有人姓名");// zt添加2017-06-03
		funSale.put("JOINT_USER_SEX", "共有人性别");// zt添加2017-06-03
		funSale.put("JOINT_ID_CARD", "共有人身份证");// zt添加2017-06-03
		funSale.put("HOUSE_SITUATION", "房屋现状");
		tableHM.put("FUN_SALE", funSale);
		// 求购客户
		HashMap buyCustomer = new HashMap();
		buyCustomer.put("BUY_CUST_ID", "求购ID");
		buyCustomer.put("BUY_CUST_NO", "客户编码");
		buyCustomer.put("BUY_CUST_SOURCE", "来源");
		buyCustomer.put("BUY_CUST_LEVEL", "级别");
		buyCustomer.put("BUY_CUST_STATUS", "状态");
		buyCustomer.put("BUY_CUST_NAME", "客户");
		buyCustomer.put("CELL_PHONE", "电话");
		buyCustomer.put("ID_CARD", "身份证");
		buyCustomer.put("CUST_ADDR", "住址");
		buyCustomer.put("CUST_LEVEL", "客户等级");
		buyCustomer.put("HOUSE_ROOM", "最小户型");
		buyCustomer.put("HOUSE_HALL", "客厅");
		buyCustomer.put("HOUSE_WEI", "卫生间");
		buyCustomer.put("HOUSE_YANG", "阳台");
		buyCustomer.put("HOUSE_ROOM_1", "最大户型");
		buyCustomer.put("REGION_NAME", "行政区");
		buyCustomer.put("SECTION_NAME", "商圈");
		buyCustomer.put("BUILD_NAME", "楼盘");
		buyCustomer.put("HOUSE_ROUND", "范围");
		buyCustomer.put("HOUSE_TYPE", "类型");
		buyCustomer.put("HOUSE_USEAGE", "房屋用途");
		buyCustomer.put("HOUSE_FITMENT", "装修");
		buyCustomer.put("HOUSE_DIRECT", "房源朝向");
		buyCustomer.put("HOUSE_FLOOR_LOW", "最低楼层");
		buyCustomer.put("HOUSE_FLOOR_HIGH", "最高楼层");
		buyCustomer.put("HOUSE_PRICE_LOW", "最低价格");
		buyCustomer.put("HOUSE_PRICE_HIGH", "最高价格");
		buyCustomer.put("HOUSE_AREA_LOW", "最低面积");
		buyCustomer.put("HOUSE_AREA_HIGH", "最高面积");
		buyCustomer.put("HOUSE_YEAR_LOW", "最近年代");
		buyCustomer.put("HOUSE_YEAR_HIGH", "最早年代");
		buyCustomer.put("HOUSE_LOOK", "是否带看");
		buyCustomer.put("CUST_REQUEST", "客户要求");
		buyCustomer.put("CUST_CHARACT", "配套");
		buyCustomer.put("CUST_MEMO", "备注");
		buyCustomer.put("TRACK_TIME", "最后跟进日期");
		buyCustomer.put("SCHEDULE_TIME", "预订日期");
		buyCustomer.put("DEAL_TIME", "成交日期");
		buyCustomer.put("WRITEOFF_TIME", "注销日期");
		buyCustomer.put("CREATOR_UID", "创建者");
		buyCustomer.put("CREATION_TIME", "创建时间");
		buyCustomer.put("UPDATE_UID", "最后更新者");
		buyCustomer.put("UPDATE_TIME", "最后更新时间");
		buyCustomer.put("USER_ID", "经纪人");
		buyCustomer.put("BUY_CUST_SEX", "性别");
		buyCustomer.put("BUY_CUST_AGE", "年龄");
		buyCustomer.put("BUY_CUST_CAREER", "职业");
		buyCustomer.put("BUY_LIFEBOUND", "生活圈");
		buyCustomer.put("BUY_GOAL", "购房目的");
		buyCustomer.put("BUY_LENGTH", "期限");
		buyCustomer.put("BUY_ABILITY", "购买能力");
		buyCustomer.put("BUY_PAYTYPE", "付款方式");
		buyCustomer.put("HOUSE_ADDR", "具体地址");
		buyCustomer.put("PLATE_TYPE", "盘别");

		buyCustomer.put("REQ_SUPP", "配套设施");
		buyCustomer.put("OFFICE_LEVEL", "写字楼级别");
		buyCustomer.put("SHOP_USAGE", "目标业态");
		buyCustomer.put("HALL_STRUCTURE", "厅结构");
		buyCustomer.put("GARDEN_AREA", "花园面积");
		buyCustomer.put("GARAGE_AMOUNT", "车位数量");
		buyCustomer.put("ROADS_NAME", "主干道");
		buyCustomer.put("WECHAT_NUMBER", "微信号");
		// buyCustomer.put("REPEAT_FLAG", "重复数据");//陈文超添加 暂时去掉
		tableHM.put("FUN_BUY_CUSTOMER", buyCustomer);

		// 求租客户
		HashMap rentCustomer = new HashMap();
		rentCustomer.put("RENT_CUST_ID", "客户ID");
		rentCustomer.put("RENT_CUST_NO", "客户编码");
		rentCustomer.put("RENT_CUST_SOURCE", "来源");
		rentCustomer.put("RENT_CUST_LEVEL", "级别");
		rentCustomer.put("RENT_CUST_STATUS", "状态");
		rentCustomer.put("RENT_CUST_NAME", "客户");
		rentCustomer.put("CELL_PHONE", "电话");
		rentCustomer.put("ID_CARD", "身份证");
		rentCustomer.put("CUST_ADDR", "住址");
		rentCustomer.put("CUST_LEVEL", "客户等级");
		rentCustomer.put("HOUSE_ROOM", "最小");
		rentCustomer.put("HOUSE_HALL", "客厅");
		rentCustomer.put("HOUSE_WEI", "卫生间");
		rentCustomer.put("HOUSE_YANG", "阳台");
		rentCustomer.put("HOUSE_ROOM_1", "最大");
		rentCustomer.put("REGION_NAME", "行政区");
		rentCustomer.put("SECTION_NAME", "商圈");
		rentCustomer.put("BUILD_NAME", "楼盘");
		rentCustomer.put("HOUSE_ROUND", "范围");
		rentCustomer.put("HOUSE_TYPE", "类型");
		rentCustomer.put("HOUSE_USEAGE", "房屋用途");
		rentCustomer.put("HOUSE_FITMENT", "装修");
		rentCustomer.put("HOUSE_DIRECT", "房源朝向");
		rentCustomer.put("HOUSE_FLOOR_LOW", "最低楼层");
		rentCustomer.put("HOUSE_FLOOR_HIGH", "最高楼层");
		rentCustomer.put("HOUSE_PRICE_LOW", "最低租金");
		rentCustomer.put("HOUSE_PRICE_HIGH", "最高租金");
		rentCustomer.put("HOUSE_AREA_LOW", "最低面积");
		rentCustomer.put("HOUSE_AREA_HIGH", "最高面积");
		rentCustomer.put("HOUSE_YEAR_LOW", "最近年代");
		rentCustomer.put("HOUSE_YEAR_HIGH", "最早年代");
		rentCustomer.put("HOUSE_LOOK", "是否带看");
		rentCustomer.put("CUST_REQUEST", "客户要求");
		rentCustomer.put("CUST_MEMO", "备注");
		rentCustomer.put("TRACK_TIME", "最后跟进日期");
		rentCustomer.put("SCHEDULE_TIME", "预订日期");
		rentCustomer.put("DEAL_TIME", "成交日期");
		rentCustomer.put("WRITEOFF_TIME", "注销日期");
		rentCustomer.put("CREATOR_UID", "创建者");
		rentCustomer.put("CREATION_TIME", "创建时间");
		rentCustomer.put("UPDATE_UID", "最后更新者");
		rentCustomer.put("UPDATE_TIME", "最后更新时间");
		rentCustomer.put("USER_ID", "经纪人");
		rentCustomer.put("RENT_CUST_SEX", "性别");
		rentCustomer.put("RENT_CUST_AGE", "年龄");
		rentCustomer.put("RENT_CUST_CAREER", "职业");
		rentCustomer.put("RENT_LIFEBOUND", "生活圈");
		rentCustomer.put("RENT_GOAL", "购房目的");
		rentCustomer.put("RENT_LENGTH", "期限");
		rentCustomer.put("RENT_ABILITY", "承租能力");
		rentCustomer.put("RENT_PAYTYPE", "付款方式");
		rentCustomer.put("HOUSE_ADDR", "具体地址");
		rentCustomer.put("PLATE_TYPE", "盘别");

		rentCustomer.put("REQ_SUPP", "配套设施");
		rentCustomer.put("OFFICE_LEVEL", "写字楼级别");
		rentCustomer.put("SHOP_USAGE", "目标业态");
		rentCustomer.put("HALL_STRUCTURE", "厅结构");
		rentCustomer.put("GARDEN_AREA", "花园面积");
		rentCustomer.put("GARAGE_AMOUNT", "车位数量");
		rentCustomer.put("ROADS_NAME", "主干道");
		rentCustomer.put("WECHAT_NUMBER", "微信号");
		// rentCustomer.put("REPEAT_FLAG", "重复数据");//陈文超添加 暂时去掉
		tableHM.put("FUN_RENT_CUSTOMER", rentCustomer);
		// 出售
		ddHM.put("SALE_SOURCE", "HOUSE_SOURCE");
		ddHM.put("SALE_LEVEL", "HOUSE_LEVEL");
		ddHM.put("SALE_CONSIGN", "HOUSE_CONSIGN");
		ddHM.put("SALE_ROUND", "HOUSE_ROUND");
		ddHM.put("PLATE_TYPE", "PLATE_TYPE");
		ddHM.put("SALE_TYPE", "HOUSE_TYPE");
		ddHM.put("SALE_FITMENT", "HOUSE_FITMENT");
		ddHM.put("SALE_STRUCT", "HOUSE_STRUCT");
		ddHM.put("SALE_USEAGE", "HOUSE_USEAGE");
		ddHM.put("SALE_RIGHT", "HOUSE_RIGHT");
		ddHM.put("SALE_ACCOUNT", "HOUSE_ACCOUNT");
		ddHM.put("SALE_STATUS", "HOUSE_STATUS");
		ddHM.put("SALE_DIRECT", "HOUSE_DIRECT");
		ddHM.put("SALE_MORTGAGE", "HOUSE_STITUAT");
		ddHM.put("OWNERSHIP_TYPE", "OWNERSHIP_TYPE");
		ddHM.put("HOUSE_SITUATION", "HOUSE_SITUATION");

		// 出租
		ddHM.put("LEASE_SOURCE", "HOUSE_SOURCE");
		ddHM.put("LEASE_LEVEL", "HOUSE_LEVEL");
		ddHM.put("LEASE_CONSIGN", "HOUSE_CONSIGN");
		ddHM.put("LEASE_ROUND", "HOUSE_ROUND");
		ddHM.put("PLATE_TYPE", "PLATE_TYPE");
		ddHM.put("LEASE_TYPE", "HOUSE_TYPE");
		ddHM.put("LEASE_FITMENT", "HOUSE_FITMENT");
		ddHM.put("LEASE_STRUCT", "HOUSE_STRUCT");
		ddHM.put("LEASE_USEAGE", "HOUSE_USEAGE");
		/*
		 * ddHM.put("LEASE_RIGHT", "HOUSE_RIGHT");
		 */ ddHM.put("LEASE_ACCOUNT", "HOUSE_ACCOUNT");
		ddHM.put("LEASE_STATUS", "HOUSE_STATUS");
		ddHM.put("LEASE_ACCOUNT", "RENT_ACCOUNT");
		ddHM.put("LEASE_DIRECT", "HOUSE_DIRECT");
		ddHM.put("LEASE_SET", "HOUSE_SET");
		ddHM.put("LEASE_LIMITE", "HOUSE_LIMITE");
		ddHM.put("PRICE_UNIT", "PRICE_UNIT");

		// 出售、出租公用DD
		ddHM.put("OWNER_TYPE", "OWNER_TYPE");
		ddHM.put("OFFICE_LEVEL", "OFFICE_LEVEL");
		ddHM.put("SHOP_USAGE", "SHOP_USAGE");
		ddHM.put("HALL_STRUCTURE", "HALL_STRUCTURE");
		ddHM.put("UG_TYPE", "UG_TYPE");

		// 求购
		ddHM.put("BUY_CUST_SOURCE", "HOUSE_SOURCE");
		ddHM.put("BUY_CUST_LEVEL", "HOUSE_LEVEL");
		ddHM.put("BUY_CUST_STATUS", "HOUSE_STATUS");
		ddHM.put("HOUSE_ROUND", "HOUSE_ROUND");
		ddHM.put("HOUSE_TYPE", "HOUSE_TYPE");
		ddHM.put("HOUSE_USEAGE", "HOUSE_USEAGE");
		ddHM.put("HOUSE_FITMENT", "HOUSE_FITMENT");
		ddHM.put("HOUSE_DIRECT", "HOUSE_DIRECT");
		ddHM.put("BUY_CUST_AGE", "AGE_TYPE");
		ddHM.put("BUY_CUST_CAREER", "CAREER_TYPE");
		ddHM.put("BUY_GOAL", "GOAL_TYPE");
		ddHM.put("BUY_LENGTH", "LENGTH_TYPE");
		ddHM.put("BUY_ABILITY", "ABILITY_TYPE");
		ddHM.put("BUY_PAYTYPE", "BUY_PAYTYPE");
		ddHM.put("PLATE_TYPE", "PLATE_TYPE");

		// 求租
		ddHM.put("RENT_CUST_SOURCE", "HOUSE_SOURCE");
		ddHM.put("RENT_CUST_LEVEL", "HOUSE_LEVEL");
		ddHM.put("RENT_CUST_STATUS", "HOUSE_STATUS");
		ddHM.put("HOUSE_ROUND", "HOUSE_ROUND");
		ddHM.put("HOUSE_TYPE", "HOUSE_TYPE");
		ddHM.put("HOUSE_USEAGE", "HOUSE_USEAGE");
		ddHM.put("HOUSE_FITMENT", "HOUSE_FITMENT");
		ddHM.put("HOUSE_DIRECT", "HOUSE_DIRECT");
		ddHM.put("RENT_CUST_AGE", "AGE_TYPE");
		ddHM.put("RENT_CUST_CAREER", "CAREER_TYPE");
		ddHM.put("RENT_GOAL", "GOAL_TYPE");
		ddHM.put("RENT_LENGTH", "LENGTH_TYPE");
		ddHM.put("RENT_ABILITY", "ABILITY_TYPE");
		ddHM.put("RENT_PAYTYPE", "RENT_ACCOUNT");
		ddHM.put("PLATE_TYPE", "PLATE_TYPE");

		addHM.put("LEASE_PROPERTY", "物业费");
		addHM.put("IS_SEPERATOR", "是否可分割");
		addHM.put("OWNER_TYPE", "业主类型");
		addHM.put("OFFICE_LEVEL", "写字楼级别");
		addHM.put("SHOP_USAGE", "商铺用途");
		addHM.put("HALL_STRUCTURE", "厅结构");
		addHM.put("UG_AREA", "地下面积");
		addHM.put("UG_TYPE", "地下类型");
		addHM.put("GARDEN_AREA", "花园面积");
		addHM.put("GARAGE_AMOUNT", "车位数量");

		// 出售
		HashMap temp2 = new HashMap();
		temp2.put("1", "是");
		temp2.put("0", "否");
		keyValueHM.put("SALE_STREET", temp2);

		HashMap temp3 = new HashMap();
		temp3.put("1", "有");
		temp3.put("0", "无");
		keyValueHM.put("SALE_KEY", temp3);

		HashMap temp4 = new HashMap();
		temp4.put("1", "已勘");
		temp4.put("0", "未勘");
		keyValueHM.put("SALE_EXPLRTH", temp4);

		HashMap temp5 = new HashMap();
		temp5.put("1", "要合作");
		temp5.put("0", "不合作");
		temp5.put("2", "已选朋友圈合作");
		keyValueHM.put("SALE_COOPERATE", temp5);

		HashMap temp6 = new HashMap();
		temp6.put("1", "打开");
		temp6.put("0", "关闭");
		keyValueHM.put("SALE_PUBLISH", temp6);

		HashMap temp7 = new HashMap();
		temp7.put("1", "有图");
		temp7.put("0", "无图");
		keyValueHM.put("SALE_MAP", temp7);

		// 出租
		HashMap temp9 = new HashMap();
		temp9.put("1", "是");
		temp9.put("0", "否");
		keyValueHM.put("LEASE_STREET", temp9);

		HashMap temp10 = new HashMap();
		temp10.put("1", "有");
		temp10.put("0", "无");
		keyValueHM.put("LEASE_KEY", temp10);

		HashMap temp11 = new HashMap();
		temp11.put("1", "已勘");
		temp11.put("0", "未勘");
		keyValueHM.put("LEASE_EXPLRTH", temp11);

		HashMap temp12 = new HashMap();
		temp12.put("1", "要合作");
		temp12.put("0", "不合作");
		keyValueHM.put("LEASE_COOPERATE", temp12);

		HashMap temp13 = new HashMap();
		temp13.put("1", "打开");
		temp13.put("0", "关闭");
		keyValueHM.put("LEASE_PUBLISH", temp13);

		HashMap temp17 = new HashMap();
		temp17.put("1", "有图");
		temp17.put("0", "无图");
		keyValueHM.put("LEASE_MAP", temp17);

		// 客户
		HashMap temp14 = new HashMap();
		temp14.put("A", "A");
		temp14.put("B", "B");
		temp14.put("C", "C");
		temp14.put("D", "D");
		temp14.put("1", "A");
		temp14.put("2", "B");
		temp14.put("3", "C");
		temp14.put("4", "D");
		keyValueHM.put("CUST_LEVEL", temp14);

		HashMap temp15 = new HashMap();
		temp15.put("1", "有带看");
		temp15.put("0", "未带看");
		keyValueHM.put("HOUSE_LOOK", temp15);

		HashMap temp16 = new HashMap();
		temp16.put("1", "先生");
		temp16.put("0", "女士");
		keyValueHM.put("BUY_CUST_SEX", temp16);
		keyValueHM.put("RENT_CUST_SEX", temp16);

		HashMap temp18 = new HashMap();
		temp18.put("1", "是");
		temp18.put("0", "否");
		keyValueHM.put("IS_SEPERATOR", temp18);

		HashMap temp19 = new HashMap();
		temp19.put("1", "好友圈合作");
		temp19.put("0", "好友圈不合作");
		keyValueHM.put("FRIEND_HOUSE", temp19);

		HashMap temp20 = new HashMap();
		temp20.put("1", "要合作");
		temp20.put("0", "不合作");
		temp20.put("2", "已选朋友圈合作");
		keyValueHM.put("COOPERATE_FLAG", temp20);

		HashMap temp21 = new HashMap();
		temp21.put("1", "要发布");
		temp21.put("0", "不发布");
		keyValueHM.put("SENDTOTENCENT", temp21);

		HashMap temp22 = new HashMap();
		temp22.put("1", "真房源");
		temp22.put("0", "非真房源");
		keyValueHM.put("TRUE_FLAG", temp22);

		HashMap temp23 = new HashMap();
		temp23.put("1", "合租");
		temp23.put("0", "整租");
		keyValueHM.put("LEASE_ROOM_TYPE", temp23);

		HashMap temp24 = new HashMap();
		temp24.put("3", "床位");
		temp24.put("2", "隔断间");
		temp24.put("1", "次卧");
		temp24.put("0", "主卧");
		keyValueHM.put("LEASE_ROOM_CLASSIC", temp24);

		HashMap temp25 = new HashMap();
		temp25.put("2", "女");
		temp25.put("1", "男");
		temp25.put("0", "不限");
		keyValueHM.put("FLAT_SHARE_SEX", temp25);

		HashMap temp26 = new HashMap();
		temp26.put("1", "要发布");
		temp26.put("0", "不发布");
		keyValueHM.put("SENDTO_WEIDIAN", temp26);
		
		HashMap temp27 = new HashMap();
		temp27.put("1", "要发布");
		temp27.put("0", "不发布");
		keyValueHM.put("SENDTO_YOUYOU", temp27);
		
		HashMap temp28 = new HashMap();
		temp27.put("1", "身份证");
		temp27.put("2", "护照");
		temp27.put("3", "军官证");
		temp27.put("4", "士兵证");
		temp27.put("5", "回乡证");
		temp27.put("6", "台胞证");
		keyValueHM.put("JOINT_ID_CARD_TYPE", temp28);
		
		HashMap temp29 = new HashMap();
		temp27.put("1", "身份证");
		temp27.put("2", "护照");
		temp27.put("3", "军官证");
		temp27.put("4", "士兵证");
		temp27.put("5", "回乡证");
		temp27.put("6", "台胞证");
		keyValueHM.put("ID_CARD_TYPE", temp29);
		
		

		decodeFieldsCN = new String[] { "微信号", "电话", "业主", "身份证", "栋座", "单元", "楼", "号", "备注", "客户", "住址", "共有人姓名", "共有人电话",
				"共有人身份证", };

		decodeFields = new String[] { "WECHAT_NUMBER", "CELL_PHONE", "JOINT_CELL_PHONE", "ID_CARD", "SALE_ROOF", "SALE_UNIT", "SALE_NUM",
				"LEASE_ROOF", "LEASE_UNIT", "LEASE_NUM", "UNIT_FLOOR", };
	}
}
