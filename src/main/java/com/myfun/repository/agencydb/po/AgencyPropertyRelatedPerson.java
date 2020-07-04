package com.myfun.repository.agencydb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AgencyPropertyRelatedPerson implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer cooperationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer agentId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte personType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String userMobile;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer orgId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String orgName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Date responsibilityPeriodBegin;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Date responsibilityPeriodEnd;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer createUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Date createTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte delFlag;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer delUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Date delTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer userId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String userName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer buildId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte status;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated -
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCooperationId() {
		return cooperationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCooperationId(Integer cooperationId) {
		this.cooperationId = cooperationId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getAgentId() {
		return agentId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getPersonType() {
		return personType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPersonType(Byte personType) {
		this.personType = personType;
	}

	/**
	 * @mbggenerated -
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}

	/**
	 * @mbggenerated -
	 */
	public Date getResponsibilityPeriodBegin() {
		return responsibilityPeriodBegin;
	}

	/**
	 * @mbggenerated -
	 */
	public void setResponsibilityPeriodBegin(Date responsibilityPeriodBegin) {
		this.responsibilityPeriodBegin = responsibilityPeriodBegin;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getResponsibilityPeriodEnd() {
		return responsibilityPeriodEnd;
	}

	/**
	 * @mbggenerated -
	 */
	public void setResponsibilityPeriodEnd(Date responsibilityPeriodEnd) {
		this.responsibilityPeriodEnd = responsibilityPeriodEnd;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getDelUserId() {
		return delUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDelUserId(Integer delUserId) {
		this.delUserId = delUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @mbggenerated -
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}
}