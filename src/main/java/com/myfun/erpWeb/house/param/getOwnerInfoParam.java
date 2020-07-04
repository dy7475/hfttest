package com.myfun.erpWeb.house.param;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author 蔡春林
 * @Date 2019/12/2 0002 下午 5:06
 **/
public class getOwnerInfoParam implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
