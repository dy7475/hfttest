package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunPaidAduitExample {
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
    public AdminFunPaidAduitExample() {
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

        public Criteria andAduitIdIsNull() {
            addCriterion("ADUIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAduitIdIsNotNull() {
            addCriterion("ADUIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAduitIdEqualTo(Integer value) {
            addCriterion("ADUIT_ID =", value, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdNotEqualTo(Integer value) {
            addCriterion("ADUIT_ID <>", value, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdGreaterThan(Integer value) {
            addCriterion("ADUIT_ID >", value, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADUIT_ID >=", value, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdLessThan(Integer value) {
            addCriterion("ADUIT_ID <", value, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdLessThanOrEqualTo(Integer value) {
            addCriterion("ADUIT_ID <=", value, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdIn(List<Integer> values) {
            addCriterion("ADUIT_ID in", values, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdNotIn(List<Integer> values) {
            addCriterion("ADUIT_ID not in", values, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdBetween(Integer value1, Integer value2) {
            addCriterion("ADUIT_ID between", value1, value2, "aduitId");
            return (Criteria) this;
        }

        public Criteria andAduitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ADUIT_ID not between", value1, value2, "aduitId");
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

        public Criteria andExtractAmountIsNull() {
            addCriterion("EXTRACT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andExtractAmountIsNotNull() {
            addCriterion("EXTRACT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andExtractAmountEqualTo(Long value) {
            addCriterion("EXTRACT_AMOUNT =", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountNotEqualTo(Long value) {
            addCriterion("EXTRACT_AMOUNT <>", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountGreaterThan(Long value) {
            addCriterion("EXTRACT_AMOUNT >", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("EXTRACT_AMOUNT >=", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountLessThan(Long value) {
            addCriterion("EXTRACT_AMOUNT <", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountLessThanOrEqualTo(Long value) {
            addCriterion("EXTRACT_AMOUNT <=", value, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountIn(List<Long> values) {
            addCriterion("EXTRACT_AMOUNT in", values, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountNotIn(List<Long> values) {
            addCriterion("EXTRACT_AMOUNT not in", values, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountBetween(Long value1, Long value2) {
            addCriterion("EXTRACT_AMOUNT between", value1, value2, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andExtractAmountNotBetween(Long value1, Long value2) {
            addCriterion("EXTRACT_AMOUNT not between", value1, value2, "extractAmount");
            return (Criteria) this;
        }

        public Criteria andAduitUidIsNull() {
            addCriterion("ADUIT_UID is null");
            return (Criteria) this;
        }

        public Criteria andAduitUidIsNotNull() {
            addCriterion("ADUIT_UID is not null");
            return (Criteria) this;
        }

        public Criteria andAduitUidEqualTo(Integer value) {
            addCriterion("ADUIT_UID =", value, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidNotEqualTo(Integer value) {
            addCriterion("ADUIT_UID <>", value, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidGreaterThan(Integer value) {
            addCriterion("ADUIT_UID >", value, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADUIT_UID >=", value, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidLessThan(Integer value) {
            addCriterion("ADUIT_UID <", value, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidLessThanOrEqualTo(Integer value) {
            addCriterion("ADUIT_UID <=", value, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidIn(List<Integer> values) {
            addCriterion("ADUIT_UID in", values, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidNotIn(List<Integer> values) {
            addCriterion("ADUIT_UID not in", values, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidBetween(Integer value1, Integer value2) {
            addCriterion("ADUIT_UID between", value1, value2, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitUidNotBetween(Integer value1, Integer value2) {
            addCriterion("ADUIT_UID not between", value1, value2, "aduitUid");
            return (Criteria) this;
        }

        public Criteria andAduitTimeIsNull() {
            addCriterion("ADUIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAduitTimeIsNotNull() {
            addCriterion("ADUIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAduitTimeEqualTo(Date value) {
            addCriterion("ADUIT_TIME =", value, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeNotEqualTo(Date value) {
            addCriterion("ADUIT_TIME <>", value, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeGreaterThan(Date value) {
            addCriterion("ADUIT_TIME >", value, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADUIT_TIME >=", value, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeLessThan(Date value) {
            addCriterion("ADUIT_TIME <", value, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeLessThanOrEqualTo(Date value) {
            addCriterion("ADUIT_TIME <=", value, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeIn(List<Date> values) {
            addCriterion("ADUIT_TIME in", values, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeNotIn(List<Date> values) {
            addCriterion("ADUIT_TIME not in", values, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeBetween(Date value1, Date value2) {
            addCriterion("ADUIT_TIME between", value1, value2, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andAduitTimeNotBetween(Date value1, Date value2) {
            addCriterion("ADUIT_TIME not between", value1, value2, "aduitTime");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Byte value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Byte value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Byte value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Byte value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Byte value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Byte> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Byte> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Byte value1, Byte value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andCompNoIsNull() {
            addCriterion("COMP_NO is null");
            return (Criteria) this;
        }

        public Criteria andCompNoIsNotNull() {
            addCriterion("COMP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCompNoEqualTo(String value) {
            addCriterion("COMP_NO =", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotEqualTo(String value) {
            addCriterion("COMP_NO <>", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoGreaterThan(String value) {
            addCriterion("COMP_NO >", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_NO >=", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLessThan(String value) {
            addCriterion("COMP_NO <", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLessThanOrEqualTo(String value) {
            addCriterion("COMP_NO <=", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLike(String value) {
            addCriterion("COMP_NO like", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotLike(String value) {
            addCriterion("COMP_NO not like", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoIn(List<String> values) {
            addCriterion("COMP_NO in", values, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotIn(List<String> values) {
            addCriterion("COMP_NO not in", values, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoBetween(String value1, String value2) {
            addCriterion("COMP_NO between", value1, value2, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotBetween(String value1, String value2) {
            addCriterion("COMP_NO not between", value1, value2, "compNo");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIsNull() {
            addCriterion("ARCHIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIsNotNull() {
            addCriterion("ARCHIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveIdEqualTo(String value) {
            addCriterion("ARCHIVE_ID =", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotEqualTo(String value) {
            addCriterion("ARCHIVE_ID <>", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThan(String value) {
            addCriterion("ARCHIVE_ID >", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThanOrEqualTo(String value) {
            addCriterion("ARCHIVE_ID >=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThan(String value) {
            addCriterion("ARCHIVE_ID <", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThanOrEqualTo(String value) {
            addCriterion("ARCHIVE_ID <=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLike(String value) {
            addCriterion("ARCHIVE_ID like", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotLike(String value) {
            addCriterion("ARCHIVE_ID not like", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIn(List<String> values) {
            addCriterion("ARCHIVE_ID in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotIn(List<String> values) {
            addCriterion("ARCHIVE_ID not in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdBetween(String value1, String value2) {
            addCriterion("ARCHIVE_ID between", value1, value2, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotBetween(String value1, String value2) {
            addCriterion("ARCHIVE_ID not between", value1, value2, "archiveId");
            return (Criteria) this;
        }

        public Criteria andUaTypeIsNull() {
            addCriterion("UA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUaTypeIsNotNull() {
            addCriterion("UA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUaTypeEqualTo(Byte value) {
            addCriterion("UA_TYPE =", value, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeNotEqualTo(Byte value) {
            addCriterion("UA_TYPE <>", value, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeGreaterThan(Byte value) {
            addCriterion("UA_TYPE >", value, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("UA_TYPE >=", value, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeLessThan(Byte value) {
            addCriterion("UA_TYPE <", value, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeLessThanOrEqualTo(Byte value) {
            addCriterion("UA_TYPE <=", value, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeIn(List<Byte> values) {
            addCriterion("UA_TYPE in", values, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeNotIn(List<Byte> values) {
            addCriterion("UA_TYPE not in", values, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeBetween(Byte value1, Byte value2) {
            addCriterion("UA_TYPE between", value1, value2, "uaType");
            return (Criteria) this;
        }

        public Criteria andUaTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("UA_TYPE not between", value1, value2, "uaType");
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