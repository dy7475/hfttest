package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class ErpFunUsersExample extends ShardDb {
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
	public ErpFunUsersExample() {
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

		public Criteria andCityIdIsNull() {
			addCriterion("CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNotNull() {
			addCriterion("CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCityIdEqualTo(Short value) {
			addCriterion("CITY_ID =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Short value) {
			addCriterion("CITY_ID <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Short value) {
			addCriterion("CITY_ID >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Short value) {
			addCriterion("CITY_ID >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Short value) {
			addCriterion("CITY_ID <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Short value) {
			addCriterion("CITY_ID <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Short> values) {
			addCriterion("CITY_ID in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Short> values) {
			addCriterion("CITY_ID not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Short value1, Short value2) {
			addCriterion("CITY_ID between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Short value1, Short value2) {
			addCriterion("CITY_ID not between", value1, value2, "cityId");
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

		public Criteria andUserNoIsNull() {
			addCriterion("USER_NO is null");
			return (Criteria) this;
		}

		public Criteria andUserNoIsNotNull() {
			addCriterion("USER_NO is not null");
			return (Criteria) this;
		}

		public Criteria andUserNoEqualTo(String value) {
			addCriterion("USER_NO =", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotEqualTo(String value) {
			addCriterion("USER_NO <>", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoGreaterThan(String value) {
			addCriterion("USER_NO >", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NO >=", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoLessThan(String value) {
			addCriterion("USER_NO <", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoLessThanOrEqualTo(String value) {
			addCriterion("USER_NO <=", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoLike(String value) {
			addCriterion("USER_NO like", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotLike(String value) {
			addCriterion("USER_NO not like", value, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoIn(List<String> values) {
			addCriterion("USER_NO in", values, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotIn(List<String> values) {
			addCriterion("USER_NO not in", values, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoBetween(String value1, String value2) {
			addCriterion("USER_NO between", value1, value2, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNoNotBetween(String value1, String value2) {
			addCriterion("USER_NO not between", value1, value2, "userNo");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("USER_NAME =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("USER_NAME <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("USER_NAME >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NAME >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("USER_NAME <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("USER_NAME <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("USER_NAME like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("USER_NAME not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("USER_NAME in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("USER_NAME not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("USER_NAME between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("USER_NAME not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andLoginUseridIsNull() {
			addCriterion("LOGIN_USERID is null");
			return (Criteria) this;
		}

		public Criteria andLoginUseridIsNotNull() {
			addCriterion("LOGIN_USERID is not null");
			return (Criteria) this;
		}

		public Criteria andLoginUseridEqualTo(String value) {
			addCriterion("LOGIN_USERID =", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridNotEqualTo(String value) {
			addCriterion("LOGIN_USERID <>", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridGreaterThan(String value) {
			addCriterion("LOGIN_USERID >", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridGreaterThanOrEqualTo(String value) {
			addCriterion("LOGIN_USERID >=", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridLessThan(String value) {
			addCriterion("LOGIN_USERID <", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridLessThanOrEqualTo(String value) {
			addCriterion("LOGIN_USERID <=", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridLike(String value) {
			addCriterion("LOGIN_USERID like", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridNotLike(String value) {
			addCriterion("LOGIN_USERID not like", value, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridIn(List<String> values) {
			addCriterion("LOGIN_USERID in", values, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridNotIn(List<String> values) {
			addCriterion("LOGIN_USERID not in", values, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridBetween(String value1, String value2) {
			addCriterion("LOGIN_USERID between", value1, value2, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginUseridNotBetween(String value1, String value2) {
			addCriterion("LOGIN_USERID not between", value1, value2, "loginUserid");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordIsNull() {
			addCriterion("LOGIN_PASSWORD is null");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordIsNotNull() {
			addCriterion("LOGIN_PASSWORD is not null");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordEqualTo(String value) {
			addCriterion("LOGIN_PASSWORD =", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotEqualTo(String value) {
			addCriterion("LOGIN_PASSWORD <>", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordGreaterThan(String value) {
			addCriterion("LOGIN_PASSWORD >", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("LOGIN_PASSWORD >=", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordLessThan(String value) {
			addCriterion("LOGIN_PASSWORD <", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
			addCriterion("LOGIN_PASSWORD <=", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordLike(String value) {
			addCriterion("LOGIN_PASSWORD like", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotLike(String value) {
			addCriterion("LOGIN_PASSWORD not like", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordIn(List<String> values) {
			addCriterion("LOGIN_PASSWORD in", values, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotIn(List<String> values) {
			addCriterion("LOGIN_PASSWORD not in", values, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordBetween(String value1, String value2) {
			addCriterion("LOGIN_PASSWORD between", value1, value2, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotBetween(String value1, String value2) {
			addCriterion("LOGIN_PASSWORD not between", value1, value2, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andUserSexIsNull() {
			addCriterion("USER_SEX is null");
			return (Criteria) this;
		}

		public Criteria andUserSexIsNotNull() {
			addCriterion("USER_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andUserSexEqualTo(Boolean value) {
			addCriterion("USER_SEX =", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexNotEqualTo(Boolean value) {
			addCriterion("USER_SEX <>", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexGreaterThan(Boolean value) {
			addCriterion("USER_SEX >", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexGreaterThanOrEqualTo(Boolean value) {
			addCriterion("USER_SEX >=", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexLessThan(Boolean value) {
			addCriterion("USER_SEX <", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexLessThanOrEqualTo(Boolean value) {
			addCriterion("USER_SEX <=", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexIn(List<Boolean> values) {
			addCriterion("USER_SEX in", values, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexNotIn(List<Boolean> values) {
			addCriterion("USER_SEX not in", values, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_SEX between", value1, value2, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexNotBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_SEX not between", value1, value2, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserMobileIsNull() {
			addCriterion("USER_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andUserMobileIsNotNull() {
			addCriterion("USER_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andUserMobileEqualTo(String value) {
			addCriterion("USER_MOBILE =", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotEqualTo(String value) {
			addCriterion("USER_MOBILE <>", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileGreaterThan(String value) {
			addCriterion("USER_MOBILE >", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
			addCriterion("USER_MOBILE >=", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLessThan(String value) {
			addCriterion("USER_MOBILE <", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLessThanOrEqualTo(String value) {
			addCriterion("USER_MOBILE <=", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLike(String value) {
			addCriterion("USER_MOBILE like", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotLike(String value) {
			addCriterion("USER_MOBILE not like", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileIn(List<String> values) {
			addCriterion("USER_MOBILE in", values, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotIn(List<String> values) {
			addCriterion("USER_MOBILE not in", values, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileBetween(String value1, String value2) {
			addCriterion("USER_MOBILE between", value1, value2, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotBetween(String value1, String value2) {
			addCriterion("USER_MOBILE not between", value1, value2, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserJobDateIsNull() {
			addCriterion("USER_JOB_DATE is null");
			return (Criteria) this;
		}

		public Criteria andUserJobDateIsNotNull() {
			addCriterion("USER_JOB_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andUserJobDateEqualTo(String value) {
			addCriterion("USER_JOB_DATE =", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateNotEqualTo(String value) {
			addCriterion("USER_JOB_DATE <>", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateGreaterThan(String value) {
			addCriterion("USER_JOB_DATE >", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateGreaterThanOrEqualTo(String value) {
			addCriterion("USER_JOB_DATE >=", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateLessThan(String value) {
			addCriterion("USER_JOB_DATE <", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateLessThanOrEqualTo(String value) {
			addCriterion("USER_JOB_DATE <=", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateLike(String value) {
			addCriterion("USER_JOB_DATE like", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateNotLike(String value) {
			addCriterion("USER_JOB_DATE not like", value, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateIn(List<String> values) {
			addCriterion("USER_JOB_DATE in", values, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateNotIn(List<String> values) {
			addCriterion("USER_JOB_DATE not in", values, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateBetween(String value1, String value2) {
			addCriterion("USER_JOB_DATE between", value1, value2, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserJobDateNotBetween(String value1, String value2) {
			addCriterion("USER_JOB_DATE not between", value1, value2, "userJobDate");
			return (Criteria) this;
		}

		public Criteria andUserPositionIsNull() {
			addCriterion("USER_POSITION is null");
			return (Criteria) this;
		}

		public Criteria andUserPositionIsNotNull() {
			addCriterion("USER_POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andUserPositionEqualTo(String value) {
			addCriterion("USER_POSITION =", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotEqualTo(String value) {
			addCriterion("USER_POSITION <>", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionGreaterThan(String value) {
			addCriterion("USER_POSITION >", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionGreaterThanOrEqualTo(String value) {
			addCriterion("USER_POSITION >=", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLessThan(String value) {
			addCriterion("USER_POSITION <", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLessThanOrEqualTo(String value) {
			addCriterion("USER_POSITION <=", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLike(String value) {
			addCriterion("USER_POSITION like", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotLike(String value) {
			addCriterion("USER_POSITION not like", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionIn(List<String> values) {
			addCriterion("USER_POSITION in", values, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotIn(List<String> values) {
			addCriterion("USER_POSITION not in", values, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionBetween(String value1, String value2) {
			addCriterion("USER_POSITION between", value1, value2, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotBetween(String value1, String value2) {
			addCriterion("USER_POSITION not between", value1, value2, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserStatusIsNull() {
			addCriterion("USER_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andUserStatusIsNotNull() {
			addCriterion("USER_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andUserStatusEqualTo(Byte value) {
			addCriterion("USER_STATUS =", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotEqualTo(Byte value) {
			addCriterion("USER_STATUS <>", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThan(Byte value) {
			addCriterion("USER_STATUS >", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("USER_STATUS >=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThan(Byte value) {
			addCriterion("USER_STATUS <", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThanOrEqualTo(Byte value) {
			addCriterion("USER_STATUS <=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusIn(List<Byte> values) {
			addCriterion("USER_STATUS in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotIn(List<Byte> values) {
			addCriterion("USER_STATUS not in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusBetween(Byte value1, Byte value2) {
			addCriterion("USER_STATUS between", value1, value2, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("USER_STATUS not between", value1, value2, "userStatus");
			return (Criteria) this;
		}

		public Criteria andStatusTimeIsNull() {
			addCriterion("STATUS_TIME is null");
			return (Criteria) this;
		}

		public Criteria andStatusTimeIsNotNull() {
			addCriterion("STATUS_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andStatusTimeEqualTo(String value) {
			addCriterion("STATUS_TIME =", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeNotEqualTo(String value) {
			addCriterion("STATUS_TIME <>", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeGreaterThan(String value) {
			addCriterion("STATUS_TIME >", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeGreaterThanOrEqualTo(String value) {
			addCriterion("STATUS_TIME >=", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeLessThan(String value) {
			addCriterion("STATUS_TIME <", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeLessThanOrEqualTo(String value) {
			addCriterion("STATUS_TIME <=", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeLike(String value) {
			addCriterion("STATUS_TIME like", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeNotLike(String value) {
			addCriterion("STATUS_TIME not like", value, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeIn(List<String> values) {
			addCriterion("STATUS_TIME in", values, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeNotIn(List<String> values) {
			addCriterion("STATUS_TIME not in", values, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeBetween(String value1, String value2) {
			addCriterion("STATUS_TIME between", value1, value2, "statusTime");
			return (Criteria) this;
		}

		public Criteria andStatusTimeNotBetween(String value1, String value2) {
			addCriterion("STATUS_TIME not between", value1, value2, "statusTime");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffIsNull() {
			addCriterion("USER_WRITEOFF is null");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffIsNotNull() {
			addCriterion("USER_WRITEOFF is not null");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffEqualTo(Boolean value) {
			addCriterion("USER_WRITEOFF =", value, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffNotEqualTo(Boolean value) {
			addCriterion("USER_WRITEOFF <>", value, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffGreaterThan(Boolean value) {
			addCriterion("USER_WRITEOFF >", value, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffGreaterThanOrEqualTo(Boolean value) {
			addCriterion("USER_WRITEOFF >=", value, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffLessThan(Boolean value) {
			addCriterion("USER_WRITEOFF <", value, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffLessThanOrEqualTo(Boolean value) {
			addCriterion("USER_WRITEOFF <=", value, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffIn(List<Boolean> values) {
			addCriterion("USER_WRITEOFF in", values, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffNotIn(List<Boolean> values) {
			addCriterion("USER_WRITEOFF not in", values, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_WRITEOFF between", value1, value2, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andUserWriteoffNotBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_WRITEOFF not between", value1, value2, "userWriteoff");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeIsNull() {
			addCriterion("WRITEOFF_TIME is null");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeIsNotNull() {
			addCriterion("WRITEOFF_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeEqualTo(String value) {
			addCriterion("WRITEOFF_TIME =", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotEqualTo(String value) {
			addCriterion("WRITEOFF_TIME <>", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeGreaterThan(String value) {
			addCriterion("WRITEOFF_TIME >", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeGreaterThanOrEqualTo(String value) {
			addCriterion("WRITEOFF_TIME >=", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeLessThan(String value) {
			addCriterion("WRITEOFF_TIME <", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeLessThanOrEqualTo(String value) {
			addCriterion("WRITEOFF_TIME <=", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeLike(String value) {
			addCriterion("WRITEOFF_TIME like", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotLike(String value) {
			addCriterion("WRITEOFF_TIME not like", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeIn(List<String> values) {
			addCriterion("WRITEOFF_TIME in", values, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotIn(List<String> values) {
			addCriterion("WRITEOFF_TIME not in", values, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeBetween(String value1, String value2) {
			addCriterion("WRITEOFF_TIME between", value1, value2, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotBetween(String value1, String value2) {
			addCriterion("WRITEOFF_TIME not between", value1, value2, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWageFlagIsNull() {
			addCriterion("WAGE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andWageFlagIsNotNull() {
			addCriterion("WAGE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andWageFlagEqualTo(Boolean value) {
			addCriterion("WAGE_FLAG =", value, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagNotEqualTo(Boolean value) {
			addCriterion("WAGE_FLAG <>", value, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagGreaterThan(Boolean value) {
			addCriterion("WAGE_FLAG >", value, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("WAGE_FLAG >=", value, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagLessThan(Boolean value) {
			addCriterion("WAGE_FLAG <", value, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("WAGE_FLAG <=", value, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagIn(List<Boolean> values) {
			addCriterion("WAGE_FLAG in", values, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagNotIn(List<Boolean> values) {
			addCriterion("WAGE_FLAG not in", values, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("WAGE_FLAG between", value1, value2, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andWageFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("WAGE_FLAG not between", value1, value2, "wageFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagIsNull() {
			addCriterion("BUILD_RULE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagIsNotNull() {
			addCriterion("BUILD_RULE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagEqualTo(Boolean value) {
			addCriterion("BUILD_RULE_FLAG =", value, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagNotEqualTo(Boolean value) {
			addCriterion("BUILD_RULE_FLAG <>", value, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagGreaterThan(Boolean value) {
			addCriterion("BUILD_RULE_FLAG >", value, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("BUILD_RULE_FLAG >=", value, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagLessThan(Boolean value) {
			addCriterion("BUILD_RULE_FLAG <", value, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("BUILD_RULE_FLAG <=", value, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagIn(List<Boolean> values) {
			addCriterion("BUILD_RULE_FLAG in", values, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagNotIn(List<Boolean> values) {
			addCriterion("BUILD_RULE_FLAG not in", values, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("BUILD_RULE_FLAG between", value1, value2, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andBuildRuleFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("BUILD_RULE_FLAG not between", value1, value2, "buildRuleFlag");
			return (Criteria) this;
		}

		public Criteria andUserPidIsNull() {
			addCriterion("USER_PID is null");
			return (Criteria) this;
		}

		public Criteria andUserPidIsNotNull() {
			addCriterion("USER_PID is not null");
			return (Criteria) this;
		}

		public Criteria andUserPidEqualTo(String value) {
			addCriterion("USER_PID =", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidNotEqualTo(String value) {
			addCriterion("USER_PID <>", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidGreaterThan(String value) {
			addCriterion("USER_PID >", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidGreaterThanOrEqualTo(String value) {
			addCriterion("USER_PID >=", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidLessThan(String value) {
			addCriterion("USER_PID <", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidLessThanOrEqualTo(String value) {
			addCriterion("USER_PID <=", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidLike(String value) {
			addCriterion("USER_PID like", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidNotLike(String value) {
			addCriterion("USER_PID not like", value, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidIn(List<String> values) {
			addCriterion("USER_PID in", values, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidNotIn(List<String> values) {
			addCriterion("USER_PID not in", values, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidBetween(String value1, String value2) {
			addCriterion("USER_PID between", value1, value2, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserPidNotBetween(String value1, String value2) {
			addCriterion("USER_PID not between", value1, value2, "userPid");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeIsNull() {
			addCriterion("USER_LOGTIME is null");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeIsNotNull() {
			addCriterion("USER_LOGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeEqualTo(String value) {
			addCriterion("USER_LOGTIME =", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeNotEqualTo(String value) {
			addCriterion("USER_LOGTIME <>", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeGreaterThan(String value) {
			addCriterion("USER_LOGTIME >", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeGreaterThanOrEqualTo(String value) {
			addCriterion("USER_LOGTIME >=", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeLessThan(String value) {
			addCriterion("USER_LOGTIME <", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeLessThanOrEqualTo(String value) {
			addCriterion("USER_LOGTIME <=", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeLike(String value) {
			addCriterion("USER_LOGTIME like", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeNotLike(String value) {
			addCriterion("USER_LOGTIME not like", value, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeIn(List<String> values) {
			addCriterion("USER_LOGTIME in", values, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeNotIn(List<String> values) {
			addCriterion("USER_LOGTIME not in", values, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeBetween(String value1, String value2) {
			addCriterion("USER_LOGTIME between", value1, value2, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserLogtimeNotBetween(String value1, String value2) {
			addCriterion("USER_LOGTIME not between", value1, value2, "userLogtime");
			return (Criteria) this;
		}

		public Criteria andUserEditionIsNull() {
			addCriterion("USER_EDITION is null");
			return (Criteria) this;
		}

		public Criteria andUserEditionIsNotNull() {
			addCriterion("USER_EDITION is not null");
			return (Criteria) this;
		}

		public Criteria andUserEditionEqualTo(Integer value) {
			addCriterion("USER_EDITION =", value, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionNotEqualTo(Integer value) {
			addCriterion("USER_EDITION <>", value, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionGreaterThan(Integer value) {
			addCriterion("USER_EDITION >", value, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_EDITION >=", value, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionLessThan(Integer value) {
			addCriterion("USER_EDITION <", value, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionLessThanOrEqualTo(Integer value) {
			addCriterion("USER_EDITION <=", value, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionIn(List<Integer> values) {
			addCriterion("USER_EDITION in", values, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionNotIn(List<Integer> values) {
			addCriterion("USER_EDITION not in", values, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionBetween(Integer value1, Integer value2) {
			addCriterion("USER_EDITION between", value1, value2, "userEdition");
			return (Criteria) this;
		}

		public Criteria andUserEditionNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_EDITION not between", value1, value2, "userEdition");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagIsNull() {
			addCriterion("ALLDEPT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagIsNotNull() {
			addCriterion("ALLDEPT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagEqualTo(Boolean value) {
			addCriterion("ALLDEPT_FLAG =", value, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagNotEqualTo(Boolean value) {
			addCriterion("ALLDEPT_FLAG <>", value, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagGreaterThan(Boolean value) {
			addCriterion("ALLDEPT_FLAG >", value, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ALLDEPT_FLAG >=", value, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagLessThan(Boolean value) {
			addCriterion("ALLDEPT_FLAG <", value, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("ALLDEPT_FLAG <=", value, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagIn(List<Boolean> values) {
			addCriterion("ALLDEPT_FLAG in", values, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagNotIn(List<Boolean> values) {
			addCriterion("ALLDEPT_FLAG not in", values, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("ALLDEPT_FLAG between", value1, value2, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andAlldeptFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ALLDEPT_FLAG not between", value1, value2, "alldeptFlag");
			return (Criteria) this;
		}

		public Criteria andUserRoamIsNull() {
			addCriterion("USER_ROAM is null");
			return (Criteria) this;
		}

		public Criteria andUserRoamIsNotNull() {
			addCriterion("USER_ROAM is not null");
			return (Criteria) this;
		}

		public Criteria andUserRoamEqualTo(Boolean value) {
			addCriterion("USER_ROAM =", value, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamNotEqualTo(Boolean value) {
			addCriterion("USER_ROAM <>", value, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamGreaterThan(Boolean value) {
			addCriterion("USER_ROAM >", value, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamGreaterThanOrEqualTo(Boolean value) {
			addCriterion("USER_ROAM >=", value, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamLessThan(Boolean value) {
			addCriterion("USER_ROAM <", value, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamLessThanOrEqualTo(Boolean value) {
			addCriterion("USER_ROAM <=", value, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamIn(List<Boolean> values) {
			addCriterion("USER_ROAM in", values, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamNotIn(List<Boolean> values) {
			addCriterion("USER_ROAM not in", values, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_ROAM between", value1, value2, "userRoam");
			return (Criteria) this;
		}

		public Criteria andUserRoamNotBetween(Boolean value1, Boolean value2) {
			addCriterion("USER_ROAM not between", value1, value2, "userRoam");
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

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("UPDATE_TIME like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("UPDATE_TIME not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinIsNull() {
			addCriterion("USER_PHOTO_MIN is null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinIsNotNull() {
			addCriterion("USER_PHOTO_MIN is not null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinEqualTo(String value) {
			addCriterion("USER_PHOTO_MIN =", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinNotEqualTo(String value) {
			addCriterion("USER_PHOTO_MIN <>", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinGreaterThan(String value) {
			addCriterion("USER_PHOTO_MIN >", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinGreaterThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO_MIN >=", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinLessThan(String value) {
			addCriterion("USER_PHOTO_MIN <", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinLessThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO_MIN <=", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinLike(String value) {
			addCriterion("USER_PHOTO_MIN like", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinNotLike(String value) {
			addCriterion("USER_PHOTO_MIN not like", value, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinIn(List<String> values) {
			addCriterion("USER_PHOTO_MIN in", values, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinNotIn(List<String> values) {
			addCriterion("USER_PHOTO_MIN not in", values, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinBetween(String value1, String value2) {
			addCriterion("USER_PHOTO_MIN between", value1, value2, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andUserPhotoMinNotBetween(String value1, String value2) {
			addCriterion("USER_PHOTO_MIN not between", value1, value2, "userPhotoMin");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeIsNull() {
			addCriterion("VERTIFY_CODE is null");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeIsNotNull() {
			addCriterion("VERTIFY_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeEqualTo(String value) {
			addCriterion("VERTIFY_CODE =", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeNotEqualTo(String value) {
			addCriterion("VERTIFY_CODE <>", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeGreaterThan(String value) {
			addCriterion("VERTIFY_CODE >", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeGreaterThanOrEqualTo(String value) {
			addCriterion("VERTIFY_CODE >=", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeLessThan(String value) {
			addCriterion("VERTIFY_CODE <", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeLessThanOrEqualTo(String value) {
			addCriterion("VERTIFY_CODE <=", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeLike(String value) {
			addCriterion("VERTIFY_CODE like", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeNotLike(String value) {
			addCriterion("VERTIFY_CODE not like", value, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeIn(List<String> values) {
			addCriterion("VERTIFY_CODE in", values, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeNotIn(List<String> values) {
			addCriterion("VERTIFY_CODE not in", values, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeBetween(String value1, String value2) {
			addCriterion("VERTIFY_CODE between", value1, value2, "vertifyCode");
			return (Criteria) this;
		}

		public Criteria andVertifyCodeNotBetween(String value1, String value2) {
			addCriterion("VERTIFY_CODE not between", value1, value2, "vertifyCode");
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

		public Criteria andUserCodeIsNull() {
			addCriterion("USER_CODE is null");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNotNull() {
			addCriterion("USER_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andUserCodeEqualTo(String value) {
			addCriterion("USER_CODE =", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotEqualTo(String value) {
			addCriterion("USER_CODE <>", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThan(String value) {
			addCriterion("USER_CODE >", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
			addCriterion("USER_CODE >=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThan(String value) {
			addCriterion("USER_CODE <", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThanOrEqualTo(String value) {
			addCriterion("USER_CODE <=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLike(String value) {
			addCriterion("USER_CODE like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotLike(String value) {
			addCriterion("USER_CODE not like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeIn(List<String> values) {
			addCriterion("USER_CODE in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotIn(List<String> values) {
			addCriterion("USER_CODE not in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeBetween(String value1, String value2) {
			addCriterion("USER_CODE between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotBetween(String value1, String value2) {
			addCriterion("USER_CODE not between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneIsNull() {
			addCriterion("YOUJIA_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneIsNotNull() {
			addCriterion("YOUJIA_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneEqualTo(String value) {
			addCriterion("YOUJIA_PHONE =", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneNotEqualTo(String value) {
			addCriterion("YOUJIA_PHONE <>", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneGreaterThan(String value) {
			addCriterion("YOUJIA_PHONE >", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("YOUJIA_PHONE >=", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneLessThan(String value) {
			addCriterion("YOUJIA_PHONE <", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneLessThanOrEqualTo(String value) {
			addCriterion("YOUJIA_PHONE <=", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneLike(String value) {
			addCriterion("YOUJIA_PHONE like", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneNotLike(String value) {
			addCriterion("YOUJIA_PHONE not like", value, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneIn(List<String> values) {
			addCriterion("YOUJIA_PHONE in", values, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneNotIn(List<String> values) {
			addCriterion("YOUJIA_PHONE not in", values, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneBetween(String value1, String value2) {
			addCriterion("YOUJIA_PHONE between", value1, value2, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andYoujiaPhoneNotBetween(String value1, String value2) {
			addCriterion("YOUJIA_PHONE not between", value1, value2, "youjiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneIsNull() {
			addCriterion("USE_YOUJIA_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneIsNotNull() {
			addCriterion("USE_YOUJIA_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneEqualTo(Byte value) {
			addCriterion("USE_YOUJIA_PHONE =", value, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneNotEqualTo(Byte value) {
			addCriterion("USE_YOUJIA_PHONE <>", value, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneGreaterThan(Byte value) {
			addCriterion("USE_YOUJIA_PHONE >", value, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneGreaterThanOrEqualTo(Byte value) {
			addCriterion("USE_YOUJIA_PHONE >=", value, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneLessThan(Byte value) {
			addCriterion("USE_YOUJIA_PHONE <", value, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneLessThanOrEqualTo(Byte value) {
			addCriterion("USE_YOUJIA_PHONE <=", value, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneIn(List<Byte> values) {
			addCriterion("USE_YOUJIA_PHONE in", values, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneNotIn(List<Byte> values) {
			addCriterion("USE_YOUJIA_PHONE not in", values, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneBetween(Byte value1, Byte value2) {
			addCriterion("USE_YOUJIA_PHONE between", value1, value2, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andUseYoujiaPhoneNotBetween(Byte value1, Byte value2) {
			addCriterion("USE_YOUJIA_PHONE not between", value1, value2, "useYoujiaPhone");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminIsNull() {
			addCriterion("DEVELOPER_ADMIN is null");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminIsNotNull() {
			addCriterion("DEVELOPER_ADMIN is not null");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminEqualTo(Byte value) {
			addCriterion("DEVELOPER_ADMIN =", value, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminNotEqualTo(Byte value) {
			addCriterion("DEVELOPER_ADMIN <>", value, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminGreaterThan(Byte value) {
			addCriterion("DEVELOPER_ADMIN >", value, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEVELOPER_ADMIN >=", value, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminLessThan(Byte value) {
			addCriterion("DEVELOPER_ADMIN <", value, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminLessThanOrEqualTo(Byte value) {
			addCriterion("DEVELOPER_ADMIN <=", value, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminIn(List<Byte> values) {
			addCriterion("DEVELOPER_ADMIN in", values, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminNotIn(List<Byte> values) {
			addCriterion("DEVELOPER_ADMIN not in", values, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminBetween(Byte value1, Byte value2) {
			addCriterion("DEVELOPER_ADMIN between", value1, value2, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andDeveloperAdminNotBetween(Byte value1, Byte value2) {
			addCriterion("DEVELOPER_ADMIN not between", value1, value2, "developerAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminIsNull() {
			addCriterion("TOPBUILDING_ADMIN is null");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminIsNotNull() {
			addCriterion("TOPBUILDING_ADMIN is not null");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminEqualTo(Byte value) {
			addCriterion("TOPBUILDING_ADMIN =", value, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminNotEqualTo(Byte value) {
			addCriterion("TOPBUILDING_ADMIN <>", value, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminGreaterThan(Byte value) {
			addCriterion("TOPBUILDING_ADMIN >", value, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminGreaterThanOrEqualTo(Byte value) {
			addCriterion("TOPBUILDING_ADMIN >=", value, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminLessThan(Byte value) {
			addCriterion("TOPBUILDING_ADMIN <", value, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminLessThanOrEqualTo(Byte value) {
			addCriterion("TOPBUILDING_ADMIN <=", value, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminIn(List<Byte> values) {
			addCriterion("TOPBUILDING_ADMIN in", values, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminNotIn(List<Byte> values) {
			addCriterion("TOPBUILDING_ADMIN not in", values, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminBetween(Byte value1, Byte value2) {
			addCriterion("TOPBUILDING_ADMIN between", value1, value2, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andTopbuildingAdminNotBetween(Byte value1, Byte value2) {
			addCriterion("TOPBUILDING_ADMIN not between", value1, value2, "topbuildingAdmin");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsIsNull() {
			addCriterion("PERSONNEL_LEVELS is null");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsIsNotNull() {
			addCriterion("PERSONNEL_LEVELS is not null");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsEqualTo(String value) {
			addCriterion("PERSONNEL_LEVELS =", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsNotEqualTo(String value) {
			addCriterion("PERSONNEL_LEVELS <>", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsGreaterThan(String value) {
			addCriterion("PERSONNEL_LEVELS >", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsGreaterThanOrEqualTo(String value) {
			addCriterion("PERSONNEL_LEVELS >=", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsLessThan(String value) {
			addCriterion("PERSONNEL_LEVELS <", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsLessThanOrEqualTo(String value) {
			addCriterion("PERSONNEL_LEVELS <=", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsLike(String value) {
			addCriterion("PERSONNEL_LEVELS like", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsNotLike(String value) {
			addCriterion("PERSONNEL_LEVELS not like", value, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsIn(List<String> values) {
			addCriterion("PERSONNEL_LEVELS in", values, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsNotIn(List<String> values) {
			addCriterion("PERSONNEL_LEVELS not in", values, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsBetween(String value1, String value2) {
			addCriterion("PERSONNEL_LEVELS between", value1, value2, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andPersonnelLevelsNotBetween(String value1, String value2) {
			addCriterion("PERSONNEL_LEVELS not between", value1, value2, "personnelLevels");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelIsNull() {
			addCriterion("RECRUITMENT_CHANNEL is null");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelIsNotNull() {
			addCriterion("RECRUITMENT_CHANNEL is not null");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelEqualTo(String value) {
			addCriterion("RECRUITMENT_CHANNEL =", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelNotEqualTo(String value) {
			addCriterion("RECRUITMENT_CHANNEL <>", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelGreaterThan(String value) {
			addCriterion("RECRUITMENT_CHANNEL >", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelGreaterThanOrEqualTo(String value) {
			addCriterion("RECRUITMENT_CHANNEL >=", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelLessThan(String value) {
			addCriterion("RECRUITMENT_CHANNEL <", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelLessThanOrEqualTo(String value) {
			addCriterion("RECRUITMENT_CHANNEL <=", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelLike(String value) {
			addCriterion("RECRUITMENT_CHANNEL like", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelNotLike(String value) {
			addCriterion("RECRUITMENT_CHANNEL not like", value, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelIn(List<String> values) {
			addCriterion("RECRUITMENT_CHANNEL in", values, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelNotIn(List<String> values) {
			addCriterion("RECRUITMENT_CHANNEL not in", values, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelBetween(String value1, String value2) {
			addCriterion("RECRUITMENT_CHANNEL between", value1, value2, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andRecruitmentChannelNotBetween(String value1, String value2) {
			addCriterion("RECRUITMENT_CHANNEL not between", value1, value2, "recruitmentChannel");
			return (Criteria) this;
		}

		public Criteria andLevelsIdIsNull() {
			addCriterion("LEVELS_ID is null");
			return (Criteria) this;
		}

		public Criteria andLevelsIdIsNotNull() {
			addCriterion("LEVELS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLevelsIdEqualTo(Integer value) {
			addCriterion("LEVELS_ID =", value, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdNotEqualTo(Integer value) {
			addCriterion("LEVELS_ID <>", value, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdGreaterThan(Integer value) {
			addCriterion("LEVELS_ID >", value, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEVELS_ID >=", value, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdLessThan(Integer value) {
			addCriterion("LEVELS_ID <", value, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdLessThanOrEqualTo(Integer value) {
			addCriterion("LEVELS_ID <=", value, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdIn(List<Integer> values) {
			addCriterion("LEVELS_ID in", values, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdNotIn(List<Integer> values) {
			addCriterion("LEVELS_ID not in", values, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdBetween(Integer value1, Integer value2) {
			addCriterion("LEVELS_ID between", value1, value2, "levelsId");
			return (Criteria) this;
		}

		public Criteria andLevelsIdNotBetween(Integer value1, Integer value2) {
			addCriterion("LEVELS_ID not between", value1, value2, "levelsId");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNull() {
			addCriterion("CHANNEL_ID is null");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNotNull() {
			addCriterion("CHANNEL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andChannelIdEqualTo(Integer value) {
			addCriterion("CHANNEL_ID =", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotEqualTo(Integer value) {
			addCriterion("CHANNEL_ID <>", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThan(Integer value) {
			addCriterion("CHANNEL_ID >", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CHANNEL_ID >=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThan(Integer value) {
			addCriterion("CHANNEL_ID <", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
			addCriterion("CHANNEL_ID <=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdIn(List<Integer> values) {
			addCriterion("CHANNEL_ID in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotIn(List<Integer> values) {
			addCriterion("CHANNEL_ID not in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdBetween(Integer value1, Integer value2) {
			addCriterion("CHANNEL_ID between", value1, value2, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CHANNEL_ID not between", value1, value2, "channelId");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeIsNull() {
			addCriterion("WRITEOFF_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeIsNotNull() {
			addCriterion("WRITEOFF_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeEqualTo(Byte value) {
			addCriterion("WRITEOFF_TYPE =", value, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeNotEqualTo(Byte value) {
			addCriterion("WRITEOFF_TYPE <>", value, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeGreaterThan(Byte value) {
			addCriterion("WRITEOFF_TYPE >", value, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("WRITEOFF_TYPE >=", value, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeLessThan(Byte value) {
			addCriterion("WRITEOFF_TYPE <", value, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeLessThanOrEqualTo(Byte value) {
			addCriterion("WRITEOFF_TYPE <=", value, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeIn(List<Byte> values) {
			addCriterion("WRITEOFF_TYPE in", values, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeNotIn(List<Byte> values) {
			addCriterion("WRITEOFF_TYPE not in", values, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeBetween(Byte value1, Byte value2) {
			addCriterion("WRITEOFF_TYPE between", value1, value2, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andWriteoffTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("WRITEOFF_TYPE not between", value1, value2, "writeoffType");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagIsNull() {
			addCriterion("APARTMENT_USE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagIsNotNull() {
			addCriterion("APARTMENT_USE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagEqualTo(Byte value) {
			addCriterion("APARTMENT_USE_FLAG =", value, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagNotEqualTo(Byte value) {
			addCriterion("APARTMENT_USE_FLAG <>", value, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagGreaterThan(Byte value) {
			addCriterion("APARTMENT_USE_FLAG >", value, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("APARTMENT_USE_FLAG >=", value, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagLessThan(Byte value) {
			addCriterion("APARTMENT_USE_FLAG <", value, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagLessThanOrEqualTo(Byte value) {
			addCriterion("APARTMENT_USE_FLAG <=", value, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagIn(List<Byte> values) {
			addCriterion("APARTMENT_USE_FLAG in", values, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagNotIn(List<Byte> values) {
			addCriterion("APARTMENT_USE_FLAG not in", values, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagBetween(Byte value1, Byte value2) {
			addCriterion("APARTMENT_USE_FLAG between", value1, value2, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andApartmentUseFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("APARTMENT_USE_FLAG not between", value1, value2, "apartmentUseFlag");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerIsNull() {
			addCriterion("SALARY_PLAN_MANAGER is null");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerIsNotNull() {
			addCriterion("SALARY_PLAN_MANAGER is not null");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerEqualTo(Byte value) {
			addCriterion("SALARY_PLAN_MANAGER =", value, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerNotEqualTo(Byte value) {
			addCriterion("SALARY_PLAN_MANAGER <>", value, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerGreaterThan(Byte value) {
			addCriterion("SALARY_PLAN_MANAGER >", value, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALARY_PLAN_MANAGER >=", value, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerLessThan(Byte value) {
			addCriterion("SALARY_PLAN_MANAGER <", value, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerLessThanOrEqualTo(Byte value) {
			addCriterion("SALARY_PLAN_MANAGER <=", value, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerIn(List<Byte> values) {
			addCriterion("SALARY_PLAN_MANAGER in", values, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerNotIn(List<Byte> values) {
			addCriterion("SALARY_PLAN_MANAGER not in", values, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerBetween(Byte value1, Byte value2) {
			addCriterion("SALARY_PLAN_MANAGER between", value1, value2, "salaryPlanManager");
			return (Criteria) this;
		}

		public Criteria andSalaryPlanManagerNotBetween(Byte value1, Byte value2) {
			addCriterion("SALARY_PLAN_MANAGER not between", value1, value2, "salaryPlanManager");
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

		public Criteria andJoinDeptTimeIsNull() {
			addCriterion("JOIN_DEPT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeIsNotNull() {
			addCriterion("JOIN_DEPT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeEqualTo(Date value) {
			addCriterion("JOIN_DEPT_TIME =", value, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeNotEqualTo(Date value) {
			addCriterion("JOIN_DEPT_TIME <>", value, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeGreaterThan(Date value) {
			addCriterion("JOIN_DEPT_TIME >", value, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("JOIN_DEPT_TIME >=", value, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeLessThan(Date value) {
			addCriterion("JOIN_DEPT_TIME <", value, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeLessThanOrEqualTo(Date value) {
			addCriterion("JOIN_DEPT_TIME <=", value, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeIn(List<Date> values) {
			addCriterion("JOIN_DEPT_TIME in", values, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeNotIn(List<Date> values) {
			addCriterion("JOIN_DEPT_TIME not in", values, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeBetween(Date value1, Date value2) {
			addCriterion("JOIN_DEPT_TIME between", value1, value2, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andJoinDeptTimeNotBetween(Date value1, Date value2) {
			addCriterion("JOIN_DEPT_TIME not between", value1, value2, "joinDeptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeIsNull() {
			addCriterion("PROMPT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPromptTimeIsNotNull() {
			addCriterion("PROMPT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPromptTimeEqualTo(Date value) {
			addCriterion("PROMPT_TIME =", value, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeNotEqualTo(Date value) {
			addCriterion("PROMPT_TIME <>", value, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeGreaterThan(Date value) {
			addCriterion("PROMPT_TIME >", value, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PROMPT_TIME >=", value, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeLessThan(Date value) {
			addCriterion("PROMPT_TIME <", value, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeLessThanOrEqualTo(Date value) {
			addCriterion("PROMPT_TIME <=", value, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeIn(List<Date> values) {
			addCriterion("PROMPT_TIME in", values, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeNotIn(List<Date> values) {
			addCriterion("PROMPT_TIME not in", values, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeBetween(Date value1, Date value2) {
			addCriterion("PROMPT_TIME between", value1, value2, "promptTime");
			return (Criteria) this;
		}

		public Criteria andPromptTimeNotBetween(Date value1, Date value2) {
			addCriterion("PROMPT_TIME not between", value1, value2, "promptTime");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerIsNull() {
			addCriterion("BESPOKE_MANAGER is null");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerIsNotNull() {
			addCriterion("BESPOKE_MANAGER is not null");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerEqualTo(Byte value) {
			addCriterion("BESPOKE_MANAGER =", value, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerNotEqualTo(Byte value) {
			addCriterion("BESPOKE_MANAGER <>", value, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerGreaterThan(Byte value) {
			addCriterion("BESPOKE_MANAGER >", value, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerGreaterThanOrEqualTo(Byte value) {
			addCriterion("BESPOKE_MANAGER >=", value, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerLessThan(Byte value) {
			addCriterion("BESPOKE_MANAGER <", value, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerLessThanOrEqualTo(Byte value) {
			addCriterion("BESPOKE_MANAGER <=", value, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerIn(List<Byte> values) {
			addCriterion("BESPOKE_MANAGER in", values, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerNotIn(List<Byte> values) {
			addCriterion("BESPOKE_MANAGER not in", values, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerBetween(Byte value1, Byte value2) {
			addCriterion("BESPOKE_MANAGER between", value1, value2, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andBespokeManagerNotBetween(Byte value1, Byte value2) {
			addCriterion("BESPOKE_MANAGER not between", value1, value2, "bespokeManager");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderIsNull() {
			addCriterion("SUPER_LEADER is null");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderIsNotNull() {
			addCriterion("SUPER_LEADER is not null");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderEqualTo(Integer value) {
			addCriterion("SUPER_LEADER =", value, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderNotEqualTo(Integer value) {
			addCriterion("SUPER_LEADER <>", value, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderGreaterThan(Integer value) {
			addCriterion("SUPER_LEADER >", value, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderGreaterThanOrEqualTo(Integer value) {
			addCriterion("SUPER_LEADER >=", value, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderLessThan(Integer value) {
			addCriterion("SUPER_LEADER <", value, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderLessThanOrEqualTo(Integer value) {
			addCriterion("SUPER_LEADER <=", value, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderIn(List<Integer> values) {
			addCriterion("SUPER_LEADER in", values, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderNotIn(List<Integer> values) {
			addCriterion("SUPER_LEADER not in", values, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderBetween(Integer value1, Integer value2) {
			addCriterion("SUPER_LEADER between", value1, value2, "superLeader");
			return (Criteria) this;
		}

		public Criteria andSuperLeaderNotBetween(Integer value1, Integer value2) {
			addCriterion("SUPER_LEADER not between", value1, value2, "superLeader");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIsNull() {
			addCriterion("USER_PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIsNotNull() {
			addCriterion("USER_PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoEqualTo(String value) {
			addCriterion("USER_PHOTO =", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotEqualTo(String value) {
			addCriterion("USER_PHOTO <>", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoGreaterThan(String value) {
			addCriterion("USER_PHOTO >", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoGreaterThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO >=", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLessThan(String value) {
			addCriterion("USER_PHOTO <", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLessThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO <=", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLike(String value) {
			addCriterion("USER_PHOTO like", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotLike(String value) {
			addCriterion("USER_PHOTO not like", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIn(List<String> values) {
			addCriterion("USER_PHOTO in", values, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotIn(List<String> values) {
			addCriterion("USER_PHOTO not in", values, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoBetween(String value1, String value2) {
			addCriterion("USER_PHOTO between", value1, value2, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotBetween(String value1, String value2) {
			addCriterion("USER_PHOTO not between", value1, value2, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andExperienceUserIsNull() {
			addCriterion("EXPERIENCE_USER is null");
			return (Criteria) this;
		}

		public Criteria andExperienceUserIsNotNull() {
			addCriterion("EXPERIENCE_USER is not null");
			return (Criteria) this;
		}

		public Criteria andExperienceUserEqualTo(Byte value) {
			addCriterion("EXPERIENCE_USER =", value, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserNotEqualTo(Byte value) {
			addCriterion("EXPERIENCE_USER <>", value, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserGreaterThan(Byte value) {
			addCriterion("EXPERIENCE_USER >", value, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserGreaterThanOrEqualTo(Byte value) {
			addCriterion("EXPERIENCE_USER >=", value, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserLessThan(Byte value) {
			addCriterion("EXPERIENCE_USER <", value, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserLessThanOrEqualTo(Byte value) {
			addCriterion("EXPERIENCE_USER <=", value, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserIn(List<Byte> values) {
			addCriterion("EXPERIENCE_USER in", values, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserNotIn(List<Byte> values) {
			addCriterion("EXPERIENCE_USER not in", values, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserBetween(Byte value1, Byte value2) {
			addCriterion("EXPERIENCE_USER between", value1, value2, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andExperienceUserNotBetween(Byte value1, Byte value2) {
			addCriterion("EXPERIENCE_USER not between", value1, value2, "experienceUser");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerIsNull() {
			addCriterion("PROPERTY_MANAGER is null");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerIsNotNull() {
			addCriterion("PROPERTY_MANAGER is not null");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerEqualTo(Byte value) {
			addCriterion("PROPERTY_MANAGER =", value, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerNotEqualTo(Byte value) {
			addCriterion("PROPERTY_MANAGER <>", value, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerGreaterThan(Byte value) {
			addCriterion("PROPERTY_MANAGER >", value, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerGreaterThanOrEqualTo(Byte value) {
			addCriterion("PROPERTY_MANAGER >=", value, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerLessThan(Byte value) {
			addCriterion("PROPERTY_MANAGER <", value, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerLessThanOrEqualTo(Byte value) {
			addCriterion("PROPERTY_MANAGER <=", value, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerIn(List<Byte> values) {
			addCriterion("PROPERTY_MANAGER in", values, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerNotIn(List<Byte> values) {
			addCriterion("PROPERTY_MANAGER not in", values, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerBetween(Byte value1, Byte value2) {
			addCriterion("PROPERTY_MANAGER between", value1, value2, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andPropertyManagerNotBetween(Byte value1, Byte value2) {
			addCriterion("PROPERTY_MANAGER not between", value1, value2, "propertyManager");
			return (Criteria) this;
		}

		public Criteria andUserSourceIsNull() {
			addCriterion("USER_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andUserSourceIsNotNull() {
			addCriterion("USER_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andUserSourceEqualTo(Byte value) {
			addCriterion("USER_SOURCE =", value, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceNotEqualTo(Byte value) {
			addCriterion("USER_SOURCE <>", value, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceGreaterThan(Byte value) {
			addCriterion("USER_SOURCE >", value, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("USER_SOURCE >=", value, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceLessThan(Byte value) {
			addCriterion("USER_SOURCE <", value, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceLessThanOrEqualTo(Byte value) {
			addCriterion("USER_SOURCE <=", value, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceIn(List<Byte> values) {
			addCriterion("USER_SOURCE in", values, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceNotIn(List<Byte> values) {
			addCriterion("USER_SOURCE not in", values, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceBetween(Byte value1, Byte value2) {
			addCriterion("USER_SOURCE between", value1, value2, "userSource");
			return (Criteria) this;
		}

		public Criteria andUserSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("USER_SOURCE not between", value1, value2, "userSource");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdIsNull() {
			addCriterion("ROLE_LEVEL_ID is null");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdIsNotNull() {
			addCriterion("ROLE_LEVEL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdEqualTo(Integer value) {
			addCriterion("ROLE_LEVEL_ID =", value, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdNotEqualTo(Integer value) {
			addCriterion("ROLE_LEVEL_ID <>", value, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdGreaterThan(Integer value) {
			addCriterion("ROLE_LEVEL_ID >", value, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ROLE_LEVEL_ID >=", value, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdLessThan(Integer value) {
			addCriterion("ROLE_LEVEL_ID <", value, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdLessThanOrEqualTo(Integer value) {
			addCriterion("ROLE_LEVEL_ID <=", value, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdIn(List<Integer> values) {
			addCriterion("ROLE_LEVEL_ID in", values, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdNotIn(List<Integer> values) {
			addCriterion("ROLE_LEVEL_ID not in", values, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdBetween(Integer value1, Integer value2) {
			addCriterion("ROLE_LEVEL_ID between", value1, value2, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andRoleLevelIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ROLE_LEVEL_ID not between", value1, value2, "roleLevelId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdIsNull() {
			addCriterion("INVITE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdIsNotNull() {
			addCriterion("INVITE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID =", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdNotEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID <>", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdGreaterThan(Integer value) {
			addCriterion("INVITE_USER_ID >", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID >=", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdLessThan(Integer value) {
			addCriterion("INVITE_USER_ID <", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID <=", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdIn(List<Integer> values) {
			addCriterion("INVITE_USER_ID in", values, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdNotIn(List<Integer> values) {
			addCriterion("INVITE_USER_ID not in", values, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdBetween(Integer value1, Integer value2) {
			addCriterion("INVITE_USER_ID between", value1, value2, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("INVITE_USER_ID not between", value1, value2, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdIsNull() {
			addCriterion("CURRENT_P_ID is null");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdIsNotNull() {
			addCriterion("CURRENT_P_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdEqualTo(Integer value) {
			addCriterion("CURRENT_P_ID =", value, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdNotEqualTo(Integer value) {
			addCriterion("CURRENT_P_ID <>", value, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdGreaterThan(Integer value) {
			addCriterion("CURRENT_P_ID >", value, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CURRENT_P_ID >=", value, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdLessThan(Integer value) {
			addCriterion("CURRENT_P_ID <", value, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdLessThanOrEqualTo(Integer value) {
			addCriterion("CURRENT_P_ID <=", value, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdIn(List<Integer> values) {
			addCriterion("CURRENT_P_ID in", values, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdNotIn(List<Integer> values) {
			addCriterion("CURRENT_P_ID not in", values, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdBetween(Integer value1, Integer value2) {
			addCriterion("CURRENT_P_ID between", value1, value2, "currentPId");
			return (Criteria) this;
		}

		public Criteria andCurrentPIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CURRENT_P_ID not between", value1, value2, "currentPId");
			return (Criteria) this;
		}

		public Criteria andTissueLineIsNull() {
			addCriterion("TISSUE_LINE is null");
			return (Criteria) this;
		}

		public Criteria andTissueLineIsNotNull() {
			addCriterion("TISSUE_LINE is not null");
			return (Criteria) this;
		}

		public Criteria andTissueLineEqualTo(String value) {
			addCriterion("TISSUE_LINE =", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineNotEqualTo(String value) {
			addCriterion("TISSUE_LINE <>", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineGreaterThan(String value) {
			addCriterion("TISSUE_LINE >", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineGreaterThanOrEqualTo(String value) {
			addCriterion("TISSUE_LINE >=", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineLessThan(String value) {
			addCriterion("TISSUE_LINE <", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineLessThanOrEqualTo(String value) {
			addCriterion("TISSUE_LINE <=", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineLike(String value) {
			addCriterion("TISSUE_LINE like", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineNotLike(String value) {
			addCriterion("TISSUE_LINE not like", value, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineIn(List<String> values) {
			addCriterion("TISSUE_LINE in", values, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineNotIn(List<String> values) {
			addCriterion("TISSUE_LINE not in", values, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineBetween(String value1, String value2) {
			addCriterion("TISSUE_LINE between", value1, value2, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andTissueLineNotBetween(String value1, String value2) {
			addCriterion("TISSUE_LINE not between", value1, value2, "tissueLine");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeIsNull() {
			addCriterion("D_ASSESSMENT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeIsNotNull() {
			addCriterion("D_ASSESSMENT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeEqualTo(Date value) {
			addCriterion("D_ASSESSMENT_TIME =", value, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeNotEqualTo(Date value) {
			addCriterion("D_ASSESSMENT_TIME <>", value, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeGreaterThan(Date value) {
			addCriterion("D_ASSESSMENT_TIME >", value, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("D_ASSESSMENT_TIME >=", value, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeLessThan(Date value) {
			addCriterion("D_ASSESSMENT_TIME <", value, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeLessThanOrEqualTo(Date value) {
			addCriterion("D_ASSESSMENT_TIME <=", value, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeIn(List<Date> values) {
			addCriterion("D_ASSESSMENT_TIME in", values, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeNotIn(List<Date> values) {
			addCriterion("D_ASSESSMENT_TIME not in", values, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeBetween(Date value1, Date value2) {
			addCriterion("D_ASSESSMENT_TIME between", value1, value2, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentTimeNotBetween(Date value1, Date value2) {
			addCriterion("D_ASSESSMENT_TIME not between", value1, value2, "dAssessmentTime");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagIsNull() {
			addCriterion("D_ASSESSMENT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagIsNotNull() {
			addCriterion("D_ASSESSMENT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagEqualTo(Byte value) {
			addCriterion("D_ASSESSMENT_FLAG =", value, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagNotEqualTo(Byte value) {
			addCriterion("D_ASSESSMENT_FLAG <>", value, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagGreaterThan(Byte value) {
			addCriterion("D_ASSESSMENT_FLAG >", value, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("D_ASSESSMENT_FLAG >=", value, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagLessThan(Byte value) {
			addCriterion("D_ASSESSMENT_FLAG <", value, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagLessThanOrEqualTo(Byte value) {
			addCriterion("D_ASSESSMENT_FLAG <=", value, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagIn(List<Byte> values) {
			addCriterion("D_ASSESSMENT_FLAG in", values, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagNotIn(List<Byte> values) {
			addCriterion("D_ASSESSMENT_FLAG not in", values, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagBetween(Byte value1, Byte value2) {
			addCriterion("D_ASSESSMENT_FLAG between", value1, value2, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andDAssessmentFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("D_ASSESSMENT_FLAG not between", value1, value2, "dAssessmentFlag");
			return (Criteria) this;
		}

		public Criteria andUserLevelIsNull() {
			addCriterion("USER_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andUserLevelIsNotNull() {
			addCriterion("USER_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andUserLevelEqualTo(Integer value) {
			addCriterion("USER_LEVEL =", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotEqualTo(Integer value) {
			addCriterion("USER_LEVEL <>", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelGreaterThan(Integer value) {
			addCriterion("USER_LEVEL >", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_LEVEL >=", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelLessThan(Integer value) {
			addCriterion("USER_LEVEL <", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelLessThanOrEqualTo(Integer value) {
			addCriterion("USER_LEVEL <=", value, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelIn(List<Integer> values) {
			addCriterion("USER_LEVEL in", values, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotIn(List<Integer> values) {
			addCriterion("USER_LEVEL not in", values, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelBetween(Integer value1, Integer value2) {
			addCriterion("USER_LEVEL between", value1, value2, "userLevel");
			return (Criteria) this;
		}

		public Criteria andUserLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_LEVEL not between", value1, value2, "userLevel");
			return (Criteria) this;
		}

		public Criteria andWorkYearIsNull() {
			addCriterion("WORK_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andWorkYearIsNotNull() {
			addCriterion("WORK_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andWorkYearEqualTo(BigDecimal value) {
			addCriterion("WORK_YEAR =", value, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearNotEqualTo(BigDecimal value) {
			addCriterion("WORK_YEAR <>", value, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearGreaterThan(BigDecimal value) {
			addCriterion("WORK_YEAR >", value, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("WORK_YEAR >=", value, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearLessThan(BigDecimal value) {
			addCriterion("WORK_YEAR <", value, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearLessThanOrEqualTo(BigDecimal value) {
			addCriterion("WORK_YEAR <=", value, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearIn(List<BigDecimal> values) {
			addCriterion("WORK_YEAR in", values, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearNotIn(List<BigDecimal> values) {
			addCriterion("WORK_YEAR not in", values, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WORK_YEAR between", value1, value2, "workYear");
			return (Criteria) this;
		}

		public Criteria andWorkYearNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WORK_YEAR not between", value1, value2, "workYear");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactIsNull() {
			addCriterion("EMERGENCY_CONTACT is null");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactIsNotNull() {
			addCriterion("EMERGENCY_CONTACT is not null");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactEqualTo(String value) {
			addCriterion("EMERGENCY_CONTACT =", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactNotEqualTo(String value) {
			addCriterion("EMERGENCY_CONTACT <>", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactGreaterThan(String value) {
			addCriterion("EMERGENCY_CONTACT >", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactGreaterThanOrEqualTo(String value) {
			addCriterion("EMERGENCY_CONTACT >=", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactLessThan(String value) {
			addCriterion("EMERGENCY_CONTACT <", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactLessThanOrEqualTo(String value) {
			addCriterion("EMERGENCY_CONTACT <=", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactLike(String value) {
			addCriterion("EMERGENCY_CONTACT like", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactNotLike(String value) {
			addCriterion("EMERGENCY_CONTACT not like", value, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactIn(List<String> values) {
			addCriterion("EMERGENCY_CONTACT in", values, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactNotIn(List<String> values) {
			addCriterion("EMERGENCY_CONTACT not in", values, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactBetween(String value1, String value2) {
			addCriterion("EMERGENCY_CONTACT between", value1, value2, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andEmergencyContactNotBetween(String value1, String value2) {
			addCriterion("EMERGENCY_CONTACT not between", value1, value2, "emergencyContact");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberIsNull() {
			addCriterion("USER_TEAM_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberIsNotNull() {
			addCriterion("USER_TEAM_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberEqualTo(Integer value) {
			addCriterion("USER_TEAM_NUMBER =", value, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberNotEqualTo(Integer value) {
			addCriterion("USER_TEAM_NUMBER <>", value, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberGreaterThan(Integer value) {
			addCriterion("USER_TEAM_NUMBER >", value, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_TEAM_NUMBER >=", value, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberLessThan(Integer value) {
			addCriterion("USER_TEAM_NUMBER <", value, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberLessThanOrEqualTo(Integer value) {
			addCriterion("USER_TEAM_NUMBER <=", value, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberIn(List<Integer> values) {
			addCriterion("USER_TEAM_NUMBER in", values, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberNotIn(List<Integer> values) {
			addCriterion("USER_TEAM_NUMBER not in", values, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberBetween(Integer value1, Integer value2) {
			addCriterion("USER_TEAM_NUMBER between", value1, value2, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andUserTeamNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_TEAM_NUMBER not between", value1, value2, "userTeamNumber");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIsNull() {
			addCriterion("PARTNER_ID is null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIsNotNull() {
			addCriterion("PARTNER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdEqualTo(Integer value) {
			addCriterion("PARTNER_ID =", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotEqualTo(Integer value) {
			addCriterion("PARTNER_ID <>", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThan(Integer value) {
			addCriterion("PARTNER_ID >", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID >=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThan(Integer value) {
			addCriterion("PARTNER_ID <", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID <=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIn(List<Integer> values) {
			addCriterion("PARTNER_ID in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotIn(List<Integer> values) {
			addCriterion("PARTNER_ID not in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID between", value1, value2, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID not between", value1, value2, "partnerId");
			return (Criteria) this;
		}

		public Criteria andOrg1IsNull() {
			addCriterion("ORG_1 is null");
			return (Criteria) this;
		}

		public Criteria andOrg1IsNotNull() {
			addCriterion("ORG_1 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg1EqualTo(Integer value) {
			addCriterion("ORG_1 =", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1NotEqualTo(Integer value) {
			addCriterion("ORG_1 <>", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1GreaterThan(Integer value) {
			addCriterion("ORG_1 >", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_1 >=", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1LessThan(Integer value) {
			addCriterion("ORG_1 <", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_1 <=", value, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1In(List<Integer> values) {
			addCriterion("ORG_1 in", values, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1NotIn(List<Integer> values) {
			addCriterion("ORG_1 not in", values, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1Between(Integer value1, Integer value2) {
			addCriterion("ORG_1 between", value1, value2, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg1NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_1 not between", value1, value2, "org1");
			return (Criteria) this;
		}

		public Criteria andOrg2IsNull() {
			addCriterion("ORG_2 is null");
			return (Criteria) this;
		}

		public Criteria andOrg2IsNotNull() {
			addCriterion("ORG_2 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg2EqualTo(Integer value) {
			addCriterion("ORG_2 =", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2NotEqualTo(Integer value) {
			addCriterion("ORG_2 <>", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2GreaterThan(Integer value) {
			addCriterion("ORG_2 >", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_2 >=", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2LessThan(Integer value) {
			addCriterion("ORG_2 <", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_2 <=", value, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2In(List<Integer> values) {
			addCriterion("ORG_2 in", values, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2NotIn(List<Integer> values) {
			addCriterion("ORG_2 not in", values, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2Between(Integer value1, Integer value2) {
			addCriterion("ORG_2 between", value1, value2, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg2NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_2 not between", value1, value2, "org2");
			return (Criteria) this;
		}

		public Criteria andOrg3IsNull() {
			addCriterion("ORG_3 is null");
			return (Criteria) this;
		}

		public Criteria andOrg3IsNotNull() {
			addCriterion("ORG_3 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg3EqualTo(Integer value) {
			addCriterion("ORG_3 =", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3NotEqualTo(Integer value) {
			addCriterion("ORG_3 <>", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3GreaterThan(Integer value) {
			addCriterion("ORG_3 >", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_3 >=", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3LessThan(Integer value) {
			addCriterion("ORG_3 <", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_3 <=", value, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3In(List<Integer> values) {
			addCriterion("ORG_3 in", values, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3NotIn(List<Integer> values) {
			addCriterion("ORG_3 not in", values, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3Between(Integer value1, Integer value2) {
			addCriterion("ORG_3 between", value1, value2, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg3NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_3 not between", value1, value2, "org3");
			return (Criteria) this;
		}

		public Criteria andOrg4IsNull() {
			addCriterion("ORG_4 is null");
			return (Criteria) this;
		}

		public Criteria andOrg4IsNotNull() {
			addCriterion("ORG_4 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg4EqualTo(Integer value) {
			addCriterion("ORG_4 =", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4NotEqualTo(Integer value) {
			addCriterion("ORG_4 <>", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4GreaterThan(Integer value) {
			addCriterion("ORG_4 >", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_4 >=", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4LessThan(Integer value) {
			addCriterion("ORG_4 <", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_4 <=", value, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4In(List<Integer> values) {
			addCriterion("ORG_4 in", values, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4NotIn(List<Integer> values) {
			addCriterion("ORG_4 not in", values, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4Between(Integer value1, Integer value2) {
			addCriterion("ORG_4 between", value1, value2, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg4NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_4 not between", value1, value2, "org4");
			return (Criteria) this;
		}

		public Criteria andOrg5IsNull() {
			addCriterion("ORG_5 is null");
			return (Criteria) this;
		}

		public Criteria andOrg5IsNotNull() {
			addCriterion("ORG_5 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg5EqualTo(Integer value) {
			addCriterion("ORG_5 =", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5NotEqualTo(Integer value) {
			addCriterion("ORG_5 <>", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5GreaterThan(Integer value) {
			addCriterion("ORG_5 >", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_5 >=", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5LessThan(Integer value) {
			addCriterion("ORG_5 <", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_5 <=", value, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5In(List<Integer> values) {
			addCriterion("ORG_5 in", values, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5NotIn(List<Integer> values) {
			addCriterion("ORG_5 not in", values, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5Between(Integer value1, Integer value2) {
			addCriterion("ORG_5 between", value1, value2, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg5NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_5 not between", value1, value2, "org5");
			return (Criteria) this;
		}

		public Criteria andOrg6IsNull() {
			addCriterion("ORG_6 is null");
			return (Criteria) this;
		}

		public Criteria andOrg6IsNotNull() {
			addCriterion("ORG_6 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg6EqualTo(Integer value) {
			addCriterion("ORG_6 =", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6NotEqualTo(Integer value) {
			addCriterion("ORG_6 <>", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6GreaterThan(Integer value) {
			addCriterion("ORG_6 >", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_6 >=", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6LessThan(Integer value) {
			addCriterion("ORG_6 <", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_6 <=", value, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6In(List<Integer> values) {
			addCriterion("ORG_6 in", values, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6NotIn(List<Integer> values) {
			addCriterion("ORG_6 not in", values, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6Between(Integer value1, Integer value2) {
			addCriterion("ORG_6 between", value1, value2, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg6NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_6 not between", value1, value2, "org6");
			return (Criteria) this;
		}

		public Criteria andOrg7IsNull() {
			addCriterion("ORG_7 is null");
			return (Criteria) this;
		}

		public Criteria andOrg7IsNotNull() {
			addCriterion("ORG_7 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg7EqualTo(Integer value) {
			addCriterion("ORG_7 =", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7NotEqualTo(Integer value) {
			addCriterion("ORG_7 <>", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7GreaterThan(Integer value) {
			addCriterion("ORG_7 >", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_7 >=", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7LessThan(Integer value) {
			addCriterion("ORG_7 <", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_7 <=", value, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7In(List<Integer> values) {
			addCriterion("ORG_7 in", values, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7NotIn(List<Integer> values) {
			addCriterion("ORG_7 not in", values, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7Between(Integer value1, Integer value2) {
			addCriterion("ORG_7 between", value1, value2, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg7NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_7 not between", value1, value2, "org7");
			return (Criteria) this;
		}

		public Criteria andOrg8IsNull() {
			addCriterion("ORG_8 is null");
			return (Criteria) this;
		}

		public Criteria andOrg8IsNotNull() {
			addCriterion("ORG_8 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg8EqualTo(Integer value) {
			addCriterion("ORG_8 =", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8NotEqualTo(Integer value) {
			addCriterion("ORG_8 <>", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8GreaterThan(Integer value) {
			addCriterion("ORG_8 >", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_8 >=", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8LessThan(Integer value) {
			addCriterion("ORG_8 <", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_8 <=", value, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8In(List<Integer> values) {
			addCriterion("ORG_8 in", values, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8NotIn(List<Integer> values) {
			addCriterion("ORG_8 not in", values, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8Between(Integer value1, Integer value2) {
			addCriterion("ORG_8 between", value1, value2, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg8NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_8 not between", value1, value2, "org8");
			return (Criteria) this;
		}

		public Criteria andOrg9IsNull() {
			addCriterion("ORG_9 is null");
			return (Criteria) this;
		}

		public Criteria andOrg9IsNotNull() {
			addCriterion("ORG_9 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg9EqualTo(Integer value) {
			addCriterion("ORG_9 =", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9NotEqualTo(Integer value) {
			addCriterion("ORG_9 <>", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9GreaterThan(Integer value) {
			addCriterion("ORG_9 >", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_9 >=", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9LessThan(Integer value) {
			addCriterion("ORG_9 <", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_9 <=", value, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9In(List<Integer> values) {
			addCriterion("ORG_9 in", values, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9NotIn(List<Integer> values) {
			addCriterion("ORG_9 not in", values, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9Between(Integer value1, Integer value2) {
			addCriterion("ORG_9 between", value1, value2, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg9NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_9 not between", value1, value2, "org9");
			return (Criteria) this;
		}

		public Criteria andOrg10IsNull() {
			addCriterion("ORG_10 is null");
			return (Criteria) this;
		}

		public Criteria andOrg10IsNotNull() {
			addCriterion("ORG_10 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg10EqualTo(Integer value) {
			addCriterion("ORG_10 =", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10NotEqualTo(Integer value) {
			addCriterion("ORG_10 <>", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10GreaterThan(Integer value) {
			addCriterion("ORG_10 >", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_10 >=", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10LessThan(Integer value) {
			addCriterion("ORG_10 <", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_10 <=", value, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10In(List<Integer> values) {
			addCriterion("ORG_10 in", values, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10NotIn(List<Integer> values) {
			addCriterion("ORG_10 not in", values, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10Between(Integer value1, Integer value2) {
			addCriterion("ORG_10 between", value1, value2, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg10NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_10 not between", value1, value2, "org10");
			return (Criteria) this;
		}

		public Criteria andOrg11IsNull() {
			addCriterion("ORG_11 is null");
			return (Criteria) this;
		}

		public Criteria andOrg11IsNotNull() {
			addCriterion("ORG_11 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg11EqualTo(Integer value) {
			addCriterion("ORG_11 =", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11NotEqualTo(Integer value) {
			addCriterion("ORG_11 <>", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11GreaterThan(Integer value) {
			addCriterion("ORG_11 >", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_11 >=", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11LessThan(Integer value) {
			addCriterion("ORG_11 <", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_11 <=", value, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11In(List<Integer> values) {
			addCriterion("ORG_11 in", values, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11NotIn(List<Integer> values) {
			addCriterion("ORG_11 not in", values, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11Between(Integer value1, Integer value2) {
			addCriterion("ORG_11 between", value1, value2, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg11NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_11 not between", value1, value2, "org11");
			return (Criteria) this;
		}

		public Criteria andOrg12IsNull() {
			addCriterion("ORG_12 is null");
			return (Criteria) this;
		}

		public Criteria andOrg12IsNotNull() {
			addCriterion("ORG_12 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg12EqualTo(Integer value) {
			addCriterion("ORG_12 =", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12NotEqualTo(Integer value) {
			addCriterion("ORG_12 <>", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12GreaterThan(Integer value) {
			addCriterion("ORG_12 >", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_12 >=", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12LessThan(Integer value) {
			addCriterion("ORG_12 <", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_12 <=", value, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12In(List<Integer> values) {
			addCriterion("ORG_12 in", values, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12NotIn(List<Integer> values) {
			addCriterion("ORG_12 not in", values, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12Between(Integer value1, Integer value2) {
			addCriterion("ORG_12 between", value1, value2, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg12NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_12 not between", value1, value2, "org12");
			return (Criteria) this;
		}

		public Criteria andOrg13IsNull() {
			addCriterion("ORG_13 is null");
			return (Criteria) this;
		}

		public Criteria andOrg13IsNotNull() {
			addCriterion("ORG_13 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg13EqualTo(Integer value) {
			addCriterion("ORG_13 =", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13NotEqualTo(Integer value) {
			addCriterion("ORG_13 <>", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13GreaterThan(Integer value) {
			addCriterion("ORG_13 >", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_13 >=", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13LessThan(Integer value) {
			addCriterion("ORG_13 <", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_13 <=", value, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13In(List<Integer> values) {
			addCriterion("ORG_13 in", values, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13NotIn(List<Integer> values) {
			addCriterion("ORG_13 not in", values, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13Between(Integer value1, Integer value2) {
			addCriterion("ORG_13 between", value1, value2, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg13NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_13 not between", value1, value2, "org13");
			return (Criteria) this;
		}

		public Criteria andOrg14IsNull() {
			addCriterion("ORG_14 is null");
			return (Criteria) this;
		}

		public Criteria andOrg14IsNotNull() {
			addCriterion("ORG_14 is not null");
			return (Criteria) this;
		}

		public Criteria andOrg14EqualTo(Integer value) {
			addCriterion("ORG_14 =", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14NotEqualTo(Integer value) {
			addCriterion("ORG_14 <>", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14GreaterThan(Integer value) {
			addCriterion("ORG_14 >", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14GreaterThanOrEqualTo(Integer value) {
			addCriterion("ORG_14 >=", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14LessThan(Integer value) {
			addCriterion("ORG_14 <", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14LessThanOrEqualTo(Integer value) {
			addCriterion("ORG_14 <=", value, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14In(List<Integer> values) {
			addCriterion("ORG_14 in", values, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14NotIn(List<Integer> values) {
			addCriterion("ORG_14 not in", values, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14Between(Integer value1, Integer value2) {
			addCriterion("ORG_14 between", value1, value2, "org14");
			return (Criteria) this;
		}

		public Criteria andOrg14NotBetween(Integer value1, Integer value2) {
			addCriterion("ORG_14 not between", value1, value2, "org14");
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

		public Criteria andServiceTypeIsNull() {
			addCriterion("SERVICE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andServiceTypeIsNotNull() {
			addCriterion("SERVICE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andServiceTypeEqualTo(String value) {
			addCriterion("SERVICE_TYPE =", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeNotEqualTo(String value) {
			addCriterion("SERVICE_TYPE <>", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeGreaterThan(String value) {
			addCriterion("SERVICE_TYPE >", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
			addCriterion("SERVICE_TYPE >=", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeLessThan(String value) {
			addCriterion("SERVICE_TYPE <", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeLessThanOrEqualTo(String value) {
			addCriterion("SERVICE_TYPE <=", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeLike(String value) {
			addCriterion("SERVICE_TYPE like", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeNotLike(String value) {
			addCriterion("SERVICE_TYPE not like", value, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeIn(List<String> values) {
			addCriterion("SERVICE_TYPE in", values, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeNotIn(List<String> values) {
			addCriterion("SERVICE_TYPE not in", values, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeBetween(String value1, String value2) {
			addCriterion("SERVICE_TYPE between", value1, value2, "serviceType");
			return (Criteria) this;
		}

		public Criteria andServiceTypeNotBetween(String value1, String value2) {
			addCriterion("SERVICE_TYPE not between", value1, value2, "serviceType");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameIsNull() {
			addCriterion("KNOW_GARDEN_NAME is null");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameIsNotNull() {
			addCriterion("KNOW_GARDEN_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameEqualTo(String value) {
			addCriterion("KNOW_GARDEN_NAME =", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameNotEqualTo(String value) {
			addCriterion("KNOW_GARDEN_NAME <>", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameGreaterThan(String value) {
			addCriterion("KNOW_GARDEN_NAME >", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameGreaterThanOrEqualTo(String value) {
			addCriterion("KNOW_GARDEN_NAME >=", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameLessThan(String value) {
			addCriterion("KNOW_GARDEN_NAME <", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameLessThanOrEqualTo(String value) {
			addCriterion("KNOW_GARDEN_NAME <=", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameLike(String value) {
			addCriterion("KNOW_GARDEN_NAME like", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameNotLike(String value) {
			addCriterion("KNOW_GARDEN_NAME not like", value, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameIn(List<String> values) {
			addCriterion("KNOW_GARDEN_NAME in", values, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameNotIn(List<String> values) {
			addCriterion("KNOW_GARDEN_NAME not in", values, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameBetween(String value1, String value2) {
			addCriterion("KNOW_GARDEN_NAME between", value1, value2, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andKnowGardenNameNotBetween(String value1, String value2) {
			addCriterion("KNOW_GARDEN_NAME not between", value1, value2, "knowGardenName");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("TITLE is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("TITLE is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("TITLE =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("TITLE <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("TITLE >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("TITLE >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("TITLE <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("TITLE <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("TITLE like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("TITLE not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("TITLE in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("TITLE not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("TITLE between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("TITLE not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameIsNull() {
			addCriterion("PROGRAMA_ITEM_NAME is null");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameIsNotNull() {
			addCriterion("PROGRAMA_ITEM_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameEqualTo(String value) {
			addCriterion("PROGRAMA_ITEM_NAME =", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameNotEqualTo(String value) {
			addCriterion("PROGRAMA_ITEM_NAME <>", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameGreaterThan(String value) {
			addCriterion("PROGRAMA_ITEM_NAME >", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameGreaterThanOrEqualTo(String value) {
			addCriterion("PROGRAMA_ITEM_NAME >=", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameLessThan(String value) {
			addCriterion("PROGRAMA_ITEM_NAME <", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameLessThanOrEqualTo(String value) {
			addCriterion("PROGRAMA_ITEM_NAME <=", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameLike(String value) {
			addCriterion("PROGRAMA_ITEM_NAME like", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameNotLike(String value) {
			addCriterion("PROGRAMA_ITEM_NAME not like", value, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameIn(List<String> values) {
			addCriterion("PROGRAMA_ITEM_NAME in", values, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameNotIn(List<String> values) {
			addCriterion("PROGRAMA_ITEM_NAME not in", values, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameBetween(String value1, String value2) {
			addCriterion("PROGRAMA_ITEM_NAME between", value1, value2, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andProgramaItemNameNotBetween(String value1, String value2) {
			addCriterion("PROGRAMA_ITEM_NAME not between", value1, value2, "programaItemName");
			return (Criteria) this;
		}

		public Criteria andIndexIsNull() {
			addCriterion("[INDEX] is null");
			return (Criteria) this;
		}

		public Criteria andIndexIsNotNull() {
			addCriterion("[INDEX] is not null");
			return (Criteria) this;
		}

		public Criteria andIndexEqualTo(Integer value) {
			addCriterion("[INDEX] =", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexNotEqualTo(Integer value) {
			addCriterion("[INDEX] <>", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexGreaterThan(Integer value) {
			addCriterion("[INDEX] >", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexGreaterThanOrEqualTo(Integer value) {
			addCriterion("[INDEX] >=", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexLessThan(Integer value) {
			addCriterion("[INDEX] <", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexLessThanOrEqualTo(Integer value) {
			addCriterion("[INDEX] <=", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexIn(List<Integer> values) {
			addCriterion("[INDEX] in", values, "index");
			return (Criteria) this;
		}

		public Criteria andIndexNotIn(List<Integer> values) {
			addCriterion("[INDEX] not in", values, "index");
			return (Criteria) this;
		}

		public Criteria andIndexBetween(Integer value1, Integer value2) {
			addCriterion("[INDEX] between", value1, value2, "index");
			return (Criteria) this;
		}

		public Criteria andIndexNotBetween(Integer value1, Integer value2) {
			addCriterion("[INDEX] not between", value1, value2, "index");
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

		public Criteria andBelongAddressIsNull() {
			addCriterion("BELONG_ADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andBelongAddressIsNotNull() {
			addCriterion("BELONG_ADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andBelongAddressEqualTo(String value) {
			addCriterion("BELONG_ADDRESS =", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressNotEqualTo(String value) {
			addCriterion("BELONG_ADDRESS <>", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressGreaterThan(String value) {
			addCriterion("BELONG_ADDRESS >", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressGreaterThanOrEqualTo(String value) {
			addCriterion("BELONG_ADDRESS >=", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressLessThan(String value) {
			addCriterion("BELONG_ADDRESS <", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressLessThanOrEqualTo(String value) {
			addCriterion("BELONG_ADDRESS <=", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressLike(String value) {
			addCriterion("BELONG_ADDRESS like", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressNotLike(String value) {
			addCriterion("BELONG_ADDRESS not like", value, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressIn(List<String> values) {
			addCriterion("BELONG_ADDRESS in", values, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressNotIn(List<String> values) {
			addCriterion("BELONG_ADDRESS not in", values, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressBetween(String value1, String value2) {
			addCriterion("BELONG_ADDRESS between", value1, value2, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andBelongAddressNotBetween(String value1, String value2) {
			addCriterion("BELONG_ADDRESS not between", value1, value2, "belongAddress");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountIsNull() {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountIsNotNull() {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountEqualTo(Integer value) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT =", value, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountNotEqualTo(Integer value) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT <>", value, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountGreaterThan(Integer value) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT >", value, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT >=", value, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountLessThan(Integer value) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT <", value, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountLessThanOrEqualTo(Integer value) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT <=", value, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountIn(List<Integer> values) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT in", values, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountNotIn(List<Integer> values) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT not in", values, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountBetween(Integer value1, Integer value2) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT between", value1, value2, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andLastThreeMonthBandSawCountNotBetween(Integer value1, Integer value2) {
			addCriterion("LAST_THREE_MONTH_BAND_SAW_COUNT not between", value1, value2, "lastThreeMonthBandSawCount");
			return (Criteria) this;
		}

		public Criteria andGardenNameIsNull() {
			addCriterion("GARDEN_NAME is null");
			return (Criteria) this;
		}

		public Criteria andGardenNameIsNotNull() {
			addCriterion("GARDEN_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andGardenNameEqualTo(String value) {
			addCriterion("GARDEN_NAME =", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameNotEqualTo(String value) {
			addCriterion("GARDEN_NAME <>", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameGreaterThan(String value) {
			addCriterion("GARDEN_NAME >", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameGreaterThanOrEqualTo(String value) {
			addCriterion("GARDEN_NAME >=", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameLessThan(String value) {
			addCriterion("GARDEN_NAME <", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameLessThanOrEqualTo(String value) {
			addCriterion("GARDEN_NAME <=", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameLike(String value) {
			addCriterion("GARDEN_NAME like", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameNotLike(String value) {
			addCriterion("GARDEN_NAME not like", value, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameIn(List<String> values) {
			addCriterion("GARDEN_NAME in", values, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameNotIn(List<String> values) {
			addCriterion("GARDEN_NAME not in", values, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameBetween(String value1, String value2) {
			addCriterion("GARDEN_NAME between", value1, value2, "gardenName");
			return (Criteria) this;
		}

		public Criteria andGardenNameNotBetween(String value1, String value2) {
			addCriterion("GARDEN_NAME not between", value1, value2, "gardenName");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagIsNull() {
			addCriterion("SYNC_HFT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagIsNotNull() {
			addCriterion("SYNC_HFT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagEqualTo(Integer value) {
			addCriterion("SYNC_HFT_FLAG =", value, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagNotEqualTo(Integer value) {
			addCriterion("SYNC_HFT_FLAG <>", value, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagGreaterThan(Integer value) {
			addCriterion("SYNC_HFT_FLAG >", value, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("SYNC_HFT_FLAG >=", value, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagLessThan(Integer value) {
			addCriterion("SYNC_HFT_FLAG <", value, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagLessThanOrEqualTo(Integer value) {
			addCriterion("SYNC_HFT_FLAG <=", value, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagIn(List<Integer> values) {
			addCriterion("SYNC_HFT_FLAG in", values, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagNotIn(List<Integer> values) {
			addCriterion("SYNC_HFT_FLAG not in", values, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagBetween(Integer value1, Integer value2) {
			addCriterion("SYNC_HFT_FLAG between", value1, value2, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andSyncHftFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("SYNC_HFT_FLAG not between", value1, value2, "syncHftFlag");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsIsNull() {
			addCriterion("KNOW_GARDEN_IDS is null");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsIsNotNull() {
			addCriterion("KNOW_GARDEN_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsEqualTo(String value) {
			addCriterion("KNOW_GARDEN_IDS =", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsNotEqualTo(String value) {
			addCriterion("KNOW_GARDEN_IDS <>", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsGreaterThan(String value) {
			addCriterion("KNOW_GARDEN_IDS >", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsGreaterThanOrEqualTo(String value) {
			addCriterion("KNOW_GARDEN_IDS >=", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsLessThan(String value) {
			addCriterion("KNOW_GARDEN_IDS <", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsLessThanOrEqualTo(String value) {
			addCriterion("KNOW_GARDEN_IDS <=", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsLike(String value) {
			addCriterion("KNOW_GARDEN_IDS like", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsNotLike(String value) {
			addCriterion("KNOW_GARDEN_IDS not like", value, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsIn(List<String> values) {
			addCriterion("KNOW_GARDEN_IDS in", values, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsNotIn(List<String> values) {
			addCriterion("KNOW_GARDEN_IDS not in", values, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsBetween(String value1, String value2) {
			addCriterion("KNOW_GARDEN_IDS between", value1, value2, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andKnowGardenIdsNotBetween(String value1, String value2) {
			addCriterion("KNOW_GARDEN_IDS not between", value1, value2, "knowGardenIds");
			return (Criteria) this;
		}

		public Criteria andUserIccodeIsNull() {
			addCriterion("USER_ICCODE is null");
			return (Criteria) this;
		}

		public Criteria andUserIccodeIsNotNull() {
			addCriterion("USER_ICCODE is not null");
			return (Criteria) this;
		}

		public Criteria andUserIccodeEqualTo(String value) {
			addCriterion("USER_ICCODE =", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeNotEqualTo(String value) {
			addCriterion("USER_ICCODE <>", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeGreaterThan(String value) {
			addCriterion("USER_ICCODE >", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeGreaterThanOrEqualTo(String value) {
			addCriterion("USER_ICCODE >=", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeLessThan(String value) {
			addCriterion("USER_ICCODE <", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeLessThanOrEqualTo(String value) {
			addCriterion("USER_ICCODE <=", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeLike(String value) {
			addCriterion("USER_ICCODE like", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeNotLike(String value) {
			addCriterion("USER_ICCODE not like", value, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeIn(List<String> values) {
			addCriterion("USER_ICCODE in", values, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeNotIn(List<String> values) {
			addCriterion("USER_ICCODE not in", values, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeBetween(String value1, String value2) {
			addCriterion("USER_ICCODE between", value1, value2, "userIccode");
			return (Criteria) this;
		}

		public Criteria andUserIccodeNotBetween(String value1, String value2) {
			addCriterion("USER_ICCODE not between", value1, value2, "userIccode");
			return (Criteria) this;
		}

		public Criteria andMlUserIdIsNull() {
			addCriterion("ML_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andMlUserIdIsNotNull() {
			addCriterion("ML_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andMlUserIdEqualTo(Integer value) {
			addCriterion("ML_USER_ID =", value, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdNotEqualTo(Integer value) {
			addCriterion("ML_USER_ID <>", value, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdGreaterThan(Integer value) {
			addCriterion("ML_USER_ID >", value, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ML_USER_ID >=", value, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdLessThan(Integer value) {
			addCriterion("ML_USER_ID <", value, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("ML_USER_ID <=", value, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdIn(List<Integer> values) {
			addCriterion("ML_USER_ID in", values, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdNotIn(List<Integer> values) {
			addCriterion("ML_USER_ID not in", values, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdBetween(Integer value1, Integer value2) {
			addCriterion("ML_USER_ID between", value1, value2, "mlUserId");
			return (Criteria) this;
		}

		public Criteria andMlUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ML_USER_ID not between", value1, value2, "mlUserId");
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