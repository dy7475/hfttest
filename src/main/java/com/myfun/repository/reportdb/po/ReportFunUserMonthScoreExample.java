package com.myfun.repository.reportdb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportFunUserMonthScoreExample {
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
	public ReportFunUserMonthScoreExample() {
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

		public Criteria andMonthTotalAmountIsNull() {
			addCriterion("MONTH_TOTAL_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountIsNotNull() {
			addCriterion("MONTH_TOTAL_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountEqualTo(BigDecimal value) {
			addCriterion("MONTH_TOTAL_AMOUNT =", value, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountNotEqualTo(BigDecimal value) {
			addCriterion("MONTH_TOTAL_AMOUNT <>", value, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountGreaterThan(BigDecimal value) {
			addCriterion("MONTH_TOTAL_AMOUNT >", value, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MONTH_TOTAL_AMOUNT >=", value, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountLessThan(BigDecimal value) {
			addCriterion("MONTH_TOTAL_AMOUNT <", value, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MONTH_TOTAL_AMOUNT <=", value, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountIn(List<BigDecimal> values) {
			addCriterion("MONTH_TOTAL_AMOUNT in", values, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountNotIn(List<BigDecimal> values) {
			addCriterion("MONTH_TOTAL_AMOUNT not in", values, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MONTH_TOTAL_AMOUNT between", value1, value2, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andMonthTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MONTH_TOTAL_AMOUNT not between", value1, value2, "monthTotalAmount");
			return (Criteria) this;
		}

		public Criteria andCompNoIsNull() {
			addCriterion("COMP_NO is null");
			return (Criteria) this;
		}

		public Criteria andCompNoIsNotNull() {
			addCriterion("COMP_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCompNoEqualTo(String value) {
			addCriterion("COMP_NO =", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotEqualTo(String value) {
			addCriterion("COMP_NO <>", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoGreaterThan(String value) {
			addCriterion("COMP_NO >", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_NO >=", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLessThan(String value) {
			addCriterion("COMP_NO <", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLessThanOrEqualTo(String value) {
			addCriterion("COMP_NO <=", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLike(String value) {
			addCriterion("COMP_NO like", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotLike(String value) {
			addCriterion("COMP_NO not like", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoIn(List<String> values) {
			addCriterion("COMP_NO in", values, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotIn(List<String> values) {
			addCriterion("COMP_NO not in", values, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoBetween(String value1, String value2) {
			addCriterion("COMP_NO between", value1, value2, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotBetween(String value1, String value2) {
			addCriterion("COMP_NO not between", value1, value2, "compNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNull() {
			addCriterion("DEPT_NO is null");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNotNull() {
			addCriterion("DEPT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNoEqualTo(String value) {
			addCriterion("DEPT_NO =", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotEqualTo(String value) {
			addCriterion("DEPT_NO <>", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThan(String value) {
			addCriterion("DEPT_NO >", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NO >=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThan(String value) {
			addCriterion("DEPT_NO <", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NO <=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLike(String value) {
			addCriterion("DEPT_NO like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotLike(String value) {
			addCriterion("DEPT_NO not like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoIn(List<String> values) {
			addCriterion("DEPT_NO in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotIn(List<String> values) {
			addCriterion("DEPT_NO not in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoBetween(String value1, String value2) {
			addCriterion("DEPT_NO between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotBetween(String value1, String value2) {
			addCriterion("DEPT_NO not between", value1, value2, "deptNo");
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

		public Criteria andOrg1IsNull() {
			addCriterion("ORG_1 is null");
			return (Criteria) this;
		}

		public Criteria andOrg1IsNotNull() {
			addCriterion("ORG_1 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg1EqualTo(Integer value) {
			addCriterion("ORG_1 =", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1NotEqualTo(Integer value) {
			addCriterion("ORG_1 <>", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1GreaterThan(Integer value) {
			addCriterion("ORG_1 >", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_1 >=", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1LessThan(Integer value) {
			addCriterion("ORG_1 <", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_1 <=", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1In(List<Integer> values) {
			addCriterion("ORG_1 in", values, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1NotIn(List<Integer> values) {
			addCriterion("ORG_1 not in", values, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1Between(Integer value1, Integer value2) {
			addCriterion("ORG_1 between", value1, value2, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_1 not between", value1, value2, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg2IsNull() {
			addCriterion("ORG_2 is null");
			return (Criteria) this;
		}

		public Criteria andOrg2IsNotNull() {
			addCriterion("ORG_2 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg2EqualTo(Integer value) {
			addCriterion("ORG_2 =", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2NotEqualTo(Integer value) {
			addCriterion("ORG_2 <>", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2GreaterThan(Integer value) {
			addCriterion("ORG_2 >", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_2 >=", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2LessThan(Integer value) {
			addCriterion("ORG_2 <", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_2 <=", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2In(List<Integer> values) {
			addCriterion("ORG_2 in", values, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2NotIn(List<Integer> values) {
			addCriterion("ORG_2 not in", values, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2Between(Integer value1, Integer value2) {
			addCriterion("ORG_2 between", value1, value2, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_2 not between", value1, value2, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg3IsNull() {
			addCriterion("ORG_3 is null");
			return (Criteria) this;
		}

		public Criteria andOrg3IsNotNull() {
			addCriterion("ORG_3 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg3EqualTo(Integer value) {
			addCriterion("ORG_3 =", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3NotEqualTo(Integer value) {
			addCriterion("ORG_3 <>", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3GreaterThan(Integer value) {
			addCriterion("ORG_3 >", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_3 >=", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3LessThan(Integer value) {
			addCriterion("ORG_3 <", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_3 <=", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3In(List<Integer> values) {
			addCriterion("ORG_3 in", values, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3NotIn(List<Integer> values) {
			addCriterion("ORG_3 not in", values, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3Between(Integer value1, Integer value2) {
			addCriterion("ORG_3 between", value1, value2, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_3 not between", value1, value2, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg4IsNull() {
			addCriterion("ORG_4 is null");
			return (Criteria) this;
		}

		public Criteria andOrg4IsNotNull() {
			addCriterion("ORG_4 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg4EqualTo(Integer value) {
			addCriterion("ORG_4 =", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4NotEqualTo(Integer value) {
			addCriterion("ORG_4 <>", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4GreaterThan(Integer value) {
			addCriterion("ORG_4 >", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_4 >=", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4LessThan(Integer value) {
			addCriterion("ORG_4 <", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_4 <=", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4In(List<Integer> values) {
			addCriterion("ORG_4 in", values, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4NotIn(List<Integer> values) {
			addCriterion("ORG_4 not in", values, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4Between(Integer value1, Integer value2) {
			addCriterion("ORG_4 between", value1, value2, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_4 not between", value1, value2, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg5IsNull() {
			addCriterion("ORG_5 is null");
			return (Criteria) this;
		}

		public Criteria andOrg5IsNotNull() {
			addCriterion("ORG_5 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg5EqualTo(Integer value) {
			addCriterion("ORG_5 =", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5NotEqualTo(Integer value) {
			addCriterion("ORG_5 <>", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5GreaterThan(Integer value) {
			addCriterion("ORG_5 >", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_5 >=", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5LessThan(Integer value) {
			addCriterion("ORG_5 <", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_5 <=", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5In(List<Integer> values) {
			addCriterion("ORG_5 in", values, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5NotIn(List<Integer> values) {
			addCriterion("ORG_5 not in", values, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5Between(Integer value1, Integer value2) {
			addCriterion("ORG_5 between", value1, value2, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_5 not between", value1, value2, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg6IsNull() {
			addCriterion("ORG_6 is null");
			return (Criteria) this;
		}

		public Criteria andOrg6IsNotNull() {
			addCriterion("ORG_6 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg6EqualTo(Integer value) {
			addCriterion("ORG_6 =", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6NotEqualTo(Integer value) {
			addCriterion("ORG_6 <>", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6GreaterThan(Integer value) {
			addCriterion("ORG_6 >", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_6 >=", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6LessThan(Integer value) {
			addCriterion("ORG_6 <", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_6 <=", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6In(List<Integer> values) {
			addCriterion("ORG_6 in", values, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6NotIn(List<Integer> values) {
			addCriterion("ORG_6 not in", values, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6Between(Integer value1, Integer value2) {
			addCriterion("ORG_6 between", value1, value2, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_6 not between", value1, value2, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg7IsNull() {
			addCriterion("ORG_7 is null");
			return (Criteria) this;
		}

		public Criteria andOrg7IsNotNull() {
			addCriterion("ORG_7 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg7EqualTo(Integer value) {
			addCriterion("ORG_7 =", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7NotEqualTo(Integer value) {
			addCriterion("ORG_7 <>", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7GreaterThan(Integer value) {
			addCriterion("ORG_7 >", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_7 >=", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7LessThan(Integer value) {
			addCriterion("ORG_7 <", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_7 <=", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7In(List<Integer> values) {
			addCriterion("ORG_7 in", values, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7NotIn(List<Integer> values) {
			addCriterion("ORG_7 not in", values, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7Between(Integer value1, Integer value2) {
			addCriterion("ORG_7 between", value1, value2, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_7 not between", value1, value2, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg8IsNull() {
			addCriterion("ORG_8 is null");
			return (Criteria) this;
		}

		public Criteria andOrg8IsNotNull() {
			addCriterion("ORG_8 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg8EqualTo(Integer value) {
			addCriterion("ORG_8 =", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8NotEqualTo(Integer value) {
			addCriterion("ORG_8 <>", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8GreaterThan(Integer value) {
			addCriterion("ORG_8 >", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_8 >=", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8LessThan(Integer value) {
			addCriterion("ORG_8 <", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_8 <=", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8In(List<Integer> values) {
			addCriterion("ORG_8 in", values, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8NotIn(List<Integer> values) {
			addCriterion("ORG_8 not in", values, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8Between(Integer value1, Integer value2) {
			addCriterion("ORG_8 between", value1, value2, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_8 not between", value1, value2, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg9IsNull() {
			addCriterion("ORG_9 is null");
			return (Criteria) this;
		}

		public Criteria andOrg9IsNotNull() {
			addCriterion("ORG_9 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg9EqualTo(Integer value) {
			addCriterion("ORG_9 =", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9NotEqualTo(Integer value) {
			addCriterion("ORG_9 <>", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9GreaterThan(Integer value) {
			addCriterion("ORG_9 >", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_9 >=", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9LessThan(Integer value) {
			addCriterion("ORG_9 <", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_9 <=", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9In(List<Integer> values) {
			addCriterion("ORG_9 in", values, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9NotIn(List<Integer> values) {
			addCriterion("ORG_9 not in", values, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9Between(Integer value1, Integer value2) {
			addCriterion("ORG_9 between", value1, value2, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_9 not between", value1, value2, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg10IsNull() {
			addCriterion("ORG_10 is null");
			return (Criteria) this;
		}

		public Criteria andOrg10IsNotNull() {
			addCriterion("ORG_10 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg10EqualTo(Integer value) {
			addCriterion("ORG_10 =", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10NotEqualTo(Integer value) {
			addCriterion("ORG_10 <>", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10GreaterThan(Integer value) {
			addCriterion("ORG_10 >", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_10 >=", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10LessThan(Integer value) {
			addCriterion("ORG_10 <", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_10 <=", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10In(List<Integer> values) {
			addCriterion("ORG_10 in", values, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10NotIn(List<Integer> values) {
			addCriterion("ORG_10 not in", values, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10Between(Integer value1, Integer value2) {
			addCriterion("ORG_10 between", value1, value2, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_10 not between", value1, value2, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg11IsNull() {
			addCriterion("ORG_11 is null");
			return (Criteria) this;
		}

		public Criteria andOrg11IsNotNull() {
			addCriterion("ORG_11 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg11EqualTo(Integer value) {
			addCriterion("ORG_11 =", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11NotEqualTo(Integer value) {
			addCriterion("ORG_11 <>", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11GreaterThan(Integer value) {
			addCriterion("ORG_11 >", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_11 >=", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11LessThan(Integer value) {
			addCriterion("ORG_11 <", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_11 <=", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11In(List<Integer> values) {
			addCriterion("ORG_11 in", values, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11NotIn(List<Integer> values) {
			addCriterion("ORG_11 not in", values, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11Between(Integer value1, Integer value2) {
			addCriterion("ORG_11 between", value1, value2, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_11 not between", value1, value2, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg12IsNull() {
			addCriterion("ORG_12 is null");
			return (Criteria) this;
		}

		public Criteria andOrg12IsNotNull() {
			addCriterion("ORG_12 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg12EqualTo(Integer value) {
			addCriterion("ORG_12 =", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12NotEqualTo(Integer value) {
			addCriterion("ORG_12 <>", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12GreaterThan(Integer value) {
			addCriterion("ORG_12 >", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_12 >=", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12LessThan(Integer value) {
			addCriterion("ORG_12 <", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_12 <=", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12In(List<Integer> values) {
			addCriterion("ORG_12 in", values, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12NotIn(List<Integer> values) {
			addCriterion("ORG_12 not in", values, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12Between(Integer value1, Integer value2) {
			addCriterion("ORG_12 between", value1, value2, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_12 not between", value1, value2, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg13IsNull() {
			addCriterion("ORG_13 is null");
			return (Criteria) this;
		}

		public Criteria andOrg13IsNotNull() {
			addCriterion("ORG_13 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg13EqualTo(Integer value) {
			addCriterion("ORG_13 =", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13NotEqualTo(Integer value) {
			addCriterion("ORG_13 <>", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13GreaterThan(Integer value) {
			addCriterion("ORG_13 >", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_13 >=", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13LessThan(Integer value) {
			addCriterion("ORG_13 <", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_13 <=", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13In(List<Integer> values) {
			addCriterion("ORG_13 in", values, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13NotIn(List<Integer> values) {
			addCriterion("ORG_13 not in", values, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13Between(Integer value1, Integer value2) {
			addCriterion("ORG_13 between", value1, value2, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_13 not between", value1, value2, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg14IsNull() {
			addCriterion("ORG_14 is null");
			return (Criteria) this;
		}

		public Criteria andOrg14IsNotNull() {
			addCriterion("ORG_14 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg14EqualTo(Integer value) {
			addCriterion("ORG_14 =", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14NotEqualTo(Integer value) {
			addCriterion("ORG_14 <>", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14GreaterThan(Integer value) {
			addCriterion("ORG_14 >", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_14 >=", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14LessThan(Integer value) {
			addCriterion("ORG_14 <", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_14 <=", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14In(List<Integer> values) {
			addCriterion("ORG_14 in", values, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14NotIn(List<Integer> values) {
			addCriterion("ORG_14 not in", values, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14Between(Integer value1, Integer value2) {
			addCriterion("ORG_14 between", value1, value2, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_14 not between", value1, value2, "org14");
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