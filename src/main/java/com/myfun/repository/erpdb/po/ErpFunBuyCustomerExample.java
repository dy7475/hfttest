package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunBuyCustomerExample extends ShardDb {
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
	public ErpFunBuyCustomerExample() {
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

		public Criteria andBuyCustIdIsNull() {
			addCriterion("BUY_CUST_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdIsNotNull() {
			addCriterion("BUY_CUST_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdEqualTo(Integer value) {
			addCriterion("BUY_CUST_ID =", value, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdNotEqualTo(Integer value) {
			addCriterion("BUY_CUST_ID <>", value, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdGreaterThan(Integer value) {
			addCriterion("BUY_CUST_ID >", value, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUY_CUST_ID >=", value, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdLessThan(Integer value) {
			addCriterion("BUY_CUST_ID <", value, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUY_CUST_ID <=", value, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdIn(List<Integer> values) {
			addCriterion("BUY_CUST_ID in", values, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdNotIn(List<Integer> values) {
			addCriterion("BUY_CUST_ID not in", values, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdBetween(Integer value1, Integer value2) {
			addCriterion("BUY_CUST_ID between", value1, value2, "buyCustId");
			return (Criteria) this;
		}

		public Criteria andBuyCustIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUY_CUST_ID not between", value1, value2, "buyCustId");
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

		public Criteria andCreateArchiveIdIsNull() {
			addCriterion("CREATE_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdIsNotNull() {
			addCriterion("CREATE_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdEqualTo(Integer value) {
			addCriterion("CREATE_ARCHIVE_ID =", value, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdNotEqualTo(Integer value) {
			addCriterion("CREATE_ARCHIVE_ID <>", value, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdGreaterThan(Integer value) {
			addCriterion("CREATE_ARCHIVE_ID >", value, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_ARCHIVE_ID >=", value, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdLessThan(Integer value) {
			addCriterion("CREATE_ARCHIVE_ID <", value, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_ARCHIVE_ID <=", value, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdIn(List<Integer> values) {
			addCriterion("CREATE_ARCHIVE_ID in", values, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdNotIn(List<Integer> values) {
			addCriterion("CREATE_ARCHIVE_ID not in", values, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_ARCHIVE_ID between", value1, value2, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andCreateArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_ARCHIVE_ID not between", value1, value2, "createArchiveId");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoIsNull() {
			addCriterion("BUY_CUST_NO is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoIsNotNull() {
			addCriterion("BUY_CUST_NO is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoEqualTo(String value) {
			addCriterion("BUY_CUST_NO =", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoNotEqualTo(String value) {
			addCriterion("BUY_CUST_NO <>", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoGreaterThan(String value) {
			addCriterion("BUY_CUST_NO >", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CUST_NO >=", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoLessThan(String value) {
			addCriterion("BUY_CUST_NO <", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoLessThanOrEqualTo(String value) {
			addCriterion("BUY_CUST_NO <=", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoLike(String value) {
			addCriterion("BUY_CUST_NO like", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoNotLike(String value) {
			addCriterion("BUY_CUST_NO not like", value, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoIn(List<String> values) {
			addCriterion("BUY_CUST_NO in", values, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoNotIn(List<String> values) {
			addCriterion("BUY_CUST_NO not in", values, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoBetween(String value1, String value2) {
			addCriterion("BUY_CUST_NO between", value1, value2, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNoNotBetween(String value1, String value2) {
			addCriterion("BUY_CUST_NO not between", value1, value2, "buyCustNo");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameIsNull() {
			addCriterion("BUY_CUST_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameIsNotNull() {
			addCriterion("BUY_CUST_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameEqualTo(String value) {
			addCriterion("BUY_CUST_NAME =", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameNotEqualTo(String value) {
			addCriterion("BUY_CUST_NAME <>", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameGreaterThan(String value) {
			addCriterion("BUY_CUST_NAME >", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CUST_NAME >=", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameLessThan(String value) {
			addCriterion("BUY_CUST_NAME <", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameLessThanOrEqualTo(String value) {
			addCriterion("BUY_CUST_NAME <=", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameLike(String value) {
			addCriterion("BUY_CUST_NAME like", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameNotLike(String value) {
			addCriterion("BUY_CUST_NAME not like", value, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameIn(List<String> values) {
			addCriterion("BUY_CUST_NAME in", values, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameNotIn(List<String> values) {
			addCriterion("BUY_CUST_NAME not in", values, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameBetween(String value1, String value2) {
			addCriterion("BUY_CUST_NAME between", value1, value2, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustNameNotBetween(String value1, String value2) {
			addCriterion("BUY_CUST_NAME not between", value1, value2, "buyCustName");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexIsNull() {
			addCriterion("BUY_CUST_SEX is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexIsNotNull() {
			addCriterion("BUY_CUST_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexEqualTo(Boolean value) {
			addCriterion("BUY_CUST_SEX =", value, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexNotEqualTo(Boolean value) {
			addCriterion("BUY_CUST_SEX <>", value, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexGreaterThan(Boolean value) {
			addCriterion("BUY_CUST_SEX >", value, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexGreaterThanOrEqualTo(Boolean value) {
			addCriterion("BUY_CUST_SEX >=", value, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexLessThan(Boolean value) {
			addCriterion("BUY_CUST_SEX <", value, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexLessThanOrEqualTo(Boolean value) {
			addCriterion("BUY_CUST_SEX <=", value, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexIn(List<Boolean> values) {
			addCriterion("BUY_CUST_SEX in", values, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexNotIn(List<Boolean> values) {
			addCriterion("BUY_CUST_SEX not in", values, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexBetween(Boolean value1, Boolean value2) {
			addCriterion("BUY_CUST_SEX between", value1, value2, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustSexNotBetween(Boolean value1, Boolean value2) {
			addCriterion("BUY_CUST_SEX not between", value1, value2, "buyCustSex");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeIsNull() {
			addCriterion("BUY_CUST_AGE is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeIsNotNull() {
			addCriterion("BUY_CUST_AGE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeEqualTo(Byte value) {
			addCriterion("BUY_CUST_AGE =", value, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeNotEqualTo(Byte value) {
			addCriterion("BUY_CUST_AGE <>", value, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeGreaterThan(Byte value) {
			addCriterion("BUY_CUST_AGE >", value, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_AGE >=", value, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeLessThan(Byte value) {
			addCriterion("BUY_CUST_AGE <", value, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_AGE <=", value, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeIn(List<Byte> values) {
			addCriterion("BUY_CUST_AGE in", values, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeNotIn(List<Byte> values) {
			addCriterion("BUY_CUST_AGE not in", values, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_AGE between", value1, value2, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustAgeNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_AGE not between", value1, value2, "buyCustAge");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerIsNull() {
			addCriterion("BUY_CUST_CAREER is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerIsNotNull() {
			addCriterion("BUY_CUST_CAREER is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerEqualTo(Byte value) {
			addCriterion("BUY_CUST_CAREER =", value, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerNotEqualTo(Byte value) {
			addCriterion("BUY_CUST_CAREER <>", value, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerGreaterThan(Byte value) {
			addCriterion("BUY_CUST_CAREER >", value, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_CAREER >=", value, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerLessThan(Byte value) {
			addCriterion("BUY_CUST_CAREER <", value, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_CAREER <=", value, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerIn(List<Byte> values) {
			addCriterion("BUY_CUST_CAREER in", values, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerNotIn(List<Byte> values) {
			addCriterion("BUY_CUST_CAREER not in", values, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_CAREER between", value1, value2, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andBuyCustCareerNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_CAREER not between", value1, value2, "buyCustCareer");
			return (Criteria) this;
		}

		public Criteria andCellPhoneIsNull() {
			addCriterion("CELL_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andCellPhoneIsNotNull() {
			addCriterion("CELL_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andCellPhoneEqualTo(String value) {
			addCriterion("CELL_PHONE =", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneNotEqualTo(String value) {
			addCriterion("CELL_PHONE <>", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneGreaterThan(String value) {
			addCriterion("CELL_PHONE >", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("CELL_PHONE >=", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneLessThan(String value) {
			addCriterion("CELL_PHONE <", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneLessThanOrEqualTo(String value) {
			addCriterion("CELL_PHONE <=", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneLike(String value) {
			addCriterion("CELL_PHONE like", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneNotLike(String value) {
			addCriterion("CELL_PHONE not like", value, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneIn(List<String> values) {
			addCriterion("CELL_PHONE in", values, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneNotIn(List<String> values) {
			addCriterion("CELL_PHONE not in", values, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneBetween(String value1, String value2) {
			addCriterion("CELL_PHONE between", value1, value2, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andCellPhoneNotBetween(String value1, String value2) {
			addCriterion("CELL_PHONE not between", value1, value2, "cellPhone");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNull() {
			addCriterion("ID_CARD is null");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNotNull() {
			addCriterion("ID_CARD is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardEqualTo(String value) {
			addCriterion("ID_CARD =", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotEqualTo(String value) {
			addCriterion("ID_CARD <>", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThan(String value) {
			addCriterion("ID_CARD >", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("ID_CARD >=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThan(String value) {
			addCriterion("ID_CARD <", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThanOrEqualTo(String value) {
			addCriterion("ID_CARD <=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLike(String value) {
			addCriterion("ID_CARD like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotLike(String value) {
			addCriterion("ID_CARD not like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardIn(List<String> values) {
			addCriterion("ID_CARD in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotIn(List<String> values) {
			addCriterion("ID_CARD not in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardBetween(String value1, String value2) {
			addCriterion("ID_CARD between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotBetween(String value1, String value2) {
			addCriterion("ID_CARD not between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andCustAddrIsNull() {
			addCriterion("CUST_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andCustAddrIsNotNull() {
			addCriterion("CUST_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andCustAddrEqualTo(String value) {
			addCriterion("CUST_ADDR =", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrNotEqualTo(String value) {
			addCriterion("CUST_ADDR <>", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrGreaterThan(String value) {
			addCriterion("CUST_ADDR >", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_ADDR >=", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrLessThan(String value) {
			addCriterion("CUST_ADDR <", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrLessThanOrEqualTo(String value) {
			addCriterion("CUST_ADDR <=", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrLike(String value) {
			addCriterion("CUST_ADDR like", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrNotLike(String value) {
			addCriterion("CUST_ADDR not like", value, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrIn(List<String> values) {
			addCriterion("CUST_ADDR in", values, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrNotIn(List<String> values) {
			addCriterion("CUST_ADDR not in", values, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrBetween(String value1, String value2) {
			addCriterion("CUST_ADDR between", value1, value2, "custAddr");
			return (Criteria) this;
		}

		public Criteria andCustAddrNotBetween(String value1, String value2) {
			addCriterion("CUST_ADDR not between", value1, value2, "custAddr");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundIsNull() {
			addCriterion("BUY_LIFEBOUND is null");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundIsNotNull() {
			addCriterion("BUY_LIFEBOUND is not null");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundEqualTo(String value) {
			addCriterion("BUY_LIFEBOUND =", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundNotEqualTo(String value) {
			addCriterion("BUY_LIFEBOUND <>", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundGreaterThan(String value) {
			addCriterion("BUY_LIFEBOUND >", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_LIFEBOUND >=", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundLessThan(String value) {
			addCriterion("BUY_LIFEBOUND <", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundLessThanOrEqualTo(String value) {
			addCriterion("BUY_LIFEBOUND <=", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundLike(String value) {
			addCriterion("BUY_LIFEBOUND like", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundNotLike(String value) {
			addCriterion("BUY_LIFEBOUND not like", value, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundIn(List<String> values) {
			addCriterion("BUY_LIFEBOUND in", values, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundNotIn(List<String> values) {
			addCriterion("BUY_LIFEBOUND not in", values, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundBetween(String value1, String value2) {
			addCriterion("BUY_LIFEBOUND between", value1, value2, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyLifeboundNotBetween(String value1, String value2) {
			addCriterion("BUY_LIFEBOUND not between", value1, value2, "buyLifebound");
			return (Criteria) this;
		}

		public Criteria andBuyGoalIsNull() {
			addCriterion("BUY_GOAL is null");
			return (Criteria) this;
		}

		public Criteria andBuyGoalIsNotNull() {
			addCriterion("BUY_GOAL is not null");
			return (Criteria) this;
		}

		public Criteria andBuyGoalEqualTo(Byte value) {
			addCriterion("BUY_GOAL =", value, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalNotEqualTo(Byte value) {
			addCriterion("BUY_GOAL <>", value, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalGreaterThan(Byte value) {
			addCriterion("BUY_GOAL >", value, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_GOAL >=", value, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalLessThan(Byte value) {
			addCriterion("BUY_GOAL <", value, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_GOAL <=", value, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalIn(List<Byte> values) {
			addCriterion("BUY_GOAL in", values, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalNotIn(List<Byte> values) {
			addCriterion("BUY_GOAL not in", values, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalBetween(Byte value1, Byte value2) {
			addCriterion("BUY_GOAL between", value1, value2, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyGoalNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_GOAL not between", value1, value2, "buyGoal");
			return (Criteria) this;
		}

		public Criteria andBuyLengthIsNull() {
			addCriterion("BUY_LENGTH is null");
			return (Criteria) this;
		}

		public Criteria andBuyLengthIsNotNull() {
			addCriterion("BUY_LENGTH is not null");
			return (Criteria) this;
		}

		public Criteria andBuyLengthEqualTo(Byte value) {
			addCriterion("BUY_LENGTH =", value, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthNotEqualTo(Byte value) {
			addCriterion("BUY_LENGTH <>", value, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthGreaterThan(Byte value) {
			addCriterion("BUY_LENGTH >", value, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_LENGTH >=", value, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthLessThan(Byte value) {
			addCriterion("BUY_LENGTH <", value, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_LENGTH <=", value, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthIn(List<Byte> values) {
			addCriterion("BUY_LENGTH in", values, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthNotIn(List<Byte> values) {
			addCriterion("BUY_LENGTH not in", values, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthBetween(Byte value1, Byte value2) {
			addCriterion("BUY_LENGTH between", value1, value2, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyLengthNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_LENGTH not between", value1, value2, "buyLength");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityIsNull() {
			addCriterion("BUY_ABILITY is null");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityIsNotNull() {
			addCriterion("BUY_ABILITY is not null");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityEqualTo(Byte value) {
			addCriterion("BUY_ABILITY =", value, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityNotEqualTo(Byte value) {
			addCriterion("BUY_ABILITY <>", value, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityGreaterThan(Byte value) {
			addCriterion("BUY_ABILITY >", value, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_ABILITY >=", value, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityLessThan(Byte value) {
			addCriterion("BUY_ABILITY <", value, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_ABILITY <=", value, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityIn(List<Byte> values) {
			addCriterion("BUY_ABILITY in", values, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityNotIn(List<Byte> values) {
			addCriterion("BUY_ABILITY not in", values, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityBetween(Byte value1, Byte value2) {
			addCriterion("BUY_ABILITY between", value1, value2, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyAbilityNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_ABILITY not between", value1, value2, "buyAbility");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeIsNull() {
			addCriterion("BUY_PAYTYPE is null");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeIsNotNull() {
			addCriterion("BUY_PAYTYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeEqualTo(Byte value) {
			addCriterion("BUY_PAYTYPE =", value, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeNotEqualTo(Byte value) {
			addCriterion("BUY_PAYTYPE <>", value, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeGreaterThan(Byte value) {
			addCriterion("BUY_PAYTYPE >", value, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_PAYTYPE >=", value, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeLessThan(Byte value) {
			addCriterion("BUY_PAYTYPE <", value, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_PAYTYPE <=", value, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeIn(List<Byte> values) {
			addCriterion("BUY_PAYTYPE in", values, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeNotIn(List<Byte> values) {
			addCriterion("BUY_PAYTYPE not in", values, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeBetween(Byte value1, Byte value2) {
			addCriterion("BUY_PAYTYPE between", value1, value2, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andBuyPaytypeNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_PAYTYPE not between", value1, value2, "buyPaytype");
			return (Criteria) this;
		}

		public Criteria andCustLevelIsNull() {
			addCriterion("CUST_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andCustLevelIsNotNull() {
			addCriterion("CUST_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andCustLevelEqualTo(String value) {
			addCriterion("CUST_LEVEL =", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotEqualTo(String value) {
			addCriterion("CUST_LEVEL <>", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelGreaterThan(String value) {
			addCriterion("CUST_LEVEL >", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_LEVEL >=", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelLessThan(String value) {
			addCriterion("CUST_LEVEL <", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelLessThanOrEqualTo(String value) {
			addCriterion("CUST_LEVEL <=", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelLike(String value) {
			addCriterion("CUST_LEVEL like", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotLike(String value) {
			addCriterion("CUST_LEVEL not like", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelIn(List<String> values) {
			addCriterion("CUST_LEVEL in", values, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotIn(List<String> values) {
			addCriterion("CUST_LEVEL not in", values, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelBetween(String value1, String value2) {
			addCriterion("CUST_LEVEL between", value1, value2, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotBetween(String value1, String value2) {
			addCriterion("CUST_LEVEL not between", value1, value2, "custLevel");
			return (Criteria) this;
		}

		public Criteria andPlateTypeIsNull() {
			addCriterion("PLATE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPlateTypeIsNotNull() {
			addCriterion("PLATE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPlateTypeEqualTo(Byte value) {
			addCriterion("PLATE_TYPE =", value, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeNotEqualTo(Byte value) {
			addCriterion("PLATE_TYPE <>", value, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeGreaterThan(Byte value) {
			addCriterion("PLATE_TYPE >", value, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PLATE_TYPE >=", value, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeLessThan(Byte value) {
			addCriterion("PLATE_TYPE <", value, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PLATE_TYPE <=", value, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeIn(List<Byte> values) {
			addCriterion("PLATE_TYPE in", values, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeNotIn(List<Byte> values) {
			addCriterion("PLATE_TYPE not in", values, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeBetween(Byte value1, Byte value2) {
			addCriterion("PLATE_TYPE between", value1, value2, "plateType");
			return (Criteria) this;
		}

		public Criteria andPlateTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PLATE_TYPE not between", value1, value2, "plateType");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceIsNull() {
			addCriterion("BUY_CUST_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceIsNotNull() {
			addCriterion("BUY_CUST_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceEqualTo(Byte value) {
			addCriterion("BUY_CUST_SOURCE =", value, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceNotEqualTo(Byte value) {
			addCriterion("BUY_CUST_SOURCE <>", value, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceGreaterThan(Byte value) {
			addCriterion("BUY_CUST_SOURCE >", value, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_SOURCE >=", value, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceLessThan(Byte value) {
			addCriterion("BUY_CUST_SOURCE <", value, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_SOURCE <=", value, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceIn(List<Byte> values) {
			addCriterion("BUY_CUST_SOURCE in", values, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceNotIn(List<Byte> values) {
			addCriterion("BUY_CUST_SOURCE not in", values, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_SOURCE between", value1, value2, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_SOURCE not between", value1, value2, "buyCustSource");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelIsNull() {
			addCriterion("BUY_CUST_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelIsNotNull() {
			addCriterion("BUY_CUST_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelEqualTo(Byte value) {
			addCriterion("BUY_CUST_LEVEL =", value, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelNotEqualTo(Byte value) {
			addCriterion("BUY_CUST_LEVEL <>", value, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelGreaterThan(Byte value) {
			addCriterion("BUY_CUST_LEVEL >", value, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_LEVEL >=", value, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelLessThan(Byte value) {
			addCriterion("BUY_CUST_LEVEL <", value, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_LEVEL <=", value, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelIn(List<Byte> values) {
			addCriterion("BUY_CUST_LEVEL in", values, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelNotIn(List<Byte> values) {
			addCriterion("BUY_CUST_LEVEL not in", values, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_LEVEL between", value1, value2, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andBuyCustLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_LEVEL not between", value1, value2, "buyCustLevel");
			return (Criteria) this;
		}

		public Criteria andHouseRoomIsNull() {
			addCriterion("HOUSE_ROOM is null");
			return (Criteria) this;
		}

		public Criteria andHouseRoomIsNotNull() {
			addCriterion("HOUSE_ROOM is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRoomEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM =", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomNotEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM <>", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomGreaterThan(Byte value) {
			addCriterion("HOUSE_ROOM >", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM >=", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomLessThan(Byte value) {
			addCriterion("HOUSE_ROOM <", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM <=", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomIn(List<Byte> values) {
			addCriterion("HOUSE_ROOM in", values, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomNotIn(List<Byte> values) {
			addCriterion("HOUSE_ROOM not in", values, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROOM between", value1, value2, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROOM not between", value1, value2, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1IsNull() {
			addCriterion("HOUSE_ROOM_1 is null");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1IsNotNull() {
			addCriterion("HOUSE_ROOM_1 is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1EqualTo(Byte value) {
			addCriterion("HOUSE_ROOM_1 =", value, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1NotEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM_1 <>", value, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1GreaterThan(Byte value) {
			addCriterion("HOUSE_ROOM_1 >", value, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1GreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM_1 >=", value, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1LessThan(Byte value) {
			addCriterion("HOUSE_ROOM_1 <", value, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1LessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM_1 <=", value, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1In(List<Byte> values) {
			addCriterion("HOUSE_ROOM_1 in", values, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1NotIn(List<Byte> values) {
			addCriterion("HOUSE_ROOM_1 not in", values, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1Between(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROOM_1 between", value1, value2, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRoom1NotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROOM_1 not between", value1, value2, "houseRoom1");
			return (Criteria) this;
		}

		public Criteria andHouseRegionIsNull() {
			addCriterion("HOUSE_REGION is null");
			return (Criteria) this;
		}

		public Criteria andHouseRegionIsNotNull() {
			addCriterion("HOUSE_REGION is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRegionEqualTo(String value) {
			addCriterion("HOUSE_REGION =", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionNotEqualTo(String value) {
			addCriterion("HOUSE_REGION <>", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionGreaterThan(String value) {
			addCriterion("HOUSE_REGION >", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_REGION >=", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionLessThan(String value) {
			addCriterion("HOUSE_REGION <", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_REGION <=", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionLike(String value) {
			addCriterion("HOUSE_REGION like", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionNotLike(String value) {
			addCriterion("HOUSE_REGION not like", value, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionIn(List<String> values) {
			addCriterion("HOUSE_REGION in", values, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionNotIn(List<String> values) {
			addCriterion("HOUSE_REGION not in", values, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionBetween(String value1, String value2) {
			addCriterion("HOUSE_REGION between", value1, value2, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andHouseRegionNotBetween(String value1, String value2) {
			addCriterion("HOUSE_REGION not between", value1, value2, "houseRegion");
			return (Criteria) this;
		}

		public Criteria andRegionNameIsNull() {
			addCriterion("REGION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRegionNameIsNotNull() {
			addCriterion("REGION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRegionNameEqualTo(String value) {
			addCriterion("REGION_NAME =", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotEqualTo(String value) {
			addCriterion("REGION_NAME <>", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameGreaterThan(String value) {
			addCriterion("REGION_NAME >", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
			addCriterion("REGION_NAME >=", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameLessThan(String value) {
			addCriterion("REGION_NAME <", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameLessThanOrEqualTo(String value) {
			addCriterion("REGION_NAME <=", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameLike(String value) {
			addCriterion("REGION_NAME like", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotLike(String value) {
			addCriterion("REGION_NAME not like", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameIn(List<String> values) {
			addCriterion("REGION_NAME in", values, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotIn(List<String> values) {
			addCriterion("REGION_NAME not in", values, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameBetween(String value1, String value2) {
			addCriterion("REGION_NAME between", value1, value2, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotBetween(String value1, String value2) {
			addCriterion("REGION_NAME not between", value1, value2, "regionName");
			return (Criteria) this;
		}

		public Criteria andSectionIdIsNull() {
			addCriterion("SECTION_ID is null");
			return (Criteria) this;
		}

		public Criteria andSectionIdIsNotNull() {
			addCriterion("SECTION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSectionIdEqualTo(String value) {
			addCriterion("SECTION_ID =", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotEqualTo(String value) {
			addCriterion("SECTION_ID <>", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThan(String value) {
			addCriterion("SECTION_ID >", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThanOrEqualTo(String value) {
			addCriterion("SECTION_ID >=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThan(String value) {
			addCriterion("SECTION_ID <", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThanOrEqualTo(String value) {
			addCriterion("SECTION_ID <=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLike(String value) {
			addCriterion("SECTION_ID like", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotLike(String value) {
			addCriterion("SECTION_ID not like", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdIn(List<String> values) {
			addCriterion("SECTION_ID in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotIn(List<String> values) {
			addCriterion("SECTION_ID not in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdBetween(String value1, String value2) {
			addCriterion("SECTION_ID between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotBetween(String value1, String value2) {
			addCriterion("SECTION_ID not between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionNameIsNull() {
			addCriterion("SECTION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSectionNameIsNotNull() {
			addCriterion("SECTION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSectionNameEqualTo(String value) {
			addCriterion("SECTION_NAME =", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotEqualTo(String value) {
			addCriterion("SECTION_NAME <>", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameGreaterThan(String value) {
			addCriterion("SECTION_NAME >", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECTION_NAME >=", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLessThan(String value) {
			addCriterion("SECTION_NAME <", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLessThanOrEqualTo(String value) {
			addCriterion("SECTION_NAME <=", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLike(String value) {
			addCriterion("SECTION_NAME like", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotLike(String value) {
			addCriterion("SECTION_NAME not like", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameIn(List<String> values) {
			addCriterion("SECTION_NAME in", values, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotIn(List<String> values) {
			addCriterion("SECTION_NAME not in", values, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameBetween(String value1, String value2) {
			addCriterion("SECTION_NAME between", value1, value2, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotBetween(String value1, String value2) {
			addCriterion("SECTION_NAME not between", value1, value2, "sectionName");
			return (Criteria) this;
		}

		public Criteria andBuildIdIsNull() {
			addCriterion("BUILD_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildIdIsNotNull() {
			addCriterion("BUILD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildIdEqualTo(String value) {
			addCriterion("BUILD_ID =", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotEqualTo(String value) {
			addCriterion("BUILD_ID <>", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThan(String value) {
			addCriterion("BUILD_ID >", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_ID >=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThan(String value) {
			addCriterion("BUILD_ID <", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThanOrEqualTo(String value) {
			addCriterion("BUILD_ID <=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLike(String value) {
			addCriterion("BUILD_ID like", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotLike(String value) {
			addCriterion("BUILD_ID not like", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdIn(List<String> values) {
			addCriterion("BUILD_ID in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotIn(List<String> values) {
			addCriterion("BUILD_ID not in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdBetween(String value1, String value2) {
			addCriterion("BUILD_ID between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotBetween(String value1, String value2) {
			addCriterion("BUILD_ID not between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildNameIsNull() {
			addCriterion("BUILD_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuildNameIsNotNull() {
			addCriterion("BUILD_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuildNameEqualTo(String value) {
			addCriterion("BUILD_NAME =", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotEqualTo(String value) {
			addCriterion("BUILD_NAME <>", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameGreaterThan(String value) {
			addCriterion("BUILD_NAME >", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_NAME >=", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLessThan(String value) {
			addCriterion("BUILD_NAME <", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLessThanOrEqualTo(String value) {
			addCriterion("BUILD_NAME <=", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLike(String value) {
			addCriterion("BUILD_NAME like", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotLike(String value) {
			addCriterion("BUILD_NAME not like", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameIn(List<String> values) {
			addCriterion("BUILD_NAME in", values, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotIn(List<String> values) {
			addCriterion("BUILD_NAME not in", values, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameBetween(String value1, String value2) {
			addCriterion("BUILD_NAME between", value1, value2, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotBetween(String value1, String value2) {
			addCriterion("BUILD_NAME not between", value1, value2, "buildName");
			return (Criteria) this;
		}

		public Criteria andHouseRoundIsNull() {
			addCriterion("HOUSE_ROUND is null");
			return (Criteria) this;
		}

		public Criteria andHouseRoundIsNotNull() {
			addCriterion("HOUSE_ROUND is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRoundEqualTo(String value) {
			addCriterion("HOUSE_ROUND =", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundNotEqualTo(String value) {
			addCriterion("HOUSE_ROUND <>", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundGreaterThan(String value) {
			addCriterion("HOUSE_ROUND >", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_ROUND >=", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundLessThan(String value) {
			addCriterion("HOUSE_ROUND <", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_ROUND <=", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundLike(String value) {
			addCriterion("HOUSE_ROUND like", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundNotLike(String value) {
			addCriterion("HOUSE_ROUND not like", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundIn(List<String> values) {
			addCriterion("HOUSE_ROUND in", values, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundNotIn(List<String> values) {
			addCriterion("HOUSE_ROUND not in", values, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundBetween(String value1, String value2) {
			addCriterion("HOUSE_ROUND between", value1, value2, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundNotBetween(String value1, String value2) {
			addCriterion("HOUSE_ROUND not between", value1, value2, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIsNull() {
			addCriterion("HOUSE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIsNotNull() {
			addCriterion("HOUSE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseTypeEqualTo(String value) {
			addCriterion("HOUSE_TYPE =", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotEqualTo(String value) {
			addCriterion("HOUSE_TYPE <>", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeGreaterThan(String value) {
			addCriterion("HOUSE_TYPE >", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_TYPE >=", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLessThan(String value) {
			addCriterion("HOUSE_TYPE <", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_TYPE <=", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLike(String value) {
			addCriterion("HOUSE_TYPE like", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotLike(String value) {
			addCriterion("HOUSE_TYPE not like", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIn(List<String> values) {
			addCriterion("HOUSE_TYPE in", values, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotIn(List<String> values) {
			addCriterion("HOUSE_TYPE not in", values, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeBetween(String value1, String value2) {
			addCriterion("HOUSE_TYPE between", value1, value2, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotBetween(String value1, String value2) {
			addCriterion("HOUSE_TYPE not between", value1, value2, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseUseageIsNull() {
			addCriterion("HOUSE_USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andHouseUseageIsNotNull() {
			addCriterion("HOUSE_USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseUseageEqualTo(String value) {
			addCriterion("HOUSE_USEAGE =", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotEqualTo(String value) {
			addCriterion("HOUSE_USEAGE <>", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageGreaterThan(String value) {
			addCriterion("HOUSE_USEAGE >", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_USEAGE >=", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLessThan(String value) {
			addCriterion("HOUSE_USEAGE <", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_USEAGE <=", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLike(String value) {
			addCriterion("HOUSE_USEAGE like", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotLike(String value) {
			addCriterion("HOUSE_USEAGE not like", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageIn(List<String> values) {
			addCriterion("HOUSE_USEAGE in", values, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotIn(List<String> values) {
			addCriterion("HOUSE_USEAGE not in", values, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageBetween(String value1, String value2) {
			addCriterion("HOUSE_USEAGE between", value1, value2, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotBetween(String value1, String value2) {
			addCriterion("HOUSE_USEAGE not between", value1, value2, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentIsNull() {
			addCriterion("HOUSE_FITMENT is null");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentIsNotNull() {
			addCriterion("HOUSE_FITMENT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT =", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentNotEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT <>", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentGreaterThan(Byte value) {
			addCriterion("HOUSE_FITMENT >", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT >=", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentLessThan(Byte value) {
			addCriterion("HOUSE_FITMENT <", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT <=", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentIn(List<Byte> values) {
			addCriterion("HOUSE_FITMENT in", values, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentNotIn(List<Byte> values) {
			addCriterion("HOUSE_FITMENT not in", values, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_FITMENT between", value1, value2, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_FITMENT not between", value1, value2, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseDirectIsNull() {
			addCriterion("HOUSE_DIRECT is null");
			return (Criteria) this;
		}

		public Criteria andHouseDirectIsNotNull() {
			addCriterion("HOUSE_DIRECT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDirectEqualTo(String value) {
			addCriterion("HOUSE_DIRECT =", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectNotEqualTo(String value) {
			addCriterion("HOUSE_DIRECT <>", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectGreaterThan(String value) {
			addCriterion("HOUSE_DIRECT >", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_DIRECT >=", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectLessThan(String value) {
			addCriterion("HOUSE_DIRECT <", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_DIRECT <=", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectLike(String value) {
			addCriterion("HOUSE_DIRECT like", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectNotLike(String value) {
			addCriterion("HOUSE_DIRECT not like", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectIn(List<String> values) {
			addCriterion("HOUSE_DIRECT in", values, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectNotIn(List<String> values) {
			addCriterion("HOUSE_DIRECT not in", values, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectBetween(String value1, String value2) {
			addCriterion("HOUSE_DIRECT between", value1, value2, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectNotBetween(String value1, String value2) {
			addCriterion("HOUSE_DIRECT not between", value1, value2, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowIsNull() {
			addCriterion("HOUSE_FLOOR_LOW is null");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowIsNotNull() {
			addCriterion("HOUSE_FLOOR_LOW is not null");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_LOW =", value, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowNotEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_LOW <>", value, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowGreaterThan(Short value) {
			addCriterion("HOUSE_FLOOR_LOW >", value, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowGreaterThanOrEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_LOW >=", value, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowLessThan(Short value) {
			addCriterion("HOUSE_FLOOR_LOW <", value, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowLessThanOrEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_LOW <=", value, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowIn(List<Short> values) {
			addCriterion("HOUSE_FLOOR_LOW in", values, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowNotIn(List<Short> values) {
			addCriterion("HOUSE_FLOOR_LOW not in", values, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowBetween(Short value1, Short value2) {
			addCriterion("HOUSE_FLOOR_LOW between", value1, value2, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLowNotBetween(Short value1, Short value2) {
			addCriterion("HOUSE_FLOOR_LOW not between", value1, value2, "houseFloorLow");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighIsNull() {
			addCriterion("HOUSE_FLOOR_HIGH is null");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighIsNotNull() {
			addCriterion("HOUSE_FLOOR_HIGH is not null");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_HIGH =", value, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighNotEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_HIGH <>", value, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighGreaterThan(Short value) {
			addCriterion("HOUSE_FLOOR_HIGH >", value, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighGreaterThanOrEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_HIGH >=", value, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighLessThan(Short value) {
			addCriterion("HOUSE_FLOOR_HIGH <", value, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighLessThanOrEqualTo(Short value) {
			addCriterion("HOUSE_FLOOR_HIGH <=", value, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighIn(List<Short> values) {
			addCriterion("HOUSE_FLOOR_HIGH in", values, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighNotIn(List<Short> values) {
			addCriterion("HOUSE_FLOOR_HIGH not in", values, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighBetween(Short value1, Short value2) {
			addCriterion("HOUSE_FLOOR_HIGH between", value1, value2, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHouseFloorHighNotBetween(Short value1, Short value2) {
			addCriterion("HOUSE_FLOOR_HIGH not between", value1, value2, "houseFloorHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowIsNull() {
			addCriterion("HOUSE_PRICE_LOW is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowIsNotNull() {
			addCriterion("HOUSE_PRICE_LOW is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_LOW =", value, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_LOW <>", value, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_PRICE_LOW >", value, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_LOW >=", value, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowLessThan(BigDecimal value) {
			addCriterion("HOUSE_PRICE_LOW <", value, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_LOW <=", value, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowIn(List<BigDecimal> values) {
			addCriterion("HOUSE_PRICE_LOW in", values, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_PRICE_LOW not in", values, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_PRICE_LOW between", value1, value2, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceLowNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_PRICE_LOW not between", value1, value2, "housePriceLow");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighIsNull() {
			addCriterion("HOUSE_PRICE_HIGH is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighIsNotNull() {
			addCriterion("HOUSE_PRICE_HIGH is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_HIGH =", value, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_HIGH <>", value, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_PRICE_HIGH >", value, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_HIGH >=", value, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighLessThan(BigDecimal value) {
			addCriterion("HOUSE_PRICE_HIGH <", value, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_PRICE_HIGH <=", value, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighIn(List<BigDecimal> values) {
			addCriterion("HOUSE_PRICE_HIGH in", values, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_PRICE_HIGH not in", values, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_PRICE_HIGH between", value1, value2, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHousePriceHighNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_PRICE_HIGH not between", value1, value2, "housePriceHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowIsNull() {
			addCriterion("HOUSE_AREA_LOW is null");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowIsNotNull() {
			addCriterion("HOUSE_AREA_LOW is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_LOW =", value, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_LOW <>", value, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_AREA_LOW >", value, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_LOW >=", value, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowLessThan(BigDecimal value) {
			addCriterion("HOUSE_AREA_LOW <", value, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_LOW <=", value, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowIn(List<BigDecimal> values) {
			addCriterion("HOUSE_AREA_LOW in", values, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_AREA_LOW not in", values, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_AREA_LOW between", value1, value2, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLowNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_AREA_LOW not between", value1, value2, "houseAreaLow");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighIsNull() {
			addCriterion("HOUSE_AREA_HIGH is null");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighIsNotNull() {
			addCriterion("HOUSE_AREA_HIGH is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_HIGH =", value, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_HIGH <>", value, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_AREA_HIGH >", value, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_HIGH >=", value, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighLessThan(BigDecimal value) {
			addCriterion("HOUSE_AREA_HIGH <", value, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA_HIGH <=", value, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighIn(List<BigDecimal> values) {
			addCriterion("HOUSE_AREA_HIGH in", values, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_AREA_HIGH not in", values, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_AREA_HIGH between", value1, value2, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseAreaHighNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_AREA_HIGH not between", value1, value2, "houseAreaHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowIsNull() {
			addCriterion("HOUSE_YEAR_LOW is null");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowIsNotNull() {
			addCriterion("HOUSE_YEAR_LOW is not null");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_LOW =", value, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowNotEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_LOW <>", value, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowGreaterThan(Short value) {
			addCriterion("HOUSE_YEAR_LOW >", value, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowGreaterThanOrEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_LOW >=", value, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowLessThan(Short value) {
			addCriterion("HOUSE_YEAR_LOW <", value, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowLessThanOrEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_LOW <=", value, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowIn(List<Short> values) {
			addCriterion("HOUSE_YEAR_LOW in", values, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowNotIn(List<Short> values) {
			addCriterion("HOUSE_YEAR_LOW not in", values, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowBetween(Short value1, Short value2) {
			addCriterion("HOUSE_YEAR_LOW between", value1, value2, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearLowNotBetween(Short value1, Short value2) {
			addCriterion("HOUSE_YEAR_LOW not between", value1, value2, "houseYearLow");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighIsNull() {
			addCriterion("HOUSE_YEAR_HIGH is null");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighIsNotNull() {
			addCriterion("HOUSE_YEAR_HIGH is not null");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_HIGH =", value, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighNotEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_HIGH <>", value, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighGreaterThan(Short value) {
			addCriterion("HOUSE_YEAR_HIGH >", value, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighGreaterThanOrEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_HIGH >=", value, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighLessThan(Short value) {
			addCriterion("HOUSE_YEAR_HIGH <", value, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighLessThanOrEqualTo(Short value) {
			addCriterion("HOUSE_YEAR_HIGH <=", value, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighIn(List<Short> values) {
			addCriterion("HOUSE_YEAR_HIGH in", values, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighNotIn(List<Short> values) {
			addCriterion("HOUSE_YEAR_HIGH not in", values, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighBetween(Short value1, Short value2) {
			addCriterion("HOUSE_YEAR_HIGH between", value1, value2, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseYearHighNotBetween(Short value1, Short value2) {
			addCriterion("HOUSE_YEAR_HIGH not between", value1, value2, "houseYearHigh");
			return (Criteria) this;
		}

		public Criteria andHouseLookIsNull() {
			addCriterion("HOUSE_LOOK is null");
			return (Criteria) this;
		}

		public Criteria andHouseLookIsNotNull() {
			addCriterion("HOUSE_LOOK is not null");
			return (Criteria) this;
		}

		public Criteria andHouseLookEqualTo(Boolean value) {
			addCriterion("HOUSE_LOOK =", value, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookNotEqualTo(Boolean value) {
			addCriterion("HOUSE_LOOK <>", value, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookGreaterThan(Boolean value) {
			addCriterion("HOUSE_LOOK >", value, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookGreaterThanOrEqualTo(Boolean value) {
			addCriterion("HOUSE_LOOK >=", value, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookLessThan(Boolean value) {
			addCriterion("HOUSE_LOOK <", value, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookLessThanOrEqualTo(Boolean value) {
			addCriterion("HOUSE_LOOK <=", value, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookIn(List<Boolean> values) {
			addCriterion("HOUSE_LOOK in", values, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookNotIn(List<Boolean> values) {
			addCriterion("HOUSE_LOOK not in", values, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookBetween(Boolean value1, Boolean value2) {
			addCriterion("HOUSE_LOOK between", value1, value2, "houseLook");
			return (Criteria) this;
		}

		public Criteria andHouseLookNotBetween(Boolean value1, Boolean value2) {
			addCriterion("HOUSE_LOOK not between", value1, value2, "houseLook");
			return (Criteria) this;
		}

		public Criteria andCustRequestIsNull() {
			addCriterion("CUST_REQUEST is null");
			return (Criteria) this;
		}

		public Criteria andCustRequestIsNotNull() {
			addCriterion("CUST_REQUEST is not null");
			return (Criteria) this;
		}

		public Criteria andCustRequestEqualTo(String value) {
			addCriterion("CUST_REQUEST =", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestNotEqualTo(String value) {
			addCriterion("CUST_REQUEST <>", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestGreaterThan(String value) {
			addCriterion("CUST_REQUEST >", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_REQUEST >=", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestLessThan(String value) {
			addCriterion("CUST_REQUEST <", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestLessThanOrEqualTo(String value) {
			addCriterion("CUST_REQUEST <=", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestLike(String value) {
			addCriterion("CUST_REQUEST like", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestNotLike(String value) {
			addCriterion("CUST_REQUEST not like", value, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestIn(List<String> values) {
			addCriterion("CUST_REQUEST in", values, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestNotIn(List<String> values) {
			addCriterion("CUST_REQUEST not in", values, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestBetween(String value1, String value2) {
			addCriterion("CUST_REQUEST between", value1, value2, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustRequestNotBetween(String value1, String value2) {
			addCriterion("CUST_REQUEST not between", value1, value2, "custRequest");
			return (Criteria) this;
		}

		public Criteria andCustMemoIsNull() {
			addCriterion("CUST_MEMO is null");
			return (Criteria) this;
		}

		public Criteria andCustMemoIsNotNull() {
			addCriterion("CUST_MEMO is not null");
			return (Criteria) this;
		}

		public Criteria andCustMemoEqualTo(String value) {
			addCriterion("CUST_MEMO =", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoNotEqualTo(String value) {
			addCriterion("CUST_MEMO <>", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoGreaterThan(String value) {
			addCriterion("CUST_MEMO >", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_MEMO >=", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoLessThan(String value) {
			addCriterion("CUST_MEMO <", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoLessThanOrEqualTo(String value) {
			addCriterion("CUST_MEMO <=", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoLike(String value) {
			addCriterion("CUST_MEMO like", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoNotLike(String value) {
			addCriterion("CUST_MEMO not like", value, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoIn(List<String> values) {
			addCriterion("CUST_MEMO in", values, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoNotIn(List<String> values) {
			addCriterion("CUST_MEMO not in", values, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoBetween(String value1, String value2) {
			addCriterion("CUST_MEMO between", value1, value2, "custMemo");
			return (Criteria) this;
		}

		public Criteria andCustMemoNotBetween(String value1, String value2) {
			addCriterion("CUST_MEMO not between", value1, value2, "custMemo");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusIsNull() {
			addCriterion("BUY_CUST_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusIsNotNull() {
			addCriterion("BUY_CUST_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusEqualTo(Byte value) {
			addCriterion("BUY_CUST_STATUS =", value, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusNotEqualTo(Byte value) {
			addCriterion("BUY_CUST_STATUS <>", value, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusGreaterThan(Byte value) {
			addCriterion("BUY_CUST_STATUS >", value, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_STATUS >=", value, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusLessThan(Byte value) {
			addCriterion("BUY_CUST_STATUS <", value, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_CUST_STATUS <=", value, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusIn(List<Byte> values) {
			addCriterion("BUY_CUST_STATUS in", values, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusNotIn(List<Byte> values) {
			addCriterion("BUY_CUST_STATUS not in", values, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_STATUS between", value1, value2, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CUST_STATUS not between", value1, value2, "buyCustStatus");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIsNull() {
			addCriterion("TRACK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIsNotNull() {
			addCriterion("TRACK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTrackTimeEqualTo(String value) {
			addCriterion("TRACK_TIME =", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotEqualTo(String value) {
			addCriterion("TRACK_TIME <>", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeGreaterThan(String value) {
			addCriterion("TRACK_TIME >", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeGreaterThanOrEqualTo(String value) {
			addCriterion("TRACK_TIME >=", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLessThan(String value) {
			addCriterion("TRACK_TIME <", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLessThanOrEqualTo(String value) {
			addCriterion("TRACK_TIME <=", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLike(String value) {
			addCriterion("TRACK_TIME like", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotLike(String value) {
			addCriterion("TRACK_TIME not like", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIn(List<String> values) {
			addCriterion("TRACK_TIME in", values, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotIn(List<String> values) {
			addCriterion("TRACK_TIME not in", values, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeBetween(String value1, String value2) {
			addCriterion("TRACK_TIME between", value1, value2, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotBetween(String value1, String value2) {
			addCriterion("TRACK_TIME not between", value1, value2, "trackTime");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagIsNull() {
			addCriterion("REPEAT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagIsNotNull() {
			addCriterion("REPEAT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagEqualTo(Boolean value) {
			addCriterion("REPEAT_FLAG =", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotEqualTo(Boolean value) {
			addCriterion("REPEAT_FLAG <>", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagGreaterThan(Boolean value) {
			addCriterion("REPEAT_FLAG >", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("REPEAT_FLAG >=", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagLessThan(Boolean value) {
			addCriterion("REPEAT_FLAG <", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("REPEAT_FLAG <=", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagIn(List<Boolean> values) {
			addCriterion("REPEAT_FLAG in", values, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotIn(List<Boolean> values) {
			addCriterion("REPEAT_FLAG not in", values, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("REPEAT_FLAG between", value1, value2, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("REPEAT_FLAG not between", value1, value2, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andInfoTypeIsNull() {
			addCriterion("INFO_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andInfoTypeIsNotNull() {
			addCriterion("INFO_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andInfoTypeEqualTo(Byte value) {
			addCriterion("INFO_TYPE =", value, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeNotEqualTo(Byte value) {
			addCriterion("INFO_TYPE <>", value, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeGreaterThan(Byte value) {
			addCriterion("INFO_TYPE >", value, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("INFO_TYPE >=", value, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeLessThan(Byte value) {
			addCriterion("INFO_TYPE <", value, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeLessThanOrEqualTo(Byte value) {
			addCriterion("INFO_TYPE <=", value, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeIn(List<Byte> values) {
			addCriterion("INFO_TYPE in", values, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeNotIn(List<Byte> values) {
			addCriterion("INFO_TYPE not in", values, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeBetween(Byte value1, Byte value2) {
			addCriterion("INFO_TYPE between", value1, value2, "infoType");
			return (Criteria) this;
		}

		public Criteria andInfoTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("INFO_TYPE not between", value1, value2, "infoType");
			return (Criteria) this;
		}

		public Criteria andShareFlagIsNull() {
			addCriterion("SHARE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andShareFlagIsNotNull() {
			addCriterion("SHARE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andShareFlagEqualTo(Boolean value) {
			addCriterion("SHARE_FLAG =", value, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagNotEqualTo(Boolean value) {
			addCriterion("SHARE_FLAG <>", value, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagGreaterThan(Boolean value) {
			addCriterion("SHARE_FLAG >", value, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SHARE_FLAG >=", value, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagLessThan(Boolean value) {
			addCriterion("SHARE_FLAG <", value, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("SHARE_FLAG <=", value, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagIn(List<Boolean> values) {
			addCriterion("SHARE_FLAG in", values, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagNotIn(List<Boolean> values) {
			addCriterion("SHARE_FLAG not in", values, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("SHARE_FLAG between", value1, value2, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andShareFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SHARE_FLAG not between", value1, value2, "shareFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagIsNull() {
			addCriterion("RED_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andRedFlagIsNotNull() {
			addCriterion("RED_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andRedFlagEqualTo(Boolean value) {
			addCriterion("RED_FLAG =", value, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagNotEqualTo(Boolean value) {
			addCriterion("RED_FLAG <>", value, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagGreaterThan(Boolean value) {
			addCriterion("RED_FLAG >", value, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("RED_FLAG >=", value, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagLessThan(Boolean value) {
			addCriterion("RED_FLAG <", value, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("RED_FLAG <=", value, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagIn(List<Boolean> values) {
			addCriterion("RED_FLAG in", values, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagNotIn(List<Boolean> values) {
			addCriterion("RED_FLAG not in", values, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("RED_FLAG between", value1, value2, "redFlag");
			return (Criteria) this;
		}

		public Criteria andRedFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("RED_FLAG not between", value1, value2, "redFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagIsNull() {
			addCriterion("ORANGE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagIsNotNull() {
			addCriterion("ORANGE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagEqualTo(Boolean value) {
			addCriterion("ORANGE_FLAG =", value, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagNotEqualTo(Boolean value) {
			addCriterion("ORANGE_FLAG <>", value, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagGreaterThan(Boolean value) {
			addCriterion("ORANGE_FLAG >", value, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ORANGE_FLAG >=", value, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagLessThan(Boolean value) {
			addCriterion("ORANGE_FLAG <", value, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("ORANGE_FLAG <=", value, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagIn(List<Boolean> values) {
			addCriterion("ORANGE_FLAG in", values, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagNotIn(List<Boolean> values) {
			addCriterion("ORANGE_FLAG not in", values, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("ORANGE_FLAG between", value1, value2, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andOrangeFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ORANGE_FLAG not between", value1, value2, "orangeFlag");
			return (Criteria) this;
		}

		public Criteria andPublicCountIsNull() {
			addCriterion("PUBLIC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andPublicCountIsNotNull() {
			addCriterion("PUBLIC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPublicCountEqualTo(Integer value) {
			addCriterion("PUBLIC_COUNT =", value, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountNotEqualTo(Integer value) {
			addCriterion("PUBLIC_COUNT <>", value, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountGreaterThan(Integer value) {
			addCriterion("PUBLIC_COUNT >", value, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("PUBLIC_COUNT >=", value, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountLessThan(Integer value) {
			addCriterion("PUBLIC_COUNT <", value, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountLessThanOrEqualTo(Integer value) {
			addCriterion("PUBLIC_COUNT <=", value, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountIn(List<Integer> values) {
			addCriterion("PUBLIC_COUNT in", values, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountNotIn(List<Integer> values) {
			addCriterion("PUBLIC_COUNT not in", values, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountBetween(Integer value1, Integer value2) {
			addCriterion("PUBLIC_COUNT between", value1, value2, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicCountNotBetween(Integer value1, Integer value2) {
			addCriterion("PUBLIC_COUNT not between", value1, value2, "publicCount");
			return (Criteria) this;
		}

		public Criteria andPublicTimeIsNull() {
			addCriterion("PUBLIC_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPublicTimeIsNotNull() {
			addCriterion("PUBLIC_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPublicTimeEqualTo(String value) {
			addCriterion("PUBLIC_TIME =", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotEqualTo(String value) {
			addCriterion("PUBLIC_TIME <>", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeGreaterThan(String value) {
			addCriterion("PUBLIC_TIME >", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeGreaterThanOrEqualTo(String value) {
			addCriterion("PUBLIC_TIME >=", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeLessThan(String value) {
			addCriterion("PUBLIC_TIME <", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeLessThanOrEqualTo(String value) {
			addCriterion("PUBLIC_TIME <=", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeLike(String value) {
			addCriterion("PUBLIC_TIME like", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotLike(String value) {
			addCriterion("PUBLIC_TIME not like", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeIn(List<String> values) {
			addCriterion("PUBLIC_TIME in", values, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotIn(List<String> values) {
			addCriterion("PUBLIC_TIME not in", values, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeBetween(String value1, String value2) {
			addCriterion("PUBLIC_TIME between", value1, value2, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotBetween(String value1, String value2) {
			addCriterion("PUBLIC_TIME not between", value1, value2, "publicTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeIsNull() {
			addCriterion("SPECIAL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeIsNotNull() {
			addCriterion("SPECIAL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeEqualTo(String value) {
			addCriterion("SPECIAL_TIME =", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotEqualTo(String value) {
			addCriterion("SPECIAL_TIME <>", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeGreaterThan(String value) {
			addCriterion("SPECIAL_TIME >", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeGreaterThanOrEqualTo(String value) {
			addCriterion("SPECIAL_TIME >=", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeLessThan(String value) {
			addCriterion("SPECIAL_TIME <", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeLessThanOrEqualTo(String value) {
			addCriterion("SPECIAL_TIME <=", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeLike(String value) {
			addCriterion("SPECIAL_TIME like", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotLike(String value) {
			addCriterion("SPECIAL_TIME not like", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeIn(List<String> values) {
			addCriterion("SPECIAL_TIME in", values, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotIn(List<String> values) {
			addCriterion("SPECIAL_TIME not in", values, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeBetween(String value1, String value2) {
			addCriterion("SPECIAL_TIME between", value1, value2, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotBetween(String value1, String value2) {
			addCriterion("SPECIAL_TIME not between", value1, value2, "specialTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeIsNull() {
			addCriterion("SCHEDULE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeIsNotNull() {
			addCriterion("SCHEDULE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeEqualTo(String value) {
			addCriterion("SCHEDULE_TIME =", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotEqualTo(String value) {
			addCriterion("SCHEDULE_TIME <>", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeGreaterThan(String value) {
			addCriterion("SCHEDULE_TIME >", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeGreaterThanOrEqualTo(String value) {
			addCriterion("SCHEDULE_TIME >=", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeLessThan(String value) {
			addCriterion("SCHEDULE_TIME <", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeLessThanOrEqualTo(String value) {
			addCriterion("SCHEDULE_TIME <=", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeLike(String value) {
			addCriterion("SCHEDULE_TIME like", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotLike(String value) {
			addCriterion("SCHEDULE_TIME not like", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeIn(List<String> values) {
			addCriterion("SCHEDULE_TIME in", values, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotIn(List<String> values) {
			addCriterion("SCHEDULE_TIME not in", values, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeBetween(String value1, String value2) {
			addCriterion("SCHEDULE_TIME between", value1, value2, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotBetween(String value1, String value2) {
			addCriterion("SCHEDULE_TIME not between", value1, value2, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeIsNull() {
			addCriterion("DEAL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDealTimeIsNotNull() {
			addCriterion("DEAL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDealTimeEqualTo(String value) {
			addCriterion("DEAL_TIME =", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotEqualTo(String value) {
			addCriterion("DEAL_TIME <>", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeGreaterThan(String value) {
			addCriterion("DEAL_TIME >", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_TIME >=", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLessThan(String value) {
			addCriterion("DEAL_TIME <", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLessThanOrEqualTo(String value) {
			addCriterion("DEAL_TIME <=", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLike(String value) {
			addCriterion("DEAL_TIME like", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotLike(String value) {
			addCriterion("DEAL_TIME not like", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeIn(List<String> values) {
			addCriterion("DEAL_TIME in", values, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotIn(List<String> values) {
			addCriterion("DEAL_TIME not in", values, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeBetween(String value1, String value2) {
			addCriterion("DEAL_TIME between", value1, value2, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotBetween(String value1, String value2) {
			addCriterion("DEAL_TIME not between", value1, value2, "dealTime");
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

		public Criteria andSecrecyTimeIsNull() {
			addCriterion("SECRECY_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeIsNotNull() {
			addCriterion("SECRECY_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeEqualTo(String value) {
			addCriterion("SECRECY_TIME =", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotEqualTo(String value) {
			addCriterion("SECRECY_TIME <>", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeGreaterThan(String value) {
			addCriterion("SECRECY_TIME >", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeGreaterThanOrEqualTo(String value) {
			addCriterion("SECRECY_TIME >=", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeLessThan(String value) {
			addCriterion("SECRECY_TIME <", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeLessThanOrEqualTo(String value) {
			addCriterion("SECRECY_TIME <=", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeLike(String value) {
			addCriterion("SECRECY_TIME like", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotLike(String value) {
			addCriterion("SECRECY_TIME not like", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeIn(List<String> values) {
			addCriterion("SECRECY_TIME in", values, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotIn(List<String> values) {
			addCriterion("SECRECY_TIME not in", values, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeBetween(String value1, String value2) {
			addCriterion("SECRECY_TIME between", value1, value2, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotBetween(String value1, String value2) {
			addCriterion("SECRECY_TIME not between", value1, value2, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeIsNull() {
			addCriterion("COMMEND_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCommendTimeIsNotNull() {
			addCriterion("COMMEND_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCommendTimeEqualTo(String value) {
			addCriterion("COMMEND_TIME =", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotEqualTo(String value) {
			addCriterion("COMMEND_TIME <>", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeGreaterThan(String value) {
			addCriterion("COMMEND_TIME >", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeGreaterThanOrEqualTo(String value) {
			addCriterion("COMMEND_TIME >=", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeLessThan(String value) {
			addCriterion("COMMEND_TIME <", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeLessThanOrEqualTo(String value) {
			addCriterion("COMMEND_TIME <=", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeLike(String value) {
			addCriterion("COMMEND_TIME like", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotLike(String value) {
			addCriterion("COMMEND_TIME not like", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeIn(List<String> values) {
			addCriterion("COMMEND_TIME in", values, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotIn(List<String> values) {
			addCriterion("COMMEND_TIME not in", values, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeBetween(String value1, String value2) {
			addCriterion("COMMEND_TIME between", value1, value2, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotBetween(String value1, String value2) {
			addCriterion("COMMEND_TIME not between", value1, value2, "commendTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeIsNull() {
			addCriterion("ACTION_TIME is null");
			return (Criteria) this;
		}

		public Criteria andActionTimeIsNotNull() {
			addCriterion("ACTION_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andActionTimeEqualTo(String value) {
			addCriterion("ACTION_TIME =", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotEqualTo(String value) {
			addCriterion("ACTION_TIME <>", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeGreaterThan(String value) {
			addCriterion("ACTION_TIME >", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeGreaterThanOrEqualTo(String value) {
			addCriterion("ACTION_TIME >=", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeLessThan(String value) {
			addCriterion("ACTION_TIME <", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeLessThanOrEqualTo(String value) {
			addCriterion("ACTION_TIME <=", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeLike(String value) {
			addCriterion("ACTION_TIME like", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotLike(String value) {
			addCriterion("ACTION_TIME not like", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeIn(List<String> values) {
			addCriterion("ACTION_TIME in", values, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotIn(List<String> values) {
			addCriterion("ACTION_TIME not in", values, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeBetween(String value1, String value2) {
			addCriterion("ACTION_TIME between", value1, value2, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotBetween(String value1, String value2) {
			addCriterion("ACTION_TIME not between", value1, value2, "actionTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeIsNull() {
			addCriterion("PRIVATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeIsNotNull() {
			addCriterion("PRIVATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeEqualTo(String value) {
			addCriterion("PRIVATE_TIME =", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotEqualTo(String value) {
			addCriterion("PRIVATE_TIME <>", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeGreaterThan(String value) {
			addCriterion("PRIVATE_TIME >", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("PRIVATE_TIME >=", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeLessThan(String value) {
			addCriterion("PRIVATE_TIME <", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeLessThanOrEqualTo(String value) {
			addCriterion("PRIVATE_TIME <=", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeLike(String value) {
			addCriterion("PRIVATE_TIME like", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotLike(String value) {
			addCriterion("PRIVATE_TIME not like", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeIn(List<String> values) {
			addCriterion("PRIVATE_TIME in", values, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotIn(List<String> values) {
			addCriterion("PRIVATE_TIME not in", values, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeBetween(String value1, String value2) {
			addCriterion("PRIVATE_TIME between", value1, value2, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotBetween(String value1, String value2) {
			addCriterion("PRIVATE_TIME not between", value1, value2, "privateTime");
			return (Criteria) this;
		}

		public Criteria andFromPublicIsNull() {
			addCriterion("FROM_PUBLIC is null");
			return (Criteria) this;
		}

		public Criteria andFromPublicIsNotNull() {
			addCriterion("FROM_PUBLIC is not null");
			return (Criteria) this;
		}

		public Criteria andFromPublicEqualTo(Boolean value) {
			addCriterion("FROM_PUBLIC =", value, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicNotEqualTo(Boolean value) {
			addCriterion("FROM_PUBLIC <>", value, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicGreaterThan(Boolean value) {
			addCriterion("FROM_PUBLIC >", value, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicGreaterThanOrEqualTo(Boolean value) {
			addCriterion("FROM_PUBLIC >=", value, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicLessThan(Boolean value) {
			addCriterion("FROM_PUBLIC <", value, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicLessThanOrEqualTo(Boolean value) {
			addCriterion("FROM_PUBLIC <=", value, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicIn(List<Boolean> values) {
			addCriterion("FROM_PUBLIC in", values, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicNotIn(List<Boolean> values) {
			addCriterion("FROM_PUBLIC not in", values, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicBetween(Boolean value1, Boolean value2) {
			addCriterion("FROM_PUBLIC between", value1, value2, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andFromPublicNotBetween(Boolean value1, Boolean value2) {
			addCriterion("FROM_PUBLIC not between", value1, value2, "fromPublic");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagIsNull() {
			addCriterion("COOPERATE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagIsNotNull() {
			addCriterion("COOPERATE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagEqualTo(Integer value) {
			addCriterion("COOPERATE_FLAG =", value, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagNotEqualTo(Integer value) {
			addCriterion("COOPERATE_FLAG <>", value, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagGreaterThan(Integer value) {
			addCriterion("COOPERATE_FLAG >", value, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("COOPERATE_FLAG >=", value, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagLessThan(Integer value) {
			addCriterion("COOPERATE_FLAG <", value, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagLessThanOrEqualTo(Integer value) {
			addCriterion("COOPERATE_FLAG <=", value, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagIn(List<Integer> values) {
			addCriterion("COOPERATE_FLAG in", values, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagNotIn(List<Integer> values) {
			addCriterion("COOPERATE_FLAG not in", values, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagBetween(Integer value1, Integer value2) {
			addCriterion("COOPERATE_FLAG between", value1, value2, "cooperateFlag");
			return (Criteria) this;
		}

		public Criteria andCooperateFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("COOPERATE_FLAG not between", value1, value2, "cooperateFlag");
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

		public Criteria andFriendHouseIsNull() {
			addCriterion("FRIEND_HOUSE is null");
			return (Criteria) this;
		}

		public Criteria andFriendHouseIsNotNull() {
			addCriterion("FRIEND_HOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andFriendHouseEqualTo(Byte value) {
			addCriterion("FRIEND_HOUSE =", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseNotEqualTo(Byte value) {
			addCriterion("FRIEND_HOUSE <>", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseGreaterThan(Byte value) {
			addCriterion("FRIEND_HOUSE >", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseGreaterThanOrEqualTo(Byte value) {
			addCriterion("FRIEND_HOUSE >=", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseLessThan(Byte value) {
			addCriterion("FRIEND_HOUSE <", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseLessThanOrEqualTo(Byte value) {
			addCriterion("FRIEND_HOUSE <=", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseIn(List<Byte> values) {
			addCriterion("FRIEND_HOUSE in", values, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseNotIn(List<Byte> values) {
			addCriterion("FRIEND_HOUSE not in", values, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseBetween(Byte value1, Byte value2) {
			addCriterion("FRIEND_HOUSE between", value1, value2, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseNotBetween(Byte value1, Byte value2) {
			addCriterion("FRIEND_HOUSE not between", value1, value2, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeIsNull() {
			addCriterion("COOPERATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeIsNotNull() {
			addCriterion("COOPERATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeEqualTo(Date value) {
			addCriterion("COOPERATE_TIME =", value, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeNotEqualTo(Date value) {
			addCriterion("COOPERATE_TIME <>", value, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeGreaterThan(Date value) {
			addCriterion("COOPERATE_TIME >", value, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("COOPERATE_TIME >=", value, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeLessThan(Date value) {
			addCriterion("COOPERATE_TIME <", value, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeLessThanOrEqualTo(Date value) {
			addCriterion("COOPERATE_TIME <=", value, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeIn(List<Date> values) {
			addCriterion("COOPERATE_TIME in", values, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeNotIn(List<Date> values) {
			addCriterion("COOPERATE_TIME not in", values, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeBetween(Date value1, Date value2) {
			addCriterion("COOPERATE_TIME between", value1, value2, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeNotBetween(Date value1, Date value2) {
			addCriterion("COOPERATE_TIME not between", value1, value2, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagIsNull() {
			addCriterion("COMPLAINT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagIsNotNull() {
			addCriterion("COMPLAINT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagEqualTo(Boolean value) {
			addCriterion("COMPLAINT_FLAG =", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagNotEqualTo(Boolean value) {
			addCriterion("COMPLAINT_FLAG <>", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagGreaterThan(Boolean value) {
			addCriterion("COMPLAINT_FLAG >", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("COMPLAINT_FLAG >=", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagLessThan(Boolean value) {
			addCriterion("COMPLAINT_FLAG <", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("COMPLAINT_FLAG <=", value, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagIn(List<Boolean> values) {
			addCriterion("COMPLAINT_FLAG in", values, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagNotIn(List<Boolean> values) {
			addCriterion("COMPLAINT_FLAG not in", values, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("COMPLAINT_FLAG between", value1, value2, "complaintFlag");
			return (Criteria) this;
		}

		public Criteria andComplaintFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("COMPLAINT_FLAG not between", value1, value2, "complaintFlag");
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

		public Criteria andIsIgnoreIsNull() {
			addCriterion("is_ignore is null");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreIsNotNull() {
			addCriterion("is_ignore is not null");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreEqualTo(Byte value) {
			addCriterion("is_ignore =", value, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreNotEqualTo(Byte value) {
			addCriterion("is_ignore <>", value, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreGreaterThan(Byte value) {
			addCriterion("is_ignore >", value, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_ignore >=", value, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreLessThan(Byte value) {
			addCriterion("is_ignore <", value, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreLessThanOrEqualTo(Byte value) {
			addCriterion("is_ignore <=", value, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreIn(List<Byte> values) {
			addCriterion("is_ignore in", values, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreNotIn(List<Byte> values) {
			addCriterion("is_ignore not in", values, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreBetween(Byte value1, Byte value2) {
			addCriterion("is_ignore between", value1, value2, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andIsIgnoreNotBetween(Byte value1, Byte value2) {
			addCriterion("is_ignore not between", value1, value2, "isIgnore");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagIsNull() {
			addCriterion("YOU_SHARE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagIsNotNull() {
			addCriterion("YOU_SHARE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagEqualTo(Byte value) {
			addCriterion("YOU_SHARE_FLAG =", value, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagNotEqualTo(Byte value) {
			addCriterion("YOU_SHARE_FLAG <>", value, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagGreaterThan(Byte value) {
			addCriterion("YOU_SHARE_FLAG >", value, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOU_SHARE_FLAG >=", value, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagLessThan(Byte value) {
			addCriterion("YOU_SHARE_FLAG <", value, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOU_SHARE_FLAG <=", value, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagIn(List<Byte> values) {
			addCriterion("YOU_SHARE_FLAG in", values, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagNotIn(List<Byte> values) {
			addCriterion("YOU_SHARE_FLAG not in", values, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOU_SHARE_FLAG between", value1, value2, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOU_SHARE_FLAG not between", value1, value2, "youShareFlag");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeIsNull() {
			addCriterion("YOU_SHARE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeIsNotNull() {
			addCriterion("YOU_SHARE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeEqualTo(Date value) {
			addCriterion("YOU_SHARE_TIME =", value, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeNotEqualTo(Date value) {
			addCriterion("YOU_SHARE_TIME <>", value, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeGreaterThan(Date value) {
			addCriterion("YOU_SHARE_TIME >", value, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("YOU_SHARE_TIME >=", value, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeLessThan(Date value) {
			addCriterion("YOU_SHARE_TIME <", value, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeLessThanOrEqualTo(Date value) {
			addCriterion("YOU_SHARE_TIME <=", value, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeIn(List<Date> values) {
			addCriterion("YOU_SHARE_TIME in", values, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeNotIn(List<Date> values) {
			addCriterion("YOU_SHARE_TIME not in", values, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeBetween(Date value1, Date value2) {
			addCriterion("YOU_SHARE_TIME between", value1, value2, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouShareTimeNotBetween(Date value1, Date value2) {
			addCriterion("YOU_SHARE_TIME not between", value1, value2, "youShareTime");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountIsNull() {
			addCriterion("YOU_BUY_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountIsNotNull() {
			addCriterion("YOU_BUY_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountEqualTo(Integer value) {
			addCriterion("YOU_BUY_COUNT =", value, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountNotEqualTo(Integer value) {
			addCriterion("YOU_BUY_COUNT <>", value, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountGreaterThan(Integer value) {
			addCriterion("YOU_BUY_COUNT >", value, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_BUY_COUNT >=", value, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountLessThan(Integer value) {
			addCriterion("YOU_BUY_COUNT <", value, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_BUY_COUNT <=", value, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountIn(List<Integer> values) {
			addCriterion("YOU_BUY_COUNT in", values, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountNotIn(List<Integer> values) {
			addCriterion("YOU_BUY_COUNT not in", values, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountBetween(Integer value1, Integer value2) {
			addCriterion("YOU_BUY_COUNT between", value1, value2, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andYouBuyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_BUY_COUNT not between", value1, value2, "youBuyCount");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdIsNull() {
			addCriterion("PRIVATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdIsNotNull() {
			addCriterion("PRIVATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdEqualTo(Integer value) {
			addCriterion("PRIVATE_USER_ID =", value, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdNotEqualTo(Integer value) {
			addCriterion("PRIVATE_USER_ID <>", value, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdGreaterThan(Integer value) {
			addCriterion("PRIVATE_USER_ID >", value, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PRIVATE_USER_ID >=", value, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdLessThan(Integer value) {
			addCriterion("PRIVATE_USER_ID <", value, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("PRIVATE_USER_ID <=", value, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdIn(List<Integer> values) {
			addCriterion("PRIVATE_USER_ID in", values, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdNotIn(List<Integer> values) {
			addCriterion("PRIVATE_USER_ID not in", values, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("PRIVATE_USER_ID between", value1, value2, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andPrivateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PRIVATE_USER_ID not between", value1, value2, "privateUserId");
			return (Criteria) this;
		}

		public Criteria andSyncTimeIsNull() {
			addCriterion("SYNC_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSyncTimeIsNotNull() {
			addCriterion("SYNC_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSyncTimeEqualTo(Date value) {
			addCriterion("SYNC_TIME =", value, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeNotEqualTo(Date value) {
			addCriterion("SYNC_TIME <>", value, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeGreaterThan(Date value) {
			addCriterion("SYNC_TIME >", value, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SYNC_TIME >=", value, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeLessThan(Date value) {
			addCriterion("SYNC_TIME <", value, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeLessThanOrEqualTo(Date value) {
			addCriterion("SYNC_TIME <=", value, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeIn(List<Date> values) {
			addCriterion("SYNC_TIME in", values, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeNotIn(List<Date> values) {
			addCriterion("SYNC_TIME not in", values, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeBetween(Date value1, Date value2) {
			addCriterion("SYNC_TIME between", value1, value2, "syncTime");
			return (Criteria) this;
		}

		public Criteria andSyncTimeNotBetween(Date value1, Date value2) {
			addCriterion("SYNC_TIME not between", value1, value2, "syncTime");
			return (Criteria) this;
		}

		public Criteria andYouShareIdIsNull() {
			addCriterion("YOU_SHARE_ID is null");
			return (Criteria) this;
		}

		public Criteria andYouShareIdIsNotNull() {
			addCriterion("YOU_SHARE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andYouShareIdEqualTo(Integer value) {
			addCriterion("YOU_SHARE_ID =", value, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdNotEqualTo(Integer value) {
			addCriterion("YOU_SHARE_ID <>", value, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdGreaterThan(Integer value) {
			addCriterion("YOU_SHARE_ID >", value, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOU_SHARE_ID >=", value, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdLessThan(Integer value) {
			addCriterion("YOU_SHARE_ID <", value, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdLessThanOrEqualTo(Integer value) {
			addCriterion("YOU_SHARE_ID <=", value, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdIn(List<Integer> values) {
			addCriterion("YOU_SHARE_ID in", values, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdNotIn(List<Integer> values) {
			addCriterion("YOU_SHARE_ID not in", values, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdBetween(Integer value1, Integer value2) {
			addCriterion("YOU_SHARE_ID between", value1, value2, "youShareId");
			return (Criteria) this;
		}

		public Criteria andYouShareIdNotBetween(Integer value1, Integer value2) {
			addCriterion("YOU_SHARE_ID not between", value1, value2, "youShareId");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeIsNull() {
			addCriterion("SPECIAL_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeIsNotNull() {
			addCriterion("SPECIAL_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeEqualTo(Date value) {
			addCriterion("SPECIAL_END_TIME =", value, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeNotEqualTo(Date value) {
			addCriterion("SPECIAL_END_TIME <>", value, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeGreaterThan(Date value) {
			addCriterion("SPECIAL_END_TIME >", value, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SPECIAL_END_TIME >=", value, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeLessThan(Date value) {
			addCriterion("SPECIAL_END_TIME <", value, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("SPECIAL_END_TIME <=", value, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeIn(List<Date> values) {
			addCriterion("SPECIAL_END_TIME in", values, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeNotIn(List<Date> values) {
			addCriterion("SPECIAL_END_TIME not in", values, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeBetween(Date value1, Date value2) {
			addCriterion("SPECIAL_END_TIME between", value1, value2, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andSpecialEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("SPECIAL_END_TIME not between", value1, value2, "specialEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeIsNull() {
			addCriterion("SCHEDULE_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeIsNotNull() {
			addCriterion("SCHEDULE_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeEqualTo(Date value) {
			addCriterion("SCHEDULE_END_TIME =", value, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeNotEqualTo(Date value) {
			addCriterion("SCHEDULE_END_TIME <>", value, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeGreaterThan(Date value) {
			addCriterion("SCHEDULE_END_TIME >", value, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SCHEDULE_END_TIME >=", value, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeLessThan(Date value) {
			addCriterion("SCHEDULE_END_TIME <", value, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("SCHEDULE_END_TIME <=", value, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeIn(List<Date> values) {
			addCriterion("SCHEDULE_END_TIME in", values, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeNotIn(List<Date> values) {
			addCriterion("SCHEDULE_END_TIME not in", values, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeBetween(Date value1, Date value2) {
			addCriterion("SCHEDULE_END_TIME between", value1, value2, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andScheduleEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("SCHEDULE_END_TIME not between", value1, value2, "scheduleEndTime");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagIsNull() {
			addCriterion("CITY_SHARE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagIsNotNull() {
			addCriterion("CITY_SHARE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG =", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagNotEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG <>", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagGreaterThan(Byte value) {
			addCriterion("CITY_SHARE_FLAG >", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG >=", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagLessThan(Byte value) {
			addCriterion("CITY_SHARE_FLAG <", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagLessThanOrEqualTo(Byte value) {
			addCriterion("CITY_SHARE_FLAG <=", value, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagIn(List<Byte> values) {
			addCriterion("CITY_SHARE_FLAG in", values, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagNotIn(List<Byte> values) {
			addCriterion("CITY_SHARE_FLAG not in", values, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagBetween(Byte value1, Byte value2) {
			addCriterion("CITY_SHARE_FLAG between", value1, value2, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andCityShareFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("CITY_SHARE_FLAG not between", value1, value2, "cityShareFlag");
			return (Criteria) this;
		}

		public Criteria andRoadsIdIsNull() {
			addCriterion("ROADS_ID is null");
			return (Criteria) this;
		}

		public Criteria andRoadsIdIsNotNull() {
			addCriterion("ROADS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRoadsIdEqualTo(String value) {
			addCriterion("ROADS_ID =", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdNotEqualTo(String value) {
			addCriterion("ROADS_ID <>", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdGreaterThan(String value) {
			addCriterion("ROADS_ID >", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdGreaterThanOrEqualTo(String value) {
			addCriterion("ROADS_ID >=", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdLessThan(String value) {
			addCriterion("ROADS_ID <", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdLessThanOrEqualTo(String value) {
			addCriterion("ROADS_ID <=", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdLike(String value) {
			addCriterion("ROADS_ID like", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdNotLike(String value) {
			addCriterion("ROADS_ID not like", value, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdIn(List<String> values) {
			addCriterion("ROADS_ID in", values, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdNotIn(List<String> values) {
			addCriterion("ROADS_ID not in", values, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdBetween(String value1, String value2) {
			addCriterion("ROADS_ID between", value1, value2, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsIdNotBetween(String value1, String value2) {
			addCriterion("ROADS_ID not between", value1, value2, "roadsId");
			return (Criteria) this;
		}

		public Criteria andRoadsNameIsNull() {
			addCriterion("ROADS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRoadsNameIsNotNull() {
			addCriterion("ROADS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRoadsNameEqualTo(String value) {
			addCriterion("ROADS_NAME =", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameNotEqualTo(String value) {
			addCriterion("ROADS_NAME <>", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameGreaterThan(String value) {
			addCriterion("ROADS_NAME >", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameGreaterThanOrEqualTo(String value) {
			addCriterion("ROADS_NAME >=", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameLessThan(String value) {
			addCriterion("ROADS_NAME <", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameLessThanOrEqualTo(String value) {
			addCriterion("ROADS_NAME <=", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameLike(String value) {
			addCriterion("ROADS_NAME like", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameNotLike(String value) {
			addCriterion("ROADS_NAME not like", value, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameIn(List<String> values) {
			addCriterion("ROADS_NAME in", values, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameNotIn(List<String> values) {
			addCriterion("ROADS_NAME not in", values, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameBetween(String value1, String value2) {
			addCriterion("ROADS_NAME between", value1, value2, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRoadsNameNotBetween(String value1, String value2) {
			addCriterion("ROADS_NAME not between", value1, value2, "roadsName");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeIsNull() {
			addCriterion("RESPITE_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeIsNotNull() {
			addCriterion("RESPITE_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeEqualTo(Date value) {
			addCriterion("RESPITE_END_TIME =", value, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeNotEqualTo(Date value) {
			addCriterion("RESPITE_END_TIME <>", value, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeGreaterThan(Date value) {
			addCriterion("RESPITE_END_TIME >", value, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("RESPITE_END_TIME >=", value, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeLessThan(Date value) {
			addCriterion("RESPITE_END_TIME <", value, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("RESPITE_END_TIME <=", value, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeIn(List<Date> values) {
			addCriterion("RESPITE_END_TIME in", values, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeNotIn(List<Date> values) {
			addCriterion("RESPITE_END_TIME not in", values, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeBetween(Date value1, Date value2) {
			addCriterion("RESPITE_END_TIME between", value1, value2, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andRespiteEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("RESPITE_END_TIME not between", value1, value2, "respiteEndTime");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseIsNull() {
			addCriterion("IS_SALE_LEASE is null");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseIsNotNull() {
			addCriterion("IS_SALE_LEASE is not null");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseEqualTo(Byte value) {
			addCriterion("IS_SALE_LEASE =", value, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseNotEqualTo(Byte value) {
			addCriterion("IS_SALE_LEASE <>", value, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseGreaterThan(Byte value) {
			addCriterion("IS_SALE_LEASE >", value, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SALE_LEASE >=", value, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseLessThan(Byte value) {
			addCriterion("IS_SALE_LEASE <", value, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SALE_LEASE <=", value, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseIn(List<Byte> values) {
			addCriterion("IS_SALE_LEASE in", values, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseNotIn(List<Byte> values) {
			addCriterion("IS_SALE_LEASE not in", values, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseBetween(Byte value1, Byte value2) {
			addCriterion("IS_SALE_LEASE between", value1, value2, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andIsSaleLeaseNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SALE_LEASE not between", value1, value2, "isSaleLease");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeIsNull() {
			addCriterion("AVAILABLE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeIsNotNull() {
			addCriterion("AVAILABLE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeEqualTo(Date value) {
			addCriterion("AVAILABLE_TIME =", value, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeNotEqualTo(Date value) {
			addCriterion("AVAILABLE_TIME <>", value, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeGreaterThan(Date value) {
			addCriterion("AVAILABLE_TIME >", value, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("AVAILABLE_TIME >=", value, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeLessThan(Date value) {
			addCriterion("AVAILABLE_TIME <", value, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeLessThanOrEqualTo(Date value) {
			addCriterion("AVAILABLE_TIME <=", value, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeIn(List<Date> values) {
			addCriterion("AVAILABLE_TIME in", values, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeNotIn(List<Date> values) {
			addCriterion("AVAILABLE_TIME not in", values, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeBetween(Date value1, Date value2) {
			addCriterion("AVAILABLE_TIME between", value1, value2, "availableTime");
			return (Criteria) this;
		}

		public Criteria andAvailableTimeNotBetween(Date value1, Date value2) {
			addCriterion("AVAILABLE_TIME not between", value1, value2, "availableTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeIsNull() {
			addCriterion("LAST_DKAN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeIsNotNull() {
			addCriterion("LAST_DKAN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeEqualTo(Date value) {
			addCriterion("LAST_DKAN_TIME =", value, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeNotEqualTo(Date value) {
			addCriterion("LAST_DKAN_TIME <>", value, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeGreaterThan(Date value) {
			addCriterion("LAST_DKAN_TIME >", value, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LAST_DKAN_TIME >=", value, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeLessThan(Date value) {
			addCriterion("LAST_DKAN_TIME <", value, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeLessThanOrEqualTo(Date value) {
			addCriterion("LAST_DKAN_TIME <=", value, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeIn(List<Date> values) {
			addCriterion("LAST_DKAN_TIME in", values, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeNotIn(List<Date> values) {
			addCriterion("LAST_DKAN_TIME not in", values, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeBetween(Date value1, Date value2) {
			addCriterion("LAST_DKAN_TIME between", value1, value2, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andLastDkanTimeNotBetween(Date value1, Date value2) {
			addCriterion("LAST_DKAN_TIME not between", value1, value2, "lastDkanTime");
			return (Criteria) this;
		}

		public Criteria andWechatNumberIsNull() {
			addCriterion("WECHAT_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andWechatNumberIsNotNull() {
			addCriterion("WECHAT_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andWechatNumberEqualTo(String value) {
			addCriterion("WECHAT_NUMBER =", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberNotEqualTo(String value) {
			addCriterion("WECHAT_NUMBER <>", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberGreaterThan(String value) {
			addCriterion("WECHAT_NUMBER >", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberGreaterThanOrEqualTo(String value) {
			addCriterion("WECHAT_NUMBER >=", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberLessThan(String value) {
			addCriterion("WECHAT_NUMBER <", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberLessThanOrEqualTo(String value) {
			addCriterion("WECHAT_NUMBER <=", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberLike(String value) {
			addCriterion("WECHAT_NUMBER like", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberNotLike(String value) {
			addCriterion("WECHAT_NUMBER not like", value, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberIn(List<String> values) {
			addCriterion("WECHAT_NUMBER in", values, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberNotIn(List<String> values) {
			addCriterion("WECHAT_NUMBER not in", values, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberBetween(String value1, String value2) {
			addCriterion("WECHAT_NUMBER between", value1, value2, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andWechatNumberNotBetween(String value1, String value2) {
			addCriterion("WECHAT_NUMBER not between", value1, value2, "wechatNumber");
			return (Criteria) this;
		}

		public Criteria andCustPhotoIsNull() {
			addCriterion("CUST_PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andCustPhotoIsNotNull() {
			addCriterion("CUST_PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andCustPhotoEqualTo(String value) {
			addCriterion("CUST_PHOTO =", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoNotEqualTo(String value) {
			addCriterion("CUST_PHOTO <>", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoGreaterThan(String value) {
			addCriterion("CUST_PHOTO >", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_PHOTO >=", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoLessThan(String value) {
			addCriterion("CUST_PHOTO <", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoLessThanOrEqualTo(String value) {
			addCriterion("CUST_PHOTO <=", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoLike(String value) {
			addCriterion("CUST_PHOTO like", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoNotLike(String value) {
			addCriterion("CUST_PHOTO not like", value, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoIn(List<String> values) {
			addCriterion("CUST_PHOTO in", values, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoNotIn(List<String> values) {
			addCriterion("CUST_PHOTO not in", values, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoBetween(String value1, String value2) {
			addCriterion("CUST_PHOTO between", value1, value2, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andCustPhotoNotBetween(String value1, String value2) {
			addCriterion("CUST_PHOTO not between", value1, value2, "custPhoto");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeIsNull() {
			addCriterion("ID_CARD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeIsNotNull() {
			addCriterion("ID_CARD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeEqualTo(Integer value) {
			addCriterion("ID_CARD_TYPE =", value, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeNotEqualTo(Integer value) {
			addCriterion("ID_CARD_TYPE <>", value, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeGreaterThan(Integer value) {
			addCriterion("ID_CARD_TYPE >", value, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID_CARD_TYPE >=", value, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeLessThan(Integer value) {
			addCriterion("ID_CARD_TYPE <", value, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("ID_CARD_TYPE <=", value, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeIn(List<Integer> values) {
			addCriterion("ID_CARD_TYPE in", values, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeNotIn(List<Integer> values) {
			addCriterion("ID_CARD_TYPE not in", values, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeBetween(Integer value1, Integer value2) {
			addCriterion("ID_CARD_TYPE between", value1, value2, "idCardType");
			return (Criteria) this;
		}

		public Criteria andIdCardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("ID_CARD_TYPE not between", value1, value2, "idCardType");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyIsNull() {
			addCriterion("BUY_QUALIFY is null");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyIsNotNull() {
			addCriterion("BUY_QUALIFY is not null");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyEqualTo(Byte value) {
			addCriterion("BUY_QUALIFY =", value, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyNotEqualTo(Byte value) {
			addCriterion("BUY_QUALIFY <>", value, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyGreaterThan(Byte value) {
			addCriterion("BUY_QUALIFY >", value, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_QUALIFY >=", value, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyLessThan(Byte value) {
			addCriterion("BUY_QUALIFY <", value, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_QUALIFY <=", value, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyIn(List<Byte> values) {
			addCriterion("BUY_QUALIFY in", values, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyNotIn(List<Byte> values) {
			addCriterion("BUY_QUALIFY not in", values, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyBetween(Byte value1, Byte value2) {
			addCriterion("BUY_QUALIFY between", value1, value2, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyQualifyNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_QUALIFY not between", value1, value2, "buyQualify");
			return (Criteria) this;
		}

		public Criteria andBuyNumIsNull() {
			addCriterion("BUY_NUM is null");
			return (Criteria) this;
		}

		public Criteria andBuyNumIsNotNull() {
			addCriterion("BUY_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andBuyNumEqualTo(Byte value) {
			addCriterion("BUY_NUM =", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumNotEqualTo(Byte value) {
			addCriterion("BUY_NUM <>", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumGreaterThan(Byte value) {
			addCriterion("BUY_NUM >", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_NUM >=", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumLessThan(Byte value) {
			addCriterion("BUY_NUM <", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_NUM <=", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumIn(List<Byte> values) {
			addCriterion("BUY_NUM in", values, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumNotIn(List<Byte> values) {
			addCriterion("BUY_NUM not in", values, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumBetween(Byte value1, Byte value2) {
			addCriterion("BUY_NUM between", value1, value2, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_NUM not between", value1, value2, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusIsNull() {
			addCriterion("BUY_CURRENT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusIsNotNull() {
			addCriterion("BUY_CURRENT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusEqualTo(Byte value) {
			addCriterion("BUY_CURRENT_STATUS =", value, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusNotEqualTo(Byte value) {
			addCriterion("BUY_CURRENT_STATUS <>", value, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusGreaterThan(Byte value) {
			addCriterion("BUY_CURRENT_STATUS >", value, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_CURRENT_STATUS >=", value, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusLessThan(Byte value) {
			addCriterion("BUY_CURRENT_STATUS <", value, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_CURRENT_STATUS <=", value, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusIn(List<Byte> values) {
			addCriterion("BUY_CURRENT_STATUS in", values, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusNotIn(List<Byte> values) {
			addCriterion("BUY_CURRENT_STATUS not in", values, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CURRENT_STATUS between", value1, value2, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCurrentStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_CURRENT_STATUS not between", value1, value2, "buyCurrentStatus");
			return (Criteria) this;
		}

		public Criteria andCreditIsNull() {
			addCriterion("CREDIT is null");
			return (Criteria) this;
		}

		public Criteria andCreditIsNotNull() {
			addCriterion("CREDIT is not null");
			return (Criteria) this;
		}

		public Criteria andCreditEqualTo(Byte value) {
			addCriterion("CREDIT =", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditNotEqualTo(Byte value) {
			addCriterion("CREDIT <>", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditGreaterThan(Byte value) {
			addCriterion("CREDIT >", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditGreaterThanOrEqualTo(Byte value) {
			addCriterion("CREDIT >=", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditLessThan(Byte value) {
			addCriterion("CREDIT <", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditLessThanOrEqualTo(Byte value) {
			addCriterion("CREDIT <=", value, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditIn(List<Byte> values) {
			addCriterion("CREDIT in", values, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditNotIn(List<Byte> values) {
			addCriterion("CREDIT not in", values, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditBetween(Byte value1, Byte value2) {
			addCriterion("CREDIT between", value1, value2, "credit");
			return (Criteria) this;
		}

		public Criteria andCreditNotBetween(Byte value1, Byte value2) {
			addCriterion("CREDIT not between", value1, value2, "credit");
			return (Criteria) this;
		}

		public Criteria andVehicleIsNull() {
			addCriterion("VEHICLE is null");
			return (Criteria) this;
		}

		public Criteria andVehicleIsNotNull() {
			addCriterion("VEHICLE is not null");
			return (Criteria) this;
		}

		public Criteria andVehicleEqualTo(Byte value) {
			addCriterion("VEHICLE =", value, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleNotEqualTo(Byte value) {
			addCriterion("VEHICLE <>", value, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleGreaterThan(Byte value) {
			addCriterion("VEHICLE >", value, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleGreaterThanOrEqualTo(Byte value) {
			addCriterion("VEHICLE >=", value, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleLessThan(Byte value) {
			addCriterion("VEHICLE <", value, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleLessThanOrEqualTo(Byte value) {
			addCriterion("VEHICLE <=", value, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleIn(List<Byte> values) {
			addCriterion("VEHICLE in", values, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleNotIn(List<Byte> values) {
			addCriterion("VEHICLE not in", values, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleBetween(Byte value1, Byte value2) {
			addCriterion("VEHICLE between", value1, value2, "vehicle");
			return (Criteria) this;
		}

		public Criteria andVehicleNotBetween(Byte value1, Byte value2) {
			addCriterion("VEHICLE not between", value1, value2, "vehicle");
			return (Criteria) this;
		}

		public Criteria andMentalityIsNull() {
			addCriterion("MENTALITY is null");
			return (Criteria) this;
		}

		public Criteria andMentalityIsNotNull() {
			addCriterion("MENTALITY is not null");
			return (Criteria) this;
		}

		public Criteria andMentalityEqualTo(Byte value) {
			addCriterion("MENTALITY =", value, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityNotEqualTo(Byte value) {
			addCriterion("MENTALITY <>", value, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityGreaterThan(Byte value) {
			addCriterion("MENTALITY >", value, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityGreaterThanOrEqualTo(Byte value) {
			addCriterion("MENTALITY >=", value, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityLessThan(Byte value) {
			addCriterion("MENTALITY <", value, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityLessThanOrEqualTo(Byte value) {
			addCriterion("MENTALITY <=", value, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityIn(List<Byte> values) {
			addCriterion("MENTALITY in", values, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityNotIn(List<Byte> values) {
			addCriterion("MENTALITY not in", values, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityBetween(Byte value1, Byte value2) {
			addCriterion("MENTALITY between", value1, value2, "mentality");
			return (Criteria) this;
		}

		public Criteria andMentalityNotBetween(Byte value1, Byte value2) {
			addCriterion("MENTALITY not between", value1, value2, "mentality");
			return (Criteria) this;
		}

		public Criteria andCUserIdIsNull() {
			addCriterion("C_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCUserIdIsNotNull() {
			addCriterion("C_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCUserIdEqualTo(Integer value) {
			addCriterion("C_USER_ID =", value, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdNotEqualTo(Integer value) {
			addCriterion("C_USER_ID <>", value, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdGreaterThan(Integer value) {
			addCriterion("C_USER_ID >", value, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("C_USER_ID >=", value, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdLessThan(Integer value) {
			addCriterion("C_USER_ID <", value, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("C_USER_ID <=", value, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdIn(List<Integer> values) {
			addCriterion("C_USER_ID in", values, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdNotIn(List<Integer> values) {
			addCriterion("C_USER_ID not in", values, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdBetween(Integer value1, Integer value2) {
			addCriterion("C_USER_ID between", value1, value2, "cUserId");
			return (Criteria) this;
		}

		public Criteria andCUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("C_USER_ID not between", value1, value2, "cUserId");
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

		public Criteria andCustSourceIsNull() {
			addCriterion("CUST_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andCustSourceIsNotNull() {
			addCriterion("CUST_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andCustSourceEqualTo(Integer value) {
			addCriterion("CUST_SOURCE =", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceNotEqualTo(Integer value) {
			addCriterion("CUST_SOURCE <>", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceGreaterThan(Integer value) {
			addCriterion("CUST_SOURCE >", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUST_SOURCE >=", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceLessThan(Integer value) {
			addCriterion("CUST_SOURCE <", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceLessThanOrEqualTo(Integer value) {
			addCriterion("CUST_SOURCE <=", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceIn(List<Integer> values) {
			addCriterion("CUST_SOURCE in", values, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceNotIn(List<Integer> values) {
			addCriterion("CUST_SOURCE not in", values, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceBetween(Integer value1, Integer value2) {
			addCriterion("CUST_SOURCE between", value1, value2, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceNotBetween(Integer value1, Integer value2) {
			addCriterion("CUST_SOURCE not between", value1, value2, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustIntentionIsNull() {
			addCriterion("CUST_INTENTION is null");
			return (Criteria) this;
		}

		public Criteria andCustIntentionIsNotNull() {
			addCriterion("CUST_INTENTION is not null");
			return (Criteria) this;
		}

		public Criteria andCustIntentionEqualTo(Integer value) {
			addCriterion("CUST_INTENTION =", value, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionNotEqualTo(Integer value) {
			addCriterion("CUST_INTENTION <>", value, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionGreaterThan(Integer value) {
			addCriterion("CUST_INTENTION >", value, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUST_INTENTION >=", value, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionLessThan(Integer value) {
			addCriterion("CUST_INTENTION <", value, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionLessThanOrEqualTo(Integer value) {
			addCriterion("CUST_INTENTION <=", value, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionIn(List<Integer> values) {
			addCriterion("CUST_INTENTION in", values, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionNotIn(List<Integer> values) {
			addCriterion("CUST_INTENTION not in", values, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionBetween(Integer value1, Integer value2) {
			addCriterion("CUST_INTENTION between", value1, value2, "custIntention");
			return (Criteria) this;
		}

		public Criteria andCustIntentionNotBetween(Integer value1, Integer value2) {
			addCriterion("CUST_INTENTION not between", value1, value2, "custIntention");
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