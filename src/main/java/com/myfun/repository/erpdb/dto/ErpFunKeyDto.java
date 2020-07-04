package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.myfun.repository.erpdb.po.ErpFunKey;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunKeyDto extends ErpFunKey implements Serializable {
	private Integer keyId;
	private String keyNum;
	private Integer deptId;
	private String deptName;
	private Integer houseDeptId;
	private Integer userId;
	private String houseNo;
	private String buildName;
	private Byte room;
	private Byte wei;
	private Byte yang;
	private Byte hall;
	private Byte keyStatus;
	private Integer floor;
	private Integer floors;
	private String lendUser;
	private String borrowUser;
	private String borrowUserMobile;
	private String borrowTime;
	private Double totalPrice;
	private Integer keyLogId;
	private Byte houseUsage;
	private String charact;
	private BigDecimal area;
	private Integer logType;
	private String borrowName;
	private String userName;
	private Integer depositStatus;
	private Integer viewPermission;
	private Byte useage;
	@ApiModelProperty(value = "等级")
	private Byte houseLevel;
	@ApiModelProperty(value = "提交人组织名称")
	private String commitUserOrgName;
	@ApiModelProperty(value = "提交人名称")
	private String commitUser;
	@ApiModelProperty(value = "房源用户id")
	private Integer houseUserId;
	@ApiModelProperty(value = "组织id")
	private Integer houseOrganizationId;
	@ApiModelProperty(value = "状态")
	private Byte houseStatus;
	@ApiModelProperty(value = "盘别")
	private Byte housePlateType;
	
	@ApiModelProperty(value = "房客源概要信息")
	private String caseSummaryInfo;

	@ApiModelProperty(value = "当前操作人是否钥匙提交人，或者提交人本人直属领导，没有直属领导算上上级，1：是，2：否")
	private Byte directlyLeaderOrSelf = Byte.valueOf("2");


	public String getCommitUserOrgName() {
		return commitUserOrgName;
	}

	public void setCommitUserOrgName(String commitUserOrgName) {
		this.commitUserOrgName = commitUserOrgName;
	}

	public Byte getDirectlyLeaderOrSelf() {
		return directlyLeaderOrSelf;
	}

	public void setDirectlyLeaderOrSelf(Byte directlyLeaderOrSelf) {
		this.directlyLeaderOrSelf = directlyLeaderOrSelf;
	}

	public Integer getDepositStatus() {
		return depositStatus;
	}

	public void setDepositStatus(Integer depositStatus) {
		this.depositStatus = depositStatus;
	}

	public String getBorrowName() {
		return borrowName;
	}

	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public Integer getLogType() {
		return logType;
	}

	@Override
	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public String getCommitUser() {
		return commitUser;
	}

	public void setCommitUser(String commitUser) {
		this.commitUser = commitUser;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getCharact() {
		return charact;
	}

	public void setCharact(String charact) {
		this.charact = charact;
	}

	public Byte getHouseUsage() {
		return houseUsage;
	}

	public void setHouseUsage(Byte houseUsage) {
		this.houseUsage = houseUsage;
	}

	public Integer getKeyLogId() {
		return keyLogId;
	}
	public void setKeyLogId(Integer keyLogId) {
		this.keyLogId = keyLogId;
	}
	public Byte getHall() {
		return hall;
	}
	public void setHall(Byte hall) {
		this.hall = hall;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getFloors() {
		return floors;
	}
	public void setFloors(Integer floors) {
		this.floors = floors;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getKeyId() {
		return keyId;
	}
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	public String getKeyNum() {
		return keyNum;
	}
	public void setKeyNum(String keyNum) {
		this.keyNum = keyNum;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getHouseDeptId() {
		return houseDeptId;
	}
	public void setHouseDeptId(Integer houseDeptId) {
		this.houseDeptId = houseDeptId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public Byte getRoom() {
		return room;
	}
	public void setRoom(Byte room) {
		this.room = room;
	}
	public Byte getWei() {
		return wei;
	}
	public void setWei(Byte wei) {
		this.wei = wei;
	}
	public Byte getYang() {
		return yang;
	}
	public void setYang(Byte yang) {
		this.yang = yang;
	}
	public Byte getKeyStatus() {
		return keyStatus;
	}
	public void setKeyStatus(Byte keyStatus) {
		this.keyStatus = keyStatus;
	}
	public String getLendUser() {
		return lendUser;
	}
	public void setLendUser(String lendUser) {
		this.lendUser = lendUser;
	}
	public String getBorrowUser() {
		return borrowUser;
	}
	public void setBorrowUser(String borrowUser) {
		this.borrowUser = borrowUser;
	}
	public String getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public String getBorrowUserMobile() {
		return borrowUserMobile;
	}

	public void setBorrowUserMobile(String borrowUserMobile) {
		this.borrowUserMobile = borrowUserMobile;
	}

	public String getCaseSummaryInfo() {
		return caseSummaryInfo;
	}

	public void setCaseSummaryInfo(String caseSummaryInfo) {
		this.caseSummaryInfo = caseSummaryInfo;
	}

	public Integer getViewPermission() {
		return viewPermission;
	}

	public void setViewPermission(Integer viewPermission) {
		this.viewPermission = viewPermission;
	}

	public Byte getUseage() {
		return useage;
	}

	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	public Byte getHouseLevel() {
		return houseLevel;
	}

	public void setHouseLevel(Byte houseLevel) {
		this.houseLevel = houseLevel;
	}

	public Integer getHouseUserId() {
		return houseUserId;
	}

	public void setHouseUserId(Integer houseUserId) {
		this.houseUserId = houseUserId;
	}

	public Integer getHouseOrganizationId() {
		return houseOrganizationId;
	}

	public void setHouseOrganizationId(Integer houseOrganizationId) {
		this.houseOrganizationId = houseOrganizationId;
	}

	public Byte getHouseStatus() {
		return houseStatus;
	}

	public void setHouseStatus(Byte houseStatus) {
		this.houseStatus = houseStatus;
	}

	public Byte getHousePlateType() {
		return housePlateType;
	}

	public void setHousePlateType(Byte housePlateType) {
		this.housePlateType = housePlateType;
	}
	
}
