package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgencyPaFinance implements Serializable {
    /**
     *
     * @mbggenerated
    金融Id，自增
     */
    private Integer financeId;

    /**
     *
     * @mbggenerated
    贷款人姓名
     */
    private String userName;

    /**
     *
     * @mbggenerated
    贷款人身份证号
     */
    private String icCode;

    /**
     *
     * @mbggenerated
    申请金额，单位万元
     */
    private BigDecimal applyPrice;

    /**
     *
     * @mbggenerated
    贷款人电话号码
     */
    private String userMobile;

    /**
     *
     * @mbggenerated
    经纪人档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    公司编号
     */
    private String compNo;

    /**
     *
     * @mbggenerated
    门店编号
     */
    private String deptNo;

    /**
     *
     * @mbggenerated
     0,'待验证',2,'验证失败',3,'待审核',4,'审核失败',5,'用户撤单',6,'待放款',13,'放款失败',7,'待结佣',8,'已分佣',9,'已失效',10,'已关闭'
     */
    private Byte financeStatus;

    /**
     *
     * @mbggenerated
    经纪人版本（用户的软件版本，非设备）[0精英版，1门店版]
     */
    private Byte financeResource;

    /**
     *
     * @mbggenerated
    产权证号
     */
    private String rightNo;

    /**
     *
     * @mbggenerated
    登记来源 [0手机,1ERP, 2CRM]
     */
    private Byte regFrom;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    更新时间
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
    放款金额，单位万元
     */
    private BigDecimal loanPrice;

    /**
     *
     * @mbggenerated
    放款时间
     */
    private Date loanTime;

    /**
     *
     * @mbggenerated
    个人返佣金额，单位：元  税前 
     */
    private BigDecimal rakebackPrice;

    /**
     *
     * @mbggenerated
    个人入账状态[0未入账,1已入账]
     */
    private Byte rakebackStatus;

    /**
     *
     * @mbggenerated
    个人返佣时间
     */
    private Date rakebackTime;

    /**
     *
     * @mbggenerated
    个人是否提现（0未提现、1提现中(由CRM后台审核)、 2已提现）
     */
    private Byte isCash;

    /**
     *
     * @mbggenerated
    经纪人所属城市ID
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    总返佣比例，前端需要格式化成 ?% 例如：3%
     */
    private BigDecimal rakebackPriceRate;

    /**
     *
     * @mbggenerated
    税前佣金
     */
    private BigDecimal moneyBeforeTaxes;

    /**
     *
     * @mbggenerated
    税率，前端需要格式化成 ?% 例如：3%
     */
    private BigDecimal taxesRate;

    /**
     *
     * @mbggenerated
    费税
     */
    private BigDecimal taxesMoney;

    /**
     *
     * @mbggenerated
    楼盘ID（完善信息）
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
    楼盘名称（完善信息）
     */
    private String buildName;

    /**
     *
     * @mbggenerated
    监证号
     */
    private String jianzhengNo;

    /**
     *
     * @mbggenerated
    评估金额
     */
    private BigDecimal assessmentMoney;

    /**
     *
     * @mbggenerated
    DY号（平安普惠生成的编号）
     */
    private String dyNo;

    /**
     *
     * @mbggenerated
    总佣金额度，单位：元  
     */
    private BigDecimal rakebackPriceTotal;

    /**
     *
     * @mbggenerated
    公司返佣金额，单位：元  税前
     */
    private BigDecimal compRakebackPrice;

    /**
     *
     * @mbggenerated
    公司入账状态[0未入账,1已入账]
     */
    private Byte compRakebackStatus;

    /**
     *
     * @mbggenerated
    公司返佣时间
     */
    private Date compRakebackTime;

    /**
     *
     * @mbggenerated
    公司是否提现（0未提现、1提现中(由CRM后台审核)、 2已提现）
     */
    private Byte compIsCash;

    /**
     *
     * @mbggenerated
    贷款期限 决定了分佣比例
     */
    private Integer financeLimit;

    /**
     *
     * @mbggenerated
    是否关闭：0:未关闭、1:已关闭
     */
    private Byte isClose;

    /**
     *
     * @mbggenerated
    被注销的经纪人archive_id
     */
    private Integer oldArchiveId;

    /**
     *
     * @mbggenerated
    审核通过时间
     */
    private Date auditPassTime;

    /**
     *
     * @mbggenerated
    原经纪人注销时间
     */
    private Date oldBrokerWriteoffTime;

    /**
     *
     * @mbggenerated
    面签次数
     */
    private Integer interviewCount;

    /**
     *
     * @mbggenerated
    撤单次数
     */
    private Integer cancelApplyCount;

    /**
     *
     * @mbggenerated
    订单结束时间（订单实际结束时间）
     */
    private Date protectEndTime;

    /**
     *
     * @mbggenerated
    贷款订单保护期结束时间（订单有效期）
     */
    private Date cancelApplyTime;

    /**
     *
     * @mbggenerated
    渠道验证通过时间
     */
    private Date channelPassTime;

    /**
     *
     * @mbggenerated
    审核失败时间
     */
    private Date auditErrorTime;

    /**
     *
     * @mbggenerated
    用户撤单时间
     */
    private Date customerRevokeTime;

    /**
     *
     * @mbggenerated
    委托邀约 0：否,1:是
     */
    private Byte entrustInvitation;

    /**
     *
     * @mbggenerated
    公司佣金 税后
     */
    private BigDecimal compRakebackPriceAfterTax;

    /**
     *
     * @mbggenerated
    个人佣金税后
     */
    private BigDecimal rakebackPriceAfterTax;

    /**
     *
     * @mbggenerated
    失败原因
     */
    private String auditErrorReason;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getFinanceId() {
        return financeId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIcCode() {
        return icCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIcCode(String icCode) {
        this.icCode = icCode == null ? null : icCode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getApplyPrice() {
        return applyPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setApplyPrice(BigDecimal applyPrice) {
        this.applyPrice = applyPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCompNo() {
        return compNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompNo(String compNo) {
        this.compNo = compNo == null ? null : compNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFinanceStatus() {
        return financeStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinanceStatus(Byte financeStatus) {
        this.financeStatus = financeStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFinanceResource() {
        return financeResource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinanceResource(Byte financeResource) {
        this.financeResource = financeResource;
    }

    /**
     *
     * @mbggenerated
     */
    public String getRightNo() {
        return rightNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRightNo(String rightNo) {
        this.rightNo = rightNo == null ? null : rightNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRegFrom() {
        return regFrom;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegFrom(Byte regFrom) {
        this.regFrom = regFrom;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getLoanPrice() {
        return loanPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoanPrice(BigDecimal loanPrice) {
        this.loanPrice = loanPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLoanTime() {
        return loanTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getRakebackPrice() {
        return rakebackPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRakebackPrice(BigDecimal rakebackPrice) {
        this.rakebackPrice = rakebackPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRakebackStatus() {
        return rakebackStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRakebackStatus(Byte rakebackStatus) {
        this.rakebackStatus = rakebackStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getRakebackTime() {
        return rakebackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRakebackTime(Date rakebackTime) {
        this.rakebackTime = rakebackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsCash() {
        return isCash;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsCash(Byte isCash) {
        this.isCash = isCash;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getRakebackPriceRate() {
        return rakebackPriceRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRakebackPriceRate(BigDecimal rakebackPriceRate) {
        this.rakebackPriceRate = rakebackPriceRate;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getMoneyBeforeTaxes() {
        return moneyBeforeTaxes;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMoneyBeforeTaxes(BigDecimal moneyBeforeTaxes) {
        this.moneyBeforeTaxes = moneyBeforeTaxes;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getTaxesRate() {
        return taxesRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaxesRate(BigDecimal taxesRate) {
        this.taxesRate = taxesRate;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getTaxesMoney() {
        return taxesMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaxesMoney(BigDecimal taxesMoney) {
        this.taxesMoney = taxesMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getJianzhengNo() {
        return jianzhengNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJianzhengNo(String jianzhengNo) {
        this.jianzhengNo = jianzhengNo == null ? null : jianzhengNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getAssessmentMoney() {
        return assessmentMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAssessmentMoney(BigDecimal assessmentMoney) {
        this.assessmentMoney = assessmentMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDyNo() {
        return dyNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDyNo(String dyNo) {
        this.dyNo = dyNo == null ? null : dyNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getRakebackPriceTotal() {
        return rakebackPriceTotal;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRakebackPriceTotal(BigDecimal rakebackPriceTotal) {
        this.rakebackPriceTotal = rakebackPriceTotal;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getCompRakebackPrice() {
        return compRakebackPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompRakebackPrice(BigDecimal compRakebackPrice) {
        this.compRakebackPrice = compRakebackPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCompRakebackStatus() {
        return compRakebackStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompRakebackStatus(Byte compRakebackStatus) {
        this.compRakebackStatus = compRakebackStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCompRakebackTime() {
        return compRakebackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompRakebackTime(Date compRakebackTime) {
        this.compRakebackTime = compRakebackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCompIsCash() {
        return compIsCash;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompIsCash(Byte compIsCash) {
        this.compIsCash = compIsCash;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFinanceLimit() {
        return financeLimit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinanceLimit(Integer financeLimit) {
        this.financeLimit = financeLimit;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsClose() {
        return isClose;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsClose(Byte isClose) {
        this.isClose = isClose;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getOldArchiveId() {
        return oldArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOldArchiveId(Integer oldArchiveId) {
        this.oldArchiveId = oldArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAuditPassTime() {
        return auditPassTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditPassTime(Date auditPassTime) {
        this.auditPassTime = auditPassTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getOldBrokerWriteoffTime() {
        return oldBrokerWriteoffTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOldBrokerWriteoffTime(Date oldBrokerWriteoffTime) {
        this.oldBrokerWriteoffTime = oldBrokerWriteoffTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getInterviewCount() {
        return interviewCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setInterviewCount(Integer interviewCount) {
        this.interviewCount = interviewCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCancelApplyCount() {
        return cancelApplyCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCancelApplyCount(Integer cancelApplyCount) {
        this.cancelApplyCount = cancelApplyCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getProtectEndTime() {
        return protectEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProtectEndTime(Date protectEndTime) {
        this.protectEndTime = protectEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCancelApplyTime() {
        return cancelApplyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCancelApplyTime(Date cancelApplyTime) {
        this.cancelApplyTime = cancelApplyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getChannelPassTime() {
        return channelPassTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setChannelPassTime(Date channelPassTime) {
        this.channelPassTime = channelPassTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAuditErrorTime() {
        return auditErrorTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditErrorTime(Date auditErrorTime) {
        this.auditErrorTime = auditErrorTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCustomerRevokeTime() {
        return customerRevokeTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustomerRevokeTime(Date customerRevokeTime) {
        this.customerRevokeTime = customerRevokeTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getEntrustInvitation() {
        return entrustInvitation;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEntrustInvitation(Byte entrustInvitation) {
        this.entrustInvitation = entrustInvitation;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getCompRakebackPriceAfterTax() {
        return compRakebackPriceAfterTax;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompRakebackPriceAfterTax(BigDecimal compRakebackPriceAfterTax) {
        this.compRakebackPriceAfterTax = compRakebackPriceAfterTax;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getRakebackPriceAfterTax() {
        return rakebackPriceAfterTax;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRakebackPriceAfterTax(BigDecimal rakebackPriceAfterTax) {
        this.rakebackPriceAfterTax = rakebackPriceAfterTax;
    }

    /**
     *
     * @mbggenerated
     */
    public String getAuditErrorReason() {
        return auditErrorReason;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditErrorReason(String auditErrorReason) {
        this.auditErrorReason = auditErrorReason == null ? null : auditErrorReason.trim();
    }
}