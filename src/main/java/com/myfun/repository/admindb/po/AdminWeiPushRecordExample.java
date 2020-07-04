package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminWeiPushRecordExample {
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
    public AdminWeiPushRecordExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("RECORD_ID =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("RECORD_ID <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("RECORD_ID >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECORD_ID >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("RECORD_ID <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("RECORD_ID <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("RECORD_ID in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("RECORD_ID not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_ID between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_ID not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("OPEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("OPEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("OPEN_ID =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("OPEN_ID <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("OPEN_ID >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_ID >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("OPEN_ID <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("OPEN_ID <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("OPEN_ID like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("OPEN_ID not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("OPEN_ID in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("OPEN_ID not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("OPEN_ID between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("OPEN_ID not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("PUSH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("PUSH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("PUSH_TIME =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("PUSH_TIME <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("PUSH_TIME >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUSH_TIME >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("PUSH_TIME <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("PUSH_TIME <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("PUSH_TIME in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("PUSH_TIME not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("PUSH_TIME between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("PUSH_TIME not between", value1, value2, "pushTime");
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

        public Criteria andPushStatusIsNull() {
            addCriterion("PUSH_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPushStatusIsNotNull() {
            addCriterion("PUSH_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPushStatusEqualTo(Byte value) {
            addCriterion("PUSH_STATUS =", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotEqualTo(Byte value) {
            addCriterion("PUSH_STATUS <>", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThan(Byte value) {
            addCriterion("PUSH_STATUS >", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("PUSH_STATUS >=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThan(Byte value) {
            addCriterion("PUSH_STATUS <", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThanOrEqualTo(Byte value) {
            addCriterion("PUSH_STATUS <=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusIn(List<Byte> values) {
            addCriterion("PUSH_STATUS in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotIn(List<Byte> values) {
            addCriterion("PUSH_STATUS not in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusBetween(Byte value1, Byte value2) {
            addCriterion("PUSH_STATUS between", value1, value2, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("PUSH_STATUS not between", value1, value2, "pushStatus");
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