package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpModelStepRelateKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer stepId;
	/**
	 * @mbggenerated
	 */
	private Integer modelId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getStepId() {
		return stepId;
	}

	/**
	 * @mbggenerated
	 */
	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getModelId() {
		return modelId;
	}

	/**
	 * @mbggenerated
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpModelStepRelateKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpModelStepRelateKey(Integer shardCityId, Integer stepId, Integer modelId, Integer compId) {
		super(shardCityId);
		this.stepId = stepId;
		this.modelId = modelId;
		this.compId = compId;
	}
}