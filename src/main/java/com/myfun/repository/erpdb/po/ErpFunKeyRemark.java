package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunKeyRemark extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    备注ID（主键自增）
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    房源ID
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
    房源类型
     */
    private Integer caseType;

    /**
     *
     * @mbggenerated
    备注信息
     */
    private String remark;

    /**
     *
     * @mbggenerated
    创建者
     */
    private Integer creatorUid;

    /**
     *
     * @mbggenerated
    CREATION_TIME
     */
    private Date creationTime;

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
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreatorUid() {
        return creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
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
    public ErpFunKeyRemark() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunKeyRemark(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}