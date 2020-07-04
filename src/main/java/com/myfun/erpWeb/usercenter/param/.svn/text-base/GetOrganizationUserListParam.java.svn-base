package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author 蔡春林
 * @Date 2020/1/15 0015 下午 5:28
 **/
@ApiModel
public class GetOrganizationUserListParam implements EncryParamIfc {

    @ApiModelProperty("组织Id，多个用，拼接")
    @NotEmpty(message = "组织Id不能为null！")
    private String Organizations;

    public String getOrganizations() {
        return Organizations;
    }

    public void setOrganizations(String organizations) {
        Organizations = organizations;
    }
}
