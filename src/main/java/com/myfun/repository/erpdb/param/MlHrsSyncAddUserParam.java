package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class MlHrsSyncAddUserParam extends AbstractEncryParam implements DaoBaseParam{

	private String password;
	private String regIds;
	private String sectionIds;
	private String serviceZone;
	private Integer inviteId;
	private Integer cityId;
	private Integer compId;
	private String compNo;
	private String userJobDate;
	// modify lcb 修改于 2020/5/25 邀请逻辑的数据

	private Integer selfUserId;
	private Integer deptId;
	private String userMobile;
	private String userName;
	private Integer grId;
	private Integer areaId;
	private Integer regId;
	private String userPosition;
	private Byte userSex;
	private Integer rangeType;
	private String rangeIds;
	private Integer organizationId;
	private Integer roleLevelId = 0;
	// modify lcb 修改于 2020/5/26 美联人事系统的主键
	private Integer mlUserId;
	private String mlUserNo;
	private String iccode;

	public String getIccode() {
		return iccode;
	}

	public void setIccode(String iccode) {
		this.iccode = iccode;
	}

	public String getMlUserNo() {
		return mlUserNo;
	}

	public void setMlUserNo(String mlUserNo) {
		this.mlUserNo = mlUserNo;
	}

	public Integer getMlUserId() {
		return mlUserId;
	}

	public void setMlUserId(Integer mlUserId) {
		this.mlUserId = mlUserId;
	}

	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getRangeIds() {
		return rangeIds;
	}

	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public Byte getUserSex() {
		return userSex;
	}

	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
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

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegIds() {
		return regIds;
	}

	public void setRegIds(String regIds) {
		this.regIds = regIds;
	}

	public String getSectionIds() {
		return sectionIds;
	}

	public void setSectionIds(String sectionIds) {
		this.sectionIds = sectionIds;
	}

	public String getServiceZone() {
		return serviceZone;
	}

	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone;
	}

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
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

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public String getUserJobDate() {
		return userJobDate;
	}

	public void setUserJobDate(String userJobDate) {
		this.userJobDate = userJobDate;
	}
}
