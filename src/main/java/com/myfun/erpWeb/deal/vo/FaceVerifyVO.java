package com.myfun.erpWeb.deal.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FaceVerifyVO implements Serializable{
	
	@ApiModelProperty("userId")
	private String webankUserid;

	@ApiModelProperty("随机数")
	private String randomStr;
	
	@ApiModelProperty("签名")
	private String faceAuthSign;
	
	@ApiModelProperty("faceId")
	private String faceId;
	
	@ApiModelProperty("唯一标识")
	private String orderNo;
	
	@ApiModelProperty("appId")
	private String appId;

	public String getWebankUserid() {
		return webankUserid;
	}

	public void setWebankUserid(String webankUserid) {
		this.webankUserid = webankUserid;
	}

	public String getRandomStr() {
		return randomStr;
	}

	public void setRandomStr(String randomStr) {
		this.randomStr = randomStr;
	}

	public String getFaceAuthSign() {
		return faceAuthSign;
	}

	public void setFaceAuthSign(String faceAuthSign) {
		this.faceAuthSign = faceAuthSign;
	}

	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
}
