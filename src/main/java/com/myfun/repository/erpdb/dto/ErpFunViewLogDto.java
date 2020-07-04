package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunViewLog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunViewLogDto extends ErpFunViewLog {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "对应房源就是小区名称，对应客源就是客源姓名")
	private String caseName;
	
	@ApiModelProperty(value = "对应房源就是房源面积，对应客源就是意向面积区间")
	private String caseArea;
	
	@ApiModelProperty(value = "对应房源就是房源价格，对应客源就是意向价格区间")
	private String casePrice;
	
	@ApiModelProperty(value = "几房/几室")
	private Byte room;
	
	@ApiModelProperty(value = "出租价格单位")
	private Byte priceUnit;
	
	@ApiModelProperty(value = "求购求租用户性别")
	private Boolean caseSex;
	
	@ApiModelProperty(value = "房客源概要信息 如:谢先生 3室 100-120㎡ 150-180万")
	private String caseSummaryInfo;

	@ApiModelProperty(value = "楼盘ID")
	private String buildId;
	
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
	@ApiModelProperty(value = "权限")
	private Integer viewPermission;

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseArea() {
		return caseArea;
	}

	public void setCaseArea(String caseArea) {
		this.caseArea = caseArea;
	}

	public String getCasePrice() {
		return casePrice;
	}

	public void setCasePrice(String casePrice) {
		this.casePrice = casePrice;
	}

	public Byte getRoom() {
		return room;
	}

	public void setRoom(Byte room) {
		this.room = room;
	}

	public Byte getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	public Boolean getCaseSex() {
		return caseSex;
	}

	public void setCaseSex(Boolean caseSex) {
		this.caseSex = caseSex;
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
	
}