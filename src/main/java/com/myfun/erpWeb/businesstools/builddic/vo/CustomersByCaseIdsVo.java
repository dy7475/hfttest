package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2019/6/1
 */
public class CustomersByCaseIdsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("客源列表")
    private List<CustomerByCaseIdVo> list;

    public List<CustomerByCaseIdVo> getList() {
        return list;
    }

    public void setList(List<CustomerByCaseIdVo> list) {
        this.list = list;
    }
}