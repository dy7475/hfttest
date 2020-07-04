package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminMobileKeyExample {
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
    public AdminMobileKeyExample() {
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

        public Criteria andKeyIdIsNull() {
            addCriterion("KEY_ID is null");
            return (Criteria) this;
        }

        public Criteria andKeyIdIsNotNull() {
            addCriterion("KEY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKeyIdEqualTo(Integer value) {
            addCriterion("KEY_ID =", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotEqualTo(Integer value) {
            addCriterion("KEY_ID <>", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThan(Integer value) {
            addCriterion("KEY_ID >", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("KEY_ID >=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThan(Integer value) {
            addCriterion("KEY_ID <", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThanOrEqualTo(Integer value) {
            addCriterion("KEY_ID <=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdIn(List<Integer> values) {
            addCriterion("KEY_ID in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotIn(List<Integer> values) {
            addCriterion("KEY_ID not in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdBetween(Integer value1, Integer value2) {
            addCriterion("KEY_ID between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("KEY_ID not between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("[KEY] is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("[KEY] is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("[KEY] =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("[KEY] <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("[KEY] >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("[KEY] >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("[KEY] <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("[KEY] <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("[KEY] like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("[KEY] not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("[KEY] in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("[KEY] not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("[KEY] between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("[KEY] not between", value1, value2, "key");
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

        public Criteria andIpAddrIsNull() {
            addCriterion("IP_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNotNull() {
            addCriterion("IP_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddrEqualTo(String value) {
            addCriterion("IP_ADDR =", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotEqualTo(String value) {
            addCriterion("IP_ADDR <>", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThan(String value) {
            addCriterion("IP_ADDR >", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThanOrEqualTo(String value) {
            addCriterion("IP_ADDR >=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThan(String value) {
            addCriterion("IP_ADDR <", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThanOrEqualTo(String value) {
            addCriterion("IP_ADDR <=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLike(String value) {
            addCriterion("IP_ADDR like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotLike(String value) {
            addCriterion("IP_ADDR not like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrIn(List<String> values) {
            addCriterion("IP_ADDR in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotIn(List<String> values) {
            addCriterion("IP_ADDR not in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrBetween(String value1, String value2) {
            addCriterion("IP_ADDR between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotBetween(String value1, String value2) {
            addCriterion("IP_ADDR not between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andWebIsNull() {
            addCriterion("WEB is null");
            return (Criteria) this;
        }

        public Criteria andWebIsNotNull() {
            addCriterion("WEB is not null");
            return (Criteria) this;
        }

        public Criteria andWebEqualTo(Integer value) {
            addCriterion("WEB =", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotEqualTo(Integer value) {
            addCriterion("WEB <>", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebGreaterThan(Integer value) {
            addCriterion("WEB >", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEB >=", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLessThan(Integer value) {
            addCriterion("WEB <", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLessThanOrEqualTo(Integer value) {
            addCriterion("WEB <=", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebIn(List<Integer> values) {
            addCriterion("WEB in", values, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotIn(List<Integer> values) {
            addCriterion("WEB not in", values, "web");
            return (Criteria) this;
        }

        public Criteria andWebBetween(Integer value1, Integer value2) {
            addCriterion("WEB between", value1, value2, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotBetween(Integer value1, Integer value2) {
            addCriterion("WEB not between", value1, value2, "web");
            return (Criteria) this;
        }

        public Criteria andResendIsNull() {
            addCriterion("RESEND is null");
            return (Criteria) this;
        }

        public Criteria andResendIsNotNull() {
            addCriterion("RESEND is not null");
            return (Criteria) this;
        }

        public Criteria andResendEqualTo(Integer value) {
            addCriterion("RESEND =", value, "resend");
            return (Criteria) this;
        }

        public Criteria andResendNotEqualTo(Integer value) {
            addCriterion("RESEND <>", value, "resend");
            return (Criteria) this;
        }

        public Criteria andResendGreaterThan(Integer value) {
            addCriterion("RESEND >", value, "resend");
            return (Criteria) this;
        }

        public Criteria andResendGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESEND >=", value, "resend");
            return (Criteria) this;
        }

        public Criteria andResendLessThan(Integer value) {
            addCriterion("RESEND <", value, "resend");
            return (Criteria) this;
        }

        public Criteria andResendLessThanOrEqualTo(Integer value) {
            addCriterion("RESEND <=", value, "resend");
            return (Criteria) this;
        }

        public Criteria andResendIn(List<Integer> values) {
            addCriterion("RESEND in", values, "resend");
            return (Criteria) this;
        }

        public Criteria andResendNotIn(List<Integer> values) {
            addCriterion("RESEND not in", values, "resend");
            return (Criteria) this;
        }

        public Criteria andResendBetween(Integer value1, Integer value2) {
            addCriterion("RESEND between", value1, value2, "resend");
            return (Criteria) this;
        }

        public Criteria andResendNotBetween(Integer value1, Integer value2) {
            addCriterion("RESEND not between", value1, value2, "resend");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("SOURCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("SOURCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("SOURCE_TYPE =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(String value) {
            addCriterion("SOURCE_TYPE <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(String value) {
            addCriterion("SOURCE_TYPE >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_TYPE >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(String value) {
            addCriterion("SOURCE_TYPE <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_TYPE <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLike(String value) {
            addCriterion("SOURCE_TYPE like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotLike(String value) {
            addCriterion("SOURCE_TYPE not like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<String> values) {
            addCriterion("SOURCE_TYPE in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<String> values) {
            addCriterion("SOURCE_TYPE not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("SOURCE_TYPE between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("SOURCE_TYPE not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("[STATUS] is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("[STATUS] is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("[STATUS] =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("[STATUS] <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("[STATUS] >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("[STATUS] >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("[STATUS] <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("[STATUS] <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("[STATUS] in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("[STATUS] not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("[STATUS] between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("[STATUS] not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andWrongTimeIsNull() {
            addCriterion("WRONG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWrongTimeIsNotNull() {
            addCriterion("WRONG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWrongTimeEqualTo(Byte value) {
            addCriterion("WRONG_TIME =", value, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeNotEqualTo(Byte value) {
            addCriterion("WRONG_TIME <>", value, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeGreaterThan(Byte value) {
            addCriterion("WRONG_TIME >", value, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeGreaterThanOrEqualTo(Byte value) {
            addCriterion("WRONG_TIME >=", value, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeLessThan(Byte value) {
            addCriterion("WRONG_TIME <", value, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeLessThanOrEqualTo(Byte value) {
            addCriterion("WRONG_TIME <=", value, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeIn(List<Byte> values) {
            addCriterion("WRONG_TIME in", values, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeNotIn(List<Byte> values) {
            addCriterion("WRONG_TIME not in", values, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeBetween(Byte value1, Byte value2) {
            addCriterion("WRONG_TIME between", value1, value2, "wrongTime");
            return (Criteria) this;
        }

        public Criteria andWrongTimeNotBetween(Byte value1, Byte value2) {
            addCriterion("WRONG_TIME not between", value1, value2, "wrongTime");
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