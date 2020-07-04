package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAuditTemplateExample extends ShardDb {
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
	public ErpAuditTemplateExample() {
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

		public Criteria andNeedAuditIsNull() {
			addCriterion("NEED_AUDIT is null");
			return (Criteria) this;
		}

		public Criteria andNeedAuditIsNotNull() {
			addCriterion("NEED_AUDIT is not null");
			return (Criteria) this;
		}

		public Criteria andNeedAuditEqualTo(Byte value) {
			addCriterion("NEED_AUDIT =", value, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditNotEqualTo(Byte value) {
			addCriterion("NEED_AUDIT <>", value, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditGreaterThan(Byte value) {
			addCriterion("NEED_AUDIT >", value, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditGreaterThanOrEqualTo(Byte value) {
			addCriterion("NEED_AUDIT >=", value, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditLessThan(Byte value) {
			addCriterion("NEED_AUDIT <", value, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditLessThanOrEqualTo(Byte value) {
			addCriterion("NEED_AUDIT <=", value, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditIn(List<Byte> values) {
			addCriterion("NEED_AUDIT in", values, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditNotIn(List<Byte> values) {
			addCriterion("NEED_AUDIT not in", values, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditBetween(Byte value1, Byte value2) {
			addCriterion("NEED_AUDIT between", value1, value2, "needAudit");
			return (Criteria) this;
		}

		public Criteria andNeedAuditNotBetween(Byte value1, Byte value2) {
			addCriterion("NEED_AUDIT not between", value1, value2, "needAudit");
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

		public Criteria andRoleTypeIsNull() {
			addCriterion("ROLE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andRoleTypeIsNotNull() {
			addCriterion("ROLE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andRoleTypeEqualTo(Byte value) {
			addCriterion("ROLE_TYPE =", value, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeNotEqualTo(Byte value) {
			addCriterion("ROLE_TYPE <>", value, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeGreaterThan(Byte value) {
			addCriterion("ROLE_TYPE >", value, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ROLE_TYPE >=", value, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeLessThan(Byte value) {
			addCriterion("ROLE_TYPE <", value, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ROLE_TYPE <=", value, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeIn(List<Byte> values) {
			addCriterion("ROLE_TYPE in", values, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeNotIn(List<Byte> values) {
			addCriterion("ROLE_TYPE not in", values, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeBetween(Byte value1, Byte value2) {
			addCriterion("ROLE_TYPE between", value1, value2, "roleType");
			return (Criteria) this;
		}

		public Criteria andRoleTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ROLE_TYPE not between", value1, value2, "roleType");
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

		public Criteria andAuditProcessIdIsNull() {
			addCriterion("AUDIT_PROCESS_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdIsNotNull() {
			addCriterion("AUDIT_PROCESS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdEqualTo(Integer value) {
			addCriterion("AUDIT_PROCESS_ID =", value, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_PROCESS_ID <>", value, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdGreaterThan(Integer value) {
			addCriterion("AUDIT_PROCESS_ID >", value, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_PROCESS_ID >=", value, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdLessThan(Integer value) {
			addCriterion("AUDIT_PROCESS_ID <", value, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_PROCESS_ID <=", value, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdIn(List<Integer> values) {
			addCriterion("AUDIT_PROCESS_ID in", values, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_PROCESS_ID not in", values, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_PROCESS_ID between", value1, value2, "auditProcessId");
			return (Criteria) this;
		}

		public Criteria andAuditProcessIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_PROCESS_ID not between", value1, value2, "auditProcessId");
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