package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminYoujiaReserve implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated agency-youjia_user的id
	 */
	private Integer youjiaUserId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 预约看房人姓名
	 */
	private String reserveName;
	/**
	 * @mbggenerated 预约看房人电话
	 */
	private String reservePhone;
	/**
	 * @mbggenerated 预约时间
	 */
	private Date reserveTime;
	/**
	 * @mbggenerated 备注
	 */
	private String note;
	/**
	 * @mbggenerated
	 */
	private Byte reserveFrom;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Byte isDk;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
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
	public Integer getYoujiaUserId() {
		return youjiaUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setYoujiaUserId(Integer youjiaUserId) {
		this.youjiaUserId = youjiaUserId;
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
	public String getReserveName() {
		return reserveName;
	}

	/**
	 * @mbggenerated
	 */
	public void setReserveName(String reserveName) {
		this.reserveName = reserveName == null ? null : reserveName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getReservePhone() {
		return reservePhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setReservePhone(String reservePhone) {
		this.reservePhone = reservePhone == null ? null : reservePhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getReserveTime() {
		return reserveTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @mbggenerated
	 */
	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getReserveFrom() {
		return reserveFrom;
	}

	/**
	 * @mbggenerated
	 */
	public void setReserveFrom(Byte reserveFrom) {
		this.reserveFrom = reserveFrom;
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
	public Byte getIsDk() {
		return isDk;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsDk(Byte isDk) {
		this.isDk = isDk;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
}