package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunContractIndex extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer indexId;
	/**
	 * @mbggenerated 指标名字
	 */
	private String indexName;
	/**
	 * @mbggenerated 指标类型
	 */
	private String indexType;
	/**
	 * @mbggenerated 指标格式
	 */
	private String indexFormat;
	/**
	 * @mbggenerated 指标单位
	 */
	private String indexUnit;
	/**
	 * @mbggenerated 下划线
	 */
	private Byte underLine;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 其他
	 */
	private String other;
	/**
	 * @mbggenerated 是否必填
	 */
	private Byte required;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 指标删除状态 1:正常 0:删除
	 */
	private Byte indexStatus;
	/**
	 * @mbggenerated
	 */
	private String funDealField;
	/**
	 * @mbggenerated
	 */
	private Byte indexGroup;
	/**
	 * @mbggenerated
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private String uniqueKey;
	/**
	 * @mbggenerated
	 */
	private Integer templateId;
	/**
	 * @mbggenerated
	 */
	private Integer indexSeq;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getIndexId() {
		return indexId;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexId(Integer indexId) {
		this.indexId = indexId;
	}

	/**
	 * @mbggenerated
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName == null ? null : indexName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getIndexType() {
		return indexType;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexType(String indexType) {
		this.indexType = indexType == null ? null : indexType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getIndexFormat() {
		return indexFormat;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexFormat(String indexFormat) {
		this.indexFormat = indexFormat == null ? null : indexFormat.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getIndexUnit() {
		return indexUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexUnit(String indexUnit) {
		this.indexUnit = indexUnit == null ? null : indexUnit.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUnderLine() {
		return underLine;
	}

	/**
	 * @mbggenerated
	 */
	public void setUnderLine(Byte underLine) {
		this.underLine = underLine;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @mbggenerated
	 */
	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRequired() {
		return required;
	}

	/**
	 * @mbggenerated
	 */
	public void setRequired(Byte required) {
		this.required = required;
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
	public Byte getIndexStatus() {
		return indexStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexStatus(Byte indexStatus) {
		this.indexStatus = indexStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getFunDealField() {
		return funDealField;
	}

	/**
	 * @mbggenerated
	 */
	public void setFunDealField(String funDealField) {
		this.funDealField = funDealField == null ? null : funDealField.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIndexGroup() {
		return indexGroup;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexGroup(Byte indexGroup) {
		this.indexGroup = indexGroup;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public String getUniqueKey() {
		return uniqueKey;
	}

	/**
	 * @mbggenerated
	 */
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getIndexSeq() {
		return indexSeq;
	}

	/**
	 * @mbggenerated
	 */
	public void setIndexSeq(Integer indexSeq) {
		this.indexSeq = indexSeq;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractIndex() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractIndex(Integer shardCityId, Integer indexId) {
		super(shardCityId);
		this.indexId = indexId;
	}
}