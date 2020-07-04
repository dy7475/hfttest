package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunDealTaxesRecord extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键ID
     */
    private Integer taxesRecordId;

    /**
     *
     * @mbggenerated
    合同编号
     */
    private String contractNo;

    /**
     *
     * @mbggenerated
    过户代办费
     */
    private String transferAgencyFee;

    /**
     *
     * @mbggenerated
    买方（卖方联系人）
     */
    private String ownerName;

    /**
     *
     * @mbggenerated
    买方（卖方联系电话）
     */
    private String callPhone;

    /**
     *
     * @mbggenerated
    客户经济人所在门店
     */
    private String custDeptName;

    /**
     *
     * @mbggenerated
    面积
     */
    private String area;

    /**
     *
     * @mbggenerated
    客户经理：名称-电话
     */
    private String custUsername;

    /**
     *
     * @mbggenerated
    缴税评估价
     */
    private String taxEvaluationPrice;

    /**
     *
     * @mbggenerated
    物业地址
     */
    private String sellAddress;

    /**
     *
     * @mbggenerated
    备注
     */
    private String remarks;

    /**
     *
     * @mbggenerated
    费用总计
     */
    private String flatFeeAmount;

    /**
     *
     * @mbggenerated
    已交定金
     */
    private String havePaidDeposit;

    /**
     *
     * @mbggenerated
    买方或卖方佣金
     */
    private String unilateralCommission;

    /**
     *
     * @mbggenerated
    买方或卖方欠费
     */
    private String unilateralArrears;

    /**
     *
     * @mbggenerated
    补交金额
     */
    private String payAmount;

    /**
     *
     * @mbggenerated
    退款金额
     */
    private String refund;

    /**
     *
     * @mbggenerated
    财务编号
     */
    private String financialNumber;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private String createTime;

    /**
     *
     * @mbggenerated
    合同ID
     */
    private Integer dealId;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    填表人
     */
    private String fillUserName;

    /**
     *
     * @mbggenerated
    审核人
     */
    private String auditUserName;

    /**
     *
     * @mbggenerated
    贷款金额
     */
    private String loanMoney;

    /**
     *
     * @mbggenerated
    佣金
     */
    private String commssion;

    /**
     *
     * @mbggenerated
    0 买方税费打印单1卖方税费打印单
     */
    private Byte feeType;

    /**
     *
     * @mbggenerated
    按揭代办费
     */
    private String mortgageAgencyFee;

    /**
     *
     * @mbggenerated
    售方税费
     */
    private String saleTax;

    /**
     *
     * @mbggenerated
    户口押金
     */
    private String accountDeposit;

    /**
     *
     * @mbggenerated
    买方或卖方押金
     */
    private String unilateralDeposit;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getTaxesRecordId() {
        return taxesRecordId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaxesRecordId(Integer taxesRecordId) {
        this.taxesRecordId = taxesRecordId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTransferAgencyFee() {
        return transferAgencyFee;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTransferAgencyFee(String transferAgencyFee) {
        this.transferAgencyFee = transferAgencyFee == null ? null : transferAgencyFee.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCallPhone() {
        return callPhone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCallPhone(String callPhone) {
        this.callPhone = callPhone == null ? null : callPhone.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCustDeptName() {
        return custDeptName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustDeptName(String custDeptName) {
        this.custDeptName = custDeptName == null ? null : custDeptName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCustUsername() {
        return custUsername;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername == null ? null : custUsername.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTaxEvaluationPrice() {
        return taxEvaluationPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaxEvaluationPrice(String taxEvaluationPrice) {
        this.taxEvaluationPrice = taxEvaluationPrice == null ? null : taxEvaluationPrice.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSellAddress() {
        return sellAddress;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSellAddress(String sellAddress) {
        this.sellAddress = sellAddress == null ? null : sellAddress.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getFlatFeeAmount() {
        return flatFeeAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFlatFeeAmount(String flatFeeAmount) {
        this.flatFeeAmount = flatFeeAmount == null ? null : flatFeeAmount.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getHavePaidDeposit() {
        return havePaidDeposit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHavePaidDeposit(String havePaidDeposit) {
        this.havePaidDeposit = havePaidDeposit == null ? null : havePaidDeposit.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUnilateralCommission() {
        return unilateralCommission;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUnilateralCommission(String unilateralCommission) {
        this.unilateralCommission = unilateralCommission == null ? null : unilateralCommission.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUnilateralArrears() {
        return unilateralArrears;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUnilateralArrears(String unilateralArrears) {
        this.unilateralArrears = unilateralArrears == null ? null : unilateralArrears.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPayAmount() {
        return payAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount == null ? null : payAmount.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRefund() {
        return refund;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefund(String refund) {
        this.refund = refund == null ? null : refund.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getFinancialNumber() {
        return financialNumber;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinancialNumber(String financialNumber) {
        this.financialNumber = financialNumber == null ? null : financialNumber.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDealId() {
        return dealId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getFillUserName() {
        return fillUserName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFillUserName(String fillUserName) {
        this.fillUserName = fillUserName == null ? null : fillUserName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAuditUserName() {
        return auditUserName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName == null ? null : auditUserName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getLoanMoney() {
        return loanMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney == null ? null : loanMoney.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCommssion() {
        return commssion;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCommssion(String commssion) {
        this.commssion = commssion == null ? null : commssion.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFeeType() {
        return feeType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFeeType(Byte feeType) {
        this.feeType = feeType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMortgageAgencyFee() {
        return mortgageAgencyFee;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMortgageAgencyFee(String mortgageAgencyFee) {
        this.mortgageAgencyFee = mortgageAgencyFee == null ? null : mortgageAgencyFee.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleTax() {
        return saleTax;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleTax(String saleTax) {
        this.saleTax = saleTax == null ? null : saleTax.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAccountDeposit() {
        return accountDeposit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAccountDeposit(String accountDeposit) {
        this.accountDeposit = accountDeposit == null ? null : accountDeposit.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUnilateralDeposit() {
        return unilateralDeposit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUnilateralDeposit(String unilateralDeposit) {
        this.unilateralDeposit = unilateralDeposit == null ? null : unilateralDeposit.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunDealTaxesRecord() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunDealTaxesRecord(Integer shardCityId, Integer taxesRecordId) {
        super(shardCityId);
        this.taxesRecordId = taxesRecordId;
    }
}