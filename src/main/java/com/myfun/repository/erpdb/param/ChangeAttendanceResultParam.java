package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ChangeAttendanceResultParam  extends AbstractEncryParam {
	
	@ApiModelProperty("考勤id")
	private Integer attId;
	
	@ApiModelProperty("时间考勤结果状态 管理中心，考勤所属模块 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假")
	private Byte attResult;
	
	@ApiModelProperty("编辑的备注信息")
	private String editRemark;
	
	@ApiModelProperty("迟到的分钟数")
	private Integer lateMinutes;
	
	@ApiModelProperty("系统配置应该的考勤时间	例 2017-01-01 09:00")
	private String configAttTime;
	
	@ApiModelProperty("位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte manageLocationAttResult;
	
	@ApiModelProperty("考勤班次时间")
	private String attClassClocktime;
	
	@ApiModelProperty("考勤的时间;如2019-03-16")
	private String attOughtDate;
	
	@ApiModelProperty("第几轮考勤")
	private Byte attNum;
	
	@ApiModelProperty("一共打几次卡")
	private Byte attSumCount;
	
	@ApiModelProperty("考勤班次名称")
	private String attClassName;
	
	@ApiModelProperty("考勤上班或者下班	上班：1 、下班：2    (默认 0)")
	private Byte attAttribute;
	
	@ApiModelProperty("考勤组id")
	private Integer attGrId =0;
	
	@ApiModelProperty("考勤班次id")
	private Integer attClassId =0;
	
	@ApiModelProperty("被修改的员工的id")
	private Integer userId;
	
	@ApiModelProperty("当前操作者用户名")
	private String currentUserName;
	
	@ApiModelProperty("原来的记录状态")
	private Byte oldAttRecordStatus;
	
	@ApiModelProperty("时间考勤结果-管理员 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息（服务器端根据时间动态计算结果）(默认0) - 实际与前端交互的参数")
	private String manageTimeAttResult;
	
	@ApiModelProperty("本次考勤打卡的时间")
	private String originTime;

	public Byte getOldAttRecordStatus() {
		return oldAttRecordStatus;
	}

	public void setOldAttRecordStatus(Byte oldAttRecordStatus) {
		this.oldAttRecordStatus = oldAttRecordStatus;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAttClassName() {
		return attClassName;
	}
	public void setAttClassName(String attClassName) {
		this.attClassName = attClassName;
	}
	public Byte getAttNum() {
		return attNum;
	}
	public void setAttNum(Byte attNum) {
		this.attNum = attNum;
	}
	public Byte getAttSumCount() {
		return attSumCount;
	}
	public void setAttSumCount(Byte attSumCount) {
		this.attSumCount = attSumCount;
	}
	public String getAttOughtDate() {
		return attOughtDate;
	}
	public void setAttOughtDate(String attOughtDate) {
		this.attOughtDate = attOughtDate;
	}
	public String getConfigAttTime() {
		return configAttTime;
	}
	public void setConfigAttTime(String configAttTime) {
		this.configAttTime = configAttTime;
	}
	public Byte getManageLocationAttResult() {
		return manageLocationAttResult;
	}
	public void setManageLocationAttResult(Byte manageLocationAttResult) {
		this.manageLocationAttResult = manageLocationAttResult;
	}
	public String getAttClassClocktime() {
		return attClassClocktime;
	}
	public void setAttClassClocktime(String attClassClocktime) {
		this.attClassClocktime = attClassClocktime;
	}
	public Integer getAttGrId() {
		return attGrId;
	}
	public void setAttGrId(Integer attGrId) {
		this.attGrId = attGrId;
	}
	public Integer getAttClassId() {
		return attClassId;
	}
	public void setAttClassId(Integer attClassId) {
		this.attClassId = attClassId;
	}
	public Integer getAttId() {
		return attId;
	}
	public void setAttId(Integer attId) {
		this.attId = attId;
	}
	public Byte getAttResult() {
		return attResult;
	}
	public void setAttResult(Byte attResult) {
		this.attResult = attResult;
	}
	public String getEditRemark() {
		return editRemark;
	}
	public void setEditRemark(String editRemark) {
		this.editRemark = editRemark;
	}
	public Integer getLateMinutes() {
		return lateMinutes;
	}
	public void setLateMinutes(Integer lateMinutes) {
		this.lateMinutes = lateMinutes;
	}
	public Byte getAttAttribute() {
		return attAttribute;
	}
	public void setAttAttribute(Byte attAttribute) {
		this.attAttribute = attAttribute;
	}

	public String getManageTimeAttResult() {
		return manageTimeAttResult;
	}

	public void setManageTimeAttResult(String manageTimeAttResult) {
		this.manageTimeAttResult = manageTimeAttResult;
	}

	public String getOriginTime() {
		return originTime;
	}

	public void setOriginTime(String originTime) {
		this.originTime = originTime;
	}
}
