package com.myfun.erpWeb.managecenter.employeeFiles.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class UploadEmployeeFileParam implements EncryParamIfc {

	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer creatorUid;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	@ApiModelProperty(value = "文件类型，1=身份证 2=学历证书 3=荣誉证书 4=档案资料 5=其他资料")
	private Byte fileType;
	@ApiModelProperty(value = "文件地址")
	private String fileUrl;
	@ApiModelProperty(value = "archiveId")
	private Integer archiveId;
	@ApiModelProperty(value = "FUN_EMPLOYEE_DOC表的主键Id")
	private Integer employeeDocId;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Byte getFileType() {
		return fileType;
	}
	public void setFileType(Byte fileType) {
		this.fileType = fileType;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public Integer getEmployeeDocId() {
		return employeeDocId;
	}
	public void setEmployeeDocId(Integer employeeDocId) {
		this.employeeDocId = employeeDocId;
	}
	public Integer getCreatorUid() {
		return creatorUid;
	}
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}
}
