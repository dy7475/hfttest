package com.myfun.repository.reportdb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportFunAssessmentStatisticsExample {
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
	public ReportFunAssessmentStatisticsExample() {
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

		public Criteria andUserPositionIsNull() {
			addCriterion("USER_POSITION is null");
			return (Criteria) this;
		}

		public Criteria andUserPositionIsNotNull() {
			addCriterion("USER_POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andUserPositionEqualTo(String value) {
			addCriterion("USER_POSITION =", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotEqualTo(String value) {
			addCriterion("USER_POSITION <>", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionGreaterThan(String value) {
			addCriterion("USER_POSITION >", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionGreaterThanOrEqualTo(String value) {
			addCriterion("USER_POSITION >=", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLessThan(String value) {
			addCriterion("USER_POSITION <", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLessThanOrEqualTo(String value) {
			addCriterion("USER_POSITION <=", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLike(String value) {
			addCriterion("USER_POSITION like", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotLike(String value) {
			addCriterion("USER_POSITION not like", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionIn(List<String> values) {
			addCriterion("USER_POSITION in", values, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotIn(List<String> values) {
			addCriterion("USER_POSITION not in", values, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionBetween(String value1, String value2) {
			addCriterion("USER_POSITION between", value1, value2, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotBetween(String value1, String value2) {
			addCriterion("USER_POSITION not between", value1, value2, "userPosition");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartIsNull() {
			addCriterion("ASSESSMENT_CYCLE_START is null");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartIsNotNull() {
			addCriterion("ASSESSMENT_CYCLE_START is not null");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_START =", value, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartNotEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_START <>", value, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartGreaterThan(Date value) {
			addCriterion("ASSESSMENT_CYCLE_START >", value, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartGreaterThanOrEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_START >=", value, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartLessThan(Date value) {
			addCriterion("ASSESSMENT_CYCLE_START <", value, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartLessThanOrEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_START <=", value, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartIn(List<Date> values) {
			addCriterion("ASSESSMENT_CYCLE_START in", values, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartNotIn(List<Date> values) {
			addCriterion("ASSESSMENT_CYCLE_START not in", values, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartBetween(Date value1, Date value2) {
			addCriterion("ASSESSMENT_CYCLE_START between", value1, value2, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleStartNotBetween(Date value1, Date value2) {
			addCriterion("ASSESSMENT_CYCLE_START not between", value1, value2, "assessmentCycleStart");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndIsNull() {
			addCriterion("ASSESSMENT_CYCLE_END is null");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndIsNotNull() {
			addCriterion("ASSESSMENT_CYCLE_END is not null");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_END =", value, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndNotEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_END <>", value, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndGreaterThan(Date value) {
			addCriterion("ASSESSMENT_CYCLE_END >", value, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndGreaterThanOrEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_END >=", value, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndLessThan(Date value) {
			addCriterion("ASSESSMENT_CYCLE_END <", value, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndLessThanOrEqualTo(Date value) {
			addCriterion("ASSESSMENT_CYCLE_END <=", value, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndIn(List<Date> values) {
			addCriterion("ASSESSMENT_CYCLE_END in", values, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndNotIn(List<Date> values) {
			addCriterion("ASSESSMENT_CYCLE_END not in", values, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndBetween(Date value1, Date value2) {
			addCriterion("ASSESSMENT_CYCLE_END between", value1, value2, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentCycleEndNotBetween(Date value1, Date value2) {
			addCriterion("ASSESSMENT_CYCLE_END not between", value1, value2, "assessmentCycleEnd");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIsNull() {
			addCriterion("ASSESSMENT_MONTH is null");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIsNotNull() {
			addCriterion("ASSESSMENT_MONTH is not null");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH =", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH <>", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthGreaterThan(String value) {
			addCriterion("ASSESSMENT_MONTH >", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthGreaterThanOrEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH >=", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLessThan(String value) {
			addCriterion("ASSESSMENT_MONTH <", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLessThanOrEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH <=", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLike(String value) {
			addCriterion("ASSESSMENT_MONTH like", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotLike(String value) {
			addCriterion("ASSESSMENT_MONTH not like", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIn(List<String> values) {
			addCriterion("ASSESSMENT_MONTH in", values, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotIn(List<String> values) {
			addCriterion("ASSESSMENT_MONTH not in", values, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthBetween(String value1, String value2) {
			addCriterion("ASSESSMENT_MONTH between", value1, value2, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotBetween(String value1, String value2) {
			addCriterion("ASSESSMENT_MONTH not between", value1, value2, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andUserCountIsNull() {
			addCriterion("USER_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andUserCountIsNotNull() {
			addCriterion("USER_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andUserCountEqualTo(BigDecimal value) {
			addCriterion("USER_COUNT =", value, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountNotEqualTo(BigDecimal value) {
			addCriterion("USER_COUNT <>", value, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountGreaterThan(BigDecimal value) {
			addCriterion("USER_COUNT >", value, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("USER_COUNT >=", value, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountLessThan(BigDecimal value) {
			addCriterion("USER_COUNT <", value, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("USER_COUNT <=", value, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountIn(List<BigDecimal> values) {
			addCriterion("USER_COUNT in", values, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountNotIn(List<BigDecimal> values) {
			addCriterion("USER_COUNT not in", values, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("USER_COUNT between", value1, value2, "userCount");
			return (Criteria) this;
		}

		public Criteria andUserCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("USER_COUNT not between", value1, value2, "userCount");
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

		public Criteria andXzFxzCountIsNull() {
			addCriterion("XZ_FXZ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountIsNotNull() {
			addCriterion("XZ_FXZ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountEqualTo(Integer value) {
			addCriterion("XZ_FXZ_COUNT =", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountNotEqualTo(Integer value) {
			addCriterion("XZ_FXZ_COUNT <>", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountGreaterThan(Integer value) {
			addCriterion("XZ_FXZ_COUNT >", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_FXZ_COUNT >=", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountLessThan(Integer value) {
			addCriterion("XZ_FXZ_COUNT <", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_FXZ_COUNT <=", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountIn(List<Integer> values) {
			addCriterion("XZ_FXZ_COUNT in", values, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountNotIn(List<Integer> values) {
			addCriterion("XZ_FXZ_COUNT not in", values, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_FXZ_COUNT between", value1, value2, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_FXZ_COUNT not between", value1, value2, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountIsNull() {
			addCriterion("XZ_KXZ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountIsNotNull() {
			addCriterion("XZ_KXZ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountEqualTo(Integer value) {
			addCriterion("XZ_KXZ_COUNT =", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountNotEqualTo(Integer value) {
			addCriterion("XZ_KXZ_COUNT <>", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountGreaterThan(Integer value) {
			addCriterion("XZ_KXZ_COUNT >", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_KXZ_COUNT >=", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountLessThan(Integer value) {
			addCriterion("XZ_KXZ_COUNT <", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_KXZ_COUNT <=", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountIn(List<Integer> values) {
			addCriterion("XZ_KXZ_COUNT in", values, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountNotIn(List<Integer> values) {
			addCriterion("XZ_KXZ_COUNT not in", values, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_KXZ_COUNT between", value1, value2, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_KXZ_COUNT not between", value1, value2, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountIsNull() {
			addCriterion("XZ_GJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzGjCountIsNotNull() {
			addCriterion("XZ_GJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzGjCountEqualTo(Integer value) {
			addCriterion("XZ_GJ_COUNT =", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountNotEqualTo(Integer value) {
			addCriterion("XZ_GJ_COUNT <>", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountGreaterThan(Integer value) {
			addCriterion("XZ_GJ_COUNT >", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_GJ_COUNT >=", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountLessThan(Integer value) {
			addCriterion("XZ_GJ_COUNT <", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_GJ_COUNT <=", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountIn(List<Integer> values) {
			addCriterion("XZ_GJ_COUNT in", values, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountNotIn(List<Integer> values) {
			addCriterion("XZ_GJ_COUNT not in", values, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_GJ_COUNT between", value1, value2, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_GJ_COUNT not between", value1, value2, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountIsNull() {
			addCriterion("XZ_TPSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountIsNotNull() {
			addCriterion("XZ_TPSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountEqualTo(Integer value) {
			addCriterion("XZ_TPSC_COUNT =", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountNotEqualTo(Integer value) {
			addCriterion("XZ_TPSC_COUNT <>", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountGreaterThan(Integer value) {
			addCriterion("XZ_TPSC_COUNT >", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_TPSC_COUNT >=", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountLessThan(Integer value) {
			addCriterion("XZ_TPSC_COUNT <", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_TPSC_COUNT <=", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountIn(List<Integer> values) {
			addCriterion("XZ_TPSC_COUNT in", values, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountNotIn(List<Integer> values) {
			addCriterion("XZ_TPSC_COUNT not in", values, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_TPSC_COUNT between", value1, value2, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_TPSC_COUNT not between", value1, value2, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountIsNull() {
			addCriterion("XZ_SPSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountIsNotNull() {
			addCriterion("XZ_SPSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountEqualTo(Integer value) {
			addCriterion("XZ_SPSC_COUNT =", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountNotEqualTo(Integer value) {
			addCriterion("XZ_SPSC_COUNT <>", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountGreaterThan(Integer value) {
			addCriterion("XZ_SPSC_COUNT >", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_SPSC_COUNT >=", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountLessThan(Integer value) {
			addCriterion("XZ_SPSC_COUNT <", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_SPSC_COUNT <=", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountIn(List<Integer> values) {
			addCriterion("XZ_SPSC_COUNT in", values, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountNotIn(List<Integer> values) {
			addCriterion("XZ_SPSC_COUNT not in", values, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_SPSC_COUNT between", value1, value2, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_SPSC_COUNT not between", value1, value2, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountIsNull() {
			addCriterion("XZ_VRSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountIsNotNull() {
			addCriterion("XZ_VRSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountEqualTo(Integer value) {
			addCriterion("XZ_VRSC_COUNT =", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountNotEqualTo(Integer value) {
			addCriterion("XZ_VRSC_COUNT <>", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountGreaterThan(Integer value) {
			addCriterion("XZ_VRSC_COUNT >", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_VRSC_COUNT >=", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountLessThan(Integer value) {
			addCriterion("XZ_VRSC_COUNT <", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_VRSC_COUNT <=", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountIn(List<Integer> values) {
			addCriterion("XZ_VRSC_COUNT in", values, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountNotIn(List<Integer> values) {
			addCriterion("XZ_VRSC_COUNT not in", values, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_VRSC_COUNT between", value1, value2, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_VRSC_COUNT not between", value1, value2, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountIsNull() {
			addCriterion("XZ_ZFY_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountIsNotNull() {
			addCriterion("XZ_ZFY_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountEqualTo(Integer value) {
			addCriterion("XZ_ZFY_COUNT =", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountNotEqualTo(Integer value) {
			addCriterion("XZ_ZFY_COUNT <>", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountGreaterThan(Integer value) {
			addCriterion("XZ_ZFY_COUNT >", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_ZFY_COUNT >=", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountLessThan(Integer value) {
			addCriterion("XZ_ZFY_COUNT <", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_ZFY_COUNT <=", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountIn(List<Integer> values) {
			addCriterion("XZ_ZFY_COUNT in", values, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountNotIn(List<Integer> values) {
			addCriterion("XZ_ZFY_COUNT not in", values, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_ZFY_COUNT between", value1, value2, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_ZFY_COUNT not between", value1, value2, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountIsNull() {
			addCriterion("XZ_IPCALL_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountIsNotNull() {
			addCriterion("XZ_IPCALL_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountEqualTo(Integer value) {
			addCriterion("XZ_IPCALL_COUNT =", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountNotEqualTo(Integer value) {
			addCriterion("XZ_IPCALL_COUNT <>", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountGreaterThan(Integer value) {
			addCriterion("XZ_IPCALL_COUNT >", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_IPCALL_COUNT >=", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountLessThan(Integer value) {
			addCriterion("XZ_IPCALL_COUNT <", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_IPCALL_COUNT <=", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountIn(List<Integer> values) {
			addCriterion("XZ_IPCALL_COUNT in", values, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountNotIn(List<Integer> values) {
			addCriterion("XZ_IPCALL_COUNT not in", values, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_IPCALL_COUNT between", value1, value2, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_IPCALL_COUNT not between", value1, value2, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountIsNull() {
			addCriterion("XZ_KFDP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountIsNotNull() {
			addCriterion("XZ_KFDP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountEqualTo(Integer value) {
			addCriterion("XZ_KFDP_COUNT =", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountNotEqualTo(Integer value) {
			addCriterion("XZ_KFDP_COUNT <>", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountGreaterThan(Integer value) {
			addCriterion("XZ_KFDP_COUNT >", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_KFDP_COUNT >=", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountLessThan(Integer value) {
			addCriterion("XZ_KFDP_COUNT <", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_KFDP_COUNT <=", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountIn(List<Integer> values) {
			addCriterion("XZ_KFDP_COUNT in", values, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountNotIn(List<Integer> values) {
			addCriterion("XZ_KFDP_COUNT not in", values, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_KFDP_COUNT between", value1, value2, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_KFDP_COUNT not between", value1, value2, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountIsNull() {
			addCriterion("XZ_HBFX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountIsNotNull() {
			addCriterion("XZ_HBFX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountEqualTo(Integer value) {
			addCriterion("XZ_HBFX_COUNT =", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountNotEqualTo(Integer value) {
			addCriterion("XZ_HBFX_COUNT <>", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountGreaterThan(Integer value) {
			addCriterion("XZ_HBFX_COUNT >", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_HBFX_COUNT >=", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountLessThan(Integer value) {
			addCriterion("XZ_HBFX_COUNT <", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_HBFX_COUNT <=", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountIn(List<Integer> values) {
			addCriterion("XZ_HBFX_COUNT in", values, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountNotIn(List<Integer> values) {
			addCriterion("XZ_HBFX_COUNT not in", values, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_HBFX_COUNT between", value1, value2, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_HBFX_COUNT not between", value1, value2, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountIsNull() {
			addCriterion("XZ_YSTJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountIsNotNull() {
			addCriterion("XZ_YSTJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountEqualTo(Integer value) {
			addCriterion("XZ_YSTJ_COUNT =", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountNotEqualTo(Integer value) {
			addCriterion("XZ_YSTJ_COUNT <>", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountGreaterThan(Integer value) {
			addCriterion("XZ_YSTJ_COUNT >", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_YSTJ_COUNT >=", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountLessThan(Integer value) {
			addCriterion("XZ_YSTJ_COUNT <", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_YSTJ_COUNT <=", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountIn(List<Integer> values) {
			addCriterion("XZ_YSTJ_COUNT in", values, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountNotIn(List<Integer> values) {
			addCriterion("XZ_YSTJ_COUNT not in", values, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_YSTJ_COUNT between", value1, value2, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_YSTJ_COUNT not between", value1, value2, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountIsNull() {
			addCriterion("XZ_PTWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountIsNotNull() {
			addCriterion("XZ_PTWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountEqualTo(Integer value) {
			addCriterion("XZ_PTWT_COUNT =", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountNotEqualTo(Integer value) {
			addCriterion("XZ_PTWT_COUNT <>", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountGreaterThan(Integer value) {
			addCriterion("XZ_PTWT_COUNT >", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_PTWT_COUNT >=", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountLessThan(Integer value) {
			addCriterion("XZ_PTWT_COUNT <", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_PTWT_COUNT <=", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountIn(List<Integer> values) {
			addCriterion("XZ_PTWT_COUNT in", values, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountNotIn(List<Integer> values) {
			addCriterion("XZ_PTWT_COUNT not in", values, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_PTWT_COUNT between", value1, value2, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_PTWT_COUNT not between", value1, value2, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountIsNull() {
			addCriterion("XZ_XSWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountIsNotNull() {
			addCriterion("XZ_XSWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountEqualTo(Integer value) {
			addCriterion("XZ_XSWT_COUNT =", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountNotEqualTo(Integer value) {
			addCriterion("XZ_XSWT_COUNT <>", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountGreaterThan(Integer value) {
			addCriterion("XZ_XSWT_COUNT >", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_XSWT_COUNT >=", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountLessThan(Integer value) {
			addCriterion("XZ_XSWT_COUNT <", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_XSWT_COUNT <=", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountIn(List<Integer> values) {
			addCriterion("XZ_XSWT_COUNT in", values, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountNotIn(List<Integer> values) {
			addCriterion("XZ_XSWT_COUNT not in", values, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_XSWT_COUNT between", value1, value2, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_XSWT_COUNT not between", value1, value2, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountIsNull() {
			addCriterion("XZ_DJWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountIsNotNull() {
			addCriterion("XZ_DJWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountEqualTo(Integer value) {
			addCriterion("XZ_DJWT_COUNT =", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountNotEqualTo(Integer value) {
			addCriterion("XZ_DJWT_COUNT <>", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountGreaterThan(Integer value) {
			addCriterion("XZ_DJWT_COUNT >", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_DJWT_COUNT >=", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountLessThan(Integer value) {
			addCriterion("XZ_DJWT_COUNT <", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_DJWT_COUNT <=", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountIn(List<Integer> values) {
			addCriterion("XZ_DJWT_COUNT in", values, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountNotIn(List<Integer> values) {
			addCriterion("XZ_DJWT_COUNT not in", values, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_DJWT_COUNT between", value1, value2, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_DJWT_COUNT not between", value1, value2, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountIsNull() {
			addCriterion("XZ_BZWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountIsNotNull() {
			addCriterion("XZ_BZWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountEqualTo(Integer value) {
			addCriterion("XZ_BZWT_COUNT =", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountNotEqualTo(Integer value) {
			addCriterion("XZ_BZWT_COUNT <>", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountGreaterThan(Integer value) {
			addCriterion("XZ_BZWT_COUNT >", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_BZWT_COUNT >=", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountLessThan(Integer value) {
			addCriterion("XZ_BZWT_COUNT <", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_BZWT_COUNT <=", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountIn(List<Integer> values) {
			addCriterion("XZ_BZWT_COUNT in", values, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountNotIn(List<Integer> values) {
			addCriterion("XZ_BZWT_COUNT not in", values, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_BZWT_COUNT between", value1, value2, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_BZWT_COUNT not between", value1, value2, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountIsNull() {
			addCriterion("XZ_FK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzFkCountIsNotNull() {
			addCriterion("XZ_FK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzFkCountEqualTo(Integer value) {
			addCriterion("XZ_FK_COUNT =", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountNotEqualTo(Integer value) {
			addCriterion("XZ_FK_COUNT <>", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountGreaterThan(Integer value) {
			addCriterion("XZ_FK_COUNT >", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_FK_COUNT >=", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountLessThan(Integer value) {
			addCriterion("XZ_FK_COUNT <", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_FK_COUNT <=", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountIn(List<Integer> values) {
			addCriterion("XZ_FK_COUNT in", values, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountNotIn(List<Integer> values) {
			addCriterion("XZ_FK_COUNT not in", values, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_FK_COUNT between", value1, value2, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_FK_COUNT not between", value1, value2, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountIsNull() {
			addCriterion("XZ_YJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzYjCountIsNotNull() {
			addCriterion("XZ_YJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzYjCountEqualTo(Integer value) {
			addCriterion("XZ_YJ_COUNT =", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountNotEqualTo(Integer value) {
			addCriterion("XZ_YJ_COUNT <>", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountGreaterThan(Integer value) {
			addCriterion("XZ_YJ_COUNT >", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_YJ_COUNT >=", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountLessThan(Integer value) {
			addCriterion("XZ_YJ_COUNT <", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_YJ_COUNT <=", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountIn(List<Integer> values) {
			addCriterion("XZ_YJ_COUNT in", values, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountNotIn(List<Integer> values) {
			addCriterion("XZ_YJ_COUNT not in", values, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_YJ_COUNT between", value1, value2, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_YJ_COUNT not between", value1, value2, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountIsNull() {
			addCriterion("XZ_DK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzDkCountIsNotNull() {
			addCriterion("XZ_DK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzDkCountEqualTo(Integer value) {
			addCriterion("XZ_DK_COUNT =", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountNotEqualTo(Integer value) {
			addCriterion("XZ_DK_COUNT <>", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountGreaterThan(Integer value) {
			addCriterion("XZ_DK_COUNT >", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZ_DK_COUNT >=", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountLessThan(Integer value) {
			addCriterion("XZ_DK_COUNT <", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZ_DK_COUNT <=", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountIn(List<Integer> values) {
			addCriterion("XZ_DK_COUNT in", values, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountNotIn(List<Integer> values) {
			addCriterion("XZ_DK_COUNT not in", values, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountBetween(Integer value1, Integer value2) {
			addCriterion("XZ_DK_COUNT between", value1, value2, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZ_DK_COUNT not between", value1, value2, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountIsNull() {
			addCriterion("XZYX_FXZ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountIsNotNull() {
			addCriterion("XZYX_FXZ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountEqualTo(Integer value) {
			addCriterion("XZYX_FXZ_COUNT =", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountNotEqualTo(Integer value) {
			addCriterion("XZYX_FXZ_COUNT <>", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountGreaterThan(Integer value) {
			addCriterion("XZYX_FXZ_COUNT >", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_FXZ_COUNT >=", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountLessThan(Integer value) {
			addCriterion("XZYX_FXZ_COUNT <", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_FXZ_COUNT <=", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountIn(List<Integer> values) {
			addCriterion("XZYX_FXZ_COUNT in", values, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountNotIn(List<Integer> values) {
			addCriterion("XZYX_FXZ_COUNT not in", values, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_FXZ_COUNT between", value1, value2, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_FXZ_COUNT not between", value1, value2, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountIsNull() {
			addCriterion("XZYX_KXZ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountIsNotNull() {
			addCriterion("XZYX_KXZ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountEqualTo(Integer value) {
			addCriterion("XZYX_KXZ_COUNT =", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountNotEqualTo(Integer value) {
			addCriterion("XZYX_KXZ_COUNT <>", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountGreaterThan(Integer value) {
			addCriterion("XZYX_KXZ_COUNT >", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_KXZ_COUNT >=", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountLessThan(Integer value) {
			addCriterion("XZYX_KXZ_COUNT <", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_KXZ_COUNT <=", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountIn(List<Integer> values) {
			addCriterion("XZYX_KXZ_COUNT in", values, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountNotIn(List<Integer> values) {
			addCriterion("XZYX_KXZ_COUNT not in", values, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_KXZ_COUNT between", value1, value2, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_KXZ_COUNT not between", value1, value2, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountIsNull() {
			addCriterion("XZYX_GJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountIsNotNull() {
			addCriterion("XZYX_GJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountEqualTo(Integer value) {
			addCriterion("XZYX_GJ_COUNT =", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountNotEqualTo(Integer value) {
			addCriterion("XZYX_GJ_COUNT <>", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountGreaterThan(Integer value) {
			addCriterion("XZYX_GJ_COUNT >", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_GJ_COUNT >=", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountLessThan(Integer value) {
			addCriterion("XZYX_GJ_COUNT <", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_GJ_COUNT <=", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountIn(List<Integer> values) {
			addCriterion("XZYX_GJ_COUNT in", values, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountNotIn(List<Integer> values) {
			addCriterion("XZYX_GJ_COUNT not in", values, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_GJ_COUNT between", value1, value2, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_GJ_COUNT not between", value1, value2, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountIsNull() {
			addCriterion("XZYX_TPSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountIsNotNull() {
			addCriterion("XZYX_TPSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountEqualTo(Integer value) {
			addCriterion("XZYX_TPSC_COUNT =", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountNotEqualTo(Integer value) {
			addCriterion("XZYX_TPSC_COUNT <>", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountGreaterThan(Integer value) {
			addCriterion("XZYX_TPSC_COUNT >", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_TPSC_COUNT >=", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountLessThan(Integer value) {
			addCriterion("XZYX_TPSC_COUNT <", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_TPSC_COUNT <=", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountIn(List<Integer> values) {
			addCriterion("XZYX_TPSC_COUNT in", values, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountNotIn(List<Integer> values) {
			addCriterion("XZYX_TPSC_COUNT not in", values, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_TPSC_COUNT between", value1, value2, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_TPSC_COUNT not between", value1, value2, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountIsNull() {
			addCriterion("XZYX_SPSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountIsNotNull() {
			addCriterion("XZYX_SPSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountEqualTo(Integer value) {
			addCriterion("XZYX_SPSC_COUNT =", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountNotEqualTo(Integer value) {
			addCriterion("XZYX_SPSC_COUNT <>", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountGreaterThan(Integer value) {
			addCriterion("XZYX_SPSC_COUNT >", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_SPSC_COUNT >=", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountLessThan(Integer value) {
			addCriterion("XZYX_SPSC_COUNT <", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_SPSC_COUNT <=", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountIn(List<Integer> values) {
			addCriterion("XZYX_SPSC_COUNT in", values, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountNotIn(List<Integer> values) {
			addCriterion("XZYX_SPSC_COUNT not in", values, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_SPSC_COUNT between", value1, value2, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_SPSC_COUNT not between", value1, value2, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountIsNull() {
			addCriterion("XZYX_VRSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountIsNotNull() {
			addCriterion("XZYX_VRSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountEqualTo(Integer value) {
			addCriterion("XZYX_VRSC_COUNT =", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountNotEqualTo(Integer value) {
			addCriterion("XZYX_VRSC_COUNT <>", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountGreaterThan(Integer value) {
			addCriterion("XZYX_VRSC_COUNT >", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_VRSC_COUNT >=", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountLessThan(Integer value) {
			addCriterion("XZYX_VRSC_COUNT <", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_VRSC_COUNT <=", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountIn(List<Integer> values) {
			addCriterion("XZYX_VRSC_COUNT in", values, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountNotIn(List<Integer> values) {
			addCriterion("XZYX_VRSC_COUNT not in", values, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_VRSC_COUNT between", value1, value2, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_VRSC_COUNT not between", value1, value2, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountIsNull() {
			addCriterion("XZYX_ZFY_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountIsNotNull() {
			addCriterion("XZYX_ZFY_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountEqualTo(Integer value) {
			addCriterion("XZYX_ZFY_COUNT =", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountNotEqualTo(Integer value) {
			addCriterion("XZYX_ZFY_COUNT <>", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountGreaterThan(Integer value) {
			addCriterion("XZYX_ZFY_COUNT >", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_ZFY_COUNT >=", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountLessThan(Integer value) {
			addCriterion("XZYX_ZFY_COUNT <", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_ZFY_COUNT <=", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountIn(List<Integer> values) {
			addCriterion("XZYX_ZFY_COUNT in", values, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountNotIn(List<Integer> values) {
			addCriterion("XZYX_ZFY_COUNT not in", values, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_ZFY_COUNT between", value1, value2, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_ZFY_COUNT not between", value1, value2, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountIsNull() {
			addCriterion("XZYX_IPCALL_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountIsNotNull() {
			addCriterion("XZYX_IPCALL_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountEqualTo(Integer value) {
			addCriterion("XZYX_IPCALL_COUNT =", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountNotEqualTo(Integer value) {
			addCriterion("XZYX_IPCALL_COUNT <>", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountGreaterThan(Integer value) {
			addCriterion("XZYX_IPCALL_COUNT >", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_IPCALL_COUNT >=", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountLessThan(Integer value) {
			addCriterion("XZYX_IPCALL_COUNT <", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_IPCALL_COUNT <=", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountIn(List<Integer> values) {
			addCriterion("XZYX_IPCALL_COUNT in", values, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountNotIn(List<Integer> values) {
			addCriterion("XZYX_IPCALL_COUNT not in", values, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_IPCALL_COUNT between", value1, value2, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_IPCALL_COUNT not between", value1, value2, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountIsNull() {
			addCriterion("XZYX_KFDP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountIsNotNull() {
			addCriterion("XZYX_KFDP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountEqualTo(Integer value) {
			addCriterion("XZYX_KFDP_COUNT =", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountNotEqualTo(Integer value) {
			addCriterion("XZYX_KFDP_COUNT <>", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountGreaterThan(Integer value) {
			addCriterion("XZYX_KFDP_COUNT >", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_KFDP_COUNT >=", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountLessThan(Integer value) {
			addCriterion("XZYX_KFDP_COUNT <", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_KFDP_COUNT <=", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountIn(List<Integer> values) {
			addCriterion("XZYX_KFDP_COUNT in", values, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountNotIn(List<Integer> values) {
			addCriterion("XZYX_KFDP_COUNT not in", values, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_KFDP_COUNT between", value1, value2, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_KFDP_COUNT not between", value1, value2, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountIsNull() {
			addCriterion("XZYX_HBFX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountIsNotNull() {
			addCriterion("XZYX_HBFX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountEqualTo(Integer value) {
			addCriterion("XZYX_HBFX_COUNT =", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountNotEqualTo(Integer value) {
			addCriterion("XZYX_HBFX_COUNT <>", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountGreaterThan(Integer value) {
			addCriterion("XZYX_HBFX_COUNT >", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_HBFX_COUNT >=", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountLessThan(Integer value) {
			addCriterion("XZYX_HBFX_COUNT <", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_HBFX_COUNT <=", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountIn(List<Integer> values) {
			addCriterion("XZYX_HBFX_COUNT in", values, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountNotIn(List<Integer> values) {
			addCriterion("XZYX_HBFX_COUNT not in", values, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_HBFX_COUNT between", value1, value2, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_HBFX_COUNT not between", value1, value2, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountIsNull() {
			addCriterion("XZYX_YSTJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountIsNotNull() {
			addCriterion("XZYX_YSTJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountEqualTo(Integer value) {
			addCriterion("XZYX_YSTJ_COUNT =", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountNotEqualTo(Integer value) {
			addCriterion("XZYX_YSTJ_COUNT <>", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountGreaterThan(Integer value) {
			addCriterion("XZYX_YSTJ_COUNT >", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_YSTJ_COUNT >=", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountLessThan(Integer value) {
			addCriterion("XZYX_YSTJ_COUNT <", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_YSTJ_COUNT <=", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountIn(List<Integer> values) {
			addCriterion("XZYX_YSTJ_COUNT in", values, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountNotIn(List<Integer> values) {
			addCriterion("XZYX_YSTJ_COUNT not in", values, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_YSTJ_COUNT between", value1, value2, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_YSTJ_COUNT not between", value1, value2, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountIsNull() {
			addCriterion("XZYX_PTWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountIsNotNull() {
			addCriterion("XZYX_PTWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountEqualTo(Integer value) {
			addCriterion("XZYX_PTWT_COUNT =", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountNotEqualTo(Integer value) {
			addCriterion("XZYX_PTWT_COUNT <>", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountGreaterThan(Integer value) {
			addCriterion("XZYX_PTWT_COUNT >", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_PTWT_COUNT >=", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountLessThan(Integer value) {
			addCriterion("XZYX_PTWT_COUNT <", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_PTWT_COUNT <=", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountIn(List<Integer> values) {
			addCriterion("XZYX_PTWT_COUNT in", values, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountNotIn(List<Integer> values) {
			addCriterion("XZYX_PTWT_COUNT not in", values, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_PTWT_COUNT between", value1, value2, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_PTWT_COUNT not between", value1, value2, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountIsNull() {
			addCriterion("XZYX_XSWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountIsNotNull() {
			addCriterion("XZYX_XSWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountEqualTo(Integer value) {
			addCriterion("XZYX_XSWT_COUNT =", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountNotEqualTo(Integer value) {
			addCriterion("XZYX_XSWT_COUNT <>", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountGreaterThan(Integer value) {
			addCriterion("XZYX_XSWT_COUNT >", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_XSWT_COUNT >=", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountLessThan(Integer value) {
			addCriterion("XZYX_XSWT_COUNT <", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_XSWT_COUNT <=", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountIn(List<Integer> values) {
			addCriterion("XZYX_XSWT_COUNT in", values, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountNotIn(List<Integer> values) {
			addCriterion("XZYX_XSWT_COUNT not in", values, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_XSWT_COUNT between", value1, value2, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_XSWT_COUNT not between", value1, value2, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountIsNull() {
			addCriterion("XZYX_DJWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountIsNotNull() {
			addCriterion("XZYX_DJWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountEqualTo(Integer value) {
			addCriterion("XZYX_DJWT_COUNT =", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountNotEqualTo(Integer value) {
			addCriterion("XZYX_DJWT_COUNT <>", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountGreaterThan(Integer value) {
			addCriterion("XZYX_DJWT_COUNT >", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_DJWT_COUNT >=", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountLessThan(Integer value) {
			addCriterion("XZYX_DJWT_COUNT <", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_DJWT_COUNT <=", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountIn(List<Integer> values) {
			addCriterion("XZYX_DJWT_COUNT in", values, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountNotIn(List<Integer> values) {
			addCriterion("XZYX_DJWT_COUNT not in", values, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_DJWT_COUNT between", value1, value2, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_DJWT_COUNT not between", value1, value2, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountIsNull() {
			addCriterion("XZYX_BZWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountIsNotNull() {
			addCriterion("XZYX_BZWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountEqualTo(Integer value) {
			addCriterion("XZYX_BZWT_COUNT =", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountNotEqualTo(Integer value) {
			addCriterion("XZYX_BZWT_COUNT <>", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountGreaterThan(Integer value) {
			addCriterion("XZYX_BZWT_COUNT >", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_BZWT_COUNT >=", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountLessThan(Integer value) {
			addCriterion("XZYX_BZWT_COUNT <", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_BZWT_COUNT <=", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountIn(List<Integer> values) {
			addCriterion("XZYX_BZWT_COUNT in", values, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountNotIn(List<Integer> values) {
			addCriterion("XZYX_BZWT_COUNT not in", values, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_BZWT_COUNT between", value1, value2, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_BZWT_COUNT not between", value1, value2, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountIsNull() {
			addCriterion("XZYX_FK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountIsNotNull() {
			addCriterion("XZYX_FK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountEqualTo(Integer value) {
			addCriterion("XZYX_FK_COUNT =", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountNotEqualTo(Integer value) {
			addCriterion("XZYX_FK_COUNT <>", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountGreaterThan(Integer value) {
			addCriterion("XZYX_FK_COUNT >", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_FK_COUNT >=", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountLessThan(Integer value) {
			addCriterion("XZYX_FK_COUNT <", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_FK_COUNT <=", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountIn(List<Integer> values) {
			addCriterion("XZYX_FK_COUNT in", values, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountNotIn(List<Integer> values) {
			addCriterion("XZYX_FK_COUNT not in", values, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_FK_COUNT between", value1, value2, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_FK_COUNT not between", value1, value2, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountIsNull() {
			addCriterion("XZYX_YJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountIsNotNull() {
			addCriterion("XZYX_YJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountEqualTo(Integer value) {
			addCriterion("XZYX_YJ_COUNT =", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountNotEqualTo(Integer value) {
			addCriterion("XZYX_YJ_COUNT <>", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountGreaterThan(Integer value) {
			addCriterion("XZYX_YJ_COUNT >", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_YJ_COUNT >=", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountLessThan(Integer value) {
			addCriterion("XZYX_YJ_COUNT <", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_YJ_COUNT <=", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountIn(List<Integer> values) {
			addCriterion("XZYX_YJ_COUNT in", values, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountNotIn(List<Integer> values) {
			addCriterion("XZYX_YJ_COUNT not in", values, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_YJ_COUNT between", value1, value2, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_YJ_COUNT not between", value1, value2, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountIsNull() {
			addCriterion("XZYX_DK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountIsNotNull() {
			addCriterion("XZYX_DK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountEqualTo(Integer value) {
			addCriterion("XZYX_DK_COUNT =", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountNotEqualTo(Integer value) {
			addCriterion("XZYX_DK_COUNT <>", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountGreaterThan(Integer value) {
			addCriterion("XZYX_DK_COUNT >", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XZYX_DK_COUNT >=", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountLessThan(Integer value) {
			addCriterion("XZYX_DK_COUNT <", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountLessThanOrEqualTo(Integer value) {
			addCriterion("XZYX_DK_COUNT <=", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountIn(List<Integer> values) {
			addCriterion("XZYX_DK_COUNT in", values, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountNotIn(List<Integer> values) {
			addCriterion("XZYX_DK_COUNT not in", values, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_DK_COUNT between", value1, value2, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XZYX_DK_COUNT not between", value1, value2, "xzyxDkCount");
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

		public Criteria andCheckTypeIsNull() {
			addCriterion("CHECK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCheckTypeIsNotNull() {
			addCriterion("CHECK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCheckTypeEqualTo(Byte value) {
			addCriterion("CHECK_TYPE =", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeNotEqualTo(Byte value) {
			addCriterion("CHECK_TYPE <>", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeGreaterThan(Byte value) {
			addCriterion("CHECK_TYPE >", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_TYPE >=", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeLessThan(Byte value) {
			addCriterion("CHECK_TYPE <", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_TYPE <=", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeIn(List<Byte> values) {
			addCriterion("CHECK_TYPE in", values, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeNotIn(List<Byte> values) {
			addCriterion("CHECK_TYPE not in", values, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_TYPE between", value1, value2, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_TYPE not between", value1, value2, "checkType");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdIsNull() {
			addCriterion("ROLE_WAGE_CONFIG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdIsNotNull() {
			addCriterion("ROLE_WAGE_CONFIG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID =", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdNotEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID <>", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdGreaterThan(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID >", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID >=", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdLessThan(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID <", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdLessThanOrEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID <=", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdIn(List<Integer> values) {
			addCriterion("ROLE_WAGE_CONFIG_ID in", values, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdNotIn(List<Integer> values) {
			addCriterion("ROLE_WAGE_CONFIG_ID not in", values, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdBetween(Integer value1, Integer value2) {
			addCriterion("ROLE_WAGE_CONFIG_ID between", value1, value2, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ROLE_WAGE_CONFIG_ID not between", value1, value2, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountIsNull() {
			addCriterion("XZ_PROFIT_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountIsNotNull() {
			addCriterion("XZ_PROFIT_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountEqualTo(BigDecimal value) {
			addCriterion("XZ_PROFIT_AMOUNT =", value, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_PROFIT_AMOUNT <>", value, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountGreaterThan(BigDecimal value) {
			addCriterion("XZ_PROFIT_AMOUNT >", value, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_PROFIT_AMOUNT >=", value, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountLessThan(BigDecimal value) {
			addCriterion("XZ_PROFIT_AMOUNT <", value, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_PROFIT_AMOUNT <=", value, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountIn(List<BigDecimal> values) {
			addCriterion("XZ_PROFIT_AMOUNT in", values, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_PROFIT_AMOUNT not in", values, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_PROFIT_AMOUNT between", value1, value2, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzProfitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_PROFIT_AMOUNT not between", value1, value2, "xzProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountIsNull() {
			addCriterion("XZYX_PROFIT_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountIsNotNull() {
			addCriterion("XZYX_PROFIT_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountEqualTo(BigDecimal value) {
			addCriterion("XZYX_PROFIT_AMOUNT =", value, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_PROFIT_AMOUNT <>", value, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_PROFIT_AMOUNT >", value, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_PROFIT_AMOUNT >=", value, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountLessThan(BigDecimal value) {
			addCriterion("XZYX_PROFIT_AMOUNT <", value, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_PROFIT_AMOUNT <=", value, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountIn(List<BigDecimal> values) {
			addCriterion("XZYX_PROFIT_AMOUNT in", values, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_PROFIT_AMOUNT not in", values, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_PROFIT_AMOUNT between", value1, value2, "xzyxProfitAmount");
			return (Criteria) this;
		}

		public Criteria andXzyxProfitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_PROFIT_AMOUNT not between", value1, value2, "xzyxProfitAmount");
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