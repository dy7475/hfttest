package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminSosoBuildingPhotoFastdfsExample {
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
    public AdminSosoBuildingPhotoFastdfsExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("PHOTO_ID is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("PHOTO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(Integer value) {
            addCriterion("PHOTO_ID =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(Integer value) {
            addCriterion("PHOTO_ID <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(Integer value) {
            addCriterion("PHOTO_ID >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PHOTO_ID >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(Integer value) {
            addCriterion("PHOTO_ID <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(Integer value) {
            addCriterion("PHOTO_ID <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<Integer> values) {
            addCriterion("PHOTO_ID in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<Integer> values) {
            addCriterion("PHOTO_ID not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(Integer value1, Integer value2) {
            addCriterion("PHOTO_ID between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PHOTO_ID not between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrIsNull() {
            addCriterion("PHOTO_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrIsNotNull() {
            addCriterion("PHOTO_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrEqualTo(String value) {
            addCriterion("PHOTO_ADDR =", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrNotEqualTo(String value) {
            addCriterion("PHOTO_ADDR <>", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrGreaterThan(String value) {
            addCriterion("PHOTO_ADDR >", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO_ADDR >=", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrLessThan(String value) {
            addCriterion("PHOTO_ADDR <", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrLessThanOrEqualTo(String value) {
            addCriterion("PHOTO_ADDR <=", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrLike(String value) {
            addCriterion("PHOTO_ADDR like", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrNotLike(String value) {
            addCriterion("PHOTO_ADDR not like", value, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrIn(List<String> values) {
            addCriterion("PHOTO_ADDR in", values, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrNotIn(List<String> values) {
            addCriterion("PHOTO_ADDR not in", values, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrBetween(String value1, String value2) {
            addCriterion("PHOTO_ADDR between", value1, value2, "photoAddr");
            return (Criteria) this;
        }

        public Criteria andPhotoAddrNotBetween(String value1, String value2) {
            addCriterion("PHOTO_ADDR not between", value1, value2, "photoAddr");
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

        public Criteria andOldAddrIsNull() {
            addCriterion("OLD_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andOldAddrIsNotNull() {
            addCriterion("OLD_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andOldAddrEqualTo(String value) {
            addCriterion("OLD_ADDR =", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotEqualTo(String value) {
            addCriterion("OLD_ADDR <>", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrGreaterThan(String value) {
            addCriterion("OLD_ADDR >", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_ADDR >=", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrLessThan(String value) {
            addCriterion("OLD_ADDR <", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrLessThanOrEqualTo(String value) {
            addCriterion("OLD_ADDR <=", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrLike(String value) {
            addCriterion("OLD_ADDR like", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotLike(String value) {
            addCriterion("OLD_ADDR not like", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrIn(List<String> values) {
            addCriterion("OLD_ADDR in", values, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotIn(List<String> values) {
            addCriterion("OLD_ADDR not in", values, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrBetween(String value1, String value2) {
            addCriterion("OLD_ADDR between", value1, value2, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotBetween(String value1, String value2) {
            addCriterion("OLD_ADDR not between", value1, value2, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNull() {
            addCriterion("IS_DEAL is null");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNotNull() {
            addCriterion("IS_DEAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealEqualTo(Byte value) {
            addCriterion("IS_DEAL =", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotEqualTo(Byte value) {
            addCriterion("IS_DEAL <>", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThan(Byte value) {
            addCriterion("IS_DEAL >", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_DEAL >=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThan(Byte value) {
            addCriterion("IS_DEAL <", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThanOrEqualTo(Byte value) {
            addCriterion("IS_DEAL <=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealIn(List<Byte> values) {
            addCriterion("IS_DEAL in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotIn(List<Byte> values) {
            addCriterion("IS_DEAL not in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEAL between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEAL not between", value1, value2, "isDeal");
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