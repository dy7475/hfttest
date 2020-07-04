package com.myfun.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 数据同步的相关常量类 
 * @author hyq
 * @version 1.0
 * @created Aprl 23, 2014 22:51:30 AM
 *
 * 修改记录：
 * 	2014-04-18 添加MOBILE_VALIDED字段(FUN_SALE,FUN_LEASE,FUN_USERS)		
 */
public final class ConstantTrans4TX_CRM {
	
	public static final String CITY_ID = "CITY_ID";
	public static final String TABLE_NAME = "TABLE_NAME";
	public static final String DEAL_TYPE = "DEAL_TYPE";
	public static final String DATA_ELEMENT = "DATA_ELEMENT";
	
	//表名
	public static final String TABLE_T_ESF_BROKER = "t_esf_broker";
	public static final String TABLE_T_ESF_BUY = "t_esf_buy";
	public static final String TABLE_T_ESF_CITY = "t_esf_city";
	public static final String TABLE_T_ESF_COMPLAINT = "t_esf_complaint";
	public static final String TABLE_T_ESF_CONSUMER_COLLECT = "t_esf_consumer_collect";
	public static final String TABLE_T_ESF_CONSUMER_CONDITION = "t_esf_consumer_condition";
	public static final String TABLE_T_ESF_DIC = "t_esf_dic";
	public static final String TABLE_T_ESF_HOUSE = "t_esf_house";
	public static final String TABLE_T_ESF_HOUSE_PHOTO = "t_esf_house_photo";
	public static final String TABLE_T_ESF_HOUSE_PRICE_CHANGES = "t_esf_house_price_changes";
	public static final String TABLE_T_ESF_LEASE = "t_esf_lease";
	public static final String TABLE_T_ESF_LEASE_LIST = "t_esf_lease_list";
	public static final String TABLE_T_ESF_PHOTO = "t_esf_photo";
	public static final String TABLE_T_ESF_PRICE_CHANGES = "t_esf_price_changes";
	public static final String TABLE_T_ESF_RENT = "t_esf_rent";
	public static final String TABLE_T_ESF_SALE = "t_esf_sale";
	public static final String TABLE_T_ESF_SALE_LIST = "t_esf_sale_list";
	public static final String TABLE_T_ESF_SMS = "t_esf_sms";
	public static final String TABLE_T_ESF_SYNCLOGS = "t_esf_synclogs";
	public static final String TABLE_T_ESF_SYNCLOGS_HIS = "t_esf_synclogs_his";
	public static final String TABLE_T_ESF_TAG = "t_esf_tag";
	public static final String TABLE_T_ESF_TRACK = "t_esf_track";
	public static final String TABLE_T_ESF_SALE_CHK = "t_esf_sale_chk";
	public static final String TABLE_T_ESF_LEASE_CHK = "t_esf_lease_chk";
	public static final String TABLE_T_ESF_BUY_CHK = "t_esf_buy_chk";
	public static final String TABLE_T_ESF_RENT_CHK = "t_esf_rent_chk";

