package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author 蔡春林
 * @Date 2019/11/28 0028 下午 2:42
 **/
public class GetHouseEntrustInfoParam implements EncryParamIfc {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "查询历史委托详情 委托Id")
    @NotNull(message = "委托Id不能为null！")
    private Integer entrustId;

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
}
