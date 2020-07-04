package com.myfun.erpWeb.businesstools.zhiye.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class AdminZhiyeTestRecordsParam extends AbstractEncryParam {

	@ApiModelProperty(value = "好房通用户唯一标识", required = true)
	private Integer brokerId;
	@ApiModelProperty(value = "试题编号", required = true)
	private Integer examId;
	@ApiModelProperty(value = "试题名称", required = true)
	private String examName;
	@ApiModelProperty(value = "专题ID", required = true)
	private Integer subjectId;
	public Integer getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
}
