package com.myfun.erpWeb.house.vo;

import com.myfun.repository.erpdb.po.ErpFunVideo;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunVideoVo extends ErpFunVideo{
	@ApiModelProperty("操作人")
	private Integer uploadSourceUser;
	@ApiModelProperty("删除标记 0.否，1.是")
	private Integer delFlag;

	public Integer getUploadSourceUser() {
		return uploadSourceUser;
	}

	public void setUploadSourceUser(Integer uploadSourceUser) {
		this.uploadSourceUser = uploadSourceUser;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
		
		
		
}
