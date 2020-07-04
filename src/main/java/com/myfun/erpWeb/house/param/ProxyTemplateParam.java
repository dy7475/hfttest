package com.myfun.erpWeb.house.param;

import com.myfun.repository.erpdb.po.ErpFunProxyTemplate;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ProxyTemplateParam implements EncryParamIfc {
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "模版类型 1:带看确认书 2：委托书")
	private Byte templateType;
	@ApiModelProperty(value = "确认带看书必传 101=买卖 102=租赁")
	private Byte caseType;
	@ApiModelProperty(value = "模版内容")
	private String templateContent;
	@ApiModelProperty(value = "模版ID")
	private Integer id;

	public Byte getTemplateType() {
		return templateType;
	}

	public void setTemplateType(Byte templateType) {
		this.templateType = templateType;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getTemplateContent() {
		return templateContent;

	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

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
}
