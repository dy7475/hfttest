package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminAliRenthousePunishmentExample {
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
	public AdminAliRenthousePunishmentExample() {
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

		public Criteria andFlatNumIsNull() {
			addCriterion("FLAT_NUM is null");
			return (Criteria) this;
		}

		public Criteria andFlatNumIsNotNull() {
			addCriterion("FLAT_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andFlatNumEqualTo(String value) {
			addCriterion("FLAT_NUM =", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumNotEqualTo(String value) {
			addCriterion("FLAT_NUM <>", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumGreaterThan(String value) {
			addCriterion("FLAT_NUM >", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumGreaterThanOrEqualTo(String value) {
			addCriterion("FLAT_NUM >=", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumLessThan(String value) {
			addCriterion("FLAT_NUM <", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumLessThanOrEqualTo(String value) {
			addCriterion("FLAT_NUM <=", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumLike(String value) {
			addCriterion("FLAT_NUM like", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumNotLike(String value) {
			addCriterion("FLAT_NUM not like", value, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumIn(List<String> values) {
			addCriterion("FLAT_NUM in", values, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumNotIn(List<String> values) {
			addCriterion("FLAT_NUM not in", values, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumBetween(String value1, String value2) {
			addCriterion("FLAT_NUM between", value1, value2, "flatNum");
			return (Criteria) this;
		}

		public Criteria andFlatNumNotBetween(String value1, String value2) {
			addCriterion("FLAT_NUM not between", value1, value2, "flatNum");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusIsNull() {
			addCriterion("PUNISHMENT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusIsNotNull() {
			addCriterion("PUNISHMENT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusEqualTo(Integer value) {
			addCriterion("PUNISHMENT_STATUS =", value, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusNotEqualTo(Integer value) {
			addCriterion("PUNISHMENT_STATUS <>", value, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusGreaterThan(Integer value) {
			addCriterion("PUNISHMENT_STATUS >", value, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("PUNISHMENT_STATUS >=", value, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusLessThan(Integer value) {
			addCriterion("PUNISHMENT_STATUS <", value, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusLessThanOrEqualTo(Integer value) {
			addCriterion("PUNISHMENT_STATUS <=", value, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusIn(List<Integer> values) {
			addCriterion("PUNISHMENT_STATUS in", values, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusNotIn(List<Integer> values) {
			addCriterion("PUNISHMENT_STATUS not in", values, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusBetween(Integer value1, Integer value2) {
			addCriterion("PUNISHMENT_STATUS between", value1, value2, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andPunishmentStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("PUNISHMENT_STATUS not between", value1, value2, "punishmentStatus");
			return (Criteria) this;
		}

		public Criteria andRoomCodeIsNull() {
			addCriterion("ROOM_CODE is null");
			return (Criteria) this;
		}

		public Criteria andRoomCodeIsNotNull() {
			addCriterion("ROOM_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andRoomCodeEqualTo(String value) {
			addCriterion("ROOM_CODE =", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeNotEqualTo(String value) {
			addCriterion("ROOM_CODE <>", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeGreaterThan(String value) {
			addCriterion("ROOM_CODE >", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ROOM_CODE >=", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeLessThan(String value) {
			addCriterion("ROOM_CODE <", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeLessThanOrEqualTo(String value) {
			addCriterion("ROOM_CODE <=", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeLike(String value) {
			addCriterion("ROOM_CODE like", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeNotLike(String value) {
			addCriterion("ROOM_CODE not like", value, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeIn(List<String> values) {
			addCriterion("ROOM_CODE in", values, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeNotIn(List<String> values) {
			addCriterion("ROOM_CODE not in", values, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeBetween(String value1, String value2) {
			addCriterion("ROOM_CODE between", value1, value2, "roomCode");
			return (Criteria) this;
		}

		public Criteria andRoomCodeNotBetween(String value1, String value2) {
			addCriterion("ROOM_CODE not between", value1, value2, "roomCode");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonIsNull() {
			addCriterion("PUNISHMENT_REASON is null");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonIsNotNull() {
			addCriterion("PUNISHMENT_REASON is not null");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonEqualTo(String value) {
			addCriterion("PUNISHMENT_REASON =", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonNotEqualTo(String value) {
			addCriterion("PUNISHMENT_REASON <>", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonGreaterThan(String value) {
			addCriterion("PUNISHMENT_REASON >", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonGreaterThanOrEqualTo(String value) {
			addCriterion("PUNISHMENT_REASON >=", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonLessThan(String value) {
			addCriterion("PUNISHMENT_REASON <", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonLessThanOrEqualTo(String value) {
			addCriterion("PUNISHMENT_REASON <=", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonLike(String value) {
			addCriterion("PUNISHMENT_REASON like", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonNotLike(String value) {
			addCriterion("PUNISHMENT_REASON not like", value, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonIn(List<String> values) {
			addCriterion("PUNISHMENT_REASON in", values, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonNotIn(List<String> values) {
			addCriterion("PUNISHMENT_REASON not in", values, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonBetween(String value1, String value2) {
			addCriterion("PUNISHMENT_REASON between", value1, value2, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentReasonNotBetween(String value1, String value2) {
			addCriterion("PUNISHMENT_REASON not between", value1, value2, "punishmentReason");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysIsNull() {
			addCriterion("PUNISHMENT_DAYS is null");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysIsNotNull() {
			addCriterion("PUNISHMENT_DAYS is not null");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysEqualTo(Integer value) {
			addCriterion("PUNISHMENT_DAYS =", value, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysNotEqualTo(Integer value) {
			addCriterion("PUNISHMENT_DAYS <>", value, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysGreaterThan(Integer value) {
			addCriterion("PUNISHMENT_DAYS >", value, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysGreaterThanOrEqualTo(Integer value) {
			addCriterion("PUNISHMENT_DAYS >=", value, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysLessThan(Integer value) {
			addCriterion("PUNISHMENT_DAYS <", value, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysLessThanOrEqualTo(Integer value) {
			addCriterion("PUNISHMENT_DAYS <=", value, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysIn(List<Integer> values) {
			addCriterion("PUNISHMENT_DAYS in", values, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysNotIn(List<Integer> values) {
			addCriterion("PUNISHMENT_DAYS not in", values, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysBetween(Integer value1, Integer value2) {
			addCriterion("PUNISHMENT_DAYS between", value1, value2, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andPunishmentDaysNotBetween(Integer value1, Integer value2) {
			addCriterion("PUNISHMENT_DAYS not between", value1, value2, "punishmentDays");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("REMARK is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("REMARK =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("REMARK <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("REMARK >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("REMARK >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("REMARK <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("REMARK <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("REMARK like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("REMARK not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("REMARK in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("REMARK not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("REMARK between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("REMARK not between", value1, value2, "remark");
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

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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