package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @desc 设置薪资管理员参数对象
 * @since 2019/11/5
 * @author lcb
 * @param userIdList
 * @return
 */
@ApiModel
public class SetWageManagerParam implements EncryParamIfc {

    @ApiModelProperty(value = "员工Id list")
    private String userids;

    public String getUserids() {
        return userids;
    }

    public void setUserids(String userids) {
        this.userids = userids;
    }
}
