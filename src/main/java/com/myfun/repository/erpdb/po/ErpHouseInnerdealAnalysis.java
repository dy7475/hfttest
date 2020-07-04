package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpHouseInnerdealAnalysis extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键ID
     */
    private Integer analysisId;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    大区ID
     */
    private Integer areaId;

    /**
     *
     * @mbggenerated
    片区ID
     */
    private Integer regId;

    /**
     *
     * @mbggenerated
    门店ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    分组ID
     */
    private Integer grId;

    /**
     *
     * @mbggenerated
    员工ID
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
    档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    出租1，出售0房源类型
     */
    private Integer caseType;

    /**
     *
     * @mbggenerated
    房源ID
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
    房源成交周期参考时间
     */
    private Date caseCreateTime;

    /**
     *
     * @mbggenerated
    内成交时间
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
    成交时，房源的状态
     */
    private Byte caseStatus;

    /**
     *
     * @mbggenerated
    合同ID
     */
    private Integer dealId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getAnalysisId() {
        return analysisId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAnalysisId(Integer analysisId) {
        this.analysisId = analysisId;
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
    public Integer getAreaId() {
        return areaId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRegId() {
        return regId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getGrId() {
        return grId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public Date getCaseCreateTime() {
        return caseCreateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseCreateTime(Date caseCreateTime) {
        this.caseCreateTime = caseCreateTime;
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
    public Byte getCaseStatus() {
        return caseStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseStatus(Byte caseStatus) {
        this.caseStatus = caseStatus;
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
    public ErpHouseInnerdealAnalysis() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpHouseInnerdealAnalysis(Integer shardCityId, Integer analysisId) {
        super(shardCityId);
        this.analysisId = analysisId;
    }
}