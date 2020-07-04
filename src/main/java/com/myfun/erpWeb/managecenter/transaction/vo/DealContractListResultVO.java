package com.myfun.erpWeb.managecenter.transaction.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel
public class DealContractListResultVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	List<DealContractVO> dealContractListVO;

	public List<DealContractVO> getDealContractListVO() {
		return dealContractListVO;
	}

	public void setDealContractListVO(List<DealContractVO> dealContractListVO) {
		this.dealContractListVO = dealContractListVO;
	}

	
}
