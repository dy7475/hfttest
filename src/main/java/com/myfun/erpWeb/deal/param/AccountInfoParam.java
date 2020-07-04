package com.myfun.erpWeb.deal.param;

import com.myfun.repository.admindb.po.AdminSsqAccountInfo;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class AccountInfoParam extends AdminSsqAccountInfo implements EncryParamIfc {
	
    @ApiModelProperty(hidden = true)
    private String account;

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }
}
