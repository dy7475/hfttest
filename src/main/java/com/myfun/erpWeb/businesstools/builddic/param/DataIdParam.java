package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2020/2/7
 */
public class DataIdParam implements EncryParamIfc {

    @ApiModelProperty(value = "查询什么范围下的数据, 例如查街道城市就传街道省份ID")
    private Integer dataId;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }
}