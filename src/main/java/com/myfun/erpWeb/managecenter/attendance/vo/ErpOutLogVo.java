package com.myfun.erpWeb.managecenter.attendance.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpOutLogDto;

import io.swagger.annotations.ApiModelProperty;

public class ErpOutLogVo {

	@ApiModelProperty(value = "外出统计列表")
	private List<ErpOutLogDto> outLogVo;

	public List<ErpOutLogDto> getOutLogVo() {
		return outLogVo;
	}

	public void setOutLogVo(List<ErpOutLogDto> outLogVo) {
		this.outLogVo = outLogVo;
	}
	
}