	/**
	 *  2014-5-10 生成，备份参考
		private static final String[] PK_T_ESF_BROKER = new String[]{"FId","FDataType"};
		private static final String[] PK_T_ESF_BUY = new String[]{"FId"};
		private static final String[] PK_T_ESF_CITY = new String[]{"FId"};
		private static final String[] PK_T_ESF_COMPLAINT = new String[]{"FId"};
		private static final String[] PK_T_ESF_CONSUMER_COLLECT = new String[]{"FId"};
		private static final String[] PK_T_ESF_CONSUMER_CONDITION = new String[]{"FId"};
		private static final String[] PK_T_ESF_DIC = new String[]{"FId"};
		private static final String[] PK_T_ESF_HOUSE = new String[]{"FId","FCityId"};
		private static final String[] PK_T_ESF_HOUSE_PHOTO = new String[]{"FId","FCityId"};
		private static final String[] PK_T_ESF_HOUSE_PRICE_CHANGES = new String[]{"FCityId","FHouseId","FStDate","FCaseType"};
		private static final String[] PK_T_ESF_LEASE = new String[]{"FCityId","FDataType","FId"};
		private static final String[] PK_T_ESF_LEASE_LIST = new String[]{"FCityId","FDataType","FId"};
		private static final String[] PK_T_ESF_PHOTO = new String[]{"FCityId","FDataType","FId"};
		private static final String[] PK_T_ESF_PRICE_CHANGES = new String[]{"FCityId","Ftype","FCaseId","FCaseType","FStDate"};
		private static final String[] PK_T_ESF_RENT = new String[]{"FId"};
		private static final String[] PK_T_ESF_SALE = new String[]{"FCityId","FDataType","FId"};
		private static final String[] PK_T_ESF_SALE_LIST = new String[]{"FCityId","FDataType","FId"};
		private static final String[] PK_T_ESF_SMS = new String[]{"FId"};
		private static final String[] PK_T_ESF_SYNCLOGS = new String[]{"FId"};
		private static final String[] PK_T_ESF_SYNCLOGS_HIS = new String[]{"FId"};
		private static final String[] PK_T_ESF_TAG = new String[]{"FId"};
		private static final String[] PK_T_ESF_TRACK = new String[]{"FId","FCityId"};
	 */
	//表主键(一旦运行，请勿修改)
	private static final String[] PK_T_ESF_BROKER = new String[]{"FId","FDataType"};
	private static final String[] PK_T_ESF_BUY = new String[]{"FId"};
	private static final String[] PK_T_ESF_CITY = new String[]{"FId"};
	private static final String[] PK_T_ESF_COMPLAINT = new String[]{"FId"};
	private static final String[] PK_T_ESF_CONSUMER_COLLECT = new String[]{"FId"};
	private static final String[] PK_T_ESF_CONSUMER_CONDITION = new String[]{"FId"};
	private static final String[] PK_T_ESF_DIC = new String[]{"FId"};
	private static final String[] PK_T_ESF_HOUSE = new String[]{"FId","FCityId"};
	private static final String[] PK_T_ESF_HOUSE_PHOTO = new String[]{"FId","FCityId"};
	private static final String[] PK_T_ESF_HOUSE_PRICE_CHANGES = new String[]{"FCityId","FHouseId","FStDate","FCaseType"};
	private static final String[] PK_T_ESF_LEASE = new String[]{"FCityId","FDataType","FId"};
	private static final String[] PK_T_ESF_LEASE_LIST = new String[]{"FCityId","FDataType","FId"};
	private static final String[] PK_T_ESF_PHOTO = new String[]{"FCityId","FDataType","FId"};
	private static final String[] PK_T_ESF_PRICE_CHANGES = new String[]{"FCityId","Ftype","FCaseId","FCaseType","FStDate"};
	private static final String[] PK_T_ESF_RENT = new String[]{"FId"};
	private static final String[] PK_T_ESF_SALE = new String[]{"FCityId","FDataType","FId"};
	private static final String[] PK_T_ESF_SALE_LIST = new String[]{"FCityId","FDataType","FId"};
	private static final String[] PK_T_ESF_SMS = new String[]{"FId"};
	private static final String[] PK_T_ESF_SYNCLOGS = new String[]{"FId"};
	private static final String[] PK_T_ESF_SYNCLOGS_HIS = new String[]{"FId"};
	private static final String[] PK_T_ESF_TAG = new String[]{"FId"};
	private static final String[] PK_T_ESF_TRACK = new String[]{"FId","FCityId"};
	private static final String[] PK_T_ESF_RENT_CHK = new String[]{"FId"};
	private static final String[] PK_T_ESF_SALE_CHK = new String[]{"FCityId","FDataType","FId"};
	private static final String[] PK_T_ESF_LEASE_CHK = new String[]{"FCityId","FDataType","FId"};
	private static final String[] PK_T_ESF_BUY_CHK = new String[]{"FId"};
	public static HashMap<String,String[]> MAPPING_KEY = null;
	
