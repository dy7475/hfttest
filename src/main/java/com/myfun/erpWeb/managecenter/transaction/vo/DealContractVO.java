package com.myfun.erpWeb.managecenter.transaction.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DealContractVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("合同id")
	private Integer dealId;
	
	@ApiModelProperty("合同编号")
	private String contractNo;
	
	@ApiModelProperty("负责人")
	private String dealUserName;
	
	@ApiModelProperty("签约人")
	private String signUserName;
	
	@ApiModelProperty("流程类型")
	private String modelName;
	
	@ApiModelProperty("签约时间")
	private String signDate;
	
	@ApiModelProperty("当前步骤")
	private String runstepName;
	
	@ApiModelProperty("楼盘")
	private String buildName;
	
	@ApiModelProperty("户型")
	private Byte houseRoom;
	
	@ApiModelProperty("面积")
	private String houseArea;
	
	@ApiModelProperty("价格")
	private String houseTotalPrice;
	
	@ApiModelProperty("房源id")
	private Integer dealHouseId;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getDealUserName() {
		return dealUserName;
	}

	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	public String getSignUserName() {
		return signUserName;
	}

	public void setSignUserName(String signUserName) {
		this.signUserName = signUserName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getRunstepName() {
		return runstepName;
	}

	public void setRunstepName(String runstepName) {
		this.runstepName = runstepName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Byte getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseTotalPrice() {
		return houseTotalPrice;
	}

	public void setHouseTotalPrice(String houseTotalPrice) {
		this.houseTotalPrice = houseTotalPrice;
	}

	public Integer getDealHouseId() {
		return dealHouseId;
	}

	public void setDealHouseId(Integer dealHouseId) {
		this.dealHouseId = dealHouseId;
	}

}
