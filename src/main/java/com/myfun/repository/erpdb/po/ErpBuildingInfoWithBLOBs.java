package com.myfun.repository.erpdb.po;

import java.io.Serializable;

public class ErpBuildingInfoWithBLOBs extends ErpBuildingInfo implements Serializable {

	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String ffloor;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String fstruct;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String fequipments;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String ftraffic;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String finner;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getFfloor() {
		return ffloor;
	}

	/**
	 * @mbggenerated
	 */
	public void setFfloor(String ffloor) {
		this.ffloor = ffloor == null ? null : ffloor.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFstruct() {
		return fstruct;
	}

	/**
	 * @mbggenerated
	 */
	public void setFstruct(String fstruct) {
		this.fstruct = fstruct == null ? null : fstruct.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFequipments() {
		return fequipments;
	}

	/**
	 * @mbggenerated
	 */
	public void setFequipments(String fequipments) {
		this.fequipments = fequipments == null ? null : fequipments.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFtraffic() {
		return ftraffic;
	}

	/**
	 * @mbggenerated
	 */
	public void setFtraffic(String ftraffic) {
		this.ftraffic = ftraffic == null ? null : ftraffic.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFinner() {
		return finner;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinner(String finner) {
		this.finner = finner == null ? null : finner.trim();
	}
}