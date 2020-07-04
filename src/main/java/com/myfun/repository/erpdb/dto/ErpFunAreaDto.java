package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunArea;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunAreaDto extends ErpFunArea{
    @ApiModelProperty("片区名称，多个，用',’号隔开")
	private String regName;
	private String range;

	private Integer countUser;

	public Integer getCountUser() {
		return countUser;
	}

	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	
}
