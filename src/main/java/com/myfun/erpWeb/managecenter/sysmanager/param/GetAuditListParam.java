package com.myfun.erpWeb.managecenter.sysmanager.param;

import java.util.List;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetAuditListParam extends AbstractEncryParam {


	@ApiModelProperty(value = "数据类型")
	private String dataType;
	
	@ApiModelProperty(value = "审核类型")
	private String auditType;
	
	@ApiModelProperty(value = "公司id")
	private Integer compId;

	@ApiModelProperty(value = "大区id")
	private Integer areaId;
	
	@ApiModelProperty(value = "片区id")
	private Integer regId;
	
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	
	@ApiModelProperty(value = "分组id")
	private Integer grId;
	
	@ApiModelProperty(value = "分组id")
	private Integer userId;
	
	@ApiModelProperty(value = "审核来源1=跟进类审核 2=请假审核 3=外出审核")
	private Byte auditResource;
	
	@ApiModelProperty(value = "目标类型")
	private Byte caseType;
	
	@ApiModelProperty(value = "目标编号")
	private String caseNo;
	
	@ApiModelProperty(value = "审核状态，0=审核中 1=审核全部通过 2=未通过 3=已撤回 4=超期自动通过 5=已失效")
	private Byte auditStatus;

	@ApiModelProperty("分类ID")
	private Integer classId;

	@ApiModelProperty("通用审核的业务类型id")
	private Integer templateId;
	
	@ApiModelProperty(value = "开始时间", hidden = true)
	private String startTime;
	
	@ApiModelProperty(value = "结束时间", hidden = true)
	private String endTime;
	
	@ApiModelProperty(value = "审核类型集合", hidden = true)
	private List<String> auditTypeArr;

	@ApiModelProperty(value = "通用审核的业务类型id集合", hidden = true)
	private List<Integer> templateIds;

	@ApiModelProperty(value = "组织机构id")
	private Integer organizationId;

	@ApiModelProperty(value = "房源IDs")
	private String caseIds;

	public String getCaseIds() {
		return caseIds;
	}

	public void setCaseIds(String caseIds) {
		this.caseIds = caseIds;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}
	
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
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

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getAuditResource() {
		return auditResource;
	}

	public void setAuditResource(Byte auditResource) {
		this.auditResource = auditResource;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<String> getAuditTypeArr() {
		return auditTypeArr;
	}

	public void setAuditTypeArr(List<String> auditTypeArr) {
		this.auditTypeArr = auditTypeArr;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public List<Integer> getTemplateIds() {
		return templateIds;
	}

	public void setTemplateIds(List<Integer> templateIds) {
		this.templateIds = templateIds;
	}
}