package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunUsersInvited extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "电话")
	private String userMobile;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte userSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String userPosition;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "级别")
	private String personnelLevels;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer levelsId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String serviceReg;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String serviceZone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String serviceZoneIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "管理范围")
	private String rangeIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer rangeType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String compNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0 待验证 1：已验证 2：已删除")
	private Byte inviteStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer createUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "新职级id，对应FUN_ROLE_LEVELS表")
	private Integer roleLevelId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "直接管理人")
	private Integer currentPId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织综合查询字段 :12001:12002:12003:")
	private String organizationPath;
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
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
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
	 * @mbggenerated -
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 电话
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated 电话
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getUserSex() {
		return userSex;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	/**
	 * @mbggenerated -
	 */
	public String getUserPosition() {
		return userPosition;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	/**
	 * @mbggenerated 级别
	 */
	public String getPersonnelLevels() {
		return personnelLevels;
	}

	/**
	 * @mbggenerated 级别
	 */
	public void setPersonnelLevels(String personnelLevels) {
		this.personnelLevels = personnelLevels;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getLevelsId() {
		return levelsId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLevelsId(Integer levelsId) {
		this.levelsId = levelsId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getServiceReg() {
		return serviceReg;
	}

	/**
	 * @mbggenerated -
	 */
	public void setServiceReg(String serviceReg) {
		this.serviceReg = serviceReg;
	}

	/**
	 * @mbggenerated -
	 */
	public String getServiceZone() {
		return serviceZone;
	}

	/**
	 * @mbggenerated -
	 */
	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone;
	}

	/**
	 * @mbggenerated -
	 */
	public String getServiceZoneIds() {
		return serviceZoneIds;
	}

	/**
	 * @mbggenerated -
	 */
	public void setServiceZoneIds(String serviceZoneIds) {
		this.serviceZoneIds = serviceZoneIds;
	}

	/**
	 * @mbggenerated 管理范围
	 */
	public String getRangeIds() {
		return rangeIds;
	}

	/**
	 * @mbggenerated 管理范围
	 */
	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getRangeType() {
		return rangeType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 0 待验证 1：已验证 2：已删除
	 */
	public Byte getInviteStatus() {
		return inviteStatus;
	}

	/**
	 * @mbggenerated 0 待验证 1：已验证 2：已删除
	 */
	public void setInviteStatus(Byte inviteStatus) {
		this.inviteStatus = inviteStatus;
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
		this.userName = userName;
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
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 新职级id，对应FUN_ROLE_LEVELS表
	 */
	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	/**
	 * @mbggenerated 新职级id，对应FUN_ROLE_LEVELS表
	 */
	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	/**
	 * @mbggenerated 直接管理人
	 */
	public Integer getCurrentPId() {
		return currentPId;
	}

	/**
	 * @mbggenerated 直接管理人
	 */
	public void setCurrentPId(Integer currentPId) {
		this.currentPId = currentPId;
	}

	/**
	 * @mbggenerated 组织机构ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated 组织机构ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunUsersInvited() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunUsersInvited(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}