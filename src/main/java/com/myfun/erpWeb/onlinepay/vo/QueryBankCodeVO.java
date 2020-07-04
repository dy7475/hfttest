package com.myfun.erpWeb.onlinepay.vo;

import com.myfun.repository.admindb.po.AdminBankDetailInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class QueryBankCodeVO implements Serializable {

    @ApiModelProperty("查询结果 如果此数据为空就提示用户重新填写开户行或者联系客户后台查询")
    private AdminBankDetailInfo adminBankDetailInfo;

    public AdminBankDetailInfo getAdminBankDetailInfo() {
        return adminBankDetailInfo;
    }

    public void setAdminBankDetailInfo(AdminBankDetailInfo adminBankDetailInfo) {
        this.adminBankDetailInfo = adminBankDetailInfo;
    }
}
