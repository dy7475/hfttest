package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 知页验证请求参数
 * @author 张宏利
 * @since 2017年5月18日
 */
@ApiModel
public class AdminZhiYeViewLogParam extends AbstractEncryParam implements DaoBaseParam {
	@ApiModelProperty(value = "专题ID")
	private String subjectId;// 专题ID
	@ApiModelProperty(value = "课程类型")
	private String coursesType;// 课程类型
	@ApiModelProperty(value = "课程ID")
	private String coursesId;// 课程ID
	@ApiModelProperty(value = "媒体ID")
	private String mediaId;// 媒体ID
	private static final long serialVersionUID = 1L;

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getCoursesType() {
		return coursesType;
	}

	public void setCoursesType(String coursesType) {
		this.coursesType = coursesType;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}

}