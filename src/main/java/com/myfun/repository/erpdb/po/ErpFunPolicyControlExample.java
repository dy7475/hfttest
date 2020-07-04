package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class ErpFunPolicyControlExample extends ShardDb {
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
	public ErpFunPolicyControlExample() {
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

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
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

		public Criteria andCaseTypeIsNull() {
			addCriterion("CASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNotNull() {
			addCriterion("CASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeEqualTo(Integer value) {
			addCriterion("CASE_TYPE =", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotEqualTo(Integer value) {
			addCriterion("CASE_TYPE <>", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThan(Integer value) {
			addCriterion("CASE_TYPE >", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE >=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThan(Integer value) {
			addCriterion("CASE_TYPE <", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE <=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIn(List<Integer> values) {
			addCriterion("CASE_TYPE in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotIn(List<Integer> values) {
			addCriterion("CASE_TYPE not in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE not between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andTrackDayIsNull() {
			addCriterion("TRACK_DAY is null");
			return (Criteria) this;
		}

		public Criteria andTrackDayIsNotNull() {
			addCriterion("TRACK_DAY is not null");
			return (Criteria) this;
		}

		public Criteria andTrackDayEqualTo(Integer value) {
			addCriterion("TRACK_DAY =", value, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayNotEqualTo(Integer value) {
			addCriterion("TRACK_DAY <>", value, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayGreaterThan(Integer value) {
			addCriterion("TRACK_DAY >", value, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRACK_DAY >=", value, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayLessThan(Integer value) {
			addCriterion("TRACK_DAY <", value, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayLessThanOrEqualTo(Integer value) {
			addCriterion("TRACK_DAY <=", value, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayIn(List<Integer> values) {
			addCriterion("TRACK_DAY in", values, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayNotIn(List<Integer> values) {
			addCriterion("TRACK_DAY not in", values, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_DAY between", value1, value2, "trackDay");
			return (Criteria) this;
		}

		public Criteria andTrackDayNotBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_DAY not between", value1, value2, "trackDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayIsNull() {
			addCriterion("FANGKAN_DAY is null");
			return (Criteria) this;
		}

		public Criteria andFangkanDayIsNotNull() {
			addCriterion("FANGKAN_DAY is not null");
			return (Criteria) this;
		}

		public Criteria andFangkanDayEqualTo(Integer value) {
			addCriterion("FANGKAN_DAY =", value, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayNotEqualTo(Integer value) {
			addCriterion("FANGKAN_DAY <>", value, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayGreaterThan(Integer value) {
			addCriterion("FANGKAN_DAY >", value, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayGreaterThanOrEqualTo(Integer value) {
			addCriterion("FANGKAN_DAY >=", value, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayLessThan(Integer value) {
			addCriterion("FANGKAN_DAY <", value, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayLessThanOrEqualTo(Integer value) {
			addCriterion("FANGKAN_DAY <=", value, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayIn(List<Integer> values) {
			addCriterion("FANGKAN_DAY in", values, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayNotIn(List<Integer> values) {
			addCriterion("FANGKAN_DAY not in", values, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayBetween(Integer value1, Integer value2) {
			addCriterion("FANGKAN_DAY between", value1, value2, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andFangkanDayNotBetween(Integer value1, Integer value2) {
			addCriterion("FANGKAN_DAY not between", value1, value2, "fangkanDay");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("UPDATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("UPDATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeIsNull() {
			addCriterion("CREATION_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreationTimeIsNotNull() {
			addCriterion("CREATION_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreationTimeEqualTo(Date value) {
			addCriterion("CREATION_TIME =", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotEqualTo(Date value) {
			addCriterion("CREATION_TIME <>", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeGreaterThan(Date value) {
			addCriterion("CREATION_TIME >", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATION_TIME >=", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeLessThan(Date value) {
			addCriterion("CREATION_TIME <", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATION_TIME <=", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeIn(List<Date> values) {
			addCriterion("CREATION_TIME in", values, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotIn(List<Date> values) {
			addCriterion("CREATION_TIME not in", values, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeBetween(Date value1, Date value2) {
			addCriterion("CREATION_TIME between", value1, value2, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATION_TIME not between", value1, value2, "creationTime");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartIsNull() {
			addCriterion("MODIFY_PRICE_START is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartIsNotNull() {
			addCriterion("MODIFY_PRICE_START is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_START =", value, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartNotEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_START <>", value, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartGreaterThan(Date value) {
			addCriterion("MODIFY_PRICE_START >", value, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartGreaterThanOrEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_START >=", value, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartLessThan(Date value) {
			addCriterion("MODIFY_PRICE_START <", value, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartLessThanOrEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_START <=", value, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartIn(List<Date> values) {
			addCriterion("MODIFY_PRICE_START in", values, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartNotIn(List<Date> values) {
			addCriterion("MODIFY_PRICE_START not in", values, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartBetween(Date value1, Date value2) {
			addCriterion("MODIFY_PRICE_START between", value1, value2, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceStartNotBetween(Date value1, Date value2) {
			addCriterion("MODIFY_PRICE_START not between", value1, value2, "modifyPriceStart");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforIsNull() {
			addCriterion("MODIFY_PRICE_BEFOR is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforIsNotNull() {
			addCriterion("MODIFY_PRICE_BEFOR is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_BEFOR =", value, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforNotEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_BEFOR <>", value, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforGreaterThan(BigDecimal value) {
			addCriterion("MODIFY_PRICE_BEFOR >", value, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_BEFOR >=", value, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforLessThan(BigDecimal value) {
			addCriterion("MODIFY_PRICE_BEFOR <", value, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_BEFOR <=", value, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforIn(List<BigDecimal> values) {
			addCriterion("MODIFY_PRICE_BEFOR in", values, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforNotIn(List<BigDecimal> values) {
			addCriterion("MODIFY_PRICE_BEFOR not in", values, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MODIFY_PRICE_BEFOR between", value1, value2, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceBeforNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MODIFY_PRICE_BEFOR not between", value1, value2, "modifyPriceBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterIsNull() {
			addCriterion("MODIFY_PRICE_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterIsNotNull() {
			addCriterion("MODIFY_PRICE_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_AFTER =", value, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterNotEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_AFTER <>", value, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterGreaterThan(BigDecimal value) {
			addCriterion("MODIFY_PRICE_AFTER >", value, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_AFTER >=", value, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterLessThan(BigDecimal value) {
			addCriterion("MODIFY_PRICE_AFTER <", value, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MODIFY_PRICE_AFTER <=", value, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterIn(List<BigDecimal> values) {
			addCriterion("MODIFY_PRICE_AFTER in", values, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterNotIn(List<BigDecimal> values) {
			addCriterion("MODIFY_PRICE_AFTER not in", values, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MODIFY_PRICE_AFTER between", value1, value2, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceAfterNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MODIFY_PRICE_AFTER not between", value1, value2, "modifyPriceAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforIsNull() {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforIsNotNull() {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR =", value, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforNotEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR <>", value, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforGreaterThan(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR >", value, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforGreaterThanOrEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR >=", value, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforLessThan(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR <", value, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforLessThanOrEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR <=", value, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforIn(List<Byte> values) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR in", values, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforNotIn(List<Byte> values) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR not in", values, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforBetween(Byte value1, Byte value2) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR between", value1, value2, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitBeforNotBetween(Byte value1, Byte value2) {
			addCriterion("MODIFY_PRICE_UNIT_BEFOR not between", value1, value2, "modifyPriceUnitBefor");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterIsNull() {
			addCriterion("MODIFY_PRICE_UNIT_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterIsNotNull() {
			addCriterion("MODIFY_PRICE_UNIT_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER =", value, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterNotEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER <>", value, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterGreaterThan(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER >", value, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterGreaterThanOrEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER >=", value, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterLessThan(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER <", value, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterLessThanOrEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER <=", value, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterIn(List<Byte> values) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER in", values, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterNotIn(List<Byte> values) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER not in", values, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterBetween(Byte value1, Byte value2) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER between", value1, value2, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceUnitAfterNotBetween(Byte value1, Byte value2) {
			addCriterion("MODIFY_PRICE_UNIT_AFTER not between", value1, value2, "modifyPriceUnitAfter");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndIsNull() {
			addCriterion("MODIFY_PRICE_END is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndIsNotNull() {
			addCriterion("MODIFY_PRICE_END is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END =", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndNotEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END <>", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndGreaterThan(Date value) {
			addCriterion("MODIFY_PRICE_END >", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndGreaterThanOrEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END >=", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndLessThan(Date value) {
			addCriterion("MODIFY_PRICE_END <", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndLessThanOrEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END <=", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndIn(List<Date> values) {
			addCriterion("MODIFY_PRICE_END in", values, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndNotIn(List<Date> values) {
			addCriterion("MODIFY_PRICE_END not in", values, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndBetween(Date value1, Date value2) {
			addCriterion("MODIFY_PRICE_END between", value1, value2, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndNotBetween(Date value1, Date value2) {
			addCriterion("MODIFY_PRICE_END not between", value1, value2, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andLookCountIsNull() {
			addCriterion("LOOK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andLookCountIsNotNull() {
			addCriterion("LOOK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andLookCountEqualTo(Integer value) {
			addCriterion("LOOK_COUNT =", value, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountNotEqualTo(Integer value) {
			addCriterion("LOOK_COUNT <>", value, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountGreaterThan(Integer value) {
			addCriterion("LOOK_COUNT >", value, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("LOOK_COUNT >=", value, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountLessThan(Integer value) {
			addCriterion("LOOK_COUNT <", value, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountLessThanOrEqualTo(Integer value) {
			addCriterion("LOOK_COUNT <=", value, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountIn(List<Integer> values) {
			addCriterion("LOOK_COUNT in", values, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountNotIn(List<Integer> values) {
			addCriterion("LOOK_COUNT not in", values, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountBetween(Integer value1, Integer value2) {
			addCriterion("LOOK_COUNT between", value1, value2, "lookCount");
			return (Criteria) this;
		}

		public Criteria andLookCountNotBetween(Integer value1, Integer value2) {
			addCriterion("LOOK_COUNT not between", value1, value2, "lookCount");
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