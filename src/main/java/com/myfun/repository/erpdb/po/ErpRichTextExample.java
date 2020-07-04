package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpRichTextExample extends ShardDb {
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
    public ErpRichTextExample() {
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

        public Criteria andSaleLeaseIsNull() {
            addCriterion("sale_lease is null");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIsNotNull() {
            addCriterion("sale_lease is not null");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseEqualTo(Integer value) {
            addCriterion("sale_lease =", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotEqualTo(Integer value) {
            addCriterion("sale_lease <>", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThan(Integer value) {
            addCriterion("sale_lease >", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_lease >=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThan(Integer value) {
            addCriterion("sale_lease <", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThanOrEqualTo(Integer value) {
            addCriterion("sale_lease <=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIn(List<Integer> values) {
            addCriterion("sale_lease in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotIn(List<Integer> values) {
            addCriterion("sale_lease not in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseBetween(Integer value1, Integer value2) {
            addCriterion("sale_lease between", value1, value2, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_lease not between", value1, value2, "saleLease");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("house_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("house_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(Integer value) {
            addCriterion("house_id =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(Integer value) {
            addCriterion("house_id <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(Integer value) {
            addCriterion("house_id >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_id >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(Integer value) {
            addCriterion("house_id <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("house_id <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<Integer> values) {
            addCriterion("house_id in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<Integer> values) {
            addCriterion("house_id not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("house_id between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("house_id not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIsNull() {
            addCriterion("house_useAge is null");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIsNotNull() {
            addCriterion("house_useAge is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUseageEqualTo(Byte value) {
            addCriterion("house_useAge =", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotEqualTo(Byte value) {
            addCriterion("house_useAge <>", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThan(Byte value) {
            addCriterion("house_useAge >", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThanOrEqualTo(Byte value) {
            addCriterion("house_useAge >=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThan(Byte value) {
            addCriterion("house_useAge <", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThanOrEqualTo(Byte value) {
            addCriterion("house_useAge <=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIn(List<Byte> values) {
            addCriterion("house_useAge in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotIn(List<Byte> values) {
            addCriterion("house_useAge not in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageBetween(Byte value1, Byte value2) {
            addCriterion("house_useAge between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotBetween(Byte value1, Byte value2) {
            addCriterion("house_useAge not between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNull() {
            addCriterion("house_no is null");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNotNull() {
            addCriterion("house_no is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNoEqualTo(String value) {
            addCriterion("house_no =", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotEqualTo(String value) {
            addCriterion("house_no <>", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThan(String value) {
            addCriterion("house_no >", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThanOrEqualTo(String value) {
            addCriterion("house_no >=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThan(String value) {
            addCriterion("house_no <", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThanOrEqualTo(String value) {
            addCriterion("house_no <=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLike(String value) {
            addCriterion("house_no like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotLike(String value) {
            addCriterion("house_no not like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoIn(List<String> values) {
            addCriterion("house_no in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotIn(List<String> values) {
            addCriterion("house_no not in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoBetween(String value1, String value2) {
            addCriterion("house_no between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotBetween(String value1, String value2) {
            addCriterion("house_no not between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andLockIsNull() {
            addCriterion("[LOCK] is null");
            return (Criteria) this;
        }

        public Criteria andLockIsNotNull() {
            addCriterion("[LOCK] is not null");
            return (Criteria) this;
        }

        public Criteria andLockEqualTo(Byte value) {
            addCriterion("[LOCK] =", value, "lock");
            return (Criteria) this;
        }

        public Criteria andLockNotEqualTo(Byte value) {
            addCriterion("[LOCK] <>", value, "lock");
            return (Criteria) this;
        }

        public Criteria andLockGreaterThan(Byte value) {
            addCriterion("[LOCK] >", value, "lock");
            return (Criteria) this;
        }

        public Criteria andLockGreaterThanOrEqualTo(Byte value) {
            addCriterion("[LOCK] >=", value, "lock");
            return (Criteria) this;
        }

        public Criteria andLockLessThan(Byte value) {
            addCriterion("[LOCK] <", value, "lock");
            return (Criteria) this;
        }

        public Criteria andLockLessThanOrEqualTo(Byte value) {
            addCriterion("[LOCK] <=", value, "lock");
            return (Criteria) this;
        }

        public Criteria andLockIn(List<Byte> values) {
            addCriterion("[LOCK] in", values, "lock");
            return (Criteria) this;
        }

        public Criteria andLockNotIn(List<Byte> values) {
            addCriterion("[LOCK] not in", values, "lock");
            return (Criteria) this;
        }

        public Criteria andLockBetween(Byte value1, Byte value2) {
            addCriterion("[LOCK] between", value1, value2, "lock");
            return (Criteria) this;
        }

        public Criteria andLockNotBetween(Byte value1, Byte value2) {
            addCriterion("[LOCK] not between", value1, value2, "lock");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagIsNull() {
            addCriterion("ENCODE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagIsNotNull() {
            addCriterion("ENCODE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagEqualTo(Byte value) {
            addCriterion("ENCODE_FLAG =", value, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagNotEqualTo(Byte value) {
            addCriterion("ENCODE_FLAG <>", value, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagGreaterThan(Byte value) {
            addCriterion("ENCODE_FLAG >", value, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("ENCODE_FLAG >=", value, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagLessThan(Byte value) {
            addCriterion("ENCODE_FLAG <", value, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagLessThanOrEqualTo(Byte value) {
            addCriterion("ENCODE_FLAG <=", value, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagIn(List<Byte> values) {
            addCriterion("ENCODE_FLAG in", values, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagNotIn(List<Byte> values) {
            addCriterion("ENCODE_FLAG not in", values, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagBetween(Byte value1, Byte value2) {
            addCriterion("ENCODE_FLAG between", value1, value2, "encodeFlag");
            return (Criteria) this;
        }

        public Criteria andEncodeFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("ENCODE_FLAG not between", value1, value2, "encodeFlag");
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