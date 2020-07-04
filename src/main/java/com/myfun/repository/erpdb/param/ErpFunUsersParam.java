package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.param.EncryParamIfc;

public class ErpFunUsersParam extends ErpFunUsers  implements EncryParamIfc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String AchiveIds;
	private String newNum;
	private String deptName;

	private Integer selfCityId;
	private Integer selfCompId;
	private Integer selfDeptId;
	private Integer selfArchiveId;
	private Integer selfUserId;
	private String selfUserName;
	private Integer selfProvinceId;
	
	public String getNewNum() {
		return newNum;
	}
	public void setNewNum(String newNum) {
		this.newNum = newNum;
	}
	public String getAchiveIds() {
		return AchiveIds;
	}
	public void setAchiveIds(String achiveIds) {
		AchiveIds = achiveIds;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getSelfCityId() {
		return selfCityId;
	}

	public void setSelfCityId(Integer selfCityId) {
		this.selfCityId = selfCityId;
	}

	public Integer getSelfCompId() {
		return selfCompId;
	}

	public void setSelfCompId(Integer selfCompId) {
		this.selfCompId = selfCompId;
	}

	public Integer getSelfDeptId() {
		return selfDeptId;
	}

	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
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

	public String getSelfUserName() {
		return selfUserName;
	}

	public void setSelfUserName(String selfUserName) {
		this.selfUserName = selfUserName;
	}

	public Integer getSelfProvinceId() {
		return selfProvinceId;
	}

	public void setSelfProvinceId(Integer selfProvinceId) {
		this.selfProvinceId = selfProvinceId;
	}
}
