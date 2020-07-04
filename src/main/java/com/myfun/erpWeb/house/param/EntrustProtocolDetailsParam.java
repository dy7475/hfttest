package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author 蔡春林
 * @Date 2019/11/23 0023 下午 3:14
 **/

@ApiModel
public class EntrustProtocolDetailsParam implements EncryParamIfc {
    @ApiModelProperty(value = "委托Id")
    @NotNull(message = "委托Id不能为null！")
    private Integer entrustId;
    @ApiModelProperty(value = "城市Id")
    @NotNull(message = "城市Id不能为null！")
    private Integer cityId;
    @ApiModelProperty(value = "业主Id")
    @NotNull(message = "业主Id不能为null！")
    private Integer ownerId;

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
