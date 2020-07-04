package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.myfun.erpWeb.managecenter.transaction.vo.HouseBriefInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.RuntimeStepVO;
import com.myfun.repository.erpdb.po.ErpFunDeal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunDealExtVO extends ErpFunDeal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "是否是分成人")
    private Boolean profitPerson;
	
	@ApiModelProperty(value = "签约人头像")
    private String signUserPhoto;
	
	@ApiModelProperty(value = "业主实收")
	private BigDecimal ownerActualReceiptCapital;
	
	@ApiModelProperty(value = "业主应收")
	private BigDecimal ownerReceivable;
	
	@ApiModelProperty(value = "客户实收")
	private BigDecimal custActualReceiptCapital;
	
	@ApiModelProperty(value = "客户应收")
	private BigDecimal custReceivable;
	
	@ApiModelProperty(value = "房源信息")
	private HouseBriefInfoVO houseInfo;
	
	@ApiModelProperty(value = "宽列表权证流程列表")
	private List<RuntimeStepVO> runtimeStepVOList;

    public Boolean getProfitPerson() {
		return profitPerson;
	}

	public void setProfitPerson(Boolean profitPerson) {
		this.profitPerson = profitPerson;
	}

	public String getSignUserPhoto() {
		return signUserPhoto;
	}

	public void setSignUserPhoto(String signUserPhoto) {
		this.signUserPhoto = signUserPhoto;
	}

	public BigDecimal getOwnerActualReceiptCapital() {
		return ownerActualReceiptCapital;
	}

	public void setOwnerActualReceiptCapital(BigDecimal ownerActualReceiptCapital) {
		this.ownerActualReceiptCapital = ownerActualReceiptCapital;
	}

	public BigDecimal getOwnerReceivable() {
		return ownerReceivable;
	}

	public void setOwnerReceivable(BigDecimal ownerReceivable) {
		this.ownerReceivable = ownerReceivable;
	}

	public BigDecimal getCustActualReceiptCapital() {
		return custActualReceiptCapital;
	}

	public void setCustActualReceiptCapital(BigDecimal custActualReceiptCapital) {
		this.custActualReceiptCapital = custActualReceiptCapital;
	}

	public BigDecimal getCustReceivable() {
		return custReceivable;
	}

	public void setCustReceivable(BigDecimal custReceivable) {
		this.custReceivable = custReceivable;
	}

	public HouseBriefInfoVO getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseBriefInfoVO houseInfo) {
		this.houseInfo = houseInfo;
	}

	public List<RuntimeStepVO> getRuntimeStepVOList() {
		return runtimeStepVOList;
	}

	public void setRuntimeStepVOList(List<RuntimeStepVO> runtimeStepVOList) {
		this.runtimeStepVOList = runtimeStepVOList;
	}
}