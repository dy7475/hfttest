package com.myfun.erpWeb.managecenter.buildData.vo;

import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunBuildrulequerylimitDto extends ErpFunBuildrulequerylimit {
	@ApiModelProperty("总户数")
	private Integer totalRoom;
	@ApiModelProperty("转售数")
	private Integer changeSale;
	@ApiModelProperty("转租数")
	private Integer changeLease;
	private String timeRange;

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}

	public Integer getTotalRoom() {
		return totalRoom;
	}

	public void setTotalRoom(Integer totalRoom) {
		this.totalRoom = totalRoom;
	}

	public Integer getChangeSale() {
		return changeSale;
	}

	public void setChangeSale(Integer changeSale) {
		this.changeSale = changeSale;
	}

	public Integer getChangeLease() {
		return changeLease;
	}

	public void setChangeLease(Integer changeLease) {
		this.changeLease = changeLease;
	}
}
