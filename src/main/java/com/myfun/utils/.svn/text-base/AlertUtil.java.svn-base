package com.myfun.utils;

import java.util.HashMap;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.support.constant.Const;

/***
 * 前端弹框样式
 * @author 尹振兴
 * @since 2018年3月16日
 */
public class AlertUtil {
	
	/***
	 * 公用错误弹窗
	 * @author 尹振兴
	 * @since 2018年3月19日
	 * @param alertTitle
	 * @param alertDesc
	 * @return
	 */
	public static HashMap<String, Object> exceptionAlert(String alertTitle, String alertDesc){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertDesc", alertDesc);
		return hashMap;
	}
	
	
	/**
	 * 小区专家弹框
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @param alertDesc
	 * @param alertDesc
	 * @return
	 */
	public static HashMap<String, Object> createBuildBiddingAlert(){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", "百万曝光量平台虚位以待");
		hashMap.put("alertImg", AppConfig.getHouseWebUrl() + "statics/images/alert/bidding.png");
		hashMap.put("alertDesc", "只需两步即可成为小区专家，坐拥海量客户来电");
		return hashMap;
	}
	
	/***
	 * 新盘顾问弹窗
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @return
	 */
	public static HashMap<String, Object> createNewSiteBuildBiddingAlert(){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", "百万曝光量平台虚位以待");
		hashMap.put("alertImg", AppConfig.getHouseWebUrl() + "statics/images/alert/bidding.png");
		hashMap.put("alertDesc", "只需两步即可成为新盘顾问，坐拥海量客户来电");
		return hashMap;
	}
	
	/***
	 * 房源推广弹窗
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @return
	 */
	public static HashMap<String, Object> createHouseBiddingAlert(){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", "百万曝光量平台虚位以待");
		hashMap.put("alertImg", AppConfig.getHouseWebUrl() + "statics/images/alert/bidding.png");
		hashMap.put("alertDesc", "只需两步即可参与房源置顶，海量客户主动上门");
		return hashMap;
	}
	
	/***
	 * 抢单弹窗
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @return
	 */
	public static HashMap<String, Object> robEntrustInfoAlert(){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", "海量房客源等您来抢");
		hashMap.put("alertImg", AppConfig.getHouseWebUrl() + "statics/images/alert/youyou.png");
		hashMap.put("alertDesc", "实名认证通过即可开始抢单，动动手指客户就有");
		return hashMap;
	}
	
	/***
	 * 真房源保证金
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @return
	 */
	public static HashMap<String, Object> updateTrueFlagAlert(String alertDesc){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", "缴纳保证金");
		hashMap.put("alertImg", "");
		hashMap.put("alertDesc", alertDesc);
		return hashMap;
	}
	
	
	
	/***
	 * 充值vip共用弹窗
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @param alertDesc
	 * @return
	 */
	public static HashMap<String, Object> rechargeVipAlert(String alertTitle, String alertDesc){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertImg", AppConfig.getHouseWebUrl() + "statics/images/alert/vip.png");
		hashMap.put("alertDesc", alertDesc);
		return hashMap;
	}
	
	/***
	 * 实名认证共用弹窗
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @param alertDesc
	 * @return
	 */
	public static HashMap<String, Object> realNameAuthenticationAlert(String alertTitle, String alertDesc){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertImg", AppConfig.getHouseWebUrl() + "statics/images/alert/realname.png");
		hashMap.put("alertDesc", alertDesc);
		return hashMap;
	}
	
	/***
	 * 实名认证共用弹窗
	 * @author 尹振兴
	 * @since 2018年3月16日
	 * @param alertDesc
	 * @return
	 */
	public static HashMap<String, Object> realNameAuthenticationAlert(String alertDesc){
		return realNameAuthenticationAlert("实名认证", alertDesc);
	}
	
