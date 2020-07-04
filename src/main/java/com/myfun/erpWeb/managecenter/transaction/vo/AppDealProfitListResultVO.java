package com.myfun.erpWeb.managecenter.transaction.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppDealProfitListResultVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "业绩列表")
	List<AppDealProfitVO> dealProfitListVO;

	public List<AppDealProfitVO> getDealProfitListVO() {
		return dealProfitListVO;
	}

	public void setDealProfitListVO(List<AppDealProfitVO> dealProfitListVO) {
		this.dealProfitListVO = dealProfitListVO;
	}

	
}
