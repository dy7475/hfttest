package com.myfun.repository.agencydb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgencyFunNewBuildingBiddingExample {
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
	public AgencyFunNewBuildingBiddingExample() {
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

		public Criteria andBiddingIdIsNull() {
			addCriterion("BIDDING_ID is null");
			return (Criteria) this;
		}

		public Criteria andBiddingIdIsNotNull() {
			addCriterion("BIDDING_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBiddingIdEqualTo(Integer value) {
			addCriterion("BIDDING_ID =", value, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdNotEqualTo(Integer value) {
			addCriterion("BIDDING_ID <>", value, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdGreaterThan(Integer value) {
			addCriterion("BIDDING_ID >", value, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BIDDING_ID >=", value, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdLessThan(Integer value) {
			addCriterion("BIDDING_ID <", value, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdLessThanOrEqualTo(Integer value) {
			addCriterion("BIDDING_ID <=", value, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdIn(List<Integer> values) {
			addCriterion("BIDDING_ID in", values, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdNotIn(List<Integer> values) {
			addCriterion("BIDDING_ID not in", values, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdBetween(Integer value1, Integer value2) {
			addCriterion("BIDDING_ID between", value1, value2, "biddingId");
			return (Criteria) this;
		}

		public Criteria andBiddingIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BIDDING_ID not between", value1, value2, "biddingId");
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

		public Criteria andBuildIdIsNull() {
			addCriterion("BUILD_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildIdIsNotNull() {
			addCriterion("BUILD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildIdEqualTo(Integer value) {
			addCriterion("BUILD_ID =", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotEqualTo(Integer value) {
			addCriterion("BUILD_ID <>", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThan(Integer value) {
			addCriterion("BUILD_ID >", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID >=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThan(Integer value) {
			addCriterion("BUILD_ID <", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID <=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdIn(List<Integer> values) {
			addCriterion("BUILD_ID in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotIn(List<Integer> values) {
			addCriterion("BUILD_ID not in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID not between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildNameIsNull() {
			addCriterion("BUILD_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuildNameIsNotNull() {
			addCriterion("BUILD_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuildNameEqualTo(String value) {
			addCriterion("BUILD_NAME =", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotEqualTo(String value) {
			addCriterion("BUILD_NAME <>", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameGreaterThan(String value) {
			addCriterion("BUILD_NAME >", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_NAME >=", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLessThan(String value) {
			addCriterion("BUILD_NAME <", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLessThanOrEqualTo(String value) {
			addCriterion("BUILD_NAME <=", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLike(String value) {
			addCriterion("BUILD_NAME like", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotLike(String value) {
			addCriterion("BUILD_NAME not like", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameIn(List<String> values) {
			addCriterion("BUILD_NAME in", values, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotIn(List<String> values) {
			addCriterion("BUILD_NAME not in", values, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameBetween(String value1, String value2) {
			addCriterion("BUILD_NAME between", value1, value2, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotBetween(String value1, String value2) {
			addCriterion("BUILD_NAME not between", value1, value2, "buildName");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIsNull() {
			addCriterion("BEGIN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIsNotNull() {
			addCriterion("BEGIN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeEqualTo(Date value) {
			addCriterion("BEGIN_TIME =", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotEqualTo(Date value) {
			addCriterion("BEGIN_TIME <>", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThan(Date value) {
			addCriterion("BEGIN_TIME >", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("BEGIN_TIME >=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThan(Date value) {
			addCriterion("BEGIN_TIME <", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
			addCriterion("BEGIN_TIME <=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIn(List<Date> values) {
			addCriterion("BEGIN_TIME in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotIn(List<Date> values) {
			addCriterion("BEGIN_TIME not in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeBetween(Date value1, Date value2) {
			addCriterion("BEGIN_TIME between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
			addCriterion("BEGIN_TIME not between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("END_TIME =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("END_TIME <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("END_TIME >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("END_TIME >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("END_TIME <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("END_TIME <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("END_TIME in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("END_TIME not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("END_TIME between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("END_TIME not between", value1, value2, "endTime");
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

		public Criteria andPriceIsNull() {
			addCriterion("PRICE is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(BigDecimal value) {
			addCriterion("PRICE =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(BigDecimal value) {
			addCriterion("PRICE <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(BigDecimal value) {
			addCriterion("PRICE >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PRICE >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(BigDecimal value) {
			addCriterion("PRICE <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PRICE <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<BigDecimal> values) {
			addCriterion("PRICE in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<BigDecimal> values) {
			addCriterion("PRICE not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PRICE between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PRICE not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceIsNull() {
			addCriterion("PERSONAL_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceIsNotNull() {
			addCriterion("PERSONAL_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_PRICE =", value, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceNotEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_PRICE <>", value, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceGreaterThan(BigDecimal value) {
			addCriterion("PERSONAL_PRICE >", value, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_PRICE >=", value, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceLessThan(BigDecimal value) {
			addCriterion("PERSONAL_PRICE <", value, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_PRICE <=", value, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceIn(List<BigDecimal> values) {
			addCriterion("PERSONAL_PRICE in", values, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceNotIn(List<BigDecimal> values) {
			addCriterion("PERSONAL_PRICE not in", values, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSONAL_PRICE between", value1, value2, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSONAL_PRICE not between", value1, value2, "personalPrice");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinIsNull() {
			addCriterion("PERSONAL_COIN is null");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinIsNotNull() {
			addCriterion("PERSONAL_COIN is not null");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_COIN =", value, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinNotEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_COIN <>", value, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinGreaterThan(BigDecimal value) {
			addCriterion("PERSONAL_COIN >", value, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_COIN >=", value, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinLessThan(BigDecimal value) {
			addCriterion("PERSONAL_COIN <", value, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSONAL_COIN <=", value, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinIn(List<BigDecimal> values) {
			addCriterion("PERSONAL_COIN in", values, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinNotIn(List<BigDecimal> values) {
			addCriterion("PERSONAL_COIN not in", values, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSONAL_COIN between", value1, value2, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andPersonalCoinNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSONAL_COIN not between", value1, value2, "personalCoin");
			return (Criteria) this;
		}

		public Criteria andCompPriceIsNull() {
			addCriterion("COMP_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andCompPriceIsNotNull() {
			addCriterion("COMP_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andCompPriceEqualTo(BigDecimal value) {
			addCriterion("COMP_PRICE =", value, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceNotEqualTo(BigDecimal value) {
			addCriterion("COMP_PRICE <>", value, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceGreaterThan(BigDecimal value) {
			addCriterion("COMP_PRICE >", value, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("COMP_PRICE >=", value, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceLessThan(BigDecimal value) {
			addCriterion("COMP_PRICE <", value, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("COMP_PRICE <=", value, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceIn(List<BigDecimal> values) {
			addCriterion("COMP_PRICE in", values, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceNotIn(List<BigDecimal> values) {
			addCriterion("COMP_PRICE not in", values, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMP_PRICE between", value1, value2, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMP_PRICE not between", value1, value2, "compPrice");
			return (Criteria) this;
		}

		public Criteria andCompCoinIsNull() {
			addCriterion("COMP_COIN is null");
			return (Criteria) this;
		}

		public Criteria andCompCoinIsNotNull() {
			addCriterion("COMP_COIN is not null");
			return (Criteria) this;
		}

		public Criteria andCompCoinEqualTo(BigDecimal value) {
			addCriterion("COMP_COIN =", value, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinNotEqualTo(BigDecimal value) {
			addCriterion("COMP_COIN <>", value, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinGreaterThan(BigDecimal value) {
			addCriterion("COMP_COIN >", value, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("COMP_COIN >=", value, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinLessThan(BigDecimal value) {
			addCriterion("COMP_COIN <", value, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinLessThanOrEqualTo(BigDecimal value) {
			addCriterion("COMP_COIN <=", value, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinIn(List<BigDecimal> values) {
			addCriterion("COMP_COIN in", values, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinNotIn(List<BigDecimal> values) {
			addCriterion("COMP_COIN not in", values, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMP_COIN between", value1, value2, "compCoin");
			return (Criteria) this;
		}

		public Criteria andCompCoinNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMP_COIN not between", value1, value2, "compCoin");
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

		public Criteria andCompUaIdIsNull() {
			addCriterion("COMP_UA_ID is null");
			return (Criteria) this;
		}

		public Criteria andCompUaIdIsNotNull() {
			addCriterion("COMP_UA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCompUaIdEqualTo(Integer value) {
			addCriterion("COMP_UA_ID =", value, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdNotEqualTo(Integer value) {
			addCriterion("COMP_UA_ID <>", value, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdGreaterThan(Integer value) {
			addCriterion("COMP_UA_ID >", value, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMP_UA_ID >=", value, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdLessThan(Integer value) {
			addCriterion("COMP_UA_ID <", value, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdLessThanOrEqualTo(Integer value) {
			addCriterion("COMP_UA_ID <=", value, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdIn(List<Integer> values) {
			addCriterion("COMP_UA_ID in", values, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdNotIn(List<Integer> values) {
			addCriterion("COMP_UA_ID not in", values, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdBetween(Integer value1, Integer value2) {
			addCriterion("COMP_UA_ID between", value1, value2, "compUaId");
			return (Criteria) this;
		}

		public Criteria andCompUaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COMP_UA_ID not between", value1, value2, "compUaId");
			return (Criteria) this;
		}

		public Criteria andUaTypeIsNull() {
			addCriterion("UA_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andUaTypeIsNotNull() {
			addCriterion("UA_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andUaTypeEqualTo(Byte value) {
			addCriterion("UA_TYPE =", value, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeNotEqualTo(Byte value) {
			addCriterion("UA_TYPE <>", value, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeGreaterThan(Byte value) {
			addCriterion("UA_TYPE >", value, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("UA_TYPE >=", value, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeLessThan(Byte value) {
			addCriterion("UA_TYPE <", value, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeLessThanOrEqualTo(Byte value) {
			addCriterion("UA_TYPE <=", value, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeIn(List<Byte> values) {
			addCriterion("UA_TYPE in", values, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeNotIn(List<Byte> values) {
			addCriterion("UA_TYPE not in", values, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeBetween(Byte value1, Byte value2) {
			addCriterion("UA_TYPE between", value1, value2, "uaType");
			return (Criteria) this;
		}

		public Criteria andUaTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("UA_TYPE not between", value1, value2, "uaType");
			return (Criteria) this;
		}

		public Criteria andConsultIsNull() {
			addCriterion("CONSULT is null");
			return (Criteria) this;
		}

		public Criteria andConsultIsNotNull() {
			addCriterion("CONSULT is not null");
			return (Criteria) this;
		}

		public Criteria andConsultEqualTo(Integer value) {
			addCriterion("CONSULT =", value, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultNotEqualTo(Integer value) {
			addCriterion("CONSULT <>", value, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultGreaterThan(Integer value) {
			addCriterion("CONSULT >", value, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONSULT >=", value, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultLessThan(Integer value) {
			addCriterion("CONSULT <", value, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultLessThanOrEqualTo(Integer value) {
			addCriterion("CONSULT <=", value, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultIn(List<Integer> values) {
			addCriterion("CONSULT in", values, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultNotIn(List<Integer> values) {
			addCriterion("CONSULT not in", values, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultBetween(Integer value1, Integer value2) {
			addCriterion("CONSULT between", value1, value2, "consult");
			return (Criteria) this;
		}

		public Criteria andConsultNotBetween(Integer value1, Integer value2) {
			addCriterion("CONSULT not between", value1, value2, "consult");
			return (Criteria) this;
		}

		public Criteria andBiddSourceIsNull() {
			addCriterion("BIDD_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andBiddSourceIsNotNull() {
			addCriterion("BIDD_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andBiddSourceEqualTo(Byte value) {
			addCriterion("BIDD_SOURCE =", value, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceNotEqualTo(Byte value) {
			addCriterion("BIDD_SOURCE <>", value, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceGreaterThan(Byte value) {
			addCriterion("BIDD_SOURCE >", value, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("BIDD_SOURCE >=", value, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceLessThan(Byte value) {
			addCriterion("BIDD_SOURCE <", value, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceLessThanOrEqualTo(Byte value) {
			addCriterion("BIDD_SOURCE <=", value, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceIn(List<Byte> values) {
			addCriterion("BIDD_SOURCE in", values, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceNotIn(List<Byte> values) {
			addCriterion("BIDD_SOURCE not in", values, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceBetween(Byte value1, Byte value2) {
			addCriterion("BIDD_SOURCE between", value1, value2, "biddSource");
			return (Criteria) this;
		}

		public Criteria andBiddSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("BIDD_SOURCE not between", value1, value2, "biddSource");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagIsNull() {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagIsNotNull() {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagEqualTo(Byte value) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG =", value, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagNotEqualTo(Byte value) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG <>", value, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagGreaterThan(Byte value) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG >", value, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG >=", value, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagLessThan(Byte value) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG <", value, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG <=", value, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagIn(List<Byte> values) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG in", values, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagNotIn(List<Byte> values) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG not in", values, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG between", value1, value2, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andYouyouBizSyncFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUYOU_BIZ_SYNC_FLAG not between", value1, value2, "youyouBizSyncFlag");
			return (Criteria) this;
		}

		public Criteria andPhone400IsNull() {
			addCriterion("PHONE_400 is null");
			return (Criteria) this;
		}

		public Criteria andPhone400IsNotNull() {
			addCriterion("PHONE_400 is not null");
			return (Criteria) this;
		}

		public Criteria andPhone400EqualTo(String value) {
			addCriterion("PHONE_400 =", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400NotEqualTo(String value) {
			addCriterion("PHONE_400 <>", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400GreaterThan(String value) {
			addCriterion("PHONE_400 >", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400GreaterThanOrEqualTo(String value) {
			addCriterion("PHONE_400 >=", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400LessThan(String value) {
			addCriterion("PHONE_400 <", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400LessThanOrEqualTo(String value) {
			addCriterion("PHONE_400 <=", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400Like(String value) {
			addCriterion("PHONE_400 like", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400NotLike(String value) {
			addCriterion("PHONE_400 not like", value, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400In(List<String> values) {
			addCriterion("PHONE_400 in", values, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400NotIn(List<String> values) {
			addCriterion("PHONE_400 not in", values, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400Between(String value1, String value2) {
			addCriterion("PHONE_400 between", value1, value2, "phone400");
			return (Criteria) this;
		}

		public Criteria andPhone400NotBetween(String value1, String value2) {
			addCriterion("PHONE_400 not between", value1, value2, "phone400");
			return (Criteria) this;
		}

		public Criteria andQueueIdIsNull() {
			addCriterion("QUEUE_ID is null");
			return (Criteria) this;
		}

		public Criteria andQueueIdIsNotNull() {
			addCriterion("QUEUE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andQueueIdEqualTo(Integer value) {
			addCriterion("QUEUE_ID =", value, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdNotEqualTo(Integer value) {
			addCriterion("QUEUE_ID <>", value, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdGreaterThan(Integer value) {
			addCriterion("QUEUE_ID >", value, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("QUEUE_ID >=", value, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdLessThan(Integer value) {
			addCriterion("QUEUE_ID <", value, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdLessThanOrEqualTo(Integer value) {
			addCriterion("QUEUE_ID <=", value, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdIn(List<Integer> values) {
			addCriterion("QUEUE_ID in", values, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdNotIn(List<Integer> values) {
			addCriterion("QUEUE_ID not in", values, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdBetween(Integer value1, Integer value2) {
			addCriterion("QUEUE_ID between", value1, value2, "queueId");
			return (Criteria) this;
		}

		public Criteria andQueueIdNotBetween(Integer value1, Integer value2) {
			addCriterion("QUEUE_ID not between", value1, value2, "queueId");
			return (Criteria) this;
		}

		public Criteria andSelfDescIsNull() {
			addCriterion("SELF_DESC is null");
			return (Criteria) this;
		}

		public Criteria andSelfDescIsNotNull() {
			addCriterion("SELF_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andSelfDescEqualTo(String value) {
			addCriterion("SELF_DESC =", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescNotEqualTo(String value) {
			addCriterion("SELF_DESC <>", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescGreaterThan(String value) {
			addCriterion("SELF_DESC >", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescGreaterThanOrEqualTo(String value) {
			addCriterion("SELF_DESC >=", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescLessThan(String value) {
			addCriterion("SELF_DESC <", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescLessThanOrEqualTo(String value) {
			addCriterion("SELF_DESC <=", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescLike(String value) {
			addCriterion("SELF_DESC like", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescNotLike(String value) {
			addCriterion("SELF_DESC not like", value, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescIn(List<String> values) {
			addCriterion("SELF_DESC in", values, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescNotIn(List<String> values) {
			addCriterion("SELF_DESC not in", values, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescBetween(String value1, String value2) {
			addCriterion("SELF_DESC between", value1, value2, "selfDesc");
			return (Criteria) this;
		}

		public Criteria andSelfDescNotBetween(String value1, String value2) {
			addCriterion("SELF_DESC not between", value1, value2, "selfDesc");
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