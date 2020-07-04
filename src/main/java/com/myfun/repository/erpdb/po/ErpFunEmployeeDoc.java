package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunEmployeeDoc extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 档案ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 修改时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 民族
	 */
	private String nation;
	/**
	 * @mbggenerated 婚姻状况 0= 未婚   1= 已婚 2：丧偶 3：离异
	 */
	private Byte maritalStatus;
	/**
	 * @mbggenerated 籍贯
	 */
	private String placeOfOrigin;
	/**
	 * @mbggenerated 毕业院校
	 */
	private String userSchool;
	/**
	 * @mbggenerated 银行账号
	 */
	private String bankAccount;
	/**
	 * @mbggenerated 社保账号
	 */
	private String socialSecurityAccount;
	/**
	 * @mbggenerated 备注信息
	 */
	private String remarkInfo;
	/**
	 * @mbggenerated 招聘渠道
	 */
	private String channelDescription;
	/**
	 * @mbggenerated 学历
	 */
	private String userSchlrecord;
	/**
	 * @mbggenerated 银行类型
	 */
	private Integer accountType;
	/**
	 * @mbggenerated 毕业时间
	 */
	private Date graduationTime;
	/**
	 * @mbggenerated 入职
	 */
	private Date userJobDate;
	/**
	 * @mbggenerated 离职
	 */
	private Date writeoffTime;
	/**
	 * @mbggenerated 當前員工的USER_ID
	 */
	private Integer userId;
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
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
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
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @mbggenerated
	 */
	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setMaritalStatus(Byte maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	/**
	 * @mbggenerated
	 */
	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin == null ? null : placeOfOrigin.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUserSchool() {
		return userSchool;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool == null ? null : userSchool.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * @mbggenerated
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount == null ? null : bankAccount.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSocialSecurityAccount() {
		return socialSecurityAccount;
	}

	/**
	 * @mbggenerated
	 */
	public void setSocialSecurityAccount(String socialSecurityAccount) {
		this.socialSecurityAccount = socialSecurityAccount == null ? null : socialSecurityAccount.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRemarkInfo() {
		return remarkInfo;
	}

	/**
	 * @mbggenerated
	 */
	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo == null ? null : remarkInfo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getChannelDescription() {
		return channelDescription;
	}

	/**
	 * @mbggenerated
	 */
	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription == null ? null : channelDescription.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUserSchlrecord() {
		return userSchlrecord;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserSchlrecord(String userSchlrecord) {
		this.userSchlrecord = userSchlrecord == null ? null : userSchlrecord.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAccountType() {
		return accountType;
	}

	/**
	 * @mbggenerated
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	/**
	 * @mbggenerated
	 */
	public Date getGraduationTime() {
		return graduationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUserJobDate() {
		return userJobDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserJobDate(Date userJobDate) {
		this.userJobDate = userJobDate;
	}

	/**
	 * @mbggenerated
	 */
	public Date getWriteoffTime() {
		return writeoffTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setWriteoffTime(Date writeoffTime) {
		this.writeoffTime = writeoffTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEmployeeDoc() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEmployeeDoc(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}