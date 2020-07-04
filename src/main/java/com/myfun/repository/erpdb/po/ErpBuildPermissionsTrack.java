package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpBuildPermissionsTrack extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer trackType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer organizationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String buildIdsView;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String buildIdsEdit;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String buildIdsAdd;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer targetOrganizationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer creationUid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Date creationTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String houseUseage;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String oldHouseUseage;
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
	public Integer getTrackType() {
		return trackType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTrackType(Integer trackType) {
		this.trackType = trackType;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getBuildIdsView() {
		return buildIdsView;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBuildIdsView(String buildIdsView) {
		this.buildIdsView = buildIdsView;
	}

	/**
	 * @mbggenerated -
	 */
	public String getBuildIdsEdit() {
		return buildIdsEdit;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBuildIdsEdit(String buildIdsEdit) {
		this.buildIdsEdit = buildIdsEdit;
	}

	/**
	 * @mbggenerated -
	 */
	public String getBuildIdsAdd() {
		return buildIdsAdd;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBuildIdsAdd(String buildIdsAdd) {
		this.buildIdsAdd = buildIdsAdd;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getTargetOrganizationId() {
		return targetOrganizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTargetOrganizationId(Integer targetOrganizationId) {
		this.targetOrganizationId = targetOrganizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCreationUid() {
		return creationUid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreationUid(Integer creationUid) {
		this.creationUid = creationUid;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated -
	 */
	public String getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated -
	 */
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOldHouseUseage() {
		return oldHouseUseage;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOldHouseUseage(String oldHouseUseage) {
		this.oldHouseUseage = oldHouseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildPermissionsTrack() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildPermissionsTrack(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}