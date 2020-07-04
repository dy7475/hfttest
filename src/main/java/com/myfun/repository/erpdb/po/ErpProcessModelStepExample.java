package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpProcessModelStepExample extends ShardDb {
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
    public ErpProcessModelStepExample() {
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

        public Criteria andStepIdIsNull() {
            addCriterion("STEP_ID is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("STEP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(Integer value) {
            addCriterion("STEP_ID =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(Integer value) {
            addCriterion("STEP_ID <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(Integer value) {
            addCriterion("STEP_ID >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("STEP_ID >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(Integer value) {
            addCriterion("STEP_ID <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("STEP_ID <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<Integer> values) {
            addCriterion("STEP_ID in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<Integer> values) {
            addCriterion("STEP_ID not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(Integer value1, Integer value2) {
            addCriterion("STEP_ID between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("STEP_ID not between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("STEP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("STEP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("STEP_NAME =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("STEP_NAME <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("STEP_NAME >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_NAME >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("STEP_NAME <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("STEP_NAME <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("STEP_NAME like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("STEP_NAME not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("STEP_NAME in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("STEP_NAME not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("STEP_NAME between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("STEP_NAME not between", value1, value2, "stepName");
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

        public Criteria andTimelimitTypeIsNull() {
            addCriterion("TIMELIMIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeIsNotNull() {
            addCriterion("TIMELIMIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeEqualTo(Byte value) {
            addCriterion("TIMELIMIT_TYPE =", value, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeNotEqualTo(Byte value) {
            addCriterion("TIMELIMIT_TYPE <>", value, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeGreaterThan(Byte value) {
            addCriterion("TIMELIMIT_TYPE >", value, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("TIMELIMIT_TYPE >=", value, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeLessThan(Byte value) {
            addCriterion("TIMELIMIT_TYPE <", value, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeLessThanOrEqualTo(Byte value) {
            addCriterion("TIMELIMIT_TYPE <=", value, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeIn(List<Byte> values) {
            addCriterion("TIMELIMIT_TYPE in", values, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeNotIn(List<Byte> values) {
            addCriterion("TIMELIMIT_TYPE not in", values, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeBetween(Byte value1, Byte value2) {
            addCriterion("TIMELIMIT_TYPE between", value1, value2, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("TIMELIMIT_TYPE not between", value1, value2, "timelimitType");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNull() {
            addCriterion("TIMELIMIT is null");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNotNull() {
            addCriterion("TIMELIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andTimelimitEqualTo(Integer value) {
            addCriterion("TIMELIMIT =", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotEqualTo(Integer value) {
            addCriterion("TIMELIMIT <>", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThan(Integer value) {
            addCriterion("TIMELIMIT >", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("TIMELIMIT >=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThan(Integer value) {
            addCriterion("TIMELIMIT <", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThanOrEqualTo(Integer value) {
            addCriterion("TIMELIMIT <=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitIn(List<Integer> values) {
            addCriterion("TIMELIMIT in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotIn(List<Integer> values) {
            addCriterion("TIMELIMIT not in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitBetween(Integer value1, Integer value2) {
            addCriterion("TIMELIMIT between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotBetween(Integer value1, Integer value2) {
            addCriterion("TIMELIMIT not between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeIsNull() {
            addCriterion("EXECUTOR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeIsNotNull() {
            addCriterion("EXECUTOR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeEqualTo(Byte value) {
            addCriterion("EXECUTOR_TYPE =", value, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeNotEqualTo(Byte value) {
            addCriterion("EXECUTOR_TYPE <>", value, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeGreaterThan(Byte value) {
            addCriterion("EXECUTOR_TYPE >", value, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("EXECUTOR_TYPE >=", value, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeLessThan(Byte value) {
            addCriterion("EXECUTOR_TYPE <", value, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeLessThanOrEqualTo(Byte value) {
            addCriterion("EXECUTOR_TYPE <=", value, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeIn(List<Byte> values) {
            addCriterion("EXECUTOR_TYPE in", values, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeNotIn(List<Byte> values) {
            addCriterion("EXECUTOR_TYPE not in", values, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeBetween(Byte value1, Byte value2) {
            addCriterion("EXECUTOR_TYPE between", value1, value2, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("EXECUTOR_TYPE not between", value1, value2, "executorType");
            return (Criteria) this;
        }

        public Criteria andExecutorIsNull() {
            addCriterion("EXECUTOR is null");
            return (Criteria) this;
        }

        public Criteria andExecutorIsNotNull() {
            addCriterion("EXECUTOR is not null");
            return (Criteria) this;
        }

        public Criteria andExecutorEqualTo(Integer value) {
            addCriterion("EXECUTOR =", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotEqualTo(Integer value) {
            addCriterion("EXECUTOR <>", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorGreaterThan(Integer value) {
            addCriterion("EXECUTOR >", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXECUTOR >=", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLessThan(Integer value) {
            addCriterion("EXECUTOR <", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLessThanOrEqualTo(Integer value) {
            addCriterion("EXECUTOR <=", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorIn(List<Integer> values) {
            addCriterion("EXECUTOR in", values, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotIn(List<Integer> values) {
            addCriterion("EXECUTOR not in", values, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTOR between", value1, value2, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTOR not between", value1, value2, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNameIsNull() {
            addCriterion("EXECUTOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExecutorNameIsNotNull() {
            addCriterion("EXECUTOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExecutorNameEqualTo(String value) {
            addCriterion("EXECUTOR_NAME =", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameNotEqualTo(String value) {
            addCriterion("EXECUTOR_NAME <>", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameGreaterThan(String value) {
            addCriterion("EXECUTOR_NAME >", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTOR_NAME >=", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameLessThan(String value) {
            addCriterion("EXECUTOR_NAME <", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameLessThanOrEqualTo(String value) {
            addCriterion("EXECUTOR_NAME <=", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameLike(String value) {
            addCriterion("EXECUTOR_NAME like", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameNotLike(String value) {
            addCriterion("EXECUTOR_NAME not like", value, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameIn(List<String> values) {
            addCriterion("EXECUTOR_NAME in", values, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameNotIn(List<String> values) {
            addCriterion("EXECUTOR_NAME not in", values, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameBetween(String value1, String value2) {
            addCriterion("EXECUTOR_NAME between", value1, value2, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorNameNotBetween(String value1, String value2) {
            addCriterion("EXECUTOR_NAME not between", value1, value2, "executorName");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleIsNull() {
            addCriterion("EXECUTOR_ROLE is null");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleIsNotNull() {
            addCriterion("EXECUTOR_ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleEqualTo(String value) {
            addCriterion("EXECUTOR_ROLE =", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleNotEqualTo(String value) {
            addCriterion("EXECUTOR_ROLE <>", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleGreaterThan(String value) {
            addCriterion("EXECUTOR_ROLE >", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTOR_ROLE >=", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleLessThan(String value) {
            addCriterion("EXECUTOR_ROLE <", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleLessThanOrEqualTo(String value) {
            addCriterion("EXECUTOR_ROLE <=", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleLike(String value) {
            addCriterion("EXECUTOR_ROLE like", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleNotLike(String value) {
            addCriterion("EXECUTOR_ROLE not like", value, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleIn(List<String> values) {
            addCriterion("EXECUTOR_ROLE in", values, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleNotIn(List<String> values) {
            addCriterion("EXECUTOR_ROLE not in", values, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleBetween(String value1, String value2) {
            addCriterion("EXECUTOR_ROLE between", value1, value2, "executorRole");
            return (Criteria) this;
        }

        public Criteria andExecutorRoleNotBetween(String value1, String value2) {
            addCriterion("EXECUTOR_ROLE not between", value1, value2, "executorRole");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNull() {
            addCriterion("WARN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNotNull() {
            addCriterion("WARN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeEqualTo(Byte value) {
            addCriterion("WARN_TYPE =", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotEqualTo(Byte value) {
            addCriterion("WARN_TYPE <>", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThan(Byte value) {
            addCriterion("WARN_TYPE >", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("WARN_TYPE >=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThan(Byte value) {
            addCriterion("WARN_TYPE <", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThanOrEqualTo(Byte value) {
            addCriterion("WARN_TYPE <=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIn(List<Byte> values) {
            addCriterion("WARN_TYPE in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotIn(List<Byte> values) {
            addCriterion("WARN_TYPE not in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeBetween(Byte value1, Byte value2) {
            addCriterion("WARN_TYPE between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("WARN_TYPE not between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnerIsNull() {
            addCriterion("WARNER is null");
            return (Criteria) this;
        }

        public Criteria andWarnerIsNotNull() {
            addCriterion("WARNER is not null");
            return (Criteria) this;
        }

        public Criteria andWarnerEqualTo(Integer value) {
            addCriterion("WARNER =", value, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerNotEqualTo(Integer value) {
            addCriterion("WARNER <>", value, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerGreaterThan(Integer value) {
            addCriterion("WARNER >", value, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("WARNER >=", value, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerLessThan(Integer value) {
            addCriterion("WARNER <", value, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerLessThanOrEqualTo(Integer value) {
            addCriterion("WARNER <=", value, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerIn(List<Integer> values) {
            addCriterion("WARNER in", values, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerNotIn(List<Integer> values) {
            addCriterion("WARNER not in", values, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerBetween(Integer value1, Integer value2) {
            addCriterion("WARNER between", value1, value2, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerNotBetween(Integer value1, Integer value2) {
            addCriterion("WARNER not between", value1, value2, "warner");
            return (Criteria) this;
        }

        public Criteria andWarnerNameIsNull() {
            addCriterion("WARNER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWarnerNameIsNotNull() {
            addCriterion("WARNER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWarnerNameEqualTo(String value) {
            addCriterion("WARNER_NAME =", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameNotEqualTo(String value) {
            addCriterion("WARNER_NAME <>", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameGreaterThan(String value) {
            addCriterion("WARNER_NAME >", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("WARNER_NAME >=", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameLessThan(String value) {
            addCriterion("WARNER_NAME <", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameLessThanOrEqualTo(String value) {
            addCriterion("WARNER_NAME <=", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameLike(String value) {
            addCriterion("WARNER_NAME like", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameNotLike(String value) {
            addCriterion("WARNER_NAME not like", value, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameIn(List<String> values) {
            addCriterion("WARNER_NAME in", values, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameNotIn(List<String> values) {
            addCriterion("WARNER_NAME not in", values, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameBetween(String value1, String value2) {
            addCriterion("WARNER_NAME between", value1, value2, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerNameNotBetween(String value1, String value2) {
            addCriterion("WARNER_NAME not between", value1, value2, "warnerName");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleIsNull() {
            addCriterion("WARNER_ROLE is null");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleIsNotNull() {
            addCriterion("WARNER_ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleEqualTo(String value) {
            addCriterion("WARNER_ROLE =", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleNotEqualTo(String value) {
            addCriterion("WARNER_ROLE <>", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleGreaterThan(String value) {
            addCriterion("WARNER_ROLE >", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleGreaterThanOrEqualTo(String value) {
            addCriterion("WARNER_ROLE >=", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleLessThan(String value) {
            addCriterion("WARNER_ROLE <", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleLessThanOrEqualTo(String value) {
            addCriterion("WARNER_ROLE <=", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleLike(String value) {
            addCriterion("WARNER_ROLE like", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleNotLike(String value) {
            addCriterion("WARNER_ROLE not like", value, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleIn(List<String> values) {
            addCriterion("WARNER_ROLE in", values, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleNotIn(List<String> values) {
            addCriterion("WARNER_ROLE not in", values, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleBetween(String value1, String value2) {
            addCriterion("WARNER_ROLE between", value1, value2, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andWarnerRoleNotBetween(String value1, String value2) {
            addCriterion("WARNER_ROLE not between", value1, value2, "warnerRole");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNull() {
            addCriterion("IS_SYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNotNull() {
            addCriterion("IS_SYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemEqualTo(Byte value) {
            addCriterion("IS_SYSTEM =", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotEqualTo(Byte value) {
            addCriterion("IS_SYSTEM <>", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThan(Byte value) {
            addCriterion("IS_SYSTEM >", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_SYSTEM >=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThan(Byte value) {
            addCriterion("IS_SYSTEM <", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThanOrEqualTo(Byte value) {
            addCriterion("IS_SYSTEM <=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemIn(List<Byte> values) {
            addCriterion("IS_SYSTEM in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotIn(List<Byte> values) {
            addCriterion("IS_SYSTEM not in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemBetween(Byte value1, Byte value2) {
            addCriterion("IS_SYSTEM between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_SYSTEM not between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdIsNull() {
            addCriterion("RPEVSTEP_ID is null");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdIsNotNull() {
            addCriterion("RPEVSTEP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdEqualTo(Integer value) {
            addCriterion("RPEVSTEP_ID =", value, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdNotEqualTo(Integer value) {
            addCriterion("RPEVSTEP_ID <>", value, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdGreaterThan(Integer value) {
            addCriterion("RPEVSTEP_ID >", value, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RPEVSTEP_ID >=", value, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdLessThan(Integer value) {
            addCriterion("RPEVSTEP_ID <", value, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdLessThanOrEqualTo(Integer value) {
            addCriterion("RPEVSTEP_ID <=", value, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdIn(List<Integer> values) {
            addCriterion("RPEVSTEP_ID in", values, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdNotIn(List<Integer> values) {
            addCriterion("RPEVSTEP_ID not in", values, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdBetween(Integer value1, Integer value2) {
            addCriterion("RPEVSTEP_ID between", value1, value2, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RPEVSTEP_ID not between", value1, value2, "rpevstepId");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameIsNull() {
            addCriterion("RPEVSTEP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameIsNotNull() {
            addCriterion("RPEVSTEP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameEqualTo(String value) {
            addCriterion("RPEVSTEP_NAME =", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameNotEqualTo(String value) {
            addCriterion("RPEVSTEP_NAME <>", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameGreaterThan(String value) {
            addCriterion("RPEVSTEP_NAME >", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameGreaterThanOrEqualTo(String value) {
            addCriterion("RPEVSTEP_NAME >=", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameLessThan(String value) {
            addCriterion("RPEVSTEP_NAME <", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameLessThanOrEqualTo(String value) {
            addCriterion("RPEVSTEP_NAME <=", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameLike(String value) {
            addCriterion("RPEVSTEP_NAME like", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameNotLike(String value) {
            addCriterion("RPEVSTEP_NAME not like", value, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameIn(List<String> values) {
            addCriterion("RPEVSTEP_NAME in", values, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameNotIn(List<String> values) {
            addCriterion("RPEVSTEP_NAME not in", values, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameBetween(String value1, String value2) {
            addCriterion("RPEVSTEP_NAME between", value1, value2, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andRpevstepNameNotBetween(String value1, String value2) {
            addCriterion("RPEVSTEP_NAME not between", value1, value2, "rpevstepName");
            return (Criteria) this;
        }

        public Criteria andStepNoIsNull() {
            addCriterion("STEP_NO is null");
            return (Criteria) this;
        }

        public Criteria andStepNoIsNotNull() {
            addCriterion("STEP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andStepNoEqualTo(String value) {
            addCriterion("STEP_NO =", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotEqualTo(String value) {
            addCriterion("STEP_NO <>", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoGreaterThan(String value) {
            addCriterion("STEP_NO >", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_NO >=", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoLessThan(String value) {
            addCriterion("STEP_NO <", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoLessThanOrEqualTo(String value) {
            addCriterion("STEP_NO <=", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoLike(String value) {
            addCriterion("STEP_NO like", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotLike(String value) {
            addCriterion("STEP_NO not like", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoIn(List<String> values) {
            addCriterion("STEP_NO in", values, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotIn(List<String> values) {
            addCriterion("STEP_NO not in", values, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoBetween(String value1, String value2) {
            addCriterion("STEP_NO between", value1, value2, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotBetween(String value1, String value2) {
            addCriterion("STEP_NO not between", value1, value2, "stepNo");
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