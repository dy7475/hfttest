package com.myfun.erpWeb.managecenter.houseComplain.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class GetHouseComplainListParam extends AbstractEncryParam {

	@ApiModelProperty(value = "用户id")
	private Integer userId;

	@ApiModelProperty(value = "用户类型：1投诉人，2处理人")
	private Integer userType;

	@ApiModelProperty(value = "创建人id",hidden = true)
	private Integer createUserId;

	@ApiModelProperty(value = "处理人id",hidden = true)
	private Integer dealUserId;

	@ApiModelProperty(value = "公司id", hidden = true)
	private Integer compId;

	@ApiModelProperty(value = "审核类型")
	private Integer auditType;

	@ApiModelProperty("是否导出 1导出")
	private Byte isExport;

	@ApiModelProperty(value = "大区id", hidden = true)
	private Integer areaId;

	@ApiModelProperty(value = "片区id", hidden = true)
	private Integer regId;

	@ApiModelProperty(value = "门店id", hidden = true)
	private Integer deptId;

	@ApiModelProperty(value = "分组id", hidden = true)
	private Integer grId;

	@ApiModelProperty(value = "审核来源1=跟进类审核 2=请假审核 3=外出审核",hidden = true)
	private Byte auditResource;
	
	@ApiModelProperty(value = "审核状态，0=审核中 1=审核全部通过 2=未通过")
	private Byte auditStatus;
	
	@ApiModelProperty(value = "开始时间 yyyy-MM-dd HH:mm:ss")
	private String startTime;
	
	@ApiModelProperty(value = "结束时间 yyyy-MM-dd HH:mm:ss")
	private String endTime;
	
	@ApiModelProperty(value = "审核类型集合", hidden = true)
	private List<String> auditTypeArr;
	@ApiModelProperty(value = "当前登录人id",hidden = true)
	private Integer selfUserId;

	public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}

	public Byte getIsExport() {
		return isExport;
	}

	public void setIsExport(Byte isExport) {
		this.isExport = isExport;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getDealUserId() {
		return dealUserId;
	}

	public void setDealUserId(Integer dealUserId) {
		this.dealUserId = dealUserId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getAuditType() {
		return auditType;
	}

	public void setAuditType(Integer auditType) {
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
}