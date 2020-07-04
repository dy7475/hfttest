package com.myfun.erpWeb.managecenter.financialLoan.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FinanceInfoPhotoParam implements EncryParamIfc {
	@ApiModelProperty(value = "金融ID")
	private Integer financeId;
	@ApiModelProperty(value = "图片类型")
	private Integer photoType;

	public Integer getFinanceId() {
		return financeId;
	}

	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}

	public Integer getPhotoType() {
		return photoType;
	}

	public void setPhotoType(Integer photoType) {
		this.photoType = photoType;
	}
}
