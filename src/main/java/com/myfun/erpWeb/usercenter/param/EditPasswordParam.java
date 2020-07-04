package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EditPasswordParam implements EncryParamIfc {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "旧密码 修改密码用")
    private String oldPwd;

    @ApiModelProperty(value = "新密码 修改密码用")
    private String newPwd;

    @ApiModelProperty(value = "确认密码 修改密码用")
    private String confirmPwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }


}
