package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2019-03-11 10:15
 */
public class GetLoanBankParam implements EncryParamIfc {
	@ApiModelProperty("银行名称")
	private String bankName;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
