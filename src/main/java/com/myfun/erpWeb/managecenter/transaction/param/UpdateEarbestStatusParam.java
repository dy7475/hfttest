package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.GeneralParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateEarbestStatusParam implements EncryParamIfc{
	private boolean isFJD = false;
	@ApiModelProperty("诚意金id")
	private Integer id;
	@ApiModelProperty("诚意金状态 0.撤销审核，1.审核，2.作废")
	private Byte earbestStatus;
	@ApiModelProperty(hidden = true)
	private GeneralParam generalParam;

	private String currentUserName;

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

	public Byte getEarbestStatus() {
		return earbestStatus;
	}

	public void setEarbestStatus(Byte earbestStatus) {
		this.earbestStatus = earbestStatus;
	}

	public GeneralParam getGeneralParam() {
		return generalParam;
	}

	public void setGeneralParam(GeneralParam generalParam) {
		this.generalParam = generalParam;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
}
