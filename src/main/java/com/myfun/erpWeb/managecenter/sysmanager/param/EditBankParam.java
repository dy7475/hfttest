package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2019-03-08 18:34
 */
public class EditBankParam implements EncryParamIfc {
	@ApiModelProperty("银行列表")
	private String bankList;

	public String getBankList() {
		return bankList;
	}

	public void setBankList(String bankList) {
		this.bankList = bankList;
	}
}
