package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpSalePeopleRelative extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源id")
	private Integer saleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "相关人类型，1=登记人 2=维护人 3=钥匙人  4=房堪人  5=委托人     6=议价人    7=楼盘责任人")
	private Integer peopleType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "相关人对应的用户id")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "相关人对应的用户名")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "电话")
	private String userMobile;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除标记 0有效 1已删除")
	private Integer delFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除时间")
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店名称")
	private String deptName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托类型 1=限时  0=独家 2包租 3普通")
	private Integer entrustType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组名称")
	private String grName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托过期时间")
	private Date dueTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进ID")
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String organizationName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 房源id
	 */
	public Integer getSaleId() {
		return saleId;
	}

	/**
	 * @mbggenerated 房源id
	 */
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	/**
	 * @mbggenerated 相关人类型，1=登记人 2=维护人 3=钥匙人  4=房堪人  5=委托人     6=议价人    7=楼盘责任人
	 */
	public Integer getPeopleType() {
		return peopleType;
	}

	/**
	 * @mbggenerated 相关人类型，1=登记人 2=维护人 3=钥匙人  4=房堪人  5=委托人     6=议价人    7=楼盘责任人
	 */
	public void setPeopleType(Integer peopleType) {
		this.peopleType = peopleType;
	}

	/**
	 * @mbggenerated 相关人对应的用户id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 相关人对应的用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 相关人对应的用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 相关人对应的用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @mbggenerated 修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 删除标记 0有效 1已删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated 删除标记 0有效 1已删除
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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
	 * @mbggenerated 门店名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated 门店名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @mbggenerated 委托类型 1=限时  0=独家 2包租 3普通
	 */
	public Integer getEntrustType() {
		return entrustType;
	}

	/**
	 * @mbggenerated 委托类型 1=限时  0=独家 2包租 3普通
	 */
	public void setEntrustType(Integer entrustType) {
		this.entrustType = entrustType;
	}

	/**
	 * @mbggenerated 分组名称
	 */
	public String getGrName() {
		return grName;
	}

	/**
	 * @mbggenerated 分组名称
	 */
	public void setGrName(String grName) {
		this.grName = grName;
	}

	/**
	 * @mbggenerated 委托过期时间
	 */
	public Date getDueTime() {
		return dueTime;
	}

	/**
	 * @mbggenerated 委托过期时间
	 */
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	/**
	 * @mbggenerated 跟进ID
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated 跟进ID
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
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
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @mbggenerated
	 */
	public ErpSalePeopleRelative() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpSalePeopleRelative(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}