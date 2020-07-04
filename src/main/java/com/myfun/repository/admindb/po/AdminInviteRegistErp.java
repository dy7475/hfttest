package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminInviteRegistErp implements Serializable {

	/**
	 * @mbggenerated 主键自增ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 分享后的唯一ID
	 */
	private String uuid;
	/**
	 * @mbggenerated 用户名
	 */
	private String userName;
	/**
	 * @mbggenerated 用户性别，0=女 1=男
	 */
	private Byte userSex;
	/**
	 * @mbggenerated 用户手机号
	 */
	private String userMobile;
	/**
	 * @mbggenerated 用户角色
	 */
	private String roleId;
	/**
	 * @mbggenerated 门店ID
	 */
	private String compNo;
	/**
	 * @mbggenerated 分组ID
	 */
	private Integer grId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 注册成功时间
	 */
	private Date registTime;
	/**
	 * @mbggenerated 注册状态 0=刚邀请 1=注册成功
	 */
	private Byte registStatus;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 门店编号
	 */
	private String deptNo;
	/**
	 * @mbggenerated 邀请人用户名
	 */
	private String createUserName;
	/**
	 * @mbggenerated 邀请人用户ID
	 */
	private Integer createUserId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @mbggenerated
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUserSex() {
		return userSex;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	/**
	 * @mbggenerated
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo == null ? null : compNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRegistTime() {
		return registTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRegistStatus() {
		return registStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegistStatus(Byte registStatus) {
		this.registStatus = registStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo == null ? null : deptNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
}