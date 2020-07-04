package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminYouViewFeeWithdrawals implements Serializable {

	/**
	 * @mbggenerated 主键自增
	 */
	private Integer id;
	/**
	 * @mbggenerated 操作人姓名
	 */
	private String userName;
	/**
	 * @mbggenerated 操作人电话
	 */
	private String userMobile;
	/**
	 * @mbggenerated 操作人档案ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 操作人城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 操作人资金账户ID
	 */
	private Integer uaId;
	/**
	 * @mbggenerated 提现金额
	 */
	private BigDecimal withdrawalsAmount;
	/**
	 * @mbggenerated 提现方式 0=微信 1=余额
	 */
	private Byte withdrawalsType;
	/**
	 * @mbggenerated 收款人姓名
	 */
	private String payeeUserName;
	/**
	 * @mbggenerated 收款人微信名
	 */
	private String payeeWeixinName;
	/**
	 * @mbggenerated 收款人账号
	 */
	private String payeeAccount;
	/**
	 * @mbggenerated 审核人
	 */
	private Integer auditUser;
	/**
	 * @mbggenerated 审核时间
	 */
	private Date auditTime;
	/**
	 * @mbggenerated 审核结果 0=待审核  1=成功  2=失败
	 */
	private Byte auditResult;
	/**
	 * @mbggenerated 审核结果说明
	 */
	private String auditExplain;
	/**
	 * @mbggenerated 申请日期
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
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
	public Integer getUaId() {
		return uaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUaId(Integer uaId) {
		this.uaId = uaId;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getWithdrawalsAmount() {
		return withdrawalsAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setWithdrawalsAmount(BigDecimal withdrawalsAmount) {
		this.withdrawalsAmount = withdrawalsAmount;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWithdrawalsType() {
		return withdrawalsType;
	}

	/**
	 * @mbggenerated
	 */
	public void setWithdrawalsType(Byte withdrawalsType) {
		this.withdrawalsType = withdrawalsType;
	}

	/**
	 * @mbggenerated
	 */
	public String getPayeeUserName() {
		return payeeUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayeeUserName(String payeeUserName) {
		this.payeeUserName = payeeUserName == null ? null : payeeUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPayeeWeixinName() {
		return payeeWeixinName;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayeeWeixinName(String payeeWeixinName) {
		this.payeeWeixinName = payeeWeixinName == null ? null : payeeWeixinName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPayeeAccount() {
		return payeeAccount;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount == null ? null : payeeAccount.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditUser() {
		return auditUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditUser(Integer auditUser) {
		this.auditUser = auditUser;
	}

	/**
	 * @mbggenerated
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getAuditResult() {
		return auditResult;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditResult(Byte auditResult) {
		this.auditResult = auditResult;
	}

	/**
	 * @mbggenerated
	 */
	public String getAuditExplain() {
		return auditExplain;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditExplain(String auditExplain) {
		this.auditExplain = auditExplain == null ? null : auditExplain.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
}