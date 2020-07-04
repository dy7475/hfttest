package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpBuildAllot extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键自增（楼盘分配表）") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘ID") private Integer buildId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘被使用公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘被使用门店id") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="0删除 1在用") private Byte isDel;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建人姓名") private String createUser;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建人Id") private Integer createUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="被分配的门店名称") private String deptName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增（楼盘分配表）
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增（楼盘分配表）
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @mbggenerated 楼盘被使用公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 楼盘被使用公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 楼盘被使用门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 楼盘被使用门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 0删除 1在用
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 0删除 1在用
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 创建人姓名
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @mbggenerated 创建人姓名
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * @mbggenerated 创建人Id
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 * @mbggenerated 创建人Id
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @mbggenerated 被分配的门店名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated 被分配的门店名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildAllot() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildAllot(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}