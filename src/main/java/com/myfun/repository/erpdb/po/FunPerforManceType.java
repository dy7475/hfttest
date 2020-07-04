package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FunPerforManceType extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键id,自增
     */
    private Integer performanceId;

    /**
     *
     * @mbggenerated
    业绩类型名称
     */
    private String performanceName;

    /**
     *
     * @mbggenerated
    公司id
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    排序no
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
    是否删除
     */
    private Byte isDel;

    /**
     *
     * @mbggenerated
    能否删除
     */
    private Integer canDel;

    /**
     *
     * @mbggenerated
    业绩分配比例
     */
    private BigDecimal performanceProportion;

    /**
     *
     * @mbggenerated
    是否使用该比例分配业绩1=是 0=否
     */
    private Byte isAuto;

    /**
     *
     * @mbggenerated
     */
    private String enMsg;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getPerformanceId() {
        return performanceId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getPerformanceName() {
        return performanceName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName == null ? null : performanceName.trim();
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
    public Integer getCanDel() {
        return canDel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCanDel(Integer canDel) {
        this.canDel = canDel;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getPerformanceProportion() {
        return performanceProportion;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPerformanceProportion(BigDecimal performanceProportion) {
        this.performanceProportion = performanceProportion;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsAuto() {
        return isAuto;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsAuto(Byte isAuto) {
        this.isAuto = isAuto;
    }

    /**
     *
     * @mbggenerated
     */
    public String getEnMsg() {
        return enMsg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEnMsg(String enMsg) {
        this.enMsg = enMsg == null ? null : enMsg.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public FunPerforManceType() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public FunPerforManceType(Integer shardCityId, Integer performanceId) {
        super(shardCityId);
        this.performanceId = performanceId;
    }
}