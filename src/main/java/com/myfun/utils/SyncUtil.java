
package com.myfun.utils;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SyncUtil {
	
	/**
	 * 同步HouseCustSuperAction.procePhone
	 * @param phoneStr
	 * @return
	 */
	public static String procePhone(String phoneStr){
//		手机:15856487897 手机:15856478979 请求的参数格式
//		&&&座机|||6313?3?3?330:3:3=384<:&&&手机|||93;313?3731442=3540145&&& 处理后的结果
		if (StringUtils.isNotBlank(phoneStr)) {
			String phone = "&&&";
			String[] phones = StringHelper.split(phoneStr, " ");
			for (int i = 0; i < phones.length; i++) {
				String[] phoneValues = StringHelper.split(phones[i], ":");
				if (phoneValues.length > 1) {
					phoneValues[1] = EnCodeHelper.encode(phoneValues[1]);
					phone += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
				}
			}
			return phone;
		}
		return "";
	}
	/**
	 * 用于好房优家楼盘资料电话号码解密用
	 * @param cellPhone 电话号码
	 * @param showAll 是否显示全部电话，false时将末尾四位变为星
	 * @return
	 */
	public static String decodePhoneForYoujiaDetail(String cellPhone, boolean showAll){
		String phone = "";
		if(StringUtils.isBlank(cellPhone)){
			return phone;
		}
		String[] phones = StringHelper.split(cellPhone, "&&&");
		if(phones == null || phones.length <= 0)
			return phone;
		String[] phoneValues = StringHelper.split(phones[0], "|||");
		if(phoneValues != null && phoneValues.length == 2){
			phone = EnCodeHelper.decode(phoneValues[1]);
			if(StringUtils.isNotBlank(phone) && !showAll){
				int len = phone.length();
				if(phone.length() > 4){
					phone = phone.substring(0, 3)+"*****"+phone.substring(len-3, len);
				}
			}
		}
		return phone;
	}
	
	/**
	 * 房客源详情使用的加密所属人
	 * @param owner
	 * @return
	 */
	public static String decodeOwnerForHouseDetail(String owner){
		if(StringUtils.isNotBlank(owner)){
			return owner.substring(0, 1)+"**";
		}
		return "***";
	}
	
	/**
	 * 房客源详情使用的解密电话
	 * @param phoneStr 电话号码
	 * @param encrypt 是否加密成*号
	 * @return
	 */
	public static String decodePhoneForHouseDetail(String phoneStr, boolean encrypt){
		if(StringUtils.isBlank(phoneStr)){
			return null;
		}
		String phone = "";
		String[] phones = StringHelper.split(phoneStr, "&&&");
		try {
			for(int i=0; i< phones.length; i++){
				String[] phoneValues = StringHelper.split(phones[i], "|||");
				phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
				if(encrypt){
					ecodePhoneToArr(phoneValues);
				}
				phone += phoneValues[0] + ":" + phoneValues[1]+" ";
			}
		} catch (Exception e) {
			phone = phoneStr;
		}
     	return phone;
	}
	
	/**
	 * 楼盘资料解密第N个电话
	 * @param phoneStr 电话号码
	 * @param index 第几个
	 * @return
	 */
	public static String decodePhoneForBuildInfoCall(String phoneStr,int index){
		if(StringUtils.isBlank(phoneStr)){
			return null;
		}
		String phone = "";
		String[] phones = StringHelper.split(phoneStr, "&&&");
		try {
			String[] phoneValues = StringHelper.split(phones[index-1], "|||");
			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
			phone = phoneValues[1];
		} catch (Exception e) {
			
		}
		return phone;
	}
	/**
	 * 房客源详情使用的电话用&&&隔开，在判重时需要用
	 * @param phoneStr 电话号码
	 *
	 * @return
	 */
	public static String decodePhoneForHouseDetail(String phoneStr){
		if(StringUtils.isBlank(phoneStr)){
			return null;
		}
		String phone = "";
		String[] phones = StringHelper.split(phoneStr, "&&&");
		try {
			for(int i=0; i< phones.length; i++){
				String[] phoneValues = StringHelper.split(phones[i], "|||");
				if(i!=phones.length-1){
					phone +=  phoneValues[1]+"&&&";
				}else{
					phone +=  phoneValues[1];
				}
			}
		} catch (Exception e) {
			phone = phoneStr;
		}
		return phone;
	}
	/**
	 * 只返回第一个电话
	 * @param phoneStr 电话号码
	 * @param encrypt 是否加密成*号
	 * @return
	 */
	public static String decodePhoneForHouseDetailOfFirst(String phoneStr, boolean encrypt){
		if(StringUtils.isBlank(phoneStr)){
			return null;
		}
		String phone = "";
		String[] phones = StringHelper.split(phoneStr, "&&&");
		try {
			if(phones.length>=1){
				String[] phoneValues = StringHelper.split(phones[0], "|||");
				phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
				if(encrypt){
					ecodePhoneToArr(phoneValues);
				}
				phone += phoneValues[0] + ":" + phoneValues[1]+" ";
			}
		} catch (Exception e) {
			
		}
		phone = phone.trim();
		return phone;
	}
	public static String getDecodePhone(String encodePhone) {
		if(StringUtils.isNotBlank(encodePhone)){
			if(encodePhone.indexOf(":")!=-1){
				String[] phoneArr = encodePhone.split(":");
				ecodePhoneToArr(phoneArr);	
				return phoneArr[0] + ":" + phoneArr[1];
			}
		}
		return null;
	}
	public static String getDecodePhoneAndType(String encodePhone) {
		if(StringUtils.isNotBlank(encodePhone)){
			if(encodePhone.indexOf(":")!=-1){
				String[] phoneArr = encodePhone.split(":");
				ecodePhoneToArr(phoneArr);	
				return phoneArr[0]+":"+phoneArr[1];
			}
		}
		return null;
	}
	/**
	 * 电话中间加密成*号公用方法
	 * @param phoneStr 电话号码
	 * @param encrypt 是否加密成*号
	 * @return
	 */
	public static void ecodePhoneToArr(String[] phoneStr){
		String num = phoneStr[1];
		int len = phoneStr[1].trim().length();
		if("手机".equals(phoneStr[0])){
			if(phoneStr[1].length()>7){
				phoneStr[1] = num.substring(0, 2)+"*******"+ num.substring(len -2, len);
			}
		} else if("座机".equals(phoneStr[0])){
			if(phoneStr[1].length()>4){
				phoneStr[1] = num.substring(0, 2)+"****"+ num.substring(len -2, len);
			}
		} else if("小灵通".equals(phoneStr[0])){
			if(phoneStr[1].length()>4){
				phoneStr[1] = num.substring(0, 2)+"****"+ num.substring(len -2, len);
			}
		} else {
			phoneStr[1] = num.substring(0, 2)+"****"+ num.substring(len -2, len);
		}
	}



	/**
	 * 电话解密公用方法
	 * @param phoneStr 电话号码
	 * @param encrypt 是否加密成*号
	 * @return
	 */
	public static String[] decodePhoneToArr(String phoneStr, boolean encrypt){
		if (StringUtils.isBlank(phoneStr)) {
			return null;
		}
		String[] phones = StringHelper.split(phoneStr, "&&&");
		try {
			for (int i = 0; i < phones.length; i++) {
				String[] phoneValues = StringHelper.split(phones[i], "|||");
				phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
				if (encrypt) {
					ecodePhoneToArr(phoneValues);
				}
				phones[i] = phoneValues[1];
			}
		} catch (Exception e) {
			return null;
		}
		return phones;
	}

	/**
	 * 用于房源数据同步电话号码解密用
	 * @param cellPhone
	 * @return
	 */
	public static String decodePhoneStr(String cellPhone){
		if(StringUtils.isBlank(cellPhone)){
			return null;
		}
		String phone = "";
		String[] phones = StringHelper.split(cellPhone, "&&&");
		try {
			for(int i=0; i<phones.length; i++){
				String[] phoneValues = StringHelper.split(phones[i], "|||");
				if(i != 0)
					phone += ",";
				phone += EnCodeHelper.decode(phoneValues[1]);
			}
		} catch (Exception e) {
			phone=cellPhone;
		}
		return phone;
	}
	
	public static String decodePhone(String cellPhone){
		if(StringUtils.isBlank(cellPhone)){
			return null;
		}
		String phone = "";
		String[] phones = StringHelper.split(cellPhone, "&&&");
  		try {
  			for(int i=0; i<phones.length; i++){
  	  			String[] phoneValues = StringHelper.split(phones[i], "|||");
  	  			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
  	  			phone +="&&&"+ phoneValues[0] + "|||" + phoneValues[1];
  	  		}
		} catch (Exception e) {
			phone=cellPhone;
		}
     	return phone;
	}
	
	protected static String ecodePhoneForBase64(String cellPhone){
		if(StringUtils.isBlank(cellPhone)){
			return null;
		}
		String phone = "&&&";
		String[] phones = StringHelper.split(cellPhone, "&&&");
  		try {
  			for(int i=0; i<phones.length; i++){
  	  			String[] phoneValues = StringHelper.split(phones[i], "|||");
	  	  		if(phoneValues.length>1){
					phoneValues[1] = Base64.encodeToString(phoneValues[1]);
					phone += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
				}else{
					phone=Base64.encodeToString(phoneValues[0]);
				}
  			}
		} catch (Exception e) {
			phone=cellPhone;
		}
     	return phone;
	}
	
	public static String getValue(String value){
		if(value==null){
			return "null";
		}else{
			return "'"+value+"'";
		}
	}
	
	public static void generateSaleSql(Connection connection,int compId,File outputFile) throws SQLException, IOException{
		if(!outputFile.exists()){
			outputFile.createNewFile();
		}
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile))); 
		try{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(500);
			ResultSet rs = statement.executeQuery("SELECT SALE_ID,COMP_ID,DEPT_ID,USER_ID,TRADE_ADDR,SALE_OWNER,CELL_PHONE,ID_CARD,SALE_ROOF,SALE_UNIT,UNIT_FLOOR,SALE_NUM,SALE_ROOF_R,SALE_UNIT_R,UNIT_FLOOR_R,SALE_NUM_R,SALE_MEMO,SALE_USEAGE,BUILD_ID,REPEAT_FLAG,CREATION_TIME FROM FUN_SALE WHERE COMP_ID="+compId);
			while (rs.next()) {
				bufferedWriter.append("INSERT INTO SALE_CORE_INFO (SALE_ID,COMP_ID,DEPT_ID,USER_ID,TRADE_ADDR,SALE_OWNER,CELL_PHONE,ID_CARD,SALE_ROOF,SALE_UNIT,UNIT_FLOOR,SALE_NUM,SALE_ROOF_R,SALE_UNIT_R,UNIT_FLOOR_R,SALE_NUM_R,SALE_MEMO,SALE_USEAGE,BUILD_ID,REPEAT_FLAG,CREATION_TIME) VALUES ("
						+getValue(rs.getString("SALE_ID"))+","
						+getValue(rs.getString("COMP_ID"))+","
						+getValue(rs.getString("DEPT_ID"))+","
						+getValue(rs.getString("USER_ID"))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("TRADE_ADDR")))))+","
						+getValue(tranValue(rs.getString("SALE_OWNER")))+","
						+getValue((ecodePhoneForBase64(decodePhone(rs.getString("CELL_PHONE")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("ID_CARD")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("SALE_ROOF")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("SALE_UNIT")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("UNIT_FLOOR")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("SALE_NUM")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("SALE_ROOF_R")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("SALE_UNIT_R")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("UNIT_FLOOR_R")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("SALE_NUM_R")))))+","
						+getValue(tranValue(rs.getString("SALE_MEMO")))+","
						+getValue(tranValue(rs.getString("SALE_USEAGE")))+","
						+getValue(rs.getString("BUILD_ID"))+","
						+getValue(rs.getString("REPEAT_FLAG"))+","
						+getValue(rs.getString("CREATION_TIME"))+""
						+ "); ").append("\n");
			}
			rs.close();
			statement.close();
		}finally{
			bufferedWriter.close();
		}
	}
	private static String tranValue(String value){
		if(value != null){
			value = value.replaceAll("'", "\\\\'");
			if(value.endsWith("\\")){
				value+="\\";
			}
		}
		return value;
	} 
	public static void generateLeaseSql(Connection connection,int compId,File outputFile) throws SQLException, IOException{
		if(!outputFile.exists()){
			outputFile.createNewFile();
		}
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile))); 
		try{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(500);
			ResultSet rs = statement.executeQuery("SELECT LEASE_ID,COMP_ID,DEPT_ID,USER_ID,TRADE_ADDR,LEASE_OWNER,CELL_PHONE,ID_CARD,LEASE_ROOF,LEASE_UNIT,UNIT_FLOOR,LEASE_NUM,LEASE_ROOF_R,LEASE_UNIT_R,UNIT_FLOOR_R,LEASE_NUM_R,LEASE_MEMO,LEASE_USEAGE,BUILD_ID,REPEAT_FLAG,CREATION_TIME FROM FUN_LEASE WHERE COMP_ID="+compId);
			while (rs.next()) {
				bufferedWriter.append("INSERT INTO LEASE_CORE_INFO (LEASE_ID,COMP_ID,DEPT_ID,USER_ID,TRADE_ADDR,LEASE_OWNER,CELL_PHONE,ID_CARD,LEASE_ROOF,LEASE_UNIT,UNIT_FLOOR,LEASE_NUM,LEASE_ROOF_R,LEASE_UNIT_R,UNIT_FLOOR_R,LEASE_NUM_R,LEASE_MEMO,LEASE_USEAGE,BUILD_ID,REPEAT_FLAG,CREATION_TIME) VALUES ("
						+getValue(rs.getString("LEASE_ID"))+","
						+getValue(rs.getString("COMP_ID"))+","
						+getValue(rs.getString("DEPT_ID"))+","
						+getValue(rs.getString("USER_ID"))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("TRADE_ADDR")))))+","
						+getValue(tranValue(rs.getString("LEASE_OWNER")))+","
						+getValue((ecodePhoneForBase64(decodePhone(rs.getString("CELL_PHONE")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("ID_CARD")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("LEASE_ROOF")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("LEASE_UNIT")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("UNIT_FLOOR")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("LEASE_NUM")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("LEASE_ROOF_R")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("LEASE_UNIT_R")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("UNIT_FLOOR_R")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("LEASE_NUM_R")))))+","
						+getValue(tranValue(rs.getString("LEASE_MEMO")))+","
						+getValue(tranValue(rs.getString("LEASE_USEAGE")))+","
						+getValue(rs.getString("BUILD_ID"))+","
						+getValue(rs.getString("REPEAT_FLAG"))+","
						+getValue(rs.getString("CREATION_TIME"))+""
						+ "); ").append("\n");
			}
			rs.close();
			statement.close();
		}finally{
			bufferedWriter.close();
		}
	}
	public static void generateBuySql(Connection connection,int compId,File outputFile) throws SQLException, IOException{
		if(!outputFile.exists()){
			outputFile.createNewFile();
		}
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile))); 
		try{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(500);
			ResultSet rs = statement.executeQuery("SELECT BUY_CUST_ID,COMP_ID,DEPT_ID,USER_ID,BUY_CUST_NAME,CELL_PHONE,ID_CARD,CUST_MEMO,BUILD_NAME,HOUSE_PRICE_LOW,HOUSE_PRICE_HIGH,BUY_CUST_SEX,CUST_ADDR,CUST_REQUEST,REPEAT_FLAG,CREATION_TIME FROM FUN_BUY_CUSTOMER WHERE COMP_ID="+compId);
			while (rs.next()) {
				bufferedWriter.append("INSERT INTO buy_core_info (BUY_ID,COMP_ID,DEPT_ID,USER_ID,BUY_CUST_NAME,CELL_PHONE,ID_CARD,CUST_MEMO,BUILD_NAME,HOUSE_PRICE_LOW,HOUSE_PRICE_HIGH,BUY_CUST_SEX,CUST_ADDR,CUST_REQUEST,REPEAT_FLAG,CREATION_TIME) VALUES ("
						+getValue(rs.getString("BUY_CUST_ID"))+","
						+getValue(rs.getString("COMP_ID"))+","
						+getValue(rs.getString("DEPT_ID"))+","
						+getValue(rs.getString("USER_ID"))+","
						+getValue(tranValue(rs.getString("BUY_CUST_NAME")))+","
						+getValue((ecodePhoneForBase64(decodePhone(rs.getString("CELL_PHONE")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("ID_CARD")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("CUST_MEMO")))))+","
						+getValue(rs.getString("BUILD_NAME"))+","
						+getValue(rs.getString("HOUSE_PRICE_LOW"))+","
						+getValue(rs.getString("HOUSE_PRICE_HIGH"))+","
						+getValue(rs.getString("BUY_CUST_SEX"))+","
						+getValue(rs.getString("CUST_ADDR"))+","
						+getValue(tranValue(rs.getString("CUST_REQUEST")))+","
						+getValue(rs.getString("REPEAT_FLAG"))+","
						+getValue(rs.getString("CREATION_TIME"))
						+ "); ").append("\n");
			}
			rs.close();
			statement.close();
		}finally{
			bufferedWriter.close();
		}
	}
	public static void generateRentSql(Connection connection,int compId,File outputFile) throws SQLException, IOException{
		if(!outputFile.exists()){
			outputFile.createNewFile();
		}
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile))); 
		try{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(500);
			ResultSet rs = statement.executeQuery("SELECT RENT_CUST_ID,COMP_ID,DEPT_ID,USER_ID,RENT_CUST_NAME,CELL_PHONE,ID_CARD,CUST_MEMO,BUILD_NAME,HOUSE_PRICE_LOW,HOUSE_PRICE_HIGH,RENT_CUST_SEX,CUST_ADDR,CUST_REQUEST,REPEAT_FLAG,CREATION_TIME FROM FUN_RENT_CUSTOMER WHERE COMP_ID="+compId);
			while (rs.next()) {
				bufferedWriter.append("INSERT INTO rent_core_info (RENT_ID,COMP_ID,DEPT_ID,USER_ID,RENT_CUST_NAME,CELL_PHONE,ID_CARD,CUST_MEMO,BUILD_NAME,HOUSE_PRICE_LOW,HOUSE_PRICE_HIGH,RENT_CUST_SEX,CUST_ADDR,CUST_REQUEST,REPEAT_FLAG,CREATION_TIME) VALUES ("
						+getValue(rs.getString("RENT_CUST_ID"))+","
						+getValue(rs.getString("COMP_ID"))+","
						+getValue(rs.getString("DEPT_ID"))+","
						+getValue(rs.getString("USER_ID"))+","
						+getValue(tranValue(rs.getString("RENT_CUST_NAME")))+","
						+getValue((ecodePhoneForBase64(decodePhone(rs.getString("CELL_PHONE")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("ID_CARD")))))+","
						+getValue(Base64.encodeToString((EnCodeHelper.decode(rs.getString("CUST_MEMO")))))+","
						+getValue(rs.getString("BUILD_NAME"))+","
						+getValue(rs.getString("HOUSE_PRICE_LOW"))+","
						+getValue(rs.getString("HOUSE_PRICE_HIGH"))+","
						+getValue(rs.getString("RENT_CUST_SEX"))+","
						+getValue(rs.getString("CUST_ADDR"))+","
						+getValue(tranValue(rs.getString("CUST_REQUEST")))+","
						+getValue(rs.getString("REPEAT_FLAG"))+","
						+getValue(rs.getString("CREATION_TIME"))
						+ "); ").append("\n");
			}
			rs.close();
			statement.close();
		}finally{
			bufferedWriter.close();
		}
	}
	public static void generatePhoneSql(Connection connection,int compId,File outputFile) throws SQLException, IOException{
		if(!outputFile.exists()){
			outputFile.createNewFile();
		}
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile))); 
		try{
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(500);
			ResultSet rs = statement.executeQuery("SELECT PHONE_ID,CITY_ID,COMP_ID,DEPT_ID,CASE_ID,CASE_TYPE,PHONE,CREATION_TIME FROM FUN_PHONE WHERE COMP_ID="+compId);
			while (rs.next()) {
				bufferedWriter.append("INSERT INTO fun_phone (PHONE_ID,CITY_ID,COMP_ID,DEPT_ID,CASE_ID,CASE_TYPE,PHONE,CREATION_TIME) VALUES ("
						+getValue(rs.getString("PHONE_ID"))+","
						+getValue(rs.getString("CITY_ID"))+","
						+getValue(rs.getString("COMP_ID"))+","
						+getValue(rs.getString("DEPT_ID"))+","
						+getValue(rs.getString("CASE_ID"))+","
						+getValue(rs.getString("CASE_TYPE"))+","
						+getValue(ecodePhoneForBase64(EnCodeHelper.decode(rs.getString("PHONE"))))+","
						+getValue(rs.getString("CREATION_TIME"))
						+ "); ").append("\n");
			}
			rs.close();
			statement.close();
		}finally{
			bufferedWriter.close();
		}
	}

	/**
     *身份证号加密，只显示前4位后面全部用*
     *
	 */
	public static String decodeIDCARDDetail(String idCard){
		if(StringUtils.isNotBlank(idCard)){
			if(idCard.trim().length()>=4){
				idCard = idCard.substring(0,4)+"**************";
				return idCard;
			}
		}
		return "";
	}
}
