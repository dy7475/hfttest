package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunEmployeeLogExample extends ShardDb {
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
	public ErpFunEmployeeLogExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andEmployeeIdIsNull() {
			addCriterion("EMPLOYEE_ID is null");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdIsNotNull() {
			addCriterion("EMPLOYEE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdEqualTo(Integer value) {
			addCriterion("EMPLOYEE_ID =", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdNotEqualTo(Integer value) {
			addCriterion("EMPLOYEE_ID <>", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdGreaterThan(Integer value) {
			addCriterion("EMPLOYEE_ID >", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("EMPLOYEE_ID >=", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdLessThan(Integer value) {
			addCriterion("EMPLOYEE_ID <", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
			addCriterion("EMPLOYEE_ID <=", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdIn(List<Integer> values) {
			addCriterion("EMPLOYEE_ID in", values, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdNotIn(List<Integer> values) {
			addCriterion("EMPLOYEE_ID not in", values, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
			addCriterion("EMPLOYEE_ID between", value1, value2, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("EMPLOYEE_ID not between", value1, value2,
					"employeeId");
			return (Criteria) this;
		}

		public Criteria andLogTypeIsNull() {
			addCriterion("LOG_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLogTypeIsNotNull() {
			addCriterion("LOG_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLogTypeEqualTo(Byte value) {
			addCriterion("LOG_TYPE =", value, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeNotEqualTo(Byte value) {
			addCriterion("LOG_TYPE <>", value, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeGreaterThan(Byte value) {
			addCriterion("LOG_TYPE >", value, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("LOG_TYPE >=", value, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeLessThan(Byte value) {
			addCriterion("LOG_TYPE <", value, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeLessThanOrEqualTo(Byte value) {
			addCriterion("LOG_TYPE <=", value, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeIn(List<Byte> values) {
			addCriterion("LOG_TYPE in", values, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeNotIn(List<Byte> values) {
			addCriterion("LOG_TYPE not in", values, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeBetween(Byte value1, Byte value2) {
			addCriterion("LOG_TYPE between", value1, value2, "logType");
			return (Criteria) this;
		}

		public Criteria andLogTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("LOG_TYPE not between", value1, value2, "logType");
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
			addCriterion("CREATION_TIME between", value1, value2,
					"creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATION_TIME not between", value1, value2,
					"creationTime");
			return (Criteria) this;
		}

		public Criteria andCreateUidIsNull() {
			addCriterion("CREATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUidIsNotNull() {
			addCriterion("CREATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUidEqualTo(Integer value) {
			addCriterion("CREATE_UID =", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotEqualTo(Integer value) {
			addCriterion("CREATE_UID <>", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThan(Integer value) {
			addCriterion("CREATE_UID >", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID >=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThan(Integer value) {
			addCriterion("CREATE_UID <", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID <=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidIn(List<Integer> values) {
			addCriterion("CREATE_UID in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotIn(List<Integer> values) {
			addCriterion("CREATE_UID not in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID between", value1, value2, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID not between", value1, value2, "createUid");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptIsNull() {
			addCriterion("BEFORE_DEPT is null");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptIsNotNull() {
			addCriterion("BEFORE_DEPT is not null");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptEqualTo(Integer value) {
			addCriterion("BEFORE_DEPT =", value, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptNotEqualTo(Integer value) {
			addCriterion("BEFORE_DEPT <>", value, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptGreaterThan(Integer value) {
			addCriterion("BEFORE_DEPT >", value, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("BEFORE_DEPT >=", value, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptLessThan(Integer value) {
			addCriterion("BEFORE_DEPT <", value, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptLessThanOrEqualTo(Integer value) {
			addCriterion("BEFORE_DEPT <=", value, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptIn(List<Integer> values) {
			addCriterion("BEFORE_DEPT in", values, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptNotIn(List<Integer> values) {
			addCriterion("BEFORE_DEPT not in", values, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptBetween(Integer value1, Integer value2) {
			addCriterion("BEFORE_DEPT between", value1, value2, "beforeDept");
			return (Criteria) this;
		}

		public Criteria andBeforeDeptNotBetween(Integer value1, Integer value2) {
			addCriterion("BEFORE_DEPT not between", value1, value2,
					"beforeDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptIsNull() {
			addCriterion("AFTER_DEPT is null");
			return (Criteria) this;
		}

		public Criteria andAfterDeptIsNotNull() {
			addCriterion("AFTER_DEPT is not null");
			return (Criteria) this;
		}

		public Criteria andAfterDeptEqualTo(Integer value) {
			addCriterion("AFTER_DEPT =", value, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptNotEqualTo(Integer value) {
			addCriterion("AFTER_DEPT <>", value, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptGreaterThan(Integer value) {
			addCriterion("AFTER_DEPT >", value, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("AFTER_DEPT >=", value, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptLessThan(Integer value) {
			addCriterion("AFTER_DEPT <", value, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptLessThanOrEqualTo(Integer value) {
			addCriterion("AFTER_DEPT <=", value, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptIn(List<Integer> values) {
			addCriterion("AFTER_DEPT in", values, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptNotIn(List<Integer> values) {
			addCriterion("AFTER_DEPT not in", values, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptBetween(Integer value1, Integer value2) {
			addCriterion("AFTER_DEPT between", value1, value2, "afterDept");
			return (Criteria) this;
		}

		public Criteria andAfterDeptNotBetween(Integer value1, Integer value2) {
			addCriterion("AFTER_DEPT not between", value1, value2, "afterDept");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleIsNull() {
			addCriterion("BEFORE_ROLE is null");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleIsNotNull() {
			addCriterion("BEFORE_ROLE is not null");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleEqualTo(String value) {
			addCriterion("BEFORE_ROLE =", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleNotEqualTo(String value) {
			addCriterion("BEFORE_ROLE <>", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleGreaterThan(String value) {
			addCriterion("BEFORE_ROLE >", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleGreaterThanOrEqualTo(String value) {
			addCriterion("BEFORE_ROLE >=", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLessThan(String value) {
			addCriterion("BEFORE_ROLE <", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLessThanOrEqualTo(String value) {
			addCriterion("BEFORE_ROLE <=", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLike(String value) {
			addCriterion("BEFORE_ROLE like", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleNotLike(String value) {
			addCriterion("BEFORE_ROLE not like", value, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleIn(List<String> values) {
			addCriterion("BEFORE_ROLE in", values, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleNotIn(List<String> values) {
			addCriterion("BEFORE_ROLE not in", values, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleBetween(String value1, String value2) {
			addCriterion("BEFORE_ROLE between", value1, value2, "beforeRole");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleNotBetween(String value1, String value2) {
			addCriterion("BEFORE_ROLE not between", value1, value2,
					"beforeRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleIsNull() {
			addCriterion("AFTER_ROLE is null");
			return (Criteria) this;
		}

		public Criteria andAfterRoleIsNotNull() {
			addCriterion("AFTER_ROLE is not null");
			return (Criteria) this;
		}

		public Criteria andAfterRoleEqualTo(String value) {
			addCriterion("AFTER_ROLE =", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleNotEqualTo(String value) {
			addCriterion("AFTER_ROLE <>", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleGreaterThan(String value) {
			addCriterion("AFTER_ROLE >", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleGreaterThanOrEqualTo(String value) {
			addCriterion("AFTER_ROLE >=", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLessThan(String value) {
			addCriterion("AFTER_ROLE <", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLessThanOrEqualTo(String value) {
			addCriterion("AFTER_ROLE <=", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLike(String value) {
			addCriterion("AFTER_ROLE like", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleNotLike(String value) {
			addCriterion("AFTER_ROLE not like", value, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleIn(List<String> values) {
			addCriterion("AFTER_ROLE in", values, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleNotIn(List<String> values) {
			addCriterion("AFTER_ROLE not in", values, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleBetween(String value1, String value2) {
			addCriterion("AFTER_ROLE between", value1, value2, "afterRole");
			return (Criteria) this;
		}

		public Criteria andAfterRoleNotBetween(String value1, String value2) {
			addCriterion("AFTER_ROLE not between", value1, value2, "afterRole");
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

		public Criteria andContentIsNull() {
			addCriterion("CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("CONTENT =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("CONTENT <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("CONTENT >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("CONTENT >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("CONTENT <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("CONTENT <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("CONTENT like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("CONTENT not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("CONTENT in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("CONTENT not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("CONTENT between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("CONTENT not between", value1, value2, "content");
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

		public Criteria andBeforeGrIsNull() {
			addCriterion("BEFORE_GR is null");
			return (Criteria) this;
		}

		public Criteria andBeforeGrIsNotNull() {
			addCriterion("BEFORE_GR is not null");
			return (Criteria) this;
		}

		public Criteria andBeforeGrEqualTo(Integer value) {
			addCriterion("BEFORE_GR =", value, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrNotEqualTo(Integer value) {
			addCriterion("BEFORE_GR <>", value, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrGreaterThan(Integer value) {
			addCriterion("BEFORE_GR >", value, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrGreaterThanOrEqualTo(Integer value) {
			addCriterion("BEFORE_GR >=", value, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrLessThan(Integer value) {
			addCriterion("BEFORE_GR <", value, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrLessThanOrEqualTo(Integer value) {
			addCriterion("BEFORE_GR <=", value, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrIn(List<Integer> values) {
			addCriterion("BEFORE_GR in", values, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrNotIn(List<Integer> values) {
			addCriterion("BEFORE_GR not in", values, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrBetween(Integer value1, Integer value2) {
			addCriterion("BEFORE_GR between", value1, value2, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andBeforeGrNotBetween(Integer value1, Integer value2) {
			addCriterion("BEFORE_GR not between", value1, value2, "beforeGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrIsNull() {
			addCriterion("AFTER_GR is null");
			return (Criteria) this;
		}

		public Criteria andAfterGrIsNotNull() {
			addCriterion("AFTER_GR is not null");
			return (Criteria) this;
		}

		public Criteria andAfterGrEqualTo(Integer value) {
			addCriterion("AFTER_GR =", value, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrNotEqualTo(Integer value) {
			addCriterion("AFTER_GR <>", value, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrGreaterThan(Integer value) {
			addCriterion("AFTER_GR >", value, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrGreaterThanOrEqualTo(Integer value) {
			addCriterion("AFTER_GR >=", value, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrLessThan(Integer value) {
			addCriterion("AFTER_GR <", value, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrLessThanOrEqualTo(Integer value) {
			addCriterion("AFTER_GR <=", value, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrIn(List<Integer> values) {
			addCriterion("AFTER_GR in", values, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrNotIn(List<Integer> values) {
			addCriterion("AFTER_GR not in", values, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrBetween(Integer value1, Integer value2) {
			addCriterion("AFTER_GR between", value1, value2, "afterGr");
			return (Criteria) this;
		}

		public Criteria andAfterGrNotBetween(Integer value1, Integer value2) {
			addCriterion("AFTER_GR not between", value1, value2, "afterGr");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdIsNull() {
			addCriterion("BEFORE_ROLE_LEVEL_ID is null");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdIsNotNull() {
			addCriterion("BEFORE_ROLE_LEVEL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdEqualTo(Integer value) {
			addCriterion("BEFORE_ROLE_LEVEL_ID =", value, "beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdNotEqualTo(Integer value) {
			addCriterion("BEFORE_ROLE_LEVEL_ID <>", value, "beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdGreaterThan(Integer value) {
			addCriterion("BEFORE_ROLE_LEVEL_ID >", value, "beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BEFORE_ROLE_LEVEL_ID >=", value, "beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdLessThan(Integer value) {
			addCriterion("BEFORE_ROLE_LEVEL_ID <", value, "beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdLessThanOrEqualTo(Integer value) {
			addCriterion("BEFORE_ROLE_LEVEL_ID <=", value, "beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdIn(List<Integer> values) {
			addCriterion("BEFORE_ROLE_LEVEL_ID in", values, "beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdNotIn(List<Integer> values) {
			addCriterion("BEFORE_ROLE_LEVEL_ID not in", values,
					"beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdBetween(Integer value1,
				Integer value2) {
			addCriterion("BEFORE_ROLE_LEVEL_ID between", value1, value2,
					"beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeRoleLevelIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("BEFORE_ROLE_LEVEL_ID not between", value1, value2,
					"beforeRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdIsNull() {
			addCriterion("AFTER_ROLE_LEVEL_ID is null");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdIsNotNull() {
			addCriterion("AFTER_ROLE_LEVEL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdEqualTo(Integer value) {
			addCriterion("AFTER_ROLE_LEVEL_ID =", value, "afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdNotEqualTo(Integer value) {
			addCriterion("AFTER_ROLE_LEVEL_ID <>", value, "afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdGreaterThan(Integer value) {
			addCriterion("AFTER_ROLE_LEVEL_ID >", value, "afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AFTER_ROLE_LEVEL_ID >=", value, "afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdLessThan(Integer value) {
			addCriterion("AFTER_ROLE_LEVEL_ID <", value, "afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdLessThanOrEqualTo(Integer value) {
			addCriterion("AFTER_ROLE_LEVEL_ID <=", value, "afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdIn(List<Integer> values) {
			addCriterion("AFTER_ROLE_LEVEL_ID in", values, "afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdNotIn(List<Integer> values) {
			addCriterion("AFTER_ROLE_LEVEL_ID not in", values,
					"afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdBetween(Integer value1,
				Integer value2) {
			addCriterion("AFTER_ROLE_LEVEL_ID between", value1, value2,
					"afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andAfterRoleLevelIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("AFTER_ROLE_LEVEL_ID not between", value1, value2,
					"afterRoleLevelId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdIsNull() {
			addCriterion("BEFORE_ORGANIZATION_ID is null");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdIsNotNull() {
			addCriterion("BEFORE_ORGANIZATION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdEqualTo(Integer value) {
			addCriterion("BEFORE_ORGANIZATION_ID =", value,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdNotEqualTo(Integer value) {
			addCriterion("BEFORE_ORGANIZATION_ID <>", value,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdGreaterThan(Integer value) {
			addCriterion("BEFORE_ORGANIZATION_ID >", value,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdGreaterThanOrEqualTo(
				Integer value) {
			addCriterion("BEFORE_ORGANIZATION_ID >=", value,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdLessThan(Integer value) {
			addCriterion("BEFORE_ORGANIZATION_ID <", value,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdLessThanOrEqualTo(Integer value) {
			addCriterion("BEFORE_ORGANIZATION_ID <=", value,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdIn(List<Integer> values) {
			addCriterion("BEFORE_ORGANIZATION_ID in", values,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdNotIn(List<Integer> values) {
			addCriterion("BEFORE_ORGANIZATION_ID not in", values,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdBetween(Integer value1,
				Integer value2) {
			addCriterion("BEFORE_ORGANIZATION_ID between", value1, value2,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andBeforeOrganizationIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("BEFORE_ORGANIZATION_ID not between", value1, value2,
					"beforeOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdIsNull() {
			addCriterion("AFTER_ORGANIZATION_ID is null");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdIsNotNull() {
			addCriterion("AFTER_ORGANIZATION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdEqualTo(Integer value) {
			addCriterion("AFTER_ORGANIZATION_ID =", value,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdNotEqualTo(Integer value) {
			addCriterion("AFTER_ORGANIZATION_ID <>", value,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdGreaterThan(Integer value) {
			addCriterion("AFTER_ORGANIZATION_ID >", value,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AFTER_ORGANIZATION_ID >=", value,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdLessThan(Integer value) {
			addCriterion("AFTER_ORGANIZATION_ID <", value,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdLessThanOrEqualTo(Integer value) {
			addCriterion("AFTER_ORGANIZATION_ID <=", value,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdIn(List<Integer> values) {
			addCriterion("AFTER_ORGANIZATION_ID in", values,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdNotIn(List<Integer> values) {
			addCriterion("AFTER_ORGANIZATION_ID not in", values,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdBetween(Integer value1,
				Integer value2) {
			addCriterion("AFTER_ORGANIZATION_ID between", value1, value2,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andAfterOrganizationIdNotBetween(Integer value1,
				Integer value2) {
			addCriterion("AFTER_ORGANIZATION_ID not between", value1, value2,
					"afterOrganizationId");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameIsNull() {
			addCriterion("CREATE_USERNAME is null");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameIsNotNull() {
			addCriterion("CREATE_USERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameEqualTo(String value) {
			addCriterion("CREATE_USERNAME =", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameNotEqualTo(String value) {
			addCriterion("CREATE_USERNAME <>", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameGreaterThan(String value) {
			addCriterion("CREATE_USERNAME >", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_USERNAME >=", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameLessThan(String value) {
			addCriterion("CREATE_USERNAME <", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameLessThanOrEqualTo(String value) {
			addCriterion("CREATE_USERNAME <=", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameLike(String value) {
			addCriterion("CREATE_USERNAME like", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameNotLike(String value) {
			addCriterion("CREATE_USERNAME not like", value, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameIn(List<String> values) {
			addCriterion("CREATE_USERNAME in", values, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameNotIn(List<String> values) {
			addCriterion("CREATE_USERNAME not in", values, "createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameBetween(String value1, String value2) {
			addCriterion("CREATE_USERNAME between", value1, value2,
					"createUsername");
			return (Criteria) this;
		}

		public Criteria andCreateUsernameNotBetween(String value1, String value2) {
			addCriterion("CREATE_USERNAME not between", value1, value2,
					"createUsername");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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