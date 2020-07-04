package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunEntrustExample extends ShardDb {
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
	public ErpFunEntrustExample() {
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

		public Criteria andEntrustIdIsNull() {
			addCriterion("ENTRUST_ID is null");
			return (Criteria) this;
		}

		public Criteria andEntrustIdIsNotNull() {
			addCriterion("ENTRUST_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustIdEqualTo(Integer value) {
			addCriterion("ENTRUST_ID =", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotEqualTo(Integer value) {
			addCriterion("ENTRUST_ID <>", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdGreaterThan(Integer value) {
			addCriterion("ENTRUST_ID >", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_ID >=", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdLessThan(Integer value) {
			addCriterion("ENTRUST_ID <", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdLessThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_ID <=", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdIn(List<Integer> values) {
			addCriterion("ENTRUST_ID in", values, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotIn(List<Integer> values) {
			addCriterion("ENTRUST_ID not in", values, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_ID between", value1, value2, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_ID not between", value1, value2, "entrustId");
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

		public Criteria andEntrustBusinessIsNull() {
			addCriterion("ENTRUST_BUSINESS is null");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessIsNotNull() {
			addCriterion("ENTRUST_BUSINESS is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessEqualTo(Byte value) {
			addCriterion("ENTRUST_BUSINESS =", value, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessNotEqualTo(Byte value) {
			addCriterion("ENTRUST_BUSINESS <>", value, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessGreaterThan(Byte value) {
			addCriterion("ENTRUST_BUSINESS >", value, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_BUSINESS >=", value, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessLessThan(Byte value) {
			addCriterion("ENTRUST_BUSINESS <", value, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessLessThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_BUSINESS <=", value, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessIn(List<Byte> values) {
			addCriterion("ENTRUST_BUSINESS in", values, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessNotIn(List<Byte> values) {
			addCriterion("ENTRUST_BUSINESS not in", values, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_BUSINESS between", value1, value2, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andEntrustBusinessNotBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_BUSINESS not between", value1, value2, "entrustBusiness");
			return (Criteria) this;
		}

		public Criteria andHouseAddrIsNull() {
			addCriterion("HOUSE_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andHouseAddrIsNotNull() {
			addCriterion("HOUSE_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAddrEqualTo(String value) {
			addCriterion("HOUSE_ADDR =", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrNotEqualTo(String value) {
			addCriterion("HOUSE_ADDR <>", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrGreaterThan(String value) {
			addCriterion("HOUSE_ADDR >", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_ADDR >=", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrLessThan(String value) {
			addCriterion("HOUSE_ADDR <", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_ADDR <=", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrLike(String value) {
			addCriterion("HOUSE_ADDR like", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrNotLike(String value) {
			addCriterion("HOUSE_ADDR not like", value, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrIn(List<String> values) {
			addCriterion("HOUSE_ADDR in", values, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrNotIn(List<String> values) {
			addCriterion("HOUSE_ADDR not in", values, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrBetween(String value1, String value2) {
			addCriterion("HOUSE_ADDR between", value1, value2, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andHouseAddrNotBetween(String value1, String value2) {
			addCriterion("HOUSE_ADDR not between", value1, value2, "houseAddr");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeIsNull() {
			addCriterion("ENTRUST_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeIsNotNull() {
			addCriterion("ENTRUST_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeEqualTo(Byte value) {
			addCriterion("ENTRUST_TYPE =", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeNotEqualTo(Byte value) {
			addCriterion("ENTRUST_TYPE <>", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeGreaterThan(Byte value) {
			addCriterion("ENTRUST_TYPE >", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_TYPE >=", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeLessThan(Byte value) {
			addCriterion("ENTRUST_TYPE <", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_TYPE <=", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeIn(List<Byte> values) {
			addCriterion("ENTRUST_TYPE in", values, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeNotIn(List<Byte> values) {
			addCriterion("ENTRUST_TYPE not in", values, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_TYPE between", value1, value2, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_TYPE not between", value1, value2, "entrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustIsNull() {
			addCriterion("ELECTRONIC_ENTRUST is null");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustIsNotNull() {
			addCriterion("ELECTRONIC_ENTRUST is not null");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST =", value, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustNotEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST <>", value, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustGreaterThan(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST >", value, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustGreaterThanOrEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST >=", value, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustLessThan(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST <", value, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustLessThanOrEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST <=", value, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustIn(List<Byte> values) {
			addCriterion("ELECTRONIC_ENTRUST in", values, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustNotIn(List<Byte> values) {
			addCriterion("ELECTRONIC_ENTRUST not in", values, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustBetween(Byte value1, Byte value2) {
			addCriterion("ELECTRONIC_ENTRUST between", value1, value2, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustNotBetween(Byte value1, Byte value2) {
			addCriterion("ELECTRONIC_ENTRUST not between", value1, value2, "electronicEntrust");
			return (Criteria) this;
		}

		public Criteria andHouseStatusIsNull() {
			addCriterion("HOUSE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andHouseStatusIsNotNull() {
			addCriterion("HOUSE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andHouseStatusEqualTo(Byte value) {
			addCriterion("HOUSE_STATUS =", value, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusNotEqualTo(Byte value) {
			addCriterion("HOUSE_STATUS <>", value, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusGreaterThan(Byte value) {
			addCriterion("HOUSE_STATUS >", value, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_STATUS >=", value, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusLessThan(Byte value) {
			addCriterion("HOUSE_STATUS <", value, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_STATUS <=", value, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusIn(List<Byte> values) {
			addCriterion("HOUSE_STATUS in", values, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusNotIn(List<Byte> values) {
			addCriterion("HOUSE_STATUS not in", values, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_STATUS between", value1, value2, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andHouseStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_STATUS not between", value1, value2, "houseStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustNoIsNull() {
			addCriterion("ENTRUST_NO is null");
			return (Criteria) this;
		}

		public Criteria andEntrustNoIsNotNull() {
			addCriterion("ENTRUST_NO is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustNoEqualTo(String value) {
			addCriterion("ENTRUST_NO =", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoNotEqualTo(String value) {
			addCriterion("ENTRUST_NO <>", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoGreaterThan(String value) {
			addCriterion("ENTRUST_NO >", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoGreaterThanOrEqualTo(String value) {
			addCriterion("ENTRUST_NO >=", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoLessThan(String value) {
			addCriterion("ENTRUST_NO <", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoLessThanOrEqualTo(String value) {
			addCriterion("ENTRUST_NO <=", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoLike(String value) {
			addCriterion("ENTRUST_NO like", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoNotLike(String value) {
			addCriterion("ENTRUST_NO not like", value, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoIn(List<String> values) {
			addCriterion("ENTRUST_NO in", values, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoNotIn(List<String> values) {
			addCriterion("ENTRUST_NO not in", values, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoBetween(String value1, String value2) {
			addCriterion("ENTRUST_NO between", value1, value2, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustNoNotBetween(String value1, String value2) {
			addCriterion("ENTRUST_NO not between", value1, value2, "entrustNo");
			return (Criteria) this;
		}

		public Criteria andEntrustStartIsNull() {
			addCriterion("ENTRUST_START is null");
			return (Criteria) this;
		}

		public Criteria andEntrustStartIsNotNull() {
			addCriterion("ENTRUST_START is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustStartEqualTo(String value) {
			addCriterion("ENTRUST_START =", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartNotEqualTo(String value) {
			addCriterion("ENTRUST_START <>", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartGreaterThan(String value) {
			addCriterion("ENTRUST_START >", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartGreaterThanOrEqualTo(String value) {
			addCriterion("ENTRUST_START >=", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartLessThan(String value) {
			addCriterion("ENTRUST_START <", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartLessThanOrEqualTo(String value) {
			addCriterion("ENTRUST_START <=", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartLike(String value) {
			addCriterion("ENTRUST_START like", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartNotLike(String value) {
			addCriterion("ENTRUST_START not like", value, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartIn(List<String> values) {
			addCriterion("ENTRUST_START in", values, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartNotIn(List<String> values) {
			addCriterion("ENTRUST_START not in", values, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartBetween(String value1, String value2) {
			addCriterion("ENTRUST_START between", value1, value2, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustStartNotBetween(String value1, String value2) {
			addCriterion("ENTRUST_START not between", value1, value2, "entrustStart");
			return (Criteria) this;
		}

		public Criteria andEntrustEndIsNull() {
			addCriterion("ENTRUST_END is null");
			return (Criteria) this;
		}

		public Criteria andEntrustEndIsNotNull() {
			addCriterion("ENTRUST_END is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustEndEqualTo(String value) {
			addCriterion("ENTRUST_END =", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndNotEqualTo(String value) {
			addCriterion("ENTRUST_END <>", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndGreaterThan(String value) {
			addCriterion("ENTRUST_END >", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndGreaterThanOrEqualTo(String value) {
			addCriterion("ENTRUST_END >=", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndLessThan(String value) {
			addCriterion("ENTRUST_END <", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndLessThanOrEqualTo(String value) {
			addCriterion("ENTRUST_END <=", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndLike(String value) {
			addCriterion("ENTRUST_END like", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndNotLike(String value) {
			addCriterion("ENTRUST_END not like", value, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndIn(List<String> values) {
			addCriterion("ENTRUST_END in", values, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndNotIn(List<String> values) {
			addCriterion("ENTRUST_END not in", values, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndBetween(String value1, String value2) {
			addCriterion("ENTRUST_END between", value1, value2, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andEntrustEndNotBetween(String value1, String value2) {
			addCriterion("ENTRUST_END not between", value1, value2, "entrustEnd");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeIsNull() {
			addCriterion("ELECTRONIC_ENTRUST_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeIsNotNull() {
			addCriterion("ELECTRONIC_ENTRUST_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE =", value, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeNotEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE <>", value, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeGreaterThan(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE >", value, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE >=", value, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeLessThan(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE <", value, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE <=", value, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeIn(List<Byte> values) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE in", values, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeNotIn(List<Byte> values) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE not in", values, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeBetween(Byte value1, Byte value2) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE between", value1, value2, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andElectronicEntrustTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ELECTRONIC_ENTRUST_TYPE not between", value1, value2, "electronicEntrustType");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomIsNull() {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM is null");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomIsNotNull() {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM is not null");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM =", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomNotEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM <>", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomGreaterThan(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM >", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomGreaterThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM >=", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomLessThan(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM <", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomLessThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM <=", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomLike(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM like", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomNotLike(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM not like", value, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomIn(List<String> values) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM in", values, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomNotIn(List<String> values) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM not in", values, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomBetween(String value1, String value2) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM between", value1, value2, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomNotBetween(String value1, String value2) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM not between", value1, value2, "depositFileForCustom");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeIsNull() {
			addCriterion("INSPECTION_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeIsNotNull() {
			addCriterion("INSPECTION_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeEqualTo(Byte value) {
			addCriterion("INSPECTION_TYPE =", value, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeNotEqualTo(Byte value) {
			addCriterion("INSPECTION_TYPE <>", value, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeGreaterThan(Byte value) {
			addCriterion("INSPECTION_TYPE >", value, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("INSPECTION_TYPE >=", value, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeLessThan(Byte value) {
			addCriterion("INSPECTION_TYPE <", value, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeLessThanOrEqualTo(Byte value) {
			addCriterion("INSPECTION_TYPE <=", value, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeIn(List<Byte> values) {
			addCriterion("INSPECTION_TYPE in", values, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeNotIn(List<Byte> values) {
			addCriterion("INSPECTION_TYPE not in", values, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeBetween(Byte value1, Byte value2) {
			addCriterion("INSPECTION_TYPE between", value1, value2, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andInspectionTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("INSPECTION_TYPE not between", value1, value2, "inspectionType");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionIsNull() {
			addCriterion("SALE_COMMISSION is null");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionIsNotNull() {
			addCriterion("SALE_COMMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionEqualTo(BigDecimal value) {
			addCriterion("SALE_COMMISSION =", value, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionNotEqualTo(BigDecimal value) {
			addCriterion("SALE_COMMISSION <>", value, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionGreaterThan(BigDecimal value) {
			addCriterion("SALE_COMMISSION >", value, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_COMMISSION >=", value, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionLessThan(BigDecimal value) {
			addCriterion("SALE_COMMISSION <", value, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_COMMISSION <=", value, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionIn(List<BigDecimal> values) {
			addCriterion("SALE_COMMISSION in", values, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionNotIn(List<BigDecimal> values) {
			addCriterion("SALE_COMMISSION not in", values, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_COMMISSION between", value1, value2, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andSaleCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_COMMISSION not between", value1, value2, "saleCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionIsNull() {
			addCriterion("LEASE_COMMISSION is null");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionIsNotNull() {
			addCriterion("LEASE_COMMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionEqualTo(BigDecimal value) {
			addCriterion("LEASE_COMMISSION =", value, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_COMMISSION <>", value, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionGreaterThan(BigDecimal value) {
			addCriterion("LEASE_COMMISSION >", value, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_COMMISSION >=", value, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionLessThan(BigDecimal value) {
			addCriterion("LEASE_COMMISSION <", value, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_COMMISSION <=", value, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionIn(List<BigDecimal> values) {
			addCriterion("LEASE_COMMISSION in", values, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_COMMISSION not in", values, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_COMMISSION between", value1, value2, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andLeaseCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_COMMISSION not between", value1, value2, "leaseCommission");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractIsNull() {
			addCriterion("HAS_LEASE_CONTRACT is null");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractIsNotNull() {
			addCriterion("HAS_LEASE_CONTRACT is not null");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractEqualTo(Byte value) {
			addCriterion("HAS_LEASE_CONTRACT =", value, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractNotEqualTo(Byte value) {
			addCriterion("HAS_LEASE_CONTRACT <>", value, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractGreaterThan(Byte value) {
			addCriterion("HAS_LEASE_CONTRACT >", value, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_LEASE_CONTRACT >=", value, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractLessThan(Byte value) {
			addCriterion("HAS_LEASE_CONTRACT <", value, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_LEASE_CONTRACT <=", value, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractIn(List<Byte> values) {
			addCriterion("HAS_LEASE_CONTRACT in", values, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractNotIn(List<Byte> values) {
			addCriterion("HAS_LEASE_CONTRACT not in", values, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractBetween(Byte value1, Byte value2) {
			addCriterion("HAS_LEASE_CONTRACT between", value1, value2, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andHasLeaseContractNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_LEASE_CONTRACT not between", value1, value2, "hasLeaseContract");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeIsNull() {
			addCriterion("LEASE_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeIsNotNull() {
			addCriterion("LEASE_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeEqualTo(Date value) {
			addCriterion("LEASE_END_TIME =", value, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeNotEqualTo(Date value) {
			addCriterion("LEASE_END_TIME <>", value, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeGreaterThan(Date value) {
			addCriterion("LEASE_END_TIME >", value, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LEASE_END_TIME >=", value, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeLessThan(Date value) {
			addCriterion("LEASE_END_TIME <", value, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("LEASE_END_TIME <=", value, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeIn(List<Date> values) {
			addCriterion("LEASE_END_TIME in", values, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeNotIn(List<Date> values) {
			addCriterion("LEASE_END_TIME not in", values, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeBetween(Date value1, Date value2) {
			addCriterion("LEASE_END_TIME between", value1, value2, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andLeaseEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("LEASE_END_TIME not between", value1, value2, "leaseEndTime");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyIsNull() {
			addCriterion("OLD_RENT_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyIsNotNull() {
			addCriterion("OLD_RENT_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyEqualTo(BigDecimal value) {
			addCriterion("OLD_RENT_MONEY =", value, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyNotEqualTo(BigDecimal value) {
			addCriterion("OLD_RENT_MONEY <>", value, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyGreaterThan(BigDecimal value) {
			addCriterion("OLD_RENT_MONEY >", value, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("OLD_RENT_MONEY >=", value, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyLessThan(BigDecimal value) {
			addCriterion("OLD_RENT_MONEY <", value, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("OLD_RENT_MONEY <=", value, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyIn(List<BigDecimal> values) {
			addCriterion("OLD_RENT_MONEY in", values, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyNotIn(List<BigDecimal> values) {
			addCriterion("OLD_RENT_MONEY not in", values, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OLD_RENT_MONEY between", value1, value2, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andOldRentMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OLD_RENT_MONEY not between", value1, value2, "oldRentMoney");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveIsNull() {
			addCriterion("IS_EFFECTIVE is null");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveIsNotNull() {
			addCriterion("IS_EFFECTIVE is not null");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveEqualTo(Byte value) {
			addCriterion("IS_EFFECTIVE =", value, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveNotEqualTo(Byte value) {
			addCriterion("IS_EFFECTIVE <>", value, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveGreaterThan(Byte value) {
			addCriterion("IS_EFFECTIVE >", value, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_EFFECTIVE >=", value, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveLessThan(Byte value) {
			addCriterion("IS_EFFECTIVE <", value, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveLessThanOrEqualTo(Byte value) {
			addCriterion("IS_EFFECTIVE <=", value, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveIn(List<Byte> values) {
			addCriterion("IS_EFFECTIVE in", values, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveNotIn(List<Byte> values) {
			addCriterion("IS_EFFECTIVE not in", values, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveBetween(Byte value1, Byte value2) {
			addCriterion("IS_EFFECTIVE between", value1, value2, "isEffective");
			return (Criteria) this;
		}

		public Criteria andIsEffectiveNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_EFFECTIVE not between", value1, value2, "isEffective");
			return (Criteria) this;
		}

		public Criteria andSignStatusIsNull() {
			addCriterion("SIGN_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andSignStatusIsNotNull() {
			addCriterion("SIGN_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andSignStatusEqualTo(Byte value) {
			addCriterion("SIGN_STATUS =", value, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusNotEqualTo(Byte value) {
			addCriterion("SIGN_STATUS <>", value, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusGreaterThan(Byte value) {
			addCriterion("SIGN_STATUS >", value, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("SIGN_STATUS >=", value, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusLessThan(Byte value) {
			addCriterion("SIGN_STATUS <", value, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusLessThanOrEqualTo(Byte value) {
			addCriterion("SIGN_STATUS <=", value, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusIn(List<Byte> values) {
			addCriterion("SIGN_STATUS in", values, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusNotIn(List<Byte> values) {
			addCriterion("SIGN_STATUS not in", values, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusBetween(Byte value1, Byte value2) {
			addCriterion("SIGN_STATUS between", value1, value2, "signStatus");
			return (Criteria) this;
		}

		public Criteria andSignStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("SIGN_STATUS not between", value1, value2, "signStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNull() {
			addCriterion("AUDIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNotNull() {
			addCriterion("AUDIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS =", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS <>", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThan(Byte value) {
			addCriterion("AUDIT_STATUS >", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS >=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThan(Byte value) {
			addCriterion("AUDIT_STATUS <", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS <=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIn(List<Byte> values) {
			addCriterion("AUDIT_STATUS in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotIn(List<Byte> values) {
			addCriterion("AUDIT_STATUS not in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_STATUS between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_STATUS not between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andIncalidDateIsNull() {
			addCriterion("INCALID_DATE is null");
			return (Criteria) this;
		}

		public Criteria andIncalidDateIsNotNull() {
			addCriterion("INCALID_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andIncalidDateEqualTo(Date value) {
			addCriterion("INCALID_DATE =", value, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateNotEqualTo(Date value) {
			addCriterion("INCALID_DATE <>", value, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateGreaterThan(Date value) {
			addCriterion("INCALID_DATE >", value, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateGreaterThanOrEqualTo(Date value) {
			addCriterion("INCALID_DATE >=", value, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateLessThan(Date value) {
			addCriterion("INCALID_DATE <", value, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateLessThanOrEqualTo(Date value) {
			addCriterion("INCALID_DATE <=", value, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateIn(List<Date> values) {
			addCriterion("INCALID_DATE in", values, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateNotIn(List<Date> values) {
			addCriterion("INCALID_DATE not in", values, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateBetween(Date value1, Date value2) {
			addCriterion("INCALID_DATE between", value1, value2, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andIncalidDateNotBetween(Date value1, Date value2) {
			addCriterion("INCALID_DATE not between", value1, value2, "incalidDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateIsNull() {
			addCriterion("SIGN_FINASH_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateIsNotNull() {
			addCriterion("SIGN_FINASH_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateEqualTo(Date value) {
			addCriterion("SIGN_FINASH_DATE =", value, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateNotEqualTo(Date value) {
			addCriterion("SIGN_FINASH_DATE <>", value, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateGreaterThan(Date value) {
			addCriterion("SIGN_FINASH_DATE >", value, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateGreaterThanOrEqualTo(Date value) {
			addCriterion("SIGN_FINASH_DATE >=", value, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateLessThan(Date value) {
			addCriterion("SIGN_FINASH_DATE <", value, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateLessThanOrEqualTo(Date value) {
			addCriterion("SIGN_FINASH_DATE <=", value, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateIn(List<Date> values) {
			addCriterion("SIGN_FINASH_DATE in", values, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateNotIn(List<Date> values) {
			addCriterion("SIGN_FINASH_DATE not in", values, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateBetween(Date value1, Date value2) {
			addCriterion("SIGN_FINASH_DATE between", value1, value2, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andSignFinashDateNotBetween(Date value1, Date value2) {
			addCriterion("SIGN_FINASH_DATE not between", value1, value2, "signFinashDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateIsNull() {
			addCriterion("AUDIT_DATE is null");
			return (Criteria) this;
		}

		public Criteria andAuditDateIsNotNull() {
			addCriterion("AUDIT_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andAuditDateEqualTo(Date value) {
			addCriterion("AUDIT_DATE =", value, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateNotEqualTo(Date value) {
			addCriterion("AUDIT_DATE <>", value, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateGreaterThan(Date value) {
			addCriterion("AUDIT_DATE >", value, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateGreaterThanOrEqualTo(Date value) {
			addCriterion("AUDIT_DATE >=", value, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateLessThan(Date value) {
			addCriterion("AUDIT_DATE <", value, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateLessThanOrEqualTo(Date value) {
			addCriterion("AUDIT_DATE <=", value, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateIn(List<Date> values) {
			addCriterion("AUDIT_DATE in", values, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateNotIn(List<Date> values) {
			addCriterion("AUDIT_DATE not in", values, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateBetween(Date value1, Date value2) {
			addCriterion("AUDIT_DATE between", value1, value2, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditDateNotBetween(Date value1, Date value2) {
			addCriterion("AUDIT_DATE not between", value1, value2, "auditDate");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIsNull() {
			addCriterion("AUDIT_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIsNotNull() {
			addCriterion("AUDIT_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID =", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID <>", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdGreaterThan(Integer value) {
			addCriterion("AUDIT_USER_ID >", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID >=", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdLessThan(Integer value) {
			addCriterion("AUDIT_USER_ID <", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID <=", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIn(List<Integer> values) {
			addCriterion("AUDIT_USER_ID in", values, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_USER_ID not in", values, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER_ID between", value1, value2, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER_ID not between", value1, value2, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonIsNull() {
			addCriterion("INCALID_REASON is null");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonIsNotNull() {
			addCriterion("INCALID_REASON is not null");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonEqualTo(Byte value) {
			addCriterion("INCALID_REASON =", value, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonNotEqualTo(Byte value) {
			addCriterion("INCALID_REASON <>", value, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonGreaterThan(Byte value) {
			addCriterion("INCALID_REASON >", value, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonGreaterThanOrEqualTo(Byte value) {
			addCriterion("INCALID_REASON >=", value, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonLessThan(Byte value) {
			addCriterion("INCALID_REASON <", value, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonLessThanOrEqualTo(Byte value) {
			addCriterion("INCALID_REASON <=", value, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonIn(List<Byte> values) {
			addCriterion("INCALID_REASON in", values, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonNotIn(List<Byte> values) {
			addCriterion("INCALID_REASON not in", values, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonBetween(Byte value1, Byte value2) {
			addCriterion("INCALID_REASON between", value1, value2, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andIncalidReasonNotBetween(Byte value1, Byte value2) {
			addCriterion("INCALID_REASON not between", value1, value2, "incalidReason");
			return (Criteria) this;
		}

		public Criteria andRecordUserIsNull() {
			addCriterion("RECORD_USER is null");
			return (Criteria) this;
		}

		public Criteria andRecordUserIsNotNull() {
			addCriterion("RECORD_USER is not null");
			return (Criteria) this;
		}

		public Criteria andRecordUserEqualTo(Integer value) {
			addCriterion("RECORD_USER =", value, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserNotEqualTo(Integer value) {
			addCriterion("RECORD_USER <>", value, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserGreaterThan(Integer value) {
			addCriterion("RECORD_USER >", value, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECORD_USER >=", value, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserLessThan(Integer value) {
			addCriterion("RECORD_USER <", value, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserLessThanOrEqualTo(Integer value) {
			addCriterion("RECORD_USER <=", value, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserIn(List<Integer> values) {
			addCriterion("RECORD_USER in", values, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserNotIn(List<Integer> values) {
			addCriterion("RECORD_USER not in", values, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserBetween(Integer value1, Integer value2) {
			addCriterion("RECORD_USER between", value1, value2, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordUserNotBetween(Integer value1, Integer value2) {
			addCriterion("RECORD_USER not between", value1, value2, "recordUser");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameIsNull() {
			addCriterion("RECORD_ORGANIZATION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameIsNotNull() {
			addCriterion("RECORD_ORGANIZATION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameEqualTo(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME =", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameNotEqualTo(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME <>", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameGreaterThan(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME >", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameGreaterThanOrEqualTo(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME >=", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameLessThan(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME <", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameLessThanOrEqualTo(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME <=", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameLike(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME like", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameNotLike(String value) {
			addCriterion("RECORD_ORGANIZATION_NAME not like", value, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameIn(List<String> values) {
			addCriterion("RECORD_ORGANIZATION_NAME in", values, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameNotIn(List<String> values) {
			addCriterion("RECORD_ORGANIZATION_NAME not in", values, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameBetween(String value1, String value2) {
			addCriterion("RECORD_ORGANIZATION_NAME between", value1, value2, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordOrganizationNameNotBetween(String value1, String value2) {
			addCriterion("RECORD_ORGANIZATION_NAME not between", value1, value2, "recordOrganizationName");
			return (Criteria) this;
		}

		public Criteria andRecordTimeIsNull() {
			addCriterion("RECORD_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRecordTimeIsNotNull() {
			addCriterion("RECORD_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRecordTimeEqualTo(Date value) {
			addCriterion("RECORD_TIME =", value, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeNotEqualTo(Date value) {
			addCriterion("RECORD_TIME <>", value, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeGreaterThan(Date value) {
			addCriterion("RECORD_TIME >", value, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("RECORD_TIME >=", value, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeLessThan(Date value) {
			addCriterion("RECORD_TIME <", value, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
			addCriterion("RECORD_TIME <=", value, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeIn(List<Date> values) {
			addCriterion("RECORD_TIME in", values, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeNotIn(List<Date> values) {
			addCriterion("RECORD_TIME not in", values, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeBetween(Date value1, Date value2) {
			addCriterion("RECORD_TIME between", value1, value2, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
			addCriterion("RECORD_TIME not between", value1, value2, "recordTime");
			return (Criteria) this;
		}

		public Criteria andRecordNoIsNull() {
			addCriterion("RECORD_NO is null");
			return (Criteria) this;
		}

		public Criteria andRecordNoIsNotNull() {
			addCriterion("RECORD_NO is not null");
			return (Criteria) this;
		}

		public Criteria andRecordNoEqualTo(String value) {
			addCriterion("RECORD_NO =", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoNotEqualTo(String value) {
			addCriterion("RECORD_NO <>", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoGreaterThan(String value) {
			addCriterion("RECORD_NO >", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoGreaterThanOrEqualTo(String value) {
			addCriterion("RECORD_NO >=", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoLessThan(String value) {
			addCriterion("RECORD_NO <", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoLessThanOrEqualTo(String value) {
			addCriterion("RECORD_NO <=", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoLike(String value) {
			addCriterion("RECORD_NO like", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoNotLike(String value) {
			addCriterion("RECORD_NO not like", value, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoIn(List<String> values) {
			addCriterion("RECORD_NO in", values, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoNotIn(List<String> values) {
			addCriterion("RECORD_NO not in", values, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoBetween(String value1, String value2) {
			addCriterion("RECORD_NO between", value1, value2, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordNoNotBetween(String value1, String value2) {
			addCriterion("RECORD_NO not between", value1, value2, "recordNo");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeIsNull() {
			addCriterion("RECORD_UPDATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeIsNotNull() {
			addCriterion("RECORD_UPDATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeEqualTo(Date value) {
			addCriterion("RECORD_UPDATE_TIME =", value, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeNotEqualTo(Date value) {
			addCriterion("RECORD_UPDATE_TIME <>", value, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeGreaterThan(Date value) {
			addCriterion("RECORD_UPDATE_TIME >", value, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("RECORD_UPDATE_TIME >=", value, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeLessThan(Date value) {
			addCriterion("RECORD_UPDATE_TIME <", value, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("RECORD_UPDATE_TIME <=", value, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeIn(List<Date> values) {
			addCriterion("RECORD_UPDATE_TIME in", values, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeNotIn(List<Date> values) {
			addCriterion("RECORD_UPDATE_TIME not in", values, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("RECORD_UPDATE_TIME between", value1, value2, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("RECORD_UPDATE_TIME not between", value1, value2, "recordUpdateTime");
			return (Criteria) this;
		}

		public Criteria andRecordStatusIsNull() {
			addCriterion("RECORD_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andRecordStatusIsNotNull() {
			addCriterion("RECORD_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andRecordStatusEqualTo(Byte value) {
			addCriterion("RECORD_STATUS =", value, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusNotEqualTo(Byte value) {
			addCriterion("RECORD_STATUS <>", value, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusGreaterThan(Byte value) {
			addCriterion("RECORD_STATUS >", value, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("RECORD_STATUS >=", value, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusLessThan(Byte value) {
			addCriterion("RECORD_STATUS <", value, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
			addCriterion("RECORD_STATUS <=", value, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusIn(List<Byte> values) {
			addCriterion("RECORD_STATUS in", values, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusNotIn(List<Byte> values) {
			addCriterion("RECORD_STATUS not in", values, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
			addCriterion("RECORD_STATUS between", value1, value2, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("RECORD_STATUS not between", value1, value2, "recordStatus");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameIsNull() {
			addCriterion("APPROVE_ORGANIZATION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameIsNotNull() {
			addCriterion("APPROVE_ORGANIZATION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameEqualTo(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME =", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameNotEqualTo(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME <>", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameGreaterThan(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME >", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameGreaterThanOrEqualTo(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME >=", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameLessThan(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME <", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameLessThanOrEqualTo(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME <=", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameLike(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME like", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameNotLike(String value) {
			addCriterion("APPROVE_ORGANIZATION_NAME not like", value, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameIn(List<String> values) {
			addCriterion("APPROVE_ORGANIZATION_NAME in", values, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameNotIn(List<String> values) {
			addCriterion("APPROVE_ORGANIZATION_NAME not in", values, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameBetween(String value1, String value2) {
			addCriterion("APPROVE_ORGANIZATION_NAME between", value1, value2, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveOrganizationNameNotBetween(String value1, String value2) {
			addCriterion("APPROVE_ORGANIZATION_NAME not between", value1, value2, "approveOrganizationName");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdIsNull() {
			addCriterion("APPROVE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdIsNotNull() {
			addCriterion("APPROVE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdEqualTo(Integer value) {
			addCriterion("APPROVE_USER_ID =", value, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdNotEqualTo(Integer value) {
			addCriterion("APPROVE_USER_ID <>", value, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdGreaterThan(Integer value) {
			addCriterion("APPROVE_USER_ID >", value, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("APPROVE_USER_ID >=", value, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdLessThan(Integer value) {
			addCriterion("APPROVE_USER_ID <", value, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("APPROVE_USER_ID <=", value, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdIn(List<Integer> values) {
			addCriterion("APPROVE_USER_ID in", values, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdNotIn(List<Integer> values) {
			addCriterion("APPROVE_USER_ID not in", values, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdBetween(Integer value1, Integer value2) {
			addCriterion("APPROVE_USER_ID between", value1, value2, "approveUserId");
			return (Criteria) this;
		}

		public Criteria andApproveUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("APPROVE_USER_ID not between", value1, value2, "approveUserId");
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

		public Criteria andDepositFileForCustomOtherIsNull() {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER is null");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherIsNotNull() {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER is not null");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER =", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherNotEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER <>", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherGreaterThan(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER >", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherGreaterThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER >=", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherLessThan(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER <", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherLessThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER <=", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherLike(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER like", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherNotLike(String value) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER not like", value, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherIn(List<String> values) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER in", values, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherNotIn(List<String> values) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER not in", values, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherBetween(String value1, String value2) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER between", value1, value2, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andDepositFileForCustomOtherNotBetween(String value1, String value2) {
			addCriterion("DEPOSIT_FILE_FOR_CUSTOM_OTHER not between", value1, value2, "depositFileForCustomOther");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusIsNull() {
			addCriterion("ENTRUST_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusIsNotNull() {
			addCriterion("ENTRUST_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusEqualTo(Byte value) {
			addCriterion("ENTRUST_STATUS =", value, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusNotEqualTo(Byte value) {
			addCriterion("ENTRUST_STATUS <>", value, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusGreaterThan(Byte value) {
			addCriterion("ENTRUST_STATUS >", value, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_STATUS >=", value, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusLessThan(Byte value) {
			addCriterion("ENTRUST_STATUS <", value, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusLessThanOrEqualTo(Byte value) {
			addCriterion("ENTRUST_STATUS <=", value, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusIn(List<Byte> values) {
			addCriterion("ENTRUST_STATUS in", values, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusNotIn(List<Byte> values) {
			addCriterion("ENTRUST_STATUS not in", values, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_STATUS between", value1, value2, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andEntrustStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("ENTRUST_STATUS not between", value1, value2, "entrustStatus");
			return (Criteria) this;
		}

		public Criteria andSalePriceIsNull() {
			addCriterion("SALE_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSalePriceIsNotNull() {
			addCriterion("SALE_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSalePriceEqualTo(BigDecimal value) {
			addCriterion("SALE_PRICE =", value, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceNotEqualTo(BigDecimal value) {
			addCriterion("SALE_PRICE <>", value, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceGreaterThan(BigDecimal value) {
			addCriterion("SALE_PRICE >", value, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_PRICE >=", value, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceLessThan(BigDecimal value) {
			addCriterion("SALE_PRICE <", value, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_PRICE <=", value, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceIn(List<BigDecimal> values) {
			addCriterion("SALE_PRICE in", values, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceNotIn(List<BigDecimal> values) {
			addCriterion("SALE_PRICE not in", values, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_PRICE between", value1, value2, "salePrice");
			return (Criteria) this;
		}

		public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_PRICE not between", value1, value2, "salePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceIsNull() {
			addCriterion("LEASE_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLeasePriceIsNotNull() {
			addCriterion("LEASE_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLeasePriceEqualTo(BigDecimal value) {
			addCriterion("LEASE_PRICE =", value, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_PRICE <>", value, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_PRICE >", value, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_PRICE >=", value, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceLessThan(BigDecimal value) {
			addCriterion("LEASE_PRICE <", value, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_PRICE <=", value, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceIn(List<BigDecimal> values) {
			addCriterion("LEASE_PRICE in", values, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_PRICE not in", values, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_PRICE between", value1, value2, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andLeasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_PRICE not between", value1, value2, "leasePrice");
			return (Criteria) this;
		}

		public Criteria andIsShareIsNull() {
			addCriterion("IS_SHARE is null");
			return (Criteria) this;
		}

		public Criteria andIsShareIsNotNull() {
			addCriterion("IS_SHARE is not null");
			return (Criteria) this;
		}

		public Criteria andIsShareEqualTo(Byte value) {
			addCriterion("IS_SHARE =", value, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareNotEqualTo(Byte value) {
			addCriterion("IS_SHARE <>", value, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareGreaterThan(Byte value) {
			addCriterion("IS_SHARE >", value, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SHARE >=", value, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareLessThan(Byte value) {
			addCriterion("IS_SHARE <", value, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SHARE <=", value, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareIn(List<Byte> values) {
			addCriterion("IS_SHARE in", values, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareNotIn(List<Byte> values) {
			addCriterion("IS_SHARE not in", values, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareBetween(Byte value1, Byte value2) {
			addCriterion("IS_SHARE between", value1, value2, "isShare");
			return (Criteria) this;
		}

		public Criteria andIsShareNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SHARE not between", value1, value2, "isShare");
			return (Criteria) this;
		}

		public Criteria andContractIdIsNull() {
			addCriterion("CONTRACT_ID is null");
			return (Criteria) this;
		}

		public Criteria andContractIdIsNotNull() {
			addCriterion("CONTRACT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andContractIdEqualTo(String value) {
			addCriterion("CONTRACT_ID =", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotEqualTo(String value) {
			addCriterion("CONTRACT_ID <>", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdGreaterThan(String value) {
			addCriterion("CONTRACT_ID >", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdGreaterThanOrEqualTo(String value) {
			addCriterion("CONTRACT_ID >=", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdLessThan(String value) {
			addCriterion("CONTRACT_ID <", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdLessThanOrEqualTo(String value) {
			addCriterion("CONTRACT_ID <=", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdLike(String value) {
			addCriterion("CONTRACT_ID like", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotLike(String value) {
			addCriterion("CONTRACT_ID not like", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdIn(List<String> values) {
			addCriterion("CONTRACT_ID in", values, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotIn(List<String> values) {
			addCriterion("CONTRACT_ID not in", values, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdBetween(String value1, String value2) {
			addCriterion("CONTRACT_ID between", value1, value2, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotBetween(String value1, String value2) {
			addCriterion("CONTRACT_ID not between", value1, value2, "contractId");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptIsNull() {
			addCriterion("RECORD_USER_DEPT is null");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptIsNotNull() {
			addCriterion("RECORD_USER_DEPT is not null");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptEqualTo(String value) {
			addCriterion("RECORD_USER_DEPT =", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptNotEqualTo(String value) {
			addCriterion("RECORD_USER_DEPT <>", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptGreaterThan(String value) {
			addCriterion("RECORD_USER_DEPT >", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptGreaterThanOrEqualTo(String value) {
			addCriterion("RECORD_USER_DEPT >=", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptLessThan(String value) {
			addCriterion("RECORD_USER_DEPT <", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptLessThanOrEqualTo(String value) {
			addCriterion("RECORD_USER_DEPT <=", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptLike(String value) {
			addCriterion("RECORD_USER_DEPT like", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptNotLike(String value) {
			addCriterion("RECORD_USER_DEPT not like", value, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptIn(List<String> values) {
			addCriterion("RECORD_USER_DEPT in", values, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptNotIn(List<String> values) {
			addCriterion("RECORD_USER_DEPT not in", values, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptBetween(String value1, String value2) {
			addCriterion("RECORD_USER_DEPT between", value1, value2, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andRecordUserDeptNotBetween(String value1, String value2) {
			addCriterion("RECORD_USER_DEPT not between", value1, value2, "recordUserDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptIsNull() {
			addCriterion("APPROVE_DEPT is null");
			return (Criteria) this;
		}

		public Criteria andApproveDeptIsNotNull() {
			addCriterion("APPROVE_DEPT is not null");
			return (Criteria) this;
		}

		public Criteria andApproveDeptEqualTo(String value) {
			addCriterion("APPROVE_DEPT =", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptNotEqualTo(String value) {
			addCriterion("APPROVE_DEPT <>", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptGreaterThan(String value) {
			addCriterion("APPROVE_DEPT >", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptGreaterThanOrEqualTo(String value) {
			addCriterion("APPROVE_DEPT >=", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptLessThan(String value) {
			addCriterion("APPROVE_DEPT <", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptLessThanOrEqualTo(String value) {
			addCriterion("APPROVE_DEPT <=", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptLike(String value) {
			addCriterion("APPROVE_DEPT like", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptNotLike(String value) {
			addCriterion("APPROVE_DEPT not like", value, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptIn(List<String> values) {
			addCriterion("APPROVE_DEPT in", values, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptNotIn(List<String> values) {
			addCriterion("APPROVE_DEPT not in", values, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptBetween(String value1, String value2) {
			addCriterion("APPROVE_DEPT between", value1, value2, "approveDept");
			return (Criteria) this;
		}

		public Criteria andApproveDeptNotBetween(String value1, String value2) {
			addCriterion("APPROVE_DEPT not between", value1, value2, "approveDept");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyIsNull() {
			addCriterion("HAS_ACCOUNT_OCCUPANCY is null");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyIsNotNull() {
			addCriterion("HAS_ACCOUNT_OCCUPANCY is not null");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyEqualTo(Byte value) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY =", value, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyNotEqualTo(Byte value) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY <>", value, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyGreaterThan(Byte value) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY >", value, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY >=", value, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyLessThan(Byte value) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY <", value, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY <=", value, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyIn(List<Byte> values) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY in", values, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyNotIn(List<Byte> values) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY not in", values, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyBetween(Byte value1, Byte value2) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY between", value1, value2, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasAccountOccupancyNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_ACCOUNT_OCCUPANCY not between", value1, value2, "hasAccountOccupancy");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationIsNull() {
			addCriterion("HAS_DEGREE_OCCUPATION is null");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationIsNotNull() {
			addCriterion("HAS_DEGREE_OCCUPATION is not null");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationEqualTo(Byte value) {
			addCriterion("HAS_DEGREE_OCCUPATION =", value, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationNotEqualTo(Byte value) {
			addCriterion("HAS_DEGREE_OCCUPATION <>", value, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationGreaterThan(Byte value) {
			addCriterion("HAS_DEGREE_OCCUPATION >", value, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_DEGREE_OCCUPATION >=", value, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationLessThan(Byte value) {
			addCriterion("HAS_DEGREE_OCCUPATION <", value, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_DEGREE_OCCUPATION <=", value, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationIn(List<Byte> values) {
			addCriterion("HAS_DEGREE_OCCUPATION in", values, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationNotIn(List<Byte> values) {
			addCriterion("HAS_DEGREE_OCCUPATION not in", values, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationBetween(Byte value1, Byte value2) {
			addCriterion("HAS_DEGREE_OCCUPATION between", value1, value2, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andHasDegreeOccupationNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_DEGREE_OCCUPATION not between", value1, value2, "hasDegreeOccupation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationIsNull() {
			addCriterion("PROPERTY_SITUATION is null");
			return (Criteria) this;
		}

		public Criteria andPropertySituationIsNotNull() {
			addCriterion("PROPERTY_SITUATION is not null");
			return (Criteria) this;
		}

		public Criteria andPropertySituationEqualTo(BigDecimal value) {
			addCriterion("PROPERTY_SITUATION =", value, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationNotEqualTo(BigDecimal value) {
			addCriterion("PROPERTY_SITUATION <>", value, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationGreaterThan(BigDecimal value) {
			addCriterion("PROPERTY_SITUATION >", value, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PROPERTY_SITUATION >=", value, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationLessThan(BigDecimal value) {
			addCriterion("PROPERTY_SITUATION <", value, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PROPERTY_SITUATION <=", value, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationIn(List<BigDecimal> values) {
			addCriterion("PROPERTY_SITUATION in", values, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationNotIn(List<BigDecimal> values) {
			addCriterion("PROPERTY_SITUATION not in", values, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROPERTY_SITUATION between", value1, value2, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROPERTY_SITUATION not between", value1, value2, "propertySituation");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherIsNull() {
			addCriterion("PROPERTY_SITUATION_OTHER is null");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherIsNotNull() {
			addCriterion("PROPERTY_SITUATION_OTHER is not null");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherEqualTo(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER =", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherNotEqualTo(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER <>", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherGreaterThan(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER >", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherGreaterThanOrEqualTo(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER >=", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherLessThan(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER <", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherLessThanOrEqualTo(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER <=", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherLike(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER like", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherNotLike(String value) {
			addCriterion("PROPERTY_SITUATION_OTHER not like", value, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherIn(List<String> values) {
			addCriterion("PROPERTY_SITUATION_OTHER in", values, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherNotIn(List<String> values) {
			addCriterion("PROPERTY_SITUATION_OTHER not in", values, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherBetween(String value1, String value2) {
			addCriterion("PROPERTY_SITUATION_OTHER between", value1, value2, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andPropertySituationOtherNotBetween(String value1, String value2) {
			addCriterion("PROPERTY_SITUATION_OTHER not between", value1, value2, "propertySituationOther");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysIsNull() {
			addCriterion("NUMBER_OF_KEYS is null");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysIsNotNull() {
			addCriterion("NUMBER_OF_KEYS is not null");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysEqualTo(Byte value) {
			addCriterion("NUMBER_OF_KEYS =", value, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysNotEqualTo(Byte value) {
			addCriterion("NUMBER_OF_KEYS <>", value, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysGreaterThan(Byte value) {
			addCriterion("NUMBER_OF_KEYS >", value, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysGreaterThanOrEqualTo(Byte value) {
			addCriterion("NUMBER_OF_KEYS >=", value, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysLessThan(Byte value) {
			addCriterion("NUMBER_OF_KEYS <", value, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysLessThanOrEqualTo(Byte value) {
			addCriterion("NUMBER_OF_KEYS <=", value, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysIn(List<Byte> values) {
			addCriterion("NUMBER_OF_KEYS in", values, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysNotIn(List<Byte> values) {
			addCriterion("NUMBER_OF_KEYS not in", values, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysBetween(Byte value1, Byte value2) {
			addCriterion("NUMBER_OF_KEYS between", value1, value2, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andNumberOfKeysNotBetween(Byte value1, Byte value2) {
			addCriterion("NUMBER_OF_KEYS not between", value1, value2, "numberOfKeys");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionIsNull() {
			addCriterion("CERTIFICATE_OF_PRODUCTION is null");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionIsNotNull() {
			addCriterion("CERTIFICATE_OF_PRODUCTION is not null");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionEqualTo(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION =", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionNotEqualTo(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION <>", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionGreaterThan(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION >", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionGreaterThanOrEqualTo(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION >=", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionLessThan(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION <", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionLessThanOrEqualTo(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION <=", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionLike(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION like", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionNotLike(String value) {
			addCriterion("CERTIFICATE_OF_PRODUCTION not like", value, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionIn(List<String> values) {
			addCriterion("CERTIFICATE_OF_PRODUCTION in", values, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionNotIn(List<String> values) {
			addCriterion("CERTIFICATE_OF_PRODUCTION not in", values, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionBetween(String value1, String value2) {
			addCriterion("CERTIFICATE_OF_PRODUCTION between", value1, value2, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andCertificateOfProductionNotBetween(String value1, String value2) {
			addCriterion("CERTIFICATE_OF_PRODUCTION not between", value1, value2, "certificateOfProduction");
			return (Criteria) this;
		}

		public Criteria andLandNatureIsNull() {
			addCriterion("LAND_NATURE is null");
			return (Criteria) this;
		}

		public Criteria andLandNatureIsNotNull() {
			addCriterion("LAND_NATURE is not null");
			return (Criteria) this;
		}

		public Criteria andLandNatureEqualTo(String value) {
			addCriterion("LAND_NATURE =", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureNotEqualTo(String value) {
			addCriterion("LAND_NATURE <>", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureGreaterThan(String value) {
			addCriterion("LAND_NATURE >", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureGreaterThanOrEqualTo(String value) {
			addCriterion("LAND_NATURE >=", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureLessThan(String value) {
			addCriterion("LAND_NATURE <", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureLessThanOrEqualTo(String value) {
			addCriterion("LAND_NATURE <=", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureLike(String value) {
			addCriterion("LAND_NATURE like", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureNotLike(String value) {
			addCriterion("LAND_NATURE not like", value, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureIn(List<String> values) {
			addCriterion("LAND_NATURE in", values, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureNotIn(List<String> values) {
			addCriterion("LAND_NATURE not in", values, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureBetween(String value1, String value2) {
			addCriterion("LAND_NATURE between", value1, value2, "landNature");
			return (Criteria) this;
		}

		public Criteria andLandNatureNotBetween(String value1, String value2) {
			addCriterion("LAND_NATURE not between", value1, value2, "landNature");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountIsNull() {
			addCriterion("ENTRUSTED_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountIsNotNull() {
			addCriterion("ENTRUSTED_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountEqualTo(BigDecimal value) {
			addCriterion("ENTRUSTED_AMOUNT =", value, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountNotEqualTo(BigDecimal value) {
			addCriterion("ENTRUSTED_AMOUNT <>", value, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountGreaterThan(BigDecimal value) {
			addCriterion("ENTRUSTED_AMOUNT >", value, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ENTRUSTED_AMOUNT >=", value, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountLessThan(BigDecimal value) {
			addCriterion("ENTRUSTED_AMOUNT <", value, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ENTRUSTED_AMOUNT <=", value, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountIn(List<BigDecimal> values) {
			addCriterion("ENTRUSTED_AMOUNT in", values, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountNotIn(List<BigDecimal> values) {
			addCriterion("ENTRUSTED_AMOUNT not in", values, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ENTRUSTED_AMOUNT between", value1, value2, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ENTRUSTED_AMOUNT not between", value1, value2, "entrustedAmount");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaIsNull() {
			addCriterion("ENTRUST_AREA is null");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaIsNotNull() {
			addCriterion("ENTRUST_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_AREA =", value, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaNotEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_AREA <>", value, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaGreaterThan(BigDecimal value) {
			addCriterion("ENTRUST_AREA >", value, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_AREA >=", value, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaLessThan(BigDecimal value) {
			addCriterion("ENTRUST_AREA <", value, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_AREA <=", value, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaIn(List<BigDecimal> values) {
			addCriterion("ENTRUST_AREA in", values, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaNotIn(List<BigDecimal> values) {
			addCriterion("ENTRUST_AREA not in", values, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ENTRUST_AREA between", value1, value2, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ENTRUST_AREA not between", value1, value2, "entrustArea");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteIsNull() {
			addCriterion("ENTRUST_NOTE is null");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteIsNotNull() {
			addCriterion("ENTRUST_NOTE is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteEqualTo(String value) {
			addCriterion("ENTRUST_NOTE =", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteNotEqualTo(String value) {
			addCriterion("ENTRUST_NOTE <>", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteGreaterThan(String value) {
			addCriterion("ENTRUST_NOTE >", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteGreaterThanOrEqualTo(String value) {
			addCriterion("ENTRUST_NOTE >=", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteLessThan(String value) {
			addCriterion("ENTRUST_NOTE <", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteLessThanOrEqualTo(String value) {
			addCriterion("ENTRUST_NOTE <=", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteLike(String value) {
			addCriterion("ENTRUST_NOTE like", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteNotLike(String value) {
			addCriterion("ENTRUST_NOTE not like", value, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteIn(List<String> values) {
			addCriterion("ENTRUST_NOTE in", values, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteNotIn(List<String> values) {
			addCriterion("ENTRUST_NOTE not in", values, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteBetween(String value1, String value2) {
			addCriterion("ENTRUST_NOTE between", value1, value2, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andEntrustNoteNotBetween(String value1, String value2) {
			addCriterion("ENTRUST_NOTE not between", value1, value2, "entrustNote");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIsNull() {
			addCriterion("PRICE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIsNotNull() {
			addCriterion("PRICE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andPriceUnitEqualTo(Byte value) {
			addCriterion("PRICE_UNIT =", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotEqualTo(Byte value) {
			addCriterion("PRICE_UNIT <>", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitGreaterThan(Byte value) {
			addCriterion("PRICE_UNIT >", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitGreaterThanOrEqualTo(Byte value) {
			addCriterion("PRICE_UNIT >=", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitLessThan(Byte value) {
			addCriterion("PRICE_UNIT <", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitLessThanOrEqualTo(Byte value) {
			addCriterion("PRICE_UNIT <=", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIn(List<Byte> values) {
			addCriterion("PRICE_UNIT in", values, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotIn(List<Byte> values) {
			addCriterion("PRICE_UNIT not in", values, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitBetween(Byte value1, Byte value2) {
			addCriterion("PRICE_UNIT between", value1, value2, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotBetween(Byte value1, Byte value2) {
			addCriterion("PRICE_UNIT not between", value1, value2, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceIsNull() {
			addCriterion("SALE_ENTRUST_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceIsNotNull() {
			addCriterion("SALE_ENTRUST_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE =", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceNotEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE <>", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceGreaterThan(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE >", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE >=", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceLessThan(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE <", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE <=", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceIn(List<BigDecimal> values) {
			addCriterion("SALE_ENTRUST_PRICE in", values, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceNotIn(List<BigDecimal> values) {
			addCriterion("SALE_ENTRUST_PRICE not in", values, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_ENTRUST_PRICE between", value1, value2, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_ENTRUST_PRICE not between", value1, value2, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceIsNull() {
			addCriterion("LEASE_ENTRUST_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceIsNotNull() {
			addCriterion("LEASE_ENTRUST_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE =", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE <>", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE >", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE >=", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceLessThan(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE <", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE <=", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceIn(List<BigDecimal> values) {
			addCriterion("LEASE_ENTRUST_PRICE in", values, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_ENTRUST_PRICE not in", values, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_ENTRUST_PRICE between", value1, value2, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_ENTRUST_PRICE not between", value1, value2, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountIsNull() {
			addCriterion("CUSTOM_RENT_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountIsNotNull() {
			addCriterion("CUSTOM_RENT_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountEqualTo(BigDecimal value) {
			addCriterion("CUSTOM_RENT_AMOUNT =", value, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountNotEqualTo(BigDecimal value) {
			addCriterion("CUSTOM_RENT_AMOUNT <>", value, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountGreaterThan(BigDecimal value) {
			addCriterion("CUSTOM_RENT_AMOUNT >", value, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("CUSTOM_RENT_AMOUNT >=", value, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountLessThan(BigDecimal value) {
			addCriterion("CUSTOM_RENT_AMOUNT <", value, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("CUSTOM_RENT_AMOUNT <=", value, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountIn(List<BigDecimal> values) {
			addCriterion("CUSTOM_RENT_AMOUNT in", values, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountNotIn(List<BigDecimal> values) {
			addCriterion("CUSTOM_RENT_AMOUNT not in", values, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CUSTOM_RENT_AMOUNT between", value1, value2, "customRentAmount");
			return (Criteria) this;
		}

		public Criteria andCustomRentAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CUSTOM_RENT_AMOUNT not between", value1, value2, "customRentAmount");
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