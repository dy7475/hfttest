package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunGenerationPayment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class ErpFunGenerationPaymentDto  implements Serializable {
    @ApiModelProperty("类别名")
    private String className;
    @ApiModelProperty("角色ID")
    private String userPosition;
    @ApiModelProperty("员工档案ID")
    private Integer archiveId; //员工档案ID
    @ApiModelProperty("审核人档案ID")
    private Integer auditArchiveId; //审核人档案ID
    @ApiModelProperty("组织id")
    private Integer organizationId;

    
    public Integer getOrganizationId() {
	
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}

	/**
     * @mbggenerated 主键
     */
    @ApiModelProperty("主键")
    private Integer id;
    /**
     * @mbggenerated 公司ID
     */
    @ApiModelProperty("公司ID")
    private Integer compId;
    /**
     * @mbggenerated 门店ID
     */
    @ApiModelProperty("门店ID")
    private Integer deptId;
    /**
     * @mbggenerated 大区ID
     */
    @ApiModelProperty("大区ID")
    private Integer areaId;
    /**
     * @mbggenerated 片区ID
     */
    @ApiModelProperty("片区ID")
    private Integer regId;
    /**
     * @mbggenerated 个人承担部分
     */
    @ApiModelProperty("个人承担部分")
    private BigDecimal personAmount;
    /**
     * @mbggenerated 公司承担部分
     */
    @ApiModelProperty("公司承担部分")
    private BigDecimal compAmount;
    /**
     * @mbggenerated 备注
     */
    @ApiModelProperty("备注")
    private String remarks;
    /**
     * @mbggenerated 登记时间
     */
    @ApiModelProperty("登记时间")
    private Date createTime;
    /**
     * @mbggenerated 登记人
     */
    @ApiModelProperty("登记人")
    private Integer createUid;
    /**
     * @mbggenerated 员工
     */
    @ApiModelProperty("员工")
    private Integer userId;
    /**
     * @mbggenerated 更新人
     */
    @ApiModelProperty("更新人")
    private Integer updateUid;
    /**
     * @mbggenerated 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
     * @mbggenerated 审核时间
     */
    @ApiModelProperty("审核时间")
    private Date auditTime;
    /**
     * @mbggenerated 审核人
     */
    @ApiModelProperty("审核人")
    private Integer auditUid;
    /**
     * @mbggenerated 审核状态 0未审核 1：已审核 2反审核
     */
    @ApiModelProperty("审核状态 0=未审核 1=已审核 2=反审核")
    private Byte auditStatus;
    /**
     * @mbggenerated 是否被删除 0未删除 1：已删除
     */
    @ApiModelProperty("是否删除 0=未删除 1=已删除")
    private Byte isDel;
    /**
     * @mbggenerated 删除时间
     */
    @ApiModelProperty("删除时间")
    private Date delTime;
    /**
     * @mbggenerated 删除人
     */
    @ApiModelProperty("删除人")
    private Integer delUid;
    /**
     * @mbggenerated 代扣时间
     */
    @ApiModelProperty("代扣时间")
    private Date occurrenceTime;
    /**
     * @mbggenerated 代扣类型
     */
    @ApiModelProperty("代扣类型")
    private Integer generationPaymentClass;
    /**
     * @mbggenerated 分组ID
     */
    @ApiModelProperty("分组ID")
    private Integer grId;
    /**
     * @mbggenerated 统计月
     */
    @ApiModelProperty("统计月")
    private String assessmentMonth;

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Integer getAuditArchiveId() {
        return auditArchiveId;
    }

    public void setAuditArchiveId(Integer auditArchiveId) {
        this.auditArchiveId = auditArchiveId;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public BigDecimal getPersonAmount() {
        return personAmount;
    }

    public void setPersonAmount(BigDecimal personAmount) {
        this.personAmount = personAmount;
    }

    public BigDecimal getCompAmount() {
        return compAmount;
    }

    public void setCompAmount(BigDecimal compAmount) {
        this.compAmount = compAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditUid() {
        return auditUid;
    }

    public void setAuditUid(Integer auditUid) {
        this.auditUid = auditUid;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    public Integer getDelUid() {
        return delUid;
    }

    public void setDelUid(Integer delUid) {
        this.delUid = delUid;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public Integer getGenerationPaymentClass() {
        return generationPaymentClass;
    }

    public void setGenerationPaymentClass(Integer generationPaymentClass) {
        this.generationPaymentClass = generationPaymentClass;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth;
    }
}
