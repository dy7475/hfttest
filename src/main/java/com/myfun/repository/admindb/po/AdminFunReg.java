package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunReg implements Serializable {

	/**
	 * @mbggenerated 区域ID
	 */
	private Integer regId;
	/**
	 * @mbggenerated 城市ID
	 */
	private Short cityId;
	/**
	 * @mbggenerated 行政区名称
	 */
	private String regName;
	/**
	 * @mbggenerated
	 */
	private Byte seqNo;
	/**
	 * @mbggenerated 是否是主城区，1是、0否
	 */
	private Boolean mainReg;
	/**
	 * @mbggenerated
	 */
	private Integer fid;
	/**
	 * @mbggenerated 纬度
	 */
	private String positionX;
	/**
	 * @mbggenerated 经度
	 */
	private String positionY;
	/**
	 * @mbggenerated 是否有效 0=无效 1=有效
	 */
	private Byte vertifyFlag;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public String getRegName() {
		return regName;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegName(String regName) {
		this.regName = regName == null ? null : regName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeqNo(Byte seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getMainReg() {
		return mainReg;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainReg(Boolean mainReg) {
		this.mainReg = mainReg;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFid() {
		return fid;
	}

	/**
	 * @mbggenerated
	 */
	public void setFid(Integer fid) {
		this.fid = fid;
	}

	/**
	 * @mbggenerated
	 */
	public String getPositionX() {
		return positionX;
	}

	/**
	 * @mbggenerated
	 */
	public void setPositionX(String positionX) {
		this.positionX = positionX == null ? null : positionX.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPositionY() {
		return positionY;
	}

	/**
	 * @mbggenerated
	 */
	public void setPositionY(String positionY) {
		this.positionY = positionY == null ? null : positionY.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getVertifyFlag() {
		return vertifyFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setVertifyFlag(Byte vertifyFlag) {
		this.vertifyFlag = vertifyFlag;
	}
}