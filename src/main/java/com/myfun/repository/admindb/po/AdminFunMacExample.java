package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminFunMacExample {
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
	public AdminFunMacExample() {
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

		public Criteria andMacaddrIsNull() {
			addCriterion("MACADDR is null");
			return (Criteria) this;
		}

		public Criteria andMacaddrIsNotNull() {
			addCriterion("MACADDR is not null");
			return (Criteria) this;
		}

		public Criteria andMacaddrEqualTo(String value) {
			addCriterion("MACADDR =", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrNotEqualTo(String value) {
			addCriterion("MACADDR <>", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrGreaterThan(String value) {
			addCriterion("MACADDR >", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrGreaterThanOrEqualTo(String value) {
			addCriterion("MACADDR >=", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrLessThan(String value) {
			addCriterion("MACADDR <", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrLessThanOrEqualTo(String value) {
			addCriterion("MACADDR <=", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrLike(String value) {
			addCriterion("MACADDR like", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrNotLike(String value) {
			addCriterion("MACADDR not like", value, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrIn(List<String> values) {
			addCriterion("MACADDR in", values, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrNotIn(List<String> values) {
			addCriterion("MACADDR not in", values, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrBetween(String value1, String value2) {
			addCriterion("MACADDR between", value1, value2, "macaddr");
			return (Criteria) this;
		}

		public Criteria andMacaddrNotBetween(String value1, String value2) {
			addCriterion("MACADDR not between", value1, value2, "macaddr");
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

		public Criteria andPcnameIsNull() {
			addCriterion("PCNAME is null");
			return (Criteria) this;
		}

		public Criteria andPcnameIsNotNull() {
			addCriterion("PCNAME is not null");
			return (Criteria) this;
		}

		public Criteria andPcnameEqualTo(String value) {
			addCriterion("PCNAME =", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameNotEqualTo(String value) {
			addCriterion("PCNAME <>", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameGreaterThan(String value) {
			addCriterion("PCNAME >", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameGreaterThanOrEqualTo(String value) {
			addCriterion("PCNAME >=", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameLessThan(String value) {
			addCriterion("PCNAME <", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameLessThanOrEqualTo(String value) {
			addCriterion("PCNAME <=", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameLike(String value) {
			addCriterion("PCNAME like", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameNotLike(String value) {
			addCriterion("PCNAME not like", value, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameIn(List<String> values) {
			addCriterion("PCNAME in", values, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameNotIn(List<String> values) {
			addCriterion("PCNAME not in", values, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameBetween(String value1, String value2) {
			addCriterion("PCNAME between", value1, value2, "pcname");
			return (Criteria) this;
		}

		public Criteria andPcnameNotBetween(String value1, String value2) {
			addCriterion("PCNAME not between", value1, value2, "pcname");
			return (Criteria) this;
		}

		public Criteria andFlagIsNull() {
			addCriterion("FLAG is null");
			return (Criteria) this;
		}

		public Criteria andFlagIsNotNull() {
			addCriterion("FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andFlagEqualTo(Byte value) {
			addCriterion("FLAG =", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotEqualTo(Byte value) {
			addCriterion("FLAG <>", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThan(Byte value) {
			addCriterion("FLAG >", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("FLAG >=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThan(Byte value) {
			addCriterion("FLAG <", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThanOrEqualTo(Byte value) {
			addCriterion("FLAG <=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagIn(List<Byte> values) {
			addCriterion("FLAG in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotIn(List<Byte> values) {
			addCriterion("FLAG not in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagBetween(Byte value1, Byte value2) {
			addCriterion("FLAG between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("FLAG not between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andRoamIsNull() {
			addCriterion("ROAM is null");
			return (Criteria) this;
		}

		public Criteria andRoamIsNotNull() {
			addCriterion("ROAM is not null");
			return (Criteria) this;
		}

		public Criteria andRoamEqualTo(Boolean value) {
			addCriterion("ROAM =", value, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamNotEqualTo(Boolean value) {
			addCriterion("ROAM <>", value, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamGreaterThan(Boolean value) {
			addCriterion("ROAM >", value, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ROAM >=", value, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamLessThan(Boolean value) {
			addCriterion("ROAM <", value, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamLessThanOrEqualTo(Boolean value) {
			addCriterion("ROAM <=", value, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamIn(List<Boolean> values) {
			addCriterion("ROAM in", values, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamNotIn(List<Boolean> values) {
			addCriterion("ROAM not in", values, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamBetween(Boolean value1, Boolean value2) {
			addCriterion("ROAM between", value1, value2, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ROAM not between", value1, value2, "roam");
			return (Criteria) this;
		}

		public Criteria andRoamUserIsNull() {
			addCriterion("ROAM_USER is null");
			return (Criteria) this;
		}

		public Criteria andRoamUserIsNotNull() {
			addCriterion("ROAM_USER is not null");
			return (Criteria) this;
		}

		public Criteria andRoamUserEqualTo(Integer value) {
			addCriterion("ROAM_USER =", value, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserNotEqualTo(Integer value) {
			addCriterion("ROAM_USER <>", value, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserGreaterThan(Integer value) {
			addCriterion("ROAM_USER >", value, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("ROAM_USER >=", value, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserLessThan(Integer value) {
			addCriterion("ROAM_USER <", value, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserLessThanOrEqualTo(Integer value) {
			addCriterion("ROAM_USER <=", value, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserIn(List<Integer> values) {
			addCriterion("ROAM_USER in", values, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserNotIn(List<Integer> values) {
			addCriterion("ROAM_USER not in", values, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserBetween(Integer value1, Integer value2) {
			addCriterion("ROAM_USER between", value1, value2, "roamUser");
			return (Criteria) this;
		}

		public Criteria andRoamUserNotBetween(Integer value1, Integer value2) {
			addCriterion("ROAM_USER not between", value1, value2, "roamUser");
			return (Criteria) this;
		}

		public Criteria andOwnerIsNull() {
			addCriterion("[OWNER] is null");
			return (Criteria) this;
		}

		public Criteria andOwnerIsNotNull() {
			addCriterion("[OWNER] is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerEqualTo(String value) {
			addCriterion("[OWNER] =", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotEqualTo(String value) {
			addCriterion("[OWNER] <>", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerGreaterThan(String value) {
			addCriterion("[OWNER] >", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerGreaterThanOrEqualTo(String value) {
			addCriterion("[OWNER] >=", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerLessThan(String value) {
			addCriterion("[OWNER] <", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerLessThanOrEqualTo(String value) {
			addCriterion("[OWNER] <=", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerLike(String value) {
			addCriterion("[OWNER] like", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotLike(String value) {
			addCriterion("[OWNER] not like", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerIn(List<String> values) {
			addCriterion("[OWNER] in", values, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotIn(List<String> values) {
			addCriterion("[OWNER] not in", values, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerBetween(String value1, String value2) {
			addCriterion("[OWNER] between", value1, value2, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotBetween(String value1, String value2) {
			addCriterion("[OWNER] not between", value1, value2, "owner");
			return (Criteria) this;
		}

		public Criteria andPcdisknoIsNull() {
			addCriterion("PCDISKNO is null");
			return (Criteria) this;
		}

		public Criteria andPcdisknoIsNotNull() {
			addCriterion("PCDISKNO is not null");
			return (Criteria) this;
		}

		public Criteria andPcdisknoEqualTo(String value) {
			addCriterion("PCDISKNO =", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoNotEqualTo(String value) {
			addCriterion("PCDISKNO <>", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoGreaterThan(String value) {
			addCriterion("PCDISKNO >", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoGreaterThanOrEqualTo(String value) {
			addCriterion("PCDISKNO >=", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoLessThan(String value) {
			addCriterion("PCDISKNO <", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoLessThanOrEqualTo(String value) {
			addCriterion("PCDISKNO <=", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoLike(String value) {
			addCriterion("PCDISKNO like", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoNotLike(String value) {
			addCriterion("PCDISKNO not like", value, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoIn(List<String> values) {
			addCriterion("PCDISKNO in", values, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoNotIn(List<String> values) {
			addCriterion("PCDISKNO not in", values, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoBetween(String value1, String value2) {
			addCriterion("PCDISKNO between", value1, value2, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andPcdisknoNotBetween(String value1, String value2) {
			addCriterion("PCDISKNO not between", value1, value2, "pcdiskno");
			return (Criteria) this;
		}

		public Criteria andRoutemacIsNull() {
			addCriterion("ROUTEMAC is null");
			return (Criteria) this;
		}

		public Criteria andRoutemacIsNotNull() {
			addCriterion("ROUTEMAC is not null");
			return (Criteria) this;
		}

		public Criteria andRoutemacEqualTo(String value) {
			addCriterion("ROUTEMAC =", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacNotEqualTo(String value) {
			addCriterion("ROUTEMAC <>", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacGreaterThan(String value) {
			addCriterion("ROUTEMAC >", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacGreaterThanOrEqualTo(String value) {
			addCriterion("ROUTEMAC >=", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacLessThan(String value) {
			addCriterion("ROUTEMAC <", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacLessThanOrEqualTo(String value) {
			addCriterion("ROUTEMAC <=", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacLike(String value) {
			addCriterion("ROUTEMAC like", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacNotLike(String value) {
			addCriterion("ROUTEMAC not like", value, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacIn(List<String> values) {
			addCriterion("ROUTEMAC in", values, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacNotIn(List<String> values) {
			addCriterion("ROUTEMAC not in", values, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacBetween(String value1, String value2) {
			addCriterion("ROUTEMAC between", value1, value2, "routemac");
			return (Criteria) this;
		}

		public Criteria andRoutemacNotBetween(String value1, String value2) {
			addCriterion("ROUTEMAC not between", value1, value2, "routemac");
			return (Criteria) this;
		}

		public Criteria andRegtimeIsNull() {
			addCriterion("REGTIME is null");
			return (Criteria) this;
		}

		public Criteria andRegtimeIsNotNull() {
			addCriterion("REGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andRegtimeEqualTo(String value) {
			addCriterion("REGTIME =", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeNotEqualTo(String value) {
			addCriterion("REGTIME <>", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeGreaterThan(String value) {
			addCriterion("REGTIME >", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeGreaterThanOrEqualTo(String value) {
			addCriterion("REGTIME >=", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeLessThan(String value) {
			addCriterion("REGTIME <", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeLessThanOrEqualTo(String value) {
			addCriterion("REGTIME <=", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeLike(String value) {
			addCriterion("REGTIME like", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeNotLike(String value) {
			addCriterion("REGTIME not like", value, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeIn(List<String> values) {
			addCriterion("REGTIME in", values, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeNotIn(List<String> values) {
			addCriterion("REGTIME not in", values, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeBetween(String value1, String value2) {
			addCriterion("REGTIME between", value1, value2, "regtime");
			return (Criteria) this;
		}

		public Criteria andRegtimeNotBetween(String value1, String value2) {
			addCriterion("REGTIME not between", value1, value2, "regtime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNull() {
			addCriterion("LAST_LOGIN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNotNull() {
			addCriterion("LAST_LOGIN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeEqualTo(String value) {
			addCriterion("LAST_LOGIN_TIME =", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotEqualTo(String value) {
			addCriterion("LAST_LOGIN_TIME <>", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThan(String value) {
			addCriterion("LAST_LOGIN_TIME >", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThanOrEqualTo(String value) {
			addCriterion("LAST_LOGIN_TIME >=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThan(String value) {
			addCriterion("LAST_LOGIN_TIME <", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThanOrEqualTo(String value) {
			addCriterion("LAST_LOGIN_TIME <=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLike(String value) {
			addCriterion("LAST_LOGIN_TIME like", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotLike(String value) {
			addCriterion("LAST_LOGIN_TIME not like", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIn(List<String> values) {
			addCriterion("LAST_LOGIN_TIME in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotIn(List<String> values) {
			addCriterion("LAST_LOGIN_TIME not in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeBetween(String value1, String value2) {
			addCriterion("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotBetween(String value1, String value2) {
			addCriterion("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
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