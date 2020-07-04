package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminZfbHouseRegExample {
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
    public AdminZfbHouseRegExample() {
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

        public Criteria andRegIdIsNull() {
            addCriterion("REG_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegIdIsNotNull() {
            addCriterion("REG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegIdEqualTo(Integer value) {
            addCriterion("REG_ID =", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotEqualTo(Integer value) {
            addCriterion("REG_ID <>", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThan(Integer value) {
            addCriterion("REG_ID >", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REG_ID >=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThan(Integer value) {
            addCriterion("REG_ID <", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThanOrEqualTo(Integer value) {
            addCriterion("REG_ID <=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdIn(List<Integer> values) {
            addCriterion("REG_ID in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotIn(List<Integer> values) {
            addCriterion("REG_ID not in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdBetween(Integer value1, Integer value2) {
            addCriterion("REG_ID between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REG_ID not between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andRegNameIsNull() {
            addCriterion("REG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRegNameIsNotNull() {
            addCriterion("REG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRegNameEqualTo(String value) {
            addCriterion("REG_NAME =", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotEqualTo(String value) {
            addCriterion("REG_NAME <>", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameGreaterThan(String value) {
            addCriterion("REG_NAME >", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameGreaterThanOrEqualTo(String value) {
            addCriterion("REG_NAME >=", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLessThan(String value) {
            addCriterion("REG_NAME <", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLessThanOrEqualTo(String value) {
            addCriterion("REG_NAME <=", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLike(String value) {
            addCriterion("REG_NAME like", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotLike(String value) {
            addCriterion("REG_NAME not like", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameIn(List<String> values) {
            addCriterion("REG_NAME in", values, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotIn(List<String> values) {
            addCriterion("REG_NAME not in", values, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameBetween(String value1, String value2) {
            addCriterion("REG_NAME between", value1, value2, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotBetween(String value1, String value2) {
            addCriterion("REG_NAME not between", value1, value2, "regName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameIsNull() {
            addCriterion("ALI_REG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAliRegNameIsNotNull() {
            addCriterion("ALI_REG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAliRegNameEqualTo(String value) {
            addCriterion("ALI_REG_NAME =", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameNotEqualTo(String value) {
            addCriterion("ALI_REG_NAME <>", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameGreaterThan(String value) {
            addCriterion("ALI_REG_NAME >", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameGreaterThanOrEqualTo(String value) {
            addCriterion("ALI_REG_NAME >=", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameLessThan(String value) {
            addCriterion("ALI_REG_NAME <", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameLessThanOrEqualTo(String value) {
            addCriterion("ALI_REG_NAME <=", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameLike(String value) {
            addCriterion("ALI_REG_NAME like", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameNotLike(String value) {
            addCriterion("ALI_REG_NAME not like", value, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameIn(List<String> values) {
            addCriterion("ALI_REG_NAME in", values, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameNotIn(List<String> values) {
            addCriterion("ALI_REG_NAME not in", values, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameBetween(String value1, String value2) {
            addCriterion("ALI_REG_NAME between", value1, value2, "aliRegName");
            return (Criteria) this;
        }

        public Criteria andAliRegNameNotBetween(String value1, String value2) {
            addCriterion("ALI_REG_NAME not between", value1, value2, "aliRegName");
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