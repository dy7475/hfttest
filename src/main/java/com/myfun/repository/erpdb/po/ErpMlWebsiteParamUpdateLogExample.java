package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpMlWebsiteParamUpdateLogExample extends ShardDb {
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
    public ErpMlWebsiteParamUpdateLogExample() {
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

        public Criteria andUpdateParamIdIsNull() {
            addCriterion("UPDATE_PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdIsNotNull() {
            addCriterion("UPDATE_PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdEqualTo(String value) {
            addCriterion("UPDATE_PARAM_ID =", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdNotEqualTo(String value) {
            addCriterion("UPDATE_PARAM_ID <>", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdGreaterThan(String value) {
            addCriterion("UPDATE_PARAM_ID >", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_PARAM_ID >=", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdLessThan(String value) {
            addCriterion("UPDATE_PARAM_ID <", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_PARAM_ID <=", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdLike(String value) {
            addCriterion("UPDATE_PARAM_ID like", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdNotLike(String value) {
            addCriterion("UPDATE_PARAM_ID not like", value, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdIn(List<String> values) {
            addCriterion("UPDATE_PARAM_ID in", values, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdNotIn(List<String> values) {
            addCriterion("UPDATE_PARAM_ID not in", values, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdBetween(String value1, String value2) {
            addCriterion("UPDATE_PARAM_ID between", value1, value2, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateParamIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_PARAM_ID not between", value1, value2, "updateParamId");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(String value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(String value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(String value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(String value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLike(String value) {
            addCriterion("UPDATE_DATE like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotLike(String value) {
            addCriterion("UPDATE_DATE not like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<String> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<String> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(String value1, String value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(String value1, String value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
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

        public Criteria andTaskUpdateIsNull() {
            addCriterion("TASK_UPDATE is null");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateIsNotNull() {
            addCriterion("TASK_UPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateEqualTo(Byte value) {
            addCriterion("TASK_UPDATE =", value, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateNotEqualTo(Byte value) {
            addCriterion("TASK_UPDATE <>", value, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateGreaterThan(Byte value) {
            addCriterion("TASK_UPDATE >", value, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateGreaterThanOrEqualTo(Byte value) {
            addCriterion("TASK_UPDATE >=", value, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateLessThan(Byte value) {
            addCriterion("TASK_UPDATE <", value, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateLessThanOrEqualTo(Byte value) {
            addCriterion("TASK_UPDATE <=", value, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateIn(List<Byte> values) {
            addCriterion("TASK_UPDATE in", values, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateNotIn(List<Byte> values) {
            addCriterion("TASK_UPDATE not in", values, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateBetween(Byte value1, Byte value2) {
            addCriterion("TASK_UPDATE between", value1, value2, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateNotBetween(Byte value1, Byte value2) {
            addCriterion("TASK_UPDATE not between", value1, value2, "taskUpdate");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeIsNull() {
            addCriterion("TASK_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeIsNotNull() {
            addCriterion("TASK_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeEqualTo(Date value) {
            addCriterion("TASK_UPDATE_TIME =", value, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeNotEqualTo(Date value) {
            addCriterion("TASK_UPDATE_TIME <>", value, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeGreaterThan(Date value) {
            addCriterion("TASK_UPDATE_TIME >", value, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_UPDATE_TIME >=", value, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeLessThan(Date value) {
            addCriterion("TASK_UPDATE_TIME <", value, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("TASK_UPDATE_TIME <=", value, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeIn(List<Date> values) {
            addCriterion("TASK_UPDATE_TIME in", values, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeNotIn(List<Date> values) {
            addCriterion("TASK_UPDATE_TIME not in", values, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("TASK_UPDATE_TIME between", value1, value2, "taskUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("TASK_UPDATE_TIME not between", value1, value2, "taskUpdateTime");
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