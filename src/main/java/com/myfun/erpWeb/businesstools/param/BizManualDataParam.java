package com.myfun.erpWeb.businesstools.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BizManualDataParam extends AbstractEncryParam {
	@ApiModelProperty(value = "主键ID")
	private Integer muId;
	@ApiModelProperty(value = "业务手册名字")
	private String menualName;
	@ApiModelProperty(value = "业务手册类型 1=公司制度 2=行业技能 3=成功案例")
	private Byte menualType;
	@ApiModelProperty(value = "来源")
	private String menualSourse;
	@ApiModelProperty(value = "业务内容")
	private String menualContent;
	@ApiModelProperty(value = "业务手册编号")
	private String menualNo;

	public Integer getMuId() {
		return muId;
	}

	public void setMuId(Integer muId) {
		this.muId = muId;
	}

	public String getMenualName() {
		return menualName;
	}

	public void setMenualName(String menualName) {
		this.menualName = menualName;
	}

	public Byte getMenualType() {
		return menualType;
	}

	public void setMenualType(Byte menualType) {
		this.menualType = menualType;
	}

	public String getMenualSourse() {
		return menualSourse;
	}

	public void setMenualSourse(String menualSourse) {
		this.menualSourse = menualSourse;
	}

	public String getMenualContent() {
		return menualContent;
	}

	public void setMenualContent(String menualContent) {
		this.menualContent = menualContent;
	}

	public String getMenualNo() {
		return menualNo;
	}

	public void setMenualNo(String menualNo) {
		this.menualNo = menualNo;
	}
}