	static{
		if(MAPPING_KEY==null){
			MAPPING_KEY = new HashMap<String, String[]>();
			MAPPING_KEY.put(TABLE_T_ESF_BROKER, PK_T_ESF_BROKER);
			MAPPING_KEY.put(TABLE_T_ESF_BUY, PK_T_ESF_BUY);
			MAPPING_KEY.put(TABLE_T_ESF_CITY, PK_T_ESF_CITY);
			MAPPING_KEY.put(TABLE_T_ESF_COMPLAINT, PK_T_ESF_COMPLAINT);
			MAPPING_KEY.put(TABLE_T_ESF_CONSUMER_COLLECT, PK_T_ESF_CONSUMER_COLLECT);
			MAPPING_KEY.put(TABLE_T_ESF_CONSUMER_CONDITION, PK_T_ESF_CONSUMER_CONDITION);
			MAPPING_KEY.put(TABLE_T_ESF_DIC, PK_T_ESF_DIC);
			MAPPING_KEY.put(TABLE_T_ESF_HOUSE, PK_T_ESF_HOUSE);
			MAPPING_KEY.put(TABLE_T_ESF_HOUSE_PHOTO, PK_T_ESF_HOUSE_PHOTO);
			MAPPING_KEY.put(TABLE_T_ESF_HOUSE_PRICE_CHANGES, PK_T_ESF_HOUSE_PRICE_CHANGES);
			MAPPING_KEY.put(TABLE_T_ESF_LEASE, PK_T_ESF_LEASE);
			MAPPING_KEY.put(TABLE_T_ESF_LEASE_LIST, PK_T_ESF_LEASE_LIST);
			MAPPING_KEY.put(TABLE_T_ESF_PHOTO, PK_T_ESF_PHOTO);
			MAPPING_KEY.put(TABLE_T_ESF_PRICE_CHANGES, PK_T_ESF_PRICE_CHANGES);
			MAPPING_KEY.put(TABLE_T_ESF_RENT, PK_T_ESF_RENT);
			MAPPING_KEY.put(TABLE_T_ESF_SALE, PK_T_ESF_SALE);
			MAPPING_KEY.put(TABLE_T_ESF_SALE_LIST, PK_T_ESF_SALE_LIST);
			MAPPING_KEY.put(TABLE_T_ESF_SMS, PK_T_ESF_SMS);
			MAPPING_KEY.put(TABLE_T_ESF_SYNCLOGS, PK_T_ESF_SYNCLOGS);
			MAPPING_KEY.put(TABLE_T_ESF_SYNCLOGS_HIS, PK_T_ESF_SYNCLOGS_HIS);
			MAPPING_KEY.put(TABLE_T_ESF_TAG, PK_T_ESF_TAG);
			MAPPING_KEY.put(TABLE_T_ESF_TRACK, PK_T_ESF_TRACK);
			
			MAPPING_KEY.put(TABLE_T_ESF_SALE_CHK, PK_T_ESF_SALE_CHK);
			MAPPING_KEY.put(TABLE_T_ESF_LEASE_CHK, PK_T_ESF_LEASE_CHK);
			MAPPING_KEY.put(TABLE_T_ESF_BUY_CHK, PK_T_ESF_BUY_CHK);
			MAPPING_KEY.put(TABLE_T_ESF_RENT_CHK, PK_T_ESF_RENT_CHK);
		}
	}
	
	public static String[] getPrimaryKeyArr(String key){
		return MAPPING_KEY.get(key);
	}
	
	/**
	 * 转化为同步表的dataMap
	 * @param tableName 数据表名
	 * @param pkDataMap 关于同步数据的主键Map
	 * @return
	 */
	public static HashMap<String, String> parserTranMap(String tableName,HashMap pkDataMap){
		HashMap<String, String> dataMap = new HashMap<String, String>();
		String[] pkArr = getPrimaryKeyArr(tableName);
		for(int index=0,len=pkArr.length;index<len;index++){
			String key = pkArr[index];
			dataMap.put("fPKeyId"+(index+1), (String)pkDataMap.get(key));
		}
		return dataMap;
	}
	
	public static void parserTranMapToPo(Object bean, String tableName,HashMap pkDataMap) throws InvocationTargetException{
		HashMap<String, String> hashMap = parserTranMap(tableName, pkDataMap);
		Iterator<String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			String value = hashMap.get(key);
			try {
				BeanUtilsHelper.setProperty(bean, key, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		//假设现在需要同步PK_T_ESF_LEASE_LIST记录
		//以下的map的key为需要同步表的主键
		HashMap dataMap = new HashMap();
		dataMap.put("FDataType", "3");
		dataMap.put("FCityId", "1");
		dataMap.put("FId", "100");
		System.out.println(dataMap);
		HashMap pkMap = parserTranMap(ConstantTrans4TX_CRM.TABLE_T_ESF_LEASE_LIST,dataMap);
		
		System.out.println(Arrays.toString(pkMap.keySet().toArray()).replace("[", "").replace("]", ""));
		
		System.out.println(Arrays.toString(pkMap.values().toArray()).replace("[", "").replace("]", ""));
		System.out.println(pkMap);
	}
}
