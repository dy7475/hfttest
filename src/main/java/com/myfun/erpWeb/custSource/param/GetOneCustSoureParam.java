package com.myfun.erpWeb.custSource.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("")
public class GetOneCustSoureParam  implements EncryParamIfc {
    @ApiModelProperty(value="来源ID")
    private Integer custSourceId;

    public Integer getCustSourceId() {
        return custSourceId;
    }

    public void setCustSourceId(Integer custSourceId) {
        this.custSourceId = custSourceId;
    }
}
