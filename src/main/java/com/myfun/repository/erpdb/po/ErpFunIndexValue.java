package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunIndexValue extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer valueId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指标ID")
	private Integer indexId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同ID")
	private Integer contractId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "生成时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同原值")
	private String indexValueOriginal;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String uniqueKey;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String funDealField;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指标名称")
	private String indexName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指标值")
	private String indexValue;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getValueId() {
		return valueId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	/**
	 * @mbggenerated 指标ID
	 */
	public Integer getIndexId() {
		return indexId;
	}

	/**
	 * @mbggenerated 指标ID
	 */
	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public Integer getContractId() {
		return contractId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	/**
	 * @mbggenerated 生成时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 生成时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 合同原值
	 */
	public String getIndexValueOriginal() {
		return indexValueOriginal;
	}

	/**
	 * @mbggenerated 合同原值
	 */
	public void setIndexValueOriginal(String indexValueOriginal) {
		this.indexValueOriginal = indexValueOriginal == null ? null : indexValueOriginal.trim();
	}

	/**
	 * @mbggenerated -
	 */
	public String getUniqueKey() {
		return uniqueKey;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
	}

	/**
	 * @mbggenerated -
	 */
	public String getFunDealField() {
		return funDealField;
	}

	/**
	 * @mbggenerated -
	 */
	public void setFunDealField(String funDealField) {
		this.funDealField = funDealField == null ? null : funDealField.trim();
	}

	/**
	 * @mbggenerated 指标名称
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * @mbggenerated 指标名称
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName == null ? null : indexName.trim();
	}

	/**
	 * @mbggenerated 指标值
	 */
	public String getIndexValue() {
		return indexValue;
	}

	/**
	 * @mbggenerated 指标值
	 */
	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue == null ? null : indexValue.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunIndexValue() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunIndexValue(Integer shardCityId, Integer valueId) {
		super(shardCityId);
		this.valueId = valueId;
	}
}