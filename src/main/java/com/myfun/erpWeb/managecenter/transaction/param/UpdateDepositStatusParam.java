package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.GeneralParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateDepositStatusParam implements EncryParamIfc{
	private boolean isFJD = false;
	@ApiModelProperty("定金id")
	private Integer id;
	@ApiModelProperty("定金状态 0.撤销审核，1.审核，2.作废")
	private Byte depositStatus;
	@ApiModelProperty(hidden = true)
	private GeneralParam generalParam;

	public boolean isFJD() {
		return isFJD;
	}

	public void setFJD(boolean FJD) {
		isFJD = FJD;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Byte getDepositStatus() {
		return depositStatus;
	}
	public void setDepositStatus(Byte depositStatus) {
		this.depositStatus = depositStatus;
	}
	public GeneralParam getGeneralParam() {
		return generalParam;
	}
	public void setGeneralParam(GeneralParam generalParam) {
		this.generalParam = generalParam;
	}
	
}
