package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunPaidExample {
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
	public AdminFunPaidExample() {
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

		public Criteria andPaidIdIsNull() {
			addCriterion("PAID_ID is null");
			return (Criteria) this;
		}

		public Criteria andPaidIdIsNotNull() {
			addCriterion("PAID_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPaidIdEqualTo(Integer value) {
			addCriterion("PAID_ID =", value, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdNotEqualTo(Integer value) {
			addCriterion("PAID_ID <>", value, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdGreaterThan(Integer value) {
			addCriterion("PAID_ID >", value, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PAID_ID >=", value, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdLessThan(Integer value) {
			addCriterion("PAID_ID <", value, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdLessThanOrEqualTo(Integer value) {
			addCriterion("PAID_ID <=", value, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdIn(List<Integer> values) {
			addCriterion("PAID_ID in", values, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdNotIn(List<Integer> values) {
			addCriterion("PAID_ID not in", values, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdBetween(Integer value1, Integer value2) {
			addCriterion("PAID_ID between", value1, value2, "paidId");
			return (Criteria) this;
		}

		public Criteria andPaidIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PAID_ID not between", value1, value2, "paidId");
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

		public Criteria andPaidCatigoryIsNull() {
			addCriterion("PAID_CATIGORY is null");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryIsNotNull() {
			addCriterion("PAID_CATIGORY is not null");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryEqualTo(String value) {
			addCriterion("PAID_CATIGORY =", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryNotEqualTo(String value) {
			addCriterion("PAID_CATIGORY <>", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryGreaterThan(String value) {
			addCriterion("PAID_CATIGORY >", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryGreaterThanOrEqualTo(String value) {
			addCriterion("PAID_CATIGORY >=", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryLessThan(String value) {
			addCriterion("PAID_CATIGORY <", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryLessThanOrEqualTo(String value) {
			addCriterion("PAID_CATIGORY <=", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryLike(String value) {
			addCriterion("PAID_CATIGORY like", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryNotLike(String value) {
			addCriterion("PAID_CATIGORY not like", value, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryIn(List<String> values) {
			addCriterion("PAID_CATIGORY in", values, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryNotIn(List<String> values) {
			addCriterion("PAID_CATIGORY not in", values, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryBetween(String value1, String value2) {
			addCriterion("PAID_CATIGORY between", value1, value2, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidCatigoryNotBetween(String value1, String value2) {
			addCriterion("PAID_CATIGORY not between", value1, value2, "paidCatigory");
			return (Criteria) this;
		}

		public Criteria andPaidTypeIsNull() {
			addCriterion("PAID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPaidTypeIsNotNull() {
			addCriterion("PAID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPaidTypeEqualTo(String value) {
			addCriterion("PAID_TYPE =", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeNotEqualTo(String value) {
			addCriterion("PAID_TYPE <>", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeGreaterThan(String value) {
			addCriterion("PAID_TYPE >", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeGreaterThanOrEqualTo(String value) {
			addCriterion("PAID_TYPE >=", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeLessThan(String value) {
			addCriterion("PAID_TYPE <", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeLessThanOrEqualTo(String value) {
			addCriterion("PAID_TYPE <=", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeLike(String value) {
			addCriterion("PAID_TYPE like", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeNotLike(String value) {
			addCriterion("PAID_TYPE not like", value, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeIn(List<String> values) {
			addCriterion("PAID_TYPE in", values, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeNotIn(List<String> values) {
			addCriterion("PAID_TYPE not in", values, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeBetween(String value1, String value2) {
			addCriterion("PAID_TYPE between", value1, value2, "paidType");
			return (Criteria) this;
		}

		public Criteria andPaidTypeNotBetween(String value1, String value2) {
			addCriterion("PAID_TYPE not between", value1, value2, "paidType");
			return (Criteria) this;
		}

		public Criteria andCardnoIsNull() {
			addCriterion("CARDNO is null");
			return (Criteria) this;
		}

		public Criteria andCardnoIsNotNull() {
			addCriterion("CARDNO is not null");
			return (Criteria) this;
		}

		public Criteria andCardnoEqualTo(String value) {
			addCriterion("CARDNO =", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoNotEqualTo(String value) {
			addCriterion("CARDNO <>", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoGreaterThan(String value) {
			addCriterion("CARDNO >", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoGreaterThanOrEqualTo(String value) {
			addCriterion("CARDNO >=", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoLessThan(String value) {
			addCriterion("CARDNO <", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoLessThanOrEqualTo(String value) {
			addCriterion("CARDNO <=", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoLike(String value) {
			addCriterion("CARDNO like", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoNotLike(String value) {
			addCriterion("CARDNO not like", value, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoIn(List<String> values) {
			addCriterion("CARDNO in", values, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoNotIn(List<String> values) {
			addCriterion("CARDNO not in", values, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoBetween(String value1, String value2) {
			addCriterion("CARDNO between", value1, value2, "cardno");
			return (Criteria) this;
		}

		public Criteria andCardnoNotBetween(String value1, String value2) {
			addCriterion("CARDNO not between", value1, value2, "cardno");
			return (Criteria) this;
		}

		public Criteria andOrdernoIsNull() {
			addCriterion("ORDERNO is null");
			return (Criteria) this;
		}

		public Criteria andOrdernoIsNotNull() {
			addCriterion("ORDERNO is not null");
			return (Criteria) this;
		}

		public Criteria andOrdernoEqualTo(String value) {
			addCriterion("ORDERNO =", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoNotEqualTo(String value) {
			addCriterion("ORDERNO <>", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoGreaterThan(String value) {
			addCriterion("ORDERNO >", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
			addCriterion("ORDERNO >=", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoLessThan(String value) {
			addCriterion("ORDERNO <", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoLessThanOrEqualTo(String value) {
			addCriterion("ORDERNO <=", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoLike(String value) {
			addCriterion("ORDERNO like", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoNotLike(String value) {
			addCriterion("ORDERNO not like", value, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoIn(List<String> values) {
			addCriterion("ORDERNO in", values, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoNotIn(List<String> values) {
			addCriterion("ORDERNO not in", values, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoBetween(String value1, String value2) {
			addCriterion("ORDERNO between", value1, value2, "orderno");
			return (Criteria) this;
		}

		public Criteria andOrdernoNotBetween(String value1, String value2) {
			addCriterion("ORDERNO not between", value1, value2, "orderno");
			return (Criteria) this;
		}

		public Criteria andAmountIsNull() {
			addCriterion("AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andAmountIsNotNull() {
			addCriterion("AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andAmountEqualTo(Double value) {
			addCriterion("AMOUNT =", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotEqualTo(Double value) {
			addCriterion("AMOUNT <>", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThan(Double value) {
			addCriterion("AMOUNT >", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT >=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThan(Double value) {
			addCriterion("AMOUNT <", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT <=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountIn(List<Double> values) {
			addCriterion("AMOUNT in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotIn(List<Double> values) {
			addCriterion("AMOUNT not in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountBetween(Double value1, Double value2) {
			addCriterion("AMOUNT between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT not between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andPadiTimeIsNull() {
			addCriterion("PADI_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPadiTimeIsNotNull() {
			addCriterion("PADI_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPadiTimeEqualTo(Date value) {
			addCriterion("PADI_TIME =", value, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeNotEqualTo(Date value) {
			addCriterion("PADI_TIME <>", value, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeGreaterThan(Date value) {
			addCriterion("PADI_TIME >", value, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PADI_TIME >=", value, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeLessThan(Date value) {
			addCriterion("PADI_TIME <", value, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeLessThanOrEqualTo(Date value) {
			addCriterion("PADI_TIME <=", value, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeIn(List<Date> values) {
			addCriterion("PADI_TIME in", values, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeNotIn(List<Date> values) {
			addCriterion("PADI_TIME not in", values, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeBetween(Date value1, Date value2) {
			addCriterion("PADI_TIME between", value1, value2, "padiTime");
			return (Criteria) this;
		}

		public Criteria andPadiTimeNotBetween(Date value1, Date value2) {
			addCriterion("PADI_TIME not between", value1, value2, "padiTime");
			return (Criteria) this;
		}

		public Criteria andDealIdIsNull() {
			addCriterion("DEAL_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealIdIsNotNull() {
			addCriterion("DEAL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealIdEqualTo(Integer value) {
			addCriterion("DEAL_ID =", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotEqualTo(Integer value) {
			addCriterion("DEAL_ID <>", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThan(Integer value) {
			addCriterion("DEAL_ID >", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID >=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThan(Integer value) {
			addCriterion("DEAL_ID <", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID <=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdIn(List<Integer> values) {
			addCriterion("DEAL_ID in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotIn(List<Integer> values) {
			addCriterion("DEAL_ID not in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID between", value1, value2, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID not between", value1, value2, "dealId");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("[STATUS] is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("[STATUS] is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("[STATUS] =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("[STATUS] <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("[STATUS] >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("[STATUS] >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("[STATUS] <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("[STATUS] <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("[STATUS] in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("[STATUS] not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("[STATUS] between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("[STATUS] not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andOldTimeIsNull() {
			addCriterion("OLD_TIME is null");
			return (Criteria) this;
		}

		public Criteria andOldTimeIsNotNull() {
			addCriterion("OLD_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andOldTimeEqualTo(Date value) {
			addCriterion("OLD_TIME =", value, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeNotEqualTo(Date value) {
			addCriterion("OLD_TIME <>", value, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeGreaterThan(Date value) {
			addCriterion("OLD_TIME >", value, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("OLD_TIME >=", value, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeLessThan(Date value) {
			addCriterion("OLD_TIME <", value, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeLessThanOrEqualTo(Date value) {
			addCriterion("OLD_TIME <=", value, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeIn(List<Date> values) {
			addCriterion("OLD_TIME in", values, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeNotIn(List<Date> values) {
			addCriterion("OLD_TIME not in", values, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeBetween(Date value1, Date value2) {
			addCriterion("OLD_TIME between", value1, value2, "oldTime");
			return (Criteria) this;
		}

		public Criteria andOldTimeNotBetween(Date value1, Date value2) {
			addCriterion("OLD_TIME not between", value1, value2, "oldTime");
			return (Criteria) this;
		}

		public Criteria andDescIsNull() {
			addCriterion("[DESC] is null");
			return (Criteria) this;
		}

		public Criteria andDescIsNotNull() {
			addCriterion("[DESC] is not null");
			return (Criteria) this;
		}

		public Criteria andDescEqualTo(String value) {
			addCriterion("[DESC] =", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotEqualTo(String value) {
			addCriterion("[DESC] <>", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescGreaterThan(String value) {
			addCriterion("[DESC] >", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescGreaterThanOrEqualTo(String value) {
			addCriterion("[DESC] >=", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLessThan(String value) {
			addCriterion("[DESC] <", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLessThanOrEqualTo(String value) {
			addCriterion("[DESC] <=", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLike(String value) {
			addCriterion("[DESC] like", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotLike(String value) {
			addCriterion("[DESC] not like", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescIn(List<String> values) {
			addCriterion("[DESC] in", values, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotIn(List<String> values) {
			addCriterion("[DESC] not in", values, "desc");
			return (Criteria) this;
		}

		public Criteria andDescBetween(String value1, String value2) {
			addCriterion("[DESC] between", value1, value2, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotBetween(String value1, String value2) {
			addCriterion("[DESC] not between", value1, value2, "desc");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeIsNull() {
			addCriterion("AMOUNT_BEFORE is null");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeIsNotNull() {
			addCriterion("AMOUNT_BEFORE is not null");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeEqualTo(Double value) {
			addCriterion("AMOUNT_BEFORE =", value, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeNotEqualTo(Double value) {
			addCriterion("AMOUNT_BEFORE <>", value, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeGreaterThan(Double value) {
			addCriterion("AMOUNT_BEFORE >", value, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_BEFORE >=", value, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeLessThan(Double value) {
			addCriterion("AMOUNT_BEFORE <", value, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_BEFORE <=", value, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeIn(List<Double> values) {
			addCriterion("AMOUNT_BEFORE in", values, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeNotIn(List<Double> values) {
			addCriterion("AMOUNT_BEFORE not in", values, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_BEFORE between", value1, value2, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountBeforeNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_BEFORE not between", value1, value2, "amountBefore");
			return (Criteria) this;
		}

		public Criteria andAmountAfterIsNull() {
			addCriterion("AMOUNT_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andAmountAfterIsNotNull() {
			addCriterion("AMOUNT_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andAmountAfterEqualTo(Double value) {
			addCriterion("AMOUNT_AFTER =", value, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterNotEqualTo(Double value) {
			addCriterion("AMOUNT_AFTER <>", value, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterGreaterThan(Double value) {
			addCriterion("AMOUNT_AFTER >", value, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_AFTER >=", value, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterLessThan(Double value) {
			addCriterion("AMOUNT_AFTER <", value, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_AFTER <=", value, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterIn(List<Double> values) {
			addCriterion("AMOUNT_AFTER in", values, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterNotIn(List<Double> values) {
			addCriterion("AMOUNT_AFTER not in", values, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_AFTER between", value1, value2, "amountAfter");
			return (Criteria) this;
		}

		public Criteria andAmountAfterNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_AFTER not between", value1, value2, "amountAfter");
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

		public Criteria andPaidSourceIsNull() {
			addCriterion("PAID_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andPaidSourceIsNotNull() {
			addCriterion("PAID_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andPaidSourceEqualTo(Byte value) {
			addCriterion("PAID_SOURCE =", value, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceNotEqualTo(Byte value) {
			addCriterion("PAID_SOURCE <>", value, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceGreaterThan(Byte value) {
			addCriterion("PAID_SOURCE >", value, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("PAID_SOURCE >=", value, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceLessThan(Byte value) {
			addCriterion("PAID_SOURCE <", value, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceLessThanOrEqualTo(Byte value) {
			addCriterion("PAID_SOURCE <=", value, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceIn(List<Byte> values) {
			addCriterion("PAID_SOURCE in", values, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceNotIn(List<Byte> values) {
			addCriterion("PAID_SOURCE not in", values, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceBetween(Byte value1, Byte value2) {
			addCriterion("PAID_SOURCE between", value1, value2, "paidSource");
			return (Criteria) this;
		}

		public Criteria andPaidSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("PAID_SOURCE not between", value1, value2, "paidSource");
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

		public Criteria andAmountQuanIsNull() {
			addCriterion("AMOUNT_QUAN is null");
			return (Criteria) this;
		}

		public Criteria andAmountQuanIsNotNull() {
			addCriterion("AMOUNT_QUAN is not null");
			return (Criteria) this;
		}

		public Criteria andAmountQuanEqualTo(Double value) {
			addCriterion("AMOUNT_QUAN =", value, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanNotEqualTo(Double value) {
			addCriterion("AMOUNT_QUAN <>", value, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanGreaterThan(Double value) {
			addCriterion("AMOUNT_QUAN >", value, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_QUAN >=", value, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanLessThan(Double value) {
			addCriterion("AMOUNT_QUAN <", value, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_QUAN <=", value, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanIn(List<Double> values) {
			addCriterion("AMOUNT_QUAN in", values, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanNotIn(List<Double> values) {
			addCriterion("AMOUNT_QUAN not in", values, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_QUAN between", value1, value2, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountQuanNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_QUAN not between", value1, value2, "amountQuan");
			return (Criteria) this;
		}

		public Criteria andAmountCoinIsNull() {
			addCriterion("AMOUNT_COIN is null");
			return (Criteria) this;
		}

		public Criteria andAmountCoinIsNotNull() {
			addCriterion("AMOUNT_COIN is not null");
			return (Criteria) this;
		}

		public Criteria andAmountCoinEqualTo(Double value) {
			addCriterion("AMOUNT_COIN =", value, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinNotEqualTo(Double value) {
			addCriterion("AMOUNT_COIN <>", value, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinGreaterThan(Double value) {
			addCriterion("AMOUNT_COIN >", value, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_COIN >=", value, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinLessThan(Double value) {
			addCriterion("AMOUNT_COIN <", value, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_COIN <=", value, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinIn(List<Double> values) {
			addCriterion("AMOUNT_COIN in", values, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinNotIn(List<Double> values) {
			addCriterion("AMOUNT_COIN not in", values, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_COIN between", value1, value2, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andAmountCoinNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_COIN not between", value1, value2, "amountCoin");
			return (Criteria) this;
		}

		public Criteria andPtIdIsNull() {
			addCriterion("PT_ID is null");
			return (Criteria) this;
		}

		public Criteria andPtIdIsNotNull() {
			addCriterion("PT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPtIdEqualTo(Integer value) {
			addCriterion("PT_ID =", value, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdNotEqualTo(Integer value) {
			addCriterion("PT_ID <>", value, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdGreaterThan(Integer value) {
			addCriterion("PT_ID >", value, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PT_ID >=", value, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdLessThan(Integer value) {
			addCriterion("PT_ID <", value, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdLessThanOrEqualTo(Integer value) {
			addCriterion("PT_ID <=", value, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdIn(List<Integer> values) {
			addCriterion("PT_ID in", values, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdNotIn(List<Integer> values) {
			addCriterion("PT_ID not in", values, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdBetween(Integer value1, Integer value2) {
			addCriterion("PT_ID between", value1, value2, "ptId");
			return (Criteria) this;
		}

		public Criteria andPtIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PT_ID not between", value1, value2, "ptId");
			return (Criteria) this;
		}

		public Criteria andHasReceiptIsNull() {
			addCriterion("HAS_RECEIPT is null");
			return (Criteria) this;
		}

		public Criteria andHasReceiptIsNotNull() {
			addCriterion("HAS_RECEIPT is not null");
			return (Criteria) this;
		}

		public Criteria andHasReceiptEqualTo(Byte value) {
			addCriterion("HAS_RECEIPT =", value, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptNotEqualTo(Byte value) {
			addCriterion("HAS_RECEIPT <>", value, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptGreaterThan(Byte value) {
			addCriterion("HAS_RECEIPT >", value, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_RECEIPT >=", value, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptLessThan(Byte value) {
			addCriterion("HAS_RECEIPT <", value, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_RECEIPT <=", value, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptIn(List<Byte> values) {
			addCriterion("HAS_RECEIPT in", values, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptNotIn(List<Byte> values) {
			addCriterion("HAS_RECEIPT not in", values, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptBetween(Byte value1, Byte value2) {
			addCriterion("HAS_RECEIPT between", value1, value2, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andHasReceiptNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_RECEIPT not between", value1, value2, "hasReceipt");
			return (Criteria) this;
		}

		public Criteria andBuyAfterIsNull() {
			addCriterion("BUY_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andBuyAfterIsNotNull() {
			addCriterion("BUY_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andBuyAfterEqualTo(Double value) {
			addCriterion("BUY_AFTER =", value, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterNotEqualTo(Double value) {
			addCriterion("BUY_AFTER <>", value, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterGreaterThan(Double value) {
			addCriterion("BUY_AFTER >", value, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterGreaterThanOrEqualTo(Double value) {
			addCriterion("BUY_AFTER >=", value, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterLessThan(Double value) {
			addCriterion("BUY_AFTER <", value, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterLessThanOrEqualTo(Double value) {
			addCriterion("BUY_AFTER <=", value, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterIn(List<Double> values) {
			addCriterion("BUY_AFTER in", values, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterNotIn(List<Double> values) {
			addCriterion("BUY_AFTER not in", values, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterBetween(Double value1, Double value2) {
			addCriterion("BUY_AFTER between", value1, value2, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andBuyAfterNotBetween(Double value1, Double value2) {
			addCriterion("BUY_AFTER not between", value1, value2, "buyAfter");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeIsNull() {
			addCriterion("SERVICE_START_TIME is null");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeIsNotNull() {
			addCriterion("SERVICE_START_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeEqualTo(Date value) {
			addCriterion("SERVICE_START_TIME =", value, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeNotEqualTo(Date value) {
			addCriterion("SERVICE_START_TIME <>", value, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeGreaterThan(Date value) {
			addCriterion("SERVICE_START_TIME >", value, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SERVICE_START_TIME >=", value, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeLessThan(Date value) {
			addCriterion("SERVICE_START_TIME <", value, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("SERVICE_START_TIME <=", value, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeIn(List<Date> values) {
			addCriterion("SERVICE_START_TIME in", values, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeNotIn(List<Date> values) {
			addCriterion("SERVICE_START_TIME not in", values, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeBetween(Date value1, Date value2) {
			addCriterion("SERVICE_START_TIME between", value1, value2, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("SERVICE_START_TIME not between", value1, value2, "serviceStartTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeIsNull() {
			addCriterion("SERVICE_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeIsNotNull() {
			addCriterion("SERVICE_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeEqualTo(Date value) {
			addCriterion("SERVICE_END_TIME =", value, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeNotEqualTo(Date value) {
			addCriterion("SERVICE_END_TIME <>", value, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeGreaterThan(Date value) {
			addCriterion("SERVICE_END_TIME >", value, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SERVICE_END_TIME >=", value, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeLessThan(Date value) {
			addCriterion("SERVICE_END_TIME <", value, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("SERVICE_END_TIME <=", value, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeIn(List<Date> values) {
			addCriterion("SERVICE_END_TIME in", values, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeNotIn(List<Date> values) {
			addCriterion("SERVICE_END_TIME not in", values, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeBetween(Date value1, Date value2) {
			addCriterion("SERVICE_END_TIME between", value1, value2, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andServiceEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("SERVICE_END_TIME not between", value1, value2, "serviceEndTime");
			return (Criteria) this;
		}

		public Criteria andTransactionIdIsNull() {
			addCriterion("TRANSACTION_ID is null");
			return (Criteria) this;
		}

		public Criteria andTransactionIdIsNotNull() {
			addCriterion("TRANSACTION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTransactionIdEqualTo(String value) {
			addCriterion("TRANSACTION_ID =", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdNotEqualTo(String value) {
			addCriterion("TRANSACTION_ID <>", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdGreaterThan(String value) {
			addCriterion("TRANSACTION_ID >", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
			addCriterion("TRANSACTION_ID >=", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdLessThan(String value) {
			addCriterion("TRANSACTION_ID <", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdLessThanOrEqualTo(String value) {
			addCriterion("TRANSACTION_ID <=", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdLike(String value) {
			addCriterion("TRANSACTION_ID like", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdNotLike(String value) {
			addCriterion("TRANSACTION_ID not like", value, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdIn(List<String> values) {
			addCriterion("TRANSACTION_ID in", values, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdNotIn(List<String> values) {
			addCriterion("TRANSACTION_ID not in", values, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdBetween(String value1, String value2) {
			addCriterion("TRANSACTION_ID between", value1, value2, "transactionId");
			return (Criteria) this;
		}

		public Criteria andTransactionIdNotBetween(String value1, String value2) {
			addCriterion("TRANSACTION_ID not between", value1, value2, "transactionId");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyIsNull() {
			addCriterion("AMOUNT_SHARE_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyIsNotNull() {
			addCriterion("AMOUNT_SHARE_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY =", value, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyNotEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY <>", value, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyGreaterThan(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY >", value, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY >=", value, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyLessThan(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY <", value, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY <=", value, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyIn(List<Double> values) {
			addCriterion("AMOUNT_SHARE_MONEY in", values, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyNotIn(List<Double> values) {
			addCriterion("AMOUNT_SHARE_MONEY not in", values, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_SHARE_MONEY between", value1, value2, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_SHARE_MONEY not between", value1, value2, "amountShareMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyIsNull() {
			addCriterion("AMOUNT_CASH_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyIsNotNull() {
			addCriterion("AMOUNT_CASH_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY =", value, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyNotEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY <>", value, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyGreaterThan(Double value) {
			addCriterion("AMOUNT_CASH_MONEY >", value, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY >=", value, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyLessThan(Double value) {
			addCriterion("AMOUNT_CASH_MONEY <", value, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY <=", value, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyIn(List<Double> values) {
			addCriterion("AMOUNT_CASH_MONEY in", values, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyNotIn(List<Double> values) {
			addCriterion("AMOUNT_CASH_MONEY not in", values, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_CASH_MONEY between", value1, value2, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_CASH_MONEY not between", value1, value2, "amountCashMoney");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentIsNull() {
			addCriterion("AMOUNT_PAYMENT is null");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentIsNotNull() {
			addCriterion("AMOUNT_PAYMENT is not null");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentEqualTo(Double value) {
			addCriterion("AMOUNT_PAYMENT =", value, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentNotEqualTo(Double value) {
			addCriterion("AMOUNT_PAYMENT <>", value, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentGreaterThan(Double value) {
			addCriterion("AMOUNT_PAYMENT >", value, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_PAYMENT >=", value, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentLessThan(Double value) {
			addCriterion("AMOUNT_PAYMENT <", value, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_PAYMENT <=", value, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentIn(List<Double> values) {
			addCriterion("AMOUNT_PAYMENT in", values, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentNotIn(List<Double> values) {
			addCriterion("AMOUNT_PAYMENT not in", values, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_PAYMENT between", value1, value2, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andAmountPaymentNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_PAYMENT not between", value1, value2, "amountPayment");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeIsNull() {
			addCriterion("SUB_PAID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeIsNotNull() {
			addCriterion("SUB_PAID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeEqualTo(String value) {
			addCriterion("SUB_PAID_TYPE =", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeNotEqualTo(String value) {
			addCriterion("SUB_PAID_TYPE <>", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeGreaterThan(String value) {
			addCriterion("SUB_PAID_TYPE >", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeGreaterThanOrEqualTo(String value) {
			addCriterion("SUB_PAID_TYPE >=", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeLessThan(String value) {
			addCriterion("SUB_PAID_TYPE <", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeLessThanOrEqualTo(String value) {
			addCriterion("SUB_PAID_TYPE <=", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeLike(String value) {
			addCriterion("SUB_PAID_TYPE like", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeNotLike(String value) {
			addCriterion("SUB_PAID_TYPE not like", value, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeIn(List<String> values) {
			addCriterion("SUB_PAID_TYPE in", values, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeNotIn(List<String> values) {
			addCriterion("SUB_PAID_TYPE not in", values, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeBetween(String value1, String value2) {
			addCriterion("SUB_PAID_TYPE between", value1, value2, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andSubPaidTypeNotBetween(String value1, String value2) {
			addCriterion("SUB_PAID_TYPE not between", value1, value2, "subPaidType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeIsNull() {
			addCriterion("AMOUNT_PAY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeIsNotNull() {
			addCriterion("AMOUNT_PAY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeEqualTo(String value) {
			addCriterion("AMOUNT_PAY_TYPE =", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeNotEqualTo(String value) {
			addCriterion("AMOUNT_PAY_TYPE <>", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeGreaterThan(String value) {
			addCriterion("AMOUNT_PAY_TYPE >", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeGreaterThanOrEqualTo(String value) {
			addCriterion("AMOUNT_PAY_TYPE >=", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeLessThan(String value) {
			addCriterion("AMOUNT_PAY_TYPE <", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeLessThanOrEqualTo(String value) {
			addCriterion("AMOUNT_PAY_TYPE <=", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeLike(String value) {
			addCriterion("AMOUNT_PAY_TYPE like", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeNotLike(String value) {
			addCriterion("AMOUNT_PAY_TYPE not like", value, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeIn(List<String> values) {
			addCriterion("AMOUNT_PAY_TYPE in", values, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeNotIn(List<String> values) {
			addCriterion("AMOUNT_PAY_TYPE not in", values, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeBetween(String value1, String value2) {
			addCriterion("AMOUNT_PAY_TYPE between", value1, value2, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountPayTypeNotBetween(String value1, String value2) {
			addCriterion("AMOUNT_PAY_TYPE not between", value1, value2, "amountPayType");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterIsNull() {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterIsNotNull() {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER =", value, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterNotEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER <>", value, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterGreaterThan(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER >", value, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER >=", value, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterLessThan(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER <", value, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER <=", value, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterIn(List<Double> values) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER in", values, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterNotIn(List<Double> values) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER not in", values, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER between", value1, value2, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountShareMoneyAfterNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_SHARE_MONEY_AFTER not between", value1, value2, "amountShareMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterIsNull() {
			addCriterion("AMOUNT_CASH_MONEY_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterIsNotNull() {
			addCriterion("AMOUNT_CASH_MONEY_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER =", value, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterNotEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER <>", value, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterGreaterThan(Double value) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER >", value, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterGreaterThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER >=", value, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterLessThan(Double value) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER <", value, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterLessThanOrEqualTo(Double value) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER <=", value, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterIn(List<Double> values) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER in", values, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterNotIn(List<Double> values) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER not in", values, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER between", value1, value2, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andAmountCashMoneyAfterNotBetween(Double value1, Double value2) {
			addCriterion("AMOUNT_CASH_MONEY_AFTER not between", value1, value2, "amountCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyIsNull() {
			addCriterion("TRUE_BAIL_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyIsNotNull() {
			addCriterion("TRUE_BAIL_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY =", value, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyNotEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY <>", value, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyGreaterThan(Double value) {
			addCriterion("TRUE_BAIL_MONEY >", value, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyGreaterThanOrEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY >=", value, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyLessThan(Double value) {
			addCriterion("TRUE_BAIL_MONEY <", value, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyLessThanOrEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY <=", value, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyIn(List<Double> values) {
			addCriterion("TRUE_BAIL_MONEY in", values, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyNotIn(List<Double> values) {
			addCriterion("TRUE_BAIL_MONEY not in", values, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyBetween(Double value1, Double value2) {
			addCriterion("TRUE_BAIL_MONEY between", value1, value2, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyNotBetween(Double value1, Double value2) {
			addCriterion("TRUE_BAIL_MONEY not between", value1, value2, "trueBailMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyIsNull() {
			addCriterion("COMP_CASH_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyIsNotNull() {
			addCriterion("COMP_CASH_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY =", value, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyNotEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY <>", value, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyGreaterThan(Double value) {
			addCriterion("COMP_CASH_MONEY >", value, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyGreaterThanOrEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY >=", value, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyLessThan(Double value) {
			addCriterion("COMP_CASH_MONEY <", value, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyLessThanOrEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY <=", value, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyIn(List<Double> values) {
			addCriterion("COMP_CASH_MONEY in", values, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyNotIn(List<Double> values) {
			addCriterion("COMP_CASH_MONEY not in", values, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyBetween(Double value1, Double value2) {
			addCriterion("COMP_CASH_MONEY between", value1, value2, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyNotBetween(Double value1, Double value2) {
			addCriterion("COMP_CASH_MONEY not between", value1, value2, "compCashMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyIsNull() {
			addCriterion("COMP_COIN_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyIsNotNull() {
			addCriterion("COMP_COIN_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY =", value, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyNotEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY <>", value, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyGreaterThan(Double value) {
			addCriterion("COMP_COIN_MONEY >", value, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyGreaterThanOrEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY >=", value, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyLessThan(Double value) {
			addCriterion("COMP_COIN_MONEY <", value, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyLessThanOrEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY <=", value, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyIn(List<Double> values) {
			addCriterion("COMP_COIN_MONEY in", values, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyNotIn(List<Double> values) {
			addCriterion("COMP_COIN_MONEY not in", values, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyBetween(Double value1, Double value2) {
			addCriterion("COMP_COIN_MONEY between", value1, value2, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyNotBetween(Double value1, Double value2) {
			addCriterion("COMP_COIN_MONEY not between", value1, value2, "compCoinMoney");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterIsNull() {
			addCriterion("TRUE_BAIL_MONEY_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterIsNotNull() {
			addCriterion("TRUE_BAIL_MONEY_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY_AFTER =", value, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterNotEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY_AFTER <>", value, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterGreaterThan(Double value) {
			addCriterion("TRUE_BAIL_MONEY_AFTER >", value, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterGreaterThanOrEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY_AFTER >=", value, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterLessThan(Double value) {
			addCriterion("TRUE_BAIL_MONEY_AFTER <", value, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterLessThanOrEqualTo(Double value) {
			addCriterion("TRUE_BAIL_MONEY_AFTER <=", value, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterIn(List<Double> values) {
			addCriterion("TRUE_BAIL_MONEY_AFTER in", values, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterNotIn(List<Double> values) {
			addCriterion("TRUE_BAIL_MONEY_AFTER not in", values, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterBetween(Double value1, Double value2) {
			addCriterion("TRUE_BAIL_MONEY_AFTER between", value1, value2, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andTrueBailMoneyAfterNotBetween(Double value1, Double value2) {
			addCriterion("TRUE_BAIL_MONEY_AFTER not between", value1, value2, "trueBailMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterIsNull() {
			addCriterion("COMP_CASH_MONEY_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterIsNotNull() {
			addCriterion("COMP_CASH_MONEY_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY_AFTER =", value, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterNotEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY_AFTER <>", value, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterGreaterThan(Double value) {
			addCriterion("COMP_CASH_MONEY_AFTER >", value, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterGreaterThanOrEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY_AFTER >=", value, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterLessThan(Double value) {
			addCriterion("COMP_CASH_MONEY_AFTER <", value, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterLessThanOrEqualTo(Double value) {
			addCriterion("COMP_CASH_MONEY_AFTER <=", value, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterIn(List<Double> values) {
			addCriterion("COMP_CASH_MONEY_AFTER in", values, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterNotIn(List<Double> values) {
			addCriterion("COMP_CASH_MONEY_AFTER not in", values, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterBetween(Double value1, Double value2) {
			addCriterion("COMP_CASH_MONEY_AFTER between", value1, value2, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCashMoneyAfterNotBetween(Double value1, Double value2) {
			addCriterion("COMP_CASH_MONEY_AFTER not between", value1, value2, "compCashMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterIsNull() {
			addCriterion("COMP_COIN_MONEY_AFTER is null");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterIsNotNull() {
			addCriterion("COMP_COIN_MONEY_AFTER is not null");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY_AFTER =", value, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterNotEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY_AFTER <>", value, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterGreaterThan(Double value) {
			addCriterion("COMP_COIN_MONEY_AFTER >", value, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterGreaterThanOrEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY_AFTER >=", value, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterLessThan(Double value) {
			addCriterion("COMP_COIN_MONEY_AFTER <", value, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterLessThanOrEqualTo(Double value) {
			addCriterion("COMP_COIN_MONEY_AFTER <=", value, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterIn(List<Double> values) {
			addCriterion("COMP_COIN_MONEY_AFTER in", values, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterNotIn(List<Double> values) {
			addCriterion("COMP_COIN_MONEY_AFTER not in", values, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterBetween(Double value1, Double value2) {
			addCriterion("COMP_COIN_MONEY_AFTER between", value1, value2, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andCompCoinMoneyAfterNotBetween(Double value1, Double value2) {
			addCriterion("COMP_COIN_MONEY_AFTER not between", value1, value2, "compCoinMoneyAfter");
			return (Criteria) this;
		}

		public Criteria andActualMoneyIsNull() {
			addCriterion("ACTUAL_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andActualMoneyIsNotNull() {
			addCriterion("ACTUAL_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andActualMoneyEqualTo(Double value) {
			addCriterion("ACTUAL_MONEY =", value, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyNotEqualTo(Double value) {
			addCriterion("ACTUAL_MONEY <>", value, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyGreaterThan(Double value) {
			addCriterion("ACTUAL_MONEY >", value, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyGreaterThanOrEqualTo(Double value) {
			addCriterion("ACTUAL_MONEY >=", value, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyLessThan(Double value) {
			addCriterion("ACTUAL_MONEY <", value, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyLessThanOrEqualTo(Double value) {
			addCriterion("ACTUAL_MONEY <=", value, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyIn(List<Double> values) {
			addCriterion("ACTUAL_MONEY in", values, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyNotIn(List<Double> values) {
			addCriterion("ACTUAL_MONEY not in", values, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyBetween(Double value1, Double value2) {
			addCriterion("ACTUAL_MONEY between", value1, value2, "actualMoney");
			return (Criteria) this;
		}

		public Criteria andActualMoneyNotBetween(Double value1, Double value2) {
			addCriterion("ACTUAL_MONEY not between", value1, value2, "actualMoney");
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

		public Criteria andJsonIsNull() {
			addCriterion("JSON is null");
			return (Criteria) this;
		}

		public Criteria andJsonIsNotNull() {
			addCriterion("JSON is not null");
			return (Criteria) this;
		}

		public Criteria andJsonEqualTo(String value) {
			addCriterion("JSON =", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonNotEqualTo(String value) {
			addCriterion("JSON <>", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonGreaterThan(String value) {
			addCriterion("JSON >", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonGreaterThanOrEqualTo(String value) {
			addCriterion("JSON >=", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonLessThan(String value) {
			addCriterion("JSON <", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonLessThanOrEqualTo(String value) {
			addCriterion("JSON <=", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonLike(String value) {
			addCriterion("JSON like", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonNotLike(String value) {
			addCriterion("JSON not like", value, "json");
			return (Criteria) this;
		}

		public Criteria andJsonIn(List<String> values) {
			addCriterion("JSON in", values, "json");
			return (Criteria) this;
		}

		public Criteria andJsonNotIn(List<String> values) {
			addCriterion("JSON not in", values, "json");
			return (Criteria) this;
		}

		public Criteria andJsonBetween(String value1, String value2) {
			addCriterion("JSON between", value1, value2, "json");
			return (Criteria) this;
		}

		public Criteria andJsonNotBetween(String value1, String value2) {
			addCriterion("JSON not between", value1, value2, "json");
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