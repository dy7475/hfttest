package com.myfun.repository.commdb.po;

import java.io.Serializable;

public class CommCrmDic implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer dicId;

    /**
     *
     * @mbggenerated
     */
    private String dicGroupType;

    /**
     *
     * @mbggenerated
     */
    private String dicType;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private String dicValue;

    /**
     *
     * @mbggenerated
     */
    private String dicValue1;

    /**
     *
     * @mbggenerated
     */
    private String dicEnMsg;

    /**
     *
     * @mbggenerated
     */
    private String dicCnMsg;

    /**
     *
     * @mbggenerated
     */
    private Integer dicParentId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getDicId() {
        return dicId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDicGroupType() {
        return dicGroupType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicGroupType(String dicGroupType) {
        this.dicGroupType = dicGroupType == null ? null : dicGroupType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDicType() {
        return dicType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicType(String dicType) {
        this.dicType = dicType == null ? null : dicType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDicValue() {
        return dicValue;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDicValue1() {
        return dicValue1;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicValue1(String dicValue1) {
        this.dicValue1 = dicValue1 == null ? null : dicValue1.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDicEnMsg() {
        return dicEnMsg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicEnMsg(String dicEnMsg) {
        this.dicEnMsg = dicEnMsg == null ? null : dicEnMsg.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDicCnMsg() {
        return dicCnMsg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicCnMsg(String dicCnMsg) {
        this.dicCnMsg = dicCnMsg == null ? null : dicCnMsg.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDicParentId() {
        return dicParentId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDicParentId(Integer dicParentId) {
        this.dicParentId = dicParentId;
    }
}