package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminCityshareBorkerComplaintExample {
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
    public AdminCityshareBorkerComplaintExample() {
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

        public Criteria andComplaintIdIsNull() {
            addCriterion("COMPLAINT_ID is null");
            return (Criteria) this;
        }

        public Criteria andComplaintIdIsNotNull() {
            addCriterion("COMPLAINT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintIdEqualTo(Integer value) {
            addCriterion("COMPLAINT_ID =", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdNotEqualTo(Integer value) {
            addCriterion("COMPLAINT_ID <>", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdGreaterThan(Integer value) {
            addCriterion("COMPLAINT_ID >", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMPLAINT_ID >=", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdLessThan(Integer value) {
            addCriterion("COMPLAINT_ID <", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMPLAINT_ID <=", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdIn(List<Integer> values) {
            addCriterion("COMPLAINT_ID in", values, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdNotIn(List<Integer> values) {
            addCriterion("COMPLAINT_ID not in", values, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdBetween(Integer value1, Integer value2) {
            addCriterion("COMPLAINT_ID between", value1, value2, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMPLAINT_ID not between", value1, value2, "complaintId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdIsNull() {
            addCriterion("SHAREHOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdIsNotNull() {
            addCriterion("SHAREHOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID =", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdNotEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID <>", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdGreaterThan(Integer value) {
            addCriterion("SHAREHOUSE_ID >", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID >=", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdLessThan(Integer value) {
            addCriterion("SHAREHOUSE_ID <", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("SHAREHOUSE_ID <=", value, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdIn(List<Integer> values) {
            addCriterion("SHAREHOUSE_ID in", values, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdNotIn(List<Integer> values) {
            addCriterion("SHAREHOUSE_ID not in", values, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdBetween(Integer value1, Integer value2) {
            addCriterion("SHAREHOUSE_ID between", value1, value2, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andSharehouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SHAREHOUSE_ID not between", value1, value2, "sharehouseId");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeIsNull() {
            addCriterion("CINFO_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeIsNotNull() {
            addCriterion("CINFO_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeEqualTo(Byte value) {
            addCriterion("CINFO_TYPE =", value, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeNotEqualTo(Byte value) {
            addCriterion("CINFO_TYPE <>", value, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeGreaterThan(Byte value) {
            addCriterion("CINFO_TYPE >", value, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("CINFO_TYPE >=", value, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeLessThan(Byte value) {
            addCriterion("CINFO_TYPE <", value, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeLessThanOrEqualTo(Byte value) {
            addCriterion("CINFO_TYPE <=", value, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeIn(List<Byte> values) {
            addCriterion("CINFO_TYPE in", values, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeNotIn(List<Byte> values) {
            addCriterion("CINFO_TYPE not in", values, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeBetween(Byte value1, Byte value2) {
            addCriterion("CINFO_TYPE between", value1, value2, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andCinfoTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("CINFO_TYPE not between", value1, value2, "cinfoType");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdIsNull() {
            addCriterion("SOURCE_COMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdIsNotNull() {
            addCriterion("SOURCE_COMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdEqualTo(Integer value) {
            addCriterion("SOURCE_COMP_ID =", value, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdNotEqualTo(Integer value) {
            addCriterion("SOURCE_COMP_ID <>", value, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdGreaterThan(Integer value) {
            addCriterion("SOURCE_COMP_ID >", value, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_COMP_ID >=", value, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdLessThan(Integer value) {
            addCriterion("SOURCE_COMP_ID <", value, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdLessThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_COMP_ID <=", value, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdIn(List<Integer> values) {
            addCriterion("SOURCE_COMP_ID in", values, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdNotIn(List<Integer> values) {
            addCriterion("SOURCE_COMP_ID not in", values, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_COMP_ID between", value1, value2, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceCompIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_COMP_ID not between", value1, value2, "sourceCompId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdIsNull() {
            addCriterion("SOURCE_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdIsNotNull() {
            addCriterion("SOURCE_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdEqualTo(Integer value) {
            addCriterion("SOURCE_DEPT_ID =", value, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdNotEqualTo(Integer value) {
            addCriterion("SOURCE_DEPT_ID <>", value, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdGreaterThan(Integer value) {
            addCriterion("SOURCE_DEPT_ID >", value, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_DEPT_ID >=", value, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdLessThan(Integer value) {
            addCriterion("SOURCE_DEPT_ID <", value, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_DEPT_ID <=", value, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdIn(List<Integer> values) {
            addCriterion("SOURCE_DEPT_ID in", values, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdNotIn(List<Integer> values) {
            addCriterion("SOURCE_DEPT_ID not in", values, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_DEPT_ID between", value1, value2, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_DEPT_ID not between", value1, value2, "sourceDeptId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdIsNull() {
            addCriterion("SOURCE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdIsNotNull() {
            addCriterion("SOURCE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdEqualTo(Integer value) {
            addCriterion("SOURCE_USER_ID =", value, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdNotEqualTo(Integer value) {
            addCriterion("SOURCE_USER_ID <>", value, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdGreaterThan(Integer value) {
            addCriterion("SOURCE_USER_ID >", value, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_USER_ID >=", value, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdLessThan(Integer value) {
            addCriterion("SOURCE_USER_ID <", value, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_USER_ID <=", value, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdIn(List<Integer> values) {
            addCriterion("SOURCE_USER_ID in", values, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdNotIn(List<Integer> values) {
            addCriterion("SOURCE_USER_ID not in", values, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_USER_ID between", value1, value2, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_USER_ID not between", value1, value2, "sourceUserId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdIsNull() {
            addCriterion("SOURCE_ARCHIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdIsNotNull() {
            addCriterion("SOURCE_ARCHIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdEqualTo(Integer value) {
            addCriterion("SOURCE_ARCHIVE_ID =", value, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdNotEqualTo(Integer value) {
            addCriterion("SOURCE_ARCHIVE_ID <>", value, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdGreaterThan(Integer value) {
            addCriterion("SOURCE_ARCHIVE_ID >", value, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_ARCHIVE_ID >=", value, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdLessThan(Integer value) {
            addCriterion("SOURCE_ARCHIVE_ID <", value, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("SOURCE_ARCHIVE_ID <=", value, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdIn(List<Integer> values) {
            addCriterion("SOURCE_ARCHIVE_ID in", values, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdNotIn(List<Integer> values) {
            addCriterion("SOURCE_ARCHIVE_ID not in", values, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_ARCHIVE_ID between", value1, value2, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andSourceArchiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SOURCE_ARCHIVE_ID not between", value1, value2, "sourceArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdIsNull() {
            addCriterion("TARGET_COMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdIsNotNull() {
            addCriterion("TARGET_COMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdEqualTo(Integer value) {
            addCriterion("TARGET_COMP_ID =", value, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdNotEqualTo(Integer value) {
            addCriterion("TARGET_COMP_ID <>", value, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdGreaterThan(Integer value) {
            addCriterion("TARGET_COMP_ID >", value, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARGET_COMP_ID >=", value, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdLessThan(Integer value) {
            addCriterion("TARGET_COMP_ID <", value, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdLessThanOrEqualTo(Integer value) {
            addCriterion("TARGET_COMP_ID <=", value, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdIn(List<Integer> values) {
            addCriterion("TARGET_COMP_ID in", values, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdNotIn(List<Integer> values) {
            addCriterion("TARGET_COMP_ID not in", values, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_COMP_ID between", value1, value2, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetCompIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_COMP_ID not between", value1, value2, "targetCompId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdIsNull() {
            addCriterion("TARGET_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdIsNotNull() {
            addCriterion("TARGET_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdEqualTo(Integer value) {
            addCriterion("TARGET_DEPT_ID =", value, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdNotEqualTo(Integer value) {
            addCriterion("TARGET_DEPT_ID <>", value, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdGreaterThan(Integer value) {
            addCriterion("TARGET_DEPT_ID >", value, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARGET_DEPT_ID >=", value, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdLessThan(Integer value) {
            addCriterion("TARGET_DEPT_ID <", value, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("TARGET_DEPT_ID <=", value, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdIn(List<Integer> values) {
            addCriterion("TARGET_DEPT_ID in", values, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdNotIn(List<Integer> values) {
            addCriterion("TARGET_DEPT_ID not in", values, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_DEPT_ID between", value1, value2, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_DEPT_ID not between", value1, value2, "targetDeptId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdIsNull() {
            addCriterion("TARGET_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdIsNotNull() {
            addCriterion("TARGET_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdEqualTo(Integer value) {
            addCriterion("TARGET_USER_ID =", value, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdNotEqualTo(Integer value) {
            addCriterion("TARGET_USER_ID <>", value, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdGreaterThan(Integer value) {
            addCriterion("TARGET_USER_ID >", value, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARGET_USER_ID >=", value, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdLessThan(Integer value) {
            addCriterion("TARGET_USER_ID <", value, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("TARGET_USER_ID <=", value, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdIn(List<Integer> values) {
            addCriterion("TARGET_USER_ID in", values, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdNotIn(List<Integer> values) {
            addCriterion("TARGET_USER_ID not in", values, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_USER_ID between", value1, value2, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_USER_ID not between", value1, value2, "targetUserId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdIsNull() {
            addCriterion("TARGET_ARCHIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdIsNotNull() {
            addCriterion("TARGET_ARCHIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdEqualTo(Integer value) {
            addCriterion("TARGET_ARCHIVE_ID =", value, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdNotEqualTo(Integer value) {
            addCriterion("TARGET_ARCHIVE_ID <>", value, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdGreaterThan(Integer value) {
            addCriterion("TARGET_ARCHIVE_ID >", value, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARGET_ARCHIVE_ID >=", value, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdLessThan(Integer value) {
            addCriterion("TARGET_ARCHIVE_ID <", value, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("TARGET_ARCHIVE_ID <=", value, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdIn(List<Integer> values) {
            addCriterion("TARGET_ARCHIVE_ID in", values, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdNotIn(List<Integer> values) {
            addCriterion("TARGET_ARCHIVE_ID not in", values, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_ARCHIVE_ID between", value1, value2, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andTargetArchiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TARGET_ARCHIVE_ID not between", value1, value2, "targetArchiveId");
            return (Criteria) this;
        }

        public Criteria andComplainContentIsNull() {
            addCriterion("COMPLAIN_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andComplainContentIsNotNull() {
            addCriterion("COMPLAIN_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andComplainContentEqualTo(String value) {
            addCriterion("COMPLAIN_CONTENT =", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentNotEqualTo(String value) {
            addCriterion("COMPLAIN_CONTENT <>", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentGreaterThan(String value) {
            addCriterion("COMPLAIN_CONTENT >", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLAIN_CONTENT >=", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentLessThan(String value) {
            addCriterion("COMPLAIN_CONTENT <", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentLessThanOrEqualTo(String value) {
            addCriterion("COMPLAIN_CONTENT <=", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentLike(String value) {
            addCriterion("COMPLAIN_CONTENT like", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentNotLike(String value) {
            addCriterion("COMPLAIN_CONTENT not like", value, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentIn(List<String> values) {
            addCriterion("COMPLAIN_CONTENT in", values, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentNotIn(List<String> values) {
            addCriterion("COMPLAIN_CONTENT not in", values, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentBetween(String value1, String value2) {
            addCriterion("COMPLAIN_CONTENT between", value1, value2, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainContentNotBetween(String value1, String value2) {
            addCriterion("COMPLAIN_CONTENT not between", value1, value2, "complainContent");
            return (Criteria) this;
        }

        public Criteria andComplainTypeIsNull() {
            addCriterion("COMPLAIN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andComplainTypeIsNotNull() {
            addCriterion("COMPLAIN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andComplainTypeEqualTo(Byte value) {
            addCriterion("COMPLAIN_TYPE =", value, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeNotEqualTo(Byte value) {
            addCriterion("COMPLAIN_TYPE <>", value, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeGreaterThan(Byte value) {
            addCriterion("COMPLAIN_TYPE >", value, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("COMPLAIN_TYPE >=", value, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeLessThan(Byte value) {
            addCriterion("COMPLAIN_TYPE <", value, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeLessThanOrEqualTo(Byte value) {
            addCriterion("COMPLAIN_TYPE <=", value, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeIn(List<Byte> values) {
            addCriterion("COMPLAIN_TYPE in", values, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeNotIn(List<Byte> values) {
            addCriterion("COMPLAIN_TYPE not in", values, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAIN_TYPE between", value1, value2, "complainType");
            return (Criteria) this;
        }

        public Criteria andComplainTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAIN_TYPE not between", value1, value2, "complainType");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNull() {
            addCriterion("DEAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("DEAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(Byte value) {
            addCriterion("DEAL_STATUS =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(Byte value) {
            addCriterion("DEAL_STATUS <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(Byte value) {
            addCriterion("DEAL_STATUS >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("DEAL_STATUS >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(Byte value) {
            addCriterion("DEAL_STATUS <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(Byte value) {
            addCriterion("DEAL_STATUS <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<Byte> values) {
            addCriterion("DEAL_STATUS in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<Byte> values) {
            addCriterion("DEAL_STATUS not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
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

        public Criteria andDealDescIsNull() {
            addCriterion("DEAL_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDealDescIsNotNull() {
            addCriterion("DEAL_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDealDescEqualTo(String value) {
            addCriterion("DEAL_DESC =", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotEqualTo(String value) {
            addCriterion("DEAL_DESC <>", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescGreaterThan(String value) {
            addCriterion("DEAL_DESC >", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_DESC >=", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescLessThan(String value) {
            addCriterion("DEAL_DESC <", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescLessThanOrEqualTo(String value) {
            addCriterion("DEAL_DESC <=", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescLike(String value) {
            addCriterion("DEAL_DESC like", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotLike(String value) {
            addCriterion("DEAL_DESC not like", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescIn(List<String> values) {
            addCriterion("DEAL_DESC in", values, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotIn(List<String> values) {
            addCriterion("DEAL_DESC not in", values, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescBetween(String value1, String value2) {
            addCriterion("DEAL_DESC between", value1, value2, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotBetween(String value1, String value2) {
            addCriterion("DEAL_DESC not between", value1, value2, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("DEAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("DEAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("DEAL_TIME =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("DEAL_TIME <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("DEAL_TIME >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DEAL_TIME >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("DEAL_TIME <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("DEAL_TIME <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("DEAL_TIME in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("DEAL_TIME not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("DEAL_TIME between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("DEAL_TIME not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserIsNull() {
            addCriterion("DEAL_CRM_USER is null");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserIsNotNull() {
            addCriterion("DEAL_CRM_USER is not null");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserEqualTo(Integer value) {
            addCriterion("DEAL_CRM_USER =", value, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserNotEqualTo(Integer value) {
            addCriterion("DEAL_CRM_USER <>", value, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserGreaterThan(Integer value) {
            addCriterion("DEAL_CRM_USER >", value, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEAL_CRM_USER >=", value, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserLessThan(Integer value) {
            addCriterion("DEAL_CRM_USER <", value, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserLessThanOrEqualTo(Integer value) {
            addCriterion("DEAL_CRM_USER <=", value, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserIn(List<Integer> values) {
            addCriterion("DEAL_CRM_USER in", values, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserNotIn(List<Integer> values) {
            addCriterion("DEAL_CRM_USER not in", values, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_CRM_USER between", value1, value2, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andDealCrmUserNotBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_CRM_USER not between", value1, value2, "dealCrmUser");
            return (Criteria) this;
        }

        public Criteria andComplainTimeIsNull() {
            addCriterion("COMPLAIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andComplainTimeIsNotNull() {
            addCriterion("COMPLAIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andComplainTimeEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME =", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeNotEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME <>", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeGreaterThan(Date value) {
            addCriterion("COMPLAIN_TIME >", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME >=", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeLessThan(Date value) {
            addCriterion("COMPLAIN_TIME <", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeLessThanOrEqualTo(Date value) {
            addCriterion("COMPLAIN_TIME <=", value, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeIn(List<Date> values) {
            addCriterion("COMPLAIN_TIME in", values, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeNotIn(List<Date> values) {
            addCriterion("COMPLAIN_TIME not in", values, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeBetween(Date value1, Date value2) {
            addCriterion("COMPLAIN_TIME between", value1, value2, "complainTime");
            return (Criteria) this;
        }

        public Criteria andComplainTimeNotBetween(Date value1, Date value2) {
            addCriterion("COMPLAIN_TIME not between", value1, value2, "complainTime");
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

        public Criteria andCaseNoIsNull() {
            addCriterion("CASE_NO is null");
            return (Criteria) this;
        }

        public Criteria andCaseNoIsNotNull() {
            addCriterion("CASE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNoEqualTo(String value) {
            addCriterion("CASE_NO =", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotEqualTo(String value) {
            addCriterion("CASE_NO <>", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoGreaterThan(String value) {
            addCriterion("CASE_NO >", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoGreaterThanOrEqualTo(String value) {
            addCriterion("CASE_NO >=", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLessThan(String value) {
            addCriterion("CASE_NO <", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLessThanOrEqualTo(String value) {
            addCriterion("CASE_NO <=", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLike(String value) {
            addCriterion("CASE_NO like", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotLike(String value) {
            addCriterion("CASE_NO not like", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoIn(List<String> values) {
            addCriterion("CASE_NO in", values, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotIn(List<String> values) {
            addCriterion("CASE_NO not in", values, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoBetween(String value1, String value2) {
            addCriterion("CASE_NO between", value1, value2, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotBetween(String value1, String value2) {
            addCriterion("CASE_NO not between", value1, value2, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeIsNull() {
            addCriterion("COOPERATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeIsNotNull() {
            addCriterion("COOPERATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeEqualTo(Byte value) {
            addCriterion("COOPERATION_TYPE =", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeNotEqualTo(Byte value) {
            addCriterion("COOPERATION_TYPE <>", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeGreaterThan(Byte value) {
            addCriterion("COOPERATION_TYPE >", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("COOPERATION_TYPE >=", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeLessThan(Byte value) {
            addCriterion("COOPERATION_TYPE <", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeLessThanOrEqualTo(Byte value) {
            addCriterion("COOPERATION_TYPE <=", value, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeIn(List<Byte> values) {
            addCriterion("COOPERATION_TYPE in", values, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeNotIn(List<Byte> values) {
            addCriterion("COOPERATION_TYPE not in", values, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeBetween(Byte value1, Byte value2) {
            addCriterion("COOPERATION_TYPE between", value1, value2, "cooperationType");
            return (Criteria) this;
        }

        public Criteria andCooperationTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("COOPERATION_TYPE not between", value1, value2, "cooperationType");
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

        public Criteria andDealMethodIsNull() {
            addCriterion("DEAL_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andDealMethodIsNotNull() {
            addCriterion("DEAL_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andDealMethodEqualTo(Byte value) {
            addCriterion("DEAL_METHOD =", value, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodNotEqualTo(Byte value) {
            addCriterion("DEAL_METHOD <>", value, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodGreaterThan(Byte value) {
            addCriterion("DEAL_METHOD >", value, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("DEAL_METHOD >=", value, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodLessThan(Byte value) {
            addCriterion("DEAL_METHOD <", value, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodLessThanOrEqualTo(Byte value) {
            addCriterion("DEAL_METHOD <=", value, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodIn(List<Byte> values) {
            addCriterion("DEAL_METHOD in", values, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodNotIn(List<Byte> values) {
            addCriterion("DEAL_METHOD not in", values, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_METHOD between", value1, value2, "dealMethod");
            return (Criteria) this;
        }

        public Criteria andDealMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("DEAL_METHOD not between", value1, value2, "dealMethod");
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