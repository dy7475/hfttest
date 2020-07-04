package com.myfun.erpWeb.houseBidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(description = "获取房源库存Vo")
public class HousePubFlagAllDto  implements Serializable {
	@ApiModelProperty("推广数")
	private Integer shelfNumBer;
	@ApiModelProperty("上架数")
	private Integer extensionNumber;
	@ApiModelProperty("房源条数")
	private Integer houseNumber;

	public Integer getShelfNumBer() {
		return shelfNumBer;
	}

	public void setShelfNumBer(Integer shelfNumBer) {
		this.shelfNumBer = shelfNumBer;
	}

	public Integer getExtensionNumber() {
		return extensionNumber;
	}

	public void setExtensionNumber(Integer extensionNumber) {
		this.extensionNumber = extensionNumber;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
}
