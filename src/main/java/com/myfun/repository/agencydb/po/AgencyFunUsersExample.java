package com.myfun.repository.agencydb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgencyFunUsersExample {
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
    public AgencyFunUsersExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdIsNull() {
            addCriterion("DEVLOPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andDevloperIdIsNotNull() {
            addCriterion("DEVLOPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDevloperIdEqualTo(Integer value) {
            addCriterion("DEVLOPER_ID =", value, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdNotEqualTo(Integer value) {
            addCriterion("DEVLOPER_ID <>", value, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdGreaterThan(Integer value) {
            addCriterion("DEVLOPER_ID >", value, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEVLOPER_ID >=", value, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdLessThan(Integer value) {
            addCriterion("DEVLOPER_ID <", value, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEVLOPER_ID <=", value, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdIn(List<Integer> values) {
            addCriterion("DEVLOPER_ID in", values, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdNotIn(List<Integer> values) {
            addCriterion("DEVLOPER_ID not in", values, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdBetween(Integer value1, Integer value2) {
            addCriterion("DEVLOPER_ID between", value1, value2, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDevloperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEVLOPER_ID not between", value1, value2, "devloperId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("DEPT_ID =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("DEPT_ID <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("DEPT_ID >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("DEPT_ID <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("DEPT_ID in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("DEPT_ID not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andBCityIdIsNull() {
            addCriterion("B_CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andBCityIdIsNotNull() {
            addCriterion("B_CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBCityIdEqualTo(Short value) {
            addCriterion("B_CITY_ID =", value, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdNotEqualTo(Short value) {
            addCriterion("B_CITY_ID <>", value, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdGreaterThan(Short value) {
            addCriterion("B_CITY_ID >", value, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdGreaterThanOrEqualTo(Short value) {
            addCriterion("B_CITY_ID >=", value, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdLessThan(Short value) {
            addCriterion("B_CITY_ID <", value, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdLessThanOrEqualTo(Short value) {
            addCriterion("B_CITY_ID <=", value, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdIn(List<Short> values) {
            addCriterion("B_CITY_ID in", values, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdNotIn(List<Short> values) {
            addCriterion("B_CITY_ID not in", values, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdBetween(Short value1, Short value2) {
            addCriterion("B_CITY_ID between", value1, value2, "bCityId");
            return (Criteria) this;
        }

        public Criteria andBCityIdNotBetween(Short value1, Short value2) {
            addCriterion("B_CITY_ID not between", value1, value2, "bCityId");
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

        public Criteria andLoginUidIsNull() {
            addCriterion("LOGIN_UID is null");
            return (Criteria) this;
        }

        public Criteria andLoginUidIsNotNull() {
            addCriterion("LOGIN_UID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUidEqualTo(String value) {
            addCriterion("LOGIN_UID =", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotEqualTo(String value) {
            addCriterion("LOGIN_UID <>", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidGreaterThan(String value) {
            addCriterion("LOGIN_UID >", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_UID >=", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidLessThan(String value) {
            addCriterion("LOGIN_UID <", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_UID <=", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidLike(String value) {
            addCriterion("LOGIN_UID like", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotLike(String value) {
            addCriterion("LOGIN_UID not like", value, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidIn(List<String> values) {
            addCriterion("LOGIN_UID in", values, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotIn(List<String> values) {
            addCriterion("LOGIN_UID not in", values, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidBetween(String value1, String value2) {
            addCriterion("LOGIN_UID between", value1, value2, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginUidNotBetween(String value1, String value2) {
            addCriterion("LOGIN_UID not between", value1, value2, "loginUid");
            return (Criteria) this;
        }

        public Criteria andLoginPwdIsNull() {
            addCriterion("LOGIN_PWD is null");
            return (Criteria) this;
        }

        public Criteria andLoginPwdIsNotNull() {
            addCriterion("LOGIN_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPwdEqualTo(String value) {
            addCriterion("LOGIN_PWD =", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotEqualTo(String value) {
            addCriterion("LOGIN_PWD <>", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdGreaterThan(String value) {
            addCriterion("LOGIN_PWD >", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_PWD >=", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdLessThan(String value) {
            addCriterion("LOGIN_PWD <", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_PWD <=", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdLike(String value) {
            addCriterion("LOGIN_PWD like", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotLike(String value) {
            addCriterion("LOGIN_PWD not like", value, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdIn(List<String> values) {
            addCriterion("LOGIN_PWD in", values, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotIn(List<String> values) {
            addCriterion("LOGIN_PWD not in", values, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdBetween(String value1, String value2) {
            addCriterion("LOGIN_PWD between", value1, value2, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andLoginPwdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_PWD not between", value1, value2, "loginPwd");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("USER_SEX is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("USER_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Boolean value) {
            addCriterion("USER_SEX =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Boolean value) {
            addCriterion("USER_SEX <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Boolean value) {
            addCriterion("USER_SEX >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("USER_SEX >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Boolean value) {
            addCriterion("USER_SEX <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Boolean value) {
            addCriterion("USER_SEX <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Boolean> values) {
            addCriterion("USER_SEX in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Boolean> values) {
            addCriterion("USER_SEX not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Boolean value1, Boolean value2) {
            addCriterion("USER_SEX between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("USER_SEX not between", value1, value2, "userSex");
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

        public Criteria andUserPositionIsNull() {
            addCriterion("USER_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andUserPositionIsNotNull() {
            addCriterion("USER_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andUserPositionEqualTo(String value) {
            addCriterion("USER_POSITION =", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotEqualTo(String value) {
            addCriterion("USER_POSITION <>", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionGreaterThan(String value) {
            addCriterion("USER_POSITION >", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionGreaterThanOrEqualTo(String value) {
            addCriterion("USER_POSITION >=", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionLessThan(String value) {
            addCriterion("USER_POSITION <", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionLessThanOrEqualTo(String value) {
            addCriterion("USER_POSITION <=", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionLike(String value) {
            addCriterion("USER_POSITION like", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotLike(String value) {
            addCriterion("USER_POSITION not like", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionIn(List<String> values) {
            addCriterion("USER_POSITION in", values, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotIn(List<String> values) {
            addCriterion("USER_POSITION not in", values, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionBetween(String value1, String value2) {
            addCriterion("USER_POSITION between", value1, value2, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotBetween(String value1, String value2) {
            addCriterion("USER_POSITION not between", value1, value2, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("USER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("USER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(String value) {
            addCriterion("USER_STATUS =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(String value) {
            addCriterion("USER_STATUS <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(String value) {
            addCriterion("USER_STATUS >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(String value) {
            addCriterion("USER_STATUS >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(String value) {
            addCriterion("USER_STATUS <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(String value) {
            addCriterion("USER_STATUS <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLike(String value) {
            addCriterion("USER_STATUS like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotLike(String value) {
            addCriterion("USER_STATUS not like", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<String> values) {
            addCriterion("USER_STATUS in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<String> values) {
            addCriterion("USER_STATUS not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(String value1, String value2) {
            addCriterion("USER_STATUS between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(String value1, String value2) {
            addCriterion("USER_STATUS not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIsNull() {
            addCriterion("SMS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIsNotNull() {
            addCriterion("SMS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSmsCodeEqualTo(String value) {
            addCriterion("SMS_CODE =", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotEqualTo(String value) {
            addCriterion("SMS_CODE <>", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeGreaterThan(String value) {
            addCriterion("SMS_CODE >", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_CODE >=", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLessThan(String value) {
            addCriterion("SMS_CODE <", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLessThanOrEqualTo(String value) {
            addCriterion("SMS_CODE <=", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLike(String value) {
            addCriterion("SMS_CODE like", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotLike(String value) {
            addCriterion("SMS_CODE not like", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIn(List<String> values) {
            addCriterion("SMS_CODE in", values, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotIn(List<String> values) {
            addCriterion("SMS_CODE not in", values, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeBetween(String value1, String value2) {
            addCriterion("SMS_CODE between", value1, value2, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotBetween(String value1, String value2) {
            addCriterion("SMS_CODE not between", value1, value2, "smsCode");
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

        public Criteria andUserEmailIsNull() {
            addCriterion("USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("USER_EMAIL =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("USER_EMAIL <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("USER_EMAIL >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("USER_EMAIL <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("USER_EMAIL like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("USER_EMAIL not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("USER_EMAIL in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("USER_EMAIL not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("USER_EMAIL between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIsNull() {
            addCriterion("USER_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIsNotNull() {
            addCriterion("USER_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoEqualTo(String value) {
            addCriterion("USER_PHOTO =", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotEqualTo(String value) {
            addCriterion("USER_PHOTO <>", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoGreaterThan(String value) {
            addCriterion("USER_PHOTO >", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO >=", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLessThan(String value) {
            addCriterion("USER_PHOTO <", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLessThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO <=", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLike(String value) {
            addCriterion("USER_PHOTO like", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotLike(String value) {
            addCriterion("USER_PHOTO not like", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIn(List<String> values) {
            addCriterion("USER_PHOTO in", values, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotIn(List<String> values) {
            addCriterion("USER_PHOTO not in", values, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoBetween(String value1, String value2) {
            addCriterion("USER_PHOTO between", value1, value2, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotBetween(String value1, String value2) {
            addCriterion("USER_PHOTO not between", value1, value2, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andPayPwdIsNull() {
            addCriterion("PAY_PWD is null");
            return (Criteria) this;
        }

        public Criteria andPayPwdIsNotNull() {
            addCriterion("PAY_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andPayPwdEqualTo(String value) {
            addCriterion("PAY_PWD =", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotEqualTo(String value) {
            addCriterion("PAY_PWD <>", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdGreaterThan(String value) {
            addCriterion("PAY_PWD >", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_PWD >=", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdLessThan(String value) {
            addCriterion("PAY_PWD <", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdLessThanOrEqualTo(String value) {
            addCriterion("PAY_PWD <=", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdLike(String value) {
            addCriterion("PAY_PWD like", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotLike(String value) {
            addCriterion("PAY_PWD not like", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdIn(List<String> values) {
            addCriterion("PAY_PWD in", values, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotIn(List<String> values) {
            addCriterion("PAY_PWD not in", values, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdBetween(String value1, String value2) {
            addCriterion("PAY_PWD between", value1, value2, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotBetween(String value1, String value2) {
            addCriterion("PAY_PWD not between", value1, value2, "payPwd");
            return (Criteria) this;
        }

        public Criteria andUserQqIsNull() {
            addCriterion("USER_QQ is null");
            return (Criteria) this;
        }

        public Criteria andUserQqIsNotNull() {
            addCriterion("USER_QQ is not null");
            return (Criteria) this;
        }

        public Criteria andUserQqEqualTo(String value) {
            addCriterion("USER_QQ =", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotEqualTo(String value) {
            addCriterion("USER_QQ <>", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqGreaterThan(String value) {
            addCriterion("USER_QQ >", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqGreaterThanOrEqualTo(String value) {
            addCriterion("USER_QQ >=", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLessThan(String value) {
            addCriterion("USER_QQ <", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLessThanOrEqualTo(String value) {
            addCriterion("USER_QQ <=", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLike(String value) {
            addCriterion("USER_QQ like", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotLike(String value) {
            addCriterion("USER_QQ not like", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqIn(List<String> values) {
            addCriterion("USER_QQ in", values, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotIn(List<String> values) {
            addCriterion("USER_QQ not in", values, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqBetween(String value1, String value2) {
            addCriterion("USER_QQ between", value1, value2, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotBetween(String value1, String value2) {
            addCriterion("USER_QQ not between", value1, value2, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionIsNull() {
            addCriterion("USER_JURISDICTION is null");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionIsNotNull() {
            addCriterion("USER_JURISDICTION is not null");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionEqualTo(String value) {
            addCriterion("USER_JURISDICTION =", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionNotEqualTo(String value) {
            addCriterion("USER_JURISDICTION <>", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionGreaterThan(String value) {
            addCriterion("USER_JURISDICTION >", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionGreaterThanOrEqualTo(String value) {
            addCriterion("USER_JURISDICTION >=", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionLessThan(String value) {
            addCriterion("USER_JURISDICTION <", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionLessThanOrEqualTo(String value) {
            addCriterion("USER_JURISDICTION <=", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionLike(String value) {
            addCriterion("USER_JURISDICTION like", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionNotLike(String value) {
            addCriterion("USER_JURISDICTION not like", value, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionIn(List<String> values) {
            addCriterion("USER_JURISDICTION in", values, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionNotIn(List<String> values) {
            addCriterion("USER_JURISDICTION not in", values, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionBetween(String value1, String value2) {
            addCriterion("USER_JURISDICTION between", value1, value2, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andUserJurisdictionNotBetween(String value1, String value2) {
            addCriterion("USER_JURISDICTION not between", value1, value2, "userJurisdiction");
            return (Criteria) this;
        }

        public Criteria andPhone400IsNull() {
            addCriterion("PHONE_400 is null");
            return (Criteria) this;
        }

        public Criteria andPhone400IsNotNull() {
            addCriterion("PHONE_400 is not null");
            return (Criteria) this;
        }

        public Criteria andPhone400EqualTo(String value) {
            addCriterion("PHONE_400 =", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400NotEqualTo(String value) {
            addCriterion("PHONE_400 <>", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400GreaterThan(String value) {
            addCriterion("PHONE_400 >", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400GreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_400 >=", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400LessThan(String value) {
            addCriterion("PHONE_400 <", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400LessThanOrEqualTo(String value) {
            addCriterion("PHONE_400 <=", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400Like(String value) {
            addCriterion("PHONE_400 like", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400NotLike(String value) {
            addCriterion("PHONE_400 not like", value, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400In(List<String> values) {
            addCriterion("PHONE_400 in", values, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400NotIn(List<String> values) {
            addCriterion("PHONE_400 not in", values, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400Between(String value1, String value2) {
            addCriterion("PHONE_400 between", value1, value2, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhone400NotBetween(String value1, String value2) {
            addCriterion("PHONE_400 not between", value1, value2, "phone400");
            return (Criteria) this;
        }

        public Criteria andPhoneRealIsNull() {
            addCriterion("PHONE_REAL is null");
            return (Criteria) this;
        }

        public Criteria andPhoneRealIsNotNull() {
            addCriterion("PHONE_REAL is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneRealEqualTo(String value) {
            addCriterion("PHONE_REAL =", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealNotEqualTo(String value) {
            addCriterion("PHONE_REAL <>", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealGreaterThan(String value) {
            addCriterion("PHONE_REAL >", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_REAL >=", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealLessThan(String value) {
            addCriterion("PHONE_REAL <", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealLessThanOrEqualTo(String value) {
            addCriterion("PHONE_REAL <=", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealLike(String value) {
            addCriterion("PHONE_REAL like", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealNotLike(String value) {
            addCriterion("PHONE_REAL not like", value, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealIn(List<String> values) {
            addCriterion("PHONE_REAL in", values, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealNotIn(List<String> values) {
            addCriterion("PHONE_REAL not in", values, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealBetween(String value1, String value2) {
            addCriterion("PHONE_REAL between", value1, value2, "phoneReal");
            return (Criteria) this;
        }

        public Criteria andPhoneRealNotBetween(String value1, String value2) {
            addCriterion("PHONE_REAL not between", value1, value2, "phoneReal");
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