package com.myfun.erpWeb.match.vo;

import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "求购匹配列表信息VO")
public class MatchBuyCustPushVo implements Serializable {
	@ApiModelProperty("求购信息")
	private List<ErpFunBuyCustomer> matchInfo;
	@ApiModelProperty("求租列表")
	private List<ErpFunSale> matchList;

	public List<ErpFunBuyCustomer> getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(List<ErpFunBuyCustomer> matchInfo) {
		this.matchInfo = matchInfo;
	}

	public List<ErpFunSale> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<ErpFunSale> matchList) {
		this.matchList = matchList;
	}
}
