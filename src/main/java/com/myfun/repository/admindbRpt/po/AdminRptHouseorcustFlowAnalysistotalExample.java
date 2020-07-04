package com.myfun.repository.admindbRpt.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminRptHouseorcustFlowAnalysistotalExample {
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
    public AdminRptHouseorcustFlowAnalysistotalExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andGrIdIsNull() {
            addCriterion("GR_ID is null");
            return (Criteria) this;
        }

        public Criteria andGrIdIsNotNull() {
            addCriterion("GR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGrIdEqualTo(Integer value) {
            addCriterion("GR_ID =", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotEqualTo(Integer value) {
            addCriterion("GR_ID <>", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdGreaterThan(Integer value) {
            addCriterion("GR_ID >", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GR_ID >=", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdLessThan(Integer value) {
            addCriterion("GR_ID <", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdLessThanOrEqualTo(Integer value) {
            addCriterion("GR_ID <=", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdIn(List<Integer> values) {
            addCriterion("GR_ID in", values, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotIn(List<Integer> values) {
            addCriterion("GR_ID not in", values, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdBetween(Integer value1, Integer value2) {
            addCriterion("GR_ID between", value1, value2, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GR_ID not between", value1, value2, "grId");
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

        public Criteria andEffectiveSaveCountIsNull() {
            addCriterion("EFFECTIVE_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountIsNotNull() {
            addCriterion("EFFECTIVE_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountEqualTo(Integer value) {
            addCriterion("EFFECTIVE_SAVE_COUNT =", value, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountNotEqualTo(Integer value) {
            addCriterion("EFFECTIVE_SAVE_COUNT <>", value, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountGreaterThan(Integer value) {
            addCriterion("EFFECTIVE_SAVE_COUNT >", value, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("EFFECTIVE_SAVE_COUNT >=", value, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountLessThan(Integer value) {
            addCriterion("EFFECTIVE_SAVE_COUNT <", value, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("EFFECTIVE_SAVE_COUNT <=", value, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountIn(List<Integer> values) {
            addCriterion("EFFECTIVE_SAVE_COUNT in", values, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountNotIn(List<Integer> values) {
            addCriterion("EFFECTIVE_SAVE_COUNT not in", values, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("EFFECTIVE_SAVE_COUNT between", value1, value2, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("EFFECTIVE_SAVE_COUNT not between", value1, value2, "effectiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountIsNull() {
            addCriterion("SEALINGPLATE_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountIsNotNull() {
            addCriterion("SEALINGPLATE_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_SAVE_COUNT =", value, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountNotEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_SAVE_COUNT <>", value, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountGreaterThan(Integer value) {
            addCriterion("SEALINGPLATE_SAVE_COUNT >", value, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_SAVE_COUNT >=", value, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountLessThan(Integer value) {
            addCriterion("SEALINGPLATE_SAVE_COUNT <", value, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_SAVE_COUNT <=", value, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountIn(List<Integer> values) {
            addCriterion("SEALINGPLATE_SAVE_COUNT in", values, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountNotIn(List<Integer> values) {
            addCriterion("SEALINGPLATE_SAVE_COUNT not in", values, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("SEALINGPLATE_SAVE_COUNT between", value1, value2, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("SEALINGPLATE_SAVE_COUNT not between", value1, value2, "sealingplateSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountIsNull() {
            addCriterion("CANCELL_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountIsNotNull() {
            addCriterion("CANCELL_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountEqualTo(Integer value) {
            addCriterion("CANCELL_SAVE_COUNT =", value, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountNotEqualTo(Integer value) {
            addCriterion("CANCELL_SAVE_COUNT <>", value, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountGreaterThan(Integer value) {
            addCriterion("CANCELL_SAVE_COUNT >", value, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("CANCELL_SAVE_COUNT >=", value, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountLessThan(Integer value) {
            addCriterion("CANCELL_SAVE_COUNT <", value, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("CANCELL_SAVE_COUNT <=", value, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountIn(List<Integer> values) {
            addCriterion("CANCELL_SAVE_COUNT in", values, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountNotIn(List<Integer> values) {
            addCriterion("CANCELL_SAVE_COUNT not in", values, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("CANCELL_SAVE_COUNT between", value1, value2, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andCancellSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("CANCELL_SAVE_COUNT not between", value1, value2, "cancellSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountIsNull() {
            addCriterion("BOOK_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountIsNotNull() {
            addCriterion("BOOK_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountEqualTo(Integer value) {
            addCriterion("BOOK_SAVE_COUNT =", value, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountNotEqualTo(Integer value) {
            addCriterion("BOOK_SAVE_COUNT <>", value, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountGreaterThan(Integer value) {
            addCriterion("BOOK_SAVE_COUNT >", value, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOK_SAVE_COUNT >=", value, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountLessThan(Integer value) {
            addCriterion("BOOK_SAVE_COUNT <", value, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("BOOK_SAVE_COUNT <=", value, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountIn(List<Integer> values) {
            addCriterion("BOOK_SAVE_COUNT in", values, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountNotIn(List<Integer> values) {
            addCriterion("BOOK_SAVE_COUNT not in", values, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_SAVE_COUNT between", value1, value2, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andBookSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_SAVE_COUNT not between", value1, value2, "bookSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountIsNull() {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountIsNotNull() {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT =", value, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT <>", value, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT >", value, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT >=", value, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountLessThan(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT <", value, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT <=", value, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT in", values, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT not in", values, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT between", value1, value2, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOEFFTIVE_SAVE_COUNT not between", value1, value2, "transfertoefftiveSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountIsNull() {
            addCriterion("INNDERDEAL_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountIsNotNull() {
            addCriterion("INNDERDEAL_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountEqualTo(Integer value) {
            addCriterion("INNDERDEAL_SAVE_COUNT =", value, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountNotEqualTo(Integer value) {
            addCriterion("INNDERDEAL_SAVE_COUNT <>", value, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountGreaterThan(Integer value) {
            addCriterion("INNDERDEAL_SAVE_COUNT >", value, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("INNDERDEAL_SAVE_COUNT >=", value, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountLessThan(Integer value) {
            addCriterion("INNDERDEAL_SAVE_COUNT <", value, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("INNDERDEAL_SAVE_COUNT <=", value, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountIn(List<Integer> values) {
            addCriterion("INNDERDEAL_SAVE_COUNT in", values, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountNotIn(List<Integer> values) {
            addCriterion("INNDERDEAL_SAVE_COUNT not in", values, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("INNDERDEAL_SAVE_COUNT between", value1, value2, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("INNDERDEAL_SAVE_COUNT not between", value1, value2, "innderdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountIsNull() {
            addCriterion("OUTDEAL_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountIsNotNull() {
            addCriterion("OUTDEAL_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountEqualTo(Integer value) {
            addCriterion("OUTDEAL_SAVE_COUNT =", value, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountNotEqualTo(Integer value) {
            addCriterion("OUTDEAL_SAVE_COUNT <>", value, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountGreaterThan(Integer value) {
            addCriterion("OUTDEAL_SAVE_COUNT >", value, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("OUTDEAL_SAVE_COUNT >=", value, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountLessThan(Integer value) {
            addCriterion("OUTDEAL_SAVE_COUNT <", value, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("OUTDEAL_SAVE_COUNT <=", value, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountIn(List<Integer> values) {
            addCriterion("OUTDEAL_SAVE_COUNT in", values, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountNotIn(List<Integer> values) {
            addCriterion("OUTDEAL_SAVE_COUNT not in", values, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("OUTDEAL_SAVE_COUNT between", value1, value2, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andOutdealSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("OUTDEAL_SAVE_COUNT not between", value1, value2, "outdealSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountIsNull() {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountIsNotNull() {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT =", value, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT <>", value, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT >", value, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT >=", value, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountLessThan(Integer value) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT <", value, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT <=", value, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT in", values, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT not in", values, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT between", value1, value2, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSALE_SAVE_COUNT not between", value1, value2, "transfertosaleSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountIsNull() {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountIsNotNull() {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT =", value, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT <>", value, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT >", value, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT >=", value, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountLessThan(Integer value) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT <", value, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT <=", value, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT in", values, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT not in", values, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT between", value1, value2, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOLEASE_SAVE_COUNT not between", value1, value2, "transfertoleaseSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountIsNull() {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountIsNotNull() {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT =", value, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT <>", value, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT >", value, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT >=", value, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountLessThan(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT <", value, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT <=", value, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT in", values, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT not in", values, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT between", value1, value2, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOPUBLIC_SAVE_COUNT not between", value1, value2, "transfertopublicSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountIsNull() {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountIsNotNull() {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT =", value, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT <>", value, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT >", value, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT >=", value, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountLessThan(Integer value) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT <", value, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT <=", value, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT in", values, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT not in", values, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT between", value1, value2, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareSaveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSHARE_SAVE_COUNT not between", value1, value2, "transfertoshareSaveCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountIsNull() {
            addCriterion("EFFECTIVE_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountIsNotNull() {
            addCriterion("EFFECTIVE_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountEqualTo(Integer value) {
            addCriterion("EFFECTIVE_ADD_COUNT =", value, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountNotEqualTo(Integer value) {
            addCriterion("EFFECTIVE_ADD_COUNT <>", value, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountGreaterThan(Integer value) {
            addCriterion("EFFECTIVE_ADD_COUNT >", value, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("EFFECTIVE_ADD_COUNT >=", value, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountLessThan(Integer value) {
            addCriterion("EFFECTIVE_ADD_COUNT <", value, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("EFFECTIVE_ADD_COUNT <=", value, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountIn(List<Integer> values) {
            addCriterion("EFFECTIVE_ADD_COUNT in", values, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountNotIn(List<Integer> values) {
            addCriterion("EFFECTIVE_ADD_COUNT not in", values, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountBetween(Integer value1, Integer value2) {
            addCriterion("EFFECTIVE_ADD_COUNT between", value1, value2, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andEffectiveAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("EFFECTIVE_ADD_COUNT not between", value1, value2, "effectiveAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountIsNull() {
            addCriterion("SEALINGPLATE_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountIsNotNull() {
            addCriterion("SEALINGPLATE_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_ADD_COUNT =", value, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountNotEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_ADD_COUNT <>", value, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountGreaterThan(Integer value) {
            addCriterion("SEALINGPLATE_ADD_COUNT >", value, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_ADD_COUNT >=", value, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountLessThan(Integer value) {
            addCriterion("SEALINGPLATE_ADD_COUNT <", value, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("SEALINGPLATE_ADD_COUNT <=", value, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountIn(List<Integer> values) {
            addCriterion("SEALINGPLATE_ADD_COUNT in", values, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountNotIn(List<Integer> values) {
            addCriterion("SEALINGPLATE_ADD_COUNT not in", values, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountBetween(Integer value1, Integer value2) {
            addCriterion("SEALINGPLATE_ADD_COUNT between", value1, value2, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andSealingplateAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("SEALINGPLATE_ADD_COUNT not between", value1, value2, "sealingplateAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountIsNull() {
            addCriterion("CANCELL_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountIsNotNull() {
            addCriterion("CANCELL_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountEqualTo(Integer value) {
            addCriterion("CANCELL_ADD_COUNT =", value, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountNotEqualTo(Integer value) {
            addCriterion("CANCELL_ADD_COUNT <>", value, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountGreaterThan(Integer value) {
            addCriterion("CANCELL_ADD_COUNT >", value, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("CANCELL_ADD_COUNT >=", value, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountLessThan(Integer value) {
            addCriterion("CANCELL_ADD_COUNT <", value, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("CANCELL_ADD_COUNT <=", value, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountIn(List<Integer> values) {
            addCriterion("CANCELL_ADD_COUNT in", values, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountNotIn(List<Integer> values) {
            addCriterion("CANCELL_ADD_COUNT not in", values, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountBetween(Integer value1, Integer value2) {
            addCriterion("CANCELL_ADD_COUNT between", value1, value2, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andCancellAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("CANCELL_ADD_COUNT not between", value1, value2, "cancellAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountIsNull() {
            addCriterion("BOOK_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andBookAddCountIsNotNull() {
            addCriterion("BOOK_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBookAddCountEqualTo(Integer value) {
            addCriterion("BOOK_ADD_COUNT =", value, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountNotEqualTo(Integer value) {
            addCriterion("BOOK_ADD_COUNT <>", value, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountGreaterThan(Integer value) {
            addCriterion("BOOK_ADD_COUNT >", value, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOK_ADD_COUNT >=", value, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountLessThan(Integer value) {
            addCriterion("BOOK_ADD_COUNT <", value, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("BOOK_ADD_COUNT <=", value, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountIn(List<Integer> values) {
            addCriterion("BOOK_ADD_COUNT in", values, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountNotIn(List<Integer> values) {
            addCriterion("BOOK_ADD_COUNT not in", values, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_ADD_COUNT between", value1, value2, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andBookAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_ADD_COUNT not between", value1, value2, "bookAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountIsNull() {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountIsNotNull() {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT =", value, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT <>", value, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT >", value, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT >=", value, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountLessThan(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT <", value, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT <=", value, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT in", values, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT not in", values, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT between", value1, value2, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoefftiveAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOEFFTIVE_ADD_COUNT not between", value1, value2, "transfertoefftiveAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountIsNull() {
            addCriterion("INNDERDEAL_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountIsNotNull() {
            addCriterion("INNDERDEAL_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountEqualTo(Integer value) {
            addCriterion("INNDERDEAL_ADD_COUNT =", value, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountNotEqualTo(Integer value) {
            addCriterion("INNDERDEAL_ADD_COUNT <>", value, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountGreaterThan(Integer value) {
            addCriterion("INNDERDEAL_ADD_COUNT >", value, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("INNDERDEAL_ADD_COUNT >=", value, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountLessThan(Integer value) {
            addCriterion("INNDERDEAL_ADD_COUNT <", value, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("INNDERDEAL_ADD_COUNT <=", value, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountIn(List<Integer> values) {
            addCriterion("INNDERDEAL_ADD_COUNT in", values, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountNotIn(List<Integer> values) {
            addCriterion("INNDERDEAL_ADD_COUNT not in", values, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountBetween(Integer value1, Integer value2) {
            addCriterion("INNDERDEAL_ADD_COUNT between", value1, value2, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andInnderdealAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("INNDERDEAL_ADD_COUNT not between", value1, value2, "innderdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountIsNull() {
            addCriterion("OUTDEAL_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountIsNotNull() {
            addCriterion("OUTDEAL_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountEqualTo(Integer value) {
            addCriterion("OUTDEAL_ADD_COUNT =", value, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountNotEqualTo(Integer value) {
            addCriterion("OUTDEAL_ADD_COUNT <>", value, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountGreaterThan(Integer value) {
            addCriterion("OUTDEAL_ADD_COUNT >", value, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("OUTDEAL_ADD_COUNT >=", value, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountLessThan(Integer value) {
            addCriterion("OUTDEAL_ADD_COUNT <", value, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("OUTDEAL_ADD_COUNT <=", value, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountIn(List<Integer> values) {
            addCriterion("OUTDEAL_ADD_COUNT in", values, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountNotIn(List<Integer> values) {
            addCriterion("OUTDEAL_ADD_COUNT not in", values, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountBetween(Integer value1, Integer value2) {
            addCriterion("OUTDEAL_ADD_COUNT between", value1, value2, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andOutdealAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("OUTDEAL_ADD_COUNT not between", value1, value2, "outdealAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountIsNull() {
            addCriterion("TRANSFERTOSALE_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountIsNotNull() {
            addCriterion("TRANSFERTOSALE_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT =", value, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT <>", value, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT >", value, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT >=", value, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountLessThan(Integer value) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT <", value, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT <=", value, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT in", values, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT not in", values, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT between", value1, value2, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertosaleAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSALE_ADD_COUNT not between", value1, value2, "transfertosaleAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountIsNull() {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountIsNotNull() {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT =", value, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT <>", value, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT >", value, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT >=", value, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountLessThan(Integer value) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT <", value, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT <=", value, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT in", values, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT not in", values, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT between", value1, value2, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoleaseAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOLEASE_ADD_COUNT not between", value1, value2, "transfertoleaseAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountIsNull() {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountIsNotNull() {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT =", value, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT <>", value, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT >", value, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT >=", value, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountLessThan(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT <", value, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT <=", value, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT in", values, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT not in", values, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT between", value1, value2, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertopublicAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOPUBLIC_ADD_COUNT not between", value1, value2, "transfertopublicAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountIsNull() {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountIsNotNull() {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT =", value, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountNotEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT <>", value, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountGreaterThan(Integer value) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT >", value, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT >=", value, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountLessThan(Integer value) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT <", value, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT <=", value, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountIn(List<Integer> values) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT in", values, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountNotIn(List<Integer> values) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT not in", values, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT between", value1, value2, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andTransfertoshareAddCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSFERTOSHARE_ADD_COUNT not between", value1, value2, "transfertoshareAddCount");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNull() {
            addCriterion("CASE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("CASE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(Byte value) {
            addCriterion("CASE_TYPE =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(Byte value) {
            addCriterion("CASE_TYPE <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(Byte value) {
            addCriterion("CASE_TYPE >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("CASE_TYPE >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(Byte value) {
            addCriterion("CASE_TYPE <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("CASE_TYPE <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<Byte> values) {
            addCriterion("CASE_TYPE in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<Byte> values) {
            addCriterion("CASE_TYPE not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(Byte value1, Byte value2) {
            addCriterion("CASE_TYPE between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("CASE_TYPE not between", value1, value2, "caseType");
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