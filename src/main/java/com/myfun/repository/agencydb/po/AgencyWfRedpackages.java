package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfRedpackages implements Serializable {

	/**
	 * @mbggenerated 
	 */
	private Integer redpackageId;
	/**
	 * @mbggenerated ID
	 */
	private Integer issueId;
	/**
	 * @mbggenerated ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated (1,ͨ(ר,ȯ),2)
	 */
	private Byte type;
	/**
	 * @mbggenerated ͣRENT_CUST|BUY_CUST3  4
	 */
	private Byte caseType;
	/**
	 * @mbggenerated ΢ûID
	 */
	private Integer wxId;
	/**
	 * @mbggenerated ΢ûOPENID
	 */
	private String wxOpenId;
	/**
	 * @mbggenerated 
	 */
	private Double amount;
	/**
	 * @mbggenerated 
	 */
	private Double butieAmount;
	/**
	 * @mbggenerated ʹ
	 */
	private Date useTime;
	/**
	 * @mbggenerated ״̬(0δЧ(δ),1δʹ,2ʹ)
	 */
	private Byte status;
	/**
	 * @mbggenerated
	 */
	private Date expireTime;
	/**
	 * @mbggenerated ȡ
	 */
	private Date createTime;
	/**
	 * @mbggenerated ľ
	 */
	private String agentName;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getRedpackageId() {
		return redpackageId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRedpackageId(Integer redpackageId) {
		this.redpackageId = redpackageId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getIssueId() {
		return issueId;
	}

	/**
	 * @mbggenerated
	 */
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * @mbggenerated
	 */
	public void setType(Byte type) {
		this.type = type;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWxId() {
		return wxId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWxId(Integer wxId) {
		this.wxId = wxId;
	}

	/**
	 * @mbggenerated
	 */
	public String getWxOpenId() {
		return wxOpenId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @mbggenerated
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @mbggenerated
	 */
	public Double getButieAmount() {
		return butieAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setButieAmount(Double butieAmount) {
		this.butieAmount = butieAmount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUseTime() {
		return useTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @mbggenerated
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @mbggenerated
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName == null ? null : agentName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
}