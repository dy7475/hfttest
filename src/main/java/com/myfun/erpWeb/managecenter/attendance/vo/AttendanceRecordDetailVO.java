package com.myfun.erpWeb.managecenter.attendance.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AttendanceRecordDetailVO {

	
	 /* "attConfigLocation": "配置的打卡地点", 
      "serverAttTime": "实际打卡时间", 
      "locationDesc": "实际打卡地点", 
      "attId": "打卡记录id", 
      "attOughtDate": "考勤日期", 
      "configAttTime": "配置的考勤时间", 
      "manageLocationAttResult": "详细档期ID", 
      "manageTimeAttResult": "时间考勤结果-管理员 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假（服务器端根据时间动态计算结果）(默认0) - 实际与前端交互的参数", 
      "extraPath": "附件地址", 
      "extraType": "附件类型：1、图片，2：文件", 
      "attRemark": "打卡备注", 
      "attClassClocktime": "班别对应的打卡时间", 
      "attClassName": "班次名称", 
      "belateMinute": "迟到分钟数", 
      "attAttribute": "1=上班，2=下班", 
      "attNum": "当前第几轮打卡", 
      "attSumCount": "总的第几轮打卡", 
      "attGrId": "考勤组id", 
      "attClassId": "班次ID", 
      "userId": "考勤员工id"*/
	@ApiModelProperty("主键自增")
	private Integer attId;
	
	@ApiModelProperty("考勤地点中文描述	例：世纪城南路888号")
	private String locationDesc;

	@ApiModelProperty("系统配置应该的考勤时间	例 2017-01-01 09:00")
	private Date configAttTime;
	@ApiModelProperty("考勤时间")
	private Date localAttTime;
	
	@ApiModelProperty("考勤上班或者下班	上班：1 、下班：2    (默认 0)")
	private Byte attAttribute;

	@ApiModelProperty("附件存储地址")
	private String extraPath;
	
	@ApiModelProperty("附件类型：1、图片，2：文件")
	private Byte extraType;

	@ApiModelProperty("是否有附件：1有、默认：0没有")
	private Byte extraExist;
	
	@ApiModelProperty("备注文案描述")
	private String attRemark;
	
	@ApiModelProperty("考勤日期格式：2017-01-01，只精确到天")
	private Date attOughtDate;

	@ApiModelProperty("配置打卡时间第一次上班到最后一次下班 格式：9：00-18:00")
	private String attClassClocktime;

	public Integer getAttId() {
		return attId;
	}

	public void setAttId(Integer attId) {
		this.attId = attId;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public Date getConfigAttTime() {
		return configAttTime;
	}

	public void setConfigAttTime(Date configAttTime) {
		this.configAttTime = configAttTime;
	}

	public Date getLocalAttTime() {
		return localAttTime;
	}

	public void setLocalAttTime(Date localAttTime) {
		this.localAttTime = localAttTime;
	}

	public Byte getAttAttribute() {
		return attAttribute;
	}

	public void setAttAttribute(Byte attAttribute) {
		this.attAttribute = attAttribute;
	}

	public String getExtraPath() {
		return extraPath;
	}

	public void setExtraPath(String extraPath) {
		this.extraPath = extraPath;
	}

	public Byte getExtraType() {
		return extraType;
	}

	public void setExtraType(Byte extraType) {
		this.extraType = extraType;
	}

	public Byte getExtraExist() {
		return extraExist;
	}

	public void setExtraExist(Byte extraExist) {
		this.extraExist = extraExist;
	}

	public String getAttRemark() {
		return attRemark;
	}

	public void setAttRemark(String attRemark) {
		this.attRemark = attRemark;
	}

	public Date getAttOughtDate() {
		return attOughtDate;
	}

	public void setAttOughtDate(Date attOughtDate) {
		this.attOughtDate = attOughtDate;
	}

	public String getAttClassClocktime() {
		return attClassClocktime;
	}

	public void setAttClassClocktime(String attClassClocktime) {
		this.attClassClocktime = attClassClocktime;
	}
}
