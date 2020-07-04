package com.myfun.framework.session;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

import com.myfun.repository.support.constant.Const;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;

public class Operator implements Serializable {
	
	private static final long serialVersionUID = -379887088764561282L;
	private static final String String = null;
	private Hashtable<String, Object> operatorHT = new Hashtable<String, Object>();
	private Map<String, String > PARAM_MAP=new HashMap<String, String>();
	private Map<String, String[] > REQUEST_PARAM_MAP=new HashMap<String,  String[]>();
	private Map<String, Object > RESPONSE_PARAM_MAP=new HashMap<String,  Object>();

	public Operator() {}
	
	public Operator(String operator) {
		setAttribute("OPERATOR", operator);
	}

	public Object getAttribute(String name) {
		return operatorHT.get(name);
	}

	public void setAttribute(String name, Object value) {
		if(value!=null){
			operatorHT.put(name, value);
		}
	}

	public void removeAttribute(String name) {
		operatorHT.remove(name);
	}
	
	public Hashtable<String, Object> getAllAtrtibute(){
		return operatorHT;
	}

	public void setAllAttribute(Hashtable<String, Object> ht){
		if(ht != null && !ht.isEmpty()){
			operatorHT = ht;
		}
	}
	
	public Hashtable<String, Object> getOperatorHT() {
		return operatorHT;
	}
	/**
	 * 设置门店是否是优优好房门店
	 */
	public void setYouDianStatus(Integer flag) {
		setAttribute("YOU_DIAN_STATUS", flag);
	}
	
	/**员工调店时才使用这个参数*/
	public String getChangToUserID() {
		return (String) getAttribute("CHANG_TO_USER_ID");
	}
	/**员工调店时才使用这个参数*/
	public void setChangToUserID(String changToUserID) {
		setAttribute("CHANG_TO_USER_ID", changToUserID);
	}
	
	public Integer getCityId() {
		if (this.isHasSwitchFlag()) {
			if (isMobileApi()) {
				return this.getSelfCityId();
			}
		}
		return Integer.valueOf(getAttribute("CITY_ID") + "");
	}

	public void setCityId(Integer cityId) {
		setAttribute("CITY_ID", cityId + "");
	}
	public String getBUILD_RULE_FLAG() {
		return (String)getAttribute("BUILD_RULE_FLAG");
	}
	
	
	public void setAgreeTruehouseRule(String agreeTruehouseRule){
		setAttribute("AGREE_TRUEHOUSE_RULE", agreeTruehouseRule);
	}
	public String getAgreeTruehouseRule(){
		return (String) getAttribute("AGREE_TRUEHOUSE_RULE");
	}
	/**
	 * 优家房源拨打IP电话是否免费，1=免费，也是直营城市控制的标志
	 */
	public void setYoujiaIpcallFree(Byte youjiaIpcallFree){
		setAttribute("YOUJIA_IPCALL_FREE", youjiaIpcallFree);
	}
	public String getYoujiaIpcallFree(){
		return (String) getAttribute("YOUJIA_IPCALL_FREE");
	}
	public void setUaId(String uaid){
		setAttribute("UA_ID", uaid);
	}
	public Integer getUaId(){
		return StringUtil.parseInteger((String) getAttribute("UA_ID"));
	}
	public String getClientKey() {
		String clientKey= (String) getAttribute("CLIENTKEY");
		if(clientKey==null){
			clientKey=getParamMap().get("CLIENTKEY");
		}
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		setAttribute("CLIENTKEY", clientKey);
	}
	
