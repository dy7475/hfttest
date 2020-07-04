package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class ErpAuditRuntimeExample extends ShardDb {
    /**
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * @mbggenerated
	 */
	public ErpAuditRuntimeExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
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
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
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

		public Criteria andAreaIdIsNull() {
			addCriterion("AREA_ID is null");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNotNull() {
			addCriterion("AREA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAreaIdEqualTo(Integer value) {
			addCriterion("AREA_ID =", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotEqualTo(Integer value) {
			addCriterion("AREA_ID <>", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThan(Integer value) {
			addCriterion("AREA_ID >", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID >=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThan(Integer value) {
			addCriterion("AREA_ID <", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID <=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdIn(List<Integer> values) {
			addCriterion("AREA_ID in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotIn(List<Integer> values) {
			addCriterion("AREA_ID not in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID not between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNull() {
			addCriterion("REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNotNull() {
			addCriterion("REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRegIdEqualTo(Integer value) {
			addCriterion("REG_ID =", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotEqualTo(Integer value) {
			addCriterion("REG_ID <>", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThan(Integer value) {
			addCriterion("REG_ID >", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("REG_ID >=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThan(Integer value) {
			addCriterion("REG_ID <", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("REG_ID <=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdIn(List<Integer> values) {
			addCriterion("REG_ID in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotIn(List<Integer> values) {
			addCriterion("REG_ID not in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID between", value1, value2, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID not between", value1, value2, "regId");
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

		public Criteria andCaseTypeIsNull() {
			addCriterion("CASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNotNull() {
			addCriterion("CASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeEqualTo(Integer value) {
			addCriterion("CASE_TYPE =", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotEqualTo(Integer value) {
			addCriterion("CASE_TYPE <>", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThan(Integer value) {
			addCriterion("CASE_TYPE >", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE >=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThan(Integer value) {
			addCriterion("CASE_TYPE <", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE <=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIn(List<Integer> values) {
			addCriterion("CASE_TYPE in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotIn(List<Integer> values) {
			addCriterion("CASE_TYPE not in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE not between", value1, value2, "caseType");
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

		public Criteria andAuditTypeIsNull() {
			addCriterion("AUDIT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andAuditTypeIsNotNull() {
			addCriterion("AUDIT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andAuditTypeEqualTo(Integer value) {
			addCriterion("AUDIT_TYPE =", value, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeNotEqualTo(Integer value) {
			addCriterion("AUDIT_TYPE <>", value, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeGreaterThan(Integer value) {
			addCriterion("AUDIT_TYPE >", value, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_TYPE >=", value, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeLessThan(Integer value) {
			addCriterion("AUDIT_TYPE <", value, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_TYPE <=", value, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeIn(List<Integer> values) {
			addCriterion("AUDIT_TYPE in", values, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeNotIn(List<Integer> values) {
			addCriterion("AUDIT_TYPE not in", values, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_TYPE between", value1, value2, "auditType");
			return (Criteria) this;
		}

		public Criteria andAuditTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_TYPE not between", value1, value2, "auditType");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeIsNull() {
			addCriterion("OVERDUE_AUDIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeIsNotNull() {
			addCriterion("OVERDUE_AUDIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeEqualTo(Integer value) {
			addCriterion("OVERDUE_AUDIT_TIME =", value, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeNotEqualTo(Integer value) {
			addCriterion("OVERDUE_AUDIT_TIME <>", value, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeGreaterThan(Integer value) {
			addCriterion("OVERDUE_AUDIT_TIME >", value, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("OVERDUE_AUDIT_TIME >=", value, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeLessThan(Integer value) {
			addCriterion("OVERDUE_AUDIT_TIME <", value, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeLessThanOrEqualTo(Integer value) {
			addCriterion("OVERDUE_AUDIT_TIME <=", value, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeIn(List<Integer> values) {
			addCriterion("OVERDUE_AUDIT_TIME in", values, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeNotIn(List<Integer> values) {
			addCriterion("OVERDUE_AUDIT_TIME not in", values, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeBetween(Integer value1, Integer value2) {
			addCriterion("OVERDUE_AUDIT_TIME between", value1, value2, "overdueAuditTime");
			return (Criteria) this;
		}

		public Criteria andOverdueAuditTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("OVERDUE_AUDIT_TIME not between", value1, value2, "overdueAuditTime");
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

		public Criteria andAuditTitleIsNull() {
			addCriterion("AUDIT_TITLE is null");
			return (Criteria) this;
		}

		public Criteria andAuditTitleIsNotNull() {
			addCriterion("AUDIT_TITLE is not null");
			return (Criteria) this;
		}

		public Criteria andAuditTitleEqualTo(String value) {
			addCriterion("AUDIT_TITLE =", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleNotEqualTo(String value) {
			addCriterion("AUDIT_TITLE <>", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleGreaterThan(String value) {
			addCriterion("AUDIT_TITLE >", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleGreaterThanOrEqualTo(String value) {
			addCriterion("AUDIT_TITLE >=", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleLessThan(String value) {
			addCriterion("AUDIT_TITLE <", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleLessThanOrEqualTo(String value) {
			addCriterion("AUDIT_TITLE <=", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleLike(String value) {
			addCriterion("AUDIT_TITLE like", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleNotLike(String value) {
			addCriterion("AUDIT_TITLE not like", value, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleIn(List<String> values) {
			addCriterion("AUDIT_TITLE in", values, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleNotIn(List<String> values) {
			addCriterion("AUDIT_TITLE not in", values, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleBetween(String value1, String value2) {
			addCriterion("AUDIT_TITLE between", value1, value2, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditTitleNotBetween(String value1, String value2) {
			addCriterion("AUDIT_TITLE not between", value1, value2, "auditTitle");
			return (Criteria) this;
		}

		public Criteria andAuditExplainIsNull() {
			addCriterion("AUDIT_EXPLAIN is null");
			return (Criteria) this;
		}

		public Criteria andAuditExplainIsNotNull() {
			addCriterion("AUDIT_EXPLAIN is not null");
			return (Criteria) this;
		}

		public Criteria andAuditExplainEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN =", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN <>", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainGreaterThan(String value) {
			addCriterion("AUDIT_EXPLAIN >", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainGreaterThanOrEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN >=", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainLessThan(String value) {
			addCriterion("AUDIT_EXPLAIN <", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainLessThanOrEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN <=", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainLike(String value) {
			addCriterion("AUDIT_EXPLAIN like", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotLike(String value) {
			addCriterion("AUDIT_EXPLAIN not like", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainIn(List<String> values) {
			addCriterion("AUDIT_EXPLAIN in", values, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotIn(List<String> values) {
			addCriterion("AUDIT_EXPLAIN not in", values, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainBetween(String value1, String value2) {
			addCriterion("AUDIT_EXPLAIN between", value1, value2, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotBetween(String value1, String value2) {
			addCriterion("AUDIT_EXPLAIN not between", value1, value2, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNull() {
			addCriterion("AUDIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNotNull() {
			addCriterion("AUDIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS =", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS <>", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThan(Byte value) {
			addCriterion("AUDIT_STATUS >", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS >=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThan(Byte value) {
			addCriterion("AUDIT_STATUS <", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_STATUS <=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIn(List<Byte> values) {
			addCriterion("AUDIT_STATUS in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotIn(List<Byte> values) {
			addCriterion("AUDIT_STATUS not in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_STATUS between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_STATUS not between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeIsNull() {
			addCriterion("LAST_AUDIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeIsNotNull() {
			addCriterion("LAST_AUDIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeEqualTo(Date value) {
			addCriterion("LAST_AUDIT_TIME =", value, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeNotEqualTo(Date value) {
			addCriterion("LAST_AUDIT_TIME <>", value, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeGreaterThan(Date value) {
			addCriterion("LAST_AUDIT_TIME >", value, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LAST_AUDIT_TIME >=", value, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeLessThan(Date value) {
			addCriterion("LAST_AUDIT_TIME <", value, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeLessThanOrEqualTo(Date value) {
			addCriterion("LAST_AUDIT_TIME <=", value, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeIn(List<Date> values) {
			addCriterion("LAST_AUDIT_TIME in", values, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeNotIn(List<Date> values) {
			addCriterion("LAST_AUDIT_TIME not in", values, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeBetween(Date value1, Date value2) {
			addCriterion("LAST_AUDIT_TIME between", value1, value2, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andLastAuditTimeNotBetween(Date value1, Date value2) {
			addCriterion("LAST_AUDIT_TIME not between", value1, value2, "lastAuditTime");
			return (Criteria) this;
		}

		public Criteria andAuditFromIsNull() {
			addCriterion("AUDIT_FROM is null");
			return (Criteria) this;
		}

		public Criteria andAuditFromIsNotNull() {
			addCriterion("AUDIT_FROM is not null");
			return (Criteria) this;
		}

		public Criteria andAuditFromEqualTo(Byte value) {
			addCriterion("AUDIT_FROM =", value, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromNotEqualTo(Byte value) {
			addCriterion("AUDIT_FROM <>", value, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromGreaterThan(Byte value) {
			addCriterion("AUDIT_FROM >", value, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_FROM >=", value, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromLessThan(Byte value) {
			addCriterion("AUDIT_FROM <", value, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromLessThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_FROM <=", value, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromIn(List<Byte> values) {
			addCriterion("AUDIT_FROM in", values, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromNotIn(List<Byte> values) {
			addCriterion("AUDIT_FROM not in", values, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_FROM between", value1, value2, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andAuditFromNotBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_FROM not between", value1, value2, "auditFrom");
			return (Criteria) this;
		}

		public Criteria andTargetTimeIsNull() {
			addCriterion("TARGET_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTargetTimeIsNotNull() {
			addCriterion("TARGET_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTargetTimeEqualTo(Date value) {
			addCriterion("TARGET_TIME =", value, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeNotEqualTo(Date value) {
			addCriterion("TARGET_TIME <>", value, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeGreaterThan(Date value) {
			addCriterion("TARGET_TIME >", value, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TARGET_TIME >=", value, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeLessThan(Date value) {
			addCriterion("TARGET_TIME <", value, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeLessThanOrEqualTo(Date value) {
			addCriterion("TARGET_TIME <=", value, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeIn(List<Date> values) {
			addCriterion("TARGET_TIME in", values, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeNotIn(List<Date> values) {
			addCriterion("TARGET_TIME not in", values, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeBetween(Date value1, Date value2) {
			addCriterion("TARGET_TIME between", value1, value2, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetTimeNotBetween(Date value1, Date value2) {
			addCriterion("TARGET_TIME not between", value1, value2, "targetTime");
			return (Criteria) this;
		}

		public Criteria andTargetIdIsNull() {
			addCriterion("TARGET_ID is null");
			return (Criteria) this;
		}

		public Criteria andTargetIdIsNotNull() {
			addCriterion("TARGET_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTargetIdEqualTo(Integer value) {
			addCriterion("TARGET_ID =", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdNotEqualTo(Integer value) {
			addCriterion("TARGET_ID <>", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdGreaterThan(Integer value) {
			addCriterion("TARGET_ID >", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TARGET_ID >=", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdLessThan(Integer value) {
			addCriterion("TARGET_ID <", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdLessThanOrEqualTo(Integer value) {
			addCriterion("TARGET_ID <=", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdIn(List<Integer> values) {
			addCriterion("TARGET_ID in", values, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdNotIn(List<Integer> values) {
			addCriterion("TARGET_ID not in", values, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_ID between", value1, value2, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_ID not between", value1, value2, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIsNull() {
			addCriterion("TARGET_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIsNotNull() {
			addCriterion("TARGET_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTargetTypeEqualTo(Integer value) {
			addCriterion("TARGET_TYPE =", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotEqualTo(Integer value) {
			addCriterion("TARGET_TYPE <>", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeGreaterThan(Integer value) {
			addCriterion("TARGET_TYPE >", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("TARGET_TYPE >=", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeLessThan(Integer value) {
			addCriterion("TARGET_TYPE <", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeLessThanOrEqualTo(Integer value) {
			addCriterion("TARGET_TYPE <=", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIn(List<Integer> values) {
			addCriterion("TARGET_TYPE in", values, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotIn(List<Integer> values) {
			addCriterion("TARGET_TYPE not in", values, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_TYPE between", value1, value2, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_TYPE not between", value1, value2, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetNoIsNull() {
			addCriterion("TARGET_NO is null");
			return (Criteria) this;
		}

		public Criteria andTargetNoIsNotNull() {
			addCriterion("TARGET_NO is not null");
			return (Criteria) this;
		}

		public Criteria andTargetNoEqualTo(String value) {
			addCriterion("TARGET_NO =", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoNotEqualTo(String value) {
			addCriterion("TARGET_NO <>", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoGreaterThan(String value) {
			addCriterion("TARGET_NO >", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoGreaterThanOrEqualTo(String value) {
			addCriterion("TARGET_NO >=", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoLessThan(String value) {
			addCriterion("TARGET_NO <", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoLessThanOrEqualTo(String value) {
			addCriterion("TARGET_NO <=", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoLike(String value) {
			addCriterion("TARGET_NO like", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoNotLike(String value) {
			addCriterion("TARGET_NO not like", value, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoIn(List<String> values) {
			addCriterion("TARGET_NO in", values, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoNotIn(List<String> values) {
			addCriterion("TARGET_NO not in", values, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoBetween(String value1, String value2) {
			addCriterion("TARGET_NO between", value1, value2, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetNoNotBetween(String value1, String value2) {
			addCriterion("TARGET_NO not between", value1, value2, "targetNo");
			return (Criteria) this;
		}

		public Criteria andTargetUseageIsNull() {
			addCriterion("TARGET_USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andTargetUseageIsNotNull() {
			addCriterion("TARGET_USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andTargetUseageEqualTo(Integer value) {
			addCriterion("TARGET_USEAGE =", value, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageNotEqualTo(Integer value) {
			addCriterion("TARGET_USEAGE <>", value, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageGreaterThan(Integer value) {
			addCriterion("TARGET_USEAGE >", value, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageGreaterThanOrEqualTo(Integer value) {
			addCriterion("TARGET_USEAGE >=", value, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageLessThan(Integer value) {
			addCriterion("TARGET_USEAGE <", value, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageLessThanOrEqualTo(Integer value) {
			addCriterion("TARGET_USEAGE <=", value, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageIn(List<Integer> values) {
			addCriterion("TARGET_USEAGE in", values, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageNotIn(List<Integer> values) {
			addCriterion("TARGET_USEAGE not in", values, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_USEAGE between", value1, value2, "targetUseage");
			return (Criteria) this;
		}

		public Criteria andTargetUseageNotBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_USEAGE not between", value1, value2, "targetUseage");
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

		public Criteria andNowAuditInfoIsNull() {
			addCriterion("NOW_AUDIT_INFO is null");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoIsNotNull() {
			addCriterion("NOW_AUDIT_INFO is not null");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoEqualTo(String value) {
			addCriterion("NOW_AUDIT_INFO =", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoNotEqualTo(String value) {
			addCriterion("NOW_AUDIT_INFO <>", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoGreaterThan(String value) {
			addCriterion("NOW_AUDIT_INFO >", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoGreaterThanOrEqualTo(String value) {
			addCriterion("NOW_AUDIT_INFO >=", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoLessThan(String value) {
			addCriterion("NOW_AUDIT_INFO <", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoLessThanOrEqualTo(String value) {
			addCriterion("NOW_AUDIT_INFO <=", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoLike(String value) {
			addCriterion("NOW_AUDIT_INFO like", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoNotLike(String value) {
			addCriterion("NOW_AUDIT_INFO not like", value, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoIn(List<String> values) {
			addCriterion("NOW_AUDIT_INFO in", values, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoNotIn(List<String> values) {
			addCriterion("NOW_AUDIT_INFO not in", values, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoBetween(String value1, String value2) {
			addCriterion("NOW_AUDIT_INFO between", value1, value2, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andNowAuditInfoNotBetween(String value1, String value2) {
			addCriterion("NOW_AUDIT_INFO not between", value1, value2, "nowAuditInfo");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsIsNull() {
			addCriterion("PHOTO_URLS is null");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsIsNotNull() {
			addCriterion("PHOTO_URLS is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsEqualTo(String value) {
			addCriterion("PHOTO_URLS =", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotEqualTo(String value) {
			addCriterion("PHOTO_URLS <>", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsGreaterThan(String value) {
			addCriterion("PHOTO_URLS >", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsGreaterThanOrEqualTo(String value) {
			addCriterion("PHOTO_URLS >=", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsLessThan(String value) {
			addCriterion("PHOTO_URLS <", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsLessThanOrEqualTo(String value) {
			addCriterion("PHOTO_URLS <=", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsLike(String value) {
			addCriterion("PHOTO_URLS like", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotLike(String value) {
			addCriterion("PHOTO_URLS not like", value, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsIn(List<String> values) {
			addCriterion("PHOTO_URLS in", values, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotIn(List<String> values) {
			addCriterion("PHOTO_URLS not in", values, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsBetween(String value1, String value2) {
			addCriterion("PHOTO_URLS between", value1, value2, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andPhotoUrlsNotBetween(String value1, String value2) {
			addCriterion("PHOTO_URLS not between", value1, value2, "photoUrls");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesIsNull() {
			addCriterion("TARGET_USEAGES is null");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesIsNotNull() {
			addCriterion("TARGET_USEAGES is not null");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesEqualTo(String value) {
			addCriterion("TARGET_USEAGES =", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesNotEqualTo(String value) {
			addCriterion("TARGET_USEAGES <>", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesGreaterThan(String value) {
			addCriterion("TARGET_USEAGES >", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesGreaterThanOrEqualTo(String value) {
			addCriterion("TARGET_USEAGES >=", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesLessThan(String value) {
			addCriterion("TARGET_USEAGES <", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesLessThanOrEqualTo(String value) {
			addCriterion("TARGET_USEAGES <=", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesLike(String value) {
			addCriterion("TARGET_USEAGES like", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesNotLike(String value) {
			addCriterion("TARGET_USEAGES not like", value, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesIn(List<String> values) {
			addCriterion("TARGET_USEAGES in", values, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesNotIn(List<String> values) {
			addCriterion("TARGET_USEAGES not in", values, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesBetween(String value1, String value2) {
			addCriterion("TARGET_USEAGES between", value1, value2, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andTargetUseagesNotBetween(String value1, String value2) {
			addCriterion("TARGET_USEAGES not between", value1, value2, "targetUseages");
			return (Criteria) this;
		}

		public Criteria andUserIdsIsNull() {
			addCriterion("USER_IDS is null");
			return (Criteria) this;
		}

		public Criteria andUserIdsIsNotNull() {
			addCriterion("USER_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdsEqualTo(String value) {
			addCriterion("USER_IDS =", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsNotEqualTo(String value) {
			addCriterion("USER_IDS <>", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsGreaterThan(String value) {
			addCriterion("USER_IDS >", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsGreaterThanOrEqualTo(String value) {
			addCriterion("USER_IDS >=", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsLessThan(String value) {
			addCriterion("USER_IDS <", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsLessThanOrEqualTo(String value) {
			addCriterion("USER_IDS <=", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsLike(String value) {
			addCriterion("USER_IDS like", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsNotLike(String value) {
			addCriterion("USER_IDS not like", value, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsIn(List<String> values) {
			addCriterion("USER_IDS in", values, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsNotIn(List<String> values) {
			addCriterion("USER_IDS not in", values, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsBetween(String value1, String value2) {
			addCriterion("USER_IDS between", value1, value2, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserIdsNotBetween(String value1, String value2) {
			addCriterion("USER_IDS not between", value1, value2, "userIds");
			return (Criteria) this;
		}

		public Criteria andUserNamesIsNull() {
			addCriterion("USER_NAMES is null");
			return (Criteria) this;
		}

		public Criteria andUserNamesIsNotNull() {
			addCriterion("USER_NAMES is not null");
			return (Criteria) this;
		}

		public Criteria andUserNamesEqualTo(String value) {
			addCriterion("USER_NAMES =", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesNotEqualTo(String value) {
			addCriterion("USER_NAMES <>", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesGreaterThan(String value) {
			addCriterion("USER_NAMES >", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NAMES >=", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesLessThan(String value) {
			addCriterion("USER_NAMES <", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesLessThanOrEqualTo(String value) {
			addCriterion("USER_NAMES <=", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesLike(String value) {
			addCriterion("USER_NAMES like", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesNotLike(String value) {
			addCriterion("USER_NAMES not like", value, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesIn(List<String> values) {
			addCriterion("USER_NAMES in", values, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesNotIn(List<String> values) {
			addCriterion("USER_NAMES not in", values, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesBetween(String value1, String value2) {
			addCriterion("USER_NAMES between", value1, value2, "userNames");
			return (Criteria) this;
		}

		public Criteria andUserNamesNotBetween(String value1, String value2) {
			addCriterion("USER_NAMES not between", value1, value2, "userNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesIsNull() {
			addCriterion("DEPT_NAMES is null");
			return (Criteria) this;
		}

		public Criteria andDeptNamesIsNotNull() {
			addCriterion("DEPT_NAMES is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNamesEqualTo(String value) {
			addCriterion("DEPT_NAMES =", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesNotEqualTo(String value) {
			addCriterion("DEPT_NAMES <>", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesGreaterThan(String value) {
			addCriterion("DEPT_NAMES >", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NAMES >=", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesLessThan(String value) {
			addCriterion("DEPT_NAMES <", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NAMES <=", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesLike(String value) {
			addCriterion("DEPT_NAMES like", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesNotLike(String value) {
			addCriterion("DEPT_NAMES not like", value, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesIn(List<String> values) {
			addCriterion("DEPT_NAMES in", values, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesNotIn(List<String> values) {
			addCriterion("DEPT_NAMES not in", values, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesBetween(String value1, String value2) {
			addCriterion("DEPT_NAMES between", value1, value2, "deptNames");
			return (Criteria) this;
		}

		public Criteria andDeptNamesNotBetween(String value1, String value2) {
			addCriterion("DEPT_NAMES not between", value1, value2, "deptNames");
			return (Criteria) this;
		}

		public Criteria andVideoIdsIsNull() {
			addCriterion("VIDEO_IDS is null");
			return (Criteria) this;
		}

		public Criteria andVideoIdsIsNotNull() {
			addCriterion("VIDEO_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andVideoIdsEqualTo(String value) {
			addCriterion("VIDEO_IDS =", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsNotEqualTo(String value) {
			addCriterion("VIDEO_IDS <>", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsGreaterThan(String value) {
			addCriterion("VIDEO_IDS >", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsGreaterThanOrEqualTo(String value) {
			addCriterion("VIDEO_IDS >=", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsLessThan(String value) {
			addCriterion("VIDEO_IDS <", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsLessThanOrEqualTo(String value) {
			addCriterion("VIDEO_IDS <=", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsLike(String value) {
			addCriterion("VIDEO_IDS like", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsNotLike(String value) {
			addCriterion("VIDEO_IDS not like", value, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsIn(List<String> values) {
			addCriterion("VIDEO_IDS in", values, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsNotIn(List<String> values) {
			addCriterion("VIDEO_IDS not in", values, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsBetween(String value1, String value2) {
			addCriterion("VIDEO_IDS between", value1, value2, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVideoIdsNotBetween(String value1, String value2) {
			addCriterion("VIDEO_IDS not between", value1, value2, "videoIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsIsNull() {
			addCriterion("VR_IDS is null");
			return (Criteria) this;
		}

		public Criteria andVrIdsIsNotNull() {
			addCriterion("VR_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andVrIdsEqualTo(String value) {
			addCriterion("VR_IDS =", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsNotEqualTo(String value) {
			addCriterion("VR_IDS <>", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsGreaterThan(String value) {
			addCriterion("VR_IDS >", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsGreaterThanOrEqualTo(String value) {
			addCriterion("VR_IDS >=", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsLessThan(String value) {
			addCriterion("VR_IDS <", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsLessThanOrEqualTo(String value) {
			addCriterion("VR_IDS <=", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsLike(String value) {
			addCriterion("VR_IDS like", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsNotLike(String value) {
			addCriterion("VR_IDS not like", value, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsIn(List<String> values) {
			addCriterion("VR_IDS in", values, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsNotIn(List<String> values) {
			addCriterion("VR_IDS not in", values, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsBetween(String value1, String value2) {
			addCriterion("VR_IDS between", value1, value2, "vrIds");
			return (Criteria) this;
		}

		public Criteria andVrIdsNotBetween(String value1, String value2) {
			addCriterion("VR_IDS not between", value1, value2, "vrIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsIsNull() {
			addCriterion("TARGET_IDS is null");
			return (Criteria) this;
		}

		public Criteria andTargetIdsIsNotNull() {
			addCriterion("TARGET_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andTargetIdsEqualTo(String value) {
			addCriterion("TARGET_IDS =", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsNotEqualTo(String value) {
			addCriterion("TARGET_IDS <>", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsGreaterThan(String value) {
			addCriterion("TARGET_IDS >", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsGreaterThanOrEqualTo(String value) {
			addCriterion("TARGET_IDS >=", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsLessThan(String value) {
			addCriterion("TARGET_IDS <", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsLessThanOrEqualTo(String value) {
			addCriterion("TARGET_IDS <=", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsLike(String value) {
			addCriterion("TARGET_IDS like", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsNotLike(String value) {
			addCriterion("TARGET_IDS not like", value, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsIn(List<String> values) {
			addCriterion("TARGET_IDS in", values, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsNotIn(List<String> values) {
			addCriterion("TARGET_IDS not in", values, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsBetween(String value1, String value2) {
			addCriterion("TARGET_IDS between", value1, value2, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTargetIdsNotBetween(String value1, String value2) {
			addCriterion("TARGET_IDS not between", value1, value2, "targetIds");
			return (Criteria) this;
		}

		public Criteria andTrackNoIsNull() {
			addCriterion("TRACK_NO is null");
			return (Criteria) this;
		}

		public Criteria andTrackNoIsNotNull() {
			addCriterion("TRACK_NO is not null");
			return (Criteria) this;
		}

		public Criteria andTrackNoEqualTo(String value) {
			addCriterion("TRACK_NO =", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoNotEqualTo(String value) {
			addCriterion("TRACK_NO <>", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoGreaterThan(String value) {
			addCriterion("TRACK_NO >", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoGreaterThanOrEqualTo(String value) {
			addCriterion("TRACK_NO >=", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoLessThan(String value) {
			addCriterion("TRACK_NO <", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoLessThanOrEqualTo(String value) {
			addCriterion("TRACK_NO <=", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoLike(String value) {
			addCriterion("TRACK_NO like", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoNotLike(String value) {
			addCriterion("TRACK_NO not like", value, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoIn(List<String> values) {
			addCriterion("TRACK_NO in", values, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoNotIn(List<String> values) {
			addCriterion("TRACK_NO not in", values, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoBetween(String value1, String value2) {
			addCriterion("TRACK_NO between", value1, value2, "trackNo");
			return (Criteria) this;
		}

		public Criteria andTrackNoNotBetween(String value1, String value2) {
			addCriterion("TRACK_NO not between", value1, value2, "trackNo");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsIsNull() {
			addCriterion("PHOTO_IDS is null");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsIsNotNull() {
			addCriterion("PHOTO_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsEqualTo(String value) {
			addCriterion("PHOTO_IDS =", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsNotEqualTo(String value) {
			addCriterion("PHOTO_IDS <>", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsGreaterThan(String value) {
			addCriterion("PHOTO_IDS >", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsGreaterThanOrEqualTo(String value) {
			addCriterion("PHOTO_IDS >=", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsLessThan(String value) {
			addCriterion("PHOTO_IDS <", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsLessThanOrEqualTo(String value) {
			addCriterion("PHOTO_IDS <=", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsLike(String value) {
			addCriterion("PHOTO_IDS like", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsNotLike(String value) {
			addCriterion("PHOTO_IDS not like", value, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsIn(List<String> values) {
			addCriterion("PHOTO_IDS in", values, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsNotIn(List<String> values) {
			addCriterion("PHOTO_IDS not in", values, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsBetween(String value1, String value2) {
			addCriterion("PHOTO_IDS between", value1, value2, "photoIds");
			return (Criteria) this;
		}

		public Criteria andPhotoIdsNotBetween(String value1, String value2) {
			addCriterion("PHOTO_IDS not between", value1, value2, "photoIds");
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

		public Criteria andKeyDeptIdIsNull() {
			addCriterion("KEY_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdIsNotNull() {
			addCriterion("KEY_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdEqualTo(Integer value) {
			addCriterion("KEY_DEPT_ID =", value, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdNotEqualTo(Integer value) {
			addCriterion("KEY_DEPT_ID <>", value, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdGreaterThan(Integer value) {
			addCriterion("KEY_DEPT_ID >", value, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("KEY_DEPT_ID >=", value, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdLessThan(Integer value) {
			addCriterion("KEY_DEPT_ID <", value, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("KEY_DEPT_ID <=", value, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdIn(List<Integer> values) {
			addCriterion("KEY_DEPT_ID in", values, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdNotIn(List<Integer> values) {
			addCriterion("KEY_DEPT_ID not in", values, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("KEY_DEPT_ID between", value1, value2, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andKeyDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("KEY_DEPT_ID not between", value1, value2, "keyDeptId");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsIsNull() {
			addCriterion("VIDEO_URLS is null");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsIsNotNull() {
			addCriterion("VIDEO_URLS is not null");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsEqualTo(String value) {
			addCriterion("VIDEO_URLS =", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsNotEqualTo(String value) {
			addCriterion("VIDEO_URLS <>", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsGreaterThan(String value) {
			addCriterion("VIDEO_URLS >", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsGreaterThanOrEqualTo(String value) {
			addCriterion("VIDEO_URLS >=", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsLessThan(String value) {
			addCriterion("VIDEO_URLS <", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsLessThanOrEqualTo(String value) {
			addCriterion("VIDEO_URLS <=", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsLike(String value) {
			addCriterion("VIDEO_URLS like", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsNotLike(String value) {
			addCriterion("VIDEO_URLS not like", value, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsIn(List<String> values) {
			addCriterion("VIDEO_URLS in", values, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsNotIn(List<String> values) {
			addCriterion("VIDEO_URLS not in", values, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsBetween(String value1, String value2) {
			addCriterion("VIDEO_URLS between", value1, value2, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andVideoUrlsNotBetween(String value1, String value2) {
			addCriterion("VIDEO_URLS not between", value1, value2, "videoUrls");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIsNull() {
			addCriterion("PRICE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIsNotNull() {
			addCriterion("PRICE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andPriceUnitEqualTo(Integer value) {
			addCriterion("PRICE_UNIT =", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotEqualTo(Integer value) {
			addCriterion("PRICE_UNIT <>", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitGreaterThan(Integer value) {
			addCriterion("PRICE_UNIT >", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitGreaterThanOrEqualTo(Integer value) {
			addCriterion("PRICE_UNIT >=", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitLessThan(Integer value) {
			addCriterion("PRICE_UNIT <", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitLessThanOrEqualTo(Integer value) {
			addCriterion("PRICE_UNIT <=", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIn(List<Integer> values) {
			addCriterion("PRICE_UNIT in", values, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotIn(List<Integer> values) {
			addCriterion("PRICE_UNIT not in", values, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitBetween(Integer value1, Integer value2) {
			addCriterion("PRICE_UNIT between", value1, value2, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotBetween(Integer value1, Integer value2) {
			addCriterion("PRICE_UNIT not between", value1, value2, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andLowestPriceIsNull() {
			addCriterion("LOWEST_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLowestPriceIsNotNull() {
			addCriterion("LOWEST_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLowestPriceEqualTo(BigDecimal value) {
			addCriterion("LOWEST_PRICE =", value, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceNotEqualTo(BigDecimal value) {
			addCriterion("LOWEST_PRICE <>", value, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceGreaterThan(BigDecimal value) {
			addCriterion("LOWEST_PRICE >", value, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LOWEST_PRICE >=", value, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceLessThan(BigDecimal value) {
			addCriterion("LOWEST_PRICE <", value, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LOWEST_PRICE <=", value, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceIn(List<BigDecimal> values) {
			addCriterion("LOWEST_PRICE in", values, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceNotIn(List<BigDecimal> values) {
			addCriterion("LOWEST_PRICE not in", values, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOWEST_PRICE between", value1, value2, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andLowestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOWEST_PRICE not between", value1, value2, "lowestPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceIsNull() {
			addCriterion("TOTAL_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andTotalPriceIsNotNull() {
			addCriterion("TOTAL_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andTotalPriceEqualTo(BigDecimal value) {
			addCriterion("TOTAL_PRICE =", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
			addCriterion("TOTAL_PRICE <>", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceGreaterThan(BigDecimal value) {
			addCriterion("TOTAL_PRICE >", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_PRICE >=", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceLessThan(BigDecimal value) {
			addCriterion("TOTAL_PRICE <", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_PRICE <=", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceIn(List<BigDecimal> values) {
			addCriterion("TOTAL_PRICE in", values, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
			addCriterion("TOTAL_PRICE not in", values, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_PRICE between", value1, value2, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_PRICE not between", value1, value2, "totalPrice");
			return (Criteria) this;
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

		public Criteria andAuditResourceIsNull() {
			addCriterion("AUDIT_RESOURCE is null");
			return (Criteria) this;
		}

		public Criteria andAuditResourceIsNotNull() {
			addCriterion("AUDIT_RESOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andAuditResourceEqualTo(Byte value) {
			addCriterion("AUDIT_RESOURCE =", value, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceNotEqualTo(Byte value) {
			addCriterion("AUDIT_RESOURCE <>", value, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceGreaterThan(Byte value) {
			addCriterion("AUDIT_RESOURCE >", value, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_RESOURCE >=", value, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceLessThan(Byte value) {
			addCriterion("AUDIT_RESOURCE <", value, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceLessThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_RESOURCE <=", value, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceIn(List<Byte> values) {
			addCriterion("AUDIT_RESOURCE in", values, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceNotIn(List<Byte> values) {
			addCriterion("AUDIT_RESOURCE not in", values, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_RESOURCE between", value1, value2, "auditResource");
			return (Criteria) this;
		}

		public Criteria andAuditResourceNotBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_RESOURCE not between", value1, value2, "auditResource");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeIsNull() {
			addCriterion("TARGET_START_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeIsNotNull() {
			addCriterion("TARGET_START_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeEqualTo(Date value) {
			addCriterion("TARGET_START_TIME =", value, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeNotEqualTo(Date value) {
			addCriterion("TARGET_START_TIME <>", value, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeGreaterThan(Date value) {
			addCriterion("TARGET_START_TIME >", value, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TARGET_START_TIME >=", value, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeLessThan(Date value) {
			addCriterion("TARGET_START_TIME <", value, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("TARGET_START_TIME <=", value, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeIn(List<Date> values) {
			addCriterion("TARGET_START_TIME in", values, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeNotIn(List<Date> values) {
			addCriterion("TARGET_START_TIME not in", values, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeBetween(Date value1, Date value2) {
			addCriterion("TARGET_START_TIME between", value1, value2, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("TARGET_START_TIME not between", value1, value2, "targetStartTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeIsNull() {
			addCriterion("TARGET_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeIsNotNull() {
			addCriterion("TARGET_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeEqualTo(Date value) {
			addCriterion("TARGET_END_TIME =", value, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeNotEqualTo(Date value) {
			addCriterion("TARGET_END_TIME <>", value, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeGreaterThan(Date value) {
			addCriterion("TARGET_END_TIME >", value, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TARGET_END_TIME >=", value, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeLessThan(Date value) {
			addCriterion("TARGET_END_TIME <", value, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("TARGET_END_TIME <=", value, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeIn(List<Date> values) {
			addCriterion("TARGET_END_TIME in", values, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeNotIn(List<Date> values) {
			addCriterion("TARGET_END_TIME not in", values, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeBetween(Date value1, Date value2) {
			addCriterion("TARGET_END_TIME between", value1, value2, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("TARGET_END_TIME not between", value1, value2, "targetEndTime");
			return (Criteria) this;
		}

		public Criteria andTargetDayIsNull() {
			addCriterion("TARGET_DAY is null");
			return (Criteria) this;
		}

		public Criteria andTargetDayIsNotNull() {
			addCriterion("TARGET_DAY is not null");
			return (Criteria) this;
		}

		public Criteria andTargetDayEqualTo(BigDecimal value) {
			addCriterion("TARGET_DAY =", value, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayNotEqualTo(BigDecimal value) {
			addCriterion("TARGET_DAY <>", value, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayGreaterThan(BigDecimal value) {
			addCriterion("TARGET_DAY >", value, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TARGET_DAY >=", value, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayLessThan(BigDecimal value) {
			addCriterion("TARGET_DAY <", value, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TARGET_DAY <=", value, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayIn(List<BigDecimal> values) {
			addCriterion("TARGET_DAY in", values, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayNotIn(List<BigDecimal> values) {
			addCriterion("TARGET_DAY not in", values, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TARGET_DAY between", value1, value2, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetDayNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TARGET_DAY not between", value1, value2, "targetDay");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeIsNull() {
			addCriterion("TARGET_START_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeIsNotNull() {
			addCriterion("TARGET_START_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeEqualTo(Byte value) {
			addCriterion("TARGET_START_TYPE =", value, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeNotEqualTo(Byte value) {
			addCriterion("TARGET_START_TYPE <>", value, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeGreaterThan(Byte value) {
			addCriterion("TARGET_START_TYPE >", value, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TARGET_START_TYPE >=", value, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeLessThan(Byte value) {
			addCriterion("TARGET_START_TYPE <", value, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TARGET_START_TYPE <=", value, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeIn(List<Byte> values) {
			addCriterion("TARGET_START_TYPE in", values, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeNotIn(List<Byte> values) {
			addCriterion("TARGET_START_TYPE not in", values, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeBetween(Byte value1, Byte value2) {
			addCriterion("TARGET_START_TYPE between", value1, value2, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetStartTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TARGET_START_TYPE not between", value1, value2, "targetStartType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeIsNull() {
			addCriterion("TARGET_END_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeIsNotNull() {
			addCriterion("TARGET_END_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeEqualTo(Byte value) {
			addCriterion("TARGET_END_TYPE =", value, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeNotEqualTo(Byte value) {
			addCriterion("TARGET_END_TYPE <>", value, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeGreaterThan(Byte value) {
			addCriterion("TARGET_END_TYPE >", value, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TARGET_END_TYPE >=", value, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeLessThan(Byte value) {
			addCriterion("TARGET_END_TYPE <", value, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TARGET_END_TYPE <=", value, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeIn(List<Byte> values) {
			addCriterion("TARGET_END_TYPE in", values, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeNotIn(List<Byte> values) {
			addCriterion("TARGET_END_TYPE not in", values, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeBetween(Byte value1, Byte value2) {
			addCriterion("TARGET_END_TYPE between", value1, value2, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetEndTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TARGET_END_TYPE not between", value1, value2, "targetEndType");
			return (Criteria) this;
		}

		public Criteria andTargetTypesIsNull() {
			addCriterion("TARGET_TYPES is null");
			return (Criteria) this;
		}

		public Criteria andTargetTypesIsNotNull() {
			addCriterion("TARGET_TYPES is not null");
			return (Criteria) this;
		}

		public Criteria andTargetTypesEqualTo(String value) {
			addCriterion("TARGET_TYPES =", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesNotEqualTo(String value) {
			addCriterion("TARGET_TYPES <>", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesGreaterThan(String value) {
			addCriterion("TARGET_TYPES >", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesGreaterThanOrEqualTo(String value) {
			addCriterion("TARGET_TYPES >=", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesLessThan(String value) {
			addCriterion("TARGET_TYPES <", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesLessThanOrEqualTo(String value) {
			addCriterion("TARGET_TYPES <=", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesLike(String value) {
			addCriterion("TARGET_TYPES like", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesNotLike(String value) {
			addCriterion("TARGET_TYPES not like", value, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesIn(List<String> values) {
			addCriterion("TARGET_TYPES in", values, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesNotIn(List<String> values) {
			addCriterion("TARGET_TYPES not in", values, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesBetween(String value1, String value2) {
			addCriterion("TARGET_TYPES between", value1, value2, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andTargetTypesNotBetween(String value1, String value2) {
			addCriterion("TARGET_TYPES not between", value1, value2, "targetTypes");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsIsNull() {
			addCriterion("VIDEO_LOCATIONS is null");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsIsNotNull() {
			addCriterion("VIDEO_LOCATIONS is not null");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsEqualTo(String value) {
			addCriterion("VIDEO_LOCATIONS =", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsNotEqualTo(String value) {
			addCriterion("VIDEO_LOCATIONS <>", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsGreaterThan(String value) {
			addCriterion("VIDEO_LOCATIONS >", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsGreaterThanOrEqualTo(String value) {
			addCriterion("VIDEO_LOCATIONS >=", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsLessThan(String value) {
			addCriterion("VIDEO_LOCATIONS <", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsLessThanOrEqualTo(String value) {
			addCriterion("VIDEO_LOCATIONS <=", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsLike(String value) {
			addCriterion("VIDEO_LOCATIONS like", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsNotLike(String value) {
			addCriterion("VIDEO_LOCATIONS not like", value, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsIn(List<String> values) {
			addCriterion("VIDEO_LOCATIONS in", values, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsNotIn(List<String> values) {
			addCriterion("VIDEO_LOCATIONS not in", values, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsBetween(String value1, String value2) {
			addCriterion("VIDEO_LOCATIONS between", value1, value2, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoLocationsNotBetween(String value1, String value2) {
			addCriterion("VIDEO_LOCATIONS not between", value1, value2, "videoLocations");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesIsNull() {
			addCriterion("VIDEO_SHOOTING_TIMES is null");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesIsNotNull() {
			addCriterion("VIDEO_SHOOTING_TIMES is not null");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES =", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesNotEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES <>", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesGreaterThan(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES >", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesGreaterThanOrEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES >=", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesLessThan(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES <", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesLessThanOrEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES <=", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesLike(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES like", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesNotLike(String value) {
			addCriterion("VIDEO_SHOOTING_TIMES not like", value, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesIn(List<String> values) {
			addCriterion("VIDEO_SHOOTING_TIMES in", values, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesNotIn(List<String> values) {
			addCriterion("VIDEO_SHOOTING_TIMES not in", values, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesBetween(String value1, String value2) {
			addCriterion("VIDEO_SHOOTING_TIMES between", value1, value2, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimesNotBetween(String value1, String value2) {
			addCriterion("VIDEO_SHOOTING_TIMES not between", value1, value2, "videoShootingTimes");
			return (Criteria) this;
		}

		public Criteria andCaseStatusIsNull() {
			addCriterion("CASE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCaseStatusIsNotNull() {
			addCriterion("CASE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCaseStatusEqualTo(Byte value) {
			addCriterion("CASE_STATUS =", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusNotEqualTo(Byte value) {
			addCriterion("CASE_STATUS <>", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusGreaterThan(Byte value) {
			addCriterion("CASE_STATUS >", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("CASE_STATUS >=", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusLessThan(Byte value) {
			addCriterion("CASE_STATUS <", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusLessThanOrEqualTo(Byte value) {
			addCriterion("CASE_STATUS <=", value, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusIn(List<Byte> values) {
			addCriterion("CASE_STATUS in", values, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusNotIn(List<Byte> values) {
			addCriterion("CASE_STATUS not in", values, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusBetween(Byte value1, Byte value2) {
			addCriterion("CASE_STATUS between", value1, value2, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andCaseStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("CASE_STATUS not between", value1, value2, "caseStatus");
			return (Criteria) this;
		}

		public Criteria andMakeSureIsNull() {
			addCriterion("MAKE_SURE is null");
			return (Criteria) this;
		}

		public Criteria andMakeSureIsNotNull() {
			addCriterion("MAKE_SURE is not null");
			return (Criteria) this;
		}

		public Criteria andMakeSureEqualTo(Byte value) {
			addCriterion("MAKE_SURE =", value, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureNotEqualTo(Byte value) {
			addCriterion("MAKE_SURE <>", value, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureGreaterThan(Byte value) {
			addCriterion("MAKE_SURE >", value, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureGreaterThanOrEqualTo(Byte value) {
			addCriterion("MAKE_SURE >=", value, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureLessThan(Byte value) {
			addCriterion("MAKE_SURE <", value, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureLessThanOrEqualTo(Byte value) {
			addCriterion("MAKE_SURE <=", value, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureIn(List<Byte> values) {
			addCriterion("MAKE_SURE in", values, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureNotIn(List<Byte> values) {
			addCriterion("MAKE_SURE not in", values, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureBetween(Byte value1, Byte value2) {
			addCriterion("MAKE_SURE between", value1, value2, "makeSure");
			return (Criteria) this;
		}

		public Criteria andMakeSureNotBetween(Byte value1, Byte value2) {
			addCriterion("MAKE_SURE not between", value1, value2, "makeSure");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoIsNull() {
			addCriterion("DK_HOUSE_INFO is null");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoIsNotNull() {
			addCriterion("DK_HOUSE_INFO is not null");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoEqualTo(String value) {
			addCriterion("DK_HOUSE_INFO =", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoNotEqualTo(String value) {
			addCriterion("DK_HOUSE_INFO <>", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoGreaterThan(String value) {
			addCriterion("DK_HOUSE_INFO >", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoGreaterThanOrEqualTo(String value) {
			addCriterion("DK_HOUSE_INFO >=", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoLessThan(String value) {
			addCriterion("DK_HOUSE_INFO <", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoLessThanOrEqualTo(String value) {
			addCriterion("DK_HOUSE_INFO <=", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoLike(String value) {
			addCriterion("DK_HOUSE_INFO like", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoNotLike(String value) {
			addCriterion("DK_HOUSE_INFO not like", value, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoIn(List<String> values) {
			addCriterion("DK_HOUSE_INFO in", values, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoNotIn(List<String> values) {
			addCriterion("DK_HOUSE_INFO not in", values, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoBetween(String value1, String value2) {
			addCriterion("DK_HOUSE_INFO between", value1, value2, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andDkHouseInfoNotBetween(String value1, String value2) {
			addCriterion("DK_HOUSE_INFO not between", value1, value2, "dkHouseInfo");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdIsNull() {
			addCriterion("TAKE_LOOK_ID is null");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdIsNotNull() {
			addCriterion("TAKE_LOOK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdEqualTo(Integer value) {
			addCriterion("TAKE_LOOK_ID =", value, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdNotEqualTo(Integer value) {
			addCriterion("TAKE_LOOK_ID <>", value, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdGreaterThan(Integer value) {
			addCriterion("TAKE_LOOK_ID >", value, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TAKE_LOOK_ID >=", value, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdLessThan(Integer value) {
			addCriterion("TAKE_LOOK_ID <", value, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdLessThanOrEqualTo(Integer value) {
			addCriterion("TAKE_LOOK_ID <=", value, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdIn(List<Integer> values) {
			addCriterion("TAKE_LOOK_ID in", values, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdNotIn(List<Integer> values) {
			addCriterion("TAKE_LOOK_ID not in", values, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdBetween(Integer value1, Integer value2) {
			addCriterion("TAKE_LOOK_ID between", value1, value2, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andTakeLookIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TAKE_LOOK_ID not between", value1, value2, "takeLookId");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceIsNull() {
			addCriterion("COMMISSION_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceIsNotNull() {
			addCriterion("COMMISSION_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceEqualTo(Integer value) {
			addCriterion("COMMISSION_PRICE =", value, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceNotEqualTo(Integer value) {
			addCriterion("COMMISSION_PRICE <>", value, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceGreaterThan(Integer value) {
			addCriterion("COMMISSION_PRICE >", value, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMMISSION_PRICE >=", value, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceLessThan(Integer value) {
			addCriterion("COMMISSION_PRICE <", value, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceLessThanOrEqualTo(Integer value) {
			addCriterion("COMMISSION_PRICE <=", value, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceIn(List<Integer> values) {
			addCriterion("COMMISSION_PRICE in", values, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceNotIn(List<Integer> values) {
			addCriterion("COMMISSION_PRICE not in", values, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceBetween(Integer value1, Integer value2) {
			addCriterion("COMMISSION_PRICE between", value1, value2, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andCommissionPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("COMMISSION_PRICE not between", value1, value2, "commissionPrice");
			return (Criteria) this;
		}

		public Criteria andIsIntentionIsNull() {
			addCriterion("IS_INTENTION is null");
			return (Criteria) this;
		}

		public Criteria andIsIntentionIsNotNull() {
			addCriterion("IS_INTENTION is not null");
			return (Criteria) this;
		}

		public Criteria andIsIntentionEqualTo(Byte value) {
			addCriterion("IS_INTENTION =", value, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionNotEqualTo(Byte value) {
			addCriterion("IS_INTENTION <>", value, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionGreaterThan(Byte value) {
			addCriterion("IS_INTENTION >", value, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_INTENTION >=", value, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionLessThan(Byte value) {
			addCriterion("IS_INTENTION <", value, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionLessThanOrEqualTo(Byte value) {
			addCriterion("IS_INTENTION <=", value, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionIn(List<Byte> values) {
			addCriterion("IS_INTENTION in", values, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionNotIn(List<Byte> values) {
			addCriterion("IS_INTENTION not in", values, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionBetween(Byte value1, Byte value2) {
			addCriterion("IS_INTENTION between", value1, value2, "isIntention");
			return (Criteria) this;
		}

		public Criteria andIsIntentionNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_INTENTION not between", value1, value2, "isIntention");
			return (Criteria) this;
		}

		public Criteria andTrackTagsIsNull() {
			addCriterion("TRACK_TAGS is null");
			return (Criteria) this;
		}

		public Criteria andTrackTagsIsNotNull() {
			addCriterion("TRACK_TAGS is not null");
			return (Criteria) this;
		}

		public Criteria andTrackTagsEqualTo(String value) {
			addCriterion("TRACK_TAGS =", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsNotEqualTo(String value) {
			addCriterion("TRACK_TAGS <>", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsGreaterThan(String value) {
			addCriterion("TRACK_TAGS >", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsGreaterThanOrEqualTo(String value) {
			addCriterion("TRACK_TAGS >=", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsLessThan(String value) {
			addCriterion("TRACK_TAGS <", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsLessThanOrEqualTo(String value) {
			addCriterion("TRACK_TAGS <=", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsLike(String value) {
			addCriterion("TRACK_TAGS like", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsNotLike(String value) {
			addCriterion("TRACK_TAGS not like", value, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsIn(List<String> values) {
			addCriterion("TRACK_TAGS in", values, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsNotIn(List<String> values) {
			addCriterion("TRACK_TAGS not in", values, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsBetween(String value1, String value2) {
			addCriterion("TRACK_TAGS between", value1, value2, "trackTags");
			return (Criteria) this;
		}

		public Criteria andTrackTagsNotBetween(String value1, String value2) {
			addCriterion("TRACK_TAGS not between", value1, value2, "trackTags");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdIsNull() {
			addCriterion("MAKE_LOOK_ID is null");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdIsNotNull() {
			addCriterion("MAKE_LOOK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdEqualTo(Integer value) {
			addCriterion("MAKE_LOOK_ID =", value, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdNotEqualTo(Integer value) {
			addCriterion("MAKE_LOOK_ID <>", value, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdGreaterThan(Integer value) {
			addCriterion("MAKE_LOOK_ID >", value, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("MAKE_LOOK_ID >=", value, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdLessThan(Integer value) {
			addCriterion("MAKE_LOOK_ID <", value, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdLessThanOrEqualTo(Integer value) {
			addCriterion("MAKE_LOOK_ID <=", value, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdIn(List<Integer> values) {
			addCriterion("MAKE_LOOK_ID in", values, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdNotIn(List<Integer> values) {
			addCriterion("MAKE_LOOK_ID not in", values, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdBetween(Integer value1, Integer value2) {
			addCriterion("MAKE_LOOK_ID between", value1, value2, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andMakeLookIdNotBetween(Integer value1, Integer value2) {
			addCriterion("MAKE_LOOK_ID not between", value1, value2, "makeLookId");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlIsNull() {
			addCriterion("VIDEO_THUMBNAIL_URL is null");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlIsNotNull() {
			addCriterion("VIDEO_THUMBNAIL_URL is not null");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlEqualTo(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL =", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlNotEqualTo(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL <>", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlGreaterThan(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL >", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlGreaterThanOrEqualTo(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL >=", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlLessThan(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL <", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlLessThanOrEqualTo(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL <=", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlLike(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL like", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlNotLike(String value) {
			addCriterion("VIDEO_THUMBNAIL_URL not like", value, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlIn(List<String> values) {
			addCriterion("VIDEO_THUMBNAIL_URL in", values, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlNotIn(List<String> values) {
			addCriterion("VIDEO_THUMBNAIL_URL not in", values, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlBetween(String value1, String value2) {
			addCriterion("VIDEO_THUMBNAIL_URL between", value1, value2, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andVideoThumbnailUrlNotBetween(String value1, String value2) {
			addCriterion("VIDEO_THUMBNAIL_URL not between", value1, value2, "videoThumbnailUrl");
			return (Criteria) this;
		}

		public Criteria andClassNameIsNull() {
			addCriterion("CLASS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andClassNameIsNotNull() {
			addCriterion("CLASS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andClassNameEqualTo(String value) {
			addCriterion("CLASS_NAME =", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotEqualTo(String value) {
			addCriterion("CLASS_NAME <>", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameGreaterThan(String value) {
			addCriterion("CLASS_NAME >", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameGreaterThanOrEqualTo(String value) {
			addCriterion("CLASS_NAME >=", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLessThan(String value) {
			addCriterion("CLASS_NAME <", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLessThanOrEqualTo(String value) {
			addCriterion("CLASS_NAME <=", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLike(String value) {
			addCriterion("CLASS_NAME like", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotLike(String value) {
			addCriterion("CLASS_NAME not like", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameIn(List<String> values) {
			addCriterion("CLASS_NAME in", values, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotIn(List<String> values) {
			addCriterion("CLASS_NAME not in", values, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameBetween(String value1, String value2) {
			addCriterion("CLASS_NAME between", value1, value2, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotBetween(String value1, String value2) {
			addCriterion("CLASS_NAME not between", value1, value2, "className");
			return (Criteria) this;
		}

		public Criteria andClassIdIsNull() {
			addCriterion("CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andClassIdIsNotNull() {
			addCriterion("CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andClassIdEqualTo(Integer value) {
			addCriterion("CLASS_ID =", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotEqualTo(Integer value) {
			addCriterion("CLASS_ID <>", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThan(Integer value) {
			addCriterion("CLASS_ID >", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CLASS_ID >=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThan(Integer value) {
			addCriterion("CLASS_ID <", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("CLASS_ID <=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdIn(List<Integer> values) {
			addCriterion("CLASS_ID in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotIn(List<Integer> values) {
			addCriterion("CLASS_ID not in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdBetween(Integer value1, Integer value2) {
			addCriterion("CLASS_ID between", value1, value2, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CLASS_ID not between", value1, value2, "classId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdIsNull() {
			addCriterion("COOPERATE_TARGET_ID is null");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdIsNotNull() {
			addCriterion("COOPERATE_TARGET_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdEqualTo(Integer value) {
			addCriterion("COOPERATE_TARGET_ID =", value, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdNotEqualTo(Integer value) {
			addCriterion("COOPERATE_TARGET_ID <>", value, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdGreaterThan(Integer value) {
			addCriterion("COOPERATE_TARGET_ID >", value, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COOPERATE_TARGET_ID >=", value, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdLessThan(Integer value) {
			addCriterion("COOPERATE_TARGET_ID <", value, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdLessThanOrEqualTo(Integer value) {
			addCriterion("COOPERATE_TARGET_ID <=", value, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdIn(List<Integer> values) {
			addCriterion("COOPERATE_TARGET_ID in", values, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdNotIn(List<Integer> values) {
			addCriterion("COOPERATE_TARGET_ID not in", values, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdBetween(Integer value1, Integer value2) {
			addCriterion("COOPERATE_TARGET_ID between", value1, value2, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andCooperateTargetIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COOPERATE_TARGET_ID not between", value1, value2, "cooperateTargetId");
			return (Criteria) this;
		}

		public Criteria andParamJsonIsNull() {
			addCriterion("PARAM_JSON is null");
			return (Criteria) this;
		}

		public Criteria andParamJsonIsNotNull() {
			addCriterion("PARAM_JSON is not null");
			return (Criteria) this;
		}

		public Criteria andParamJsonEqualTo(String value) {
			addCriterion("PARAM_JSON =", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonNotEqualTo(String value) {
			addCriterion("PARAM_JSON <>", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonGreaterThan(String value) {
			addCriterion("PARAM_JSON >", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_JSON >=", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonLessThan(String value) {
			addCriterion("PARAM_JSON <", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonLessThanOrEqualTo(String value) {
			addCriterion("PARAM_JSON <=", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonLike(String value) {
			addCriterion("PARAM_JSON like", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonNotLike(String value) {
			addCriterion("PARAM_JSON not like", value, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonIn(List<String> values) {
			addCriterion("PARAM_JSON in", values, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonNotIn(List<String> values) {
			addCriterion("PARAM_JSON not in", values, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonBetween(String value1, String value2) {
			addCriterion("PARAM_JSON between", value1, value2, "paramJson");
			return (Criteria) this;
		}

		public Criteria andParamJsonNotBetween(String value1, String value2) {
			addCriterion("PARAM_JSON not between", value1, value2, "paramJson");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsIsNull() {
			addCriterion("ATTACHMENT_URLS is null");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsIsNotNull() {
			addCriterion("ATTACHMENT_URLS is not null");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsEqualTo(String value) {
			addCriterion("ATTACHMENT_URLS =", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsNotEqualTo(String value) {
			addCriterion("ATTACHMENT_URLS <>", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsGreaterThan(String value) {
			addCriterion("ATTACHMENT_URLS >", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsGreaterThanOrEqualTo(String value) {
			addCriterion("ATTACHMENT_URLS >=", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsLessThan(String value) {
			addCriterion("ATTACHMENT_URLS <", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsLessThanOrEqualTo(String value) {
			addCriterion("ATTACHMENT_URLS <=", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsLike(String value) {
			addCriterion("ATTACHMENT_URLS like", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsNotLike(String value) {
			addCriterion("ATTACHMENT_URLS not like", value, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsIn(List<String> values) {
			addCriterion("ATTACHMENT_URLS in", values, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsNotIn(List<String> values) {
			addCriterion("ATTACHMENT_URLS not in", values, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsBetween(String value1, String value2) {
			addCriterion("ATTACHMENT_URLS between", value1, value2, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andAttachmentUrlsNotBetween(String value1, String value2) {
			addCriterion("ATTACHMENT_URLS not between", value1, value2, "attachmentUrls");
			return (Criteria) this;
		}

		public Criteria andTemplateIdIsNull() {
			addCriterion("TEMPLATE_ID is null");
			return (Criteria) this;
		}

		public Criteria andTemplateIdIsNotNull() {
			addCriterion("TEMPLATE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateIdEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID =", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID <>", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdGreaterThan(Integer value) {
			addCriterion("TEMPLATE_ID >", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID >=", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdLessThan(Integer value) {
			addCriterion("TEMPLATE_ID <", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdLessThanOrEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID <=", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdIn(List<Integer> values) {
			addCriterion("TEMPLATE_ID in", values, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotIn(List<Integer> values) {
			addCriterion("TEMPLATE_ID not in", values, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdBetween(Integer value1, Integer value2) {
			addCriterion("TEMPLATE_ID between", value1, value2, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TEMPLATE_ID not between", value1, value2, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIsNull() {
			addCriterion("TEMPLATE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIsNotNull() {
			addCriterion("TEMPLATE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateNameEqualTo(String value) {
			addCriterion("TEMPLATE_NAME =", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotEqualTo(String value) {
			addCriterion("TEMPLATE_NAME <>", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameGreaterThan(String value) {
			addCriterion("TEMPLATE_NAME >", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
			addCriterion("TEMPLATE_NAME >=", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLessThan(String value) {
			addCriterion("TEMPLATE_NAME <", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLessThanOrEqualTo(String value) {
			addCriterion("TEMPLATE_NAME <=", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLike(String value) {
			addCriterion("TEMPLATE_NAME like", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotLike(String value) {
			addCriterion("TEMPLATE_NAME not like", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIn(List<String> values) {
			addCriterion("TEMPLATE_NAME in", values, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotIn(List<String> values) {
			addCriterion("TEMPLATE_NAME not in", values, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameBetween(String value1, String value2) {
			addCriterion("TEMPLATE_NAME between", value1, value2, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotBetween(String value1, String value2) {
			addCriterion("TEMPLATE_NAME not between", value1, value2, "templateName");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditIsNull() {
			addCriterion("IS_SHARE_AUDIT is null");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditIsNotNull() {
			addCriterion("IS_SHARE_AUDIT is not null");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditEqualTo(Byte value) {
			addCriterion("IS_SHARE_AUDIT =", value, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditNotEqualTo(Byte value) {
			addCriterion("IS_SHARE_AUDIT <>", value, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditGreaterThan(Byte value) {
			addCriterion("IS_SHARE_AUDIT >", value, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SHARE_AUDIT >=", value, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditLessThan(Byte value) {
			addCriterion("IS_SHARE_AUDIT <", value, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SHARE_AUDIT <=", value, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditIn(List<Byte> values) {
			addCriterion("IS_SHARE_AUDIT in", values, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditNotIn(List<Byte> values) {
			addCriterion("IS_SHARE_AUDIT not in", values, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditBetween(Byte value1, Byte value2) {
			addCriterion("IS_SHARE_AUDIT between", value1, value2, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andIsShareAuditNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SHARE_AUDIT not between", value1, value2, "isShareAudit");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNull() {
			addCriterion("ORGANIZATION_PATH is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNotNull() {
			addCriterion("ORGANIZATION_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH =", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <>", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThan(String value) {
			addCriterion("ORGANIZATION_PATH >", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH >=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThan(String value) {
			addCriterion("ORGANIZATION_PATH <", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLike(String value) {
			addCriterion("ORGANIZATION_PATH like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotLike(String value) {
			addCriterion("ORGANIZATION_PATH not like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH not in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH between", value1, value2, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH not between", value1, value2, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNull() {
			addCriterion("ORGANIZATION_ID is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNotNull() {
			addCriterion("ORGANIZATION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID =", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <>", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThan(Integer value) {
			addCriterion("ORGANIZATION_ID >", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID >=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThan(Integer value) {
			addCriterion("ORGANIZATION_ID <", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID not in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID between", value1, value2, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID not between", value1, value2, "organizationId");
			return (Criteria) this;
		}
	}

	/**
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

	/**
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}