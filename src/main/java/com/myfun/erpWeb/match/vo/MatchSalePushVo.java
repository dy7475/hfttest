package com.myfun.erpWeb.match.vo;

import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "出售匹配列表信息VO")
public class MatchSalePushVo implements Serializable {
	@ApiModelProperty("出售信息")
	private List<ErpFunSale> matchInfo;
	@ApiModelProperty("求购列表")
	private List<ErpFunBuyCustomer> matchList;

	public List<ErpFunSale> getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(List<ErpFunSale> matchInfo) {
		this.matchInfo = matchInfo;
	}

	public List<ErpFunBuyCustomer> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<ErpFunBuyCustomer> matchList) {
		this.matchList = matchList;
	}
}
