package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunCustSourceExample extends ShardDb {
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
    public ErpFunCustSourceExample() {
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

        public Criteria andCustSourceIdIsNull() {
            addCriterion("CUST_SOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdIsNotNull() {
            addCriterion("CUST_SOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdEqualTo(Integer value) {
            addCriterion("CUST_SOURCE_ID =", value, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdNotEqualTo(Integer value) {
            addCriterion("CUST_SOURCE_ID <>", value, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdGreaterThan(Integer value) {
            addCriterion("CUST_SOURCE_ID >", value, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUST_SOURCE_ID >=", value, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdLessThan(Integer value) {
            addCriterion("CUST_SOURCE_ID <", value, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("CUST_SOURCE_ID <=", value, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdIn(List<Integer> values) {
            addCriterion("CUST_SOURCE_ID in", values, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdNotIn(List<Integer> values) {
            addCriterion("CUST_SOURCE_ID not in", values, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("CUST_SOURCE_ID between", value1, value2, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCustSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CUST_SOURCE_ID not between", value1, value2, "custSourceId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIsNull() {
            addCriterion("CREATED_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIsNotNull() {
            addCriterion("CREATED_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdEqualTo(Integer value) {
            addCriterion("CREATED_USER_ID =", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotEqualTo(Integer value) {
            addCriterion("CREATED_USER_ID <>", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdGreaterThan(Integer value) {
            addCriterion("CREATED_USER_ID >", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATED_USER_ID >=", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdLessThan(Integer value) {
            addCriterion("CREATED_USER_ID <", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("CREATED_USER_ID <=", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIn(List<Integer> values) {
            addCriterion("CREATED_USER_ID in", values, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotIn(List<Integer> values) {
            addCriterion("CREATED_USER_ID not in", values, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdBetween(Integer value1, Integer value2) {
            addCriterion("CREATED_USER_ID between", value1, value2, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATED_USER_ID not between", value1, value2, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("CREATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("CREATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("CREATED_TIME =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("CREATED_TIME <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("CREATED_TIME >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("CREATED_TIME <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("CREATED_TIME in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("CREATED_TIME not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdIsNull() {
            addCriterion("UPDATED_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdIsNotNull() {
            addCriterion("UPDATED_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdEqualTo(String value) {
            addCriterion("UPDATED_USER_ID =", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotEqualTo(String value) {
            addCriterion("UPDATED_USER_ID <>", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdGreaterThan(String value) {
            addCriterion("UPDATED_USER_ID >", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATED_USER_ID >=", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdLessThan(String value) {
            addCriterion("UPDATED_USER_ID <", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATED_USER_ID <=", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdLike(String value) {
            addCriterion("UPDATED_USER_ID like", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotLike(String value) {
            addCriterion("UPDATED_USER_ID not like", value, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdIn(List<String> values) {
            addCriterion("UPDATED_USER_ID in", values, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotIn(List<String> values) {
            addCriterion("UPDATED_USER_ID not in", values, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdBetween(String value1, String value2) {
            addCriterion("UPDATED_USER_ID between", value1, value2, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIdNotBetween(String value1, String value2) {
            addCriterion("UPDATED_USER_ID not between", value1, value2, "updatedUserId");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("UPDATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("UPDATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("UPDATED_TIME =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("UPDATED_TIME <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("UPDATED_TIME >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("UPDATED_TIME <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("UPDATED_TIME in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("UPDATED_TIME not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andForbidStatusIsNull() {
            addCriterion("FORBID_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andForbidStatusIsNotNull() {
            addCriterion("FORBID_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andForbidStatusEqualTo(Byte value) {
            addCriterion("FORBID_STATUS =", value, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusNotEqualTo(Byte value) {
            addCriterion("FORBID_STATUS <>", value, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusGreaterThan(Byte value) {
            addCriterion("FORBID_STATUS >", value, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("FORBID_STATUS >=", value, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusLessThan(Byte value) {
            addCriterion("FORBID_STATUS <", value, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusLessThanOrEqualTo(Byte value) {
            addCriterion("FORBID_STATUS <=", value, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusIn(List<Byte> values) {
            addCriterion("FORBID_STATUS in", values, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusNotIn(List<Byte> values) {
            addCriterion("FORBID_STATUS not in", values, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusBetween(Byte value1, Byte value2) {
            addCriterion("FORBID_STATUS between", value1, value2, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andForbidStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("FORBID_STATUS not between", value1, value2, "forbidStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusIsNull() {
            addCriterion("DEL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDelStatusIsNotNull() {
            addCriterion("DEL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDelStatusEqualTo(Byte value) {
            addCriterion("DEL_STATUS =", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotEqualTo(Byte value) {
            addCriterion("DEL_STATUS <>", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThan(Byte value) {
            addCriterion("DEL_STATUS >", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("DEL_STATUS >=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThan(Byte value) {
            addCriterion("DEL_STATUS <", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThanOrEqualTo(Byte value) {
            addCriterion("DEL_STATUS <=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusIn(List<Byte> values) {
            addCriterion("DEL_STATUS in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotIn(List<Byte> values) {
            addCriterion("DEL_STATUS not in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusBetween(Byte value1, Byte value2) {
            addCriterion("DEL_STATUS between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("DEL_STATUS not between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNull() {
            addCriterion("SOURCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNotNull() {
            addCriterion("SOURCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNameEqualTo(String value) {
            addCriterion("SOURCE_NAME =", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotEqualTo(String value) {
            addCriterion("SOURCE_NAME <>", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThan(String value) {
            addCriterion("SOURCE_NAME >", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_NAME >=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThan(String value) {
            addCriterion("SOURCE_NAME <", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_NAME <=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLike(String value) {
            addCriterion("SOURCE_NAME like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotLike(String value) {
            addCriterion("SOURCE_NAME not like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameIn(List<String> values) {
            addCriterion("SOURCE_NAME in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotIn(List<String> values) {
            addCriterion("SOURCE_NAME not in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameBetween(String value1, String value2) {
            addCriterion("SOURCE_NAME between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotBetween(String value1, String value2) {
            addCriterion("SOURCE_NAME not between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("SERIAL_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("SERIAL_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(Integer value) {
            addCriterion("SERIAL_NUMBER =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(Integer value) {
            addCriterion("SERIAL_NUMBER <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(Integer value) {
            addCriterion("SERIAL_NUMBER >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERIAL_NUMBER >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(Integer value) {
            addCriterion("SERIAL_NUMBER <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("SERIAL_NUMBER <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<Integer> values) {
            addCriterion("SERIAL_NUMBER in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<Integer> values) {
            addCriterion("SERIAL_NUMBER not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(Integer value1, Integer value2) {
            addCriterion("SERIAL_NUMBER between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SERIAL_NUMBER not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
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