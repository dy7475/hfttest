package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunAttendanceParam extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    打卡规则
     */
    private String ruleValue;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     *
     * @mbggenerated
    参数
     */
    private String paramType;

    /**
     *
     * @mbggenerated
    罚款金额
     */
    private String penaltyMoney;

    /**
     *
     * @mbggenerated
    罚款方式
     */
    private Byte penaltyType;

    /**
     *
     * @mbggenerated
    交款方式 1：现金 2：工资扣除
     */
    private String paymentType;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public String getRuleValue() {
        return ruleValue;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue == null ? null : ruleValue.trim();
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
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * @mbggenerated
     */
    public String getParamType() {
        return paramType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPenaltyMoney() {
        return penaltyMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPenaltyMoney(String penaltyMoney) {
        this.penaltyMoney = penaltyMoney == null ? null : penaltyMoney.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPenaltyType() {
        return penaltyType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPenaltyType(Byte penaltyType) {
        this.penaltyType = penaltyType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunAttendanceParam() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunAttendanceParam(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}