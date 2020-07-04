package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpBuildingManager extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "表ID")
	private Integer buildingManagerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘ID")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "维护人ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "管理类型 1：楼盘管理员2：栋管理员")
	private Byte managerType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 表ID
	 */
	public Integer getBuildingManagerId() {
		return buildingManagerId;
	}

	/**
	 * @mbggenerated 表ID
	 */
	public void setBuildingManagerId(Integer buildingManagerId) {
		this.buildingManagerId = buildingManagerId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated 维护人ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 维护人ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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

	/**
	 * @mbggenerated 管理类型 1：楼盘管理员2：栋管理员
	 */
	public Byte getManagerType() {
		return managerType;
	}

	/**
	 * @mbggenerated 管理类型 1：楼盘管理员2：栋管理员
	 */
	public void setManagerType(Byte managerType) {
		this.managerType = managerType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingManager() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingManager(Integer shardCityId, Integer buildingManagerId) {
		super(shardCityId);
		this.buildingManagerId = buildingManagerId;
	}
}