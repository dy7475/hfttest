package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpBuildingSetSetting extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
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
	@ApiModelProperty(value = "是否锁定，0=未锁定 1=锁定")
	private Byte buildLock;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座别名")
	private String buildRoofName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元别名")
	private String buildUnitName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @mbggenerated 是否锁定，0=未锁定 1=锁定
	 */
	public Byte getBuildLock() {
		return buildLock;
	}

	/**
	 * @mbggenerated 是否锁定，0=未锁定 1=锁定
	 */
	public void setBuildLock(Byte buildLock) {
		this.buildLock = buildLock;
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
	 * @mbggenerated 栋座别名
	 */
	public String getBuildRoofName() {
		return buildRoofName;
	}

	/**
	 * @mbggenerated 栋座别名
	 */
	public void setBuildRoofName(String buildRoofName) {
		this.buildRoofName = buildRoofName == null ? null : buildRoofName.trim();
	}

	/**
	 * @mbggenerated 单元别名
	 */
	public String getBuildUnitName() {
		return buildUnitName;
	}

	/**
	 * @mbggenerated 单元别名
	 */
	public void setBuildUnitName(String buildUnitName) {
		this.buildUnitName = buildUnitName == null ? null : buildUnitName.trim();
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingSetSetting() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingSetSetting(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}