package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ErpFunNatureTempletExample extends ShardDb {
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
	public ErpFunNatureTempletExample() {
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

		public Criteria andTaxNameIsNull() {
			addCriterion("TAX_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTaxNameIsNotNull() {
			addCriterion("TAX_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTaxNameEqualTo(String value) {
			addCriterion("TAX_NAME =", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameNotEqualTo(String value) {
			addCriterion("TAX_NAME <>", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameGreaterThan(String value) {
			addCriterion("TAX_NAME >", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameGreaterThanOrEqualTo(String value) {
			addCriterion("TAX_NAME >=", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameLessThan(String value) {
			addCriterion("TAX_NAME <", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameLessThanOrEqualTo(String value) {
			addCriterion("TAX_NAME <=", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameLike(String value) {
			addCriterion("TAX_NAME like", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameNotLike(String value) {
			addCriterion("TAX_NAME not like", value, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameIn(List<String> values) {
			addCriterion("TAX_NAME in", values, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameNotIn(List<String> values) {
			addCriterion("TAX_NAME not in", values, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameBetween(String value1, String value2) {
			addCriterion("TAX_NAME between", value1, value2, "taxName");
			return (Criteria) this;
		}

		public Criteria andTaxNameNotBetween(String value1, String value2) {
			addCriterion("TAX_NAME not between", value1, value2, "taxName");
			return (Criteria) this;
		}

		public Criteria andFunNatureIsNull() {
			addCriterion("FUN_NATURE is null");
			return (Criteria) this;
		}

		public Criteria andFunNatureIsNotNull() {
			addCriterion("FUN_NATURE is not null");
			return (Criteria) this;
		}

		public Criteria andFunNatureEqualTo(Byte value) {
			addCriterion("FUN_NATURE =", value, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureNotEqualTo(Byte value) {
			addCriterion("FUN_NATURE <>", value, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureGreaterThan(Byte value) {
			addCriterion("FUN_NATURE >", value, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureGreaterThanOrEqualTo(Byte value) {
			addCriterion("FUN_NATURE >=", value, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureLessThan(Byte value) {
			addCriterion("FUN_NATURE <", value, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureLessThanOrEqualTo(Byte value) {
			addCriterion("FUN_NATURE <=", value, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureIn(List<Byte> values) {
			addCriterion("FUN_NATURE in", values, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureNotIn(List<Byte> values) {
			addCriterion("FUN_NATURE not in", values, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureBetween(Byte value1, Byte value2) {
			addCriterion("FUN_NATURE between", value1, value2, "funNature");
			return (Criteria) this;
		}

		public Criteria andFunNatureNotBetween(Byte value1, Byte value2) {
			addCriterion("FUN_NATURE not between", value1, value2, "funNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureIsNull() {
			addCriterion("BUY_NATURE is null");
			return (Criteria) this;
		}

		public Criteria andBuyNatureIsNotNull() {
			addCriterion("BUY_NATURE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyNatureEqualTo(Byte value) {
			addCriterion("BUY_NATURE =", value, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureNotEqualTo(Byte value) {
			addCriterion("BUY_NATURE <>", value, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureGreaterThan(Byte value) {
			addCriterion("BUY_NATURE >", value, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_NATURE >=", value, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureLessThan(Byte value) {
			addCriterion("BUY_NATURE <", value, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_NATURE <=", value, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureIn(List<Byte> values) {
			addCriterion("BUY_NATURE in", values, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureNotIn(List<Byte> values) {
			addCriterion("BUY_NATURE not in", values, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureBetween(Byte value1, Byte value2) {
			addCriterion("BUY_NATURE between", value1, value2, "buyNature");
			return (Criteria) this;
		}

		public Criteria andBuyNatureNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_NATURE not between", value1, value2, "buyNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureIsNull() {
			addCriterion("YEAR_NATURE is null");
			return (Criteria) this;
		}

		public Criteria andYearNatureIsNotNull() {
			addCriterion("YEAR_NATURE is not null");
			return (Criteria) this;
		}

		public Criteria andYearNatureEqualTo(Byte value) {
			addCriterion("YEAR_NATURE =", value, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureNotEqualTo(Byte value) {
			addCriterion("YEAR_NATURE <>", value, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureGreaterThan(Byte value) {
			addCriterion("YEAR_NATURE >", value, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureGreaterThanOrEqualTo(Byte value) {
			addCriterion("YEAR_NATURE >=", value, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureLessThan(Byte value) {
			addCriterion("YEAR_NATURE <", value, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureLessThanOrEqualTo(Byte value) {
			addCriterion("YEAR_NATURE <=", value, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureIn(List<Byte> values) {
			addCriterion("YEAR_NATURE in", values, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureNotIn(List<Byte> values) {
			addCriterion("YEAR_NATURE not in", values, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureBetween(Byte value1, Byte value2) {
			addCriterion("YEAR_NATURE between", value1, value2, "yearNature");
			return (Criteria) this;
		}

		public Criteria andYearNatureNotBetween(Byte value1, Byte value2) {
			addCriterion("YEAR_NATURE not between", value1, value2, "yearNature");
			return (Criteria) this;
		}

		public Criteria andQsRateIsNull() {
			addCriterion("QS_RATE is null");
			return (Criteria) this;
		}

		public Criteria andQsRateIsNotNull() {
			addCriterion("QS_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andQsRateEqualTo(BigDecimal value) {
			addCriterion("QS_RATE =", value, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateNotEqualTo(BigDecimal value) {
			addCriterion("QS_RATE <>", value, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateGreaterThan(BigDecimal value) {
			addCriterion("QS_RATE >", value, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("QS_RATE >=", value, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateLessThan(BigDecimal value) {
			addCriterion("QS_RATE <", value, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("QS_RATE <=", value, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateIn(List<BigDecimal> values) {
			addCriterion("QS_RATE in", values, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateNotIn(List<BigDecimal> values) {
			addCriterion("QS_RATE not in", values, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("QS_RATE between", value1, value2, "qsRate");
			return (Criteria) this;
		}

		public Criteria andQsRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("QS_RATE not between", value1, value2, "qsRate");
			return (Criteria) this;
		}

		public Criteria andYhRateIsNull() {
			addCriterion("YH_RATE is null");
			return (Criteria) this;
		}

		public Criteria andYhRateIsNotNull() {
			addCriterion("YH_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andYhRateEqualTo(BigDecimal value) {
			addCriterion("YH_RATE =", value, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateNotEqualTo(BigDecimal value) {
			addCriterion("YH_RATE <>", value, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateGreaterThan(BigDecimal value) {
			addCriterion("YH_RATE >", value, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("YH_RATE >=", value, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateLessThan(BigDecimal value) {
			addCriterion("YH_RATE <", value, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("YH_RATE <=", value, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateIn(List<BigDecimal> values) {
			addCriterion("YH_RATE in", values, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateNotIn(List<BigDecimal> values) {
			addCriterion("YH_RATE not in", values, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("YH_RATE between", value1, value2, "yhRate");
			return (Criteria) this;
		}

		public Criteria andYhRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("YH_RATE not between", value1, value2, "yhRate");
			return (Criteria) this;
		}

		public Criteria andTradeFeeIsNull() {
			addCriterion("TRADE_FEE is null");
			return (Criteria) this;
		}

		public Criteria andTradeFeeIsNotNull() {
			addCriterion("TRADE_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andTradeFeeEqualTo(BigDecimal value) {
			addCriterion("TRADE_FEE =", value, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeNotEqualTo(BigDecimal value) {
			addCriterion("TRADE_FEE <>", value, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeGreaterThan(BigDecimal value) {
			addCriterion("TRADE_FEE >", value, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TRADE_FEE >=", value, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeLessThan(BigDecimal value) {
			addCriterion("TRADE_FEE <", value, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TRADE_FEE <=", value, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeIn(List<BigDecimal> values) {
			addCriterion("TRADE_FEE in", values, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeNotIn(List<BigDecimal> values) {
			addCriterion("TRADE_FEE not in", values, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRADE_FEE between", value1, value2, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andTradeFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRADE_FEE not between", value1, value2, "tradeFee");
			return (Criteria) this;
		}

		public Criteria andZzsTypeIsNull() {
			addCriterion("ZZS_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andZzsTypeIsNotNull() {
			addCriterion("ZZS_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andZzsTypeEqualTo(Byte value) {
			addCriterion("ZZS_TYPE =", value, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeNotEqualTo(Byte value) {
			addCriterion("ZZS_TYPE <>", value, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeGreaterThan(Byte value) {
			addCriterion("ZZS_TYPE >", value, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ZZS_TYPE >=", value, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeLessThan(Byte value) {
			addCriterion("ZZS_TYPE <", value, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ZZS_TYPE <=", value, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeIn(List<Byte> values) {
			addCriterion("ZZS_TYPE in", values, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeNotIn(List<Byte> values) {
			addCriterion("ZZS_TYPE not in", values, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeBetween(Byte value1, Byte value2) {
			addCriterion("ZZS_TYPE between", value1, value2, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ZZS_TYPE not between", value1, value2, "zzsType");
			return (Criteria) this;
		}

		public Criteria andZzsRateIsNull() {
			addCriterion("ZZS_RATE is null");
			return (Criteria) this;
		}

		public Criteria andZzsRateIsNotNull() {
			addCriterion("ZZS_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andZzsRateEqualTo(BigDecimal value) {
			addCriterion("ZZS_RATE =", value, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateNotEqualTo(BigDecimal value) {
			addCriterion("ZZS_RATE <>", value, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateGreaterThan(BigDecimal value) {
			addCriterion("ZZS_RATE >", value, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ZZS_RATE >=", value, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateLessThan(BigDecimal value) {
			addCriterion("ZZS_RATE <", value, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ZZS_RATE <=", value, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateIn(List<BigDecimal> values) {
			addCriterion("ZZS_RATE in", values, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateNotIn(List<BigDecimal> values) {
			addCriterion("ZZS_RATE not in", values, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ZZS_RATE between", value1, value2, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andZzsRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ZZS_RATE not between", value1, value2, "zzsRate");
			return (Criteria) this;
		}

		public Criteria andGsTypeIsNull() {
			addCriterion("GS_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andGsTypeIsNotNull() {
			addCriterion("GS_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andGsTypeEqualTo(Byte value) {
			addCriterion("GS_TYPE =", value, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeNotEqualTo(Byte value) {
			addCriterion("GS_TYPE <>", value, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeGreaterThan(Byte value) {
			addCriterion("GS_TYPE >", value, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("GS_TYPE >=", value, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeLessThan(Byte value) {
			addCriterion("GS_TYPE <", value, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeLessThanOrEqualTo(Byte value) {
			addCriterion("GS_TYPE <=", value, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeIn(List<Byte> values) {
			addCriterion("GS_TYPE in", values, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeNotIn(List<Byte> values) {
			addCriterion("GS_TYPE not in", values, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeBetween(Byte value1, Byte value2) {
			addCriterion("GS_TYPE between", value1, value2, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("GS_TYPE not between", value1, value2, "gsType");
			return (Criteria) this;
		}

		public Criteria andGsRateIsNull() {
			addCriterion("GS_RATE is null");
			return (Criteria) this;
		}

		public Criteria andGsRateIsNotNull() {
			addCriterion("GS_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andGsRateEqualTo(BigDecimal value) {
			addCriterion("GS_RATE =", value, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateNotEqualTo(BigDecimal value) {
			addCriterion("GS_RATE <>", value, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateGreaterThan(BigDecimal value) {
			addCriterion("GS_RATE >", value, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("GS_RATE >=", value, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateLessThan(BigDecimal value) {
			addCriterion("GS_RATE <", value, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("GS_RATE <=", value, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateIn(List<BigDecimal> values) {
			addCriterion("GS_RATE in", values, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateNotIn(List<BigDecimal> values) {
			addCriterion("GS_RATE not in", values, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GS_RATE between", value1, value2, "gsRate");
			return (Criteria) this;
		}

		public Criteria andGsRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GS_RATE not between", value1, value2, "gsRate");
			return (Criteria) this;
		}

		public Criteria andServerTypeIsNull() {
			addCriterion("SERVER_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andServerTypeIsNotNull() {
			addCriterion("SERVER_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andServerTypeEqualTo(Byte value) {
			addCriterion("SERVER_TYPE =", value, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeNotEqualTo(Byte value) {
			addCriterion("SERVER_TYPE <>", value, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeGreaterThan(Byte value) {
			addCriterion("SERVER_TYPE >", value, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SERVER_TYPE >=", value, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeLessThan(Byte value) {
			addCriterion("SERVER_TYPE <", value, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SERVER_TYPE <=", value, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeIn(List<Byte> values) {
			addCriterion("SERVER_TYPE in", values, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeNotIn(List<Byte> values) {
			addCriterion("SERVER_TYPE not in", values, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeBetween(Byte value1, Byte value2) {
			addCriterion("SERVER_TYPE between", value1, value2, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SERVER_TYPE not between", value1, value2, "serverType");
			return (Criteria) this;
		}

		public Criteria andServerFeeIsNull() {
			addCriterion("SERVER_FEE is null");
			return (Criteria) this;
		}

		public Criteria andServerFeeIsNotNull() {
			addCriterion("SERVER_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andServerFeeEqualTo(BigDecimal value) {
			addCriterion("SERVER_FEE =", value, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeNotEqualTo(BigDecimal value) {
			addCriterion("SERVER_FEE <>", value, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeGreaterThan(BigDecimal value) {
			addCriterion("SERVER_FEE >", value, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SERVER_FEE >=", value, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeLessThan(BigDecimal value) {
			addCriterion("SERVER_FEE <", value, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SERVER_FEE <=", value, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeIn(List<BigDecimal> values) {
			addCriterion("SERVER_FEE in", values, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeNotIn(List<BigDecimal> values) {
			addCriterion("SERVER_FEE not in", values, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SERVER_FEE between", value1, value2, "serverFee");
			return (Criteria) this;
		}

		public Criteria andServerFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SERVER_FEE not between", value1, value2, "serverFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeIsNull() {
			addCriterion("REG_FEE is null");
			return (Criteria) this;
		}

		public Criteria andRegFeeIsNotNull() {
			addCriterion("REG_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andRegFeeEqualTo(BigDecimal value) {
			addCriterion("REG_FEE =", value, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeNotEqualTo(BigDecimal value) {
			addCriterion("REG_FEE <>", value, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeGreaterThan(BigDecimal value) {
			addCriterion("REG_FEE >", value, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REG_FEE >=", value, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeLessThan(BigDecimal value) {
			addCriterion("REG_FEE <", value, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REG_FEE <=", value, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeIn(List<BigDecimal> values) {
			addCriterion("REG_FEE in", values, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeNotIn(List<BigDecimal> values) {
			addCriterion("REG_FEE not in", values, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REG_FEE between", value1, value2, "regFee");
			return (Criteria) this;
		}

		public Criteria andRegFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REG_FEE not between", value1, value2, "regFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeIsNull() {
			addCriterion("TRANSFER_FEE is null");
			return (Criteria) this;
		}

		public Criteria andTransferFeeIsNotNull() {
			addCriterion("TRANSFER_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andTransferFeeEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE =", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeNotEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE <>", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeGreaterThan(BigDecimal value) {
			addCriterion("TRANSFER_FEE >", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE >=", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeLessThan(BigDecimal value) {
			addCriterion("TRANSFER_FEE <", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE <=", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_FEE in", values, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeNotIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_FEE not in", values, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_FEE between", value1, value2, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_FEE not between", value1, value2, "transferFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeIsNull() {
			addCriterion("LAND_CARD_FEE is null");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeIsNotNull() {
			addCriterion("LAND_CARD_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeEqualTo(BigDecimal value) {
			addCriterion("LAND_CARD_FEE =", value, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeNotEqualTo(BigDecimal value) {
			addCriterion("LAND_CARD_FEE <>", value, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeGreaterThan(BigDecimal value) {
			addCriterion("LAND_CARD_FEE >", value, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LAND_CARD_FEE >=", value, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeLessThan(BigDecimal value) {
			addCriterion("LAND_CARD_FEE <", value, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LAND_CARD_FEE <=", value, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeIn(List<BigDecimal> values) {
			addCriterion("LAND_CARD_FEE in", values, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeNotIn(List<BigDecimal> values) {
			addCriterion("LAND_CARD_FEE not in", values, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LAND_CARD_FEE between", value1, value2, "landCardFee");
			return (Criteria) this;
		}

		public Criteria andLandCardFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LAND_CARD_FEE not between", value1, value2, "landCardFee");
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

		public Criteria andExtParamIsNull() {
			addCriterion("EXT_PARAM is null");
			return (Criteria) this;
		}

		public Criteria andExtParamIsNotNull() {
			addCriterion("EXT_PARAM is not null");
			return (Criteria) this;
		}

		public Criteria andExtParamEqualTo(String value) {
			addCriterion("EXT_PARAM =", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamNotEqualTo(String value) {
			addCriterion("EXT_PARAM <>", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamGreaterThan(String value) {
			addCriterion("EXT_PARAM >", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamGreaterThanOrEqualTo(String value) {
			addCriterion("EXT_PARAM >=", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamLessThan(String value) {
			addCriterion("EXT_PARAM <", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamLessThanOrEqualTo(String value) {
			addCriterion("EXT_PARAM <=", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamLike(String value) {
			addCriterion("EXT_PARAM like", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamNotLike(String value) {
			addCriterion("EXT_PARAM not like", value, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamIn(List<String> values) {
			addCriterion("EXT_PARAM in", values, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamNotIn(List<String> values) {
			addCriterion("EXT_PARAM not in", values, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamBetween(String value1, String value2) {
			addCriterion("EXT_PARAM between", value1, value2, "extParam");
			return (Criteria) this;
		}

		public Criteria andExtParamNotBetween(String value1, String value2) {
			addCriterion("EXT_PARAM not between", value1, value2, "extParam");
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