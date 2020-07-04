package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModelProperty;

public class EnclosureVo {
	@ApiModelProperty("房源类型：3.业主身份类")
	private Integer fileClass;
	@ApiModelProperty("房源类型描述")
	private String fileClassName;
	@ApiModelProperty("房源附件类型：10:产权人身份证;11:产权人户口本;12:共有权人身份证;13:共有权人同意销售声明;14:代理人委托书;;15:代理人身份证;16:公正委托书;")
	private Integer fileType;
	@ApiModelProperty("房源附件类型描述")
	private String fileTypeName;
	@ApiModelProperty("附件地址")
	private String fileAddr;
	public Integer getFileClass() {
		return fileClass;
	}
	public void setFileClass(Integer fileClass) {
		this.fileClass = fileClass;
	}
	public String getFileClassName() {
		return fileClassName;
	}
	public void setFileClassName(String fileClassName) {
		this.fileClassName = fileClassName;
	}
	public Integer getFileType() {
		return fileType;
	}
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	public String getFileTypeName() {
		return fileTypeName;
	}
	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}
	public String getFileAddr() {
		return fileAddr;
	}
	public void setFileAddr(String fileAddr) {
		this.fileAddr = fileAddr;
	}
	
	
}
