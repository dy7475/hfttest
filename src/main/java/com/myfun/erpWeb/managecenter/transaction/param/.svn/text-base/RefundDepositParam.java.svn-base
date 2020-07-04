package com.myfun.erpWeb.managecenter.transaction.param;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.myfun.erpWeb.managecenter.transaction.vo.CustInfoVO;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.GeneralParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RefundDepositParam implements EncryParamIfc{

	private boolean isFJD = false;
	@ApiModelProperty("定金id")
	private Integer id;
	@ApiModelProperty("退款金额")
	private BigDecimal refundMoney;
	@ApiModelProperty("备注")
	private String depositRemark;
	@ApiModelProperty(hidden=true)
	private GeneralParam generalParam;
	@ApiModelProperty(hidden=true)
	private ErpFunDeposit deposit;
	@ApiModelProperty(hidden = true)
	private CustInfoVO custInfo;


	public boolean isFJD() {
		return isFJD;
	}

	public void setFJD(boolean FJD) {
		isFJD = FJD;
	}

	public CustInfoVO getCustInfo() {
		return custInfo;
	}
	public void setCustInfo(CustInfoVO custInfo) {
		this.custInfo = custInfo;
	}
	public ErpFunDeposit getDeposit() {
		return deposit;
	}
	public void setDeposit(ErpFunDeposit deposit) {
		this.deposit = deposit;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getRefundMoney() {
		return refundMoney;
	}
	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}
	public String getDepositRemark() {
		return depositRemark;
	}
	public void setDepositRemark(String depositRemark) {
		this.depositRemark = depositRemark;
	}
	public GeneralParam getGeneralParam() {
		return generalParam;
	}
	public void setGeneralParam(GeneralParam generalParam) {
		this.generalParam = generalParam;
	}
}
