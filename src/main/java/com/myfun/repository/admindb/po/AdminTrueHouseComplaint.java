package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminTrueHouseComplaint implements Serializable {
    /**
     *
     * @mbggenerated
     Ͷid
     */
    private Integer complaintId;

    /**
     *
     * @mbggenerated
    Դid
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    Դid
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
    Դ
     */
    private String caseNo;

    /**
     *
     * @mbggenerated
    Դ 1  2 
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
    Ͷid
     */
    private Integer sourceUserId;

    /**
     *
     * @mbggenerated
    Ͷ˵id
     */
    private Integer sourceArchiveId;

    /**
     *
     * @mbggenerated
    Ͷid
     */
    private Integer targetUserId;

    /**
     *
     * @mbggenerated
    Ͷ˵id
     */
    private Integer targetArchiveId;

    /**
     *
     * @mbggenerated
    Ͷ
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    ͶԴ 0 ERP 1 εκ÷ 2Ѷַ 3 ƶ
     */
    private Byte complaintSource;

    /**
     *
     * @mbggenerated
    Ͷ״̬ 0 Ͷ 1  2 Ѵ
     */
    private Byte complaintType;

    /**
     *
     * @mbggenerated
    ״̬ 0 δ 1 ɹ 2 ʧ
     */
    private Byte dealStatus;

    /**
     *
     * @mbggenerated
     0 Զ 1 ˹
     */
    private Byte dealType;

    /**
     *
     * @mbggenerated
    id
     */
    private Integer dealUserId;

    /**
     *
     * @mbggenerated

     */
    private Date dealTime;

    /**
     *
     * @mbggenerated

     */
    private Date appealTime;

    /**
     *
     * @mbggenerated
    
     */
    private String appealContent;

    /**
     *
     * @mbggenerated
    Ͷ
     */
    private String complaintContent;

    /**
     *
     * @mbggenerated
    
     */
    private String dealContent;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getComplaintId() {
        return complaintId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
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
    public String getCaseNo() {
        return caseNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo == null ? null : caseNo.trim();
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
    public Integer getSourceUserId() {
        return sourceUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSourceUserId(Integer sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSourceArchiveId() {
        return sourceArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSourceArchiveId(Integer sourceArchiveId) {
        this.sourceArchiveId = sourceArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getTargetUserId() {
        return targetUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getTargetArchiveId() {
        return targetArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTargetArchiveId(Integer targetArchiveId) {
        this.targetArchiveId = targetArchiveId;
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
    public Byte getComplaintSource() {
        return complaintSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplaintSource(Byte complaintSource) {
        this.complaintSource = complaintSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getComplaintType() {
        return complaintType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplaintType(Byte complaintType) {
        this.complaintType = complaintType;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDealStatus() {
        return dealStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealStatus(Byte dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDealType() {
        return dealType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealType(Byte dealType) {
        this.dealType = dealType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDealUserId() {
        return dealUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAppealTime() {
        return appealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAppealTime(Date appealTime) {
        this.appealTime = appealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getAppealContent() {
        return appealContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent == null ? null : appealContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getComplaintContent() {
        return complaintContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent == null ? null : complaintContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDealContent() {
        return dealContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealContent(String dealContent) {
        this.dealContent = dealContent == null ? null : dealContent.trim();
    }
}