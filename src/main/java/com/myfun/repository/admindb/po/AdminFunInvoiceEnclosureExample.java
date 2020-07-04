package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunInvoiceEnclosureExample {
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
    public AdminFunInvoiceEnclosureExample() {
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

        public Criteria andEsIdIsNull() {
            addCriterion("ES_ID is null");
            return (Criteria) this;
        }

        public Criteria andEsIdIsNotNull() {
            addCriterion("ES_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEsIdEqualTo(Integer value) {
            addCriterion("ES_ID =", value, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdNotEqualTo(Integer value) {
            addCriterion("ES_ID <>", value, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdGreaterThan(Integer value) {
            addCriterion("ES_ID >", value, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ES_ID >=", value, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdLessThan(Integer value) {
            addCriterion("ES_ID <", value, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ES_ID <=", value, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdIn(List<Integer> values) {
            addCriterion("ES_ID in", values, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdNotIn(List<Integer> values) {
            addCriterion("ES_ID not in", values, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdBetween(Integer value1, Integer value2) {
            addCriterion("ES_ID between", value1, value2, "esId");
            return (Criteria) this;
        }

        public Criteria andEsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ES_ID not between", value1, value2, "esId");
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

        public Criteria andCreateUidIsNull() {
            addCriterion("CREATE_UID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUidIsNotNull() {
            addCriterion("CREATE_UID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUidEqualTo(Integer value) {
            addCriterion("CREATE_UID =", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotEqualTo(Integer value) {
            addCriterion("CREATE_UID <>", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThan(Integer value) {
            addCriterion("CREATE_UID >", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATE_UID >=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThan(Integer value) {
            addCriterion("CREATE_UID <", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThanOrEqualTo(Integer value) {
            addCriterion("CREATE_UID <=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidIn(List<Integer> values) {
            addCriterion("CREATE_UID in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotIn(List<Integer> values) {
            addCriterion("CREATE_UID not in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_UID between", value1, value2, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_UID not between", value1, value2, "createUid");
            return (Criteria) this;
        }

        public Criteria andCompNoIsNull() {
            addCriterion("COMP_NO is null");
            return (Criteria) this;
        }

        public Criteria andCompNoIsNotNull() {
            addCriterion("COMP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCompNoEqualTo(String value) {
            addCriterion("COMP_NO =", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotEqualTo(String value) {
            addCriterion("COMP_NO <>", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoGreaterThan(String value) {
            addCriterion("COMP_NO >", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_NO >=", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLessThan(String value) {
            addCriterion("COMP_NO <", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLessThanOrEqualTo(String value) {
            addCriterion("COMP_NO <=", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLike(String value) {
            addCriterion("COMP_NO like", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotLike(String value) {
            addCriterion("COMP_NO not like", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoIn(List<String> values) {
            addCriterion("COMP_NO in", values, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotIn(List<String> values) {
            addCriterion("COMP_NO not in", values, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoBetween(String value1, String value2) {
            addCriterion("COMP_NO between", value1, value2, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotBetween(String value1, String value2) {
            addCriterion("COMP_NO not between", value1, value2, "compNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoIsNull() {
            addCriterion("DEPT_NO is null");
            return (Criteria) this;
        }

        public Criteria andDeptNoIsNotNull() {
            addCriterion("DEPT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNoEqualTo(String value) {
            addCriterion("DEPT_NO =", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotEqualTo(String value) {
            addCriterion("DEPT_NO <>", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoGreaterThan(String value) {
            addCriterion("DEPT_NO >", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_NO >=", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoLessThan(String value) {
            addCriterion("DEPT_NO <", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoLessThanOrEqualTo(String value) {
            addCriterion("DEPT_NO <=", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoLike(String value) {
            addCriterion("DEPT_NO like", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotLike(String value) {
            addCriterion("DEPT_NO not like", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoIn(List<String> values) {
            addCriterion("DEPT_NO in", values, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotIn(List<String> values) {
            addCriterion("DEPT_NO not in", values, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoBetween(String value1, String value2) {
            addCriterion("DEPT_NO between", value1, value2, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotBetween(String value1, String value2) {
            addCriterion("DEPT_NO not between", value1, value2, "deptNo");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Short value) {
            addCriterion("CITY_ID =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Short value) {
            addCriterion("CITY_ID <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Short value) {
            addCriterion("CITY_ID >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Short value) {
            addCriterion("CITY_ID >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Short value) {
            addCriterion("CITY_ID <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Short value) {
            addCriterion("CITY_ID <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Short> values) {
            addCriterion("CITY_ID in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Short> values) {
            addCriterion("CITY_ID not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Short value1, Short value2) {
            addCriterion("CITY_ID between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Short value1, Short value2) {
            addCriterion("CITY_ID not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andEsStatusIsNull() {
            addCriterion("ES_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andEsStatusIsNotNull() {
            addCriterion("ES_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andEsStatusEqualTo(Byte value) {
            addCriterion("ES_STATUS =", value, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusNotEqualTo(Byte value) {
            addCriterion("ES_STATUS <>", value, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusGreaterThan(Byte value) {
            addCriterion("ES_STATUS >", value, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ES_STATUS >=", value, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusLessThan(Byte value) {
            addCriterion("ES_STATUS <", value, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusLessThanOrEqualTo(Byte value) {
            addCriterion("ES_STATUS <=", value, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusIn(List<Byte> values) {
            addCriterion("ES_STATUS in", values, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusNotIn(List<Byte> values) {
            addCriterion("ES_STATUS not in", values, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusBetween(Byte value1, Byte value2) {
            addCriterion("ES_STATUS between", value1, value2, "esStatus");
            return (Criteria) this;
        }

        public Criteria andEsStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ES_STATUS not between", value1, value2, "esStatus");
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

        public Criteria andEsTypeIsNull() {
            addCriterion("ES_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEsTypeIsNotNull() {
            addCriterion("ES_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEsTypeEqualTo(Byte value) {
            addCriterion("ES_TYPE =", value, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeNotEqualTo(Byte value) {
            addCriterion("ES_TYPE <>", value, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeGreaterThan(Byte value) {
            addCriterion("ES_TYPE >", value, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ES_TYPE >=", value, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeLessThan(Byte value) {
            addCriterion("ES_TYPE <", value, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeLessThanOrEqualTo(Byte value) {
            addCriterion("ES_TYPE <=", value, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeIn(List<Byte> values) {
            addCriterion("ES_TYPE in", values, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeNotIn(List<Byte> values) {
            addCriterion("ES_TYPE not in", values, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeBetween(Byte value1, Byte value2) {
            addCriterion("ES_TYPE between", value1, value2, "esType");
            return (Criteria) this;
        }

        public Criteria andEsTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ES_TYPE not between", value1, value2, "esType");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNull() {
            addCriterion("INVOICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNotNull() {
            addCriterion("INVOICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdEqualTo(Integer value) {
            addCriterion("INVOICE_ID =", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotEqualTo(Integer value) {
            addCriterion("INVOICE_ID <>", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThan(Integer value) {
            addCriterion("INVOICE_ID >", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("INVOICE_ID >=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThan(Integer value) {
            addCriterion("INVOICE_ID <", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("INVOICE_ID <=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIn(List<Integer> values) {
            addCriterion("INVOICE_ID in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotIn(List<Integer> values) {
            addCriterion("INVOICE_ID not in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdBetween(Integer value1, Integer value2) {
            addCriterion("INVOICE_ID between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("INVOICE_ID not between", value1, value2, "invoiceId");
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