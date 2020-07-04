package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人中心提醒顾问联系用户
 * 请求参数封装
 * create by 程二狗 on 2018/11/22 0022
 */
@ApiModel
public class RemindConsultantParam implements EncryParamIfc {
    @ApiModelProperty("0=客户咨询软件费用 1=客户咨询微店费用 2=客户咨询精英版费用")
    private String isOTOweixin;

    public String getIsOTOweixin() {
        return isOTOweixin;
    }

    public void setIsOTOweixin(String isOTOweixin) {
        this.isOTOweixin = isOTOweixin;
    }
}
