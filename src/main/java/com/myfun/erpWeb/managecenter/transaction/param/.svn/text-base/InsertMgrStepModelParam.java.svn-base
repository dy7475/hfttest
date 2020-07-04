package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class InsertMgrStepModelParam implements EncryParamIfc {
	@ApiModelProperty(value = "流程名称")
	private String proName;
	@ApiModelProperty(value = "步骤,按所排顺序传值如 2898,2890,2896 (修改和插入的时候传此参数)")
	private String stepIds;
	
	@ApiModelProperty(value = "取消的步骤,传值如 2898,2890,2896 (取消以前选中步骤的时候传此参数)")
	private String cancelStepIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "步骤ID")
	private Integer stepId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "流程ID")
	private Integer modelId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "步骤序号")
	private Byte stepSeq;

	@ApiModelProperty(value = "条件步骤的ID")
	private String conditionStepIds;

	public String getConditionStepIds() {
		return conditionStepIds;
	}

	public void setConditionStepIds(String conditionStepIds) {
		this.conditionStepIds = conditionStepIds;
	}

	public String getStepIds() {
		return stepIds;
	}

	public void setStepIds(String stepIds) {
		this.stepIds = stepIds;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getCancelStepIds() {
		return cancelStepIds;
	}

	public void setCancelStepIds(String cancelStepIds) {
		this.cancelStepIds = cancelStepIds;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

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

	public Byte getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(Byte stepSeq) {
		this.stepSeq = stepSeq;
	}
}
