package com.myfun.erpWeb.managecenter.transaction.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ContractTaskListOfTransactVo extends BaseListResultVo {

	@ApiModelProperty(value = "列表")
	private List<DealContractDto> list;

	public ContractTaskListOfTransactVo(PageInfo pageInfo) {
		this.setPageNum(pageInfo.getPageNum());
		this.setPages(pageInfo.getPages());
		this.setPageSize(pageInfo.getPageSize());
		this.setTotal(pageInfo.getTotal());
		this.setList(pageInfo.getList());
	}

	public ContractTaskListOfTransactVo() {
	}

	public List<DealContractDto> getList() {
		return list;
	}

	public void setList(List<DealContractDto> list) {
		this.list = list;
	}
}
