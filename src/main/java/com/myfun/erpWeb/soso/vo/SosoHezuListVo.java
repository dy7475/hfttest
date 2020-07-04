package com.myfun.erpWeb.soso.vo;

import com.myfun.repository.searchdb.dto.SearchHeZuDataInfoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取搜搜合租列表VO")
public class SosoHezuListVo implements Serializable {
	@ApiModelProperty("获取搜搜合租列表")
	private List<SearchHeZuDataInfoDto> resultList;

	public List<SearchHeZuDataInfoDto> getResultList() {
		return resultList;
	}

	public void setResultList(List<SearchHeZuDataInfoDto> resultList) {
		this.resultList = resultList;
	}
}
