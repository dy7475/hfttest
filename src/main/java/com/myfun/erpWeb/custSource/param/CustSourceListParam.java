package com.myfun.erpWeb.custSource.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("客源来源列表")
public class CustSourceListParam  extends AbstractEncryParam {
    @ApiModelProperty("名称或编码")
    private String keyWords;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
