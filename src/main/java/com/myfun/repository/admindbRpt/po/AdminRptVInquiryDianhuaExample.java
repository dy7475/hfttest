package com.myfun.repository.admindbRpt.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminRptVInquiryDianhuaExample extends ShardDb {
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
    public AdminRptVInquiryDianhuaExample() {
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

        public Criteria andInquiryidIsNull() {
            addCriterion("InquiryID is null");
            return (Criteria) this;
        }

        public Criteria andInquiryidIsNotNull() {
            addCriterion("InquiryID is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryidEqualTo(String value) {
            addCriterion("InquiryID =", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidNotEqualTo(String value) {
            addCriterion("InquiryID <>", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidGreaterThan(String value) {
            addCriterion("InquiryID >", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidGreaterThanOrEqualTo(String value) {
            addCriterion("InquiryID >=", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidLessThan(String value) {
            addCriterion("InquiryID <", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidLessThanOrEqualTo(String value) {
            addCriterion("InquiryID <=", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidLike(String value) {
            addCriterion("InquiryID like", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidNotLike(String value) {
            addCriterion("InquiryID not like", value, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidIn(List<String> values) {
            addCriterion("InquiryID in", values, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidNotIn(List<String> values) {
            addCriterion("InquiryID not in", values, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidBetween(String value1, String value2) {
            addCriterion("InquiryID between", value1, value2, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquiryidNotBetween(String value1, String value2) {
            addCriterion("InquiryID not between", value1, value2, "inquiryid");
            return (Criteria) this;
        }

        public Criteria andInquirynoIsNull() {
            addCriterion("InquiryNo is null");
            return (Criteria) this;
        }

        public Criteria andInquirynoIsNotNull() {
            addCriterion("InquiryNo is not null");
            return (Criteria) this;
        }

        public Criteria andInquirynoEqualTo(String value) {
            addCriterion("InquiryNo =", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoNotEqualTo(String value) {
            addCriterion("InquiryNo <>", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoGreaterThan(String value) {
            addCriterion("InquiryNo >", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoGreaterThanOrEqualTo(String value) {
            addCriterion("InquiryNo >=", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoLessThan(String value) {
            addCriterion("InquiryNo <", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoLessThanOrEqualTo(String value) {
            addCriterion("InquiryNo <=", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoLike(String value) {
            addCriterion("InquiryNo like", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoNotLike(String value) {
            addCriterion("InquiryNo not like", value, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoIn(List<String> values) {
            addCriterion("InquiryNo in", values, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoNotIn(List<String> values) {
            addCriterion("InquiryNo not in", values, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoBetween(String value1, String value2) {
            addCriterion("InquiryNo between", value1, value2, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andInquirynoNotBetween(String value1, String value2) {
            addCriterion("InquiryNo not between", value1, value2, "inquiryno");
            return (Criteria) this;
        }

        public Criteria andCusttelIsNull() {
            addCriterion("CustTel is null");
            return (Criteria) this;
        }

        public Criteria andCusttelIsNotNull() {
            addCriterion("CustTel is not null");
            return (Criteria) this;
        }

        public Criteria andCusttelEqualTo(String value) {
            addCriterion("CustTel =", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelNotEqualTo(String value) {
            addCriterion("CustTel <>", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelGreaterThan(String value) {
            addCriterion("CustTel >", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelGreaterThanOrEqualTo(String value) {
            addCriterion("CustTel >=", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelLessThan(String value) {
            addCriterion("CustTel <", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelLessThanOrEqualTo(String value) {
            addCriterion("CustTel <=", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelLike(String value) {
            addCriterion("CustTel like", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelNotLike(String value) {
            addCriterion("CustTel not like", value, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelIn(List<String> values) {
            addCriterion("CustTel in", values, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelNotIn(List<String> values) {
            addCriterion("CustTel not in", values, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelBetween(String value1, String value2) {
            addCriterion("CustTel between", value1, value2, "custtel");
            return (Criteria) this;
        }

        public Criteria andCusttelNotBetween(String value1, String value2) {
            addCriterion("CustTel not between", value1, value2, "custtel");
            return (Criteria) this;
        }

        public Criteria andCustmobileIsNull() {
            addCriterion("CustMobile is null");
            return (Criteria) this;
        }

        public Criteria andCustmobileIsNotNull() {
            addCriterion("CustMobile is not null");
            return (Criteria) this;
        }

        public Criteria andCustmobileEqualTo(String value) {
            addCriterion("CustMobile =", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileNotEqualTo(String value) {
            addCriterion("CustMobile <>", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileGreaterThan(String value) {
            addCriterion("CustMobile >", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileGreaterThanOrEqualTo(String value) {
            addCriterion("CustMobile >=", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileLessThan(String value) {
            addCriterion("CustMobile <", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileLessThanOrEqualTo(String value) {
            addCriterion("CustMobile <=", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileLike(String value) {
            addCriterion("CustMobile like", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileNotLike(String value) {
            addCriterion("CustMobile not like", value, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileIn(List<String> values) {
            addCriterion("CustMobile in", values, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileNotIn(List<String> values) {
            addCriterion("CustMobile not in", values, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileBetween(String value1, String value2) {
            addCriterion("CustMobile between", value1, value2, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCustmobileNotBetween(String value1, String value2) {
            addCriterion("CustMobile not between", value1, value2, "custmobile");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNull() {
            addCriterion("cell_phone is null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIsNotNull() {
            addCriterion("cell_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneEqualTo(String value) {
            addCriterion("cell_phone =", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotEqualTo(String value) {
            addCriterion("cell_phone <>", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThan(String value) {
            addCriterion("cell_phone >", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cell_phone >=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThan(String value) {
            addCriterion("cell_phone <", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLessThanOrEqualTo(String value) {
            addCriterion("cell_phone <=", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneLike(String value) {
            addCriterion("cell_phone like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotLike(String value) {
            addCriterion("cell_phone not like", value, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneIn(List<String> values) {
            addCriterion("cell_phone in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotIn(List<String> values) {
            addCriterion("cell_phone not in", values, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneBetween(String value1, String value2) {
            addCriterion("cell_phone between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneNotBetween(String value1, String value2) {
            addCriterion("cell_phone not between", value1, value2, "cellPhone");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRIsNull() {
            addCriterion("cell_phone_r is null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRIsNotNull() {
            addCriterion("cell_phone_r is not null");
            return (Criteria) this;
        }

        public Criteria andCellPhoneREqualTo(String value) {
            addCriterion("cell_phone_r =", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRNotEqualTo(String value) {
            addCriterion("cell_phone_r <>", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRGreaterThan(String value) {
            addCriterion("cell_phone_r >", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRGreaterThanOrEqualTo(String value) {
            addCriterion("cell_phone_r >=", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRLessThan(String value) {
            addCriterion("cell_phone_r <", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRLessThanOrEqualTo(String value) {
            addCriterion("cell_phone_r <=", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRLike(String value) {
            addCriterion("cell_phone_r like", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRNotLike(String value) {
            addCriterion("cell_phone_r not like", value, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRIn(List<String> values) {
            addCriterion("cell_phone_r in", values, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRNotIn(List<String> values) {
            addCriterion("cell_phone_r not in", values, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRBetween(String value1, String value2) {
            addCriterion("cell_phone_r between", value1, value2, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andCellPhoneRNotBetween(String value1, String value2) {
            addCriterion("cell_phone_r not between", value1, value2, "cellPhoneR");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNull() {
            addCriterion("RegDate is null");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNotNull() {
            addCriterion("RegDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegdateEqualTo(Date value) {
            addCriterion("RegDate =", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotEqualTo(Date value) {
            addCriterion("RegDate <>", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThan(Date value) {
            addCriterion("RegDate >", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThanOrEqualTo(Date value) {
            addCriterion("RegDate >=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThan(Date value) {
            addCriterion("RegDate <", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThanOrEqualTo(Date value) {
            addCriterion("RegDate <=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateIn(List<Date> values) {
            addCriterion("RegDate in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotIn(List<Date> values) {
            addCriterion("RegDate not in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateBetween(Date value1, Date value2) {
            addCriterion("RegDate between", value1, value2, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotBetween(Date value1, Date value2) {
            addCriterion("RegDate not between", value1, value2, "regdate");
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