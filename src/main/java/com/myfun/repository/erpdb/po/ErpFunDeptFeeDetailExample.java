package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunDeptFeeDetailExample extends ShardDb {
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
    public ErpFunDeptFeeDetailExample() {
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

        public Criteria andDeptFeeIdIsNull() {
            addCriterion("DEPT_FEE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdIsNotNull() {
            addCriterion("DEPT_FEE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdEqualTo(Integer value) {
            addCriterion("DEPT_FEE_ID =", value, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdNotEqualTo(Integer value) {
            addCriterion("DEPT_FEE_ID <>", value, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdGreaterThan(Integer value) {
            addCriterion("DEPT_FEE_ID >", value, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPT_FEE_ID >=", value, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdLessThan(Integer value) {
            addCriterion("DEPT_FEE_ID <", value, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPT_FEE_ID <=", value, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdIn(List<Integer> values) {
            addCriterion("DEPT_FEE_ID in", values, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdNotIn(List<Integer> values) {
            addCriterion("DEPT_FEE_ID not in", values, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_FEE_ID between", value1, value2, "deptFeeId");
            return (Criteria) this;
        }

        public Criteria andDeptFeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_FEE_ID not between", value1, value2, "deptFeeId");
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

        public Criteria andDeptIdIsNull() {
            addCriterion("DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("DEPT_ID =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("DEPT_ID <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("DEPT_ID >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("DEPT_ID <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("DEPT_ID in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("DEPT_ID not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andAduitStatusIsNull() {
            addCriterion("ADUIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAduitStatusIsNotNull() {
            addCriterion("ADUIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAduitStatusEqualTo(Byte value) {
            addCriterion("ADUIT_STATUS =", value, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusNotEqualTo(Byte value) {
            addCriterion("ADUIT_STATUS <>", value, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusGreaterThan(Byte value) {
            addCriterion("ADUIT_STATUS >", value, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ADUIT_STATUS >=", value, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusLessThan(Byte value) {
            addCriterion("ADUIT_STATUS <", value, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusLessThanOrEqualTo(Byte value) {
            addCriterion("ADUIT_STATUS <=", value, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusIn(List<Byte> values) {
            addCriterion("ADUIT_STATUS in", values, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusNotIn(List<Byte> values) {
            addCriterion("ADUIT_STATUS not in", values, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusBetween(Byte value1, Byte value2) {
            addCriterion("ADUIT_STATUS between", value1, value2, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ADUIT_STATUS not between", value1, value2, "aduitStatus");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdIsNull() {
            addCriterion("ADUIT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdIsNotNull() {
            addCriterion("ADUIT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdEqualTo(Integer value) {
            addCriterion("ADUIT_USER_ID =", value, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdNotEqualTo(Integer value) {
            addCriterion("ADUIT_USER_ID <>", value, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdGreaterThan(Integer value) {
            addCriterion("ADUIT_USER_ID >", value, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADUIT_USER_ID >=", value, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdLessThan(Integer value) {
            addCriterion("ADUIT_USER_ID <", value, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("ADUIT_USER_ID <=", value, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdIn(List<Integer> values) {
            addCriterion("ADUIT_USER_ID in", values, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdNotIn(List<Integer> values) {
            addCriterion("ADUIT_USER_ID not in", values, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdBetween(Integer value1, Integer value2) {
            addCriterion("ADUIT_USER_ID between", value1, value2, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ADUIT_USER_ID not between", value1, value2, "aduitUserId");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameIsNull() {
            addCriterion("ADUIT_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameIsNotNull() {
            addCriterion("ADUIT_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameEqualTo(String value) {
            addCriterion("ADUIT_USER_NAME =", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameNotEqualTo(String value) {
            addCriterion("ADUIT_USER_NAME <>", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameGreaterThan(String value) {
            addCriterion("ADUIT_USER_NAME >", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("ADUIT_USER_NAME >=", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameLessThan(String value) {
            addCriterion("ADUIT_USER_NAME <", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameLessThanOrEqualTo(String value) {
            addCriterion("ADUIT_USER_NAME <=", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameLike(String value) {
            addCriterion("ADUIT_USER_NAME like", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameNotLike(String value) {
            addCriterion("ADUIT_USER_NAME not like", value, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameIn(List<String> values) {
            addCriterion("ADUIT_USER_NAME in", values, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameNotIn(List<String> values) {
            addCriterion("ADUIT_USER_NAME not in", values, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameBetween(String value1, String value2) {
            addCriterion("ADUIT_USER_NAME between", value1, value2, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andAduitUserNameNotBetween(String value1, String value2) {
            addCriterion("ADUIT_USER_NAME not between", value1, value2, "aduitUserName");
            return (Criteria) this;
        }

        public Criteria andCountTimeIsNull() {
            addCriterion("COUNT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCountTimeIsNotNull() {
            addCriterion("COUNT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCountTimeEqualTo(Date value) {
            addCriterion("COUNT_TIME =", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotEqualTo(Date value) {
            addCriterion("COUNT_TIME <>", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeGreaterThan(Date value) {
            addCriterion("COUNT_TIME >", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("COUNT_TIME >=", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeLessThan(Date value) {
            addCriterion("COUNT_TIME <", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeLessThanOrEqualTo(Date value) {
            addCriterion("COUNT_TIME <=", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeIn(List<Date> values) {
            addCriterion("COUNT_TIME in", values, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotIn(List<Date> values) {
            addCriterion("COUNT_TIME not in", values, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeBetween(Date value1, Date value2) {
            addCriterion("COUNT_TIME between", value1, value2, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotBetween(Date value1, Date value2) {
            addCriterion("COUNT_TIME not between", value1, value2, "countTime");
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