package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("公司角色VO")
public class ErpFunHeadVo {

	@ApiModelProperty("主键序列ID")
	private Integer headId;
	@ApiModelProperty("公司ID(默认为0)")
	private Integer compId;
	@ApiModelProperty("类型:出售、出租、求购、求租，DD:CASE_TYPE")
	private Byte caseType;
	@ApiModelProperty("表头显示名")
	private String headName;
	@ApiModelProperty("客户端便于找到对应的值")
	private String headValue;
	@ApiModelProperty("序号")
	private Integer headSeq;
	@ApiModelProperty("是否为必显，1:必显(不可选) 0：可选择")
	private Byte headType;
	@ApiModelProperty("显示与否，1：显示 0:不显示")
	private Byte headShow;
	@ApiModelProperty("更新时间")
	private Date headUpdateTime;
	@ApiModelProperty("表头宽度")
	private Integer headRatio;


	public Integer getHeadId() {
		return headId;
	}

	public void setHeadId(Integer headId) {
		this.headId = headId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getHeadValue() {
		return headValue;
	}

	public void setHeadValue(String headValue) {
		this.headValue = headValue;
	}

	public Integer getHeadSeq() {
		return headSeq;
	}

	public void setHeadSeq(Integer headSeq) {
		this.headSeq = headSeq;
	}

	public Byte getHeadType() {
		return headType;
	}

	public void setHeadType(Byte headType) {
		this.headType = headType;
	}

	public Byte getHeadShow() {
		return headShow;
	}

	public void setHeadShow(Byte headShow) {
		this.headShow = headShow;
	}

	public Date getHeadUpdateTime() {
		return headUpdateTime;
	}

	public void setHeadUpdateTime(Date headUpdateTime) {
		this.headUpdateTime = headUpdateTime;
	}

	public Integer getHeadRatio() {
		return headRatio;
	}

	public void setHeadRatio(Integer headRatio) {
		this.headRatio = headRatio;
	}
}
