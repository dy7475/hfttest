package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2020/2/6
 */
public class StreetListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("街道列表")
    private List<CustomerByCaseIdVo> list;



}