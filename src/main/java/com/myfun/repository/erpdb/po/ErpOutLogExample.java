package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpOutLogExample extends ShardDb {
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
	public ErpOutLogExample() {
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

		public Criteria andOutIdIsNull() {
			addCriterion("OUT_ID is null");
			return (Criteria) this;
		}

		public Criteria andOutIdIsNotNull() {
			addCriterion("OUT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOutIdEqualTo(Integer value) {
			addCriterion("OUT_ID =", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdNotEqualTo(Integer value) {
			addCriterion("OUT_ID <>", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdGreaterThan(Integer value) {
			addCriterion("OUT_ID >", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("OUT_ID >=", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdLessThan(Integer value) {
			addCriterion("OUT_ID <", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdLessThanOrEqualTo(Integer value) {
			addCriterion("OUT_ID <=", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdIn(List<Integer> values) {
			addCriterion("OUT_ID in", values, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdNotIn(List<Integer> values) {
			addCriterion("OUT_ID not in", values, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdBetween(Integer value1, Integer value2) {
			addCriterion("OUT_ID between", value1, value2, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdNotBetween(Integer value1, Integer value2) {
			addCriterion("OUT_ID not between", value1, value2, "outId");
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

		public Criteria andOutUserIsNull() {
			addCriterion("OUT_USER is null");
			return (Criteria) this;
		}

		public Criteria andOutUserIsNotNull() {
			addCriterion("OUT_USER is not null");
			return (Criteria) this;
		}

		public Criteria andOutUserEqualTo(Integer value) {
			addCriterion("OUT_USER =", value, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserNotEqualTo(Integer value) {
			addCriterion("OUT_USER <>", value, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserGreaterThan(Integer value) {
			addCriterion("OUT_USER >", value, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("OUT_USER >=", value, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserLessThan(Integer value) {
			addCriterion("OUT_USER <", value, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserLessThanOrEqualTo(Integer value) {
			addCriterion("OUT_USER <=", value, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserIn(List<Integer> values) {
			addCriterion("OUT_USER in", values, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserNotIn(List<Integer> values) {
			addCriterion("OUT_USER not in", values, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserBetween(Integer value1, Integer value2) {
			addCriterion("OUT_USER between", value1, value2, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutUserNotBetween(Integer value1, Integer value2) {
			addCriterion("OUT_USER not between", value1, value2, "outUser");
			return (Criteria) this;
		}

		public Criteria andOutTimeIsNull() {
			addCriterion("OUT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andOutTimeIsNotNull() {
			addCriterion("OUT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andOutTimeEqualTo(String value) {
			addCriterion("OUT_TIME =", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeNotEqualTo(String value) {
			addCriterion("OUT_TIME <>", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeGreaterThan(String value) {
			addCriterion("OUT_TIME >", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeGreaterThanOrEqualTo(String value) {
			addCriterion("OUT_TIME >=", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeLessThan(String value) {
			addCriterion("OUT_TIME <", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeLessThanOrEqualTo(String value) {
			addCriterion("OUT_TIME <=", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeLike(String value) {
			addCriterion("OUT_TIME like", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeNotLike(String value) {
			addCriterion("OUT_TIME not like", value, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeIn(List<String> values) {
			addCriterion("OUT_TIME in", values, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeNotIn(List<String> values) {
			addCriterion("OUT_TIME not in", values, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeBetween(String value1, String value2) {
			addCriterion("OUT_TIME between", value1, value2, "outTime");
			return (Criteria) this;
		}

		public Criteria andOutTimeNotBetween(String value1, String value2) {
			addCriterion("OUT_TIME not between", value1, value2, "outTime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeIsNull() {
			addCriterion("EXPECT_BACKTIME is null");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeIsNotNull() {
			addCriterion("EXPECT_BACKTIME is not null");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeEqualTo(Integer value) {
			addCriterion("EXPECT_BACKTIME =", value, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeNotEqualTo(Integer value) {
			addCriterion("EXPECT_BACKTIME <>", value, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeGreaterThan(Integer value) {
			addCriterion("EXPECT_BACKTIME >", value, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("EXPECT_BACKTIME >=", value, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeLessThan(Integer value) {
			addCriterion("EXPECT_BACKTIME <", value, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeLessThanOrEqualTo(Integer value) {
			addCriterion("EXPECT_BACKTIME <=", value, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeIn(List<Integer> values) {
			addCriterion("EXPECT_BACKTIME in", values, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeNotIn(List<Integer> values) {
			addCriterion("EXPECT_BACKTIME not in", values, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeBetween(Integer value1, Integer value2) {
			addCriterion("EXPECT_BACKTIME between", value1, value2, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andExpectBacktimeNotBetween(Integer value1, Integer value2) {
			addCriterion("EXPECT_BACKTIME not between", value1, value2, "expectBacktime");
			return (Criteria) this;
		}

		public Criteria andOutDescIsNull() {
			addCriterion("OUT_DESC is null");
			return (Criteria) this;
		}

		public Criteria andOutDescIsNotNull() {
			addCriterion("OUT_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andOutDescEqualTo(String value) {
			addCriterion("OUT_DESC =", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescNotEqualTo(String value) {
			addCriterion("OUT_DESC <>", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescGreaterThan(String value) {
			addCriterion("OUT_DESC >", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescGreaterThanOrEqualTo(String value) {
			addCriterion("OUT_DESC >=", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescLessThan(String value) {
			addCriterion("OUT_DESC <", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescLessThanOrEqualTo(String value) {
			addCriterion("OUT_DESC <=", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescLike(String value) {
			addCriterion("OUT_DESC like", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescNotLike(String value) {
			addCriterion("OUT_DESC not like", value, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescIn(List<String> values) {
			addCriterion("OUT_DESC in", values, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescNotIn(List<String> values) {
			addCriterion("OUT_DESC not in", values, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescBetween(String value1, String value2) {
			addCriterion("OUT_DESC between", value1, value2, "outDesc");
			return (Criteria) this;
		}

		public Criteria andOutDescNotBetween(String value1, String value2) {
			addCriterion("OUT_DESC not between", value1, value2, "outDesc");
			return (Criteria) this;
		}

		public Criteria andBackTimeIsNull() {
			addCriterion("BACK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andBackTimeIsNotNull() {
			addCriterion("BACK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andBackTimeEqualTo(String value) {
			addCriterion("BACK_TIME =", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeNotEqualTo(String value) {
			addCriterion("BACK_TIME <>", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeGreaterThan(String value) {
			addCriterion("BACK_TIME >", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeGreaterThanOrEqualTo(String value) {
			addCriterion("BACK_TIME >=", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeLessThan(String value) {
			addCriterion("BACK_TIME <", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeLessThanOrEqualTo(String value) {
			addCriterion("BACK_TIME <=", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeLike(String value) {
			addCriterion("BACK_TIME like", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeNotLike(String value) {
			addCriterion("BACK_TIME not like", value, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeIn(List<String> values) {
			addCriterion("BACK_TIME in", values, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeNotIn(List<String> values) {
			addCriterion("BACK_TIME not in", values, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeBetween(String value1, String value2) {
			addCriterion("BACK_TIME between", value1, value2, "backTime");
			return (Criteria) this;
		}

		public Criteria andBackTimeNotBetween(String value1, String value2) {
			addCriterion("BACK_TIME not between", value1, value2, "backTime");
			return (Criteria) this;
		}

		public Criteria andOutUserNameIsNull() {
			addCriterion("OUT_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andOutUserNameIsNotNull() {
			addCriterion("OUT_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andOutUserNameEqualTo(String value) {
			addCriterion("OUT_USER_NAME =", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameNotEqualTo(String value) {
			addCriterion("OUT_USER_NAME <>", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameGreaterThan(String value) {
			addCriterion("OUT_USER_NAME >", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("OUT_USER_NAME >=", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameLessThan(String value) {
			addCriterion("OUT_USER_NAME <", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameLessThanOrEqualTo(String value) {
			addCriterion("OUT_USER_NAME <=", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameLike(String value) {
			addCriterion("OUT_USER_NAME like", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameNotLike(String value) {
			addCriterion("OUT_USER_NAME not like", value, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameIn(List<String> values) {
			addCriterion("OUT_USER_NAME in", values, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameNotIn(List<String> values) {
			addCriterion("OUT_USER_NAME not in", values, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameBetween(String value1, String value2) {
			addCriterion("OUT_USER_NAME between", value1, value2, "outUserName");
			return (Criteria) this;
		}

		public Criteria andOutUserNameNotBetween(String value1, String value2) {
			addCriterion("OUT_USER_NAME not between", value1, value2, "outUserName");
			return (Criteria) this;
		}

		public Criteria andCheckInCountIsNull() {
			addCriterion("CHECK_IN_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andCheckInCountIsNotNull() {
			addCriterion("CHECK_IN_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andCheckInCountEqualTo(Integer value) {
			addCriterion("CHECK_IN_COUNT =", value, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountNotEqualTo(Integer value) {
			addCriterion("CHECK_IN_COUNT <>", value, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountGreaterThan(Integer value) {
			addCriterion("CHECK_IN_COUNT >", value, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("CHECK_IN_COUNT >=", value, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountLessThan(Integer value) {
			addCriterion("CHECK_IN_COUNT <", value, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountLessThanOrEqualTo(Integer value) {
			addCriterion("CHECK_IN_COUNT <=", value, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountIn(List<Integer> values) {
			addCriterion("CHECK_IN_COUNT in", values, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountNotIn(List<Integer> values) {
			addCriterion("CHECK_IN_COUNT not in", values, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountBetween(Integer value1, Integer value2) {
			addCriterion("CHECK_IN_COUNT between", value1, value2, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andCheckInCountNotBetween(Integer value1, Integer value2) {
			addCriterion("CHECK_IN_COUNT not between", value1, value2, "checkInCount");
			return (Criteria) this;
		}

		public Criteria andAuditIdIsNull() {
			addCriterion("AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditIdIsNotNull() {
			addCriterion("AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditIdEqualTo(Integer value) {
			addCriterion("AUDIT_ID =", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_ID <>", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThan(Integer value) {
			addCriterion("AUDIT_ID >", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID >=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThan(Integer value) {
			addCriterion("AUDIT_ID <", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID <=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdIn(List<Integer> values) {
			addCriterion("AUDIT_ID in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_ID not in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID not between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIsNull() {
			addCriterion("ASSESSMENT_MONTH is null");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIsNotNull() {
			addCriterion("ASSESSMENT_MONTH is not null");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH =", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH <>", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthGreaterThan(String value) {
			addCriterion("ASSESSMENT_MONTH >", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthGreaterThanOrEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH >=", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLessThan(String value) {
			addCriterion("ASSESSMENT_MONTH <", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLessThanOrEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH <=", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLike(String value) {
			addCriterion("ASSESSMENT_MONTH like", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotLike(String value) {
			addCriterion("ASSESSMENT_MONTH not like", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIn(List<String> values) {
			addCriterion("ASSESSMENT_MONTH in", values, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotIn(List<String> values) {
			addCriterion("ASSESSMENT_MONTH not in", values, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthBetween(String value1, String value2) {
			addCriterion("ASSESSMENT_MONTH between", value1, value2, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotBetween(String value1, String value2) {
			addCriterion("ASSESSMENT_MONTH not between", value1, value2, "assessmentMonth");
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