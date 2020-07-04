package com.myfun.repository.erpdb.dto;

import java.io.Serializable;


public class AttendanceRecordResultDto implements Serializable {

	private String attId;//"打卡更新id (打卡时不需要上传 ，更新打卡时（actionType =1），必须上传)",
	private String attConfigTime;//"配置打卡时间",
	private String attLimitTime;//"配置限制打卡时间点",
	private String attLocalTime;// "实际打卡时间",
	private String attAttribute;//"（1）上班或（2）下班",
	private String attNum;//"第几班打卡（1/2/3）",
	private String attTimeResult;//"打卡时间结果 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、
	// 9病假 、10事假、11未就绪（服务器端根据时间动态计算结果）(默认0) - 实际与前端交互的参数",
	private String attLocationResult;//"打卡地点结果(默认0)正常1外勤"
	private String locationDesc;//"打卡地点描述"
	private String attRemark;//"打卡地点描述"
	private String extraPath;//"附件存储地址"
	private String attFlag = "0";// 是否已经打卡 1是 0否

	public String getAttId() {
		return attId;
	}

	public void setAttId(String attId) {
		this.attId = attId;
	}

	public void setAttConfigTime(String attConfigTime) {
		this.attConfigTime = attConfigTime;
	}

	public String getAttConfigTime() {
		return attConfigTime;
	}

	public void setAttLocalTime(String attLocalTime) {
		this.attLocalTime = attLocalTime;
	}

	public String getAttLocalTime() {
		return attLocalTime;
	}

	public void setAttAttribute(String attAttribute) {
		this.attAttribute = attAttribute;
	}

	public String getAttAttribute() {
		return attAttribute;
	}

	public void setAttNum(String attNum) {
		this.attNum = attNum;
	}

	public String getAttNum() {
		return attNum;
	}

	public void setAttTimeResult(String attTimeResult) {
		this.attTimeResult = attTimeResult;
	}

	public String getAttTimeResult() {
		return attTimeResult;
	}

	public void setAttLocationResult(String attLocationResult) {
		this.attLocationResult = attLocationResult;
	}

	public String getAttLocationResult() {
		return attLocationResult;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getAttRemark() {
		return attRemark;
	}

	public void setAttRemark(String attRemark) {
		this.attRemark = attRemark;
	}

	public String getExtraPath() {
		return extraPath;
	}

	public void setExtraPath(String extraPath) {
		this.extraPath = extraPath;
	}

	public String getAttLimitTime() {
		return attLimitTime;
	}

	public void setAttLimitTime(String attLimitTime) {
		this.attLimitTime = attLimitTime;
	}

	public String getAttFlag() {
		return attFlag;
	}

	public void setAttFlag(String attFlag) {
		this.attFlag = attFlag;
	}
}
