package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAliyunPhoneBindHistoryExample extends ShardDb {
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
	public ErpAliyunPhoneBindHistoryExample() {
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

		public Criteria andNumberPoolKeyIsNull() {
			addCriterion("NUMBER_POOL_KEY is null");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyIsNotNull() {
			addCriterion("NUMBER_POOL_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyEqualTo(String value) {
			addCriterion("NUMBER_POOL_KEY =", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyNotEqualTo(String value) {
			addCriterion("NUMBER_POOL_KEY <>", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyGreaterThan(String value) {
			addCriterion("NUMBER_POOL_KEY >", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyGreaterThanOrEqualTo(String value) {
			addCriterion("NUMBER_POOL_KEY >=", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyLessThan(String value) {
			addCriterion("NUMBER_POOL_KEY <", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyLessThanOrEqualTo(String value) {
			addCriterion("NUMBER_POOL_KEY <=", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyLike(String value) {
			addCriterion("NUMBER_POOL_KEY like", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyNotLike(String value) {
			addCriterion("NUMBER_POOL_KEY not like", value, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyIn(List<String> values) {
			addCriterion("NUMBER_POOL_KEY in", values, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyNotIn(List<String> values) {
			addCriterion("NUMBER_POOL_KEY not in", values, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyBetween(String value1, String value2) {
			addCriterion("NUMBER_POOL_KEY between", value1, value2, "numberPoolKey");
			return (Criteria) this;
		}

		public Criteria andNumberPoolKeyNotBetween(String value1, String value2) {
			addCriterion("NUMBER_POOL_KEY not between", value1, value2, "numberPoolKey");
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

		public Criteria andBindAIsNull() {
			addCriterion("BIND_A is null");
			return (Criteria) this;
		}

		public Criteria andBindAIsNotNull() {
			addCriterion("BIND_A is not null");
			return (Criteria) this;
		}

		public Criteria andBindAEqualTo(String value) {
			addCriterion("BIND_A =", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindANotEqualTo(String value) {
			addCriterion("BIND_A <>", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindAGreaterThan(String value) {
			addCriterion("BIND_A >", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindAGreaterThanOrEqualTo(String value) {
			addCriterion("BIND_A >=", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindALessThan(String value) {
			addCriterion("BIND_A <", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindALessThanOrEqualTo(String value) {
			addCriterion("BIND_A <=", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindALike(String value) {
			addCriterion("BIND_A like", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindANotLike(String value) {
			addCriterion("BIND_A not like", value, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindAIn(List<String> values) {
			addCriterion("BIND_A in", values, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindANotIn(List<String> values) {
			addCriterion("BIND_A not in", values, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindABetween(String value1, String value2) {
			addCriterion("BIND_A between", value1, value2, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindANotBetween(String value1, String value2) {
			addCriterion("BIND_A not between", value1, value2, "bindA");
			return (Criteria) this;
		}

		public Criteria andBindXIsNull() {
			addCriterion("BIND_X is null");
			return (Criteria) this;
		}

		public Criteria andBindXIsNotNull() {
			addCriterion("BIND_X is not null");
			return (Criteria) this;
		}

		public Criteria andBindXEqualTo(String value) {
			addCriterion("BIND_X =", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXNotEqualTo(String value) {
			addCriterion("BIND_X <>", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXGreaterThan(String value) {
			addCriterion("BIND_X >", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXGreaterThanOrEqualTo(String value) {
			addCriterion("BIND_X >=", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXLessThan(String value) {
			addCriterion("BIND_X <", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXLessThanOrEqualTo(String value) {
			addCriterion("BIND_X <=", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXLike(String value) {
			addCriterion("BIND_X like", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXNotLike(String value) {
			addCriterion("BIND_X not like", value, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXIn(List<String> values) {
			addCriterion("BIND_X in", values, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXNotIn(List<String> values) {
			addCriterion("BIND_X not in", values, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXBetween(String value1, String value2) {
			addCriterion("BIND_X between", value1, value2, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindXNotBetween(String value1, String value2) {
			addCriterion("BIND_X not between", value1, value2, "bindX");
			return (Criteria) this;
		}

		public Criteria andBindNOrBIsNull() {
			addCriterion("BIND_N_OR_B is null");
			return (Criteria) this;
		}

		public Criteria andBindNOrBIsNotNull() {
			addCriterion("BIND_N_OR_B is not null");
			return (Criteria) this;
		}

		public Criteria andBindNOrBEqualTo(String value) {
			addCriterion("BIND_N_OR_B =", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBNotEqualTo(String value) {
			addCriterion("BIND_N_OR_B <>", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBGreaterThan(String value) {
			addCriterion("BIND_N_OR_B >", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBGreaterThanOrEqualTo(String value) {
			addCriterion("BIND_N_OR_B >=", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBLessThan(String value) {
			addCriterion("BIND_N_OR_B <", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBLessThanOrEqualTo(String value) {
			addCriterion("BIND_N_OR_B <=", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBLike(String value) {
			addCriterion("BIND_N_OR_B like", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBNotLike(String value) {
			addCriterion("BIND_N_OR_B not like", value, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBIn(List<String> values) {
			addCriterion("BIND_N_OR_B in", values, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBNotIn(List<String> values) {
			addCriterion("BIND_N_OR_B not in", values, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBBetween(String value1, String value2) {
			addCriterion("BIND_N_OR_B between", value1, value2, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindNOrBNotBetween(String value1, String value2) {
			addCriterion("BIND_N_OR_B not between", value1, value2, "bindNOrB");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdIsNull() {
			addCriterion("BIND_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdIsNotNull() {
			addCriterion("BIND_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdEqualTo(Integer value) {
			addCriterion("BIND_ARCHIVE_ID =", value, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdNotEqualTo(Integer value) {
			addCriterion("BIND_ARCHIVE_ID <>", value, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdGreaterThan(Integer value) {
			addCriterion("BIND_ARCHIVE_ID >", value, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BIND_ARCHIVE_ID >=", value, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdLessThan(Integer value) {
			addCriterion("BIND_ARCHIVE_ID <", value, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("BIND_ARCHIVE_ID <=", value, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdIn(List<Integer> values) {
			addCriterion("BIND_ARCHIVE_ID in", values, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdNotIn(List<Integer> values) {
			addCriterion("BIND_ARCHIVE_ID not in", values, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("BIND_ARCHIVE_ID between", value1, value2, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BIND_ARCHIVE_ID not between", value1, value2, "bindArchiveId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdIsNull() {
			addCriterion("BIND_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andBindUserIdIsNotNull() {
			addCriterion("BIND_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBindUserIdEqualTo(Integer value) {
			addCriterion("BIND_USER_ID =", value, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdNotEqualTo(Integer value) {
			addCriterion("BIND_USER_ID <>", value, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdGreaterThan(Integer value) {
			addCriterion("BIND_USER_ID >", value, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BIND_USER_ID >=", value, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdLessThan(Integer value) {
			addCriterion("BIND_USER_ID <", value, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("BIND_USER_ID <=", value, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdIn(List<Integer> values) {
			addCriterion("BIND_USER_ID in", values, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdNotIn(List<Integer> values) {
			addCriterion("BIND_USER_ID not in", values, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdBetween(Integer value1, Integer value2) {
			addCriterion("BIND_USER_ID between", value1, value2, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BIND_USER_ID not between", value1, value2, "bindUserId");
			return (Criteria) this;
		}

		public Criteria andBindUserNameIsNull() {
			addCriterion("BIND_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBindUserNameIsNotNull() {
			addCriterion("BIND_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBindUserNameEqualTo(String value) {
			addCriterion("BIND_USER_NAME =", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameNotEqualTo(String value) {
			addCriterion("BIND_USER_NAME <>", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameGreaterThan(String value) {
			addCriterion("BIND_USER_NAME >", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("BIND_USER_NAME >=", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameLessThan(String value) {
			addCriterion("BIND_USER_NAME <", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameLessThanOrEqualTo(String value) {
			addCriterion("BIND_USER_NAME <=", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameLike(String value) {
			addCriterion("BIND_USER_NAME like", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameNotLike(String value) {
			addCriterion("BIND_USER_NAME not like", value, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameIn(List<String> values) {
			addCriterion("BIND_USER_NAME in", values, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameNotIn(List<String> values) {
			addCriterion("BIND_USER_NAME not in", values, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameBetween(String value1, String value2) {
			addCriterion("BIND_USER_NAME between", value1, value2, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindUserNameNotBetween(String value1, String value2) {
			addCriterion("BIND_USER_NAME not between", value1, value2, "bindUserName");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdIsNull() {
			addCriterion("BIND_A_ORG_ID is null");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdIsNotNull() {
			addCriterion("BIND_A_ORG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdEqualTo(Integer value) {
			addCriterion("BIND_A_ORG_ID =", value, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdNotEqualTo(Integer value) {
			addCriterion("BIND_A_ORG_ID <>", value, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdGreaterThan(Integer value) {
			addCriterion("BIND_A_ORG_ID >", value, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BIND_A_ORG_ID >=", value, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdLessThan(Integer value) {
			addCriterion("BIND_A_ORG_ID <", value, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdLessThanOrEqualTo(Integer value) {
			addCriterion("BIND_A_ORG_ID <=", value, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdIn(List<Integer> values) {
			addCriterion("BIND_A_ORG_ID in", values, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdNotIn(List<Integer> values) {
			addCriterion("BIND_A_ORG_ID not in", values, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdBetween(Integer value1, Integer value2) {
			addCriterion("BIND_A_ORG_ID between", value1, value2, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BIND_A_ORG_ID not between", value1, value2, "bindAOrgId");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoIsNull() {
			addCriterion("BIND_A_ORG_NO is null");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoIsNotNull() {
			addCriterion("BIND_A_ORG_NO is not null");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoEqualTo(String value) {
			addCriterion("BIND_A_ORG_NO =", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoNotEqualTo(String value) {
			addCriterion("BIND_A_ORG_NO <>", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoGreaterThan(String value) {
			addCriterion("BIND_A_ORG_NO >", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoGreaterThanOrEqualTo(String value) {
			addCriterion("BIND_A_ORG_NO >=", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoLessThan(String value) {
			addCriterion("BIND_A_ORG_NO <", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoLessThanOrEqualTo(String value) {
			addCriterion("BIND_A_ORG_NO <=", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoLike(String value) {
			addCriterion("BIND_A_ORG_NO like", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoNotLike(String value) {
			addCriterion("BIND_A_ORG_NO not like", value, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoIn(List<String> values) {
			addCriterion("BIND_A_ORG_NO in", values, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoNotIn(List<String> values) {
			addCriterion("BIND_A_ORG_NO not in", values, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoBetween(String value1, String value2) {
			addCriterion("BIND_A_ORG_NO between", value1, value2, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindAOrgNoNotBetween(String value1, String value2) {
			addCriterion("BIND_A_ORG_NO not between", value1, value2, "bindAOrgNo");
			return (Criteria) this;
		}

		public Criteria andBindATimeIsNull() {
			addCriterion("BIND_A_TIME is null");
			return (Criteria) this;
		}

		public Criteria andBindATimeIsNotNull() {
			addCriterion("BIND_A_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andBindATimeEqualTo(Date value) {
			addCriterion("BIND_A_TIME =", value, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeNotEqualTo(Date value) {
			addCriterion("BIND_A_TIME <>", value, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeGreaterThan(Date value) {
			addCriterion("BIND_A_TIME >", value, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeGreaterThanOrEqualTo(Date value) {
			addCriterion("BIND_A_TIME >=", value, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeLessThan(Date value) {
			addCriterion("BIND_A_TIME <", value, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeLessThanOrEqualTo(Date value) {
			addCriterion("BIND_A_TIME <=", value, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeIn(List<Date> values) {
			addCriterion("BIND_A_TIME in", values, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeNotIn(List<Date> values) {
			addCriterion("BIND_A_TIME not in", values, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeBetween(Date value1, Date value2) {
			addCriterion("BIND_A_TIME between", value1, value2, "bindATime");
			return (Criteria) this;
		}

		public Criteria andBindATimeNotBetween(Date value1, Date value2) {
			addCriterion("BIND_A_TIME not between", value1, value2, "bindATime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeIsNull() {
			addCriterion("UNBIND_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeIsNotNull() {
			addCriterion("UNBIND_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeEqualTo(Date value) {
			addCriterion("UNBIND_TIME =", value, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeNotEqualTo(Date value) {
			addCriterion("UNBIND_TIME <>", value, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeGreaterThan(Date value) {
			addCriterion("UNBIND_TIME >", value, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UNBIND_TIME >=", value, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeLessThan(Date value) {
			addCriterion("UNBIND_TIME <", value, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeLessThanOrEqualTo(Date value) {
			addCriterion("UNBIND_TIME <=", value, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeIn(List<Date> values) {
			addCriterion("UNBIND_TIME in", values, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeNotIn(List<Date> values) {
			addCriterion("UNBIND_TIME not in", values, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeBetween(Date value1, Date value2) {
			addCriterion("UNBIND_TIME between", value1, value2, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andUnbindTimeNotBetween(Date value1, Date value2) {
			addCriterion("UNBIND_TIME not between", value1, value2, "unbindTime");
			return (Criteria) this;
		}

		public Criteria andSubsIdIsNull() {
			addCriterion("SUBS_ID is null");
			return (Criteria) this;
		}

		public Criteria andSubsIdIsNotNull() {
			addCriterion("SUBS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSubsIdEqualTo(String value) {
			addCriterion("SUBS_ID =", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdNotEqualTo(String value) {
			addCriterion("SUBS_ID <>", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdGreaterThan(String value) {
			addCriterion("SUBS_ID >", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdGreaterThanOrEqualTo(String value) {
			addCriterion("SUBS_ID >=", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdLessThan(String value) {
			addCriterion("SUBS_ID <", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdLessThanOrEqualTo(String value) {
			addCriterion("SUBS_ID <=", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdLike(String value) {
			addCriterion("SUBS_ID like", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdNotLike(String value) {
			addCriterion("SUBS_ID not like", value, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdIn(List<String> values) {
			addCriterion("SUBS_ID in", values, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdNotIn(List<String> values) {
			addCriterion("SUBS_ID not in", values, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdBetween(String value1, String value2) {
			addCriterion("SUBS_ID between", value1, value2, "subsId");
			return (Criteria) this;
		}

		public Criteria andSubsIdNotBetween(String value1, String value2) {
			addCriterion("SUBS_ID not between", value1, value2, "subsId");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyIsNull() {
			addCriterion("ALI_NUMBER_POOL_KEY is null");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyIsNotNull() {
			addCriterion("ALI_NUMBER_POOL_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyEqualTo(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY =", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyNotEqualTo(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY <>", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyGreaterThan(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY >", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyGreaterThanOrEqualTo(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY >=", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyLessThan(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY <", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyLessThanOrEqualTo(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY <=", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyLike(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY like", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyNotLike(String value) {
			addCriterion("ALI_NUMBER_POOL_KEY not like", value, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyIn(List<String> values) {
			addCriterion("ALI_NUMBER_POOL_KEY in", values, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyNotIn(List<String> values) {
			addCriterion("ALI_NUMBER_POOL_KEY not in", values, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyBetween(String value1, String value2) {
			addCriterion("ALI_NUMBER_POOL_KEY between", value1, value2, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andAliNumberPoolKeyNotBetween(String value1, String value2) {
			addCriterion("ALI_NUMBER_POOL_KEY not between", value1, value2, "aliNumberPoolKey");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdIsNull() {
			addCriterion("BIND_OPERATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdIsNotNull() {
			addCriterion("BIND_OPERATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdEqualTo(Integer value) {
			addCriterion("BIND_OPERATE_USER_ID =", value, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdNotEqualTo(Integer value) {
			addCriterion("BIND_OPERATE_USER_ID <>", value, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdGreaterThan(Integer value) {
			addCriterion("BIND_OPERATE_USER_ID >", value, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BIND_OPERATE_USER_ID >=", value, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdLessThan(Integer value) {
			addCriterion("BIND_OPERATE_USER_ID <", value, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("BIND_OPERATE_USER_ID <=", value, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdIn(List<Integer> values) {
			addCriterion("BIND_OPERATE_USER_ID in", values, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdNotIn(List<Integer> values) {
			addCriterion("BIND_OPERATE_USER_ID not in", values, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("BIND_OPERATE_USER_ID between", value1, value2, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andBindOperateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BIND_OPERATE_USER_ID not between", value1, value2, "bindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdIsNull() {
			addCriterion("UNBIND_OPERATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdIsNotNull() {
			addCriterion("UNBIND_OPERATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdEqualTo(Integer value) {
			addCriterion("UNBIND_OPERATE_USER_ID =", value, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdNotEqualTo(Integer value) {
			addCriterion("UNBIND_OPERATE_USER_ID <>", value, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdGreaterThan(Integer value) {
			addCriterion("UNBIND_OPERATE_USER_ID >", value, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("UNBIND_OPERATE_USER_ID >=", value, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdLessThan(Integer value) {
			addCriterion("UNBIND_OPERATE_USER_ID <", value, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("UNBIND_OPERATE_USER_ID <=", value, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdIn(List<Integer> values) {
			addCriterion("UNBIND_OPERATE_USER_ID in", values, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdNotIn(List<Integer> values) {
			addCriterion("UNBIND_OPERATE_USER_ID not in", values, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("UNBIND_OPERATE_USER_ID between", value1, value2, "unbindOperateUserId");
			return (Criteria) this;
		}

		public Criteria andUnbindOperateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("UNBIND_OPERATE_USER_ID not between", value1, value2, "unbindOperateUserId");
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