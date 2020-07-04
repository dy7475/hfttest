package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "委托确认带看书模版VO")
public class ErpFunProxyTemplateVo implements Serializable {

	/**
	 *  主键
	 */
	@ApiModelProperty("主键ID")
	private Integer id;
	/**
	 *  公司ID
	 */
	@ApiModelProperty("公司ID")
	private Integer compId;
	/**
	 *  1:带看确认书 2：委托书
	 */
	@ApiModelProperty("模版类型（1:带看确认书 2：委托书）")
	private Byte templateType;
	/**
	 *  创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;
	/**
	 *  模版内容
	 */
	@ApiModelProperty("模版内容")
	private String templateContent;
	/**
	 *  101=买卖 102=租赁
	 */
	@ApiModelProperty("101=买卖 102=租赁")
	private Byte caseType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Byte getTemplateType() {
		return templateType;
	}

	public void setTemplateType(Byte templateType) {
		this.templateType = templateType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}
}
