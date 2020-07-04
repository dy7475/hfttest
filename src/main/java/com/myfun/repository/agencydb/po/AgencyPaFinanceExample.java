package com.myfun.repository.agencydb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgencyPaFinanceExample {
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
    public AgencyPaFinanceExample() {
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

        public Criteria andFinanceIdIsNull() {
            addCriterion("FINANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("FINANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(Integer value) {
            addCriterion("FINANCE_ID =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(Integer value) {
            addCriterion("FINANCE_ID <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(Integer value) {
            addCriterion("FINANCE_ID >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FINANCE_ID >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(Integer value) {
            addCriterion("FINANCE_ID <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("FINANCE_ID <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<Integer> values) {
            addCriterion("FINANCE_ID in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<Integer> values) {
            addCriterion("FINANCE_ID not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(Integer value1, Integer value2) {
            addCriterion("FINANCE_ID between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FINANCE_ID not between", value1, value2, "financeId");
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

        public Criteria andIcCodeIsNull() {
            addCriterion("IC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andIcCodeIsNotNull() {
            addCriterion("IC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andIcCodeEqualTo(String value) {
            addCriterion("IC_CODE =", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeNotEqualTo(String value) {
            addCriterion("IC_CODE <>", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeGreaterThan(String value) {
            addCriterion("IC_CODE >", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("IC_CODE >=", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeLessThan(String value) {
            addCriterion("IC_CODE <", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeLessThanOrEqualTo(String value) {
            addCriterion("IC_CODE <=", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeLike(String value) {
            addCriterion("IC_CODE like", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeNotLike(String value) {
            addCriterion("IC_CODE not like", value, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeIn(List<String> values) {
            addCriterion("IC_CODE in", values, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeNotIn(List<String> values) {
            addCriterion("IC_CODE not in", values, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeBetween(String value1, String value2) {
            addCriterion("IC_CODE between", value1, value2, "icCode");
            return (Criteria) this;
        }

        public Criteria andIcCodeNotBetween(String value1, String value2) {
            addCriterion("IC_CODE not between", value1, value2, "icCode");
            return (Criteria) this;
        }

        public Criteria andApplyPriceIsNull() {
            addCriterion("APPLY_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andApplyPriceIsNotNull() {
            addCriterion("APPLY_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPriceEqualTo(BigDecimal value) {
            addCriterion("APPLY_PRICE =", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceNotEqualTo(BigDecimal value) {
            addCriterion("APPLY_PRICE <>", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceGreaterThan(BigDecimal value) {
            addCriterion("APPLY_PRICE >", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("APPLY_PRICE >=", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceLessThan(BigDecimal value) {
            addCriterion("APPLY_PRICE <", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("APPLY_PRICE <=", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceIn(List<BigDecimal> values) {
            addCriterion("APPLY_PRICE in", values, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceNotIn(List<BigDecimal> values) {
            addCriterion("APPLY_PRICE not in", values, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APPLY_PRICE between", value1, value2, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APPLY_PRICE not between", value1, value2, "applyPrice");
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

        public Criteria andFinanceStatusIsNull() {
            addCriterion("FINANCE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIsNotNull() {
            addCriterion("FINANCE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusEqualTo(Byte value) {
            addCriterion("FINANCE_STATUS =", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotEqualTo(Byte value) {
            addCriterion("FINANCE_STATUS <>", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusGreaterThan(Byte value) {
            addCriterion("FINANCE_STATUS >", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("FINANCE_STATUS >=", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusLessThan(Byte value) {
            addCriterion("FINANCE_STATUS <", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("FINANCE_STATUS <=", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIn(List<Byte> values) {
            addCriterion("FINANCE_STATUS in", values, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotIn(List<Byte> values) {
            addCriterion("FINANCE_STATUS not in", values, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusBetween(Byte value1, Byte value2) {
            addCriterion("FINANCE_STATUS between", value1, value2, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("FINANCE_STATUS not between", value1, value2, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceIsNull() {
            addCriterion("FINANCE_RESOURCE is null");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceIsNotNull() {
            addCriterion("FINANCE_RESOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceEqualTo(Byte value) {
            addCriterion("FINANCE_RESOURCE =", value, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceNotEqualTo(Byte value) {
            addCriterion("FINANCE_RESOURCE <>", value, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceGreaterThan(Byte value) {
            addCriterion("FINANCE_RESOURCE >", value, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("FINANCE_RESOURCE >=", value, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceLessThan(Byte value) {
            addCriterion("FINANCE_RESOURCE <", value, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceLessThanOrEqualTo(Byte value) {
            addCriterion("FINANCE_RESOURCE <=", value, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceIn(List<Byte> values) {
            addCriterion("FINANCE_RESOURCE in", values, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceNotIn(List<Byte> values) {
            addCriterion("FINANCE_RESOURCE not in", values, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceBetween(Byte value1, Byte value2) {
            addCriterion("FINANCE_RESOURCE between", value1, value2, "financeResource");
            return (Criteria) this;
        }

        public Criteria andFinanceResourceNotBetween(Byte value1, Byte value2) {
            addCriterion("FINANCE_RESOURCE not between", value1, value2, "financeResource");
            return (Criteria) this;
        }

        public Criteria andRightNoIsNull() {
            addCriterion("RIGHT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRightNoIsNotNull() {
            addCriterion("RIGHT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRightNoEqualTo(String value) {
            addCriterion("RIGHT_NO =", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoNotEqualTo(String value) {
            addCriterion("RIGHT_NO <>", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoGreaterThan(String value) {
            addCriterion("RIGHT_NO >", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHT_NO >=", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoLessThan(String value) {
            addCriterion("RIGHT_NO <", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoLessThanOrEqualTo(String value) {
            addCriterion("RIGHT_NO <=", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoLike(String value) {
            addCriterion("RIGHT_NO like", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoNotLike(String value) {
            addCriterion("RIGHT_NO not like", value, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoIn(List<String> values) {
            addCriterion("RIGHT_NO in", values, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoNotIn(List<String> values) {
            addCriterion("RIGHT_NO not in", values, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoBetween(String value1, String value2) {
            addCriterion("RIGHT_NO between", value1, value2, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRightNoNotBetween(String value1, String value2) {
            addCriterion("RIGHT_NO not between", value1, value2, "rightNo");
            return (Criteria) this;
        }

        public Criteria andRegFromIsNull() {
            addCriterion("REG_FROM is null");
            return (Criteria) this;
        }

        public Criteria andRegFromIsNotNull() {
            addCriterion("REG_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andRegFromEqualTo(Byte value) {
            addCriterion("REG_FROM =", value, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromNotEqualTo(Byte value) {
            addCriterion("REG_FROM <>", value, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromGreaterThan(Byte value) {
            addCriterion("REG_FROM >", value, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromGreaterThanOrEqualTo(Byte value) {
            addCriterion("REG_FROM >=", value, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromLessThan(Byte value) {
            addCriterion("REG_FROM <", value, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromLessThanOrEqualTo(Byte value) {
            addCriterion("REG_FROM <=", value, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromIn(List<Byte> values) {
            addCriterion("REG_FROM in", values, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromNotIn(List<Byte> values) {
            addCriterion("REG_FROM not in", values, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromBetween(Byte value1, Byte value2) {
            addCriterion("REG_FROM between", value1, value2, "regFrom");
            return (Criteria) this;
        }

        public Criteria andRegFromNotBetween(Byte value1, Byte value2) {
            addCriterion("REG_FROM not between", value1, value2, "regFrom");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLoanPriceIsNull() {
            addCriterion("LOAN_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andLoanPriceIsNotNull() {
            addCriterion("LOAN_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPriceEqualTo(BigDecimal value) {
            addCriterion("LOAN_PRICE =", value, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceNotEqualTo(BigDecimal value) {
            addCriterion("LOAN_PRICE <>", value, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceGreaterThan(BigDecimal value) {
            addCriterion("LOAN_PRICE >", value, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PRICE >=", value, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceLessThan(BigDecimal value) {
            addCriterion("LOAN_PRICE <", value, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOAN_PRICE <=", value, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceIn(List<BigDecimal> values) {
            addCriterion("LOAN_PRICE in", values, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceNotIn(List<BigDecimal> values) {
            addCriterion("LOAN_PRICE not in", values, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PRICE between", value1, value2, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOAN_PRICE not between", value1, value2, "loanPrice");
            return (Criteria) this;
        }

        public Criteria andLoanTimeIsNull() {
            addCriterion("LOAN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLoanTimeIsNotNull() {
            addCriterion("LOAN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTimeEqualTo(Date value) {
            addCriterion("LOAN_TIME =", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeNotEqualTo(Date value) {
            addCriterion("LOAN_TIME <>", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeGreaterThan(Date value) {
            addCriterion("LOAN_TIME >", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOAN_TIME >=", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeLessThan(Date value) {
            addCriterion("LOAN_TIME <", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeLessThanOrEqualTo(Date value) {
            addCriterion("LOAN_TIME <=", value, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeIn(List<Date> values) {
            addCriterion("LOAN_TIME in", values, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeNotIn(List<Date> values) {
            addCriterion("LOAN_TIME not in", values, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeBetween(Date value1, Date value2) {
            addCriterion("LOAN_TIME between", value1, value2, "loanTime");
            return (Criteria) this;
        }

        public Criteria andLoanTimeNotBetween(Date value1, Date value2) {
            addCriterion("LOAN_TIME not between", value1, value2, "loanTime");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceIsNull() {
            addCriterion("RAKEBACK_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceIsNotNull() {
            addCriterion("RAKEBACK_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE =", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceNotEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE <>", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceGreaterThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE >", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE >=", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceLessThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE <", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE <=", value, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE in", values, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceNotIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE not in", values, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE between", value1, value2, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE not between", value1, value2, "rakebackPrice");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusIsNull() {
            addCriterion("RAKEBACK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusIsNotNull() {
            addCriterion("RAKEBACK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusEqualTo(Byte value) {
            addCriterion("RAKEBACK_STATUS =", value, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusNotEqualTo(Byte value) {
            addCriterion("RAKEBACK_STATUS <>", value, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusGreaterThan(Byte value) {
            addCriterion("RAKEBACK_STATUS >", value, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("RAKEBACK_STATUS >=", value, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusLessThan(Byte value) {
            addCriterion("RAKEBACK_STATUS <", value, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusLessThanOrEqualTo(Byte value) {
            addCriterion("RAKEBACK_STATUS <=", value, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusIn(List<Byte> values) {
            addCriterion("RAKEBACK_STATUS in", values, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusNotIn(List<Byte> values) {
            addCriterion("RAKEBACK_STATUS not in", values, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusBetween(Byte value1, Byte value2) {
            addCriterion("RAKEBACK_STATUS between", value1, value2, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("RAKEBACK_STATUS not between", value1, value2, "rakebackStatus");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeIsNull() {
            addCriterion("RAKEBACK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeIsNotNull() {
            addCriterion("RAKEBACK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeEqualTo(Date value) {
            addCriterion("RAKEBACK_TIME =", value, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeNotEqualTo(Date value) {
            addCriterion("RAKEBACK_TIME <>", value, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeGreaterThan(Date value) {
            addCriterion("RAKEBACK_TIME >", value, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RAKEBACK_TIME >=", value, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeLessThan(Date value) {
            addCriterion("RAKEBACK_TIME <", value, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeLessThanOrEqualTo(Date value) {
            addCriterion("RAKEBACK_TIME <=", value, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeIn(List<Date> values) {
            addCriterion("RAKEBACK_TIME in", values, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeNotIn(List<Date> values) {
            addCriterion("RAKEBACK_TIME not in", values, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeBetween(Date value1, Date value2) {
            addCriterion("RAKEBACK_TIME between", value1, value2, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andRakebackTimeNotBetween(Date value1, Date value2) {
            addCriterion("RAKEBACK_TIME not between", value1, value2, "rakebackTime");
            return (Criteria) this;
        }

        public Criteria andIsCashIsNull() {
            addCriterion("IS_CASH is null");
            return (Criteria) this;
        }

        public Criteria andIsCashIsNotNull() {
            addCriterion("IS_CASH is not null");
            return (Criteria) this;
        }

        public Criteria andIsCashEqualTo(Byte value) {
            addCriterion("IS_CASH =", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashNotEqualTo(Byte value) {
            addCriterion("IS_CASH <>", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashGreaterThan(Byte value) {
            addCriterion("IS_CASH >", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_CASH >=", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashLessThan(Byte value) {
            addCriterion("IS_CASH <", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashLessThanOrEqualTo(Byte value) {
            addCriterion("IS_CASH <=", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashIn(List<Byte> values) {
            addCriterion("IS_CASH in", values, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashNotIn(List<Byte> values) {
            addCriterion("IS_CASH not in", values, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashBetween(Byte value1, Byte value2) {
            addCriterion("IS_CASH between", value1, value2, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_CASH not between", value1, value2, "isCash");
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

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("CITY_ID =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("CITY_ID <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("CITY_ID >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CITY_ID >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("CITY_ID <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("CITY_ID <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("CITY_ID in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("CITY_ID not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("CITY_ID between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CITY_ID not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateIsNull() {
            addCriterion("RAKEBACK_PRICE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateIsNotNull() {
            addCriterion("RAKEBACK_PRICE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_RATE =", value, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateNotEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_RATE <>", value, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateGreaterThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_RATE >", value, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_RATE >=", value, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateLessThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_RATE <", value, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_RATE <=", value, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE_RATE in", values, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateNotIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE_RATE not in", values, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE_RATE between", value1, value2, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE_RATE not between", value1, value2, "rakebackPriceRate");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesIsNull() {
            addCriterion("MONEY_BEFORE_TAXES is null");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesIsNotNull() {
            addCriterion("MONEY_BEFORE_TAXES is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesEqualTo(BigDecimal value) {
            addCriterion("MONEY_BEFORE_TAXES =", value, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesNotEqualTo(BigDecimal value) {
            addCriterion("MONEY_BEFORE_TAXES <>", value, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesGreaterThan(BigDecimal value) {
            addCriterion("MONEY_BEFORE_TAXES >", value, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY_BEFORE_TAXES >=", value, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesLessThan(BigDecimal value) {
            addCriterion("MONEY_BEFORE_TAXES <", value, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY_BEFORE_TAXES <=", value, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesIn(List<BigDecimal> values) {
            addCriterion("MONEY_BEFORE_TAXES in", values, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesNotIn(List<BigDecimal> values) {
            addCriterion("MONEY_BEFORE_TAXES not in", values, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY_BEFORE_TAXES between", value1, value2, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andMoneyBeforeTaxesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY_BEFORE_TAXES not between", value1, value2, "moneyBeforeTaxes");
            return (Criteria) this;
        }

        public Criteria andTaxesRateIsNull() {
            addCriterion("TAXES_RATE is null");
            return (Criteria) this;
        }

        public Criteria andTaxesRateIsNotNull() {
            addCriterion("TAXES_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andTaxesRateEqualTo(BigDecimal value) {
            addCriterion("TAXES_RATE =", value, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateNotEqualTo(BigDecimal value) {
            addCriterion("TAXES_RATE <>", value, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateGreaterThan(BigDecimal value) {
            addCriterion("TAXES_RATE >", value, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXES_RATE >=", value, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateLessThan(BigDecimal value) {
            addCriterion("TAXES_RATE <", value, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXES_RATE <=", value, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateIn(List<BigDecimal> values) {
            addCriterion("TAXES_RATE in", values, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateNotIn(List<BigDecimal> values) {
            addCriterion("TAXES_RATE not in", values, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXES_RATE between", value1, value2, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXES_RATE not between", value1, value2, "taxesRate");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyIsNull() {
            addCriterion("TAXES_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyIsNotNull() {
            addCriterion("TAXES_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY =", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyNotEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY <>", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyGreaterThan(BigDecimal value) {
            addCriterion("TAXES_MONEY >", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY >=", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyLessThan(BigDecimal value) {
            addCriterion("TAXES_MONEY <", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TAXES_MONEY <=", value, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyIn(List<BigDecimal> values) {
            addCriterion("TAXES_MONEY in", values, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyNotIn(List<BigDecimal> values) {
            addCriterion("TAXES_MONEY not in", values, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXES_MONEY between", value1, value2, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andTaxesMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TAXES_MONEY not between", value1, value2, "taxesMoney");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNull() {
            addCriterion("BUILD_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNotNull() {
            addCriterion("BUILD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildIdEqualTo(Integer value) {
            addCriterion("BUILD_ID =", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotEqualTo(Integer value) {
            addCriterion("BUILD_ID <>", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThan(Integer value) {
            addCriterion("BUILD_ID >", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUILD_ID >=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThan(Integer value) {
            addCriterion("BUILD_ID <", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThanOrEqualTo(Integer value) {
            addCriterion("BUILD_ID <=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIn(List<Integer> values) {
            addCriterion("BUILD_ID in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotIn(List<Integer> values) {
            addCriterion("BUILD_ID not in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_ID between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_ID not between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNull() {
            addCriterion("BUILD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNotNull() {
            addCriterion("BUILD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBuildNameEqualTo(String value) {
            addCriterion("BUILD_NAME =", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotEqualTo(String value) {
            addCriterion("BUILD_NAME <>", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThan(String value) {
            addCriterion("BUILD_NAME >", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_NAME >=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThan(String value) {
            addCriterion("BUILD_NAME <", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThanOrEqualTo(String value) {
            addCriterion("BUILD_NAME <=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLike(String value) {
            addCriterion("BUILD_NAME like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotLike(String value) {
            addCriterion("BUILD_NAME not like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameIn(List<String> values) {
            addCriterion("BUILD_NAME in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotIn(List<String> values) {
            addCriterion("BUILD_NAME not in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameBetween(String value1, String value2) {
            addCriterion("BUILD_NAME between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotBetween(String value1, String value2) {
            addCriterion("BUILD_NAME not between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoIsNull() {
            addCriterion("JIANZHENG_NO is null");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoIsNotNull() {
            addCriterion("JIANZHENG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoEqualTo(String value) {
            addCriterion("JIANZHENG_NO =", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoNotEqualTo(String value) {
            addCriterion("JIANZHENG_NO <>", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoGreaterThan(String value) {
            addCriterion("JIANZHENG_NO >", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoGreaterThanOrEqualTo(String value) {
            addCriterion("JIANZHENG_NO >=", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoLessThan(String value) {
            addCriterion("JIANZHENG_NO <", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoLessThanOrEqualTo(String value) {
            addCriterion("JIANZHENG_NO <=", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoLike(String value) {
            addCriterion("JIANZHENG_NO like", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoNotLike(String value) {
            addCriterion("JIANZHENG_NO not like", value, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoIn(List<String> values) {
            addCriterion("JIANZHENG_NO in", values, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoNotIn(List<String> values) {
            addCriterion("JIANZHENG_NO not in", values, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoBetween(String value1, String value2) {
            addCriterion("JIANZHENG_NO between", value1, value2, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andJianzhengNoNotBetween(String value1, String value2) {
            addCriterion("JIANZHENG_NO not between", value1, value2, "jianzhengNo");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyIsNull() {
            addCriterion("ASSESSMENT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyIsNotNull() {
            addCriterion("ASSESSMENT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyEqualTo(BigDecimal value) {
            addCriterion("ASSESSMENT_MONEY =", value, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyNotEqualTo(BigDecimal value) {
            addCriterion("ASSESSMENT_MONEY <>", value, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyGreaterThan(BigDecimal value) {
            addCriterion("ASSESSMENT_MONEY >", value, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSESSMENT_MONEY >=", value, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyLessThan(BigDecimal value) {
            addCriterion("ASSESSMENT_MONEY <", value, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSESSMENT_MONEY <=", value, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyIn(List<BigDecimal> values) {
            addCriterion("ASSESSMENT_MONEY in", values, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyNotIn(List<BigDecimal> values) {
            addCriterion("ASSESSMENT_MONEY not in", values, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSESSMENT_MONEY between", value1, value2, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andAssessmentMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSESSMENT_MONEY not between", value1, value2, "assessmentMoney");
            return (Criteria) this;
        }

        public Criteria andDyNoIsNull() {
            addCriterion("DY_NO is null");
            return (Criteria) this;
        }

        public Criteria andDyNoIsNotNull() {
            addCriterion("DY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDyNoEqualTo(String value) {
            addCriterion("DY_NO =", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoNotEqualTo(String value) {
            addCriterion("DY_NO <>", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoGreaterThan(String value) {
            addCriterion("DY_NO >", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoGreaterThanOrEqualTo(String value) {
            addCriterion("DY_NO >=", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoLessThan(String value) {
            addCriterion("DY_NO <", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoLessThanOrEqualTo(String value) {
            addCriterion("DY_NO <=", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoLike(String value) {
            addCriterion("DY_NO like", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoNotLike(String value) {
            addCriterion("DY_NO not like", value, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoIn(List<String> values) {
            addCriterion("DY_NO in", values, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoNotIn(List<String> values) {
            addCriterion("DY_NO not in", values, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoBetween(String value1, String value2) {
            addCriterion("DY_NO between", value1, value2, "dyNo");
            return (Criteria) this;
        }

        public Criteria andDyNoNotBetween(String value1, String value2) {
            addCriterion("DY_NO not between", value1, value2, "dyNo");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalIsNull() {
            addCriterion("RAKEBACK_PRICE_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalIsNotNull() {
            addCriterion("RAKEBACK_PRICE_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_TOTAL =", value, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalNotEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_TOTAL <>", value, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalGreaterThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_TOTAL >", value, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_TOTAL >=", value, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalLessThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_TOTAL <", value, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_TOTAL <=", value, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE_TOTAL in", values, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalNotIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE_TOTAL not in", values, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE_TOTAL between", value1, value2, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE_TOTAL not between", value1, value2, "rakebackPriceTotal");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceIsNull() {
            addCriterion("COMP_RAKEBACK_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceIsNotNull() {
            addCriterion("COMP_RAKEBACK_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE =", value, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceNotEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE <>", value, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceGreaterThan(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE >", value, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE >=", value, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceLessThan(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE <", value, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE <=", value, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceIn(List<BigDecimal> values) {
            addCriterion("COMP_RAKEBACK_PRICE in", values, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceNotIn(List<BigDecimal> values) {
            addCriterion("COMP_RAKEBACK_PRICE not in", values, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMP_RAKEBACK_PRICE between", value1, value2, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMP_RAKEBACK_PRICE not between", value1, value2, "compRakebackPrice");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusIsNull() {
            addCriterion("COMP_RAKEBACK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusIsNotNull() {
            addCriterion("COMP_RAKEBACK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusEqualTo(Byte value) {
            addCriterion("COMP_RAKEBACK_STATUS =", value, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusNotEqualTo(Byte value) {
            addCriterion("COMP_RAKEBACK_STATUS <>", value, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusGreaterThan(Byte value) {
            addCriterion("COMP_RAKEBACK_STATUS >", value, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("COMP_RAKEBACK_STATUS >=", value, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusLessThan(Byte value) {
            addCriterion("COMP_RAKEBACK_STATUS <", value, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusLessThanOrEqualTo(Byte value) {
            addCriterion("COMP_RAKEBACK_STATUS <=", value, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusIn(List<Byte> values) {
            addCriterion("COMP_RAKEBACK_STATUS in", values, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusNotIn(List<Byte> values) {
            addCriterion("COMP_RAKEBACK_STATUS not in", values, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusBetween(Byte value1, Byte value2) {
            addCriterion("COMP_RAKEBACK_STATUS between", value1, value2, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("COMP_RAKEBACK_STATUS not between", value1, value2, "compRakebackStatus");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeIsNull() {
            addCriterion("COMP_RAKEBACK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeIsNotNull() {
            addCriterion("COMP_RAKEBACK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeEqualTo(Date value) {
            addCriterion("COMP_RAKEBACK_TIME =", value, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeNotEqualTo(Date value) {
            addCriterion("COMP_RAKEBACK_TIME <>", value, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeGreaterThan(Date value) {
            addCriterion("COMP_RAKEBACK_TIME >", value, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("COMP_RAKEBACK_TIME >=", value, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeLessThan(Date value) {
            addCriterion("COMP_RAKEBACK_TIME <", value, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeLessThanOrEqualTo(Date value) {
            addCriterion("COMP_RAKEBACK_TIME <=", value, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeIn(List<Date> values) {
            addCriterion("COMP_RAKEBACK_TIME in", values, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeNotIn(List<Date> values) {
            addCriterion("COMP_RAKEBACK_TIME not in", values, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeBetween(Date value1, Date value2) {
            addCriterion("COMP_RAKEBACK_TIME between", value1, value2, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompRakebackTimeNotBetween(Date value1, Date value2) {
            addCriterion("COMP_RAKEBACK_TIME not between", value1, value2, "compRakebackTime");
            return (Criteria) this;
        }

        public Criteria andCompIsCashIsNull() {
            addCriterion("COMP_IS_CASH is null");
            return (Criteria) this;
        }

        public Criteria andCompIsCashIsNotNull() {
            addCriterion("COMP_IS_CASH is not null");
            return (Criteria) this;
        }

        public Criteria andCompIsCashEqualTo(Byte value) {
            addCriterion("COMP_IS_CASH =", value, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashNotEqualTo(Byte value) {
            addCriterion("COMP_IS_CASH <>", value, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashGreaterThan(Byte value) {
            addCriterion("COMP_IS_CASH >", value, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashGreaterThanOrEqualTo(Byte value) {
            addCriterion("COMP_IS_CASH >=", value, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashLessThan(Byte value) {
            addCriterion("COMP_IS_CASH <", value, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashLessThanOrEqualTo(Byte value) {
            addCriterion("COMP_IS_CASH <=", value, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashIn(List<Byte> values) {
            addCriterion("COMP_IS_CASH in", values, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashNotIn(List<Byte> values) {
            addCriterion("COMP_IS_CASH not in", values, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashBetween(Byte value1, Byte value2) {
            addCriterion("COMP_IS_CASH between", value1, value2, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andCompIsCashNotBetween(Byte value1, Byte value2) {
            addCriterion("COMP_IS_CASH not between", value1, value2, "compIsCash");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitIsNull() {
            addCriterion("FINANCE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitIsNotNull() {
            addCriterion("FINANCE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitEqualTo(Integer value) {
            addCriterion("FINANCE_LIMIT =", value, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitNotEqualTo(Integer value) {
            addCriterion("FINANCE_LIMIT <>", value, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitGreaterThan(Integer value) {
            addCriterion("FINANCE_LIMIT >", value, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("FINANCE_LIMIT >=", value, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitLessThan(Integer value) {
            addCriterion("FINANCE_LIMIT <", value, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitLessThanOrEqualTo(Integer value) {
            addCriterion("FINANCE_LIMIT <=", value, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitIn(List<Integer> values) {
            addCriterion("FINANCE_LIMIT in", values, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitNotIn(List<Integer> values) {
            addCriterion("FINANCE_LIMIT not in", values, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitBetween(Integer value1, Integer value2) {
            addCriterion("FINANCE_LIMIT between", value1, value2, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andFinanceLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("FINANCE_LIMIT not between", value1, value2, "financeLimit");
            return (Criteria) this;
        }

        public Criteria andIsCloseIsNull() {
            addCriterion("IS_CLOSE is null");
            return (Criteria) this;
        }

        public Criteria andIsCloseIsNotNull() {
            addCriterion("IS_CLOSE is not null");
            return (Criteria) this;
        }

        public Criteria andIsCloseEqualTo(Byte value) {
            addCriterion("IS_CLOSE =", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseNotEqualTo(Byte value) {
            addCriterion("IS_CLOSE <>", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseGreaterThan(Byte value) {
            addCriterion("IS_CLOSE >", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_CLOSE >=", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseLessThan(Byte value) {
            addCriterion("IS_CLOSE <", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseLessThanOrEqualTo(Byte value) {
            addCriterion("IS_CLOSE <=", value, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseIn(List<Byte> values) {
            addCriterion("IS_CLOSE in", values, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseNotIn(List<Byte> values) {
            addCriterion("IS_CLOSE not in", values, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseBetween(Byte value1, Byte value2) {
            addCriterion("IS_CLOSE between", value1, value2, "isClose");
            return (Criteria) this;
        }

        public Criteria andIsCloseNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_CLOSE not between", value1, value2, "isClose");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdIsNull() {
            addCriterion("OLD_ARCHIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdIsNotNull() {
            addCriterion("OLD_ARCHIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdEqualTo(Integer value) {
            addCriterion("OLD_ARCHIVE_ID =", value, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdNotEqualTo(Integer value) {
            addCriterion("OLD_ARCHIVE_ID <>", value, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdGreaterThan(Integer value) {
            addCriterion("OLD_ARCHIVE_ID >", value, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OLD_ARCHIVE_ID >=", value, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdLessThan(Integer value) {
            addCriterion("OLD_ARCHIVE_ID <", value, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("OLD_ARCHIVE_ID <=", value, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdIn(List<Integer> values) {
            addCriterion("OLD_ARCHIVE_ID in", values, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdNotIn(List<Integer> values) {
            addCriterion("OLD_ARCHIVE_ID not in", values, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdBetween(Integer value1, Integer value2) {
            addCriterion("OLD_ARCHIVE_ID between", value1, value2, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andOldArchiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OLD_ARCHIVE_ID not between", value1, value2, "oldArchiveId");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeIsNull() {
            addCriterion("AUDIT_PASS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeIsNotNull() {
            addCriterion("AUDIT_PASS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeEqualTo(Date value) {
            addCriterion("AUDIT_PASS_TIME =", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeNotEqualTo(Date value) {
            addCriterion("AUDIT_PASS_TIME <>", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeGreaterThan(Date value) {
            addCriterion("AUDIT_PASS_TIME >", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDIT_PASS_TIME >=", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeLessThan(Date value) {
            addCriterion("AUDIT_PASS_TIME <", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeLessThanOrEqualTo(Date value) {
            addCriterion("AUDIT_PASS_TIME <=", value, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeIn(List<Date> values) {
            addCriterion("AUDIT_PASS_TIME in", values, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeNotIn(List<Date> values) {
            addCriterion("AUDIT_PASS_TIME not in", values, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeBetween(Date value1, Date value2) {
            addCriterion("AUDIT_PASS_TIME between", value1, value2, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditPassTimeNotBetween(Date value1, Date value2) {
            addCriterion("AUDIT_PASS_TIME not between", value1, value2, "auditPassTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeIsNull() {
            addCriterion("OLD_BROKER_WRITEOFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeIsNotNull() {
            addCriterion("OLD_BROKER_WRITEOFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeEqualTo(Date value) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME =", value, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeNotEqualTo(Date value) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME <>", value, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeGreaterThan(Date value) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME >", value, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME >=", value, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeLessThan(Date value) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME <", value, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeLessThanOrEqualTo(Date value) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME <=", value, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeIn(List<Date> values) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME in", values, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeNotIn(List<Date> values) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME not in", values, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeBetween(Date value1, Date value2) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME between", value1, value2, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andOldBrokerWriteoffTimeNotBetween(Date value1, Date value2) {
            addCriterion("OLD_BROKER_WRITEOFF_TIME not between", value1, value2, "oldBrokerWriteoffTime");
            return (Criteria) this;
        }

        public Criteria andInterviewCountIsNull() {
            addCriterion("INTERVIEW_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andInterviewCountIsNotNull() {
            addCriterion("INTERVIEW_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewCountEqualTo(Integer value) {
            addCriterion("INTERVIEW_COUNT =", value, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountNotEqualTo(Integer value) {
            addCriterion("INTERVIEW_COUNT <>", value, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountGreaterThan(Integer value) {
            addCriterion("INTERVIEW_COUNT >", value, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("INTERVIEW_COUNT >=", value, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountLessThan(Integer value) {
            addCriterion("INTERVIEW_COUNT <", value, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountLessThanOrEqualTo(Integer value) {
            addCriterion("INTERVIEW_COUNT <=", value, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountIn(List<Integer> values) {
            addCriterion("INTERVIEW_COUNT in", values, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountNotIn(List<Integer> values) {
            addCriterion("INTERVIEW_COUNT not in", values, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountBetween(Integer value1, Integer value2) {
            addCriterion("INTERVIEW_COUNT between", value1, value2, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andInterviewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("INTERVIEW_COUNT not between", value1, value2, "interviewCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountIsNull() {
            addCriterion("CANCEL_APPLY_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountIsNotNull() {
            addCriterion("CANCEL_APPLY_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountEqualTo(Integer value) {
            addCriterion("CANCEL_APPLY_COUNT =", value, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountNotEqualTo(Integer value) {
            addCriterion("CANCEL_APPLY_COUNT <>", value, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountGreaterThan(Integer value) {
            addCriterion("CANCEL_APPLY_COUNT >", value, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("CANCEL_APPLY_COUNT >=", value, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountLessThan(Integer value) {
            addCriterion("CANCEL_APPLY_COUNT <", value, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("CANCEL_APPLY_COUNT <=", value, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountIn(List<Integer> values) {
            addCriterion("CANCEL_APPLY_COUNT in", values, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountNotIn(List<Integer> values) {
            addCriterion("CANCEL_APPLY_COUNT not in", values, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountBetween(Integer value1, Integer value2) {
            addCriterion("CANCEL_APPLY_COUNT between", value1, value2, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andCancelApplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("CANCEL_APPLY_COUNT not between", value1, value2, "cancelApplyCount");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeIsNull() {
            addCriterion("PROTECT_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeIsNotNull() {
            addCriterion("PROTECT_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeEqualTo(Date value) {
            addCriterion("PROTECT_END_TIME =", value, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeNotEqualTo(Date value) {
            addCriterion("PROTECT_END_TIME <>", value, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeGreaterThan(Date value) {
            addCriterion("PROTECT_END_TIME >", value, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PROTECT_END_TIME >=", value, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeLessThan(Date value) {
            addCriterion("PROTECT_END_TIME <", value, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("PROTECT_END_TIME <=", value, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeIn(List<Date> values) {
            addCriterion("PROTECT_END_TIME in", values, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeNotIn(List<Date> values) {
            addCriterion("PROTECT_END_TIME not in", values, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeBetween(Date value1, Date value2) {
            addCriterion("PROTECT_END_TIME between", value1, value2, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andProtectEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("PROTECT_END_TIME not between", value1, value2, "protectEndTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeIsNull() {
            addCriterion("CANCEL_APPLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeIsNotNull() {
            addCriterion("CANCEL_APPLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeEqualTo(Date value) {
            addCriterion("CANCEL_APPLY_TIME =", value, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeNotEqualTo(Date value) {
            addCriterion("CANCEL_APPLY_TIME <>", value, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeGreaterThan(Date value) {
            addCriterion("CANCEL_APPLY_TIME >", value, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CANCEL_APPLY_TIME >=", value, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeLessThan(Date value) {
            addCriterion("CANCEL_APPLY_TIME <", value, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("CANCEL_APPLY_TIME <=", value, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeIn(List<Date> values) {
            addCriterion("CANCEL_APPLY_TIME in", values, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeNotIn(List<Date> values) {
            addCriterion("CANCEL_APPLY_TIME not in", values, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeBetween(Date value1, Date value2) {
            addCriterion("CANCEL_APPLY_TIME between", value1, value2, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andCancelApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("CANCEL_APPLY_TIME not between", value1, value2, "cancelApplyTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeIsNull() {
            addCriterion("CHANNEL_PASS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeIsNotNull() {
            addCriterion("CHANNEL_PASS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeEqualTo(Date value) {
            addCriterion("CHANNEL_PASS_TIME =", value, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeNotEqualTo(Date value) {
            addCriterion("CHANNEL_PASS_TIME <>", value, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeGreaterThan(Date value) {
            addCriterion("CHANNEL_PASS_TIME >", value, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHANNEL_PASS_TIME >=", value, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeLessThan(Date value) {
            addCriterion("CHANNEL_PASS_TIME <", value, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHANNEL_PASS_TIME <=", value, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeIn(List<Date> values) {
            addCriterion("CHANNEL_PASS_TIME in", values, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeNotIn(List<Date> values) {
            addCriterion("CHANNEL_PASS_TIME not in", values, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeBetween(Date value1, Date value2) {
            addCriterion("CHANNEL_PASS_TIME between", value1, value2, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andChannelPassTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHANNEL_PASS_TIME not between", value1, value2, "channelPassTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeIsNull() {
            addCriterion("AUDIT_ERROR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeIsNotNull() {
            addCriterion("AUDIT_ERROR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeEqualTo(Date value) {
            addCriterion("AUDIT_ERROR_TIME =", value, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeNotEqualTo(Date value) {
            addCriterion("AUDIT_ERROR_TIME <>", value, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeGreaterThan(Date value) {
            addCriterion("AUDIT_ERROR_TIME >", value, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDIT_ERROR_TIME >=", value, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeLessThan(Date value) {
            addCriterion("AUDIT_ERROR_TIME <", value, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeLessThanOrEqualTo(Date value) {
            addCriterion("AUDIT_ERROR_TIME <=", value, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeIn(List<Date> values) {
            addCriterion("AUDIT_ERROR_TIME in", values, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeNotIn(List<Date> values) {
            addCriterion("AUDIT_ERROR_TIME not in", values, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeBetween(Date value1, Date value2) {
            addCriterion("AUDIT_ERROR_TIME between", value1, value2, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andAuditErrorTimeNotBetween(Date value1, Date value2) {
            addCriterion("AUDIT_ERROR_TIME not between", value1, value2, "auditErrorTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeIsNull() {
            addCriterion("CUSTOMER_REVOKE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeIsNotNull() {
            addCriterion("CUSTOMER_REVOKE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeEqualTo(Date value) {
            addCriterion("CUSTOMER_REVOKE_TIME =", value, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeNotEqualTo(Date value) {
            addCriterion("CUSTOMER_REVOKE_TIME <>", value, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeGreaterThan(Date value) {
            addCriterion("CUSTOMER_REVOKE_TIME >", value, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CUSTOMER_REVOKE_TIME >=", value, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeLessThan(Date value) {
            addCriterion("CUSTOMER_REVOKE_TIME <", value, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeLessThanOrEqualTo(Date value) {
            addCriterion("CUSTOMER_REVOKE_TIME <=", value, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeIn(List<Date> values) {
            addCriterion("CUSTOMER_REVOKE_TIME in", values, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeNotIn(List<Date> values) {
            addCriterion("CUSTOMER_REVOKE_TIME not in", values, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeBetween(Date value1, Date value2) {
            addCriterion("CUSTOMER_REVOKE_TIME between", value1, value2, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andCustomerRevokeTimeNotBetween(Date value1, Date value2) {
            addCriterion("CUSTOMER_REVOKE_TIME not between", value1, value2, "customerRevokeTime");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationIsNull() {
            addCriterion("ENTRUST_INVITATION is null");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationIsNotNull() {
            addCriterion("ENTRUST_INVITATION is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationEqualTo(Byte value) {
            addCriterion("ENTRUST_INVITATION =", value, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationNotEqualTo(Byte value) {
            addCriterion("ENTRUST_INVITATION <>", value, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationGreaterThan(Byte value) {
            addCriterion("ENTRUST_INVITATION >", value, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationGreaterThanOrEqualTo(Byte value) {
            addCriterion("ENTRUST_INVITATION >=", value, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationLessThan(Byte value) {
            addCriterion("ENTRUST_INVITATION <", value, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationLessThanOrEqualTo(Byte value) {
            addCriterion("ENTRUST_INVITATION <=", value, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationIn(List<Byte> values) {
            addCriterion("ENTRUST_INVITATION in", values, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationNotIn(List<Byte> values) {
            addCriterion("ENTRUST_INVITATION not in", values, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationBetween(Byte value1, Byte value2) {
            addCriterion("ENTRUST_INVITATION between", value1, value2, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andEntrustInvitationNotBetween(Byte value1, Byte value2) {
            addCriterion("ENTRUST_INVITATION not between", value1, value2, "entrustInvitation");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxIsNull() {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX is null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxIsNotNull() {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX =", value, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxNotEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX <>", value, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxGreaterThan(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX >", value, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX >=", value, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxLessThan(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX <", value, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX <=", value, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxIn(List<BigDecimal> values) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX in", values, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxNotIn(List<BigDecimal> values) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX not in", values, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX between", value1, value2, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andCompRakebackPriceAfterTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMP_RAKEBACK_PRICE_AFTER_TAX not between", value1, value2, "compRakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxIsNull() {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX is null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxIsNotNull() {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX =", value, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxNotEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX <>", value, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxGreaterThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX >", value, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX >=", value, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxLessThan(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX <", value, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX <=", value, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX in", values, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxNotIn(List<BigDecimal> values) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX not in", values, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX between", value1, value2, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andRakebackPriceAfterTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RAKEBACK_PRICE_AFTER_TAX not between", value1, value2, "rakebackPriceAfterTax");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonIsNull() {
            addCriterion("AUDIT_ERROR_REASON is null");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonIsNotNull() {
            addCriterion("AUDIT_ERROR_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonEqualTo(String value) {
            addCriterion("AUDIT_ERROR_REASON =", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonNotEqualTo(String value) {
            addCriterion("AUDIT_ERROR_REASON <>", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonGreaterThan(String value) {
            addCriterion("AUDIT_ERROR_REASON >", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_ERROR_REASON >=", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonLessThan(String value) {
            addCriterion("AUDIT_ERROR_REASON <", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_ERROR_REASON <=", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonLike(String value) {
            addCriterion("AUDIT_ERROR_REASON like", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonNotLike(String value) {
            addCriterion("AUDIT_ERROR_REASON not like", value, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonIn(List<String> values) {
            addCriterion("AUDIT_ERROR_REASON in", values, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonNotIn(List<String> values) {
            addCriterion("AUDIT_ERROR_REASON not in", values, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonBetween(String value1, String value2) {
            addCriterion("AUDIT_ERROR_REASON between", value1, value2, "auditErrorReason");
            return (Criteria) this;
        }

        public Criteria andAuditErrorReasonNotBetween(String value1, String value2) {
            addCriterion("AUDIT_ERROR_REASON not between", value1, value2, "auditErrorReason");
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