package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpFunLeasePublishInfo extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源id")
	private String leaseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联官网发布状态")
	private String websiteState;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联官网发布时间")
	private String websiteLastUpTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联官网下架时间")
	private String websiteLastDownTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联好房发布状态")
	private String mlhfState;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联好房发布时间")
	private String mlhfLastUpTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联好房下架时间")
	private String mlhfLastDownTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer lastActionUserId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 房源id
	 */
	public String getLeaseId() {
		return leaseId;
	}

	/**
	 * @mbggenerated 房源id
	 */
	public void setLeaseId(String leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * @mbggenerated 美联官网发布状态
	 */
	public String getWebsiteState() {
		return websiteState;
	}

	/**
	 * @mbggenerated 美联官网发布状态
	 */
	public void setWebsiteState(String websiteState) {
		this.websiteState = websiteState;
	}

	/**
	 * @mbggenerated 美联官网发布时间
	 */
	public String getWebsiteLastUpTime() {
		return websiteLastUpTime;
	}

	/**
	 * @mbggenerated 美联官网发布时间
	 */
	public void setWebsiteLastUpTime(String websiteLastUpTime) {
		this.websiteLastUpTime = websiteLastUpTime;
	}

	/**
	 * @mbggenerated 美联官网下架时间
	 */
	public String getWebsiteLastDownTime() {
		return websiteLastDownTime;
	}

	/**
	 * @mbggenerated 美联官网下架时间
	 */
	public void setWebsiteLastDownTime(String websiteLastDownTime) {
		this.websiteLastDownTime = websiteLastDownTime;
	}

	/**
	 * @mbggenerated 美联好房发布状态
	 */
	public String getMlhfState() {
		return mlhfState;
	}

	/**
	 * @mbggenerated 美联好房发布状态
	 */
	public void setMlhfState(String mlhfState) {
		this.mlhfState = mlhfState;
	}

	/**
	 * @mbggenerated 美联好房发布时间
	 */
	public String getMlhfLastUpTime() {
		return mlhfLastUpTime;
	}

	/**
	 * @mbggenerated 美联好房发布时间
	 */
	public void setMlhfLastUpTime(String mlhfLastUpTime) {
		this.mlhfLastUpTime = mlhfLastUpTime;
	}

	/**
	 * @mbggenerated 美联好房下架时间
	 */
	public String getMlhfLastDownTime() {
		return mlhfLastDownTime;
	}

	/**
	 * @mbggenerated 美联好房下架时间
	 */
	public void setMlhfLastDownTime(String mlhfLastDownTime) {
		this.mlhfLastDownTime = mlhfLastDownTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getLastActionUserId() {
		return lastActionUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLastActionUserId(Integer lastActionUserId) {
		this.lastActionUserId = lastActionUserId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunLeasePublishInfo() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunLeasePublishInfo(Integer shardCityId, String leaseId) {
		super(shardCityId);
		this.leaseId = leaseId;
	}
}