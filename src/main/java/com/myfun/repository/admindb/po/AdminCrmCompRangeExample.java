package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminCrmCompRangeExample {
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
    public AdminCrmCompRangeExample() {
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

        public Criteria andRangeIdIsNull() {
            addCriterion("RANGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRangeIdIsNotNull() {
            addCriterion("RANGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRangeIdEqualTo(Integer value) {
            addCriterion("RANGE_ID =", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdNotEqualTo(Integer value) {
            addCriterion("RANGE_ID <>", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdGreaterThan(Integer value) {
            addCriterion("RANGE_ID >", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RANGE_ID >=", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdLessThan(Integer value) {
            addCriterion("RANGE_ID <", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdLessThanOrEqualTo(Integer value) {
            addCriterion("RANGE_ID <=", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdIn(List<Integer> values) {
            addCriterion("RANGE_ID in", values, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdNotIn(List<Integer> values) {
            addCriterion("RANGE_ID not in", values, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdBetween(Integer value1, Integer value2) {
            addCriterion("RANGE_ID between", value1, value2, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RANGE_ID not between", value1, value2, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIsNull() {
            addCriterion("RANGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIsNotNull() {
            addCriterion("RANGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRangeTypeEqualTo(Byte value) {
            addCriterion("RANGE_TYPE =", value, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNotEqualTo(Byte value) {
            addCriterion("RANGE_TYPE <>", value, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeGreaterThan(Byte value) {
            addCriterion("RANGE_TYPE >", value, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("RANGE_TYPE >=", value, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeLessThan(Byte value) {
            addCriterion("RANGE_TYPE <", value, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("RANGE_TYPE <=", value, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIn(List<Byte> values) {
            addCriterion("RANGE_TYPE in", values, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNotIn(List<Byte> values) {
            addCriterion("RANGE_TYPE not in", values, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeBetween(Byte value1, Byte value2) {
            addCriterion("RANGE_TYPE between", value1, value2, "rangeType");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("RANGE_TYPE not between", value1, value2, "rangeType");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagIsNull() {
            addCriterion("WRITEOFF_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagIsNotNull() {
            addCriterion("WRITEOFF_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG =", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagNotEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG <>", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagGreaterThan(Boolean value) {
            addCriterion("WRITEOFF_FLAG >", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG >=", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagLessThan(Boolean value) {
            addCriterion("WRITEOFF_FLAG <", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG <=", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagIn(List<Boolean> values) {
            addCriterion("WRITEOFF_FLAG in", values, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagNotIn(List<Boolean> values) {
            addCriterion("WRITEOFF_FLAG not in", values, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("WRITEOFF_FLAG between", value1, value2, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("WRITEOFF_FLAG not between", value1, value2, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(Byte value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(Byte value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(Byte value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(Byte value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(Byte value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<Byte> values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<Byte> values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(Byte value1, Byte value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeIsNull() {
            addCriterion("PROXY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProxyTypeIsNotNull() {
            addCriterion("PROXY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProxyTypeEqualTo(Byte value) {
            addCriterion("PROXY_TYPE =", value, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeNotEqualTo(Byte value) {
            addCriterion("PROXY_TYPE <>", value, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeGreaterThan(Byte value) {
            addCriterion("PROXY_TYPE >", value, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("PROXY_TYPE >=", value, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeLessThan(Byte value) {
            addCriterion("PROXY_TYPE <", value, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeLessThanOrEqualTo(Byte value) {
            addCriterion("PROXY_TYPE <=", value, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeIn(List<Byte> values) {
            addCriterion("PROXY_TYPE in", values, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeNotIn(List<Byte> values) {
            addCriterion("PROXY_TYPE not in", values, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeBetween(Byte value1, Byte value2) {
            addCriterion("PROXY_TYPE between", value1, value2, "proxyType");
            return (Criteria) this;
        }

        public Criteria andProxyTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("PROXY_TYPE not between", value1, value2, "proxyType");
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