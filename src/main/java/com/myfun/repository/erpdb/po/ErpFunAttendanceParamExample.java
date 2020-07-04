package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceParamExample extends ShardDb {
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
    public ErpFunAttendanceParamExample() {
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

        public Criteria andRuleValueIsNull() {
            addCriterion("RULE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andRuleValueIsNotNull() {
            addCriterion("RULE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andRuleValueEqualTo(String value) {
            addCriterion("RULE_VALUE =", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotEqualTo(String value) {
            addCriterion("RULE_VALUE <>", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueGreaterThan(String value) {
            addCriterion("RULE_VALUE >", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueGreaterThanOrEqualTo(String value) {
            addCriterion("RULE_VALUE >=", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueLessThan(String value) {
            addCriterion("RULE_VALUE <", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueLessThanOrEqualTo(String value) {
            addCriterion("RULE_VALUE <=", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueLike(String value) {
            addCriterion("RULE_VALUE like", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotLike(String value) {
            addCriterion("RULE_VALUE not like", value, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueIn(List<String> values) {
            addCriterion("RULE_VALUE in", values, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotIn(List<String> values) {
            addCriterion("RULE_VALUE not in", values, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueBetween(String value1, String value2) {
            addCriterion("RULE_VALUE between", value1, value2, "ruleValue");
            return (Criteria) this;
        }

        public Criteria andRuleValueNotBetween(String value1, String value2) {
            addCriterion("RULE_VALUE not between", value1, value2, "ruleValue");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNull() {
            addCriterion("PARAM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andParamTypeIsNotNull() {
            addCriterion("PARAM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andParamTypeEqualTo(String value) {
            addCriterion("PARAM_TYPE =", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotEqualTo(String value) {
            addCriterion("PARAM_TYPE <>", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThan(String value) {
            addCriterion("PARAM_TYPE >", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_TYPE >=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThan(String value) {
            addCriterion("PARAM_TYPE <", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_TYPE <=", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeLike(String value) {
            addCriterion("PARAM_TYPE like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotLike(String value) {
            addCriterion("PARAM_TYPE not like", value, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeIn(List<String> values) {
            addCriterion("PARAM_TYPE in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotIn(List<String> values) {
            addCriterion("PARAM_TYPE not in", values, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeBetween(String value1, String value2) {
            addCriterion("PARAM_TYPE between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andParamTypeNotBetween(String value1, String value2) {
            addCriterion("PARAM_TYPE not between", value1, value2, "paramType");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyIsNull() {
            addCriterion("PENALTY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyIsNotNull() {
            addCriterion("PENALTY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyEqualTo(String value) {
            addCriterion("PENALTY_MONEY =", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyNotEqualTo(String value) {
            addCriterion("PENALTY_MONEY <>", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyGreaterThan(String value) {
            addCriterion("PENALTY_MONEY >", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("PENALTY_MONEY >=", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyLessThan(String value) {
            addCriterion("PENALTY_MONEY <", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyLessThanOrEqualTo(String value) {
            addCriterion("PENALTY_MONEY <=", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyLike(String value) {
            addCriterion("PENALTY_MONEY like", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyNotLike(String value) {
            addCriterion("PENALTY_MONEY not like", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyIn(List<String> values) {
            addCriterion("PENALTY_MONEY in", values, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyNotIn(List<String> values) {
            addCriterion("PENALTY_MONEY not in", values, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyBetween(String value1, String value2) {
            addCriterion("PENALTY_MONEY between", value1, value2, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyNotBetween(String value1, String value2) {
            addCriterion("PENALTY_MONEY not between", value1, value2, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeIsNull() {
            addCriterion("PENALTY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeIsNotNull() {
            addCriterion("PENALTY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeEqualTo(Byte value) {
            addCriterion("PENALTY_TYPE =", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeNotEqualTo(Byte value) {
            addCriterion("PENALTY_TYPE <>", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeGreaterThan(Byte value) {
            addCriterion("PENALTY_TYPE >", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("PENALTY_TYPE >=", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeLessThan(Byte value) {
            addCriterion("PENALTY_TYPE <", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeLessThanOrEqualTo(Byte value) {
            addCriterion("PENALTY_TYPE <=", value, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeIn(List<Byte> values) {
            addCriterion("PENALTY_TYPE in", values, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeNotIn(List<Byte> values) {
            addCriterion("PENALTY_TYPE not in", values, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeBetween(Byte value1, Byte value2) {
            addCriterion("PENALTY_TYPE between", value1, value2, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPenaltyTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("PENALTY_TYPE not between", value1, value2, "penaltyType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("PAYMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("PAYMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("PAYMENT_TYPE =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(String value) {
            addCriterion("PAYMENT_TYPE <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(String value) {
            addCriterion("PAYMENT_TYPE >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_TYPE >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(String value) {
            addCriterion("PAYMENT_TYPE <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_TYPE <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLike(String value) {
            addCriterion("PAYMENT_TYPE like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotLike(String value) {
            addCriterion("PAYMENT_TYPE not like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<String> values) {
            addCriterion("PAYMENT_TYPE in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<String> values) {
            addCriterion("PAYMENT_TYPE not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(String value1, String value2) {
            addCriterion("PAYMENT_TYPE between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_TYPE not between", value1, value2, "paymentType");
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