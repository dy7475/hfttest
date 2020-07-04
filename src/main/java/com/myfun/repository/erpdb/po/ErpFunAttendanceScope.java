package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunAttendanceScope extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer attScopeId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经度")
	private String attScopeX;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "维度")
	private String attScopeY;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "打卡范围")
	private Integer attDistance;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "全称")
	private String locationDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "简称")
	private String locationDescAbb;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否可以删除 0：不可以删除 1：可删除")
	private Byte calDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除 0：未删除 1：已删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "初始化门店Id  新增的地址此字段没值")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除时间")
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getAttScopeId() {
		return attScopeId;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setAttScopeId(Integer attScopeId) {
		this.attScopeId = attScopeId;
	}

	/**
	 * @mbggenerated 经度
	 */
	public String getAttScopeX() {
		return attScopeX;
	}

	/**
	 * @mbggenerated 经度
	 */
	public void setAttScopeX(String attScopeX) {
		this.attScopeX = attScopeX;
	}

	/**
	 * @mbggenerated 维度
	 */
	public String getAttScopeY() {
		return attScopeY;
	}

	/**
	 * @mbggenerated 维度
	 */
	public void setAttScopeY(String attScopeY) {
		this.attScopeY = attScopeY;
	}

	/**
	 * @mbggenerated 打卡范围
	 */
	public Integer getAttDistance() {
		return attDistance;
	}

	/**
	 * @mbggenerated 打卡范围
	 */
	public void setAttDistance(Integer attDistance) {
		this.attDistance = attDistance;
	}

	/**
	 * @mbggenerated 全称
	 */
	public String getLocationDesc() {
		return locationDesc;
	}

	/**
	 * @mbggenerated 全称
	 */
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	/**
	 * @mbggenerated 简称
	 */
	public String getLocationDescAbb() {
		return locationDescAbb;
	}

	/**
	 * @mbggenerated 简称
	 */
	public void setLocationDescAbb(String locationDescAbb) {
		this.locationDescAbb = locationDescAbb;
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
	 * @mbggenerated 是否可以删除 0：不可以删除 1：可删除
	 */
	public Byte getCalDel() {
		return calDel;
	}

	/**
	 * @mbggenerated 是否可以删除 0：不可以删除 1：可删除
	 */
	public void setCalDel(Byte calDel) {
		this.calDel = calDel;
	}

	/**
	 * @mbggenerated 是否删除 0：未删除 1：已删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否删除 0：未删除 1：已删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 初始化门店Id  新增的地址此字段没值
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 初始化门店Id  新增的地址此字段没值
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
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
	 * @mbggenerated
	 */
	public ErpFunAttendanceScope() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceScope(Integer shardCityId, Integer attScopeId) {
		super(shardCityId);
		this.attScopeId = attScopeId;
	}
}