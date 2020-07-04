package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunStreetSectionExample extends ShardDb {
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
	public ErpFunStreetSectionExample() {
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

		public Criteria andStreetTerritoryIdIsNull() {
			addCriterion("STREET_TERRITORY_ID is null");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdIsNotNull() {
			addCriterion("STREET_TERRITORY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdEqualTo(Integer value) {
			addCriterion("STREET_TERRITORY_ID =", value, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdNotEqualTo(Integer value) {
			addCriterion("STREET_TERRITORY_ID <>", value, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdGreaterThan(Integer value) {
			addCriterion("STREET_TERRITORY_ID >", value, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("STREET_TERRITORY_ID >=", value, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdLessThan(Integer value) {
			addCriterion("STREET_TERRITORY_ID <", value, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("STREET_TERRITORY_ID <=", value, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdIn(List<Integer> values) {
			addCriterion("STREET_TERRITORY_ID in", values, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdNotIn(List<Integer> values) {
			addCriterion("STREET_TERRITORY_ID not in", values, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdBetween(Integer value1, Integer value2) {
			addCriterion("STREET_TERRITORY_ID between", value1, value2, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetTerritoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("STREET_TERRITORY_ID not between", value1, value2, "streetTerritoryId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdIsNull() {
			addCriterion("STREET_PROVINCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdIsNotNull() {
			addCriterion("STREET_PROVINCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdEqualTo(Integer value) {
			addCriterion("STREET_PROVINCE_ID =", value, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdNotEqualTo(Integer value) {
			addCriterion("STREET_PROVINCE_ID <>", value, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdGreaterThan(Integer value) {
			addCriterion("STREET_PROVINCE_ID >", value, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("STREET_PROVINCE_ID >=", value, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdLessThan(Integer value) {
			addCriterion("STREET_PROVINCE_ID <", value, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdLessThanOrEqualTo(Integer value) {
			addCriterion("STREET_PROVINCE_ID <=", value, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdIn(List<Integer> values) {
			addCriterion("STREET_PROVINCE_ID in", values, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdNotIn(List<Integer> values) {
			addCriterion("STREET_PROVINCE_ID not in", values, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdBetween(Integer value1, Integer value2) {
			addCriterion("STREET_PROVINCE_ID between", value1, value2, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetProvinceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("STREET_PROVINCE_ID not between", value1, value2, "streetProvinceId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdIsNull() {
			addCriterion("STREET_CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdIsNotNull() {
			addCriterion("STREET_CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdEqualTo(Integer value) {
			addCriterion("STREET_CITY_ID =", value, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdNotEqualTo(Integer value) {
			addCriterion("STREET_CITY_ID <>", value, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdGreaterThan(Integer value) {
			addCriterion("STREET_CITY_ID >", value, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("STREET_CITY_ID >=", value, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdLessThan(Integer value) {
			addCriterion("STREET_CITY_ID <", value, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdLessThanOrEqualTo(Integer value) {
			addCriterion("STREET_CITY_ID <=", value, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdIn(List<Integer> values) {
			addCriterion("STREET_CITY_ID in", values, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdNotIn(List<Integer> values) {
			addCriterion("STREET_CITY_ID not in", values, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdBetween(Integer value1, Integer value2) {
			addCriterion("STREET_CITY_ID between", value1, value2, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetCityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("STREET_CITY_ID not between", value1, value2, "streetCityId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdIsNull() {
			addCriterion("STREET_REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdIsNotNull() {
			addCriterion("STREET_REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdEqualTo(Integer value) {
			addCriterion("STREET_REG_ID =", value, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdNotEqualTo(Integer value) {
			addCriterion("STREET_REG_ID <>", value, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdGreaterThan(Integer value) {
			addCriterion("STREET_REG_ID >", value, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("STREET_REG_ID >=", value, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdLessThan(Integer value) {
			addCriterion("STREET_REG_ID <", value, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("STREET_REG_ID <=", value, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdIn(List<Integer> values) {
			addCriterion("STREET_REG_ID in", values, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdNotIn(List<Integer> values) {
			addCriterion("STREET_REG_ID not in", values, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdBetween(Integer value1, Integer value2) {
			addCriterion("STREET_REG_ID between", value1, value2, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andStreetRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("STREET_REG_ID not between", value1, value2, "streetRegId");
			return (Criteria) this;
		}

		public Criteria andSectionNameIsNull() {
			addCriterion("SECTION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSectionNameIsNotNull() {
			addCriterion("SECTION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSectionNameEqualTo(String value) {
			addCriterion("SECTION_NAME =", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotEqualTo(String value) {
			addCriterion("SECTION_NAME <>", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameGreaterThan(String value) {
			addCriterion("SECTION_NAME >", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECTION_NAME >=", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLessThan(String value) {
			addCriterion("SECTION_NAME <", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLessThanOrEqualTo(String value) {
			addCriterion("SECTION_NAME <=", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLike(String value) {
			addCriterion("SECTION_NAME like", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotLike(String value) {
			addCriterion("SECTION_NAME not like", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameIn(List<String> values) {
			addCriterion("SECTION_NAME in", values, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotIn(List<String> values) {
			addCriterion("SECTION_NAME not in", values, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameBetween(String value1, String value2) {
			addCriterion("SECTION_NAME between", value1, value2, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotBetween(String value1, String value2) {
			addCriterion("SECTION_NAME not between", value1, value2, "sectionName");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("CODE is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("CODE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("CODE =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("CODE <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("CODE >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("CODE >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("CODE <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("CODE <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("CODE like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("CODE not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("CODE in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("CODE not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("CODE between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("CODE not between", value1, value2, "code");
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

		public Criteria andSeqNoEqualTo(Integer value) {
			addCriterion("SEQ_NO =", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotEqualTo(Integer value) {
			addCriterion("SEQ_NO <>", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThan(Integer value) {
			addCriterion("SEQ_NO >", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO >=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThan(Integer value) {
			addCriterion("SEQ_NO <", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO <=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoIn(List<Integer> values) {
			addCriterion("SEQ_NO in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotIn(List<Integer> values) {
			addCriterion("SEQ_NO not in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO not between", value1, value2, "seqNo");
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

		public Criteria andUpdateTimeIsNull() {
			addCriterion("UPDATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("UPDATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNull() {
			addCriterion("IS_DEL is null");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNotNull() {
			addCriterion("IS_DEL is not null");
			return (Criteria) this;
		}

		public Criteria andIsDelEqualTo(Byte value) {
			addCriterion("IS_DEL =", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotEqualTo(Byte value) {
			addCriterion("IS_DEL <>", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThan(Byte value) {
			addCriterion("IS_DEL >", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_DEL >=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThan(Byte value) {
			addCriterion("IS_DEL <", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThanOrEqualTo(Byte value) {
			addCriterion("IS_DEL <=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelIn(List<Byte> values) {
			addCriterion("IS_DEL in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotIn(List<Byte> values) {
			addCriterion("IS_DEL not in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelBetween(Byte value1, Byte value2) {
			addCriterion("IS_DEL between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_DEL not between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andDelUserIdIsNull() {
			addCriterion("DEL_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andDelUserIdIsNotNull() {
			addCriterion("DEL_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDelUserIdEqualTo(Integer value) {
			addCriterion("DEL_USER_ID =", value, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdNotEqualTo(Integer value) {
			addCriterion("DEL_USER_ID <>", value, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdGreaterThan(Integer value) {
			addCriterion("DEL_USER_ID >", value, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEL_USER_ID >=", value, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdLessThan(Integer value) {
			addCriterion("DEL_USER_ID <", value, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEL_USER_ID <=", value, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdIn(List<Integer> values) {
			addCriterion("DEL_USER_ID in", values, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdNotIn(List<Integer> values) {
			addCriterion("DEL_USER_ID not in", values, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdBetween(Integer value1, Integer value2) {
			addCriterion("DEL_USER_ID between", value1, value2, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEL_USER_ID not between", value1, value2, "delUserId");
			return (Criteria) this;
		}

		public Criteria andDelTimeIsNull() {
			addCriterion("DEL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDelTimeIsNotNull() {
			addCriterion("DEL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDelTimeEqualTo(Date value) {
			addCriterion("DEL_TIME =", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotEqualTo(Date value) {
			addCriterion("DEL_TIME <>", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThan(Date value) {
			addCriterion("DEL_TIME >", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME >=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThan(Date value) {
			addCriterion("DEL_TIME <", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME <=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeIn(List<Date> values) {
			addCriterion("DEL_TIME in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotIn(List<Date> values) {
			addCriterion("DEL_TIME not in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME between", value1, value2, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME not between", value1, value2, "delTime");
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