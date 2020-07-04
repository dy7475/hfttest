package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpCityshareBorkerPurchaseExample extends ShardDb {
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
    public ErpCityshareBorkerPurchaseExample() {
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

        public Criteria andPurchaseIdIsNull() {
            addCriterion("PURCHASE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIsNotNull() {
            addCriterion("PURCHASE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdEqualTo(Integer value) {
            addCriterion("PURCHASE_ID =", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotEqualTo(Integer value) {
            addCriterion("PURCHASE_ID <>", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThan(Integer value) {
            addCriterion("PURCHASE_ID >", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PURCHASE_ID >=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThan(Integer value) {
            addCriterion("PURCHASE_ID <", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("PURCHASE_ID <=", value, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdIn(List<Integer> values) {
            addCriterion("PURCHASE_ID in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotIn(List<Integer> values) {
            addCriterion("PURCHASE_ID not in", values, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdBetween(Integer value1, Integer value2) {
            addCriterion("PURCHASE_ID between", value1, value2, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PURCHASE_ID not between", value1, value2, "purchaseId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNull() {
            addCriterion("RETURN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIsNotNull() {
            addCriterion("RETURN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andReturnStatusEqualTo(Byte value) {
            addCriterion("RETURN_STATUS =", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotEqualTo(Byte value) {
            addCriterion("RETURN_STATUS <>", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThan(Byte value) {
            addCriterion("RETURN_STATUS >", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("RETURN_STATUS >=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThan(Byte value) {
            addCriterion("RETURN_STATUS <", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusLessThanOrEqualTo(Byte value) {
            addCriterion("RETURN_STATUS <=", value, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusIn(List<Byte> values) {
            addCriterion("RETURN_STATUS in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotIn(List<Byte> values) {
            addCriterion("RETURN_STATUS not in", values, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusBetween(Byte value1, Byte value2) {
            addCriterion("RETURN_STATUS between", value1, value2, "returnStatus");
            return (Criteria) this;
        }

        public Criteria andReturnStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("RETURN_STATUS not between", value1, value2, "returnStatus");
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

        public Criteria andSharehouseIdIsNull() {
            addCriterion("SHAREHOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdIsNotNull() {
            addCriterion("SHAREHOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID =", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdNotEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID <>", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdGreaterThan(Integer value) {
            addCriterion("SHAREHOUSE_ID >", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID >=", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdLessThan(Integer value) {
            addCriterion("SHAREHOUSE_ID <", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID <=", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdIn(List<Integer> values) {
            addCriterion("SHAREHOUSE_ID in", values, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdNotIn(List<Integer> values) {
            addCriterion("SHAREHOUSE_ID not in", values, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdBetween(Integer value1, Integer value2) {
            addCriterion("SHAREHOUSE_ID between", value1, value2, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SHAREHOUSE_ID not between", value1, value2, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIsNull() {
            addCriterion("PURCHASE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIsNotNull() {
            addCriterion("PURCHASE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeEqualTo(Byte value) {
            addCriterion("PURCHASE_TYPE =", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotEqualTo(Byte value) {
            addCriterion("PURCHASE_TYPE <>", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeGreaterThan(Byte value) {
            addCriterion("PURCHASE_TYPE >", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("PURCHASE_TYPE >=", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLessThan(Byte value) {
            addCriterion("PURCHASE_TYPE <", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("PURCHASE_TYPE <=", value, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeIn(List<Byte> values) {
            addCriterion("PURCHASE_TYPE in", values, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotIn(List<Byte> values) {
            addCriterion("PURCHASE_TYPE not in", values, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeBetween(Byte value1, Byte value2) {
            addCriterion("PURCHASE_TYPE between", value1, value2, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andPurchaseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("PURCHASE_TYPE not between", value1, value2, "purchaseType");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyIsNull() {
            addCriterion("MANAGER_GET_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyIsNotNull() {
            addCriterion("MANAGER_GET_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyEqualTo(BigDecimal value) {
            addCriterion("MANAGER_GET_MONEY =", value, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyNotEqualTo(BigDecimal value) {
            addCriterion("MANAGER_GET_MONEY <>", value, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyGreaterThan(BigDecimal value) {
            addCriterion("MANAGER_GET_MONEY >", value, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MANAGER_GET_MONEY >=", value, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyLessThan(BigDecimal value) {
            addCriterion("MANAGER_GET_MONEY <", value, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MANAGER_GET_MONEY <=", value, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyIn(List<BigDecimal> values) {
            addCriterion("MANAGER_GET_MONEY in", values, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyNotIn(List<BigDecimal> values) {
            addCriterion("MANAGER_GET_MONEY not in", values, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MANAGER_GET_MONEY between", value1, value2, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andManagerGetMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MANAGER_GET_MONEY not between", value1, value2, "managerGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyIsNull() {
            addCriterion("SHARE_GET_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyIsNotNull() {
            addCriterion("SHARE_GET_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyEqualTo(BigDecimal value) {
            addCriterion("SHARE_GET_MONEY =", value, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyNotEqualTo(BigDecimal value) {
            addCriterion("SHARE_GET_MONEY <>", value, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyGreaterThan(BigDecimal value) {
            addCriterion("SHARE_GET_MONEY >", value, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SHARE_GET_MONEY >=", value, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyLessThan(BigDecimal value) {
            addCriterion("SHARE_GET_MONEY <", value, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SHARE_GET_MONEY <=", value, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyIn(List<BigDecimal> values) {
            addCriterion("SHARE_GET_MONEY in", values, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyNotIn(List<BigDecimal> values) {
            addCriterion("SHARE_GET_MONEY not in", values, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHARE_GET_MONEY between", value1, value2, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andShareGetMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHARE_GET_MONEY not between", value1, value2, "shareGetMoney");
            return (Criteria) this;
        }

        public Criteria andViewStatusIsNull() {
            addCriterion("VIEW_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andViewStatusIsNotNull() {
            addCriterion("VIEW_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andViewStatusEqualTo(Byte value) {
            addCriterion("VIEW_STATUS =", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusNotEqualTo(Byte value) {
            addCriterion("VIEW_STATUS <>", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusGreaterThan(Byte value) {
            addCriterion("VIEW_STATUS >", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("VIEW_STATUS >=", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusLessThan(Byte value) {
            addCriterion("VIEW_STATUS <", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusLessThanOrEqualTo(Byte value) {
            addCriterion("VIEW_STATUS <=", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusIn(List<Byte> values) {
            addCriterion("VIEW_STATUS in", values, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusNotIn(List<Byte> values) {
            addCriterion("VIEW_STATUS not in", values, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusBetween(Byte value1, Byte value2) {
            addCriterion("VIEW_STATUS between", value1, value2, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("VIEW_STATUS not between", value1, value2, "viewStatus");
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

        public Criteria andArchiveIdEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID =", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID <>", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThan(Integer value) {
            addCriterion("ARCHIVE_ID >", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID >=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThan(Integer value) {
            addCriterion("ARCHIVE_ID <", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID <=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIn(List<Integer> values) {
            addCriterion("ARCHIVE_ID in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotIn(List<Integer> values) {
            addCriterion("ARCHIVE_ID not in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdBetween(Integer value1, Integer value2) {
            addCriterion("ARCHIVE_ID between", value1, value2, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ARCHIVE_ID not between", value1, value2, "archiveId");
            return (Criteria) this;
        }

        public Criteria andShareReturnIsNull() {
            addCriterion("SHARE_RETURN is null");
            return (Criteria) this;
        }

        public Criteria andShareReturnIsNotNull() {
            addCriterion("SHARE_RETURN is not null");
            return (Criteria) this;
        }

        public Criteria andShareReturnEqualTo(Byte value) {
            addCriterion("SHARE_RETURN =", value, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnNotEqualTo(Byte value) {
            addCriterion("SHARE_RETURN <>", value, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnGreaterThan(Byte value) {
            addCriterion("SHARE_RETURN >", value, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnGreaterThanOrEqualTo(Byte value) {
            addCriterion("SHARE_RETURN >=", value, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnLessThan(Byte value) {
            addCriterion("SHARE_RETURN <", value, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnLessThanOrEqualTo(Byte value) {
            addCriterion("SHARE_RETURN <=", value, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnIn(List<Byte> values) {
            addCriterion("SHARE_RETURN in", values, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnNotIn(List<Byte> values) {
            addCriterion("SHARE_RETURN not in", values, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnBetween(Byte value1, Byte value2) {
            addCriterion("SHARE_RETURN between", value1, value2, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andShareReturnNotBetween(Byte value1, Byte value2) {
            addCriterion("SHARE_RETURN not between", value1, value2, "shareReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnIsNull() {
            addCriterion("MANAGER_RETURN is null");
            return (Criteria) this;
        }

        public Criteria andManagerReturnIsNotNull() {
            addCriterion("MANAGER_RETURN is not null");
            return (Criteria) this;
        }

        public Criteria andManagerReturnEqualTo(Byte value) {
            addCriterion("MANAGER_RETURN =", value, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnNotEqualTo(Byte value) {
            addCriterion("MANAGER_RETURN <>", value, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnGreaterThan(Byte value) {
            addCriterion("MANAGER_RETURN >", value, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnGreaterThanOrEqualTo(Byte value) {
            addCriterion("MANAGER_RETURN >=", value, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnLessThan(Byte value) {
            addCriterion("MANAGER_RETURN <", value, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnLessThanOrEqualTo(Byte value) {
            addCriterion("MANAGER_RETURN <=", value, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnIn(List<Byte> values) {
            addCriterion("MANAGER_RETURN in", values, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnNotIn(List<Byte> values) {
            addCriterion("MANAGER_RETURN not in", values, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnBetween(Byte value1, Byte value2) {
            addCriterion("MANAGER_RETURN between", value1, value2, "managerReturn");
            return (Criteria) this;
        }

        public Criteria andManagerReturnNotBetween(Byte value1, Byte value2) {
            addCriterion("MANAGER_RETURN not between", value1, value2, "managerReturn");
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

        public Criteria andTargetComplainFlagIsNull() {
            addCriterion("TARGET_COMPLAIN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagIsNotNull() {
            addCriterion("TARGET_COMPLAIN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagEqualTo(Byte value) {
            addCriterion("TARGET_COMPLAIN_FLAG =", value, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagNotEqualTo(Byte value) {
            addCriterion("TARGET_COMPLAIN_FLAG <>", value, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagGreaterThan(Byte value) {
            addCriterion("TARGET_COMPLAIN_FLAG >", value, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("TARGET_COMPLAIN_FLAG >=", value, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagLessThan(Byte value) {
            addCriterion("TARGET_COMPLAIN_FLAG <", value, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagLessThanOrEqualTo(Byte value) {
            addCriterion("TARGET_COMPLAIN_FLAG <=", value, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagIn(List<Byte> values) {
            addCriterion("TARGET_COMPLAIN_FLAG in", values, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagNotIn(List<Byte> values) {
            addCriterion("TARGET_COMPLAIN_FLAG not in", values, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagBetween(Byte value1, Byte value2) {
            addCriterion("TARGET_COMPLAIN_FLAG between", value1, value2, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andTargetComplainFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("TARGET_COMPLAIN_FLAG not between", value1, value2, "targetComplainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagIsNull() {
            addCriterion("COMPLAIN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andComplainFlagIsNotNull() {
            addCriterion("COMPLAIN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andComplainFlagEqualTo(Byte value) {
            addCriterion("COMPLAIN_FLAG =", value, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagNotEqualTo(Byte value) {
            addCriterion("COMPLAIN_FLAG <>", value, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagGreaterThan(Byte value) {
            addCriterion("COMPLAIN_FLAG >", value, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("COMPLAIN_FLAG >=", value, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagLessThan(Byte value) {
            addCriterion("COMPLAIN_FLAG <", value, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagLessThanOrEqualTo(Byte value) {
            addCriterion("COMPLAIN_FLAG <=", value, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagIn(List<Byte> values) {
            addCriterion("COMPLAIN_FLAG in", values, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagNotIn(List<Byte> values) {
            addCriterion("COMPLAIN_FLAG not in", values, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAIN_FLAG between", value1, value2, "complainFlag");
            return (Criteria) this;
        }

        public Criteria andComplainFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAIN_FLAG not between", value1, value2, "complainFlag");
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