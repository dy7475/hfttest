package com.myfun.repository.agencydb.po;

import java.util.ArrayList;
import java.util.List;

public class AgencyVipErpRelationExample {
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
    public AgencyVipErpRelationExample() {
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

        public Criteria andWfIdIsNull() {
            addCriterion("WF_ID is null");
            return (Criteria) this;
        }

        public Criteria andWfIdIsNotNull() {
            addCriterion("WF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWfIdEqualTo(Integer value) {
            addCriterion("WF_ID =", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdNotEqualTo(Integer value) {
            addCriterion("WF_ID <>", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdGreaterThan(Integer value) {
            addCriterion("WF_ID >", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WF_ID >=", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdLessThan(Integer value) {
            addCriterion("WF_ID <", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdLessThanOrEqualTo(Integer value) {
            addCriterion("WF_ID <=", value, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdIn(List<Integer> values) {
            addCriterion("WF_ID in", values, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdNotIn(List<Integer> values) {
            addCriterion("WF_ID not in", values, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdBetween(Integer value1, Integer value2) {
            addCriterion("WF_ID between", value1, value2, "wfId");
            return (Criteria) this;
        }

        public Criteria andWfIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WF_ID not between", value1, value2, "wfId");
            return (Criteria) this;
        }

        public Criteria andVipIdIsNull() {
            addCriterion("VIP_ID is null");
            return (Criteria) this;
        }

        public Criteria andVipIdIsNotNull() {
            addCriterion("VIP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVipIdEqualTo(Integer value) {
            addCriterion("VIP_ID =", value, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdNotEqualTo(Integer value) {
            addCriterion("VIP_ID <>", value, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdGreaterThan(Integer value) {
            addCriterion("VIP_ID >", value, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIP_ID >=", value, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdLessThan(Integer value) {
            addCriterion("VIP_ID <", value, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdLessThanOrEqualTo(Integer value) {
            addCriterion("VIP_ID <=", value, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdIn(List<Integer> values) {
            addCriterion("VIP_ID in", values, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdNotIn(List<Integer> values) {
            addCriterion("VIP_ID not in", values, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdBetween(Integer value1, Integer value2) {
            addCriterion("VIP_ID between", value1, value2, "vipId");
            return (Criteria) this;
        }

        public Criteria andVipIdNotBetween(Integer value1, Integer value2) {
            addCriterion("VIP_ID not between", value1, value2, "vipId");
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

        public Criteria andCaseIdIsNull() {
            addCriterion("CASE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("CASE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Integer value) {
            addCriterion("CASE_ID =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Integer value) {
            addCriterion("CASE_ID <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Integer value) {
            addCriterion("CASE_ID >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASE_ID >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Integer value) {
            addCriterion("CASE_ID <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("CASE_ID <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Integer> values) {
            addCriterion("CASE_ID in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Integer> values) {
            addCriterion("CASE_ID not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Integer value1, Integer value2) {
            addCriterion("CASE_ID between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CASE_ID not between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNull() {
            addCriterion("CASE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("CASE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(Byte value) {
            addCriterion("CASE_TYPE =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(Byte value) {
            addCriterion("CASE_TYPE <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(Byte value) {
            addCriterion("CASE_TYPE >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("CASE_TYPE >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(Byte value) {
            addCriterion("CASE_TYPE <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("CASE_TYPE <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<Byte> values) {
            addCriterion("CASE_TYPE in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<Byte> values) {
            addCriterion("CASE_TYPE not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(Byte value1, Byte value2) {
            addCriterion("CASE_TYPE between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("CASE_TYPE not between", value1, value2, "caseType");
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

        public Criteria andUpdateSyncFlagIsNull() {
            addCriterion("UPDATE_SYNC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagIsNotNull() {
            addCriterion("UPDATE_SYNC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagEqualTo(Byte value) {
            addCriterion("UPDATE_SYNC_FLAG =", value, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagNotEqualTo(Byte value) {
            addCriterion("UPDATE_SYNC_FLAG <>", value, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagGreaterThan(Byte value) {
            addCriterion("UPDATE_SYNC_FLAG >", value, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("UPDATE_SYNC_FLAG >=", value, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagLessThan(Byte value) {
            addCriterion("UPDATE_SYNC_FLAG <", value, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagLessThanOrEqualTo(Byte value) {
            addCriterion("UPDATE_SYNC_FLAG <=", value, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagIn(List<Byte> values) {
            addCriterion("UPDATE_SYNC_FLAG in", values, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagNotIn(List<Byte> values) {
            addCriterion("UPDATE_SYNC_FLAG not in", values, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagBetween(Byte value1, Byte value2) {
            addCriterion("UPDATE_SYNC_FLAG between", value1, value2, "updateSyncFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateSyncFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("UPDATE_SYNC_FLAG not between", value1, value2, "updateSyncFlag");
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