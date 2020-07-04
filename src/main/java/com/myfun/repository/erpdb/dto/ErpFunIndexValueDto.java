package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunIndexValue;

public class ErpFunIndexValueDto extends ErpFunIndexValue{

	private String indexName;
	private String indexType;
	private String indexFormat;
	private String indexUnit;
	private Integer underLine;
	private String other;
	private Integer required;
	private String uniqueKey;
	private String funDealField;

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIndexType() {
		return indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

	public String getIndexFormat() {
		return indexFormat;
	}

	public void setIndexFormat(String indexFormat) {
		this.indexFormat = indexFormat;
	}

	public String getIndexUnit() {
		return indexUnit;
	}

	public void setIndexUnit(String indexUnit) {
		this.indexUnit = indexUnit;
	}

	public Integer getUnderLine() {
		return underLine;
	}

	public void setUnderLine(Integer underLine) {
		this.underLine = underLine;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getRequired() {
		return required;
	}

	public void setRequired(Integer required) {
		this.required = required;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getFunDealField() {
		return funDealField;
	}

	public void setFunDealField(String funDealField) {
		this.funDealField = funDealField;
	}
}
