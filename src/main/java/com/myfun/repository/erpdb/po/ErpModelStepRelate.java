package com.myfun.repository.erpdb.po;

import java.io.Serializable;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

public class ErpModelStepRelate extends ShardDb implements Serializable {

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
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte seqSort;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer timelimit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte timelimitType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer rpevstepId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String rpevstepName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 步骤ID
	 */
	public Integer getStepId() {
		return stepId;
	}

	/**
	 * @mbggenerated 步骤ID
	 */
	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	/**
	 * @mbggenerated 流程ID
	 */
	public Integer getModelId() {
		return modelId;
	}

	/**
	 * @mbggenerated 流程ID
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 步骤序号
	 */
	public Byte getStepSeq() {
		return stepSeq;
	}

	/**
	 * @mbggenerated 步骤序号
	 */
	public void setStepSeq(Byte stepSeq) {
		this.stepSeq = stepSeq;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getSeqSort() {
		return seqSort;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSeqSort(Byte seqSort) {
		this.seqSort = seqSort;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getTimelimit() {
		return timelimit;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTimelimit(Integer timelimit) {
		this.timelimit = timelimit;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getTimelimitType() {
		return timelimitType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTimelimitType(Byte timelimitType) {
		this.timelimitType = timelimitType;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getRpevstepId() {
		return rpevstepId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setRpevstepId(Integer rpevstepId) {
		this.rpevstepId = rpevstepId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getRpevstepName() {
		return rpevstepName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setRpevstepName(String rpevstepName) {
		this.rpevstepName = rpevstepName == null ? null : rpevstepName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpModelStepRelate() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpModelStepRelate(Integer shardCityId, Integer stepId, Integer modelId, Integer compId) {
		super(shardCityId);
		this.stepId = stepId;
		this.modelId = modelId;
		this.compId = compId;
	}
}