package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunCompExample {
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
	public AdminFunCompExample() {
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

		public Criteria andCrmCompIdIsNull() {
			addCriterion("CRM_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIsNotNull() {
			addCriterion("CRM_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID =", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <>", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThan(Integer value) {
			addCriterion("CRM_COMP_ID >", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID >=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThan(Integer value) {
			addCriterion("CRM_COMP_ID <", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID not in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID between", value1, value2, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID not between", value1, value2, "crmCompId");
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

		public Criteria andProvinceIdIsNull() {
			addCriterion("PROVINCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIsNotNull() {
			addCriterion("PROVINCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andProvinceIdEqualTo(Integer value) {
			addCriterion("PROVINCE_ID =", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotEqualTo(Integer value) {
			addCriterion("PROVINCE_ID <>", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThan(Integer value) {
			addCriterion("PROVINCE_ID >", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PROVINCE_ID >=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThan(Integer value) {
			addCriterion("PROVINCE_ID <", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
			addCriterion("PROVINCE_ID <=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIn(List<Integer> values) {
			addCriterion("PROVINCE_ID in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotIn(List<Integer> values) {
			addCriterion("PROVINCE_ID not in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
			addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
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

		public Criteria andCompNameIsNull() {
			addCriterion("COMP_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCompNameIsNotNull() {
			addCriterion("COMP_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCompNameEqualTo(String value) {
			addCriterion("COMP_NAME =", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotEqualTo(String value) {
			addCriterion("COMP_NAME <>", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameGreaterThan(String value) {
			addCriterion("COMP_NAME >", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_NAME >=", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameLessThan(String value) {
			addCriterion("COMP_NAME <", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameLessThanOrEqualTo(String value) {
			addCriterion("COMP_NAME <=", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameLike(String value) {
			addCriterion("COMP_NAME like", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotLike(String value) {
			addCriterion("COMP_NAME not like", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameIn(List<String> values) {
			addCriterion("COMP_NAME in", values, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotIn(List<String> values) {
			addCriterion("COMP_NAME not in", values, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameBetween(String value1, String value2) {
			addCriterion("COMP_NAME between", value1, value2, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotBetween(String value1, String value2) {
			addCriterion("COMP_NAME not between", value1, value2, "compName");
			return (Criteria) this;
		}

		public Criteria andCompCnameIsNull() {
			addCriterion("COMP_CNAME is null");
			return (Criteria) this;
		}

		public Criteria andCompCnameIsNotNull() {
			addCriterion("COMP_CNAME is not null");
			return (Criteria) this;
		}

		public Criteria andCompCnameEqualTo(String value) {
			addCriterion("COMP_CNAME =", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameNotEqualTo(String value) {
			addCriterion("COMP_CNAME <>", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameGreaterThan(String value) {
			addCriterion("COMP_CNAME >", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_CNAME >=", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameLessThan(String value) {
			addCriterion("COMP_CNAME <", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameLessThanOrEqualTo(String value) {
			addCriterion("COMP_CNAME <=", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameLike(String value) {
			addCriterion("COMP_CNAME like", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameNotLike(String value) {
			addCriterion("COMP_CNAME not like", value, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameIn(List<String> values) {
			addCriterion("COMP_CNAME in", values, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameNotIn(List<String> values) {
			addCriterion("COMP_CNAME not in", values, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameBetween(String value1, String value2) {
			addCriterion("COMP_CNAME between", value1, value2, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompCnameNotBetween(String value1, String value2) {
			addCriterion("COMP_CNAME not between", value1, value2, "compCname");
			return (Criteria) this;
		}

		public Criteria andCompAddrIsNull() {
			addCriterion("COMP_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andCompAddrIsNotNull() {
			addCriterion("COMP_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andCompAddrEqualTo(String value) {
			addCriterion("COMP_ADDR =", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotEqualTo(String value) {
			addCriterion("COMP_ADDR <>", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrGreaterThan(String value) {
			addCriterion("COMP_ADDR >", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_ADDR >=", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrLessThan(String value) {
			addCriterion("COMP_ADDR <", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrLessThanOrEqualTo(String value) {
			addCriterion("COMP_ADDR <=", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrLike(String value) {
			addCriterion("COMP_ADDR like", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotLike(String value) {
			addCriterion("COMP_ADDR not like", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrIn(List<String> values) {
			addCriterion("COMP_ADDR in", values, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotIn(List<String> values) {
			addCriterion("COMP_ADDR not in", values, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrBetween(String value1, String value2) {
			addCriterion("COMP_ADDR between", value1, value2, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotBetween(String value1, String value2) {
			addCriterion("COMP_ADDR not between", value1, value2, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompTeleIsNull() {
			addCriterion("COMP_TELE is null");
			return (Criteria) this;
		}

		public Criteria andCompTeleIsNotNull() {
			addCriterion("COMP_TELE is not null");
			return (Criteria) this;
		}

		public Criteria andCompTeleEqualTo(String value) {
			addCriterion("COMP_TELE =", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleNotEqualTo(String value) {
			addCriterion("COMP_TELE <>", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleGreaterThan(String value) {
			addCriterion("COMP_TELE >", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_TELE >=", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleLessThan(String value) {
			addCriterion("COMP_TELE <", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleLessThanOrEqualTo(String value) {
			addCriterion("COMP_TELE <=", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleLike(String value) {
			addCriterion("COMP_TELE like", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleNotLike(String value) {
			addCriterion("COMP_TELE not like", value, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleIn(List<String> values) {
			addCriterion("COMP_TELE in", values, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleNotIn(List<String> values) {
			addCriterion("COMP_TELE not in", values, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleBetween(String value1, String value2) {
			addCriterion("COMP_TELE between", value1, value2, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompTeleNotBetween(String value1, String value2) {
			addCriterion("COMP_TELE not between", value1, value2, "compTele");
			return (Criteria) this;
		}

		public Criteria andCompEmailIsNull() {
			addCriterion("COMP_EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andCompEmailIsNotNull() {
			addCriterion("COMP_EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andCompEmailEqualTo(String value) {
			addCriterion("COMP_EMAIL =", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailNotEqualTo(String value) {
			addCriterion("COMP_EMAIL <>", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailGreaterThan(String value) {
			addCriterion("COMP_EMAIL >", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_EMAIL >=", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailLessThan(String value) {
			addCriterion("COMP_EMAIL <", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailLessThanOrEqualTo(String value) {
			addCriterion("COMP_EMAIL <=", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailLike(String value) {
			addCriterion("COMP_EMAIL like", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailNotLike(String value) {
			addCriterion("COMP_EMAIL not like", value, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailIn(List<String> values) {
			addCriterion("COMP_EMAIL in", values, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailNotIn(List<String> values) {
			addCriterion("COMP_EMAIL not in", values, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailBetween(String value1, String value2) {
			addCriterion("COMP_EMAIL between", value1, value2, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompEmailNotBetween(String value1, String value2) {
			addCriterion("COMP_EMAIL not between", value1, value2, "compEmail");
			return (Criteria) this;
		}

		public Criteria andCompQqIsNull() {
			addCriterion("COMP_QQ is null");
			return (Criteria) this;
		}

		public Criteria andCompQqIsNotNull() {
			addCriterion("COMP_QQ is not null");
			return (Criteria) this;
		}

		public Criteria andCompQqEqualTo(String value) {
			addCriterion("COMP_QQ =", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqNotEqualTo(String value) {
			addCriterion("COMP_QQ <>", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqGreaterThan(String value) {
			addCriterion("COMP_QQ >", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_QQ >=", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqLessThan(String value) {
			addCriterion("COMP_QQ <", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqLessThanOrEqualTo(String value) {
			addCriterion("COMP_QQ <=", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqLike(String value) {
			addCriterion("COMP_QQ like", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqNotLike(String value) {
			addCriterion("COMP_QQ not like", value, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqIn(List<String> values) {
			addCriterion("COMP_QQ in", values, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqNotIn(List<String> values) {
			addCriterion("COMP_QQ not in", values, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqBetween(String value1, String value2) {
			addCriterion("COMP_QQ between", value1, value2, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompQqNotBetween(String value1, String value2) {
			addCriterion("COMP_QQ not between", value1, value2, "compQq");
			return (Criteria) this;
		}

		public Criteria andCompContactIsNull() {
			addCriterion("COMP_CONTACT is null");
			return (Criteria) this;
		}

		public Criteria andCompContactIsNotNull() {
			addCriterion("COMP_CONTACT is not null");
			return (Criteria) this;
		}

		public Criteria andCompContactEqualTo(String value) {
			addCriterion("COMP_CONTACT =", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactNotEqualTo(String value) {
			addCriterion("COMP_CONTACT <>", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactGreaterThan(String value) {
			addCriterion("COMP_CONTACT >", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_CONTACT >=", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactLessThan(String value) {
			addCriterion("COMP_CONTACT <", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactLessThanOrEqualTo(String value) {
			addCriterion("COMP_CONTACT <=", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactLike(String value) {
			addCriterion("COMP_CONTACT like", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactNotLike(String value) {
			addCriterion("COMP_CONTACT not like", value, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactIn(List<String> values) {
			addCriterion("COMP_CONTACT in", values, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactNotIn(List<String> values) {
			addCriterion("COMP_CONTACT not in", values, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactBetween(String value1, String value2) {
			addCriterion("COMP_CONTACT between", value1, value2, "compContact");
			return (Criteria) this;
		}

		public Criteria andCompContactNotBetween(String value1, String value2) {
			addCriterion("COMP_CONTACT not between", value1, value2, "compContact");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIsNull() {
			addCriterion("CONTACT_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIsNotNull() {
			addCriterion("CONTACT_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andContactPhoneEqualTo(String value) {
			addCriterion("CONTACT_PHONE =", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotEqualTo(String value) {
			addCriterion("CONTACT_PHONE <>", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneGreaterThan(String value) {
			addCriterion("CONTACT_PHONE >", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("CONTACT_PHONE >=", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLessThan(String value) {
			addCriterion("CONTACT_PHONE <", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLessThanOrEqualTo(String value) {
			addCriterion("CONTACT_PHONE <=", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLike(String value) {
			addCriterion("CONTACT_PHONE like", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotLike(String value) {
			addCriterion("CONTACT_PHONE not like", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIn(List<String> values) {
			addCriterion("CONTACT_PHONE in", values, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotIn(List<String> values) {
			addCriterion("CONTACT_PHONE not in", values, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneBetween(String value1, String value2) {
			addCriterion("CONTACT_PHONE between", value1, value2, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotBetween(String value1, String value2) {
			addCriterion("CONTACT_PHONE not between", value1, value2, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andCompDescIsNull() {
			addCriterion("COMP_DESC is null");
			return (Criteria) this;
		}

		public Criteria andCompDescIsNotNull() {
			addCriterion("COMP_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andCompDescEqualTo(String value) {
			addCriterion("COMP_DESC =", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescNotEqualTo(String value) {
			addCriterion("COMP_DESC <>", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescGreaterThan(String value) {
			addCriterion("COMP_DESC >", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_DESC >=", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescLessThan(String value) {
			addCriterion("COMP_DESC <", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescLessThanOrEqualTo(String value) {
			addCriterion("COMP_DESC <=", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescLike(String value) {
			addCriterion("COMP_DESC like", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescNotLike(String value) {
			addCriterion("COMP_DESC not like", value, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescIn(List<String> values) {
			addCriterion("COMP_DESC in", values, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescNotIn(List<String> values) {
			addCriterion("COMP_DESC not in", values, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescBetween(String value1, String value2) {
			addCriterion("COMP_DESC between", value1, value2, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDescNotBetween(String value1, String value2) {
			addCriterion("COMP_DESC not between", value1, value2, "compDesc");
			return (Criteria) this;
		}

		public Criteria andCompDeptsIsNull() {
			addCriterion("COMP_DEPTS is null");
			return (Criteria) this;
		}

		public Criteria andCompDeptsIsNotNull() {
			addCriterion("COMP_DEPTS is not null");
			return (Criteria) this;
		}

		public Criteria andCompDeptsEqualTo(Integer value) {
			addCriterion("COMP_DEPTS =", value, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNotEqualTo(Integer value) {
			addCriterion("COMP_DEPTS <>", value, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsGreaterThan(Integer value) {
			addCriterion("COMP_DEPTS >", value, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMP_DEPTS >=", value, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsLessThan(Integer value) {
			addCriterion("COMP_DEPTS <", value, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsLessThanOrEqualTo(Integer value) {
			addCriterion("COMP_DEPTS <=", value, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsIn(List<Integer> values) {
			addCriterion("COMP_DEPTS in", values, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNotIn(List<Integer> values) {
			addCriterion("COMP_DEPTS not in", values, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsBetween(Integer value1, Integer value2) {
			addCriterion("COMP_DEPTS between", value1, value2, "compDepts");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNotBetween(Integer value1, Integer value2) {
			addCriterion("COMP_DEPTS not between", value1, value2, "compDepts");
			return (Criteria) this;
		}

		public Criteria andDeptStatusIsNull() {
			addCriterion("DEPT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andDeptStatusIsNotNull() {
			addCriterion("DEPT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andDeptStatusEqualTo(Integer value) {
			addCriterion("DEPT_STATUS =", value, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusNotEqualTo(Integer value) {
			addCriterion("DEPT_STATUS <>", value, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusGreaterThan(Integer value) {
			addCriterion("DEPT_STATUS >", value, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEPT_STATUS >=", value, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusLessThan(Integer value) {
			addCriterion("DEPT_STATUS <", value, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusLessThanOrEqualTo(Integer value) {
			addCriterion("DEPT_STATUS <=", value, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusIn(List<Integer> values) {
			addCriterion("DEPT_STATUS in", values, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusNotIn(List<Integer> values) {
			addCriterion("DEPT_STATUS not in", values, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_STATUS between", value1, value2, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andDeptStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_STATUS not between", value1, value2, "deptStatus");
			return (Criteria) this;
		}

		public Criteria andSellIdIsNull() {
			addCriterion("SELL_ID is null");
			return (Criteria) this;
		}

		public Criteria andSellIdIsNotNull() {
			addCriterion("SELL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSellIdEqualTo(Integer value) {
			addCriterion("SELL_ID =", value, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdNotEqualTo(Integer value) {
			addCriterion("SELL_ID <>", value, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdGreaterThan(Integer value) {
			addCriterion("SELL_ID >", value, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SELL_ID >=", value, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdLessThan(Integer value) {
			addCriterion("SELL_ID <", value, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdLessThanOrEqualTo(Integer value) {
			addCriterion("SELL_ID <=", value, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdIn(List<Integer> values) {
			addCriterion("SELL_ID in", values, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdNotIn(List<Integer> values) {
			addCriterion("SELL_ID not in", values, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdBetween(Integer value1, Integer value2) {
			addCriterion("SELL_ID between", value1, value2, "sellId");
			return (Criteria) this;
		}

		public Criteria andSellIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SELL_ID not between", value1, value2, "sellId");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIsNull() {
			addCriterion("TRACK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIsNotNull() {
			addCriterion("TRACK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTrackTimeEqualTo(Date value) {
			addCriterion("TRACK_TIME =", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotEqualTo(Date value) {
			addCriterion("TRACK_TIME <>", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeGreaterThan(Date value) {
			addCriterion("TRACK_TIME >", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TRACK_TIME >=", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLessThan(Date value) {
			addCriterion("TRACK_TIME <", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLessThanOrEqualTo(Date value) {
			addCriterion("TRACK_TIME <=", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIn(List<Date> values) {
			addCriterion("TRACK_TIME in", values, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotIn(List<Date> values) {
			addCriterion("TRACK_TIME not in", values, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeBetween(Date value1, Date value2) {
			addCriterion("TRACK_TIME between", value1, value2, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotBetween(Date value1, Date value2) {
			addCriterion("TRACK_TIME not between", value1, value2, "trackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeIsNull() {
			addCriterion("SELL_TRACK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeIsNotNull() {
			addCriterion("SELL_TRACK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeEqualTo(Date value) {
			addCriterion("SELL_TRACK_TIME =", value, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeNotEqualTo(Date value) {
			addCriterion("SELL_TRACK_TIME <>", value, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeGreaterThan(Date value) {
			addCriterion("SELL_TRACK_TIME >", value, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SELL_TRACK_TIME >=", value, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeLessThan(Date value) {
			addCriterion("SELL_TRACK_TIME <", value, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeLessThanOrEqualTo(Date value) {
			addCriterion("SELL_TRACK_TIME <=", value, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeIn(List<Date> values) {
			addCriterion("SELL_TRACK_TIME in", values, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeNotIn(List<Date> values) {
			addCriterion("SELL_TRACK_TIME not in", values, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeBetween(Date value1, Date value2) {
			addCriterion("SELL_TRACK_TIME between", value1, value2, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andSellTrackTimeNotBetween(Date value1, Date value2) {
			addCriterion("SELL_TRACK_TIME not between", value1, value2, "sellTrackTime");
			return (Criteria) this;
		}

		public Criteria andPeerSoftIsNull() {
			addCriterion("PEER_SOFT is null");
			return (Criteria) this;
		}

		public Criteria andPeerSoftIsNotNull() {
			addCriterion("PEER_SOFT is not null");
			return (Criteria) this;
		}

		public Criteria andPeerSoftEqualTo(String value) {
			addCriterion("PEER_SOFT =", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftNotEqualTo(String value) {
			addCriterion("PEER_SOFT <>", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftGreaterThan(String value) {
			addCriterion("PEER_SOFT >", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftGreaterThanOrEqualTo(String value) {
			addCriterion("PEER_SOFT >=", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftLessThan(String value) {
			addCriterion("PEER_SOFT <", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftLessThanOrEqualTo(String value) {
			addCriterion("PEER_SOFT <=", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftLike(String value) {
			addCriterion("PEER_SOFT like", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftNotLike(String value) {
			addCriterion("PEER_SOFT not like", value, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftIn(List<String> values) {
			addCriterion("PEER_SOFT in", values, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftNotIn(List<String> values) {
			addCriterion("PEER_SOFT not in", values, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftBetween(String value1, String value2) {
			addCriterion("PEER_SOFT between", value1, value2, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andPeerSoftNotBetween(String value1, String value2) {
			addCriterion("PEER_SOFT not between", value1, value2, "peerSoft");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("REMARK is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("REMARK =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("REMARK <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("REMARK >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("REMARK >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("REMARK <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("REMARK <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("REMARK like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("REMARK not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("REMARK in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("REMARK not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("REMARK between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("REMARK not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andInstallPwdIsNull() {
			addCriterion("INSTALL_PWD is null");
			return (Criteria) this;
		}

		public Criteria andInstallPwdIsNotNull() {
			addCriterion("INSTALL_PWD is not null");
			return (Criteria) this;
		}

		public Criteria andInstallPwdEqualTo(String value) {
			addCriterion("INSTALL_PWD =", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdNotEqualTo(String value) {
			addCriterion("INSTALL_PWD <>", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdGreaterThan(String value) {
			addCriterion("INSTALL_PWD >", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdGreaterThanOrEqualTo(String value) {
			addCriterion("INSTALL_PWD >=", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdLessThan(String value) {
			addCriterion("INSTALL_PWD <", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdLessThanOrEqualTo(String value) {
			addCriterion("INSTALL_PWD <=", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdLike(String value) {
			addCriterion("INSTALL_PWD like", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdNotLike(String value) {
			addCriterion("INSTALL_PWD not like", value, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdIn(List<String> values) {
			addCriterion("INSTALL_PWD in", values, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdNotIn(List<String> values) {
			addCriterion("INSTALL_PWD not in", values, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdBetween(String value1, String value2) {
			addCriterion("INSTALL_PWD between", value1, value2, "installPwd");
			return (Criteria) this;
		}

		public Criteria andInstallPwdNotBetween(String value1, String value2) {
			addCriterion("INSTALL_PWD not between", value1, value2, "installPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdIsNull() {
			addCriterion("PLAINT_PWD is null");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdIsNotNull() {
			addCriterion("PLAINT_PWD is not null");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdEqualTo(String value) {
			addCriterion("PLAINT_PWD =", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdNotEqualTo(String value) {
			addCriterion("PLAINT_PWD <>", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdGreaterThan(String value) {
			addCriterion("PLAINT_PWD >", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdGreaterThanOrEqualTo(String value) {
			addCriterion("PLAINT_PWD >=", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdLessThan(String value) {
			addCriterion("PLAINT_PWD <", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdLessThanOrEqualTo(String value) {
			addCriterion("PLAINT_PWD <=", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdLike(String value) {
			addCriterion("PLAINT_PWD like", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdNotLike(String value) {
			addCriterion("PLAINT_PWD not like", value, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdIn(List<String> values) {
			addCriterion("PLAINT_PWD in", values, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdNotIn(List<String> values) {
			addCriterion("PLAINT_PWD not in", values, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdBetween(String value1, String value2) {
			addCriterion("PLAINT_PWD between", value1, value2, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andPlaintPwdNotBetween(String value1, String value2) {
			addCriterion("PLAINT_PWD not between", value1, value2, "plaintPwd");
			return (Criteria) this;
		}

		public Criteria andCustomLogIsNull() {
			addCriterion("CUSTOM_LOG is null");
			return (Criteria) this;
		}

		public Criteria andCustomLogIsNotNull() {
			addCriterion("CUSTOM_LOG is not null");
			return (Criteria) this;
		}

		public Criteria andCustomLogEqualTo(String value) {
			addCriterion("CUSTOM_LOG =", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogNotEqualTo(String value) {
			addCriterion("CUSTOM_LOG <>", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogGreaterThan(String value) {
			addCriterion("CUSTOM_LOG >", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogGreaterThanOrEqualTo(String value) {
			addCriterion("CUSTOM_LOG >=", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogLessThan(String value) {
			addCriterion("CUSTOM_LOG <", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogLessThanOrEqualTo(String value) {
			addCriterion("CUSTOM_LOG <=", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogLike(String value) {
			addCriterion("CUSTOM_LOG like", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogNotLike(String value) {
			addCriterion("CUSTOM_LOG not like", value, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogIn(List<String> values) {
			addCriterion("CUSTOM_LOG in", values, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogNotIn(List<String> values) {
			addCriterion("CUSTOM_LOG not in", values, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogBetween(String value1, String value2) {
			addCriterion("CUSTOM_LOG between", value1, value2, "customLog");
			return (Criteria) this;
		}

		public Criteria andCustomLogNotBetween(String value1, String value2) {
			addCriterion("CUSTOM_LOG not between", value1, value2, "customLog");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIsNull() {
			addCriterion("CREATOR_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIsNotNull() {
			addCriterion("CREATOR_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidEqualTo(Integer value) {
			addCriterion("CREATOR_UID =", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotEqualTo(Integer value) {
			addCriterion("CREATOR_UID <>", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThan(Integer value) {
			addCriterion("CREATOR_UID >", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID >=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThan(Integer value) {
			addCriterion("CREATOR_UID <", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID <=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIn(List<Integer> values) {
			addCriterion("CREATOR_UID in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotIn(List<Integer> values) {
			addCriterion("CREATOR_UID not in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID between", value1, value2, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID not between", value1, value2, "creatorUid");
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

		public Criteria andCompTypeIsNull() {
			addCriterion("COMP_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCompTypeIsNotNull() {
			addCriterion("COMP_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCompTypeEqualTo(Byte value) {
			addCriterion("COMP_TYPE =", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeNotEqualTo(Byte value) {
			addCriterion("COMP_TYPE <>", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeGreaterThan(Byte value) {
			addCriterion("COMP_TYPE >", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_TYPE >=", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeLessThan(Byte value) {
			addCriterion("COMP_TYPE <", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_TYPE <=", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeIn(List<Byte> values) {
			addCriterion("COMP_TYPE in", values, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeNotIn(List<Byte> values) {
			addCriterion("COMP_TYPE not in", values, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeBetween(Byte value1, Byte value2) {
			addCriterion("COMP_TYPE between", value1, value2, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_TYPE not between", value1, value2, "compType");
			return (Criteria) this;
		}

		public Criteria andStoreNoIsNull() {
			addCriterion("STORE_NO is null");
			return (Criteria) this;
		}

		public Criteria andStoreNoIsNotNull() {
			addCriterion("STORE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andStoreNoEqualTo(String value) {
			addCriterion("STORE_NO =", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoNotEqualTo(String value) {
			addCriterion("STORE_NO <>", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoGreaterThan(String value) {
			addCriterion("STORE_NO >", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoGreaterThanOrEqualTo(String value) {
			addCriterion("STORE_NO >=", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoLessThan(String value) {
			addCriterion("STORE_NO <", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoLessThanOrEqualTo(String value) {
			addCriterion("STORE_NO <=", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoLike(String value) {
			addCriterion("STORE_NO like", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoNotLike(String value) {
			addCriterion("STORE_NO not like", value, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoIn(List<String> values) {
			addCriterion("STORE_NO in", values, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoNotIn(List<String> values) {
			addCriterion("STORE_NO not in", values, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoBetween(String value1, String value2) {
			addCriterion("STORE_NO between", value1, value2, "storeNo");
			return (Criteria) this;
		}

		public Criteria andStoreNoNotBetween(String value1, String value2) {
			addCriterion("STORE_NO not between", value1, value2, "storeNo");
			return (Criteria) this;
		}

		public Criteria andIsVipIsNull() {
			addCriterion("IS_VIP is null");
			return (Criteria) this;
		}

		public Criteria andIsVipIsNotNull() {
			addCriterion("IS_VIP is not null");
			return (Criteria) this;
		}

		public Criteria andIsVipEqualTo(Byte value) {
			addCriterion("IS_VIP =", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipNotEqualTo(Byte value) {
			addCriterion("IS_VIP <>", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipGreaterThan(Byte value) {
			addCriterion("IS_VIP >", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_VIP >=", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipLessThan(Byte value) {
			addCriterion("IS_VIP <", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipLessThanOrEqualTo(Byte value) {
			addCriterion("IS_VIP <=", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipIn(List<Byte> values) {
			addCriterion("IS_VIP in", values, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipNotIn(List<Byte> values) {
			addCriterion("IS_VIP not in", values, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipBetween(Byte value1, Byte value2) {
			addCriterion("IS_VIP between", value1, value2, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_VIP not between", value1, value2, "isVip");
			return (Criteria) this;
		}

		public Criteria andUaIdIsNull() {
			addCriterion("UA_ID is null");
			return (Criteria) this;
		}

		public Criteria andUaIdIsNotNull() {
			addCriterion("UA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUaIdEqualTo(Integer value) {
			addCriterion("UA_ID =", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdNotEqualTo(Integer value) {
			addCriterion("UA_ID <>", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdGreaterThan(Integer value) {
			addCriterion("UA_ID >", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("UA_ID >=", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdLessThan(Integer value) {
			addCriterion("UA_ID <", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdLessThanOrEqualTo(Integer value) {
			addCriterion("UA_ID <=", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdIn(List<Integer> values) {
			addCriterion("UA_ID in", values, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdNotIn(List<Integer> values) {
			addCriterion("UA_ID not in", values, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdBetween(Integer value1, Integer value2) {
			addCriterion("UA_ID between", value1, value2, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("UA_ID not between", value1, value2, "uaId");
			return (Criteria) this;
		}

		public Criteria andBrandIdIsNull() {
			addCriterion("BRAND_ID is null");
			return (Criteria) this;
		}

		public Criteria andBrandIdIsNotNull() {
			addCriterion("BRAND_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBrandIdEqualTo(Integer value) {
			addCriterion("BRAND_ID =", value, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdNotEqualTo(Integer value) {
			addCriterion("BRAND_ID <>", value, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdGreaterThan(Integer value) {
			addCriterion("BRAND_ID >", value, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BRAND_ID >=", value, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdLessThan(Integer value) {
			addCriterion("BRAND_ID <", value, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
			addCriterion("BRAND_ID <=", value, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdIn(List<Integer> values) {
			addCriterion("BRAND_ID in", values, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdNotIn(List<Integer> values) {
			addCriterion("BRAND_ID not in", values, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdBetween(Integer value1, Integer value2) {
			addCriterion("BRAND_ID between", value1, value2, "brandId");
			return (Criteria) this;
		}

		public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BRAND_ID not between", value1, value2, "brandId");
			return (Criteria) this;
		}

		public Criteria andAreaFlagIsNull() {
			addCriterion("AREA_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andAreaFlagIsNotNull() {
			addCriterion("AREA_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andAreaFlagEqualTo(Byte value) {
			addCriterion("AREA_FLAG =", value, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagNotEqualTo(Byte value) {
			addCriterion("AREA_FLAG <>", value, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagGreaterThan(Byte value) {
			addCriterion("AREA_FLAG >", value, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("AREA_FLAG >=", value, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagLessThan(Byte value) {
			addCriterion("AREA_FLAG <", value, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagLessThanOrEqualTo(Byte value) {
			addCriterion("AREA_FLAG <=", value, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagIn(List<Byte> values) {
			addCriterion("AREA_FLAG in", values, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagNotIn(List<Byte> values) {
			addCriterion("AREA_FLAG not in", values, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagBetween(Byte value1, Byte value2) {
			addCriterion("AREA_FLAG between", value1, value2, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andAreaFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("AREA_FLAG not between", value1, value2, "areaFlag");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveIsNull() {
			addCriterion("GENERAL_ARCHIVE is null");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveIsNotNull() {
			addCriterion("GENERAL_ARCHIVE is not null");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveEqualTo(Integer value) {
			addCriterion("GENERAL_ARCHIVE =", value, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveNotEqualTo(Integer value) {
			addCriterion("GENERAL_ARCHIVE <>", value, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveGreaterThan(Integer value) {
			addCriterion("GENERAL_ARCHIVE >", value, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveGreaterThanOrEqualTo(Integer value) {
			addCriterion("GENERAL_ARCHIVE >=", value, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveLessThan(Integer value) {
			addCriterion("GENERAL_ARCHIVE <", value, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveLessThanOrEqualTo(Integer value) {
			addCriterion("GENERAL_ARCHIVE <=", value, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveIn(List<Integer> values) {
			addCriterion("GENERAL_ARCHIVE in", values, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveNotIn(List<Integer> values) {
			addCriterion("GENERAL_ARCHIVE not in", values, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveBetween(Integer value1, Integer value2) {
			addCriterion("GENERAL_ARCHIVE between", value1, value2, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andGeneralArchiveNotBetween(Integer value1, Integer value2) {
			addCriterion("GENERAL_ARCHIVE not between", value1, value2, "generalArchive");
			return (Criteria) this;
		}

		public Criteria andCompModelIsNull() {
			addCriterion("COMP_MODEL is null");
			return (Criteria) this;
		}

		public Criteria andCompModelIsNotNull() {
			addCriterion("COMP_MODEL is not null");
			return (Criteria) this;
		}

		public Criteria andCompModelEqualTo(Byte value) {
			addCriterion("COMP_MODEL =", value, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelNotEqualTo(Byte value) {
			addCriterion("COMP_MODEL <>", value, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelGreaterThan(Byte value) {
			addCriterion("COMP_MODEL >", value, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_MODEL >=", value, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelLessThan(Byte value) {
			addCriterion("COMP_MODEL <", value, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_MODEL <=", value, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelIn(List<Byte> values) {
			addCriterion("COMP_MODEL in", values, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelNotIn(List<Byte> values) {
			addCriterion("COMP_MODEL not in", values, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelBetween(Byte value1, Byte value2) {
			addCriterion("COMP_MODEL between", value1, value2, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompModelNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_MODEL not between", value1, value2, "compModel");
			return (Criteria) this;
		}

		public Criteria andCompAttrIsNull() {
			addCriterion("COMP_ATTR is null");
			return (Criteria) this;
		}

		public Criteria andCompAttrIsNotNull() {
			addCriterion("COMP_ATTR is not null");
			return (Criteria) this;
		}

		public Criteria andCompAttrEqualTo(Byte value) {
			addCriterion("COMP_ATTR =", value, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrNotEqualTo(Byte value) {
			addCriterion("COMP_ATTR <>", value, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrGreaterThan(Byte value) {
			addCriterion("COMP_ATTR >", value, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_ATTR >=", value, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrLessThan(Byte value) {
			addCriterion("COMP_ATTR <", value, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_ATTR <=", value, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrIn(List<Byte> values) {
			addCriterion("COMP_ATTR in", values, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrNotIn(List<Byte> values) {
			addCriterion("COMP_ATTR not in", values, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrBetween(Byte value1, Byte value2) {
			addCriterion("COMP_ATTR between", value1, value2, "compAttr");
			return (Criteria) this;
		}

		public Criteria andCompAttrNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_ATTR not between", value1, value2, "compAttr");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagIsNull() {
			addCriterion("WXALLOWANCE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagIsNotNull() {
			addCriterion("WXALLOWANCE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_FLAG =", value, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagNotEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_FLAG <>", value, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagGreaterThan(Byte value) {
			addCriterion("WXALLOWANCE_FLAG >", value, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_FLAG >=", value, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagLessThan(Byte value) {
			addCriterion("WXALLOWANCE_FLAG <", value, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagLessThanOrEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_FLAG <=", value, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagIn(List<Byte> values) {
			addCriterion("WXALLOWANCE_FLAG in", values, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagNotIn(List<Byte> values) {
			addCriterion("WXALLOWANCE_FLAG not in", values, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagBetween(Byte value1, Byte value2) {
			addCriterion("WXALLOWANCE_FLAG between", value1, value2, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("WXALLOWANCE_FLAG not between", value1, value2, "wxallowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioIsNull() {
			addCriterion("WXALLOWANCE_SALERATIO is null");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioIsNotNull() {
			addCriterion("WXALLOWANCE_SALERATIO is not null");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_SALERATIO =", value, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioNotEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_SALERATIO <>", value, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioGreaterThan(Byte value) {
			addCriterion("WXALLOWANCE_SALERATIO >", value, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioGreaterThanOrEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_SALERATIO >=", value, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioLessThan(Byte value) {
			addCriterion("WXALLOWANCE_SALERATIO <", value, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioLessThanOrEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_SALERATIO <=", value, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioIn(List<Byte> values) {
			addCriterion("WXALLOWANCE_SALERATIO in", values, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioNotIn(List<Byte> values) {
			addCriterion("WXALLOWANCE_SALERATIO not in", values, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioBetween(Byte value1, Byte value2) {
			addCriterion("WXALLOWANCE_SALERATIO between", value1, value2, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceSaleratioNotBetween(Byte value1, Byte value2) {
			addCriterion("WXALLOWANCE_SALERATIO not between", value1, value2, "wxallowanceSaleratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioIsNull() {
			addCriterion("WXALLOWANCE_LEASERATIO is null");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioIsNotNull() {
			addCriterion("WXALLOWANCE_LEASERATIO is not null");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_LEASERATIO =", value, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioNotEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_LEASERATIO <>", value, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioGreaterThan(Byte value) {
			addCriterion("WXALLOWANCE_LEASERATIO >", value, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioGreaterThanOrEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_LEASERATIO >=", value, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioLessThan(Byte value) {
			addCriterion("WXALLOWANCE_LEASERATIO <", value, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioLessThanOrEqualTo(Byte value) {
			addCriterion("WXALLOWANCE_LEASERATIO <=", value, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioIn(List<Byte> values) {
			addCriterion("WXALLOWANCE_LEASERATIO in", values, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioNotIn(List<Byte> values) {
			addCriterion("WXALLOWANCE_LEASERATIO not in", values, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioBetween(Byte value1, Byte value2) {
			addCriterion("WXALLOWANCE_LEASERATIO between", value1, value2, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andWxallowanceLeaseratioNotBetween(Byte value1, Byte value2) {
			addCriterion("WXALLOWANCE_LEASERATIO not between", value1, value2, "wxallowanceLeaseratio");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusIsNull() {
			addCriterion("COMP_WEIXIN_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusIsNotNull() {
			addCriterion("COMP_WEIXIN_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusEqualTo(Integer value) {
			addCriterion("COMP_WEIXIN_STATUS =", value, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusNotEqualTo(Integer value) {
			addCriterion("COMP_WEIXIN_STATUS <>", value, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusGreaterThan(Integer value) {
			addCriterion("COMP_WEIXIN_STATUS >", value, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMP_WEIXIN_STATUS >=", value, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusLessThan(Integer value) {
			addCriterion("COMP_WEIXIN_STATUS <", value, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusLessThanOrEqualTo(Integer value) {
			addCriterion("COMP_WEIXIN_STATUS <=", value, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusIn(List<Integer> values) {
			addCriterion("COMP_WEIXIN_STATUS in", values, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusNotIn(List<Integer> values) {
			addCriterion("COMP_WEIXIN_STATUS not in", values, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusBetween(Integer value1, Integer value2) {
			addCriterion("COMP_WEIXIN_STATUS between", value1, value2, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andCompWeixinStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("COMP_WEIXIN_STATUS not between", value1, value2, "compWeixinStatus");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagIsNull() {
			addCriterion("WX_ALLOWANCE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagIsNotNull() {
			addCriterion("WX_ALLOWANCE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagEqualTo(Byte value) {
			addCriterion("WX_ALLOWANCE_FLAG =", value, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagNotEqualTo(Byte value) {
			addCriterion("WX_ALLOWANCE_FLAG <>", value, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagGreaterThan(Byte value) {
			addCriterion("WX_ALLOWANCE_FLAG >", value, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("WX_ALLOWANCE_FLAG >=", value, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagLessThan(Byte value) {
			addCriterion("WX_ALLOWANCE_FLAG <", value, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagLessThanOrEqualTo(Byte value) {
			addCriterion("WX_ALLOWANCE_FLAG <=", value, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagIn(List<Byte> values) {
			addCriterion("WX_ALLOWANCE_FLAG in", values, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagNotIn(List<Byte> values) {
			addCriterion("WX_ALLOWANCE_FLAG not in", values, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagBetween(Byte value1, Byte value2) {
			addCriterion("WX_ALLOWANCE_FLAG between", value1, value2, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andWxAllowanceFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("WX_ALLOWANCE_FLAG not between", value1, value2, "wxAllowanceFlag");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusIsNull() {
			addCriterion("COMP_PAY_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusIsNotNull() {
			addCriterion("COMP_PAY_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusEqualTo(Byte value) {
			addCriterion("COMP_PAY_STATUS =", value, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusNotEqualTo(Byte value) {
			addCriterion("COMP_PAY_STATUS <>", value, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusGreaterThan(Byte value) {
			addCriterion("COMP_PAY_STATUS >", value, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_PAY_STATUS >=", value, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusLessThan(Byte value) {
			addCriterion("COMP_PAY_STATUS <", value, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_PAY_STATUS <=", value, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusIn(List<Byte> values) {
			addCriterion("COMP_PAY_STATUS in", values, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusNotIn(List<Byte> values) {
			addCriterion("COMP_PAY_STATUS not in", values, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusBetween(Byte value1, Byte value2) {
			addCriterion("COMP_PAY_STATUS between", value1, value2, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andCompPayStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_PAY_STATUS not between", value1, value2, "compPayStatus");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeIsNull() {
			addCriterion("BIZ_DIAL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeIsNotNull() {
			addCriterion("BIZ_DIAL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeEqualTo(Byte value) {
			addCriterion("BIZ_DIAL_TYPE =", value, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeNotEqualTo(Byte value) {
			addCriterion("BIZ_DIAL_TYPE <>", value, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeGreaterThan(Byte value) {
			addCriterion("BIZ_DIAL_TYPE >", value, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("BIZ_DIAL_TYPE >=", value, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeLessThan(Byte value) {
			addCriterion("BIZ_DIAL_TYPE <", value, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeLessThanOrEqualTo(Byte value) {
			addCriterion("BIZ_DIAL_TYPE <=", value, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeIn(List<Byte> values) {
			addCriterion("BIZ_DIAL_TYPE in", values, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeNotIn(List<Byte> values) {
			addCriterion("BIZ_DIAL_TYPE not in", values, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeBetween(Byte value1, Byte value2) {
			addCriterion("BIZ_DIAL_TYPE between", value1, value2, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andBizDialTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("BIZ_DIAL_TYPE not between", value1, value2, "bizDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeIsNull() {
			addCriterion("SOSO_DIAL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeIsNotNull() {
			addCriterion("SOSO_DIAL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeEqualTo(Byte value) {
			addCriterion("SOSO_DIAL_TYPE =", value, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeNotEqualTo(Byte value) {
			addCriterion("SOSO_DIAL_TYPE <>", value, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeGreaterThan(Byte value) {
			addCriterion("SOSO_DIAL_TYPE >", value, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SOSO_DIAL_TYPE >=", value, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeLessThan(Byte value) {
			addCriterion("SOSO_DIAL_TYPE <", value, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SOSO_DIAL_TYPE <=", value, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeIn(List<Byte> values) {
			addCriterion("SOSO_DIAL_TYPE in", values, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeNotIn(List<Byte> values) {
			addCriterion("SOSO_DIAL_TYPE not in", values, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeBetween(Byte value1, Byte value2) {
			addCriterion("SOSO_DIAL_TYPE between", value1, value2, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andSosoDialTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SOSO_DIAL_TYPE not between", value1, value2, "sosoDialType");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagIsNull() {
			addCriterion("DISTRIBUTE_MANAGER_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagIsNotNull() {
			addCriterion("DISTRIBUTE_MANAGER_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagEqualTo(Byte value) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG =", value, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagNotEqualTo(Byte value) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG <>", value, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagGreaterThan(Byte value) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG >", value, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG >=", value, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagLessThan(Byte value) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG <", value, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagLessThanOrEqualTo(Byte value) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG <=", value, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagIn(List<Byte> values) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG in", values, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagNotIn(List<Byte> values) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG not in", values, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagBetween(Byte value1, Byte value2) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG between", value1, value2, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andDistributeManagerFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("DISTRIBUTE_MANAGER_FLAG not between", value1, value2, "distributeManagerFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagIsNull() {
			addCriterion("CUSTOM_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andCustomFlagIsNotNull() {
			addCriterion("CUSTOM_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andCustomFlagEqualTo(Byte value) {
			addCriterion("CUSTOM_FLAG =", value, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagNotEqualTo(Byte value) {
			addCriterion("CUSTOM_FLAG <>", value, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagGreaterThan(Byte value) {
			addCriterion("CUSTOM_FLAG >", value, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUSTOM_FLAG >=", value, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagLessThan(Byte value) {
			addCriterion("CUSTOM_FLAG <", value, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagLessThanOrEqualTo(Byte value) {
			addCriterion("CUSTOM_FLAG <=", value, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagIn(List<Byte> values) {
			addCriterion("CUSTOM_FLAG in", values, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagNotIn(List<Byte> values) {
			addCriterion("CUSTOM_FLAG not in", values, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOM_FLAG between", value1, value2, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOM_FLAG not between", value1, value2, "customFlag");
			return (Criteria) this;
		}

		public Criteria andCustomUrlIsNull() {
			addCriterion("CUSTOM_URL is null");
			return (Criteria) this;
		}

		public Criteria andCustomUrlIsNotNull() {
			addCriterion("CUSTOM_URL is not null");
			return (Criteria) this;
		}

		public Criteria andCustomUrlEqualTo(String value) {
			addCriterion("CUSTOM_URL =", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlNotEqualTo(String value) {
			addCriterion("CUSTOM_URL <>", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlGreaterThan(String value) {
			addCriterion("CUSTOM_URL >", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlGreaterThanOrEqualTo(String value) {
			addCriterion("CUSTOM_URL >=", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlLessThan(String value) {
			addCriterion("CUSTOM_URL <", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlLessThanOrEqualTo(String value) {
			addCriterion("CUSTOM_URL <=", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlLike(String value) {
			addCriterion("CUSTOM_URL like", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlNotLike(String value) {
			addCriterion("CUSTOM_URL not like", value, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlIn(List<String> values) {
			addCriterion("CUSTOM_URL in", values, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlNotIn(List<String> values) {
			addCriterion("CUSTOM_URL not in", values, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlBetween(String value1, String value2) {
			addCriterion("CUSTOM_URL between", value1, value2, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomUrlNotBetween(String value1, String value2) {
			addCriterion("CUSTOM_URL not between", value1, value2, "customUrl");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyIsNull() {
			addCriterion("CUSTOM_PUBLIC_KEY is null");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyIsNotNull() {
			addCriterion("CUSTOM_PUBLIC_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyEqualTo(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY =", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyNotEqualTo(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY <>", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyGreaterThan(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY >", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyGreaterThanOrEqualTo(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY >=", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyLessThan(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY <", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyLessThanOrEqualTo(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY <=", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyLike(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY like", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyNotLike(String value) {
			addCriterion("CUSTOM_PUBLIC_KEY not like", value, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyIn(List<String> values) {
			addCriterion("CUSTOM_PUBLIC_KEY in", values, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyNotIn(List<String> values) {
			addCriterion("CUSTOM_PUBLIC_KEY not in", values, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyBetween(String value1, String value2) {
			addCriterion("CUSTOM_PUBLIC_KEY between", value1, value2, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomPublicKeyNotBetween(String value1, String value2) {
			addCriterion("CUSTOM_PUBLIC_KEY not between", value1, value2, "customPublicKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyIsNull() {
			addCriterion("CUSTOM_DECODE_KEY is null");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyIsNotNull() {
			addCriterion("CUSTOM_DECODE_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyEqualTo(String value) {
			addCriterion("CUSTOM_DECODE_KEY =", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyNotEqualTo(String value) {
			addCriterion("CUSTOM_DECODE_KEY <>", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyGreaterThan(String value) {
			addCriterion("CUSTOM_DECODE_KEY >", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyGreaterThanOrEqualTo(String value) {
			addCriterion("CUSTOM_DECODE_KEY >=", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyLessThan(String value) {
			addCriterion("CUSTOM_DECODE_KEY <", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyLessThanOrEqualTo(String value) {
			addCriterion("CUSTOM_DECODE_KEY <=", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyLike(String value) {
			addCriterion("CUSTOM_DECODE_KEY like", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyNotLike(String value) {
			addCriterion("CUSTOM_DECODE_KEY not like", value, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyIn(List<String> values) {
			addCriterion("CUSTOM_DECODE_KEY in", values, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyNotIn(List<String> values) {
			addCriterion("CUSTOM_DECODE_KEY not in", values, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyBetween(String value1, String value2) {
			addCriterion("CUSTOM_DECODE_KEY between", value1, value2, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andCustomDecodeKeyNotBetween(String value1, String value2) {
			addCriterion("CUSTOM_DECODE_KEY not between", value1, value2, "customDecodeKey");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleIsNull() {
			addCriterion("SPECIAL_PASS_RULE is null");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleIsNotNull() {
			addCriterion("SPECIAL_PASS_RULE is not null");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleEqualTo(Byte value) {
			addCriterion("SPECIAL_PASS_RULE =", value, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleNotEqualTo(Byte value) {
			addCriterion("SPECIAL_PASS_RULE <>", value, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleGreaterThan(Byte value) {
			addCriterion("SPECIAL_PASS_RULE >", value, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleGreaterThanOrEqualTo(Byte value) {
			addCriterion("SPECIAL_PASS_RULE >=", value, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleLessThan(Byte value) {
			addCriterion("SPECIAL_PASS_RULE <", value, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleLessThanOrEqualTo(Byte value) {
			addCriterion("SPECIAL_PASS_RULE <=", value, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleIn(List<Byte> values) {
			addCriterion("SPECIAL_PASS_RULE in", values, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleNotIn(List<Byte> values) {
			addCriterion("SPECIAL_PASS_RULE not in", values, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleBetween(Byte value1, Byte value2) {
			addCriterion("SPECIAL_PASS_RULE between", value1, value2, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andSpecialPassRuleNotBetween(Byte value1, Byte value2) {
			addCriterion("SPECIAL_PASS_RULE not between", value1, value2, "specialPassRule");
			return (Criteria) this;
		}

		public Criteria andRealWeixinIsNull() {
			addCriterion("REAL_WEIXIN is null");
			return (Criteria) this;
		}

		public Criteria andRealWeixinIsNotNull() {
			addCriterion("REAL_WEIXIN is not null");
			return (Criteria) this;
		}

		public Criteria andRealWeixinEqualTo(Byte value) {
			addCriterion("REAL_WEIXIN =", value, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinNotEqualTo(Byte value) {
			addCriterion("REAL_WEIXIN <>", value, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinGreaterThan(Byte value) {
			addCriterion("REAL_WEIXIN >", value, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinGreaterThanOrEqualTo(Byte value) {
			addCriterion("REAL_WEIXIN >=", value, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinLessThan(Byte value) {
			addCriterion("REAL_WEIXIN <", value, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinLessThanOrEqualTo(Byte value) {
			addCriterion("REAL_WEIXIN <=", value, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinIn(List<Byte> values) {
			addCriterion("REAL_WEIXIN in", values, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinNotIn(List<Byte> values) {
			addCriterion("REAL_WEIXIN not in", values, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinBetween(Byte value1, Byte value2) {
			addCriterion("REAL_WEIXIN between", value1, value2, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andRealWeixinNotBetween(Byte value1, Byte value2) {
			addCriterion("REAL_WEIXIN not between", value1, value2, "realWeixin");
			return (Criteria) this;
		}

		public Criteria andLogoPathIsNull() {
			addCriterion("LOGO_PATH is null");
			return (Criteria) this;
		}

		public Criteria andLogoPathIsNotNull() {
			addCriterion("LOGO_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andLogoPathEqualTo(String value) {
			addCriterion("LOGO_PATH =", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotEqualTo(String value) {
			addCriterion("LOGO_PATH <>", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathGreaterThan(String value) {
			addCriterion("LOGO_PATH >", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathGreaterThanOrEqualTo(String value) {
			addCriterion("LOGO_PATH >=", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathLessThan(String value) {
			addCriterion("LOGO_PATH <", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathLessThanOrEqualTo(String value) {
			addCriterion("LOGO_PATH <=", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathLike(String value) {
			addCriterion("LOGO_PATH like", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotLike(String value) {
			addCriterion("LOGO_PATH not like", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathIn(List<String> values) {
			addCriterion("LOGO_PATH in", values, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotIn(List<String> values) {
			addCriterion("LOGO_PATH not in", values, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathBetween(String value1, String value2) {
			addCriterion("LOGO_PATH between", value1, value2, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotBetween(String value1, String value2) {
			addCriterion("LOGO_PATH not between", value1, value2, "logoPath");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagIsNull() {
			addCriterion("YOUJIA_COMP_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagIsNotNull() {
			addCriterion("YOUJIA_COMP_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagEqualTo(Byte value) {
			addCriterion("YOUJIA_COMP_FLAG =", value, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagNotEqualTo(Byte value) {
			addCriterion("YOUJIA_COMP_FLAG <>", value, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagGreaterThan(Byte value) {
			addCriterion("YOUJIA_COMP_FLAG >", value, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_COMP_FLAG >=", value, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagLessThan(Byte value) {
			addCriterion("YOUJIA_COMP_FLAG <", value, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_COMP_FLAG <=", value, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagIn(List<Byte> values) {
			addCriterion("YOUJIA_COMP_FLAG in", values, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagNotIn(List<Byte> values) {
			addCriterion("YOUJIA_COMP_FLAG not in", values, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_COMP_FLAG between", value1, value2, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaCompFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_COMP_FLAG not between", value1, value2, "youjiaCompFlag");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeIsNull() {
			addCriterion("COMP_VIEW_RANGE is null");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeIsNotNull() {
			addCriterion("COMP_VIEW_RANGE is not null");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeEqualTo(Byte value) {
			addCriterion("COMP_VIEW_RANGE =", value, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeNotEqualTo(Byte value) {
			addCriterion("COMP_VIEW_RANGE <>", value, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeGreaterThan(Byte value) {
			addCriterion("COMP_VIEW_RANGE >", value, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_VIEW_RANGE >=", value, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeLessThan(Byte value) {
			addCriterion("COMP_VIEW_RANGE <", value, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_VIEW_RANGE <=", value, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeIn(List<Byte> values) {
			addCriterion("COMP_VIEW_RANGE in", values, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeNotIn(List<Byte> values) {
			addCriterion("COMP_VIEW_RANGE not in", values, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeBetween(Byte value1, Byte value2) {
			addCriterion("COMP_VIEW_RANGE between", value1, value2, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompViewRangeNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_VIEW_RANGE not between", value1, value2, "compViewRange");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusIsNull() {
			addCriterion("COMP_DISTRIBUTE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusIsNotNull() {
			addCriterion("COMP_DISTRIBUTE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusEqualTo(Byte value) {
			addCriterion("COMP_DISTRIBUTE_STATUS =", value, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusNotEqualTo(Byte value) {
			addCriterion("COMP_DISTRIBUTE_STATUS <>", value, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusGreaterThan(Byte value) {
			addCriterion("COMP_DISTRIBUTE_STATUS >", value, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_DISTRIBUTE_STATUS >=", value, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusLessThan(Byte value) {
			addCriterion("COMP_DISTRIBUTE_STATUS <", value, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_DISTRIBUTE_STATUS <=", value, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusIn(List<Byte> values) {
			addCriterion("COMP_DISTRIBUTE_STATUS in", values, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusNotIn(List<Byte> values) {
			addCriterion("COMP_DISTRIBUTE_STATUS not in", values, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusBetween(Byte value1, Byte value2) {
			addCriterion("COMP_DISTRIBUTE_STATUS between", value1, value2, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andCompDistributeStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_DISTRIBUTE_STATUS not between", value1, value2, "compDistributeStatus");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleIsNull() {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleIsNotNull() {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE =", value, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleNotEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE <>", value, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleGreaterThan(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE >", value, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE >=", value, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleLessThan(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE <", value, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleLessThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE <=", value, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE in", values, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleNotIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE not in", values, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE between", value1, value2, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareSaleNotBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_SALE not between", value1, value2, "youjiaDeptMaxshareSale");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseIsNull() {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseIsNotNull() {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE =", value, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseNotEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE <>", value, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseGreaterThan(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE >", value, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE >=", value, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseLessThan(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE <", value, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseLessThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE <=", value, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE in", values, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseNotIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE not in", values, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE between", value1, value2, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLeaseNotBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_MAXSHARE_LEASE not between", value1, value2, "youjiaDeptMaxshareLease");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareIsNull() {
			addCriterion("YOUJIA_DEPT_MAXSHARE is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareIsNotNull() {
			addCriterion("YOUJIA_DEPT_MAXSHARE is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE =", value, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareNotEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE <>", value, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareGreaterThan(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE >", value, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE >=", value, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLessThan(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE <", value, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareLessThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_MAXSHARE <=", value, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_MAXSHARE in", values, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareNotIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_MAXSHARE not in", values, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_MAXSHARE between", value1, value2, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptMaxshareNotBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_MAXSHARE not between", value1, value2, "youjiaDeptMaxshare");
			return (Criteria) this;
		}

		public Criteria andSubVersionIsNull() {
			addCriterion("SUB_VERSION is null");
			return (Criteria) this;
		}

		public Criteria andSubVersionIsNotNull() {
			addCriterion("SUB_VERSION is not null");
			return (Criteria) this;
		}

		public Criteria andSubVersionEqualTo(Byte value) {
			addCriterion("SUB_VERSION =", value, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionNotEqualTo(Byte value) {
			addCriterion("SUB_VERSION <>", value, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionGreaterThan(Byte value) {
			addCriterion("SUB_VERSION >", value, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionGreaterThanOrEqualTo(Byte value) {
			addCriterion("SUB_VERSION >=", value, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionLessThan(Byte value) {
			addCriterion("SUB_VERSION <", value, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionLessThanOrEqualTo(Byte value) {
			addCriterion("SUB_VERSION <=", value, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionIn(List<Byte> values) {
			addCriterion("SUB_VERSION in", values, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionNotIn(List<Byte> values) {
			addCriterion("SUB_VERSION not in", values, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionBetween(Byte value1, Byte value2) {
			addCriterion("SUB_VERSION between", value1, value2, "subVersion");
			return (Criteria) this;
		}

		public Criteria andSubVersionNotBetween(Byte value1, Byte value2) {
			addCriterion("SUB_VERSION not between", value1, value2, "subVersion");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaIsNull() {
			addCriterion("AUTO_PUBLISH_YOUJIA is null");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaIsNotNull() {
			addCriterion("AUTO_PUBLISH_YOUJIA is not null");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaEqualTo(Byte value) {
			addCriterion("AUTO_PUBLISH_YOUJIA =", value, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaNotEqualTo(Byte value) {
			addCriterion("AUTO_PUBLISH_YOUJIA <>", value, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaGreaterThan(Byte value) {
			addCriterion("AUTO_PUBLISH_YOUJIA >", value, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUTO_PUBLISH_YOUJIA >=", value, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaLessThan(Byte value) {
			addCriterion("AUTO_PUBLISH_YOUJIA <", value, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaLessThanOrEqualTo(Byte value) {
			addCriterion("AUTO_PUBLISH_YOUJIA <=", value, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaIn(List<Byte> values) {
			addCriterion("AUTO_PUBLISH_YOUJIA in", values, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaNotIn(List<Byte> values) {
			addCriterion("AUTO_PUBLISH_YOUJIA not in", values, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaBetween(Byte value1, Byte value2) {
			addCriterion("AUTO_PUBLISH_YOUJIA between", value1, value2, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andAutoPublishYoujiaNotBetween(Byte value1, Byte value2) {
			addCriterion("AUTO_PUBLISH_YOUJIA not between", value1, value2, "autoPublishYoujia");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyIsNull() {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyIsNotNull() {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY =", value, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyNotEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY <>", value, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyGreaterThan(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY >", value, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY >=", value, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyLessThan(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY <", value, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyLessThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY <=", value, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY in", values, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyNotIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY not in", values, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY between", value1, value2, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareBuyNotBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_BUY not between", value1, value2, "youjiaDeptCustmaxshareBuy");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentIsNull() {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentIsNotNull() {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT =", value, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentNotEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT <>", value, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentGreaterThan(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT >", value, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT >=", value, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentLessThan(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT <", value, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentLessThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT <=", value, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT in", values, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentNotIn(List<Integer> values) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT not in", values, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT between", value1, value2, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andYoujiaDeptCustmaxshareRentNotBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_DEPT_CUSTMAXSHARE_RENT not between", value1, value2, "youjiaDeptCustmaxshareRent");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusIsNull() {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusIsNotNull() {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusEqualTo(Byte value) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS =", value, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusNotEqualTo(Byte value) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS <>", value, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusGreaterThan(Byte value) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS >", value, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS >=", value, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusLessThan(Byte value) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS <", value, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS <=", value, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusIn(List<Byte> values) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS in", values, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusNotIn(List<Byte> values) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS not in", values, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS between", value1, value2, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andOpenMicroProgramStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_MICRO_PROGRAM_STATUS not between", value1, value2, "openMicroProgramStatus");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeIsNull() {
			addCriterion("WX_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeIsNotNull() {
			addCriterion("WX_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeEqualTo(Date value) {
			addCriterion("WX_END_TIME =", value, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeNotEqualTo(Date value) {
			addCriterion("WX_END_TIME <>", value, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeGreaterThan(Date value) {
			addCriterion("WX_END_TIME >", value, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("WX_END_TIME >=", value, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeLessThan(Date value) {
			addCriterion("WX_END_TIME <", value, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("WX_END_TIME <=", value, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeIn(List<Date> values) {
			addCriterion("WX_END_TIME in", values, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeNotIn(List<Date> values) {
			addCriterion("WX_END_TIME not in", values, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeBetween(Date value1, Date value2) {
			addCriterion("WX_END_TIME between", value1, value2, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("WX_END_TIME not between", value1, value2, "wxEndTime");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeIsNull() {
			addCriterion("WX_PAY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeIsNotNull() {
			addCriterion("WX_PAY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeEqualTo(Byte value) {
			addCriterion("WX_PAY_TYPE =", value, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeNotEqualTo(Byte value) {
			addCriterion("WX_PAY_TYPE <>", value, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeGreaterThan(Byte value) {
			addCriterion("WX_PAY_TYPE >", value, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("WX_PAY_TYPE >=", value, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeLessThan(Byte value) {
			addCriterion("WX_PAY_TYPE <", value, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeLessThanOrEqualTo(Byte value) {
			addCriterion("WX_PAY_TYPE <=", value, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeIn(List<Byte> values) {
			addCriterion("WX_PAY_TYPE in", values, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeNotIn(List<Byte> values) {
			addCriterion("WX_PAY_TYPE not in", values, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeBetween(Byte value1, Byte value2) {
			addCriterion("WX_PAY_TYPE between", value1, value2, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andWxPayTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("WX_PAY_TYPE not between", value1, value2, "wxPayType");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionIsNull() {
			addCriterion("MICRO_PROGRAM_VERSION is null");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionIsNotNull() {
			addCriterion("MICRO_PROGRAM_VERSION is not null");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_VERSION =", value, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionNotEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_VERSION <>", value, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionGreaterThan(Byte value) {
			addCriterion("MICRO_PROGRAM_VERSION >", value, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionGreaterThanOrEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_VERSION >=", value, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionLessThan(Byte value) {
			addCriterion("MICRO_PROGRAM_VERSION <", value, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionLessThanOrEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_VERSION <=", value, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionIn(List<Byte> values) {
			addCriterion("MICRO_PROGRAM_VERSION in", values, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionNotIn(List<Byte> values) {
			addCriterion("MICRO_PROGRAM_VERSION not in", values, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionBetween(Byte value1, Byte value2) {
			addCriterion("MICRO_PROGRAM_VERSION between", value1, value2, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andMicroProgramVersionNotBetween(Byte value1, Byte value2) {
			addCriterion("MICRO_PROGRAM_VERSION not between", value1, value2, "microProgramVersion");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameIsNull() {
			addCriterion("ERP_SYSTEM_NAME is null");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameIsNotNull() {
			addCriterion("ERP_SYSTEM_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAME =", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameNotEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAME <>", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameGreaterThan(String value) {
			addCriterion("ERP_SYSTEM_NAME >", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameGreaterThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAME >=", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameLessThan(String value) {
			addCriterion("ERP_SYSTEM_NAME <", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameLessThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAME <=", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameLike(String value) {
			addCriterion("ERP_SYSTEM_NAME like", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameNotLike(String value) {
			addCriterion("ERP_SYSTEM_NAME not like", value, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameIn(List<String> values) {
			addCriterion("ERP_SYSTEM_NAME in", values, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameNotIn(List<String> values) {
			addCriterion("ERP_SYSTEM_NAME not in", values, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_NAME between", value1, value2, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemNameNotBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_NAME not between", value1, value2, "erpSystemName");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconIsNull() {
			addCriterion("ERP_SYSTEM_ICON is null");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconIsNotNull() {
			addCriterion("ERP_SYSTEM_ICON is not null");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconEqualTo(String value) {
			addCriterion("ERP_SYSTEM_ICON =", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconNotEqualTo(String value) {
			addCriterion("ERP_SYSTEM_ICON <>", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconGreaterThan(String value) {
			addCriterion("ERP_SYSTEM_ICON >", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconGreaterThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_ICON >=", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconLessThan(String value) {
			addCriterion("ERP_SYSTEM_ICON <", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconLessThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_ICON <=", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconLike(String value) {
			addCriterion("ERP_SYSTEM_ICON like", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconNotLike(String value) {
			addCriterion("ERP_SYSTEM_ICON not like", value, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconIn(List<String> values) {
			addCriterion("ERP_SYSTEM_ICON in", values, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconNotIn(List<String> values) {
			addCriterion("ERP_SYSTEM_ICON not in", values, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_ICON between", value1, value2, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemIconNotBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_ICON not between", value1, value2, "erpSystemIcon");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundIsNull() {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND is null");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundIsNotNull() {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND is not null");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND =", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundNotEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND <>", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundGreaterThan(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND >", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundGreaterThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND >=", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundLessThan(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND <", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundLessThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND <=", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundLike(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND like", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundNotLike(String value) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND not like", value, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundIn(List<String> values) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND in", values, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundNotIn(List<String> values) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND not in", values, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND between", value1, value2, "erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemNavigationBackgroundNotBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND not between", value1, value2,
					"erpSystemNavigationBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundIsNull() {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND is null");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundIsNotNull() {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND is not null");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundEqualTo(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND =", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundNotEqualTo(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND <>", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundGreaterThan(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND >", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundGreaterThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND >=", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundLessThan(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND <", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundLessThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND <=", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundLike(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND like", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundNotLike(String value) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND not like", value, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundIn(List<String> values) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND in", values, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundNotIn(List<String> values) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND not in", values, "erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND between", value1, value2,
					"erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemPopupWindowBackgroundNotBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND not between", value1, value2,
					"erpSystemPopupWindowBackground");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalIsNull() {
			addCriterion("ERP_SYSTEM_TONAL is null");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalIsNotNull() {
			addCriterion("ERP_SYSTEM_TONAL is not null");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalEqualTo(String value) {
			addCriterion("ERP_SYSTEM_TONAL =", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalNotEqualTo(String value) {
			addCriterion("ERP_SYSTEM_TONAL <>", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalGreaterThan(String value) {
			addCriterion("ERP_SYSTEM_TONAL >", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalGreaterThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_TONAL >=", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalLessThan(String value) {
			addCriterion("ERP_SYSTEM_TONAL <", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalLessThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_TONAL <=", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalLike(String value) {
			addCriterion("ERP_SYSTEM_TONAL like", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalNotLike(String value) {
			addCriterion("ERP_SYSTEM_TONAL not like", value, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalIn(List<String> values) {
			addCriterion("ERP_SYSTEM_TONAL in", values, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalNotIn(List<String> values) {
			addCriterion("ERP_SYSTEM_TONAL not in", values, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_TONAL between", value1, value2, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andErpSystemTonalNotBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_TONAL not between", value1, value2, "erpSystemTonal");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNull() {
			addCriterion("CHANNEL_ID is null");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNotNull() {
			addCriterion("CHANNEL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andChannelIdEqualTo(Integer value) {
			addCriterion("CHANNEL_ID =", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotEqualTo(Integer value) {
			addCriterion("CHANNEL_ID <>", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThan(Integer value) {
			addCriterion("CHANNEL_ID >", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CHANNEL_ID >=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThan(Integer value) {
			addCriterion("CHANNEL_ID <", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
			addCriterion("CHANNEL_ID <=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdIn(List<Integer> values) {
			addCriterion("CHANNEL_ID in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotIn(List<Integer> values) {
			addCriterion("CHANNEL_ID not in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdBetween(Integer value1, Integer value2) {
			addCriterion("CHANNEL_ID between", value1, value2, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CHANNEL_ID not between", value1, value2, "channelId");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkIsNull() {
			addCriterion("CHAIN_CUSTOMER_MARK is null");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkIsNotNull() {
			addCriterion("CHAIN_CUSTOMER_MARK is not null");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkEqualTo(Integer value) {
			addCriterion("CHAIN_CUSTOMER_MARK =", value, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkNotEqualTo(Integer value) {
			addCriterion("CHAIN_CUSTOMER_MARK <>", value, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkGreaterThan(Integer value) {
			addCriterion("CHAIN_CUSTOMER_MARK >", value, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkGreaterThanOrEqualTo(Integer value) {
			addCriterion("CHAIN_CUSTOMER_MARK >=", value, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkLessThan(Integer value) {
			addCriterion("CHAIN_CUSTOMER_MARK <", value, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkLessThanOrEqualTo(Integer value) {
			addCriterion("CHAIN_CUSTOMER_MARK <=", value, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkIn(List<Integer> values) {
			addCriterion("CHAIN_CUSTOMER_MARK in", values, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkNotIn(List<Integer> values) {
			addCriterion("CHAIN_CUSTOMER_MARK not in", values, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkBetween(Integer value1, Integer value2) {
			addCriterion("CHAIN_CUSTOMER_MARK between", value1, value2, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andChainCustomerMarkNotBetween(Integer value1, Integer value2) {
			addCriterion("CHAIN_CUSTOMER_MARK not between", value1, value2, "chainCustomerMark");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusIsNull() {
			addCriterion("MICRO_PROGRAM_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusIsNotNull() {
			addCriterion("MICRO_PROGRAM_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_STATUS =", value, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusNotEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_STATUS <>", value, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusGreaterThan(Byte value) {
			addCriterion("MICRO_PROGRAM_STATUS >", value, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_STATUS >=", value, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusLessThan(Byte value) {
			addCriterion("MICRO_PROGRAM_STATUS <", value, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusLessThanOrEqualTo(Byte value) {
			addCriterion("MICRO_PROGRAM_STATUS <=", value, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusIn(List<Byte> values) {
			addCriterion("MICRO_PROGRAM_STATUS in", values, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusNotIn(List<Byte> values) {
			addCriterion("MICRO_PROGRAM_STATUS not in", values, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusBetween(Byte value1, Byte value2) {
			addCriterion("MICRO_PROGRAM_STATUS between", value1, value2, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andMicroProgramStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("MICRO_PROGRAM_STATUS not between", value1, value2, "microProgramStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoIsNull() {
			addCriterion("BUSINESS_LICENSE_NO is null");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoIsNotNull() {
			addCriterion("BUSINESS_LICENSE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_NO =", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoNotEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_NO <>", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoGreaterThan(String value) {
			addCriterion("BUSINESS_LICENSE_NO >", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoGreaterThanOrEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_NO >=", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoLessThan(String value) {
			addCriterion("BUSINESS_LICENSE_NO <", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoLessThanOrEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_NO <=", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoLike(String value) {
			addCriterion("BUSINESS_LICENSE_NO like", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoNotLike(String value) {
			addCriterion("BUSINESS_LICENSE_NO not like", value, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoIn(List<String> values) {
			addCriterion("BUSINESS_LICENSE_NO in", values, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoNotIn(List<String> values) {
			addCriterion("BUSINESS_LICENSE_NO not in", values, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoBetween(String value1, String value2) {
			addCriterion("BUSINESS_LICENSE_NO between", value1, value2, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andBusinessLicenseNoNotBetween(String value1, String value2) {
			addCriterion("BUSINESS_LICENSE_NO not between", value1, value2, "businessLicenseNo");
			return (Criteria) this;
		}

		public Criteria andCompScaleIsNull() {
			addCriterion("COMP_SCALE is null");
			return (Criteria) this;
		}

		public Criteria andCompScaleIsNotNull() {
			addCriterion("COMP_SCALE is not null");
			return (Criteria) this;
		}

		public Criteria andCompScaleEqualTo(Byte value) {
			addCriterion("COMP_SCALE =", value, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleNotEqualTo(Byte value) {
			addCriterion("COMP_SCALE <>", value, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleGreaterThan(Byte value) {
			addCriterion("COMP_SCALE >", value, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_SCALE >=", value, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleLessThan(Byte value) {
			addCriterion("COMP_SCALE <", value, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_SCALE <=", value, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleIn(List<Byte> values) {
			addCriterion("COMP_SCALE in", values, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleNotIn(List<Byte> values) {
			addCriterion("COMP_SCALE not in", values, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleBetween(Byte value1, Byte value2) {
			addCriterion("COMP_SCALE between", value1, value2, "compScale");
			return (Criteria) this;
		}

		public Criteria andCompScaleNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_SCALE not between", value1, value2, "compScale");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlIsNull() {
			addCriterion("BUSINESS_LICENSE_PIC_URL is null");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlIsNotNull() {
			addCriterion("BUSINESS_LICENSE_PIC_URL is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL =", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlNotEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL <>", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlGreaterThan(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL >", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlGreaterThanOrEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL >=", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlLessThan(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL <", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlLessThanOrEqualTo(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL <=", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlLike(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL like", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlNotLike(String value) {
			addCriterion("BUSINESS_LICENSE_PIC_URL not like", value, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlIn(List<String> values) {
			addCriterion("BUSINESS_LICENSE_PIC_URL in", values, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlNotIn(List<String> values) {
			addCriterion("BUSINESS_LICENSE_PIC_URL not in", values, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlBetween(String value1, String value2) {
			addCriterion("BUSINESS_LICENSE_PIC_URL between", value1, value2, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andBusinessLicensePicUrlNotBetween(String value1, String value2) {
			addCriterion("BUSINESS_LICENSE_PIC_URL not between", value1, value2, "businessLicensePicUrl");
			return (Criteria) this;
		}

		public Criteria andTrialStatusIsNull() {
			addCriterion("TRIAL_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andTrialStatusIsNotNull() {
			addCriterion("TRIAL_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andTrialStatusEqualTo(Byte value) {
			addCriterion("TRIAL_STATUS =", value, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusNotEqualTo(Byte value) {
			addCriterion("TRIAL_STATUS <>", value, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusGreaterThan(Byte value) {
			addCriterion("TRIAL_STATUS >", value, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRIAL_STATUS >=", value, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusLessThan(Byte value) {
			addCriterion("TRIAL_STATUS <", value, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusLessThanOrEqualTo(Byte value) {
			addCriterion("TRIAL_STATUS <=", value, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusIn(List<Byte> values) {
			addCriterion("TRIAL_STATUS in", values, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusNotIn(List<Byte> values) {
			addCriterion("TRIAL_STATUS not in", values, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusBetween(Byte value1, Byte value2) {
			addCriterion("TRIAL_STATUS between", value1, value2, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andTrialStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("TRIAL_STATUS not between", value1, value2, "trialStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusIsNull() {
			addCriterion("JOIN_INTENTION_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusIsNotNull() {
			addCriterion("JOIN_INTENTION_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusEqualTo(Integer value) {
			addCriterion("JOIN_INTENTION_STATUS =", value, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusNotEqualTo(Integer value) {
			addCriterion("JOIN_INTENTION_STATUS <>", value, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusGreaterThan(Integer value) {
			addCriterion("JOIN_INTENTION_STATUS >", value, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("JOIN_INTENTION_STATUS >=", value, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusLessThan(Integer value) {
			addCriterion("JOIN_INTENTION_STATUS <", value, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusLessThanOrEqualTo(Integer value) {
			addCriterion("JOIN_INTENTION_STATUS <=", value, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusIn(List<Integer> values) {
			addCriterion("JOIN_INTENTION_STATUS in", values, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusNotIn(List<Integer> values) {
			addCriterion("JOIN_INTENTION_STATUS not in", values, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusBetween(Integer value1, Integer value2) {
			addCriterion("JOIN_INTENTION_STATUS between", value1, value2, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andJoinIntentionStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("JOIN_INTENTION_STATUS not between", value1, value2, "joinIntentionStatus");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyIsNull() {
			addCriterion("CUSTOM_HTTP_KEY is null");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyIsNotNull() {
			addCriterion("CUSTOM_HTTP_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyEqualTo(String value) {
			addCriterion("CUSTOM_HTTP_KEY =", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyNotEqualTo(String value) {
			addCriterion("CUSTOM_HTTP_KEY <>", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyGreaterThan(String value) {
			addCriterion("CUSTOM_HTTP_KEY >", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyGreaterThanOrEqualTo(String value) {
			addCriterion("CUSTOM_HTTP_KEY >=", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyLessThan(String value) {
			addCriterion("CUSTOM_HTTP_KEY <", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyLessThanOrEqualTo(String value) {
			addCriterion("CUSTOM_HTTP_KEY <=", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyLike(String value) {
			addCriterion("CUSTOM_HTTP_KEY like", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyNotLike(String value) {
			addCriterion("CUSTOM_HTTP_KEY not like", value, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyIn(List<String> values) {
			addCriterion("CUSTOM_HTTP_KEY in", values, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyNotIn(List<String> values) {
			addCriterion("CUSTOM_HTTP_KEY not in", values, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyBetween(String value1, String value2) {
			addCriterion("CUSTOM_HTTP_KEY between", value1, value2, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCustomHttpKeyNotBetween(String value1, String value2) {
			addCriterion("CUSTOM_HTTP_KEY not between", value1, value2, "customHttpKey");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdIsNull() {
			addCriterion("CREATE_PUSHER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdIsNotNull() {
			addCriterion("CREATE_PUSHER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdEqualTo(Integer value) {
			addCriterion("CREATE_PUSHER_ID =", value, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdNotEqualTo(Integer value) {
			addCriterion("CREATE_PUSHER_ID <>", value, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdGreaterThan(Integer value) {
			addCriterion("CREATE_PUSHER_ID >", value, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_PUSHER_ID >=", value, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdLessThan(Integer value) {
			addCriterion("CREATE_PUSHER_ID <", value, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_PUSHER_ID <=", value, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdIn(List<Integer> values) {
			addCriterion("CREATE_PUSHER_ID in", values, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdNotIn(List<Integer> values) {
			addCriterion("CREATE_PUSHER_ID not in", values, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_PUSHER_ID between", value1, value2, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andCreatePusherIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_PUSHER_ID not between", value1, value2, "createPusherId");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoIsNull() {
			addCriterion("ERP_SYSTEM_LOGO is null");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoIsNotNull() {
			addCriterion("ERP_SYSTEM_LOGO is not null");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoEqualTo(String value) {
			addCriterion("ERP_SYSTEM_LOGO =", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoNotEqualTo(String value) {
			addCriterion("ERP_SYSTEM_LOGO <>", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoGreaterThan(String value) {
			addCriterion("ERP_SYSTEM_LOGO >", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoGreaterThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_LOGO >=", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoLessThan(String value) {
			addCriterion("ERP_SYSTEM_LOGO <", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoLessThanOrEqualTo(String value) {
			addCriterion("ERP_SYSTEM_LOGO <=", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoLike(String value) {
			addCriterion("ERP_SYSTEM_LOGO like", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoNotLike(String value) {
			addCriterion("ERP_SYSTEM_LOGO not like", value, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoIn(List<String> values) {
			addCriterion("ERP_SYSTEM_LOGO in", values, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoNotIn(List<String> values) {
			addCriterion("ERP_SYSTEM_LOGO not in", values, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_LOGO between", value1, value2, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andErpSystemLogoNotBetween(String value1, String value2) {
			addCriterion("ERP_SYSTEM_LOGO not between", value1, value2, "erpSystemLogo");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureIsNull() {
			addCriterion("APP_SYSTEM_START_FIGURE is null");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureIsNotNull() {
			addCriterion("APP_SYSTEM_START_FIGURE is not null");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureEqualTo(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE =", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureNotEqualTo(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE <>", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureGreaterThan(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE >", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureGreaterThanOrEqualTo(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE >=", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureLessThan(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE <", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureLessThanOrEqualTo(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE <=", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureLike(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE like", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureNotLike(String value) {
			addCriterion("APP_SYSTEM_START_FIGURE not like", value, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureIn(List<String> values) {
			addCriterion("APP_SYSTEM_START_FIGURE in", values, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureNotIn(List<String> values) {
			addCriterion("APP_SYSTEM_START_FIGURE not in", values, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureBetween(String value1, String value2) {
			addCriterion("APP_SYSTEM_START_FIGURE between", value1, value2, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andAppSystemStartFigureNotBetween(String value1, String value2) {
			addCriterion("APP_SYSTEM_START_FIGURE not between", value1, value2, "appSystemStartFigure");
			return (Criteria) this;
		}

		public Criteria andPackageTypeIsNull() {
			addCriterion("PACKAGE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPackageTypeIsNotNull() {
			addCriterion("PACKAGE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPackageTypeEqualTo(Byte value) {
			addCriterion("PACKAGE_TYPE =", value, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeNotEqualTo(Byte value) {
			addCriterion("PACKAGE_TYPE <>", value, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeGreaterThan(Byte value) {
			addCriterion("PACKAGE_TYPE >", value, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PACKAGE_TYPE >=", value, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeLessThan(Byte value) {
			addCriterion("PACKAGE_TYPE <", value, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PACKAGE_TYPE <=", value, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeIn(List<Byte> values) {
			addCriterion("PACKAGE_TYPE in", values, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeNotIn(List<Byte> values) {
			addCriterion("PACKAGE_TYPE not in", values, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeBetween(Byte value1, Byte value2) {
			addCriterion("PACKAGE_TYPE between", value1, value2, "packageType");
			return (Criteria) this;
		}

		public Criteria andPackageTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PACKAGE_TYPE not between", value1, value2, "packageType");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsIsNull() {
			addCriterion("KA_DEPT_TOTAL_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsIsNotNull() {
			addCriterion("KA_DEPT_TOTAL_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsEqualTo(Integer value) {
			addCriterion("KA_DEPT_TOTAL_NUMS =", value, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsNotEqualTo(Integer value) {
			addCriterion("KA_DEPT_TOTAL_NUMS <>", value, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsGreaterThan(Integer value) {
			addCriterion("KA_DEPT_TOTAL_NUMS >", value, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("KA_DEPT_TOTAL_NUMS >=", value, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsLessThan(Integer value) {
			addCriterion("KA_DEPT_TOTAL_NUMS <", value, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsLessThanOrEqualTo(Integer value) {
			addCriterion("KA_DEPT_TOTAL_NUMS <=", value, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsIn(List<Integer> values) {
			addCriterion("KA_DEPT_TOTAL_NUMS in", values, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsNotIn(List<Integer> values) {
			addCriterion("KA_DEPT_TOTAL_NUMS not in", values, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsBetween(Integer value1, Integer value2) {
			addCriterion("KA_DEPT_TOTAL_NUMS between", value1, value2, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptTotalNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("KA_DEPT_TOTAL_NUMS not between", value1, value2, "kaDeptTotalNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsIsNull() {
			addCriterion("KA_DEPT_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsIsNotNull() {
			addCriterion("KA_DEPT_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsEqualTo(Integer value) {
			addCriterion("KA_DEPT_NUMS =", value, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsNotEqualTo(Integer value) {
			addCriterion("KA_DEPT_NUMS <>", value, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsGreaterThan(Integer value) {
			addCriterion("KA_DEPT_NUMS >", value, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("KA_DEPT_NUMS >=", value, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsLessThan(Integer value) {
			addCriterion("KA_DEPT_NUMS <", value, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsLessThanOrEqualTo(Integer value) {
			addCriterion("KA_DEPT_NUMS <=", value, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsIn(List<Integer> values) {
			addCriterion("KA_DEPT_NUMS in", values, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsNotIn(List<Integer> values) {
			addCriterion("KA_DEPT_NUMS not in", values, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsBetween(Integer value1, Integer value2) {
			addCriterion("KA_DEPT_NUMS between", value1, value2, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaDeptNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("KA_DEPT_NUMS not between", value1, value2, "kaDeptNums");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeIsNull() {
			addCriterion("KA_PACKAGE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeIsNotNull() {
			addCriterion("KA_PACKAGE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeEqualTo(Byte value) {
			addCriterion("KA_PACKAGE_TYPE =", value, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeNotEqualTo(Byte value) {
			addCriterion("KA_PACKAGE_TYPE <>", value, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeGreaterThan(Byte value) {
			addCriterion("KA_PACKAGE_TYPE >", value, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("KA_PACKAGE_TYPE >=", value, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeLessThan(Byte value) {
			addCriterion("KA_PACKAGE_TYPE <", value, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeLessThanOrEqualTo(Byte value) {
			addCriterion("KA_PACKAGE_TYPE <=", value, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeIn(List<Byte> values) {
			addCriterion("KA_PACKAGE_TYPE in", values, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeNotIn(List<Byte> values) {
			addCriterion("KA_PACKAGE_TYPE not in", values, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeBetween(Byte value1, Byte value2) {
			addCriterion("KA_PACKAGE_TYPE between", value1, value2, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andKaPackageTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("KA_PACKAGE_TYPE not between", value1, value2, "kaPackageType");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddIsNull() {
			addCriterion("IS_OPEN_FDD is null");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddIsNotNull() {
			addCriterion("IS_OPEN_FDD is not null");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddEqualTo(Byte value) {
			addCriterion("IS_OPEN_FDD =", value, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddNotEqualTo(Byte value) {
			addCriterion("IS_OPEN_FDD <>", value, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddGreaterThan(Byte value) {
			addCriterion("IS_OPEN_FDD >", value, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_OPEN_FDD >=", value, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddLessThan(Byte value) {
			addCriterion("IS_OPEN_FDD <", value, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddLessThanOrEqualTo(Byte value) {
			addCriterion("IS_OPEN_FDD <=", value, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddIn(List<Byte> values) {
			addCriterion("IS_OPEN_FDD in", values, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddNotIn(List<Byte> values) {
			addCriterion("IS_OPEN_FDD not in", values, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddBetween(Byte value1, Byte value2) {
			addCriterion("IS_OPEN_FDD between", value1, value2, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsOpenFddNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_OPEN_FDD not between", value1, value2, "isOpenFdd");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataIsNull() {
			addCriterion("IS_SYNC_FDD_DATA is null");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataIsNotNull() {
			addCriterion("IS_SYNC_FDD_DATA is not null");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataEqualTo(Byte value) {
			addCriterion("IS_SYNC_FDD_DATA =", value, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataNotEqualTo(Byte value) {
			addCriterion("IS_SYNC_FDD_DATA <>", value, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataGreaterThan(Byte value) {
			addCriterion("IS_SYNC_FDD_DATA >", value, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SYNC_FDD_DATA >=", value, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataLessThan(Byte value) {
			addCriterion("IS_SYNC_FDD_DATA <", value, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SYNC_FDD_DATA <=", value, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataIn(List<Byte> values) {
			addCriterion("IS_SYNC_FDD_DATA in", values, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataNotIn(List<Byte> values) {
			addCriterion("IS_SYNC_FDD_DATA not in", values, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataBetween(Byte value1, Byte value2) {
			addCriterion("IS_SYNC_FDD_DATA between", value1, value2, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andIsSyncFddDataNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SYNC_FDD_DATA not between", value1, value2, "isSyncFddData");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumIsNull() {
			addCriterion("COMP_DEPTS_NUM is null");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumIsNotNull() {
			addCriterion("COMP_DEPTS_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumEqualTo(Integer value) {
			addCriterion("COMP_DEPTS_NUM =", value, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumNotEqualTo(Integer value) {
			addCriterion("COMP_DEPTS_NUM <>", value, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumGreaterThan(Integer value) {
			addCriterion("COMP_DEPTS_NUM >", value, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMP_DEPTS_NUM >=", value, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumLessThan(Integer value) {
			addCriterion("COMP_DEPTS_NUM <", value, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumLessThanOrEqualTo(Integer value) {
			addCriterion("COMP_DEPTS_NUM <=", value, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumIn(List<Integer> values) {
			addCriterion("COMP_DEPTS_NUM in", values, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumNotIn(List<Integer> values) {
			addCriterion("COMP_DEPTS_NUM not in", values, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumBetween(Integer value1, Integer value2) {
			addCriterion("COMP_DEPTS_NUM between", value1, value2, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andCompDeptsNumNotBetween(Integer value1, Integer value2) {
			addCriterion("COMP_DEPTS_NUM not between", value1, value2, "compDeptsNum");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationIsNull() {
			addCriterion("IS_CUSTOMIZATION is null");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationIsNotNull() {
			addCriterion("IS_CUSTOMIZATION is not null");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationEqualTo(Byte value) {
			addCriterion("IS_CUSTOMIZATION =", value, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationNotEqualTo(Byte value) {
			addCriterion("IS_CUSTOMIZATION <>", value, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationGreaterThan(Byte value) {
			addCriterion("IS_CUSTOMIZATION >", value, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_CUSTOMIZATION >=", value, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationLessThan(Byte value) {
			addCriterion("IS_CUSTOMIZATION <", value, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationLessThanOrEqualTo(Byte value) {
			addCriterion("IS_CUSTOMIZATION <=", value, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationIn(List<Byte> values) {
			addCriterion("IS_CUSTOMIZATION in", values, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationNotIn(List<Byte> values) {
			addCriterion("IS_CUSTOMIZATION not in", values, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationBetween(Byte value1, Byte value2) {
			addCriterion("IS_CUSTOMIZATION between", value1, value2, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andIsCustomizationNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_CUSTOMIZATION not between", value1, value2, "isCustomization");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreIsNull() {
			addCriterion("FLAGSHIP_STORE is null");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreIsNotNull() {
			addCriterion("FLAGSHIP_STORE is not null");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreEqualTo(Byte value) {
			addCriterion("FLAGSHIP_STORE =", value, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreNotEqualTo(Byte value) {
			addCriterion("FLAGSHIP_STORE <>", value, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreGreaterThan(Byte value) {
			addCriterion("FLAGSHIP_STORE >", value, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreGreaterThanOrEqualTo(Byte value) {
			addCriterion("FLAGSHIP_STORE >=", value, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreLessThan(Byte value) {
			addCriterion("FLAGSHIP_STORE <", value, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreLessThanOrEqualTo(Byte value) {
			addCriterion("FLAGSHIP_STORE <=", value, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreIn(List<Byte> values) {
			addCriterion("FLAGSHIP_STORE in", values, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreNotIn(List<Byte> values) {
			addCriterion("FLAGSHIP_STORE not in", values, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreBetween(Byte value1, Byte value2) {
			addCriterion("FLAGSHIP_STORE between", value1, value2, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andFlagshipStoreNotBetween(Byte value1, Byte value2) {
			addCriterion("FLAGSHIP_STORE not between", value1, value2, "flagshipStore");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanIsNull() {
			addCriterion("IS_OPEN_SALE_QUAN is null");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanIsNotNull() {
			addCriterion("IS_OPEN_SALE_QUAN is not null");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanEqualTo(Byte value) {
			addCriterion("IS_OPEN_SALE_QUAN =", value, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanNotEqualTo(Byte value) {
			addCriterion("IS_OPEN_SALE_QUAN <>", value, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanGreaterThan(Byte value) {
			addCriterion("IS_OPEN_SALE_QUAN >", value, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_OPEN_SALE_QUAN >=", value, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanLessThan(Byte value) {
			addCriterion("IS_OPEN_SALE_QUAN <", value, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanLessThanOrEqualTo(Byte value) {
			addCriterion("IS_OPEN_SALE_QUAN <=", value, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanIn(List<Byte> values) {
			addCriterion("IS_OPEN_SALE_QUAN in", values, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanNotIn(List<Byte> values) {
			addCriterion("IS_OPEN_SALE_QUAN not in", values, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanBetween(Byte value1, Byte value2) {
			addCriterion("IS_OPEN_SALE_QUAN between", value1, value2, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andIsOpenSaleQuanNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_OPEN_SALE_QUAN not between", value1, value2, "isOpenSaleQuan");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeIsNull() {
			addCriterion("FIRST_DEPT_FORM_TIME is null");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeIsNotNull() {
			addCriterion("FIRST_DEPT_FORM_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeEqualTo(Date value) {
			addCriterion("FIRST_DEPT_FORM_TIME =", value, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeNotEqualTo(Date value) {
			addCriterion("FIRST_DEPT_FORM_TIME <>", value, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeGreaterThan(Date value) {
			addCriterion("FIRST_DEPT_FORM_TIME >", value, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_DEPT_FORM_TIME >=", value, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeLessThan(Date value) {
			addCriterion("FIRST_DEPT_FORM_TIME <", value, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_DEPT_FORM_TIME <=", value, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeIn(List<Date> values) {
			addCriterion("FIRST_DEPT_FORM_TIME in", values, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeNotIn(List<Date> values) {
			addCriterion("FIRST_DEPT_FORM_TIME not in", values, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeBetween(Date value1, Date value2) {
			addCriterion("FIRST_DEPT_FORM_TIME between", value1, value2, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andFirstDeptFormTimeNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_DEPT_FORM_TIME not between", value1, value2, "firstDeptFormTime");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedIsNull() {
			addCriterion("SPECIAL_CUSTOMIZED is null");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedIsNotNull() {
			addCriterion("SPECIAL_CUSTOMIZED is not null");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedEqualTo(Byte value) {
			addCriterion("SPECIAL_CUSTOMIZED =", value, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedNotEqualTo(Byte value) {
			addCriterion("SPECIAL_CUSTOMIZED <>", value, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedGreaterThan(Byte value) {
			addCriterion("SPECIAL_CUSTOMIZED >", value, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedGreaterThanOrEqualTo(Byte value) {
			addCriterion("SPECIAL_CUSTOMIZED >=", value, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedLessThan(Byte value) {
			addCriterion("SPECIAL_CUSTOMIZED <", value, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedLessThanOrEqualTo(Byte value) {
			addCriterion("SPECIAL_CUSTOMIZED <=", value, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedIn(List<Byte> values) {
			addCriterion("SPECIAL_CUSTOMIZED in", values, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedNotIn(List<Byte> values) {
			addCriterion("SPECIAL_CUSTOMIZED not in", values, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedBetween(Byte value1, Byte value2) {
			addCriterion("SPECIAL_CUSTOMIZED between", value1, value2, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andSpecialCustomizedNotBetween(Byte value1, Byte value2) {
			addCriterion("SPECIAL_CUSTOMIZED not between", value1, value2, "specialCustomized");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractIsNull() {
			addCriterion("OPEN_ONLINE_CONTRACT is null");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractIsNotNull() {
			addCriterion("OPEN_ONLINE_CONTRACT is not null");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractEqualTo(Byte value) {
			addCriterion("OPEN_ONLINE_CONTRACT =", value, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractNotEqualTo(Byte value) {
			addCriterion("OPEN_ONLINE_CONTRACT <>", value, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractGreaterThan(Byte value) {
			addCriterion("OPEN_ONLINE_CONTRACT >", value, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_ONLINE_CONTRACT >=", value, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractLessThan(Byte value) {
			addCriterion("OPEN_ONLINE_CONTRACT <", value, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_ONLINE_CONTRACT <=", value, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractIn(List<Byte> values) {
			addCriterion("OPEN_ONLINE_CONTRACT in", values, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractNotIn(List<Byte> values) {
			addCriterion("OPEN_ONLINE_CONTRACT not in", values, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_ONLINE_CONTRACT between", value1, value2, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andOpenOnlineContractNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_ONLINE_CONTRACT not between", value1, value2, "openOnlineContract");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelIsNull() {
			addCriterion("COMP_MANAGEMENT_MODEL is null");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelIsNotNull() {
			addCriterion("COMP_MANAGEMENT_MODEL is not null");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelEqualTo(Byte value) {
			addCriterion("COMP_MANAGEMENT_MODEL =", value, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelNotEqualTo(Byte value) {
			addCriterion("COMP_MANAGEMENT_MODEL <>", value, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelGreaterThan(Byte value) {
			addCriterion("COMP_MANAGEMENT_MODEL >", value, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMP_MANAGEMENT_MODEL >=", value, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelLessThan(Byte value) {
			addCriterion("COMP_MANAGEMENT_MODEL <", value, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelLessThanOrEqualTo(Byte value) {
			addCriterion("COMP_MANAGEMENT_MODEL <=", value, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelIn(List<Byte> values) {
			addCriterion("COMP_MANAGEMENT_MODEL in", values, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelNotIn(List<Byte> values) {
			addCriterion("COMP_MANAGEMENT_MODEL not in", values, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelBetween(Byte value1, Byte value2) {
			addCriterion("COMP_MANAGEMENT_MODEL between", value1, value2, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCompManagementModelNotBetween(Byte value1, Byte value2) {
			addCriterion("COMP_MANAGEMENT_MODEL not between", value1, value2, "compManagementModel");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeIsNull() {
			addCriterion("CUSTOMIZED_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeIsNotNull() {
			addCriterion("CUSTOMIZED_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeEqualTo(Integer value) {
			addCriterion("CUSTOMIZED_TYPE =", value, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeNotEqualTo(Integer value) {
			addCriterion("CUSTOMIZED_TYPE <>", value, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeGreaterThan(Integer value) {
			addCriterion("CUSTOMIZED_TYPE >", value, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMIZED_TYPE >=", value, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeLessThan(Integer value) {
			addCriterion("CUSTOMIZED_TYPE <", value, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMIZED_TYPE <=", value, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeIn(List<Integer> values) {
			addCriterion("CUSTOMIZED_TYPE in", values, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeNotIn(List<Integer> values) {
			addCriterion("CUSTOMIZED_TYPE not in", values, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMIZED_TYPE between", value1, value2, "customizedType");
			return (Criteria) this;
		}

		public Criteria andCustomizedTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMIZED_TYPE not between", value1, value2, "customizedType");
			return (Criteria) this;
		}

		public Criteria andFirstInIsNull() {
			addCriterion("FIRST_IN is null");
			return (Criteria) this;
		}

		public Criteria andFirstInIsNotNull() {
			addCriterion("FIRST_IN is not null");
			return (Criteria) this;
		}

		public Criteria andFirstInEqualTo(Integer value) {
			addCriterion("FIRST_IN =", value, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInNotEqualTo(Integer value) {
			addCriterion("FIRST_IN <>", value, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInGreaterThan(Integer value) {
			addCriterion("FIRST_IN >", value, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_IN >=", value, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInLessThan(Integer value) {
			addCriterion("FIRST_IN <", value, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_IN <=", value, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInIn(List<Integer> values) {
			addCriterion("FIRST_IN in", values, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInNotIn(List<Integer> values) {
			addCriterion("FIRST_IN not in", values, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_IN between", value1, value2, "firstIn");
			return (Criteria) this;
		}

		public Criteria andFirstInNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_IN not between", value1, value2, "firstIn");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeIsNull() {
			addCriterion("PROPERTY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeIsNotNull() {
			addCriterion("PROPERTY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeEqualTo(Byte value) {
			addCriterion("PROPERTY_TYPE =", value, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeNotEqualTo(Byte value) {
			addCriterion("PROPERTY_TYPE <>", value, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeGreaterThan(Byte value) {
			addCriterion("PROPERTY_TYPE >", value, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PROPERTY_TYPE >=", value, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeLessThan(Byte value) {
			addCriterion("PROPERTY_TYPE <", value, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PROPERTY_TYPE <=", value, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeIn(List<Byte> values) {
			addCriterion("PROPERTY_TYPE in", values, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeNotIn(List<Byte> values) {
			addCriterion("PROPERTY_TYPE not in", values, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeBetween(Byte value1, Byte value2) {
			addCriterion("PROPERTY_TYPE between", value1, value2, "propertyType");
			return (Criteria) this;
		}

		public Criteria andPropertyTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PROPERTY_TYPE not between", value1, value2, "propertyType");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerIsNull() {
			addCriterion("OPEN_PARTNER is null");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerIsNotNull() {
			addCriterion("OPEN_PARTNER is not null");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerEqualTo(Byte value) {
			addCriterion("OPEN_PARTNER =", value, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerNotEqualTo(Byte value) {
			addCriterion("OPEN_PARTNER <>", value, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerGreaterThan(Byte value) {
			addCriterion("OPEN_PARTNER >", value, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_PARTNER >=", value, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerLessThan(Byte value) {
			addCriterion("OPEN_PARTNER <", value, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_PARTNER <=", value, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerIn(List<Byte> values) {
			addCriterion("OPEN_PARTNER in", values, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerNotIn(List<Byte> values) {
			addCriterion("OPEN_PARTNER not in", values, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_PARTNER between", value1, value2, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOpenPartnerNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_PARTNER not between", value1, value2, "openPartner");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeIsNull() {
			addCriterion("ORGANIZATION_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeIsNotNull() {
			addCriterion("ORGANIZATION_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeEqualTo(Integer value) {
			addCriterion("ORGANIZATION_TYPE =", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeNotEqualTo(Integer value) {
			addCriterion("ORGANIZATION_TYPE <>", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeGreaterThan(Integer value) {
			addCriterion("ORGANIZATION_TYPE >", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_TYPE >=", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeLessThan(Integer value) {
			addCriterion("ORGANIZATION_TYPE <", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeLessThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_TYPE <=", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeIn(List<Integer> values) {
			addCriterion("ORGANIZATION_TYPE in", values, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeNotIn(List<Integer> values) {
			addCriterion("ORGANIZATION_TYPE not in", values, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_TYPE between", value1, value2, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_TYPE not between", value1, value2, "organizationType");
			return (Criteria) this;
		}

		public Criteria andMainCompIsNull() {
			addCriterion("MAIN_COMP is null");
			return (Criteria) this;
		}

		public Criteria andMainCompIsNotNull() {
			addCriterion("MAIN_COMP is not null");
			return (Criteria) this;
		}

		public Criteria andMainCompEqualTo(Byte value) {
			addCriterion("MAIN_COMP =", value, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompNotEqualTo(Byte value) {
			addCriterion("MAIN_COMP <>", value, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompGreaterThan(Byte value) {
			addCriterion("MAIN_COMP >", value, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompGreaterThanOrEqualTo(Byte value) {
			addCriterion("MAIN_COMP >=", value, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompLessThan(Byte value) {
			addCriterion("MAIN_COMP <", value, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompLessThanOrEqualTo(Byte value) {
			addCriterion("MAIN_COMP <=", value, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompIn(List<Byte> values) {
			addCriterion("MAIN_COMP in", values, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompNotIn(List<Byte> values) {
			addCriterion("MAIN_COMP not in", values, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_COMP between", value1, value2, "mainComp");
			return (Criteria) this;
		}

		public Criteria andMainCompNotBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_COMP not between", value1, value2, "mainComp");
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