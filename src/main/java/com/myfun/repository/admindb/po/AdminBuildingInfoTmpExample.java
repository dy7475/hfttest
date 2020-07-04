package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminBuildingInfoTmpExample {
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
    public AdminBuildingInfoTmpExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("SID is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("SID is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("SID =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("SID <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("SID >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SID >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("SID <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("SID <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("SID in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("SID not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("SID between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("SID not between", value1, value2, "sid");
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

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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

        public Criteria andBuildCodeIsNull() {
            addCriterion("BUILD_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBuildCodeIsNotNull() {
            addCriterion("BUILD_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBuildCodeEqualTo(String value) {
            addCriterion("BUILD_CODE =", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeNotEqualTo(String value) {
            addCriterion("BUILD_CODE <>", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeGreaterThan(String value) {
            addCriterion("BUILD_CODE >", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_CODE >=", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeLessThan(String value) {
            addCriterion("BUILD_CODE <", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeLessThanOrEqualTo(String value) {
            addCriterion("BUILD_CODE <=", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeLike(String value) {
            addCriterion("BUILD_CODE like", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeNotLike(String value) {
            addCriterion("BUILD_CODE not like", value, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeIn(List<String> values) {
            addCriterion("BUILD_CODE in", values, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeNotIn(List<String> values) {
            addCriterion("BUILD_CODE not in", values, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeBetween(String value1, String value2) {
            addCriterion("BUILD_CODE between", value1, value2, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildCodeNotBetween(String value1, String value2) {
            addCriterion("BUILD_CODE not between", value1, value2, "buildCode");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperIsNull() {
            addCriterion("BUILD_DEVLOPER is null");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperIsNotNull() {
            addCriterion("BUILD_DEVLOPER is not null");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperEqualTo(String value) {
            addCriterion("BUILD_DEVLOPER =", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperNotEqualTo(String value) {
            addCriterion("BUILD_DEVLOPER <>", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperGreaterThan(String value) {
            addCriterion("BUILD_DEVLOPER >", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_DEVLOPER >=", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperLessThan(String value) {
            addCriterion("BUILD_DEVLOPER <", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperLessThanOrEqualTo(String value) {
            addCriterion("BUILD_DEVLOPER <=", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperLike(String value) {
            addCriterion("BUILD_DEVLOPER like", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperNotLike(String value) {
            addCriterion("BUILD_DEVLOPER not like", value, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperIn(List<String> values) {
            addCriterion("BUILD_DEVLOPER in", values, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperNotIn(List<String> values) {
            addCriterion("BUILD_DEVLOPER not in", values, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperBetween(String value1, String value2) {
            addCriterion("BUILD_DEVLOPER between", value1, value2, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildDevloperNotBetween(String value1, String value2) {
            addCriterion("BUILD_DEVLOPER not between", value1, value2, "buildDevloper");
            return (Criteria) this;
        }

        public Criteria andBuildAddrIsNull() {
            addCriterion("BUILD_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andBuildAddrIsNotNull() {
            addCriterion("BUILD_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAddrEqualTo(String value) {
            addCriterion("BUILD_ADDR =", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrNotEqualTo(String value) {
            addCriterion("BUILD_ADDR <>", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrGreaterThan(String value) {
            addCriterion("BUILD_ADDR >", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_ADDR >=", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrLessThan(String value) {
            addCriterion("BUILD_ADDR <", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrLessThanOrEqualTo(String value) {
            addCriterion("BUILD_ADDR <=", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrLike(String value) {
            addCriterion("BUILD_ADDR like", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrNotLike(String value) {
            addCriterion("BUILD_ADDR not like", value, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrIn(List<String> values) {
            addCriterion("BUILD_ADDR in", values, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrNotIn(List<String> values) {
            addCriterion("BUILD_ADDR not in", values, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrBetween(String value1, String value2) {
            addCriterion("BUILD_ADDR between", value1, value2, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildAddrNotBetween(String value1, String value2) {
            addCriterion("BUILD_ADDR not between", value1, value2, "buildAddr");
            return (Criteria) this;
        }

        public Criteria andBuildRegionIsNull() {
            addCriterion("BUILD_REGION is null");
            return (Criteria) this;
        }

        public Criteria andBuildRegionIsNotNull() {
            addCriterion("BUILD_REGION is not null");
            return (Criteria) this;
        }

        public Criteria andBuildRegionEqualTo(Integer value) {
            addCriterion("BUILD_REGION =", value, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionNotEqualTo(Integer value) {
            addCriterion("BUILD_REGION <>", value, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionGreaterThan(Integer value) {
            addCriterion("BUILD_REGION >", value, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUILD_REGION >=", value, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionLessThan(Integer value) {
            addCriterion("BUILD_REGION <", value, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionLessThanOrEqualTo(Integer value) {
            addCriterion("BUILD_REGION <=", value, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionIn(List<Integer> values) {
            addCriterion("BUILD_REGION in", values, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionNotIn(List<Integer> values) {
            addCriterion("BUILD_REGION not in", values, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_REGION between", value1, value2, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andBuildRegionNotBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_REGION not between", value1, value2, "buildRegion");
            return (Criteria) this;
        }

        public Criteria andSectionIdIsNull() {
            addCriterion("SECTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andSectionIdIsNotNull() {
            addCriterion("SECTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSectionIdEqualTo(Integer value) {
            addCriterion("SECTION_ID =", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdNotEqualTo(Integer value) {
            addCriterion("SECTION_ID <>", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdGreaterThan(Integer value) {
            addCriterion("SECTION_ID >", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SECTION_ID >=", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdLessThan(Integer value) {
            addCriterion("SECTION_ID <", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("SECTION_ID <=", value, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdIn(List<Integer> values) {
            addCriterion("SECTION_ID in", values, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdNotIn(List<Integer> values) {
            addCriterion("SECTION_ID not in", values, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdBetween(Integer value1, Integer value2) {
            addCriterion("SECTION_ID between", value1, value2, "sectionId");
            return (Criteria) this;
        }

        public Criteria andSectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SECTION_ID not between", value1, value2, "sectionId");
            return (Criteria) this;
        }

        public Criteria andBuildRoundIsNull() {
            addCriterion("BUILD_ROUND is null");
            return (Criteria) this;
        }

        public Criteria andBuildRoundIsNotNull() {
            addCriterion("BUILD_ROUND is not null");
            return (Criteria) this;
        }

        public Criteria andBuildRoundEqualTo(String value) {
            addCriterion("BUILD_ROUND =", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundNotEqualTo(String value) {
            addCriterion("BUILD_ROUND <>", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundGreaterThan(String value) {
            addCriterion("BUILD_ROUND >", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_ROUND >=", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundLessThan(String value) {
            addCriterion("BUILD_ROUND <", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundLessThanOrEqualTo(String value) {
            addCriterion("BUILD_ROUND <=", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundLike(String value) {
            addCriterion("BUILD_ROUND like", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundNotLike(String value) {
            addCriterion("BUILD_ROUND not like", value, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundIn(List<String> values) {
            addCriterion("BUILD_ROUND in", values, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundNotIn(List<String> values) {
            addCriterion("BUILD_ROUND not in", values, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundBetween(String value1, String value2) {
            addCriterion("BUILD_ROUND between", value1, value2, "buildRound");
            return (Criteria) this;
        }

        public Criteria andBuildRoundNotBetween(String value1, String value2) {
            addCriterion("BUILD_ROUND not between", value1, value2, "buildRound");
            return (Criteria) this;
        }

        public Criteria andAddCaseIsNull() {
            addCriterion("ADD_CASE is null");
            return (Criteria) this;
        }

        public Criteria andAddCaseIsNotNull() {
            addCriterion("ADD_CASE is not null");
            return (Criteria) this;
        }

        public Criteria andAddCaseEqualTo(String value) {
            addCriterion("ADD_CASE =", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseNotEqualTo(String value) {
            addCriterion("ADD_CASE <>", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseGreaterThan(String value) {
            addCriterion("ADD_CASE >", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_CASE >=", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseLessThan(String value) {
            addCriterion("ADD_CASE <", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseLessThanOrEqualTo(String value) {
            addCriterion("ADD_CASE <=", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseLike(String value) {
            addCriterion("ADD_CASE like", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseNotLike(String value) {
            addCriterion("ADD_CASE not like", value, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseIn(List<String> values) {
            addCriterion("ADD_CASE in", values, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseNotIn(List<String> values) {
            addCriterion("ADD_CASE not in", values, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseBetween(String value1, String value2) {
            addCriterion("ADD_CASE between", value1, value2, "addCase");
            return (Criteria) this;
        }

        public Criteria andAddCaseNotBetween(String value1, String value2) {
            addCriterion("ADD_CASE not between", value1, value2, "addCase");
            return (Criteria) this;
        }

        public Criteria andRightConductIsNull() {
            addCriterion("RIGHT_CONDUCT is null");
            return (Criteria) this;
        }

        public Criteria andRightConductIsNotNull() {
            addCriterion("RIGHT_CONDUCT is not null");
            return (Criteria) this;
        }

        public Criteria andRightConductEqualTo(String value) {
            addCriterion("RIGHT_CONDUCT =", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductNotEqualTo(String value) {
            addCriterion("RIGHT_CONDUCT <>", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductGreaterThan(String value) {
            addCriterion("RIGHT_CONDUCT >", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHT_CONDUCT >=", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductLessThan(String value) {
            addCriterion("RIGHT_CONDUCT <", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductLessThanOrEqualTo(String value) {
            addCriterion("RIGHT_CONDUCT <=", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductLike(String value) {
            addCriterion("RIGHT_CONDUCT like", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductNotLike(String value) {
            addCriterion("RIGHT_CONDUCT not like", value, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductIn(List<String> values) {
            addCriterion("RIGHT_CONDUCT in", values, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductNotIn(List<String> values) {
            addCriterion("RIGHT_CONDUCT not in", values, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductBetween(String value1, String value2) {
            addCriterion("RIGHT_CONDUCT between", value1, value2, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andRightConductNotBetween(String value1, String value2) {
            addCriterion("RIGHT_CONDUCT not between", value1, value2, "rightConduct");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIsNull() {
            addCriterion("BUILD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIsNotNull() {
            addCriterion("BUILD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBuildTypeEqualTo(String value) {
            addCriterion("BUILD_TYPE =", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotEqualTo(String value) {
            addCriterion("BUILD_TYPE <>", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeGreaterThan(String value) {
            addCriterion("BUILD_TYPE >", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_TYPE >=", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLessThan(String value) {
            addCriterion("BUILD_TYPE <", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLessThanOrEqualTo(String value) {
            addCriterion("BUILD_TYPE <=", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLike(String value) {
            addCriterion("BUILD_TYPE like", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotLike(String value) {
            addCriterion("BUILD_TYPE not like", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIn(List<String> values) {
            addCriterion("BUILD_TYPE in", values, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotIn(List<String> values) {
            addCriterion("BUILD_TYPE not in", values, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeBetween(String value1, String value2) {
            addCriterion("BUILD_TYPE between", value1, value2, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotBetween(String value1, String value2) {
            addCriterion("BUILD_TYPE not between", value1, value2, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildDateIsNull() {
            addCriterion("BUILD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBuildDateIsNotNull() {
            addCriterion("BUILD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBuildDateEqualTo(String value) {
            addCriterion("BUILD_DATE =", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotEqualTo(String value) {
            addCriterion("BUILD_DATE <>", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateGreaterThan(String value) {
            addCriterion("BUILD_DATE >", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_DATE >=", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateLessThan(String value) {
            addCriterion("BUILD_DATE <", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateLessThanOrEqualTo(String value) {
            addCriterion("BUILD_DATE <=", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateLike(String value) {
            addCriterion("BUILD_DATE like", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotLike(String value) {
            addCriterion("BUILD_DATE not like", value, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateIn(List<String> values) {
            addCriterion("BUILD_DATE in", values, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotIn(List<String> values) {
            addCriterion("BUILD_DATE not in", values, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateBetween(String value1, String value2) {
            addCriterion("BUILD_DATE between", value1, value2, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildDateNotBetween(String value1, String value2) {
            addCriterion("BUILD_DATE not between", value1, value2, "buildDate");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNull() {
            addCriterion("BUILD_AREA is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("BUILD_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(String value) {
            addCriterion("BUILD_AREA =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(String value) {
            addCriterion("BUILD_AREA <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(String value) {
            addCriterion("BUILD_AREA >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_AREA >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(String value) {
            addCriterion("BUILD_AREA <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(String value) {
            addCriterion("BUILD_AREA <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLike(String value) {
            addCriterion("BUILD_AREA like", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotLike(String value) {
            addCriterion("BUILD_AREA not like", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<String> values) {
            addCriterion("BUILD_AREA in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<String> values) {
            addCriterion("BUILD_AREA not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(String value1, String value2) {
            addCriterion("BUILD_AREA between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(String value1, String value2) {
            addCriterion("BUILD_AREA not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andProjectCoverIsNull() {
            addCriterion("PROJECT_COVER is null");
            return (Criteria) this;
        }

        public Criteria andProjectCoverIsNotNull() {
            addCriterion("PROJECT_COVER is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCoverEqualTo(String value) {
            addCriterion("PROJECT_COVER =", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverNotEqualTo(String value) {
            addCriterion("PROJECT_COVER <>", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverGreaterThan(String value) {
            addCriterion("PROJECT_COVER >", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_COVER >=", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverLessThan(String value) {
            addCriterion("PROJECT_COVER <", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_COVER <=", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverLike(String value) {
            addCriterion("PROJECT_COVER like", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverNotLike(String value) {
            addCriterion("PROJECT_COVER not like", value, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverIn(List<String> values) {
            addCriterion("PROJECT_COVER in", values, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverNotIn(List<String> values) {
            addCriterion("PROJECT_COVER not in", values, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverBetween(String value1, String value2) {
            addCriterion("PROJECT_COVER between", value1, value2, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectCoverNotBetween(String value1, String value2) {
            addCriterion("PROJECT_COVER not between", value1, value2, "projectCover");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceIsNull() {
            addCriterion("PROJECT_SPACE is null");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceIsNotNull() {
            addCriterion("PROJECT_SPACE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceEqualTo(String value) {
            addCriterion("PROJECT_SPACE =", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceNotEqualTo(String value) {
            addCriterion("PROJECT_SPACE <>", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceGreaterThan(String value) {
            addCriterion("PROJECT_SPACE >", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_SPACE >=", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceLessThan(String value) {
            addCriterion("PROJECT_SPACE <", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_SPACE <=", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceLike(String value) {
            addCriterion("PROJECT_SPACE like", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceNotLike(String value) {
            addCriterion("PROJECT_SPACE not like", value, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceIn(List<String> values) {
            addCriterion("PROJECT_SPACE in", values, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceNotIn(List<String> values) {
            addCriterion("PROJECT_SPACE not in", values, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceBetween(String value1, String value2) {
            addCriterion("PROJECT_SPACE between", value1, value2, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectSpaceNotBetween(String value1, String value2) {
            addCriterion("PROJECT_SPACE not between", value1, value2, "projectSpace");
            return (Criteria) this;
        }

        public Criteria andProjectGreenIsNull() {
            addCriterion("PROJECT_GREEN is null");
            return (Criteria) this;
        }

        public Criteria andProjectGreenIsNotNull() {
            addCriterion("PROJECT_GREEN is not null");
            return (Criteria) this;
        }

        public Criteria andProjectGreenEqualTo(String value) {
            addCriterion("PROJECT_GREEN =", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenNotEqualTo(String value) {
            addCriterion("PROJECT_GREEN <>", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenGreaterThan(String value) {
            addCriterion("PROJECT_GREEN >", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_GREEN >=", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenLessThan(String value) {
            addCriterion("PROJECT_GREEN <", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_GREEN <=", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenLike(String value) {
            addCriterion("PROJECT_GREEN like", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenNotLike(String value) {
            addCriterion("PROJECT_GREEN not like", value, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenIn(List<String> values) {
            addCriterion("PROJECT_GREEN in", values, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenNotIn(List<String> values) {
            addCriterion("PROJECT_GREEN not in", values, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenBetween(String value1, String value2) {
            addCriterion("PROJECT_GREEN between", value1, value2, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andProjectGreenNotBetween(String value1, String value2) {
            addCriterion("PROJECT_GREEN not between", value1, value2, "projectGreen");
            return (Criteria) this;
        }

        public Criteria andCarsCaseIsNull() {
            addCriterion("CARS_CASE is null");
            return (Criteria) this;
        }

        public Criteria andCarsCaseIsNotNull() {
            addCriterion("CARS_CASE is not null");
            return (Criteria) this;
        }

        public Criteria andCarsCaseEqualTo(String value) {
            addCriterion("CARS_CASE =", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseNotEqualTo(String value) {
            addCriterion("CARS_CASE <>", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseGreaterThan(String value) {
            addCriterion("CARS_CASE >", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseGreaterThanOrEqualTo(String value) {
            addCriterion("CARS_CASE >=", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseLessThan(String value) {
            addCriterion("CARS_CASE <", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseLessThanOrEqualTo(String value) {
            addCriterion("CARS_CASE <=", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseLike(String value) {
            addCriterion("CARS_CASE like", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseNotLike(String value) {
            addCriterion("CARS_CASE not like", value, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseIn(List<String> values) {
            addCriterion("CARS_CASE in", values, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseNotIn(List<String> values) {
            addCriterion("CARS_CASE not in", values, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseBetween(String value1, String value2) {
            addCriterion("CARS_CASE between", value1, value2, "carsCase");
            return (Criteria) this;
        }

        public Criteria andCarsCaseNotBetween(String value1, String value2) {
            addCriterion("CARS_CASE not between", value1, value2, "carsCase");
            return (Criteria) this;
        }

        public Criteria andBusLineIsNull() {
            addCriterion("BUS_LINE is null");
            return (Criteria) this;
        }

        public Criteria andBusLineIsNotNull() {
            addCriterion("BUS_LINE is not null");
            return (Criteria) this;
        }

        public Criteria andBusLineEqualTo(String value) {
            addCriterion("BUS_LINE =", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineNotEqualTo(String value) {
            addCriterion("BUS_LINE <>", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineGreaterThan(String value) {
            addCriterion("BUS_LINE >", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineGreaterThanOrEqualTo(String value) {
            addCriterion("BUS_LINE >=", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineLessThan(String value) {
            addCriterion("BUS_LINE <", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineLessThanOrEqualTo(String value) {
            addCriterion("BUS_LINE <=", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineLike(String value) {
            addCriterion("BUS_LINE like", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineNotLike(String value) {
            addCriterion("BUS_LINE not like", value, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineIn(List<String> values) {
            addCriterion("BUS_LINE in", values, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineNotIn(List<String> values) {
            addCriterion("BUS_LINE not in", values, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineBetween(String value1, String value2) {
            addCriterion("BUS_LINE between", value1, value2, "busLine");
            return (Criteria) this;
        }

        public Criteria andBusLineNotBetween(String value1, String value2) {
            addCriterion("BUS_LINE not between", value1, value2, "busLine");
            return (Criteria) this;
        }

        public Criteria andPropertyCompIsNull() {
            addCriterion("PROPERTY_COMP is null");
            return (Criteria) this;
        }

        public Criteria andPropertyCompIsNotNull() {
            addCriterion("PROPERTY_COMP is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyCompEqualTo(String value) {
            addCriterion("PROPERTY_COMP =", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompNotEqualTo(String value) {
            addCriterion("PROPERTY_COMP <>", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompGreaterThan(String value) {
            addCriterion("PROPERTY_COMP >", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY_COMP >=", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompLessThan(String value) {
            addCriterion("PROPERTY_COMP <", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompLessThanOrEqualTo(String value) {
            addCriterion("PROPERTY_COMP <=", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompLike(String value) {
            addCriterion("PROPERTY_COMP like", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompNotLike(String value) {
            addCriterion("PROPERTY_COMP not like", value, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompIn(List<String> values) {
            addCriterion("PROPERTY_COMP in", values, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompNotIn(List<String> values) {
            addCriterion("PROPERTY_COMP not in", values, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompBetween(String value1, String value2) {
            addCriterion("PROPERTY_COMP between", value1, value2, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertyCompNotBetween(String value1, String value2) {
            addCriterion("PROPERTY_COMP not between", value1, value2, "propertyComp");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleIsNull() {
            addCriterion("PROPERTYCOMP_TELE is null");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleIsNotNull() {
            addCriterion("PROPERTYCOMP_TELE is not null");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleEqualTo(String value) {
            addCriterion("PROPERTYCOMP_TELE =", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleNotEqualTo(String value) {
            addCriterion("PROPERTYCOMP_TELE <>", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleGreaterThan(String value) {
            addCriterion("PROPERTYCOMP_TELE >", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTYCOMP_TELE >=", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleLessThan(String value) {
            addCriterion("PROPERTYCOMP_TELE <", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleLessThanOrEqualTo(String value) {
            addCriterion("PROPERTYCOMP_TELE <=", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleLike(String value) {
            addCriterion("PROPERTYCOMP_TELE like", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleNotLike(String value) {
            addCriterion("PROPERTYCOMP_TELE not like", value, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleIn(List<String> values) {
            addCriterion("PROPERTYCOMP_TELE in", values, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleNotIn(List<String> values) {
            addCriterion("PROPERTYCOMP_TELE not in", values, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleBetween(String value1, String value2) {
            addCriterion("PROPERTYCOMP_TELE between", value1, value2, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andPropertycompTeleNotBetween(String value1, String value2) {
            addCriterion("PROPERTYCOMP_TELE not between", value1, value2, "propertycompTele");
            return (Criteria) this;
        }

        public Criteria andCostStandardIsNull() {
            addCriterion("COST_STANDARD is null");
            return (Criteria) this;
        }

        public Criteria andCostStandardIsNotNull() {
            addCriterion("COST_STANDARD is not null");
            return (Criteria) this;
        }

        public Criteria andCostStandardEqualTo(String value) {
            addCriterion("COST_STANDARD =", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotEqualTo(String value) {
            addCriterion("COST_STANDARD <>", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardGreaterThan(String value) {
            addCriterion("COST_STANDARD >", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardGreaterThanOrEqualTo(String value) {
            addCriterion("COST_STANDARD >=", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardLessThan(String value) {
            addCriterion("COST_STANDARD <", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardLessThanOrEqualTo(String value) {
            addCriterion("COST_STANDARD <=", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardLike(String value) {
            addCriterion("COST_STANDARD like", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotLike(String value) {
            addCriterion("COST_STANDARD not like", value, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardIn(List<String> values) {
            addCriterion("COST_STANDARD in", values, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotIn(List<String> values) {
            addCriterion("COST_STANDARD not in", values, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardBetween(String value1, String value2) {
            addCriterion("COST_STANDARD between", value1, value2, "costStandard");
            return (Criteria) this;
        }

        public Criteria andCostStandardNotBetween(String value1, String value2) {
            addCriterion("COST_STANDARD not between", value1, value2, "costStandard");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptIsNull() {
            addCriterion("BUILD_DESCRIPT is null");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptIsNotNull() {
            addCriterion("BUILD_DESCRIPT is not null");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptEqualTo(String value) {
            addCriterion("BUILD_DESCRIPT =", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptNotEqualTo(String value) {
            addCriterion("BUILD_DESCRIPT <>", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptGreaterThan(String value) {
            addCriterion("BUILD_DESCRIPT >", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("BUILD_DESCRIPT >=", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptLessThan(String value) {
            addCriterion("BUILD_DESCRIPT <", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptLessThanOrEqualTo(String value) {
            addCriterion("BUILD_DESCRIPT <=", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptLike(String value) {
            addCriterion("BUILD_DESCRIPT like", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptNotLike(String value) {
            addCriterion("BUILD_DESCRIPT not like", value, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptIn(List<String> values) {
            addCriterion("BUILD_DESCRIPT in", values, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptNotIn(List<String> values) {
            addCriterion("BUILD_DESCRIPT not in", values, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptBetween(String value1, String value2) {
            addCriterion("BUILD_DESCRIPT between", value1, value2, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildDescriptNotBetween(String value1, String value2) {
            addCriterion("BUILD_DESCRIPT not between", value1, value2, "buildDescript");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoIsNull() {
            addCriterion("BUILD_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoIsNotNull() {
            addCriterion("BUILD_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoEqualTo(Byte value) {
            addCriterion("BUILD_PHOTO =", value, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoNotEqualTo(Byte value) {
            addCriterion("BUILD_PHOTO <>", value, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoGreaterThan(Byte value) {
            addCriterion("BUILD_PHOTO >", value, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoGreaterThanOrEqualTo(Byte value) {
            addCriterion("BUILD_PHOTO >=", value, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoLessThan(Byte value) {
            addCriterion("BUILD_PHOTO <", value, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoLessThanOrEqualTo(Byte value) {
            addCriterion("BUILD_PHOTO <=", value, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoIn(List<Byte> values) {
            addCriterion("BUILD_PHOTO in", values, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoNotIn(List<Byte> values) {
            addCriterion("BUILD_PHOTO not in", values, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoBetween(Byte value1, Byte value2) {
            addCriterion("BUILD_PHOTO between", value1, value2, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andBuildPhotoNotBetween(Byte value1, Byte value2) {
            addCriterion("BUILD_PHOTO not between", value1, value2, "buildPhoto");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNull() {
            addCriterion("POSITION_X is null");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNotNull() {
            addCriterion("POSITION_X is not null");
            return (Criteria) this;
        }

        public Criteria andPositionXEqualTo(Integer value) {
            addCriterion("POSITION_X =", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotEqualTo(Integer value) {
            addCriterion("POSITION_X <>", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThan(Integer value) {
            addCriterion("POSITION_X >", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThanOrEqualTo(Integer value) {
            addCriterion("POSITION_X >=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThan(Integer value) {
            addCriterion("POSITION_X <", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThanOrEqualTo(Integer value) {
            addCriterion("POSITION_X <=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXIn(List<Integer> values) {
            addCriterion("POSITION_X in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotIn(List<Integer> values) {
            addCriterion("POSITION_X not in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXBetween(Integer value1, Integer value2) {
            addCriterion("POSITION_X between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotBetween(Integer value1, Integer value2) {
            addCriterion("POSITION_X not between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPostionYIsNull() {
            addCriterion("POSTION_Y is null");
            return (Criteria) this;
        }

        public Criteria andPostionYIsNotNull() {
            addCriterion("POSTION_Y is not null");
            return (Criteria) this;
        }

        public Criteria andPostionYEqualTo(Integer value) {
            addCriterion("POSTION_Y =", value, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYNotEqualTo(Integer value) {
            addCriterion("POSTION_Y <>", value, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYGreaterThan(Integer value) {
            addCriterion("POSTION_Y >", value, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYGreaterThanOrEqualTo(Integer value) {
            addCriterion("POSTION_Y >=", value, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYLessThan(Integer value) {
            addCriterion("POSTION_Y <", value, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYLessThanOrEqualTo(Integer value) {
            addCriterion("POSTION_Y <=", value, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYIn(List<Integer> values) {
            addCriterion("POSTION_Y in", values, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYNotIn(List<Integer> values) {
            addCriterion("POSTION_Y not in", values, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYBetween(Integer value1, Integer value2) {
            addCriterion("POSTION_Y between", value1, value2, "postionY");
            return (Criteria) this;
        }

        public Criteria andPostionYNotBetween(Integer value1, Integer value2) {
            addCriterion("POSTION_Y not between", value1, value2, "postionY");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNull() {
            addCriterion("CHECK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNotNull() {
            addCriterion("CHECK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagEqualTo(Byte value) {
            addCriterion("CHECK_FLAG =", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotEqualTo(Byte value) {
            addCriterion("CHECK_FLAG <>", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThan(Byte value) {
            addCriterion("CHECK_FLAG >", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("CHECK_FLAG >=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThan(Byte value) {
            addCriterion("CHECK_FLAG <", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThanOrEqualTo(Byte value) {
            addCriterion("CHECK_FLAG <=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIn(List<Byte> values) {
            addCriterion("CHECK_FLAG in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotIn(List<Byte> values) {
            addCriterion("CHECK_FLAG not in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagBetween(Byte value1, Byte value2) {
            addCriterion("CHECK_FLAG between", value1, value2, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("CHECK_FLAG not between", value1, value2, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNull() {
            addCriterion("SUBMIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNotNull() {
            addCriterion("SUBMIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateEqualTo(String value) {
            addCriterion("SUBMIT_DATE =", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotEqualTo(String value) {
            addCriterion("SUBMIT_DATE <>", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThan(String value) {
            addCriterion("SUBMIT_DATE >", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThanOrEqualTo(String value) {
            addCriterion("SUBMIT_DATE >=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThan(String value) {
            addCriterion("SUBMIT_DATE <", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThanOrEqualTo(String value) {
            addCriterion("SUBMIT_DATE <=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLike(String value) {
            addCriterion("SUBMIT_DATE like", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotLike(String value) {
            addCriterion("SUBMIT_DATE not like", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIn(List<String> values) {
            addCriterion("SUBMIT_DATE in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotIn(List<String> values) {
            addCriterion("SUBMIT_DATE not in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateBetween(String value1, String value2) {
            addCriterion("SUBMIT_DATE between", value1, value2, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotBetween(String value1, String value2) {
            addCriterion("SUBMIT_DATE not between", value1, value2, "submitDate");
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