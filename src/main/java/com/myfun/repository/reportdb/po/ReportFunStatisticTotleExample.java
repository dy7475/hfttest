package com.myfun.repository.reportdb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportFunStatisticTotleExample {
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
	public ReportFunStatisticTotleExample() {
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

		public Criteria andIdEqualTo(Long value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
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

		public Criteria andAreaIdIsNull() {
			addCriterion("AREA_ID is null");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNotNull() {
			addCriterion("AREA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAreaIdEqualTo(Integer value) {
			addCriterion("AREA_ID =", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotEqualTo(Integer value) {
			addCriterion("AREA_ID <>", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThan(Integer value) {
			addCriterion("AREA_ID >", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID >=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThan(Integer value) {
			addCriterion("AREA_ID <", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID <=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdIn(List<Integer> values) {
			addCriterion("AREA_ID in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotIn(List<Integer> values) {
			addCriterion("AREA_ID not in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID not between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNull() {
			addCriterion("REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNotNull() {
			addCriterion("REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRegIdEqualTo(Integer value) {
			addCriterion("REG_ID =", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotEqualTo(Integer value) {
			addCriterion("REG_ID <>", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThan(Integer value) {
			addCriterion("REG_ID >", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("REG_ID >=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThan(Integer value) {
			addCriterion("REG_ID <", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("REG_ID <=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdIn(List<Integer> values) {
			addCriterion("REG_ID in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotIn(List<Integer> values) {
			addCriterion("REG_ID not in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID between", value1, value2, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID not between", value1, value2, "regId");
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

		public Criteria andGrIdIsNull() {
			addCriterion("GR_ID is null");
			return (Criteria) this;
		}

		public Criteria andGrIdIsNotNull() {
			addCriterion("GR_ID is not null");
			return (Criteria) this;
		}

		public Criteria andGrIdEqualTo(Integer value) {
			addCriterion("GR_ID =", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotEqualTo(Integer value) {
			addCriterion("GR_ID <>", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThan(Integer value) {
			addCriterion("GR_ID >", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("GR_ID >=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThan(Integer value) {
			addCriterion("GR_ID <", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThanOrEqualTo(Integer value) {
			addCriterion("GR_ID <=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdIn(List<Integer> values) {
			addCriterion("GR_ID in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotIn(List<Integer> values) {
			addCriterion("GR_ID not in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdBetween(Integer value1, Integer value2) {
			addCriterion("GR_ID between", value1, value2, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotBetween(Integer value1, Integer value2) {
			addCriterion("GR_ID not between", value1, value2, "grId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
			return (Criteria) this;
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

		public Criteria andMergeKeyIsNull() {
			addCriterion("MERGE_KEY is null");
			return (Criteria) this;
		}

		public Criteria andMergeKeyIsNotNull() {
			addCriterion("MERGE_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andMergeKeyEqualTo(String value) {
			addCriterion("MERGE_KEY =", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyNotEqualTo(String value) {
			addCriterion("MERGE_KEY <>", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyGreaterThan(String value) {
			addCriterion("MERGE_KEY >", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyGreaterThanOrEqualTo(String value) {
			addCriterion("MERGE_KEY >=", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyLessThan(String value) {
			addCriterion("MERGE_KEY <", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyLessThanOrEqualTo(String value) {
			addCriterion("MERGE_KEY <=", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyLike(String value) {
			addCriterion("MERGE_KEY like", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyNotLike(String value) {
			addCriterion("MERGE_KEY not like", value, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyIn(List<String> values) {
			addCriterion("MERGE_KEY in", values, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyNotIn(List<String> values) {
			addCriterion("MERGE_KEY not in", values, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyBetween(String value1, String value2) {
			addCriterion("MERGE_KEY between", value1, value2, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andMergeKeyNotBetween(String value1, String value2) {
			addCriterion("MERGE_KEY not between", value1, value2, "mergeKey");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andTotalCountIsNull() {
			addCriterion("TOTAL_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andTotalCountIsNotNull() {
			addCriterion("TOTAL_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andTotalCountEqualTo(Integer value) {
			addCriterion("TOTAL_COUNT =", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountNotEqualTo(Integer value) {
			addCriterion("TOTAL_COUNT <>", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountGreaterThan(Integer value) {
			addCriterion("TOTAL_COUNT >", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("TOTAL_COUNT >=", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountLessThan(Integer value) {
			addCriterion("TOTAL_COUNT <", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountLessThanOrEqualTo(Integer value) {
			addCriterion("TOTAL_COUNT <=", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountIn(List<Integer> values) {
			addCriterion("TOTAL_COUNT in", values, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountNotIn(List<Integer> values) {
			addCriterion("TOTAL_COUNT not in", values, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountBetween(Integer value1, Integer value2) {
			addCriterion("TOTAL_COUNT between", value1, value2, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountNotBetween(Integer value1, Integer value2) {
			addCriterion("TOTAL_COUNT not between", value1, value2, "totalCount");
			return (Criteria) this;
		}

		public Criteria andDjCountIsNull() {
			addCriterion("DJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDjCountIsNotNull() {
			addCriterion("DJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDjCountEqualTo(Integer value) {
			addCriterion("DJ_COUNT =", value, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountNotEqualTo(Integer value) {
			addCriterion("DJ_COUNT <>", value, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountGreaterThan(Integer value) {
			addCriterion("DJ_COUNT >", value, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DJ_COUNT >=", value, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountLessThan(Integer value) {
			addCriterion("DJ_COUNT <", value, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountLessThanOrEqualTo(Integer value) {
			addCriterion("DJ_COUNT <=", value, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountIn(List<Integer> values) {
			addCriterion("DJ_COUNT in", values, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountNotIn(List<Integer> values) {
			addCriterion("DJ_COUNT not in", values, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountBetween(Integer value1, Integer value2) {
			addCriterion("DJ_COUNT between", value1, value2, "djCount");
			return (Criteria) this;
		}

		public Criteria andDjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DJ_COUNT not between", value1, value2, "djCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountIsNull() {
			addCriterion("ZYX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andZyxCountIsNotNull() {
			addCriterion("ZYX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andZyxCountEqualTo(Integer value) {
			addCriterion("ZYX_COUNT =", value, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountNotEqualTo(Integer value) {
			addCriterion("ZYX_COUNT <>", value, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountGreaterThan(Integer value) {
			addCriterion("ZYX_COUNT >", value, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("ZYX_COUNT >=", value, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountLessThan(Integer value) {
			addCriterion("ZYX_COUNT <", value, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountLessThanOrEqualTo(Integer value) {
			addCriterion("ZYX_COUNT <=", value, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountIn(List<Integer> values) {
			addCriterion("ZYX_COUNT in", values, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountNotIn(List<Integer> values) {
			addCriterion("ZYX_COUNT not in", values, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountBetween(Integer value1, Integer value2) {
			addCriterion("ZYX_COUNT between", value1, value2, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andZyxCountNotBetween(Integer value1, Integer value2) {
			addCriterion("ZYX_COUNT not between", value1, value2, "zyxCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountIsNull() {
			addCriterion("SSZR_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andSszrCountIsNotNull() {
			addCriterion("SSZR_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSszrCountEqualTo(Integer value) {
			addCriterion("SSZR_COUNT =", value, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountNotEqualTo(Integer value) {
			addCriterion("SSZR_COUNT <>", value, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountGreaterThan(Integer value) {
			addCriterion("SSZR_COUNT >", value, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("SSZR_COUNT >=", value, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountLessThan(Integer value) {
			addCriterion("SSZR_COUNT <", value, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountLessThanOrEqualTo(Integer value) {
			addCriterion("SSZR_COUNT <=", value, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountIn(List<Integer> values) {
			addCriterion("SSZR_COUNT in", values, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountNotIn(List<Integer> values) {
			addCriterion("SSZR_COUNT not in", values, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountBetween(Integer value1, Integer value2) {
			addCriterion("SSZR_COUNT between", value1, value2, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andSszrCountNotBetween(Integer value1, Integer value2) {
			addCriterion("SSZR_COUNT not between", value1, value2, "sszrCount");
			return (Criteria) this;
		}

		public Criteria andZpCountIsNull() {
			addCriterion("ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andZpCountIsNotNull() {
			addCriterion("ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andZpCountEqualTo(Integer value) {
			addCriterion("ZP_COUNT =", value, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountNotEqualTo(Integer value) {
			addCriterion("ZP_COUNT <>", value, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountGreaterThan(Integer value) {
			addCriterion("ZP_COUNT >", value, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("ZP_COUNT >=", value, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountLessThan(Integer value) {
			addCriterion("ZP_COUNT <", value, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountLessThanOrEqualTo(Integer value) {
			addCriterion("ZP_COUNT <=", value, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountIn(List<Integer> values) {
			addCriterion("ZP_COUNT in", values, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountNotIn(List<Integer> values) {
			addCriterion("ZP_COUNT not in", values, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountBetween(Integer value1, Integer value2) {
			addCriterion("ZP_COUNT between", value1, value2, "zpCount");
			return (Criteria) this;
		}

		public Criteria andZpCountNotBetween(Integer value1, Integer value2) {
			addCriterion("ZP_COUNT not between", value1, value2, "zpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountIsNull() {
			addCriterion("FP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFpCountIsNotNull() {
			addCriterion("FP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFpCountEqualTo(Integer value) {
			addCriterion("FP_COUNT =", value, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountNotEqualTo(Integer value) {
			addCriterion("FP_COUNT <>", value, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountGreaterThan(Integer value) {
			addCriterion("FP_COUNT >", value, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FP_COUNT >=", value, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountLessThan(Integer value) {
			addCriterion("FP_COUNT <", value, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountLessThanOrEqualTo(Integer value) {
			addCriterion("FP_COUNT <=", value, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountIn(List<Integer> values) {
			addCriterion("FP_COUNT in", values, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountNotIn(List<Integer> values) {
			addCriterion("FP_COUNT not in", values, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountBetween(Integer value1, Integer value2) {
			addCriterion("FP_COUNT between", value1, value2, "fpCount");
			return (Criteria) this;
		}

		public Criteria andFpCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FP_COUNT not between", value1, value2, "fpCount");
			return (Criteria) this;
		}

		public Criteria andXgCountIsNull() {
			addCriterion("XG_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXgCountIsNotNull() {
			addCriterion("XG_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXgCountEqualTo(Integer value) {
			addCriterion("XG_COUNT =", value, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountNotEqualTo(Integer value) {
			addCriterion("XG_COUNT <>", value, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountGreaterThan(Integer value) {
			addCriterion("XG_COUNT >", value, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XG_COUNT >=", value, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountLessThan(Integer value) {
			addCriterion("XG_COUNT <", value, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountLessThanOrEqualTo(Integer value) {
			addCriterion("XG_COUNT <=", value, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountIn(List<Integer> values) {
			addCriterion("XG_COUNT in", values, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountNotIn(List<Integer> values) {
			addCriterion("XG_COUNT not in", values, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountBetween(Integer value1, Integer value2) {
			addCriterion("XG_COUNT between", value1, value2, "xgCount");
			return (Criteria) this;
		}

		public Criteria andXgCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XG_COUNT not between", value1, value2, "xgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountIsNull() {
			addCriterion("ZTBG_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andZtbgCountIsNotNull() {
			addCriterion("ZTBG_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andZtbgCountEqualTo(Integer value) {
			addCriterion("ZTBG_COUNT =", value, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountNotEqualTo(Integer value) {
			addCriterion("ZTBG_COUNT <>", value, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountGreaterThan(Integer value) {
			addCriterion("ZTBG_COUNT >", value, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("ZTBG_COUNT >=", value, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountLessThan(Integer value) {
			addCriterion("ZTBG_COUNT <", value, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountLessThanOrEqualTo(Integer value) {
			addCriterion("ZTBG_COUNT <=", value, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountIn(List<Integer> values) {
			addCriterion("ZTBG_COUNT in", values, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountNotIn(List<Integer> values) {
			addCriterion("ZTBG_COUNT not in", values, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountBetween(Integer value1, Integer value2) {
			addCriterion("ZTBG_COUNT between", value1, value2, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andZtbgCountNotBetween(Integer value1, Integer value2) {
			addCriterion("ZTBG_COUNT not between", value1, value2, "ztbgCount");
			return (Criteria) this;
		}

		public Criteria andWtCountIsNull() {
			addCriterion("WT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andWtCountIsNotNull() {
			addCriterion("WT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andWtCountEqualTo(Integer value) {
			addCriterion("WT_COUNT =", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountNotEqualTo(Integer value) {
			addCriterion("WT_COUNT <>", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountGreaterThan(Integer value) {
			addCriterion("WT_COUNT >", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("WT_COUNT >=", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountLessThan(Integer value) {
			addCriterion("WT_COUNT <", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountLessThanOrEqualTo(Integer value) {
			addCriterion("WT_COUNT <=", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountIn(List<Integer> values) {
			addCriterion("WT_COUNT in", values, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountNotIn(List<Integer> values) {
			addCriterion("WT_COUNT not in", values, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountBetween(Integer value1, Integer value2) {
			addCriterion("WT_COUNT between", value1, value2, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("WT_COUNT not between", value1, value2, "wtCount");
			return (Criteria) this;
		}

		public Criteria andGjCountIsNull() {
			addCriterion("GJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andGjCountIsNotNull() {
			addCriterion("GJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andGjCountEqualTo(Integer value) {
			addCriterion("GJ_COUNT =", value, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountNotEqualTo(Integer value) {
			addCriterion("GJ_COUNT <>", value, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountGreaterThan(Integer value) {
			addCriterion("GJ_COUNT >", value, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("GJ_COUNT >=", value, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountLessThan(Integer value) {
			addCriterion("GJ_COUNT <", value, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountLessThanOrEqualTo(Integer value) {
			addCriterion("GJ_COUNT <=", value, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountIn(List<Integer> values) {
			addCriterion("GJ_COUNT in", values, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountNotIn(List<Integer> values) {
			addCriterion("GJ_COUNT not in", values, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountBetween(Integer value1, Integer value2) {
			addCriterion("GJ_COUNT between", value1, value2, "gjCount");
			return (Criteria) this;
		}

		public Criteria andGjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("GJ_COUNT not between", value1, value2, "gjCount");
			return (Criteria) this;
		}

		public Criteria andFkCountIsNull() {
			addCriterion("FK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFkCountIsNotNull() {
			addCriterion("FK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFkCountEqualTo(Integer value) {
			addCriterion("FK_COUNT =", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountNotEqualTo(Integer value) {
			addCriterion("FK_COUNT <>", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountGreaterThan(Integer value) {
			addCriterion("FK_COUNT >", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FK_COUNT >=", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountLessThan(Integer value) {
			addCriterion("FK_COUNT <", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountLessThanOrEqualTo(Integer value) {
			addCriterion("FK_COUNT <=", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountIn(List<Integer> values) {
			addCriterion("FK_COUNT in", values, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountNotIn(List<Integer> values) {
			addCriterion("FK_COUNT not in", values, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountBetween(Integer value1, Integer value2) {
			addCriterion("FK_COUNT between", value1, value2, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FK_COUNT not between", value1, value2, "fkCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountIsNull() {
			addCriterion("YSTJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andYstjCountIsNotNull() {
			addCriterion("YSTJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andYstjCountEqualTo(Integer value) {
			addCriterion("YSTJ_COUNT =", value, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountNotEqualTo(Integer value) {
			addCriterion("YSTJ_COUNT <>", value, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountGreaterThan(Integer value) {
			addCriterion("YSTJ_COUNT >", value, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("YSTJ_COUNT >=", value, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountLessThan(Integer value) {
			addCriterion("YSTJ_COUNT <", value, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountLessThanOrEqualTo(Integer value) {
			addCriterion("YSTJ_COUNT <=", value, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountIn(List<Integer> values) {
			addCriterion("YSTJ_COUNT in", values, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountNotIn(List<Integer> values) {
			addCriterion("YSTJ_COUNT not in", values, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountBetween(Integer value1, Integer value2) {
			addCriterion("YSTJ_COUNT between", value1, value2, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYstjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("YSTJ_COUNT not between", value1, value2, "ystjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountIsNull() {
			addCriterion("YJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andYjCountIsNotNull() {
			addCriterion("YJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andYjCountEqualTo(Integer value) {
			addCriterion("YJ_COUNT =", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountNotEqualTo(Integer value) {
			addCriterion("YJ_COUNT <>", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountGreaterThan(Integer value) {
			addCriterion("YJ_COUNT >", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("YJ_COUNT >=", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountLessThan(Integer value) {
			addCriterion("YJ_COUNT <", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountLessThanOrEqualTo(Integer value) {
			addCriterion("YJ_COUNT <=", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountIn(List<Integer> values) {
			addCriterion("YJ_COUNT in", values, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountNotIn(List<Integer> values) {
			addCriterion("YJ_COUNT not in", values, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountBetween(Integer value1, Integer value2) {
			addCriterion("YJ_COUNT between", value1, value2, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("YJ_COUNT not between", value1, value2, "yjCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountIsNull() {
			addCriterion("TPSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andTpscCountIsNotNull() {
			addCriterion("TPSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andTpscCountEqualTo(Integer value) {
			addCriterion("TPSC_COUNT =", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountNotEqualTo(Integer value) {
			addCriterion("TPSC_COUNT <>", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountGreaterThan(Integer value) {
			addCriterion("TPSC_COUNT >", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("TPSC_COUNT >=", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountLessThan(Integer value) {
			addCriterion("TPSC_COUNT <", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountLessThanOrEqualTo(Integer value) {
			addCriterion("TPSC_COUNT <=", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountIn(List<Integer> values) {
			addCriterion("TPSC_COUNT in", values, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountNotIn(List<Integer> values) {
			addCriterion("TPSC_COUNT not in", values, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountBetween(Integer value1, Integer value2) {
			addCriterion("TPSC_COUNT between", value1, value2, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("TPSC_COUNT not between", value1, value2, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountIsNull() {
			addCriterion("SPSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andSpscCountIsNotNull() {
			addCriterion("SPSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSpscCountEqualTo(Integer value) {
			addCriterion("SPSC_COUNT =", value, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountNotEqualTo(Integer value) {
			addCriterion("SPSC_COUNT <>", value, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountGreaterThan(Integer value) {
			addCriterion("SPSC_COUNT >", value, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("SPSC_COUNT >=", value, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountLessThan(Integer value) {
			addCriterion("SPSC_COUNT <", value, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountLessThanOrEqualTo(Integer value) {
			addCriterion("SPSC_COUNT <=", value, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountIn(List<Integer> values) {
			addCriterion("SPSC_COUNT in", values, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountNotIn(List<Integer> values) {
			addCriterion("SPSC_COUNT not in", values, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountBetween(Integer value1, Integer value2) {
			addCriterion("SPSC_COUNT between", value1, value2, "spscCount");
			return (Criteria) this;
		}

		public Criteria andSpscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("SPSC_COUNT not between", value1, value2, "spscCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountIsNull() {
			addCriterion("CKDH_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andCkdhCountIsNotNull() {
			addCriterion("CKDH_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andCkdhCountEqualTo(Integer value) {
			addCriterion("CKDH_COUNT =", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountNotEqualTo(Integer value) {
			addCriterion("CKDH_COUNT <>", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountGreaterThan(Integer value) {
			addCriterion("CKDH_COUNT >", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("CKDH_COUNT >=", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountLessThan(Integer value) {
			addCriterion("CKDH_COUNT <", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountLessThanOrEqualTo(Integer value) {
			addCriterion("CKDH_COUNT <=", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountIn(List<Integer> values) {
			addCriterion("CKDH_COUNT in", values, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountNotIn(List<Integer> values) {
			addCriterion("CKDH_COUNT not in", values, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountBetween(Integer value1, Integer value2) {
			addCriterion("CKDH_COUNT between", value1, value2, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountNotBetween(Integer value1, Integer value2) {
			addCriterion("CKDH_COUNT not between", value1, value2, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountIsNull() {
			addCriterion("IPCALL_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andIpcallCountIsNotNull() {
			addCriterion("IPCALL_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andIpcallCountEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT =", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountNotEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT <>", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountGreaterThan(Integer value) {
			addCriterion("IPCALL_COUNT >", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT >=", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountLessThan(Integer value) {
			addCriterion("IPCALL_COUNT <", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountLessThanOrEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT <=", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountIn(List<Integer> values) {
			addCriterion("IPCALL_COUNT in", values, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountNotIn(List<Integer> values) {
			addCriterion("IPCALL_COUNT not in", values, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountBetween(Integer value1, Integer value2) {
			addCriterion("IPCALL_COUNT between", value1, value2, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountNotBetween(Integer value1, Integer value2) {
			addCriterion("IPCALL_COUNT not between", value1, value2, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountIsNull() {
			addCriterion("WLFB_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andWlfbCountIsNotNull() {
			addCriterion("WLFB_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andWlfbCountEqualTo(Integer value) {
			addCriterion("WLFB_COUNT =", value, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountNotEqualTo(Integer value) {
			addCriterion("WLFB_COUNT <>", value, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountGreaterThan(Integer value) {
			addCriterion("WLFB_COUNT >", value, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("WLFB_COUNT >=", value, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountLessThan(Integer value) {
			addCriterion("WLFB_COUNT <", value, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountLessThanOrEqualTo(Integer value) {
			addCriterion("WLFB_COUNT <=", value, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountIn(List<Integer> values) {
			addCriterion("WLFB_COUNT in", values, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountNotIn(List<Integer> values) {
			addCriterion("WLFB_COUNT not in", values, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountBetween(Integer value1, Integer value2) {
			addCriterion("WLFB_COUNT between", value1, value2, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlfbCountNotBetween(Integer value1, Integer value2) {
			addCriterion("WLFB_COUNT not between", value1, value2, "wlfbCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountIsNull() {
			addCriterion("WLSX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andWlsxCountIsNotNull() {
			addCriterion("WLSX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andWlsxCountEqualTo(Integer value) {
			addCriterion("WLSX_COUNT =", value, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountNotEqualTo(Integer value) {
			addCriterion("WLSX_COUNT <>", value, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountGreaterThan(Integer value) {
			addCriterion("WLSX_COUNT >", value, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("WLSX_COUNT >=", value, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountLessThan(Integer value) {
			addCriterion("WLSX_COUNT <", value, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountLessThanOrEqualTo(Integer value) {
			addCriterion("WLSX_COUNT <=", value, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountIn(List<Integer> values) {
			addCriterion("WLSX_COUNT in", values, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountNotIn(List<Integer> values) {
			addCriterion("WLSX_COUNT not in", values, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountBetween(Integer value1, Integer value2) {
			addCriterion("WLSX_COUNT between", value1, value2, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andWlsxCountNotBetween(Integer value1, Integer value2) {
			addCriterion("WLSX_COUNT not between", value1, value2, "wlsxCount");
			return (Criteria) this;
		}

		public Criteria andDkCountIsNull() {
			addCriterion("DK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDkCountIsNotNull() {
			addCriterion("DK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDkCountEqualTo(Integer value) {
			addCriterion("DK_COUNT =", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountNotEqualTo(Integer value) {
			addCriterion("DK_COUNT <>", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountGreaterThan(Integer value) {
			addCriterion("DK_COUNT >", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DK_COUNT >=", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountLessThan(Integer value) {
			addCriterion("DK_COUNT <", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountLessThanOrEqualTo(Integer value) {
			addCriterion("DK_COUNT <=", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountIn(List<Integer> values) {
			addCriterion("DK_COUNT in", values, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountNotIn(List<Integer> values) {
			addCriterion("DK_COUNT not in", values, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountBetween(Integer value1, Integer value2) {
			addCriterion("DK_COUNT between", value1, value2, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DK_COUNT not between", value1, value2, "dkCount");
			return (Criteria) this;
		}

		public Criteria andCjCountIsNull() {
			addCriterion("CJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andCjCountIsNotNull() {
			addCriterion("CJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andCjCountEqualTo(Integer value) {
			addCriterion("CJ_COUNT =", value, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountNotEqualTo(Integer value) {
			addCriterion("CJ_COUNT <>", value, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountGreaterThan(Integer value) {
			addCriterion("CJ_COUNT >", value, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("CJ_COUNT >=", value, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountLessThan(Integer value) {
			addCriterion("CJ_COUNT <", value, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountLessThanOrEqualTo(Integer value) {
			addCriterion("CJ_COUNT <=", value, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountIn(List<Integer> values) {
			addCriterion("CJ_COUNT in", values, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountNotIn(List<Integer> values) {
			addCriterion("CJ_COUNT not in", values, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountBetween(Integer value1, Integer value2) {
			addCriterion("CJ_COUNT between", value1, value2, "cjCount");
			return (Criteria) this;
		}

		public Criteria andCjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("CJ_COUNT not between", value1, value2, "cjCount");
			return (Criteria) this;
		}

		public Criteria andSxCountIsNull() {
			addCriterion("SX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andSxCountIsNotNull() {
			addCriterion("SX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSxCountEqualTo(Integer value) {
			addCriterion("SX_COUNT =", value, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountNotEqualTo(Integer value) {
			addCriterion("SX_COUNT <>", value, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountGreaterThan(Integer value) {
			addCriterion("SX_COUNT >", value, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("SX_COUNT >=", value, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountLessThan(Integer value) {
			addCriterion("SX_COUNT <", value, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountLessThanOrEqualTo(Integer value) {
			addCriterion("SX_COUNT <=", value, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountIn(List<Integer> values) {
			addCriterion("SX_COUNT in", values, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountNotIn(List<Integer> values) {
			addCriterion("SX_COUNT not in", values, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountBetween(Integer value1, Integer value2) {
			addCriterion("SX_COUNT between", value1, value2, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSxCountNotBetween(Integer value1, Integer value2) {
			addCriterion("SX_COUNT not between", value1, value2, "sxCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountIsNull() {
			addCriterion("SPDK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andSpdkCountIsNotNull() {
			addCriterion("SPDK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSpdkCountEqualTo(Integer value) {
			addCriterion("SPDK_COUNT =", value, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountNotEqualTo(Integer value) {
			addCriterion("SPDK_COUNT <>", value, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountGreaterThan(Integer value) {
			addCriterion("SPDK_COUNT >", value, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("SPDK_COUNT >=", value, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountLessThan(Integer value) {
			addCriterion("SPDK_COUNT <", value, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountLessThanOrEqualTo(Integer value) {
			addCriterion("SPDK_COUNT <=", value, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountIn(List<Integer> values) {
			addCriterion("SPDK_COUNT in", values, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountNotIn(List<Integer> values) {
			addCriterion("SPDK_COUNT not in", values, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountBetween(Integer value1, Integer value2) {
			addCriterion("SPDK_COUNT between", value1, value2, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andSpdkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("SPDK_COUNT not between", value1, value2, "spdkCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountIsNull() {
			addCriterion("KFDP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andKfdpCountIsNotNull() {
			addCriterion("KFDP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andKfdpCountEqualTo(Integer value) {
			addCriterion("KFDP_COUNT =", value, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountNotEqualTo(Integer value) {
			addCriterion("KFDP_COUNT <>", value, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountGreaterThan(Integer value) {
			addCriterion("KFDP_COUNT >", value, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("KFDP_COUNT >=", value, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountLessThan(Integer value) {
			addCriterion("KFDP_COUNT <", value, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountLessThanOrEqualTo(Integer value) {
			addCriterion("KFDP_COUNT <=", value, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountIn(List<Integer> values) {
			addCriterion("KFDP_COUNT in", values, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountNotIn(List<Integer> values) {
			addCriterion("KFDP_COUNT not in", values, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountBetween(Integer value1, Integer value2) {
			addCriterion("KFDP_COUNT between", value1, value2, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andKfdpCountNotBetween(Integer value1, Integer value2) {
			addCriterion("KFDP_COUNT not between", value1, value2, "kfdpCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountIsNull() {
			addCriterion("PYQ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andPyqCountIsNotNull() {
			addCriterion("PYQ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPyqCountEqualTo(Integer value) {
			addCriterion("PYQ_COUNT =", value, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountNotEqualTo(Integer value) {
			addCriterion("PYQ_COUNT <>", value, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountGreaterThan(Integer value) {
			addCriterion("PYQ_COUNT >", value, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("PYQ_COUNT >=", value, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountLessThan(Integer value) {
			addCriterion("PYQ_COUNT <", value, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountLessThanOrEqualTo(Integer value) {
			addCriterion("PYQ_COUNT <=", value, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountIn(List<Integer> values) {
			addCriterion("PYQ_COUNT in", values, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountNotIn(List<Integer> values) {
			addCriterion("PYQ_COUNT not in", values, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountBetween(Integer value1, Integer value2) {
			addCriterion("PYQ_COUNT between", value1, value2, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andPyqCountNotBetween(Integer value1, Integer value2) {
			addCriterion("PYQ_COUNT not between", value1, value2, "pyqCount");
			return (Criteria) this;
		}

		public Criteria andVrCountIsNull() {
			addCriterion("VR_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andVrCountIsNotNull() {
			addCriterion("VR_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andVrCountEqualTo(Integer value) {
			addCriterion("VR_COUNT =", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountNotEqualTo(Integer value) {
			addCriterion("VR_COUNT <>", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountGreaterThan(Integer value) {
			addCriterion("VR_COUNT >", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("VR_COUNT >=", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountLessThan(Integer value) {
			addCriterion("VR_COUNT <", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountLessThanOrEqualTo(Integer value) {
			addCriterion("VR_COUNT <=", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountIn(List<Integer> values) {
			addCriterion("VR_COUNT in", values, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountNotIn(List<Integer> values) {
			addCriterion("VR_COUNT not in", values, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountBetween(Integer value1, Integer value2) {
			addCriterion("VR_COUNT between", value1, value2, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountNotBetween(Integer value1, Integer value2) {
			addCriterion("VR_COUNT not between", value1, value2, "vrCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountIsNull() {
			addCriterion("DKUP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDkupCountIsNotNull() {
			addCriterion("DKUP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDkupCountEqualTo(Integer value) {
			addCriterion("DKUP_COUNT =", value, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountNotEqualTo(Integer value) {
			addCriterion("DKUP_COUNT <>", value, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountGreaterThan(Integer value) {
			addCriterion("DKUP_COUNT >", value, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DKUP_COUNT >=", value, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountLessThan(Integer value) {
			addCriterion("DKUP_COUNT <", value, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountLessThanOrEqualTo(Integer value) {
			addCriterion("DKUP_COUNT <=", value, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountIn(List<Integer> values) {
			addCriterion("DKUP_COUNT in", values, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountNotIn(List<Integer> values) {
			addCriterion("DKUP_COUNT not in", values, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountBetween(Integer value1, Integer value2) {
			addCriterion("DKUP_COUNT between", value1, value2, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkupCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DKUP_COUNT not between", value1, value2, "dkupCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountIsNull() {
			addCriterion("DKDOWN_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDkdownCountIsNotNull() {
			addCriterion("DKDOWN_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDkdownCountEqualTo(Integer value) {
			addCriterion("DKDOWN_COUNT =", value, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountNotEqualTo(Integer value) {
			addCriterion("DKDOWN_COUNT <>", value, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountGreaterThan(Integer value) {
			addCriterion("DKDOWN_COUNT >", value, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DKDOWN_COUNT >=", value, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountLessThan(Integer value) {
			addCriterion("DKDOWN_COUNT <", value, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountLessThanOrEqualTo(Integer value) {
			addCriterion("DKDOWN_COUNT <=", value, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountIn(List<Integer> values) {
			addCriterion("DKDOWN_COUNT in", values, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountNotIn(List<Integer> values) {
			addCriterion("DKDOWN_COUNT not in", values, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountBetween(Integer value1, Integer value2) {
			addCriterion("DKDOWN_COUNT between", value1, value2, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andDkdownCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DKDOWN_COUNT not between", value1, value2, "dkdownCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountIsNull() {
			addCriterion("ZFY_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andZfyCountIsNotNull() {
			addCriterion("ZFY_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andZfyCountEqualTo(Integer value) {
			addCriterion("ZFY_COUNT =", value, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountNotEqualTo(Integer value) {
			addCriterion("ZFY_COUNT <>", value, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountGreaterThan(Integer value) {
			addCriterion("ZFY_COUNT >", value, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("ZFY_COUNT >=", value, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountLessThan(Integer value) {
			addCriterion("ZFY_COUNT <", value, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountLessThanOrEqualTo(Integer value) {
			addCriterion("ZFY_COUNT <=", value, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountIn(List<Integer> values) {
			addCriterion("ZFY_COUNT in", values, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountNotIn(List<Integer> values) {
			addCriterion("ZFY_COUNT not in", values, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountBetween(Integer value1, Integer value2) {
			addCriterion("ZFY_COUNT between", value1, value2, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZfyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("ZFY_COUNT not between", value1, value2, "zfyCount");
			return (Criteria) this;
		}

		public Criteria andZxCountIsNull() {
			addCriterion("ZX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andZxCountIsNotNull() {
			addCriterion("ZX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andZxCountEqualTo(Integer value) {
			addCriterion("ZX_COUNT =", value, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountNotEqualTo(Integer value) {
			addCriterion("ZX_COUNT <>", value, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountGreaterThan(Integer value) {
			addCriterion("ZX_COUNT >", value, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("ZX_COUNT >=", value, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountLessThan(Integer value) {
			addCriterion("ZX_COUNT <", value, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountLessThanOrEqualTo(Integer value) {
			addCriterion("ZX_COUNT <=", value, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountIn(List<Integer> values) {
			addCriterion("ZX_COUNT in", values, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountNotIn(List<Integer> values) {
			addCriterion("ZX_COUNT not in", values, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountBetween(Integer value1, Integer value2) {
			addCriterion("ZX_COUNT between", value1, value2, "zxCount");
			return (Criteria) this;
		}

		public Criteria andZxCountNotBetween(Integer value1, Integer value2) {
			addCriterion("ZX_COUNT not between", value1, value2, "zxCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountIsNull() {
			addCriterion("QFTG_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andQftgCountIsNotNull() {
			addCriterion("QFTG_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andQftgCountEqualTo(Integer value) {
			addCriterion("QFTG_COUNT =", value, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountNotEqualTo(Integer value) {
			addCriterion("QFTG_COUNT <>", value, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountGreaterThan(Integer value) {
			addCriterion("QFTG_COUNT >", value, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("QFTG_COUNT >=", value, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountLessThan(Integer value) {
			addCriterion("QFTG_COUNT <", value, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountLessThanOrEqualTo(Integer value) {
			addCriterion("QFTG_COUNT <=", value, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountIn(List<Integer> values) {
			addCriterion("QFTG_COUNT in", values, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountNotIn(List<Integer> values) {
			addCriterion("QFTG_COUNT not in", values, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountBetween(Integer value1, Integer value2) {
			addCriterion("QFTG_COUNT between", value1, value2, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andQftgCountNotBetween(Integer value1, Integer value2) {
			addCriterion("QFTG_COUNT not between", value1, value2, "qftgCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountIsNull() {
			addCriterion("XQZJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXqzjCountIsNotNull() {
			addCriterion("XQZJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXqzjCountEqualTo(Integer value) {
			addCriterion("XQZJ_COUNT =", value, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountNotEqualTo(Integer value) {
			addCriterion("XQZJ_COUNT <>", value, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountGreaterThan(Integer value) {
			addCriterion("XQZJ_COUNT >", value, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XQZJ_COUNT >=", value, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountLessThan(Integer value) {
			addCriterion("XQZJ_COUNT <", value, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountLessThanOrEqualTo(Integer value) {
			addCriterion("XQZJ_COUNT <=", value, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountIn(List<Integer> values) {
			addCriterion("XQZJ_COUNT in", values, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountNotIn(List<Integer> values) {
			addCriterion("XQZJ_COUNT not in", values, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountBetween(Integer value1, Integer value2) {
			addCriterion("XQZJ_COUNT between", value1, value2, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andXqzjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XQZJ_COUNT not between", value1, value2, "xqzjCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountIsNull() {
			addCriterion("FYTG_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFytgCountIsNotNull() {
			addCriterion("FYTG_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFytgCountEqualTo(Integer value) {
			addCriterion("FYTG_COUNT =", value, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountNotEqualTo(Integer value) {
			addCriterion("FYTG_COUNT <>", value, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountGreaterThan(Integer value) {
			addCriterion("FYTG_COUNT >", value, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FYTG_COUNT >=", value, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountLessThan(Integer value) {
			addCriterion("FYTG_COUNT <", value, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountLessThanOrEqualTo(Integer value) {
			addCriterion("FYTG_COUNT <=", value, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountIn(List<Integer> values) {
			addCriterion("FYTG_COUNT in", values, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountNotIn(List<Integer> values) {
			addCriterion("FYTG_COUNT not in", values, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountBetween(Integer value1, Integer value2) {
			addCriterion("FYTG_COUNT between", value1, value2, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFytgCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FYTG_COUNT not between", value1, value2, "fytgCount");
			return (Criteria) this;
		}

		public Criteria andFyCountIsNull() {
			addCriterion("FY_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFyCountIsNotNull() {
			addCriterion("FY_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFyCountEqualTo(Integer value) {
			addCriterion("FY_COUNT =", value, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountNotEqualTo(Integer value) {
			addCriterion("FY_COUNT <>", value, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountGreaterThan(Integer value) {
			addCriterion("FY_COUNT >", value, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FY_COUNT >=", value, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountLessThan(Integer value) {
			addCriterion("FY_COUNT <", value, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountLessThanOrEqualTo(Integer value) {
			addCriterion("FY_COUNT <=", value, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountIn(List<Integer> values) {
			addCriterion("FY_COUNT in", values, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountNotIn(List<Integer> values) {
			addCriterion("FY_COUNT not in", values, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountBetween(Integer value1, Integer value2) {
			addCriterion("FY_COUNT between", value1, value2, "fyCount");
			return (Criteria) this;
		}

		public Criteria andFyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FY_COUNT not between", value1, value2, "fyCount");
			return (Criteria) this;
		}

		public Criteria andWdCountIsNull() {
			addCriterion("WD_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andWdCountIsNotNull() {
			addCriterion("WD_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andWdCountEqualTo(Integer value) {
			addCriterion("WD_COUNT =", value, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountNotEqualTo(Integer value) {
			addCriterion("WD_COUNT <>", value, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountGreaterThan(Integer value) {
			addCriterion("WD_COUNT >", value, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("WD_COUNT >=", value, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountLessThan(Integer value) {
			addCriterion("WD_COUNT <", value, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountLessThanOrEqualTo(Integer value) {
			addCriterion("WD_COUNT <=", value, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountIn(List<Integer> values) {
			addCriterion("WD_COUNT in", values, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountNotIn(List<Integer> values) {
			addCriterion("WD_COUNT not in", values, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountBetween(Integer value1, Integer value2) {
			addCriterion("WD_COUNT between", value1, value2, "wdCount");
			return (Criteria) this;
		}

		public Criteria andWdCountNotBetween(Integer value1, Integer value2) {
			addCriterion("WD_COUNT not between", value1, value2, "wdCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountIsNull() {
			addCriterion("FDK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFdkCountIsNotNull() {
			addCriterion("FDK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFdkCountEqualTo(Integer value) {
			addCriterion("FDK_COUNT =", value, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountNotEqualTo(Integer value) {
			addCriterion("FDK_COUNT <>", value, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountGreaterThan(Integer value) {
			addCriterion("FDK_COUNT >", value, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FDK_COUNT >=", value, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountLessThan(Integer value) {
			addCriterion("FDK_COUNT <", value, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountLessThanOrEqualTo(Integer value) {
			addCriterion("FDK_COUNT <=", value, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountIn(List<Integer> values) {
			addCriterion("FDK_COUNT in", values, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountNotIn(List<Integer> values) {
			addCriterion("FDK_COUNT not in", values, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountBetween(Integer value1, Integer value2) {
			addCriterion("FDK_COUNT between", value1, value2, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andFdkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FDK_COUNT not between", value1, value2, "fdkCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountIsNull() {
			addCriterion("IPDGJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountIsNotNull() {
			addCriterion("IPDGJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountEqualTo(Integer value) {
			addCriterion("IPDGJ_COUNT =", value, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountNotEqualTo(Integer value) {
			addCriterion("IPDGJ_COUNT <>", value, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountGreaterThan(Integer value) {
			addCriterion("IPDGJ_COUNT >", value, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("IPDGJ_COUNT >=", value, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountLessThan(Integer value) {
			addCriterion("IPDGJ_COUNT <", value, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountLessThanOrEqualTo(Integer value) {
			addCriterion("IPDGJ_COUNT <=", value, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountIn(List<Integer> values) {
			addCriterion("IPDGJ_COUNT in", values, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountNotIn(List<Integer> values) {
			addCriterion("IPDGJ_COUNT not in", values, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountBetween(Integer value1, Integer value2) {
			addCriterion("IPDGJ_COUNT between", value1, value2, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpdgjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("IPDGJ_COUNT not between", value1, value2, "ipdgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountIsNull() {
			addCriterion("IPZGJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountIsNotNull() {
			addCriterion("IPZGJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountEqualTo(Integer value) {
			addCriterion("IPZGJ_COUNT =", value, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountNotEqualTo(Integer value) {
			addCriterion("IPZGJ_COUNT <>", value, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountGreaterThan(Integer value) {
			addCriterion("IPZGJ_COUNT >", value, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("IPZGJ_COUNT >=", value, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountLessThan(Integer value) {
			addCriterion("IPZGJ_COUNT <", value, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountLessThanOrEqualTo(Integer value) {
			addCriterion("IPZGJ_COUNT <=", value, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountIn(List<Integer> values) {
			addCriterion("IPZGJ_COUNT in", values, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountNotIn(List<Integer> values) {
			addCriterion("IPZGJ_COUNT not in", values, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountBetween(Integer value1, Integer value2) {
			addCriterion("IPZGJ_COUNT between", value1, value2, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andIpzgjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("IPZGJ_COUNT not between", value1, value2, "ipzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountIsNull() {
			addCriterion("DHDGJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountIsNotNull() {
			addCriterion("DHDGJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountEqualTo(Integer value) {
			addCriterion("DHDGJ_COUNT =", value, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountNotEqualTo(Integer value) {
			addCriterion("DHDGJ_COUNT <>", value, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountGreaterThan(Integer value) {
			addCriterion("DHDGJ_COUNT >", value, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DHDGJ_COUNT >=", value, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountLessThan(Integer value) {
			addCriterion("DHDGJ_COUNT <", value, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountLessThanOrEqualTo(Integer value) {
			addCriterion("DHDGJ_COUNT <=", value, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountIn(List<Integer> values) {
			addCriterion("DHDGJ_COUNT in", values, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountNotIn(List<Integer> values) {
			addCriterion("DHDGJ_COUNT not in", values, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountBetween(Integer value1, Integer value2) {
			addCriterion("DHDGJ_COUNT between", value1, value2, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhdgjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DHDGJ_COUNT not between", value1, value2, "dhdgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountIsNull() {
			addCriterion("DHZGJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountIsNotNull() {
			addCriterion("DHZGJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountEqualTo(Integer value) {
			addCriterion("DHZGJ_COUNT =", value, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountNotEqualTo(Integer value) {
			addCriterion("DHZGJ_COUNT <>", value, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountGreaterThan(Integer value) {
			addCriterion("DHZGJ_COUNT >", value, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DHZGJ_COUNT >=", value, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountLessThan(Integer value) {
			addCriterion("DHZGJ_COUNT <", value, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountLessThanOrEqualTo(Integer value) {
			addCriterion("DHZGJ_COUNT <=", value, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountIn(List<Integer> values) {
			addCriterion("DHZGJ_COUNT in", values, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountNotIn(List<Integer> values) {
			addCriterion("DHZGJ_COUNT not in", values, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountBetween(Integer value1, Integer value2) {
			addCriterion("DHZGJ_COUNT between", value1, value2, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDhzgjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DHZGJ_COUNT not between", value1, value2, "dhzgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountIsNull() {
			addCriterion("DGJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDgjCountIsNotNull() {
			addCriterion("DGJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDgjCountEqualTo(Integer value) {
			addCriterion("DGJ_COUNT =", value, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountNotEqualTo(Integer value) {
			addCriterion("DGJ_COUNT <>", value, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountGreaterThan(Integer value) {
			addCriterion("DGJ_COUNT >", value, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DGJ_COUNT >=", value, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountLessThan(Integer value) {
			addCriterion("DGJ_COUNT <", value, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountLessThanOrEqualTo(Integer value) {
			addCriterion("DGJ_COUNT <=", value, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountIn(List<Integer> values) {
			addCriterion("DGJ_COUNT in", values, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountNotIn(List<Integer> values) {
			addCriterion("DGJ_COUNT not in", values, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountBetween(Integer value1, Integer value2) {
			addCriterion("DGJ_COUNT between", value1, value2, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andDgjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DGJ_COUNT not between", value1, value2, "dgjCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountIsNull() {
			addCriterion("XSWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXswtCountIsNotNull() {
			addCriterion("XSWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXswtCountEqualTo(Integer value) {
			addCriterion("XSWT_COUNT =", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountNotEqualTo(Integer value) {
			addCriterion("XSWT_COUNT <>", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountGreaterThan(Integer value) {
			addCriterion("XSWT_COUNT >", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XSWT_COUNT >=", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountLessThan(Integer value) {
			addCriterion("XSWT_COUNT <", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XSWT_COUNT <=", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountIn(List<Integer> values) {
			addCriterion("XSWT_COUNT in", values, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountNotIn(List<Integer> values) {
			addCriterion("XSWT_COUNT not in", values, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountBetween(Integer value1, Integer value2) {
			addCriterion("XSWT_COUNT between", value1, value2, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XSWT_COUNT not between", value1, value2, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountIsNull() {
			addCriterion("DJWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDjwtCountIsNotNull() {
			addCriterion("DJWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDjwtCountEqualTo(Integer value) {
			addCriterion("DJWT_COUNT =", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountNotEqualTo(Integer value) {
			addCriterion("DJWT_COUNT <>", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountGreaterThan(Integer value) {
			addCriterion("DJWT_COUNT >", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DJWT_COUNT >=", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountLessThan(Integer value) {
			addCriterion("DJWT_COUNT <", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("DJWT_COUNT <=", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountIn(List<Integer> values) {
			addCriterion("DJWT_COUNT in", values, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountNotIn(List<Integer> values) {
			addCriterion("DJWT_COUNT not in", values, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountBetween(Integer value1, Integer value2) {
			addCriterion("DJWT_COUNT between", value1, value2, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DJWT_COUNT not between", value1, value2, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountIsNull() {
			addCriterion("BZWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andBzwtCountIsNotNull() {
			addCriterion("BZWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andBzwtCountEqualTo(Integer value) {
			addCriterion("BZWT_COUNT =", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountNotEqualTo(Integer value) {
			addCriterion("BZWT_COUNT <>", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountGreaterThan(Integer value) {
			addCriterion("BZWT_COUNT >", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("BZWT_COUNT >=", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountLessThan(Integer value) {
			addCriterion("BZWT_COUNT <", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("BZWT_COUNT <=", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountIn(List<Integer> values) {
			addCriterion("BZWT_COUNT in", values, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountNotIn(List<Integer> values) {
			addCriterion("BZWT_COUNT not in", values, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountBetween(Integer value1, Integer value2) {
			addCriterion("BZWT_COUNT between", value1, value2, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("BZWT_COUNT not between", value1, value2, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountIsNull() {
			addCriterion("PTWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andPtwtCountIsNotNull() {
			addCriterion("PTWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPtwtCountEqualTo(Integer value) {
			addCriterion("PTWT_COUNT =", value, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountNotEqualTo(Integer value) {
			addCriterion("PTWT_COUNT <>", value, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountGreaterThan(Integer value) {
			addCriterion("PTWT_COUNT >", value, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("PTWT_COUNT >=", value, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountLessThan(Integer value) {
			addCriterion("PTWT_COUNT <", value, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("PTWT_COUNT <=", value, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountIn(List<Integer> values) {
			addCriterion("PTWT_COUNT in", values, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountNotIn(List<Integer> values) {
			addCriterion("PTWT_COUNT not in", values, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountBetween(Integer value1, Integer value2) {
			addCriterion("PTWT_COUNT between", value1, value2, "ptwtCount");
			return (Criteria) this;
		}

		public Criteria andPtwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("PTWT_COUNT not between", value1, value2, "ptwtCount");
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