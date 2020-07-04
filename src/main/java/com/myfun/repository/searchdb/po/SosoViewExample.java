package com.myfun.repository.searchdb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SosoViewExample {
    /**
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * @mbggenerated
	 */
	public SosoViewExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * @mbggenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * @mbggenerated
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andArchiveIdIsNull() {
			addCriterion("ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIsNotNull() {
			addCriterion("ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID =", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <>", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThan(Integer value) {
			addCriterion("ARCHIVE_ID >", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID >=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThan(Integer value) {
			addCriterion("ARCHIVE_ID <", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID not in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID between", value1, value2, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID not between", value1, value2, "archiveId");
			return (Criteria) this;
		}

		public Criteria andSosoIdIsNull() {
			addCriterion("SOSO_ID is null");
			return (Criteria) this;
		}

		public Criteria andSosoIdIsNotNull() {
			addCriterion("SOSO_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSosoIdEqualTo(Integer value) {
			addCriterion("SOSO_ID =", value, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdNotEqualTo(Integer value) {
			addCriterion("SOSO_ID <>", value, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdGreaterThan(Integer value) {
			addCriterion("SOSO_ID >", value, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SOSO_ID >=", value, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdLessThan(Integer value) {
			addCriterion("SOSO_ID <", value, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdLessThanOrEqualTo(Integer value) {
			addCriterion("SOSO_ID <=", value, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdIn(List<Integer> values) {
			addCriterion("SOSO_ID in", values, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdNotIn(List<Integer> values) {
			addCriterion("SOSO_ID not in", values, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_ID between", value1, value2, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_ID not between", value1, value2, "sosoId");
			return (Criteria) this;
		}

		public Criteria andSosoTypeIsNull() {
			addCriterion("SOSO_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSosoTypeIsNotNull() {
			addCriterion("SOSO_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSosoTypeEqualTo(Integer value) {
			addCriterion("SOSO_TYPE =", value, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeNotEqualTo(Integer value) {
			addCriterion("SOSO_TYPE <>", value, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeGreaterThan(Integer value) {
			addCriterion("SOSO_TYPE >", value, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("SOSO_TYPE >=", value, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeLessThan(Integer value) {
			addCriterion("SOSO_TYPE <", value, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeLessThanOrEqualTo(Integer value) {
			addCriterion("SOSO_TYPE <=", value, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeIn(List<Integer> values) {
			addCriterion("SOSO_TYPE in", values, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeNotIn(List<Integer> values) {
			addCriterion("SOSO_TYPE not in", values, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_TYPE between", value1, value2, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_TYPE not between", value1, value2, "sosoType");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyIsNull() {
			addCriterion("SOSO_PROPERTY is null");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyIsNotNull() {
			addCriterion("SOSO_PROPERTY is not null");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyEqualTo(Integer value) {
			addCriterion("SOSO_PROPERTY =", value, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyNotEqualTo(Integer value) {
			addCriterion("SOSO_PROPERTY <>", value, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyGreaterThan(Integer value) {
			addCriterion("SOSO_PROPERTY >", value, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyGreaterThanOrEqualTo(Integer value) {
			addCriterion("SOSO_PROPERTY >=", value, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyLessThan(Integer value) {
			addCriterion("SOSO_PROPERTY <", value, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyLessThanOrEqualTo(Integer value) {
			addCriterion("SOSO_PROPERTY <=", value, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyIn(List<Integer> values) {
			addCriterion("SOSO_PROPERTY in", values, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyNotIn(List<Integer> values) {
			addCriterion("SOSO_PROPERTY not in", values, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_PROPERTY between", value1, value2, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andSosoPropertyNotBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_PROPERTY not between", value1, value2, "sosoProperty");
			return (Criteria) this;
		}

		public Criteria andViewTimeIsNull() {
			addCriterion("VIEW_TIME is null");
			return (Criteria) this;
		}

		public Criteria andViewTimeIsNotNull() {
			addCriterion("VIEW_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andViewTimeEqualTo(Date value) {
			addCriterion("VIEW_TIME =", value, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeNotEqualTo(Date value) {
			addCriterion("VIEW_TIME <>", value, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeGreaterThan(Date value) {
			addCriterion("VIEW_TIME >", value, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("VIEW_TIME >=", value, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeLessThan(Date value) {
			addCriterion("VIEW_TIME <", value, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeLessThanOrEqualTo(Date value) {
			addCriterion("VIEW_TIME <=", value, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeIn(List<Date> values) {
			addCriterion("VIEW_TIME in", values, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeNotIn(List<Date> values) {
			addCriterion("VIEW_TIME not in", values, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeBetween(Date value1, Date value2) {
			addCriterion("VIEW_TIME between", value1, value2, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewTimeNotBetween(Date value1, Date value2) {
			addCriterion("VIEW_TIME not between", value1, value2, "viewTime");
			return (Criteria) this;
		}

		public Criteria andViewSourceIsNull() {
			addCriterion("VIEW_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andViewSourceIsNotNull() {
			addCriterion("VIEW_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andViewSourceEqualTo(Byte value) {
			addCriterion("VIEW_SOURCE =", value, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceNotEqualTo(Byte value) {
			addCriterion("VIEW_SOURCE <>", value, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceGreaterThan(Byte value) {
			addCriterion("VIEW_SOURCE >", value, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("VIEW_SOURCE >=", value, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceLessThan(Byte value) {
			addCriterion("VIEW_SOURCE <", value, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceLessThanOrEqualTo(Byte value) {
			addCriterion("VIEW_SOURCE <=", value, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceIn(List<Byte> values) {
			addCriterion("VIEW_SOURCE in", values, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceNotIn(List<Byte> values) {
			addCriterion("VIEW_SOURCE not in", values, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceBetween(Byte value1, Byte value2) {
			addCriterion("VIEW_SOURCE between", value1, value2, "viewSource");
			return (Criteria) this;
		}

		public Criteria andViewSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("VIEW_SOURCE not between", value1, value2, "viewSource");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagIsNull() {
			addCriterion("PERPETUAL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagIsNotNull() {
			addCriterion("PERPETUAL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagEqualTo(Byte value) {
			addCriterion("PERPETUAL_FLAG =", value, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagNotEqualTo(Byte value) {
			addCriterion("PERPETUAL_FLAG <>", value, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagGreaterThan(Byte value) {
			addCriterion("PERPETUAL_FLAG >", value, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("PERPETUAL_FLAG >=", value, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagLessThan(Byte value) {
			addCriterion("PERPETUAL_FLAG <", value, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagLessThanOrEqualTo(Byte value) {
			addCriterion("PERPETUAL_FLAG <=", value, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagIn(List<Byte> values) {
			addCriterion("PERPETUAL_FLAG in", values, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagNotIn(List<Byte> values) {
			addCriterion("PERPETUAL_FLAG not in", values, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagBetween(Byte value1, Byte value2) {
			addCriterion("PERPETUAL_FLAG between", value1, value2, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andPerpetualFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("PERPETUAL_FLAG not between", value1, value2, "perpetualFlag");
			return (Criteria) this;
		}

		public Criteria andIsConvertIsNull() {
			addCriterion("IS_CONVERT is null");
			return (Criteria) this;
		}

		public Criteria andIsConvertIsNotNull() {
			addCriterion("IS_CONVERT is not null");
			return (Criteria) this;
		}

		public Criteria andIsConvertEqualTo(Byte value) {
			addCriterion("IS_CONVERT =", value, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertNotEqualTo(Byte value) {
			addCriterion("IS_CONVERT <>", value, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertGreaterThan(Byte value) {
			addCriterion("IS_CONVERT >", value, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_CONVERT >=", value, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertLessThan(Byte value) {
			addCriterion("IS_CONVERT <", value, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertLessThanOrEqualTo(Byte value) {
			addCriterion("IS_CONVERT <=", value, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertIn(List<Byte> values) {
			addCriterion("IS_CONVERT in", values, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertNotIn(List<Byte> values) {
			addCriterion("IS_CONVERT not in", values, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertBetween(Byte value1, Byte value2) {
			addCriterion("IS_CONVERT between", value1, value2, "isConvert");
			return (Criteria) this;
		}

		public Criteria andIsConvertNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_CONVERT not between", value1, value2, "isConvert");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIsNull() {
			addCriterion("CONVERT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIsNotNull() {
			addCriterion("CONVERT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andConvertTimeEqualTo(Date value) {
			addCriterion("CONVERT_TIME =", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotEqualTo(Date value) {
			addCriterion("CONVERT_TIME <>", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeGreaterThan(Date value) {
			addCriterion("CONVERT_TIME >", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CONVERT_TIME >=", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeLessThan(Date value) {
			addCriterion("CONVERT_TIME <", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeLessThanOrEqualTo(Date value) {
			addCriterion("CONVERT_TIME <=", value, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeIn(List<Date> values) {
			addCriterion("CONVERT_TIME in", values, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotIn(List<Date> values) {
			addCriterion("CONVERT_TIME not in", values, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeBetween(Date value1, Date value2) {
			addCriterion("CONVERT_TIME between", value1, value2, "convertTime");
			return (Criteria) this;
		}

		public Criteria andConvertTimeNotBetween(Date value1, Date value2) {
			addCriterion("CONVERT_TIME not between", value1, value2, "convertTime");
			return (Criteria) this;
		}

		public Criteria andDataTypeIsNull() {
			addCriterion("DATA_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDataTypeIsNotNull() {
			addCriterion("DATA_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDataTypeEqualTo(Byte value) {
			addCriterion("DATA_TYPE =", value, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeNotEqualTo(Byte value) {
			addCriterion("DATA_TYPE <>", value, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeGreaterThan(Byte value) {
			addCriterion("DATA_TYPE >", value, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DATA_TYPE >=", value, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeLessThan(Byte value) {
			addCriterion("DATA_TYPE <", value, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeLessThanOrEqualTo(Byte value) {
			addCriterion("DATA_TYPE <=", value, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeIn(List<Byte> values) {
			addCriterion("DATA_TYPE in", values, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeNotIn(List<Byte> values) {
			addCriterion("DATA_TYPE not in", values, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeBetween(Byte value1, Byte value2) {
			addCriterion("DATA_TYPE between", value1, value2, "dataType");
			return (Criteria) this;
		}

		public Criteria andDataTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("DATA_TYPE not between", value1, value2, "dataType");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagIsNull() {
			addCriterion("COMPLAINT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagIsNotNull() {
			addCriterion("COMPLAINT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagEqualTo(Byte value) {
			addCriterion("COMPLAINT_FLAG =", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagNotEqualTo(Byte value) {
			addCriterion("COMPLAINT_FLAG <>", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagGreaterThan(Byte value) {
			addCriterion("COMPLAINT_FLAG >", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMPLAINT_FLAG >=", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagLessThan(Byte value) {
			addCriterion("COMPLAINT_FLAG <", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagLessThanOrEqualTo(Byte value) {
			addCriterion("COMPLAINT_FLAG <=", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagIn(List<Byte> values) {
			addCriterion("COMPLAINT_FLAG in", values, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagNotIn(List<Byte> values) {
			addCriterion("COMPLAINT_FLAG not in", values, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagBetween(Byte value1, Byte value2) {
			addCriterion("COMPLAINT_FLAG between", value1, value2, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("COMPLAINT_FLAG not between", value1, value2, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeIsNull() {
			addCriterion("COMPLAINT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeIsNotNull() {
			addCriterion("COMPLAINT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeEqualTo(Date value) {
			addCriterion("COMPLAINT_TIME =", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeNotEqualTo(Date value) {
			addCriterion("COMPLAINT_TIME <>", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeGreaterThan(Date value) {
			addCriterion("COMPLAINT_TIME >", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("COMPLAINT_TIME >=", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeLessThan(Date value) {
			addCriterion("COMPLAINT_TIME <", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeLessThanOrEqualTo(Date value) {
			addCriterion("COMPLAINT_TIME <=", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeIn(List<Date> values) {
			addCriterion("COMPLAINT_TIME in", values, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeNotIn(List<Date> values) {
			addCriterion("COMPLAINT_TIME not in", values, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeBetween(Date value1, Date value2) {
			addCriterion("COMPLAINT_TIME between", value1, value2, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeNotBetween(Date value1, Date value2) {
			addCriterion("COMPLAINT_TIME not between", value1, value2, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileIsNull() {
			addCriterion("EXCLUSIVE_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileIsNotNull() {
			addCriterion("EXCLUSIVE_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileEqualTo(String value) {
			addCriterion("EXCLUSIVE_MOBILE =", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileNotEqualTo(String value) {
			addCriterion("EXCLUSIVE_MOBILE <>", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileGreaterThan(String value) {
			addCriterion("EXCLUSIVE_MOBILE >", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileGreaterThanOrEqualTo(String value) {
			addCriterion("EXCLUSIVE_MOBILE >=", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileLessThan(String value) {
			addCriterion("EXCLUSIVE_MOBILE <", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileLessThanOrEqualTo(String value) {
			addCriterion("EXCLUSIVE_MOBILE <=", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileLike(String value) {
			addCriterion("EXCLUSIVE_MOBILE like", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileNotLike(String value) {
			addCriterion("EXCLUSIVE_MOBILE not like", value, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileIn(List<String> values) {
			addCriterion("EXCLUSIVE_MOBILE in", values, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileNotIn(List<String> values) {
			addCriterion("EXCLUSIVE_MOBILE not in", values, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileBetween(String value1, String value2) {
			addCriterion("EXCLUSIVE_MOBILE between", value1, value2, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andExclusiveMobileNotBetween(String value1, String value2) {
			addCriterion("EXCLUSIVE_MOBILE not between", value1, value2, "exclusiveMobile");
			return (Criteria) this;
		}

		public Criteria andDeptIdIsNull() {
			addCriterion("DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andDeptIdIsNotNull() {
			addCriterion("DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDeptIdEqualTo(Integer value) {
			addCriterion("DEPT_ID =", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotEqualTo(Integer value) {
			addCriterion("DEPT_ID <>", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThan(Integer value) {
			addCriterion("DEPT_ID >", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEPT_ID >=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThan(Integer value) {
			addCriterion("DEPT_ID <", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEPT_ID <=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdIn(List<Integer> values) {
			addCriterion("DEPT_ID in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotIn(List<Integer> values) {
			addCriterion("DEPT_ID not in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_ID between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_ID not between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andCompIdIsNull() {
			addCriterion("COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andCompIdIsNotNull() {
			addCriterion("COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCompIdEqualTo(Integer value) {
			addCriterion("COMP_ID =", value, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdNotEqualTo(Integer value) {
			addCriterion("COMP_ID <>", value, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdGreaterThan(Integer value) {
			addCriterion("COMP_ID >", value, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMP_ID >=", value, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdLessThan(Integer value) {
			addCriterion("COMP_ID <", value, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("COMP_ID <=", value, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdIn(List<Integer> values) {
			addCriterion("COMP_ID in", values, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdNotIn(List<Integer> values) {
			addCriterion("COMP_ID not in", values, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdBetween(Integer value1, Integer value2) {
			addCriterion("COMP_ID between", value1, value2, "compId");
			return (Criteria) this;
		}

		public Criteria andCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COMP_ID not between", value1, value2, "compId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNull() {
			addCriterion("CASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNotNull() {
			addCriterion("CASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCaseIdEqualTo(Integer value) {
			addCriterion("CASE_ID =", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotEqualTo(Integer value) {
			addCriterion("CASE_ID <>", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThan(Integer value) {
			addCriterion("CASE_ID >", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID >=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThan(Integer value) {
			addCriterion("CASE_ID <", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID <=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIn(List<Integer> values) {
			addCriterion("CASE_ID in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotIn(List<Integer> values) {
			addCriterion("CASE_ID not in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID not between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIsNull() {
			addCriterion("ERP_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIsNotNull() {
			addCriterion("ERP_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID =", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID <>", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdGreaterThan(Integer value) {
			addCriterion("ERP_DEPT_ID >", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID >=", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdLessThan(Integer value) {
			addCriterion("ERP_DEPT_ID <", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID <=", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIn(List<Integer> values) {
			addCriterion("ERP_DEPT_ID in", values, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotIn(List<Integer> values) {
			addCriterion("ERP_DEPT_ID not in", values, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_DEPT_ID between", value1, value2, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_DEPT_ID not between", value1, value2, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIsNull() {
			addCriterion("ERP_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIsNotNull() {
			addCriterion("ERP_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpCompIdEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID =", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID <>", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdGreaterThan(Integer value) {
			addCriterion("ERP_COMP_ID >", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID >=", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdLessThan(Integer value) {
			addCriterion("ERP_COMP_ID <", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID <=", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIn(List<Integer> values) {
			addCriterion("ERP_COMP_ID in", values, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotIn(List<Integer> values) {
			addCriterion("ERP_COMP_ID not in", values, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_COMP_ID between", value1, value2, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_COMP_ID not between", value1, value2, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNull() {
			addCriterion("CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNotNull() {
			addCriterion("CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCityIdEqualTo(Integer value) {
			addCriterion("CITY_ID =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Integer value) {
			addCriterion("CITY_ID <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Integer value) {
			addCriterion("CITY_ID >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CITY_ID >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Integer value) {
			addCriterion("CITY_ID <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Integer value) {
			addCriterion("CITY_ID <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Integer> values) {
			addCriterion("CITY_ID in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Integer> values) {
			addCriterion("CITY_ID not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Integer value1, Integer value2) {
			addCriterion("CITY_ID between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CITY_ID not between", value1, value2, "cityId");
			return (Criteria) this;
		}
	}

	/**
	 * @mbggenerated
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}