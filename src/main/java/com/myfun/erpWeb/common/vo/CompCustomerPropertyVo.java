package com.myfun.erpWeb.common.vo;

import com.myfun.repository.admindb.po.AdminFunCompSkin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("公司自定义冠名")
public class CompCustomerPropertyVo {

	@ApiModelProperty(value= "返回列表值")
	private List<AdminFunCompSkin> propertyList;

	public List<AdminFunCompSkin> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<AdminFunCompSkin> propertyList) {
		this.propertyList = propertyList;
	}
}
