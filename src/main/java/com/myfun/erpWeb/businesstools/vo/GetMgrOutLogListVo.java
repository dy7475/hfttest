package com.myfun.erpWeb.businesstools.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpOutLogDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetMgrOutLogListVo {

	@ApiModelProperty(value = "外出日志列表")
	private List<ErpOutLogDto> list;

	public List<ErpOutLogDto> getList() {
		return list;
	}

	public void setList(List<ErpOutLogDto> list) {
		this.list = list;
	}
}