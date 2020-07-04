package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel(description = "成交列表VO")
public class ErpOutdealVo implements Serializable {
	/**
	 *
	 * @mbggenerated
	合同ID
	 */
	@ApiModelProperty("合同ID")
	private Integer dealId;

	/**
	 *
	 * @mbggenerated
	公司ID
	 */
	@ApiModelProperty("公司ID")
	private Integer compId;

	/**
	 *
	 * @mbggenerated
	分店ID
	 */
	@ApiModelProperty("分店ID")
	private Integer deptId;

	/**
	 *
	 * @mbggenerated
	合同编号自动生成
	 */
	@ApiModelProperty("同编号自动生成")
	private String agreementNo;

	/**
	 *
	 * @mbggenerated
	签定时间
	 */
	@ApiModelProperty("签定时间")
	private String creatorDate;

	/**
	 *
	 * @mbggenerated
	创建人(USER_ID)
	 */
	@ApiModelProperty("创建人")
	private Integer creatorUserId;

	/**
	 *
	 * @mbggenerated
	成交类型
	 */
	@ApiModelProperty("成交类型")
	private Byte dealType;

	/**
	 *
	 * @mbggenerated
	状态
	 */
	@ApiModelProperty("状态")
	private Byte dealStatus;

	/**
	 *
	 * @mbggenerated
	房源ID
	 */
	@ApiModelProperty("房源ID")
	private Integer caseId;

	/**
	 *
	 * @mbggenerated
	来源类型
	 */
	@ApiModelProperty("来源类型")
	private Byte caseType;

	/**
	 *
	 * @mbggenerated
	用途
	 */
	@ApiModelProperty("用途")
	private Byte houseUseage;

	/**
	 *
	 * @mbggenerated
	大区ID
	 */
	@ApiModelProperty("大区ID")
	private Integer areaId;

	/**
	 *
	 * @mbggenerated
	片区ID
	 */
	@ApiModelProperty("片区ID")
	private Integer regId;

	/**
	 *
	 * @mbggenerated
	成交金额
	 */
	@ApiModelProperty("成交金额")
	private BigDecimal dealTotalPrice;

	/**
	 *
	 * @mbggenerated
	佣金
	 */
	@ApiModelProperty("佣金")
	private BigDecimal dealCommission;

	/**
	 * @mbggenerated 成交金额单位
	 */
	@ApiModelProperty("成交金额单位")
	private Byte totalPriceUnit;
	/**
	 * @mbggenerated 房客描述
	 */
	@ApiModelProperty("房客描述")
	private String caseCharacter;
	/**
	 * @mbggenerated 房客所属人
	 */
	@ApiModelProperty("房客所属人")
	private Integer caseUser;

	@ApiModelProperty(value = "成交类型 0:内成交 1：外成交")
	private Integer caseDealType;

	@ApiModelProperty(value = "用户档案ID")
	private Integer archiveId;


	private String userName;
	private String caseNo;

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getCaseDealType() {
		return caseDealType;
	}

	public void setCaseDealType(Integer caseDealType) {
		this.caseDealType = caseDealType;
	}

	public Byte getTotalPriceUnit() {
		return totalPriceUnit;
	}

	public void setTotalPriceUnit(Byte totalPriceUnit) {
		this.totalPriceUnit = totalPriceUnit;
	}

	public String getCaseCharacter() {
		return caseCharacter;
	}

	public void setCaseCharacter(String caseCharacter) {
		this.caseCharacter = caseCharacter;
	}

	public Integer getCaseUser() {
		return caseUser;
	}

	public void setCaseUser(Integer caseUser) {
		this.caseUser = caseUser;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public String getCreatorDate() {
		return creatorDate;
	}

	public void setCreatorDate(String creatorDate) {
		this.creatorDate = creatorDate;
	}

	public Integer getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public Byte getDealType() {
		return dealType;
	}

	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}

	public Byte getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Byte dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public Byte getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public BigDecimal getDealTotalPrice() {
		return dealTotalPrice;
	}

	public void setDealTotalPrice(BigDecimal dealTotalPrice) {
		this.dealTotalPrice = dealTotalPrice;
	}

	public BigDecimal getDealCommission() {
		return dealCommission;
	}

	public void setDealCommission(BigDecimal dealCommission) {
		this.dealCommission = dealCommission;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
}
