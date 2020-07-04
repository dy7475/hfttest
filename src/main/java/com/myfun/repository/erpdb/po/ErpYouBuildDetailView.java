package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpYouBuildDetailView extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    自增ID
     */
    private Integer detailViewId;

    /**
     *
     * @mbggenerated
    楼盘数据ID，DD:YOU_BUILD_DETAIL
     */
    private Integer buildDetailId;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    门店ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    用户ID
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
    本人操作此房源状态，1:已拨打（绿色）2:已拨打（红色）3:已转入系统
     */
    private Integer viewStatus;

    /**
     *
     * @mbggenerated
    是否明文显示电话，0：否1：是
     */
    private Byte showPhone;

    /**
     *
     * @mbggenerated
    转入后的关联数据ID
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
    转入后的关联数据类型，DD:CASE_TYPE
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
    创建时间，YOU_SHARE_HOUSE_STATUS
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    楼盘ID
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
    收藏时间
     */
    private String collectionTime;

    /**
     *
     * @mbggenerated
    行政区域
     */
    private Integer buildReg;

    /**
     *
     * @mbggenerated
    片区ID
     */
    private Integer sectionId;

    /**
     *
     * @mbggenerated
    片区名称
     */
    private String sectionName;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getDetailViewId() {
        return detailViewId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDetailViewId(Integer detailViewId) {
        this.detailViewId = detailViewId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildDetailId() {
        return buildDetailId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildDetailId(Integer buildDetailId) {
        this.buildDetailId = buildDetailId;
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
    public Integer getViewStatus() {
        return viewStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setViewStatus(Integer viewStatus) {
        this.viewStatus = viewStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getShowPhone() {
        return showPhone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShowPhone(Byte showPhone) {
        this.showPhone = showPhone;
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
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
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
    public String getCollectionTime() {
        return collectionTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime == null ? null : collectionTime.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildReg() {
        return buildReg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildReg(Integer buildReg) {
        this.buildReg = buildReg;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public ErpYouBuildDetailView() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpYouBuildDetailView(Integer shardCityId, Integer detailViewId) {
        super(shardCityId);
        this.detailViewId = detailViewId;
    }
}