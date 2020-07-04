package com.myfun.erpWeb.managecenter.constract.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/9/26
 */
@ApiModel
public class CanSeeFunDealPhotoVo {

    @ApiModelProperty("是否可以查看合同附件 0=不可以 1=可以")
    private Integer canSee;

    public Integer getCanSee() {
        return canSee;
    }

    public void setCanSee(Integer canSee) {
        this.canSee = canSee;
    }
}