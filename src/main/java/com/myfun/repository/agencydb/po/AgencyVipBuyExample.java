package com.myfun.repository.agencydb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgencyVipBuyExample {
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
    public AgencyVipBuyExample() {
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

        public Criteria andBuyIdIsNull() {
            addCriterion("BUY_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuyIdIsNotNull() {
            addCriterion("BUY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuyIdEqualTo(Integer value) {
            addCriterion("BUY_ID =", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotEqualTo(Integer value) {
            addCriterion("BUY_ID <>", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThan(Integer value) {
            addCriterion("BUY_ID >", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUY_ID >=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThan(Integer value) {
            addCriterion("BUY_ID <", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThanOrEqualTo(Integer value) {
            addCriterion("BUY_ID <=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdIn(List<Integer> values) {
            addCriterion("BUY_ID in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotIn(List<Integer> values) {
            addCriterion("BUY_ID not in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdBetween(Integer value1, Integer value2) {
            addCriterion("BUY_ID between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BUY_ID not between", value1, value2, "buyId");
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

        public Criteria andBuildIdEqualTo(String value) {
            addCriterion("BUILD_ID =", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotEqualTo(String value) {
            addCriterion("BUILD_ID <>", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThan(String value) {
            addCriterion("BUILD_ID >", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_ID >=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThan(String value) {
            addCriterion("BUILD_ID <", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThanOrEqualTo(String value) {
            addCriterion("BUILD_ID <=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLike(String value) {
            addCriterion("BUILD_ID like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotLike(String value) {
            addCriterion("BUILD_ID not like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIn(List<String> values) {
            addCriterion("BUILD_ID in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotIn(List<String> values) {
            addCriterion("BUILD_ID not in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdBetween(String value1, String value2) {
            addCriterion("BUILD_ID between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotBetween(String value1, String value2) {
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

        public Criteria andHouseRegionIsNull() {
            addCriterion("HOUSE_REGION is null");
            return (Criteria) this;
        }

        public Criteria andHouseRegionIsNotNull() {
            addCriterion("HOUSE_REGION is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRegionEqualTo(String value) {
            addCriterion("HOUSE_REGION =", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotEqualTo(String value) {
            addCriterion("HOUSE_REGION <>", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionGreaterThan(String value) {
            addCriterion("HOUSE_REGION >", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_REGION >=", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionLessThan(String value) {
            addCriterion("HOUSE_REGION <", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_REGION <=", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionLike(String value) {
            addCriterion("HOUSE_REGION like", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotLike(String value) {
            addCriterion("HOUSE_REGION not like", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionIn(List<String> values) {
            addCriterion("HOUSE_REGION in", values, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotIn(List<String> values) {
            addCriterion("HOUSE_REGION not in", values, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionBetween(String value1, String value2) {
            addCriterion("HOUSE_REGION between", value1, value2, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotBetween(String value1, String value2) {
            addCriterion("HOUSE_REGION not between", value1, value2, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("REGION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("REGION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("REGION_NAME =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("REGION_NAME <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("REGION_NAME >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("REGION_NAME >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("REGION_NAME <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("REGION_NAME <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("REGION_NAME like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("REGION_NAME not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("REGION_NAME in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("REGION_NAME not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("REGION_NAME between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("REGION_NAME not between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andHouseRoundIsNull() {
            addCriterion("HOUSE_ROUND is null");
            return (Criteria) this;
        }

        public Criteria andHouseRoundIsNotNull() {
            addCriterion("HOUSE_ROUND is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRoundEqualTo(String value) {
            addCriterion("HOUSE_ROUND =", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundNotEqualTo(String value) {
            addCriterion("HOUSE_ROUND <>", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundGreaterThan(String value) {
            addCriterion("HOUSE_ROUND >", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_ROUND >=", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundLessThan(String value) {
            addCriterion("HOUSE_ROUND <", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_ROUND <=", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundLike(String value) {
            addCriterion("HOUSE_ROUND like", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundNotLike(String value) {
            addCriterion("HOUSE_ROUND not like", value, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundIn(List<String> values) {
            addCriterion("HOUSE_ROUND in", values, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundNotIn(List<String> values) {
            addCriterion("HOUSE_ROUND not in", values, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundBetween(String value1, String value2) {
            addCriterion("HOUSE_ROUND between", value1, value2, "houseRound");
            return (Criteria) this;
        }

        public Criteria andHouseRoundNotBetween(String value1, String value2) {
            addCriterion("HOUSE_ROUND not between", value1, value2, "houseRound");
            return (Criteria) this;
        }

        public Criteria andRoundNameIsNull() {
            addCriterion("ROUND_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoundNameIsNotNull() {
            addCriterion("ROUND_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoundNameEqualTo(String value) {
            addCriterion("ROUND_NAME =", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameNotEqualTo(String value) {
            addCriterion("ROUND_NAME <>", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameGreaterThan(String value) {
            addCriterion("ROUND_NAME >", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROUND_NAME >=", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameLessThan(String value) {
            addCriterion("ROUND_NAME <", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameLessThanOrEqualTo(String value) {
            addCriterion("ROUND_NAME <=", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameLike(String value) {
            addCriterion("ROUND_NAME like", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameNotLike(String value) {
            addCriterion("ROUND_NAME not like", value, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameIn(List<String> values) {
            addCriterion("ROUND_NAME in", values, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameNotIn(List<String> values) {
            addCriterion("ROUND_NAME not in", values, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameBetween(String value1, String value2) {
            addCriterion("ROUND_NAME between", value1, value2, "roundName");
            return (Criteria) this;
        }

        public Criteria andRoundNameNotBetween(String value1, String value2) {
            addCriterion("ROUND_NAME not between", value1, value2, "roundName");
            return (Criteria) this;
        }

        public Criteria andBuySubjectIsNull() {
            addCriterion("BUY_SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andBuySubjectIsNotNull() {
            addCriterion("BUY_SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andBuySubjectEqualTo(String value) {
            addCriterion("BUY_SUBJECT =", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectNotEqualTo(String value) {
            addCriterion("BUY_SUBJECT <>", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectGreaterThan(String value) {
            addCriterion("BUY_SUBJECT >", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectGreaterThanOrEqualTo(String value) {
            addCriterion("BUY_SUBJECT >=", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectLessThan(String value) {
            addCriterion("BUY_SUBJECT <", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectLessThanOrEqualTo(String value) {
            addCriterion("BUY_SUBJECT <=", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectLike(String value) {
            addCriterion("BUY_SUBJECT like", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectNotLike(String value) {
            addCriterion("BUY_SUBJECT not like", value, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectIn(List<String> values) {
            addCriterion("BUY_SUBJECT in", values, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectNotIn(List<String> values) {
            addCriterion("BUY_SUBJECT not in", values, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectBetween(String value1, String value2) {
            addCriterion("BUY_SUBJECT between", value1, value2, "buySubject");
            return (Criteria) this;
        }

        public Criteria andBuySubjectNotBetween(String value1, String value2) {
            addCriterion("BUY_SUBJECT not between", value1, value2, "buySubject");
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

        public Criteria andHouseRightIsNull() {
            addCriterion("HOUSE_RIGHT is null");
            return (Criteria) this;
        }

        public Criteria andHouseRightIsNotNull() {
            addCriterion("HOUSE_RIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRightEqualTo(String value) {
            addCriterion("HOUSE_RIGHT =", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightNotEqualTo(String value) {
            addCriterion("HOUSE_RIGHT <>", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightGreaterThan(String value) {
            addCriterion("HOUSE_RIGHT >", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_RIGHT >=", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightLessThan(String value) {
            addCriterion("HOUSE_RIGHT <", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_RIGHT <=", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightLike(String value) {
            addCriterion("HOUSE_RIGHT like", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightNotLike(String value) {
            addCriterion("HOUSE_RIGHT not like", value, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightIn(List<String> values) {
            addCriterion("HOUSE_RIGHT in", values, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightNotIn(List<String> values) {
            addCriterion("HOUSE_RIGHT not in", values, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightBetween(String value1, String value2) {
            addCriterion("HOUSE_RIGHT between", value1, value2, "houseRight");
            return (Criteria) this;
        }

        public Criteria andHouseRightNotBetween(String value1, String value2) {
            addCriterion("HOUSE_RIGHT not between", value1, value2, "houseRight");
            return (Criteria) this;
        }

        public Criteria andRoomLIsNull() {
            addCriterion("ROOM_L is null");
            return (Criteria) this;
        }

        public Criteria andRoomLIsNotNull() {
            addCriterion("ROOM_L is not null");
            return (Criteria) this;
        }

        public Criteria andRoomLEqualTo(Byte value) {
            addCriterion("ROOM_L =", value, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLNotEqualTo(Byte value) {
            addCriterion("ROOM_L <>", value, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLGreaterThan(Byte value) {
            addCriterion("ROOM_L >", value, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLGreaterThanOrEqualTo(Byte value) {
            addCriterion("ROOM_L >=", value, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLLessThan(Byte value) {
            addCriterion("ROOM_L <", value, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLLessThanOrEqualTo(Byte value) {
            addCriterion("ROOM_L <=", value, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLIn(List<Byte> values) {
            addCriterion("ROOM_L in", values, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLNotIn(List<Byte> values) {
            addCriterion("ROOM_L not in", values, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLBetween(Byte value1, Byte value2) {
            addCriterion("ROOM_L between", value1, value2, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomLNotBetween(Byte value1, Byte value2) {
            addCriterion("ROOM_L not between", value1, value2, "roomL");
            return (Criteria) this;
        }

        public Criteria andRoomHIsNull() {
            addCriterion("ROOM_H is null");
            return (Criteria) this;
        }

        public Criteria andRoomHIsNotNull() {
            addCriterion("ROOM_H is not null");
            return (Criteria) this;
        }

        public Criteria andRoomHEqualTo(Byte value) {
            addCriterion("ROOM_H =", value, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHNotEqualTo(Byte value) {
            addCriterion("ROOM_H <>", value, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHGreaterThan(Byte value) {
            addCriterion("ROOM_H >", value, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHGreaterThanOrEqualTo(Byte value) {
            addCriterion("ROOM_H >=", value, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHLessThan(Byte value) {
            addCriterion("ROOM_H <", value, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHLessThanOrEqualTo(Byte value) {
            addCriterion("ROOM_H <=", value, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHIn(List<Byte> values) {
            addCriterion("ROOM_H in", values, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHNotIn(List<Byte> values) {
            addCriterion("ROOM_H not in", values, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHBetween(Byte value1, Byte value2) {
            addCriterion("ROOM_H between", value1, value2, "roomH");
            return (Criteria) this;
        }

        public Criteria andRoomHNotBetween(Byte value1, Byte value2) {
            addCriterion("ROOM_H not between", value1, value2, "roomH");
            return (Criteria) this;
        }

        public Criteria andFloorLIsNull() {
            addCriterion("FLOOR_L is null");
            return (Criteria) this;
        }

        public Criteria andFloorLIsNotNull() {
            addCriterion("FLOOR_L is not null");
            return (Criteria) this;
        }

        public Criteria andFloorLEqualTo(Byte value) {
            addCriterion("FLOOR_L =", value, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLNotEqualTo(Byte value) {
            addCriterion("FLOOR_L <>", value, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLGreaterThan(Byte value) {
            addCriterion("FLOOR_L >", value, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLGreaterThanOrEqualTo(Byte value) {
            addCriterion("FLOOR_L >=", value, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLLessThan(Byte value) {
            addCriterion("FLOOR_L <", value, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLLessThanOrEqualTo(Byte value) {
            addCriterion("FLOOR_L <=", value, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLIn(List<Byte> values) {
            addCriterion("FLOOR_L in", values, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLNotIn(List<Byte> values) {
            addCriterion("FLOOR_L not in", values, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLBetween(Byte value1, Byte value2) {
            addCriterion("FLOOR_L between", value1, value2, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorLNotBetween(Byte value1, Byte value2) {
            addCriterion("FLOOR_L not between", value1, value2, "floorL");
            return (Criteria) this;
        }

        public Criteria andFloorHIsNull() {
            addCriterion("FLOOR_H is null");
            return (Criteria) this;
        }

        public Criteria andFloorHIsNotNull() {
            addCriterion("FLOOR_H is not null");
            return (Criteria) this;
        }

        public Criteria andFloorHEqualTo(Byte value) {
            addCriterion("FLOOR_H =", value, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHNotEqualTo(Byte value) {
            addCriterion("FLOOR_H <>", value, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHGreaterThan(Byte value) {
            addCriterion("FLOOR_H >", value, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHGreaterThanOrEqualTo(Byte value) {
            addCriterion("FLOOR_H >=", value, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHLessThan(Byte value) {
            addCriterion("FLOOR_H <", value, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHLessThanOrEqualTo(Byte value) {
            addCriterion("FLOOR_H <=", value, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHIn(List<Byte> values) {
            addCriterion("FLOOR_H in", values, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHNotIn(List<Byte> values) {
            addCriterion("FLOOR_H not in", values, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHBetween(Byte value1, Byte value2) {
            addCriterion("FLOOR_H between", value1, value2, "floorH");
            return (Criteria) this;
        }

        public Criteria andFloorHNotBetween(Byte value1, Byte value2) {
            addCriterion("FLOOR_H not between", value1, value2, "floorH");
            return (Criteria) this;
        }

        public Criteria andPriceLIsNull() {
            addCriterion("PRICE_L is null");
            return (Criteria) this;
        }

        public Criteria andPriceLIsNotNull() {
            addCriterion("PRICE_L is not null");
            return (Criteria) this;
        }

        public Criteria andPriceLEqualTo(Integer value) {
            addCriterion("PRICE_L =", value, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLNotEqualTo(Integer value) {
            addCriterion("PRICE_L <>", value, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLGreaterThan(Integer value) {
            addCriterion("PRICE_L >", value, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE_L >=", value, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLLessThan(Integer value) {
            addCriterion("PRICE_L <", value, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLLessThanOrEqualTo(Integer value) {
            addCriterion("PRICE_L <=", value, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLIn(List<Integer> values) {
            addCriterion("PRICE_L in", values, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLNotIn(List<Integer> values) {
            addCriterion("PRICE_L not in", values, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLBetween(Integer value1, Integer value2) {
            addCriterion("PRICE_L between", value1, value2, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceLNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE_L not between", value1, value2, "priceL");
            return (Criteria) this;
        }

        public Criteria andPriceHIsNull() {
            addCriterion("PRICE_H is null");
            return (Criteria) this;
        }

        public Criteria andPriceHIsNotNull() {
            addCriterion("PRICE_H is not null");
            return (Criteria) this;
        }

        public Criteria andPriceHEqualTo(Integer value) {
            addCriterion("PRICE_H =", value, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHNotEqualTo(Integer value) {
            addCriterion("PRICE_H <>", value, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHGreaterThan(Integer value) {
            addCriterion("PRICE_H >", value, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE_H >=", value, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHLessThan(Integer value) {
            addCriterion("PRICE_H <", value, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHLessThanOrEqualTo(Integer value) {
            addCriterion("PRICE_H <=", value, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHIn(List<Integer> values) {
            addCriterion("PRICE_H in", values, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHNotIn(List<Integer> values) {
            addCriterion("PRICE_H not in", values, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHBetween(Integer value1, Integer value2) {
            addCriterion("PRICE_H between", value1, value2, "priceH");
            return (Criteria) this;
        }

        public Criteria andPriceHNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE_H not between", value1, value2, "priceH");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeIsNull() {
            addCriterion("BUY_PAYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeIsNotNull() {
            addCriterion("BUY_PAYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeEqualTo(String value) {
            addCriterion("BUY_PAYTYPE =", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeNotEqualTo(String value) {
            addCriterion("BUY_PAYTYPE <>", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeGreaterThan(String value) {
            addCriterion("BUY_PAYTYPE >", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUY_PAYTYPE >=", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeLessThan(String value) {
            addCriterion("BUY_PAYTYPE <", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeLessThanOrEqualTo(String value) {
            addCriterion("BUY_PAYTYPE <=", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeLike(String value) {
            addCriterion("BUY_PAYTYPE like", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeNotLike(String value) {
            addCriterion("BUY_PAYTYPE not like", value, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeIn(List<String> values) {
            addCriterion("BUY_PAYTYPE in", values, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeNotIn(List<String> values) {
            addCriterion("BUY_PAYTYPE not in", values, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeBetween(String value1, String value2) {
            addCriterion("BUY_PAYTYPE between", value1, value2, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andBuyPaytypeNotBetween(String value1, String value2) {
            addCriterion("BUY_PAYTYPE not between", value1, value2, "buyPaytype");
            return (Criteria) this;
        }

        public Criteria andDownPayIsNull() {
            addCriterion("DOWN_PAY is null");
            return (Criteria) this;
        }

        public Criteria andDownPayIsNotNull() {
            addCriterion("DOWN_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andDownPayEqualTo(Integer value) {
            addCriterion("DOWN_PAY =", value, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayNotEqualTo(Integer value) {
            addCriterion("DOWN_PAY <>", value, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayGreaterThan(Integer value) {
            addCriterion("DOWN_PAY >", value, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("DOWN_PAY >=", value, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayLessThan(Integer value) {
            addCriterion("DOWN_PAY <", value, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayLessThanOrEqualTo(Integer value) {
            addCriterion("DOWN_PAY <=", value, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayIn(List<Integer> values) {
            addCriterion("DOWN_PAY in", values, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayNotIn(List<Integer> values) {
            addCriterion("DOWN_PAY not in", values, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayBetween(Integer value1, Integer value2) {
            addCriterion("DOWN_PAY between", value1, value2, "downPay");
            return (Criteria) this;
        }

        public Criteria andDownPayNotBetween(Integer value1, Integer value2) {
            addCriterion("DOWN_PAY not between", value1, value2, "downPay");
            return (Criteria) this;
        }

        public Criteria andAreaLIsNull() {
            addCriterion("AREA_L is null");
            return (Criteria) this;
        }

        public Criteria andAreaLIsNotNull() {
            addCriterion("AREA_L is not null");
            return (Criteria) this;
        }

        public Criteria andAreaLEqualTo(Integer value) {
            addCriterion("AREA_L =", value, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLNotEqualTo(Integer value) {
            addCriterion("AREA_L <>", value, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLGreaterThan(Integer value) {
            addCriterion("AREA_L >", value, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLGreaterThanOrEqualTo(Integer value) {
            addCriterion("AREA_L >=", value, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLLessThan(Integer value) {
            addCriterion("AREA_L <", value, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLLessThanOrEqualTo(Integer value) {
            addCriterion("AREA_L <=", value, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLIn(List<Integer> values) {
            addCriterion("AREA_L in", values, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLNotIn(List<Integer> values) {
            addCriterion("AREA_L not in", values, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLBetween(Integer value1, Integer value2) {
            addCriterion("AREA_L between", value1, value2, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaLNotBetween(Integer value1, Integer value2) {
            addCriterion("AREA_L not between", value1, value2, "areaL");
            return (Criteria) this;
        }

        public Criteria andAreaHIsNull() {
            addCriterion("AREA_H is null");
            return (Criteria) this;
        }

        public Criteria andAreaHIsNotNull() {
            addCriterion("AREA_H is not null");
            return (Criteria) this;
        }

        public Criteria andAreaHEqualTo(Integer value) {
            addCriterion("AREA_H =", value, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHNotEqualTo(Integer value) {
            addCriterion("AREA_H <>", value, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHGreaterThan(Integer value) {
            addCriterion("AREA_H >", value, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHGreaterThanOrEqualTo(Integer value) {
            addCriterion("AREA_H >=", value, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHLessThan(Integer value) {
            addCriterion("AREA_H <", value, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHLessThanOrEqualTo(Integer value) {
            addCriterion("AREA_H <=", value, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHIn(List<Integer> values) {
            addCriterion("AREA_H in", values, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHNotIn(List<Integer> values) {
            addCriterion("AREA_H not in", values, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHBetween(Integer value1, Integer value2) {
            addCriterion("AREA_H between", value1, value2, "areaH");
            return (Criteria) this;
        }

        public Criteria andAreaHNotBetween(Integer value1, Integer value2) {
            addCriterion("AREA_H not between", value1, value2, "areaH");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentIsNull() {
            addCriterion("HOUSE_FITMENT is null");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentIsNotNull() {
            addCriterion("HOUSE_FITMENT is not null");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentEqualTo(String value) {
            addCriterion("HOUSE_FITMENT =", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentNotEqualTo(String value) {
            addCriterion("HOUSE_FITMENT <>", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentGreaterThan(String value) {
            addCriterion("HOUSE_FITMENT >", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_FITMENT >=", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentLessThan(String value) {
            addCriterion("HOUSE_FITMENT <", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_FITMENT <=", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentLike(String value) {
            addCriterion("HOUSE_FITMENT like", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentNotLike(String value) {
            addCriterion("HOUSE_FITMENT not like", value, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentIn(List<String> values) {
            addCriterion("HOUSE_FITMENT in", values, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentNotIn(List<String> values) {
            addCriterion("HOUSE_FITMENT not in", values, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentBetween(String value1, String value2) {
            addCriterion("HOUSE_FITMENT between", value1, value2, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andHouseFitmentNotBetween(String value1, String value2) {
            addCriterion("HOUSE_FITMENT not between", value1, value2, "houseFitment");
            return (Criteria) this;
        }

        public Criteria andDescpIsNull() {
            addCriterion("DESCP is null");
            return (Criteria) this;
        }

        public Criteria andDescpIsNotNull() {
            addCriterion("DESCP is not null");
            return (Criteria) this;
        }

        public Criteria andDescpEqualTo(String value) {
            addCriterion("DESCP =", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpNotEqualTo(String value) {
            addCriterion("DESCP <>", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpGreaterThan(String value) {
            addCriterion("DESCP >", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpGreaterThanOrEqualTo(String value) {
            addCriterion("DESCP >=", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpLessThan(String value) {
            addCriterion("DESCP <", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpLessThanOrEqualTo(String value) {
            addCriterion("DESCP <=", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpLike(String value) {
            addCriterion("DESCP like", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpNotLike(String value) {
            addCriterion("DESCP not like", value, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpIn(List<String> values) {
            addCriterion("DESCP in", values, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpNotIn(List<String> values) {
            addCriterion("DESCP not in", values, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpBetween(String value1, String value2) {
            addCriterion("DESCP between", value1, value2, "descp");
            return (Criteria) this;
        }

        public Criteria andDescpNotBetween(String value1, String value2) {
            addCriterion("DESCP not between", value1, value2, "descp");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Byte value) {
            addCriterion("PERIOD =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Byte value) {
            addCriterion("PERIOD <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Byte value) {
            addCriterion("PERIOD >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Byte value) {
            addCriterion("PERIOD >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Byte value) {
            addCriterion("PERIOD <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Byte value) {
            addCriterion("PERIOD <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Byte> values) {
            addCriterion("PERIOD in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Byte> values) {
            addCriterion("PERIOD not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Byte value1, Byte value2) {
            addCriterion("PERIOD between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Byte value1, Byte value2) {
            addCriterion("PERIOD not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andRelateHouseIsNull() {
            addCriterion("RELATE_HOUSE is null");
            return (Criteria) this;
        }

        public Criteria andRelateHouseIsNotNull() {
            addCriterion("RELATE_HOUSE is not null");
            return (Criteria) this;
        }

        public Criteria andRelateHouseEqualTo(Integer value) {
            addCriterion("RELATE_HOUSE =", value, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseNotEqualTo(Integer value) {
            addCriterion("RELATE_HOUSE <>", value, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseGreaterThan(Integer value) {
            addCriterion("RELATE_HOUSE >", value, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseGreaterThanOrEqualTo(Integer value) {
            addCriterion("RELATE_HOUSE >=", value, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseLessThan(Integer value) {
            addCriterion("RELATE_HOUSE <", value, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseLessThanOrEqualTo(Integer value) {
            addCriterion("RELATE_HOUSE <=", value, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseIn(List<Integer> values) {
            addCriterion("RELATE_HOUSE in", values, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseNotIn(List<Integer> values) {
            addCriterion("RELATE_HOUSE not in", values, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseBetween(Integer value1, Integer value2) {
            addCriterion("RELATE_HOUSE between", value1, value2, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andRelateHouseNotBetween(Integer value1, Integer value2) {
            addCriterion("RELATE_HOUSE not between", value1, value2, "relateHouse");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("COMMISSION is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("COMMISSION is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("COMMISSION =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("COMMISSION <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("COMMISSION >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("COMMISSION <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("COMMISSION in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("COMMISSION not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCashDepositIsNull() {
            addCriterion("CASH_DEPOSIT is null");
            return (Criteria) this;
        }

        public Criteria andCashDepositIsNotNull() {
            addCriterion("CASH_DEPOSIT is not null");
            return (Criteria) this;
        }

        public Criteria andCashDepositEqualTo(Integer value) {
            addCriterion("CASH_DEPOSIT =", value, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositNotEqualTo(Integer value) {
            addCriterion("CASH_DEPOSIT <>", value, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositGreaterThan(Integer value) {
            addCriterion("CASH_DEPOSIT >", value, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASH_DEPOSIT >=", value, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositLessThan(Integer value) {
            addCriterion("CASH_DEPOSIT <", value, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositLessThanOrEqualTo(Integer value) {
            addCriterion("CASH_DEPOSIT <=", value, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositIn(List<Integer> values) {
            addCriterion("CASH_DEPOSIT in", values, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositNotIn(List<Integer> values) {
            addCriterion("CASH_DEPOSIT not in", values, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositBetween(Integer value1, Integer value2) {
            addCriterion("CASH_DEPOSIT between", value1, value2, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andCashDepositNotBetween(Integer value1, Integer value2) {
            addCriterion("CASH_DEPOSIT not between", value1, value2, "cashDeposit");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("CLIENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("CLIENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Integer value) {
            addCriterion("CLIENT_ID =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Integer value) {
            addCriterion("CLIENT_ID <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Integer value) {
            addCriterion("CLIENT_ID >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLIENT_ID >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Integer value) {
            addCriterion("CLIENT_ID <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Integer value) {
            addCriterion("CLIENT_ID <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Integer> values) {
            addCriterion("CLIENT_ID in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Integer> values) {
            addCriterion("CLIENT_ID not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Integer value1, Integer value2) {
            addCriterion("CLIENT_ID between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CLIENT_ID not between", value1, value2, "clientId");
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

        public Criteria andTrackUserIsNull() {
            addCriterion("TRACK_USER is null");
            return (Criteria) this;
        }

        public Criteria andTrackUserIsNotNull() {
            addCriterion("TRACK_USER is not null");
            return (Criteria) this;
        }

        public Criteria andTrackUserEqualTo(Integer value) {
            addCriterion("TRACK_USER =", value, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserNotEqualTo(Integer value) {
            addCriterion("TRACK_USER <>", value, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserGreaterThan(Integer value) {
            addCriterion("TRACK_USER >", value, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRACK_USER >=", value, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserLessThan(Integer value) {
            addCriterion("TRACK_USER <", value, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserLessThanOrEqualTo(Integer value) {
            addCriterion("TRACK_USER <=", value, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserIn(List<Integer> values) {
            addCriterion("TRACK_USER in", values, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserNotIn(List<Integer> values) {
            addCriterion("TRACK_USER not in", values, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserBetween(Integer value1, Integer value2) {
            addCriterion("TRACK_USER between", value1, value2, "trackUser");
            return (Criteria) this;
        }

        public Criteria andTrackUserNotBetween(Integer value1, Integer value2) {
            addCriterion("TRACK_USER not between", value1, value2, "trackUser");
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

        public Criteria andCaseStatusIsNull() {
            addCriterion("CASE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIsNotNull() {
            addCriterion("CASE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusEqualTo(Integer value) {
            addCriterion("CASE_STATUS =", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotEqualTo(Integer value) {
            addCriterion("CASE_STATUS <>", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThan(Integer value) {
            addCriterion("CASE_STATUS >", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASE_STATUS >=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThan(Integer value) {
            addCriterion("CASE_STATUS <", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("CASE_STATUS <=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIn(List<Integer> values) {
            addCriterion("CASE_STATUS in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotIn(List<Integer> values) {
            addCriterion("CASE_STATUS not in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusBetween(Integer value1, Integer value2) {
            addCriterion("CASE_STATUS between", value1, value2, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("CASE_STATUS not between", value1, value2, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andTradePriceIsNull() {
            addCriterion("TRADE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTradePriceIsNotNull() {
            addCriterion("TRADE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTradePriceEqualTo(Integer value) {
            addCriterion("TRADE_PRICE =", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceNotEqualTo(Integer value) {
            addCriterion("TRADE_PRICE <>", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceGreaterThan(Integer value) {
            addCriterion("TRADE_PRICE >", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRADE_PRICE >=", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceLessThan(Integer value) {
            addCriterion("TRADE_PRICE <", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceLessThanOrEqualTo(Integer value) {
            addCriterion("TRADE_PRICE <=", value, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceIn(List<Integer> values) {
            addCriterion("TRADE_PRICE in", values, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceNotIn(List<Integer> values) {
            addCriterion("TRADE_PRICE not in", values, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_PRICE between", value1, value2, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_PRICE not between", value1, value2, "tradePrice");
            return (Criteria) this;
        }

        public Criteria andTradeTimesIsNull() {
            addCriterion("TRADE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimesIsNotNull() {
            addCriterion("TRADE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimesEqualTo(Integer value) {
            addCriterion("TRADE_TIMES =", value, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesNotEqualTo(Integer value) {
            addCriterion("TRADE_TIMES <>", value, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesGreaterThan(Integer value) {
            addCriterion("TRADE_TIMES >", value, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRADE_TIMES >=", value, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesLessThan(Integer value) {
            addCriterion("TRADE_TIMES <", value, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesLessThanOrEqualTo(Integer value) {
            addCriterion("TRADE_TIMES <=", value, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesIn(List<Integer> values) {
            addCriterion("TRADE_TIMES in", values, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesNotIn(List<Integer> values) {
            addCriterion("TRADE_TIMES not in", values, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_TIMES between", value1, value2, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_TIMES not between", value1, value2, "tradeTimes");
            return (Criteria) this;
        }

        public Criteria andTradeUserIsNull() {
            addCriterion("TRADE_USER is null");
            return (Criteria) this;
        }

        public Criteria andTradeUserIsNotNull() {
            addCriterion("TRADE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andTradeUserEqualTo(Integer value) {
            addCriterion("TRADE_USER =", value, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserNotEqualTo(Integer value) {
            addCriterion("TRADE_USER <>", value, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserGreaterThan(Integer value) {
            addCriterion("TRADE_USER >", value, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRADE_USER >=", value, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserLessThan(Integer value) {
            addCriterion("TRADE_USER <", value, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserLessThanOrEqualTo(Integer value) {
            addCriterion("TRADE_USER <=", value, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserIn(List<Integer> values) {
            addCriterion("TRADE_USER in", values, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserNotIn(List<Integer> values) {
            addCriterion("TRADE_USER not in", values, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_USER between", value1, value2, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeUserNotBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_USER not between", value1, value2, "tradeUser");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("TRADE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("TRADE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Date value) {
            addCriterion("TRADE_TIME =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Date value) {
            addCriterion("TRADE_TIME <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Date value) {
            addCriterion("TRADE_TIME >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TRADE_TIME >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Date value) {
            addCriterion("TRADE_TIME <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("TRADE_TIME <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Date> values) {
            addCriterion("TRADE_TIME in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Date> values) {
            addCriterion("TRADE_TIME not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Date value1, Date value2) {
            addCriterion("TRADE_TIME between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("TRADE_TIME not between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeFlagIsNull() {
            addCriterion("TRADE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andTradeFlagIsNotNull() {
            addCriterion("TRADE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTradeFlagEqualTo(Byte value) {
            addCriterion("TRADE_FLAG =", value, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagNotEqualTo(Byte value) {
            addCriterion("TRADE_FLAG <>", value, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagGreaterThan(Byte value) {
            addCriterion("TRADE_FLAG >", value, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("TRADE_FLAG >=", value, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagLessThan(Byte value) {
            addCriterion("TRADE_FLAG <", value, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagLessThanOrEqualTo(Byte value) {
            addCriterion("TRADE_FLAG <=", value, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagIn(List<Byte> values) {
            addCriterion("TRADE_FLAG in", values, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagNotIn(List<Byte> values) {
            addCriterion("TRADE_FLAG not in", values, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagBetween(Byte value1, Byte value2) {
            addCriterion("TRADE_FLAG between", value1, value2, "tradeFlag");
            return (Criteria) this;
        }

        public Criteria andTradeFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("TRADE_FLAG not between", value1, value2, "tradeFlag");
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

        public Criteria andInfoSourceIsNull() {
            addCriterion("INFO_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andInfoSourceIsNotNull() {
            addCriterion("INFO_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andInfoSourceEqualTo(Byte value) {
            addCriterion("INFO_SOURCE =", value, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceNotEqualTo(Byte value) {
            addCriterion("INFO_SOURCE <>", value, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceGreaterThan(Byte value) {
            addCriterion("INFO_SOURCE >", value, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("INFO_SOURCE >=", value, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceLessThan(Byte value) {
            addCriterion("INFO_SOURCE <", value, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceLessThanOrEqualTo(Byte value) {
            addCriterion("INFO_SOURCE <=", value, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceIn(List<Byte> values) {
            addCriterion("INFO_SOURCE in", values, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceNotIn(List<Byte> values) {
            addCriterion("INFO_SOURCE not in", values, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceBetween(Byte value1, Byte value2) {
            addCriterion("INFO_SOURCE between", value1, value2, "infoSource");
            return (Criteria) this;
        }

        public Criteria andInfoSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("INFO_SOURCE not between", value1, value2, "infoSource");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagIsNull() {
            addCriterion("REPEAT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagIsNotNull() {
            addCriterion("REPEAT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagEqualTo(Byte value) {
            addCriterion("REPEAT_FLAG =", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagNotEqualTo(Byte value) {
            addCriterion("REPEAT_FLAG <>", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagGreaterThan(Byte value) {
            addCriterion("REPEAT_FLAG >", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("REPEAT_FLAG >=", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagLessThan(Byte value) {
            addCriterion("REPEAT_FLAG <", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagLessThanOrEqualTo(Byte value) {
            addCriterion("REPEAT_FLAG <=", value, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagIn(List<Byte> values) {
            addCriterion("REPEAT_FLAG in", values, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagNotIn(List<Byte> values) {
            addCriterion("REPEAT_FLAG not in", values, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagBetween(Byte value1, Byte value2) {
            addCriterion("REPEAT_FLAG between", value1, value2, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andRepeatFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("REPEAT_FLAG not between", value1, value2, "repeatFlag");
            return (Criteria) this;
        }

        public Criteria andHouseSectionIsNull() {
            addCriterion("HOUSE_SECTION is null");
            return (Criteria) this;
        }

        public Criteria andHouseSectionIsNotNull() {
            addCriterion("HOUSE_SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andHouseSectionEqualTo(String value) {
            addCriterion("HOUSE_SECTION =", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionNotEqualTo(String value) {
            addCriterion("HOUSE_SECTION <>", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionGreaterThan(String value) {
            addCriterion("HOUSE_SECTION >", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_SECTION >=", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionLessThan(String value) {
            addCriterion("HOUSE_SECTION <", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_SECTION <=", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionLike(String value) {
            addCriterion("HOUSE_SECTION like", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionNotLike(String value) {
            addCriterion("HOUSE_SECTION not like", value, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionIn(List<String> values) {
            addCriterion("HOUSE_SECTION in", values, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionNotIn(List<String> values) {
            addCriterion("HOUSE_SECTION not in", values, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionBetween(String value1, String value2) {
            addCriterion("HOUSE_SECTION between", value1, value2, "houseSection");
            return (Criteria) this;
        }

        public Criteria andHouseSectionNotBetween(String value1, String value2) {
            addCriterion("HOUSE_SECTION not between", value1, value2, "houseSection");
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

        public Criteria andNewComplainIsNull() {
            addCriterion("NEW_COMPLAIN is null");
            return (Criteria) this;
        }

        public Criteria andNewComplainIsNotNull() {
            addCriterion("NEW_COMPLAIN is not null");
            return (Criteria) this;
        }

        public Criteria andNewComplainEqualTo(Byte value) {
            addCriterion("NEW_COMPLAIN =", value, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainNotEqualTo(Byte value) {
            addCriterion("NEW_COMPLAIN <>", value, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainGreaterThan(Byte value) {
            addCriterion("NEW_COMPLAIN >", value, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainGreaterThanOrEqualTo(Byte value) {
            addCriterion("NEW_COMPLAIN >=", value, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainLessThan(Byte value) {
            addCriterion("NEW_COMPLAIN <", value, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainLessThanOrEqualTo(Byte value) {
            addCriterion("NEW_COMPLAIN <=", value, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainIn(List<Byte> values) {
            addCriterion("NEW_COMPLAIN in", values, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainNotIn(List<Byte> values) {
            addCriterion("NEW_COMPLAIN not in", values, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainBetween(Byte value1, Byte value2) {
            addCriterion("NEW_COMPLAIN between", value1, value2, "newComplain");
            return (Criteria) this;
        }

        public Criteria andNewComplainNotBetween(Byte value1, Byte value2) {
            addCriterion("NEW_COMPLAIN not between", value1, value2, "newComplain");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("HOUSE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("HOUSE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("HOUSE_TYPE =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("HOUSE_TYPE <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("HOUSE_TYPE >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_TYPE >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("HOUSE_TYPE <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_TYPE <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("HOUSE_TYPE like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("HOUSE_TYPE not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("HOUSE_TYPE in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("HOUSE_TYPE not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("HOUSE_TYPE between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("HOUSE_TYPE not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowIsNull() {
            addCriterion("HOUSE_YEAR_LOW is null");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowIsNotNull() {
            addCriterion("HOUSE_YEAR_LOW is not null");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowEqualTo(String value) {
            addCriterion("HOUSE_YEAR_LOW =", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowNotEqualTo(String value) {
            addCriterion("HOUSE_YEAR_LOW <>", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowGreaterThan(String value) {
            addCriterion("HOUSE_YEAR_LOW >", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_YEAR_LOW >=", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowLessThan(String value) {
            addCriterion("HOUSE_YEAR_LOW <", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_YEAR_LOW <=", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowLike(String value) {
            addCriterion("HOUSE_YEAR_LOW like", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowNotLike(String value) {
            addCriterion("HOUSE_YEAR_LOW not like", value, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowIn(List<String> values) {
            addCriterion("HOUSE_YEAR_LOW in", values, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowNotIn(List<String> values) {
            addCriterion("HOUSE_YEAR_LOW not in", values, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowBetween(String value1, String value2) {
            addCriterion("HOUSE_YEAR_LOW between", value1, value2, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearLowNotBetween(String value1, String value2) {
            addCriterion("HOUSE_YEAR_LOW not between", value1, value2, "houseYearLow");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighIsNull() {
            addCriterion("HOUSE_YEAR_HIGH is null");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighIsNotNull() {
            addCriterion("HOUSE_YEAR_HIGH is not null");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighEqualTo(String value) {
            addCriterion("HOUSE_YEAR_HIGH =", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighNotEqualTo(String value) {
            addCriterion("HOUSE_YEAR_HIGH <>", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighGreaterThan(String value) {
            addCriterion("HOUSE_YEAR_HIGH >", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_YEAR_HIGH >=", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighLessThan(String value) {
            addCriterion("HOUSE_YEAR_HIGH <", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_YEAR_HIGH <=", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighLike(String value) {
            addCriterion("HOUSE_YEAR_HIGH like", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighNotLike(String value) {
            addCriterion("HOUSE_YEAR_HIGH not like", value, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighIn(List<String> values) {
            addCriterion("HOUSE_YEAR_HIGH in", values, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighNotIn(List<String> values) {
            addCriterion("HOUSE_YEAR_HIGH not in", values, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighBetween(String value1, String value2) {
            addCriterion("HOUSE_YEAR_HIGH between", value1, value2, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andHouseYearHighNotBetween(String value1, String value2) {
            addCriterion("HOUSE_YEAR_HIGH not between", value1, value2, "houseYearHigh");
            return (Criteria) this;
        }

        public Criteria andComplainTimeIsNull() {
            addCriterion("COMPLAIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andComplainTimeIsNotNull() {
            addCriterion("COMPLAIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andComplainTimeEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME =", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeNotEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME <>", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeGreaterThan(Date value) {
            addCriterion("COMPLAIN_TIME >", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME >=", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeLessThan(Date value) {
            addCriterion("COMPLAIN_TIME <", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeLessThanOrEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME <=", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeIn(List<Date> values) {
            addCriterion("COMPLAIN_TIME in", values, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeNotIn(List<Date> values) {
            addCriterion("COMPLAIN_TIME not in", values, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeBetween(Date value1, Date value2) {
            addCriterion("COMPLAIN_TIME between", value1, value2, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeNotBetween(Date value1, Date value2) {
            addCriterion("COMPLAIN_TIME not between", value1, value2, "complainTime");
            return (Criteria) this;
        }

        public Criteria andHasRefundIsNull() {
            addCriterion("HAS_REFUND is null");
            return (Criteria) this;
        }

        public Criteria andHasRefundIsNotNull() {
            addCriterion("HAS_REFUND is not null");
            return (Criteria) this;
        }

        public Criteria andHasRefundEqualTo(Byte value) {
            addCriterion("HAS_REFUND =", value, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundNotEqualTo(Byte value) {
            addCriterion("HAS_REFUND <>", value, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundGreaterThan(Byte value) {
            addCriterion("HAS_REFUND >", value, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundGreaterThanOrEqualTo(Byte value) {
            addCriterion("HAS_REFUND >=", value, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundLessThan(Byte value) {
            addCriterion("HAS_REFUND <", value, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundLessThanOrEqualTo(Byte value) {
            addCriterion("HAS_REFUND <=", value, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundIn(List<Byte> values) {
            addCriterion("HAS_REFUND in", values, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundNotIn(List<Byte> values) {
            addCriterion("HAS_REFUND not in", values, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundBetween(Byte value1, Byte value2) {
            addCriterion("HAS_REFUND between", value1, value2, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andHasRefundNotBetween(Byte value1, Byte value2) {
            addCriterion("HAS_REFUND not between", value1, value2, "hasRefund");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("REFUND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("REFUND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("REFUND_TIME =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("REFUND_TIME <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("REFUND_TIME >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REFUND_TIME >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("REFUND_TIME <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("REFUND_TIME <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("REFUND_TIME in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("REFUND_TIME not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("REFUND_TIME between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("REFUND_TIME not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountIsNull() {
            addCriterion("PURCHASE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountIsNotNull() {
            addCriterion("PURCHASE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountEqualTo(Byte value) {
            addCriterion("PURCHASE_COUNT =", value, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountNotEqualTo(Byte value) {
            addCriterion("PURCHASE_COUNT <>", value, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountGreaterThan(Byte value) {
            addCriterion("PURCHASE_COUNT >", value, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("PURCHASE_COUNT >=", value, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountLessThan(Byte value) {
            addCriterion("PURCHASE_COUNT <", value, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountLessThanOrEqualTo(Byte value) {
            addCriterion("PURCHASE_COUNT <=", value, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountIn(List<Byte> values) {
            addCriterion("PURCHASE_COUNT in", values, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountNotIn(List<Byte> values) {
            addCriterion("PURCHASE_COUNT not in", values, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountBetween(Byte value1, Byte value2) {
            addCriterion("PURCHASE_COUNT between", value1, value2, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andPurchaseCountNotBetween(Byte value1, Byte value2) {
            addCriterion("PURCHASE_COUNT not between", value1, value2, "purchaseCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountIsNull() {
            addCriterion("COMPLAIN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andComplainCountIsNotNull() {
            addCriterion("COMPLAIN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andComplainCountEqualTo(Byte value) {
            addCriterion("COMPLAIN_COUNT =", value, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountNotEqualTo(Byte value) {
            addCriterion("COMPLAIN_COUNT <>", value, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountGreaterThan(Byte value) {
            addCriterion("COMPLAIN_COUNT >", value, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("COMPLAIN_COUNT >=", value, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountLessThan(Byte value) {
            addCriterion("COMPLAIN_COUNT <", value, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountLessThanOrEqualTo(Byte value) {
            addCriterion("COMPLAIN_COUNT <=", value, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountIn(List<Byte> values) {
            addCriterion("COMPLAIN_COUNT in", values, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountNotIn(List<Byte> values) {
            addCriterion("COMPLAIN_COUNT not in", values, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAIN_COUNT between", value1, value2, "complainCount");
            return (Criteria) this;
        }

        public Criteria andComplainCountNotBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAIN_COUNT not between", value1, value2, "complainCount");
            return (Criteria) this;
        }

        public Criteria andDownTimeIsNull() {
            addCriterion("DOWN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDownTimeIsNotNull() {
            addCriterion("DOWN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDownTimeEqualTo(Date value) {
            addCriterion("DOWN_TIME =", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotEqualTo(Date value) {
            addCriterion("DOWN_TIME <>", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThan(Date value) {
            addCriterion("DOWN_TIME >", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DOWN_TIME >=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThan(Date value) {
            addCriterion("DOWN_TIME <", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThanOrEqualTo(Date value) {
            addCriterion("DOWN_TIME <=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeIn(List<Date> values) {
            addCriterion("DOWN_TIME in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotIn(List<Date> values) {
            addCriterion("DOWN_TIME not in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeBetween(Date value1, Date value2) {
            addCriterion("DOWN_TIME between", value1, value2, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotBetween(Date value1, Date value2) {
            addCriterion("DOWN_TIME not between", value1, value2, "downTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeIsNull() {
            addCriterion("FULL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFullTimeIsNotNull() {
            addCriterion("FULL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFullTimeEqualTo(Date value) {
            addCriterion("FULL_TIME =", value, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeNotEqualTo(Date value) {
            addCriterion("FULL_TIME <>", value, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeGreaterThan(Date value) {
            addCriterion("FULL_TIME >", value, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FULL_TIME >=", value, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeLessThan(Date value) {
            addCriterion("FULL_TIME <", value, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeLessThanOrEqualTo(Date value) {
            addCriterion("FULL_TIME <=", value, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeIn(List<Date> values) {
            addCriterion("FULL_TIME in", values, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeNotIn(List<Date> values) {
            addCriterion("FULL_TIME not in", values, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeBetween(Date value1, Date value2) {
            addCriterion("FULL_TIME between", value1, value2, "fullTime");
            return (Criteria) this;
        }

        public Criteria andFullTimeNotBetween(Date value1, Date value2) {
            addCriterion("FULL_TIME not between", value1, value2, "fullTime");
            return (Criteria) this;
        }

        public Criteria andDownTrackidIsNull() {
            addCriterion("DOWN_TRACKID is null");
            return (Criteria) this;
        }

        public Criteria andDownTrackidIsNotNull() {
            addCriterion("DOWN_TRACKID is not null");
            return (Criteria) this;
        }

        public Criteria andDownTrackidEqualTo(Integer value) {
            addCriterion("DOWN_TRACKID =", value, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidNotEqualTo(Integer value) {
            addCriterion("DOWN_TRACKID <>", value, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidGreaterThan(Integer value) {
            addCriterion("DOWN_TRACKID >", value, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DOWN_TRACKID >=", value, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidLessThan(Integer value) {
            addCriterion("DOWN_TRACKID <", value, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidLessThanOrEqualTo(Integer value) {
            addCriterion("DOWN_TRACKID <=", value, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidIn(List<Integer> values) {
            addCriterion("DOWN_TRACKID in", values, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidNotIn(List<Integer> values) {
            addCriterion("DOWN_TRACKID not in", values, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidBetween(Integer value1, Integer value2) {
            addCriterion("DOWN_TRACKID between", value1, value2, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andDownTrackidNotBetween(Integer value1, Integer value2) {
            addCriterion("DOWN_TRACKID not between", value1, value2, "downTrackid");
            return (Criteria) this;
        }

        public Criteria andIsurgentIsNull() {
            addCriterion("ISURGENT is null");
            return (Criteria) this;
        }

        public Criteria andIsurgentIsNotNull() {
            addCriterion("ISURGENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsurgentEqualTo(Byte value) {
            addCriterion("ISURGENT =", value, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentNotEqualTo(Byte value) {
            addCriterion("ISURGENT <>", value, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentGreaterThan(Byte value) {
            addCriterion("ISURGENT >", value, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentGreaterThanOrEqualTo(Byte value) {
            addCriterion("ISURGENT >=", value, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentLessThan(Byte value) {
            addCriterion("ISURGENT <", value, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentLessThanOrEqualTo(Byte value) {
            addCriterion("ISURGENT <=", value, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentIn(List<Byte> values) {
            addCriterion("ISURGENT in", values, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentNotIn(List<Byte> values) {
            addCriterion("ISURGENT not in", values, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentBetween(Byte value1, Byte value2) {
            addCriterion("ISURGENT between", value1, value2, "isurgent");
            return (Criteria) this;
        }

        public Criteria andIsurgentNotBetween(Byte value1, Byte value2) {
            addCriterion("ISURGENT not between", value1, value2, "isurgent");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitIsNull() {
            addCriterion("BUY_PRICE_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitIsNotNull() {
            addCriterion("BUY_PRICE_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitEqualTo(Byte value) {
            addCriterion("BUY_PRICE_UNIT =", value, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitNotEqualTo(Byte value) {
            addCriterion("BUY_PRICE_UNIT <>", value, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitGreaterThan(Byte value) {
            addCriterion("BUY_PRICE_UNIT >", value, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitGreaterThanOrEqualTo(Byte value) {
            addCriterion("BUY_PRICE_UNIT >=", value, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitLessThan(Byte value) {
            addCriterion("BUY_PRICE_UNIT <", value, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitLessThanOrEqualTo(Byte value) {
            addCriterion("BUY_PRICE_UNIT <=", value, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitIn(List<Byte> values) {
            addCriterion("BUY_PRICE_UNIT in", values, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitNotIn(List<Byte> values) {
            addCriterion("BUY_PRICE_UNIT not in", values, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitBetween(Byte value1, Byte value2) {
            addCriterion("BUY_PRICE_UNIT between", value1, value2, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyPriceUnitNotBetween(Byte value1, Byte value2) {
            addCriterion("BUY_PRICE_UNIT not between", value1, value2, "buyPriceUnit");
            return (Criteria) this;
        }

        public Criteria andSosoIdIsNull() {
            addCriterion("SOSO_ID is null");
            return (Criteria) this;
        }

        public Criteria andSosoIdIsNotNull() {
            addCriterion("SOSO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSosoIdEqualTo(Integer value) {
            addCriterion("SOSO_ID =", value, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdNotEqualTo(Integer value) {
            addCriterion("SOSO_ID <>", value, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdGreaterThan(Integer value) {
            addCriterion("SOSO_ID >", value, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOSO_ID >=", value, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdLessThan(Integer value) {
            addCriterion("SOSO_ID <", value, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdLessThanOrEqualTo(Integer value) {
            addCriterion("SOSO_ID <=", value, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdIn(List<Integer> values) {
            addCriterion("SOSO_ID in", values, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdNotIn(List<Integer> values) {
            addCriterion("SOSO_ID not in", values, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdBetween(Integer value1, Integer value2) {
            addCriterion("SOSO_ID between", value1, value2, "sosoId");
            return (Criteria) this;
        }

        public Criteria andSosoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SOSO_ID not between", value1, value2, "sosoId");
            return (Criteria) this;
        }

        public Criteria andUgcIdIsNull() {
            addCriterion("UGC_ID is null");
            return (Criteria) this;
        }

        public Criteria andUgcIdIsNotNull() {
            addCriterion("UGC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUgcIdEqualTo(Integer value) {
            addCriterion("UGC_ID =", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdNotEqualTo(Integer value) {
            addCriterion("UGC_ID <>", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdGreaterThan(Integer value) {
            addCriterion("UGC_ID >", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UGC_ID >=", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdLessThan(Integer value) {
            addCriterion("UGC_ID <", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdLessThanOrEqualTo(Integer value) {
            addCriterion("UGC_ID <=", value, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdIn(List<Integer> values) {
            addCriterion("UGC_ID in", values, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdNotIn(List<Integer> values) {
            addCriterion("UGC_ID not in", values, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdBetween(Integer value1, Integer value2) {
            addCriterion("UGC_ID between", value1, value2, "ugcId");
            return (Criteria) this;
        }

        public Criteria andUgcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UGC_ID not between", value1, value2, "ugcId");
            return (Criteria) this;
        }

        public Criteria andWxIdIsNull() {
            addCriterion("WX_ID is null");
            return (Criteria) this;
        }

        public Criteria andWxIdIsNotNull() {
            addCriterion("WX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWxIdEqualTo(Integer value) {
            addCriterion("WX_ID =", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdNotEqualTo(Integer value) {
            addCriterion("WX_ID <>", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdGreaterThan(Integer value) {
            addCriterion("WX_ID >", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WX_ID >=", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdLessThan(Integer value) {
            addCriterion("WX_ID <", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdLessThanOrEqualTo(Integer value) {
            addCriterion("WX_ID <=", value, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdIn(List<Integer> values) {
            addCriterion("WX_ID in", values, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdNotIn(List<Integer> values) {
            addCriterion("WX_ID not in", values, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdBetween(Integer value1, Integer value2) {
            addCriterion("WX_ID between", value1, value2, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WX_ID not between", value1, value2, "wxId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIsNull() {
            addCriterion("WX_OPEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIsNotNull() {
            addCriterion("WX_OPEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdEqualTo(String value) {
            addCriterion("WX_OPEN_ID =", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotEqualTo(String value) {
            addCriterion("WX_OPEN_ID <>", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdGreaterThan(String value) {
            addCriterion("WX_OPEN_ID >", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("WX_OPEN_ID >=", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLessThan(String value) {
            addCriterion("WX_OPEN_ID <", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLessThanOrEqualTo(String value) {
            addCriterion("WX_OPEN_ID <=", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLike(String value) {
            addCriterion("WX_OPEN_ID like", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotLike(String value) {
            addCriterion("WX_OPEN_ID not like", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIn(List<String> values) {
            addCriterion("WX_OPEN_ID in", values, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotIn(List<String> values) {
            addCriterion("WX_OPEN_ID not in", values, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdBetween(String value1, String value2) {
            addCriterion("WX_OPEN_ID between", value1, value2, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotBetween(String value1, String value2) {
            addCriterion("WX_OPEN_ID not between", value1, value2, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWfStatusIsNull() {
            addCriterion("WF_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWfStatusIsNotNull() {
            addCriterion("WF_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWfStatusEqualTo(Byte value) {
            addCriterion("WF_STATUS =", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusNotEqualTo(Byte value) {
            addCriterion("WF_STATUS <>", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusGreaterThan(Byte value) {
            addCriterion("WF_STATUS >", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("WF_STATUS >=", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusLessThan(Byte value) {
            addCriterion("WF_STATUS <", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusLessThanOrEqualTo(Byte value) {
            addCriterion("WF_STATUS <=", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusIn(List<Byte> values) {
            addCriterion("WF_STATUS in", values, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusNotIn(List<Byte> values) {
            addCriterion("WF_STATUS not in", values, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusBetween(Byte value1, Byte value2) {
            addCriterion("WF_STATUS between", value1, value2, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("WF_STATUS not between", value1, value2, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidIsNull() {
            addCriterion("WF_STATUS_VALID is null");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidIsNotNull() {
            addCriterion("WF_STATUS_VALID is not null");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidEqualTo(Byte value) {
            addCriterion("WF_STATUS_VALID =", value, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidNotEqualTo(Byte value) {
            addCriterion("WF_STATUS_VALID <>", value, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidGreaterThan(Byte value) {
            addCriterion("WF_STATUS_VALID >", value, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidGreaterThanOrEqualTo(Byte value) {
            addCriterion("WF_STATUS_VALID >=", value, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidLessThan(Byte value) {
            addCriterion("WF_STATUS_VALID <", value, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidLessThanOrEqualTo(Byte value) {
            addCriterion("WF_STATUS_VALID <=", value, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidIn(List<Byte> values) {
            addCriterion("WF_STATUS_VALID in", values, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidNotIn(List<Byte> values) {
            addCriterion("WF_STATUS_VALID not in", values, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidBetween(Byte value1, Byte value2) {
            addCriterion("WF_STATUS_VALID between", value1, value2, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusValidNotBetween(Byte value1, Byte value2) {
            addCriterion("WF_STATUS_VALID not between", value1, value2, "wfStatusValid");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropIsNull() {
            addCriterion("WF_STATUS_DROP is null");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropIsNotNull() {
            addCriterion("WF_STATUS_DROP is not null");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropEqualTo(Byte value) {
            addCriterion("WF_STATUS_DROP =", value, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropNotEqualTo(Byte value) {
            addCriterion("WF_STATUS_DROP <>", value, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropGreaterThan(Byte value) {
            addCriterion("WF_STATUS_DROP >", value, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropGreaterThanOrEqualTo(Byte value) {
            addCriterion("WF_STATUS_DROP >=", value, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropLessThan(Byte value) {
            addCriterion("WF_STATUS_DROP <", value, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropLessThanOrEqualTo(Byte value) {
            addCriterion("WF_STATUS_DROP <=", value, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropIn(List<Byte> values) {
            addCriterion("WF_STATUS_DROP in", values, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropNotIn(List<Byte> values) {
            addCriterion("WF_STATUS_DROP not in", values, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropBetween(Byte value1, Byte value2) {
            addCriterion("WF_STATUS_DROP between", value1, value2, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfStatusDropNotBetween(Byte value1, Byte value2) {
            addCriterion("WF_STATUS_DROP not between", value1, value2, "wfStatusDrop");
            return (Criteria) this;
        }

        public Criteria andWfSexIsNull() {
            addCriterion("WF_SEX is null");
            return (Criteria) this;
        }

        public Criteria andWfSexIsNotNull() {
            addCriterion("WF_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andWfSexEqualTo(Byte value) {
            addCriterion("WF_SEX =", value, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexNotEqualTo(Byte value) {
            addCriterion("WF_SEX <>", value, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexGreaterThan(Byte value) {
            addCriterion("WF_SEX >", value, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("WF_SEX >=", value, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexLessThan(Byte value) {
            addCriterion("WF_SEX <", value, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexLessThanOrEqualTo(Byte value) {
            addCriterion("WF_SEX <=", value, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexIn(List<Byte> values) {
            addCriterion("WF_SEX in", values, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexNotIn(List<Byte> values) {
            addCriterion("WF_SEX not in", values, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexBetween(Byte value1, Byte value2) {
            addCriterion("WF_SEX between", value1, value2, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfSexNotBetween(Byte value1, Byte value2) {
            addCriterion("WF_SEX not between", value1, value2, "wfSex");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdIsNull() {
            addCriterion("WF_RELATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdIsNotNull() {
            addCriterion("WF_RELATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdEqualTo(Integer value) {
            addCriterion("WF_RELATE_ID =", value, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdNotEqualTo(Integer value) {
            addCriterion("WF_RELATE_ID <>", value, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdGreaterThan(Integer value) {
            addCriterion("WF_RELATE_ID >", value, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WF_RELATE_ID >=", value, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdLessThan(Integer value) {
            addCriterion("WF_RELATE_ID <", value, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdLessThanOrEqualTo(Integer value) {
            addCriterion("WF_RELATE_ID <=", value, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdIn(List<Integer> values) {
            addCriterion("WF_RELATE_ID in", values, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdNotIn(List<Integer> values) {
            addCriterion("WF_RELATE_ID not in", values, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdBetween(Integer value1, Integer value2) {
            addCriterion("WF_RELATE_ID between", value1, value2, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfRelateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WF_RELATE_ID not between", value1, value2, "wfRelateId");
            return (Criteria) this;
        }

        public Criteria andWfFeeIsNull() {
            addCriterion("WF_FEE is null");
            return (Criteria) this;
        }

        public Criteria andWfFeeIsNotNull() {
            addCriterion("WF_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andWfFeeEqualTo(String value) {
            addCriterion("WF_FEE =", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeNotEqualTo(String value) {
            addCriterion("WF_FEE <>", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeGreaterThan(String value) {
            addCriterion("WF_FEE >", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeGreaterThanOrEqualTo(String value) {
            addCriterion("WF_FEE >=", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeLessThan(String value) {
            addCriterion("WF_FEE <", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeLessThanOrEqualTo(String value) {
            addCriterion("WF_FEE <=", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeLike(String value) {
            addCriterion("WF_FEE like", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeNotLike(String value) {
            addCriterion("WF_FEE not like", value, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeIn(List<String> values) {
            addCriterion("WF_FEE in", values, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeNotIn(List<String> values) {
            addCriterion("WF_FEE not in", values, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeBetween(String value1, String value2) {
            addCriterion("WF_FEE between", value1, value2, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfFeeNotBetween(String value1, String value2) {
            addCriterion("WF_FEE not between", value1, value2, "wfFee");
            return (Criteria) this;
        }

        public Criteria andWfMoneyIsNull() {
            addCriterion("WF_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyIsNotNull() {
            addCriterion("WF_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyEqualTo(Long value) {
            addCriterion("WF_MONEY =", value, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyNotEqualTo(Long value) {
            addCriterion("WF_MONEY <>", value, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyGreaterThan(Long value) {
            addCriterion("WF_MONEY >", value, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY >=", value, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyLessThan(Long value) {
            addCriterion("WF_MONEY <", value, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyLessThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY <=", value, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyIn(List<Long> values) {
            addCriterion("WF_MONEY in", values, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyNotIn(List<Long> values) {
            addCriterion("WF_MONEY not in", values, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY between", value1, value2, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyNotBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY not between", value1, value2, "wfMoney");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddIsNull() {
            addCriterion("WF_MONEY_ADD is null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddIsNotNull() {
            addCriterion("WF_MONEY_ADD is not null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddEqualTo(Long value) {
            addCriterion("WF_MONEY_ADD =", value, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddNotEqualTo(Long value) {
            addCriterion("WF_MONEY_ADD <>", value, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddGreaterThan(Long value) {
            addCriterion("WF_MONEY_ADD >", value, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_ADD >=", value, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddLessThan(Long value) {
            addCriterion("WF_MONEY_ADD <", value, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddLessThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_ADD <=", value, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddIn(List<Long> values) {
            addCriterion("WF_MONEY_ADD in", values, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddNotIn(List<Long> values) {
            addCriterion("WF_MONEY_ADD not in", values, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_ADD between", value1, value2, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyAddNotBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_ADD not between", value1, value2, "wfMoneyAdd");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieIsNull() {
            addCriterion("WF_MONEY_BUTIE is null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieIsNotNull() {
            addCriterion("WF_MONEY_BUTIE is not null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieEqualTo(Long value) {
            addCriterion("WF_MONEY_BUTIE =", value, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieNotEqualTo(Long value) {
            addCriterion("WF_MONEY_BUTIE <>", value, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieGreaterThan(Long value) {
            addCriterion("WF_MONEY_BUTIE >", value, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_BUTIE >=", value, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieLessThan(Long value) {
            addCriterion("WF_MONEY_BUTIE <", value, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieLessThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_BUTIE <=", value, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieIn(List<Long> values) {
            addCriterion("WF_MONEY_BUTIE in", values, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieNotIn(List<Long> values) {
            addCriterion("WF_MONEY_BUTIE not in", values, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_BUTIE between", value1, value2, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyButieNotBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_BUTIE not between", value1, value2, "wfMoneyButie");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusIsNull() {
            addCriterion("WF_MONEY_BONUS is null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusIsNotNull() {
            addCriterion("WF_MONEY_BONUS is not null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusEqualTo(Long value) {
            addCriterion("WF_MONEY_BONUS =", value, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusNotEqualTo(Long value) {
            addCriterion("WF_MONEY_BONUS <>", value, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusGreaterThan(Long value) {
            addCriterion("WF_MONEY_BONUS >", value, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_BONUS >=", value, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusLessThan(Long value) {
            addCriterion("WF_MONEY_BONUS <", value, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusLessThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_BONUS <=", value, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusIn(List<Long> values) {
            addCriterion("WF_MONEY_BONUS in", values, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusNotIn(List<Long> values) {
            addCriterion("WF_MONEY_BONUS not in", values, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_BONUS between", value1, value2, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyBonusNotBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_BONUS not between", value1, value2, "wfMoneyBonus");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnIsNull() {
            addCriterion("WF_MONEY_RETURN is null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnIsNotNull() {
            addCriterion("WF_MONEY_RETURN is not null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnEqualTo(Long value) {
            addCriterion("WF_MONEY_RETURN =", value, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnNotEqualTo(Long value) {
            addCriterion("WF_MONEY_RETURN <>", value, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnGreaterThan(Long value) {
            addCriterion("WF_MONEY_RETURN >", value, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_RETURN >=", value, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnLessThan(Long value) {
            addCriterion("WF_MONEY_RETURN <", value, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnLessThanOrEqualTo(Long value) {
            addCriterion("WF_MONEY_RETURN <=", value, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnIn(List<Long> values) {
            addCriterion("WF_MONEY_RETURN in", values, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnNotIn(List<Long> values) {
            addCriterion("WF_MONEY_RETURN not in", values, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_RETURN between", value1, value2, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyReturnNotBetween(Long value1, Long value2) {
            addCriterion("WF_MONEY_RETURN not between", value1, value2, "wfMoneyReturn");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayIsNull() {
            addCriterion("WF_MONEY_PAY is null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayIsNotNull() {
            addCriterion("WF_MONEY_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayEqualTo(BigDecimal value) {
            addCriterion("WF_MONEY_PAY =", value, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayNotEqualTo(BigDecimal value) {
            addCriterion("WF_MONEY_PAY <>", value, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayGreaterThan(BigDecimal value) {
            addCriterion("WF_MONEY_PAY >", value, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WF_MONEY_PAY >=", value, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayLessThan(BigDecimal value) {
            addCriterion("WF_MONEY_PAY <", value, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WF_MONEY_PAY <=", value, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayIn(List<BigDecimal> values) {
            addCriterion("WF_MONEY_PAY in", values, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayNotIn(List<BigDecimal> values) {
            addCriterion("WF_MONEY_PAY not in", values, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WF_MONEY_PAY between", value1, value2, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfMoneyPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WF_MONEY_PAY not between", value1, value2, "wfMoneyPay");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyIsNull() {
            addCriterion("WF_ONLINE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyIsNotNull() {
            addCriterion("WF_ONLINE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyEqualTo(BigDecimal value) {
            addCriterion("WF_ONLINE_MONEY =", value, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyNotEqualTo(BigDecimal value) {
            addCriterion("WF_ONLINE_MONEY <>", value, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyGreaterThan(BigDecimal value) {
            addCriterion("WF_ONLINE_MONEY >", value, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WF_ONLINE_MONEY >=", value, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyLessThan(BigDecimal value) {
            addCriterion("WF_ONLINE_MONEY <", value, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WF_ONLINE_MONEY <=", value, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyIn(List<BigDecimal> values) {
            addCriterion("WF_ONLINE_MONEY in", values, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyNotIn(List<BigDecimal> values) {
            addCriterion("WF_ONLINE_MONEY not in", values, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WF_ONLINE_MONEY between", value1, value2, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfOnlineMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WF_ONLINE_MONEY not between", value1, value2, "wfOnlineMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyIsNull() {
            addCriterion("WF_HOUSE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyIsNotNull() {
            addCriterion("WF_HOUSE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyEqualTo(Long value) {
            addCriterion("WF_HOUSE_MONEY =", value, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyNotEqualTo(Long value) {
            addCriterion("WF_HOUSE_MONEY <>", value, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyGreaterThan(Long value) {
            addCriterion("WF_HOUSE_MONEY >", value, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_HOUSE_MONEY >=", value, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyLessThan(Long value) {
            addCriterion("WF_HOUSE_MONEY <", value, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyLessThanOrEqualTo(Long value) {
            addCriterion("WF_HOUSE_MONEY <=", value, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyIn(List<Long> values) {
            addCriterion("WF_HOUSE_MONEY in", values, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyNotIn(List<Long> values) {
            addCriterion("WF_HOUSE_MONEY not in", values, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyBetween(Long value1, Long value2) {
            addCriterion("WF_HOUSE_MONEY between", value1, value2, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfHouseMoneyNotBetween(Long value1, Long value2) {
            addCriterion("WF_HOUSE_MONEY not between", value1, value2, "wfHouseMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyIsNull() {
            addCriterion("WF_BROKER_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyIsNotNull() {
            addCriterion("WF_BROKER_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyEqualTo(Long value) {
            addCriterion("WF_BROKER_MONEY =", value, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyNotEqualTo(Long value) {
            addCriterion("WF_BROKER_MONEY <>", value, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyGreaterThan(Long value) {
            addCriterion("WF_BROKER_MONEY >", value, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("WF_BROKER_MONEY >=", value, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyLessThan(Long value) {
            addCriterion("WF_BROKER_MONEY <", value, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyLessThanOrEqualTo(Long value) {
            addCriterion("WF_BROKER_MONEY <=", value, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyIn(List<Long> values) {
            addCriterion("WF_BROKER_MONEY in", values, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyNotIn(List<Long> values) {
            addCriterion("WF_BROKER_MONEY not in", values, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyBetween(Long value1, Long value2) {
            addCriterion("WF_BROKER_MONEY between", value1, value2, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfBrokerMoneyNotBetween(Long value1, Long value2) {
            addCriterion("WF_BROKER_MONEY not between", value1, value2, "wfBrokerMoney");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeIsNull() {
            addCriterion("WF_COMPLETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeIsNotNull() {
            addCriterion("WF_COMPLETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeEqualTo(Date value) {
            addCriterion("WF_COMPLETE_TIME =", value, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeNotEqualTo(Date value) {
            addCriterion("WF_COMPLETE_TIME <>", value, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeGreaterThan(Date value) {
            addCriterion("WF_COMPLETE_TIME >", value, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WF_COMPLETE_TIME >=", value, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeLessThan(Date value) {
            addCriterion("WF_COMPLETE_TIME <", value, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("WF_COMPLETE_TIME <=", value, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeIn(List<Date> values) {
            addCriterion("WF_COMPLETE_TIME in", values, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeNotIn(List<Date> values) {
            addCriterion("WF_COMPLETE_TIME not in", values, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("WF_COMPLETE_TIME between", value1, value2, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("WF_COMPLETE_TIME not between", value1, value2, "wfCompleteTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeIsNull() {
            addCriterion("WF_RECEIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeIsNotNull() {
            addCriterion("WF_RECEIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeEqualTo(Integer value) {
            addCriterion("WF_RECEIVE_TIME =", value, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeNotEqualTo(Integer value) {
            addCriterion("WF_RECEIVE_TIME <>", value, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeGreaterThan(Integer value) {
            addCriterion("WF_RECEIVE_TIME >", value, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("WF_RECEIVE_TIME >=", value, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeLessThan(Integer value) {
            addCriterion("WF_RECEIVE_TIME <", value, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeLessThanOrEqualTo(Integer value) {
            addCriterion("WF_RECEIVE_TIME <=", value, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeIn(List<Integer> values) {
            addCriterion("WF_RECEIVE_TIME in", values, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeNotIn(List<Integer> values) {
            addCriterion("WF_RECEIVE_TIME not in", values, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeBetween(Integer value1, Integer value2) {
            addCriterion("WF_RECEIVE_TIME between", value1, value2, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfReceiveTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("WF_RECEIVE_TIME not between", value1, value2, "wfReceiveTime");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesIsNull() {
            addCriterion("WF_PUSH_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesIsNotNull() {
            addCriterion("WF_PUSH_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesEqualTo(Integer value) {
            addCriterion("WF_PUSH_TIMES =", value, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesNotEqualTo(Integer value) {
            addCriterion("WF_PUSH_TIMES <>", value, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesGreaterThan(Integer value) {
            addCriterion("WF_PUSH_TIMES >", value, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("WF_PUSH_TIMES >=", value, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesLessThan(Integer value) {
            addCriterion("WF_PUSH_TIMES <", value, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesLessThanOrEqualTo(Integer value) {
            addCriterion("WF_PUSH_TIMES <=", value, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesIn(List<Integer> values) {
            addCriterion("WF_PUSH_TIMES in", values, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesNotIn(List<Integer> values) {
            addCriterion("WF_PUSH_TIMES not in", values, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesBetween(Integer value1, Integer value2) {
            addCriterion("WF_PUSH_TIMES between", value1, value2, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andWfPushTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("WF_PUSH_TIMES not between", value1, value2, "wfPushTimes");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("OPERATOR_ID =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("OPERATOR_ID <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("OPERATOR_ID >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATOR_ID >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("OPERATOR_ID <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATOR_ID <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("OPERATOR_ID in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("OPERATOR_ID not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("OPERATOR_ID between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATOR_ID not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andDownReasonIsNull() {
            addCriterion("DOWN_REASON is null");
            return (Criteria) this;
        }

        public Criteria andDownReasonIsNotNull() {
            addCriterion("DOWN_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andDownReasonEqualTo(String value) {
            addCriterion("DOWN_REASON =", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotEqualTo(String value) {
            addCriterion("DOWN_REASON <>", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonGreaterThan(String value) {
            addCriterion("DOWN_REASON >", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonGreaterThanOrEqualTo(String value) {
            addCriterion("DOWN_REASON >=", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonLessThan(String value) {
            addCriterion("DOWN_REASON <", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonLessThanOrEqualTo(String value) {
            addCriterion("DOWN_REASON <=", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonLike(String value) {
            addCriterion("DOWN_REASON like", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotLike(String value) {
            addCriterion("DOWN_REASON not like", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonIn(List<String> values) {
            addCriterion("DOWN_REASON in", values, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotIn(List<String> values) {
            addCriterion("DOWN_REASON not in", values, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonBetween(String value1, String value2) {
            addCriterion("DOWN_REASON between", value1, value2, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotBetween(String value1, String value2) {
            addCriterion("DOWN_REASON not between", value1, value2, "downReason");
            return (Criteria) this;
        }

        public Criteria andJiedanCountIsNull() {
            addCriterion("JIEDAN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andJiedanCountIsNotNull() {
            addCriterion("JIEDAN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andJiedanCountEqualTo(Integer value) {
            addCriterion("JIEDAN_COUNT =", value, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountNotEqualTo(Integer value) {
            addCriterion("JIEDAN_COUNT <>", value, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountGreaterThan(Integer value) {
            addCriterion("JIEDAN_COUNT >", value, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("JIEDAN_COUNT >=", value, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountLessThan(Integer value) {
            addCriterion("JIEDAN_COUNT <", value, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountLessThanOrEqualTo(Integer value) {
            addCriterion("JIEDAN_COUNT <=", value, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountIn(List<Integer> values) {
            addCriterion("JIEDAN_COUNT in", values, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountNotIn(List<Integer> values) {
            addCriterion("JIEDAN_COUNT not in", values, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountBetween(Integer value1, Integer value2) {
            addCriterion("JIEDAN_COUNT between", value1, value2, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andJiedanCountNotBetween(Integer value1, Integer value2) {
            addCriterion("JIEDAN_COUNT not between", value1, value2, "jiedanCount");
            return (Criteria) this;
        }

        public Criteria andWfArchivesIsNull() {
            addCriterion("WF_ARCHIVES is null");
            return (Criteria) this;
        }

        public Criteria andWfArchivesIsNotNull() {
            addCriterion("WF_ARCHIVES is not null");
            return (Criteria) this;
        }

        public Criteria andWfArchivesEqualTo(String value) {
            addCriterion("WF_ARCHIVES =", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesNotEqualTo(String value) {
            addCriterion("WF_ARCHIVES <>", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesGreaterThan(String value) {
            addCriterion("WF_ARCHIVES >", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesGreaterThanOrEqualTo(String value) {
            addCriterion("WF_ARCHIVES >=", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesLessThan(String value) {
            addCriterion("WF_ARCHIVES <", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesLessThanOrEqualTo(String value) {
            addCriterion("WF_ARCHIVES <=", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesLike(String value) {
            addCriterion("WF_ARCHIVES like", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesNotLike(String value) {
            addCriterion("WF_ARCHIVES not like", value, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesIn(List<String> values) {
            addCriterion("WF_ARCHIVES in", values, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesNotIn(List<String> values) {
            addCriterion("WF_ARCHIVES not in", values, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesBetween(String value1, String value2) {
            addCriterion("WF_ARCHIVES between", value1, value2, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfArchivesNotBetween(String value1, String value2) {
            addCriterion("WF_ARCHIVES not between", value1, value2, "wfArchives");
            return (Criteria) this;
        }

        public Criteria andWfRecomedIsNull() {
            addCriterion("WF_RECOMED is null");
            return (Criteria) this;
        }

        public Criteria andWfRecomedIsNotNull() {
            addCriterion("WF_RECOMED is not null");
            return (Criteria) this;
        }

        public Criteria andWfRecomedEqualTo(Byte value) {
            addCriterion("WF_RECOMED =", value, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedNotEqualTo(Byte value) {
            addCriterion("WF_RECOMED <>", value, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedGreaterThan(Byte value) {
            addCriterion("WF_RECOMED >", value, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedGreaterThanOrEqualTo(Byte value) {
            addCriterion("WF_RECOMED >=", value, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedLessThan(Byte value) {
            addCriterion("WF_RECOMED <", value, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedLessThanOrEqualTo(Byte value) {
            addCriterion("WF_RECOMED <=", value, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedIn(List<Byte> values) {
            addCriterion("WF_RECOMED in", values, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedNotIn(List<Byte> values) {
            addCriterion("WF_RECOMED not in", values, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedBetween(Byte value1, Byte value2) {
            addCriterion("WF_RECOMED between", value1, value2, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andWfRecomedNotBetween(Byte value1, Byte value2) {
            addCriterion("WF_RECOMED not between", value1, value2, "wfRecomed");
            return (Criteria) this;
        }

        public Criteria andSenderMsgIsNull() {
            addCriterion("SENDER_MSG is null");
            return (Criteria) this;
        }

        public Criteria andSenderMsgIsNotNull() {
            addCriterion("SENDER_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andSenderMsgEqualTo(String value) {
            addCriterion("SENDER_MSG =", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgNotEqualTo(String value) {
            addCriterion("SENDER_MSG <>", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgGreaterThan(String value) {
            addCriterion("SENDER_MSG >", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgGreaterThanOrEqualTo(String value) {
            addCriterion("SENDER_MSG >=", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgLessThan(String value) {
            addCriterion("SENDER_MSG <", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgLessThanOrEqualTo(String value) {
            addCriterion("SENDER_MSG <=", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgLike(String value) {
            addCriterion("SENDER_MSG like", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgNotLike(String value) {
            addCriterion("SENDER_MSG not like", value, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgIn(List<String> values) {
            addCriterion("SENDER_MSG in", values, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgNotIn(List<String> values) {
            addCriterion("SENDER_MSG not in", values, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgBetween(String value1, String value2) {
            addCriterion("SENDER_MSG between", value1, value2, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andSenderMsgNotBetween(String value1, String value2) {
            addCriterion("SENDER_MSG not between", value1, value2, "senderMsg");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeIsNull() {
            addCriterion("LAST_PUSH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeIsNotNull() {
            addCriterion("LAST_PUSH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeEqualTo(Date value) {
            addCriterion("LAST_PUSH_TIME =", value, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeNotEqualTo(Date value) {
            addCriterion("LAST_PUSH_TIME <>", value, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeGreaterThan(Date value) {
            addCriterion("LAST_PUSH_TIME >", value, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_PUSH_TIME >=", value, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeLessThan(Date value) {
            addCriterion("LAST_PUSH_TIME <", value, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_PUSH_TIME <=", value, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeIn(List<Date> values) {
            addCriterion("LAST_PUSH_TIME in", values, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeNotIn(List<Date> values) {
            addCriterion("LAST_PUSH_TIME not in", values, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_PUSH_TIME between", value1, value2, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andLastPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_PUSH_TIME not between", value1, value2, "lastPushTime");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeIsNull() {
            addCriterion("UGC_DATETYPE is null");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeIsNotNull() {
            addCriterion("UGC_DATETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeEqualTo(Byte value) {
            addCriterion("UGC_DATETYPE =", value, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeNotEqualTo(Byte value) {
            addCriterion("UGC_DATETYPE <>", value, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeGreaterThan(Byte value) {
            addCriterion("UGC_DATETYPE >", value, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("UGC_DATETYPE >=", value, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeLessThan(Byte value) {
            addCriterion("UGC_DATETYPE <", value, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeLessThanOrEqualTo(Byte value) {
            addCriterion("UGC_DATETYPE <=", value, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeIn(List<Byte> values) {
            addCriterion("UGC_DATETYPE in", values, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeNotIn(List<Byte> values) {
            addCriterion("UGC_DATETYPE not in", values, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeBetween(Byte value1, Byte value2) {
            addCriterion("UGC_DATETYPE between", value1, value2, "ugcDatetype");
            return (Criteria) this;
        }

        public Criteria andUgcDatetypeNotBetween(Byte value1, Byte value2) {
            addCriterion("UGC_DATETYPE not between", value1, value2, "ugcDatetype");
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

        public Criteria andWfCodeIsNull() {
            addCriterion("WF_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWfCodeIsNotNull() {
            addCriterion("WF_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWfCodeEqualTo(String value) {
            addCriterion("WF_CODE =", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotEqualTo(String value) {
            addCriterion("WF_CODE <>", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeGreaterThan(String value) {
            addCriterion("WF_CODE >", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WF_CODE >=", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeLessThan(String value) {
            addCriterion("WF_CODE <", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeLessThanOrEqualTo(String value) {
            addCriterion("WF_CODE <=", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeLike(String value) {
            addCriterion("WF_CODE like", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotLike(String value) {
            addCriterion("WF_CODE not like", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeIn(List<String> values) {
            addCriterion("WF_CODE in", values, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotIn(List<String> values) {
            addCriterion("WF_CODE not in", values, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeBetween(String value1, String value2) {
            addCriterion("WF_CODE between", value1, value2, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotBetween(String value1, String value2) {
            addCriterion("WF_CODE not between", value1, value2, "wfCode");
            return (Criteria) this;
        }

        public Criteria andIsHelpIsNull() {
            addCriterion("IS_HELP is null");
            return (Criteria) this;
        }

        public Criteria andIsHelpIsNotNull() {
            addCriterion("IS_HELP is not null");
            return (Criteria) this;
        }

        public Criteria andIsHelpEqualTo(Byte value) {
            addCriterion("IS_HELP =", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpNotEqualTo(Byte value) {
            addCriterion("IS_HELP <>", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpGreaterThan(Byte value) {
            addCriterion("IS_HELP >", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_HELP >=", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpLessThan(Byte value) {
            addCriterion("IS_HELP <", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpLessThanOrEqualTo(Byte value) {
            addCriterion("IS_HELP <=", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpIn(List<Byte> values) {
            addCriterion("IS_HELP in", values, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpNotIn(List<Byte> values) {
            addCriterion("IS_HELP not in", values, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpBetween(Byte value1, Byte value2) {
            addCriterion("IS_HELP between", value1, value2, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_HELP not between", value1, value2, "isHelp");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagIsNull() {
            addCriterion("PUSHMSG_LOCKFLAG is null");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagIsNotNull() {
            addCriterion("PUSHMSG_LOCKFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagEqualTo(Byte value) {
            addCriterion("PUSHMSG_LOCKFLAG =", value, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagNotEqualTo(Byte value) {
            addCriterion("PUSHMSG_LOCKFLAG <>", value, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagGreaterThan(Byte value) {
            addCriterion("PUSHMSG_LOCKFLAG >", value, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagGreaterThanOrEqualTo(Byte value) {
            addCriterion("PUSHMSG_LOCKFLAG >=", value, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagLessThan(Byte value) {
            addCriterion("PUSHMSG_LOCKFLAG <", value, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagLessThanOrEqualTo(Byte value) {
            addCriterion("PUSHMSG_LOCKFLAG <=", value, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagIn(List<Byte> values) {
            addCriterion("PUSHMSG_LOCKFLAG in", values, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagNotIn(List<Byte> values) {
            addCriterion("PUSHMSG_LOCKFLAG not in", values, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagBetween(Byte value1, Byte value2) {
            addCriterion("PUSHMSG_LOCKFLAG between", value1, value2, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andPushmsgLockflagNotBetween(Byte value1, Byte value2) {
            addCriterion("PUSHMSG_LOCKFLAG not between", value1, value2, "pushmsgLockflag");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeIsNull() {
            addCriterion("LAST_PUSHMSG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeIsNotNull() {
            addCriterion("LAST_PUSHMSG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeEqualTo(Date value) {
            addCriterion("LAST_PUSHMSG_TIME =", value, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeNotEqualTo(Date value) {
            addCriterion("LAST_PUSHMSG_TIME <>", value, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeGreaterThan(Date value) {
            addCriterion("LAST_PUSHMSG_TIME >", value, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_PUSHMSG_TIME >=", value, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeLessThan(Date value) {
            addCriterion("LAST_PUSHMSG_TIME <", value, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_PUSHMSG_TIME <=", value, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeIn(List<Date> values) {
            addCriterion("LAST_PUSHMSG_TIME in", values, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeNotIn(List<Date> values) {
            addCriterion("LAST_PUSHMSG_TIME not in", values, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_PUSHMSG_TIME between", value1, value2, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andLastPushmsgTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_PUSHMSG_TIME not between", value1, value2, "lastPushmsgTime");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("SOURCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("SOURCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(Byte value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(Byte value) {
            addCriterion("SOURCE_TYPE <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(Byte value) {
            addCriterion("SOURCE_TYPE >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SOURCE_TYPE >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(Byte value) {
            addCriterion("SOURCE_TYPE <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("SOURCE_TYPE <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<Byte> values) {
            addCriterion("SOURCE_TYPE in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<Byte> values) {
            addCriterion("SOURCE_TYPE not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(Byte value1, Byte value2) {
            addCriterion("SOURCE_TYPE between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SOURCE_TYPE not between", value1, value2, "sourceType");
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

        public Criteria andSupplementaryMoneyIsNull() {
            addCriterion("SUPPLEMENTARY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyIsNotNull() {
            addCriterion("SUPPLEMENTARY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyEqualTo(BigDecimal value) {
            addCriterion("SUPPLEMENTARY_MONEY =", value, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyNotEqualTo(BigDecimal value) {
            addCriterion("SUPPLEMENTARY_MONEY <>", value, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyGreaterThan(BigDecimal value) {
            addCriterion("SUPPLEMENTARY_MONEY >", value, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUPPLEMENTARY_MONEY >=", value, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyLessThan(BigDecimal value) {
            addCriterion("SUPPLEMENTARY_MONEY <", value, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUPPLEMENTARY_MONEY <=", value, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyIn(List<BigDecimal> values) {
            addCriterion("SUPPLEMENTARY_MONEY in", values, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyNotIn(List<BigDecimal> values) {
            addCriterion("SUPPLEMENTARY_MONEY not in", values, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUPPLEMENTARY_MONEY between", value1, value2, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andSupplementaryMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUPPLEMENTARY_MONEY not between", value1, value2, "supplementaryMoney");
            return (Criteria) this;
        }

        public Criteria andMustPayIsNull() {
            addCriterion("MUST_PAY is null");
            return (Criteria) this;
        }

        public Criteria andMustPayIsNotNull() {
            addCriterion("MUST_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andMustPayEqualTo(Byte value) {
            addCriterion("MUST_PAY =", value, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayNotEqualTo(Byte value) {
            addCriterion("MUST_PAY <>", value, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayGreaterThan(Byte value) {
            addCriterion("MUST_PAY >", value, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayGreaterThanOrEqualTo(Byte value) {
            addCriterion("MUST_PAY >=", value, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayLessThan(Byte value) {
            addCriterion("MUST_PAY <", value, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayLessThanOrEqualTo(Byte value) {
            addCriterion("MUST_PAY <=", value, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayIn(List<Byte> values) {
            addCriterion("MUST_PAY in", values, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayNotIn(List<Byte> values) {
            addCriterion("MUST_PAY not in", values, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayBetween(Byte value1, Byte value2) {
            addCriterion("MUST_PAY between", value1, value2, "mustPay");
            return (Criteria) this;
        }

        public Criteria andMustPayNotBetween(Byte value1, Byte value2) {
            addCriterion("MUST_PAY not between", value1, value2, "mustPay");
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