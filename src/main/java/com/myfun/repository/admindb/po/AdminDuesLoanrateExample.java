package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminDuesLoanrateExample {
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
    public AdminDuesLoanrateExample() {
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

        public Criteria andLoanrateIdIsNull() {
            addCriterion("LOANRATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdIsNotNull() {
            addCriterion("LOANRATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdEqualTo(Integer value) {
            addCriterion("LOANRATE_ID =", value, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdNotEqualTo(Integer value) {
            addCriterion("LOANRATE_ID <>", value, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdGreaterThan(Integer value) {
            addCriterion("LOANRATE_ID >", value, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOANRATE_ID >=", value, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdLessThan(Integer value) {
            addCriterion("LOANRATE_ID <", value, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdLessThanOrEqualTo(Integer value) {
            addCriterion("LOANRATE_ID <=", value, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdIn(List<Integer> values) {
            addCriterion("LOANRATE_ID in", values, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdNotIn(List<Integer> values) {
            addCriterion("LOANRATE_ID not in", values, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdBetween(Integer value1, Integer value2) {
            addCriterion("LOANRATE_ID between", value1, value2, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LOANRATE_ID not between", value1, value2, "loanrateId");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateIsNull() {
            addCriterion("LOANRATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateIsNotNull() {
            addCriterion("LOANRATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateEqualTo(String value) {
            addCriterion("LOANRATE_DATE =", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateNotEqualTo(String value) {
            addCriterion("LOANRATE_DATE <>", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateGreaterThan(String value) {
            addCriterion("LOANRATE_DATE >", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateGreaterThanOrEqualTo(String value) {
            addCriterion("LOANRATE_DATE >=", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateLessThan(String value) {
            addCriterion("LOANRATE_DATE <", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateLessThanOrEqualTo(String value) {
            addCriterion("LOANRATE_DATE <=", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateLike(String value) {
            addCriterion("LOANRATE_DATE like", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateNotLike(String value) {
            addCriterion("LOANRATE_DATE not like", value, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateIn(List<String> values) {
            addCriterion("LOANRATE_DATE in", values, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateNotIn(List<String> values) {
            addCriterion("LOANRATE_DATE not in", values, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateBetween(String value1, String value2) {
            addCriterion("LOANRATE_DATE between", value1, value2, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andLoanrateDateNotBetween(String value1, String value2) {
            addCriterion("LOANRATE_DATE not between", value1, value2, "loanrateDate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateIsNull() {
            addCriterion("BASE_PUBLIC_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateIsNotNull() {
            addCriterion("BASE_PUBLIC_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateEqualTo(Double value) {
            addCriterion("BASE_PUBLIC_RATE =", value, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateNotEqualTo(Double value) {
            addCriterion("BASE_PUBLIC_RATE <>", value, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateGreaterThan(Double value) {
            addCriterion("BASE_PUBLIC_RATE >", value, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateGreaterThanOrEqualTo(Double value) {
            addCriterion("BASE_PUBLIC_RATE >=", value, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateLessThan(Double value) {
            addCriterion("BASE_PUBLIC_RATE <", value, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateLessThanOrEqualTo(Double value) {
            addCriterion("BASE_PUBLIC_RATE <=", value, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateIn(List<Double> values) {
            addCriterion("BASE_PUBLIC_RATE in", values, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateNotIn(List<Double> values) {
            addCriterion("BASE_PUBLIC_RATE not in", values, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateBetween(Double value1, Double value2) {
            addCriterion("BASE_PUBLIC_RATE between", value1, value2, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBasePublicRateNotBetween(Double value1, Double value2) {
            addCriterion("BASE_PUBLIC_RATE not between", value1, value2, "basePublicRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateIsNull() {
            addCriterion("BASE_BUSI_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateIsNotNull() {
            addCriterion("BASE_BUSI_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateEqualTo(Double value) {
            addCriterion("BASE_BUSI_RATE =", value, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateNotEqualTo(Double value) {
            addCriterion("BASE_BUSI_RATE <>", value, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateGreaterThan(Double value) {
            addCriterion("BASE_BUSI_RATE >", value, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateGreaterThanOrEqualTo(Double value) {
            addCriterion("BASE_BUSI_RATE >=", value, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateLessThan(Double value) {
            addCriterion("BASE_BUSI_RATE <", value, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateLessThanOrEqualTo(Double value) {
            addCriterion("BASE_BUSI_RATE <=", value, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateIn(List<Double> values) {
            addCriterion("BASE_BUSI_RATE in", values, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateNotIn(List<Double> values) {
            addCriterion("BASE_BUSI_RATE not in", values, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateBetween(Double value1, Double value2) {
            addCriterion("BASE_BUSI_RATE between", value1, value2, "baseBusiRate");
            return (Criteria) this;
        }

        public Criteria andBaseBusiRateNotBetween(Double value1, Double value2) {
            addCriterion("BASE_BUSI_RATE not between", value1, value2, "baseBusiRate");
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

        public Criteria andSeqNoIsNull() {
            addCriterion("SEQ_NO is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("SEQ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(Integer value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(Integer value) {
            addCriterion("SEQ_NO <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(Integer value) {
            addCriterion("SEQ_NO >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQ_NO >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(Integer value) {
            addCriterion("SEQ_NO <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
            addCriterion("SEQ_NO <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<Integer> values) {
            addCriterion("SEQ_NO in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<Integer> values) {
            addCriterion("SEQ_NO not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(Integer value1, Integer value2) {
            addCriterion("SEQ_NO between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQ_NO not between", value1, value2, "seqNo");
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