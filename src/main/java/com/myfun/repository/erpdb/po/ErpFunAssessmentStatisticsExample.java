package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAssessmentStatisticsExample extends ShardDb {
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
	public ErpFunAssessmentStatisticsExample() {
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

		public Criteria andXzFxzCountEqualTo(BigDecimal value) {
			addCriterion("XZ_FXZ_COUNT =", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_FXZ_COUNT <>", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_FXZ_COUNT >", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FXZ_COUNT >=", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountLessThan(BigDecimal value) {
			addCriterion("XZ_FXZ_COUNT <", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FXZ_COUNT <=", value, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountIn(List<BigDecimal> values) {
			addCriterion("XZ_FXZ_COUNT in", values, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_FXZ_COUNT not in", values, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FXZ_COUNT between", value1, value2, "xzFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzFxzCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzKxzCountEqualTo(BigDecimal value) {
			addCriterion("XZ_KXZ_COUNT =", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_KXZ_COUNT <>", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_KXZ_COUNT >", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KXZ_COUNT >=", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountLessThan(BigDecimal value) {
			addCriterion("XZ_KXZ_COUNT <", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KXZ_COUNT <=", value, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountIn(List<BigDecimal> values) {
			addCriterion("XZ_KXZ_COUNT in", values, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_KXZ_COUNT not in", values, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KXZ_COUNT between", value1, value2, "xzKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzKxzCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzGjCountEqualTo(BigDecimal value) {
			addCriterion("XZ_GJ_COUNT =", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_GJ_COUNT <>", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_GJ_COUNT >", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_GJ_COUNT >=", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountLessThan(BigDecimal value) {
			addCriterion("XZ_GJ_COUNT <", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_GJ_COUNT <=", value, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountIn(List<BigDecimal> values) {
			addCriterion("XZ_GJ_COUNT in", values, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_GJ_COUNT not in", values, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_GJ_COUNT between", value1, value2, "xzGjCount");
			return (Criteria) this;
		}

		public Criteria andXzGjCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzTpscCountEqualTo(BigDecimal value) {
			addCriterion("XZ_TPSC_COUNT =", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_TPSC_COUNT <>", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_TPSC_COUNT >", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_TPSC_COUNT >=", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountLessThan(BigDecimal value) {
			addCriterion("XZ_TPSC_COUNT <", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_TPSC_COUNT <=", value, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountIn(List<BigDecimal> values) {
			addCriterion("XZ_TPSC_COUNT in", values, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_TPSC_COUNT not in", values, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_TPSC_COUNT between", value1, value2, "xzTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzTpscCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzSpscCountEqualTo(BigDecimal value) {
			addCriterion("XZ_SPSC_COUNT =", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_SPSC_COUNT <>", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_SPSC_COUNT >", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_SPSC_COUNT >=", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountLessThan(BigDecimal value) {
			addCriterion("XZ_SPSC_COUNT <", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_SPSC_COUNT <=", value, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountIn(List<BigDecimal> values) {
			addCriterion("XZ_SPSC_COUNT in", values, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_SPSC_COUNT not in", values, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_SPSC_COUNT between", value1, value2, "xzSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzSpscCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzVrscCountEqualTo(BigDecimal value) {
			addCriterion("XZ_VRSC_COUNT =", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_VRSC_COUNT <>", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_VRSC_COUNT >", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_VRSC_COUNT >=", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountLessThan(BigDecimal value) {
			addCriterion("XZ_VRSC_COUNT <", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_VRSC_COUNT <=", value, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountIn(List<BigDecimal> values) {
			addCriterion("XZ_VRSC_COUNT in", values, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_VRSC_COUNT not in", values, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_VRSC_COUNT between", value1, value2, "xzVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzVrscCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzZfyCountEqualTo(BigDecimal value) {
			addCriterion("XZ_ZFY_COUNT =", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_ZFY_COUNT <>", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_ZFY_COUNT >", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_ZFY_COUNT >=", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountLessThan(BigDecimal value) {
			addCriterion("XZ_ZFY_COUNT <", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_ZFY_COUNT <=", value, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountIn(List<BigDecimal> values) {
			addCriterion("XZ_ZFY_COUNT in", values, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_ZFY_COUNT not in", values, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_ZFY_COUNT between", value1, value2, "xzZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzZfyCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzIpcallCountEqualTo(BigDecimal value) {
			addCriterion("XZ_IPCALL_COUNT =", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_IPCALL_COUNT <>", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_IPCALL_COUNT >", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_IPCALL_COUNT >=", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountLessThan(BigDecimal value) {
			addCriterion("XZ_IPCALL_COUNT <", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_IPCALL_COUNT <=", value, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountIn(List<BigDecimal> values) {
			addCriterion("XZ_IPCALL_COUNT in", values, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_IPCALL_COUNT not in", values, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_IPCALL_COUNT between", value1, value2, "xzIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzIpcallCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzKfdpCountEqualTo(BigDecimal value) {
			addCriterion("XZ_KFDP_COUNT =", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_KFDP_COUNT <>", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_KFDP_COUNT >", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KFDP_COUNT >=", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountLessThan(BigDecimal value) {
			addCriterion("XZ_KFDP_COUNT <", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KFDP_COUNT <=", value, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountIn(List<BigDecimal> values) {
			addCriterion("XZ_KFDP_COUNT in", values, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_KFDP_COUNT not in", values, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KFDP_COUNT between", value1, value2, "xzKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzKfdpCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzHbfxCountEqualTo(BigDecimal value) {
			addCriterion("XZ_HBFX_COUNT =", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_HBFX_COUNT <>", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_HBFX_COUNT >", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_HBFX_COUNT >=", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountLessThan(BigDecimal value) {
			addCriterion("XZ_HBFX_COUNT <", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_HBFX_COUNT <=", value, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountIn(List<BigDecimal> values) {
			addCriterion("XZ_HBFX_COUNT in", values, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_HBFX_COUNT not in", values, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_HBFX_COUNT between", value1, value2, "xzHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzHbfxCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzYstjCountEqualTo(BigDecimal value) {
			addCriterion("XZ_YSTJ_COUNT =", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_YSTJ_COUNT <>", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_YSTJ_COUNT >", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_YSTJ_COUNT >=", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountLessThan(BigDecimal value) {
			addCriterion("XZ_YSTJ_COUNT <", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_YSTJ_COUNT <=", value, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountIn(List<BigDecimal> values) {
			addCriterion("XZ_YSTJ_COUNT in", values, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_YSTJ_COUNT not in", values, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_YSTJ_COUNT between", value1, value2, "xzYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzYstjCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzPtwtCountEqualTo(BigDecimal value) {
			addCriterion("XZ_PTWT_COUNT =", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_PTWT_COUNT <>", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_PTWT_COUNT >", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_PTWT_COUNT >=", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountLessThan(BigDecimal value) {
			addCriterion("XZ_PTWT_COUNT <", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_PTWT_COUNT <=", value, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountIn(List<BigDecimal> values) {
			addCriterion("XZ_PTWT_COUNT in", values, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_PTWT_COUNT not in", values, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_PTWT_COUNT between", value1, value2, "xzPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzPtwtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzXswtCountEqualTo(BigDecimal value) {
			addCriterion("XZ_XSWT_COUNT =", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_XSWT_COUNT <>", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_XSWT_COUNT >", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_XSWT_COUNT >=", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountLessThan(BigDecimal value) {
			addCriterion("XZ_XSWT_COUNT <", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_XSWT_COUNT <=", value, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountIn(List<BigDecimal> values) {
			addCriterion("XZ_XSWT_COUNT in", values, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_XSWT_COUNT not in", values, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_XSWT_COUNT between", value1, value2, "xzXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzXswtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzDjwtCountEqualTo(BigDecimal value) {
			addCriterion("XZ_DJWT_COUNT =", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_DJWT_COUNT <>", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_DJWT_COUNT >", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_DJWT_COUNT >=", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountLessThan(BigDecimal value) {
			addCriterion("XZ_DJWT_COUNT <", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_DJWT_COUNT <=", value, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountIn(List<BigDecimal> values) {
			addCriterion("XZ_DJWT_COUNT in", values, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_DJWT_COUNT not in", values, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_DJWT_COUNT between", value1, value2, "xzDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzDjwtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzBzwtCountEqualTo(BigDecimal value) {
			addCriterion("XZ_BZWT_COUNT =", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_BZWT_COUNT <>", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_BZWT_COUNT >", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_BZWT_COUNT >=", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountLessThan(BigDecimal value) {
			addCriterion("XZ_BZWT_COUNT <", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_BZWT_COUNT <=", value, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountIn(List<BigDecimal> values) {
			addCriterion("XZ_BZWT_COUNT in", values, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_BZWT_COUNT not in", values, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_BZWT_COUNT between", value1, value2, "xzBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzBzwtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzFkCountEqualTo(BigDecimal value) {
			addCriterion("XZ_FK_COUNT =", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_FK_COUNT <>", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_FK_COUNT >", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FK_COUNT >=", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountLessThan(BigDecimal value) {
			addCriterion("XZ_FK_COUNT <", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FK_COUNT <=", value, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountIn(List<BigDecimal> values) {
			addCriterion("XZ_FK_COUNT in", values, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_FK_COUNT not in", values, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FK_COUNT between", value1, value2, "xzFkCount");
			return (Criteria) this;
		}

		public Criteria andXzFkCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzYjCountEqualTo(BigDecimal value) {
			addCriterion("XZ_YJ_COUNT =", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_YJ_COUNT <>", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_YJ_COUNT >", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_YJ_COUNT >=", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountLessThan(BigDecimal value) {
			addCriterion("XZ_YJ_COUNT <", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_YJ_COUNT <=", value, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountIn(List<BigDecimal> values) {
			addCriterion("XZ_YJ_COUNT in", values, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_YJ_COUNT not in", values, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_YJ_COUNT between", value1, value2, "xzYjCount");
			return (Criteria) this;
		}

		public Criteria andXzYjCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzDkCountEqualTo(BigDecimal value) {
			addCriterion("XZ_DK_COUNT =", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_DK_COUNT <>", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_DK_COUNT >", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_DK_COUNT >=", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountLessThan(BigDecimal value) {
			addCriterion("XZ_DK_COUNT <", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_DK_COUNT <=", value, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountIn(List<BigDecimal> values) {
			addCriterion("XZ_DK_COUNT in", values, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_DK_COUNT not in", values, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_DK_COUNT between", value1, value2, "xzDkCount");
			return (Criteria) this;
		}

		public Criteria andXzDkCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxFxzCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_FXZ_COUNT =", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_FXZ_COUNT <>", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_FXZ_COUNT >", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FXZ_COUNT >=", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountLessThan(BigDecimal value) {
			addCriterion("XZYX_FXZ_COUNT <", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FXZ_COUNT <=", value, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_FXZ_COUNT in", values, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_FXZ_COUNT not in", values, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FXZ_COUNT between", value1, value2, "xzyxFxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFxzCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxKxzCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_KXZ_COUNT =", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_KXZ_COUNT <>", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_KXZ_COUNT >", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KXZ_COUNT >=", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountLessThan(BigDecimal value) {
			addCriterion("XZYX_KXZ_COUNT <", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KXZ_COUNT <=", value, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_KXZ_COUNT in", values, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_KXZ_COUNT not in", values, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KXZ_COUNT between", value1, value2, "xzyxKxzCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKxzCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxGjCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_GJ_COUNT =", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_GJ_COUNT <>", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_GJ_COUNT >", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_GJ_COUNT >=", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountLessThan(BigDecimal value) {
			addCriterion("XZYX_GJ_COUNT <", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_GJ_COUNT <=", value, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_GJ_COUNT in", values, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_GJ_COUNT not in", values, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_GJ_COUNT between", value1, value2, "xzyxGjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxGjCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxTpscCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_TPSC_COUNT =", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_TPSC_COUNT <>", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_TPSC_COUNT >", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_TPSC_COUNT >=", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountLessThan(BigDecimal value) {
			addCriterion("XZYX_TPSC_COUNT <", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_TPSC_COUNT <=", value, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_TPSC_COUNT in", values, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_TPSC_COUNT not in", values, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_TPSC_COUNT between", value1, value2, "xzyxTpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxTpscCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxSpscCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_SPSC_COUNT =", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_SPSC_COUNT <>", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_SPSC_COUNT >", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_SPSC_COUNT >=", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountLessThan(BigDecimal value) {
			addCriterion("XZYX_SPSC_COUNT <", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_SPSC_COUNT <=", value, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_SPSC_COUNT in", values, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_SPSC_COUNT not in", values, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_SPSC_COUNT between", value1, value2, "xzyxSpscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSpscCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxVrscCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_VRSC_COUNT =", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_VRSC_COUNT <>", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_VRSC_COUNT >", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_VRSC_COUNT >=", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountLessThan(BigDecimal value) {
			addCriterion("XZYX_VRSC_COUNT <", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_VRSC_COUNT <=", value, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_VRSC_COUNT in", values, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_VRSC_COUNT not in", values, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_VRSC_COUNT between", value1, value2, "xzyxVrscCount");
			return (Criteria) this;
		}

		public Criteria andXzyxVrscCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxZfyCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_ZFY_COUNT =", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_ZFY_COUNT <>", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_ZFY_COUNT >", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_ZFY_COUNT >=", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountLessThan(BigDecimal value) {
			addCriterion("XZYX_ZFY_COUNT <", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_ZFY_COUNT <=", value, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_ZFY_COUNT in", values, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_ZFY_COUNT not in", values, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_ZFY_COUNT between", value1, value2, "xzyxZfyCount");
			return (Criteria) this;
		}

		public Criteria andXzyxZfyCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxIpcallCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_IPCALL_COUNT =", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_IPCALL_COUNT <>", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_IPCALL_COUNT >", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_IPCALL_COUNT >=", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountLessThan(BigDecimal value) {
			addCriterion("XZYX_IPCALL_COUNT <", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_IPCALL_COUNT <=", value, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_IPCALL_COUNT in", values, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_IPCALL_COUNT not in", values, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_IPCALL_COUNT between", value1, value2, "xzyxIpcallCount");
			return (Criteria) this;
		}

		public Criteria andXzyxIpcallCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxKfdpCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_KFDP_COUNT =", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_KFDP_COUNT <>", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_KFDP_COUNT >", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KFDP_COUNT >=", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountLessThan(BigDecimal value) {
			addCriterion("XZYX_KFDP_COUNT <", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KFDP_COUNT <=", value, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_KFDP_COUNT in", values, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_KFDP_COUNT not in", values, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KFDP_COUNT between", value1, value2, "xzyxKfdpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKfdpCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxHbfxCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_HBFX_COUNT =", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_HBFX_COUNT <>", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_HBFX_COUNT >", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_HBFX_COUNT >=", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountLessThan(BigDecimal value) {
			addCriterion("XZYX_HBFX_COUNT <", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_HBFX_COUNT <=", value, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_HBFX_COUNT in", values, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_HBFX_COUNT not in", values, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_HBFX_COUNT between", value1, value2, "xzyxHbfxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxHbfxCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxYstjCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_YSTJ_COUNT =", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_YSTJ_COUNT <>", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_YSTJ_COUNT >", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_YSTJ_COUNT >=", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountLessThan(BigDecimal value) {
			addCriterion("XZYX_YSTJ_COUNT <", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_YSTJ_COUNT <=", value, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_YSTJ_COUNT in", values, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_YSTJ_COUNT not in", values, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_YSTJ_COUNT between", value1, value2, "xzyxYstjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYstjCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxPtwtCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_PTWT_COUNT =", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_PTWT_COUNT <>", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_PTWT_COUNT >", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_PTWT_COUNT >=", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountLessThan(BigDecimal value) {
			addCriterion("XZYX_PTWT_COUNT <", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_PTWT_COUNT <=", value, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_PTWT_COUNT in", values, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_PTWT_COUNT not in", values, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_PTWT_COUNT between", value1, value2, "xzyxPtwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxPtwtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxXswtCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_XSWT_COUNT =", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_XSWT_COUNT <>", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_XSWT_COUNT >", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_XSWT_COUNT >=", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountLessThan(BigDecimal value) {
			addCriterion("XZYX_XSWT_COUNT <", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_XSWT_COUNT <=", value, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_XSWT_COUNT in", values, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_XSWT_COUNT not in", values, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_XSWT_COUNT between", value1, value2, "xzyxXswtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxXswtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxDjwtCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_DJWT_COUNT =", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_DJWT_COUNT <>", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_DJWT_COUNT >", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_DJWT_COUNT >=", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountLessThan(BigDecimal value) {
			addCriterion("XZYX_DJWT_COUNT <", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_DJWT_COUNT <=", value, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_DJWT_COUNT in", values, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_DJWT_COUNT not in", values, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_DJWT_COUNT between", value1, value2, "xzyxDjwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDjwtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxBzwtCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_BZWT_COUNT =", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_BZWT_COUNT <>", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_BZWT_COUNT >", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_BZWT_COUNT >=", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountLessThan(BigDecimal value) {
			addCriterion("XZYX_BZWT_COUNT <", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_BZWT_COUNT <=", value, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_BZWT_COUNT in", values, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_BZWT_COUNT not in", values, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_BZWT_COUNT between", value1, value2, "xzyxBzwtCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBzwtCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxFkCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_FK_COUNT =", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_FK_COUNT <>", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_FK_COUNT >", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FK_COUNT >=", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountLessThan(BigDecimal value) {
			addCriterion("XZYX_FK_COUNT <", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FK_COUNT <=", value, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_FK_COUNT in", values, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_FK_COUNT not in", values, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FK_COUNT between", value1, value2, "xzyxFkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFkCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxYjCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_YJ_COUNT =", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_YJ_COUNT <>", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_YJ_COUNT >", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_YJ_COUNT >=", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountLessThan(BigDecimal value) {
			addCriterion("XZYX_YJ_COUNT <", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_YJ_COUNT <=", value, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_YJ_COUNT in", values, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_YJ_COUNT not in", values, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_YJ_COUNT between", value1, value2, "xzyxYjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxYjCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andXzyxDkCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_DK_COUNT =", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_DK_COUNT <>", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_DK_COUNT >", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_DK_COUNT >=", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountLessThan(BigDecimal value) {
			addCriterion("XZYX_DK_COUNT <", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_DK_COUNT <=", value, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_DK_COUNT in", values, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_DK_COUNT not in", values, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_DK_COUNT between", value1, value2, "xzyxDkCount");
			return (Criteria) this;
		}

		public Criteria andXzyxDkCountNotBetween(BigDecimal value1, BigDecimal value2) {
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

		public Criteria andDealFlagIsNull() {
			addCriterion("DEAL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDealFlagIsNotNull() {
			addCriterion("DEAL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDealFlagEqualTo(Byte value) {
			addCriterion("DEAL_FLAG =", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagNotEqualTo(Byte value) {
			addCriterion("DEAL_FLAG <>", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagGreaterThan(Byte value) {
			addCriterion("DEAL_FLAG >", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_FLAG >=", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagLessThan(Byte value) {
			addCriterion("DEAL_FLAG <", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_FLAG <=", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagIn(List<Byte> values) {
			addCriterion("DEAL_FLAG in", values, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagNotIn(List<Byte> values) {
			addCriterion("DEAL_FLAG not in", values, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_FLAG between", value1, value2, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_FLAG not between", value1, value2, "dealFlag");
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

		public Criteria andXzFdjCountIsNull() {
			addCriterion("XZ_FDJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountIsNotNull() {
			addCriterion("XZ_FDJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountEqualTo(BigDecimal value) {
			addCriterion("XZ_FDJ_COUNT =", value, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_FDJ_COUNT <>", value, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_FDJ_COUNT >", value, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FDJ_COUNT >=", value, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountLessThan(BigDecimal value) {
			addCriterion("XZ_FDJ_COUNT <", value, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FDJ_COUNT <=", value, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountIn(List<BigDecimal> values) {
			addCriterion("XZ_FDJ_COUNT in", values, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_FDJ_COUNT not in", values, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FDJ_COUNT between", value1, value2, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzFdjCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FDJ_COUNT not between", value1, value2, "xzFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountIsNull() {
			addCriterion("XZYX_FDJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountIsNotNull() {
			addCriterion("XZYX_FDJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_FDJ_COUNT =", value, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_FDJ_COUNT <>", value, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_FDJ_COUNT >", value, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FDJ_COUNT >=", value, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountLessThan(BigDecimal value) {
			addCriterion("XZYX_FDJ_COUNT <", value, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FDJ_COUNT <=", value, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_FDJ_COUNT in", values, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_FDJ_COUNT not in", values, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FDJ_COUNT between", value1, value2, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFdjCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FDJ_COUNT not between", value1, value2, "xzyxFdjCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountIsNull() {
			addCriterion("XZ_BUILDINFO_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountIsNotNull() {
			addCriterion("XZ_BUILDINFO_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountEqualTo(BigDecimal value) {
			addCriterion("XZ_BUILDINFO_COUNT =", value, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_BUILDINFO_COUNT <>", value, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_BUILDINFO_COUNT >", value, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_BUILDINFO_COUNT >=", value, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountLessThan(BigDecimal value) {
			addCriterion("XZ_BUILDINFO_COUNT <", value, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_BUILDINFO_COUNT <=", value, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountIn(List<BigDecimal> values) {
			addCriterion("XZ_BUILDINFO_COUNT in", values, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_BUILDINFO_COUNT not in", values, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_BUILDINFO_COUNT between", value1, value2, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzBuildinfoCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_BUILDINFO_COUNT not between", value1, value2, "xzBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountIsNull() {
			addCriterion("XZYX_BUILDINFO_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountIsNotNull() {
			addCriterion("XZYX_BUILDINFO_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_BUILDINFO_COUNT =", value, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_BUILDINFO_COUNT <>", value, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_BUILDINFO_COUNT >", value, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_BUILDINFO_COUNT >=", value, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountLessThan(BigDecimal value) {
			addCriterion("XZYX_BUILDINFO_COUNT <", value, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_BUILDINFO_COUNT <=", value, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_BUILDINFO_COUNT in", values, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_BUILDINFO_COUNT not in", values, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_BUILDINFO_COUNT between", value1, value2, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxBuildinfoCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_BUILDINFO_COUNT not between", value1, value2, "xzyxBuildinfoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountIsNull() {
			addCriterion("XZ_SOSO_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountIsNotNull() {
			addCriterion("XZ_SOSO_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountEqualTo(BigDecimal value) {
			addCriterion("XZ_SOSO_COUNT =", value, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_SOSO_COUNT <>", value, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_SOSO_COUNT >", value, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_SOSO_COUNT >=", value, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountLessThan(BigDecimal value) {
			addCriterion("XZ_SOSO_COUNT <", value, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_SOSO_COUNT <=", value, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountIn(List<BigDecimal> values) {
			addCriterion("XZ_SOSO_COUNT in", values, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_SOSO_COUNT not in", values, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_SOSO_COUNT between", value1, value2, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzSosoCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_SOSO_COUNT not between", value1, value2, "xzSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountIsNull() {
			addCriterion("XZYX_SOSO_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountIsNotNull() {
			addCriterion("XZYX_SOSO_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_SOSO_COUNT =", value, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_SOSO_COUNT <>", value, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_SOSO_COUNT >", value, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_SOSO_COUNT >=", value, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountLessThan(BigDecimal value) {
			addCriterion("XZYX_SOSO_COUNT <", value, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_SOSO_COUNT <=", value, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_SOSO_COUNT in", values, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_SOSO_COUNT not in", values, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_SOSO_COUNT between", value1, value2, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzyxSosoCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_SOSO_COUNT not between", value1, value2, "xzyxSosoCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountIsNull() {
			addCriterion("XZ_FPUBLIC_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountIsNotNull() {
			addCriterion("XZ_FPUBLIC_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountEqualTo(BigDecimal value) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT =", value, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT <>", value, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT >", value, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT >=", value, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountLessThan(BigDecimal value) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT <", value, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT <=", value, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountIn(List<BigDecimal> values) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT in", values, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT not in", values, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT between", value1, value2, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFpublicZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FPUBLIC_ZP_COUNT not between", value1, value2, "xzFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountIsNull() {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountIsNotNull() {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT =", value, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT <>", value, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT >", value, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT >=", value, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountLessThan(BigDecimal value) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT <", value, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT <=", value, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT in", values, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT not in", values, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT between", value1, value2, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFpublicZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FPUBLIC_ZP_COUNT not between", value1, value2, "xzyxFpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountIsNull() {
			addCriterion("XZ_FSHARE_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountIsNotNull() {
			addCriterion("XZ_FSHARE_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountEqualTo(BigDecimal value) {
			addCriterion("XZ_FSHARE_ZP_COUNT =", value, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_FSHARE_ZP_COUNT <>", value, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_FSHARE_ZP_COUNT >", value, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FSHARE_ZP_COUNT >=", value, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountLessThan(BigDecimal value) {
			addCriterion("XZ_FSHARE_ZP_COUNT <", value, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FSHARE_ZP_COUNT <=", value, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountIn(List<BigDecimal> values) {
			addCriterion("XZ_FSHARE_ZP_COUNT in", values, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_FSHARE_ZP_COUNT not in", values, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FSHARE_ZP_COUNT between", value1, value2, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFshareZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FSHARE_ZP_COUNT not between", value1, value2, "xzFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountIsNull() {
			addCriterion("XZYX_FSHARE_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountIsNotNull() {
			addCriterion("XZYX_FSHARE_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_FSHARE_ZP_COUNT =", value, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_FSHARE_ZP_COUNT <>", value, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_FSHARE_ZP_COUNT >", value, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FSHARE_ZP_COUNT >=", value, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountLessThan(BigDecimal value) {
			addCriterion("XZYX_FSHARE_ZP_COUNT <", value, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FSHARE_ZP_COUNT <=", value, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_FSHARE_ZP_COUNT in", values, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_FSHARE_ZP_COUNT not in", values, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FSHARE_ZP_COUNT between", value1, value2, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFshareZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FSHARE_ZP_COUNT not between", value1, value2, "xzyxFshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountIsNull() {
			addCriterion("XZ_FZYX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountIsNotNull() {
			addCriterion("XZ_FZYX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountEqualTo(BigDecimal value) {
			addCriterion("XZ_FZYX_COUNT =", value, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_FZYX_COUNT <>", value, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_FZYX_COUNT >", value, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FZYX_COUNT >=", value, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountLessThan(BigDecimal value) {
			addCriterion("XZ_FZYX_COUNT <", value, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_FZYX_COUNT <=", value, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountIn(List<BigDecimal> values) {
			addCriterion("XZ_FZYX_COUNT in", values, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_FZYX_COUNT not in", values, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FZYX_COUNT between", value1, value2, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzFzyxCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_FZYX_COUNT not between", value1, value2, "xzFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountIsNull() {
			addCriterion("XZYX_FZYX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountIsNotNull() {
			addCriterion("XZYX_FZYX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_FZYX_COUNT =", value, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_FZYX_COUNT <>", value, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_FZYX_COUNT >", value, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FZYX_COUNT >=", value, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountLessThan(BigDecimal value) {
			addCriterion("XZYX_FZYX_COUNT <", value, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_FZYX_COUNT <=", value, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_FZYX_COUNT in", values, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_FZYX_COUNT not in", values, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FZYX_COUNT between", value1, value2, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxFzyxCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_FZYX_COUNT not between", value1, value2, "xzyxFzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountIsNull() {
			addCriterion("XZ_KDJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountIsNotNull() {
			addCriterion("XZ_KDJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountEqualTo(BigDecimal value) {
			addCriterion("XZ_KDJ_COUNT =", value, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_KDJ_COUNT <>", value, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_KDJ_COUNT >", value, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KDJ_COUNT >=", value, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountLessThan(BigDecimal value) {
			addCriterion("XZ_KDJ_COUNT <", value, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KDJ_COUNT <=", value, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountIn(List<BigDecimal> values) {
			addCriterion("XZ_KDJ_COUNT in", values, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_KDJ_COUNT not in", values, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KDJ_COUNT between", value1, value2, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKdjCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KDJ_COUNT not between", value1, value2, "xzKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountIsNull() {
			addCriterion("XZYX_KDJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountIsNotNull() {
			addCriterion("XZYX_KDJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_KDJ_COUNT =", value, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_KDJ_COUNT <>", value, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_KDJ_COUNT >", value, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KDJ_COUNT >=", value, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountLessThan(BigDecimal value) {
			addCriterion("XZYX_KDJ_COUNT <", value, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KDJ_COUNT <=", value, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_KDJ_COUNT in", values, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_KDJ_COUNT not in", values, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KDJ_COUNT between", value1, value2, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKdjCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KDJ_COUNT not between", value1, value2, "xzyxKdjCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountIsNull() {
			addCriterion("XZ_KPUBLIC_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountIsNotNull() {
			addCriterion("XZ_KPUBLIC_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountEqualTo(BigDecimal value) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT =", value, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT <>", value, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT >", value, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT >=", value, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountLessThan(BigDecimal value) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT <", value, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT <=", value, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountIn(List<BigDecimal> values) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT in", values, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT not in", values, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT between", value1, value2, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKpublicZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KPUBLIC_ZP_COUNT not between", value1, value2, "xzKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountIsNull() {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountIsNotNull() {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT =", value, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT <>", value, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT >", value, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT >=", value, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountLessThan(BigDecimal value) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT <", value, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT <=", value, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT in", values, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT not in", values, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT between", value1, value2, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKpublicZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KPUBLIC_ZP_COUNT not between", value1, value2, "xzyxKpublicZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountIsNull() {
			addCriterion("XZ_KSHARE_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountIsNotNull() {
			addCriterion("XZ_KSHARE_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountEqualTo(BigDecimal value) {
			addCriterion("XZ_KSHARE_ZP_COUNT =", value, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_KSHARE_ZP_COUNT <>", value, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_KSHARE_ZP_COUNT >", value, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KSHARE_ZP_COUNT >=", value, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountLessThan(BigDecimal value) {
			addCriterion("XZ_KSHARE_ZP_COUNT <", value, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KSHARE_ZP_COUNT <=", value, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountIn(List<BigDecimal> values) {
			addCriterion("XZ_KSHARE_ZP_COUNT in", values, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_KSHARE_ZP_COUNT not in", values, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KSHARE_ZP_COUNT between", value1, value2, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKshareZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KSHARE_ZP_COUNT not between", value1, value2, "xzKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountIsNull() {
			addCriterion("XZYX_KSHARE_ZP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountIsNotNull() {
			addCriterion("XZYX_KSHARE_ZP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_KSHARE_ZP_COUNT =", value, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_KSHARE_ZP_COUNT <>", value, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_KSHARE_ZP_COUNT >", value, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KSHARE_ZP_COUNT >=", value, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountLessThan(BigDecimal value) {
			addCriterion("XZYX_KSHARE_ZP_COUNT <", value, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KSHARE_ZP_COUNT <=", value, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_KSHARE_ZP_COUNT in", values, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_KSHARE_ZP_COUNT not in", values, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KSHARE_ZP_COUNT between", value1, value2, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKshareZpCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KSHARE_ZP_COUNT not between", value1, value2, "xzyxKshareZpCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountIsNull() {
			addCriterion("XZ_KZYX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountIsNotNull() {
			addCriterion("XZ_KZYX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountEqualTo(BigDecimal value) {
			addCriterion("XZ_KZYX_COUNT =", value, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_KZYX_COUNT <>", value, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_KZYX_COUNT >", value, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KZYX_COUNT >=", value, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountLessThan(BigDecimal value) {
			addCriterion("XZ_KZYX_COUNT <", value, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_KZYX_COUNT <=", value, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountIn(List<BigDecimal> values) {
			addCriterion("XZ_KZYX_COUNT in", values, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_KZYX_COUNT not in", values, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KZYX_COUNT between", value1, value2, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzKzyxCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_KZYX_COUNT not between", value1, value2, "xzKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountIsNull() {
			addCriterion("XZYX_KZYX_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountIsNotNull() {
			addCriterion("XZYX_KZYX_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_KZYX_COUNT =", value, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_KZYX_COUNT <>", value, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_KZYX_COUNT >", value, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KZYX_COUNT >=", value, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountLessThan(BigDecimal value) {
			addCriterion("XZYX_KZYX_COUNT <", value, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_KZYX_COUNT <=", value, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_KZYX_COUNT in", values, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_KZYX_COUNT not in", values, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KZYX_COUNT between", value1, value2, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzyxKzyxCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_KZYX_COUNT not between", value1, value2, "xzyxKzyxCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountIsNull() {
			addCriterion("XZ_QXZH_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountIsNotNull() {
			addCriterion("XZ_QXZH_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountEqualTo(BigDecimal value) {
			addCriterion("XZ_QXZH_COUNT =", value, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountNotEqualTo(BigDecimal value) {
			addCriterion("XZ_QXZH_COUNT <>", value, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountGreaterThan(BigDecimal value) {
			addCriterion("XZ_QXZH_COUNT >", value, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_QXZH_COUNT >=", value, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountLessThan(BigDecimal value) {
			addCriterion("XZ_QXZH_COUNT <", value, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZ_QXZH_COUNT <=", value, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountIn(List<BigDecimal> values) {
			addCriterion("XZ_QXZH_COUNT in", values, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountNotIn(List<BigDecimal> values) {
			addCriterion("XZ_QXZH_COUNT not in", values, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_QXZH_COUNT between", value1, value2, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzQxzhCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZ_QXZH_COUNT not between", value1, value2, "xzQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountIsNull() {
			addCriterion("XZYX_QXZH_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountIsNotNull() {
			addCriterion("XZYX_QXZH_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountEqualTo(BigDecimal value) {
			addCriterion("XZYX_QXZH_COUNT =", value, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountNotEqualTo(BigDecimal value) {
			addCriterion("XZYX_QXZH_COUNT <>", value, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountGreaterThan(BigDecimal value) {
			addCriterion("XZYX_QXZH_COUNT >", value, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_QXZH_COUNT >=", value, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountLessThan(BigDecimal value) {
			addCriterion("XZYX_QXZH_COUNT <", value, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("XZYX_QXZH_COUNT <=", value, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountIn(List<BigDecimal> values) {
			addCriterion("XZYX_QXZH_COUNT in", values, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountNotIn(List<BigDecimal> values) {
			addCriterion("XZYX_QXZH_COUNT not in", values, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_QXZH_COUNT between", value1, value2, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andXzyxQxzhCountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("XZYX_QXZH_COUNT not between", value1, value2, "xzyxQxzhCount");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusIsNull() {
			addCriterion("EFFECTIVE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusIsNotNull() {
			addCriterion("EFFECTIVE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS =", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusNotEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS <>", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusGreaterThan(Byte value) {
			addCriterion("EFFECTIVE_STATUS >", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS >=", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusLessThan(Byte value) {
			addCriterion("EFFECTIVE_STATUS <", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusLessThanOrEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS <=", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusIn(List<Byte> values) {
			addCriterion("EFFECTIVE_STATUS in", values, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusNotIn(List<Byte> values) {
			addCriterion("EFFECTIVE_STATUS not in", values, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusBetween(Byte value1, Byte value2) {
			addCriterion("EFFECTIVE_STATUS between", value1, value2, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("EFFECTIVE_STATUS not between", value1, value2, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNull() {
			addCriterion("ORGANIZATION_ID is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNotNull() {
			addCriterion("ORGANIZATION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID =", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <>", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThan(Integer value) {
			addCriterion("ORGANIZATION_ID >", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID >=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThan(Integer value) {
			addCriterion("ORGANIZATION_ID <", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID not in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID between", value1, value2, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID not between", value1, value2, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNull() {
			addCriterion("ORGANIZATION_PATH is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNotNull() {
			addCriterion("ORGANIZATION_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH =", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <>", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThan(String value) {
			addCriterion("ORGANIZATION_PATH >", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH >=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThan(String value) {
			addCriterion("ORGANIZATION_PATH <", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLike(String value) {
			addCriterion("ORGANIZATION_PATH like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotLike(String value) {
			addCriterion("ORGANIZATION_PATH not like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH not in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH between", value1, value2, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH not between", value1, value2, "organizationPath");
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