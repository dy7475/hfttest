package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunCityExample {
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
	public AdminFunCityExample() {
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

		public Criteria andCityIdIsNull() {
			addCriterion("CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNotNull() {
			addCriterion("CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCityIdEqualTo(Short value) {
			addCriterion("CITY_ID =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Short value) {
			addCriterion("CITY_ID <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Short value) {
			addCriterion("CITY_ID >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Short value) {
			addCriterion("CITY_ID >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Short value) {
			addCriterion("CITY_ID <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Short value) {
			addCriterion("CITY_ID <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Short> values) {
			addCriterion("CITY_ID in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Short> values) {
			addCriterion("CITY_ID not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Short value1, Short value2) {
			addCriterion("CITY_ID between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Short value1, Short value2) {
			addCriterion("CITY_ID not between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIsNull() {
			addCriterion("PROVINCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIsNotNull() {
			addCriterion("PROVINCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andProvinceIdEqualTo(Short value) {
			addCriterion("PROVINCE_ID =", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotEqualTo(Short value) {
			addCriterion("PROVINCE_ID <>", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThan(Short value) {
			addCriterion("PROVINCE_ID >", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThanOrEqualTo(Short value) {
			addCriterion("PROVINCE_ID >=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThan(Short value) {
			addCriterion("PROVINCE_ID <", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThanOrEqualTo(Short value) {
			addCriterion("PROVINCE_ID <=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIn(List<Short> values) {
			addCriterion("PROVINCE_ID in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotIn(List<Short> values) {
			addCriterion("PROVINCE_ID not in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdBetween(Short value1, Short value2) {
			addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotBetween(Short value1, Short value2) {
			addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
			return (Criteria) this;
		}

		public Criteria andCityNameIsNull() {
			addCriterion("CITY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCityNameIsNotNull() {
			addCriterion("CITY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCityNameEqualTo(String value) {
			addCriterion("CITY_NAME =", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameNotEqualTo(String value) {
			addCriterion("CITY_NAME <>", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameGreaterThan(String value) {
			addCriterion("CITY_NAME >", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameGreaterThanOrEqualTo(String value) {
			addCriterion("CITY_NAME >=", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameLessThan(String value) {
			addCriterion("CITY_NAME <", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameLessThanOrEqualTo(String value) {
			addCriterion("CITY_NAME <=", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameLike(String value) {
			addCriterion("CITY_NAME like", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameNotLike(String value) {
			addCriterion("CITY_NAME not like", value, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameIn(List<String> values) {
			addCriterion("CITY_NAME in", values, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameNotIn(List<String> values) {
			addCriterion("CITY_NAME not in", values, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameBetween(String value1, String value2) {
			addCriterion("CITY_NAME between", value1, value2, "cityName");
			return (Criteria) this;
		}

		public Criteria andCityNameNotBetween(String value1, String value2) {
			addCriterion("CITY_NAME not between", value1, value2, "cityName");
			return (Criteria) this;
		}

		public Criteria andPyCodeIsNull() {
			addCriterion("PY_CODE is null");
			return (Criteria) this;
		}

		public Criteria andPyCodeIsNotNull() {
			addCriterion("PY_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andPyCodeEqualTo(String value) {
			addCriterion("PY_CODE =", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeNotEqualTo(String value) {
			addCriterion("PY_CODE <>", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeGreaterThan(String value) {
			addCriterion("PY_CODE >", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeGreaterThanOrEqualTo(String value) {
			addCriterion("PY_CODE >=", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeLessThan(String value) {
			addCriterion("PY_CODE <", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeLessThanOrEqualTo(String value) {
			addCriterion("PY_CODE <=", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeLike(String value) {
			addCriterion("PY_CODE like", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeNotLike(String value) {
			addCriterion("PY_CODE not like", value, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeIn(List<String> values) {
			addCriterion("PY_CODE in", values, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeNotIn(List<String> values) {
			addCriterion("PY_CODE not in", values, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeBetween(String value1, String value2) {
			addCriterion("PY_CODE between", value1, value2, "pyCode");
			return (Criteria) this;
		}

		public Criteria andPyCodeNotBetween(String value1, String value2) {
			addCriterion("PY_CODE not between", value1, value2, "pyCode");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNull() {
			addCriterion("SEQ_NO is null");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNotNull() {
			addCriterion("SEQ_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSeqNoEqualTo(Short value) {
			addCriterion("SEQ_NO =", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotEqualTo(Short value) {
			addCriterion("SEQ_NO <>", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThan(Short value) {
			addCriterion("SEQ_NO >", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThanOrEqualTo(Short value) {
			addCriterion("SEQ_NO >=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThan(Short value) {
			addCriterion("SEQ_NO <", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThanOrEqualTo(Short value) {
			addCriterion("SEQ_NO <=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoIn(List<Short> values) {
			addCriterion("SEQ_NO in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotIn(List<Short> values) {
			addCriterion("SEQ_NO not in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoBetween(Short value1, Short value2) {
			addCriterion("SEQ_NO between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotBetween(Short value1, Short value2) {
			addCriterion("SEQ_NO not between", value1, value2, "seqNo");
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

		public Criteria andCityOnIsNull() {
			addCriterion("CITY_ON is null");
			return (Criteria) this;
		}

		public Criteria andCityOnIsNotNull() {
			addCriterion("CITY_ON is not null");
			return (Criteria) this;
		}

		public Criteria andCityOnEqualTo(Boolean value) {
			addCriterion("CITY_ON =", value, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnNotEqualTo(Boolean value) {
			addCriterion("CITY_ON <>", value, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnGreaterThan(Boolean value) {
			addCriterion("CITY_ON >", value, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnGreaterThanOrEqualTo(Boolean value) {
			addCriterion("CITY_ON >=", value, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnLessThan(Boolean value) {
			addCriterion("CITY_ON <", value, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnLessThanOrEqualTo(Boolean value) {
			addCriterion("CITY_ON <=", value, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnIn(List<Boolean> values) {
			addCriterion("CITY_ON in", values, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnNotIn(List<Boolean> values) {
			addCriterion("CITY_ON not in", values, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnBetween(Boolean value1, Boolean value2) {
			addCriterion("CITY_ON between", value1, value2, "cityOn");
			return (Criteria) this;
		}

		public Criteria andCityOnNotBetween(Boolean value1, Boolean value2) {
			addCriterion("CITY_ON not between", value1, value2, "cityOn");
			return (Criteria) this;
		}

		public Criteria andTelCodeIsNull() {
			addCriterion("TEL_CODE is null");
			return (Criteria) this;
		}

		public Criteria andTelCodeIsNotNull() {
			addCriterion("TEL_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andTelCodeEqualTo(String value) {
			addCriterion("TEL_CODE =", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeNotEqualTo(String value) {
			addCriterion("TEL_CODE <>", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeGreaterThan(String value) {
			addCriterion("TEL_CODE >", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeGreaterThanOrEqualTo(String value) {
			addCriterion("TEL_CODE >=", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeLessThan(String value) {
			addCriterion("TEL_CODE <", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeLessThanOrEqualTo(String value) {
			addCriterion("TEL_CODE <=", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeLike(String value) {
			addCriterion("TEL_CODE like", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeNotLike(String value) {
			addCriterion("TEL_CODE not like", value, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeIn(List<String> values) {
			addCriterion("TEL_CODE in", values, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeNotIn(List<String> values) {
			addCriterion("TEL_CODE not in", values, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeBetween(String value1, String value2) {
			addCriterion("TEL_CODE between", value1, value2, "telCode");
			return (Criteria) this;
		}

		public Criteria andTelCodeNotBetween(String value1, String value2) {
			addCriterion("TEL_CODE not between", value1, value2, "telCode");
			return (Criteria) this;
		}

		public Criteria andPositionXIsNull() {
			addCriterion("POSITION_X is null");
			return (Criteria) this;
		}

		public Criteria andPositionXIsNotNull() {
			addCriterion("POSITION_X is not null");
			return (Criteria) this;
		}

		public Criteria andPositionXEqualTo(String value) {
			addCriterion("POSITION_X =", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotEqualTo(String value) {
			addCriterion("POSITION_X <>", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXGreaterThan(String value) {
			addCriterion("POSITION_X >", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXGreaterThanOrEqualTo(String value) {
			addCriterion("POSITION_X >=", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXLessThan(String value) {
			addCriterion("POSITION_X <", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXLessThanOrEqualTo(String value) {
			addCriterion("POSITION_X <=", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXLike(String value) {
			addCriterion("POSITION_X like", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotLike(String value) {
			addCriterion("POSITION_X not like", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXIn(List<String> values) {
			addCriterion("POSITION_X in", values, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotIn(List<String> values) {
			addCriterion("POSITION_X not in", values, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXBetween(String value1, String value2) {
			addCriterion("POSITION_X between", value1, value2, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotBetween(String value1, String value2) {
			addCriterion("POSITION_X not between", value1, value2, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionYIsNull() {
			addCriterion("POSITION_Y is null");
			return (Criteria) this;
		}

		public Criteria andPositionYIsNotNull() {
			addCriterion("POSITION_Y is not null");
			return (Criteria) this;
		}

		public Criteria andPositionYEqualTo(String value) {
			addCriterion("POSITION_Y =", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotEqualTo(String value) {
			addCriterion("POSITION_Y <>", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYGreaterThan(String value) {
			addCriterion("POSITION_Y >", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYGreaterThanOrEqualTo(String value) {
			addCriterion("POSITION_Y >=", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYLessThan(String value) {
			addCriterion("POSITION_Y <", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYLessThanOrEqualTo(String value) {
			addCriterion("POSITION_Y <=", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYLike(String value) {
			addCriterion("POSITION_Y like", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotLike(String value) {
			addCriterion("POSITION_Y not like", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYIn(List<String> values) {
			addCriterion("POSITION_Y in", values, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotIn(List<String> values) {
			addCriterion("POSITION_Y not in", values, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYBetween(String value1, String value2) {
			addCriterion("POSITION_Y between", value1, value2, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotBetween(String value1, String value2) {
			addCriterion("POSITION_Y not between", value1, value2, "positionY");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeIsNull() {
			addCriterion("WEATHER_CODE is null");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeIsNotNull() {
			addCriterion("WEATHER_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeEqualTo(String value) {
			addCriterion("WEATHER_CODE =", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeNotEqualTo(String value) {
			addCriterion("WEATHER_CODE <>", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeGreaterThan(String value) {
			addCriterion("WEATHER_CODE >", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeGreaterThanOrEqualTo(String value) {
			addCriterion("WEATHER_CODE >=", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeLessThan(String value) {
			addCriterion("WEATHER_CODE <", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeLessThanOrEqualTo(String value) {
			addCriterion("WEATHER_CODE <=", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeLike(String value) {
			addCriterion("WEATHER_CODE like", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeNotLike(String value) {
			addCriterion("WEATHER_CODE not like", value, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeIn(List<String> values) {
			addCriterion("WEATHER_CODE in", values, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeNotIn(List<String> values) {
			addCriterion("WEATHER_CODE not in", values, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeBetween(String value1, String value2) {
			addCriterion("WEATHER_CODE between", value1, value2, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andWeatherCodeNotBetween(String value1, String value2) {
			addCriterion("WEATHER_CODE not between", value1, value2, "weatherCode");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperIsNull() {
			addCriterion("SIMPLE_SUPER is null");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperIsNotNull() {
			addCriterion("SIMPLE_SUPER is not null");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperEqualTo(Short value) {
			addCriterion("SIMPLE_SUPER =", value, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperNotEqualTo(Short value) {
			addCriterion("SIMPLE_SUPER <>", value, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperGreaterThan(Short value) {
			addCriterion("SIMPLE_SUPER >", value, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperGreaterThanOrEqualTo(Short value) {
			addCriterion("SIMPLE_SUPER >=", value, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperLessThan(Short value) {
			addCriterion("SIMPLE_SUPER <", value, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperLessThanOrEqualTo(Short value) {
			addCriterion("SIMPLE_SUPER <=", value, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperIn(List<Short> values) {
			addCriterion("SIMPLE_SUPER in", values, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperNotIn(List<Short> values) {
			addCriterion("SIMPLE_SUPER not in", values, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperBetween(Short value1, Short value2) {
			addCriterion("SIMPLE_SUPER between", value1, value2, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andSimpleSuperNotBetween(Short value1, Short value2) {
			addCriterion("SIMPLE_SUPER not between", value1, value2, "simpleSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperIsNull() {
			addCriterion("PERSONAL_SUPER is null");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperIsNotNull() {
			addCriterion("PERSONAL_SUPER is not null");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperEqualTo(Short value) {
			addCriterion("PERSONAL_SUPER =", value, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperNotEqualTo(Short value) {
			addCriterion("PERSONAL_SUPER <>", value, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperGreaterThan(Short value) {
			addCriterion("PERSONAL_SUPER >", value, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperGreaterThanOrEqualTo(Short value) {
			addCriterion("PERSONAL_SUPER >=", value, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperLessThan(Short value) {
			addCriterion("PERSONAL_SUPER <", value, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperLessThanOrEqualTo(Short value) {
			addCriterion("PERSONAL_SUPER <=", value, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperIn(List<Short> values) {
			addCriterion("PERSONAL_SUPER in", values, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperNotIn(List<Short> values) {
			addCriterion("PERSONAL_SUPER not in", values, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperBetween(Short value1, Short value2) {
			addCriterion("PERSONAL_SUPER between", value1, value2, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andPersonalSuperNotBetween(Short value1, Short value2) {
			addCriterion("PERSONAL_SUPER not between", value1, value2, "personalSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperIsNull() {
			addCriterion("ENTERPRISE_SUPER is null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperIsNotNull() {
			addCriterion("ENTERPRISE_SUPER is not null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperEqualTo(Short value) {
			addCriterion("ENTERPRISE_SUPER =", value, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperNotEqualTo(Short value) {
			addCriterion("ENTERPRISE_SUPER <>", value, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperGreaterThan(Short value) {
			addCriterion("ENTERPRISE_SUPER >", value, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperGreaterThanOrEqualTo(Short value) {
			addCriterion("ENTERPRISE_SUPER >=", value, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperLessThan(Short value) {
			addCriterion("ENTERPRISE_SUPER <", value, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperLessThanOrEqualTo(Short value) {
			addCriterion("ENTERPRISE_SUPER <=", value, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperIn(List<Short> values) {
			addCriterion("ENTERPRISE_SUPER in", values, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperNotIn(List<Short> values) {
			addCriterion("ENTERPRISE_SUPER not in", values, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperBetween(Short value1, Short value2) {
			addCriterion("ENTERPRISE_SUPER between", value1, value2, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andEnterpriseSuperNotBetween(Short value1, Short value2) {
			addCriterion("ENTERPRISE_SUPER not between", value1, value2, "enterpriseSuper");
			return (Criteria) this;
		}

		public Criteria andSuperTimeIsNull() {
			addCriterion("SUPER_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSuperTimeIsNotNull() {
			addCriterion("SUPER_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSuperTimeEqualTo(Date value) {
			addCriterion("SUPER_TIME =", value, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeNotEqualTo(Date value) {
			addCriterion("SUPER_TIME <>", value, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeGreaterThan(Date value) {
			addCriterion("SUPER_TIME >", value, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SUPER_TIME >=", value, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeLessThan(Date value) {
			addCriterion("SUPER_TIME <", value, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeLessThanOrEqualTo(Date value) {
			addCriterion("SUPER_TIME <=", value, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeIn(List<Date> values) {
			addCriterion("SUPER_TIME in", values, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeNotIn(List<Date> values) {
			addCriterion("SUPER_TIME not in", values, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeBetween(Date value1, Date value2) {
			addCriterion("SUPER_TIME between", value1, value2, "superTime");
			return (Criteria) this;
		}

		public Criteria andSuperTimeNotBetween(Date value1, Date value2) {
			addCriterion("SUPER_TIME not between", value1, value2, "superTime");
			return (Criteria) this;
		}

		public Criteria andTryDaysIsNull() {
			addCriterion("TRY_DAYS is null");
			return (Criteria) this;
		}

		public Criteria andTryDaysIsNotNull() {
			addCriterion("TRY_DAYS is not null");
			return (Criteria) this;
		}

		public Criteria andTryDaysEqualTo(Integer value) {
			addCriterion("TRY_DAYS =", value, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysNotEqualTo(Integer value) {
			addCriterion("TRY_DAYS <>", value, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysGreaterThan(Integer value) {
			addCriterion("TRY_DAYS >", value, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRY_DAYS >=", value, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysLessThan(Integer value) {
			addCriterion("TRY_DAYS <", value, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysLessThanOrEqualTo(Integer value) {
			addCriterion("TRY_DAYS <=", value, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysIn(List<Integer> values) {
			addCriterion("TRY_DAYS in", values, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysNotIn(List<Integer> values) {
			addCriterion("TRY_DAYS not in", values, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysBetween(Integer value1, Integer value2) {
			addCriterion("TRY_DAYS between", value1, value2, "tryDays");
			return (Criteria) this;
		}

		public Criteria andTryDaysNotBetween(Integer value1, Integer value2) {
			addCriterion("TRY_DAYS not between", value1, value2, "tryDays");
			return (Criteria) this;
		}

		public Criteria andUserRightIsNull() {
			addCriterion("USER_RIGHT is null");
			return (Criteria) this;
		}

		public Criteria andUserRightIsNotNull() {
			addCriterion("USER_RIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andUserRightEqualTo(Boolean value) {
			addCriterion("USER_RIGHT =", value, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightNotEqualTo(Boolean value) {
			addCriterion("USER_RIGHT <>", value, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightGreaterThan(Boolean value) {
			addCriterion("USER_RIGHT >", value, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightGreaterThanOrEqualTo(Boolean value) {
			addCriterion("USER_RIGHT >=", value, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightLessThan(Boolean value) {
			addCriterion("USER_RIGHT <", value, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightLessThanOrEqualTo(Boolean value) {
			addCriterion("USER_RIGHT <=", value, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightIn(List<Boolean> values) {
			addCriterion("USER_RIGHT in", values, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightNotIn(List<Boolean> values) {
			addCriterion("USER_RIGHT not in", values, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_RIGHT between", value1, value2, "userRight");
			return (Criteria) this;
		}

		public Criteria andUserRightNotBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_RIGHT not between", value1, value2, "userRight");
			return (Criteria) this;
		}

		public Criteria andSuperUserIsNull() {
			addCriterion("SUPER_USER is null");
			return (Criteria) this;
		}

		public Criteria andSuperUserIsNotNull() {
			addCriterion("SUPER_USER is not null");
			return (Criteria) this;
		}

		public Criteria andSuperUserEqualTo(Boolean value) {
			addCriterion("SUPER_USER =", value, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserNotEqualTo(Boolean value) {
			addCriterion("SUPER_USER <>", value, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserGreaterThan(Boolean value) {
			addCriterion("SUPER_USER >", value, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SUPER_USER >=", value, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserLessThan(Boolean value) {
			addCriterion("SUPER_USER <", value, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserLessThanOrEqualTo(Boolean value) {
			addCriterion("SUPER_USER <=", value, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserIn(List<Boolean> values) {
			addCriterion("SUPER_USER in", values, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserNotIn(List<Boolean> values) {
			addCriterion("SUPER_USER not in", values, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserBetween(Boolean value1, Boolean value2) {
			addCriterion("SUPER_USER between", value1, value2, "superUser");
			return (Criteria) this;
		}

		public Criteria andSuperUserNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SUPER_USER not between", value1, value2, "superUser");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumIsNull() {
			addCriterion("ENTER_USER_NUM is null");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumIsNotNull() {
			addCriterion("ENTER_USER_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumEqualTo(Byte value) {
			addCriterion("ENTER_USER_NUM =", value, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumNotEqualTo(Byte value) {
			addCriterion("ENTER_USER_NUM <>", value, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumGreaterThan(Byte value) {
			addCriterion("ENTER_USER_NUM >", value, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENTER_USER_NUM >=", value, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumLessThan(Byte value) {
			addCriterion("ENTER_USER_NUM <", value, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumLessThanOrEqualTo(Byte value) {
			addCriterion("ENTER_USER_NUM <=", value, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumIn(List<Byte> values) {
			addCriterion("ENTER_USER_NUM in", values, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumNotIn(List<Byte> values) {
			addCriterion("ENTER_USER_NUM not in", values, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumBetween(Byte value1, Byte value2) {
			addCriterion("ENTER_USER_NUM between", value1, value2, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andEnterUserNumNotBetween(Byte value1, Byte value2) {
			addCriterion("ENTER_USER_NUM not between", value1, value2, "enterUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumIsNull() {
			addCriterion("PRO_USER_NUM is null");
			return (Criteria) this;
		}

		public Criteria andProUserNumIsNotNull() {
			addCriterion("PRO_USER_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andProUserNumEqualTo(Byte value) {
			addCriterion("PRO_USER_NUM =", value, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumNotEqualTo(Byte value) {
			addCriterion("PRO_USER_NUM <>", value, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumGreaterThan(Byte value) {
			addCriterion("PRO_USER_NUM >", value, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumGreaterThanOrEqualTo(Byte value) {
			addCriterion("PRO_USER_NUM >=", value, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumLessThan(Byte value) {
			addCriterion("PRO_USER_NUM <", value, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumLessThanOrEqualTo(Byte value) {
			addCriterion("PRO_USER_NUM <=", value, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumIn(List<Byte> values) {
			addCriterion("PRO_USER_NUM in", values, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumNotIn(List<Byte> values) {
			addCriterion("PRO_USER_NUM not in", values, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumBetween(Byte value1, Byte value2) {
			addCriterion("PRO_USER_NUM between", value1, value2, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andProUserNumNotBetween(Byte value1, Byte value2) {
			addCriterion("PRO_USER_NUM not between", value1, value2, "proUserNum");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagIsNull() {
			addCriterion("BUILDING_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagIsNotNull() {
			addCriterion("BUILDING_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagEqualTo(Boolean value) {
			addCriterion("BUILDING_FLAG =", value, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagNotEqualTo(Boolean value) {
			addCriterion("BUILDING_FLAG <>", value, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagGreaterThan(Boolean value) {
			addCriterion("BUILDING_FLAG >", value, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("BUILDING_FLAG >=", value, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagLessThan(Boolean value) {
			addCriterion("BUILDING_FLAG <", value, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("BUILDING_FLAG <=", value, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagIn(List<Boolean> values) {
			addCriterion("BUILDING_FLAG in", values, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagNotIn(List<Boolean> values) {
			addCriterion("BUILDING_FLAG not in", values, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("BUILDING_FLAG between", value1, value2, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andBuildingFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("BUILDING_FLAG not between", value1, value2, "buildingFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagIsNull() {
			addCriterion("GROUPON_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagIsNotNull() {
			addCriterion("GROUPON_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagEqualTo(Boolean value) {
			addCriterion("GROUPON_FLAG =", value, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagNotEqualTo(Boolean value) {
			addCriterion("GROUPON_FLAG <>", value, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagGreaterThan(Boolean value) {
			addCriterion("GROUPON_FLAG >", value, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("GROUPON_FLAG >=", value, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagLessThan(Boolean value) {
			addCriterion("GROUPON_FLAG <", value, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("GROUPON_FLAG <=", value, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagIn(List<Boolean> values) {
			addCriterion("GROUPON_FLAG in", values, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagNotIn(List<Boolean> values) {
			addCriterion("GROUPON_FLAG not in", values, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("GROUPON_FLAG between", value1, value2, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andGrouponFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("GROUPON_FLAG not between", value1, value2, "grouponFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagIsNull() {
			addCriterion("BULLET_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andBulletFlagIsNotNull() {
			addCriterion("BULLET_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andBulletFlagEqualTo(Boolean value) {
			addCriterion("BULLET_FLAG =", value, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagNotEqualTo(Boolean value) {
			addCriterion("BULLET_FLAG <>", value, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagGreaterThan(Boolean value) {
			addCriterion("BULLET_FLAG >", value, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("BULLET_FLAG >=", value, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagLessThan(Boolean value) {
			addCriterion("BULLET_FLAG <", value, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("BULLET_FLAG <=", value, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagIn(List<Boolean> values) {
			addCriterion("BULLET_FLAG in", values, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagNotIn(List<Boolean> values) {
			addCriterion("BULLET_FLAG not in", values, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("BULLET_FLAG between", value1, value2, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andBulletFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("BULLET_FLAG not between", value1, value2, "bulletFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagIsNull() {
			addCriterion("MANAGE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andManageFlagIsNotNull() {
			addCriterion("MANAGE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andManageFlagEqualTo(Boolean value) {
			addCriterion("MANAGE_FLAG =", value, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagNotEqualTo(Boolean value) {
			addCriterion("MANAGE_FLAG <>", value, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagGreaterThan(Boolean value) {
			addCriterion("MANAGE_FLAG >", value, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("MANAGE_FLAG >=", value, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagLessThan(Boolean value) {
			addCriterion("MANAGE_FLAG <", value, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("MANAGE_FLAG <=", value, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagIn(List<Boolean> values) {
			addCriterion("MANAGE_FLAG in", values, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagNotIn(List<Boolean> values) {
			addCriterion("MANAGE_FLAG not in", values, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("MANAGE_FLAG between", value1, value2, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andManageFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("MANAGE_FLAG not between", value1, value2, "manageFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagIsNull() {
			addCriterion("UPDATE_SUPER_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagIsNotNull() {
			addCriterion("UPDATE_SUPER_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagEqualTo(Boolean value) {
			addCriterion("UPDATE_SUPER_FLAG =", value, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagNotEqualTo(Boolean value) {
			addCriterion("UPDATE_SUPER_FLAG <>", value, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagGreaterThan(Boolean value) {
			addCriterion("UPDATE_SUPER_FLAG >", value, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("UPDATE_SUPER_FLAG >=", value, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagLessThan(Boolean value) {
			addCriterion("UPDATE_SUPER_FLAG <", value, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("UPDATE_SUPER_FLAG <=", value, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagIn(List<Boolean> values) {
			addCriterion("UPDATE_SUPER_FLAG in", values, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagNotIn(List<Boolean> values) {
			addCriterion("UPDATE_SUPER_FLAG not in", values, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("UPDATE_SUPER_FLAG between", value1, value2, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSuperFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("UPDATE_SUPER_FLAG not between", value1, value2, "updateSuperFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagIsNull() {
			addCriterion("VIP_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andVipFlagIsNotNull() {
			addCriterion("VIP_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andVipFlagEqualTo(Byte value) {
			addCriterion("VIP_FLAG =", value, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagNotEqualTo(Byte value) {
			addCriterion("VIP_FLAG <>", value, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagGreaterThan(Byte value) {
			addCriterion("VIP_FLAG >", value, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("VIP_FLAG >=", value, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagLessThan(Byte value) {
			addCriterion("VIP_FLAG <", value, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagLessThanOrEqualTo(Byte value) {
			addCriterion("VIP_FLAG <=", value, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagIn(List<Byte> values) {
			addCriterion("VIP_FLAG in", values, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagNotIn(List<Byte> values) {
			addCriterion("VIP_FLAG not in", values, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagBetween(Byte value1, Byte value2) {
			addCriterion("VIP_FLAG between", value1, value2, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andVipFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("VIP_FLAG not between", value1, value2, "vipFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagIsNull() {
			addCriterion("FINAC_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andFinacFlagIsNotNull() {
			addCriterion("FINAC_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andFinacFlagEqualTo(Byte value) {
			addCriterion("FINAC_FLAG =", value, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagNotEqualTo(Byte value) {
			addCriterion("FINAC_FLAG <>", value, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagGreaterThan(Byte value) {
			addCriterion("FINAC_FLAG >", value, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("FINAC_FLAG >=", value, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagLessThan(Byte value) {
			addCriterion("FINAC_FLAG <", value, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagLessThanOrEqualTo(Byte value) {
			addCriterion("FINAC_FLAG <=", value, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagIn(List<Byte> values) {
			addCriterion("FINAC_FLAG in", values, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagNotIn(List<Byte> values) {
			addCriterion("FINAC_FLAG not in", values, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagBetween(Byte value1, Byte value2) {
			addCriterion("FINAC_FLAG between", value1, value2, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andFinacFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("FINAC_FLAG not between", value1, value2, "finacFlag");
			return (Criteria) this;
		}

		public Criteria andCityLevelIsNull() {
			addCriterion("CITY_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andCityLevelIsNotNull() {
			addCriterion("CITY_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andCityLevelEqualTo(Byte value) {
			addCriterion("CITY_LEVEL =", value, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelNotEqualTo(Byte value) {
			addCriterion("CITY_LEVEL <>", value, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelGreaterThan(Byte value) {
			addCriterion("CITY_LEVEL >", value, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("CITY_LEVEL >=", value, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelLessThan(Byte value) {
			addCriterion("CITY_LEVEL <", value, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelLessThanOrEqualTo(Byte value) {
			addCriterion("CITY_LEVEL <=", value, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelIn(List<Byte> values) {
			addCriterion("CITY_LEVEL in", values, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelNotIn(List<Byte> values) {
			addCriterion("CITY_LEVEL not in", values, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelBetween(Byte value1, Byte value2) {
			addCriterion("CITY_LEVEL between", value1, value2, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andCityLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("CITY_LEVEL not between", value1, value2, "cityLevel");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagIsNull() {
			addCriterion("SEL_BUILDPIC_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagIsNotNull() {
			addCriterion("SEL_BUILDPIC_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagEqualTo(Byte value) {
			addCriterion("SEL_BUILDPIC_FLAG =", value, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagNotEqualTo(Byte value) {
			addCriterion("SEL_BUILDPIC_FLAG <>", value, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagGreaterThan(Byte value) {
			addCriterion("SEL_BUILDPIC_FLAG >", value, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("SEL_BUILDPIC_FLAG >=", value, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagLessThan(Byte value) {
			addCriterion("SEL_BUILDPIC_FLAG <", value, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagLessThanOrEqualTo(Byte value) {
			addCriterion("SEL_BUILDPIC_FLAG <=", value, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagIn(List<Byte> values) {
			addCriterion("SEL_BUILDPIC_FLAG in", values, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagNotIn(List<Byte> values) {
			addCriterion("SEL_BUILDPIC_FLAG not in", values, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagBetween(Byte value1, Byte value2) {
			addCriterion("SEL_BUILDPIC_FLAG between", value1, value2, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andSelBuildpicFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("SEL_BUILDPIC_FLAG not between", value1, value2, "selBuildpicFlag");
			return (Criteria) this;
		}

		public Criteria andFidIsNull() {
			addCriterion("FId is null");
			return (Criteria) this;
		}

		public Criteria andFidIsNotNull() {
			addCriterion("FId is not null");
			return (Criteria) this;
		}

		public Criteria andFidEqualTo(Integer value) {
			addCriterion("FId =", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotEqualTo(Integer value) {
			addCriterion("FId <>", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidGreaterThan(Integer value) {
			addCriterion("FId >", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidGreaterThanOrEqualTo(Integer value) {
			addCriterion("FId >=", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidLessThan(Integer value) {
			addCriterion("FId <", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidLessThanOrEqualTo(Integer value) {
			addCriterion("FId <=", value, "fid");
			return (Criteria) this;
		}

		public Criteria andFidIn(List<Integer> values) {
			addCriterion("FId in", values, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotIn(List<Integer> values) {
			addCriterion("FId not in", values, "fid");
			return (Criteria) this;
		}

		public Criteria andFidBetween(Integer value1, Integer value2) {
			addCriterion("FId between", value1, value2, "fid");
			return (Criteria) this;
		}

		public Criteria andFidNotBetween(Integer value1, Integer value2) {
			addCriterion("FId not between", value1, value2, "fid");
			return (Criteria) this;
		}

		public Criteria andSubnameIsNull() {
			addCriterion("SUBNAME is null");
			return (Criteria) this;
		}

		public Criteria andSubnameIsNotNull() {
			addCriterion("SUBNAME is not null");
			return (Criteria) this;
		}

		public Criteria andSubnameEqualTo(String value) {
			addCriterion("SUBNAME =", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameNotEqualTo(String value) {
			addCriterion("SUBNAME <>", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameGreaterThan(String value) {
			addCriterion("SUBNAME >", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameGreaterThanOrEqualTo(String value) {
			addCriterion("SUBNAME >=", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameLessThan(String value) {
			addCriterion("SUBNAME <", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameLessThanOrEqualTo(String value) {
			addCriterion("SUBNAME <=", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameLike(String value) {
			addCriterion("SUBNAME like", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameNotLike(String value) {
			addCriterion("SUBNAME not like", value, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameIn(List<String> values) {
			addCriterion("SUBNAME in", values, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameNotIn(List<String> values) {
			addCriterion("SUBNAME not in", values, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameBetween(String value1, String value2) {
			addCriterion("SUBNAME between", value1, value2, "subname");
			return (Criteria) this;
		}

		public Criteria andSubnameNotBetween(String value1, String value2) {
			addCriterion("SUBNAME not between", value1, value2, "subname");
			return (Criteria) this;
		}

		public Criteria andCitySingleIsNull() {
			addCriterion("CITY_SINGLE is null");
			return (Criteria) this;
		}

		public Criteria andCitySingleIsNotNull() {
			addCriterion("CITY_SINGLE is not null");
			return (Criteria) this;
		}

		public Criteria andCitySingleEqualTo(Byte value) {
			addCriterion("CITY_SINGLE =", value, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleNotEqualTo(Byte value) {
			addCriterion("CITY_SINGLE <>", value, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleGreaterThan(Byte value) {
			addCriterion("CITY_SINGLE >", value, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleGreaterThanOrEqualTo(Byte value) {
			addCriterion("CITY_SINGLE >=", value, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleLessThan(Byte value) {
			addCriterion("CITY_SINGLE <", value, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleLessThanOrEqualTo(Byte value) {
			addCriterion("CITY_SINGLE <=", value, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleIn(List<Byte> values) {
			addCriterion("CITY_SINGLE in", values, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleNotIn(List<Byte> values) {
			addCriterion("CITY_SINGLE not in", values, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleBetween(Byte value1, Byte value2) {
			addCriterion("CITY_SINGLE between", value1, value2, "citySingle");
			return (Criteria) this;
		}

		public Criteria andCitySingleNotBetween(Byte value1, Byte value2) {
			addCriterion("CITY_SINGLE not between", value1, value2, "citySingle");
			return (Criteria) this;
		}

		public Criteria andQqPublishIsNull() {
			addCriterion("QQ_PUBLISH is null");
			return (Criteria) this;
		}

		public Criteria andQqPublishIsNotNull() {
			addCriterion("QQ_PUBLISH is not null");
			return (Criteria) this;
		}

		public Criteria andQqPublishEqualTo(Byte value) {
			addCriterion("QQ_PUBLISH =", value, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishNotEqualTo(Byte value) {
			addCriterion("QQ_PUBLISH <>", value, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishGreaterThan(Byte value) {
			addCriterion("QQ_PUBLISH >", value, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishGreaterThanOrEqualTo(Byte value) {
			addCriterion("QQ_PUBLISH >=", value, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishLessThan(Byte value) {
			addCriterion("QQ_PUBLISH <", value, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishLessThanOrEqualTo(Byte value) {
			addCriterion("QQ_PUBLISH <=", value, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishIn(List<Byte> values) {
			addCriterion("QQ_PUBLISH in", values, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishNotIn(List<Byte> values) {
			addCriterion("QQ_PUBLISH not in", values, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishBetween(Byte value1, Byte value2) {
			addCriterion("QQ_PUBLISH between", value1, value2, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andQqPublishNotBetween(Byte value1, Byte value2) {
			addCriterion("QQ_PUBLISH not between", value1, value2, "qqPublish");
			return (Criteria) this;
		}

		public Criteria andVipBoundIsNull() {
			addCriterion("VIP_BOUND is null");
			return (Criteria) this;
		}

		public Criteria andVipBoundIsNotNull() {
			addCriterion("VIP_BOUND is not null");
			return (Criteria) this;
		}

		public Criteria andVipBoundEqualTo(Byte value) {
			addCriterion("VIP_BOUND =", value, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundNotEqualTo(Byte value) {
			addCriterion("VIP_BOUND <>", value, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundGreaterThan(Byte value) {
			addCriterion("VIP_BOUND >", value, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundGreaterThanOrEqualTo(Byte value) {
			addCriterion("VIP_BOUND >=", value, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundLessThan(Byte value) {
			addCriterion("VIP_BOUND <", value, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundLessThanOrEqualTo(Byte value) {
			addCriterion("VIP_BOUND <=", value, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundIn(List<Byte> values) {
			addCriterion("VIP_BOUND in", values, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundNotIn(List<Byte> values) {
			addCriterion("VIP_BOUND not in", values, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundBetween(Byte value1, Byte value2) {
			addCriterion("VIP_BOUND between", value1, value2, "vipBound");
			return (Criteria) this;
		}

		public Criteria andVipBoundNotBetween(Byte value1, Byte value2) {
			addCriterion("VIP_BOUND not between", value1, value2, "vipBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundIsNull() {
			addCriterion("PHONE_BOUND is null");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundIsNotNull() {
			addCriterion("PHONE_BOUND is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundEqualTo(Integer value) {
			addCriterion("PHONE_BOUND =", value, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundNotEqualTo(Integer value) {
			addCriterion("PHONE_BOUND <>", value, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundGreaterThan(Integer value) {
			addCriterion("PHONE_BOUND >", value, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHONE_BOUND >=", value, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundLessThan(Integer value) {
			addCriterion("PHONE_BOUND <", value, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundLessThanOrEqualTo(Integer value) {
			addCriterion("PHONE_BOUND <=", value, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundIn(List<Integer> values) {
			addCriterion("PHONE_BOUND in", values, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundNotIn(List<Integer> values) {
			addCriterion("PHONE_BOUND not in", values, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundBetween(Integer value1, Integer value2) {
			addCriterion("PHONE_BOUND between", value1, value2, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andPhoneBoundNotBetween(Integer value1, Integer value2) {
			addCriterion("PHONE_BOUND not between", value1, value2, "phoneBound");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceIsNull() {
			addCriterion("HOUSE_BIDDING_MIN_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceIsNotNull() {
			addCriterion("HOUSE_BIDDING_MIN_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE =", value, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE <>", value, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE >", value, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE >=", value, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceLessThan(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE <", value, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE <=", value, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceIn(List<BigDecimal> values) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE in", values, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE not in", values, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE between", value1, value2, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMinPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_BIDDING_MIN_PRICE not between", value1, value2, "houseBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceIsNull() {
			addCriterion("BUILD_BIDDING_MIN_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceIsNotNull() {
			addCriterion("BUILD_BIDDING_MIN_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MIN_PRICE =", value, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceNotEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MIN_PRICE <>", value, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceGreaterThan(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MIN_PRICE >", value, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MIN_PRICE >=", value, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceLessThan(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MIN_PRICE <", value, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MIN_PRICE <=", value, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceIn(List<BigDecimal> values) {
			addCriterion("BUILD_BIDDING_MIN_PRICE in", values, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceNotIn(List<BigDecimal> values) {
			addCriterion("BUILD_BIDDING_MIN_PRICE not in", values, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUILD_BIDDING_MIN_PRICE between", value1, value2, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMinPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUILD_BIDDING_MIN_PRICE not between", value1, value2, "buildBiddingMinPrice");
			return (Criteria) this;
		}

		public Criteria andCCityNameIsNull() {
			addCriterion("C_CITY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCCityNameIsNotNull() {
			addCriterion("C_CITY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCCityNameEqualTo(String value) {
			addCriterion("C_CITY_NAME =", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameNotEqualTo(String value) {
			addCriterion("C_CITY_NAME <>", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameGreaterThan(String value) {
			addCriterion("C_CITY_NAME >", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameGreaterThanOrEqualTo(String value) {
			addCriterion("C_CITY_NAME >=", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameLessThan(String value) {
			addCriterion("C_CITY_NAME <", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameLessThanOrEqualTo(String value) {
			addCriterion("C_CITY_NAME <=", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameLike(String value) {
			addCriterion("C_CITY_NAME like", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameNotLike(String value) {
			addCriterion("C_CITY_NAME not like", value, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameIn(List<String> values) {
			addCriterion("C_CITY_NAME in", values, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameNotIn(List<String> values) {
			addCriterion("C_CITY_NAME not in", values, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameBetween(String value1, String value2) {
			addCriterion("C_CITY_NAME between", value1, value2, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCCityNameNotBetween(String value1, String value2) {
			addCriterion("C_CITY_NAME not between", value1, value2, "cCityName");
			return (Criteria) this;
		}

		public Criteria andCPyCodeIsNull() {
			addCriterion("C_PY_CODE is null");
			return (Criteria) this;
		}

		public Criteria andCPyCodeIsNotNull() {
			addCriterion("C_PY_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCPyCodeEqualTo(String value) {
			addCriterion("C_PY_CODE =", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeNotEqualTo(String value) {
			addCriterion("C_PY_CODE <>", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeGreaterThan(String value) {
			addCriterion("C_PY_CODE >", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeGreaterThanOrEqualTo(String value) {
			addCriterion("C_PY_CODE >=", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeLessThan(String value) {
			addCriterion("C_PY_CODE <", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeLessThanOrEqualTo(String value) {
			addCriterion("C_PY_CODE <=", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeLike(String value) {
			addCriterion("C_PY_CODE like", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeNotLike(String value) {
			addCriterion("C_PY_CODE not like", value, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeIn(List<String> values) {
			addCriterion("C_PY_CODE in", values, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeNotIn(List<String> values) {
			addCriterion("C_PY_CODE not in", values, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeBetween(String value1, String value2) {
			addCriterion("C_PY_CODE between", value1, value2, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andCPyCodeNotBetween(String value1, String value2) {
			addCriterion("C_PY_CODE not between", value1, value2, "cPyCode");
			return (Criteria) this;
		}

		public Criteria andWebFlagIsNull() {
			addCriterion("WEB_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andWebFlagIsNotNull() {
			addCriterion("WEB_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andWebFlagEqualTo(Integer value) {
			addCriterion("WEB_FLAG =", value, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagNotEqualTo(Integer value) {
			addCriterion("WEB_FLAG <>", value, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagGreaterThan(Integer value) {
			addCriterion("WEB_FLAG >", value, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("WEB_FLAG >=", value, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagLessThan(Integer value) {
			addCriterion("WEB_FLAG <", value, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagLessThanOrEqualTo(Integer value) {
			addCriterion("WEB_FLAG <=", value, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagIn(List<Integer> values) {
			addCriterion("WEB_FLAG in", values, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagNotIn(List<Integer> values) {
			addCriterion("WEB_FLAG not in", values, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagBetween(Integer value1, Integer value2) {
			addCriterion("WEB_FLAG between", value1, value2, "webFlag");
			return (Criteria) this;
		}

		public Criteria andWebFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("WEB_FLAG not between", value1, value2, "webFlag");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountIsNull() {
			addCriterion("QQ_HOUSE_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountIsNotNull() {
			addCriterion("QQ_HOUSE_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT =", value, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountNotEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT <>", value, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountGreaterThan(Integer value) {
			addCriterion("QQ_HOUSE_COUNT >", value, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT >=", value, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountLessThan(Integer value) {
			addCriterion("QQ_HOUSE_COUNT <", value, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountLessThanOrEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT <=", value, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountIn(List<Integer> values) {
			addCriterion("QQ_HOUSE_COUNT in", values, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountNotIn(List<Integer> values) {
			addCriterion("QQ_HOUSE_COUNT not in", values, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountBetween(Integer value1, Integer value2) {
			addCriterion("QQ_HOUSE_COUNT between", value1, value2, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountNotBetween(Integer value1, Integer value2) {
			addCriterion("QQ_HOUSE_COUNT not between", value1, value2, "qqHouseCount");
			return (Criteria) this;
		}

		public Criteria andWebDomainIsNull() {
			addCriterion("WEB_DOMAIN is null");
			return (Criteria) this;
		}

		public Criteria andWebDomainIsNotNull() {
			addCriterion("WEB_DOMAIN is not null");
			return (Criteria) this;
		}

		public Criteria andWebDomainEqualTo(String value) {
			addCriterion("WEB_DOMAIN =", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainNotEqualTo(String value) {
			addCriterion("WEB_DOMAIN <>", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainGreaterThan(String value) {
			addCriterion("WEB_DOMAIN >", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainGreaterThanOrEqualTo(String value) {
			addCriterion("WEB_DOMAIN >=", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainLessThan(String value) {
			addCriterion("WEB_DOMAIN <", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainLessThanOrEqualTo(String value) {
			addCriterion("WEB_DOMAIN <=", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainLike(String value) {
			addCriterion("WEB_DOMAIN like", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainNotLike(String value) {
			addCriterion("WEB_DOMAIN not like", value, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainIn(List<String> values) {
			addCriterion("WEB_DOMAIN in", values, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainNotIn(List<String> values) {
			addCriterion("WEB_DOMAIN not in", values, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainBetween(String value1, String value2) {
			addCriterion("WEB_DOMAIN between", value1, value2, "webDomain");
			return (Criteria) this;
		}

		public Criteria andWebDomainNotBetween(String value1, String value2) {
			addCriterion("WEB_DOMAIN not between", value1, value2, "webDomain");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeIsNull() {
			addCriterion("QQ_HOUSE_COUNT_FREE is null");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeIsNotNull() {
			addCriterion("QQ_HOUSE_COUNT_FREE is not null");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT_FREE =", value, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeNotEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT_FREE <>", value, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeGreaterThan(Integer value) {
			addCriterion("QQ_HOUSE_COUNT_FREE >", value, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeGreaterThanOrEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT_FREE >=", value, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeLessThan(Integer value) {
			addCriterion("QQ_HOUSE_COUNT_FREE <", value, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeLessThanOrEqualTo(Integer value) {
			addCriterion("QQ_HOUSE_COUNT_FREE <=", value, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeIn(List<Integer> values) {
			addCriterion("QQ_HOUSE_COUNT_FREE in", values, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeNotIn(List<Integer> values) {
			addCriterion("QQ_HOUSE_COUNT_FREE not in", values, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeBetween(Integer value1, Integer value2) {
			addCriterion("QQ_HOUSE_COUNT_FREE between", value1, value2, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andQqHouseCountFreeNotBetween(Integer value1, Integer value2) {
			addCriterion("QQ_HOUSE_COUNT_FREE not between", value1, value2, "qqHouseCountFree");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceIsNull() {
			addCriterion("BUILD_BIDDING_MAX_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceIsNotNull() {
			addCriterion("BUILD_BIDDING_MAX_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MAX_PRICE =", value, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceNotEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MAX_PRICE <>", value, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceGreaterThan(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MAX_PRICE >", value, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MAX_PRICE >=", value, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceLessThan(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MAX_PRICE <", value, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BUILD_BIDDING_MAX_PRICE <=", value, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceIn(List<BigDecimal> values) {
			addCriterion("BUILD_BIDDING_MAX_PRICE in", values, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceNotIn(List<BigDecimal> values) {
			addCriterion("BUILD_BIDDING_MAX_PRICE not in", values, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUILD_BIDDING_MAX_PRICE between", value1, value2, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andBuildBiddingMaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUILD_BIDDING_MAX_PRICE not between", value1, value2, "buildBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceIsNull() {
			addCriterion("HOUSE_BIDDING_MAX_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceIsNotNull() {
			addCriterion("HOUSE_BIDDING_MAX_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE =", value, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE <>", value, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE >", value, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE >=", value, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceLessThan(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE <", value, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE <=", value, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceIn(List<BigDecimal> values) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE in", values, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE not in", values, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE between", value1, value2, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andHouseBiddingMaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_BIDDING_MAX_PRICE not between", value1, value2, "houseBiddingMaxPrice");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagIsNull() {
			addCriterion("SOSO_SOLR_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagIsNotNull() {
			addCriterion("SOSO_SOLR_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagEqualTo(Byte value) {
			addCriterion("SOSO_SOLR_FLAG =", value, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagNotEqualTo(Byte value) {
			addCriterion("SOSO_SOLR_FLAG <>", value, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagGreaterThan(Byte value) {
			addCriterion("SOSO_SOLR_FLAG >", value, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("SOSO_SOLR_FLAG >=", value, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagLessThan(Byte value) {
			addCriterion("SOSO_SOLR_FLAG <", value, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagLessThanOrEqualTo(Byte value) {
			addCriterion("SOSO_SOLR_FLAG <=", value, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagIn(List<Byte> values) {
			addCriterion("SOSO_SOLR_FLAG in", values, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagNotIn(List<Byte> values) {
			addCriterion("SOSO_SOLR_FLAG not in", values, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagBetween(Byte value1, Byte value2) {
			addCriterion("SOSO_SOLR_FLAG between", value1, value2, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andSosoSolrFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("SOSO_SOLR_FLAG not between", value1, value2, "sosoSolrFlag");
			return (Criteria) this;
		}

		public Criteria andEnterVipIsNull() {
			addCriterion("ENTER_VIP is null");
			return (Criteria) this;
		}

		public Criteria andEnterVipIsNotNull() {
			addCriterion("ENTER_VIP is not null");
			return (Criteria) this;
		}

		public Criteria andEnterVipEqualTo(Byte value) {
			addCriterion("ENTER_VIP =", value, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipNotEqualTo(Byte value) {
			addCriterion("ENTER_VIP <>", value, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipGreaterThan(Byte value) {
			addCriterion("ENTER_VIP >", value, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENTER_VIP >=", value, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipLessThan(Byte value) {
			addCriterion("ENTER_VIP <", value, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipLessThanOrEqualTo(Byte value) {
			addCriterion("ENTER_VIP <=", value, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipIn(List<Byte> values) {
			addCriterion("ENTER_VIP in", values, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipNotIn(List<Byte> values) {
			addCriterion("ENTER_VIP not in", values, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipBetween(Byte value1, Byte value2) {
			addCriterion("ENTER_VIP between", value1, value2, "enterVip");
			return (Criteria) this;
		}

		public Criteria andEnterVipNotBetween(Byte value1, Byte value2) {
			addCriterion("ENTER_VIP not between", value1, value2, "enterVip");
			return (Criteria) this;
		}

		public Criteria andCityDescIsNull() {
			addCriterion("CITY_DESC is null");
			return (Criteria) this;
		}

		public Criteria andCityDescIsNotNull() {
			addCriterion("CITY_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andCityDescEqualTo(String value) {
			addCriterion("CITY_DESC =", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescNotEqualTo(String value) {
			addCriterion("CITY_DESC <>", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescGreaterThan(String value) {
			addCriterion("CITY_DESC >", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescGreaterThanOrEqualTo(String value) {
			addCriterion("CITY_DESC >=", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescLessThan(String value) {
			addCriterion("CITY_DESC <", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescLessThanOrEqualTo(String value) {
			addCriterion("CITY_DESC <=", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescLike(String value) {
			addCriterion("CITY_DESC like", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescNotLike(String value) {
			addCriterion("CITY_DESC not like", value, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescIn(List<String> values) {
			addCriterion("CITY_DESC in", values, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescNotIn(List<String> values) {
			addCriterion("CITY_DESC not in", values, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescBetween(String value1, String value2) {
			addCriterion("CITY_DESC between", value1, value2, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andCityDescNotBetween(String value1, String value2) {
			addCriterion("CITY_DESC not between", value1, value2, "cityDesc");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagIsNull() {
			addCriterion("BAIDU_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagIsNotNull() {
			addCriterion("BAIDU_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagEqualTo(Byte value) {
			addCriterion("BAIDU_FLAG =", value, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagNotEqualTo(Byte value) {
			addCriterion("BAIDU_FLAG <>", value, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagGreaterThan(Byte value) {
			addCriterion("BAIDU_FLAG >", value, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("BAIDU_FLAG >=", value, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagLessThan(Byte value) {
			addCriterion("BAIDU_FLAG <", value, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagLessThanOrEqualTo(Byte value) {
			addCriterion("BAIDU_FLAG <=", value, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagIn(List<Byte> values) {
			addCriterion("BAIDU_FLAG in", values, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagNotIn(List<Byte> values) {
			addCriterion("BAIDU_FLAG not in", values, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagBetween(Byte value1, Byte value2) {
			addCriterion("BAIDU_FLAG between", value1, value2, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andBaiduFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("BAIDU_FLAG not between", value1, value2, "baiduFlag");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyIsNull() {
			addCriterion("WF_PRICE_STANDARD_BUY is null");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyIsNotNull() {
			addCriterion("WF_PRICE_STANDARD_BUY is not null");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY =", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyNotEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY <>", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyGreaterThan(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY >", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyGreaterThanOrEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY >=", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyLessThan(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY <", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyLessThanOrEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY <=", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyLike(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY like", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyNotLike(String value) {
			addCriterion("WF_PRICE_STANDARD_BUY not like", value, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyIn(List<String> values) {
			addCriterion("WF_PRICE_STANDARD_BUY in", values, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyNotIn(List<String> values) {
			addCriterion("WF_PRICE_STANDARD_BUY not in", values, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyBetween(String value1, String value2) {
			addCriterion("WF_PRICE_STANDARD_BUY between", value1, value2, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardBuyNotBetween(String value1, String value2) {
			addCriterion("WF_PRICE_STANDARD_BUY not between", value1, value2, "wfPriceStandardBuy");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentIsNull() {
			addCriterion("WF_PRICE_STANDARD_RENT is null");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentIsNotNull() {
			addCriterion("WF_PRICE_STANDARD_RENT is not null");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT =", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentNotEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT <>", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentGreaterThan(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT >", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentGreaterThanOrEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT >=", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentLessThan(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT <", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentLessThanOrEqualTo(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT <=", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentLike(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT like", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentNotLike(String value) {
			addCriterion("WF_PRICE_STANDARD_RENT not like", value, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentIn(List<String> values) {
			addCriterion("WF_PRICE_STANDARD_RENT in", values, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentNotIn(List<String> values) {
			addCriterion("WF_PRICE_STANDARD_RENT not in", values, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentBetween(String value1, String value2) {
			addCriterion("WF_PRICE_STANDARD_RENT between", value1, value2, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPriceStandardRentNotBetween(String value1, String value2) {
			addCriterion("WF_PRICE_STANDARD_RENT not between", value1, value2, "wfPriceStandardRent");
			return (Criteria) this;
		}

		public Criteria andWfPricePayIsNull() {
			addCriterion("WF_PRICE_PAY is null");
			return (Criteria) this;
		}

		public Criteria andWfPricePayIsNotNull() {
			addCriterion("WF_PRICE_PAY is not null");
			return (Criteria) this;
		}

		public Criteria andWfPricePayEqualTo(String value) {
			addCriterion("WF_PRICE_PAY =", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayNotEqualTo(String value) {
			addCriterion("WF_PRICE_PAY <>", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayGreaterThan(String value) {
			addCriterion("WF_PRICE_PAY >", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayGreaterThanOrEqualTo(String value) {
			addCriterion("WF_PRICE_PAY >=", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayLessThan(String value) {
			addCriterion("WF_PRICE_PAY <", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayLessThanOrEqualTo(String value) {
			addCriterion("WF_PRICE_PAY <=", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayLike(String value) {
			addCriterion("WF_PRICE_PAY like", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayNotLike(String value) {
			addCriterion("WF_PRICE_PAY not like", value, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayIn(List<String> values) {
			addCriterion("WF_PRICE_PAY in", values, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayNotIn(List<String> values) {
			addCriterion("WF_PRICE_PAY not in", values, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayBetween(String value1, String value2) {
			addCriterion("WF_PRICE_PAY between", value1, value2, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andWfPricePayNotBetween(String value1, String value2) {
			addCriterion("WF_PRICE_PAY not between", value1, value2, "wfPricePay");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagIsNull() {
			addCriterion("YOUJIA_CITY_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagIsNotNull() {
			addCriterion("YOUJIA_CITY_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagEqualTo(Byte value) {
			addCriterion("YOUJIA_CITY_FLAG =", value, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagNotEqualTo(Byte value) {
			addCriterion("YOUJIA_CITY_FLAG <>", value, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagGreaterThan(Byte value) {
			addCriterion("YOUJIA_CITY_FLAG >", value, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_CITY_FLAG >=", value, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagLessThan(Byte value) {
			addCriterion("YOUJIA_CITY_FLAG <", value, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_CITY_FLAG <=", value, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagIn(List<Byte> values) {
			addCriterion("YOUJIA_CITY_FLAG in", values, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagNotIn(List<Byte> values) {
			addCriterion("YOUJIA_CITY_FLAG not in", values, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_CITY_FLAG between", value1, value2, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCityFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_CITY_FLAG not between", value1, value2, "youjiaCityFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagIsNull() {
			addCriterion("YOUJIA_BUILDINFO_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagIsNotNull() {
			addCriterion("YOUJIA_BUILDINFO_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagEqualTo(Byte value) {
			addCriterion("YOUJIA_BUILDINFO_FLAG =", value, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagNotEqualTo(Byte value) {
			addCriterion("YOUJIA_BUILDINFO_FLAG <>", value, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagGreaterThan(Byte value) {
			addCriterion("YOUJIA_BUILDINFO_FLAG >", value, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_BUILDINFO_FLAG >=", value, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagLessThan(Byte value) {
			addCriterion("YOUJIA_BUILDINFO_FLAG <", value, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_BUILDINFO_FLAG <=", value, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagIn(List<Byte> values) {
			addCriterion("YOUJIA_BUILDINFO_FLAG in", values, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagNotIn(List<Byte> values) {
			addCriterion("YOUJIA_BUILDINFO_FLAG not in", values, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_BUILDINFO_FLAG between", value1, value2, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaBuildinfoFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_BUILDINFO_FLAG not between", value1, value2, "youjiaBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreIsNull() {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE is null");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreIsNotNull() {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE is not null");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreEqualTo(Integer value) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE =", value, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreNotEqualTo(Integer value) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE <>", value, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreGreaterThan(Integer value) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE >", value, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE >=", value, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreLessThan(Integer value) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE <", value, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE <=", value, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreIn(List<Integer> values) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE in", values, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreNotIn(List<Integer> values) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE not in", values, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreBetween(Integer value1, Integer value2) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE between", value1, value2, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouShareHousegainscoreNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_SHARE_HOUSEGAINSCORE not between", value1, value2, "youShareHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreIsNull() {
			addCriterion("YOU_BUY_HOUSECOSTSCORE is null");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreIsNotNull() {
			addCriterion("YOU_BUY_HOUSECOSTSCORE is not null");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreEqualTo(Integer value) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE =", value, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreNotEqualTo(Integer value) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE <>", value, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreGreaterThan(Integer value) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE >", value, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE >=", value, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreLessThan(Integer value) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE <", value, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE <=", value, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreIn(List<Integer> values) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE in", values, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreNotIn(List<Integer> values) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE not in", values, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreBetween(Integer value1, Integer value2) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE between", value1, value2, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouBuyHousecostscoreNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_BUY_HOUSECOSTSCORE not between", value1, value2, "youBuyHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreIsNull() {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE is null");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreIsNotNull() {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE is not null");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreEqualTo(Integer value) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE =", value, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreNotEqualTo(Integer value) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE <>", value, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreGreaterThan(Integer value) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE >", value, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE >=", value, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreLessThan(Integer value) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE <", value, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE <=", value, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreIn(List<Integer> values) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE in", values, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreNotIn(List<Integer> values) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE not in", values, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreBetween(Integer value1, Integer value2) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE between", value1, value2, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCooperateHousecostscoreNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_COOPERATE_HOUSECOSTSCORE not between", value1, value2, "youCooperateHousecostscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreIsNull() {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE is null");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreIsNotNull() {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE is not null");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreEqualTo(Integer value) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE =", value, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreNotEqualTo(Integer value) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE <>", value, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreGreaterThan(Integer value) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE >", value, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE >=", value, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreLessThan(Integer value) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE <", value, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE <=", value, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreIn(List<Integer> values) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE in", values, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreNotIn(List<Integer> values) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE not in", values, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreBetween(Integer value1, Integer value2) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE between", value1, value2, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouCallBuildfirstscoreNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_CALL_BUILDFIRSTSCORE not between", value1, value2, "youCallBuildfirstscore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreIsNull() {
			addCriterion("YOU_SHOW_BUILDPHONESCORE is null");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreIsNotNull() {
			addCriterion("YOU_SHOW_BUILDPHONESCORE is not null");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreEqualTo(Integer value) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE =", value, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreNotEqualTo(Integer value) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE <>", value, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreGreaterThan(Integer value) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE >", value, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE >=", value, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreLessThan(Integer value) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE <", value, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE <=", value, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreIn(List<Integer> values) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE in", values, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreNotIn(List<Integer> values) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE not in", values, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreBetween(Integer value1, Integer value2) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE between", value1, value2, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouShowBuildphonescoreNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_SHOW_BUILDPHONESCORE not between", value1, value2, "youShowBuildphonescore");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagIsNull() {
			addCriterion("YOU_BUILDINFO_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagIsNotNull() {
			addCriterion("YOU_BUILDINFO_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagEqualTo(Integer value) {
			addCriterion("YOU_BUILDINFO_FLAG =", value, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagNotEqualTo(Integer value) {
			addCriterion("YOU_BUILDINFO_FLAG <>", value, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagGreaterThan(Integer value) {
			addCriterion("YOU_BUILDINFO_FLAG >", value, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_BUILDINFO_FLAG >=", value, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagLessThan(Integer value) {
			addCriterion("YOU_BUILDINFO_FLAG <", value, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_BUILDINFO_FLAG <=", value, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagIn(List<Integer> values) {
			addCriterion("YOU_BUILDINFO_FLAG in", values, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagNotIn(List<Integer> values) {
			addCriterion("YOU_BUILDINFO_FLAG not in", values, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagBetween(Integer value1, Integer value2) {
			addCriterion("YOU_BUILDINFO_FLAG between", value1, value2, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouBuildinfoFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_BUILDINFO_FLAG not between", value1, value2, "youBuildinfoFlag");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathIsNull() {
			addCriterion("YOU_LOGO_PATH is null");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathIsNotNull() {
			addCriterion("YOU_LOGO_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathEqualTo(String value) {
			addCriterion("YOU_LOGO_PATH =", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathNotEqualTo(String value) {
			addCriterion("YOU_LOGO_PATH <>", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathGreaterThan(String value) {
			addCriterion("YOU_LOGO_PATH >", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathGreaterThanOrEqualTo(String value) {
			addCriterion("YOU_LOGO_PATH >=", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathLessThan(String value) {
			addCriterion("YOU_LOGO_PATH <", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathLessThanOrEqualTo(String value) {
			addCriterion("YOU_LOGO_PATH <=", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathLike(String value) {
			addCriterion("YOU_LOGO_PATH like", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathNotLike(String value) {
			addCriterion("YOU_LOGO_PATH not like", value, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathIn(List<String> values) {
			addCriterion("YOU_LOGO_PATH in", values, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathNotIn(List<String> values) {
			addCriterion("YOU_LOGO_PATH not in", values, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathBetween(String value1, String value2) {
			addCriterion("YOU_LOGO_PATH between", value1, value2, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouLogoPathNotBetween(String value1, String value2) {
			addCriterion("YOU_LOGO_PATH not between", value1, value2, "youLogoPath");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagIsNull() {
			addCriterion("DIDI_OPEN_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagIsNotNull() {
			addCriterion("DIDI_OPEN_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagEqualTo(Byte value) {
			addCriterion("DIDI_OPEN_FLAG =", value, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagNotEqualTo(Byte value) {
			addCriterion("DIDI_OPEN_FLAG <>", value, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagGreaterThan(Byte value) {
			addCriterion("DIDI_OPEN_FLAG >", value, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("DIDI_OPEN_FLAG >=", value, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagLessThan(Byte value) {
			addCriterion("DIDI_OPEN_FLAG <", value, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagLessThanOrEqualTo(Byte value) {
			addCriterion("DIDI_OPEN_FLAG <=", value, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagIn(List<Byte> values) {
			addCriterion("DIDI_OPEN_FLAG in", values, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagNotIn(List<Byte> values) {
			addCriterion("DIDI_OPEN_FLAG not in", values, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagBetween(Byte value1, Byte value2) {
			addCriterion("DIDI_OPEN_FLAG between", value1, value2, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andDidiOpenFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("DIDI_OPEN_FLAG not between", value1, value2, "didiOpenFlag");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeIsNull() {
			addCriterion("UPDATE_SECTION_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeIsNotNull() {
			addCriterion("UPDATE_SECTION_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeEqualTo(Date value) {
			addCriterion("UPDATE_SECTION_TIME =", value, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeNotEqualTo(Date value) {
			addCriterion("UPDATE_SECTION_TIME <>", value, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeGreaterThan(Date value) {
			addCriterion("UPDATE_SECTION_TIME >", value, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATE_SECTION_TIME >=", value, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeLessThan(Date value) {
			addCriterion("UPDATE_SECTION_TIME <", value, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeLessThanOrEqualTo(Date value) {
			addCriterion("UPDATE_SECTION_TIME <=", value, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeIn(List<Date> values) {
			addCriterion("UPDATE_SECTION_TIME in", values, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeNotIn(List<Date> values) {
			addCriterion("UPDATE_SECTION_TIME not in", values, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeBetween(Date value1, Date value2) {
			addCriterion("UPDATE_SECTION_TIME between", value1, value2, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateSectionTimeNotBetween(Date value1, Date value2) {
			addCriterion("UPDATE_SECTION_TIME not between", value1, value2, "updateSectionTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeIsNull() {
			addCriterion("UPDATE_REG_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeIsNotNull() {
			addCriterion("UPDATE_REG_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeEqualTo(Date value) {
			addCriterion("UPDATE_REG_TIME =", value, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeNotEqualTo(Date value) {
			addCriterion("UPDATE_REG_TIME <>", value, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeGreaterThan(Date value) {
			addCriterion("UPDATE_REG_TIME >", value, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATE_REG_TIME >=", value, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeLessThan(Date value) {
			addCriterion("UPDATE_REG_TIME <", value, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeLessThanOrEqualTo(Date value) {
			addCriterion("UPDATE_REG_TIME <=", value, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeIn(List<Date> values) {
			addCriterion("UPDATE_REG_TIME in", values, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeNotIn(List<Date> values) {
			addCriterion("UPDATE_REG_TIME not in", values, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeBetween(Date value1, Date value2) {
			addCriterion("UPDATE_REG_TIME between", value1, value2, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andUpdateRegTimeNotBetween(Date value1, Date value2) {
			addCriterion("UPDATE_REG_TIME not between", value1, value2, "updateRegTime");
			return (Criteria) this;
		}

		public Criteria andCityShareNameIsNull() {
			addCriterion("CITY_SHARE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCityShareNameIsNotNull() {
			addCriterion("CITY_SHARE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCityShareNameEqualTo(String value) {
			addCriterion("CITY_SHARE_NAME =", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameNotEqualTo(String value) {
			addCriterion("CITY_SHARE_NAME <>", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameGreaterThan(String value) {
			addCriterion("CITY_SHARE_NAME >", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameGreaterThanOrEqualTo(String value) {
			addCriterion("CITY_SHARE_NAME >=", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameLessThan(String value) {
			addCriterion("CITY_SHARE_NAME <", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameLessThanOrEqualTo(String value) {
			addCriterion("CITY_SHARE_NAME <=", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameLike(String value) {
			addCriterion("CITY_SHARE_NAME like", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameNotLike(String value) {
			addCriterion("CITY_SHARE_NAME not like", value, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameIn(List<String> values) {
			addCriterion("CITY_SHARE_NAME in", values, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameNotIn(List<String> values) {
			addCriterion("CITY_SHARE_NAME not in", values, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameBetween(String value1, String value2) {
			addCriterion("CITY_SHARE_NAME between", value1, value2, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareNameNotBetween(String value1, String value2) {
			addCriterion("CITY_SHARE_NAME not between", value1, value2, "cityShareName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameIsNull() {
			addCriterion("CITY_SHARE_SHORT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameIsNotNull() {
			addCriterion("CITY_SHARE_SHORT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameEqualTo(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME =", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameNotEqualTo(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME <>", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameGreaterThan(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME >", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameGreaterThanOrEqualTo(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME >=", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameLessThan(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME <", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameLessThanOrEqualTo(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME <=", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameLike(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME like", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameNotLike(String value) {
			addCriterion("CITY_SHARE_SHORT_NAME not like", value, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameIn(List<String> values) {
			addCriterion("CITY_SHARE_SHORT_NAME in", values, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameNotIn(List<String> values) {
			addCriterion("CITY_SHARE_SHORT_NAME not in", values, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameBetween(String value1, String value2) {
			addCriterion("CITY_SHARE_SHORT_NAME between", value1, value2, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andCityShareShortNameNotBetween(String value1, String value2) {
			addCriterion("CITY_SHARE_SHORT_NAME not between", value1, value2, "cityShareShortName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameIsNull() {
			addCriterion("YOUJIA_HOTLINE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameIsNotNull() {
			addCriterion("YOUJIA_HOTLINE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME =", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameNotEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME <>", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameGreaterThan(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME >", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameGreaterThanOrEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME >=", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameLessThan(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME <", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameLessThanOrEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME <=", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameLike(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME like", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameNotLike(String value) {
			addCriterion("YOUJIA_HOTLINE_NAME not like", value, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameIn(List<String> values) {
			addCriterion("YOUJIA_HOTLINE_NAME in", values, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameNotIn(List<String> values) {
			addCriterion("YOUJIA_HOTLINE_NAME not in", values, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameBetween(String value1, String value2) {
			addCriterion("YOUJIA_HOTLINE_NAME between", value1, value2, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNameNotBetween(String value1, String value2) {
			addCriterion("YOUJIA_HOTLINE_NAME not between", value1, value2, "youjiaHotlineName");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineIsNull() {
			addCriterion("YOUJIA_HOTLINE is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineIsNotNull() {
			addCriterion("YOUJIA_HOTLINE is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE =", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNotEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE <>", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineGreaterThan(String value) {
			addCriterion("YOUJIA_HOTLINE >", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineGreaterThanOrEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE >=", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineLessThan(String value) {
			addCriterion("YOUJIA_HOTLINE <", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineLessThanOrEqualTo(String value) {
			addCriterion("YOUJIA_HOTLINE <=", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineLike(String value) {
			addCriterion("YOUJIA_HOTLINE like", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNotLike(String value) {
			addCriterion("YOUJIA_HOTLINE not like", value, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineIn(List<String> values) {
			addCriterion("YOUJIA_HOTLINE in", values, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNotIn(List<String> values) {
			addCriterion("YOUJIA_HOTLINE not in", values, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineBetween(String value1, String value2) {
			addCriterion("YOUJIA_HOTLINE between", value1, value2, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaHotlineNotBetween(String value1, String value2) {
			addCriterion("YOUJIA_HOTLINE not between", value1, value2, "youjiaHotline");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneIsNull() {
			addCriterion("YOUJIA_AUDIT_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneIsNotNull() {
			addCriterion("YOUJIA_AUDIT_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneEqualTo(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE =", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneNotEqualTo(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE <>", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneGreaterThan(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE >", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE >=", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneLessThan(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE <", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneLessThanOrEqualTo(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE <=", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneLike(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE like", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneNotLike(String value) {
			addCriterion("YOUJIA_AUDIT_PHONE not like", value, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneIn(List<String> values) {
			addCriterion("YOUJIA_AUDIT_PHONE in", values, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneNotIn(List<String> values) {
			addCriterion("YOUJIA_AUDIT_PHONE not in", values, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneBetween(String value1, String value2) {
			addCriterion("YOUJIA_AUDIT_PHONE between", value1, value2, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaAuditPhoneNotBetween(String value1, String value2) {
			addCriterion("YOUJIA_AUDIT_PHONE not between", value1, value2, "youjiaAuditPhone");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouIsNull() {
			addCriterion("APP_SHOW_YOUYOU is null");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouIsNotNull() {
			addCriterion("APP_SHOW_YOUYOU is not null");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouEqualTo(Byte value) {
			addCriterion("APP_SHOW_YOUYOU =", value, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouNotEqualTo(Byte value) {
			addCriterion("APP_SHOW_YOUYOU <>", value, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouGreaterThan(Byte value) {
			addCriterion("APP_SHOW_YOUYOU >", value, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouGreaterThanOrEqualTo(Byte value) {
			addCriterion("APP_SHOW_YOUYOU >=", value, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouLessThan(Byte value) {
			addCriterion("APP_SHOW_YOUYOU <", value, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouLessThanOrEqualTo(Byte value) {
			addCriterion("APP_SHOW_YOUYOU <=", value, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouIn(List<Byte> values) {
			addCriterion("APP_SHOW_YOUYOU in", values, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouNotIn(List<Byte> values) {
			addCriterion("APP_SHOW_YOUYOU not in", values, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouBetween(Byte value1, Byte value2) {
			addCriterion("APP_SHOW_YOUYOU between", value1, value2, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andAppShowYouyouNotBetween(Byte value1, Byte value2) {
			addCriterion("APP_SHOW_YOUYOU not between", value1, value2, "appShowYouyou");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreIsNull() {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE is null");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreIsNotNull() {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE is not null");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreEqualTo(Integer value) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE =", value, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreNotEqualTo(Integer value) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE <>", value, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreGreaterThan(Integer value) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE >", value, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE >=", value, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreLessThan(Integer value) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE <", value, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE <=", value, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreIn(List<Integer> values) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE in", values, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreNotIn(List<Integer> values) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE not in", values, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreBetween(Integer value1, Integer value2) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE between", value1, value2, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYouPropertyVerHousegainscoreNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_PROPERTY_VER_HOUSEGAINSCORE not between", value1, value2, "youPropertyVerHousegainscore");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeIsNull() {
			addCriterion("YOUJIA_IPCALL_FREE is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeIsNotNull() {
			addCriterion("YOUJIA_IPCALL_FREE is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeEqualTo(Byte value) {
			addCriterion("YOUJIA_IPCALL_FREE =", value, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeNotEqualTo(Byte value) {
			addCriterion("YOUJIA_IPCALL_FREE <>", value, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeGreaterThan(Byte value) {
			addCriterion("YOUJIA_IPCALL_FREE >", value, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_IPCALL_FREE >=", value, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeLessThan(Byte value) {
			addCriterion("YOUJIA_IPCALL_FREE <", value, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeLessThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_IPCALL_FREE <=", value, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeIn(List<Byte> values) {
			addCriterion("YOUJIA_IPCALL_FREE in", values, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeNotIn(List<Byte> values) {
			addCriterion("YOUJIA_IPCALL_FREE not in", values, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_IPCALL_FREE between", value1, value2, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andYoujiaIpcallFreeNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_IPCALL_FREE not between", value1, value2, "youjiaIpcallFree");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeIsNull() {
			addCriterion("CITY_LEVEL_GRADE is null");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeIsNotNull() {
			addCriterion("CITY_LEVEL_GRADE is not null");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeEqualTo(Byte value) {
			addCriterion("CITY_LEVEL_GRADE =", value, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeNotEqualTo(Byte value) {
			addCriterion("CITY_LEVEL_GRADE <>", value, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeGreaterThan(Byte value) {
			addCriterion("CITY_LEVEL_GRADE >", value, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CITY_LEVEL_GRADE >=", value, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeLessThan(Byte value) {
			addCriterion("CITY_LEVEL_GRADE <", value, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeLessThanOrEqualTo(Byte value) {
			addCriterion("CITY_LEVEL_GRADE <=", value, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeIn(List<Byte> values) {
			addCriterion("CITY_LEVEL_GRADE in", values, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeNotIn(List<Byte> values) {
			addCriterion("CITY_LEVEL_GRADE not in", values, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeBetween(Byte value1, Byte value2) {
			addCriterion("CITY_LEVEL_GRADE between", value1, value2, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andCityLevelGradeNotBetween(Byte value1, Byte value2) {
			addCriterion("CITY_LEVEL_GRADE not between", value1, value2, "cityLevelGrade");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineIsNull() {
			addCriterion("YOU_DEAL_NEED_EXAMINE is null");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineIsNotNull() {
			addCriterion("YOU_DEAL_NEED_EXAMINE is not null");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineEqualTo(Byte value) {
			addCriterion("YOU_DEAL_NEED_EXAMINE =", value, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineNotEqualTo(Byte value) {
			addCriterion("YOU_DEAL_NEED_EXAMINE <>", value, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineGreaterThan(Byte value) {
			addCriterion("YOU_DEAL_NEED_EXAMINE >", value, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOU_DEAL_NEED_EXAMINE >=", value, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineLessThan(Byte value) {
			addCriterion("YOU_DEAL_NEED_EXAMINE <", value, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineLessThanOrEqualTo(Byte value) {
			addCriterion("YOU_DEAL_NEED_EXAMINE <=", value, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineIn(List<Byte> values) {
			addCriterion("YOU_DEAL_NEED_EXAMINE in", values, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineNotIn(List<Byte> values) {
			addCriterion("YOU_DEAL_NEED_EXAMINE not in", values, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineBetween(Byte value1, Byte value2) {
			addCriterion("YOU_DEAL_NEED_EXAMINE between", value1, value2, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andYouDealNeedExamineNotBetween(Byte value1, Byte value2) {
			addCriterion("YOU_DEAL_NEED_EXAMINE not between", value1, value2, "youDealNeedExamine");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlIsNull() {
			addCriterion("IP_CALL_URL is null");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlIsNotNull() {
			addCriterion("IP_CALL_URL is not null");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlEqualTo(String value) {
			addCriterion("IP_CALL_URL =", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlNotEqualTo(String value) {
			addCriterion("IP_CALL_URL <>", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlGreaterThan(String value) {
			addCriterion("IP_CALL_URL >", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlGreaterThanOrEqualTo(String value) {
			addCriterion("IP_CALL_URL >=", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlLessThan(String value) {
			addCriterion("IP_CALL_URL <", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlLessThanOrEqualTo(String value) {
			addCriterion("IP_CALL_URL <=", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlLike(String value) {
			addCriterion("IP_CALL_URL like", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlNotLike(String value) {
			addCriterion("IP_CALL_URL not like", value, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlIn(List<String> values) {
			addCriterion("IP_CALL_URL in", values, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlNotIn(List<String> values) {
			addCriterion("IP_CALL_URL not in", values, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlBetween(String value1, String value2) {
			addCriterion("IP_CALL_URL between", value1, value2, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andIpCallUrlNotBetween(String value1, String value2) {
			addCriterion("IP_CALL_URL not between", value1, value2, "ipCallUrl");
			return (Criteria) this;
		}

		public Criteria andRepairFlagIsNull() {
			addCriterion("REPAIR_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andRepairFlagIsNotNull() {
			addCriterion("REPAIR_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andRepairFlagEqualTo(Byte value) {
			addCriterion("REPAIR_FLAG =", value, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagNotEqualTo(Byte value) {
			addCriterion("REPAIR_FLAG <>", value, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagGreaterThan(Byte value) {
			addCriterion("REPAIR_FLAG >", value, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("REPAIR_FLAG >=", value, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagLessThan(Byte value) {
			addCriterion("REPAIR_FLAG <", value, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagLessThanOrEqualTo(Byte value) {
			addCriterion("REPAIR_FLAG <=", value, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagIn(List<Byte> values) {
			addCriterion("REPAIR_FLAG in", values, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagNotIn(List<Byte> values) {
			addCriterion("REPAIR_FLAG not in", values, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagBetween(Byte value1, Byte value2) {
			addCriterion("REPAIR_FLAG between", value1, value2, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andRepairFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("REPAIR_FLAG not between", value1, value2, "repairFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagIsNull() {
			addCriterion("FITMENT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagIsNotNull() {
			addCriterion("FITMENT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagEqualTo(Byte value) {
			addCriterion("FITMENT_FLAG =", value, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagNotEqualTo(Byte value) {
			addCriterion("FITMENT_FLAG <>", value, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagGreaterThan(Byte value) {
			addCriterion("FITMENT_FLAG >", value, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("FITMENT_FLAG >=", value, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagLessThan(Byte value) {
			addCriterion("FITMENT_FLAG <", value, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagLessThanOrEqualTo(Byte value) {
			addCriterion("FITMENT_FLAG <=", value, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagIn(List<Byte> values) {
			addCriterion("FITMENT_FLAG in", values, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagNotIn(List<Byte> values) {
			addCriterion("FITMENT_FLAG not in", values, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagBetween(Byte value1, Byte value2) {
			addCriterion("FITMENT_FLAG between", value1, value2, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andFitmentFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("FITMENT_FLAG not between", value1, value2, "fitmentFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayIsNull() {
			addCriterion("YOUJIA_DATA_NEED_PAY is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayIsNotNull() {
			addCriterion("YOUJIA_DATA_NEED_PAY is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayEqualTo(Byte value) {
			addCriterion("YOUJIA_DATA_NEED_PAY =", value, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayNotEqualTo(Byte value) {
			addCriterion("YOUJIA_DATA_NEED_PAY <>", value, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayGreaterThan(Byte value) {
			addCriterion("YOUJIA_DATA_NEED_PAY >", value, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_DATA_NEED_PAY >=", value, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayLessThan(Byte value) {
			addCriterion("YOUJIA_DATA_NEED_PAY <", value, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayLessThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_DATA_NEED_PAY <=", value, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayIn(List<Byte> values) {
			addCriterion("YOUJIA_DATA_NEED_PAY in", values, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayNotIn(List<Byte> values) {
			addCriterion("YOUJIA_DATA_NEED_PAY not in", values, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_DATA_NEED_PAY between", value1, value2, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andYoujiaDataNeedPayNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_DATA_NEED_PAY not between", value1, value2, "youjiaDataNeedPay");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionIsNull() {
			addCriterion("STATISTICS_PRICE_SALE_OPTION is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionIsNotNull() {
			addCriterion("STATISTICS_PRICE_SALE_OPTION is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION =", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionNotEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION <>", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionGreaterThan(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION >", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionGreaterThanOrEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION >=", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionLessThan(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION <", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionLessThanOrEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION <=", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionLike(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION like", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionNotLike(String value) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION not like", value, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionIn(List<String> values) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION in", values, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionNotIn(List<String> values) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION not in", values, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionBetween(String value1, String value2) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION between", value1, value2, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceSaleOptionNotBetween(String value1, String value2) {
			addCriterion("STATISTICS_PRICE_SALE_OPTION not between", value1, value2, "statisticsPriceSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionIsNull() {
			addCriterion("STATISTICS_AREA_SALE_OPTION is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionIsNotNull() {
			addCriterion("STATISTICS_AREA_SALE_OPTION is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionEqualTo(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION =", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionNotEqualTo(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION <>", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionGreaterThan(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION >", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionGreaterThanOrEqualTo(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION >=", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionLessThan(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION <", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionLessThanOrEqualTo(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION <=", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionLike(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION like", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionNotLike(String value) {
			addCriterion("STATISTICS_AREA_SALE_OPTION not like", value, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionIn(List<String> values) {
			addCriterion("STATISTICS_AREA_SALE_OPTION in", values, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionNotIn(List<String> values) {
			addCriterion("STATISTICS_AREA_SALE_OPTION not in", values, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionBetween(String value1, String value2) {
			addCriterion("STATISTICS_AREA_SALE_OPTION between", value1, value2, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaSaleOptionNotBetween(String value1, String value2) {
			addCriterion("STATISTICS_AREA_SALE_OPTION not between", value1, value2, "statisticsAreaSaleOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionIsNull() {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionIsNotNull() {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION =", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionNotEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION <>", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionGreaterThan(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION >", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionGreaterThanOrEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION >=", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionLessThan(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION <", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionLessThanOrEqualTo(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION <=", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionLike(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION like", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionNotLike(String value) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION not like", value, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionIn(List<String> values) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION in", values, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionNotIn(List<String> values) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION not in", values, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionBetween(String value1, String value2) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION between", value1, value2, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsPriceLeaseOptionNotBetween(String value1, String value2) {
			addCriterion("STATISTICS_PRICE_LEASE_OPTION not between", value1, value2, "statisticsPriceLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionIsNull() {
			addCriterion("STATISTICS_AREA_LEASE_OPTION is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionIsNotNull() {
			addCriterion("STATISTICS_AREA_LEASE_OPTION is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionEqualTo(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION =", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionNotEqualTo(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION <>", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionGreaterThan(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION >", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionGreaterThanOrEqualTo(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION >=", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionLessThan(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION <", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionLessThanOrEqualTo(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION <=", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionLike(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION like", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionNotLike(String value) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION not like", value, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionIn(List<String> values) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION in", values, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionNotIn(List<String> values) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION not in", values, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionBetween(String value1, String value2) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION between", value1, value2, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andStatisticsAreaLeaseOptionNotBetween(String value1, String value2) {
			addCriterion("STATISTICS_AREA_LEASE_OPTION not between", value1, value2, "statisticsAreaLeaseOption");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagIsNull() {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagIsNotNull() {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagEqualTo(Byte value) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG =", value, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagNotEqualTo(Byte value) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG <>", value, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagGreaterThan(Byte value) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG >", value, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG >=", value, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagLessThan(Byte value) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG <", value, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG <=", value, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagIn(List<Byte> values) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG in", values, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagNotIn(List<Byte> values) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG not in", values, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG between", value1, value2, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouNewHouseFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUYOU_NEW_HOUSE_FLAG not between", value1, value2, "youyouNewHouseFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagIsNull() {
			addCriterion("PA_FINANCE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagIsNotNull() {
			addCriterion("PA_FINANCE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagEqualTo(Byte value) {
			addCriterion("PA_FINANCE_FLAG =", value, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagNotEqualTo(Byte value) {
			addCriterion("PA_FINANCE_FLAG <>", value, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagGreaterThan(Byte value) {
			addCriterion("PA_FINANCE_FLAG >", value, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("PA_FINANCE_FLAG >=", value, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagLessThan(Byte value) {
			addCriterion("PA_FINANCE_FLAG <", value, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagLessThanOrEqualTo(Byte value) {
			addCriterion("PA_FINANCE_FLAG <=", value, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagIn(List<Byte> values) {
			addCriterion("PA_FINANCE_FLAG in", values, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagNotIn(List<Byte> values) {
			addCriterion("PA_FINANCE_FLAG not in", values, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagBetween(Byte value1, Byte value2) {
			addCriterion("PA_FINANCE_FLAG between", value1, value2, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andPaFinanceFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("PA_FINANCE_FLAG not between", value1, value2, "paFinanceFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagIsNull() {
			addCriterion("SHOW_CASE_NO_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagIsNotNull() {
			addCriterion("SHOW_CASE_NO_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagEqualTo(Byte value) {
			addCriterion("SHOW_CASE_NO_FLAG =", value, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagNotEqualTo(Byte value) {
			addCriterion("SHOW_CASE_NO_FLAG <>", value, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagGreaterThan(Byte value) {
			addCriterion("SHOW_CASE_NO_FLAG >", value, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("SHOW_CASE_NO_FLAG >=", value, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagLessThan(Byte value) {
			addCriterion("SHOW_CASE_NO_FLAG <", value, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagLessThanOrEqualTo(Byte value) {
			addCriterion("SHOW_CASE_NO_FLAG <=", value, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagIn(List<Byte> values) {
			addCriterion("SHOW_CASE_NO_FLAG in", values, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagNotIn(List<Byte> values) {
			addCriterion("SHOW_CASE_NO_FLAG not in", values, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagBetween(Byte value1, Byte value2) {
			addCriterion("SHOW_CASE_NO_FLAG between", value1, value2, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andShowCaseNoFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("SHOW_CASE_NO_FLAG not between", value1, value2, "showCaseNoFlag");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponIsNull() {
			addCriterion("OPEN_NEWHOUSE_COUPON is null");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponIsNotNull() {
			addCriterion("OPEN_NEWHOUSE_COUPON is not null");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponEqualTo(Byte value) {
			addCriterion("OPEN_NEWHOUSE_COUPON =", value, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponNotEqualTo(Byte value) {
			addCriterion("OPEN_NEWHOUSE_COUPON <>", value, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponGreaterThan(Byte value) {
			addCriterion("OPEN_NEWHOUSE_COUPON >", value, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_NEWHOUSE_COUPON >=", value, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponLessThan(Byte value) {
			addCriterion("OPEN_NEWHOUSE_COUPON <", value, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_NEWHOUSE_COUPON <=", value, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponIn(List<Byte> values) {
			addCriterion("OPEN_NEWHOUSE_COUPON in", values, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponNotIn(List<Byte> values) {
			addCriterion("OPEN_NEWHOUSE_COUPON not in", values, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_NEWHOUSE_COUPON between", value1, value2, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenNewhouseCouponNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_NEWHOUSE_COUPON not between", value1, value2, "openNewhouseCoupon");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagIsNull() {
			addCriterion("OPEN_OWNERHOUSE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagIsNotNull() {
			addCriterion("OPEN_OWNERHOUSE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagEqualTo(Byte value) {
			addCriterion("OPEN_OWNERHOUSE_FLAG =", value, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagNotEqualTo(Byte value) {
			addCriterion("OPEN_OWNERHOUSE_FLAG <>", value, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagGreaterThan(Byte value) {
			addCriterion("OPEN_OWNERHOUSE_FLAG >", value, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_OWNERHOUSE_FLAG >=", value, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagLessThan(Byte value) {
			addCriterion("OPEN_OWNERHOUSE_FLAG <", value, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_OWNERHOUSE_FLAG <=", value, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagIn(List<Byte> values) {
			addCriterion("OPEN_OWNERHOUSE_FLAG in", values, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagNotIn(List<Byte> values) {
			addCriterion("OPEN_OWNERHOUSE_FLAG not in", values, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_OWNERHOUSE_FLAG between", value1, value2, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andOpenOwnerhouseFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_OWNERHOUSE_FLAG not between", value1, value2, "openOwnerhouseFlag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagIsNull() {
			addCriterion("AD_WAP_OPENFLAG is null");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagIsNotNull() {
			addCriterion("AD_WAP_OPENFLAG is not null");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagEqualTo(Byte value) {
			addCriterion("AD_WAP_OPENFLAG =", value, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagNotEqualTo(Byte value) {
			addCriterion("AD_WAP_OPENFLAG <>", value, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagGreaterThan(Byte value) {
			addCriterion("AD_WAP_OPENFLAG >", value, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagGreaterThanOrEqualTo(Byte value) {
			addCriterion("AD_WAP_OPENFLAG >=", value, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagLessThan(Byte value) {
			addCriterion("AD_WAP_OPENFLAG <", value, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagLessThanOrEqualTo(Byte value) {
			addCriterion("AD_WAP_OPENFLAG <=", value, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagIn(List<Byte> values) {
			addCriterion("AD_WAP_OPENFLAG in", values, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagNotIn(List<Byte> values) {
			addCriterion("AD_WAP_OPENFLAG not in", values, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagBetween(Byte value1, Byte value2) {
			addCriterion("AD_WAP_OPENFLAG between", value1, value2, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andAdWapOpenflagNotBetween(Byte value1, Byte value2) {
			addCriterion("AD_WAP_OPENFLAG not between", value1, value2, "adWapOpenflag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagIsNull() {
			addCriterion("CITY_APARTMENT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagIsNotNull() {
			addCriterion("CITY_APARTMENT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagEqualTo(Byte value) {
			addCriterion("CITY_APARTMENT_FLAG =", value, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagNotEqualTo(Byte value) {
			addCriterion("CITY_APARTMENT_FLAG <>", value, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagGreaterThan(Byte value) {
			addCriterion("CITY_APARTMENT_FLAG >", value, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("CITY_APARTMENT_FLAG >=", value, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagLessThan(Byte value) {
			addCriterion("CITY_APARTMENT_FLAG <", value, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagLessThanOrEqualTo(Byte value) {
			addCriterion("CITY_APARTMENT_FLAG <=", value, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagIn(List<Byte> values) {
			addCriterion("CITY_APARTMENT_FLAG in", values, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagNotIn(List<Byte> values) {
			addCriterion("CITY_APARTMENT_FLAG not in", values, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagBetween(Byte value1, Byte value2) {
			addCriterion("CITY_APARTMENT_FLAG between", value1, value2, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityApartmentFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("CITY_APARTMENT_FLAG not between", value1, value2, "cityApartmentFlag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagIsNull() {
			addCriterion("CITY_CHECK_CODEFLAG is null");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagIsNotNull() {
			addCriterion("CITY_CHECK_CODEFLAG is not null");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagEqualTo(Byte value) {
			addCriterion("CITY_CHECK_CODEFLAG =", value, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagNotEqualTo(Byte value) {
			addCriterion("CITY_CHECK_CODEFLAG <>", value, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagGreaterThan(Byte value) {
			addCriterion("CITY_CHECK_CODEFLAG >", value, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagGreaterThanOrEqualTo(Byte value) {
			addCriterion("CITY_CHECK_CODEFLAG >=", value, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagLessThan(Byte value) {
			addCriterion("CITY_CHECK_CODEFLAG <", value, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagLessThanOrEqualTo(Byte value) {
			addCriterion("CITY_CHECK_CODEFLAG <=", value, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagIn(List<Byte> values) {
			addCriterion("CITY_CHECK_CODEFLAG in", values, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagNotIn(List<Byte> values) {
			addCriterion("CITY_CHECK_CODEFLAG not in", values, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagBetween(Byte value1, Byte value2) {
			addCriterion("CITY_CHECK_CODEFLAG between", value1, value2, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityCheckCodeflagNotBetween(Byte value1, Byte value2) {
			addCriterion("CITY_CHECK_CODEFLAG not between", value1, value2, "cityCheckCodeflag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagIsNull() {
			addCriterion("CITY_SHARE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagIsNotNull() {
			addCriterion("CITY_SHARE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG =", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagNotEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG <>", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagGreaterThan(Byte value) {
			addCriterion("CITY_SHARE_FLAG >", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG >=", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagLessThan(Byte value) {
			addCriterion("CITY_SHARE_FLAG <", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagLessThanOrEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG <=", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagIn(List<Byte> values) {
			addCriterion("CITY_SHARE_FLAG in", values, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagNotIn(List<Byte> values) {
			addCriterion("CITY_SHARE_FLAG not in", values, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagBetween(Byte value1, Byte value2) {
			addCriterion("CITY_SHARE_FLAG between", value1, value2, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("CITY_SHARE_FLAG not between", value1, value2, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagIsNull() {
			addCriterion("BUILD_ASSESS_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagIsNotNull() {
			addCriterion("BUILD_ASSESS_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG =", value, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagNotEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG <>", value, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagGreaterThan(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG >", value, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG >=", value, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagLessThan(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG <", value, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagLessThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG <=", value, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagIn(List<Byte> values) {
			addCriterion("BUILD_ASSESS_FLAG in", values, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagNotIn(List<Byte> values) {
			addCriterion("BUILD_ASSESS_FLAG not in", values, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ASSESS_FLAG between", value1, value2, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ASSESS_FLAG not between", value1, value2, "buildAssessFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagIsNull() {
			addCriterion("FZG_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andFzgFlagIsNotNull() {
			addCriterion("FZG_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andFzgFlagEqualTo(Byte value) {
			addCriterion("FZG_FLAG =", value, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagNotEqualTo(Byte value) {
			addCriterion("FZG_FLAG <>", value, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagGreaterThan(Byte value) {
			addCriterion("FZG_FLAG >", value, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("FZG_FLAG >=", value, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagLessThan(Byte value) {
			addCriterion("FZG_FLAG <", value, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagLessThanOrEqualTo(Byte value) {
			addCriterion("FZG_FLAG <=", value, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagIn(List<Byte> values) {
			addCriterion("FZG_FLAG in", values, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagNotIn(List<Byte> values) {
			addCriterion("FZG_FLAG not in", values, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagBetween(Byte value1, Byte value2) {
			addCriterion("FZG_FLAG between", value1, value2, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andFzgFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("FZG_FLAG not between", value1, value2, "fzgFlag");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenIsNull() {
			addCriterion("BUILD_ASSESS_IS_OPEN is null");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenIsNotNull() {
			addCriterion("BUILD_ASSESS_IS_OPEN is not null");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_IS_OPEN =", value, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenNotEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_IS_OPEN <>", value, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenGreaterThan(Byte value) {
			addCriterion("BUILD_ASSESS_IS_OPEN >", value, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_IS_OPEN >=", value, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenLessThan(Byte value) {
			addCriterion("BUILD_ASSESS_IS_OPEN <", value, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenLessThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_IS_OPEN <=", value, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenIn(List<Byte> values) {
			addCriterion("BUILD_ASSESS_IS_OPEN in", values, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenNotIn(List<Byte> values) {
			addCriterion("BUILD_ASSESS_IS_OPEN not in", values, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ASSESS_IS_OPEN between", value1, value2, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessIsOpenNotBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ASSESS_IS_OPEN not between", value1, value2, "buildAssessIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenIsNull() {
			addCriterion("APARTMENT_IS_OPEN is null");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenIsNotNull() {
			addCriterion("APARTMENT_IS_OPEN is not null");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenEqualTo(Byte value) {
			addCriterion("APARTMENT_IS_OPEN =", value, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenNotEqualTo(Byte value) {
			addCriterion("APARTMENT_IS_OPEN <>", value, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenGreaterThan(Byte value) {
			addCriterion("APARTMENT_IS_OPEN >", value, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenGreaterThanOrEqualTo(Byte value) {
			addCriterion("APARTMENT_IS_OPEN >=", value, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenLessThan(Byte value) {
			addCriterion("APARTMENT_IS_OPEN <", value, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenLessThanOrEqualTo(Byte value) {
			addCriterion("APARTMENT_IS_OPEN <=", value, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenIn(List<Byte> values) {
			addCriterion("APARTMENT_IS_OPEN in", values, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenNotIn(List<Byte> values) {
			addCriterion("APARTMENT_IS_OPEN not in", values, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenBetween(Byte value1, Byte value2) {
			addCriterion("APARTMENT_IS_OPEN between", value1, value2, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andApartmentIsOpenNotBetween(Byte value1, Byte value2) {
			addCriterion("APARTMENT_IS_OPEN not between", value1, value2, "apartmentIsOpen");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cIsNull() {
			addCriterion("BUILD_ASSESS_FLAG_4C is null");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cIsNotNull() {
			addCriterion("BUILD_ASSESS_FLAG_4C is not null");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG_4C =", value, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cNotEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG_4C <>", value, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cGreaterThan(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG_4C >", value, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG_4C >=", value, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cLessThan(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG_4C <", value, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cLessThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ASSESS_FLAG_4C <=", value, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cIn(List<Byte> values) {
			addCriterion("BUILD_ASSESS_FLAG_4C in", values, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cNotIn(List<Byte> values) {
			addCriterion("BUILD_ASSESS_FLAG_4C not in", values, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ASSESS_FLAG_4C between", value1, value2, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andBuildAssessFlag4cNotBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ASSESS_FLAG_4C not between", value1, value2, "buildAssessFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cIsNull() {
			addCriterion("APARTMENT_FLAG_4C is null");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cIsNotNull() {
			addCriterion("APARTMENT_FLAG_4C is not null");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cEqualTo(Byte value) {
			addCriterion("APARTMENT_FLAG_4C =", value, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cNotEqualTo(Byte value) {
			addCriterion("APARTMENT_FLAG_4C <>", value, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cGreaterThan(Byte value) {
			addCriterion("APARTMENT_FLAG_4C >", value, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cGreaterThanOrEqualTo(Byte value) {
			addCriterion("APARTMENT_FLAG_4C >=", value, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cLessThan(Byte value) {
			addCriterion("APARTMENT_FLAG_4C <", value, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cLessThanOrEqualTo(Byte value) {
			addCriterion("APARTMENT_FLAG_4C <=", value, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cIn(List<Byte> values) {
			addCriterion("APARTMENT_FLAG_4C in", values, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cNotIn(List<Byte> values) {
			addCriterion("APARTMENT_FLAG_4C not in", values, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cBetween(Byte value1, Byte value2) {
			addCriterion("APARTMENT_FLAG_4C between", value1, value2, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andApartmentFlag4cNotBetween(Byte value1, Byte value2) {
			addCriterion("APARTMENT_FLAG_4C not between", value1, value2, "apartmentFlag4c");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagIsNull() {
			addCriterion("INVOICE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagIsNotNull() {
			addCriterion("INVOICE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagEqualTo(Byte value) {
			addCriterion("INVOICE_FLAG =", value, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagNotEqualTo(Byte value) {
			addCriterion("INVOICE_FLAG <>", value, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagGreaterThan(Byte value) {
			addCriterion("INVOICE_FLAG >", value, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("INVOICE_FLAG >=", value, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagLessThan(Byte value) {
			addCriterion("INVOICE_FLAG <", value, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagLessThanOrEqualTo(Byte value) {
			addCriterion("INVOICE_FLAG <=", value, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagIn(List<Byte> values) {
			addCriterion("INVOICE_FLAG in", values, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagNotIn(List<Byte> values) {
			addCriterion("INVOICE_FLAG not in", values, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagBetween(Byte value1, Byte value2) {
			addCriterion("INVOICE_FLAG between", value1, value2, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andInvoiceFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("INVOICE_FLAG not between", value1, value2, "invoiceFlag");
			return (Criteria) this;
		}

		public Criteria andIsCapitalIsNull() {
			addCriterion("IS_CAPITAL is null");
			return (Criteria) this;
		}

		public Criteria andIsCapitalIsNotNull() {
			addCriterion("IS_CAPITAL is not null");
			return (Criteria) this;
		}

		public Criteria andIsCapitalEqualTo(Byte value) {
			addCriterion("IS_CAPITAL =", value, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalNotEqualTo(Byte value) {
			addCriterion("IS_CAPITAL <>", value, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalGreaterThan(Byte value) {
			addCriterion("IS_CAPITAL >", value, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_CAPITAL >=", value, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalLessThan(Byte value) {
			addCriterion("IS_CAPITAL <", value, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalLessThanOrEqualTo(Byte value) {
			addCriterion("IS_CAPITAL <=", value, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalIn(List<Byte> values) {
			addCriterion("IS_CAPITAL in", values, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalNotIn(List<Byte> values) {
			addCriterion("IS_CAPITAL not in", values, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalBetween(Byte value1, Byte value2) {
			addCriterion("IS_CAPITAL between", value1, value2, "isCapital");
			return (Criteria) this;
		}

		public Criteria andIsCapitalNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_CAPITAL not between", value1, value2, "isCapital");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishIsNull() {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH is null");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishIsNotNull() {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH is not null");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishEqualTo(Byte value) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH =", value, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishNotEqualTo(Byte value) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH <>", value, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishGreaterThan(Byte value) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH >", value, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH >=", value, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishLessThan(Byte value) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH <", value, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH <=", value, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishIn(List<Byte> values) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH in", values, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishNotIn(List<Byte> values) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH not in", values, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH between", value1, value2, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSalecheckcodeOnpublishNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_SALECHECKCODE_ONPUBLISH not between", value1, value2, "checkSalecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishIsNull() {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH is null");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishIsNotNull() {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH is not null");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishEqualTo(Byte value) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH =", value, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishNotEqualTo(Byte value) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH <>", value, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishGreaterThan(Byte value) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH >", value, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH >=", value, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishLessThan(Byte value) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH <", value, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH <=", value, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishIn(List<Byte> values) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH in", values, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishNotIn(List<Byte> values) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH not in", values, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH between", value1, value2, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeasecheckcodeOnpublishNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_LEASECHECKCODE_ONPUBLISH not between", value1, value2, "checkLeasecheckcodeOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishIsNull() {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH is null");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishIsNotNull() {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH is not null");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishEqualTo(Byte value) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH =", value, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishNotEqualTo(Byte value) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH <>", value, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishGreaterThan(Byte value) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH >", value, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH >=", value, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishLessThan(Byte value) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH <", value, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH <=", value, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishIn(List<Byte> values) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH in", values, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishNotIn(List<Byte> values) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH not in", values, "checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH between", value1, value2,
					"checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckSaleeffectivedateOnpublishNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_SALEEFFECTIVEDATE_ONPUBLISH not between", value1, value2,
					"checkSaleeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishIsNull() {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH is null");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishIsNotNull() {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH is not null");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishEqualTo(Byte value) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH =", value, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishNotEqualTo(Byte value) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH <>", value, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishGreaterThan(Byte value) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH >", value, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH >=", value, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishLessThan(Byte value) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH <", value, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH <=", value, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishIn(List<Byte> values) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH in", values, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishNotIn(List<Byte> values) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH not in", values, "checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH between", value1, value2,
					"checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andCheckLeaseeffectivedateOnpublishNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH not between", value1, value2,
					"checkLeaseeffectivedateOnpublish");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusIsNull() {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS is null");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusIsNotNull() {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS is not null");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusEqualTo(Byte value) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS =", value, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusNotEqualTo(Byte value) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS <>", value, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusGreaterThan(Byte value) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS >", value, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS >=", value, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusLessThan(Byte value) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS <", value, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusLessThanOrEqualTo(Byte value) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS <=", value, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusIn(List<Byte> values) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS in", values, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusNotIn(List<Byte> values) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS not in", values, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusBetween(Byte value1, Byte value2) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS between", value1, value2, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andShowFunmanagerSalestatusNotBetween(Byte value1, Byte value2) {
			addCriterion("SHOW_FUNMANAGER_SALESTATUS not between", value1, value2, "showFunmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andChanceIsNull() {
			addCriterion("CHANCE is null");
			return (Criteria) this;
		}

		public Criteria andChanceIsNotNull() {
			addCriterion("CHANCE is not null");
			return (Criteria) this;
		}

		public Criteria andChanceEqualTo(Byte value) {
			addCriterion("CHANCE =", value, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceNotEqualTo(Byte value) {
			addCriterion("CHANCE <>", value, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceGreaterThan(Byte value) {
			addCriterion("CHANCE >", value, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHANCE >=", value, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceLessThan(Byte value) {
			addCriterion("CHANCE <", value, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceLessThanOrEqualTo(Byte value) {
			addCriterion("CHANCE <=", value, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceIn(List<Byte> values) {
			addCriterion("CHANCE in", values, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceNotIn(List<Byte> values) {
			addCriterion("CHANCE not in", values, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceBetween(Byte value1, Byte value2) {
			addCriterion("CHANCE between", value1, value2, "chance");
			return (Criteria) this;
		}

		public Criteria andChanceNotBetween(Byte value1, Byte value2) {
			addCriterion("CHANCE not between", value1, value2, "chance");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeIsNull() {
			addCriterion("PLATFORM_FEE is null");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeIsNotNull() {
			addCriterion("PLATFORM_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeEqualTo(BigDecimal value) {
			addCriterion("PLATFORM_FEE =", value, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeNotEqualTo(BigDecimal value) {
			addCriterion("PLATFORM_FEE <>", value, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeGreaterThan(BigDecimal value) {
			addCriterion("PLATFORM_FEE >", value, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PLATFORM_FEE >=", value, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeLessThan(BigDecimal value) {
			addCriterion("PLATFORM_FEE <", value, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PLATFORM_FEE <=", value, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeIn(List<BigDecimal> values) {
			addCriterion("PLATFORM_FEE in", values, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeNotIn(List<BigDecimal> values) {
			addCriterion("PLATFORM_FEE not in", values, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PLATFORM_FEE between", value1, value2, "platformFee");
			return (Criteria) this;
		}

		public Criteria andPlatformFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PLATFORM_FEE not between", value1, value2, "platformFee");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagIsNull() {
			addCriterion("PROFIT_BASEPRO_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagIsNotNull() {
			addCriterion("PROFIT_BASEPRO_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagEqualTo(Byte value) {
			addCriterion("PROFIT_BASEPRO_FLAG =", value, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagNotEqualTo(Byte value) {
			addCriterion("PROFIT_BASEPRO_FLAG <>", value, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagGreaterThan(Byte value) {
			addCriterion("PROFIT_BASEPRO_FLAG >", value, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("PROFIT_BASEPRO_FLAG >=", value, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagLessThan(Byte value) {
			addCriterion("PROFIT_BASEPRO_FLAG <", value, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagLessThanOrEqualTo(Byte value) {
			addCriterion("PROFIT_BASEPRO_FLAG <=", value, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagIn(List<Byte> values) {
			addCriterion("PROFIT_BASEPRO_FLAG in", values, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagNotIn(List<Byte> values) {
			addCriterion("PROFIT_BASEPRO_FLAG not in", values, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagBetween(Byte value1, Byte value2) {
			addCriterion("PROFIT_BASEPRO_FLAG between", value1, value2, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andProfitBaseproFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("PROFIT_BASEPRO_FLAG not between", value1, value2, "profitBaseproFlag");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiIsNull() {
			addCriterion("OPEN_HUABEI is null");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiIsNotNull() {
			addCriterion("OPEN_HUABEI is not null");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiEqualTo(Byte value) {
			addCriterion("OPEN_HUABEI =", value, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiNotEqualTo(Byte value) {
			addCriterion("OPEN_HUABEI <>", value, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiGreaterThan(Byte value) {
			addCriterion("OPEN_HUABEI >", value, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_HUABEI >=", value, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiLessThan(Byte value) {
			addCriterion("OPEN_HUABEI <", value, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_HUABEI <=", value, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiIn(List<Byte> values) {
			addCriterion("OPEN_HUABEI in", values, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiNotIn(List<Byte> values) {
			addCriterion("OPEN_HUABEI not in", values, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_HUABEI between", value1, value2, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andOpenHuabeiNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_HUABEI not between", value1, value2, "openHuabei");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneIsNull() {
			addCriterion("FAFA_THREE_IN_ONE is null");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneIsNotNull() {
			addCriterion("FAFA_THREE_IN_ONE is not null");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneEqualTo(Byte value) {
			addCriterion("FAFA_THREE_IN_ONE =", value, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneNotEqualTo(Byte value) {
			addCriterion("FAFA_THREE_IN_ONE <>", value, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneGreaterThan(Byte value) {
			addCriterion("FAFA_THREE_IN_ONE >", value, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneGreaterThanOrEqualTo(Byte value) {
			addCriterion("FAFA_THREE_IN_ONE >=", value, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneLessThan(Byte value) {
			addCriterion("FAFA_THREE_IN_ONE <", value, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneLessThanOrEqualTo(Byte value) {
			addCriterion("FAFA_THREE_IN_ONE <=", value, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneIn(List<Byte> values) {
			addCriterion("FAFA_THREE_IN_ONE in", values, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneNotIn(List<Byte> values) {
			addCriterion("FAFA_THREE_IN_ONE not in", values, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneBetween(Byte value1, Byte value2) {
			addCriterion("FAFA_THREE_IN_ONE between", value1, value2, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andFafaThreeInOneNotBetween(Byte value1, Byte value2) {
			addCriterion("FAFA_THREE_IN_ONE not between", value1, value2, "fafaThreeInOne");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagIsNull() {
			addCriterion("OPEN_DY_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagIsNotNull() {
			addCriterion("OPEN_DY_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagEqualTo(Byte value) {
			addCriterion("OPEN_DY_FLAG =", value, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagNotEqualTo(Byte value) {
			addCriterion("OPEN_DY_FLAG <>", value, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagGreaterThan(Byte value) {
			addCriterion("OPEN_DY_FLAG >", value, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_DY_FLAG >=", value, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagLessThan(Byte value) {
			addCriterion("OPEN_DY_FLAG <", value, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_DY_FLAG <=", value, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagIn(List<Byte> values) {
			addCriterion("OPEN_DY_FLAG in", values, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagNotIn(List<Byte> values) {
			addCriterion("OPEN_DY_FLAG not in", values, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_DY_FLAG between", value1, value2, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andOpenDyFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_DY_FLAG not between", value1, value2, "openDyFlag");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipIsNull() {
			addCriterion("CITY_LEVEL_VIP is null");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipIsNotNull() {
			addCriterion("CITY_LEVEL_VIP is not null");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipEqualTo(Integer value) {
			addCriterion("CITY_LEVEL_VIP =", value, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipNotEqualTo(Integer value) {
			addCriterion("CITY_LEVEL_VIP <>", value, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipGreaterThan(Integer value) {
			addCriterion("CITY_LEVEL_VIP >", value, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipGreaterThanOrEqualTo(Integer value) {
			addCriterion("CITY_LEVEL_VIP >=", value, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipLessThan(Integer value) {
			addCriterion("CITY_LEVEL_VIP <", value, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipLessThanOrEqualTo(Integer value) {
			addCriterion("CITY_LEVEL_VIP <=", value, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipIn(List<Integer> values) {
			addCriterion("CITY_LEVEL_VIP in", values, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipNotIn(List<Integer> values) {
			addCriterion("CITY_LEVEL_VIP not in", values, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipBetween(Integer value1, Integer value2) {
			addCriterion("CITY_LEVEL_VIP between", value1, value2, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andCityLevelVipNotBetween(Integer value1, Integer value2) {
			addCriterion("CITY_LEVEL_VIP not between", value1, value2, "cityLevelVip");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleIsNull() {
			addCriterion("ENTRUST_SALE is null");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleIsNotNull() {
			addCriterion("ENTRUST_SALE is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleEqualTo(Integer value) {
			addCriterion("ENTRUST_SALE =", value, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleNotEqualTo(Integer value) {
			addCriterion("ENTRUST_SALE <>", value, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleGreaterThan(Integer value) {
			addCriterion("ENTRUST_SALE >", value, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleGreaterThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_SALE >=", value, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleLessThan(Integer value) {
			addCriterion("ENTRUST_SALE <", value, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleLessThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_SALE <=", value, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleIn(List<Integer> values) {
			addCriterion("ENTRUST_SALE in", values, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleNotIn(List<Integer> values) {
			addCriterion("ENTRUST_SALE not in", values, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_SALE between", value1, value2, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustSaleNotBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_SALE not between", value1, value2, "entrustSale");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseIsNull() {
			addCriterion("ENTRUST_LEASE is null");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseIsNotNull() {
			addCriterion("ENTRUST_LEASE is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseEqualTo(Integer value) {
			addCriterion("ENTRUST_LEASE =", value, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseNotEqualTo(Integer value) {
			addCriterion("ENTRUST_LEASE <>", value, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseGreaterThan(Integer value) {
			addCriterion("ENTRUST_LEASE >", value, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseGreaterThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_LEASE >=", value, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseLessThan(Integer value) {
			addCriterion("ENTRUST_LEASE <", value, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseLessThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_LEASE <=", value, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseIn(List<Integer> values) {
			addCriterion("ENTRUST_LEASE in", values, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseNotIn(List<Integer> values) {
			addCriterion("ENTRUST_LEASE not in", values, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_LEASE between", value1, value2, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andEntrustLeaseNotBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_LEASE not between", value1, value2, "entrustLease");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathIsNull() {
			addCriterion("YOU_DIAN_LOGO_PATH is null");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathIsNotNull() {
			addCriterion("YOU_DIAN_LOGO_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathEqualTo(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH =", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathNotEqualTo(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH <>", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathGreaterThan(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH >", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathGreaterThanOrEqualTo(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH >=", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathLessThan(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH <", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathLessThanOrEqualTo(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH <=", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathLike(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH like", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathNotLike(String value) {
			addCriterion("YOU_DIAN_LOGO_PATH not like", value, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathIn(List<String> values) {
			addCriterion("YOU_DIAN_LOGO_PATH in", values, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathNotIn(List<String> values) {
			addCriterion("YOU_DIAN_LOGO_PATH not in", values, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathBetween(String value1, String value2) {
			addCriterion("YOU_DIAN_LOGO_PATH between", value1, value2, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andYouDianLogoPathNotBetween(String value1, String value2) {
			addCriterion("YOU_DIAN_LOGO_PATH not between", value1, value2, "youDianLogoPath");
			return (Criteria) this;
		}

		public Criteria andOpenMetroIsNull() {
			addCriterion("OPEN_METRO is null");
			return (Criteria) this;
		}

		public Criteria andOpenMetroIsNotNull() {
			addCriterion("OPEN_METRO is not null");
			return (Criteria) this;
		}

		public Criteria andOpenMetroEqualTo(Byte value) {
			addCriterion("OPEN_METRO =", value, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroNotEqualTo(Byte value) {
			addCriterion("OPEN_METRO <>", value, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroGreaterThan(Byte value) {
			addCriterion("OPEN_METRO >", value, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_METRO >=", value, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroLessThan(Byte value) {
			addCriterion("OPEN_METRO <", value, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_METRO <=", value, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroIn(List<Byte> values) {
			addCriterion("OPEN_METRO in", values, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroNotIn(List<Byte> values) {
			addCriterion("OPEN_METRO not in", values, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_METRO between", value1, value2, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenMetroNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_METRO not between", value1, value2, "openMetro");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseIsNull() {
			addCriterion("OPEN_ALI_RENT_HOUSE is null");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseIsNotNull() {
			addCriterion("OPEN_ALI_RENT_HOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseEqualTo(Byte value) {
			addCriterion("OPEN_ALI_RENT_HOUSE =", value, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseNotEqualTo(Byte value) {
			addCriterion("OPEN_ALI_RENT_HOUSE <>", value, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseGreaterThan(Byte value) {
			addCriterion("OPEN_ALI_RENT_HOUSE >", value, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_ALI_RENT_HOUSE >=", value, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseLessThan(Byte value) {
			addCriterion("OPEN_ALI_RENT_HOUSE <", value, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_ALI_RENT_HOUSE <=", value, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseIn(List<Byte> values) {
			addCriterion("OPEN_ALI_RENT_HOUSE in", values, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseNotIn(List<Byte> values) {
			addCriterion("OPEN_ALI_RENT_HOUSE not in", values, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_ALI_RENT_HOUSE between", value1, value2, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andOpenAliRentHouseNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_ALI_RENT_HOUSE not between", value1, value2, "openAliRentHouse");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeIsNull() {
			addCriterion("RIGHT_CALL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeIsNotNull() {
			addCriterion("RIGHT_CALL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeEqualTo(Byte value) {
			addCriterion("RIGHT_CALL_TYPE =", value, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeNotEqualTo(Byte value) {
			addCriterion("RIGHT_CALL_TYPE <>", value, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeGreaterThan(Byte value) {
			addCriterion("RIGHT_CALL_TYPE >", value, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("RIGHT_CALL_TYPE >=", value, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeLessThan(Byte value) {
			addCriterion("RIGHT_CALL_TYPE <", value, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeLessThanOrEqualTo(Byte value) {
			addCriterion("RIGHT_CALL_TYPE <=", value, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeIn(List<Byte> values) {
			addCriterion("RIGHT_CALL_TYPE in", values, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeNotIn(List<Byte> values) {
			addCriterion("RIGHT_CALL_TYPE not in", values, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeBetween(Byte value1, Byte value2) {
			addCriterion("RIGHT_CALL_TYPE between", value1, value2, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andRightCallTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("RIGHT_CALL_TYPE not between", value1, value2, "rightCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeIsNull() {
			addCriterion("WUYE_CALL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeIsNotNull() {
			addCriterion("WUYE_CALL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeEqualTo(Byte value) {
			addCriterion("WUYE_CALL_TYPE =", value, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeNotEqualTo(Byte value) {
			addCriterion("WUYE_CALL_TYPE <>", value, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeGreaterThan(Byte value) {
			addCriterion("WUYE_CALL_TYPE >", value, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("WUYE_CALL_TYPE >=", value, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeLessThan(Byte value) {
			addCriterion("WUYE_CALL_TYPE <", value, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeLessThanOrEqualTo(Byte value) {
			addCriterion("WUYE_CALL_TYPE <=", value, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeIn(List<Byte> values) {
			addCriterion("WUYE_CALL_TYPE in", values, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeNotIn(List<Byte> values) {
			addCriterion("WUYE_CALL_TYPE not in", values, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeBetween(Byte value1, Byte value2) {
			addCriterion("WUYE_CALL_TYPE between", value1, value2, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andWuyeCallTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("WUYE_CALL_TYPE not between", value1, value2, "wuyeCallType");
			return (Criteria) this;
		}

		public Criteria andCountryIdIsNull() {
			addCriterion("COUNTRY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCountryIdIsNotNull() {
			addCriterion("COUNTRY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCountryIdEqualTo(Integer value) {
			addCriterion("COUNTRY_ID =", value, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdNotEqualTo(Integer value) {
			addCriterion("COUNTRY_ID <>", value, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdGreaterThan(Integer value) {
			addCriterion("COUNTRY_ID >", value, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COUNTRY_ID >=", value, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdLessThan(Integer value) {
			addCriterion("COUNTRY_ID <", value, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdLessThanOrEqualTo(Integer value) {
			addCriterion("COUNTRY_ID <=", value, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdIn(List<Integer> values) {
			addCriterion("COUNTRY_ID in", values, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdNotIn(List<Integer> values) {
			addCriterion("COUNTRY_ID not in", values, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdBetween(Integer value1, Integer value2) {
			addCriterion("COUNTRY_ID between", value1, value2, "countryId");
			return (Criteria) this;
		}

		public Criteria andCountryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COUNTRY_ID not between", value1, value2, "countryId");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionIsNull() {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION is null");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionIsNotNull() {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionEqualTo(Byte value) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION =", value, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionNotEqualTo(Byte value) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION <>", value, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionGreaterThan(Byte value) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION >", value, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION >=", value, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionLessThan(Byte value) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION <", value, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionLessThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION <=", value, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionIn(List<Byte> values) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION in", values, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionNotIn(List<Byte> values) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION not in", values, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION between", value1, value2, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andEntrustHouseInstructionNotBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_HOUSE_INSTRUCTION not between", value1, value2, "entrustHouseInstruction");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateIsNull() {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE is null");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateIsNotNull() {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateEqualTo(BigDecimal value) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE =", value, "portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateNotEqualTo(BigDecimal value) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE <>", value, "portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateGreaterThan(BigDecimal value) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE >", value, "portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE >=", value, "portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateLessThan(BigDecimal value) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE <", value, "portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE <=", value, "portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateIn(List<BigDecimal> values) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE in", values, "portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateNotIn(List<BigDecimal> values) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE not in", values,
					"portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE between", value1, value2,
					"portentialPerformanceCommissionRate");
			return (Criteria) this;
		}

		public Criteria andPortentialPerformanceCommissionRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PORTENTIAL_PERFORMANCE_COMMISSION_RATE not between", value1, value2,
					"portentialPerformanceCommissionRate");
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