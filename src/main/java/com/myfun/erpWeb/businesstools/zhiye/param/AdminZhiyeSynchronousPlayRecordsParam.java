package com.myfun.erpWeb.businesstools.zhiye.param;

import java.util.Date;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class AdminZhiyeSynchronousPlayRecordsParam extends AbstractEncryParam {

	@ApiModelProperty(value = "数据唯一标识", required = true)
	private Integer id;
	@ApiModelProperty(value = "好房通用户唯一标识", required = true)
	private Integer brokerId;
	@ApiModelProperty(value = "音视频编号", required = true)
	private Integer targetId;
	@ApiModelProperty(value = "音视频名称", required = true)
	private String targetName;
	@ApiModelProperty(value = "1视频，2音频", required = true)
	private Integer targetType;
	@ApiModelProperty(value = "课程Id", required = true)
	private Integer courseId;
	@ApiModelProperty(value = "课程名称", required = true)
	private Integer courseName;
	@ApiModelProperty(value = "专题ID", required = true)
	private Integer subjectId;
	@ApiModelProperty(value = "专题名称", required = true)
	private String subjectName;
	@ApiModelProperty(value = "创建时间", required = true)
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}
	public Integer getTargetId() {
		return targetId;
	}
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public Integer getTargetType() {
		return targetType;
	}
	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getCourseName() {
		return courseName;
	}
	public void setCourseName(Integer courseName) {
		this.courseName = courseName;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