	public Integer getUserId() {
		try {
			return Integer.valueOf(getAttribute("USER_ID") + "");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}

	public void setUserId(Integer userId) {
		setAttribute("USER_ID", userId);
	}
	
	public String getScopeId() {
		return (String) getAttribute("SCOPE_ID");
	}

	public void setScopeId(String scopeId) {
		setAttribute("SCOPE_ID", scopeId);
	}
	
	public Integer getCompId() {
		if (this.isHasSwitchFlag()) {
			if (isMobileApi()) {
				return this.getSelfCompId();
			}
		}
		return Integer.valueOf(getAttribute("COMP_ID") + "");
	}
	
	public Object[] getCompIds() {
		return ((String) getAttribute("COMP_IDS")).split(",");
	}

	public void setCompId(Integer compId) {

		setAttribute("COMP_ID", null != compId ? compId + "" : null);
	}
	
	public Integer getCompUaId(){// 纯精英版没有公司UAID
		return StringUtil.parseInteger(getAttribute("COMP_UA_ID"));
	}
	
	public String getCompNo() {
		Object compNo=getAttribute("COMP_NO") ;
		return  compNo==null?"":(String)compNo;
	}

	public void setCompNo(String compNo) {
		setAttribute("COMP_NO", compNo);
	}
	
	public Integer getCompType() {
		return StringUtil.parseInteger(getAttribute("COMP_TYPE"), 1);
	}

	public void setCompType(String compType) {
		setAttribute("COMP_TYPE", compType);
	}
	
	public String getCompName() {
		return (String) getAttribute("COMP_NAME");
	}
	
	public void setCompName(String compName) {
		setAttribute("COMP_NAME", compName);
	}

	public void setPlotSwitch(Boolean plotSwitch) {
		setAttribute("PLOT_SWITCH", plotSwitch);
	}
	
	public Integer getProvinceId() {
		return Integer.valueOf(getAttribute("PROVINCE_ID")+"");
	}

	public void setProvinceId(Short ProvinceId) {
		setAttribute("PROVINCE_ID", ProvinceId);
	}
	
	public String getUserName(){
		return (String) getAttribute("USER_NAME");
	}
	public void setUserName(String userName){
		setAttribute("USER_NAME", userName);
	}
	
	public String getUserSex(){
		return  Optional.ofNullable(getAttribute("USER_SEX")).map(Object::toString).orElse(null);
	}
	public void setUserSex(Byte userSex){
		setAttribute("USER_SEX", userSex);
	}
	
	public String getUserNo(){
		return (String) getAttribute("USER_NO");
	}
	public void setUserNo(String userName){
		setAttribute("USER_NO", userName);
	}
	public Integer getDeptId(){
		return Integer.valueOf(getAttribute("DEPT_ID") + "");
	}
	public void setDeptId(Integer deptId){
		setAttribute("DEPT_ID", null != deptId ? deptId + "" : null);
	}
	public String getDeptName(){
		return (String) getAttribute("DEPT_NAME");
	}
	public void setDeptName(String deptName){
		setAttribute("DEPT_NAME", deptName);
	}
	public void setArchiveId(String archiveId){
		setAttribute("ARCHIVE_ID", archiveId);
	}
	public Integer getArchiveId(){
		return StringUtil.parseInteger((String) getAttribute("ARCHIVE_ID"));
	}
	public String getDeptNo(){
		return (String) getAttribute("DEPT_NO");
	}
	public void setDeptNo(String deptNo){
		setAttribute("DEPT_NO", deptNo);
	}
	public String getHousePicDoc(){
		return (String) getAttribute("HOUSE_PIC_DOC");
	}
	public void setHousePicDoc(String picDoc){
		setAttribute("HOUSE_PIC_DOC", picDoc);
	}
	public void setBulletPicDoc(String docPath){
		setAttribute("BULLET_PIC_DOC", docPath);
	}
	public String getBulletPicDoc(){
		return (String) getAttribute("BULLET_PIC_DOC");
	}
	public void setUserPhotoDoc(String docPath){
		setAttribute("USER_PHOTO_DOC", docPath);
	}
	public String getUserPhotoDoc(){
		return (String) getAttribute("USER_PHOTO_DOC");
	}
	public void setBaseDoc(String docPath){
		setAttribute("USER_BASE_DOC", docPath);
	}
	public String getBaseDoc(){
		return (String) getAttribute("USER_BASE_DOC");
	}
	public void setUserRight(String userRight){
		setAttribute("USER_RIGHT", userRight);
	}
	
	public String getUserRight(){
		return (String) getAttribute("USER_RIGHT");
	}
	public String getUserHonest(){
		return (String) getAttribute("USER_HONEST");
	}
	public void setUserHonest(String userHonest){
		setAttribute("USER_HONEST", userHonest);
	}
	public String getProvinceName() {
		return (String) getAttribute("PROVINCE_NAME");
	}
    
	public Integer getAreaId(){
		return StringUtil.parseInteger(getAttribute("AREA_ID"));
	}
	public void setAreaId(Integer areaId){

		setAttribute("AREA_ID", null != areaId ? areaId+"" : null);
	}
	public Integer getRegId(){
		return StringUtil.parseInteger(getAttribute("REG_ID"), 0);
	}
	public void setRegId(Integer regId){
		setAttribute("REG_ID", null != regId ? regId+"" : null);
	}

	public void setAreaFlag(String areaFlag ){
		setAttribute("AREA_FLAG", areaFlag);
	}
	
	public String getAreaFlag(){
		return (String) getAttribute("AREA_FLAG");
	}
	
	public void setProvinceName(String PROVINCE_NAME) {
		setAttribute("PROVINCE_NAME", PROVINCE_NAME);
	}
	
	public void setUserPosition(String USER_POSITION){
		setAttribute("USER_POSITION", USER_POSITION);
	}
	public  String getUserPosition(){
		return (String) getAttribute("USER_POSITION");
	}
	public void setCompAttr(String sqlString){
		setAttribute("COMP_ATTR",sqlString);
	} 
	public String getCompAttr(){
	    return (String) getAttribute("COMP_ATTR");
	}
	public void setCompModel(String sqlString){
		setAttribute("COMP_MODEL",sqlString);
	} 
	public String getCompModel(){
	    return (String) getAttribute("COMP_MODEL");
	}
	public void setShareId(Integer sqlString){
		setAttribute("SHARE_ID",sqlString);
	} 
	public String getShareId(){
	    return (String) getAttribute("SHARE_ID");
	}
	public void setSname(String sqlString){
		setAttribute("SNAME",sqlString);
	} 
	public String getSname(){
	    return (String) getAttribute("SNAME");
	}

	public Integer getAdminDeptId() {
		return StringUtil.parseInteger( getAttribute("ADMIN_DEPT_ID"));
	}

	public Integer getAdminCompId() {
		return StringUtil.parseInteger( getAttribute("ADMIN_COMP_ID"));
	}

	public void setAdminDeptId(String adminDeptId){
		 setAttribute("ADMIN_DEPT_ID",adminDeptId);
	}
   public void setAdminCompId(String adminCompId){
   	     setAttribute("ADMIN_COMP_ID",adminCompId);
	}
   public void setUserMobile(String USER_MOBILE){
 	     setAttribute("USER_MOBILE",USER_MOBILE);
	}
   public String getUserMobile(){
		return  (String) getAttribute("USER_MOBILE");
	}
   public String getYouCompFlag(){
	   Object youjiaCompFlag = getAttribute("YOUJIA_COMP_FLAG");
	   return StringUtil.parseInteger(youjiaCompFlag, 0).toString();
   }
	/**
	 * 验证是否是总经理
	 * @return
	 * @author 胡飞龙
	 */
	public  boolean isGeneralManager(){
		return getUserPosition().equals("GENERAL_MANAGER");
	}
	
	/**
	 * 获得城市是否支持QQ推广
	 * @return
	 */
	public Integer getQQPublish(){
		Object qqPublish = getAttribute("QQ_PUBLISH");
		return StringUtil.parseInteger(qqPublish, 0);
	}

	public void setGrId(String grId){
		setAttribute("GR_ID",grId);
	}
	
	public Integer getGrId(){
		return StringUtil.parseInteger( getAttribute("GR_ID"), 0);
	}


	public void setPartnerId(Integer partnerId) {
		setAttribute("PARTNER_ID", partnerId);
	}

	public void setOpenPartner(Byte openPartner) {
		setAttribute("OPEN_PARTNER", openPartner);
	}

	public void setParamMap(Map<String,String> paramMap){
		PARAM_MAP=paramMap;
	}
	public Map<String,String> getParamMap(){
		return PARAM_MAP;
	}
	public String getString(String key) {
		String resultValue = null;
		if(REQUEST_PARAM_MAP != null){
			String[] values = REQUEST_PARAM_MAP.get(key);
			if(values != null && values.length>0){
				resultValue = values[0];
			}
		}
		if(resultValue==null){
			if(PARAM_MAP != null){
				resultValue= PARAM_MAP.get(key);
			}
		}
		return resultValue;
	}
	public void setRequestParamMap(Map<String, String[]> paramMap){
		REQUEST_PARAM_MAP.putAll(paramMap);
	}
	public Map<String, String[]>  getRequestParamMap(){
		return REQUEST_PARAM_MAP;
	}
	public void setResponseParamMap(Map<String, Object> responseParamMap){
		RESPONSE_PARAM_MAP=responseParamMap;
	}
	public Map<String, Object>  getResponseParamMap(){
		return RESPONSE_PARAM_MAP;
	}

	public void setHongJICompModel(String paraValueById) {
		setAttribute("HONGJI_COMP_MODEL",paraValueById);
	}
	
	public void setPayMentOrderNO(String orderNo){
		setAttribute("PAYMENT_ORDERNO",orderNo);
	}
	
	public String getPayMentOrderNO(){
		return (String) getAttribute("PAYMENT_ORDERNO");
	}
	
	/**
	 * 返回值：0：鸿基，1：非鸿基
	 * @author 陈文超
	 * @date May 25, 2015 1:49:41 PM
	 */
	public Integer getHongJICompModel() {
		return StringUtil.parseInteger( getAttribute("HONGJI_COMP_MODEL"), 0);
	}



	/**
	 * 是否是纯精英版用户
	 * true 纯精英版
	 * false 门店精英版
	 * @return
	 */
	public boolean isPersonalVersion(){
		return "0".equals(getAttribute("DEPT_PERSONAL"));
	}
	
	/**
	 * 当前用户是否是LINK版用户（compType == 1 || compType == 2）
	 * 注意与以前的COMP_TYPE = 3的赢销版区别开
	 */
	public boolean isLinkEdition() {
		if(getAttribute("COMP_TYPE") != null){
			String compType = getAttribute("COMP_TYPE").toString();
			return Const.DIC_COMP_TYPE_1.toString().equals(compType) || Const.DIC_COMP_TYPE_2.toString().equals(compType);
		}else{
			return false;
		}
	}
	
	/**
	 * 当前用户是否是物业版用户
	 * @author 方李骥
	 * @date 2018年6月1日 下午1:46:07
	 */
	public boolean isPropertyEdition() {
		/***link版下物业版也返回true**/
		if ("1".equals(StringUtil.toString(getAttribute("SUPPORT_PROPERTY_FLAG")))) {
			return true;
		}
		if (getAttribute("COMP_TYPE") != null) {
			return Const.DIC_COMP_TYPE_5.toString().equals(getAttribute("COMP_TYPE").toString());
		} else {
			return false;
		}
	}
	
	/**
	 * 是否是单店版
	 * @return
	 */
	public boolean isSingleDeptEdition() {
		if(getAttribute("COMP_TYPE") != null){
			return Const.DIC_COMP_TYPE_6.toString().equals(getAttribute("COMP_TYPE").toString());
		}else{
			return false;
		}
	}
	
	/**
	 * 用户使用的是精英版客户端登录
	 * @author 陈文超
	 * @date Jul 6, 2015 3:24:56 PM
	 */
	public boolean isPerLogin(){
		return "1".equals(getAttribute("IS_PER_LOGIN"));
	}
	
	/**
	 * 用户使用的是精英版客户端登录
	 * @author 陈文超
	 * @date Jul 6, 2015 3:24:56 PM
	 */
	public void setIsPerLogin(String isPerLogin){
		setAttribute("IS_PER_LOGIN", isPerLogin);
	}
	
	/**是否是手机端请求接口*/
	public boolean isMobileApi(){
		return "1".equals(getAttribute("IS_MOBILE_API"));
	}
	
	/**是否是手机端请求接口*/
	public void setIsMobileApi(String isMobileApi){
		setAttribute("IS_MOBILE_API", isMobileApi);
	}
	
	/**
	 * 获取OTO标记 1:有，0:无
	 * @author 陈文超
	 * @date Aug 4, 2015 2:55:44 PM
	 */
	public Integer getOTO_Flag(){
		Integer o2OFlag = StringUtil.parseInteger(getAttribute("O2O_FLAG"), 0);
		return o2OFlag;
	}
	
	/**
	 * 获取用户是否是VIP
	 * @author 陈文超
	 * @date Aug 4, 2015 3:12:05 PM
	 */
	public String getSUPER_USER(){
		Integer superUser = StringUtil.parseInteger(getAttribute("SUPER_USER"), 0);
		return superUser + "";
	}
	/**
	 * 判断是否是科威模式（加盟圈）
	 * @return
	 */
	public boolean isKEWEI_COMP_MODEL(){
		if(getCompModel()==null){
			return false;
		}
		return getCompModel().equals(Constants_DIC.DIC_IS_KEWEI_COMP_MODEL);
	}
	
	public void setBIZ_DIAL_TYPE(String bizDialType){
		setAttribute("BIZ_DIAL_TYPE",bizDialType);
	}
	public String getBIZ_DIAL_TYPE(){
		return (String) getAttribute("BIZ_DIAL_TYPE");
	}
	
	public void setSOSO_DIAL_TYPE(String sosoDialType){
		setAttribute("SOSO_DIAL_TYPE",sosoDialType);
	}
	public String getSOSO_DIAL_TYPE(){
		return (String) getAttribute("SOSO_DIAL_TYPE");
	}
	public boolean isCustom(){
		return "1".equals(getAttribute("CUSTOM_FLAG"));
	}
	public String getCustom_URL(){
		return (String) getAttribute("CUSTOM_URL");
	}
	public void setTopJoinCircleCompId(String compId){
		setAttribute("TOP_JOIN_CIRCLE_COMPID",compId);
	}
	
	public String getTopJoinCircleCompId(){
		return (String) getAttribute("TOP_JOIN_CIRCLE_COMPID");
	}
	
	/**
	 * 设置是否使用优家电话
	 */
	public void setUseYouJiaPhone(String phone){
		setAttribute("USE_YOUJIA_PHONE",phone);
	}
	
	/**
	 * 获取是否使用优家电话
	 */
	public String getUseYouJiaPhone(){
		return (String) getAttribute("USE_YOUJIA_PHONE");
	}
	
	/**
	 * 设置优家电话
	 */
	public void setYouJiaPhone(String phone){
		setAttribute("YOUJIA_PHONE",phone);
	}
	
	/**
	 * 获取优家电话
	 */
	public String getYouJiaPhone(){
		return (String) getAttribute("YOUJIA_PHONE");
	}
	
	/**
	 * 门店是否是优家
	 */
	public void setYouJiaDeptFlag(String flag){
		setAttribute("YOUJIA_DEPT_FLAG",flag);
	}
	
	/**
	 * 门店是否是优家
	 * @return true:已开通
	 */
	public boolean youJiaDeptFlag(){
		return "1".equals(getAttribute("YOUJIA_DEPT_FLAG"));
	}
	
	/**
	 * 门店是否已被停权
	 */
	public void setYouJiaDeptBanFlag(String flag){
		setAttribute("YOUJIA_DEPT_BAN_FLAG",flag);
	}
	
	/**
	 * 门店是否已被停权
	 * @return true:已被停权
	 */
	public boolean youJiaDeptBanFlag(){
		return "1".equals(getAttribute("YOUJIA_DEPT_BAN_FLAG"));
	}
	
	/**
	 * 用户是否已签署优家协议
	 */
	public void setYouJiaUserProtocolFlag(String flag){
		setAttribute("YOUJIA_USER_PROTOCOL_FLAG",flag);
	}
	
	/**
	 * 用户是否已签署优家协议
	 * @return true:已签
	 */
	public boolean youJiaUserProtocolFlag(){
		return "1".equals(getAttribute("YOUJIA_USER_PROTOCOL_FLAG"));
	}
	
	/**
	 * 用户是否已被停权
	 */
	public void setYouJiaUserBanFlag(String flag){
		setAttribute("YOUJIA_USER_BAN_FLAG",flag);
	}
	
	/**
	 * 用户是否已被停权
	 * @return true:已停权
	 */
	public boolean youJiaUserBanFlag(){
		return "1".equals(getAttribute("YOUJIA_USER_BAN_FLAG"));
	}
	
	/**
	 * 用户是有权否能使用优家<br/>
	 * @return 1:有权限<br/>-1:门店未开通<br/>-2:门店已停权<br/>-3:用户未签协议<br/>-4:用户已停权
	 */
	public int isYouJiaUserResult(){
		if(!youJiaDeptFlag()){return -1;}
		if(youJiaDeptBanFlag()){return -2;}
		if(!youJiaUserProtocolFlag()){return -3;}
		if(youJiaUserBanFlag()){return -4;}
		return 1;
	}
	
	/**
	 * 用户是有权否能使用优家<br/>
	 * 门店已开通+门店未停权+用户已签署协议+用户未被停权
	 * @return true:可以使用优家功能
	 */
	public boolean isYouJiaUser(){
		return 1 == isYouJiaUserResult();
	}
	
	/**
	 * 城市优家名字
	 */
	public void setYouCityName(String youCityName){
		setAttribute("CITY_SHARE_NAME", youCityName);
	}
	
	/**
	 * 城市优家名字
	 */
	public String getYouCityName(){
		return (String) getAttribute("CITY_SHARE_NAME");
	}
	
	/**
	 * 城市是否开通YOU+
	 * true:开通
	 * false:未开通
	 */
	public boolean getCityOpenYoujia(){
		return "1".equals(getAttribute("YOUJIA_CITY_FLAG"));
	}
	
	/**
	 * 城市是否开通YOU+楼盘资料
	 * 
	 */
	public boolean getCityOpenYoujiaBuild(){
		return "1".equals(getAttribute("YOUJIA_BUILDINFO_FLAG"));
	}
	
	/**
	 * 是否是加盟总店
	 * @return
	 */
	public boolean isTopJoinComp(){
		return "1".equals(getCompAttr()) && "2".equals(getCompModel());
	}
	
	/**
	 * 是否是加盟模式
	 * @return
	 */
	public boolean isJoinCompModel(){
		return "2".equals(getCompModel());
	}
	
	/**设置自动发布房源到you+*/
	public void setAutoPublishYoujia(String autoPublishYoujia){
		setAttribute("AUTO_PUBLISH_YOUJIA",autoPublishYoujia);
	}
	
	/**获取自动发布房源到you+*/
	public String getAutoPublishYoujia(){
		return (String) getAttribute("AUTO_PUBLISH_YOUJIA");
	}
	
	/**设置子版本*/
	public void setSubVersion(String subVersion){
		setAttribute("SUB_VERSION",subVersion);
	}
	
	/**获取子版本*/
	public String getSubVersion(){
		return (String) getAttribute("SUB_VERSION");
	}
	
	/**是否是物业版*/
	public boolean isWuYeVersion(){
		return Constants_DIC.DIC_COMP_TYPE_2.equals(getCompType())
				&& Constants_DIC.DIC_COMP_TYPE_2_SUB_VERSION_1.equals(getSubVersion());
	}
	
	public String getErpCompId() {
		Object obj = getAttribute("ERP_COMP_ID");
		String compId = null;
		if (obj!=null) {
			compId = obj.toString();
		}
		if(StringUtil.isBlank(compId)) {
			compId = getAttribute("COMP_ID").toString();
		}
		return compId;
	}
	
	/**设置是否是体验账号*/
	public void setExperienceAccount(Integer experience){
		setAttribute("EXPERIENCE_ACCOUNT",experience);
	}
	
	/**是否是体验账号*/
	public boolean getExperienceAccount(){
		Integer experienceAccount = StringUtil.parseInteger(getAttribute("EXPERIENCE_ACCOUNT"), 0);
		return 1 == experienceAccount;
	}
	
	/**是否是手机端请求接口*/
	public boolean isFddApi(){
		return "1".equals(getAttribute("IS_FDD_API"));
	}
	
	public void setDeptAddr(String deptAddr){
		setAttribute("DEPT_ADDR", deptAddr);
		
	}
	public String getDeptAddr() {
		return (String)getAttribute("DEPT_ADDR");
	}
	
	public String getDeptCName(){
		String deptCName=(String) getAttribute("DEPT_CNAME");
		return deptCName;
		
	}
	public void setDeptCName(String name){
		setAttribute("DEPT_CNAME", name);
		
	}
	/**
	 * 当前用户是否是新的赢销版用户
	 * 注意与以前的COMP_TYPE = 3的赢销版区别开
	 * @author 陈文超
	 * @date 2018年6月1日 下午1:46:07
	 */
	public boolean isMarketEdition() {
		if(getAttribute("COMP_TYPE") != null){
			return Const.DIC_COMP_TYPE_4.toString().equals(getAttribute("COMP_TYPE").toString());
		}else{
			return false;
		}
	}
	
	/**
	 * 老赢销版
	 */
	public boolean isOldMarketEdition() {
		if (getAttribute("COMP_TYPE") != null) {
			return Const.DIC_COMP_TYPE_3.toString().equals(getAttribute("COMP_TYPE").toString());
		} else {
			return false;
		}
	}

	public  String getGrName() {
		return (String)getAttribute("GR_NAME");
	}
	
	/**
	 * 是否是新房版
	 * @return
	 */
	public boolean isNewHouseEdition() {
		if(getAttribute("COMP_TYPE") != null){
			return Const.DIC_COMP_TYPE_7.toString().equals(StringUtil.toString(getAttribute("COMP_TYPE")));
		}else{
			return false;
		}
	}
	
	/**
	 * 是否是定制版
	 * @return
	 */
	public boolean isSpecialSustomized() {
		if(getAttribute("IS_SPECIAL_CUSTOMIZED") != null){
			return Const.DIC_IS_SPECIAL_CUSTOMIZED_1.toString().equals(StringUtil.toString(getAttribute("IS_SPECIAL_CUSTOMIZED")));
		}else{
			return false;
		}
	}
	
	/**
	 * 定制公司的组织id
	 * @return
	 */
	public Integer getLeaguesType() {
		return StringUtil.parseInteger(getAttribute("LEAGUES_TYPE"));
	}

	/**
	 * 是否是房基地
	 * @return
	 */
	public boolean isFangJidi() {
		return 4 == getLeaguesType();
	}

	/**
	 * 获取加盟商ID
	 */
	public Integer getPartnerId() {
		return StringUtil.parseInteger(getAttribute("PARTNER_ID"), -1);
	}
	
	/**
	 * 是否开启加盟模式 0=没有开启 1=开启
	 */
	public Integer openPartner() {
		return StringUtil.parseInteger(getAttribute("OPEN_PARTNER"), 0);
	}
	
	/**
	 * @author lcb
	 * @tag  判断是否是啥会员
	 * @since 2019/11/7
	 */
	public void setPlusVip(Integer plusVip, Date nowDate, Date endDate, Byte isFreeUser){
		// 避免坑
		isFreeUser = null == isFreeUser ? 0 : isFreeUser;
		setAttribute("PLUS_VIP",((1 == plusVip && endDate.getTime() > nowDate.getTime()) || 1 == isFreeUser) ? "1":"0");
	}

	public void setSupportPropertyFlag(Byte supportPropertyFlag) {
		setAttribute("SUPPORT_PROPERTY_FLAG", supportPropertyFlag);
	}

	/**是否是美联**/
	public boolean isMeiLianApi() {
		return "2".equals(StringUtil.toString(getAttribute("CUSTOMIZED_TYPE")));
	}

	/**
	 * @Desc 查询组织架构版本是否是新版本
	 * @Time 2019/11/23
	 * @Author lcb
	 **/
	public boolean newOrganizationType() {
		Object organizationType = getAttribute("ORGANIZATION_TYPE");
		if(null != organizationType) {
			return 1 == (Integer) organizationType;
		}
		return false;
	}

	/**
	 * 新版组织机构当前登录人组织Id
	 * @return
	 */
	public Integer getOrganizationId() {
		return StringUtil.parseInteger(getAttribute("ORGANIZATION_ID"),0);
	}

	/**
	 * 新版组织机构当前登录人组织的路径
	 * @return
	 */
	public String getOrganizationPath() {
		return (String) getAttribute("ORGANIZATION_PATH");
	}

	/**
	 * @Desc 查询登录人组织名称
	 * @Time 2019/11/23
	 * @Author lcb
	 **/
	public String getOrganizationName() {
		Object organizationName = getAttribute("ORGANIZATION_NAME");
		return organizationName + "";
	}

	public Integer getBusinessType() {
		Object businessType = getAttribute("BUSINESS_TYPE");
		return StringUtil.parseInteger(businessType, 0);
	}

	public boolean isSwitchCompLogin() {
		Object isSwitchComp = this.getAttribute("IS_SWITCH_COMP");
		if (null != isSwitchComp) {
			return 1 == (Integer)isSwitchComp && !isMobileApi();
		} else {
			return false;
		}
	}
	public boolean isHasSwitchFlag() {
		Object isSwitchComp = this.getAttribute("IS_SWITCH_COMP");
		if (null != isSwitchComp) {
			return 1 == (Integer)isSwitchComp;
		} else {
			return false;
		}
	}
	public Integer getSelfCityId() {
		return StringUtil.parseInteger(getAttribute("SELF_CITY_ID"), 0);
	}
	public Integer getSelfCompId() {
		return StringUtil.parseInteger(getAttribute("SELF_COMP_ID"), 0);
	}
}