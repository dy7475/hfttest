package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpCompRoles extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer autoId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色ID")
	private String roleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色名")
	private String roleName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "序号")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "管理标记，1=管理层")
	private Byte manageFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是公司自定义角色")
	private Byte isCompRole;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除 0=未删除 1=删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "管理层级 0=没有 1=公司 2=大区 3=片区 4=门店 5=分组")
	private Byte manageLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1:参与统计   0不参与统计")
	private Byte partStatistCount;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getAutoId() {
		return autoId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
	 * @mbggenerated 角色名
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @mbggenerated 角色名
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @mbggenerated 序号
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 序号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated 管理标记，1=管理层
	 */
	public Byte getManageFlag() {
		return manageFlag;
	}

	/**
	 * @mbggenerated 管理标记，1=管理层
	 */
	public void setManageFlag(Byte manageFlag) {
		this.manageFlag = manageFlag;
	}

	/**
	 * @mbggenerated 是否是公司自定义角色
	 */
	public Byte getIsCompRole() {
		return isCompRole;
	}

	/**
	 * @mbggenerated 是否是公司自定义角色
	 */
	public void setIsCompRole(Byte isCompRole) {
		this.isCompRole = isCompRole;
	}

	/**
	 * @mbggenerated 是否删除 0=未删除 1=删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否删除 0=未删除 1=删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 管理层级 0=没有 1=公司 2=大区 3=片区 4=门店 5=分组
	 */
	public Byte getManageLevel() {
		return manageLevel;
	}

	/**
	 * @mbggenerated 管理层级 0=没有 1=公司 2=大区 3=片区 4=门店 5=分组
	 */
	public void setManageLevel(Byte manageLevel) {
		this.manageLevel = manageLevel;
	}

	/**
	 * @mbggenerated -
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 1:参与统计   0不参与统计
	 */
	public Byte getPartStatistCount() {
		return partStatistCount;
	}

	/**
	 * @mbggenerated 1:参与统计   0不参与统计
	 */
	public void setPartStatistCount(Byte partStatistCount) {
		this.partStatistCount = partStatistCount;
	}

	/**
	 * @mbggenerated
	 */
	public ErpCompRoles() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpCompRoles(Integer shardCityId, Integer autoId) {
		super(shardCityId);
		this.autoId = autoId;
	}
}