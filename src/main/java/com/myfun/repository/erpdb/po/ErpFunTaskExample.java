package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunTaskExample extends ShardDb {
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
	public ErpFunTaskExample() {
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

		public Criteria andTaskIdIsNull() {
			addCriterion("TASK_ID is null");
			return (Criteria) this;
		}

		public Criteria andTaskIdIsNotNull() {
			addCriterion("TASK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTaskIdEqualTo(Integer value) {
			addCriterion("TASK_ID =", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotEqualTo(Integer value) {
			addCriterion("TASK_ID <>", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdGreaterThan(Integer value) {
			addCriterion("TASK_ID >", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TASK_ID >=", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdLessThan(Integer value) {
			addCriterion("TASK_ID <", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
			addCriterion("TASK_ID <=", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdIn(List<Integer> values) {
			addCriterion("TASK_ID in", values, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotIn(List<Integer> values) {
			addCriterion("TASK_ID not in", values, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdBetween(Integer value1, Integer value2) {
			addCriterion("TASK_ID between", value1, value2, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TASK_ID not between", value1, value2, "taskId");
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

		public Criteria andTrackTypeIsNull() {
			addCriterion("TRACK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTrackTypeIsNotNull() {
			addCriterion("TRACK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTrackTypeEqualTo(Byte value) {
			addCriterion("TRACK_TYPE =", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeNotEqualTo(Byte value) {
			addCriterion("TRACK_TYPE <>", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeGreaterThan(Byte value) {
			addCriterion("TRACK_TYPE >", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRACK_TYPE >=", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeLessThan(Byte value) {
			addCriterion("TRACK_TYPE <", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TRACK_TYPE <=", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeIn(List<Byte> values) {
			addCriterion("TRACK_TYPE in", values, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeNotIn(List<Byte> values) {
			addCriterion("TRACK_TYPE not in", values, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeBetween(Byte value1, Byte value2) {
			addCriterion("TRACK_TYPE between", value1, value2, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TRACK_TYPE not between", value1, value2, "trackType");
			return (Criteria) this;
		}

		public Criteria andUseageIsNull() {
			addCriterion("USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andUseageIsNotNull() {
			addCriterion("USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andUseageEqualTo(Byte value) {
			addCriterion("USEAGE =", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageNotEqualTo(Byte value) {
			addCriterion("USEAGE <>", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageGreaterThan(Byte value) {
			addCriterion("USEAGE >", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageGreaterThanOrEqualTo(Byte value) {
			addCriterion("USEAGE >=", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageLessThan(Byte value) {
			addCriterion("USEAGE <", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageLessThanOrEqualTo(Byte value) {
			addCriterion("USEAGE <=", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageIn(List<Byte> values) {
			addCriterion("USEAGE in", values, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageNotIn(List<Byte> values) {
			addCriterion("USEAGE not in", values, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageBetween(Byte value1, Byte value2) {
			addCriterion("USEAGE between", value1, value2, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageNotBetween(Byte value1, Byte value2) {
			addCriterion("USEAGE not between", value1, value2, "useage");
			return (Criteria) this;
		}

		public Criteria andKeyIdIsNull() {
			addCriterion("KEY_ID is null");
			return (Criteria) this;
		}

		public Criteria andKeyIdIsNotNull() {
			addCriterion("KEY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andKeyIdEqualTo(Integer value) {
			addCriterion("KEY_ID =", value, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdNotEqualTo(Integer value) {
			addCriterion("KEY_ID <>", value, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdGreaterThan(Integer value) {
			addCriterion("KEY_ID >", value, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("KEY_ID >=", value, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdLessThan(Integer value) {
			addCriterion("KEY_ID <", value, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdLessThanOrEqualTo(Integer value) {
			addCriterion("KEY_ID <=", value, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdIn(List<Integer> values) {
			addCriterion("KEY_ID in", values, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdNotIn(List<Integer> values) {
			addCriterion("KEY_ID not in", values, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdBetween(Integer value1, Integer value2) {
			addCriterion("KEY_ID between", value1, value2, "keyId");
			return (Criteria) this;
		}

		public Criteria andKeyIdNotBetween(Integer value1, Integer value2) {
			addCriterion("KEY_ID not between", value1, value2, "keyId");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerIsNull() {
			addCriterion("TASK_OWNER is null");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerIsNotNull() {
			addCriterion("TASK_OWNER is not null");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerEqualTo(Integer value) {
			addCriterion("TASK_OWNER =", value, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerNotEqualTo(Integer value) {
			addCriterion("TASK_OWNER <>", value, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerGreaterThan(Integer value) {
			addCriterion("TASK_OWNER >", value, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerGreaterThanOrEqualTo(Integer value) {
			addCriterion("TASK_OWNER >=", value, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerLessThan(Integer value) {
			addCriterion("TASK_OWNER <", value, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerLessThanOrEqualTo(Integer value) {
			addCriterion("TASK_OWNER <=", value, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerIn(List<Integer> values) {
			addCriterion("TASK_OWNER in", values, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerNotIn(List<Integer> values) {
			addCriterion("TASK_OWNER not in", values, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerBetween(Integer value1, Integer value2) {
			addCriterion("TASK_OWNER between", value1, value2, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskOwnerNotBetween(Integer value1, Integer value2) {
			addCriterion("TASK_OWNER not between", value1, value2, "taskOwner");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectIsNull() {
			addCriterion("TASK_SUBJECT is null");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectIsNotNull() {
			addCriterion("TASK_SUBJECT is not null");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectEqualTo(String value) {
			addCriterion("TASK_SUBJECT =", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectNotEqualTo(String value) {
			addCriterion("TASK_SUBJECT <>", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectGreaterThan(String value) {
			addCriterion("TASK_SUBJECT >", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectGreaterThanOrEqualTo(String value) {
			addCriterion("TASK_SUBJECT >=", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectLessThan(String value) {
			addCriterion("TASK_SUBJECT <", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectLessThanOrEqualTo(String value) {
			addCriterion("TASK_SUBJECT <=", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectLike(String value) {
			addCriterion("TASK_SUBJECT like", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectNotLike(String value) {
			addCriterion("TASK_SUBJECT not like", value, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectIn(List<String> values) {
			addCriterion("TASK_SUBJECT in", values, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectNotIn(List<String> values) {
			addCriterion("TASK_SUBJECT not in", values, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectBetween(String value1, String value2) {
			addCriterion("TASK_SUBJECT between", value1, value2, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskSubjectNotBetween(String value1, String value2) {
			addCriterion("TASK_SUBJECT not between", value1, value2, "taskSubject");
			return (Criteria) this;
		}

		public Criteria andTaskDescIsNull() {
			addCriterion("TASK_DESC is null");
			return (Criteria) this;
		}

		public Criteria andTaskDescIsNotNull() {
			addCriterion("TASK_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andTaskDescEqualTo(String value) {
			addCriterion("TASK_DESC =", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescNotEqualTo(String value) {
			addCriterion("TASK_DESC <>", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescGreaterThan(String value) {
			addCriterion("TASK_DESC >", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescGreaterThanOrEqualTo(String value) {
			addCriterion("TASK_DESC >=", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescLessThan(String value) {
			addCriterion("TASK_DESC <", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescLessThanOrEqualTo(String value) {
			addCriterion("TASK_DESC <=", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescLike(String value) {
			addCriterion("TASK_DESC like", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescNotLike(String value) {
			addCriterion("TASK_DESC not like", value, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescIn(List<String> values) {
			addCriterion("TASK_DESC in", values, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescNotIn(List<String> values) {
			addCriterion("TASK_DESC not in", values, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescBetween(String value1, String value2) {
			addCriterion("TASK_DESC between", value1, value2, "taskDesc");
			return (Criteria) this;
		}

		public Criteria andTaskDescNotBetween(String value1, String value2) {
			addCriterion("TASK_DESC not between", value1, value2, "taskDesc");
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

		public Criteria andTrackWarmEqualTo(Boolean value) {
			addCriterion("TRACK_WARM =", value, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmNotEqualTo(Boolean value) {
			addCriterion("TRACK_WARM <>", value, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmGreaterThan(Boolean value) {
			addCriterion("TRACK_WARM >", value, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmGreaterThanOrEqualTo(Boolean value) {
			addCriterion("TRACK_WARM >=", value, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmLessThan(Boolean value) {
			addCriterion("TRACK_WARM <", value, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmLessThanOrEqualTo(Boolean value) {
			addCriterion("TRACK_WARM <=", value, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmIn(List<Boolean> values) {
			addCriterion("TRACK_WARM in", values, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmNotIn(List<Boolean> values) {
			addCriterion("TRACK_WARM not in", values, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmBetween(Boolean value1, Boolean value2) {
			addCriterion("TRACK_WARM between", value1, value2, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTrackWarmNotBetween(Boolean value1, Boolean value2) {
			addCriterion("TRACK_WARM not between", value1, value2, "trackWarm");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIsNull() {
			addCriterion("TASK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIsNotNull() {
			addCriterion("TASK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTaskTypeEqualTo(Byte value) {
			addCriterion("TASK_TYPE =", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotEqualTo(Byte value) {
			addCriterion("TASK_TYPE <>", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeGreaterThan(Byte value) {
			addCriterion("TASK_TYPE >", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TASK_TYPE >=", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeLessThan(Byte value) {
			addCriterion("TASK_TYPE <", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TASK_TYPE <=", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIn(List<Byte> values) {
			addCriterion("TASK_TYPE in", values, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotIn(List<Byte> values) {
			addCriterion("TASK_TYPE not in", values, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeBetween(Byte value1, Byte value2) {
			addCriterion("TASK_TYPE between", value1, value2, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TASK_TYPE not between", value1, value2, "taskType");
			return (Criteria) this;
		}

		public Criteria andTypeFlagIsNull() {
			addCriterion("TYPE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andTypeFlagIsNotNull() {
			addCriterion("TYPE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andTypeFlagEqualTo(Byte value) {
			addCriterion("TYPE_FLAG =", value, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagNotEqualTo(Byte value) {
			addCriterion("TYPE_FLAG <>", value, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagGreaterThan(Byte value) {
			addCriterion("TYPE_FLAG >", value, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("TYPE_FLAG >=", value, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagLessThan(Byte value) {
			addCriterion("TYPE_FLAG <", value, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagLessThanOrEqualTo(Byte value) {
			addCriterion("TYPE_FLAG <=", value, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagIn(List<Byte> values) {
			addCriterion("TYPE_FLAG in", values, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagNotIn(List<Byte> values) {
			addCriterion("TYPE_FLAG not in", values, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagBetween(Byte value1, Byte value2) {
			addCriterion("TYPE_FLAG between", value1, value2, "typeFlag");
			return (Criteria) this;
		}

		public Criteria andTypeFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("TYPE_FLAG not between", value1, value2, "typeFlag");
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

		public Criteria andWarmTimeEqualTo(String value) {
			addCriterion("WARM_TIME =", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeNotEqualTo(String value) {
			addCriterion("WARM_TIME <>", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeGreaterThan(String value) {
			addCriterion("WARM_TIME >", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeGreaterThanOrEqualTo(String value) {
			addCriterion("WARM_TIME >=", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeLessThan(String value) {
			addCriterion("WARM_TIME <", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeLessThanOrEqualTo(String value) {
			addCriterion("WARM_TIME <=", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeLike(String value) {
			addCriterion("WARM_TIME like", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeNotLike(String value) {
			addCriterion("WARM_TIME not like", value, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeIn(List<String> values) {
			addCriterion("WARM_TIME in", values, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeNotIn(List<String> values) {
			addCriterion("WARM_TIME not in", values, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeBetween(String value1, String value2) {
			addCriterion("WARM_TIME between", value1, value2, "warmTime");
			return (Criteria) this;
		}

		public Criteria andWarmTimeNotBetween(String value1, String value2) {
			addCriterion("WARM_TIME not between", value1, value2, "warmTime");
			return (Criteria) this;
		}

		public Criteria andIsReadIsNull() {
			addCriterion("IS_READ is null");
			return (Criteria) this;
		}

		public Criteria andIsReadIsNotNull() {
			addCriterion("IS_READ is not null");
			return (Criteria) this;
		}

		public Criteria andIsReadEqualTo(Boolean value) {
			addCriterion("IS_READ =", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotEqualTo(Boolean value) {
			addCriterion("IS_READ <>", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThan(Boolean value) {
			addCriterion("IS_READ >", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_READ >=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThan(Boolean value) {
			addCriterion("IS_READ <", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_READ <=", value, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadIn(List<Boolean> values) {
			addCriterion("IS_READ in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotIn(List<Boolean> values) {
			addCriterion("IS_READ not in", values, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_READ between", value1, value2, "isRead");
			return (Criteria) this;
		}

		public Criteria andIsReadNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_READ not between", value1, value2, "isRead");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIsNull() {
			addCriterion("TASK_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIsNotNull() {
			addCriterion("TASK_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andTaskStatusEqualTo(Byte value) {
			addCriterion("TASK_STATUS =", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotEqualTo(Byte value) {
			addCriterion("TASK_STATUS <>", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusGreaterThan(Byte value) {
			addCriterion("TASK_STATUS >", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("TASK_STATUS >=", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusLessThan(Byte value) {
			addCriterion("TASK_STATUS <", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusLessThanOrEqualTo(Byte value) {
			addCriterion("TASK_STATUS <=", value, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusIn(List<Byte> values) {
			addCriterion("TASK_STATUS in", values, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotIn(List<Byte> values) {
			addCriterion("TASK_STATUS not in", values, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusBetween(Byte value1, Byte value2) {
			addCriterion("TASK_STATUS between", value1, value2, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("TASK_STATUS not between", value1, value2, "taskStatus");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteIsNull() {
			addCriterion("TASK_SOLUTE is null");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteIsNotNull() {
			addCriterion("TASK_SOLUTE is not null");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteEqualTo(String value) {
			addCriterion("TASK_SOLUTE =", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteNotEqualTo(String value) {
			addCriterion("TASK_SOLUTE <>", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteGreaterThan(String value) {
			addCriterion("TASK_SOLUTE >", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteGreaterThanOrEqualTo(String value) {
			addCriterion("TASK_SOLUTE >=", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteLessThan(String value) {
			addCriterion("TASK_SOLUTE <", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteLessThanOrEqualTo(String value) {
			addCriterion("TASK_SOLUTE <=", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteLike(String value) {
			addCriterion("TASK_SOLUTE like", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteNotLike(String value) {
			addCriterion("TASK_SOLUTE not like", value, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteIn(List<String> values) {
			addCriterion("TASK_SOLUTE in", values, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteNotIn(List<String> values) {
			addCriterion("TASK_SOLUTE not in", values, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteBetween(String value1, String value2) {
			addCriterion("TASK_SOLUTE between", value1, value2, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskSoluteNotBetween(String value1, String value2) {
			addCriterion("TASK_SOLUTE not between", value1, value2, "taskSolute");
			return (Criteria) this;
		}

		public Criteria andTaskResultIsNull() {
			addCriterion("TASK_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andTaskResultIsNotNull() {
			addCriterion("TASK_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andTaskResultEqualTo(Byte value) {
			addCriterion("TASK_RESULT =", value, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultNotEqualTo(Byte value) {
			addCriterion("TASK_RESULT <>", value, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultGreaterThan(Byte value) {
			addCriterion("TASK_RESULT >", value, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultGreaterThanOrEqualTo(Byte value) {
			addCriterion("TASK_RESULT >=", value, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultLessThan(Byte value) {
			addCriterion("TASK_RESULT <", value, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultLessThanOrEqualTo(Byte value) {
			addCriterion("TASK_RESULT <=", value, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultIn(List<Byte> values) {
			addCriterion("TASK_RESULT in", values, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultNotIn(List<Byte> values) {
			addCriterion("TASK_RESULT not in", values, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultBetween(Byte value1, Byte value2) {
			addCriterion("TASK_RESULT between", value1, value2, "taskResult");
			return (Criteria) this;
		}

		public Criteria andTaskResultNotBetween(Byte value1, Byte value2) {
			addCriterion("TASK_RESULT not between", value1, value2, "taskResult");
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

		public Criteria andCreationTimeEqualTo(String value) {
			addCriterion("CREATION_TIME =", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotEqualTo(String value) {
			addCriterion("CREATION_TIME <>", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeGreaterThan(String value) {
			addCriterion("CREATION_TIME >", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeGreaterThanOrEqualTo(String value) {
			addCriterion("CREATION_TIME >=", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeLessThan(String value) {
			addCriterion("CREATION_TIME <", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeLessThanOrEqualTo(String value) {
			addCriterion("CREATION_TIME <=", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeLike(String value) {
			addCriterion("CREATION_TIME like", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotLike(String value) {
			addCriterion("CREATION_TIME not like", value, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeIn(List<String> values) {
			addCriterion("CREATION_TIME in", values, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotIn(List<String> values) {
			addCriterion("CREATION_TIME not in", values, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeBetween(String value1, String value2) {
			addCriterion("CREATION_TIME between", value1, value2, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCreationTimeNotBetween(String value1, String value2) {
			addCriterion("CREATION_TIME not between", value1, value2, "creationTime");
			return (Criteria) this;
		}

		public Criteria andCcIdIsNull() {
			addCriterion("CC_ID is null");
			return (Criteria) this;
		}

		public Criteria andCcIdIsNotNull() {
			addCriterion("CC_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCcIdEqualTo(Integer value) {
			addCriterion("CC_ID =", value, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdNotEqualTo(Integer value) {
			addCriterion("CC_ID <>", value, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdGreaterThan(Integer value) {
			addCriterion("CC_ID >", value, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CC_ID >=", value, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdLessThan(Integer value) {
			addCriterion("CC_ID <", value, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdLessThanOrEqualTo(Integer value) {
			addCriterion("CC_ID <=", value, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdIn(List<Integer> values) {
			addCriterion("CC_ID in", values, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdNotIn(List<Integer> values) {
			addCriterion("CC_ID not in", values, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdBetween(Integer value1, Integer value2) {
			addCriterion("CC_ID between", value1, value2, "ccId");
			return (Criteria) this;
		}

		public Criteria andCcIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CC_ID not between", value1, value2, "ccId");
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

		public Criteria andUpdateUidIsNull() {
			addCriterion("UPDATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIsNotNull() {
			addCriterion("UPDATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidEqualTo(Integer value) {
			addCriterion("UPDATE_UID =", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotEqualTo(Integer value) {
			addCriterion("UPDATE_UID <>", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThan(Integer value) {
			addCriterion("UPDATE_UID >", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID >=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThan(Integer value) {
			addCriterion("UPDATE_UID <", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID <=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIn(List<Integer> values) {
			addCriterion("UPDATE_UID in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotIn(List<Integer> values) {
			addCriterion("UPDATE_UID not in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID between", value1, value2, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID not between", value1, value2, "updateUid");
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

		public Criteria andTagIsNull() {
			addCriterion("TAG is null");
			return (Criteria) this;
		}

		public Criteria andTagIsNotNull() {
			addCriterion("TAG is not null");
			return (Criteria) this;
		}

		public Criteria andTagEqualTo(String value) {
			addCriterion("TAG =", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagNotEqualTo(String value) {
			addCriterion("TAG <>", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagGreaterThan(String value) {
			addCriterion("TAG >", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagGreaterThanOrEqualTo(String value) {
			addCriterion("TAG >=", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagLessThan(String value) {
			addCriterion("TAG <", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagLessThanOrEqualTo(String value) {
			addCriterion("TAG <=", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagLike(String value) {
			addCriterion("TAG like", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagNotLike(String value) {
			addCriterion("TAG not like", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagIn(List<String> values) {
			addCriterion("TAG in", values, "tag");
			return (Criteria) this;
		}

		public Criteria andTagNotIn(List<String> values) {
			addCriterion("TAG not in", values, "tag");
			return (Criteria) this;
		}

		public Criteria andTagBetween(String value1, String value2) {
			addCriterion("TAG between", value1, value2, "tag");
			return (Criteria) this;
		}

		public Criteria andTagNotBetween(String value1, String value2) {
			addCriterion("TAG not between", value1, value2, "tag");
			return (Criteria) this;
		}

		public Criteria andIndexShowIsNull() {
			addCriterion("INDEX_SHOW is null");
			return (Criteria) this;
		}

		public Criteria andIndexShowIsNotNull() {
			addCriterion("INDEX_SHOW is not null");
			return (Criteria) this;
		}

		public Criteria andIndexShowEqualTo(Integer value) {
			addCriterion("INDEX_SHOW =", value, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowNotEqualTo(Integer value) {
			addCriterion("INDEX_SHOW <>", value, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowGreaterThan(Integer value) {
			addCriterion("INDEX_SHOW >", value, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowGreaterThanOrEqualTo(Integer value) {
			addCriterion("INDEX_SHOW >=", value, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowLessThan(Integer value) {
			addCriterion("INDEX_SHOW <", value, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowLessThanOrEqualTo(Integer value) {
			addCriterion("INDEX_SHOW <=", value, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowIn(List<Integer> values) {
			addCriterion("INDEX_SHOW in", values, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowNotIn(List<Integer> values) {
			addCriterion("INDEX_SHOW not in", values, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowBetween(Integer value1, Integer value2) {
			addCriterion("INDEX_SHOW between", value1, value2, "indexShow");
			return (Criteria) this;
		}

		public Criteria andIndexShowNotBetween(Integer value1, Integer value2) {
			addCriterion("INDEX_SHOW not between", value1, value2, "indexShow");
			return (Criteria) this;
		}

		public Criteria andAutoAduitIsNull() {
			addCriterion("AUTO_ADUIT is null");
			return (Criteria) this;
		}

		public Criteria andAutoAduitIsNotNull() {
			addCriterion("AUTO_ADUIT is not null");
			return (Criteria) this;
		}

		public Criteria andAutoAduitEqualTo(Byte value) {
			addCriterion("AUTO_ADUIT =", value, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitNotEqualTo(Byte value) {
			addCriterion("AUTO_ADUIT <>", value, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitGreaterThan(Byte value) {
			addCriterion("AUTO_ADUIT >", value, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUTO_ADUIT >=", value, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitLessThan(Byte value) {
			addCriterion("AUTO_ADUIT <", value, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitLessThanOrEqualTo(Byte value) {
			addCriterion("AUTO_ADUIT <=", value, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitIn(List<Byte> values) {
			addCriterion("AUTO_ADUIT in", values, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitNotIn(List<Byte> values) {
			addCriterion("AUTO_ADUIT not in", values, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitBetween(Byte value1, Byte value2) {
			addCriterion("AUTO_ADUIT between", value1, value2, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andAutoAduitNotBetween(Byte value1, Byte value2) {
			addCriterion("AUTO_ADUIT not between", value1, value2, "autoAduit");
			return (Criteria) this;
		}

		public Criteria andExamineSourceIsNull() {
			addCriterion("EXAMINE_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andExamineSourceIsNotNull() {
			addCriterion("EXAMINE_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andExamineSourceEqualTo(Byte value) {
			addCriterion("EXAMINE_SOURCE =", value, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceNotEqualTo(Byte value) {
			addCriterion("EXAMINE_SOURCE <>", value, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceGreaterThan(Byte value) {
			addCriterion("EXAMINE_SOURCE >", value, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("EXAMINE_SOURCE >=", value, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceLessThan(Byte value) {
			addCriterion("EXAMINE_SOURCE <", value, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceLessThanOrEqualTo(Byte value) {
			addCriterion("EXAMINE_SOURCE <=", value, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceIn(List<Byte> values) {
			addCriterion("EXAMINE_SOURCE in", values, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceNotIn(List<Byte> values) {
			addCriterion("EXAMINE_SOURCE not in", values, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceBetween(Byte value1, Byte value2) {
			addCriterion("EXAMINE_SOURCE between", value1, value2, "examineSource");
			return (Criteria) this;
		}

		public Criteria andExamineSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("EXAMINE_SOURCE not between", value1, value2, "examineSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceIsNull() {
			addCriterion("TASK_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andTaskSourceIsNotNull() {
			addCriterion("TASK_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andTaskSourceEqualTo(Byte value) {
			addCriterion("TASK_SOURCE =", value, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceNotEqualTo(Byte value) {
			addCriterion("TASK_SOURCE <>", value, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceGreaterThan(Byte value) {
			addCriterion("TASK_SOURCE >", value, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("TASK_SOURCE >=", value, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceLessThan(Byte value) {
			addCriterion("TASK_SOURCE <", value, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceLessThanOrEqualTo(Byte value) {
			addCriterion("TASK_SOURCE <=", value, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceIn(List<Byte> values) {
			addCriterion("TASK_SOURCE in", values, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceNotIn(List<Byte> values) {
			addCriterion("TASK_SOURCE not in", values, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceBetween(Byte value1, Byte value2) {
			addCriterion("TASK_SOURCE between", value1, value2, "taskSource");
			return (Criteria) this;
		}

		public Criteria andTaskSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("TASK_SOURCE not between", value1, value2, "taskSource");
			return (Criteria) this;
		}

		public Criteria andIsSendIsNull() {
			addCriterion("IS_SEND is null");
			return (Criteria) this;
		}

		public Criteria andIsSendIsNotNull() {
			addCriterion("IS_SEND is not null");
			return (Criteria) this;
		}

		public Criteria andIsSendEqualTo(Byte value) {
			addCriterion("IS_SEND =", value, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendNotEqualTo(Byte value) {
			addCriterion("IS_SEND <>", value, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendGreaterThan(Byte value) {
			addCriterion("IS_SEND >", value, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SEND >=", value, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendLessThan(Byte value) {
			addCriterion("IS_SEND <", value, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SEND <=", value, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendIn(List<Byte> values) {
			addCriterion("IS_SEND in", values, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendNotIn(List<Byte> values) {
			addCriterion("IS_SEND not in", values, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendBetween(Byte value1, Byte value2) {
			addCriterion("IS_SEND between", value1, value2, "isSend");
			return (Criteria) this;
		}

		public Criteria andIsSendNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SEND not between", value1, value2, "isSend");
			return (Criteria) this;
		}

		public Criteria andWarmUsersIsNull() {
			addCriterion("WARM_USERS is null");
			return (Criteria) this;
		}

		public Criteria andWarmUsersIsNotNull() {
			addCriterion("WARM_USERS is not null");
			return (Criteria) this;
		}

		public Criteria andWarmUsersEqualTo(String value) {
			addCriterion("WARM_USERS =", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersNotEqualTo(String value) {
			addCriterion("WARM_USERS <>", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersGreaterThan(String value) {
			addCriterion("WARM_USERS >", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersGreaterThanOrEqualTo(String value) {
			addCriterion("WARM_USERS >=", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersLessThan(String value) {
			addCriterion("WARM_USERS <", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersLessThanOrEqualTo(String value) {
			addCriterion("WARM_USERS <=", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersLike(String value) {
			addCriterion("WARM_USERS like", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersNotLike(String value) {
			addCriterion("WARM_USERS not like", value, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersIn(List<String> values) {
			addCriterion("WARM_USERS in", values, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersNotIn(List<String> values) {
			addCriterion("WARM_USERS not in", values, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersBetween(String value1, String value2) {
			addCriterion("WARM_USERS between", value1, value2, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andWarmUsersNotBetween(String value1, String value2) {
			addCriterion("WARM_USERS not between", value1, value2, "warmUsers");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagIsNull() {
			addCriterion("NEW_TYPE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagIsNotNull() {
			addCriterion("NEW_TYPE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagEqualTo(Byte value) {
			addCriterion("NEW_TYPE_FLAG =", value, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagNotEqualTo(Byte value) {
			addCriterion("NEW_TYPE_FLAG <>", value, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagGreaterThan(Byte value) {
			addCriterion("NEW_TYPE_FLAG >", value, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("NEW_TYPE_FLAG >=", value, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagLessThan(Byte value) {
			addCriterion("NEW_TYPE_FLAG <", value, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagLessThanOrEqualTo(Byte value) {
			addCriterion("NEW_TYPE_FLAG <=", value, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagIn(List<Byte> values) {
			addCriterion("NEW_TYPE_FLAG in", values, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagNotIn(List<Byte> values) {
			addCriterion("NEW_TYPE_FLAG not in", values, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagBetween(Byte value1, Byte value2) {
			addCriterion("NEW_TYPE_FLAG between", value1, value2, "newTypeFlag");
			return (Criteria) this;
		}

		public Criteria andNewTypeFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("NEW_TYPE_FLAG not between", value1, value2, "newTypeFlag");
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