package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceExtraExample extends ShardDb {
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
    public ErpFunAttendanceExtraExample() {
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

        public Criteria andAttExtraIdIsNull() {
            addCriterion("ATT_EXTRA_ID is null");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdIsNotNull() {
            addCriterion("ATT_EXTRA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdEqualTo(Integer value) {
            addCriterion("ATT_EXTRA_ID =", value, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdNotEqualTo(Integer value) {
            addCriterion("ATT_EXTRA_ID <>", value, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdGreaterThan(Integer value) {
            addCriterion("ATT_EXTRA_ID >", value, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATT_EXTRA_ID >=", value, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdLessThan(Integer value) {
            addCriterion("ATT_EXTRA_ID <", value, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdLessThanOrEqualTo(Integer value) {
            addCriterion("ATT_EXTRA_ID <=", value, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdIn(List<Integer> values) {
            addCriterion("ATT_EXTRA_ID in", values, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdNotIn(List<Integer> values) {
            addCriterion("ATT_EXTRA_ID not in", values, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdBetween(Integer value1, Integer value2) {
            addCriterion("ATT_EXTRA_ID between", value1, value2, "attExtraId");
            return (Criteria) this;
        }

        public Criteria andAttExtraIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ATT_EXTRA_ID not between", value1, value2, "attExtraId");
            return (Criteria) this;
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

        public Criteria andFilePathIsNull() {
            addCriterion("FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FILE_PATH =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FILE_PATH <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FILE_PATH >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_PATH >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("FILE_PATH <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FILE_PATH <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("FILE_PATH like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("FILE_PATH not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FILE_PATH in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FILE_PATH not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FILE_PATH between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FILE_PATH not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andResultfulIsNull() {
            addCriterion("RESULTFUL is null");
            return (Criteria) this;
        }

        public Criteria andResultfulIsNotNull() {
            addCriterion("RESULTFUL is not null");
            return (Criteria) this;
        }

        public Criteria andResultfulEqualTo(Byte value) {
            addCriterion("RESULTFUL =", value, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulNotEqualTo(Byte value) {
            addCriterion("RESULTFUL <>", value, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulGreaterThan(Byte value) {
            addCriterion("RESULTFUL >", value, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulGreaterThanOrEqualTo(Byte value) {
            addCriterion("RESULTFUL >=", value, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulLessThan(Byte value) {
            addCriterion("RESULTFUL <", value, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulLessThanOrEqualTo(Byte value) {
            addCriterion("RESULTFUL <=", value, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulIn(List<Byte> values) {
            addCriterion("RESULTFUL in", values, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulNotIn(List<Byte> values) {
            addCriterion("RESULTFUL not in", values, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulBetween(Byte value1, Byte value2) {
            addCriterion("RESULTFUL between", value1, value2, "resultful");
            return (Criteria) this;
        }

        public Criteria andResultfulNotBetween(Byte value1, Byte value2) {
            addCriterion("RESULTFUL not between", value1, value2, "resultful");
            return (Criteria) this;
        }

        public Criteria andExtraTypeIsNull() {
            addCriterion("EXTRA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExtraTypeIsNotNull() {
            addCriterion("EXTRA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExtraTypeEqualTo(Integer value) {
            addCriterion("EXTRA_TYPE =", value, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeNotEqualTo(Integer value) {
            addCriterion("EXTRA_TYPE <>", value, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeGreaterThan(Integer value) {
            addCriterion("EXTRA_TYPE >", value, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXTRA_TYPE >=", value, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeLessThan(Integer value) {
            addCriterion("EXTRA_TYPE <", value, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeLessThanOrEqualTo(Integer value) {
            addCriterion("EXTRA_TYPE <=", value, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeIn(List<Integer> values) {
            addCriterion("EXTRA_TYPE in", values, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeNotIn(List<Integer> values) {
            addCriterion("EXTRA_TYPE not in", values, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeBetween(Integer value1, Integer value2) {
            addCriterion("EXTRA_TYPE between", value1, value2, "extraType");
            return (Criteria) this;
        }

        public Criteria andExtraTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("EXTRA_TYPE not between", value1, value2, "extraType");
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