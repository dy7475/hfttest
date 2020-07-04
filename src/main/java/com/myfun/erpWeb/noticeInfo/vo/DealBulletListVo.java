package com.myfun.erpWeb.noticeInfo.vo;

import com.myfun.repository.erpdb.dto.DealBulletDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取喜报列表VO")
public class DealBulletListVo implements Serializable {
	@ApiModelProperty("获取喜报列表")
	private List<DealBulletDto> resultList;

	public List<DealBulletDto> getResultList() {
		return resultList;
	}

	public void setResultList(List<DealBulletDto> resultList) {
		this.resultList = resultList;
	}
}
