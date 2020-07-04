package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunFinancStatus extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer financStatusId;

    /**
     *
     * @mbggenerated
     */
    private String financName;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Byte isDel;

    /**
     *
     * @mbggenerated
     */
    private Byte canDel;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getFinancStatusId() {
        return financStatusId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinancStatusId(Integer financStatusId) {
        this.financStatusId = financStatusId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getFinancName() {
        return financName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinancName(String financName) {
        this.financName = financName == null ? null : financName.trim();
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
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCanDel() {
        return canDel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCanDel(Byte canDel) {
        this.canDel = canDel;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunFinancStatus() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunFinancStatus(Integer shardCityId, Integer financStatusId) {
        super(shardCityId);
        this.financStatusId = financStatusId;
    }
}