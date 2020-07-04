package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpHouseRoofAnis extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer houseId;
	/**
	 * @mbggenerated
	 */
	private String houseNo;
	/**
	 * @mbggenerated
	 */
	private Byte houseType;
	/**
	 * @mbggenerated
	 */
	private String houseRoof;
	/**
	 * @mbggenerated
	 */
	private String houseRoofR;
	/**
	 * @mbggenerated
	 */
	private String houseRoofMinwen;
	/**
	 * @mbggenerated
	 */
	private String houseRoofRMinwen;
	/**
	 * @mbggenerated
	 */
	private Byte roofFlag;
	/**
	 * @mbggenerated
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getHouseId() {
		return houseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo == null ? null : houseNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseType() {
		return houseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseType(Byte houseType) {
		this.houseType = houseType;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseRoof() {
		return houseRoof;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRoof(String houseRoof) {
		this.houseRoof = houseRoof == null ? null : houseRoof.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseRoofR() {
		return houseRoofR;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRoofR(String houseRoofR) {
		this.houseRoofR = houseRoofR == null ? null : houseRoofR.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseRoofMinwen() {
		return houseRoofMinwen;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRoofMinwen(String houseRoofMinwen) {
		this.houseRoofMinwen = houseRoofMinwen == null ? null : houseRoofMinwen.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseRoofRMinwen() {
		return houseRoofRMinwen;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRoofRMinwen(String houseRoofRMinwen) {
		this.houseRoofRMinwen = houseRoofRMinwen == null ? null : houseRoofRMinwen.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRoofFlag() {
		return roofFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoofFlag(Byte roofFlag) {
		this.roofFlag = roofFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpHouseRoofAnis() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpHouseRoofAnis(Integer shardCityId) {
		super(shardCityId);
	}
}