package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpYouBuildDetailViewExample extends ShardDb {
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
    public ErpYouBuildDetailViewExample() {
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

        public Criteria andDetailViewIdIsNull() {
            addCriterion("DETAIL_VIEW_ID is null");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdIsNotNull() {
            addCriterion("DETAIL_VIEW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdEqualTo(Integer value) {
            addCriterion("DETAIL_VIEW_ID =", value, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdNotEqualTo(Integer value) {
            addCriterion("DETAIL_VIEW_ID <>", value, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdGreaterThan(Integer value) {
            addCriterion("DETAIL_VIEW_ID >", value, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DETAIL_VIEW_ID >=", value, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdLessThan(Integer value) {
            addCriterion("DETAIL_VIEW_ID <", value, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdLessThanOrEqualTo(Integer value) {
            addCriterion("DETAIL_VIEW_ID <=", value, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdIn(List<Integer> values) {
            addCriterion("DETAIL_VIEW_ID in", values, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdNotIn(List<Integer> values) {
            addCriterion("DETAIL_VIEW_ID not in", values, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdBetween(Integer value1, Integer value2) {
            addCriterion("DETAIL_VIEW_ID between", value1, value2, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andDetailViewIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DETAIL_VIEW_ID not between", value1, value2, "detailViewId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdIsNull() {
            addCriterion("BUILD_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdIsNotNull() {
            addCriterion("BUILD_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdEqualTo(Integer value) {
            addCriterion("BUILD_DETAIL_ID =", value, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdNotEqualTo(Integer value) {
            addCriterion("BUILD_DETAIL_ID <>", value, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdGreaterThan(Integer value) {
            addCriterion("BUILD_DETAIL_ID >", value, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUILD_DETAIL_ID >=", value, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdLessThan(Integer value) {
            addCriterion("BUILD_DETAIL_ID <", value, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("BUILD_DETAIL_ID <=", value, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdIn(List<Integer> values) {
            addCriterion("BUILD_DETAIL_ID in", values, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdNotIn(List<Integer> values) {
            addCriterion("BUILD_DETAIL_ID not in", values, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_DETAIL_ID between", value1, value2, "buildDetailId");
            return (Criteria) this;
        }

        public Criteria andBuildDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_DETAIL_ID not between", value1, value2, "buildDetailId");
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

        public Criteria andViewStatusIsNull() {
            addCriterion("VIEW_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andViewStatusIsNotNull() {
            addCriterion("VIEW_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andViewStatusEqualTo(Integer value) {
            addCriterion("VIEW_STATUS =", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusNotEqualTo(Integer value) {
            addCriterion("VIEW_STATUS <>", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusGreaterThan(Integer value) {
            addCriterion("VIEW_STATUS >", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIEW_STATUS >=", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusLessThan(Integer value) {
            addCriterion("VIEW_STATUS <", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusLessThanOrEqualTo(Integer value) {
            addCriterion("VIEW_STATUS <=", value, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusIn(List<Integer> values) {
            addCriterion("VIEW_STATUS in", values, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusNotIn(List<Integer> values) {
            addCriterion("VIEW_STATUS not in", values, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusBetween(Integer value1, Integer value2) {
            addCriterion("VIEW_STATUS between", value1, value2, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andViewStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("VIEW_STATUS not between", value1, value2, "viewStatus");
            return (Criteria) this;
        }

        public Criteria andShowPhoneIsNull() {
            addCriterion("SHOW_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andShowPhoneIsNotNull() {
            addCriterion("SHOW_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andShowPhoneEqualTo(Byte value) {
            addCriterion("SHOW_PHONE =", value, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneNotEqualTo(Byte value) {
            addCriterion("SHOW_PHONE <>", value, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneGreaterThan(Byte value) {
            addCriterion("SHOW_PHONE >", value, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneGreaterThanOrEqualTo(Byte value) {
            addCriterion("SHOW_PHONE >=", value, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneLessThan(Byte value) {
            addCriterion("SHOW_PHONE <", value, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneLessThanOrEqualTo(Byte value) {
            addCriterion("SHOW_PHONE <=", value, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneIn(List<Byte> values) {
            addCriterion("SHOW_PHONE in", values, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneNotIn(List<Byte> values) {
            addCriterion("SHOW_PHONE not in", values, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneBetween(Byte value1, Byte value2) {
            addCriterion("SHOW_PHONE between", value1, value2, "showPhone");
            return (Criteria) this;
        }

        public Criteria andShowPhoneNotBetween(Byte value1, Byte value2) {
            addCriterion("SHOW_PHONE not between", value1, value2, "showPhone");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNull() {
            addCriterion("CASE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("CASE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Integer value) {
            addCriterion("CASE_ID =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Integer value) {
            addCriterion("CASE_ID <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Integer value) {
            addCriterion("CASE_ID >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASE_ID >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Integer value) {
            addCriterion("CASE_ID <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("CASE_ID <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Integer> values) {
            addCriterion("CASE_ID in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Integer> values) {
            addCriterion("CASE_ID not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Integer value1, Integer value2) {
            addCriterion("CASE_ID between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CASE_ID not between", value1, value2, "caseId");
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

        public Criteria andCollectionTimeIsNull() {
            addCriterion("COLLECTION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNotNull() {
            addCriterion("COLLECTION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeEqualTo(String value) {
            addCriterion("COLLECTION_TIME =", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotEqualTo(String value) {
            addCriterion("COLLECTION_TIME <>", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThan(String value) {
            addCriterion("COLLECTION_TIME >", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("COLLECTION_TIME >=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThan(String value) {
            addCriterion("COLLECTION_TIME <", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThanOrEqualTo(String value) {
            addCriterion("COLLECTION_TIME <=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLike(String value) {
            addCriterion("COLLECTION_TIME like", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotLike(String value) {
            addCriterion("COLLECTION_TIME not like", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIn(List<String> values) {
            addCriterion("COLLECTION_TIME in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotIn(List<String> values) {
            addCriterion("COLLECTION_TIME not in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeBetween(String value1, String value2) {
            addCriterion("COLLECTION_TIME between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotBetween(String value1, String value2) {
            addCriterion("COLLECTION_TIME not between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andBuildRegIsNull() {
            addCriterion("BUILD_REG is null");
            return (Criteria) this;
        }

        public Criteria andBuildRegIsNotNull() {
            addCriterion("BUILD_REG is not null");
            return (Criteria) this;
        }

        public Criteria andBuildRegEqualTo(Integer value) {
            addCriterion("BUILD_REG =", value, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegNotEqualTo(Integer value) {
            addCriterion("BUILD_REG <>", value, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegGreaterThan(Integer value) {
            addCriterion("BUILD_REG >", value, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUILD_REG >=", value, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegLessThan(Integer value) {
            addCriterion("BUILD_REG <", value, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegLessThanOrEqualTo(Integer value) {
            addCriterion("BUILD_REG <=", value, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegIn(List<Integer> values) {
            addCriterion("BUILD_REG in", values, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegNotIn(List<Integer> values) {
            addCriterion("BUILD_REG not in", values, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_REG between", value1, value2, "buildReg");
            return (Criteria) this;
        }

        public Criteria andBuildRegNotBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_REG not between", value1, value2, "buildReg");
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

        public Criteria andSectionNameIsNull() {
            addCriterion("SECTION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNotNull() {
            addCriterion("SECTION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSectionNameEqualTo(String value) {
            addCriterion("SECTION_NAME =", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotEqualTo(String value) {
            addCriterion("SECTION_NAME <>", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThan(String value) {
            addCriterion("SECTION_NAME >", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("SECTION_NAME >=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThan(String value) {
            addCriterion("SECTION_NAME <", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThanOrEqualTo(String value) {
            addCriterion("SECTION_NAME <=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLike(String value) {
            addCriterion("SECTION_NAME like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotLike(String value) {
            addCriterion("SECTION_NAME not like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameIn(List<String> values) {
            addCriterion("SECTION_NAME in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotIn(List<String> values) {
            addCriterion("SECTION_NAME not in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameBetween(String value1, String value2) {
            addCriterion("SECTION_NAME between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotBetween(String value1, String value2) {
            addCriterion("SECTION_NAME not between", value1, value2, "sectionName");
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