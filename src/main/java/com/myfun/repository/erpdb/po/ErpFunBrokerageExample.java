package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ErpFunBrokerageExample extends ShardDb {
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
    public ErpFunBrokerageExample() {
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

        public Criteria andBrokerageRateIsNull() {
            addCriterion("BROKERAGE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateIsNotNull() {
            addCriterion("BROKERAGE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateEqualTo(BigDecimal value) {
            addCriterion("BROKERAGE_RATE =", value, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateNotEqualTo(BigDecimal value) {
            addCriterion("BROKERAGE_RATE <>", value, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateGreaterThan(BigDecimal value) {
            addCriterion("BROKERAGE_RATE >", value, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BROKERAGE_RATE >=", value, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateLessThan(BigDecimal value) {
            addCriterion("BROKERAGE_RATE <", value, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BROKERAGE_RATE <=", value, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateIn(List<BigDecimal> values) {
            addCriterion("BROKERAGE_RATE in", values, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateNotIn(List<BigDecimal> values) {
            addCriterion("BROKERAGE_RATE not in", values, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BROKERAGE_RATE between", value1, value2, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BROKERAGE_RATE not between", value1, value2, "brokerageRate");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeIsNull() {
            addCriterion("BROKERAGE_COUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeIsNotNull() {
            addCriterion("BROKERAGE_COUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeEqualTo(Integer value) {
            addCriterion("BROKERAGE_COUNT_TYPE =", value, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeNotEqualTo(Integer value) {
            addCriterion("BROKERAGE_COUNT_TYPE <>", value, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeGreaterThan(Integer value) {
            addCriterion("BROKERAGE_COUNT_TYPE >", value, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BROKERAGE_COUNT_TYPE >=", value, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeLessThan(Integer value) {
            addCriterion("BROKERAGE_COUNT_TYPE <", value, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BROKERAGE_COUNT_TYPE <=", value, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeIn(List<Integer> values) {
            addCriterion("BROKERAGE_COUNT_TYPE in", values, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeNotIn(List<Integer> values) {
            addCriterion("BROKERAGE_COUNT_TYPE not in", values, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeBetween(Integer value1, Integer value2) {
            addCriterion("BROKERAGE_COUNT_TYPE between", value1, value2, "brokerageCountType");
            return (Criteria) this;
        }

        public Criteria andBrokerageCountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BROKERAGE_COUNT_TYPE not between", value1, value2, "brokerageCountType");
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

        public Criteria andSaleLeaseEqualTo(Integer value) {
            addCriterion("SALE_LEASE =", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotEqualTo(Integer value) {
            addCriterion("SALE_LEASE <>", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThan(Integer value) {
            addCriterion("SALE_LEASE >", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("SALE_LEASE >=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThan(Integer value) {
            addCriterion("SALE_LEASE <", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThanOrEqualTo(Integer value) {
            addCriterion("SALE_LEASE <=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIn(List<Integer> values) {
            addCriterion("SALE_LEASE in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotIn(List<Integer> values) {
            addCriterion("SALE_LEASE not in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseBetween(Integer value1, Integer value2) {
            addCriterion("SALE_LEASE between", value1, value2, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotBetween(Integer value1, Integer value2) {
            addCriterion("SALE_LEASE not between", value1, value2, "saleLease");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateIsNull() {
            addCriterion("CHARGE_HOUSE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateIsNotNull() {
            addCriterion("CHARGE_HOUSE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateEqualTo(BigDecimal value) {
            addCriterion("CHARGE_HOUSE_RATE =", value, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateNotEqualTo(BigDecimal value) {
            addCriterion("CHARGE_HOUSE_RATE <>", value, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateGreaterThan(BigDecimal value) {
            addCriterion("CHARGE_HOUSE_RATE >", value, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE_HOUSE_RATE >=", value, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateLessThan(BigDecimal value) {
            addCriterion("CHARGE_HOUSE_RATE <", value, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE_HOUSE_RATE <=", value, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateIn(List<BigDecimal> values) {
            addCriterion("CHARGE_HOUSE_RATE in", values, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateNotIn(List<BigDecimal> values) {
            addCriterion("CHARGE_HOUSE_RATE not in", values, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE_HOUSE_RATE between", value1, value2, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeHouseRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE_HOUSE_RATE not between", value1, value2, "chargeHouseRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateIsNull() {
            addCriterion("CHARGE_CUST_RATE is null");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateIsNotNull() {
            addCriterion("CHARGE_CUST_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateEqualTo(BigDecimal value) {
            addCriterion("CHARGE_CUST_RATE =", value, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateNotEqualTo(BigDecimal value) {
            addCriterion("CHARGE_CUST_RATE <>", value, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateGreaterThan(BigDecimal value) {
            addCriterion("CHARGE_CUST_RATE >", value, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE_CUST_RATE >=", value, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateLessThan(BigDecimal value) {
            addCriterion("CHARGE_CUST_RATE <", value, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE_CUST_RATE <=", value, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateIn(List<BigDecimal> values) {
            addCriterion("CHARGE_CUST_RATE in", values, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateNotIn(List<BigDecimal> values) {
            addCriterion("CHARGE_CUST_RATE not in", values, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE_CUST_RATE between", value1, value2, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andChargeCustRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE_CUST_RATE not between", value1, value2, "chargeCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateIsNull() {
            addCriterion("BROKER_HOUSE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateIsNotNull() {
            addCriterion("BROKER_HOUSE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateEqualTo(BigDecimal value) {
            addCriterion("BROKER_HOUSE_RATE =", value, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateNotEqualTo(BigDecimal value) {
            addCriterion("BROKER_HOUSE_RATE <>", value, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateGreaterThan(BigDecimal value) {
            addCriterion("BROKER_HOUSE_RATE >", value, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BROKER_HOUSE_RATE >=", value, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateLessThan(BigDecimal value) {
            addCriterion("BROKER_HOUSE_RATE <", value, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BROKER_HOUSE_RATE <=", value, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateIn(List<BigDecimal> values) {
            addCriterion("BROKER_HOUSE_RATE in", values, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateNotIn(List<BigDecimal> values) {
            addCriterion("BROKER_HOUSE_RATE not in", values, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BROKER_HOUSE_RATE between", value1, value2, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerHouseRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BROKER_HOUSE_RATE not between", value1, value2, "brokerHouseRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateIsNull() {
            addCriterion("BROKER_CUST_RATE is null");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateIsNotNull() {
            addCriterion("BROKER_CUST_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateEqualTo(BigDecimal value) {
            addCriterion("BROKER_CUST_RATE =", value, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateNotEqualTo(BigDecimal value) {
            addCriterion("BROKER_CUST_RATE <>", value, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateGreaterThan(BigDecimal value) {
            addCriterion("BROKER_CUST_RATE >", value, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BROKER_CUST_RATE >=", value, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateLessThan(BigDecimal value) {
            addCriterion("BROKER_CUST_RATE <", value, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BROKER_CUST_RATE <=", value, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateIn(List<BigDecimal> values) {
            addCriterion("BROKER_CUST_RATE in", values, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateNotIn(List<BigDecimal> values) {
            addCriterion("BROKER_CUST_RATE not in", values, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BROKER_CUST_RATE between", value1, value2, "brokerCustRate");
            return (Criteria) this;
        }

        public Criteria andBrokerCustRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BROKER_CUST_RATE not between", value1, value2, "brokerCustRate");
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