	/***
	 * 充值好房豆通用弹窗
	 * @author 尹振兴
	 * @since 2018年3月17日
	 * @param rechargeDesc
	 * @param rechargeCoin
	 * @return
	 */
	public static HashMap<String, Object> rechargeCoinAlert(String rechargeDesc,Double rechargeCoin,String businessType){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("rechargeDesc", rechargeDesc);
		//这里将浮点数直接取整，不能进行四舍五入,向上取整
		hashMap.put("rechargeCoin", String.valueOf((int)Math.ceil(rechargeCoin)));
		//业务类型
		hashMap.put("businessType", businessType);
		if(StringUtil.isNotEmpty(businessType)){
			//是否再次请求
			hashMap.put("requestAgain", "1");
		}
		return hashMap;
	}
	
	/**
	 * 预存好房豆送vip
	 * @author 尹振兴
	 * @since 2018年6月3日
	 * @param alertTitle
	 * @param alertDesc
	 * @return
	 */
	public static HashMap<String, Object> rechargeCoinGiftVipAlert(String alertTitle, String alertDesc,String rechargeBeanAmount){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertDesc", alertDesc);
		hashMap.put("sureBtnTitle", "预存公司好房豆");
		hashMap.put("cancelBtnTitle", "下次再说");
		hashMap.put("rechargeBeanAmount", rechargeBeanAmount);
		return hashMap;
	}

	public static HashMap<String, Object> rechargeCoinGiftVipAlertWhenSoso(String alertTitle, String alertDesc,String rechargeBeanAmount){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertDesc", alertDesc);
		hashMap.put("sureBtnTitle", "预存公司好房豆");
		hashMap.put("cancelBtnTitle", "下次再说");
		hashMap.put("rechargeBeanAmount", rechargeBeanAmount);
		return hashMap;
	}

	/**
	 * 真房源VIP业务
	 * 预存好房豆送vip
	 * 
	 * 参考：Const.TRUE_HOUSE_HINT_BECOME_VIP的常量描述
	 * @author 尹振兴
	 * @since 2018年6月3日
	 * @param alertTitle
	 * @param alertDesc
	 * @return
	 */
	public static HashMap<String, Object> trueHouseCoinGiftVipAlert(String alertTitle, String alertDesc,String rechargeBeanAmount){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertDesc", alertDesc);
		hashMap.put("sureBtnTitle", "预存公司好房豆");
		hashMap.put("cancelBtnTitle", "继续支付");
		hashMap.put("rechargeBeanAmount", rechargeBeanAmount);
		return hashMap;
	}
	
	/***
	 * 通用弹窗
	 * @author 尹振兴
	 * @since 2018年6月4日
	 * @param alertTitle
	 * @param alertDesc
	 * @param sureBtnTitle
	 * @return
	 */
	public static HashMap<String, Object> commonAlert(String alertTitle, String alertDesc){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertDesc", alertDesc);
		hashMap.put("sureBtnTitle", "我知道了");
		hashMap.put("cancelBtnTitle", "");
		return hashMap;
	}
	
	/***
	 * 左右结构弹框
	 * @author 尹振兴
	 * @since 2018年6月5日
	 * @return
	 */
	public static HashMap<String, Object> leftRightAlert(String alertTitle, String alertDesc,String cancelBtnTitle,String sureBtnTitle){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertDesc", alertDesc);
		hashMap.put("cancelBtnTitle", cancelBtnTitle);
		hashMap.put("sureBtnTitle", sureBtnTitle);
		return hashMap;
	}

	public static HashMap<String, Object> rechargeVipAlert(String alertTitle, String alertDesc, String sureBtn){
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("alertTitle", alertTitle);
		hashMap.put("alertImg", AppConfig.getHouseWebUrl() + "statics/images/alert/vip.png");
		hashMap.put("alertDesc", alertDesc);
		hashMap.put("sureBtnTitle", sureBtn);
		return hashMap;
	}
	
	public static void main(String[] args) {
		Double rechargeCoin = 2.10d;
		System.out.println((int)Math.ceil(rechargeCoin));
	}
}
