package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author 蔡春林
 * @Date 2019/11/23 0023 下午 3:20
 **/
@ApiModel
public class SaveEntrustProtocolParam implements EncryParamIfc {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "委托Id")
    @NotNull(message = "委托Id不能为null！")
    private Integer entrustId;
    @ApiModelProperty(value = "签名图片")
    @NotNull(message = "签名图片不能为null！")
    private String signaturePic;
    @ApiModelProperty(value = "当前业主Id")
    @NotNull(message = "业主Id不能为null！")
    private Integer currentOwerId;
    @ApiModelProperty(value = "城市Id")
    @NotNull(message = "城市Id不能为null！")
    private Integer cityId;

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    public String getSignaturePic() {
        return signaturePic;
    }

    public void setSignaturePic(String signaturePic) {
        this.signaturePic = signaturePic;
    }

    public Integer getCurrentOwerId() {
        return currentOwerId;
    }

    public void setCurrentOwerId(Integer currentOwerId) {
        this.currentOwerId = currentOwerId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
