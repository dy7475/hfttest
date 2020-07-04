package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunCompExample extends ShardDb {
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
	public ErpFunCompExample() {
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

		public Criteria andCommercialNoIsNull() {
			addCriterion("COMMERCIAL_NO is null");
			return (Criteria) this;
		}

		public Criteria andCommercialNoIsNotNull() {
			addCriterion("COMMERCIAL_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCommercialNoEqualTo(String value) {
			addCriterion("COMMERCIAL_NO =", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoNotEqualTo(String value) {
			addCriterion("COMMERCIAL_NO <>", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoGreaterThan(String value) {
			addCriterion("COMMERCIAL_NO >", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoGreaterThanOrEqualTo(String value) {
			addCriterion("COMMERCIAL_NO >=", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoLessThan(String value) {
			addCriterion("COMMERCIAL_NO <", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoLessThanOrEqualTo(String value) {
			addCriterion("COMMERCIAL_NO <=", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoLike(String value) {
			addCriterion("COMMERCIAL_NO like", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoNotLike(String value) {
			addCriterion("COMMERCIAL_NO not like", value, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoIn(List<String> values) {
			addCriterion("COMMERCIAL_NO in", values, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoNotIn(List<String> values) {
			addCriterion("COMMERCIAL_NO not in", values, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoBetween(String value1, String value2) {
			addCriterion("COMMERCIAL_NO between", value1, value2, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andCommercialNoNotBetween(String value1, String value2) {
			addCriterion("COMMERCIAL_NO not between", value1, value2, "commercialNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoIsNull() {
			addCriterion("APTITUDE_NO is null");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoIsNotNull() {
			addCriterion("APTITUDE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoEqualTo(String value) {
			addCriterion("APTITUDE_NO =", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoNotEqualTo(String value) {
			addCriterion("APTITUDE_NO <>", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoGreaterThan(String value) {
			addCriterion("APTITUDE_NO >", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoGreaterThanOrEqualTo(String value) {
			addCriterion("APTITUDE_NO >=", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoLessThan(String value) {
			addCriterion("APTITUDE_NO <", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoLessThanOrEqualTo(String value) {
			addCriterion("APTITUDE_NO <=", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoLike(String value) {
			addCriterion("APTITUDE_NO like", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoNotLike(String value) {
			addCriterion("APTITUDE_NO not like", value, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoIn(List<String> values) {
			addCriterion("APTITUDE_NO in", values, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoNotIn(List<String> values) {
			addCriterion("APTITUDE_NO not in", values, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoBetween(String value1, String value2) {
			addCriterion("APTITUDE_NO between", value1, value2, "aptitudeNo");
			return (Criteria) this;
		}

		public Criteria andAptitudeNoNotBetween(String value1, String value2) {
			addCriterion("APTITUDE_NO not between", value1, value2, "aptitudeNo");
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

		public Criteria andRegistFlagIsNull() {
			addCriterion("REGIST_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andRegistFlagIsNotNull() {
			addCriterion("REGIST_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andRegistFlagEqualTo(Boolean value) {
			addCriterion("REGIST_FLAG =", value, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagNotEqualTo(Boolean value) {
			addCriterion("REGIST_FLAG <>", value, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagGreaterThan(Boolean value) {
			addCriterion("REGIST_FLAG >", value, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("REGIST_FLAG >=", value, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagLessThan(Boolean value) {
			addCriterion("REGIST_FLAG <", value, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("REGIST_FLAG <=", value, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagIn(List<Boolean> values) {
			addCriterion("REGIST_FLAG in", values, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagNotIn(List<Boolean> values) {
			addCriterion("REGIST_FLAG not in", values, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("REGIST_FLAG between", value1, value2, "registFlag");
			return (Criteria) this;
		}

		public Criteria andRegistFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("REGIST_FLAG not between", value1, value2, "registFlag");
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

		public Criteria andPlotSwitchIsNull() {
			addCriterion("PLOT_SWITCH is null");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchIsNotNull() {
			addCriterion("PLOT_SWITCH is not null");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchEqualTo(Boolean value) {
			addCriterion("PLOT_SWITCH =", value, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchNotEqualTo(Boolean value) {
			addCriterion("PLOT_SWITCH <>", value, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchGreaterThan(Boolean value) {
			addCriterion("PLOT_SWITCH >", value, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchGreaterThanOrEqualTo(Boolean value) {
			addCriterion("PLOT_SWITCH >=", value, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchLessThan(Boolean value) {
			addCriterion("PLOT_SWITCH <", value, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchLessThanOrEqualTo(Boolean value) {
			addCriterion("PLOT_SWITCH <=", value, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchIn(List<Boolean> values) {
			addCriterion("PLOT_SWITCH in", values, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchNotIn(List<Boolean> values) {
			addCriterion("PLOT_SWITCH not in", values, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchBetween(Boolean value1, Boolean value2) {
			addCriterion("PLOT_SWITCH between", value1, value2, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andPlotSwitchNotBetween(Boolean value1, Boolean value2) {
			addCriterion("PLOT_SWITCH not between", value1, value2, "plotSwitch");
			return (Criteria) this;
		}

		public Criteria andWaterimgIsNull() {
			addCriterion("WATERIMG is null");
			return (Criteria) this;
		}

		public Criteria andWaterimgIsNotNull() {
			addCriterion("WATERIMG is not null");
			return (Criteria) this;
		}

		public Criteria andWaterimgEqualTo(String value) {
			addCriterion("WATERIMG =", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgNotEqualTo(String value) {
			addCriterion("WATERIMG <>", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgGreaterThan(String value) {
			addCriterion("WATERIMG >", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgGreaterThanOrEqualTo(String value) {
			addCriterion("WATERIMG >=", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgLessThan(String value) {
			addCriterion("WATERIMG <", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgLessThanOrEqualTo(String value) {
			addCriterion("WATERIMG <=", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgLike(String value) {
			addCriterion("WATERIMG like", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgNotLike(String value) {
			addCriterion("WATERIMG not like", value, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgIn(List<String> values) {
			addCriterion("WATERIMG in", values, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgNotIn(List<String> values) {
			addCriterion("WATERIMG not in", values, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgBetween(String value1, String value2) {
			addCriterion("WATERIMG between", value1, value2, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterimgNotBetween(String value1, String value2) {
			addCriterion("WATERIMG not between", value1, value2, "waterimg");
			return (Criteria) this;
		}

		public Criteria andWaterConfigIsNull() {
			addCriterion("WATER_CONFIG is null");
			return (Criteria) this;
		}

		public Criteria andWaterConfigIsNotNull() {
			addCriterion("WATER_CONFIG is not null");
			return (Criteria) this;
		}

		public Criteria andWaterConfigEqualTo(String value) {
			addCriterion("WATER_CONFIG =", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigNotEqualTo(String value) {
			addCriterion("WATER_CONFIG <>", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigGreaterThan(String value) {
			addCriterion("WATER_CONFIG >", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigGreaterThanOrEqualTo(String value) {
			addCriterion("WATER_CONFIG >=", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigLessThan(String value) {
			addCriterion("WATER_CONFIG <", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigLessThanOrEqualTo(String value) {
			addCriterion("WATER_CONFIG <=", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigLike(String value) {
			addCriterion("WATER_CONFIG like", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigNotLike(String value) {
			addCriterion("WATER_CONFIG not like", value, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigIn(List<String> values) {
			addCriterion("WATER_CONFIG in", values, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigNotIn(List<String> values) {
			addCriterion("WATER_CONFIG not in", values, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigBetween(String value1, String value2) {
			addCriterion("WATER_CONFIG between", value1, value2, "waterConfig");
			return (Criteria) this;
		}

		public Criteria andWaterConfigNotBetween(String value1, String value2) {
			addCriterion("WATER_CONFIG not between", value1, value2, "waterConfig");
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

		public Criteria andUpdateUidIsNull() {
			addCriterion("UPDATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIsNotNull() {
			addCriterion("UPDATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidEqualTo(Integer value) {
			addCriterion("UPDATE_UID =", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotEqualTo(Integer value) {
			addCriterion("UPDATE_UID <>", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThan(Integer value) {
			addCriterion("UPDATE_UID >", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID >=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThan(Integer value) {
			addCriterion("UPDATE_UID <", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID <=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIn(List<Integer> values) {
			addCriterion("UPDATE_UID in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotIn(List<Integer> values) {
			addCriterion("UPDATE_UID not in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID between", value1, value2, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID not between", value1, value2, "updateUid");
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

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("UPDATE_TIME like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("UPDATE_TIME not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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

		public Criteria andHouseAddNoIsNull() {
			addCriterion("HOUSE_ADD_NO is null");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoIsNotNull() {
			addCriterion("HOUSE_ADD_NO is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_NO =", value, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoNotEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_NO <>", value, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoGreaterThan(Integer value) {
			addCriterion("HOUSE_ADD_NO >", value, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_NO >=", value, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoLessThan(Integer value) {
			addCriterion("HOUSE_ADD_NO <", value, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_NO <=", value, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoIn(List<Integer> values) {
			addCriterion("HOUSE_ADD_NO in", values, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoNotIn(List<Integer> values) {
			addCriterion("HOUSE_ADD_NO not in", values, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD_NO between", value1, value2, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHouseAddNoNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD_NO not between", value1, value2, "houseAddNo");
			return (Criteria) this;
		}

		public Criteria andHeadNameIsNull() {
			addCriterion("HEAD_NAME is null");
			return (Criteria) this;
		}

		public Criteria andHeadNameIsNotNull() {
			addCriterion("HEAD_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andHeadNameEqualTo(String value) {
			addCriterion("HEAD_NAME =", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameNotEqualTo(String value) {
			addCriterion("HEAD_NAME <>", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameGreaterThan(String value) {
			addCriterion("HEAD_NAME >", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameGreaterThanOrEqualTo(String value) {
			addCriterion("HEAD_NAME >=", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameLessThan(String value) {
			addCriterion("HEAD_NAME <", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameLessThanOrEqualTo(String value) {
			addCriterion("HEAD_NAME <=", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameLike(String value) {
			addCriterion("HEAD_NAME like", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameNotLike(String value) {
			addCriterion("HEAD_NAME not like", value, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameIn(List<String> values) {
			addCriterion("HEAD_NAME in", values, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameNotIn(List<String> values) {
			addCriterion("HEAD_NAME not in", values, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameBetween(String value1, String value2) {
			addCriterion("HEAD_NAME between", value1, value2, "headName");
			return (Criteria) this;
		}

		public Criteria andHeadNameNotBetween(String value1, String value2) {
			addCriterion("HEAD_NAME not between", value1, value2, "headName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameIsNull() {
			addCriterion("BUSINESS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBusinessNameIsNotNull() {
			addCriterion("BUSINESS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessNameEqualTo(String value) {
			addCriterion("BUSINESS_NAME =", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotEqualTo(String value) {
			addCriterion("BUSINESS_NAME <>", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameGreaterThan(String value) {
			addCriterion("BUSINESS_NAME >", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUSINESS_NAME >=", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameLessThan(String value) {
			addCriterion("BUSINESS_NAME <", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameLessThanOrEqualTo(String value) {
			addCriterion("BUSINESS_NAME <=", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameLike(String value) {
			addCriterion("BUSINESS_NAME like", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotLike(String value) {
			addCriterion("BUSINESS_NAME not like", value, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameIn(List<String> values) {
			addCriterion("BUSINESS_NAME in", values, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotIn(List<String> values) {
			addCriterion("BUSINESS_NAME not in", values, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameBetween(String value1, String value2) {
			addCriterion("BUSINESS_NAME between", value1, value2, "businessName");
			return (Criteria) this;
		}

		public Criteria andBusinessNameNotBetween(String value1, String value2) {
			addCriterion("BUSINESS_NAME not between", value1, value2, "businessName");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagIsNull() {
			addCriterion("STATISTICS_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagIsNotNull() {
			addCriterion("STATISTICS_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG =", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagNotEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG <>", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagGreaterThan(Byte value) {
			addCriterion("STATISTICS_FLAG >", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG >=", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagLessThan(Byte value) {
			addCriterion("STATISTICS_FLAG <", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagLessThanOrEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG <=", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagIn(List<Byte> values) {
			addCriterion("STATISTICS_FLAG in", values, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagNotIn(List<Byte> values) {
			addCriterion("STATISTICS_FLAG not in", values, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagBetween(Byte value1, Byte value2) {
			addCriterion("STATISTICS_FLAG between", value1, value2, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("STATISTICS_FLAG not between", value1, value2, "statisticsFlag");
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

		public Criteria andBusinessApartIsNull() {
			addCriterion("BUSINESS_APART is null");
			return (Criteria) this;
		}

		public Criteria andBusinessApartIsNotNull() {
			addCriterion("BUSINESS_APART is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessApartEqualTo(Byte value) {
			addCriterion("BUSINESS_APART =", value, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartNotEqualTo(Byte value) {
			addCriterion("BUSINESS_APART <>", value, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartGreaterThan(Byte value) {
			addCriterion("BUSINESS_APART >", value, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUSINESS_APART >=", value, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartLessThan(Byte value) {
			addCriterion("BUSINESS_APART <", value, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartLessThanOrEqualTo(Byte value) {
			addCriterion("BUSINESS_APART <=", value, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartIn(List<Byte> values) {
			addCriterion("BUSINESS_APART in", values, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartNotIn(List<Byte> values) {
			addCriterion("BUSINESS_APART not in", values, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartBetween(Byte value1, Byte value2) {
			addCriterion("BUSINESS_APART between", value1, value2, "businessApart");
			return (Criteria) this;
		}

		public Criteria andBusinessApartNotBetween(Byte value1, Byte value2) {
			addCriterion("BUSINESS_APART not between", value1, value2, "businessApart");
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