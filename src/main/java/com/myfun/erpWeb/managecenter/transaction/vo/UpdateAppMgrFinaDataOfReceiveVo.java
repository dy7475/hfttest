package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/3/19
 */
public class UpdateAppMgrFinaDataOfReceiveVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("财务ID")
    private String pfId;

    public String getPfId() {
        return pfId;
    }

    public void setPfId(String pfId) {
        this.pfId = pfId;
    }
}