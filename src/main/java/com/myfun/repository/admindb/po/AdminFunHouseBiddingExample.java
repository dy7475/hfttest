package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunHouseBiddingExample {
    /**
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public AdminFunHouseBiddingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
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
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
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

        public Criteria andBiddIdIsNull() {
            addCriterion("BIDD_ID is null");
            return (Criteria) this;
        }

        public Criteria andBiddIdIsNotNull() {
            addCriterion("BIDD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBiddIdEqualTo(Integer value) {
            addCriterion("BIDD_ID =", value, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdNotEqualTo(Integer value) {
            addCriterion("BIDD_ID <>", value, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdGreaterThan(Integer value) {
            addCriterion("BIDD_ID >", value, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIDD_ID >=", value, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdLessThan(Integer value) {
            addCriterion("BIDD_ID <", value, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdLessThanOrEqualTo(Integer value) {
            addCriterion("BIDD_ID <=", value, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdIn(List<Integer> values) {
            addCriterion("BIDD_ID in", values, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdNotIn(List<Integer> values) {
            addCriterion("BIDD_ID not in", values, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdBetween(Integer value1, Integer value2) {
            addCriterion("BIDD_ID between", value1, value2, "biddId");
            return (Criteria) this;
        }

        public Criteria andBiddIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BIDD_ID not between", value1, value2, "biddId");
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

        public Criteria andHouseIdIsNull() {
            addCriterion("HOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("HOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(Integer value) {
            addCriterion("HOUSE_ID =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(Integer value) {
            addCriterion("HOUSE_ID <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(Integer value) {
            addCriterion("HOUSE_ID >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HOUSE_ID >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(Integer value) {
            addCriterion("HOUSE_ID <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("HOUSE_ID <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<Integer> values) {
            addCriterion("HOUSE_ID in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<Integer> values) {
            addCriterion("HOUSE_ID not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("HOUSE_ID between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HOUSE_ID not between", value1, value2, "houseId");
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

        public Criteria andHouseUseageIsNull() {
            addCriterion("HOUSE_USEAGE is null");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIsNotNull() {
            addCriterion("HOUSE_USEAGE is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUseageEqualTo(String value) {
            addCriterion("HOUSE_USEAGE =", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotEqualTo(String value) {
            addCriterion("HOUSE_USEAGE <>", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThan(String value) {
            addCriterion("HOUSE_USEAGE >", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_USEAGE >=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThan(String value) {
            addCriterion("HOUSE_USEAGE <", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_USEAGE <=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLike(String value) {
            addCriterion("HOUSE_USEAGE like", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotLike(String value) {
            addCriterion("HOUSE_USEAGE not like", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIn(List<String> values) {
            addCriterion("HOUSE_USEAGE in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotIn(List<String> values) {
            addCriterion("HOUSE_USEAGE not in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageBetween(String value1, String value2) {
            addCriterion("HOUSE_USEAGE between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotBetween(String value1, String value2) {
            addCriterion("HOUSE_USEAGE not between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIsNull() {
            addCriterion("SALE_LEASE is null");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIsNotNull() {
            addCriterion("SALE_LEASE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseEqualTo(String value) {
            addCriterion("SALE_LEASE =", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotEqualTo(String value) {
            addCriterion("SALE_LEASE <>", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThan(String value) {
            addCriterion("SALE_LEASE >", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_LEASE >=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThan(String value) {
            addCriterion("SALE_LEASE <", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThanOrEqualTo(String value) {
            addCriterion("SALE_LEASE <=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLike(String value) {
            addCriterion("SALE_LEASE like", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotLike(String value) {
            addCriterion("SALE_LEASE not like", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIn(List<String> values) {
            addCriterion("SALE_LEASE in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotIn(List<String> values) {
            addCriterion("SALE_LEASE not in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseBetween(String value1, String value2) {
            addCriterion("SALE_LEASE between", value1, value2, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotBetween(String value1, String value2) {
            addCriterion("SALE_LEASE not between", value1, value2, "saleLease");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeIsNull() {
            addCriterion("BIDDING_SUCC_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeIsNotNull() {
            addCriterion("BIDDING_SUCC_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeEqualTo(Date value) {
            addCriterion("BIDDING_SUCC_TIME =", value, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeNotEqualTo(Date value) {
            addCriterion("BIDDING_SUCC_TIME <>", value, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeGreaterThan(Date value) {
            addCriterion("BIDDING_SUCC_TIME >", value, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BIDDING_SUCC_TIME >=", value, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeLessThan(Date value) {
            addCriterion("BIDDING_SUCC_TIME <", value, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeLessThanOrEqualTo(Date value) {
            addCriterion("BIDDING_SUCC_TIME <=", value, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeIn(List<Date> values) {
            addCriterion("BIDDING_SUCC_TIME in", values, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeNotIn(List<Date> values) {
            addCriterion("BIDDING_SUCC_TIME not in", values, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeBetween(Date value1, Date value2) {
            addCriterion("BIDDING_SUCC_TIME between", value1, value2, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingSuccTimeNotBetween(Date value1, Date value2) {
            addCriterion("BIDDING_SUCC_TIME not between", value1, value2, "biddingSuccTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeIsNull() {
            addCriterion("BIDDING_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeIsNotNull() {
            addCriterion("BIDDING_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeEqualTo(Date value) {
            addCriterion("BIDDING_END_TIME =", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeNotEqualTo(Date value) {
            addCriterion("BIDDING_END_TIME <>", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeGreaterThan(Date value) {
            addCriterion("BIDDING_END_TIME >", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BIDDING_END_TIME >=", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeLessThan(Date value) {
            addCriterion("BIDDING_END_TIME <", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("BIDDING_END_TIME <=", value, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeIn(List<Date> values) {
            addCriterion("BIDDING_END_TIME in", values, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeNotIn(List<Date> values) {
            addCriterion("BIDDING_END_TIME not in", values, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeBetween(Date value1, Date value2) {
            addCriterion("BIDDING_END_TIME between", value1, value2, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("BIDDING_END_TIME not between", value1, value2, "biddingEndTime");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysIsNull() {
            addCriterion("BIDDING_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysIsNotNull() {
            addCriterion("BIDDING_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysEqualTo(Integer value) {
            addCriterion("BIDDING_DAYS =", value, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysNotEqualTo(Integer value) {
            addCriterion("BIDDING_DAYS <>", value, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysGreaterThan(Integer value) {
            addCriterion("BIDDING_DAYS >", value, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIDDING_DAYS >=", value, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysLessThan(Integer value) {
            addCriterion("BIDDING_DAYS <", value, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysLessThanOrEqualTo(Integer value) {
            addCriterion("BIDDING_DAYS <=", value, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysIn(List<Integer> values) {
            addCriterion("BIDDING_DAYS in", values, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysNotIn(List<Integer> values) {
            addCriterion("BIDDING_DAYS not in", values, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysBetween(Integer value1, Integer value2) {
            addCriterion("BIDDING_DAYS between", value1, value2, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("BIDDING_DAYS not between", value1, value2, "biddingDays");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceIsNull() {
            addCriterion("BIDDING_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceIsNotNull() {
            addCriterion("BIDDING_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceEqualTo(BigDecimal value) {
            addCriterion("BIDDING_PRICE =", value, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceNotEqualTo(BigDecimal value) {
            addCriterion("BIDDING_PRICE <>", value, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceGreaterThan(BigDecimal value) {
            addCriterion("BIDDING_PRICE >", value, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BIDDING_PRICE >=", value, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceLessThan(BigDecimal value) {
            addCriterion("BIDDING_PRICE <", value, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BIDDING_PRICE <=", value, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceIn(List<BigDecimal> values) {
            addCriterion("BIDDING_PRICE in", values, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceNotIn(List<BigDecimal> values) {
            addCriterion("BIDDING_PRICE not in", values, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BIDDING_PRICE between", value1, value2, "biddingPrice");
            return (Criteria) this;
        }

        public Criteria andBiddingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BIDDING_PRICE not between", value1, value2, "biddingPrice");
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

        public Criteria andQqStatusIsNull() {
            addCriterion("QQ_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andQqStatusIsNotNull() {
            addCriterion("QQ_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andQqStatusEqualTo(Byte value) {
            addCriterion("QQ_STATUS =", value, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusNotEqualTo(Byte value) {
            addCriterion("QQ_STATUS <>", value, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusGreaterThan(Byte value) {
            addCriterion("QQ_STATUS >", value, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("QQ_STATUS >=", value, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusLessThan(Byte value) {
            addCriterion("QQ_STATUS <", value, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusLessThanOrEqualTo(Byte value) {
            addCriterion("QQ_STATUS <=", value, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusIn(List<Byte> values) {
            addCriterion("QQ_STATUS in", values, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusNotIn(List<Byte> values) {
            addCriterion("QQ_STATUS not in", values, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusBetween(Byte value1, Byte value2) {
            addCriterion("QQ_STATUS between", value1, value2, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andQqStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("QQ_STATUS not between", value1, value2, "qqStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusIsNull() {
            addCriterion("HAOFANG_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusIsNotNull() {
            addCriterion("HAOFANG_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusEqualTo(Byte value) {
            addCriterion("HAOFANG_STATUS =", value, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusNotEqualTo(Byte value) {
            addCriterion("HAOFANG_STATUS <>", value, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusGreaterThan(Byte value) {
            addCriterion("HAOFANG_STATUS >", value, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("HAOFANG_STATUS >=", value, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusLessThan(Byte value) {
            addCriterion("HAOFANG_STATUS <", value, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusLessThanOrEqualTo(Byte value) {
            addCriterion("HAOFANG_STATUS <=", value, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusIn(List<Byte> values) {
            addCriterion("HAOFANG_STATUS in", values, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusNotIn(List<Byte> values) {
            addCriterion("HAOFANG_STATUS not in", values, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusBetween(Byte value1, Byte value2) {
            addCriterion("HAOFANG_STATUS between", value1, value2, "haofangStatus");
            return (Criteria) this;
        }

        public Criteria andHaofangStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("HAOFANG_STATUS not between", value1, value2, "haofangStatus");
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

        public Criteria andSyncFlagIsNull() {
            addCriterion("SYNC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIsNotNull() {
            addCriterion("SYNC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSyncFlagEqualTo(Integer value) {
            addCriterion("SYNC_FLAG =", value, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagNotEqualTo(Integer value) {
            addCriterion("SYNC_FLAG <>", value, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagGreaterThan(Integer value) {
            addCriterion("SYNC_FLAG >", value, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("SYNC_FLAG >=", value, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagLessThan(Integer value) {
            addCriterion("SYNC_FLAG <", value, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagLessThanOrEqualTo(Integer value) {
            addCriterion("SYNC_FLAG <=", value, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIn(List<Integer> values) {
            addCriterion("SYNC_FLAG in", values, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagNotIn(List<Integer> values) {
            addCriterion("SYNC_FLAG not in", values, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagBetween(Integer value1, Integer value2) {
            addCriterion("SYNC_FLAG between", value1, value2, "syncFlag");
            return (Criteria) this;
        }

        public Criteria andSyncFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("SYNC_FLAG not between", value1, value2, "syncFlag");
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

        public Criteria andSortPriceIsNull() {
            addCriterion("SORT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andSortPriceIsNotNull() {
            addCriterion("SORT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSortPriceEqualTo(BigDecimal value) {
            addCriterion("SORT_PRICE =", value, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceNotEqualTo(BigDecimal value) {
            addCriterion("SORT_PRICE <>", value, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceGreaterThan(BigDecimal value) {
            addCriterion("SORT_PRICE >", value, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SORT_PRICE >=", value, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceLessThan(BigDecimal value) {
            addCriterion("SORT_PRICE <", value, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SORT_PRICE <=", value, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceIn(List<BigDecimal> values) {
            addCriterion("SORT_PRICE in", values, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceNotIn(List<BigDecimal> values) {
            addCriterion("SORT_PRICE not in", values, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SORT_PRICE between", value1, value2, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andSortPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SORT_PRICE not between", value1, value2, "sortPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceIsNull() {
            addCriterion("ACTIVITY_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andActivityPriceIsNotNull() {
            addCriterion("ACTIVITY_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPriceEqualTo(BigDecimal value) {
            addCriterion("ACTIVITY_PRICE =", value, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceNotEqualTo(BigDecimal value) {
            addCriterion("ACTIVITY_PRICE <>", value, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceGreaterThan(BigDecimal value) {
            addCriterion("ACTIVITY_PRICE >", value, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTIVITY_PRICE >=", value, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceLessThan(BigDecimal value) {
            addCriterion("ACTIVITY_PRICE <", value, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTIVITY_PRICE <=", value, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceIn(List<BigDecimal> values) {
            addCriterion("ACTIVITY_PRICE in", values, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceNotIn(List<BigDecimal> values) {
            addCriterion("ACTIVITY_PRICE not in", values, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTIVITY_PRICE between", value1, value2, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andActivityPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTIVITY_PRICE not between", value1, value2, "activityPrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceIsNull() {
            addCriterion("CASH_BALANCE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceIsNotNull() {
            addCriterion("CASH_BALANCE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceEqualTo(BigDecimal value) {
            addCriterion("CASH_BALANCE_PRICE =", value, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceNotEqualTo(BigDecimal value) {
            addCriterion("CASH_BALANCE_PRICE <>", value, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceGreaterThan(BigDecimal value) {
            addCriterion("CASH_BALANCE_PRICE >", value, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_BALANCE_PRICE >=", value, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceLessThan(BigDecimal value) {
            addCriterion("CASH_BALANCE_PRICE <", value, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_BALANCE_PRICE <=", value, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceIn(List<BigDecimal> values) {
            addCriterion("CASH_BALANCE_PRICE in", values, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceNotIn(List<BigDecimal> values) {
            addCriterion("CASH_BALANCE_PRICE not in", values, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_BALANCE_PRICE between", value1, value2, "cashBalancePrice");
            return (Criteria) this;
        }

        public Criteria andCashBalancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_BALANCE_PRICE not between", value1, value2, "cashBalancePrice");
            return (Criteria) this;
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

    /**
     *
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
}