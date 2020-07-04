package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CompDefineTemplateParam extends AbstractEncryParam {


	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true, value = "userId", example = "6637075")
	private Integer compId;
	@ApiModelProperty("类型")
	private String type;
	@ApiModelProperty("房客类型")
	private Byte caseType;
	@ApiModelProperty("类型 0：公司 1：个人")
	private Byte queryType;
	@ApiModelProperty("类型")
	private String types;
	@ApiModelProperty("用途")
	private Byte useage;
	@ApiModelProperty(hidden = true)
	private Integer archiveId;

	public Byte getUseage() {
		return useage;
	}

	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public Byte getQueryType() {
		return queryType;
	}

	public void setQueryType(Byte queryType) {
		this.queryType = queryType;
	}
}
