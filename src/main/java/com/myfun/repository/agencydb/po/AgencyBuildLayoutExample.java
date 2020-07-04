package com.myfun.repository.agencydb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AgencyBuildLayoutExample {
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
    public AgencyBuildLayoutExample() {
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

        public Criteria andLayoutIdIsNull() {
            addCriterion("LAYOUT_ID is null");
            return (Criteria) this;
        }

        public Criteria andLayoutIdIsNotNull() {
            addCriterion("LAYOUT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutIdEqualTo(Integer value) {
            addCriterion("LAYOUT_ID =", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdNotEqualTo(Integer value) {
            addCriterion("LAYOUT_ID <>", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdGreaterThan(Integer value) {
            addCriterion("LAYOUT_ID >", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LAYOUT_ID >=", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdLessThan(Integer value) {
            addCriterion("LAYOUT_ID <", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdLessThanOrEqualTo(Integer value) {
            addCriterion("LAYOUT_ID <=", value, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdIn(List<Integer> values) {
            addCriterion("LAYOUT_ID in", values, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdNotIn(List<Integer> values) {
            addCriterion("LAYOUT_ID not in", values, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdBetween(Integer value1, Integer value2) {
            addCriterion("LAYOUT_ID between", value1, value2, "layoutId");
            return (Criteria) this;
        }

        public Criteria andLayoutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LAYOUT_ID not between", value1, value2, "layoutId");
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

        public Criteria andLayoutNoIsNull() {
            addCriterion("LAYOUT_NO is null");
            return (Criteria) this;
        }

        public Criteria andLayoutNoIsNotNull() {
            addCriterion("LAYOUT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutNoEqualTo(String value) {
            addCriterion("LAYOUT_NO =", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoNotEqualTo(String value) {
            addCriterion("LAYOUT_NO <>", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoGreaterThan(String value) {
            addCriterion("LAYOUT_NO >", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoGreaterThanOrEqualTo(String value) {
            addCriterion("LAYOUT_NO >=", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoLessThan(String value) {
            addCriterion("LAYOUT_NO <", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoLessThanOrEqualTo(String value) {
            addCriterion("LAYOUT_NO <=", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoLike(String value) {
            addCriterion("LAYOUT_NO like", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoNotLike(String value) {
            addCriterion("LAYOUT_NO not like", value, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoIn(List<String> values) {
            addCriterion("LAYOUT_NO in", values, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoNotIn(List<String> values) {
            addCriterion("LAYOUT_NO not in", values, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoBetween(String value1, String value2) {
            addCriterion("LAYOUT_NO between", value1, value2, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNoNotBetween(String value1, String value2) {
            addCriterion("LAYOUT_NO not between", value1, value2, "layoutNo");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIsNull() {
            addCriterion("LAYOUT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIsNotNull() {
            addCriterion("LAYOUT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutNameEqualTo(String value) {
            addCriterion("LAYOUT_NAME =", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotEqualTo(String value) {
            addCriterion("LAYOUT_NAME <>", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameGreaterThan(String value) {
            addCriterion("LAYOUT_NAME >", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameGreaterThanOrEqualTo(String value) {
            addCriterion("LAYOUT_NAME >=", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLessThan(String value) {
            addCriterion("LAYOUT_NAME <", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLessThanOrEqualTo(String value) {
            addCriterion("LAYOUT_NAME <=", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameLike(String value) {
            addCriterion("LAYOUT_NAME like", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotLike(String value) {
            addCriterion("LAYOUT_NAME not like", value, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameIn(List<String> values) {
            addCriterion("LAYOUT_NAME in", values, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotIn(List<String> values) {
            addCriterion("LAYOUT_NAME not in", values, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameBetween(String value1, String value2) {
            addCriterion("LAYOUT_NAME between", value1, value2, "layoutName");
            return (Criteria) this;
        }

        public Criteria andLayoutNameNotBetween(String value1, String value2) {
            addCriterion("LAYOUT_NAME not between", value1, value2, "layoutName");
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

        public Criteria andSeqNoEqualTo(Short value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(Short value) {
            addCriterion("SEQ_NO <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(Short value) {
            addCriterion("SEQ_NO >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(Short value) {
            addCriterion("SEQ_NO >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(Short value) {
            addCriterion("SEQ_NO <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(Short value) {
            addCriterion("SEQ_NO <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<Short> values) {
            addCriterion("SEQ_NO in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<Short> values) {
            addCriterion("SEQ_NO not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(Short value1, Short value2) {
            addCriterion("SEQ_NO between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(Short value1, Short value2) {
            addCriterion("SEQ_NO not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andRoomsIsNull() {
            addCriterion("ROOMS is null");
            return (Criteria) this;
        }

        public Criteria andRoomsIsNotNull() {
            addCriterion("ROOMS is not null");
            return (Criteria) this;
        }

        public Criteria andRoomsEqualTo(Byte value) {
            addCriterion("ROOMS =", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotEqualTo(Byte value) {
            addCriterion("ROOMS <>", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsGreaterThan(Byte value) {
            addCriterion("ROOMS >", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsGreaterThanOrEqualTo(Byte value) {
            addCriterion("ROOMS >=", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsLessThan(Byte value) {
            addCriterion("ROOMS <", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsLessThanOrEqualTo(Byte value) {
            addCriterion("ROOMS <=", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsIn(List<Byte> values) {
            addCriterion("ROOMS in", values, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotIn(List<Byte> values) {
            addCriterion("ROOMS not in", values, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsBetween(Byte value1, Byte value2) {
            addCriterion("ROOMS between", value1, value2, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotBetween(Byte value1, Byte value2) {
            addCriterion("ROOMS not between", value1, value2, "rooms");
            return (Criteria) this;
        }

        public Criteria andHallsIsNull() {
            addCriterion("HALLS is null");
            return (Criteria) this;
        }

        public Criteria andHallsIsNotNull() {
            addCriterion("HALLS is not null");
            return (Criteria) this;
        }

        public Criteria andHallsEqualTo(Byte value) {
            addCriterion("HALLS =", value, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsNotEqualTo(Byte value) {
            addCriterion("HALLS <>", value, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsGreaterThan(Byte value) {
            addCriterion("HALLS >", value, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsGreaterThanOrEqualTo(Byte value) {
            addCriterion("HALLS >=", value, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsLessThan(Byte value) {
            addCriterion("HALLS <", value, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsLessThanOrEqualTo(Byte value) {
            addCriterion("HALLS <=", value, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsIn(List<Byte> values) {
            addCriterion("HALLS in", values, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsNotIn(List<Byte> values) {
            addCriterion("HALLS not in", values, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsBetween(Byte value1, Byte value2) {
            addCriterion("HALLS between", value1, value2, "halls");
            return (Criteria) this;
        }

        public Criteria andHallsNotBetween(Byte value1, Byte value2) {
            addCriterion("HALLS not between", value1, value2, "halls");
            return (Criteria) this;
        }

        public Criteria andWeisIsNull() {
            addCriterion("WEIS is null");
            return (Criteria) this;
        }

        public Criteria andWeisIsNotNull() {
            addCriterion("WEIS is not null");
            return (Criteria) this;
        }

        public Criteria andWeisEqualTo(Byte value) {
            addCriterion("WEIS =", value, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisNotEqualTo(Byte value) {
            addCriterion("WEIS <>", value, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisGreaterThan(Byte value) {
            addCriterion("WEIS >", value, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisGreaterThanOrEqualTo(Byte value) {
            addCriterion("WEIS >=", value, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisLessThan(Byte value) {
            addCriterion("WEIS <", value, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisLessThanOrEqualTo(Byte value) {
            addCriterion("WEIS <=", value, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisIn(List<Byte> values) {
            addCriterion("WEIS in", values, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisNotIn(List<Byte> values) {
            addCriterion("WEIS not in", values, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisBetween(Byte value1, Byte value2) {
            addCriterion("WEIS between", value1, value2, "weis");
            return (Criteria) this;
        }

        public Criteria andWeisNotBetween(Byte value1, Byte value2) {
            addCriterion("WEIS not between", value1, value2, "weis");
            return (Criteria) this;
        }

        public Criteria andYangsIsNull() {
            addCriterion("YANGS is null");
            return (Criteria) this;
        }

        public Criteria andYangsIsNotNull() {
            addCriterion("YANGS is not null");
            return (Criteria) this;
        }

        public Criteria andYangsEqualTo(Byte value) {
            addCriterion("YANGS =", value, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsNotEqualTo(Byte value) {
            addCriterion("YANGS <>", value, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsGreaterThan(Byte value) {
            addCriterion("YANGS >", value, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsGreaterThanOrEqualTo(Byte value) {
            addCriterion("YANGS >=", value, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsLessThan(Byte value) {
            addCriterion("YANGS <", value, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsLessThanOrEqualTo(Byte value) {
            addCriterion("YANGS <=", value, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsIn(List<Byte> values) {
            addCriterion("YANGS in", values, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsNotIn(List<Byte> values) {
            addCriterion("YANGS not in", values, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsBetween(Byte value1, Byte value2) {
            addCriterion("YANGS between", value1, value2, "yangs");
            return (Criteria) this;
        }

        public Criteria andYangsNotBetween(Byte value1, Byte value2) {
            addCriterion("YANGS not between", value1, value2, "yangs");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNull() {
            addCriterion("BUILD_AREA is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("BUILD_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(BigDecimal value) {
            addCriterion("BUILD_AREA =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(BigDecimal value) {
            addCriterion("BUILD_AREA <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(BigDecimal value) {
            addCriterion("BUILD_AREA >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILD_AREA >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(BigDecimal value) {
            addCriterion("BUILD_AREA <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILD_AREA <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<BigDecimal> values) {
            addCriterion("BUILD_AREA in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<BigDecimal> values) {
            addCriterion("BUILD_AREA not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILD_AREA between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILD_AREA not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaIsNull() {
            addCriterion("INSIDE_AREA is null");
            return (Criteria) this;
        }

        public Criteria andInsideAreaIsNotNull() {
            addCriterion("INSIDE_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andInsideAreaEqualTo(BigDecimal value) {
            addCriterion("INSIDE_AREA =", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaNotEqualTo(BigDecimal value) {
            addCriterion("INSIDE_AREA <>", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaGreaterThan(BigDecimal value) {
            addCriterion("INSIDE_AREA >", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INSIDE_AREA >=", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaLessThan(BigDecimal value) {
            addCriterion("INSIDE_AREA <", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INSIDE_AREA <=", value, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaIn(List<BigDecimal> values) {
            addCriterion("INSIDE_AREA in", values, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaNotIn(List<BigDecimal> values) {
            addCriterion("INSIDE_AREA not in", values, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSIDE_AREA between", value1, value2, "insideArea");
            return (Criteria) this;
        }

        public Criteria andInsideAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INSIDE_AREA not between", value1, value2, "insideArea");
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

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeIsNull() {
            addCriterion("LAYOUT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeIsNotNull() {
            addCriterion("LAYOUT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeEqualTo(String value) {
            addCriterion("LAYOUT_TYPE =", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeNotEqualTo(String value) {
            addCriterion("LAYOUT_TYPE <>", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeGreaterThan(String value) {
            addCriterion("LAYOUT_TYPE >", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LAYOUT_TYPE >=", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeLessThan(String value) {
            addCriterion("LAYOUT_TYPE <", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeLessThanOrEqualTo(String value) {
            addCriterion("LAYOUT_TYPE <=", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeLike(String value) {
            addCriterion("LAYOUT_TYPE like", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeNotLike(String value) {
            addCriterion("LAYOUT_TYPE not like", value, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeIn(List<String> values) {
            addCriterion("LAYOUT_TYPE in", values, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeNotIn(List<String> values) {
            addCriterion("LAYOUT_TYPE not in", values, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeBetween(String value1, String value2) {
            addCriterion("LAYOUT_TYPE between", value1, value2, "layoutType");
            return (Criteria) this;
        }

        public Criteria andLayoutTypeNotBetween(String value1, String value2) {
            addCriterion("LAYOUT_TYPE not between", value1, value2, "layoutType");
            return (Criteria) this;
        }

        public Criteria andHousesIsNull() {
            addCriterion("HOUSES is null");
            return (Criteria) this;
        }

        public Criteria andHousesIsNotNull() {
            addCriterion("HOUSES is not null");
            return (Criteria) this;
        }

        public Criteria andHousesEqualTo(Integer value) {
            addCriterion("HOUSES =", value, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesNotEqualTo(Integer value) {
            addCriterion("HOUSES <>", value, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesGreaterThan(Integer value) {
            addCriterion("HOUSES >", value, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesGreaterThanOrEqualTo(Integer value) {
            addCriterion("HOUSES >=", value, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesLessThan(Integer value) {
            addCriterion("HOUSES <", value, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesLessThanOrEqualTo(Integer value) {
            addCriterion("HOUSES <=", value, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesIn(List<Integer> values) {
            addCriterion("HOUSES in", values, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesNotIn(List<Integer> values) {
            addCriterion("HOUSES not in", values, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesBetween(Integer value1, Integer value2) {
            addCriterion("HOUSES between", value1, value2, "houses");
            return (Criteria) this;
        }

        public Criteria andHousesNotBetween(Integer value1, Integer value2) {
            addCriterion("HOUSES not between", value1, value2, "houses");
            return (Criteria) this;
        }

        public Criteria andIsmainIsNull() {
            addCriterion("ISMAIN is null");
            return (Criteria) this;
        }

        public Criteria andIsmainIsNotNull() {
            addCriterion("ISMAIN is not null");
            return (Criteria) this;
        }

        public Criteria andIsmainEqualTo(Short value) {
            addCriterion("ISMAIN =", value, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainNotEqualTo(Short value) {
            addCriterion("ISMAIN <>", value, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainGreaterThan(Short value) {
            addCriterion("ISMAIN >", value, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainGreaterThanOrEqualTo(Short value) {
            addCriterion("ISMAIN >=", value, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainLessThan(Short value) {
            addCriterion("ISMAIN <", value, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainLessThanOrEqualTo(Short value) {
            addCriterion("ISMAIN <=", value, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainIn(List<Short> values) {
            addCriterion("ISMAIN in", values, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainNotIn(List<Short> values) {
            addCriterion("ISMAIN not in", values, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainBetween(Short value1, Short value2) {
            addCriterion("ISMAIN between", value1, value2, "ismain");
            return (Criteria) this;
        }

        public Criteria andIsmainNotBetween(Short value1, Short value2) {
            addCriterion("ISMAIN not between", value1, value2, "ismain");
            return (Criteria) this;
        }

        public Criteria andCharactIsNull() {
            addCriterion("CHARACT is null");
            return (Criteria) this;
        }

        public Criteria andCharactIsNotNull() {
            addCriterion("CHARACT is not null");
            return (Criteria) this;
        }

        public Criteria andCharactEqualTo(String value) {
            addCriterion("CHARACT =", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotEqualTo(String value) {
            addCriterion("CHARACT <>", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThan(String value) {
            addCriterion("CHARACT >", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThanOrEqualTo(String value) {
            addCriterion("CHARACT >=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThan(String value) {
            addCriterion("CHARACT <", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThanOrEqualTo(String value) {
            addCriterion("CHARACT <=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLike(String value) {
            addCriterion("CHARACT like", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotLike(String value) {
            addCriterion("CHARACT not like", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactIn(List<String> values) {
            addCriterion("CHARACT in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotIn(List<String> values) {
            addCriterion("CHARACT not in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactBetween(String value1, String value2) {
            addCriterion("CHARACT between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotBetween(String value1, String value2) {
            addCriterion("CHARACT not between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1IsNull() {
            addCriterion("LAYOUT_PIC1 is null");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1IsNotNull() {
            addCriterion("LAYOUT_PIC1 is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1EqualTo(String value) {
            addCriterion("LAYOUT_PIC1 =", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1NotEqualTo(String value) {
            addCriterion("LAYOUT_PIC1 <>", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1GreaterThan(String value) {
            addCriterion("LAYOUT_PIC1 >", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1GreaterThanOrEqualTo(String value) {
            addCriterion("LAYOUT_PIC1 >=", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1LessThan(String value) {
            addCriterion("LAYOUT_PIC1 <", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1LessThanOrEqualTo(String value) {
            addCriterion("LAYOUT_PIC1 <=", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1Like(String value) {
            addCriterion("LAYOUT_PIC1 like", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1NotLike(String value) {
            addCriterion("LAYOUT_PIC1 not like", value, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1In(List<String> values) {
            addCriterion("LAYOUT_PIC1 in", values, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1NotIn(List<String> values) {
            addCriterion("LAYOUT_PIC1 not in", values, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1Between(String value1, String value2) {
            addCriterion("LAYOUT_PIC1 between", value1, value2, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic1NotBetween(String value1, String value2) {
            addCriterion("LAYOUT_PIC1 not between", value1, value2, "layoutPic1");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2IsNull() {
            addCriterion("LAYOUT_PIC2 is null");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2IsNotNull() {
            addCriterion("LAYOUT_PIC2 is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2EqualTo(String value) {
            addCriterion("LAYOUT_PIC2 =", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2NotEqualTo(String value) {
            addCriterion("LAYOUT_PIC2 <>", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2GreaterThan(String value) {
            addCriterion("LAYOUT_PIC2 >", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2GreaterThanOrEqualTo(String value) {
            addCriterion("LAYOUT_PIC2 >=", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2LessThan(String value) {
            addCriterion("LAYOUT_PIC2 <", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2LessThanOrEqualTo(String value) {
            addCriterion("LAYOUT_PIC2 <=", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2Like(String value) {
            addCriterion("LAYOUT_PIC2 like", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2NotLike(String value) {
            addCriterion("LAYOUT_PIC2 not like", value, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2In(List<String> values) {
            addCriterion("LAYOUT_PIC2 in", values, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2NotIn(List<String> values) {
            addCriterion("LAYOUT_PIC2 not in", values, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2Between(String value1, String value2) {
            addCriterion("LAYOUT_PIC2 between", value1, value2, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andLayoutPic2NotBetween(String value1, String value2) {
            addCriterion("LAYOUT_PIC2 not between", value1, value2, "layoutPic2");
            return (Criteria) this;
        }

        public Criteria andEditFlagIsNull() {
            addCriterion("EDIT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEditFlagIsNotNull() {
            addCriterion("EDIT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEditFlagEqualTo(Byte value) {
            addCriterion("EDIT_FLAG =", value, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagNotEqualTo(Byte value) {
            addCriterion("EDIT_FLAG <>", value, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagGreaterThan(Byte value) {
            addCriterion("EDIT_FLAG >", value, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("EDIT_FLAG >=", value, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagLessThan(Byte value) {
            addCriterion("EDIT_FLAG <", value, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagLessThanOrEqualTo(Byte value) {
            addCriterion("EDIT_FLAG <=", value, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagIn(List<Byte> values) {
            addCriterion("EDIT_FLAG in", values, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagNotIn(List<Byte> values) {
            addCriterion("EDIT_FLAG not in", values, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagBetween(Byte value1, Byte value2) {
            addCriterion("EDIT_FLAG between", value1, value2, "editFlag");
            return (Criteria) this;
        }

        public Criteria andEditFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("EDIT_FLAG not between", value1, value2, "editFlag");
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

        public Criteria andHouseUseageEqualTo(Byte value) {
            addCriterion("HOUSE_USEAGE =", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotEqualTo(Byte value) {
            addCriterion("HOUSE_USEAGE <>", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThan(Byte value) {
            addCriterion("HOUSE_USEAGE >", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThanOrEqualTo(Byte value) {
            addCriterion("HOUSE_USEAGE >=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThan(Byte value) {
            addCriterion("HOUSE_USEAGE <", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThanOrEqualTo(Byte value) {
            addCriterion("HOUSE_USEAGE <=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIn(List<Byte> values) {
            addCriterion("HOUSE_USEAGE in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotIn(List<Byte> values) {
            addCriterion("HOUSE_USEAGE not in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageBetween(Byte value1, Byte value2) {
            addCriterion("HOUSE_USEAGE between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotBetween(Byte value1, Byte value2) {
            addCriterion("HOUSE_USEAGE not between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusIsNull() {
            addCriterion("LAYOUT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusIsNotNull() {
            addCriterion("LAYOUT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusEqualTo(Byte value) {
            addCriterion("LAYOUT_STATUS =", value, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusNotEqualTo(Byte value) {
            addCriterion("LAYOUT_STATUS <>", value, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusGreaterThan(Byte value) {
            addCriterion("LAYOUT_STATUS >", value, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("LAYOUT_STATUS >=", value, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusLessThan(Byte value) {
            addCriterion("LAYOUT_STATUS <", value, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusLessThanOrEqualTo(Byte value) {
            addCriterion("LAYOUT_STATUS <=", value, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusIn(List<Byte> values) {
            addCriterion("LAYOUT_STATUS in", values, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusNotIn(List<Byte> values) {
            addCriterion("LAYOUT_STATUS not in", values, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusBetween(Byte value1, Byte value2) {
            addCriterion("LAYOUT_STATUS between", value1, value2, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("LAYOUT_STATUS not between", value1, value2, "layoutStatus");
            return (Criteria) this;
        }

        public Criteria andLayoutTagIsNull() {
            addCriterion("LAYOUT_TAG is null");
            return (Criteria) this;
        }

        public Criteria andLayoutTagIsNotNull() {
            addCriterion("LAYOUT_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutTagEqualTo(String value) {
            addCriterion("LAYOUT_TAG =", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagNotEqualTo(String value) {
            addCriterion("LAYOUT_TAG <>", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagGreaterThan(String value) {
            addCriterion("LAYOUT_TAG >", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagGreaterThanOrEqualTo(String value) {
            addCriterion("LAYOUT_TAG >=", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagLessThan(String value) {
            addCriterion("LAYOUT_TAG <", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagLessThanOrEqualTo(String value) {
            addCriterion("LAYOUT_TAG <=", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagLike(String value) {
            addCriterion("LAYOUT_TAG like", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagNotLike(String value) {
            addCriterion("LAYOUT_TAG not like", value, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagIn(List<String> values) {
            addCriterion("LAYOUT_TAG in", values, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagNotIn(List<String> values) {
            addCriterion("LAYOUT_TAG not in", values, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagBetween(String value1, String value2) {
            addCriterion("LAYOUT_TAG between", value1, value2, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andLayoutTagNotBetween(String value1, String value2) {
            addCriterion("LAYOUT_TAG not between", value1, value2, "layoutTag");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaIsNull() {
            addCriterion("HAS_PANORAMA is null");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaIsNotNull() {
            addCriterion("HAS_PANORAMA is not null");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaEqualTo(Byte value) {
            addCriterion("HAS_PANORAMA =", value, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaNotEqualTo(Byte value) {
            addCriterion("HAS_PANORAMA <>", value, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaGreaterThan(Byte value) {
            addCriterion("HAS_PANORAMA >", value, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaGreaterThanOrEqualTo(Byte value) {
            addCriterion("HAS_PANORAMA >=", value, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaLessThan(Byte value) {
            addCriterion("HAS_PANORAMA <", value, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaLessThanOrEqualTo(Byte value) {
            addCriterion("HAS_PANORAMA <=", value, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaIn(List<Byte> values) {
            addCriterion("HAS_PANORAMA in", values, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaNotIn(List<Byte> values) {
            addCriterion("HAS_PANORAMA not in", values, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaBetween(Byte value1, Byte value2) {
            addCriterion("HAS_PANORAMA between", value1, value2, "hasPanorama");
            return (Criteria) this;
        }

        public Criteria andHasPanoramaNotBetween(Byte value1, Byte value2) {
            addCriterion("HAS_PANORAMA not between", value1, value2, "hasPanorama");
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