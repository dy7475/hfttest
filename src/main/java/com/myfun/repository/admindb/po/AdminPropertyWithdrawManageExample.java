package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminPropertyWithdrawManageExample {
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
	public AdminPropertyWithdrawManageExample() {
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

		public Criteria andWithdrawStatusIsNull() {
			addCriterion("WITHDRAW_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusIsNotNull() {
			addCriterion("WITHDRAW_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusEqualTo(Byte value) {
			addCriterion("WITHDRAW_STATUS =", value, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusNotEqualTo(Byte value) {
			addCriterion("WITHDRAW_STATUS <>", value, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusGreaterThan(Byte value) {
			addCriterion("WITHDRAW_STATUS >", value, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("WITHDRAW_STATUS >=", value, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusLessThan(Byte value) {
			addCriterion("WITHDRAW_STATUS <", value, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusLessThanOrEqualTo(Byte value) {
			addCriterion("WITHDRAW_STATUS <=", value, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusIn(List<Byte> values) {
			addCriterion("WITHDRAW_STATUS in", values, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusNotIn(List<Byte> values) {
			addCriterion("WITHDRAW_STATUS not in", values, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusBetween(Byte value1, Byte value2) {
			addCriterion("WITHDRAW_STATUS between", value1, value2, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andWithdrawStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("WITHDRAW_STATUS not between", value1, value2, "withdrawStatus");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIsNull() {
			addCriterion("APPLY_TIME is null");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIsNotNull() {
			addCriterion("APPLY_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andApplyTimeEqualTo(Date value) {
			addCriterion("APPLY_TIME =", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotEqualTo(Date value) {
			addCriterion("APPLY_TIME <>", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeGreaterThan(Date value) {
			addCriterion("APPLY_TIME >", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("APPLY_TIME >=", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeLessThan(Date value) {
			addCriterion("APPLY_TIME <", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
			addCriterion("APPLY_TIME <=", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIn(List<Date> values) {
			addCriterion("APPLY_TIME in", values, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotIn(List<Date> values) {
			addCriterion("APPLY_TIME not in", values, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeBetween(Date value1, Date value2) {
			addCriterion("APPLY_TIME between", value1, value2, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
			addCriterion("APPLY_TIME not between", value1, value2, "applyTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeIsNull() {
			addCriterion("WITHDRAW_TIME is null");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeIsNotNull() {
			addCriterion("WITHDRAW_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeEqualTo(Date value) {
			addCriterion("WITHDRAW_TIME =", value, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeNotEqualTo(Date value) {
			addCriterion("WITHDRAW_TIME <>", value, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeGreaterThan(Date value) {
			addCriterion("WITHDRAW_TIME >", value, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("WITHDRAW_TIME >=", value, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeLessThan(Date value) {
			addCriterion("WITHDRAW_TIME <", value, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeLessThanOrEqualTo(Date value) {
			addCriterion("WITHDRAW_TIME <=", value, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeIn(List<Date> values) {
			addCriterion("WITHDRAW_TIME in", values, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeNotIn(List<Date> values) {
			addCriterion("WITHDRAW_TIME not in", values, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeBetween(Date value1, Date value2) {
			addCriterion("WITHDRAW_TIME between", value1, value2, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andWithdrawTimeNotBetween(Date value1, Date value2) {
			addCriterion("WITHDRAW_TIME not between", value1, value2, "withdrawTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeIsNull() {
			addCriterion("ARRIVAL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeIsNotNull() {
			addCriterion("ARRIVAL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeEqualTo(Date value) {
			addCriterion("ARRIVAL_TIME =", value, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeNotEqualTo(Date value) {
			addCriterion("ARRIVAL_TIME <>", value, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeGreaterThan(Date value) {
			addCriterion("ARRIVAL_TIME >", value, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ARRIVAL_TIME >=", value, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeLessThan(Date value) {
			addCriterion("ARRIVAL_TIME <", value, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeLessThanOrEqualTo(Date value) {
			addCriterion("ARRIVAL_TIME <=", value, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeIn(List<Date> values) {
			addCriterion("ARRIVAL_TIME in", values, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeNotIn(List<Date> values) {
			addCriterion("ARRIVAL_TIME not in", values, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeBetween(Date value1, Date value2) {
			addCriterion("ARRIVAL_TIME between", value1, value2, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andArrivalTimeNotBetween(Date value1, Date value2) {
			addCriterion("ARRIVAL_TIME not between", value1, value2, "arrivalTime");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeIsNull() {
			addCriterion("RECEIVE_BANK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeIsNotNull() {
			addCriterion("RECEIVE_BANK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeEqualTo(Integer value) {
			addCriterion("RECEIVE_BANK_TYPE =", value, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeNotEqualTo(Integer value) {
			addCriterion("RECEIVE_BANK_TYPE <>", value, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeGreaterThan(Integer value) {
			addCriterion("RECEIVE_BANK_TYPE >", value, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECEIVE_BANK_TYPE >=", value, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeLessThan(Integer value) {
			addCriterion("RECEIVE_BANK_TYPE <", value, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeLessThanOrEqualTo(Integer value) {
			addCriterion("RECEIVE_BANK_TYPE <=", value, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeIn(List<Integer> values) {
			addCriterion("RECEIVE_BANK_TYPE in", values, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeNotIn(List<Integer> values) {
			addCriterion("RECEIVE_BANK_TYPE not in", values, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeBetween(Integer value1, Integer value2) {
			addCriterion("RECEIVE_BANK_TYPE between", value1, value2, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("RECEIVE_BANK_TYPE not between", value1, value2, "receiveBankType");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameIsNull() {
			addCriterion("RECEIVE_BANK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameIsNotNull() {
			addCriterion("RECEIVE_BANK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NAME =", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameNotEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NAME <>", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameGreaterThan(String value) {
			addCriterion("RECEIVE_BANK_NAME >", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NAME >=", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameLessThan(String value) {
			addCriterion("RECEIVE_BANK_NAME <", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameLessThanOrEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NAME <=", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameLike(String value) {
			addCriterion("RECEIVE_BANK_NAME like", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameNotLike(String value) {
			addCriterion("RECEIVE_BANK_NAME not like", value, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameIn(List<String> values) {
			addCriterion("RECEIVE_BANK_NAME in", values, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameNotIn(List<String> values) {
			addCriterion("RECEIVE_BANK_NAME not in", values, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameBetween(String value1, String value2) {
			addCriterion("RECEIVE_BANK_NAME between", value1, value2, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNameNotBetween(String value1, String value2) {
			addCriterion("RECEIVE_BANK_NAME not between", value1, value2, "receiveBankName");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoIsNull() {
			addCriterion("RECEIVE_BANK_NO is null");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoIsNotNull() {
			addCriterion("RECEIVE_BANK_NO is not null");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NO =", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoNotEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NO <>", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoGreaterThan(String value) {
			addCriterion("RECEIVE_BANK_NO >", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoGreaterThanOrEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NO >=", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoLessThan(String value) {
			addCriterion("RECEIVE_BANK_NO <", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoLessThanOrEqualTo(String value) {
			addCriterion("RECEIVE_BANK_NO <=", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoLike(String value) {
			addCriterion("RECEIVE_BANK_NO like", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoNotLike(String value) {
			addCriterion("RECEIVE_BANK_NO not like", value, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoIn(List<String> values) {
			addCriterion("RECEIVE_BANK_NO in", values, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoNotIn(List<String> values) {
			addCriterion("RECEIVE_BANK_NO not in", values, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoBetween(String value1, String value2) {
			addCriterion("RECEIVE_BANK_NO between", value1, value2, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andReceiveBankNoNotBetween(String value1, String value2) {
			addCriterion("RECEIVE_BANK_NO not between", value1, value2, "receiveBankNo");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountIsNull() {
			addCriterion("WITHDRAW_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountIsNotNull() {
			addCriterion("WITHDRAW_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountEqualTo(BigDecimal value) {
			addCriterion("WITHDRAW_AMOUNT =", value, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountNotEqualTo(BigDecimal value) {
			addCriterion("WITHDRAW_AMOUNT <>", value, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountGreaterThan(BigDecimal value) {
			addCriterion("WITHDRAW_AMOUNT >", value, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("WITHDRAW_AMOUNT >=", value, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountLessThan(BigDecimal value) {
			addCriterion("WITHDRAW_AMOUNT <", value, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("WITHDRAW_AMOUNT <=", value, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountIn(List<BigDecimal> values) {
			addCriterion("WITHDRAW_AMOUNT in", values, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountNotIn(List<BigDecimal> values) {
			addCriterion("WITHDRAW_AMOUNT not in", values, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WITHDRAW_AMOUNT between", value1, value2, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WITHDRAW_AMOUNT not between", value1, value2, "withdrawAmount");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdIsNull() {
			addCriterion("APPLY_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdIsNotNull() {
			addCriterion("APPLY_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdEqualTo(Integer value) {
			addCriterion("APPLY_USER_ID =", value, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdNotEqualTo(Integer value) {
			addCriterion("APPLY_USER_ID <>", value, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdGreaterThan(Integer value) {
			addCriterion("APPLY_USER_ID >", value, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("APPLY_USER_ID >=", value, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdLessThan(Integer value) {
			addCriterion("APPLY_USER_ID <", value, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("APPLY_USER_ID <=", value, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdIn(List<Integer> values) {
			addCriterion("APPLY_USER_ID in", values, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdNotIn(List<Integer> values) {
			addCriterion("APPLY_USER_ID not in", values, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdBetween(Integer value1, Integer value2) {
			addCriterion("APPLY_USER_ID between", value1, value2, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("APPLY_USER_ID not between", value1, value2, "applyUserId");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileIsNull() {
			addCriterion("APPLY_USER_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileIsNotNull() {
			addCriterion("APPLY_USER_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileEqualTo(String value) {
			addCriterion("APPLY_USER_MOBILE =", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileNotEqualTo(String value) {
			addCriterion("APPLY_USER_MOBILE <>", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileGreaterThan(String value) {
			addCriterion("APPLY_USER_MOBILE >", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileGreaterThanOrEqualTo(String value) {
			addCriterion("APPLY_USER_MOBILE >=", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileLessThan(String value) {
			addCriterion("APPLY_USER_MOBILE <", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileLessThanOrEqualTo(String value) {
			addCriterion("APPLY_USER_MOBILE <=", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileLike(String value) {
			addCriterion("APPLY_USER_MOBILE like", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileNotLike(String value) {
			addCriterion("APPLY_USER_MOBILE not like", value, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileIn(List<String> values) {
			addCriterion("APPLY_USER_MOBILE in", values, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileNotIn(List<String> values) {
			addCriterion("APPLY_USER_MOBILE not in", values, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileBetween(String value1, String value2) {
			addCriterion("APPLY_USER_MOBILE between", value1, value2, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andApplyUserMobileNotBetween(String value1, String value2) {
			addCriterion("APPLY_USER_MOBILE not between", value1, value2, "applyUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeIsNull() {
			addCriterion("BROKERAGE_FEE is null");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeIsNotNull() {
			addCriterion("BROKERAGE_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeEqualTo(BigDecimal value) {
			addCriterion("BROKERAGE_FEE =", value, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeNotEqualTo(BigDecimal value) {
			addCriterion("BROKERAGE_FEE <>", value, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeGreaterThan(BigDecimal value) {
			addCriterion("BROKERAGE_FEE >", value, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BROKERAGE_FEE >=", value, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeLessThan(BigDecimal value) {
			addCriterion("BROKERAGE_FEE <", value, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BROKERAGE_FEE <=", value, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeIn(List<BigDecimal> values) {
			addCriterion("BROKERAGE_FEE in", values, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeNotIn(List<BigDecimal> values) {
			addCriterion("BROKERAGE_FEE not in", values, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BROKERAGE_FEE between", value1, value2, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andBrokerageFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BROKERAGE_FEE not between", value1, value2, "brokerageFee");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNull() {
			addCriterion("DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNotNull() {
			addCriterion("DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNameEqualTo(String value) {
			addCriterion("DEPT_NAME =", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotEqualTo(String value) {
			addCriterion("DEPT_NAME <>", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThan(String value) {
			addCriterion("DEPT_NAME >", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME >=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThan(String value) {
			addCriterion("DEPT_NAME <", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME <=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLike(String value) {
			addCriterion("DEPT_NAME like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotLike(String value) {
			addCriterion("DEPT_NAME not like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameIn(List<String> values) {
			addCriterion("DEPT_NAME in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotIn(List<String> values) {
			addCriterion("DEPT_NAME not in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameBetween(String value1, String value2) {
			addCriterion("DEPT_NAME between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotBetween(String value1, String value2) {
			addCriterion("DEPT_NAME not between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameIsNull() {
			addCriterion("APPLY_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameIsNotNull() {
			addCriterion("APPLY_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameEqualTo(String value) {
			addCriterion("APPLY_USER_NAME =", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameNotEqualTo(String value) {
			addCriterion("APPLY_USER_NAME <>", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameGreaterThan(String value) {
			addCriterion("APPLY_USER_NAME >", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("APPLY_USER_NAME >=", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameLessThan(String value) {
			addCriterion("APPLY_USER_NAME <", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameLessThanOrEqualTo(String value) {
			addCriterion("APPLY_USER_NAME <=", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameLike(String value) {
			addCriterion("APPLY_USER_NAME like", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameNotLike(String value) {
			addCriterion("APPLY_USER_NAME not like", value, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameIn(List<String> values) {
			addCriterion("APPLY_USER_NAME in", values, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameNotIn(List<String> values) {
			addCriterion("APPLY_USER_NAME not in", values, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameBetween(String value1, String value2) {
			addCriterion("APPLY_USER_NAME between", value1, value2, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andApplyUserNameNotBetween(String value1, String value2) {
			addCriterion("APPLY_USER_NAME not between", value1, value2, "applyUserName");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyIsNull() {
			addCriterion("TOTAL_APPLY_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyIsNotNull() {
			addCriterion("TOTAL_APPLY_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyEqualTo(BigDecimal value) {
			addCriterion("TOTAL_APPLY_MONEY =", value, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyNotEqualTo(BigDecimal value) {
			addCriterion("TOTAL_APPLY_MONEY <>", value, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyGreaterThan(BigDecimal value) {
			addCriterion("TOTAL_APPLY_MONEY >", value, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_APPLY_MONEY >=", value, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyLessThan(BigDecimal value) {
			addCriterion("TOTAL_APPLY_MONEY <", value, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_APPLY_MONEY <=", value, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyIn(List<BigDecimal> values) {
			addCriterion("TOTAL_APPLY_MONEY in", values, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyNotIn(List<BigDecimal> values) {
			addCriterion("TOTAL_APPLY_MONEY not in", values, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_APPLY_MONEY between", value1, value2, "totalApplyMoney");
			return (Criteria) this;
		}

		public Criteria andTotalApplyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_APPLY_MONEY not between", value1, value2, "totalApplyMoney");
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