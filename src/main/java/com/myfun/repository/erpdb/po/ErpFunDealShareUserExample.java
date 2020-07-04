package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunDealShareUserExample extends ShardDb {
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
    public ErpFunDealShareUserExample() {
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

        public Criteria andDealIdIsNull() {
            addCriterion("DEAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDealIdIsNotNull() {
            addCriterion("DEAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDealIdEqualTo(Integer value) {
            addCriterion("DEAL_ID =", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotEqualTo(Integer value) {
            addCriterion("DEAL_ID <>", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThan(Integer value) {
            addCriterion("DEAL_ID >", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEAL_ID >=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThan(Integer value) {
            addCriterion("DEAL_ID <", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEAL_ID <=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdIn(List<Integer> values) {
            addCriterion("DEAL_ID in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotIn(List<Integer> values) {
            addCriterion("DEAL_ID not in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_ID between", value1, value2, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_ID not between", value1, value2, "dealId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdIsNull() {
            addCriterion("BUY_OPEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdIsNotNull() {
            addCriterion("BUY_OPEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdEqualTo(String value) {
            addCriterion("BUY_OPEN_ID =", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdNotEqualTo(String value) {
            addCriterion("BUY_OPEN_ID <>", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdGreaterThan(String value) {
            addCriterion("BUY_OPEN_ID >", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUY_OPEN_ID >=", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdLessThan(String value) {
            addCriterion("BUY_OPEN_ID <", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdLessThanOrEqualTo(String value) {
            addCriterion("BUY_OPEN_ID <=", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdLike(String value) {
            addCriterion("BUY_OPEN_ID like", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdNotLike(String value) {
            addCriterion("BUY_OPEN_ID not like", value, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdIn(List<String> values) {
            addCriterion("BUY_OPEN_ID in", values, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdNotIn(List<String> values) {
            addCriterion("BUY_OPEN_ID not in", values, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdBetween(String value1, String value2) {
            addCriterion("BUY_OPEN_ID between", value1, value2, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyOpenIdNotBetween(String value1, String value2) {
            addCriterion("BUY_OPEN_ID not between", value1, value2, "buyOpenId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdIsNull() {
            addCriterion("BUY_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdIsNotNull() {
            addCriterion("BUY_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdEqualTo(String value) {
            addCriterion("BUY_USER_ID =", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdNotEqualTo(String value) {
            addCriterion("BUY_USER_ID <>", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdGreaterThan(String value) {
            addCriterion("BUY_USER_ID >", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUY_USER_ID >=", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdLessThan(String value) {
            addCriterion("BUY_USER_ID <", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdLessThanOrEqualTo(String value) {
            addCriterion("BUY_USER_ID <=", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdLike(String value) {
            addCriterion("BUY_USER_ID like", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdNotLike(String value) {
            addCriterion("BUY_USER_ID not like", value, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdIn(List<String> values) {
            addCriterion("BUY_USER_ID in", values, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdNotIn(List<String> values) {
            addCriterion("BUY_USER_ID not in", values, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdBetween(String value1, String value2) {
            addCriterion("BUY_USER_ID between", value1, value2, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andBuyUserIdNotBetween(String value1, String value2) {
            addCriterion("BUY_USER_ID not between", value1, value2, "buyUserId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdIsNull() {
            addCriterion("SELL_OPEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdIsNotNull() {
            addCriterion("SELL_OPEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdEqualTo(String value) {
            addCriterion("SELL_OPEN_ID =", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdNotEqualTo(String value) {
            addCriterion("SELL_OPEN_ID <>", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdGreaterThan(String value) {
            addCriterion("SELL_OPEN_ID >", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("SELL_OPEN_ID >=", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdLessThan(String value) {
            addCriterion("SELL_OPEN_ID <", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdLessThanOrEqualTo(String value) {
            addCriterion("SELL_OPEN_ID <=", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdLike(String value) {
            addCriterion("SELL_OPEN_ID like", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdNotLike(String value) {
            addCriterion("SELL_OPEN_ID not like", value, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdIn(List<String> values) {
            addCriterion("SELL_OPEN_ID in", values, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdNotIn(List<String> values) {
            addCriterion("SELL_OPEN_ID not in", values, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdBetween(String value1, String value2) {
            addCriterion("SELL_OPEN_ID between", value1, value2, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellOpenIdNotBetween(String value1, String value2) {
            addCriterion("SELL_OPEN_ID not between", value1, value2, "sellOpenId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdIsNull() {
            addCriterion("SELL_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSellUserIdIsNotNull() {
            addCriterion("SELL_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSellUserIdEqualTo(String value) {
            addCriterion("SELL_USER_ID =", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdNotEqualTo(String value) {
            addCriterion("SELL_USER_ID <>", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdGreaterThan(String value) {
            addCriterion("SELL_USER_ID >", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("SELL_USER_ID >=", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdLessThan(String value) {
            addCriterion("SELL_USER_ID <", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdLessThanOrEqualTo(String value) {
            addCriterion("SELL_USER_ID <=", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdLike(String value) {
            addCriterion("SELL_USER_ID like", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdNotLike(String value) {
            addCriterion("SELL_USER_ID not like", value, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdIn(List<String> values) {
            addCriterion("SELL_USER_ID in", values, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdNotIn(List<String> values) {
            addCriterion("SELL_USER_ID not in", values, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdBetween(String value1, String value2) {
            addCriterion("SELL_USER_ID between", value1, value2, "sellUserId");
            return (Criteria) this;
        }

        public Criteria andSellUserIdNotBetween(String value1, String value2) {
            addCriterion("SELL_USER_ID not between", value1, value2, "sellUserId");
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