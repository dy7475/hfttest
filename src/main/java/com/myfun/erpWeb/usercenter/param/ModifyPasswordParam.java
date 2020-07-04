package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2020/2/5
 */
public class ModifyPasswordParam implements EncryParamIfc {

    @ApiModelProperty("需要修改密码的用户")
    private Integer needModifyUserId;

    public Integer getNeedModifyUserId() {
        return needModifyUserId;
    }

    public void setNeedModifyUserId(Integer needModifyUserId) {
        this.needModifyUserId = needModifyUserId;
    }
}