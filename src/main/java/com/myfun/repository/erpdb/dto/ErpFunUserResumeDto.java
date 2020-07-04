package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunUserResume;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunUserResumeDto extends ErpFunUserResume {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户头像")
	private String userPhoto;

	@ApiModelProperty(value = "历程发生时间")
	private String occurrenceTimeStr;
	
	
	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getOccurrenceTimeStr() {
		return occurrenceTimeStr;
	}

	public void setOccurrenceTimeStr(String occurrenceTimeStr) {
		this.occurrenceTimeStr = occurrenceTimeStr;
	}
}
