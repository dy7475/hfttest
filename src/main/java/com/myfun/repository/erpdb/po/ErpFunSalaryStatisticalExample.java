package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunSalaryStatisticalExample extends ShardDb {
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
	public ErpFunSalaryStatisticalExample() {
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

		public Criteria andHouseAddCountIsNull() {
			addCriterion("HOUSE_ADD_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountIsNotNull() {
			addCriterion("HOUSE_ADD_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT =", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountNotEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT <>", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountGreaterThan(Integer value) {
			addCriterion("HOUSE_ADD_COUNT >", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT >=", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountLessThan(Integer value) {
			addCriterion("HOUSE_ADD_COUNT <", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT <=", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountIn(List<Integer> values) {
			addCriterion("HOUSE_ADD_COUNT in", values, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountNotIn(List<Integer> values) {
			addCriterion("HOUSE_ADD_COUNT not in", values, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD_COUNT between", value1, value2, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD_COUNT not between", value1, value2, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountIsNull() {
			addCriterion("CUST_ADD_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andCustAddCountIsNotNull() {
			addCriterion("CUST_ADD_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andCustAddCountEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT =", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountNotEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT <>", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountGreaterThan(Integer value) {
			addCriterion("CUST_ADD_COUNT >", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT >=", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountLessThan(Integer value) {
			addCriterion("CUST_ADD_COUNT <", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountLessThanOrEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT <=", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountIn(List<Integer> values) {
			addCriterion("CUST_ADD_COUNT in", values, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountNotIn(List<Integer> values) {
			addCriterion("CUST_ADD_COUNT not in", values, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountBetween(Integer value1, Integer value2) {
			addCriterion("CUST_ADD_COUNT between", value1, value2, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountNotBetween(Integer value1, Integer value2) {
			addCriterion("CUST_ADD_COUNT not between", value1, value2, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountIsNull() {
			addCriterion("FANKAN_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFankanCountIsNotNull() {
			addCriterion("FANKAN_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFankanCountEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT =", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountNotEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT <>", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountGreaterThan(Integer value) {
			addCriterion("FANKAN_COUNT >", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT >=", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountLessThan(Integer value) {
			addCriterion("FANKAN_COUNT <", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountLessThanOrEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT <=", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountIn(List<Integer> values) {
			addCriterion("FANKAN_COUNT in", values, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountNotIn(List<Integer> values) {
			addCriterion("FANKAN_COUNT not in", values, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountBetween(Integer value1, Integer value2) {
			addCriterion("FANKAN_COUNT between", value1, value2, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FANKAN_COUNT not between", value1, value2, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountIsNull() {
			addCriterion("DAIKAN_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDaikanCountIsNotNull() {
			addCriterion("DAIKAN_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDaikanCountEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT =", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountNotEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT <>", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountGreaterThan(Integer value) {
			addCriterion("DAIKAN_COUNT >", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT >=", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountLessThan(Integer value) {
			addCriterion("DAIKAN_COUNT <", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountLessThanOrEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT <=", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountIn(List<Integer> values) {
			addCriterion("DAIKAN_COUNT in", values, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountNotIn(List<Integer> values) {
			addCriterion("DAIKAN_COUNT not in", values, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountBetween(Integer value1, Integer value2) {
			addCriterion("DAIKAN_COUNT between", value1, value2, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DAIKAN_COUNT not between", value1, value2, "daikanCount");
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