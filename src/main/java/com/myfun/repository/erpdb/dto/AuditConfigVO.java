package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class AuditConfigVO {

	@ApiModelProperty(value = "配置数据列")
	private List<AuditConfigTypeVO> list;

	public List<AuditConfigTypeVO> getList() {
		return list;
	}

	public void setList(List<AuditConfigTypeVO> list) {
		this.list = list;
	}
}
