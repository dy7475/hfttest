package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AdminFunDeptsActivity implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键ID")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "门店ID")
    private Integer deptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "活动类型 1=意向金活动")
    private Integer activityType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同ID")
    private Integer contractId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "活动状态 默认=1 ，1=正常(未付款) ，2=已经付款，3=已退款")
    private Byte activityStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建时间")
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "意向金支付时间")
    private Date clearTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "退款时间  ")
    private Date refundTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单ID")
    private Integer ptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "（非KA合同时ARCHIVE_ID = UA_ID共用  从-20000开始，每次插入减一）；（KA意向金合同的时候存总经理ARCHIVE_ID）")
    private Integer archiveUaId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "意向金金额，默认0.0")
    private Double amount;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "尾款支付状态 默认=0=未支付 ，1=已支付")
    private Byte finalPaymentStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司ID")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 门店ID
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     * 门店ID
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     * 活动类型 1=意向金活动
     */
    public Integer getActivityType() {
        return activityType;
    }

    /**
     *
     * @mbggenerated
     * 活动类型 1=意向金活动
     */
    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    /**
     *
     * @mbggenerated
     * 合同ID
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     *
     * @mbggenerated
     * 合同ID
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     *
     * @mbggenerated
     * 活动状态 默认=1 ，1=正常(未付款) ，2=已经付款，3=已退款
     */
    public Byte getActivityStatus() {
        return activityStatus;
    }

    /**
     *
     * @mbggenerated
     * 活动状态 默认=1 ，1=正常(未付款) ，2=已经付款，3=已退款
     */
    public void setActivityStatus(Byte activityStatus) {
        this.activityStatus = activityStatus;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * @mbggenerated
     * 意向金支付时间
     */
    public Date getClearTime() {
        return clearTime;
    }

    /**
     *
     * @mbggenerated
     * 意向金支付时间
     */
    public void setClearTime(Date clearTime) {
        this.clearTime = clearTime;
    }

    /**
     *
     * @mbggenerated
     * 退款时间  
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     *
     * @mbggenerated
     * 退款时间  
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     *
     * @mbggenerated
     * 订单ID
     */
    public Integer getPtId() {
        return ptId;
    }

    /**
     *
     * @mbggenerated
     * 订单ID
     */
    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    /**
     *
     * @mbggenerated
     * （非KA合同时ARCHIVE_ID = UA_ID共用  从-20000开始，每次插入减一）；（KA意向金合同的时候存总经理ARCHIVE_ID）
     */
    public Integer getArchiveUaId() {
        return archiveUaId;
    }

    /**
     *
     * @mbggenerated
     * （非KA合同时ARCHIVE_ID = UA_ID共用  从-20000开始，每次插入减一）；（KA意向金合同的时候存总经理ARCHIVE_ID）
     */
    public void setArchiveUaId(Integer archiveUaId) {
        this.archiveUaId = archiveUaId;
    }

    /**
     *
     * @mbggenerated
     * 意向金金额，默认0.0
     */
    public Double getAmount() {
        return amount;
    }

    /**
     *
     * @mbggenerated
     * 意向金金额，默认0.0
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     *
     * @mbggenerated
     * 尾款支付状态 默认=0=未支付 ，1=已支付
     */
    public Byte getFinalPaymentStatus() {
        return finalPaymentStatus;
    }

    /**
     *
     * @mbggenerated
     * 尾款支付状态 默认=0=未支付 ，1=已支付
     */
    public void setFinalPaymentStatus(Byte finalPaymentStatus) {
        this.finalPaymentStatus = finalPaymentStatus;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}