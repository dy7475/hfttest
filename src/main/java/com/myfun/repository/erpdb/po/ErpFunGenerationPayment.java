package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunGenerationPayment extends ShardDb implements Serializable {

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
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getPersonAmount() {
		return personAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setPersonAmount(BigDecimal personAmount) {
		this.personAmount = personAmount;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCompAmount() {
		return compAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompAmount(BigDecimal compAmount) {
		this.compAmount = compAmount;
	}

	/**
	 * @mbggenerated
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @mbggenerated
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUpdateUid() {
		return updateUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateUid(Integer updateUid) {
		this.updateUid = updateUid;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditUid() {
		return auditUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditUid(Integer auditUid) {
		this.auditUid = auditUid;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDelUid() {
		return delUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelUid(Integer delUid) {
		this.delUid = delUid;
	}

	/**
	 * @mbggenerated
	 */
	public Date getOccurrenceTime() {
		return occurrenceTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setOccurrenceTime(Date occurrenceTime) {
		this.occurrenceTime = occurrenceTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGenerationPaymentClass() {
		return generationPaymentClass;
	}

	/**
	 * @mbggenerated
	 */
	public void setGenerationPaymentClass(Integer generationPaymentClass) {
		this.generationPaymentClass = generationPaymentClass;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth == null ? null : assessmentMonth.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunGenerationPayment() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunGenerationPayment(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}