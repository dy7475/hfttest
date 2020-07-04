package com.myfun.erpWeb.managecenter.transaction.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 房源简要信息
 */
@ApiModel
public class HouseBriefInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty(value ="房源id")
	private Integer houseId;
	
	@ApiModelProperty(value ="栋")
	private String houseRoof;
	
	@ApiModelProperty(value ="单元")
	private String houseUnit;
	
	@ApiModelProperty(value = "房号")
	private String houseNum;
	
	@ApiModelProperty(value = "几房/几室")
	private Byte houseRoom;

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getHouseRoof() {
		return houseRoof;
	}

	public void setHouseRoof(String houseRoof) {
		this.houseRoof = houseRoof;
	}

	public String getHouseUnit() {
		return houseUnit;
	}

	public void setHouseUnit(String houseUnit) {
		this.houseUnit = houseUnit;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public Byte getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}
}
