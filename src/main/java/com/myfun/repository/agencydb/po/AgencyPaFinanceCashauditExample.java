package com.myfun.repository.agencydb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgencyPaFinanceCashauditExample {
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
    public AgencyPaFinanceCashauditExample() {
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

        public Criteria andCashIdIsNull() {
            addCriterion("CASH_ID is null");
            return (Criteria) this;
        }

        public Criteria andCashIdIsNotNull() {
            addCriterion("CASH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCashIdEqualTo(Integer value) {
            addCriterion("CASH_ID =", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdNotEqualTo(Integer value) {
            addCriterion("CASH_ID <>", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdGreaterThan(Integer value) {
            addCriterion("CASH_ID >", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASH_ID >=", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdLessThan(Integer value) {
            addCriterion("CASH_ID <", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdLessThanOrEqualTo(Integer value) {
            addCriterion("CASH_ID <=", value, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdIn(List<Integer> values) {
            addCriterion("CASH_ID in", values, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdNotIn(List<Integer> values) {
            addCriterion("CASH_ID not in", values, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdBetween(Integer value1, Integer value2) {
            addCriterion("CASH_ID between", value1, value2, "cashId");
            return (Criteria) this;
        }

        public Criteria andCashIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CASH_ID not between", value1, value2, "cashId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNull() {
            addCriterion("FINANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("FINANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(Integer value) {
            addCriterion("FINANCE_ID =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(Integer value) {
            addCriterion("FINANCE_ID <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(Integer value) {
            addCriterion("FINANCE_ID >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FINANCE_ID >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(Integer value) {
            addCriterion("FINANCE_ID <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("FINANCE_ID <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<Integer> values) {
            addCriterion("FINANCE_ID in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<Integer> values) {
            addCriterion("FINANCE_ID not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(Integer value1, Integer value2) {
            addCriterion("FINANCE_ID between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FINANCE_ID not between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andCashPriceIsNull() {
            addCriterion("CASH_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCashPriceIsNotNull() {
            addCriterion("CASH_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCashPriceEqualTo(BigDecimal value) {
            addCriterion("CASH_PRICE =", value, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceNotEqualTo(BigDecimal value) {
            addCriterion("CASH_PRICE <>", value, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceGreaterThan(BigDecimal value) {
            addCriterion("CASH_PRICE >", value, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_PRICE >=", value, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceLessThan(BigDecimal value) {
            addCriterion("CASH_PRICE <", value, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASH_PRICE <=", value, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceIn(List<BigDecimal> values) {
            addCriterion("CASH_PRICE in", values, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceNotIn(List<BigDecimal> values) {
            addCriterion("CASH_PRICE not in", values, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_PRICE between", value1, value2, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andCashPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASH_PRICE not between", value1, value2, "cashPrice");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("AUDIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("AUDIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Byte value) {
            addCriterion("AUDIT_STATUS >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Byte value) {
            addCriterion("AUDIT_STATUS <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Byte> values) {
            addCriterion("AUDIT_STATUS in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Byte> values) {
            addCriterion("AUDIT_STATUS not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Byte value1, Byte value2) {
            addCriterion("AUDIT_STATUS between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("AUDIT_STATUS not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIsNull() {
            addCriterion("AUDIT_REASON is null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIsNotNull() {
            addCriterion("AUDIT_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andAuditReasonEqualTo(String value) {
            addCriterion("AUDIT_REASON =", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotEqualTo(String value) {
            addCriterion("AUDIT_REASON <>", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonGreaterThan(String value) {
            addCriterion("AUDIT_REASON >", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_REASON >=", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLessThan(String value) {
            addCriterion("AUDIT_REASON <", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_REASON <=", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonLike(String value) {
            addCriterion("AUDIT_REASON like", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotLike(String value) {
            addCriterion("AUDIT_REASON not like", value, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonIn(List<String> values) {
            addCriterion("AUDIT_REASON in", values, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotIn(List<String> values) {
            addCriterion("AUDIT_REASON not in", values, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonBetween(String value1, String value2) {
            addCriterion("AUDIT_REASON between", value1, value2, "auditReason");
            return (Criteria) this;
        }

        public Criteria andAuditReasonNotBetween(String value1, String value2) {
            addCriterion("AUDIT_REASON not between", value1, value2, "auditReason");
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

        public Criteria andAuditUidIsNull() {
            addCriterion("AUDIT_UID is null");
            return (Criteria) this;
        }

        public Criteria andAuditUidIsNotNull() {
            addCriterion("AUDIT_UID is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUidEqualTo(Integer value) {
            addCriterion("AUDIT_UID =", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidNotEqualTo(Integer value) {
            addCriterion("AUDIT_UID <>", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidGreaterThan(Integer value) {
            addCriterion("AUDIT_UID >", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUDIT_UID >=", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidLessThan(Integer value) {
            addCriterion("AUDIT_UID <", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidLessThanOrEqualTo(Integer value) {
            addCriterion("AUDIT_UID <=", value, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidIn(List<Integer> values) {
            addCriterion("AUDIT_UID in", values, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidNotIn(List<Integer> values) {
            addCriterion("AUDIT_UID not in", values, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidBetween(Integer value1, Integer value2) {
            addCriterion("AUDIT_UID between", value1, value2, "auditUid");
            return (Criteria) this;
        }

        public Criteria andAuditUidNotBetween(Integer value1, Integer value2) {
            addCriterion("AUDIT_UID not between", value1, value2, "auditUid");
            return (Criteria) this;
        }

        public Criteria andCashDateIsNull() {
            addCriterion("CASH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCashDateIsNotNull() {
            addCriterion("CASH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCashDateEqualTo(Date value) {
            addCriterion("CASH_DATE =", value, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateNotEqualTo(Date value) {
            addCriterion("CASH_DATE <>", value, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateGreaterThan(Date value) {
            addCriterion("CASH_DATE >", value, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CASH_DATE >=", value, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateLessThan(Date value) {
            addCriterion("CASH_DATE <", value, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateLessThanOrEqualTo(Date value) {
            addCriterion("CASH_DATE <=", value, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateIn(List<Date> values) {
            addCriterion("CASH_DATE in", values, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateNotIn(List<Date> values) {
            addCriterion("CASH_DATE not in", values, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateBetween(Date value1, Date value2) {
            addCriterion("CASH_DATE between", value1, value2, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashDateNotBetween(Date value1, Date value2) {
            addCriterion("CASH_DATE not between", value1, value2, "cashDate");
            return (Criteria) this;
        }

        public Criteria andCashTypeIsNull() {
            addCriterion("CASH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCashTypeIsNotNull() {
            addCriterion("CASH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCashTypeEqualTo(Byte value) {
            addCriterion("CASH_TYPE =", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeNotEqualTo(Byte value) {
            addCriterion("CASH_TYPE <>", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeGreaterThan(Byte value) {
            addCriterion("CASH_TYPE >", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("CASH_TYPE >=", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeLessThan(Byte value) {
            addCriterion("CASH_TYPE <", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeLessThanOrEqualTo(Byte value) {
            addCriterion("CASH_TYPE <=", value, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeIn(List<Byte> values) {
            addCriterion("CASH_TYPE in", values, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeNotIn(List<Byte> values) {
            addCriterion("CASH_TYPE not in", values, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeBetween(Byte value1, Byte value2) {
            addCriterion("CASH_TYPE between", value1, value2, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("CASH_TYPE not between", value1, value2, "cashType");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdIsNull() {
            addCriterion("CASH_ARCHIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdIsNotNull() {
            addCriterion("CASH_ARCHIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdEqualTo(Integer value) {
            addCriterion("CASH_ARCHIVE_ID =", value, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdNotEqualTo(Integer value) {
            addCriterion("CASH_ARCHIVE_ID <>", value, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdGreaterThan(Integer value) {
            addCriterion("CASH_ARCHIVE_ID >", value, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASH_ARCHIVE_ID >=", value, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdLessThan(Integer value) {
            addCriterion("CASH_ARCHIVE_ID <", value, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("CASH_ARCHIVE_ID <=", value, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdIn(List<Integer> values) {
            addCriterion("CASH_ARCHIVE_ID in", values, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdNotIn(List<Integer> values) {
            addCriterion("CASH_ARCHIVE_ID not in", values, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdBetween(Integer value1, Integer value2) {
            addCriterion("CASH_ARCHIVE_ID between", value1, value2, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andCashArchiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CASH_ARCHIVE_ID not between", value1, value2, "cashArchiveId");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("TRADE_NO is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("TRADE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("TRADE_NO =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("TRADE_NO <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("TRADE_NO >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_NO >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("TRADE_NO <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("TRADE_NO <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("TRADE_NO like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("TRADE_NO not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("TRADE_NO in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("TRADE_NO not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("TRADE_NO between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("TRADE_NO not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("PAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("PAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("PAY_TIME =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("PAY_TIME <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("PAY_TIME >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PAY_TIME >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("PAY_TIME <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("PAY_TIME <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("PAY_TIME in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("PAY_TIME not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("PAY_TIME between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("PAY_TIME not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andCashModeIsNull() {
            addCriterion("CASH_MODE is null");
            return (Criteria) this;
        }

        public Criteria andCashModeIsNotNull() {
            addCriterion("CASH_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andCashModeEqualTo(Byte value) {
            addCriterion("CASH_MODE =", value, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeNotEqualTo(Byte value) {
            addCriterion("CASH_MODE <>", value, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeGreaterThan(Byte value) {
            addCriterion("CASH_MODE >", value, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("CASH_MODE >=", value, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeLessThan(Byte value) {
            addCriterion("CASH_MODE <", value, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeLessThanOrEqualTo(Byte value) {
            addCriterion("CASH_MODE <=", value, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeIn(List<Byte> values) {
            addCriterion("CASH_MODE in", values, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeNotIn(List<Byte> values) {
            addCriterion("CASH_MODE not in", values, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeBetween(Byte value1, Byte value2) {
            addCriterion("CASH_MODE between", value1, value2, "cashMode");
            return (Criteria) this;
        }

        public Criteria andCashModeNotBetween(Byte value1, Byte value2) {
            addCriterion("CASH_MODE not between", value1, value2, "cashMode");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyIsNull() {
            addCriterion("TAXES_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyIsNotNull() {
            addCriterion("TAXES_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY =", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyNotEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY <>", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyGreaterThan(BigDecimal value) {
            addCriterion("TAXES_MONEY >", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY >=", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyLessThan(BigDecimal value) {
            addCriterion("TAXES_MONEY <", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY <=", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyIn(List<BigDecimal> values) {
            addCriterion("TAXES_MONEY in", values, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyNotIn(List<BigDecimal> values) {
            addCriterion("TAXES_MONEY not in", values, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXES_MONEY between", value1, value2, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXES_MONEY not between", value1, value2, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceIsNull() {
            addCriterion("RAKEBACK_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceIsNotNull() {
            addCriterion("RAKEBACK_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE =", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceNotEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE <>", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceGreaterThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE >", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE >=", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceLessThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE <", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE <=", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE in", values, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceNotIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE not in", values, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE between", value1, value2, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE not between", value1, value2, "rakebackPrice");
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