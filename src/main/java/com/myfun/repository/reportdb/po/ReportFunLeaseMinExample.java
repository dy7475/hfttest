package com.myfun.repository.reportdb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ReportFunLeaseMinExample {
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
	public ReportFunLeaseMinExample() {
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

		public Criteria andLeaseIdIsNull() {
			addCriterion("LEASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andLeaseIdIsNotNull() {
			addCriterion("LEASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseIdEqualTo(Integer value) {
			addCriterion("LEASE_ID =", value, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdNotEqualTo(Integer value) {
			addCriterion("LEASE_ID <>", value, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdGreaterThan(Integer value) {
			addCriterion("LEASE_ID >", value, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_ID >=", value, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdLessThan(Integer value) {
			addCriterion("LEASE_ID <", value, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_ID <=", value, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdIn(List<Integer> values) {
			addCriterion("LEASE_ID in", values, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdNotIn(List<Integer> values) {
			addCriterion("LEASE_ID not in", values, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_ID between", value1, value2, "leaseId");
			return (Criteria) this;
		}

		public Criteria andLeaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_ID not between", value1, value2, "leaseId");
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

		public Criteria andLastSyncTimeIsNull() {
			addCriterion("LAST_SYNC_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeIsNotNull() {
			addCriterion("LAST_SYNC_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeEqualTo(String value) {
			addCriterion("LAST_SYNC_TIME =", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeNotEqualTo(String value) {
			addCriterion("LAST_SYNC_TIME <>", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeGreaterThan(String value) {
			addCriterion("LAST_SYNC_TIME >", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeGreaterThanOrEqualTo(String value) {
			addCriterion("LAST_SYNC_TIME >=", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeLessThan(String value) {
			addCriterion("LAST_SYNC_TIME <", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeLessThanOrEqualTo(String value) {
			addCriterion("LAST_SYNC_TIME <=", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeLike(String value) {
			addCriterion("LAST_SYNC_TIME like", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeNotLike(String value) {
			addCriterion("LAST_SYNC_TIME not like", value, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeIn(List<String> values) {
			addCriterion("LAST_SYNC_TIME in", values, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeNotIn(List<String> values) {
			addCriterion("LAST_SYNC_TIME not in", values, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeBetween(String value1, String value2) {
			addCriterion("LAST_SYNC_TIME between", value1, value2, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLastSyncTimeNotBetween(String value1, String value2) {
			addCriterion("LAST_SYNC_TIME not between", value1, value2, "lastSyncTime");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusIsNull() {
			addCriterion("LEASE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusIsNotNull() {
			addCriterion("LEASE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusEqualTo(Integer value) {
			addCriterion("LEASE_STATUS =", value, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusNotEqualTo(Integer value) {
			addCriterion("LEASE_STATUS <>", value, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusGreaterThan(Integer value) {
			addCriterion("LEASE_STATUS >", value, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_STATUS >=", value, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusLessThan(Integer value) {
			addCriterion("LEASE_STATUS <", value, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_STATUS <=", value, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusIn(List<Integer> values) {
			addCriterion("LEASE_STATUS in", values, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusNotIn(List<Integer> values) {
			addCriterion("LEASE_STATUS not in", values, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_STATUS between", value1, value2, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_STATUS not between", value1, value2, "leaseStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomIsNull() {
			addCriterion("LEASE_ROOM is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomIsNotNull() {
			addCriterion("LEASE_ROOM is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomEqualTo(Byte value) {
			addCriterion("LEASE_ROOM =", value, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomNotEqualTo(Byte value) {
			addCriterion("LEASE_ROOM <>", value, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomGreaterThan(Byte value) {
			addCriterion("LEASE_ROOM >", value, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROOM >=", value, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomLessThan(Byte value) {
			addCriterion("LEASE_ROOM <", value, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROOM <=", value, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomIn(List<Byte> values) {
			addCriterion("LEASE_ROOM in", values, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomNotIn(List<Byte> values) {
			addCriterion("LEASE_ROOM not in", values, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROOM between", value1, value2, "leaseRoom");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROOM not between", value1, value2, "leaseRoom");
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

		public Criteria andSectionIdEqualTo(Integer value) {
			addCriterion("SECTION_ID =", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotEqualTo(Integer value) {
			addCriterion("SECTION_ID <>", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThan(Integer value) {
			addCriterion("SECTION_ID >", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID >=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThan(Integer value) {
			addCriterion("SECTION_ID <", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID <=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdIn(List<Integer> values) {
			addCriterion("SECTION_ID in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotIn(List<Integer> values) {
			addCriterion("SECTION_ID not in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID not between", value1, value2, "sectionId");
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

		public Criteria andBuildIdEqualTo(Integer value) {
			addCriterion("BUILD_ID =", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotEqualTo(Integer value) {
			addCriterion("BUILD_ID <>", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThan(Integer value) {
			addCriterion("BUILD_ID >", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID >=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThan(Integer value) {
			addCriterion("BUILD_ID <", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID <=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdIn(List<Integer> values) {
			addCriterion("BUILD_ID in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotIn(List<Integer> values) {
			addCriterion("BUILD_ID not in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID not between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andLeaseRegIsNull() {
			addCriterion("LEASE_REG is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRegIsNotNull() {
			addCriterion("LEASE_REG is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRegEqualTo(Integer value) {
			addCriterion("LEASE_REG =", value, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegNotEqualTo(Integer value) {
			addCriterion("LEASE_REG <>", value, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegGreaterThan(Integer value) {
			addCriterion("LEASE_REG >", value, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_REG >=", value, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegLessThan(Integer value) {
			addCriterion("LEASE_REG <", value, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_REG <=", value, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegIn(List<Integer> values) {
			addCriterion("LEASE_REG in", values, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegNotIn(List<Integer> values) {
			addCriterion("LEASE_REG not in", values, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_REG between", value1, value2, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseRegNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_REG not between", value1, value2, "leaseReg");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageIsNull() {
			addCriterion("LEASE_USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageIsNotNull() {
			addCriterion("LEASE_USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageEqualTo(Byte value) {
			addCriterion("LEASE_USEAGE =", value, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageNotEqualTo(Byte value) {
			addCriterion("LEASE_USEAGE <>", value, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageGreaterThan(Byte value) {
			addCriterion("LEASE_USEAGE >", value, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_USEAGE >=", value, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageLessThan(Byte value) {
			addCriterion("LEASE_USEAGE <", value, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_USEAGE <=", value, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageIn(List<Byte> values) {
			addCriterion("LEASE_USEAGE in", values, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageNotIn(List<Byte> values) {
			addCriterion("LEASE_USEAGE not in", values, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_USEAGE between", value1, value2, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseUseageNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_USEAGE not between", value1, value2, "leaseUseage");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeIsNull() {
			addCriterion("LEASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeIsNotNull() {
			addCriterion("LEASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeEqualTo(Byte value) {
			addCriterion("LEASE_TYPE =", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeNotEqualTo(Byte value) {
			addCriterion("LEASE_TYPE <>", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeGreaterThan(Byte value) {
			addCriterion("LEASE_TYPE >", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_TYPE >=", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeLessThan(Byte value) {
			addCriterion("LEASE_TYPE <", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_TYPE <=", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeIn(List<Byte> values) {
			addCriterion("LEASE_TYPE in", values, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeNotIn(List<Byte> values) {
			addCriterion("LEASE_TYPE not in", values, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_TYPE between", value1, value2, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_TYPE not between", value1, value2, "leaseType");
			return (Criteria) this;
		}

		public Criteria andUnitFloorIsNull() {
			addCriterion("UNIT_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andUnitFloorIsNotNull() {
			addCriterion("UNIT_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andUnitFloorEqualTo(String value) {
			addCriterion("UNIT_FLOOR =", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorNotEqualTo(String value) {
			addCriterion("UNIT_FLOOR <>", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorGreaterThan(String value) {
			addCriterion("UNIT_FLOOR >", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorGreaterThanOrEqualTo(String value) {
			addCriterion("UNIT_FLOOR >=", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorLessThan(String value) {
			addCriterion("UNIT_FLOOR <", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorLessThanOrEqualTo(String value) {
			addCriterion("UNIT_FLOOR <=", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorLike(String value) {
			addCriterion("UNIT_FLOOR like", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorNotLike(String value) {
			addCriterion("UNIT_FLOOR not like", value, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorIn(List<String> values) {
			addCriterion("UNIT_FLOOR in", values, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorNotIn(List<String> values) {
			addCriterion("UNIT_FLOOR not in", values, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorBetween(String value1, String value2) {
			addCriterion("UNIT_FLOOR between", value1, value2, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andUnitFloorNotBetween(String value1, String value2) {
			addCriterion("UNIT_FLOOR not between", value1, value2, "unitFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyIsNull() {
			addCriterion("LEASE_KEY is null");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyIsNotNull() {
			addCriterion("LEASE_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyEqualTo(Boolean value) {
			addCriterion("LEASE_KEY =", value, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNotEqualTo(Boolean value) {
			addCriterion("LEASE_KEY <>", value, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyGreaterThan(Boolean value) {
			addCriterion("LEASE_KEY >", value, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyGreaterThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_KEY >=", value, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyLessThan(Boolean value) {
			addCriterion("LEASE_KEY <", value, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyLessThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_KEY <=", value, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyIn(List<Boolean> values) {
			addCriterion("LEASE_KEY in", values, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNotIn(List<Boolean> values) {
			addCriterion("LEASE_KEY not in", values, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_KEY between", value1, value2, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNotBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_KEY not between", value1, value2, "leaseKey");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthIsNull() {
			addCriterion("LEASE_EXPLRTH is null");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthIsNotNull() {
			addCriterion("LEASE_EXPLRTH is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthEqualTo(Boolean value) {
			addCriterion("LEASE_EXPLRTH =", value, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthNotEqualTo(Boolean value) {
			addCriterion("LEASE_EXPLRTH <>", value, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthGreaterThan(Boolean value) {
			addCriterion("LEASE_EXPLRTH >", value, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthGreaterThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_EXPLRTH >=", value, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthLessThan(Boolean value) {
			addCriterion("LEASE_EXPLRTH <", value, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthLessThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_EXPLRTH <=", value, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthIn(List<Boolean> values) {
			addCriterion("LEASE_EXPLRTH in", values, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthNotIn(List<Boolean> values) {
			addCriterion("LEASE_EXPLRTH not in", values, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_EXPLRTH between", value1, value2, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andLeaseExplrthNotBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_EXPLRTH not between", value1, value2, "leaseExplrth");
			return (Criteria) this;
		}

		public Criteria andTrueFlagIsNull() {
			addCriterion("TRUE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andTrueFlagIsNotNull() {
			addCriterion("TRUE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andTrueFlagEqualTo(Byte value) {
			addCriterion("TRUE_FLAG =", value, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagNotEqualTo(Byte value) {
			addCriterion("TRUE_FLAG <>", value, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagGreaterThan(Byte value) {
			addCriterion("TRUE_FLAG >", value, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRUE_FLAG >=", value, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagLessThan(Byte value) {
			addCriterion("TRUE_FLAG <", value, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagLessThanOrEqualTo(Byte value) {
			addCriterion("TRUE_FLAG <=", value, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagIn(List<Byte> values) {
			addCriterion("TRUE_FLAG in", values, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagNotIn(List<Byte> values) {
			addCriterion("TRUE_FLAG not in", values, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagBetween(Byte value1, Byte value2) {
			addCriterion("TRUE_FLAG between", value1, value2, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andTrueFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("TRUE_FLAG not between", value1, value2, "trueFlag");
			return (Criteria) this;
		}

		public Criteria andLeaseMapIsNull() {
			addCriterion("LEASE_MAP is null");
			return (Criteria) this;
		}

		public Criteria andLeaseMapIsNotNull() {
			addCriterion("LEASE_MAP is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseMapEqualTo(Integer value) {
			addCriterion("LEASE_MAP =", value, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapNotEqualTo(Integer value) {
			addCriterion("LEASE_MAP <>", value, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapGreaterThan(Integer value) {
			addCriterion("LEASE_MAP >", value, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_MAP >=", value, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapLessThan(Integer value) {
			addCriterion("LEASE_MAP <", value, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_MAP <=", value, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapIn(List<Integer> values) {
			addCriterion("LEASE_MAP in", values, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapNotIn(List<Integer> values) {
			addCriterion("LEASE_MAP not in", values, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_MAP between", value1, value2, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andLeaseMapNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_MAP not between", value1, value2, "leaseMap");
			return (Criteria) this;
		}

		public Criteria andVideoNumIsNull() {
			addCriterion("VIDEO_NUM is null");
			return (Criteria) this;
		}

		public Criteria andVideoNumIsNotNull() {
			addCriterion("VIDEO_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andVideoNumEqualTo(Integer value) {
			addCriterion("VIDEO_NUM =", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumNotEqualTo(Integer value) {
			addCriterion("VIDEO_NUM <>", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumGreaterThan(Integer value) {
			addCriterion("VIDEO_NUM >", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("VIDEO_NUM >=", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumLessThan(Integer value) {
			addCriterion("VIDEO_NUM <", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumLessThanOrEqualTo(Integer value) {
			addCriterion("VIDEO_NUM <=", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumIn(List<Integer> values) {
			addCriterion("VIDEO_NUM in", values, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumNotIn(List<Integer> values) {
			addCriterion("VIDEO_NUM not in", values, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumBetween(Integer value1, Integer value2) {
			addCriterion("VIDEO_NUM between", value1, value2, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumNotBetween(Integer value1, Integer value2) {
			addCriterion("VIDEO_NUM not between", value1, value2, "videoNum");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapIsNull() {
			addCriterion("PANORAMA_MAP is null");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapIsNotNull() {
			addCriterion("PANORAMA_MAP is not null");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapEqualTo(Integer value) {
			addCriterion("PANORAMA_MAP =", value, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapNotEqualTo(Integer value) {
			addCriterion("PANORAMA_MAP <>", value, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapGreaterThan(Integer value) {
			addCriterion("PANORAMA_MAP >", value, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapGreaterThanOrEqualTo(Integer value) {
			addCriterion("PANORAMA_MAP >=", value, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapLessThan(Integer value) {
			addCriterion("PANORAMA_MAP <", value, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapLessThanOrEqualTo(Integer value) {
			addCriterion("PANORAMA_MAP <=", value, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapIn(List<Integer> values) {
			addCriterion("PANORAMA_MAP in", values, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapNotIn(List<Integer> values) {
			addCriterion("PANORAMA_MAP not in", values, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapBetween(Integer value1, Integer value2) {
			addCriterion("PANORAMA_MAP between", value1, value2, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andPanoramaMapNotBetween(Integer value1, Integer value2) {
			addCriterion("PANORAMA_MAP not between", value1, value2, "panoramaMap");
			return (Criteria) this;
		}

		public Criteria andHasFunkanIsNull() {
			addCriterion("HAS_FUNKAN is null");
			return (Criteria) this;
		}

		public Criteria andHasFunkanIsNotNull() {
			addCriterion("HAS_FUNKAN is not null");
			return (Criteria) this;
		}

		public Criteria andHasFunkanEqualTo(Byte value) {
			addCriterion("HAS_FUNKAN =", value, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanNotEqualTo(Byte value) {
			addCriterion("HAS_FUNKAN <>", value, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanGreaterThan(Byte value) {
			addCriterion("HAS_FUNKAN >", value, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_FUNKAN >=", value, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanLessThan(Byte value) {
			addCriterion("HAS_FUNKAN <", value, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_FUNKAN <=", value, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanIn(List<Byte> values) {
			addCriterion("HAS_FUNKAN in", values, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanNotIn(List<Byte> values) {
			addCriterion("HAS_FUNKAN not in", values, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanBetween(Byte value1, Byte value2) {
			addCriterion("HAS_FUNKAN between", value1, value2, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andHasFunkanNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_FUNKAN not between", value1, value2, "hasFunkan");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaIsNull() {
			addCriterion("LEASE_AREA is null");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaIsNotNull() {
			addCriterion("LEASE_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaEqualTo(BigDecimal value) {
			addCriterion("LEASE_AREA =", value, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_AREA <>", value, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaGreaterThan(BigDecimal value) {
			addCriterion("LEASE_AREA >", value, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_AREA >=", value, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaLessThan(BigDecimal value) {
			addCriterion("LEASE_AREA <", value, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_AREA <=", value, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaIn(List<BigDecimal> values) {
			addCriterion("LEASE_AREA in", values, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_AREA not in", values, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_AREA between", value1, value2, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_AREA not between", value1, value2, "leaseArea");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceIsNull() {
			addCriterion("LEASE_TOTAL_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceIsNotNull() {
			addCriterion("LEASE_TOTAL_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceEqualTo(BigDecimal value) {
			addCriterion("LEASE_TOTAL_PRICE =", value, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_TOTAL_PRICE <>", value, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_TOTAL_PRICE >", value, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_TOTAL_PRICE >=", value, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceLessThan(BigDecimal value) {
			addCriterion("LEASE_TOTAL_PRICE <", value, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_TOTAL_PRICE <=", value, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceIn(List<BigDecimal> values) {
			addCriterion("LEASE_TOTAL_PRICE in", values, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_TOTAL_PRICE not in", values, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_TOTAL_PRICE between", value1, value2, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_TOTAL_PRICE not between", value1, value2, "leaseTotalPrice");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIsNull() {
			addCriterion("PRICE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIsNotNull() {
			addCriterion("PRICE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andPriceUnitEqualTo(Byte value) {
			addCriterion("PRICE_UNIT =", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotEqualTo(Byte value) {
			addCriterion("PRICE_UNIT <>", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitGreaterThan(Byte value) {
			addCriterion("PRICE_UNIT >", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitGreaterThanOrEqualTo(Byte value) {
			addCriterion("PRICE_UNIT >=", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitLessThan(Byte value) {
			addCriterion("PRICE_UNIT <", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitLessThanOrEqualTo(Byte value) {
			addCriterion("PRICE_UNIT <=", value, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitIn(List<Byte> values) {
			addCriterion("PRICE_UNIT in", values, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotIn(List<Byte> values) {
			addCriterion("PRICE_UNIT not in", values, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitBetween(Byte value1, Byte value2) {
			addCriterion("PRICE_UNIT between", value1, value2, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andPriceUnitNotBetween(Byte value1, Byte value2) {
			addCriterion("PRICE_UNIT not between", value1, value2, "priceUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceIsNull() {
			addCriterion("LEASE_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceIsNotNull() {
			addCriterion("LEASE_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceEqualTo(Byte value) {
			addCriterion("LEASE_SOURCE =", value, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceNotEqualTo(Byte value) {
			addCriterion("LEASE_SOURCE <>", value, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceGreaterThan(Byte value) {
			addCriterion("LEASE_SOURCE >", value, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_SOURCE >=", value, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceLessThan(Byte value) {
			addCriterion("LEASE_SOURCE <", value, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_SOURCE <=", value, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceIn(List<Byte> values) {
			addCriterion("LEASE_SOURCE in", values, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceNotIn(List<Byte> values) {
			addCriterion("LEASE_SOURCE not in", values, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_SOURCE between", value1, value2, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andLeaseSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_SOURCE not between", value1, value2, "leaseSource");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagIsNull() {
			addCriterion("HAVE_TAG_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagIsNotNull() {
			addCriterion("HAVE_TAG_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagEqualTo(Byte value) {
			addCriterion("HAVE_TAG_FLAG =", value, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagNotEqualTo(Byte value) {
			addCriterion("HAVE_TAG_FLAG <>", value, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagGreaterThan(Byte value) {
			addCriterion("HAVE_TAG_FLAG >", value, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAVE_TAG_FLAG >=", value, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagLessThan(Byte value) {
			addCriterion("HAVE_TAG_FLAG <", value, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagLessThanOrEqualTo(Byte value) {
			addCriterion("HAVE_TAG_FLAG <=", value, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagIn(List<Byte> values) {
			addCriterion("HAVE_TAG_FLAG in", values, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagNotIn(List<Byte> values) {
			addCriterion("HAVE_TAG_FLAG not in", values, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagBetween(Byte value1, Byte value2) {
			addCriterion("HAVE_TAG_FLAG between", value1, value2, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveTagFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("HAVE_TAG_FLAG not between", value1, value2, "haveTagFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagIsNull() {
			addCriterion("HAVE_LAYOUT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagIsNotNull() {
			addCriterion("HAVE_LAYOUT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagEqualTo(Byte value) {
			addCriterion("HAVE_LAYOUT_FLAG =", value, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagNotEqualTo(Byte value) {
			addCriterion("HAVE_LAYOUT_FLAG <>", value, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagGreaterThan(Byte value) {
			addCriterion("HAVE_LAYOUT_FLAG >", value, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAVE_LAYOUT_FLAG >=", value, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagLessThan(Byte value) {
			addCriterion("HAVE_LAYOUT_FLAG <", value, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagLessThanOrEqualTo(Byte value) {
			addCriterion("HAVE_LAYOUT_FLAG <=", value, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagIn(List<Byte> values) {
			addCriterion("HAVE_LAYOUT_FLAG in", values, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagNotIn(List<Byte> values) {
			addCriterion("HAVE_LAYOUT_FLAG not in", values, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagBetween(Byte value1, Byte value2) {
			addCriterion("HAVE_LAYOUT_FLAG between", value1, value2, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andHaveLayoutFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("HAVE_LAYOUT_FLAG not between", value1, value2, "haveLayoutFlag");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignIsNull() {
			addCriterion("LEASE_CONSIGN is null");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignIsNotNull() {
			addCriterion("LEASE_CONSIGN is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignEqualTo(Byte value) {
			addCriterion("LEASE_CONSIGN =", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNotEqualTo(Byte value) {
			addCriterion("LEASE_CONSIGN <>", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignGreaterThan(Byte value) {
			addCriterion("LEASE_CONSIGN >", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_CONSIGN >=", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignLessThan(Byte value) {
			addCriterion("LEASE_CONSIGN <", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_CONSIGN <=", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignIn(List<Byte> values) {
			addCriterion("LEASE_CONSIGN in", values, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNotIn(List<Byte> values) {
			addCriterion("LEASE_CONSIGN not in", values, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_CONSIGN between", value1, value2, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_CONSIGN not between", value1, value2, "leaseConsign");
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

		public Criteria andRepeatFlagEqualTo(Byte value) {
			addCriterion("REPEAT_FLAG =", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotEqualTo(Byte value) {
			addCriterion("REPEAT_FLAG <>", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagGreaterThan(Byte value) {
			addCriterion("REPEAT_FLAG >", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("REPEAT_FLAG >=", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagLessThan(Byte value) {
			addCriterion("REPEAT_FLAG <", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagLessThanOrEqualTo(Byte value) {
			addCriterion("REPEAT_FLAG <=", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagIn(List<Byte> values) {
			addCriterion("REPEAT_FLAG in", values, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotIn(List<Byte> values) {
			addCriterion("REPEAT_FLAG not in", values, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagBetween(Byte value1, Byte value2) {
			addCriterion("REPEAT_FLAG between", value1, value2, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("REPEAT_FLAG not between", value1, value2, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andLeasePublishIsNull() {
			addCriterion("LEASE_PUBLISH is null");
			return (Criteria) this;
		}

		public Criteria andLeasePublishIsNotNull() {
			addCriterion("LEASE_PUBLISH is not null");
			return (Criteria) this;
		}

		public Criteria andLeasePublishEqualTo(Boolean value) {
			addCriterion("LEASE_PUBLISH =", value, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishNotEqualTo(Boolean value) {
			addCriterion("LEASE_PUBLISH <>", value, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishGreaterThan(Boolean value) {
			addCriterion("LEASE_PUBLISH >", value, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishGreaterThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_PUBLISH >=", value, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishLessThan(Boolean value) {
			addCriterion("LEASE_PUBLISH <", value, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishLessThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_PUBLISH <=", value, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishIn(List<Boolean> values) {
			addCriterion("LEASE_PUBLISH in", values, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishNotIn(List<Boolean> values) {
			addCriterion("LEASE_PUBLISH not in", values, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_PUBLISH between", value1, value2, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeasePublishNotBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_PUBLISH not between", value1, value2, "leasePublish");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelIsNull() {
			addCriterion("LEASE_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelIsNotNull() {
			addCriterion("LEASE_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelEqualTo(Byte value) {
			addCriterion("LEASE_LEVEL =", value, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelNotEqualTo(Byte value) {
			addCriterion("LEASE_LEVEL <>", value, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelGreaterThan(Byte value) {
			addCriterion("LEASE_LEVEL >", value, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_LEVEL >=", value, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelLessThan(Byte value) {
			addCriterion("LEASE_LEVEL <", value, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_LEVEL <=", value, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelIn(List<Byte> values) {
			addCriterion("LEASE_LEVEL in", values, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelNotIn(List<Byte> values) {
			addCriterion("LEASE_LEVEL not in", values, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_LEVEL between", value1, value2, "leaseLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_LEVEL not between", value1, value2, "leaseLevel");
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