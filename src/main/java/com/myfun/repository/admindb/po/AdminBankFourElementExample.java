package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminBankFourElementExample {
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
    public AdminBankFourElementExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("ID_CARD is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("ID_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("ID_CARD =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("ID_CARD <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("ID_CARD >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("ID_CARD <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("ID_CARD like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("ID_CARD not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("ID_CARD in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("ID_CARD not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("ID_CARD between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("ID_CARD not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIsNull() {
            addCriterion("BANK_CARD_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIsNotNull() {
            addCriterion("BANK_CARD_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberEqualTo(String value) {
            addCriterion("BANK_CARD_NUMBER =", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotEqualTo(String value) {
            addCriterion("BANK_CARD_NUMBER <>", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThan(String value) {
            addCriterion("BANK_CARD_NUMBER >", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_CARD_NUMBER >=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThan(String value) {
            addCriterion("BANK_CARD_NUMBER <", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLessThanOrEqualTo(String value) {
            addCriterion("BANK_CARD_NUMBER <=", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberLike(String value) {
            addCriterion("BANK_CARD_NUMBER like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotLike(String value) {
            addCriterion("BANK_CARD_NUMBER not like", value, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberIn(List<String> values) {
            addCriterion("BANK_CARD_NUMBER in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotIn(List<String> values) {
            addCriterion("BANK_CARD_NUMBER not in", values, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberBetween(String value1, String value2) {
            addCriterion("BANK_CARD_NUMBER between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andBankCardNumberNotBetween(String value1, String value2) {
            addCriterion("BANK_CARD_NUMBER not between", value1, value2, "bankCardNumber");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("USER_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("USER_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("USER_MOBILE =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("USER_MOBILE <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("USER_MOBILE >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("USER_MOBILE >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("USER_MOBILE <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("USER_MOBILE <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("USER_MOBILE like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("USER_MOBILE not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("USER_MOBILE in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("USER_MOBILE not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("USER_MOBILE between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("USER_MOBILE not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andValidationStatusIsNull() {
            addCriterion("VALIDATION_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andValidationStatusIsNotNull() {
            addCriterion("VALIDATION_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andValidationStatusEqualTo(Byte value) {
            addCriterion("VALIDATION_STATUS =", value, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusNotEqualTo(Byte value) {
            addCriterion("VALIDATION_STATUS <>", value, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusGreaterThan(Byte value) {
            addCriterion("VALIDATION_STATUS >", value, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("VALIDATION_STATUS >=", value, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusLessThan(Byte value) {
            addCriterion("VALIDATION_STATUS <", value, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusLessThanOrEqualTo(Byte value) {
            addCriterion("VALIDATION_STATUS <=", value, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusIn(List<Byte> values) {
            addCriterion("VALIDATION_STATUS in", values, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusNotIn(List<Byte> values) {
            addCriterion("VALIDATION_STATUS not in", values, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusBetween(Byte value1, Byte value2) {
            addCriterion("VALIDATION_STATUS between", value1, value2, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andValidationStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("VALIDATION_STATUS not between", value1, value2, "validationStatus");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdIsNull() {
            addCriterion("COOPERATE_DEAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdIsNotNull() {
            addCriterion("COOPERATE_DEAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdEqualTo(Integer value) {
            addCriterion("COOPERATE_DEAL_ID =", value, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdNotEqualTo(Integer value) {
            addCriterion("COOPERATE_DEAL_ID <>", value, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdGreaterThan(Integer value) {
            addCriterion("COOPERATE_DEAL_ID >", value, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COOPERATE_DEAL_ID >=", value, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdLessThan(Integer value) {
            addCriterion("COOPERATE_DEAL_ID <", value, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdLessThanOrEqualTo(Integer value) {
            addCriterion("COOPERATE_DEAL_ID <=", value, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdIn(List<Integer> values) {
            addCriterion("COOPERATE_DEAL_ID in", values, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdNotIn(List<Integer> values) {
            addCriterion("COOPERATE_DEAL_ID not in", values, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdBetween(Integer value1, Integer value2) {
            addCriterion("COOPERATE_DEAL_ID between", value1, value2, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andCooperateDealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COOPERATE_DEAL_ID not between", value1, value2, "cooperateDealId");
            return (Criteria) this;
        }

        public Criteria andBankNameAllIsNull() {
            addCriterion("BANK_NAME_ALL is null");
            return (Criteria) this;
        }

        public Criteria andBankNameAllIsNotNull() {
            addCriterion("BANK_NAME_ALL is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameAllEqualTo(String value) {
            addCriterion("BANK_NAME_ALL =", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllNotEqualTo(String value) {
            addCriterion("BANK_NAME_ALL <>", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllGreaterThan(String value) {
            addCriterion("BANK_NAME_ALL >", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME_ALL >=", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllLessThan(String value) {
            addCriterion("BANK_NAME_ALL <", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME_ALL <=", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllLike(String value) {
            addCriterion("BANK_NAME_ALL like", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllNotLike(String value) {
            addCriterion("BANK_NAME_ALL not like", value, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllIn(List<String> values) {
            addCriterion("BANK_NAME_ALL in", values, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllNotIn(List<String> values) {
            addCriterion("BANK_NAME_ALL not in", values, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllBetween(String value1, String value2) {
            addCriterion("BANK_NAME_ALL between", value1, value2, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameAllNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME_ALL not between", value1, value2, "bankNameAll");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleIsNull() {
            addCriterion("BANK_NAME_SIMPLE is null");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleIsNotNull() {
            addCriterion("BANK_NAME_SIMPLE is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleEqualTo(String value) {
            addCriterion("BANK_NAME_SIMPLE =", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleNotEqualTo(String value) {
            addCriterion("BANK_NAME_SIMPLE <>", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleGreaterThan(String value) {
            addCriterion("BANK_NAME_SIMPLE >", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME_SIMPLE >=", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleLessThan(String value) {
            addCriterion("BANK_NAME_SIMPLE <", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME_SIMPLE <=", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleLike(String value) {
            addCriterion("BANK_NAME_SIMPLE like", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleNotLike(String value) {
            addCriterion("BANK_NAME_SIMPLE not like", value, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleIn(List<String> values) {
            addCriterion("BANK_NAME_SIMPLE in", values, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleNotIn(List<String> values) {
            addCriterion("BANK_NAME_SIMPLE not in", values, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleBetween(String value1, String value2) {
            addCriterion("BANK_NAME_SIMPLE between", value1, value2, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNameSimpleNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME_SIMPLE not between", value1, value2, "bankNameSimple");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNull() {
            addCriterion("BANK_NO is null");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("BANK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("BANK_NO =", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("BANK_NO <>", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("BANK_NO >", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NO >=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("BANK_NO <", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("BANK_NO <=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLike(String value) {
            addCriterion("BANK_NO like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("BANK_NO not like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoIn(List<String> values) {
            addCriterion("BANK_NO in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotIn(List<String> values) {
            addCriterion("BANK_NO not in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("BANK_NO between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("BANK_NO not between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyIsNull() {
            addCriterion("CERTIFICATION_PARTY is null");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyIsNotNull() {
            addCriterion("CERTIFICATION_PARTY is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyEqualTo(Byte value) {
            addCriterion("CERTIFICATION_PARTY =", value, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyNotEqualTo(Byte value) {
            addCriterion("CERTIFICATION_PARTY <>", value, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyGreaterThan(Byte value) {
            addCriterion("CERTIFICATION_PARTY >", value, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyGreaterThanOrEqualTo(Byte value) {
            addCriterion("CERTIFICATION_PARTY >=", value, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyLessThan(Byte value) {
            addCriterion("CERTIFICATION_PARTY <", value, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyLessThanOrEqualTo(Byte value) {
            addCriterion("CERTIFICATION_PARTY <=", value, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyIn(List<Byte> values) {
            addCriterion("CERTIFICATION_PARTY in", values, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyNotIn(List<Byte> values) {
            addCriterion("CERTIFICATION_PARTY not in", values, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyBetween(Byte value1, Byte value2) {
            addCriterion("CERTIFICATION_PARTY between", value1, value2, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andCertificationPartyNotBetween(Byte value1, Byte value2) {
            addCriterion("CERTIFICATION_PARTY not between", value1, value2, "certificationParty");
            return (Criteria) this;
        }

        public Criteria andDealTypeIsNull() {
            addCriterion("DEAL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDealTypeIsNotNull() {
            addCriterion("DEAL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDealTypeEqualTo(Byte value) {
            addCriterion("DEAL_TYPE =", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotEqualTo(Byte value) {
            addCriterion("DEAL_TYPE <>", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeGreaterThan(Byte value) {
            addCriterion("DEAL_TYPE >", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("DEAL_TYPE >=", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeLessThan(Byte value) {
            addCriterion("DEAL_TYPE <", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeLessThanOrEqualTo(Byte value) {
            addCriterion("DEAL_TYPE <=", value, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeIn(List<Byte> values) {
            addCriterion("DEAL_TYPE in", values, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotIn(List<Byte> values) {
            addCriterion("DEAL_TYPE not in", values, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_TYPE between", value1, value2, "dealType");
            return (Criteria) this;
        }

        public Criteria andDealTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_TYPE not between", value1, value2, "dealType");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIsNull() {
            addCriterion("ARCHIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIsNotNull() {
            addCriterion("ARCHIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveIdEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID =", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID <>", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThan(Integer value) {
            addCriterion("ARCHIVE_ID >", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID >=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThan(Integer value) {
            addCriterion("ARCHIVE_ID <", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("ARCHIVE_ID <=", value, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdIn(List<Integer> values) {
            addCriterion("ARCHIVE_ID in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotIn(List<Integer> values) {
            addCriterion("ARCHIVE_ID not in", values, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdBetween(Integer value1, Integer value2) {
            addCriterion("ARCHIVE_ID between", value1, value2, "archiveId");
            return (Criteria) this;
        }

        public Criteria andArchiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ARCHIVE_ID not between", value1, value2, "archiveId");
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