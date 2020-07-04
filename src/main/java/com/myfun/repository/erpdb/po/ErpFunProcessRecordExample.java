package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunProcessRecordExample extends ShardDb {
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
	public ErpFunProcessRecordExample() {
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

		public Criteria andRecordIdIsNull() {
			addCriterion("RECORD_ID is null");
			return (Criteria) this;
		}

		public Criteria andRecordIdIsNotNull() {
			addCriterion("RECORD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRecordIdEqualTo(Integer value) {
			addCriterion("RECORD_ID =", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdNotEqualTo(Integer value) {
			addCriterion("RECORD_ID <>", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdGreaterThan(Integer value) {
			addCriterion("RECORD_ID >", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECORD_ID >=", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdLessThan(Integer value) {
			addCriterion("RECORD_ID <", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
			addCriterion("RECORD_ID <=", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdIn(List<Integer> values) {
			addCriterion("RECORD_ID in", values, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdNotIn(List<Integer> values) {
			addCriterion("RECORD_ID not in", values, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdBetween(Integer value1, Integer value2) {
			addCriterion("RECORD_ID between", value1, value2, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RECORD_ID not between", value1, value2, "recordId");
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

		public Criteria andDealIdIsNull() {
			addCriterion("DEAL_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealIdIsNotNull() {
			addCriterion("DEAL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealIdEqualTo(Integer value) {
			addCriterion("DEAL_ID =", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotEqualTo(Integer value) {
			addCriterion("DEAL_ID <>", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThan(Integer value) {
			addCriterion("DEAL_ID >", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID >=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThan(Integer value) {
			addCriterion("DEAL_ID <", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID <=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdIn(List<Integer> values) {
			addCriterion("DEAL_ID in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotIn(List<Integer> values) {
			addCriterion("DEAL_ID not in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID between", value1, value2, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID not between", value1, value2, "dealId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameIsNull() {
			addCriterion("UPDATE_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameIsNotNull() {
			addCriterion("UPDATE_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME =", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME <>", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameGreaterThan(String value) {
			addCriterion("UPDATE_USER_NAME >", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME >=", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameLessThan(String value) {
			addCriterion("UPDATE_USER_NAME <", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME <=", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameLike(String value) {
			addCriterion("UPDATE_USER_NAME like", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotLike(String value) {
			addCriterion("UPDATE_USER_NAME not like", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameIn(List<String> values) {
			addCriterion("UPDATE_USER_NAME in", values, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotIn(List<String> values) {
			addCriterion("UPDATE_USER_NAME not in", values, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameBetween(String value1, String value2) {
			addCriterion("UPDATE_USER_NAME between", value1, value2, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
			addCriterion("UPDATE_USER_NAME not between", value1, value2, "updateUserName");
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

		public Criteria andDealStatusEqualTo(String value) {
			addCriterion("DEAL_STATUS =", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusNotEqualTo(String value) {
			addCriterion("DEAL_STATUS <>", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusGreaterThan(String value) {
			addCriterion("DEAL_STATUS >", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_STATUS >=", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusLessThan(String value) {
			addCriterion("DEAL_STATUS <", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusLessThanOrEqualTo(String value) {
			addCriterion("DEAL_STATUS <=", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusLike(String value) {
			addCriterion("DEAL_STATUS like", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusNotLike(String value) {
			addCriterion("DEAL_STATUS not like", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusIn(List<String> values) {
			addCriterion("DEAL_STATUS in", values, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusNotIn(List<String> values) {
			addCriterion("DEAL_STATUS not in", values, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusBetween(String value1, String value2) {
			addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusNotBetween(String value1, String value2) {
			addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleIsNull() {
			addCriterion("OWNER_STYLE is null");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleIsNotNull() {
			addCriterion("OWNER_STYLE is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleEqualTo(String value) {
			addCriterion("OWNER_STYLE =", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleNotEqualTo(String value) {
			addCriterion("OWNER_STYLE <>", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleGreaterThan(String value) {
			addCriterion("OWNER_STYLE >", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleGreaterThanOrEqualTo(String value) {
			addCriterion("OWNER_STYLE >=", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleLessThan(String value) {
			addCriterion("OWNER_STYLE <", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleLessThanOrEqualTo(String value) {
			addCriterion("OWNER_STYLE <=", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleLike(String value) {
			addCriterion("OWNER_STYLE like", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleNotLike(String value) {
			addCriterion("OWNER_STYLE not like", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleIn(List<String> values) {
			addCriterion("OWNER_STYLE in", values, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleNotIn(List<String> values) {
			addCriterion("OWNER_STYLE not in", values, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleBetween(String value1, String value2) {
			addCriterion("OWNER_STYLE between", value1, value2, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleNotBetween(String value1, String value2) {
			addCriterion("OWNER_STYLE not between", value1, value2, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andDealUnameIsNull() {
			addCriterion("DEAL_UNAME is null");
			return (Criteria) this;
		}

		public Criteria andDealUnameIsNotNull() {
			addCriterion("DEAL_UNAME is not null");
			return (Criteria) this;
		}

		public Criteria andDealUnameEqualTo(String value) {
			addCriterion("DEAL_UNAME =", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameNotEqualTo(String value) {
			addCriterion("DEAL_UNAME <>", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameGreaterThan(String value) {
			addCriterion("DEAL_UNAME >", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_UNAME >=", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameLessThan(String value) {
			addCriterion("DEAL_UNAME <", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameLessThanOrEqualTo(String value) {
			addCriterion("DEAL_UNAME <=", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameLike(String value) {
			addCriterion("DEAL_UNAME like", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameNotLike(String value) {
			addCriterion("DEAL_UNAME not like", value, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameIn(List<String> values) {
			addCriterion("DEAL_UNAME in", values, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameNotIn(List<String> values) {
			addCriterion("DEAL_UNAME not in", values, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameBetween(String value1, String value2) {
			addCriterion("DEAL_UNAME between", value1, value2, "dealUname");
			return (Criteria) this;
		}

		public Criteria andDealUnameNotBetween(String value1, String value2) {
			addCriterion("DEAL_UNAME not between", value1, value2, "dealUname");
			return (Criteria) this;
		}

		public Criteria andSignDateIsNull() {
			addCriterion("SIGN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSignDateIsNotNull() {
			addCriterion("SIGN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSignDateEqualTo(String value) {
			addCriterion("SIGN_DATE =", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotEqualTo(String value) {
			addCriterion("SIGN_DATE <>", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateGreaterThan(String value) {
			addCriterion("SIGN_DATE >", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateGreaterThanOrEqualTo(String value) {
			addCriterion("SIGN_DATE >=", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLessThan(String value) {
			addCriterion("SIGN_DATE <", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLessThanOrEqualTo(String value) {
			addCriterion("SIGN_DATE <=", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLike(String value) {
			addCriterion("SIGN_DATE like", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotLike(String value) {
			addCriterion("SIGN_DATE not like", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateIn(List<String> values) {
			addCriterion("SIGN_DATE in", values, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotIn(List<String> values) {
			addCriterion("SIGN_DATE not in", values, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateBetween(String value1, String value2) {
			addCriterion("SIGN_DATE between", value1, value2, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotBetween(String value1, String value2) {
			addCriterion("SIGN_DATE not between", value1, value2, "signDate");
			return (Criteria) this;
		}

		public Criteria andModelNameIsNull() {
			addCriterion("MODEL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andModelNameIsNotNull() {
			addCriterion("MODEL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andModelNameEqualTo(String value) {
			addCriterion("MODEL_NAME =", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotEqualTo(String value) {
			addCriterion("MODEL_NAME <>", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameGreaterThan(String value) {
			addCriterion("MODEL_NAME >", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameGreaterThanOrEqualTo(String value) {
			addCriterion("MODEL_NAME >=", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLessThan(String value) {
			addCriterion("MODEL_NAME <", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLessThanOrEqualTo(String value) {
			addCriterion("MODEL_NAME <=", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLike(String value) {
			addCriterion("MODEL_NAME like", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotLike(String value) {
			addCriterion("MODEL_NAME not like", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameIn(List<String> values) {
			addCriterion("MODEL_NAME in", values, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotIn(List<String> values) {
			addCriterion("MODEL_NAME not in", values, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameBetween(String value1, String value2) {
			addCriterion("MODEL_NAME between", value1, value2, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotBetween(String value1, String value2) {
			addCriterion("MODEL_NAME not between", value1, value2, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeIsNull() {
			addCriterion("MODEL_CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeIsNotNull() {
			addCriterion("MODEL_CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeEqualTo(String value) {
			addCriterion("MODEL_CREATE_TIME =", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeNotEqualTo(String value) {
			addCriterion("MODEL_CREATE_TIME <>", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeGreaterThan(String value) {
			addCriterion("MODEL_CREATE_TIME >", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("MODEL_CREATE_TIME >=", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeLessThan(String value) {
			addCriterion("MODEL_CREATE_TIME <", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("MODEL_CREATE_TIME <=", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeLike(String value) {
			addCriterion("MODEL_CREATE_TIME like", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeNotLike(String value) {
			addCriterion("MODEL_CREATE_TIME not like", value, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeIn(List<String> values) {
			addCriterion("MODEL_CREATE_TIME in", values, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeNotIn(List<String> values) {
			addCriterion("MODEL_CREATE_TIME not in", values, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeBetween(String value1, String value2) {
			addCriterion("MODEL_CREATE_TIME between", value1, value2, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andModelCreateTimeNotBetween(String value1, String value2) {
			addCriterion("MODEL_CREATE_TIME not between", value1, value2, "modelCreateTime");
			return (Criteria) this;
		}

		public Criteria andNowStepIsNull() {
			addCriterion("NOW_STEP is null");
			return (Criteria) this;
		}

		public Criteria andNowStepIsNotNull() {
			addCriterion("NOW_STEP is not null");
			return (Criteria) this;
		}

		public Criteria andNowStepEqualTo(String value) {
			addCriterion("NOW_STEP =", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepNotEqualTo(String value) {
			addCriterion("NOW_STEP <>", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepGreaterThan(String value) {
			addCriterion("NOW_STEP >", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepGreaterThanOrEqualTo(String value) {
			addCriterion("NOW_STEP >=", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepLessThan(String value) {
			addCriterion("NOW_STEP <", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepLessThanOrEqualTo(String value) {
			addCriterion("NOW_STEP <=", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepLike(String value) {
			addCriterion("NOW_STEP like", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepNotLike(String value) {
			addCriterion("NOW_STEP not like", value, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepIn(List<String> values) {
			addCriterion("NOW_STEP in", values, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepNotIn(List<String> values) {
			addCriterion("NOW_STEP not in", values, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepBetween(String value1, String value2) {
			addCriterion("NOW_STEP between", value1, value2, "nowStep");
			return (Criteria) this;
		}

		public Criteria andNowStepNotBetween(String value1, String value2) {
			addCriterion("NOW_STEP not between", value1, value2, "nowStep");
			return (Criteria) this;
		}

		public Criteria andOldStepIsNull() {
			addCriterion("OLD_STEP is null");
			return (Criteria) this;
		}

		public Criteria andOldStepIsNotNull() {
			addCriterion("OLD_STEP is not null");
			return (Criteria) this;
		}

		public Criteria andOldStepEqualTo(String value) {
			addCriterion("OLD_STEP =", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepNotEqualTo(String value) {
			addCriterion("OLD_STEP <>", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepGreaterThan(String value) {
			addCriterion("OLD_STEP >", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepGreaterThanOrEqualTo(String value) {
			addCriterion("OLD_STEP >=", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepLessThan(String value) {
			addCriterion("OLD_STEP <", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepLessThanOrEqualTo(String value) {
			addCriterion("OLD_STEP <=", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepLike(String value) {
			addCriterion("OLD_STEP like", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepNotLike(String value) {
			addCriterion("OLD_STEP not like", value, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepIn(List<String> values) {
			addCriterion("OLD_STEP in", values, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepNotIn(List<String> values) {
			addCriterion("OLD_STEP not in", values, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepBetween(String value1, String value2) {
			addCriterion("OLD_STEP between", value1, value2, "oldStep");
			return (Criteria) this;
		}

		public Criteria andOldStepNotBetween(String value1, String value2) {
			addCriterion("OLD_STEP not between", value1, value2, "oldStep");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkIsNull() {
			addCriterion("RECORD_REMARK is null");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkIsNotNull() {
			addCriterion("RECORD_REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkEqualTo(String value) {
			addCriterion("RECORD_REMARK =", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkNotEqualTo(String value) {
			addCriterion("RECORD_REMARK <>", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkGreaterThan(String value) {
			addCriterion("RECORD_REMARK >", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("RECORD_REMARK >=", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkLessThan(String value) {
			addCriterion("RECORD_REMARK <", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkLessThanOrEqualTo(String value) {
			addCriterion("RECORD_REMARK <=", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkLike(String value) {
			addCriterion("RECORD_REMARK like", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkNotLike(String value) {
			addCriterion("RECORD_REMARK not like", value, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkIn(List<String> values) {
			addCriterion("RECORD_REMARK in", values, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkNotIn(List<String> values) {
			addCriterion("RECORD_REMARK not in", values, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkBetween(String value1, String value2) {
			addCriterion("RECORD_REMARK between", value1, value2, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andRecordRemarkNotBetween(String value1, String value2) {
			addCriterion("RECORD_REMARK not between", value1, value2, "recordRemark");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("UPDATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("UPDATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(String value) {
			addCriterion("UPDATE_DATE =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(String value) {
			addCriterion("UPDATE_DATE <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(String value) {
			addCriterion("UPDATE_DATE >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_DATE >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(String value) {
			addCriterion("UPDATE_DATE <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_DATE <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLike(String value) {
			addCriterion("UPDATE_DATE like", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotLike(String value) {
			addCriterion("UPDATE_DATE not like", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<String> values) {
			addCriterion("UPDATE_DATE in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<String> values) {
			addCriterion("UPDATE_DATE not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(String value1, String value2) {
			addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(String value1, String value2) {
			addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andTrackContentIsNull() {
			addCriterion("TRACK_CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andTrackContentIsNotNull() {
			addCriterion("TRACK_CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andTrackContentEqualTo(String value) {
			addCriterion("TRACK_CONTENT =", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotEqualTo(String value) {
			addCriterion("TRACK_CONTENT <>", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentGreaterThan(String value) {
			addCriterion("TRACK_CONTENT >", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentGreaterThanOrEqualTo(String value) {
			addCriterion("TRACK_CONTENT >=", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentLessThan(String value) {
			addCriterion("TRACK_CONTENT <", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentLessThanOrEqualTo(String value) {
			addCriterion("TRACK_CONTENT <=", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentLike(String value) {
			addCriterion("TRACK_CONTENT like", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotLike(String value) {
			addCriterion("TRACK_CONTENT not like", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentIn(List<String> values) {
			addCriterion("TRACK_CONTENT in", values, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotIn(List<String> values) {
			addCriterion("TRACK_CONTENT not in", values, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentBetween(String value1, String value2) {
			addCriterion("TRACK_CONTENT between", value1, value2, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotBetween(String value1, String value2) {
			addCriterion("TRACK_CONTENT not between", value1, value2, "trackContent");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicIsNull() {
			addCriterion("UPDATE_CLASSIC is null");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicIsNotNull() {
			addCriterion("UPDATE_CLASSIC is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicEqualTo(String value) {
			addCriterion("UPDATE_CLASSIC =", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicNotEqualTo(String value) {
			addCriterion("UPDATE_CLASSIC <>", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicGreaterThan(String value) {
			addCriterion("UPDATE_CLASSIC >", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_CLASSIC >=", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicLessThan(String value) {
			addCriterion("UPDATE_CLASSIC <", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_CLASSIC <=", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicLike(String value) {
			addCriterion("UPDATE_CLASSIC like", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicNotLike(String value) {
			addCriterion("UPDATE_CLASSIC not like", value, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicIn(List<String> values) {
			addCriterion("UPDATE_CLASSIC in", values, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicNotIn(List<String> values) {
			addCriterion("UPDATE_CLASSIC not in", values, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicBetween(String value1, String value2) {
			addCriterion("UPDATE_CLASSIC between", value1, value2, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andUpdateClassicNotBetween(String value1, String value2) {
			addCriterion("UPDATE_CLASSIC not between", value1, value2, "updateClassic");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdIsNull() {
			addCriterion("FRONT_RECORD_ID is null");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdIsNotNull() {
			addCriterion("FRONT_RECORD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdEqualTo(Integer value) {
			addCriterion("FRONT_RECORD_ID =", value, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdNotEqualTo(Integer value) {
			addCriterion("FRONT_RECORD_ID <>", value, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdGreaterThan(Integer value) {
			addCriterion("FRONT_RECORD_ID >", value, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FRONT_RECORD_ID >=", value, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdLessThan(Integer value) {
			addCriterion("FRONT_RECORD_ID <", value, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdLessThanOrEqualTo(Integer value) {
			addCriterion("FRONT_RECORD_ID <=", value, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdIn(List<Integer> values) {
			addCriterion("FRONT_RECORD_ID in", values, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdNotIn(List<Integer> values) {
			addCriterion("FRONT_RECORD_ID not in", values, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdBetween(Integer value1, Integer value2) {
			addCriterion("FRONT_RECORD_ID between", value1, value2, "frontRecordId");
			return (Criteria) this;
		}

		public Criteria andFrontRecordIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FRONT_RECORD_ID not between", value1, value2, "frontRecordId");
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

		public Criteria andUpdateContentIsNull() {
			addCriterion("UPDATE_CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andUpdateContentIsNotNull() {
			addCriterion("UPDATE_CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateContentEqualTo(String value) {
			addCriterion("UPDATE_CONTENT =", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentNotEqualTo(String value) {
			addCriterion("UPDATE_CONTENT <>", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentGreaterThan(String value) {
			addCriterion("UPDATE_CONTENT >", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_CONTENT >=", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentLessThan(String value) {
			addCriterion("UPDATE_CONTENT <", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_CONTENT <=", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentLike(String value) {
			addCriterion("UPDATE_CONTENT like", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentNotLike(String value) {
			addCriterion("UPDATE_CONTENT not like", value, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentIn(List<String> values) {
			addCriterion("UPDATE_CONTENT in", values, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentNotIn(List<String> values) {
			addCriterion("UPDATE_CONTENT not in", values, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentBetween(String value1, String value2) {
			addCriterion("UPDATE_CONTENT between", value1, value2, "updateContent");
			return (Criteria) this;
		}

		public Criteria andUpdateContentNotBetween(String value1, String value2) {
			addCriterion("UPDATE_CONTENT not between", value1, value2, "updateContent");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdIsNull() {
			addCriterion("RUNSTRP_ID is null");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdIsNotNull() {
			addCriterion("RUNSTRP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdEqualTo(Integer value) {
			addCriterion("RUNSTRP_ID =", value, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdNotEqualTo(Integer value) {
			addCriterion("RUNSTRP_ID <>", value, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdGreaterThan(Integer value) {
			addCriterion("RUNSTRP_ID >", value, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RUNSTRP_ID >=", value, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdLessThan(Integer value) {
			addCriterion("RUNSTRP_ID <", value, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdLessThanOrEqualTo(Integer value) {
			addCriterion("RUNSTRP_ID <=", value, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdIn(List<Integer> values) {
			addCriterion("RUNSTRP_ID in", values, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdNotIn(List<Integer> values) {
			addCriterion("RUNSTRP_ID not in", values, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdBetween(Integer value1, Integer value2) {
			addCriterion("RUNSTRP_ID between", value1, value2, "runstrpId");
			return (Criteria) this;
		}

		public Criteria andRunstrpIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RUNSTRP_ID not between", value1, value2, "runstrpId");
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