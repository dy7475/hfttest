package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateDealAuditStatusParam  implements EncryParamIfc{
	@ApiModelProperty(value = "合同ID，自增序列")
	private Integer dealId;
	@ApiModelProperty(value = "合同号【合同创建时不论是手动输入还是自动分配的编号】")
	private String contractNo;
	@ApiModelProperty(value = "备注信息")
	private String dealVerifyCon;
	@ApiModelProperty(value = "来源，1=表示来源于手动录入业绩")
	private Integer completeFailSource;
	@ApiModelProperty(value = "合同审核状态（接口：updateMgrDealAduitStatus 1=初审，2=复审，3=作废）  （接口updateMgrDealAduitStatusByCounter 5 = 撤销初审 6=撤销复审）")
	private Integer dealAuditStatus;
	@ApiModelProperty(value = "成交类型，DD:CASE_TYPE")
	private Byte dealType;
	@ApiModelProperty(hidden = true)
	private String selfUserName;
	@ApiModelProperty(hidden = true)
	private Integer selfCompType;
	@ApiModelProperty(hidden = true)
	private boolean isPersonalVersion;
	@ApiModelProperty(hidden = true)
	private String selfDeptName;
	@ApiModelProperty(hidden = true)
	private Integer selfUserId;
	@ApiModelProperty(hidden = true)
	private Integer selfDeptId;
	@ApiModelProperty(hidden = true)
	private Integer selfCompId;
	@ApiModelProperty(hidden = true)
	private Integer selfArchiveId;
	@ApiModelProperty(hidden = true)
	private Integer selfGrId;
	@ApiModelProperty(hidden = true)
	private Integer selfRegId;
	@ApiModelProperty(hidden = true)
	private Integer selfAreaId;

	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private String taskSubJect;
	@ApiModelProperty(hidden = true)
	private String taskContent;
	@ApiModelProperty(hidden = true)
	private String trackContent;
	@ApiModelProperty(hidden = true)
	private String updateClassic;

	@ApiModelProperty(hidden = true, value = "初审时间")
	private String firstTrialCompleteDate;
	@ApiModelProperty(hidden = true,value = "复审时间")
	private String recheckCompleteDate;
	@ApiModelProperty(hidden = true,value = "作废时间")
	private String invalidCompleteDate;

	@ApiModelProperty("如果有共享中心审核配置, 选择的具体共享中心审核流程的ID")
	private Integer classId;

	public String getFirstTrialCompleteDate() {
		return firstTrialCompleteDate;
	}

	public void setFirstTrialCompleteDate(String firstTrialCompleteDate) {
		this.firstTrialCompleteDate = firstTrialCompleteDate;
	}

	public String getRecheckCompleteDate() {
		return recheckCompleteDate;
	}

	public void setRecheckCompleteDate(String recheckCompleteDate) {
		this.recheckCompleteDate = recheckCompleteDate;
	}

	public String getInvalidCompleteDate() {
		return invalidCompleteDate;
	}

	public void setInvalidCompleteDate(String invalidCompleteDate) {
		this.invalidCompleteDate = invalidCompleteDate;
	}

	public Byte getDealType() {
		return dealType;
	}

	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getDealAuditStatus() {
		return dealAuditStatus;
	}

	public void setDealAuditStatus(Integer dealAuditStatus) {
		this.dealAuditStatus = dealAuditStatus;
	}

	public String getSelfUserName() {
		return selfUserName;
	}

	public void setSelfUserName(String selfUserName) {
		this.selfUserName = selfUserName;
	}

	public Integer getSelfCompType() {
		return selfCompType;
	}

	public void setSelfCompType(Integer selfCompType) {
		this.selfCompType = selfCompType;
	}

	public boolean isPersonalVersion() {
		return isPersonalVersion;
	}
	@ApiModelProperty(hidden = true)
	public void setPersonalVersion(boolean personalVersion) {
		isPersonalVersion = personalVersion;
	}

	public String getSelfDeptName() {
		return selfDeptName;
	}

	public void setSelfDeptName(String selfDeptName) {
		this.selfDeptName = selfDeptName;
	}

	public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}

	public Integer getSelfDeptId() {
		return selfDeptId;
	}

	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
	}

	public Integer getSelfCompId() {
		return selfCompId;
	}

	public void setSelfCompId(Integer selfCompId) {
		this.selfCompId = selfCompId;
	}

	public Integer getSelfArchiveId() {
		return selfArchiveId;
	}

	public void setSelfArchiveId(Integer selfArchiveId) {
		this.selfArchiveId = selfArchiveId;
	}

	public Integer getSelfGrId() {
		return selfGrId;
	}

	public void setSelfGrId(Integer selfGrId) {
		this.selfGrId = selfGrId;
	}

	public Integer getSelfRegId() {
		return selfRegId;
	}

	public void setSelfRegId(Integer selfRegId) {
		this.selfRegId = selfRegId;
	}

	public Integer getSelfAreaId() {
		return selfAreaId;
	}

	public void setSelfAreaId(Integer selfAreaId) {
		this.selfAreaId = selfAreaId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@ApiModelProperty(value = "业绩json")


	public String getDealVerifyCon() {
		return dealVerifyCon;
	}

	public void setDealVerifyCon(String dealVerifyCon) {
		this.dealVerifyCon = dealVerifyCon;
	}

	public Integer getCompleteFailSource() {
		return completeFailSource;
	}

	public void setCompleteFailSource(Integer completeFailSource) {
		this.completeFailSource = completeFailSource;
	}

	public String getTaskSubJect() {
		return taskSubJect;
	}

	public void setTaskSubJect(String taskSubJect) {
		this.taskSubJect = taskSubJect;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getTrackContent() {
		return trackContent;
	}

	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}

	public String getUpdateClassic() {
		return updateClassic;
	}

	public void setUpdateClassic(String updateClassic) {
		this.updateClassic = updateClassic;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}
}
