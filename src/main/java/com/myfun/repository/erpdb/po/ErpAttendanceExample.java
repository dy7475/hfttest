package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAttendanceExample extends ShardDb {
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
    public ErpAttendanceExample() {
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

        public Criteria andAttIdIsNull() {
            addCriterion("ATT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAttIdIsNotNull() {
            addCriterion("ATT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAttIdEqualTo(Integer value) {
            addCriterion("ATT_ID =", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdNotEqualTo(Integer value) {
            addCriterion("ATT_ID <>", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdGreaterThan(Integer value) {
            addCriterion("ATT_ID >", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATT_ID >=", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdLessThan(Integer value) {
            addCriterion("ATT_ID <", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdLessThanOrEqualTo(Integer value) {
            addCriterion("ATT_ID <=", value, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdIn(List<Integer> values) {
            addCriterion("ATT_ID in", values, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdNotIn(List<Integer> values) {
            addCriterion("ATT_ID not in", values, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdBetween(Integer value1, Integer value2) {
            addCriterion("ATT_ID between", value1, value2, "attId");
            return (Criteria) this;
        }

        public Criteria andAttIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ATT_ID not between", value1, value2, "attId");
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

        public Criteria andAttUserIsNull() {
            addCriterion("ATT_USER is null");
            return (Criteria) this;
        }

        public Criteria andAttUserIsNotNull() {
            addCriterion("ATT_USER is not null");
            return (Criteria) this;
        }

        public Criteria andAttUserEqualTo(Integer value) {
            addCriterion("ATT_USER =", value, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserNotEqualTo(Integer value) {
            addCriterion("ATT_USER <>", value, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserGreaterThan(Integer value) {
            addCriterion("ATT_USER >", value, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATT_USER >=", value, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserLessThan(Integer value) {
            addCriterion("ATT_USER <", value, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserLessThanOrEqualTo(Integer value) {
            addCriterion("ATT_USER <=", value, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserIn(List<Integer> values) {
            addCriterion("ATT_USER in", values, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserNotIn(List<Integer> values) {
            addCriterion("ATT_USER not in", values, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserBetween(Integer value1, Integer value2) {
            addCriterion("ATT_USER between", value1, value2, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttUserNotBetween(Integer value1, Integer value2) {
            addCriterion("ATT_USER not between", value1, value2, "attUser");
            return (Criteria) this;
        }

        public Criteria andAttDateIsNull() {
            addCriterion("ATT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAttDateIsNotNull() {
            addCriterion("ATT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAttDateEqualTo(String value) {
            addCriterion("ATT_DATE =", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateNotEqualTo(String value) {
            addCriterion("ATT_DATE <>", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateGreaterThan(String value) {
            addCriterion("ATT_DATE >", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateGreaterThanOrEqualTo(String value) {
            addCriterion("ATT_DATE >=", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateLessThan(String value) {
            addCriterion("ATT_DATE <", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateLessThanOrEqualTo(String value) {
            addCriterion("ATT_DATE <=", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateLike(String value) {
            addCriterion("ATT_DATE like", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateNotLike(String value) {
            addCriterion("ATT_DATE not like", value, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateIn(List<String> values) {
            addCriterion("ATT_DATE in", values, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateNotIn(List<String> values) {
            addCriterion("ATT_DATE not in", values, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateBetween(String value1, String value2) {
            addCriterion("ATT_DATE between", value1, value2, "attDate");
            return (Criteria) this;
        }

        public Criteria andAttDateNotBetween(String value1, String value2) {
            addCriterion("ATT_DATE not between", value1, value2, "attDate");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeIsNull() {
            addCriterion("WORK_ON_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeIsNotNull() {
            addCriterion("WORK_ON_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeEqualTo(Byte value) {
            addCriterion("WORK_ON_TYPE =", value, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeNotEqualTo(Byte value) {
            addCriterion("WORK_ON_TYPE <>", value, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeGreaterThan(Byte value) {
            addCriterion("WORK_ON_TYPE >", value, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("WORK_ON_TYPE >=", value, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeLessThan(Byte value) {
            addCriterion("WORK_ON_TYPE <", value, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeLessThanOrEqualTo(Byte value) {
            addCriterion("WORK_ON_TYPE <=", value, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeIn(List<Byte> values) {
            addCriterion("WORK_ON_TYPE in", values, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeNotIn(List<Byte> values) {
            addCriterion("WORK_ON_TYPE not in", values, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeBetween(Byte value1, Byte value2) {
            addCriterion("WORK_ON_TYPE between", value1, value2, "workOnType");
            return (Criteria) this;
        }

        public Criteria andWorkOnTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("WORK_ON_TYPE not between", value1, value2, "workOnType");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusIsNull() {
            addCriterion("ATT_ON_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusIsNotNull() {
            addCriterion("ATT_ON_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusEqualTo(Byte value) {
            addCriterion("ATT_ON_STATUS =", value, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusNotEqualTo(Byte value) {
            addCriterion("ATT_ON_STATUS <>", value, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusGreaterThan(Byte value) {
            addCriterion("ATT_ON_STATUS >", value, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ATT_ON_STATUS >=", value, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusLessThan(Byte value) {
            addCriterion("ATT_ON_STATUS <", value, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusLessThanOrEqualTo(Byte value) {
            addCriterion("ATT_ON_STATUS <=", value, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusIn(List<Byte> values) {
            addCriterion("ATT_ON_STATUS in", values, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusNotIn(List<Byte> values) {
            addCriterion("ATT_ON_STATUS not in", values, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusBetween(Byte value1, Byte value2) {
            addCriterion("ATT_ON_STATUS between", value1, value2, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ATT_ON_STATUS not between", value1, value2, "attOnStatus");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeIsNull() {
            addCriterion("ATT_ON_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeIsNotNull() {
            addCriterion("ATT_ON_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeEqualTo(String value) {
            addCriterion("ATT_ON_TIME =", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeNotEqualTo(String value) {
            addCriterion("ATT_ON_TIME <>", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeGreaterThan(String value) {
            addCriterion("ATT_ON_TIME >", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ATT_ON_TIME >=", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeLessThan(String value) {
            addCriterion("ATT_ON_TIME <", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeLessThanOrEqualTo(String value) {
            addCriterion("ATT_ON_TIME <=", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeLike(String value) {
            addCriterion("ATT_ON_TIME like", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeNotLike(String value) {
            addCriterion("ATT_ON_TIME not like", value, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeIn(List<String> values) {
            addCriterion("ATT_ON_TIME in", values, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeNotIn(List<String> values) {
            addCriterion("ATT_ON_TIME not in", values, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeBetween(String value1, String value2) {
            addCriterion("ATT_ON_TIME between", value1, value2, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttOnTimeNotBetween(String value1, String value2) {
            addCriterion("ATT_ON_TIME not between", value1, value2, "attOnTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeIsNull() {
            addCriterion("ATT_LATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeIsNotNull() {
            addCriterion("ATT_LATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeEqualTo(Integer value) {
            addCriterion("ATT_LATE_TIME =", value, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeNotEqualTo(Integer value) {
            addCriterion("ATT_LATE_TIME <>", value, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeGreaterThan(Integer value) {
            addCriterion("ATT_LATE_TIME >", value, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATT_LATE_TIME >=", value, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeLessThan(Integer value) {
            addCriterion("ATT_LATE_TIME <", value, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("ATT_LATE_TIME <=", value, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeIn(List<Integer> values) {
            addCriterion("ATT_LATE_TIME in", values, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeNotIn(List<Integer> values) {
            addCriterion("ATT_LATE_TIME not in", values, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeBetween(Integer value1, Integer value2) {
            addCriterion("ATT_LATE_TIME between", value1, value2, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ATT_LATE_TIME not between", value1, value2, "attLateTime");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonIsNull() {
            addCriterion("ATT_LATE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonIsNotNull() {
            addCriterion("ATT_LATE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonEqualTo(String value) {
            addCriterion("ATT_LATE_REASON =", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonNotEqualTo(String value) {
            addCriterion("ATT_LATE_REASON <>", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonGreaterThan(String value) {
            addCriterion("ATT_LATE_REASON >", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ATT_LATE_REASON >=", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonLessThan(String value) {
            addCriterion("ATT_LATE_REASON <", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonLessThanOrEqualTo(String value) {
            addCriterion("ATT_LATE_REASON <=", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonLike(String value) {
            addCriterion("ATT_LATE_REASON like", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonNotLike(String value) {
            addCriterion("ATT_LATE_REASON not like", value, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonIn(List<String> values) {
            addCriterion("ATT_LATE_REASON in", values, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonNotIn(List<String> values) {
            addCriterion("ATT_LATE_REASON not in", values, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonBetween(String value1, String value2) {
            addCriterion("ATT_LATE_REASON between", value1, value2, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andAttLateReasonNotBetween(String value1, String value2) {
            addCriterion("ATT_LATE_REASON not between", value1, value2, "attLateReason");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeIsNull() {
            addCriterion("WORK_OFF_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeIsNotNull() {
            addCriterion("WORK_OFF_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeEqualTo(Byte value) {
            addCriterion("WORK_OFF_TYPE =", value, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeNotEqualTo(Byte value) {
            addCriterion("WORK_OFF_TYPE <>", value, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeGreaterThan(Byte value) {
            addCriterion("WORK_OFF_TYPE >", value, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("WORK_OFF_TYPE >=", value, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeLessThan(Byte value) {
            addCriterion("WORK_OFF_TYPE <", value, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeLessThanOrEqualTo(Byte value) {
            addCriterion("WORK_OFF_TYPE <=", value, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeIn(List<Byte> values) {
            addCriterion("WORK_OFF_TYPE in", values, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeNotIn(List<Byte> values) {
            addCriterion("WORK_OFF_TYPE not in", values, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeBetween(Byte value1, Byte value2) {
            addCriterion("WORK_OFF_TYPE between", value1, value2, "workOffType");
            return (Criteria) this;
        }

        public Criteria andWorkOffTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("WORK_OFF_TYPE not between", value1, value2, "workOffType");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusIsNull() {
            addCriterion("ATT_OFF_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusIsNotNull() {
            addCriterion("ATT_OFF_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusEqualTo(Byte value) {
            addCriterion("ATT_OFF_STATUS =", value, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusNotEqualTo(Byte value) {
            addCriterion("ATT_OFF_STATUS <>", value, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusGreaterThan(Byte value) {
            addCriterion("ATT_OFF_STATUS >", value, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ATT_OFF_STATUS >=", value, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusLessThan(Byte value) {
            addCriterion("ATT_OFF_STATUS <", value, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusLessThanOrEqualTo(Byte value) {
            addCriterion("ATT_OFF_STATUS <=", value, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusIn(List<Byte> values) {
            addCriterion("ATT_OFF_STATUS in", values, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusNotIn(List<Byte> values) {
            addCriterion("ATT_OFF_STATUS not in", values, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusBetween(Byte value1, Byte value2) {
            addCriterion("ATT_OFF_STATUS between", value1, value2, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ATT_OFF_STATUS not between", value1, value2, "attOffStatus");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeIsNull() {
            addCriterion("ATT_OFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeIsNotNull() {
            addCriterion("ATT_OFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeEqualTo(String value) {
            addCriterion("ATT_OFF_TIME =", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeNotEqualTo(String value) {
            addCriterion("ATT_OFF_TIME <>", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeGreaterThan(String value) {
            addCriterion("ATT_OFF_TIME >", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ATT_OFF_TIME >=", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeLessThan(String value) {
            addCriterion("ATT_OFF_TIME <", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeLessThanOrEqualTo(String value) {
            addCriterion("ATT_OFF_TIME <=", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeLike(String value) {
            addCriterion("ATT_OFF_TIME like", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeNotLike(String value) {
            addCriterion("ATT_OFF_TIME not like", value, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeIn(List<String> values) {
            addCriterion("ATT_OFF_TIME in", values, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeNotIn(List<String> values) {
            addCriterion("ATT_OFF_TIME not in", values, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeBetween(String value1, String value2) {
            addCriterion("ATT_OFF_TIME between", value1, value2, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttOffTimeNotBetween(String value1, String value2) {
            addCriterion("ATT_OFF_TIME not between", value1, value2, "attOffTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeIsNull() {
            addCriterion("ATT_EARLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeIsNotNull() {
            addCriterion("ATT_EARLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeEqualTo(Integer value) {
            addCriterion("ATT_EARLY_TIME =", value, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeNotEqualTo(Integer value) {
            addCriterion("ATT_EARLY_TIME <>", value, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeGreaterThan(Integer value) {
            addCriterion("ATT_EARLY_TIME >", value, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATT_EARLY_TIME >=", value, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeLessThan(Integer value) {
            addCriterion("ATT_EARLY_TIME <", value, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeLessThanOrEqualTo(Integer value) {
            addCriterion("ATT_EARLY_TIME <=", value, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeIn(List<Integer> values) {
            addCriterion("ATT_EARLY_TIME in", values, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeNotIn(List<Integer> values) {
            addCriterion("ATT_EARLY_TIME not in", values, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeBetween(Integer value1, Integer value2) {
            addCriterion("ATT_EARLY_TIME between", value1, value2, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ATT_EARLY_TIME not between", value1, value2, "attEarlyTime");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonIsNull() {
            addCriterion("ATT_EARLY_REASON is null");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonIsNotNull() {
            addCriterion("ATT_EARLY_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonEqualTo(String value) {
            addCriterion("ATT_EARLY_REASON =", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonNotEqualTo(String value) {
            addCriterion("ATT_EARLY_REASON <>", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonGreaterThan(String value) {
            addCriterion("ATT_EARLY_REASON >", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ATT_EARLY_REASON >=", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonLessThan(String value) {
            addCriterion("ATT_EARLY_REASON <", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonLessThanOrEqualTo(String value) {
            addCriterion("ATT_EARLY_REASON <=", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonLike(String value) {
            addCriterion("ATT_EARLY_REASON like", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonNotLike(String value) {
            addCriterion("ATT_EARLY_REASON not like", value, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonIn(List<String> values) {
            addCriterion("ATT_EARLY_REASON in", values, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonNotIn(List<String> values) {
            addCriterion("ATT_EARLY_REASON not in", values, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonBetween(String value1, String value2) {
            addCriterion("ATT_EARLY_REASON between", value1, value2, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andAttEarlyReasonNotBetween(String value1, String value2) {
            addCriterion("ATT_EARLY_REASON not between", value1, value2, "attEarlyReason");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
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

        public Criteria andCreateWorkonUserIsNull() {
            addCriterion("CREATE_WORKON_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserIsNotNull() {
            addCriterion("CREATE_WORKON_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserEqualTo(Integer value) {
            addCriterion("CREATE_WORKON_USER =", value, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserNotEqualTo(Integer value) {
            addCriterion("CREATE_WORKON_USER <>", value, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserGreaterThan(Integer value) {
            addCriterion("CREATE_WORKON_USER >", value, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATE_WORKON_USER >=", value, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserLessThan(Integer value) {
            addCriterion("CREATE_WORKON_USER <", value, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserLessThanOrEqualTo(Integer value) {
            addCriterion("CREATE_WORKON_USER <=", value, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserIn(List<Integer> values) {
            addCriterion("CREATE_WORKON_USER in", values, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserNotIn(List<Integer> values) {
            addCriterion("CREATE_WORKON_USER not in", values, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_WORKON_USER between", value1, value2, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkonUserNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_WORKON_USER not between", value1, value2, "createWorkonUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserIsNull() {
            addCriterion("CREATE_WORKOFF_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserIsNotNull() {
            addCriterion("CREATE_WORKOFF_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserEqualTo(Integer value) {
            addCriterion("CREATE_WORKOFF_USER =", value, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserNotEqualTo(Integer value) {
            addCriterion("CREATE_WORKOFF_USER <>", value, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserGreaterThan(Integer value) {
            addCriterion("CREATE_WORKOFF_USER >", value, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATE_WORKOFF_USER >=", value, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserLessThan(Integer value) {
            addCriterion("CREATE_WORKOFF_USER <", value, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserLessThanOrEqualTo(Integer value) {
            addCriterion("CREATE_WORKOFF_USER <=", value, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserIn(List<Integer> values) {
            addCriterion("CREATE_WORKOFF_USER in", values, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserNotIn(List<Integer> values) {
            addCriterion("CREATE_WORKOFF_USER not in", values, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_WORKOFF_USER between", value1, value2, "createWorkoffUser");
            return (Criteria) this;
        }

        public Criteria andCreateWorkoffUserNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_WORKOFF_USER not between", value1, value2, "createWorkoffUser");
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