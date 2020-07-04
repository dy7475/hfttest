package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ModifyPwdParam implements EncryParamIfc {

    @ApiModelProperty("原密码")
    private String oldLoginPassword;
    @ApiModelProperty("新密码")
    private String loginPassword;

    public String getOldLoginPassword() {
        return oldLoginPassword;
    }

    public void setOldLoginPassword(String oldLoginPassword) {
        this.oldLoginPassword = oldLoginPassword;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
