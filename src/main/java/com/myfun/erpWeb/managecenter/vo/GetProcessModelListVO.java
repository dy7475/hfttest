package com.myfun.erpWeb.managecenter.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetProcessModelListVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("模板ID")
	private Integer modelId;
	
	@ApiModelProperty("公司ID")
	private Integer compId;
	
	@ApiModelProperty("是否是优家")
	private Byte youStatus;
	
	@ApiModelProperty("流程名称")
	private String proName;
	
	@ApiModelProperty("权证项目类别名称")
	private String modelNo;
	
	@ApiModelProperty("操作步骤步数")
	private Integer stepCount;

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Byte getYouStatus() {
		return youStatus;
	}

	public void setYouStatus(Byte youStatus) {
		this.youStatus = youStatus;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public Integer getStepCount() {
		return stepCount;
	}

	public void setStepCount(Integer stepCount) {
		this.stepCount = stepCount;
	}

}
