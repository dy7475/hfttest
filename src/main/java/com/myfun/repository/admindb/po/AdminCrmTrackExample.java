package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminCrmTrackExample {
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
    public AdminCrmTrackExample() {
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

        public Criteria andTrackIdIsNull() {
            addCriterion("TRACK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTrackIdIsNotNull() {
            addCriterion("TRACK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTrackIdEqualTo(Integer value) {
            addCriterion("TRACK_ID =", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdNotEqualTo(Integer value) {
            addCriterion("TRACK_ID <>", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdGreaterThan(Integer value) {
            addCriterion("TRACK_ID >", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRACK_ID >=", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdLessThan(Integer value) {
            addCriterion("TRACK_ID <", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdLessThanOrEqualTo(Integer value) {
            addCriterion("TRACK_ID <=", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdIn(List<Integer> values) {
            addCriterion("TRACK_ID in", values, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdNotIn(List<Integer> values) {
            addCriterion("TRACK_ID not in", values, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdBetween(Integer value1, Integer value2) {
            addCriterion("TRACK_ID between", value1, value2, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TRACK_ID not between", value1, value2, "trackId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("PROVINCE_ID =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("PROVINCE_ID <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("PROVINCE_ID >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_ID >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("PROVINCE_ID <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_ID <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("PROVINCE_ID in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("PROVINCE_ID not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
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

        public Criteria andCompIdIsNull() {
            addCriterion("COMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompIdIsNotNull() {
            addCriterion("COMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompIdEqualTo(Integer value) {
            addCriterion("COMP_ID =", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotEqualTo(Integer value) {
            addCriterion("COMP_ID <>", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThan(Integer value) {
            addCriterion("COMP_ID >", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMP_ID >=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThan(Integer value) {
            addCriterion("COMP_ID <", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMP_ID <=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdIn(List<Integer> values) {
            addCriterion("COMP_ID in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotIn(List<Integer> values) {
            addCriterion("COMP_ID not in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdBetween(Integer value1, Integer value2) {
            addCriterion("COMP_ID between", value1, value2, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMP_ID not between", value1, value2, "compId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdIsNull() {
            addCriterion("CRM_COMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdIsNotNull() {
            addCriterion("CRM_COMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdEqualTo(Integer value) {
            addCriterion("CRM_COMP_ID =", value, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdNotEqualTo(Integer value) {
            addCriterion("CRM_COMP_ID <>", value, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdGreaterThan(Integer value) {
            addCriterion("CRM_COMP_ID >", value, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CRM_COMP_ID >=", value, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdLessThan(Integer value) {
            addCriterion("CRM_COMP_ID <", value, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdLessThanOrEqualTo(Integer value) {
            addCriterion("CRM_COMP_ID <=", value, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdIn(List<Integer> values) {
            addCriterion("CRM_COMP_ID in", values, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdNotIn(List<Integer> values) {
            addCriterion("CRM_COMP_ID not in", values, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdBetween(Integer value1, Integer value2) {
            addCriterion("CRM_COMP_ID between", value1, value2, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmCompIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CRM_COMP_ID not between", value1, value2, "crmCompId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdIsNull() {
            addCriterion("CRM_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdIsNotNull() {
            addCriterion("CRM_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdEqualTo(Integer value) {
            addCriterion("CRM_DEPT_ID =", value, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdNotEqualTo(Integer value) {
            addCriterion("CRM_DEPT_ID <>", value, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdGreaterThan(Integer value) {
            addCriterion("CRM_DEPT_ID >", value, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CRM_DEPT_ID >=", value, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdLessThan(Integer value) {
            addCriterion("CRM_DEPT_ID <", value, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("CRM_DEPT_ID <=", value, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdIn(List<Integer> values) {
            addCriterion("CRM_DEPT_ID in", values, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdNotIn(List<Integer> values) {
            addCriterion("CRM_DEPT_ID not in", values, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("CRM_DEPT_ID between", value1, value2, "crmDeptId");
            return (Criteria) this;
        }

        public Criteria andCrmDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CRM_DEPT_ID not between", value1, value2, "crmDeptId");
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

        public Criteria andUserTeleIsNull() {
            addCriterion("USER_TELE is null");
            return (Criteria) this;
        }

        public Criteria andUserTeleIsNotNull() {
            addCriterion("USER_TELE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTeleEqualTo(String value) {
            addCriterion("USER_TELE =", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleNotEqualTo(String value) {
            addCriterion("USER_TELE <>", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleGreaterThan(String value) {
            addCriterion("USER_TELE >", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TELE >=", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleLessThan(String value) {
            addCriterion("USER_TELE <", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleLessThanOrEqualTo(String value) {
            addCriterion("USER_TELE <=", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleLike(String value) {
            addCriterion("USER_TELE like", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleNotLike(String value) {
            addCriterion("USER_TELE not like", value, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleIn(List<String> values) {
            addCriterion("USER_TELE in", values, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleNotIn(List<String> values) {
            addCriterion("USER_TELE not in", values, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleBetween(String value1, String value2) {
            addCriterion("USER_TELE between", value1, value2, "userTele");
            return (Criteria) this;
        }

        public Criteria andUserTeleNotBetween(String value1, String value2) {
            addCriterion("USER_TELE not between", value1, value2, "userTele");
            return (Criteria) this;
        }

        public Criteria andTrackTypeIsNull() {
            addCriterion("TRACK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTrackTypeIsNotNull() {
            addCriterion("TRACK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTrackTypeEqualTo(String value) {
            addCriterion("TRACK_TYPE =", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeNotEqualTo(String value) {
            addCriterion("TRACK_TYPE <>", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeGreaterThan(String value) {
            addCriterion("TRACK_TYPE >", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TRACK_TYPE >=", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeLessThan(String value) {
            addCriterion("TRACK_TYPE <", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeLessThanOrEqualTo(String value) {
            addCriterion("TRACK_TYPE <=", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeLike(String value) {
            addCriterion("TRACK_TYPE like", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeNotLike(String value) {
            addCriterion("TRACK_TYPE not like", value, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeIn(List<String> values) {
            addCriterion("TRACK_TYPE in", values, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeNotIn(List<String> values) {
            addCriterion("TRACK_TYPE not in", values, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeBetween(String value1, String value2) {
            addCriterion("TRACK_TYPE between", value1, value2, "trackType");
            return (Criteria) this;
        }

        public Criteria andTrackTypeNotBetween(String value1, String value2) {
            addCriterion("TRACK_TYPE not between", value1, value2, "trackType");
            return (Criteria) this;
        }

        public Criteria andTypeDescIsNull() {
            addCriterion("TYPE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andTypeDescIsNotNull() {
            addCriterion("TYPE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDescEqualTo(String value) {
            addCriterion("TYPE_DESC =", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotEqualTo(String value) {
            addCriterion("TYPE_DESC <>", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThan(String value) {
            addCriterion("TYPE_DESC >", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_DESC >=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThan(String value) {
            addCriterion("TYPE_DESC <", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThanOrEqualTo(String value) {
            addCriterion("TYPE_DESC <=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLike(String value) {
            addCriterion("TYPE_DESC like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotLike(String value) {
            addCriterion("TYPE_DESC not like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescIn(List<String> values) {
            addCriterion("TYPE_DESC in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotIn(List<String> values) {
            addCriterion("TYPE_DESC not in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescBetween(String value1, String value2) {
            addCriterion("TYPE_DESC between", value1, value2, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotBetween(String value1, String value2) {
            addCriterion("TYPE_DESC not between", value1, value2, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTrackStyleIsNull() {
            addCriterion("TRACK_STYLE is null");
            return (Criteria) this;
        }

        public Criteria andTrackStyleIsNotNull() {
            addCriterion("TRACK_STYLE is not null");
            return (Criteria) this;
        }

        public Criteria andTrackStyleEqualTo(String value) {
            addCriterion("TRACK_STYLE =", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleNotEqualTo(String value) {
            addCriterion("TRACK_STYLE <>", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleGreaterThan(String value) {
            addCriterion("TRACK_STYLE >", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleGreaterThanOrEqualTo(String value) {
            addCriterion("TRACK_STYLE >=", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleLessThan(String value) {
            addCriterion("TRACK_STYLE <", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleLessThanOrEqualTo(String value) {
            addCriterion("TRACK_STYLE <=", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleLike(String value) {
            addCriterion("TRACK_STYLE like", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleNotLike(String value) {
            addCriterion("TRACK_STYLE not like", value, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleIn(List<String> values) {
            addCriterion("TRACK_STYLE in", values, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleNotIn(List<String> values) {
            addCriterion("TRACK_STYLE not in", values, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleBetween(String value1, String value2) {
            addCriterion("TRACK_STYLE between", value1, value2, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andTrackStyleNotBetween(String value1, String value2) {
            addCriterion("TRACK_STYLE not between", value1, value2, "trackStyle");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("SERVICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("SERVICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("SERVICE_TYPE =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("SERVICE_TYPE <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("SERVICE_TYPE >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("SERVICE_TYPE <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("SERVICE_TYPE like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("SERVICE_TYPE not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("SERVICE_TYPE in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("SERVICE_TYPE not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelIsNull() {
            addCriterion("SALE_EVAL_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelIsNotNull() {
            addCriterion("SALE_EVAL_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelEqualTo(Integer value) {
            addCriterion("SALE_EVAL_LEVEL =", value, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelNotEqualTo(Integer value) {
            addCriterion("SALE_EVAL_LEVEL <>", value, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelGreaterThan(Integer value) {
            addCriterion("SALE_EVAL_LEVEL >", value, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("SALE_EVAL_LEVEL >=", value, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelLessThan(Integer value) {
            addCriterion("SALE_EVAL_LEVEL <", value, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelLessThanOrEqualTo(Integer value) {
            addCriterion("SALE_EVAL_LEVEL <=", value, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelIn(List<Integer> values) {
            addCriterion("SALE_EVAL_LEVEL in", values, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelNotIn(List<Integer> values) {
            addCriterion("SALE_EVAL_LEVEL not in", values, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelBetween(Integer value1, Integer value2) {
            addCriterion("SALE_EVAL_LEVEL between", value1, value2, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSaleEvalLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("SALE_EVAL_LEVEL not between", value1, value2, "saleEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelIsNull() {
            addCriterion("SOFT_EVAL_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelIsNotNull() {
            addCriterion("SOFT_EVAL_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelEqualTo(Integer value) {
            addCriterion("SOFT_EVAL_LEVEL =", value, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelNotEqualTo(Integer value) {
            addCriterion("SOFT_EVAL_LEVEL <>", value, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelGreaterThan(Integer value) {
            addCriterion("SOFT_EVAL_LEVEL >", value, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOFT_EVAL_LEVEL >=", value, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelLessThan(Integer value) {
            addCriterion("SOFT_EVAL_LEVEL <", value, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelLessThanOrEqualTo(Integer value) {
            addCriterion("SOFT_EVAL_LEVEL <=", value, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelIn(List<Integer> values) {
            addCriterion("SOFT_EVAL_LEVEL in", values, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelNotIn(List<Integer> values) {
            addCriterion("SOFT_EVAL_LEVEL not in", values, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelBetween(Integer value1, Integer value2) {
            addCriterion("SOFT_EVAL_LEVEL between", value1, value2, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andSoftEvalLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("SOFT_EVAL_LEVEL not between", value1, value2, "softEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelIsNull() {
            addCriterion("SERV_EVAL_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelIsNotNull() {
            addCriterion("SERV_EVAL_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelEqualTo(Integer value) {
            addCriterion("SERV_EVAL_LEVEL =", value, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelNotEqualTo(Integer value) {
            addCriterion("SERV_EVAL_LEVEL <>", value, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelGreaterThan(Integer value) {
            addCriterion("SERV_EVAL_LEVEL >", value, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_EVAL_LEVEL >=", value, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelLessThan(Integer value) {
            addCriterion("SERV_EVAL_LEVEL <", value, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_EVAL_LEVEL <=", value, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelIn(List<Integer> values) {
            addCriterion("SERV_EVAL_LEVEL in", values, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelNotIn(List<Integer> values) {
            addCriterion("SERV_EVAL_LEVEL not in", values, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelBetween(Integer value1, Integer value2) {
            addCriterion("SERV_EVAL_LEVEL between", value1, value2, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andServEvalLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_EVAL_LEVEL not between", value1, value2, "servEvalLevel");
            return (Criteria) this;
        }

        public Criteria andTrackWarmIsNull() {
            addCriterion("TRACK_WARM is null");
            return (Criteria) this;
        }

        public Criteria andTrackWarmIsNotNull() {
            addCriterion("TRACK_WARM is not null");
            return (Criteria) this;
        }

        public Criteria andTrackWarmEqualTo(Integer value) {
            addCriterion("TRACK_WARM =", value, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmNotEqualTo(Integer value) {
            addCriterion("TRACK_WARM <>", value, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmGreaterThan(Integer value) {
            addCriterion("TRACK_WARM >", value, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRACK_WARM >=", value, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmLessThan(Integer value) {
            addCriterion("TRACK_WARM <", value, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmLessThanOrEqualTo(Integer value) {
            addCriterion("TRACK_WARM <=", value, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmIn(List<Integer> values) {
            addCriterion("TRACK_WARM in", values, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmNotIn(List<Integer> values) {
            addCriterion("TRACK_WARM not in", values, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmBetween(Integer value1, Integer value2) {
            addCriterion("TRACK_WARM between", value1, value2, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andTrackWarmNotBetween(Integer value1, Integer value2) {
            addCriterion("TRACK_WARM not between", value1, value2, "trackWarm");
            return (Criteria) this;
        }

        public Criteria andWarmUserIsNull() {
            addCriterion("WARM_USER is null");
            return (Criteria) this;
        }

        public Criteria andWarmUserIsNotNull() {
            addCriterion("WARM_USER is not null");
            return (Criteria) this;
        }

        public Criteria andWarmUserEqualTo(Integer value) {
            addCriterion("WARM_USER =", value, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserNotEqualTo(Integer value) {
            addCriterion("WARM_USER <>", value, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserGreaterThan(Integer value) {
            addCriterion("WARM_USER >", value, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("WARM_USER >=", value, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserLessThan(Integer value) {
            addCriterion("WARM_USER <", value, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserLessThanOrEqualTo(Integer value) {
            addCriterion("WARM_USER <=", value, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserIn(List<Integer> values) {
            addCriterion("WARM_USER in", values, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserNotIn(List<Integer> values) {
            addCriterion("WARM_USER not in", values, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserBetween(Integer value1, Integer value2) {
            addCriterion("WARM_USER between", value1, value2, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmUserNotBetween(Integer value1, Integer value2) {
            addCriterion("WARM_USER not between", value1, value2, "warmUser");
            return (Criteria) this;
        }

        public Criteria andWarmTimeIsNull() {
            addCriterion("WARM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWarmTimeIsNotNull() {
            addCriterion("WARM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWarmTimeEqualTo(Date value) {
            addCriterion("WARM_TIME =", value, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeNotEqualTo(Date value) {
            addCriterion("WARM_TIME <>", value, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeGreaterThan(Date value) {
            addCriterion("WARM_TIME >", value, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WARM_TIME >=", value, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeLessThan(Date value) {
            addCriterion("WARM_TIME <", value, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("WARM_TIME <=", value, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeIn(List<Date> values) {
            addCriterion("WARM_TIME in", values, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeNotIn(List<Date> values) {
            addCriterion("WARM_TIME not in", values, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeBetween(Date value1, Date value2) {
            addCriterion("WARM_TIME between", value1, value2, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("WARM_TIME not between", value1, value2, "warmTime");
            return (Criteria) this;
        }

        public Criteria andWarmContentIsNull() {
            addCriterion("WARM_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andWarmContentIsNotNull() {
            addCriterion("WARM_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andWarmContentEqualTo(String value) {
            addCriterion("WARM_CONTENT =", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentNotEqualTo(String value) {
            addCriterion("WARM_CONTENT <>", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentGreaterThan(String value) {
            addCriterion("WARM_CONTENT >", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentGreaterThanOrEqualTo(String value) {
            addCriterion("WARM_CONTENT >=", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentLessThan(String value) {
            addCriterion("WARM_CONTENT <", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentLessThanOrEqualTo(String value) {
            addCriterion("WARM_CONTENT <=", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentLike(String value) {
            addCriterion("WARM_CONTENT like", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentNotLike(String value) {
            addCriterion("WARM_CONTENT not like", value, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentIn(List<String> values) {
            addCriterion("WARM_CONTENT in", values, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentNotIn(List<String> values) {
            addCriterion("WARM_CONTENT not in", values, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentBetween(String value1, String value2) {
            addCriterion("WARM_CONTENT between", value1, value2, "warmContent");
            return (Criteria) this;
        }

        public Criteria andWarmContentNotBetween(String value1, String value2) {
            addCriterion("WARM_CONTENT not between", value1, value2, "warmContent");
            return (Criteria) this;
        }

        public Criteria andCreatorUidIsNull() {
            addCriterion("CREATOR_UID is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUidIsNotNull() {
            addCriterion("CREATOR_UID is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUidEqualTo(Integer value) {
            addCriterion("CREATOR_UID =", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidNotEqualTo(Integer value) {
            addCriterion("CREATOR_UID <>", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidGreaterThan(Integer value) {
            addCriterion("CREATOR_UID >", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATOR_UID >=", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidLessThan(Integer value) {
            addCriterion("CREATOR_UID <", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidLessThanOrEqualTo(Integer value) {
            addCriterion("CREATOR_UID <=", value, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidIn(List<Integer> values) {
            addCriterion("CREATOR_UID in", values, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidNotIn(List<Integer> values) {
            addCriterion("CREATOR_UID not in", values, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidBetween(Integer value1, Integer value2) {
            addCriterion("CREATOR_UID between", value1, value2, "creatorUid");
            return (Criteria) this;
        }

        public Criteria andCreatorUidNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATOR_UID not between", value1, value2, "creatorUid");
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

        public Criteria andRealWeixinIsNull() {
            addCriterion("REAL_WEIXIN is null");
            return (Criteria) this;
        }

        public Criteria andRealWeixinIsNotNull() {
            addCriterion("REAL_WEIXIN is not null");
            return (Criteria) this;
        }

        public Criteria andRealWeixinEqualTo(Byte value) {
            addCriterion("REAL_WEIXIN =", value, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinNotEqualTo(Byte value) {
            addCriterion("REAL_WEIXIN <>", value, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinGreaterThan(Byte value) {
            addCriterion("REAL_WEIXIN >", value, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinGreaterThanOrEqualTo(Byte value) {
            addCriterion("REAL_WEIXIN >=", value, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinLessThan(Byte value) {
            addCriterion("REAL_WEIXIN <", value, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinLessThanOrEqualTo(Byte value) {
            addCriterion("REAL_WEIXIN <=", value, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinIn(List<Byte> values) {
            addCriterion("REAL_WEIXIN in", values, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinNotIn(List<Byte> values) {
            addCriterion("REAL_WEIXIN not in", values, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinBetween(Byte value1, Byte value2) {
            addCriterion("REAL_WEIXIN between", value1, value2, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andRealWeixinNotBetween(Byte value1, Byte value2) {
            addCriterion("REAL_WEIXIN not between", value1, value2, "realWeixin");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointIsNull() {
            addCriterion("FORCED_SINGLE_POINT is null");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointIsNotNull() {
            addCriterion("FORCED_SINGLE_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointEqualTo(String value) {
            addCriterion("FORCED_SINGLE_POINT =", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointNotEqualTo(String value) {
            addCriterion("FORCED_SINGLE_POINT <>", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointGreaterThan(String value) {
            addCriterion("FORCED_SINGLE_POINT >", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointGreaterThanOrEqualTo(String value) {
            addCriterion("FORCED_SINGLE_POINT >=", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointLessThan(String value) {
            addCriterion("FORCED_SINGLE_POINT <", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointLessThanOrEqualTo(String value) {
            addCriterion("FORCED_SINGLE_POINT <=", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointLike(String value) {
            addCriterion("FORCED_SINGLE_POINT like", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointNotLike(String value) {
            addCriterion("FORCED_SINGLE_POINT not like", value, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointIn(List<String> values) {
            addCriterion("FORCED_SINGLE_POINT in", values, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointNotIn(List<String> values) {
            addCriterion("FORCED_SINGLE_POINT not in", values, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointBetween(String value1, String value2) {
            addCriterion("FORCED_SINGLE_POINT between", value1, value2, "forcedSinglePoint");
            return (Criteria) this;
        }

        public Criteria andForcedSinglePointNotBetween(String value1, String value2) {
            addCriterion("FORCED_SINGLE_POINT not between", value1, value2, "forcedSinglePoint");
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

        public Criteria andIsStickIsNull() {
            addCriterion("IS_STICK is null");
            return (Criteria) this;
        }

        public Criteria andIsStickIsNotNull() {
            addCriterion("IS_STICK is not null");
            return (Criteria) this;
        }

        public Criteria andIsStickEqualTo(Byte value) {
            addCriterion("IS_STICK =", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickNotEqualTo(Byte value) {
            addCriterion("IS_STICK <>", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickGreaterThan(Byte value) {
            addCriterion("IS_STICK >", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_STICK >=", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickLessThan(Byte value) {
            addCriterion("IS_STICK <", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickLessThanOrEqualTo(Byte value) {
            addCriterion("IS_STICK <=", value, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickIn(List<Byte> values) {
            addCriterion("IS_STICK in", values, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickNotIn(List<Byte> values) {
            addCriterion("IS_STICK not in", values, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickBetween(Byte value1, Byte value2) {
            addCriterion("IS_STICK between", value1, value2, "isStick");
            return (Criteria) this;
        }

        public Criteria andIsStickNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_STICK not between", value1, value2, "isStick");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeIsNull() {
            addCriterion("NEXT_TRACK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeIsNotNull() {
            addCriterion("NEXT_TRACK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeEqualTo(Date value) {
            addCriterion("NEXT_TRACK_TIME =", value, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeNotEqualTo(Date value) {
            addCriterion("NEXT_TRACK_TIME <>", value, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeGreaterThan(Date value) {
            addCriterion("NEXT_TRACK_TIME >", value, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NEXT_TRACK_TIME >=", value, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeLessThan(Date value) {
            addCriterion("NEXT_TRACK_TIME <", value, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeLessThanOrEqualTo(Date value) {
            addCriterion("NEXT_TRACK_TIME <=", value, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeIn(List<Date> values) {
            addCriterion("NEXT_TRACK_TIME in", values, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeNotIn(List<Date> values) {
            addCriterion("NEXT_TRACK_TIME not in", values, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeBetween(Date value1, Date value2) {
            addCriterion("NEXT_TRACK_TIME between", value1, value2, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andNextTrackTimeNotBetween(Date value1, Date value2) {
            addCriterion("NEXT_TRACK_TIME not between", value1, value2, "nextTrackTime");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteIsNull() {
            addCriterion("PLAN_COMPLETE is null");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteIsNotNull() {
            addCriterion("PLAN_COMPLETE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteEqualTo(Byte value) {
            addCriterion("PLAN_COMPLETE =", value, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteNotEqualTo(Byte value) {
            addCriterion("PLAN_COMPLETE <>", value, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteGreaterThan(Byte value) {
            addCriterion("PLAN_COMPLETE >", value, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("PLAN_COMPLETE >=", value, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteLessThan(Byte value) {
            addCriterion("PLAN_COMPLETE <", value, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteLessThanOrEqualTo(Byte value) {
            addCriterion("PLAN_COMPLETE <=", value, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteIn(List<Byte> values) {
            addCriterion("PLAN_COMPLETE in", values, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteNotIn(List<Byte> values) {
            addCriterion("PLAN_COMPLETE not in", values, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteBetween(Byte value1, Byte value2) {
            addCriterion("PLAN_COMPLETE between", value1, value2, "planComplete");
            return (Criteria) this;
        }

        public Criteria andPlanCompleteNotBetween(Byte value1, Byte value2) {
            addCriterion("PLAN_COMPLETE not between", value1, value2, "planComplete");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionIsNull() {
            addCriterion("JOIN_INTENTION is null");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionIsNotNull() {
            addCriterion("JOIN_INTENTION is not null");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionEqualTo(Byte value) {
            addCriterion("JOIN_INTENTION =", value, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionNotEqualTo(Byte value) {
            addCriterion("JOIN_INTENTION <>", value, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionGreaterThan(Byte value) {
            addCriterion("JOIN_INTENTION >", value, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionGreaterThanOrEqualTo(Byte value) {
            addCriterion("JOIN_INTENTION >=", value, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionLessThan(Byte value) {
            addCriterion("JOIN_INTENTION <", value, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionLessThanOrEqualTo(Byte value) {
            addCriterion("JOIN_INTENTION <=", value, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionIn(List<Byte> values) {
            addCriterion("JOIN_INTENTION in", values, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionNotIn(List<Byte> values) {
            addCriterion("JOIN_INTENTION not in", values, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionBetween(Byte value1, Byte value2) {
            addCriterion("JOIN_INTENTION between", value1, value2, "joinIntention");
            return (Criteria) this;
        }

        public Criteria andJoinIntentionNotBetween(Byte value1, Byte value2) {
            addCriterion("JOIN_INTENTION not between", value1, value2, "joinIntention");
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