package com.myfun.erpWeb.managecenter.constract.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import com.myfun.repository.erpdb.po.ErpFunDealRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class HandProfitLogListVo extends BaseListResultVo {
	@ApiModelProperty(value = "返回列表")
	List<ErpFunDealRecord> list;

	public HandProfitLogListVo(PageInfo pageInfo) {
		this.setPageNum(pageInfo.getPageNum());
		this.setPages(pageInfo.getPages());
		this.setPageSize(pageInfo.getPageSize());
		this.setTotal(pageInfo.getTotal());
		this.setList(pageInfo.getList());
	}

	public List<ErpFunDealRecord> getList() {
		return list;
	}

	public void setList(List<ErpFunDealRecord> list) {
		this.list = list;
	}
}
