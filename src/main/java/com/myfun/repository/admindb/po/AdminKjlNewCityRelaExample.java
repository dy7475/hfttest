package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminKjlNewCityRelaExample {
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
    public AdminKjlNewCityRelaExample() {
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

        public Criteria andMyCityIdIsNull() {
            addCriterion("MY_CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andMyCityIdIsNotNull() {
            addCriterion("MY_CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMyCityIdEqualTo(Integer value) {
            addCriterion("MY_CITY_ID =", value, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdNotEqualTo(Integer value) {
            addCriterion("MY_CITY_ID <>", value, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdGreaterThan(Integer value) {
            addCriterion("MY_CITY_ID >", value, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MY_CITY_ID >=", value, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdLessThan(Integer value) {
            addCriterion("MY_CITY_ID <", value, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("MY_CITY_ID <=", value, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdIn(List<Integer> values) {
            addCriterion("MY_CITY_ID in", values, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdNotIn(List<Integer> values) {
            addCriterion("MY_CITY_ID not in", values, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdBetween(Integer value1, Integer value2) {
            addCriterion("MY_CITY_ID between", value1, value2, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MY_CITY_ID not between", value1, value2, "myCityId");
            return (Criteria) this;
        }

        public Criteria andMyCityNameIsNull() {
            addCriterion("MY_CITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMyCityNameIsNotNull() {
            addCriterion("MY_CITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMyCityNameEqualTo(String value) {
            addCriterion("MY_CITY_NAME =", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameNotEqualTo(String value) {
            addCriterion("MY_CITY_NAME <>", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameGreaterThan(String value) {
            addCriterion("MY_CITY_NAME >", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("MY_CITY_NAME >=", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameLessThan(String value) {
            addCriterion("MY_CITY_NAME <", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameLessThanOrEqualTo(String value) {
            addCriterion("MY_CITY_NAME <=", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameLike(String value) {
            addCriterion("MY_CITY_NAME like", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameNotLike(String value) {
            addCriterion("MY_CITY_NAME not like", value, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameIn(List<String> values) {
            addCriterion("MY_CITY_NAME in", values, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameNotIn(List<String> values) {
            addCriterion("MY_CITY_NAME not in", values, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameBetween(String value1, String value2) {
            addCriterion("MY_CITY_NAME between", value1, value2, "myCityName");
            return (Criteria) this;
        }

        public Criteria andMyCityNameNotBetween(String value1, String value2) {
            addCriterion("MY_CITY_NAME not between", value1, value2, "myCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdIsNull() {
            addCriterion("KJL_CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdIsNotNull() {
            addCriterion("KJL_CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdEqualTo(Integer value) {
            addCriterion("KJL_CITY_ID =", value, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdNotEqualTo(Integer value) {
            addCriterion("KJL_CITY_ID <>", value, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdGreaterThan(Integer value) {
            addCriterion("KJL_CITY_ID >", value, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("KJL_CITY_ID >=", value, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdLessThan(Integer value) {
            addCriterion("KJL_CITY_ID <", value, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("KJL_CITY_ID <=", value, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdIn(List<Integer> values) {
            addCriterion("KJL_CITY_ID in", values, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdNotIn(List<Integer> values) {
            addCriterion("KJL_CITY_ID not in", values, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdBetween(Integer value1, Integer value2) {
            addCriterion("KJL_CITY_ID between", value1, value2, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("KJL_CITY_ID not between", value1, value2, "kjlCityId");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameIsNull() {
            addCriterion("KJL_CITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameIsNotNull() {
            addCriterion("KJL_CITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameEqualTo(String value) {
            addCriterion("KJL_CITY_NAME =", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameNotEqualTo(String value) {
            addCriterion("KJL_CITY_NAME <>", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameGreaterThan(String value) {
            addCriterion("KJL_CITY_NAME >", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("KJL_CITY_NAME >=", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameLessThan(String value) {
            addCriterion("KJL_CITY_NAME <", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameLessThanOrEqualTo(String value) {
            addCriterion("KJL_CITY_NAME <=", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameLike(String value) {
            addCriterion("KJL_CITY_NAME like", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameNotLike(String value) {
            addCriterion("KJL_CITY_NAME not like", value, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameIn(List<String> values) {
            addCriterion("KJL_CITY_NAME in", values, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameNotIn(List<String> values) {
            addCriterion("KJL_CITY_NAME not in", values, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameBetween(String value1, String value2) {
            addCriterion("KJL_CITY_NAME between", value1, value2, "kjlCityName");
            return (Criteria) this;
        }

        public Criteria andKjlCityNameNotBetween(String value1, String value2) {
            addCriterion("KJL_CITY_NAME not between", value1, value2, "kjlCityName");
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