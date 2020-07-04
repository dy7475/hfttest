package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AdminXwBankAccount implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "平台账户ID, 作为我们系统台账在新网唯一ID 对应新网的 platform_customer_no")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开户城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1：个人账户 2：企业账户")
	private Byte accountType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开户流水号 业务上暂时不会使用")
	private String openAccountNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=审核中 2=开户失败 3=开户成功")
	private Byte openAccountStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对应好房通的体系ID，结合ACCOUNT_TYPE和CITY_ID 使用   1=archiveId  2=erp的compId")
	private Integer accountHftIdentification;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 平台账户ID, 作为我们系统台账在新网唯一ID 对应新网的 platform_customer_no
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 平台账户ID, 作为我们系统台账在新网唯一ID 对应新网的 platform_customer_no
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 开户城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 开户城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 1：个人账户 2：企业账户
	 */
	public Byte getAccountType() {
		return accountType;
	}

	/**
	 * @mbggenerated 1：个人账户 2：企业账户
	 */
	public void setAccountType(Byte accountType) {
		this.accountType = accountType;
	}

	/**
	 * @mbggenerated 开户流水号 业务上暂时不会使用
	 */
	public String getOpenAccountNo() {
		return openAccountNo;
	}

	/**
	 * @mbggenerated 开户流水号 业务上暂时不会使用
	 */
	public void setOpenAccountNo(String openAccountNo) {
		this.openAccountNo = openAccountNo;
	}

	/**
	 * @mbggenerated 1=审核中 2=开户失败 3=开户成功
	 */
	public Byte getOpenAccountStatus() {
		return openAccountStatus;
	}

	/**
	 * @mbggenerated 1=审核中 2=开户失败 3=开户成功
	 */
	public void setOpenAccountStatus(Byte openAccountStatus) {
		this.openAccountStatus = openAccountStatus;
	}

	/**
	 * @mbggenerated 对应好房通的体系ID，结合ACCOUNT_TYPE和CITY_ID 使用   1=archiveId  2=erp的compId
	 */
	public Integer getAccountHftIdentification() {
		return accountHftIdentification;
	}

	/**
	 * @mbggenerated 对应好房通的体系ID，结合ACCOUNT_TYPE和CITY_ID 使用   1=archiveId  2=erp的compId
	 */
	public void setAccountHftIdentification(Integer accountHftIdentification) {
		this.accountHftIdentification = accountHftIdentification;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}