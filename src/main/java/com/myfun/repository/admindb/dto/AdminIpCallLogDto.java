package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminIpCallLog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdminIpCallLogDto extends AdminIpCallLog {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "房客源概要信息")
	private String caseSummaryInfo;
	@ApiModelProperty(value = "房源名称（或者客户名）")
	private String caseName;
	@ApiModelProperty(value = "概要信息（不包含房源名称（或者客户名））")
	private String caseInfo;
	@ApiModelProperty(value = "语音所属房源的所属人id")
	private Integer caseSourceUserId;
	@ApiModelProperty(value = "等级")
	private Byte houseLevel;
	@ApiModelProperty(value = "房源用户id")
	private Integer houseUserId;
	@ApiModelProperty(value = "组织id")
	private Integer houseOrganizationId;
	@ApiModelProperty(value = "状态")
	private Byte houseStatus;
	@ApiModelProperty(value = "盘别")
	private Byte housePlateType;
	@ApiModelProperty(value = "用途")
	private Byte houseUseage;
	@ApiModelProperty(value = "楼盘id")
	private Integer houseBuildId;
	@ApiModelProperty(value = "权限")
	private Integer viewPermission;

	public Integer getCaseSourceUserId() {
		return caseSourceUserId;
	}

	public void setCaseSourceUserId(Integer caseSourceUserId) {
		this.caseSourceUserId = caseSourceUserId;
	}

	public String getCaseName() {
	
		return caseName;
	}

	public void setCaseName(String caseName) {
	
		this.caseName = caseName;
	}

	public String getCaseInfo() {
	
		return caseInfo;
	}

	public void setCaseInfo(String caseInfo) {
	
		this.caseInfo = caseInfo;
	}

	public String getCaseSummaryInfo() {
		return caseSummaryInfo;
	}

	public void setCaseSummaryInfo(String caseSummaryInfo) {
		this.caseSummaryInfo = caseSummaryInfo;
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

	public Integer getViewPermission() {
		return viewPermission;
	}

	public void setViewPermission(Integer viewPermission) {
		this.viewPermission = viewPermission;
	}

	public Byte getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
	}

	public Integer getHouseBuildId() {
		return houseBuildId;
	}

	public void setHouseBuildId(Integer houseBuildId) {
		this.houseBuildId = houseBuildId;
	}
	

}