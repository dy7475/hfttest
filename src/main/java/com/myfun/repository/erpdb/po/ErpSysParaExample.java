package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpSysParaExample extends ShardDb {
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
	public ErpSysParaExample() {
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

		public Criteria andParamIdIsNull() {
			addCriterion("PARAM_ID is null");
			return (Criteria) this;
		}

		public Criteria andParamIdIsNotNull() {
			addCriterion("PARAM_ID is not null");
			return (Criteria) this;
		}

		public Criteria andParamIdEqualTo(String value) {
			addCriterion("PARAM_ID =", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdNotEqualTo(String value) {
			addCriterion("PARAM_ID <>", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdGreaterThan(String value) {
			addCriterion("PARAM_ID >", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_ID >=", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdLessThan(String value) {
			addCriterion("PARAM_ID <", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdLessThanOrEqualTo(String value) {
			addCriterion("PARAM_ID <=", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdLike(String value) {
			addCriterion("PARAM_ID like", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdNotLike(String value) {
			addCriterion("PARAM_ID not like", value, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdIn(List<String> values) {
			addCriterion("PARAM_ID in", values, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdNotIn(List<String> values) {
			addCriterion("PARAM_ID not in", values, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdBetween(String value1, String value2) {
			addCriterion("PARAM_ID between", value1, value2, "paramId");
			return (Criteria) this;
		}

		public Criteria andParamIdNotBetween(String value1, String value2) {
			addCriterion("PARAM_ID not between", value1, value2, "paramId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIsNull() {
			addCriterion("PARTNER_ID is null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIsNotNull() {
			addCriterion("PARTNER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdEqualTo(Integer value) {
			addCriterion("PARTNER_ID =", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotEqualTo(Integer value) {
			addCriterion("PARTNER_ID <>", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThan(Integer value) {
			addCriterion("PARTNER_ID >", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID >=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThan(Integer value) {
			addCriterion("PARTNER_ID <", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID <=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIn(List<Integer> values) {
			addCriterion("PARTNER_ID in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotIn(List<Integer> values) {
			addCriterion("PARTNER_ID not in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID between", value1, value2, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID not between", value1, value2, "partnerId");
			return (Criteria) this;
		}

		public Criteria andParamValueIsNull() {
			addCriterion("PARAM_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andParamValueIsNotNull() {
			addCriterion("PARAM_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andParamValueEqualTo(String value) {
			addCriterion("PARAM_VALUE =", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotEqualTo(String value) {
			addCriterion("PARAM_VALUE <>", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueGreaterThan(String value) {
			addCriterion("PARAM_VALUE >", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE >=", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLessThan(String value) {
			addCriterion("PARAM_VALUE <", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLessThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE <=", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLike(String value) {
			addCriterion("PARAM_VALUE like", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotLike(String value) {
			addCriterion("PARAM_VALUE not like", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueIn(List<String> values) {
			addCriterion("PARAM_VALUE in", values, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotIn(List<String> values) {
			addCriterion("PARAM_VALUE not in", values, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE between", value1, value2, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE not between", value1, value2, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamTypeIsNull() {
			addCriterion("PARAM_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andParamTypeIsNotNull() {
			addCriterion("PARAM_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andParamTypeEqualTo(String value) {
			addCriterion("PARAM_TYPE =", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotEqualTo(String value) {
			addCriterion("PARAM_TYPE <>", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeGreaterThan(String value) {
			addCriterion("PARAM_TYPE >", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_TYPE >=", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeLessThan(String value) {
			addCriterion("PARAM_TYPE <", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeLessThanOrEqualTo(String value) {
			addCriterion("PARAM_TYPE <=", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeLike(String value) {
			addCriterion("PARAM_TYPE like", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotLike(String value) {
			addCriterion("PARAM_TYPE not like", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeIn(List<String> values) {
			addCriterion("PARAM_TYPE in", values, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotIn(List<String> values) {
			addCriterion("PARAM_TYPE not in", values, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeBetween(String value1, String value2) {
			addCriterion("PARAM_TYPE between", value1, value2, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotBetween(String value1, String value2) {
			addCriterion("PARAM_TYPE not between", value1, value2, "paramType");
			return (Criteria) this;
		}

		public Criteria andDefaultValueIsNull() {
			addCriterion("DEFAULT_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andDefaultValueIsNotNull() {
			addCriterion("DEFAULT_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andDefaultValueEqualTo(String value) {
			addCriterion("DEFAULT_VALUE =", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueNotEqualTo(String value) {
			addCriterion("DEFAULT_VALUE <>", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueGreaterThan(String value) {
			addCriterion("DEFAULT_VALUE >", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
			addCriterion("DEFAULT_VALUE >=", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueLessThan(String value) {
			addCriterion("DEFAULT_VALUE <", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueLessThanOrEqualTo(String value) {
			addCriterion("DEFAULT_VALUE <=", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueLike(String value) {
			addCriterion("DEFAULT_VALUE like", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueNotLike(String value) {
			addCriterion("DEFAULT_VALUE not like", value, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueIn(List<String> values) {
			addCriterion("DEFAULT_VALUE in", values, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueNotIn(List<String> values) {
			addCriterion("DEFAULT_VALUE not in", values, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueBetween(String value1, String value2) {
			addCriterion("DEFAULT_VALUE between", value1, value2, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andDefaultValueNotBetween(String value1, String value2) {
			addCriterion("DEFAULT_VALUE not between", value1, value2, "defaultValue");
			return (Criteria) this;
		}

		public Criteria andParamDescIsNull() {
			addCriterion("PARAM_DESC is null");
			return (Criteria) this;
		}

		public Criteria andParamDescIsNotNull() {
			addCriterion("PARAM_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andParamDescEqualTo(String value) {
			addCriterion("PARAM_DESC =", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescNotEqualTo(String value) {
			addCriterion("PARAM_DESC <>", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescGreaterThan(String value) {
			addCriterion("PARAM_DESC >", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_DESC >=", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescLessThan(String value) {
			addCriterion("PARAM_DESC <", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescLessThanOrEqualTo(String value) {
			addCriterion("PARAM_DESC <=", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescLike(String value) {
			addCriterion("PARAM_DESC like", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescNotLike(String value) {
			addCriterion("PARAM_DESC not like", value, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescIn(List<String> values) {
			addCriterion("PARAM_DESC in", values, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescNotIn(List<String> values) {
			addCriterion("PARAM_DESC not in", values, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescBetween(String value1, String value2) {
			addCriterion("PARAM_DESC between", value1, value2, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andParamDescNotBetween(String value1, String value2) {
			addCriterion("PARAM_DESC not between", value1, value2, "paramDesc");
			return (Criteria) this;
		}

		public Criteria andNeedReloginIsNull() {
			addCriterion("NEED_RELOGIN is null");
			return (Criteria) this;
		}

		public Criteria andNeedReloginIsNotNull() {
			addCriterion("NEED_RELOGIN is not null");
			return (Criteria) this;
		}

		public Criteria andNeedReloginEqualTo(Byte value) {
			addCriterion("NEED_RELOGIN =", value, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginNotEqualTo(Byte value) {
			addCriterion("NEED_RELOGIN <>", value, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginGreaterThan(Byte value) {
			addCriterion("NEED_RELOGIN >", value, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginGreaterThanOrEqualTo(Byte value) {
			addCriterion("NEED_RELOGIN >=", value, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginLessThan(Byte value) {
			addCriterion("NEED_RELOGIN <", value, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginLessThanOrEqualTo(Byte value) {
			addCriterion("NEED_RELOGIN <=", value, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginIn(List<Byte> values) {
			addCriterion("NEED_RELOGIN in", values, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginNotIn(List<Byte> values) {
			addCriterion("NEED_RELOGIN not in", values, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginBetween(Byte value1, Byte value2) {
			addCriterion("NEED_RELOGIN between", value1, value2, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andNeedReloginNotBetween(Byte value1, Byte value2) {
			addCriterion("NEED_RELOGIN not between", value1, value2, "needRelogin");
			return (Criteria) this;
		}

		public Criteria andMediumValueIsNull() {
			addCriterion("MEDIUM_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andMediumValueIsNotNull() {
			addCriterion("MEDIUM_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andMediumValueEqualTo(String value) {
			addCriterion("MEDIUM_VALUE =", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueNotEqualTo(String value) {
			addCriterion("MEDIUM_VALUE <>", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueGreaterThan(String value) {
			addCriterion("MEDIUM_VALUE >", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueGreaterThanOrEqualTo(String value) {
			addCriterion("MEDIUM_VALUE >=", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueLessThan(String value) {
			addCriterion("MEDIUM_VALUE <", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueLessThanOrEqualTo(String value) {
			addCriterion("MEDIUM_VALUE <=", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueLike(String value) {
			addCriterion("MEDIUM_VALUE like", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueNotLike(String value) {
			addCriterion("MEDIUM_VALUE not like", value, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueIn(List<String> values) {
			addCriterion("MEDIUM_VALUE in", values, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueNotIn(List<String> values) {
			addCriterion("MEDIUM_VALUE not in", values, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueBetween(String value1, String value2) {
			addCriterion("MEDIUM_VALUE between", value1, value2, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andMediumValueNotBetween(String value1, String value2) {
			addCriterion("MEDIUM_VALUE not between", value1, value2, "mediumValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueIsNull() {
			addCriterion("SENIOR_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andSeniorValueIsNotNull() {
			addCriterion("SENIOR_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andSeniorValueEqualTo(String value) {
			addCriterion("SENIOR_VALUE =", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueNotEqualTo(String value) {
			addCriterion("SENIOR_VALUE <>", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueGreaterThan(String value) {
			addCriterion("SENIOR_VALUE >", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueGreaterThanOrEqualTo(String value) {
			addCriterion("SENIOR_VALUE >=", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueLessThan(String value) {
			addCriterion("SENIOR_VALUE <", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueLessThanOrEqualTo(String value) {
			addCriterion("SENIOR_VALUE <=", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueLike(String value) {
			addCriterion("SENIOR_VALUE like", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueNotLike(String value) {
			addCriterion("SENIOR_VALUE not like", value, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueIn(List<String> values) {
			addCriterion("SENIOR_VALUE in", values, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueNotIn(List<String> values) {
			addCriterion("SENIOR_VALUE not in", values, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueBetween(String value1, String value2) {
			addCriterion("SENIOR_VALUE between", value1, value2, "seniorValue");
			return (Criteria) this;
		}

		public Criteria andSeniorValueNotBetween(String value1, String value2) {
			addCriterion("SENIOR_VALUE not between", value1, value2, "seniorValue");
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

		public Criteria andOrganizationTypeEqualTo(Byte value) {
			addCriterion("ORGANIZATION_TYPE =", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeNotEqualTo(Byte value) {
			addCriterion("ORGANIZATION_TYPE <>", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeGreaterThan(Byte value) {
			addCriterion("ORGANIZATION_TYPE >", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ORGANIZATION_TYPE >=", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeLessThan(Byte value) {
			addCriterion("ORGANIZATION_TYPE <", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ORGANIZATION_TYPE <=", value, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeIn(List<Byte> values) {
			addCriterion("ORGANIZATION_TYPE in", values, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeNotIn(List<Byte> values) {
			addCriterion("ORGANIZATION_TYPE not in", values, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeBetween(Byte value1, Byte value2) {
			addCriterion("ORGANIZATION_TYPE between", value1, value2, "organizationType");
			return (Criteria) this;
		}

		public Criteria andOrganizationTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ORGANIZATION_TYPE not between", value1, value2, "organizationType");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdIsNull() {
			addCriterion("PARAM_VALUE_DEF_ID is null");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdIsNotNull() {
			addCriterion("PARAM_VALUE_DEF_ID is not null");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdEqualTo(Integer value) {
			addCriterion("PARAM_VALUE_DEF_ID =", value, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdNotEqualTo(Integer value) {
			addCriterion("PARAM_VALUE_DEF_ID <>", value, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdGreaterThan(Integer value) {
			addCriterion("PARAM_VALUE_DEF_ID >", value, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARAM_VALUE_DEF_ID >=", value, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdLessThan(Integer value) {
			addCriterion("PARAM_VALUE_DEF_ID <", value, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdLessThanOrEqualTo(Integer value) {
			addCriterion("PARAM_VALUE_DEF_ID <=", value, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdIn(List<Integer> values) {
			addCriterion("PARAM_VALUE_DEF_ID in", values, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdNotIn(List<Integer> values) {
			addCriterion("PARAM_VALUE_DEF_ID not in", values, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdBetween(Integer value1, Integer value2) {
			addCriterion("PARAM_VALUE_DEF_ID between", value1, value2, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andParamValueDefIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PARAM_VALUE_DEF_ID not between", value1, value2, "paramValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdIsNull() {
			addCriterion("DEFAULT_VALUE_DEF_ID is null");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdIsNotNull() {
			addCriterion("DEFAULT_VALUE_DEF_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdEqualTo(Integer value) {
			addCriterion("DEFAULT_VALUE_DEF_ID =", value, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdNotEqualTo(Integer value) {
			addCriterion("DEFAULT_VALUE_DEF_ID <>", value, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdGreaterThan(Integer value) {
			addCriterion("DEFAULT_VALUE_DEF_ID >", value, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEFAULT_VALUE_DEF_ID >=", value, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdLessThan(Integer value) {
			addCriterion("DEFAULT_VALUE_DEF_ID <", value, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEFAULT_VALUE_DEF_ID <=", value, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdIn(List<Integer> values) {
			addCriterion("DEFAULT_VALUE_DEF_ID in", values, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdNotIn(List<Integer> values) {
			addCriterion("DEFAULT_VALUE_DEF_ID not in", values, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdBetween(Integer value1, Integer value2) {
			addCriterion("DEFAULT_VALUE_DEF_ID between", value1, value2, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andDefaultValueDefIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEFAULT_VALUE_DEF_ID not between", value1, value2, "defaultValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdIsNull() {
			addCriterion("MEDIUM_VALUE_DEF_ID is null");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdIsNotNull() {
			addCriterion("MEDIUM_VALUE_DEF_ID is not null");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdEqualTo(Integer value) {
			addCriterion("MEDIUM_VALUE_DEF_ID =", value, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdNotEqualTo(Integer value) {
			addCriterion("MEDIUM_VALUE_DEF_ID <>", value, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdGreaterThan(Integer value) {
			addCriterion("MEDIUM_VALUE_DEF_ID >", value, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("MEDIUM_VALUE_DEF_ID >=", value, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdLessThan(Integer value) {
			addCriterion("MEDIUM_VALUE_DEF_ID <", value, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdLessThanOrEqualTo(Integer value) {
			addCriterion("MEDIUM_VALUE_DEF_ID <=", value, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdIn(List<Integer> values) {
			addCriterion("MEDIUM_VALUE_DEF_ID in", values, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdNotIn(List<Integer> values) {
			addCriterion("MEDIUM_VALUE_DEF_ID not in", values, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdBetween(Integer value1, Integer value2) {
			addCriterion("MEDIUM_VALUE_DEF_ID between", value1, value2, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andMediumValueDefIdNotBetween(Integer value1, Integer value2) {
			addCriterion("MEDIUM_VALUE_DEF_ID not between", value1, value2, "mediumValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdIsNull() {
			addCriterion("SENIOR_VALUE_DEF_ID is null");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdIsNotNull() {
			addCriterion("SENIOR_VALUE_DEF_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdEqualTo(Integer value) {
			addCriterion("SENIOR_VALUE_DEF_ID =", value, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdNotEqualTo(Integer value) {
			addCriterion("SENIOR_VALUE_DEF_ID <>", value, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdGreaterThan(Integer value) {
			addCriterion("SENIOR_VALUE_DEF_ID >", value, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SENIOR_VALUE_DEF_ID >=", value, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdLessThan(Integer value) {
			addCriterion("SENIOR_VALUE_DEF_ID <", value, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdLessThanOrEqualTo(Integer value) {
			addCriterion("SENIOR_VALUE_DEF_ID <=", value, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdIn(List<Integer> values) {
			addCriterion("SENIOR_VALUE_DEF_ID in", values, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdNotIn(List<Integer> values) {
			addCriterion("SENIOR_VALUE_DEF_ID not in", values, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdBetween(Integer value1, Integer value2) {
			addCriterion("SENIOR_VALUE_DEF_ID between", value1, value2, "seniorValueDefId");
			return (Criteria) this;
		}

		public Criteria andSeniorValueDefIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SENIOR_VALUE_DEF_ID not between", value1, value2, "seniorValueDefId");
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