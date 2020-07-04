package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunRoleLevels extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增")
	private Integer roleLevelId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色ID-字符串类型")
	private String roleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "职级名称-角色范围内不能重复")
	private String roleLevelName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "职级薪资-整数-暂时不使用")
	private Integer roleLevelSalary;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "数据库排序：序号越大，则职级越高")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "职级状态：1启用、0删除、默认：1")
	private Byte roleLevelStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增
	 */
	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	/**
	 * @mbggenerated 主键自增
	 */
	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
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
	 * @mbggenerated 角色ID-字符串类型
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated 角色ID-字符串类型
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @mbggenerated 职级名称-角色范围内不能重复
	 */
	public String getRoleLevelName() {
		return roleLevelName;
	}

	/**
	 * @mbggenerated 职级名称-角色范围内不能重复
	 */
	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
	}

	/**
	 * @mbggenerated 职级薪资-整数-暂时不使用
	 */
	public Integer getRoleLevelSalary() {
		return roleLevelSalary;
	}

	/**
	 * @mbggenerated 职级薪资-整数-暂时不使用
	 */
	public void setRoleLevelSalary(Integer roleLevelSalary) {
		this.roleLevelSalary = roleLevelSalary;
	}

	/**
	 * @mbggenerated 数据库排序：序号越大，则职级越高
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 数据库排序：序号越大，则职级越高
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated 职级状态：1启用、0删除、默认：1
	 */
	public Byte getRoleLevelStatus() {
		return roleLevelStatus;
	}

	/**
	 * @mbggenerated 职级状态：1启用、0删除、默认：1
	 */
	public void setRoleLevelStatus(Byte roleLevelStatus) {
		this.roleLevelStatus = roleLevelStatus;
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
	 * @mbggenerated
	 */
	public ErpFunRoleLevels() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoleLevels(Integer shardCityId, Integer roleLevelId) {
		super(shardCityId);
		this.roleLevelId = roleLevelId;
	}
}