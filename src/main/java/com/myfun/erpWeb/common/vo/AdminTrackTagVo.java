package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("公司角色VO")
public class AdminTrackTagVo {

	@ApiModelProperty(value= "自增主键")
	private Integer id;
	@ApiModelProperty(value= "TAG_ID")
	private Integer tagId;
	@ApiModelProperty(value= "出售出租求购求租1234")
	private Byte caseType;
	@ApiModelProperty(value= "跟进数据字典的DIC_VALUE")
	private String trackTypeValue;
	@ApiModelProperty(value= "分数")
	private Integer score;
	@ApiModelProperty(value= "中文值")
	private String tagMsg;
	@ApiModelProperty(value= "是否删除")
	private Byte isDel;
	@ApiModelProperty(value= "最后更新时间")
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getTagMsg() {
		return tagMsg;
	}

	public void setTagMsg(String tagMsg) {
		this.tagMsg = tagMsg;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
