package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;

public class UpdateUserInfoParam extends AbstractEncryParam{

	private String baseMoney;
	private String statusTime;
	private String userPosition;
	private String oldUserPosition; // 
	private Integer oldUserStatus; // 
	private Integer userStatus;
	private Integer userId;
	private Integer grId;
	private Integer deptId;
	private Integer regId;
	private Integer areaId;
	private Integer archiveId;

	private Integer selfCityId;
	private Integer compType;
	private Integer selfCompId;
	private Integer selfDeptId;
	private Integer selfArchiveId;
	private Integer selfUserId;
	private Integer provinceId;
	private Integer selUid;
	private boolean isFangJidi;
	
	public boolean isFangJidi() {
		return isFangJidi;
	}

	public void setFangJidi(boolean isFangJidi) {
		this.isFangJidi = isFangJidi;
	}

	public Integer getSelUid() {
		return selUid;
	}

	public void setSelUid(Integer selUid) {
		this.selUid = selUid;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public String getOldUserPosition() {
		return oldUserPosition;
	}
	public void setOldUserPosition(String oldUserPosition) {
		this.oldUserPosition = oldUserPosition;
	}
	public Integer getOldUserStatus() {
		return oldUserStatus;
	}
	public void setOldUserStatus(Integer oldUserStatus) {
		this.oldUserStatus = oldUserStatus;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public Integer getSelfArchiveId() {
		return selfArchiveId;
	}
	public void setSelfArchiveId(Integer selfArchiveId) {
		this.selfArchiveId = selfArchiveId;
	}
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	public Integer getSelfCompId() {
		return selfCompId;
	}
	public void setSelfCompId(Integer selfCompId) {
		this.selfCompId = selfCompId;
	}
	public Integer getSelfCityId() {
		return selfCityId;
	}
	public void setSelfCityId(Integer selfCityId) {
		this.selfCityId = selfCityId;
	}
	public String getStatusTime() {
		return statusTime;
	}
	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}
	public Integer getCompType() {
		return compType;
	}
	public void setCompType(Integer compType) {
		this.compType = compType;
	}
	public Integer getSelfDeptId() {
		return selfDeptId;
	}
	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
	}
	public String getBaseMoney() {
		return baseMoney;
	}
	public void setBaseMoney(String baseMoney) {
		this.baseMoney = baseMoney;
	}
	
}
