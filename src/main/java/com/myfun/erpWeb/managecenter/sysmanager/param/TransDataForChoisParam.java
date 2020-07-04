package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class TransDataForChoisParam implements EncryParamIfc {

	@ApiModelProperty(value = "多个类型用逗号隔开，1=出售 2=出租 3-求购 4=求租 5=联动客户", required = true)
	private String transDataType;
	@ApiModelProperty(value = "移交原因", required = true)
	private String transReson;
	@ApiModelProperty(value = "接收人ids,用逗号隔开", required = true)
	private String acceptUserIds;
	@ApiModelProperty(value = "接收人门店ids,用逗号隔开", required = true)
	private String acceptDeptIds;
	@ApiModelProperty(value = "来源userId", required = true)
	private Integer srcUserId;
	@ApiModelProperty(value = "接受的分组Id")
	private Integer acceptGrId;
	@ApiModelProperty(value = "来源deptId", required = true)
	private Integer srcDeptId;
	public Integer getAcceptGrId() {
		return acceptGrId;
	}
	public void setAcceptGrId(Integer acceptGrId) {
		this.acceptGrId = acceptGrId;
	}
	public Integer getSrcDeptId() {
		return srcDeptId;
	}
	public void setSrcDeptId(Integer srcDeptId) {
		this.srcDeptId = srcDeptId;
	}
	public String getTransDataType() {
		return transDataType;
	}
	public void setTransDataType(String transDataType) {
		this.transDataType = transDataType;
	}
	public String getTransReson() {
		return transReson;
	}
	public void setTransReson(String transReson) {
		this.transReson = transReson;
	}
	public String getAcceptUserIds() {
		return acceptUserIds;
	}
	public void setAcceptUserIds(String acceptUserIds) {
		this.acceptUserIds = acceptUserIds;
	}
	public String getAcceptDeptIds() {
		return acceptDeptIds;
	}
	public void setAcceptDeptIds(String acceptDeptIds) {
		this.acceptDeptIds = acceptDeptIds;
	}
	public Integer getSrcUserId() {
		return srcUserId;
	}
	public void setSrcUserId(Integer srcUserId) {
		this.srcUserId = srcUserId;
	}
}
