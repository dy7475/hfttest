package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunHistoryDealRecord extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="id") private Integer funHistoryDealRecordId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建人") private String createdUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createdTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="更新人") private String updatedUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="更新时间") private Date updatedTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="历史成交客ID") private Integer funHistoryDealCustId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动原因") private String changeCause;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动前归属人") private Integer beforeChangeUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动前归属人名称") private String beforeChangeUserName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动前归属人组织ID") private Integer beforeChangeOrgId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动前归属人组织名称") private String beforeChangeOrgName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动后归属人") private Integer afterChangeUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动后归属人名称") private String afterChangeUserName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动后归属人组织ID") private Integer afterChangeOrgId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="变动后组织名称") private String afterChangeOrgName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated id
	 */
	public Integer getFunHistoryDealRecordId() {
		return funHistoryDealRecordId;
	}

	/**
	 * @mbggenerated id
	 */
	public void setFunHistoryDealRecordId(Integer funHistoryDealRecordId) {
		this.funHistoryDealRecordId = funHistoryDealRecordId;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public String getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @mbggenerated 更新人
	 */
	public String getUpdatedUserId() {
		return updatedUserId;
	}

	/**
	 * @mbggenerated 更新人
	 */
	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * @mbggenerated 历史成交客ID
	 */
	public Integer getFunHistoryDealCustId() {
		return funHistoryDealCustId;
	}

	/**
	 * @mbggenerated 历史成交客ID
	 */
	public void setFunHistoryDealCustId(Integer funHistoryDealCustId) {
		this.funHistoryDealCustId = funHistoryDealCustId;
	}

	/**
	 * @mbggenerated 变动原因
	 */
	public String getChangeCause() {
		return changeCause;
	}

	/**
	 * @mbggenerated 变动原因
	 */
	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
	}

	/**
	 * @mbggenerated 变动前归属人
	 */
	public Integer getBeforeChangeUserId() {
		return beforeChangeUserId;
	}

	/**
	 * @mbggenerated 变动前归属人
	 */
	public void setBeforeChangeUserId(Integer beforeChangeUserId) {
		this.beforeChangeUserId = beforeChangeUserId;
	}

	/**
	 * @mbggenerated 变动前归属人名称
	 */
	public String getBeforeChangeUserName() {
		return beforeChangeUserName;
	}

	/**
	 * @mbggenerated 变动前归属人名称
	 */
	public void setBeforeChangeUserName(String beforeChangeUserName) {
		this.beforeChangeUserName = beforeChangeUserName;
	}

	/**
	 * @mbggenerated 变动前归属人组织ID
	 */
	public Integer getBeforeChangeOrgId() {
		return beforeChangeOrgId;
	}

	/**
	 * @mbggenerated 变动前归属人组织ID
	 */
	public void setBeforeChangeOrgId(Integer beforeChangeOrgId) {
		this.beforeChangeOrgId = beforeChangeOrgId;
	}

	/**
	 * @mbggenerated 变动前归属人组织名称
	 */
	public String getBeforeChangeOrgName() {
		return beforeChangeOrgName;
	}

	/**
	 * @mbggenerated 变动前归属人组织名称
	 */
	public void setBeforeChangeOrgName(String beforeChangeOrgName) {
		this.beforeChangeOrgName = beforeChangeOrgName;
	}

	/**
	 * @mbggenerated 变动后归属人
	 */
	public Integer getAfterChangeUserId() {
		return afterChangeUserId;
	}

	/**
	 * @mbggenerated 变动后归属人
	 */
	public void setAfterChangeUserId(Integer afterChangeUserId) {
		this.afterChangeUserId = afterChangeUserId;
	}

	/**
	 * @mbggenerated 变动后归属人名称
	 */
	public String getAfterChangeUserName() {
		return afterChangeUserName;
	}

	/**
	 * @mbggenerated 变动后归属人名称
	 */
	public void setAfterChangeUserName(String afterChangeUserName) {
		this.afterChangeUserName = afterChangeUserName;
	}

	/**
	 * @mbggenerated 变动后归属人组织ID
	 */
	public Integer getAfterChangeOrgId() {
		return afterChangeOrgId;
	}

	/**
	 * @mbggenerated 变动后归属人组织ID
	 */
	public void setAfterChangeOrgId(Integer afterChangeOrgId) {
		this.afterChangeOrgId = afterChangeOrgId;
	}

	/**
	 * @mbggenerated 变动后组织名称
	 */
	public String getAfterChangeOrgName() {
		return afterChangeOrgName;
	}

	/**
	 * @mbggenerated 变动后组织名称
	 */
	public void setAfterChangeOrgName(String afterChangeOrgName) {
		this.afterChangeOrgName = afterChangeOrgName;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunHistoryDealRecord() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunHistoryDealRecord(Integer shardCityId, Integer funHistoryDealRecordId) {
		super(shardCityId);
		this.funHistoryDealRecordId = funHistoryDealRecordId;
	}
}