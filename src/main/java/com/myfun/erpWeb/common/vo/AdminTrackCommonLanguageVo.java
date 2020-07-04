package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("公司角色VO")
public class AdminTrackCommonLanguageVo {

	@ApiModelProperty(value= "zjian")
	private Integer id;
	@ApiModelProperty(value= "出售出租求购求租1234")
	private Byte caseType;
	@ApiModelProperty(value= "跟进的值DIC_VALUE  数字")
	private String trackTypeValue;
	@ApiModelProperty(value= "跟进的值中文")
	private String commonLanguage;
	@ApiModelProperty(value= "最后更新时间")
	private Date updateTime;
	@ApiModelProperty(value= "是否删除")
	private Byte isDel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public String getTrackTypeValue() {
		return trackTypeValue;
	}

	public void setTrackTypeValue(String trackTypeValue) {
		this.trackTypeValue = trackTypeValue;
	}

	public String getCommonLanguage() {
		return commonLanguage;
	}

	public void setCommonLanguage(String commonLanguage) {
		this.commonLanguage = commonLanguage;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}
}
