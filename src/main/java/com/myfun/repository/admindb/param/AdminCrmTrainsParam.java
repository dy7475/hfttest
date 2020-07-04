package com.myfun.repository.admindb.param;

import java.util.Date;

import com.myfun.repository.support.param.PageParam;

public class AdminCrmTrainsParam extends PageParam {

	/**
	 * 
	 */
	private String startTime;
	private String endTime;
	private Byte trainClose;
	private Integer trainMaster;
	private Integer compId;
	private Integer deptId;
	private String trainSubject;
	private Integer createUid;
	private String trainDesc;
	private Integer trainId;
	private Date trainStart;
	private Date trainEnd;
	private Integer trainStatus;
	private Integer trainLogId;
	private String trainTrack;
	private String userName;

	public Date getTrainStart() {
		return trainStart;
	}

	public void setTrainStart(Date trainStart) {
		this.trainStart = trainStart;
	}

	public Date getTrainEnd() {
		return trainEnd;
	}

	public void setTrainEnd(Date trainEnd) {
		this.trainEnd = trainEnd;
	}

	public String getTrainDesc() {
		return trainDesc;
	}

	public void setTrainDesc(String trainDesc) {
		this.trainDesc = trainDesc;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getTrainSubject() {
		return trainSubject;
	}

	public void setTrainSubject(String trainSubject) {
		this.trainSubject = trainSubject;
	}

	public Integer getCreateUid() {
		return createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public Byte getTrainClose() {
		return trainClose;
	}

	public void setTrainClose(Byte trainClose) {
		this.trainClose = trainClose;
	}

	public Integer getTrainMaster() {
		return trainMaster;
	}

	public void setTrainMaster(Integer trainMaster) {
		this.trainMaster = trainMaster;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getTrainStatus() {
		return trainStatus;
	}

	public void setTrainStatus(Integer trainStatus) {
		this.trainStatus = trainStatus;
	}

	public Integer getTrainLogId() {
		return trainLogId;
	}

	public void setTrainLogId(Integer trainLogId) {
		this.trainLogId = trainLogId;
	}

	public String getTrainTrack() {
		return trainTrack;
	}

	public void setTrainTrack(String trainTrack) {
		this.trainTrack = trainTrack;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
}
