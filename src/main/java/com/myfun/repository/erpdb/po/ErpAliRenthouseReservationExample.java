package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAliRenthouseReservationExample extends ShardDb {
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
	public ErpAliRenthouseReservationExample() {
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

		public Criteria andAliUserIdIsNull() {
			addCriterion("ALI_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andAliUserIdIsNotNull() {
			addCriterion("ALI_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAliUserIdEqualTo(String value) {
			addCriterion("ALI_USER_ID =", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdNotEqualTo(String value) {
			addCriterion("ALI_USER_ID <>", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdGreaterThan(String value) {
			addCriterion("ALI_USER_ID >", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("ALI_USER_ID >=", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdLessThan(String value) {
			addCriterion("ALI_USER_ID <", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdLessThanOrEqualTo(String value) {
			addCriterion("ALI_USER_ID <=", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdLike(String value) {
			addCriterion("ALI_USER_ID like", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdNotLike(String value) {
			addCriterion("ALI_USER_ID not like", value, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdIn(List<String> values) {
			addCriterion("ALI_USER_ID in", values, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdNotIn(List<String> values) {
			addCriterion("ALI_USER_ID not in", values, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdBetween(String value1, String value2) {
			addCriterion("ALI_USER_ID between", value1, value2, "aliUserId");
			return (Criteria) this;
		}

		public Criteria andAliUserIdNotBetween(String value1, String value2) {
			addCriterion("ALI_USER_ID not between", value1, value2, "aliUserId");
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

		public Criteria andFlatsTagIsNull() {
			addCriterion("FLATS_TAG is null");
			return (Criteria) this;
		}

		public Criteria andFlatsTagIsNotNull() {
			addCriterion("FLATS_TAG is not null");
			return (Criteria) this;
		}

		public Criteria andFlatsTagEqualTo(Integer value) {
			addCriterion("FLATS_TAG =", value, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagNotEqualTo(Integer value) {
			addCriterion("FLATS_TAG <>", value, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagGreaterThan(Integer value) {
			addCriterion("FLATS_TAG >", value, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagGreaterThanOrEqualTo(Integer value) {
			addCriterion("FLATS_TAG >=", value, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagLessThan(Integer value) {
			addCriterion("FLATS_TAG <", value, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagLessThanOrEqualTo(Integer value) {
			addCriterion("FLATS_TAG <=", value, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagIn(List<Integer> values) {
			addCriterion("FLATS_TAG in", values, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagNotIn(List<Integer> values) {
			addCriterion("FLATS_TAG not in", values, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagBetween(Integer value1, Integer value2) {
			addCriterion("FLATS_TAG between", value1, value2, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andFlatsTagNotBetween(Integer value1, Integer value2) {
			addCriterion("FLATS_TAG not between", value1, value2, "flatsTag");
			return (Criteria) this;
		}

		public Criteria andLookTimeIsNull() {
			addCriterion("LOOK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLookTimeIsNotNull() {
			addCriterion("LOOK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLookTimeEqualTo(Date value) {
			addCriterion("LOOK_TIME =", value, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeNotEqualTo(Date value) {
			addCriterion("LOOK_TIME <>", value, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeGreaterThan(Date value) {
			addCriterion("LOOK_TIME >", value, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LOOK_TIME >=", value, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeLessThan(Date value) {
			addCriterion("LOOK_TIME <", value, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeLessThanOrEqualTo(Date value) {
			addCriterion("LOOK_TIME <=", value, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeIn(List<Date> values) {
			addCriterion("LOOK_TIME in", values, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeNotIn(List<Date> values) {
			addCriterion("LOOK_TIME not in", values, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeBetween(Date value1, Date value2) {
			addCriterion("LOOK_TIME between", value1, value2, "lookTime");
			return (Criteria) this;
		}

		public Criteria andLookTimeNotBetween(Date value1, Date value2) {
			addCriterion("LOOK_TIME not between", value1, value2, "lookTime");
			return (Criteria) this;
		}

		public Criteria andBookPhoneIsNull() {
			addCriterion("BOOK_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andBookPhoneIsNotNull() {
			addCriterion("BOOK_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andBookPhoneEqualTo(String value) {
			addCriterion("BOOK_PHONE =", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneNotEqualTo(String value) {
			addCriterion("BOOK_PHONE <>", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneGreaterThan(String value) {
			addCriterion("BOOK_PHONE >", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("BOOK_PHONE >=", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneLessThan(String value) {
			addCriterion("BOOK_PHONE <", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneLessThanOrEqualTo(String value) {
			addCriterion("BOOK_PHONE <=", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneLike(String value) {
			addCriterion("BOOK_PHONE like", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneNotLike(String value) {
			addCriterion("BOOK_PHONE not like", value, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneIn(List<String> values) {
			addCriterion("BOOK_PHONE in", values, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneNotIn(List<String> values) {
			addCriterion("BOOK_PHONE not in", values, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneBetween(String value1, String value2) {
			addCriterion("BOOK_PHONE between", value1, value2, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookPhoneNotBetween(String value1, String value2) {
			addCriterion("BOOK_PHONE not between", value1, value2, "bookPhone");
			return (Criteria) this;
		}

		public Criteria andBookSexIsNull() {
			addCriterion("BOOK_SEX is null");
			return (Criteria) this;
		}

		public Criteria andBookSexIsNotNull() {
			addCriterion("BOOK_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andBookSexEqualTo(Integer value) {
			addCriterion("BOOK_SEX =", value, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexNotEqualTo(Integer value) {
			addCriterion("BOOK_SEX <>", value, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexGreaterThan(Integer value) {
			addCriterion("BOOK_SEX >", value, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexGreaterThanOrEqualTo(Integer value) {
			addCriterion("BOOK_SEX >=", value, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexLessThan(Integer value) {
			addCriterion("BOOK_SEX <", value, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexLessThanOrEqualTo(Integer value) {
			addCriterion("BOOK_SEX <=", value, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexIn(List<Integer> values) {
			addCriterion("BOOK_SEX in", values, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexNotIn(List<Integer> values) {
			addCriterion("BOOK_SEX not in", values, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexBetween(Integer value1, Integer value2) {
			addCriterion("BOOK_SEX between", value1, value2, "bookSex");
			return (Criteria) this;
		}

		public Criteria andBookSexNotBetween(Integer value1, Integer value2) {
			addCriterion("BOOK_SEX not between", value1, value2, "bookSex");
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

		public Criteria andBookNameIsNull() {
			addCriterion("BOOK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBookNameIsNotNull() {
			addCriterion("BOOK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBookNameEqualTo(String value) {
			addCriterion("BOOK_NAME =", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameNotEqualTo(String value) {
			addCriterion("BOOK_NAME <>", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameGreaterThan(String value) {
			addCriterion("BOOK_NAME >", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameGreaterThanOrEqualTo(String value) {
			addCriterion("BOOK_NAME >=", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameLessThan(String value) {
			addCriterion("BOOK_NAME <", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameLessThanOrEqualTo(String value) {
			addCriterion("BOOK_NAME <=", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameLike(String value) {
			addCriterion("BOOK_NAME like", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameNotLike(String value) {
			addCriterion("BOOK_NAME not like", value, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameIn(List<String> values) {
			addCriterion("BOOK_NAME in", values, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameNotIn(List<String> values) {
			addCriterion("BOOK_NAME not in", values, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameBetween(String value1, String value2) {
			addCriterion("BOOK_NAME between", value1, value2, "bookName");
			return (Criteria) this;
		}

		public Criteria andBookNameNotBetween(String value1, String value2) {
			addCriterion("BOOK_NAME not between", value1, value2, "bookName");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdIsNull() {
			addCriterion("CASE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdIsNotNull() {
			addCriterion("CASE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdEqualTo(Integer value) {
			addCriterion("CASE_USER_ID =", value, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdNotEqualTo(Integer value) {
			addCriterion("CASE_USER_ID <>", value, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdGreaterThan(Integer value) {
			addCriterion("CASE_USER_ID >", value, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_USER_ID >=", value, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdLessThan(Integer value) {
			addCriterion("CASE_USER_ID <", value, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_USER_ID <=", value, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdIn(List<Integer> values) {
			addCriterion("CASE_USER_ID in", values, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdNotIn(List<Integer> values) {
			addCriterion("CASE_USER_ID not in", values, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CASE_USER_ID between", value1, value2, "caseUserId");
			return (Criteria) this;
		}

		public Criteria andCaseUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_USER_ID not between", value1, value2, "caseUserId");
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

		public Criteria andTransCaseIdIsNull() {
			addCriterion("TRANS_CASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdIsNotNull() {
			addCriterion("TRANS_CASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdEqualTo(Integer value) {
			addCriterion("TRANS_CASE_ID =", value, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdNotEqualTo(Integer value) {
			addCriterion("TRANS_CASE_ID <>", value, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdGreaterThan(Integer value) {
			addCriterion("TRANS_CASE_ID >", value, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRANS_CASE_ID >=", value, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdLessThan(Integer value) {
			addCriterion("TRANS_CASE_ID <", value, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("TRANS_CASE_ID <=", value, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdIn(List<Integer> values) {
			addCriterion("TRANS_CASE_ID in", values, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdNotIn(List<Integer> values) {
			addCriterion("TRANS_CASE_ID not in", values, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdBetween(Integer value1, Integer value2) {
			addCriterion("TRANS_CASE_ID between", value1, value2, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TRANS_CASE_ID not between", value1, value2, "transCaseId");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeIsNull() {
			addCriterion("TRANS_CASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeIsNotNull() {
			addCriterion("TRANS_CASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeEqualTo(Integer value) {
			addCriterion("TRANS_CASE_TYPE =", value, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeNotEqualTo(Integer value) {
			addCriterion("TRANS_CASE_TYPE <>", value, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeGreaterThan(Integer value) {
			addCriterion("TRANS_CASE_TYPE >", value, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRANS_CASE_TYPE >=", value, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeLessThan(Integer value) {
			addCriterion("TRANS_CASE_TYPE <", value, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeLessThanOrEqualTo(Integer value) {
			addCriterion("TRANS_CASE_TYPE <=", value, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeIn(List<Integer> values) {
			addCriterion("TRANS_CASE_TYPE in", values, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeNotIn(List<Integer> values) {
			addCriterion("TRANS_CASE_TYPE not in", values, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeBetween(Integer value1, Integer value2) {
			addCriterion("TRANS_CASE_TYPE between", value1, value2, "transCaseType");
			return (Criteria) this;
		}

		public Criteria andTransCaseTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("TRANS_CASE_TYPE not between", value1, value2, "transCaseType");
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