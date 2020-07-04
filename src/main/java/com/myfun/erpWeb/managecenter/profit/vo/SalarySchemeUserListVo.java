package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.dto.ErpWagetypeUserRelativeDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取薪资方案分配的员工列表VO")
public class SalarySchemeUserListVo  implements Serializable {
	@ApiModelProperty("薪资方案列表")
	private List<ErpWagetypeUserRelativeDto> resultList;

	public List<ErpWagetypeUserRelativeDto> getResultList() {
		return resultList;
	}

	public void setResultList(List<ErpWagetypeUserRelativeDto> resultList) {
		this.resultList = resultList;
	}
}
