package com.myfun.erpWeb.managecenter.commission.param;

import java.math.BigDecimal;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年7月30日 上午10:10:53
 * Modified XXX HuangJiang 2019年7月30日
 */
@ApiModel
public class ApplyCashWithdrawalParam implements EncryParamIfc {

	@ApiModelProperty(value = "提现金额")
	private BigDecimal cashWithdrawalMoney;
	@ApiModelProperty(value = "手续费金额")
	private BigDecimal serviceChargeMoney;
	@ApiModelProperty(value="总申请提现金额")
	private BigDecimal totalApplyMoney;
	
	public BigDecimal getTotalApplyMoney() {
	
		return totalApplyMoney;
	}
	public void setTotalApplyMoney(BigDecimal totalApplyMoney) {
	
		this.totalApplyMoney = totalApplyMoney;
	}
	public BigDecimal getCashWithdrawalMoney() {
	
		return cashWithdrawalMoney;
	}
	public void setCashWithdrawalMoney(BigDecimal cashWithdrawalMoney) {
	
		this.cashWithdrawalMoney = cashWithdrawalMoney;
	}
	public BigDecimal getServiceChargeMoney() {
	
		return serviceChargeMoney;
	}
	public void setServiceChargeMoney(BigDecimal serviceChargeMoney) {
	
		this.serviceChargeMoney = serviceChargeMoney;
	}
	
}

