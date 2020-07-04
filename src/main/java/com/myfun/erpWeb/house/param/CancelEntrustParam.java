package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年11月27日 19:05:44
 * Modified XXX HuangJiang 2019年11月27日
 */
public class CancelEntrustParam implements EncryParamIfc {
    
    @ApiModelProperty(value = "委托ID")
    private Integer entrustId;
    
    public Integer getEntrustId() {
        return entrustId;
    }
    
    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
}
