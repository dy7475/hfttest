/**
 * @author 方李骥
 * @since 2016年9月19日
 */
package com.myfun.repository.erpdb.param;

import java.math.BigDecimal;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * @author 方李骥
 * @since 2016年9月19日
 */
public class CreateOrUpdateWorkLogParam extends AbstractEncryParam implements DaoBaseParam{
	private Integer cityId;//城市ID
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	private String userName;//业务层需要使用当前用户名称
	private String currentDeptName;//业务层需要使用当前用户名称
	private Integer currentDeptId;//当前用户所在门店ID
	private Integer currentUserId;//当前用户的ID
	private Integer wlId;
	private Integer compId;
	private Integer deptId;
	private Integer wlUser;
	private String wlTime;
	private String wlSubmit;
	private Integer explrthCount;
	private Integer lookCount;
	private BigDecimal otherCount = new BigDecimal("0");
	private BigDecimal totalCount;
	private String wlSummary;
	private Byte examinFlag;
	private String examinLevel;
	private String examinDescript;
	private Integer examinUser;
	private String examinTime;
	private Integer creatorUid;
	private String creationTime;
	private String planJson;
	private Byte trackType;
	private static final long serialVersionUID = 1L;


	
	public Byte getTrackType() {
		return trackType;
	}

	public void setTrackType(Byte trackType) {
		this.trackType = trackType;
	}

	public String getPlanJson() {
		return planJson;
	}

	public void setPlanJson(String planJson) {
		this.planJson = planJson;
	}

	/**
	 * @return the currentUserId
	 */
	public Integer getCurrentUserId() {
		return currentUserId;
	}

	/**
	 * @param currentUserId the currentUserId to set
	 */
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

	public Integer getWlId() {
		return wlId;
	}

	public void setWlId(Integer wlId) {
		this.wlId = wlId;
	}

	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getWlUser() {
		return wlUser;
	}

	public void setWlUser(Integer wlUser) {
		this.wlUser = wlUser;
	}

	public String getWlTime() {
		return wlTime;
	}

	public void setWlTime(String wlTime) {
		this.wlTime = wlTime == null ? null : wlTime.trim();
	}

	public String getWlSubmit() {
		return wlSubmit;
	}

	public void setWlSubmit(String wlSubmit) {
		this.wlSubmit = wlSubmit == null ? null : wlSubmit.trim();
	}

	public Integer getExplrthCount() {
		return explrthCount;
	}

	public void setExplrthCount(Integer explrthCount) {
		this.explrthCount = explrthCount;
	}

	public Integer getLookCount() {
		return lookCount;
	}

	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
	}

	public BigDecimal getOtherCount() {
		return otherCount;
	}

	public void setOtherCount(BigDecimal otherCount) {
		this.otherCount = otherCount;
	}

	public BigDecimal getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(BigDecimal totalCount) {
		this.totalCount = totalCount;
	}

	public String getWlSummary() {
		return wlSummary;
	}

	public void setWlSummary(String wlSummary) {
		this.wlSummary = wlSummary == null ? null : wlSummary.trim();
	}

	public Byte getExaminFlag() {
		return examinFlag;
	}

	public void setExaminFlag(Byte examinFlag) {
		this.examinFlag = examinFlag;
	}

	public String getExaminLevel() {
		return examinLevel;
	}

	public void setExaminLevel(String examinLevel) {
		this.examinLevel = examinLevel == null ? null : examinLevel.trim();
	}

	public String getExaminDescript() {
		return examinDescript;
	}

	public void setExaminDescript(String examinDescript) {
		this.examinDescript = examinDescript == null ? null : examinDescript.trim();
	}

	public Integer getExaminUser() {
		return examinUser;
	}

	public void setExaminUser(Integer examinUser) {
		this.examinUser = examinUser;
	}

	public String getExaminTime() {
		return examinTime;
	}

	public void setExaminTime(String examinTime) {
		this.examinTime = examinTime == null ? null : examinTime.trim();
	}

	public Integer getCreatorUid() {
		return creatorUid;
	}

	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime == null ? null : creationTime.trim();
	}
	
	public Integer getCityId() {
		return cityId;
	}
	
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCurrentDeptName() {
		return currentDeptName;
	}

	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}

	public Integer getCurrentDeptId() {
		return currentDeptId;
	}

	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}
	
	
	
}
