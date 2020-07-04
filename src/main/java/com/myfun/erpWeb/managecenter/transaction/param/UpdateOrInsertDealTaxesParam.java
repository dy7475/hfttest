package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateOrInsertDealTaxesParam implements EncryParamIfc{

	@ApiModelProperty(value = "合同id")
	private Integer dealId;
	@ApiModelProperty(value = "支付方式")
	private Integer payType;
	@ApiModelProperty(value = "json数组 例：\"taxesJson\": \"[{\\\"checkFlag\\\":\\\"1\\\",\\\"compId\\\":\\\"12001\\\",\\\"createTime\\\":\\\"2019-03-14 14:12:11.7790000\\\",\\\"dealId\\\":\\\"51109\\\",\\\"id\\\":\\\"6543\\\",\\\"name\\\":\\\"摇号费\\\",\\\"payType\\\":\\\"0\\\",\\\"price\\\":\\\"20 元\\\",\\\"taxesFatherId\\\":\\\"7292\\\",\\\"taxesFatherName\\\":\\\"测试\\\",\\\"taxesFixedAmount\\\":\\\"20 元\\\",\\\"taxesFixedUnit\\\":\\\"1\\\",\\\"taxesSubId\\\":\\\"28052\\\",\\\"taxesSubName\\\":\\\"摇号费\\\",\\\"taxesType\\\":\\\"0\\\",\\\"updateUser\\\":\\\"20122922\\\",\\\"updateUserName\\\":\\\"尹振兴\\\"}]\"")
	private String taxesJson;
	@ApiModelProperty(value = "条数")
	private Integer count;
	@ApiModelProperty(value = "城市id")
	private Integer cityId;
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	@ApiModelProperty(value = "部门id")
	private Integer deptId;
	@ApiModelProperty(value = "用户名")
	private String userName;
	@ApiModelProperty(value = "客户姓名")
	private String currUserName;
	@ApiModelProperty(value = "合同编号")
    private String contractNo;
	@ApiModelProperty(value = "过户代办费")
    private String transferAgencyFee;
	@ApiModelProperty(value = "买方（卖方联系人）")
    private String ownerName;
	@ApiModelProperty(value = " 买方（卖方联系电话）")
    private String callPhone;
	@ApiModelProperty(value = "客户经济人所在门店")
    private String custDeptName;
	@ApiModelProperty(value = "面积")
    private String area;
	@ApiModelProperty(value = "客户经理：名称-电话")
    private String custUsername;
	@ApiModelProperty(value = "缴税评估价")
    private String taxEvaluationPrice;
	@ApiModelProperty(value = "物业地址")
    private String sellAddress;
	@ApiModelProperty(value = "备注")
    private String remarks;
	@ApiModelProperty(value = "费用总计")
    private String flatFeeAmount;
	@ApiModelProperty(value = "已交定金")
    private String havePaidDeposit;
	@ApiModelProperty(value = "买方或卖方佣金")
    private String unilateralCommission;
	@ApiModelProperty(value = "买方或卖方欠费")
    private String unilateralArrears;
	@ApiModelProperty(value = "补交金额")
    private String payAmount;
	@ApiModelProperty(value = "退款金额")
    private String refund;
	@ApiModelProperty(value = "财务编号")
    private String financialNumber;
	@ApiModelProperty(value = "填表人")
	private String fillUserName;
	@ApiModelProperty(value = "审核人")
    private String auditUserName;
	@ApiModelProperty(value = "贷款金额")
    private String loanMoney;
	@ApiModelProperty(value = "佣金")
    private String commssion;
	@ApiModelProperty(value = "0 买方税费打印单1卖方税费打印单")
    private Byte feeType;
	@ApiModelProperty(value = "按揭代办费")
    private String mortgageAgencyFee;
	@ApiModelProperty(value = "售方税费")
    private String saleTax;
	@ApiModelProperty(value = "户口押金")
    private String accountDeposit;
	@ApiModelProperty(value = "买方或卖方押金")
	private String unilateralDeposit;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCurrUserName() {
		return currUserName;
	}

	public void setCurrUserName(String currUserName) {
		this.currUserName = currUserName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getTaxesJson() {
		return taxesJson;
	}

	public void setTaxesJson(String taxesJson) {
		this.taxesJson = taxesJson;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getTransferAgencyFee() {
		return transferAgencyFee;
	}

	public void setTransferAgencyFee(String transferAgencyFee) {
		this.transferAgencyFee = transferAgencyFee;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCallPhone() {
		return callPhone;
	}

	public void setCallPhone(String callPhone) {
		this.callPhone = callPhone;
	}

	public String getCustDeptName() {
		return custDeptName;
	}

	public void setCustDeptName(String custDeptName) {
		this.custDeptName = custDeptName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCustUsername() {
		return custUsername;
	}

	public void setCustUsername(String custUsername) {
		this.custUsername = custUsername;
	}

	public String getTaxEvaluationPrice() {
		return taxEvaluationPrice;
	}

	public void setTaxEvaluationPrice(String taxEvaluationPrice) {
		this.taxEvaluationPrice = taxEvaluationPrice;
	}

	public String getSellAddress() {
		return sellAddress;
	}

	public void setSellAddress(String sellAddress) {
		this.sellAddress = sellAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFlatFeeAmount() {
		return flatFeeAmount;
	}

	public void setFlatFeeAmount(String flatFeeAmount) {
		this.flatFeeAmount = flatFeeAmount;
	}

	public String getHavePaidDeposit() {
		return havePaidDeposit;
	}

	public void setHavePaidDeposit(String havePaidDeposit) {
		this.havePaidDeposit = havePaidDeposit;
	}

	public String getUnilateralCommission() {
		return unilateralCommission;
	}

	public void setUnilateralCommission(String unilateralCommission) {
		this.unilateralCommission = unilateralCommission;
	}

	public String getUnilateralArrears() {
		return unilateralArrears;
	}

	public void setUnilateralArrears(String unilateralArrears) {
		this.unilateralArrears = unilateralArrears;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public String getFinancialNumber() {
		return financialNumber;
	}

	public void setFinancialNumber(String financialNumber) {
		this.financialNumber = financialNumber;
	}

	public String getFillUserName() {
		return fillUserName;
	}

	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public String getLoanMoney() {
		return loanMoney;
	}

	public void setLoanMoney(String loanMoney) {
		this.loanMoney = loanMoney;
	}

	public String getCommssion() {
		return commssion;
	}

	public void setCommssion(String commssion) {
		this.commssion = commssion;
	}

	public Byte getFeeType() {
		return feeType;
	}

	public void setFeeType(Byte feeType) {
		this.feeType = feeType;
	}

	public String getMortgageAgencyFee() {
		return mortgageAgencyFee;
	}

	public void setMortgageAgencyFee(String mortgageAgencyFee) {
		this.mortgageAgencyFee = mortgageAgencyFee;
	}

	public String getSaleTax() {
		return saleTax;
	}

	public void setSaleTax(String saleTax) {
		this.saleTax = saleTax;
	}

	public String getAccountDeposit() {
		return accountDeposit;
	}

	public void setAccountDeposit(String accountDeposit) {
		this.accountDeposit = accountDeposit;
	}

	public String getUnilateralDeposit() {
		return unilateralDeposit;
	}

	public void setUnilateralDeposit(String unilateralDeposit) {
		this.unilateralDeposit = unilateralDeposit;
	}
	
}
