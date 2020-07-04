package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FunPerforManceTypeExample extends ShardDb {
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
    public FunPerforManceTypeExample() {
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

        public Criteria andPerformanceIdIsNull() {
            addCriterion("PERFORMANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdIsNotNull() {
            addCriterion("PERFORMANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID =", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID <>", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdGreaterThan(Integer value) {
            addCriterion("PERFORMANCE_ID >", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID >=", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdLessThan(Integer value) {
            addCriterion("PERFORMANCE_ID <", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID <=", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdIn(List<Integer> values) {
            addCriterion("PERFORMANCE_ID in", values, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotIn(List<Integer> values) {
            addCriterion("PERFORMANCE_ID not in", values, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_ID between", value1, value2, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_ID not between", value1, value2, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameIsNull() {
            addCriterion("PERFORMANCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameIsNotNull() {
            addCriterion("PERFORMANCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME =", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME <>", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameGreaterThan(String value) {
            addCriterion("PERFORMANCE_NAME >", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME >=", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameLessThan(String value) {
            addCriterion("PERFORMANCE_NAME <", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameLessThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME <=", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameLike(String value) {
            addCriterion("PERFORMANCE_NAME like", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotLike(String value) {
            addCriterion("PERFORMANCE_NAME not like", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameIn(List<String> values) {
            addCriterion("PERFORMANCE_NAME in", values, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotIn(List<String> values) {
            addCriterion("PERFORMANCE_NAME not in", values, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_NAME between", value1, value2, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_NAME not between", value1, value2, "performanceName");
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

        public Criteria andIsDelIsNull() {
            addCriterion("IS_DEL is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("IS_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Byte value) {
            addCriterion("IS_DEL =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Byte value) {
            addCriterion("IS_DEL <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Byte value) {
            addCriterion("IS_DEL >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_DEL >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Byte value) {
            addCriterion("IS_DEL <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Byte value) {
            addCriterion("IS_DEL <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Byte> values) {
            addCriterion("IS_DEL in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Byte> values) {
            addCriterion("IS_DEL not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEL between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEL not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andCanDelIsNull() {
            addCriterion("CAN_DEL is null");
            return (Criteria) this;
        }

        public Criteria andCanDelIsNotNull() {
            addCriterion("CAN_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andCanDelEqualTo(Integer value) {
            addCriterion("CAN_DEL =", value, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelNotEqualTo(Integer value) {
            addCriterion("CAN_DEL <>", value, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelGreaterThan(Integer value) {
            addCriterion("CAN_DEL >", value, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAN_DEL >=", value, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelLessThan(Integer value) {
            addCriterion("CAN_DEL <", value, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelLessThanOrEqualTo(Integer value) {
            addCriterion("CAN_DEL <=", value, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelIn(List<Integer> values) {
            addCriterion("CAN_DEL in", values, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelNotIn(List<Integer> values) {
            addCriterion("CAN_DEL not in", values, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelBetween(Integer value1, Integer value2) {
            addCriterion("CAN_DEL between", value1, value2, "canDel");
            return (Criteria) this;
        }

        public Criteria andCanDelNotBetween(Integer value1, Integer value2) {
            addCriterion("CAN_DEL not between", value1, value2, "canDel");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionIsNull() {
            addCriterion("PERFORMANCE_PROPORTION is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionIsNotNull() {
            addCriterion("PERFORMANCE_PROPORTION is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_PROPORTION =", value, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionNotEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_PROPORTION <>", value, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionGreaterThan(BigDecimal value) {
            addCriterion("PERFORMANCE_PROPORTION >", value, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_PROPORTION >=", value, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionLessThan(BigDecimal value) {
            addCriterion("PERFORMANCE_PROPORTION <", value, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_PROPORTION <=", value, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionIn(List<BigDecimal> values) {
            addCriterion("PERFORMANCE_PROPORTION in", values, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionNotIn(List<BigDecimal> values) {
            addCriterion("PERFORMANCE_PROPORTION not in", values, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERFORMANCE_PROPORTION between", value1, value2, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andPerformanceProportionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERFORMANCE_PROPORTION not between", value1, value2, "performanceProportion");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNull() {
            addCriterion("IS_AUTO is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNotNull() {
            addCriterion("IS_AUTO is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoEqualTo(Byte value) {
            addCriterion("IS_AUTO =", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotEqualTo(Byte value) {
            addCriterion("IS_AUTO <>", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThan(Byte value) {
            addCriterion("IS_AUTO >", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_AUTO >=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThan(Byte value) {
            addCriterion("IS_AUTO <", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThanOrEqualTo(Byte value) {
            addCriterion("IS_AUTO <=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoIn(List<Byte> values) {
            addCriterion("IS_AUTO in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotIn(List<Byte> values) {
            addCriterion("IS_AUTO not in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoBetween(Byte value1, Byte value2) {
            addCriterion("IS_AUTO between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_AUTO not between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andEnMsgIsNull() {
            addCriterion("EN_MSG is null");
            return (Criteria) this;
        }

        public Criteria andEnMsgIsNotNull() {
            addCriterion("EN_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andEnMsgEqualTo(String value) {
            addCriterion("EN_MSG =", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgNotEqualTo(String value) {
            addCriterion("EN_MSG <>", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgGreaterThan(String value) {
            addCriterion("EN_MSG >", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgGreaterThanOrEqualTo(String value) {
            addCriterion("EN_MSG >=", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgLessThan(String value) {
            addCriterion("EN_MSG <", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgLessThanOrEqualTo(String value) {
            addCriterion("EN_MSG <=", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgLike(String value) {
            addCriterion("EN_MSG like", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgNotLike(String value) {
            addCriterion("EN_MSG not like", value, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgIn(List<String> values) {
            addCriterion("EN_MSG in", values, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgNotIn(List<String> values) {
            addCriterion("EN_MSG not in", values, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgBetween(String value1, String value2) {
            addCriterion("EN_MSG between", value1, value2, "enMsg");
            return (Criteria) this;
        }

        public Criteria andEnMsgNotBetween(String value1, String value2) {
            addCriterion("EN_MSG not between", value1, value2, "enMsg");
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