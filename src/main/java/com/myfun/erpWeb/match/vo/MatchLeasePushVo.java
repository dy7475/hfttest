package com.myfun.erpWeb.match.vo;

import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "出租匹配列表信息VO")
public class MatchLeasePushVo implements Serializable {
	@ApiModelProperty("出租信息")
	private List<ErpFunLease> matchInfo;
	@ApiModelProperty("求租列表")
	private List<ErpFunRentCustomer> matchList;

	public List<ErpFunLease> getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(List<ErpFunLease> matchInfo) {
		this.matchInfo = matchInfo;
	}

	public List<ErpFunRentCustomer> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<ErpFunRentCustomer> matchList) {
		this.matchList = matchList;
	}
}
