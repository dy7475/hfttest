package com.myfun.erpWeb.managecenter.transaction.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class MatchInnerDealListVo extends BaseListResultVo {
	@ApiModelProperty(value = "")
	private List<ErpFunDeal> list;

	public MatchInnerDealListVo(PageInfo pageInfo) {
		this.setPageNum(pageInfo.getPageNum());
		this.setPages(pageInfo.getPages());
		this.setPageSize(pageInfo.getPageSize());
		this.setTotal(pageInfo.getTotal());
		this.setList(pageInfo.getList());
	}

	public MatchInnerDealListVo() {
	}

	public List<ErpFunDeal> getList() {
		return list;
	}

	public void setList(List<ErpFunDeal> list) {
		this.list = list;
	}
}
