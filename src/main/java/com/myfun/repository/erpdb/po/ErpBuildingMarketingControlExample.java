package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpBuildingMarketingControlExample extends ShardDb {
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
	public ErpBuildingMarketingControlExample() {
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

		public Criteria andBuildIdIsNull() {
			addCriterion("BUILD_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildIdIsNotNull() {
			addCriterion("BUILD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildIdEqualTo(Integer value) {
			addCriterion("BUILD_ID =", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotEqualTo(Integer value) {
			addCriterion("BUILD_ID <>", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThan(Integer value) {
			addCriterion("BUILD_ID >", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID >=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThan(Integer value) {
			addCriterion("BUILD_ID <", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID <=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdIn(List<Integer> values) {
			addCriterion("BUILD_ID in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotIn(List<Integer> values) {
			addCriterion("BUILD_ID not in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID not between", value1, value2, "buildId");
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

		public Criteria andCaseTypeEqualTo(Byte value) {
			addCriterion("CASE_TYPE =", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotEqualTo(Byte value) {
			addCriterion("CASE_TYPE <>", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThan(Byte value) {
			addCriterion("CASE_TYPE >", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CASE_TYPE >=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThan(Byte value) {
			addCriterion("CASE_TYPE <", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CASE_TYPE <=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIn(List<Byte> values) {
			addCriterion("CASE_TYPE in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotIn(List<Byte> values) {
			addCriterion("CASE_TYPE not in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeBetween(Byte value1, Byte value2) {
			addCriterion("CASE_TYPE between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CASE_TYPE not between", value1, value2, "caseType");
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

		public Criteria andCaseNoIsNull() {
			addCriterion("CASE_NO is null");
			return (Criteria) this;
		}

		public Criteria andCaseNoIsNotNull() {
			addCriterion("CASE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCaseNoEqualTo(String value) {
			addCriterion("CASE_NO =", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotEqualTo(String value) {
			addCriterion("CASE_NO <>", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoGreaterThan(String value) {
			addCriterion("CASE_NO >", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoGreaterThanOrEqualTo(String value) {
			addCriterion("CASE_NO >=", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLessThan(String value) {
			addCriterion("CASE_NO <", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLessThanOrEqualTo(String value) {
			addCriterion("CASE_NO <=", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLike(String value) {
			addCriterion("CASE_NO like", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotLike(String value) {
			addCriterion("CASE_NO not like", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoIn(List<String> values) {
			addCriterion("CASE_NO in", values, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotIn(List<String> values) {
			addCriterion("CASE_NO not in", values, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoBetween(String value1, String value2) {
			addCriterion("CASE_NO between", value1, value2, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotBetween(String value1, String value2) {
			addCriterion("CASE_NO not between", value1, value2, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseStatusIsNull() {
			addCriterion("CASE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCaseStatusIsNotNull() {
			addCriterion("CASE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCaseStatusEqualTo(Byte value) {
			addCriterion("CASE_STATUS =", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusNotEqualTo(Byte value) {
			addCriterion("CASE_STATUS <>", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusGreaterThan(Byte value) {
			addCriterion("CASE_STATUS >", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("CASE_STATUS >=", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusLessThan(Byte value) {
			addCriterion("CASE_STATUS <", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusLessThanOrEqualTo(Byte value) {
			addCriterion("CASE_STATUS <=", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusIn(List<Byte> values) {
			addCriterion("CASE_STATUS in", values, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusNotIn(List<Byte> values) {
			addCriterion("CASE_STATUS not in", values, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusBetween(Byte value1, Byte value2) {
			addCriterion("CASE_STATUS between", value1, value2, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("CASE_STATUS not between", value1, value2, "caseStatus");
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

		public Criteria andMarketingControlMd5IsNull() {
			addCriterion("MARKETING_CONTROL_MD5 is null");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5IsNotNull() {
			addCriterion("MARKETING_CONTROL_MD5 is not null");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5EqualTo(String value) {
			addCriterion("MARKETING_CONTROL_MD5 =", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5NotEqualTo(String value) {
			addCriterion("MARKETING_CONTROL_MD5 <>", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5GreaterThan(String value) {
			addCriterion("MARKETING_CONTROL_MD5 >", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5GreaterThanOrEqualTo(String value) {
			addCriterion("MARKETING_CONTROL_MD5 >=", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5LessThan(String value) {
			addCriterion("MARKETING_CONTROL_MD5 <", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5LessThanOrEqualTo(String value) {
			addCriterion("MARKETING_CONTROL_MD5 <=", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5Like(String value) {
			addCriterion("MARKETING_CONTROL_MD5 like", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5NotLike(String value) {
			addCriterion("MARKETING_CONTROL_MD5 not like", value, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5In(List<String> values) {
			addCriterion("MARKETING_CONTROL_MD5 in", values, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5NotIn(List<String> values) {
			addCriterion("MARKETING_CONTROL_MD5 not in", values, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5Between(String value1, String value2) {
			addCriterion("MARKETING_CONTROL_MD5 between", value1, value2, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andMarketingControlMd5NotBetween(String value1, String value2) {
			addCriterion("MARKETING_CONTROL_MD5 not between", value1, value2, "marketingControlMd5");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIsNull() {
			addCriterion("BUILDING_SET_ROOF is null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIsNotNull() {
			addCriterion("BUILDING_SET_ROOF is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofEqualTo(String value) {
			addCriterion("BUILDING_SET_ROOF =", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofNotEqualTo(String value) {
			addCriterion("BUILDING_SET_ROOF <>", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofGreaterThan(String value) {
			addCriterion("BUILDING_SET_ROOF >", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofGreaterThanOrEqualTo(String value) {
			addCriterion("BUILDING_SET_ROOF >=", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofLessThan(String value) {
			addCriterion("BUILDING_SET_ROOF <", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofLessThanOrEqualTo(String value) {
			addCriterion("BUILDING_SET_ROOF <=", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofLike(String value) {
			addCriterion("BUILDING_SET_ROOF like", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofNotLike(String value) {
			addCriterion("BUILDING_SET_ROOF not like", value, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIn(List<String> values) {
			addCriterion("BUILDING_SET_ROOF in", values, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofNotIn(List<String> values) {
			addCriterion("BUILDING_SET_ROOF not in", values, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofBetween(String value1, String value2) {
			addCriterion("BUILDING_SET_ROOF between", value1, value2, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofNotBetween(String value1, String value2) {
			addCriterion("BUILDING_SET_ROOF not between", value1, value2, "buildingSetRoof");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIsNull() {
			addCriterion("BUILDING_SET_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIsNotNull() {
			addCriterion("BUILDING_SET_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitEqualTo(String value) {
			addCriterion("BUILDING_SET_UNIT =", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitNotEqualTo(String value) {
			addCriterion("BUILDING_SET_UNIT <>", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitGreaterThan(String value) {
			addCriterion("BUILDING_SET_UNIT >", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitGreaterThanOrEqualTo(String value) {
			addCriterion("BUILDING_SET_UNIT >=", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitLessThan(String value) {
			addCriterion("BUILDING_SET_UNIT <", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitLessThanOrEqualTo(String value) {
			addCriterion("BUILDING_SET_UNIT <=", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitLike(String value) {
			addCriterion("BUILDING_SET_UNIT like", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitNotLike(String value) {
			addCriterion("BUILDING_SET_UNIT not like", value, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIn(List<String> values) {
			addCriterion("BUILDING_SET_UNIT in", values, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitNotIn(List<String> values) {
			addCriterion("BUILDING_SET_UNIT not in", values, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitBetween(String value1, String value2) {
			addCriterion("BUILDING_SET_UNIT between", value1, value2, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitNotBetween(String value1, String value2) {
			addCriterion("BUILDING_SET_UNIT not between", value1, value2, "buildingSetUnit");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorIsNull() {
			addCriterion("BUILDING_SET_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorIsNotNull() {
			addCriterion("BUILDING_SET_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorEqualTo(String value) {
			addCriterion("BUILDING_SET_FLOOR =", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorNotEqualTo(String value) {
			addCriterion("BUILDING_SET_FLOOR <>", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorGreaterThan(String value) {
			addCriterion("BUILDING_SET_FLOOR >", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorGreaterThanOrEqualTo(String value) {
			addCriterion("BUILDING_SET_FLOOR >=", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorLessThan(String value) {
			addCriterion("BUILDING_SET_FLOOR <", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorLessThanOrEqualTo(String value) {
			addCriterion("BUILDING_SET_FLOOR <=", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorLike(String value) {
			addCriterion("BUILDING_SET_FLOOR like", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorNotLike(String value) {
			addCriterion("BUILDING_SET_FLOOR not like", value, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorIn(List<String> values) {
			addCriterion("BUILDING_SET_FLOOR in", values, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorNotIn(List<String> values) {
			addCriterion("BUILDING_SET_FLOOR not in", values, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorBetween(String value1, String value2) {
			addCriterion("BUILDING_SET_FLOOR between", value1, value2, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andBuildingSetFloorNotBetween(String value1, String value2) {
			addCriterion("BUILDING_SET_FLOOR not between", value1, value2, "buildingSetFloor");
			return (Criteria) this;
		}

		public Criteria andRoomIdIsNull() {
			addCriterion("ROOM_ID is null");
			return (Criteria) this;
		}

		public Criteria andRoomIdIsNotNull() {
			addCriterion("ROOM_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRoomIdEqualTo(String value) {
			addCriterion("ROOM_ID =", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdNotEqualTo(String value) {
			addCriterion("ROOM_ID <>", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdGreaterThan(String value) {
			addCriterion("ROOM_ID >", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
			addCriterion("ROOM_ID >=", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdLessThan(String value) {
			addCriterion("ROOM_ID <", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdLessThanOrEqualTo(String value) {
			addCriterion("ROOM_ID <=", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdLike(String value) {
			addCriterion("ROOM_ID like", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdNotLike(String value) {
			addCriterion("ROOM_ID not like", value, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdIn(List<String> values) {
			addCriterion("ROOM_ID in", values, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdNotIn(List<String> values) {
			addCriterion("ROOM_ID not in", values, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdBetween(String value1, String value2) {
			addCriterion("ROOM_ID between", value1, value2, "roomId");
			return (Criteria) this;
		}

		public Criteria andRoomIdNotBetween(String value1, String value2) {
			addCriterion("ROOM_ID not between", value1, value2, "roomId");
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