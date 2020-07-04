package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunLeaseExample extends ShardDb {
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
	public ErpFunLeaseExample() {
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

		public Criteria andLeaseNoIsNull() {
			addCriterion("LEASE_NO is null");
			return (Criteria) this;
		}

		public Criteria andLeaseNoIsNotNull() {
			addCriterion("LEASE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseNoEqualTo(String value) {
			addCriterion("LEASE_NO =", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoNotEqualTo(String value) {
			addCriterion("LEASE_NO <>", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoGreaterThan(String value) {
			addCriterion("LEASE_NO >", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_NO >=", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoLessThan(String value) {
			addCriterion("LEASE_NO <", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoLessThanOrEqualTo(String value) {
			addCriterion("LEASE_NO <=", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoLike(String value) {
			addCriterion("LEASE_NO like", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoNotLike(String value) {
			addCriterion("LEASE_NO not like", value, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoIn(List<String> values) {
			addCriterion("LEASE_NO in", values, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoNotIn(List<String> values) {
			addCriterion("LEASE_NO not in", values, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoBetween(String value1, String value2) {
			addCriterion("LEASE_NO between", value1, value2, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseNoNotBetween(String value1, String value2) {
			addCriterion("LEASE_NO not between", value1, value2, "leaseNo");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectIsNull() {
			addCriterion("LEASE_SUBJECT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectIsNotNull() {
			addCriterion("LEASE_SUBJECT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectEqualTo(String value) {
			addCriterion("LEASE_SUBJECT =", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectNotEqualTo(String value) {
			addCriterion("LEASE_SUBJECT <>", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectGreaterThan(String value) {
			addCriterion("LEASE_SUBJECT >", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_SUBJECT >=", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectLessThan(String value) {
			addCriterion("LEASE_SUBJECT <", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectLessThanOrEqualTo(String value) {
			addCriterion("LEASE_SUBJECT <=", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectLike(String value) {
			addCriterion("LEASE_SUBJECT like", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectNotLike(String value) {
			addCriterion("LEASE_SUBJECT not like", value, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectIn(List<String> values) {
			addCriterion("LEASE_SUBJECT in", values, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectNotIn(List<String> values) {
			addCriterion("LEASE_SUBJECT not in", values, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectBetween(String value1, String value2) {
			addCriterion("LEASE_SUBJECT between", value1, value2, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseSubjectNotBetween(String value1, String value2) {
			addCriterion("LEASE_SUBJECT not between", value1, value2, "leaseSubject");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerIsNull() {
			addCriterion("LEASE_OWNER is null");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerIsNotNull() {
			addCriterion("LEASE_OWNER is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerEqualTo(String value) {
			addCriterion("LEASE_OWNER =", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerNotEqualTo(String value) {
			addCriterion("LEASE_OWNER <>", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerGreaterThan(String value) {
			addCriterion("LEASE_OWNER >", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_OWNER >=", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerLessThan(String value) {
			addCriterion("LEASE_OWNER <", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerLessThanOrEqualTo(String value) {
			addCriterion("LEASE_OWNER <=", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerLike(String value) {
			addCriterion("LEASE_OWNER like", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerNotLike(String value) {
			addCriterion("LEASE_OWNER not like", value, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerIn(List<String> values) {
			addCriterion("LEASE_OWNER in", values, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerNotIn(List<String> values) {
			addCriterion("LEASE_OWNER not in", values, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerBetween(String value1, String value2) {
			addCriterion("LEASE_OWNER between", value1, value2, "leaseOwner");
			return (Criteria) this;
		}

		public Criteria andLeaseOwnerNotBetween(String value1, String value2) {
			addCriterion("LEASE_OWNER not between", value1, value2, "leaseOwner");
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

		public Criteria andBuildCodeIsNull() {
			addCriterion("BUILD_CODE is null");
			return (Criteria) this;
		}

		public Criteria andBuildCodeIsNotNull() {
			addCriterion("BUILD_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildCodeEqualTo(String value) {
			addCriterion("BUILD_CODE =", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotEqualTo(String value) {
			addCriterion("BUILD_CODE <>", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeGreaterThan(String value) {
			addCriterion("BUILD_CODE >", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_CODE >=", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeLessThan(String value) {
			addCriterion("BUILD_CODE <", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeLessThanOrEqualTo(String value) {
			addCriterion("BUILD_CODE <=", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeLike(String value) {
			addCriterion("BUILD_CODE like", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotLike(String value) {
			addCriterion("BUILD_CODE not like", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeIn(List<String> values) {
			addCriterion("BUILD_CODE in", values, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotIn(List<String> values) {
			addCriterion("BUILD_CODE not in", values, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeBetween(String value1, String value2) {
			addCriterion("BUILD_CODE between", value1, value2, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotBetween(String value1, String value2) {
			addCriterion("BUILD_CODE not between", value1, value2, "buildCode");
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

		public Criteria andLeaseRoundIsNull() {
			addCriterion("LEASE_ROUND is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundIsNotNull() {
			addCriterion("LEASE_ROUND is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundEqualTo(Byte value) {
			addCriterion("LEASE_ROUND =", value, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundNotEqualTo(Byte value) {
			addCriterion("LEASE_ROUND <>", value, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundGreaterThan(Byte value) {
			addCriterion("LEASE_ROUND >", value, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROUND >=", value, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundLessThan(Byte value) {
			addCriterion("LEASE_ROUND <", value, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROUND <=", value, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundIn(List<Byte> values) {
			addCriterion("LEASE_ROUND in", values, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundNotIn(List<Byte> values) {
			addCriterion("LEASE_ROUND not in", values, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROUND between", value1, value2, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andLeaseRoundNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROUND not between", value1, value2, "leaseRound");
			return (Criteria) this;
		}

		public Criteria andTradeAddrIsNull() {
			addCriterion("TRADE_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andTradeAddrIsNotNull() {
			addCriterion("TRADE_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andTradeAddrEqualTo(String value) {
			addCriterion("TRADE_ADDR =", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrNotEqualTo(String value) {
			addCriterion("TRADE_ADDR <>", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrGreaterThan(String value) {
			addCriterion("TRADE_ADDR >", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrGreaterThanOrEqualTo(String value) {
			addCriterion("TRADE_ADDR >=", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrLessThan(String value) {
			addCriterion("TRADE_ADDR <", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrLessThanOrEqualTo(String value) {
			addCriterion("TRADE_ADDR <=", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrLike(String value) {
			addCriterion("TRADE_ADDR like", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrNotLike(String value) {
			addCriterion("TRADE_ADDR not like", value, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrIn(List<String> values) {
			addCriterion("TRADE_ADDR in", values, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrNotIn(List<String> values) {
			addCriterion("TRADE_ADDR not in", values, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrBetween(String value1, String value2) {
			addCriterion("TRADE_ADDR between", value1, value2, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andTradeAddrNotBetween(String value1, String value2) {
			addCriterion("TRADE_ADDR not between", value1, value2, "tradeAddr");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofIsNull() {
			addCriterion("LEASE_ROOF is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofIsNotNull() {
			addCriterion("LEASE_ROOF is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofEqualTo(String value) {
			addCriterion("LEASE_ROOF =", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofNotEqualTo(String value) {
			addCriterion("LEASE_ROOF <>", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofGreaterThan(String value) {
			addCriterion("LEASE_ROOF >", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_ROOF >=", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofLessThan(String value) {
			addCriterion("LEASE_ROOF <", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofLessThanOrEqualTo(String value) {
			addCriterion("LEASE_ROOF <=", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofLike(String value) {
			addCriterion("LEASE_ROOF like", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofNotLike(String value) {
			addCriterion("LEASE_ROOF not like", value, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofIn(List<String> values) {
			addCriterion("LEASE_ROOF in", values, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofNotIn(List<String> values) {
			addCriterion("LEASE_ROOF not in", values, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofBetween(String value1, String value2) {
			addCriterion("LEASE_ROOF between", value1, value2, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofNotBetween(String value1, String value2) {
			addCriterion("LEASE_ROOF not between", value1, value2, "leaseRoof");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitIsNull() {
			addCriterion("LEASE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitIsNotNull() {
			addCriterion("LEASE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitEqualTo(String value) {
			addCriterion("LEASE_UNIT =", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitNotEqualTo(String value) {
			addCriterion("LEASE_UNIT <>", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitGreaterThan(String value) {
			addCriterion("LEASE_UNIT >", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_UNIT >=", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitLessThan(String value) {
			addCriterion("LEASE_UNIT <", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitLessThanOrEqualTo(String value) {
			addCriterion("LEASE_UNIT <=", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitLike(String value) {
			addCriterion("LEASE_UNIT like", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitNotLike(String value) {
			addCriterion("LEASE_UNIT not like", value, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitIn(List<String> values) {
			addCriterion("LEASE_UNIT in", values, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitNotIn(List<String> values) {
			addCriterion("LEASE_UNIT not in", values, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitBetween(String value1, String value2) {
			addCriterion("LEASE_UNIT between", value1, value2, "leaseUnit");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitNotBetween(String value1, String value2) {
			addCriterion("LEASE_UNIT not between", value1, value2, "leaseUnit");
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

		public Criteria andLeaseNumIsNull() {
			addCriterion("LEASE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumIsNotNull() {
			addCriterion("LEASE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumEqualTo(String value) {
			addCriterion("LEASE_NUM =", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumNotEqualTo(String value) {
			addCriterion("LEASE_NUM <>", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumGreaterThan(String value) {
			addCriterion("LEASE_NUM >", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_NUM >=", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumLessThan(String value) {
			addCriterion("LEASE_NUM <", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumLessThanOrEqualTo(String value) {
			addCriterion("LEASE_NUM <=", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumLike(String value) {
			addCriterion("LEASE_NUM like", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumNotLike(String value) {
			addCriterion("LEASE_NUM not like", value, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumIn(List<String> values) {
			addCriterion("LEASE_NUM in", values, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumNotIn(List<String> values) {
			addCriterion("LEASE_NUM not in", values, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumBetween(String value1, String value2) {
			addCriterion("LEASE_NUM between", value1, value2, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseNumNotBetween(String value1, String value2) {
			addCriterion("LEASE_NUM not between", value1, value2, "leaseNum");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRIsNull() {
			addCriterion("LEASE_ROOF_R is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRIsNotNull() {
			addCriterion("LEASE_ROOF_R is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofREqualTo(String value) {
			addCriterion("LEASE_ROOF_R =", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRNotEqualTo(String value) {
			addCriterion("LEASE_ROOF_R <>", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRGreaterThan(String value) {
			addCriterion("LEASE_ROOF_R >", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_ROOF_R >=", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRLessThan(String value) {
			addCriterion("LEASE_ROOF_R <", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRLessThanOrEqualTo(String value) {
			addCriterion("LEASE_ROOF_R <=", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRLike(String value) {
			addCriterion("LEASE_ROOF_R like", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRNotLike(String value) {
			addCriterion("LEASE_ROOF_R not like", value, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRIn(List<String> values) {
			addCriterion("LEASE_ROOF_R in", values, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRNotIn(List<String> values) {
			addCriterion("LEASE_ROOF_R not in", values, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRBetween(String value1, String value2) {
			addCriterion("LEASE_ROOF_R between", value1, value2, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofRNotBetween(String value1, String value2) {
			addCriterion("LEASE_ROOF_R not between", value1, value2, "leaseRoofR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRIsNull() {
			addCriterion("LEASE_UNIT_R is null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRIsNotNull() {
			addCriterion("LEASE_UNIT_R is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitREqualTo(String value) {
			addCriterion("LEASE_UNIT_R =", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRNotEqualTo(String value) {
			addCriterion("LEASE_UNIT_R <>", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRGreaterThan(String value) {
			addCriterion("LEASE_UNIT_R >", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_UNIT_R >=", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRLessThan(String value) {
			addCriterion("LEASE_UNIT_R <", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRLessThanOrEqualTo(String value) {
			addCriterion("LEASE_UNIT_R <=", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRLike(String value) {
			addCriterion("LEASE_UNIT_R like", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRNotLike(String value) {
			addCriterion("LEASE_UNIT_R not like", value, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRIn(List<String> values) {
			addCriterion("LEASE_UNIT_R in", values, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRNotIn(List<String> values) {
			addCriterion("LEASE_UNIT_R not in", values, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRBetween(String value1, String value2) {
			addCriterion("LEASE_UNIT_R between", value1, value2, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitRNotBetween(String value1, String value2) {
			addCriterion("LEASE_UNIT_R not between", value1, value2, "leaseUnitR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRIsNull() {
			addCriterion("UNIT_FLOOR_R is null");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRIsNotNull() {
			addCriterion("UNIT_FLOOR_R is not null");
			return (Criteria) this;
		}

		public Criteria andUnitFloorREqualTo(String value) {
			addCriterion("UNIT_FLOOR_R =", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRNotEqualTo(String value) {
			addCriterion("UNIT_FLOOR_R <>", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRGreaterThan(String value) {
			addCriterion("UNIT_FLOOR_R >", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRGreaterThanOrEqualTo(String value) {
			addCriterion("UNIT_FLOOR_R >=", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRLessThan(String value) {
			addCriterion("UNIT_FLOOR_R <", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRLessThanOrEqualTo(String value) {
			addCriterion("UNIT_FLOOR_R <=", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRLike(String value) {
			addCriterion("UNIT_FLOOR_R like", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRNotLike(String value) {
			addCriterion("UNIT_FLOOR_R not like", value, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRIn(List<String> values) {
			addCriterion("UNIT_FLOOR_R in", values, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRNotIn(List<String> values) {
			addCriterion("UNIT_FLOOR_R not in", values, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRBetween(String value1, String value2) {
			addCriterion("UNIT_FLOOR_R between", value1, value2, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andUnitFloorRNotBetween(String value1, String value2) {
			addCriterion("UNIT_FLOOR_R not between", value1, value2, "unitFloorR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRIsNull() {
			addCriterion("LEASE_NUM_R is null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRIsNotNull() {
			addCriterion("LEASE_NUM_R is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumREqualTo(String value) {
			addCriterion("LEASE_NUM_R =", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRNotEqualTo(String value) {
			addCriterion("LEASE_NUM_R <>", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRGreaterThan(String value) {
			addCriterion("LEASE_NUM_R >", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_NUM_R >=", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRLessThan(String value) {
			addCriterion("LEASE_NUM_R <", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRLessThanOrEqualTo(String value) {
			addCriterion("LEASE_NUM_R <=", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRLike(String value) {
			addCriterion("LEASE_NUM_R like", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRNotLike(String value) {
			addCriterion("LEASE_NUM_R not like", value, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRIn(List<String> values) {
			addCriterion("LEASE_NUM_R in", values, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRNotIn(List<String> values) {
			addCriterion("LEASE_NUM_R not in", values, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRBetween(String value1, String value2) {
			addCriterion("LEASE_NUM_R between", value1, value2, "leaseNumR");
			return (Criteria) this;
		}

		public Criteria andLeaseNumRNotBetween(String value1, String value2) {
			addCriterion("LEASE_NUM_R not between", value1, value2, "leaseNumR");
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

		public Criteria andLeaseHallIsNull() {
			addCriterion("LEASE_HALL is null");
			return (Criteria) this;
		}

		public Criteria andLeaseHallIsNotNull() {
			addCriterion("LEASE_HALL is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseHallEqualTo(Byte value) {
			addCriterion("LEASE_HALL =", value, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallNotEqualTo(Byte value) {
			addCriterion("LEASE_HALL <>", value, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallGreaterThan(Byte value) {
			addCriterion("LEASE_HALL >", value, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_HALL >=", value, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallLessThan(Byte value) {
			addCriterion("LEASE_HALL <", value, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_HALL <=", value, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallIn(List<Byte> values) {
			addCriterion("LEASE_HALL in", values, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallNotIn(List<Byte> values) {
			addCriterion("LEASE_HALL not in", values, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_HALL between", value1, value2, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseHallNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_HALL not between", value1, value2, "leaseHall");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiIsNull() {
			addCriterion("LEASE_WEI is null");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiIsNotNull() {
			addCriterion("LEASE_WEI is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiEqualTo(Byte value) {
			addCriterion("LEASE_WEI =", value, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiNotEqualTo(Byte value) {
			addCriterion("LEASE_WEI <>", value, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiGreaterThan(Byte value) {
			addCriterion("LEASE_WEI >", value, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_WEI >=", value, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiLessThan(Byte value) {
			addCriterion("LEASE_WEI <", value, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_WEI <=", value, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiIn(List<Byte> values) {
			addCriterion("LEASE_WEI in", values, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiNotIn(List<Byte> values) {
			addCriterion("LEASE_WEI not in", values, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_WEI between", value1, value2, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseWeiNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_WEI not between", value1, value2, "leaseWei");
			return (Criteria) this;
		}

		public Criteria andLeaseYangIsNull() {
			addCriterion("LEASE_YANG is null");
			return (Criteria) this;
		}

		public Criteria andLeaseYangIsNotNull() {
			addCriterion("LEASE_YANG is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseYangEqualTo(Byte value) {
			addCriterion("LEASE_YANG =", value, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangNotEqualTo(Byte value) {
			addCriterion("LEASE_YANG <>", value, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangGreaterThan(Byte value) {
			addCriterion("LEASE_YANG >", value, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_YANG >=", value, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangLessThan(Byte value) {
			addCriterion("LEASE_YANG <", value, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_YANG <=", value, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangIn(List<Byte> values) {
			addCriterion("LEASE_YANG in", values, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangNotIn(List<Byte> values) {
			addCriterion("LEASE_YANG not in", values, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_YANG between", value1, value2, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseYangNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_YANG not between", value1, value2, "leaseYang");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderIsNull() {
			addCriterion("LEASE_LADDER is null");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderIsNotNull() {
			addCriterion("LEASE_LADDER is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderEqualTo(Byte value) {
			addCriterion("LEASE_LADDER =", value, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderNotEqualTo(Byte value) {
			addCriterion("LEASE_LADDER <>", value, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderGreaterThan(Byte value) {
			addCriterion("LEASE_LADDER >", value, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_LADDER >=", value, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderLessThan(Byte value) {
			addCriterion("LEASE_LADDER <", value, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_LADDER <=", value, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderIn(List<Byte> values) {
			addCriterion("LEASE_LADDER in", values, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderNotIn(List<Byte> values) {
			addCriterion("LEASE_LADDER not in", values, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_LADDER between", value1, value2, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseLadderNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_LADDER not between", value1, value2, "leaseLadder");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsIsNull() {
			addCriterion("LEASE_DOORS is null");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsIsNotNull() {
			addCriterion("LEASE_DOORS is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsEqualTo(Integer value) {
			addCriterion("LEASE_DOORS =", value, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsNotEqualTo(Integer value) {
			addCriterion("LEASE_DOORS <>", value, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsGreaterThan(Integer value) {
			addCriterion("LEASE_DOORS >", value, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_DOORS >=", value, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsLessThan(Integer value) {
			addCriterion("LEASE_DOORS <", value, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_DOORS <=", value, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsIn(List<Integer> values) {
			addCriterion("LEASE_DOORS in", values, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsNotIn(List<Integer> values) {
			addCriterion("LEASE_DOORS not in", values, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_DOORS between", value1, value2, "leaseDoors");
			return (Criteria) this;
		}

		public Criteria andLeaseDoorsNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_DOORS not between", value1, value2, "leaseDoors");
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

		public Criteria andLeaseFloorIsNull() {
			addCriterion("LEASE_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorIsNotNull() {
			addCriterion("LEASE_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorEqualTo(Short value) {
			addCriterion("LEASE_FLOOR =", value, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorNotEqualTo(Short value) {
			addCriterion("LEASE_FLOOR <>", value, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorGreaterThan(Short value) {
			addCriterion("LEASE_FLOOR >", value, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorGreaterThanOrEqualTo(Short value) {
			addCriterion("LEASE_FLOOR >=", value, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorLessThan(Short value) {
			addCriterion("LEASE_FLOOR <", value, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorLessThanOrEqualTo(Short value) {
			addCriterion("LEASE_FLOOR <=", value, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorIn(List<Short> values) {
			addCriterion("LEASE_FLOOR in", values, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorNotIn(List<Short> values) {
			addCriterion("LEASE_FLOOR not in", values, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorBetween(Short value1, Short value2) {
			addCriterion("LEASE_FLOOR between", value1, value2, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorNotBetween(Short value1, Short value2) {
			addCriterion("LEASE_FLOOR not between", value1, value2, "leaseFloor");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsIsNull() {
			addCriterion("LEASE_FLOORS is null");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsIsNotNull() {
			addCriterion("LEASE_FLOORS is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsEqualTo(Integer value) {
			addCriterion("LEASE_FLOORS =", value, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsNotEqualTo(Integer value) {
			addCriterion("LEASE_FLOORS <>", value, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsGreaterThan(Integer value) {
			addCriterion("LEASE_FLOORS >", value, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_FLOORS >=", value, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsLessThan(Integer value) {
			addCriterion("LEASE_FLOORS <", value, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_FLOORS <=", value, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsIn(List<Integer> values) {
			addCriterion("LEASE_FLOORS in", values, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsNotIn(List<Integer> values) {
			addCriterion("LEASE_FLOORS not in", values, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_FLOORS between", value1, value2, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFloorsNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_FLOORS not between", value1, value2, "leaseFloors");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentIsNull() {
			addCriterion("LEASE_FITMENT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentIsNotNull() {
			addCriterion("LEASE_FITMENT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentEqualTo(Byte value) {
			addCriterion("LEASE_FITMENT =", value, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentNotEqualTo(Byte value) {
			addCriterion("LEASE_FITMENT <>", value, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentGreaterThan(Byte value) {
			addCriterion("LEASE_FITMENT >", value, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_FITMENT >=", value, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentLessThan(Byte value) {
			addCriterion("LEASE_FITMENT <", value, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_FITMENT <=", value, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentIn(List<Byte> values) {
			addCriterion("LEASE_FITMENT in", values, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentNotIn(List<Byte> values) {
			addCriterion("LEASE_FITMENT not in", values, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_FITMENT between", value1, value2, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseFitmentNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_FITMENT not between", value1, value2, "leaseFitment");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectIsNull() {
			addCriterion("LEASE_DIRECT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectIsNotNull() {
			addCriterion("LEASE_DIRECT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectEqualTo(Byte value) {
			addCriterion("LEASE_DIRECT =", value, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectNotEqualTo(Byte value) {
			addCriterion("LEASE_DIRECT <>", value, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectGreaterThan(Byte value) {
			addCriterion("LEASE_DIRECT >", value, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_DIRECT >=", value, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectLessThan(Byte value) {
			addCriterion("LEASE_DIRECT <", value, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_DIRECT <=", value, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectIn(List<Byte> values) {
			addCriterion("LEASE_DIRECT in", values, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectNotIn(List<Byte> values) {
			addCriterion("LEASE_DIRECT not in", values, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_DIRECT between", value1, value2, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseDirectNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_DIRECT not between", value1, value2, "leaseDirect");
			return (Criteria) this;
		}

		public Criteria andLeaseYearIsNull() {
			addCriterion("LEASE_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andLeaseYearIsNotNull() {
			addCriterion("LEASE_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseYearEqualTo(Short value) {
			addCriterion("LEASE_YEAR =", value, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearNotEqualTo(Short value) {
			addCriterion("LEASE_YEAR <>", value, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearGreaterThan(Short value) {
			addCriterion("LEASE_YEAR >", value, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearGreaterThanOrEqualTo(Short value) {
			addCriterion("LEASE_YEAR >=", value, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearLessThan(Short value) {
			addCriterion("LEASE_YEAR <", value, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearLessThanOrEqualTo(Short value) {
			addCriterion("LEASE_YEAR <=", value, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearIn(List<Short> values) {
			addCriterion("LEASE_YEAR in", values, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearNotIn(List<Short> values) {
			addCriterion("LEASE_YEAR not in", values, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearBetween(Short value1, Short value2) {
			addCriterion("LEASE_YEAR between", value1, value2, "leaseYear");
			return (Criteria) this;
		}

		public Criteria andLeaseYearNotBetween(Short value1, Short value2) {
			addCriterion("LEASE_YEAR not between", value1, value2, "leaseYear");
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

		public Criteria andLeaseStreetIsNull() {
			addCriterion("LEASE_STREET is null");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetIsNotNull() {
			addCriterion("LEASE_STREET is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetEqualTo(Boolean value) {
			addCriterion("LEASE_STREET =", value, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetNotEqualTo(Boolean value) {
			addCriterion("LEASE_STREET <>", value, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetGreaterThan(Boolean value) {
			addCriterion("LEASE_STREET >", value, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetGreaterThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_STREET >=", value, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetLessThan(Boolean value) {
			addCriterion("LEASE_STREET <", value, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetLessThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_STREET <=", value, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetIn(List<Boolean> values) {
			addCriterion("LEASE_STREET in", values, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetNotIn(List<Boolean> values) {
			addCriterion("LEASE_STREET not in", values, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_STREET between", value1, value2, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseStreetNotBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_STREET not between", value1, value2, "leaseStreet");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountIsNull() {
			addCriterion("LEASE_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountIsNotNull() {
			addCriterion("LEASE_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountEqualTo(Integer value) {
			addCriterion("LEASE_ACCOUNT =", value, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountNotEqualTo(Integer value) {
			addCriterion("LEASE_ACCOUNT <>", value, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountGreaterThan(Integer value) {
			addCriterion("LEASE_ACCOUNT >", value, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_ACCOUNT >=", value, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountLessThan(Integer value) {
			addCriterion("LEASE_ACCOUNT <", value, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_ACCOUNT <=", value, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountIn(List<Integer> values) {
			addCriterion("LEASE_ACCOUNT in", values, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountNotIn(List<Integer> values) {
			addCriterion("LEASE_ACCOUNT not in", values, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_ACCOUNT between", value1, value2, "leaseAccount");
			return (Criteria) this;
		}

		public Criteria andLeaseAccountNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_ACCOUNT not between", value1, value2, "leaseAccount");
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

		public Criteria andLeaseLowestPriceIsNull() {
			addCriterion("LEASE_LOWEST_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceIsNotNull() {
			addCriterion("LEASE_LOWEST_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceEqualTo(BigDecimal value) {
			addCriterion("LEASE_LOWEST_PRICE =", value, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_LOWEST_PRICE <>", value, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_LOWEST_PRICE >", value, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_LOWEST_PRICE >=", value, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceLessThan(BigDecimal value) {
			addCriterion("LEASE_LOWEST_PRICE <", value, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_LOWEST_PRICE <=", value, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceIn(List<BigDecimal> values) {
			addCriterion("LEASE_LOWEST_PRICE in", values, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_LOWEST_PRICE not in", values, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_LOWEST_PRICE between", value1, value2, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseLowestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_LOWEST_PRICE not between", value1, value2, "leaseLowestPrice");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyIsNull() {
			addCriterion("LEASE_PROPERTY is null");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyIsNotNull() {
			addCriterion("LEASE_PROPERTY is not null");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyEqualTo(BigDecimal value) {
			addCriterion("LEASE_PROPERTY =", value, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_PROPERTY <>", value, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyGreaterThan(BigDecimal value) {
			addCriterion("LEASE_PROPERTY >", value, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_PROPERTY >=", value, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyLessThan(BigDecimal value) {
			addCriterion("LEASE_PROPERTY <", value, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_PROPERTY <=", value, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyIn(List<BigDecimal> values) {
			addCriterion("LEASE_PROPERTY in", values, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_PROPERTY not in", values, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_PROPERTY between", value1, value2, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andLeasePropertyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_PROPERTY not between", value1, value2, "leaseProperty");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorIsNull() {
			addCriterion("IS_SEPERATOR is null");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorIsNotNull() {
			addCriterion("IS_SEPERATOR is not null");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorEqualTo(Boolean value) {
			addCriterion("IS_SEPERATOR =", value, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorNotEqualTo(Boolean value) {
			addCriterion("IS_SEPERATOR <>", value, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorGreaterThan(Boolean value) {
			addCriterion("IS_SEPERATOR >", value, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_SEPERATOR >=", value, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorLessThan(Boolean value) {
			addCriterion("IS_SEPERATOR <", value, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_SEPERATOR <=", value, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorIn(List<Boolean> values) {
			addCriterion("IS_SEPERATOR in", values, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorNotIn(List<Boolean> values) {
			addCriterion("IS_SEPERATOR not in", values, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_SEPERATOR between", value1, value2, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andIsSeperatorNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_SEPERATOR not between", value1, value2, "isSeperator");
			return (Criteria) this;
		}

		public Criteria andShopUsageIsNull() {
			addCriterion("SHOP_USAGE is null");
			return (Criteria) this;
		}

		public Criteria andShopUsageIsNotNull() {
			addCriterion("SHOP_USAGE is not null");
			return (Criteria) this;
		}

		public Criteria andShopUsageEqualTo(String value) {
			addCriterion("SHOP_USAGE =", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageNotEqualTo(String value) {
			addCriterion("SHOP_USAGE <>", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageGreaterThan(String value) {
			addCriterion("SHOP_USAGE >", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageGreaterThanOrEqualTo(String value) {
			addCriterion("SHOP_USAGE >=", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageLessThan(String value) {
			addCriterion("SHOP_USAGE <", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageLessThanOrEqualTo(String value) {
			addCriterion("SHOP_USAGE <=", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageLike(String value) {
			addCriterion("SHOP_USAGE like", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageNotLike(String value) {
			addCriterion("SHOP_USAGE not like", value, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageIn(List<String> values) {
			addCriterion("SHOP_USAGE in", values, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageNotIn(List<String> values) {
			addCriterion("SHOP_USAGE not in", values, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageBetween(String value1, String value2) {
			addCriterion("SHOP_USAGE between", value1, value2, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andShopUsageNotBetween(String value1, String value2) {
			addCriterion("SHOP_USAGE not between", value1, value2, "shopUsage");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeIsNull() {
			addCriterion("OWNER_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeIsNotNull() {
			addCriterion("OWNER_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeEqualTo(Byte value) {
			addCriterion("OWNER_TYPE =", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeNotEqualTo(Byte value) {
			addCriterion("OWNER_TYPE <>", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeGreaterThan(Byte value) {
			addCriterion("OWNER_TYPE >", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("OWNER_TYPE >=", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeLessThan(Byte value) {
			addCriterion("OWNER_TYPE <", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeLessThanOrEqualTo(Byte value) {
			addCriterion("OWNER_TYPE <=", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeIn(List<Byte> values) {
			addCriterion("OWNER_TYPE in", values, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeNotIn(List<Byte> values) {
			addCriterion("OWNER_TYPE not in", values, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeBetween(Byte value1, Byte value2) {
			addCriterion("OWNER_TYPE between", value1, value2, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("OWNER_TYPE not between", value1, value2, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelIsNull() {
			addCriterion("OFFICE_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelIsNotNull() {
			addCriterion("OFFICE_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelEqualTo(Byte value) {
			addCriterion("OFFICE_LEVEL =", value, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelNotEqualTo(Byte value) {
			addCriterion("OFFICE_LEVEL <>", value, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelGreaterThan(Byte value) {
			addCriterion("OFFICE_LEVEL >", value, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("OFFICE_LEVEL >=", value, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelLessThan(Byte value) {
			addCriterion("OFFICE_LEVEL <", value, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelLessThanOrEqualTo(Byte value) {
			addCriterion("OFFICE_LEVEL <=", value, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelIn(List<Byte> values) {
			addCriterion("OFFICE_LEVEL in", values, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelNotIn(List<Byte> values) {
			addCriterion("OFFICE_LEVEL not in", values, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelBetween(Byte value1, Byte value2) {
			addCriterion("OFFICE_LEVEL between", value1, value2, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andOfficeLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("OFFICE_LEVEL not between", value1, value2, "officeLevel");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositIsNull() {
			addCriterion("LEASE_DEPOSIT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositIsNotNull() {
			addCriterion("LEASE_DEPOSIT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositEqualTo(Integer value) {
			addCriterion("LEASE_DEPOSIT =", value, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositNotEqualTo(Integer value) {
			addCriterion("LEASE_DEPOSIT <>", value, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositGreaterThan(Integer value) {
			addCriterion("LEASE_DEPOSIT >", value, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_DEPOSIT >=", value, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositLessThan(Integer value) {
			addCriterion("LEASE_DEPOSIT <", value, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_DEPOSIT <=", value, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositIn(List<Integer> values) {
			addCriterion("LEASE_DEPOSIT in", values, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositNotIn(List<Integer> values) {
			addCriterion("LEASE_DEPOSIT not in", values, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_DEPOSIT between", value1, value2, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseDepositNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_DEPOSIT not between", value1, value2, "leaseDeposit");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeIsNull() {
			addCriterion("LEASE_LEAVE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeIsNotNull() {
			addCriterion("LEASE_LEAVE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeEqualTo(String value) {
			addCriterion("LEASE_LEAVE_TIME =", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeNotEqualTo(String value) {
			addCriterion("LEASE_LEAVE_TIME <>", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeGreaterThan(String value) {
			addCriterion("LEASE_LEAVE_TIME >", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_LEAVE_TIME >=", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeLessThan(String value) {
			addCriterion("LEASE_LEAVE_TIME <", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeLessThanOrEqualTo(String value) {
			addCriterion("LEASE_LEAVE_TIME <=", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeLike(String value) {
			addCriterion("LEASE_LEAVE_TIME like", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeNotLike(String value) {
			addCriterion("LEASE_LEAVE_TIME not like", value, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeIn(List<String> values) {
			addCriterion("LEASE_LEAVE_TIME in", values, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeNotIn(List<String> values) {
			addCriterion("LEASE_LEAVE_TIME not in", values, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeBetween(String value1, String value2) {
			addCriterion("LEASE_LEAVE_TIME between", value1, value2, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLeaveTimeNotBetween(String value1, String value2) {
			addCriterion("LEASE_LEAVE_TIME not between", value1, value2, "leaseLeaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteIsNull() {
			addCriterion("LEASE_LIMITE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteIsNotNull() {
			addCriterion("LEASE_LIMITE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteEqualTo(Integer value) {
			addCriterion("LEASE_LIMITE =", value, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteNotEqualTo(Integer value) {
			addCriterion("LEASE_LIMITE <>", value, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteGreaterThan(Integer value) {
			addCriterion("LEASE_LIMITE >", value, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_LIMITE >=", value, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteLessThan(Integer value) {
			addCriterion("LEASE_LIMITE <", value, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_LIMITE <=", value, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteIn(List<Integer> values) {
			addCriterion("LEASE_LIMITE in", values, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteNotIn(List<Integer> values) {
			addCriterion("LEASE_LIMITE not in", values, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_LIMITE between", value1, value2, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andLeaseLimiteNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_LIMITE not between", value1, value2, "leaseLimite");
			return (Criteria) this;
		}

		public Criteria andHallStructureIsNull() {
			addCriterion("HALL_STRUCTURE is null");
			return (Criteria) this;
		}

		public Criteria andHallStructureIsNotNull() {
			addCriterion("HALL_STRUCTURE is not null");
			return (Criteria) this;
		}

		public Criteria andHallStructureEqualTo(Byte value) {
			addCriterion("HALL_STRUCTURE =", value, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureNotEqualTo(Byte value) {
			addCriterion("HALL_STRUCTURE <>", value, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureGreaterThan(Byte value) {
			addCriterion("HALL_STRUCTURE >", value, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureGreaterThanOrEqualTo(Byte value) {
			addCriterion("HALL_STRUCTURE >=", value, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureLessThan(Byte value) {
			addCriterion("HALL_STRUCTURE <", value, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureLessThanOrEqualTo(Byte value) {
			addCriterion("HALL_STRUCTURE <=", value, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureIn(List<Byte> values) {
			addCriterion("HALL_STRUCTURE in", values, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureNotIn(List<Byte> values) {
			addCriterion("HALL_STRUCTURE not in", values, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureBetween(Byte value1, Byte value2) {
			addCriterion("HALL_STRUCTURE between", value1, value2, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andHallStructureNotBetween(Byte value1, Byte value2) {
			addCriterion("HALL_STRUCTURE not between", value1, value2, "hallStructure");
			return (Criteria) this;
		}

		public Criteria andUgAreaIsNull() {
			addCriterion("UG_AREA is null");
			return (Criteria) this;
		}

		public Criteria andUgAreaIsNotNull() {
			addCriterion("UG_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andUgAreaEqualTo(BigDecimal value) {
			addCriterion("UG_AREA =", value, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaNotEqualTo(BigDecimal value) {
			addCriterion("UG_AREA <>", value, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaGreaterThan(BigDecimal value) {
			addCriterion("UG_AREA >", value, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("UG_AREA >=", value, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaLessThan(BigDecimal value) {
			addCriterion("UG_AREA <", value, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("UG_AREA <=", value, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaIn(List<BigDecimal> values) {
			addCriterion("UG_AREA in", values, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaNotIn(List<BigDecimal> values) {
			addCriterion("UG_AREA not in", values, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("UG_AREA between", value1, value2, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("UG_AREA not between", value1, value2, "ugArea");
			return (Criteria) this;
		}

		public Criteria andUgTypeIsNull() {
			addCriterion("UG_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andUgTypeIsNotNull() {
			addCriterion("UG_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andUgTypeEqualTo(Integer value) {
			addCriterion("UG_TYPE =", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeNotEqualTo(Integer value) {
			addCriterion("UG_TYPE <>", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeGreaterThan(Integer value) {
			addCriterion("UG_TYPE >", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("UG_TYPE >=", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeLessThan(Integer value) {
			addCriterion("UG_TYPE <", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeLessThanOrEqualTo(Integer value) {
			addCriterion("UG_TYPE <=", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeIn(List<Integer> values) {
			addCriterion("UG_TYPE in", values, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeNotIn(List<Integer> values) {
			addCriterion("UG_TYPE not in", values, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeBetween(Integer value1, Integer value2) {
			addCriterion("UG_TYPE between", value1, value2, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("UG_TYPE not between", value1, value2, "ugType");
			return (Criteria) this;
		}

		public Criteria andGardenAreaIsNull() {
			addCriterion("GARDEN_AREA is null");
			return (Criteria) this;
		}

		public Criteria andGardenAreaIsNotNull() {
			addCriterion("GARDEN_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andGardenAreaEqualTo(BigDecimal value) {
			addCriterion("GARDEN_AREA =", value, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaNotEqualTo(BigDecimal value) {
			addCriterion("GARDEN_AREA <>", value, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaGreaterThan(BigDecimal value) {
			addCriterion("GARDEN_AREA >", value, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("GARDEN_AREA >=", value, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaLessThan(BigDecimal value) {
			addCriterion("GARDEN_AREA <", value, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("GARDEN_AREA <=", value, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaIn(List<BigDecimal> values) {
			addCriterion("GARDEN_AREA in", values, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaNotIn(List<BigDecimal> values) {
			addCriterion("GARDEN_AREA not in", values, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GARDEN_AREA between", value1, value2, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGardenAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GARDEN_AREA not between", value1, value2, "gardenArea");
			return (Criteria) this;
		}

		public Criteria andGarageAmountIsNull() {
			addCriterion("GARAGE_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andGarageAmountIsNotNull() {
			addCriterion("GARAGE_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andGarageAmountEqualTo(Integer value) {
			addCriterion("GARAGE_AMOUNT =", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountNotEqualTo(Integer value) {
			addCriterion("GARAGE_AMOUNT <>", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountGreaterThan(Integer value) {
			addCriterion("GARAGE_AMOUNT >", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("GARAGE_AMOUNT >=", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountLessThan(Integer value) {
			addCriterion("GARAGE_AMOUNT <", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountLessThanOrEqualTo(Integer value) {
			addCriterion("GARAGE_AMOUNT <=", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountIn(List<Integer> values) {
			addCriterion("GARAGE_AMOUNT in", values, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountNotIn(List<Integer> values) {
			addCriterion("GARAGE_AMOUNT not in", values, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountBetween(Integer value1, Integer value2) {
			addCriterion("GARAGE_AMOUNT between", value1, value2, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("GARAGE_AMOUNT not between", value1, value2, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andLeaseSetIsNull() {
			addCriterion("LEASE_SET is null");
			return (Criteria) this;
		}

		public Criteria andLeaseSetIsNotNull() {
			addCriterion("LEASE_SET is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseSetEqualTo(String value) {
			addCriterion("LEASE_SET =", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetNotEqualTo(String value) {
			addCriterion("LEASE_SET <>", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetGreaterThan(String value) {
			addCriterion("LEASE_SET >", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_SET >=", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetLessThan(String value) {
			addCriterion("LEASE_SET <", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetLessThanOrEqualTo(String value) {
			addCriterion("LEASE_SET <=", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetLike(String value) {
			addCriterion("LEASE_SET like", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetNotLike(String value) {
			addCriterion("LEASE_SET not like", value, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetIn(List<String> values) {
			addCriterion("LEASE_SET in", values, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetNotIn(List<String> values) {
			addCriterion("LEASE_SET not in", values, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetBetween(String value1, String value2) {
			addCriterion("LEASE_SET between", value1, value2, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseSetNotBetween(String value1, String value2) {
			addCriterion("LEASE_SET not between", value1, value2, "leaseSet");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactIsNull() {
			addCriterion("LEASE_CHARACT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactIsNotNull() {
			addCriterion("LEASE_CHARACT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactEqualTo(String value) {
			addCriterion("LEASE_CHARACT =", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactNotEqualTo(String value) {
			addCriterion("LEASE_CHARACT <>", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactGreaterThan(String value) {
			addCriterion("LEASE_CHARACT >", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_CHARACT >=", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactLessThan(String value) {
			addCriterion("LEASE_CHARACT <", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactLessThanOrEqualTo(String value) {
			addCriterion("LEASE_CHARACT <=", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactLike(String value) {
			addCriterion("LEASE_CHARACT like", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactNotLike(String value) {
			addCriterion("LEASE_CHARACT not like", value, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactIn(List<String> values) {
			addCriterion("LEASE_CHARACT in", values, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactNotIn(List<String> values) {
			addCriterion("LEASE_CHARACT not in", values, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactBetween(String value1, String value2) {
			addCriterion("LEASE_CHARACT between", value1, value2, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseCharactNotBetween(String value1, String value2) {
			addCriterion("LEASE_CHARACT not between", value1, value2, "leaseCharact");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoIsNull() {
			addCriterion("LEASE_MEMO is null");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoIsNotNull() {
			addCriterion("LEASE_MEMO is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoEqualTo(String value) {
			addCriterion("LEASE_MEMO =", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoNotEqualTo(String value) {
			addCriterion("LEASE_MEMO <>", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoGreaterThan(String value) {
			addCriterion("LEASE_MEMO >", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_MEMO >=", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoLessThan(String value) {
			addCriterion("LEASE_MEMO <", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoLessThanOrEqualTo(String value) {
			addCriterion("LEASE_MEMO <=", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoLike(String value) {
			addCriterion("LEASE_MEMO like", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoNotLike(String value) {
			addCriterion("LEASE_MEMO not like", value, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoIn(List<String> values) {
			addCriterion("LEASE_MEMO in", values, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoNotIn(List<String> values) {
			addCriterion("LEASE_MEMO not in", values, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoBetween(String value1, String value2) {
			addCriterion("LEASE_MEMO between", value1, value2, "leaseMemo");
			return (Criteria) this;
		}

		public Criteria andLeaseMemoNotBetween(String value1, String value2) {
			addCriterion("LEASE_MEMO not between", value1, value2, "leaseMemo");
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

		public Criteria andLeaseKeyNumIsNull() {
			addCriterion("LEASE_KEY_NUM is null");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumIsNotNull() {
			addCriterion("LEASE_KEY_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumEqualTo(String value) {
			addCriterion("LEASE_KEY_NUM =", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumNotEqualTo(String value) {
			addCriterion("LEASE_KEY_NUM <>", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumGreaterThan(String value) {
			addCriterion("LEASE_KEY_NUM >", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_KEY_NUM >=", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumLessThan(String value) {
			addCriterion("LEASE_KEY_NUM <", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumLessThanOrEqualTo(String value) {
			addCriterion("LEASE_KEY_NUM <=", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumLike(String value) {
			addCriterion("LEASE_KEY_NUM like", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumNotLike(String value) {
			addCriterion("LEASE_KEY_NUM not like", value, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumIn(List<String> values) {
			addCriterion("LEASE_KEY_NUM in", values, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumNotIn(List<String> values) {
			addCriterion("LEASE_KEY_NUM not in", values, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumBetween(String value1, String value2) {
			addCriterion("LEASE_KEY_NUM between", value1, value2, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyNumNotBetween(String value1, String value2) {
			addCriterion("LEASE_KEY_NUM not between", value1, value2, "leaseKeyNum");
			return (Criteria) this;
		}

		public Criteria andKeyTimeIsNull() {
			addCriterion("KEY_TIME is null");
			return (Criteria) this;
		}

		public Criteria andKeyTimeIsNotNull() {
			addCriterion("KEY_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andKeyTimeEqualTo(Date value) {
			addCriterion("KEY_TIME =", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeNotEqualTo(Date value) {
			addCriterion("KEY_TIME <>", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeGreaterThan(Date value) {
			addCriterion("KEY_TIME >", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("KEY_TIME >=", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeLessThan(Date value) {
			addCriterion("KEY_TIME <", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeLessThanOrEqualTo(Date value) {
			addCriterion("KEY_TIME <=", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeLike(Date value) {
			addCriterion("KEY_TIME like", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeNotLike(Date value) {
			addCriterion("KEY_TIME not like", value, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeIn(List<Date> values) {
			addCriterion("KEY_TIME in", values, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeNotIn(List<Date> values) {
			addCriterion("KEY_TIME not in", values, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeBetween(Date value1, Date value2) {
			addCriterion("KEY_TIME between", value1, value2, "keyTime");
			return (Criteria) this;
		}

		public Criteria andKeyTimeNotBetween(Date value1, Date value2) {
			addCriterion("KEY_TIME not between", value1, value2, "keyTime");
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

		public Criteria andExplrthDatetimeIsNull() {
			addCriterion("EXPLRTH_DATETIME is null");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeIsNotNull() {
			addCriterion("EXPLRTH_DATETIME is not null");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeEqualTo(Date value) {
			addCriterion("EXPLRTH_DATETIME =", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeNotEqualTo(Date value) {
			addCriterion("EXPLRTH_DATETIME <>", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeGreaterThan(Date value) {
			addCriterion("EXPLRTH_DATETIME >", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("EXPLRTH_DATETIME >=", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeLessThan(Date value) {
			addCriterion("EXPLRTH_DATETIME <", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeLessThanOrEqualTo(Date value) {
			addCriterion("EXPLRTH_DATETIME <=", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeLike(Date value) {
			addCriterion("EXPLRTH_DATETIME like", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeNotLike(Date value) {
			addCriterion("EXPLRTH_DATETIME not like", value, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeIn(List<Date> values) {
			addCriterion("EXPLRTH_DATETIME in", values, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeNotIn(List<Date> values) {
			addCriterion("EXPLRTH_DATETIME not in", values, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeBetween(Date value1, Date value2) {
			addCriterion("EXPLRTH_DATETIME between", value1, value2, "explrthDatetime");
			return (Criteria) this;
		}

		public Criteria andExplrthDatetimeNotBetween(Date value1, Date value2) {
			addCriterion("EXPLRTH_DATETIME not between", value1, value2, "explrthDatetime");
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

		public Criteria andLeaseConsignEqualTo(Integer value) {
			addCriterion("LEASE_CONSIGN =", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNotEqualTo(Integer value) {
			addCriterion("LEASE_CONSIGN <>", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignGreaterThan(Integer value) {
			addCriterion("LEASE_CONSIGN >", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_CONSIGN >=", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignLessThan(Integer value) {
			addCriterion("LEASE_CONSIGN <", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_CONSIGN <=", value, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignIn(List<Integer> values) {
			addCriterion("LEASE_CONSIGN in", values, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNotIn(List<Integer> values) {
			addCriterion("LEASE_CONSIGN not in", values, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_CONSIGN between", value1, value2, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_CONSIGN not between", value1, value2, "leaseConsign");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoIsNull() {
			addCriterion("LEASE_CONSIGN_NO is null");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoIsNotNull() {
			addCriterion("LEASE_CONSIGN_NO is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoEqualTo(String value) {
			addCriterion("LEASE_CONSIGN_NO =", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoNotEqualTo(String value) {
			addCriterion("LEASE_CONSIGN_NO <>", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoGreaterThan(String value) {
			addCriterion("LEASE_CONSIGN_NO >", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_CONSIGN_NO >=", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoLessThan(String value) {
			addCriterion("LEASE_CONSIGN_NO <", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoLessThanOrEqualTo(String value) {
			addCriterion("LEASE_CONSIGN_NO <=", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoLike(String value) {
			addCriterion("LEASE_CONSIGN_NO like", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoNotLike(String value) {
			addCriterion("LEASE_CONSIGN_NO not like", value, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoIn(List<String> values) {
			addCriterion("LEASE_CONSIGN_NO in", values, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoNotIn(List<String> values) {
			addCriterion("LEASE_CONSIGN_NO not in", values, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoBetween(String value1, String value2) {
			addCriterion("LEASE_CONSIGN_NO between", value1, value2, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andLeaseConsignNoNotBetween(String value1, String value2) {
			addCriterion("LEASE_CONSIGN_NO not between", value1, value2, "leaseConsignNo");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeIsNull() {
			addCriterion("WEITUO_TIME is null");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeIsNotNull() {
			addCriterion("WEITUO_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeEqualTo(Date value) {
			addCriterion("WEITUO_TIME =", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeNotEqualTo(Date value) {
			addCriterion("WEITUO_TIME <>", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeGreaterThan(Date value) {
			addCriterion("WEITUO_TIME >", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("WEITUO_TIME >=", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeLessThan(Date value) {
			addCriterion("WEITUO_TIME <", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeLessThanOrEqualTo(Date value) {
			addCriterion("WEITUO_TIME <=", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeLike(Date value) {
			addCriterion("WEITUO_TIME like", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeNotLike(Date value) {
			addCriterion("WEITUO_TIME not like", value, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeIn(List<Date> values) {
			addCriterion("WEITUO_TIME in", values, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeNotIn(List<Date> values) {
			addCriterion("WEITUO_TIME not in", values, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeBetween(Date value1, Date value2) {
			addCriterion("WEITUO_TIME between", value1, value2, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andWeituoTimeNotBetween(Date value1, Date value2) {
			addCriterion("WEITUO_TIME not between", value1, value2, "weituoTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateIsNull() {
			addCriterion("LEASE_COOPERATE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateIsNotNull() {
			addCriterion("LEASE_COOPERATE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateEqualTo(Boolean value) {
			addCriterion("LEASE_COOPERATE =", value, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateNotEqualTo(Boolean value) {
			addCriterion("LEASE_COOPERATE <>", value, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateGreaterThan(Boolean value) {
			addCriterion("LEASE_COOPERATE >", value, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateGreaterThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_COOPERATE >=", value, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateLessThan(Boolean value) {
			addCriterion("LEASE_COOPERATE <", value, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateLessThanOrEqualTo(Boolean value) {
			addCriterion("LEASE_COOPERATE <=", value, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateIn(List<Boolean> values) {
			addCriterion("LEASE_COOPERATE in", values, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateNotIn(List<Boolean> values) {
			addCriterion("LEASE_COOPERATE not in", values, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_COOPERATE between", value1, value2, "leaseCooperate");
			return (Criteria) this;
		}

		public Criteria andLeaseCooperateNotBetween(Boolean value1, Boolean value2) {
			addCriterion("LEASE_COOPERATE not between", value1, value2, "leaseCooperate");
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

		public Criteria andCooperateTimeLike(Date value) {
			addCriterion("COOPERATE_TIME like", value, "cooperateTime");
			return (Criteria) this;
		}

		public Criteria andCooperateTimeNotLike(Date value) {
			addCriterion("COOPERATE_TIME not like", value, "cooperateTime");
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

		public Criteria andPublishTimeIsNull() {
			addCriterion("PUBLISH_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIsNotNull() {
			addCriterion("PUBLISH_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPublishTimeEqualTo(Date value) {
			addCriterion("PUBLISH_TIME =", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotEqualTo(Date value) {
			addCriterion("PUBLISH_TIME <>", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeGreaterThan(Date value) {
			addCriterion("PUBLISH_TIME >", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PUBLISH_TIME >=", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeLessThan(Date value) {
			addCriterion("PUBLISH_TIME <", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
			addCriterion("PUBLISH_TIME <=", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeLike(Date value) {
			addCriterion("PUBLISH_TIME like", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotLike(Date value) {
			addCriterion("PUBLISH_TIME not like", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIn(List<Date> values) {
			addCriterion("PUBLISH_TIME in", values, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotIn(List<Date> values) {
			addCriterion("PUBLISH_TIME not in", values, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeBetween(Date value1, Date value2) {
			addCriterion("PUBLISH_TIME between", value1, value2, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
			addCriterion("PUBLISH_TIME not between", value1, value2, "publishTime");
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

		public Criteria andPhotoTimeIsNull() {
			addCriterion("PHOTO_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeIsNotNull() {
			addCriterion("PHOTO_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeEqualTo(Date value) {
			addCriterion("PHOTO_TIME =", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeNotEqualTo(Date value) {
			addCriterion("PHOTO_TIME <>", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeGreaterThan(Date value) {
			addCriterion("PHOTO_TIME >", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PHOTO_TIME >=", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeLessThan(Date value) {
			addCriterion("PHOTO_TIME <", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeLessThanOrEqualTo(Date value) {
			addCriterion("PHOTO_TIME <=", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeLike(Date value) {
			addCriterion("PHOTO_TIME like", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeNotLike(Date value) {
			addCriterion("PHOTO_TIME not like", value, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeIn(List<Date> values) {
			addCriterion("PHOTO_TIME in", values, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeNotIn(List<Date> values) {
			addCriterion("PHOTO_TIME not in", values, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeBetween(Date value1, Date value2) {
			addCriterion("PHOTO_TIME between", value1, value2, "photoTime");
			return (Criteria) this;
		}

		public Criteria andPhotoTimeNotBetween(Date value1, Date value2) {
			addCriterion("PHOTO_TIME not between", value1, value2, "photoTime");
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

		public Criteria andTrackTimeIsNull() {
			addCriterion("TRACK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIsNotNull() {
			addCriterion("TRACK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTrackTimeEqualTo(Date value) {
			addCriterion("TRACK_TIME =", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotEqualTo(Date value) {
			addCriterion("TRACK_TIME <>", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeGreaterThan(Date value) {
			addCriterion("TRACK_TIME >", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TRACK_TIME >=", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLessThan(Date value) {
			addCriterion("TRACK_TIME <", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLessThanOrEqualTo(Date value) {
			addCriterion("TRACK_TIME <=", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeLike(Date value) {
			addCriterion("TRACK_TIME like", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotLike(Date value) {
			addCriterion("TRACK_TIME not like", value, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeIn(List<Date> values) {
			addCriterion("TRACK_TIME in", values, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotIn(List<Date> values) {
			addCriterion("TRACK_TIME not in", values, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeBetween(Date value1, Date value2) {
			addCriterion("TRACK_TIME between", value1, value2, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTimeNotBetween(Date value1, Date value2) {
			addCriterion("TRACK_TIME not between", value1, value2, "trackTime");
			return (Criteria) this;
		}

		public Criteria andTrackTime2IsNull() {
			addCriterion("TRACK_TIME2 is null");
			return (Criteria) this;
		}

		public Criteria andTrackTime2IsNotNull() {
			addCriterion("TRACK_TIME2 is not null");
			return (Criteria) this;
		}

		public Criteria andTrackTime2EqualTo(Date value) {
			addCriterion("TRACK_TIME2 =", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2NotEqualTo(Date value) {
			addCriterion("TRACK_TIME2 <>", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2GreaterThan(Date value) {
			addCriterion("TRACK_TIME2 >", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2GreaterThanOrEqualTo(Date value) {
			addCriterion("TRACK_TIME2 >=", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2LessThan(Date value) {
			addCriterion("TRACK_TIME2 <", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2LessThanOrEqualTo(Date value) {
			addCriterion("TRACK_TIME2 <=", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2Like(Date value) {
			addCriterion("TRACK_TIME2 like", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2NotLike(Date value) {
			addCriterion("TRACK_TIME2 not like", value, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2In(List<Date> values) {
			addCriterion("TRACK_TIME2 in", values, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2NotIn(List<Date> values) {
			addCriterion("TRACK_TIME2 not in", values, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2Between(Date value1, Date value2) {
			addCriterion("TRACK_TIME2 between", value1, value2, "trackTime2");
			return (Criteria) this;
		}

		public Criteria andTrackTime2NotBetween(Date value1, Date value2) {
			addCriterion("TRACK_TIME2 not between", value1, value2, "trackTime2");
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

		public Criteria andActionTimeEqualTo(Date value) {
			addCriterion("ACTION_TIME =", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotEqualTo(Date value) {
			addCriterion("ACTION_TIME <>", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeGreaterThan(Date value) {
			addCriterion("ACTION_TIME >", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ACTION_TIME >=", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeLessThan(Date value) {
			addCriterion("ACTION_TIME <", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeLessThanOrEqualTo(Date value) {
			addCriterion("ACTION_TIME <=", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeLike(Date value) {
			addCriterion("ACTION_TIME like", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotLike(Date value) {
			addCriterion("ACTION_TIME not like", value, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeIn(List<Date> values) {
			addCriterion("ACTION_TIME in", values, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotIn(List<Date> values) {
			addCriterion("ACTION_TIME not in", values, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeBetween(Date value1, Date value2) {
			addCriterion("ACTION_TIME between", value1, value2, "actionTime");
			return (Criteria) this;
		}

		public Criteria andActionTimeNotBetween(Date value1, Date value2) {
			addCriterion("ACTION_TIME not between", value1, value2, "actionTime");
			return (Criteria) this;
		}

		public Criteria andFromSosoIsNull() {
			addCriterion("FROM_SOSO is null");
			return (Criteria) this;
		}

		public Criteria andFromSosoIsNotNull() {
			addCriterion("FROM_SOSO is not null");
			return (Criteria) this;
		}

		public Criteria andFromSosoEqualTo(Boolean value) {
			addCriterion("FROM_SOSO =", value, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoNotEqualTo(Boolean value) {
			addCriterion("FROM_SOSO <>", value, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoGreaterThan(Boolean value) {
			addCriterion("FROM_SOSO >", value, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoGreaterThanOrEqualTo(Boolean value) {
			addCriterion("FROM_SOSO >=", value, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoLessThan(Boolean value) {
			addCriterion("FROM_SOSO <", value, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoLessThanOrEqualTo(Boolean value) {
			addCriterion("FROM_SOSO <=", value, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoIn(List<Boolean> values) {
			addCriterion("FROM_SOSO in", values, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoNotIn(List<Boolean> values) {
			addCriterion("FROM_SOSO not in", values, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoBetween(Boolean value1, Boolean value2) {
			addCriterion("FROM_SOSO between", value1, value2, "fromSoso");
			return (Criteria) this;
		}

		public Criteria andFromSosoNotBetween(Boolean value1, Boolean value2) {
			addCriterion("FROM_SOSO not between", value1, value2, "fromSoso");
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

		public Criteria andRepeatFlagEqualTo(Integer value) {
			addCriterion("REPEAT_FLAG =", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotEqualTo(Integer value) {
			addCriterion("REPEAT_FLAG <>", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagGreaterThan(Integer value) {
			addCriterion("REPEAT_FLAG >", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("REPEAT_FLAG >=", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagLessThan(Integer value) {
			addCriterion("REPEAT_FLAG <", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagLessThanOrEqualTo(Integer value) {
			addCriterion("REPEAT_FLAG <=", value, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagIn(List<Integer> values) {
			addCriterion("REPEAT_FLAG in", values, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotIn(List<Integer> values) {
			addCriterion("REPEAT_FLAG not in", values, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagBetween(Integer value1, Integer value2) {
			addCriterion("REPEAT_FLAG between", value1, value2, "repeatFlag");
			return (Criteria) this;
		}

		public Criteria andRepeatFlagNotBetween(Integer value1, Integer value2) {
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

		public Criteria andFriendHouseIsNull() {
			addCriterion("FRIEND_HOUSE is null");
			return (Criteria) this;
		}

		public Criteria andFriendHouseIsNotNull() {
			addCriterion("FRIEND_HOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andFriendHouseEqualTo(Boolean value) {
			addCriterion("FRIEND_HOUSE =", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseNotEqualTo(Boolean value) {
			addCriterion("FRIEND_HOUSE <>", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseGreaterThan(Boolean value) {
			addCriterion("FRIEND_HOUSE >", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseGreaterThanOrEqualTo(Boolean value) {
			addCriterion("FRIEND_HOUSE >=", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseLessThan(Boolean value) {
			addCriterion("FRIEND_HOUSE <", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseLessThanOrEqualTo(Boolean value) {
			addCriterion("FRIEND_HOUSE <=", value, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseIn(List<Boolean> values) {
			addCriterion("FRIEND_HOUSE in", values, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseNotIn(List<Boolean> values) {
			addCriterion("FRIEND_HOUSE not in", values, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseBetween(Boolean value1, Boolean value2) {
			addCriterion("FRIEND_HOUSE between", value1, value2, "friendHouse");
			return (Criteria) this;
		}

		public Criteria andFriendHouseNotBetween(Boolean value1, Boolean value2) {
			addCriterion("FRIEND_HOUSE not between", value1, value2, "friendHouse");
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

		public Criteria andPublicTimeEqualTo(Date value) {
			addCriterion("PUBLIC_TIME =", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotEqualTo(Date value) {
			addCriterion("PUBLIC_TIME <>", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeGreaterThan(Date value) {
			addCriterion("PUBLIC_TIME >", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PUBLIC_TIME >=", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeLessThan(Date value) {
			addCriterion("PUBLIC_TIME <", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeLessThanOrEqualTo(Date value) {
			addCriterion("PUBLIC_TIME <=", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeLike(Date value) {
			addCriterion("PUBLIC_TIME like", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotLike(Date value) {
			addCriterion("PUBLIC_TIME not like", value, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeIn(List<Date> values) {
			addCriterion("PUBLIC_TIME in", values, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotIn(List<Date> values) {
			addCriterion("PUBLIC_TIME not in", values, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeBetween(Date value1, Date value2) {
			addCriterion("PUBLIC_TIME between", value1, value2, "publicTime");
			return (Criteria) this;
		}

		public Criteria andPublicTimeNotBetween(Date value1, Date value2) {
			addCriterion("PUBLIC_TIME not between", value1, value2, "publicTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeIsNull() {
			addCriterion("DUE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDueTimeIsNotNull() {
			addCriterion("DUE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDueTimeEqualTo(Date value) {
			addCriterion("DUE_TIME =", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeNotEqualTo(Date value) {
			addCriterion("DUE_TIME <>", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeGreaterThan(Date value) {
			addCriterion("DUE_TIME >", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DUE_TIME >=", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeLessThan(Date value) {
			addCriterion("DUE_TIME <", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeLessThanOrEqualTo(Date value) {
			addCriterion("DUE_TIME <=", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeLike(Date value) {
			addCriterion("DUE_TIME like", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeNotLike(Date value) {
			addCriterion("DUE_TIME not like", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeIn(List<Date> values) {
			addCriterion("DUE_TIME in", values, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeNotIn(List<Date> values) {
			addCriterion("DUE_TIME not in", values, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeBetween(Date value1, Date value2) {
			addCriterion("DUE_TIME between", value1, value2, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeNotBetween(Date value1, Date value2) {
			addCriterion("DUE_TIME not between", value1, value2, "dueTime");
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

		public Criteria andSpecialTimeEqualTo(Date value) {
			addCriterion("SPECIAL_TIME =", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotEqualTo(Date value) {
			addCriterion("SPECIAL_TIME <>", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeGreaterThan(Date value) {
			addCriterion("SPECIAL_TIME >", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SPECIAL_TIME >=", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeLessThan(Date value) {
			addCriterion("SPECIAL_TIME <", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeLessThanOrEqualTo(Date value) {
			addCriterion("SPECIAL_TIME <=", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeLike(Date value) {
			addCriterion("SPECIAL_TIME like", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotLike(Date value) {
			addCriterion("SPECIAL_TIME not like", value, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeIn(List<Date> values) {
			addCriterion("SPECIAL_TIME in", values, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotIn(List<Date> values) {
			addCriterion("SPECIAL_TIME not in", values, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeBetween(Date value1, Date value2) {
			addCriterion("SPECIAL_TIME between", value1, value2, "specialTime");
			return (Criteria) this;
		}

		public Criteria andSpecialTimeNotBetween(Date value1, Date value2) {
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

		public Criteria andScheduleTimeEqualTo(Date value) {
			addCriterion("SCHEDULE_TIME =", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotEqualTo(Date value) {
			addCriterion("SCHEDULE_TIME <>", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeGreaterThan(Date value) {
			addCriterion("SCHEDULE_TIME >", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SCHEDULE_TIME >=", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeLessThan(Date value) {
			addCriterion("SCHEDULE_TIME <", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeLessThanOrEqualTo(Date value) {
			addCriterion("SCHEDULE_TIME <=", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeLike(Date value) {
			addCriterion("SCHEDULE_TIME like", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotLike(Date value) {
			addCriterion("SCHEDULE_TIME not like", value, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeIn(List<Date> values) {
			addCriterion("SCHEDULE_TIME in", values, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotIn(List<Date> values) {
			addCriterion("SCHEDULE_TIME not in", values, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeBetween(Date value1, Date value2) {
			addCriterion("SCHEDULE_TIME between", value1, value2, "scheduleTime");
			return (Criteria) this;
		}

		public Criteria andScheduleTimeNotBetween(Date value1, Date value2) {
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

		public Criteria andDealTimeEqualTo(Date value) {
			addCriterion("DEAL_TIME =", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotEqualTo(Date value) {
			addCriterion("DEAL_TIME <>", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeGreaterThan(Date value) {
			addCriterion("DEAL_TIME >", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DEAL_TIME >=", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLessThan(Date value) {
			addCriterion("DEAL_TIME <", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLessThanOrEqualTo(Date value) {
			addCriterion("DEAL_TIME <=", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLike(Date value) {
			addCriterion("DEAL_TIME like", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotLike(Date value) {
			addCriterion("DEAL_TIME not like", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeIn(List<Date> values) {
			addCriterion("DEAL_TIME in", values, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotIn(List<Date> values) {
			addCriterion("DEAL_TIME not in", values, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeBetween(Date value1, Date value2) {
			addCriterion("DEAL_TIME between", value1, value2, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotBetween(Date value1, Date value2) {
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

		public Criteria andWriteoffTimeEqualTo(Date value) {
			addCriterion("WRITEOFF_TIME =", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotEqualTo(Date value) {
			addCriterion("WRITEOFF_TIME <>", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeGreaterThan(Date value) {
			addCriterion("WRITEOFF_TIME >", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("WRITEOFF_TIME >=", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeLessThan(Date value) {
			addCriterion("WRITEOFF_TIME <", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeLessThanOrEqualTo(Date value) {
			addCriterion("WRITEOFF_TIME <=", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeLike(Date value) {
			addCriterion("WRITEOFF_TIME like", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotLike(Date value) {
			addCriterion("WRITEOFF_TIME not like", value, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeIn(List<Date> values) {
			addCriterion("WRITEOFF_TIME in", values, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotIn(List<Date> values) {
			addCriterion("WRITEOFF_TIME not in", values, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeBetween(Date value1, Date value2) {
			addCriterion("WRITEOFF_TIME between", value1, value2, "writeoffTime");
			return (Criteria) this;
		}

		public Criteria andWriteoffTimeNotBetween(Date value1, Date value2) {
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

		public Criteria andSecrecyTimeEqualTo(Date value) {
			addCriterion("SECRECY_TIME =", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotEqualTo(Date value) {
			addCriterion("SECRECY_TIME <>", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeGreaterThan(Date value) {
			addCriterion("SECRECY_TIME >", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SECRECY_TIME >=", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeLessThan(Date value) {
			addCriterion("SECRECY_TIME <", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeLessThanOrEqualTo(Date value) {
			addCriterion("SECRECY_TIME <=", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeLike(Date value) {
			addCriterion("SECRECY_TIME like", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotLike(Date value) {
			addCriterion("SECRECY_TIME not like", value, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeIn(List<Date> values) {
			addCriterion("SECRECY_TIME in", values, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotIn(List<Date> values) {
			addCriterion("SECRECY_TIME not in", values, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeBetween(Date value1, Date value2) {
			addCriterion("SECRECY_TIME between", value1, value2, "secrecyTime");
			return (Criteria) this;
		}

		public Criteria andSecrecyTimeNotBetween(Date value1, Date value2) {
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

		public Criteria andCommendTimeEqualTo(Date value) {
			addCriterion("COMMEND_TIME =", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotEqualTo(Date value) {
			addCriterion("COMMEND_TIME <>", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeGreaterThan(Date value) {
			addCriterion("COMMEND_TIME >", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("COMMEND_TIME >=", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeLessThan(Date value) {
			addCriterion("COMMEND_TIME <", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeLessThanOrEqualTo(Date value) {
			addCriterion("COMMEND_TIME <=", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeLike(Date value) {
			addCriterion("COMMEND_TIME like", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotLike(Date value) {
			addCriterion("COMMEND_TIME not like", value, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeIn(List<Date> values) {
			addCriterion("COMMEND_TIME in", values, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotIn(List<Date> values) {
			addCriterion("COMMEND_TIME not in", values, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeBetween(Date value1, Date value2) {
			addCriterion("COMMEND_TIME between", value1, value2, "commendTime");
			return (Criteria) this;
		}

		public Criteria andCommendTimeNotBetween(Date value1, Date value2) {
			addCriterion("COMMEND_TIME not between", value1, value2, "commendTime");
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

		public Criteria andPrivateTimeEqualTo(Date value) {
			addCriterion("PRIVATE_TIME =", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotEqualTo(Date value) {
			addCriterion("PRIVATE_TIME <>", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeGreaterThan(Date value) {
			addCriterion("PRIVATE_TIME >", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PRIVATE_TIME >=", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeLessThan(Date value) {
			addCriterion("PRIVATE_TIME <", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeLessThanOrEqualTo(Date value) {
			addCriterion("PRIVATE_TIME <=", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeLike(Date value) {
			addCriterion("PRIVATE_TIME like", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotLike(Date value) {
			addCriterion("PRIVATE_TIME not like", value, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeIn(List<Date> values) {
			addCriterion("PRIVATE_TIME in", values, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotIn(List<Date> values) {
			addCriterion("PRIVATE_TIME not in", values, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeBetween(Date value1, Date value2) {
			addCriterion("PRIVATE_TIME between", value1, value2, "privateTime");
			return (Criteria) this;
		}

		public Criteria andPrivateTimeNotBetween(Date value1, Date value2) {
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

		public Criteria andThumbUrlIsNull() {
			addCriterion("THUMB_URL is null");
			return (Criteria) this;
		}

		public Criteria andThumbUrlIsNotNull() {
			addCriterion("THUMB_URL is not null");
			return (Criteria) this;
		}

		public Criteria andThumbUrlEqualTo(String value) {
			addCriterion("THUMB_URL =", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlNotEqualTo(String value) {
			addCriterion("THUMB_URL <>", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlGreaterThan(String value) {
			addCriterion("THUMB_URL >", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlGreaterThanOrEqualTo(String value) {
			addCriterion("THUMB_URL >=", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlLessThan(String value) {
			addCriterion("THUMB_URL <", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlLessThanOrEqualTo(String value) {
			addCriterion("THUMB_URL <=", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlLike(String value) {
			addCriterion("THUMB_URL like", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlNotLike(String value) {
			addCriterion("THUMB_URL not like", value, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlIn(List<String> values) {
			addCriterion("THUMB_URL in", values, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlNotIn(List<String> values) {
			addCriterion("THUMB_URL not in", values, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlBetween(String value1, String value2) {
			addCriterion("THUMB_URL between", value1, value2, "thumbUrl");
			return (Criteria) this;
		}

		public Criteria andThumbUrlNotBetween(String value1, String value2) {
			addCriterion("THUMB_URL not between", value1, value2, "thumbUrl");
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

		public Criteria andTagIdsIsNull() {
			addCriterion("TAG_IDS is null");
			return (Criteria) this;
		}

		public Criteria andTagIdsIsNotNull() {
			addCriterion("TAG_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andTagIdsEqualTo(String value) {
			addCriterion("TAG_IDS =", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsNotEqualTo(String value) {
			addCriterion("TAG_IDS <>", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsGreaterThan(String value) {
			addCriterion("TAG_IDS >", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsGreaterThanOrEqualTo(String value) {
			addCriterion("TAG_IDS >=", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsLessThan(String value) {
			addCriterion("TAG_IDS <", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsLessThanOrEqualTo(String value) {
			addCriterion("TAG_IDS <=", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsLike(String value) {
			addCriterion("TAG_IDS like", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsNotLike(String value) {
			addCriterion("TAG_IDS not like", value, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsIn(List<String> values) {
			addCriterion("TAG_IDS in", values, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsNotIn(List<String> values) {
			addCriterion("TAG_IDS not in", values, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsBetween(String value1, String value2) {
			addCriterion("TAG_IDS between", value1, value2, "tagIds");
			return (Criteria) this;
		}

		public Criteria andTagIdsNotBetween(String value1, String value2) {
			addCriterion("TAG_IDS not between", value1, value2, "tagIds");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeIsNull() {
			addCriterion("LEASE_CERT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeIsNotNull() {
			addCriterion("LEASE_CERT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeEqualTo(Date value) {
			addCriterion("LEASE_CERT_TIME =", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeNotEqualTo(Date value) {
			addCriterion("LEASE_CERT_TIME <>", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeGreaterThan(Date value) {
			addCriterion("LEASE_CERT_TIME >", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LEASE_CERT_TIME >=", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeLessThan(Date value) {
			addCriterion("LEASE_CERT_TIME <", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeLessThanOrEqualTo(Date value) {
			addCriterion("LEASE_CERT_TIME <=", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeLike(Date value) {
			addCriterion("LEASE_CERT_TIME like", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeNotLike(Date value) {
			addCriterion("LEASE_CERT_TIME not like", value, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeIn(List<Date> values) {
			addCriterion("LEASE_CERT_TIME in", values, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeNotIn(List<Date> values) {
			addCriterion("LEASE_CERT_TIME not in", values, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeBetween(Date value1, Date value2) {
			addCriterion("LEASE_CERT_TIME between", value1, value2, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andLeaseCertTimeNotBetween(Date value1, Date value2) {
			addCriterion("LEASE_CERT_TIME not between", value1, value2, "leaseCertTime");
			return (Criteria) this;
		}

		public Criteria andPublishSitesIsNull() {
			addCriterion("PUBLISH_SITES is null");
			return (Criteria) this;
		}

		public Criteria andPublishSitesIsNotNull() {
			addCriterion("PUBLISH_SITES is not null");
			return (Criteria) this;
		}

		public Criteria andPublishSitesEqualTo(Integer value) {
			addCriterion("PUBLISH_SITES =", value, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesNotEqualTo(Integer value) {
			addCriterion("PUBLISH_SITES <>", value, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesGreaterThan(Integer value) {
			addCriterion("PUBLISH_SITES >", value, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesGreaterThanOrEqualTo(Integer value) {
			addCriterion("PUBLISH_SITES >=", value, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesLessThan(Integer value) {
			addCriterion("PUBLISH_SITES <", value, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesLessThanOrEqualTo(Integer value) {
			addCriterion("PUBLISH_SITES <=", value, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesIn(List<Integer> values) {
			addCriterion("PUBLISH_SITES in", values, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesNotIn(List<Integer> values) {
			addCriterion("PUBLISH_SITES not in", values, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesBetween(Integer value1, Integer value2) {
			addCriterion("PUBLISH_SITES between", value1, value2, "publishSites");
			return (Criteria) this;
		}

		public Criteria andPublishSitesNotBetween(Integer value1, Integer value2) {
			addCriterion("PUBLISH_SITES not between", value1, value2, "publishSites");
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

		public Criteria andLeaseRoofTIsNull() {
			addCriterion("LEASE_ROOF_T is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTIsNotNull() {
			addCriterion("LEASE_ROOF_T is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTEqualTo(String value) {
			addCriterion("LEASE_ROOF_T =", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTNotEqualTo(String value) {
			addCriterion("LEASE_ROOF_T <>", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTGreaterThan(String value) {
			addCriterion("LEASE_ROOF_T >", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_ROOF_T >=", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTLessThan(String value) {
			addCriterion("LEASE_ROOF_T <", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTLessThanOrEqualTo(String value) {
			addCriterion("LEASE_ROOF_T <=", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTLike(String value) {
			addCriterion("LEASE_ROOF_T like", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTNotLike(String value) {
			addCriterion("LEASE_ROOF_T not like", value, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTIn(List<String> values) {
			addCriterion("LEASE_ROOF_T in", values, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTNotIn(List<String> values) {
			addCriterion("LEASE_ROOF_T not in", values, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTBetween(String value1, String value2) {
			addCriterion("LEASE_ROOF_T between", value1, value2, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseRoofTNotBetween(String value1, String value2) {
			addCriterion("LEASE_ROOF_T not between", value1, value2, "leaseRoofT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTIsNull() {
			addCriterion("LEASE_NUM_T is null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTIsNotNull() {
			addCriterion("LEASE_NUM_T is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTEqualTo(String value) {
			addCriterion("LEASE_NUM_T =", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTNotEqualTo(String value) {
			addCriterion("LEASE_NUM_T <>", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTGreaterThan(String value) {
			addCriterion("LEASE_NUM_T >", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_NUM_T >=", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTLessThan(String value) {
			addCriterion("LEASE_NUM_T <", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTLessThanOrEqualTo(String value) {
			addCriterion("LEASE_NUM_T <=", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTLike(String value) {
			addCriterion("LEASE_NUM_T like", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTNotLike(String value) {
			addCriterion("LEASE_NUM_T not like", value, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTIn(List<String> values) {
			addCriterion("LEASE_NUM_T in", values, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTNotIn(List<String> values) {
			addCriterion("LEASE_NUM_T not in", values, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTBetween(String value1, String value2) {
			addCriterion("LEASE_NUM_T between", value1, value2, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseNumTNotBetween(String value1, String value2) {
			addCriterion("LEASE_NUM_T not between", value1, value2, "leaseNumT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTIsNull() {
			addCriterion("LEASE_UNIT_T is null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTIsNotNull() {
			addCriterion("LEASE_UNIT_T is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTEqualTo(String value) {
			addCriterion("LEASE_UNIT_T =", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTNotEqualTo(String value) {
			addCriterion("LEASE_UNIT_T <>", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTGreaterThan(String value) {
			addCriterion("LEASE_UNIT_T >", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTGreaterThanOrEqualTo(String value) {
			addCriterion("LEASE_UNIT_T >=", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTLessThan(String value) {
			addCriterion("LEASE_UNIT_T <", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTLessThanOrEqualTo(String value) {
			addCriterion("LEASE_UNIT_T <=", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTLike(String value) {
			addCriterion("LEASE_UNIT_T like", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTNotLike(String value) {
			addCriterion("LEASE_UNIT_T not like", value, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTIn(List<String> values) {
			addCriterion("LEASE_UNIT_T in", values, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTNotIn(List<String> values) {
			addCriterion("LEASE_UNIT_T not in", values, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTBetween(String value1, String value2) {
			addCriterion("LEASE_UNIT_T between", value1, value2, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitTNotBetween(String value1, String value2) {
			addCriterion("LEASE_UNIT_T not between", value1, value2, "leaseUnitT");
			return (Criteria) this;
		}

		public Criteria andLeaseRightIsNull() {
			addCriterion("LEASE_RIGHT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRightIsNotNull() {
			addCriterion("LEASE_RIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRightEqualTo(Byte value) {
			addCriterion("LEASE_RIGHT =", value, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightNotEqualTo(Byte value) {
			addCriterion("LEASE_RIGHT <>", value, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightGreaterThan(Byte value) {
			addCriterion("LEASE_RIGHT >", value, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_RIGHT >=", value, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightLessThan(Byte value) {
			addCriterion("LEASE_RIGHT <", value, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_RIGHT <=", value, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightIn(List<Byte> values) {
			addCriterion("LEASE_RIGHT in", values, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightNotIn(List<Byte> values) {
			addCriterion("LEASE_RIGHT not in", values, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_RIGHT between", value1, value2, "leaseRight");
			return (Criteria) this;
		}

		public Criteria andLeaseRightNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_RIGHT not between", value1, value2, "leaseRight");
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

		public Criteria andLeaseIdOldIsNull() {
			addCriterion("lease_id_old is null");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldIsNotNull() {
			addCriterion("lease_id_old is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldEqualTo(Integer value) {
			addCriterion("lease_id_old =", value, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldNotEqualTo(Integer value) {
			addCriterion("lease_id_old <>", value, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldGreaterThan(Integer value) {
			addCriterion("lease_id_old >", value, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldGreaterThanOrEqualTo(Integer value) {
			addCriterion("lease_id_old >=", value, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldLessThan(Integer value) {
			addCriterion("lease_id_old <", value, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldLessThanOrEqualTo(Integer value) {
			addCriterion("lease_id_old <=", value, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldIn(List<Integer> values) {
			addCriterion("lease_id_old in", values, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldNotIn(List<Integer> values) {
			addCriterion("lease_id_old not in", values, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldBetween(Integer value1, Integer value2) {
			addCriterion("lease_id_old between", value1, value2, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseIdOldNotBetween(Integer value1, Integer value2) {
			addCriterion("lease_id_old not between", value1, value2, "leaseIdOld");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaIsNull() {
			addCriterion("LEASE_INNERAREA is null");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaIsNotNull() {
			addCriterion("LEASE_INNERAREA is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaEqualTo(BigDecimal value) {
			addCriterion("LEASE_INNERAREA =", value, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_INNERAREA <>", value, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaGreaterThan(BigDecimal value) {
			addCriterion("LEASE_INNERAREA >", value, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_INNERAREA >=", value, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaLessThan(BigDecimal value) {
			addCriterion("LEASE_INNERAREA <", value, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_INNERAREA <=", value, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaIn(List<BigDecimal> values) {
			addCriterion("LEASE_INNERAREA in", values, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_INNERAREA not in", values, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_INNERAREA between", value1, value2, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andLeaseInnerareaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_INNERAREA not between", value1, value2, "leaseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseBargainIsNull() {
			addCriterion("HOUSE_BARGAIN is null");
			return (Criteria) this;
		}

		public Criteria andHouseBargainIsNotNull() {
			addCriterion("HOUSE_BARGAIN is not null");
			return (Criteria) this;
		}

		public Criteria andHouseBargainEqualTo(Boolean value) {
			addCriterion("HOUSE_BARGAIN =", value, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainNotEqualTo(Boolean value) {
			addCriterion("HOUSE_BARGAIN <>", value, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainGreaterThan(Boolean value) {
			addCriterion("HOUSE_BARGAIN >", value, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainGreaterThanOrEqualTo(Boolean value) {
			addCriterion("HOUSE_BARGAIN >=", value, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainLessThan(Boolean value) {
			addCriterion("HOUSE_BARGAIN <", value, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainLessThanOrEqualTo(Boolean value) {
			addCriterion("HOUSE_BARGAIN <=", value, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainIn(List<Boolean> values) {
			addCriterion("HOUSE_BARGAIN in", values, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainNotIn(List<Boolean> values) {
			addCriterion("HOUSE_BARGAIN not in", values, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainBetween(Boolean value1, Boolean value2) {
			addCriterion("HOUSE_BARGAIN between", value1, value2, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andHouseBargainNotBetween(Boolean value1, Boolean value2) {
			addCriterion("HOUSE_BARGAIN not between", value1, value2, "houseBargain");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagIsNull() {
			addCriterion("ENCODE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagIsNotNull() {
			addCriterion("ENCODE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagEqualTo(Byte value) {
			addCriterion("ENCODE_FLAG =", value, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagNotEqualTo(Byte value) {
			addCriterion("ENCODE_FLAG <>", value, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagGreaterThan(Byte value) {
			addCriterion("ENCODE_FLAG >", value, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENCODE_FLAG >=", value, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagLessThan(Byte value) {
			addCriterion("ENCODE_FLAG <", value, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagLessThanOrEqualTo(Byte value) {
			addCriterion("ENCODE_FLAG <=", value, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagIn(List<Byte> values) {
			addCriterion("ENCODE_FLAG in", values, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagNotIn(List<Byte> values) {
			addCriterion("ENCODE_FLAG not in", values, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagBetween(Byte value1, Byte value2) {
			addCriterion("ENCODE_FLAG between", value1, value2, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andEncodeFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("ENCODE_FLAG not between", value1, value2, "encodeFlag");
			return (Criteria) this;
		}

		public Criteria andLockIsNull() {
			addCriterion("[LOCK] is null");
			return (Criteria) this;
		}

		public Criteria andLockIsNotNull() {
			addCriterion("[LOCK] is not null");
			return (Criteria) this;
		}

		public Criteria andLockEqualTo(Byte value) {
			addCriterion("[LOCK] =", value, "lock");
			return (Criteria) this;
		}

		public Criteria andLockNotEqualTo(Byte value) {
			addCriterion("[LOCK] <>", value, "lock");
			return (Criteria) this;
		}

		public Criteria andLockGreaterThan(Byte value) {
			addCriterion("[LOCK] >", value, "lock");
			return (Criteria) this;
		}

		public Criteria andLockGreaterThanOrEqualTo(Byte value) {
			addCriterion("[LOCK] >=", value, "lock");
			return (Criteria) this;
		}

		public Criteria andLockLessThan(Byte value) {
			addCriterion("[LOCK] <", value, "lock");
			return (Criteria) this;
		}

		public Criteria andLockLessThanOrEqualTo(Byte value) {
			addCriterion("[LOCK] <=", value, "lock");
			return (Criteria) this;
		}

		public Criteria andLockIn(List<Byte> values) {
			addCriterion("[LOCK] in", values, "lock");
			return (Criteria) this;
		}

		public Criteria andLockNotIn(List<Byte> values) {
			addCriterion("[LOCK] not in", values, "lock");
			return (Criteria) this;
		}

		public Criteria andLockBetween(Byte value1, Byte value2) {
			addCriterion("[LOCK] between", value1, value2, "lock");
			return (Criteria) this;
		}

		public Criteria andLockNotBetween(Byte value1, Byte value2) {
			addCriterion("[LOCK] not between", value1, value2, "lock");
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

		public Criteria andSendtotencentIsNull() {
			addCriterion("SENDTOTENCENT is null");
			return (Criteria) this;
		}

		public Criteria andSendtotencentIsNotNull() {
			addCriterion("SENDTOTENCENT is not null");
			return (Criteria) this;
		}

		public Criteria andSendtotencentEqualTo(Byte value) {
			addCriterion("SENDTOTENCENT =", value, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentNotEqualTo(Byte value) {
			addCriterion("SENDTOTENCENT <>", value, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentGreaterThan(Byte value) {
			addCriterion("SENDTOTENCENT >", value, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentGreaterThanOrEqualTo(Byte value) {
			addCriterion("SENDTOTENCENT >=", value, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentLessThan(Byte value) {
			addCriterion("SENDTOTENCENT <", value, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentLessThanOrEqualTo(Byte value) {
			addCriterion("SENDTOTENCENT <=", value, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentIn(List<Byte> values) {
			addCriterion("SENDTOTENCENT in", values, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentNotIn(List<Byte> values) {
			addCriterion("SENDTOTENCENT not in", values, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentBetween(Byte value1, Byte value2) {
			addCriterion("SENDTOTENCENT between", value1, value2, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andSendtotencentNotBetween(Byte value1, Byte value2) {
			addCriterion("SENDTOTENCENT not between", value1, value2, "sendtotencent");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayIsNull() {
			addCriterion("HOUSE_SOURCE_WAY is null");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayIsNotNull() {
			addCriterion("HOUSE_SOURCE_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE_WAY =", value, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayNotEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE_WAY <>", value, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayGreaterThan(Byte value) {
			addCriterion("HOUSE_SOURCE_WAY >", value, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE_WAY >=", value, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayLessThan(Byte value) {
			addCriterion("HOUSE_SOURCE_WAY <", value, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE_WAY <=", value, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayIn(List<Byte> values) {
			addCriterion("HOUSE_SOURCE_WAY in", values, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayNotIn(List<Byte> values) {
			addCriterion("HOUSE_SOURCE_WAY not in", values, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SOURCE_WAY between", value1, value2, "houseSourceWay");
			return (Criteria) this;
		}

		public Criteria andHouseSourceWayNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SOURCE_WAY not between", value1, value2, "houseSourceWay");
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

		public Criteria andOwnerSexIsNull() {
			addCriterion("OWNER_SEX is null");
			return (Criteria) this;
		}

		public Criteria andOwnerSexIsNotNull() {
			addCriterion("OWNER_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerSexEqualTo(Byte value) {
			addCriterion("OWNER_SEX =", value, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexNotEqualTo(Byte value) {
			addCriterion("OWNER_SEX <>", value, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexGreaterThan(Byte value) {
			addCriterion("OWNER_SEX >", value, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexGreaterThanOrEqualTo(Byte value) {
			addCriterion("OWNER_SEX >=", value, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexLessThan(Byte value) {
			addCriterion("OWNER_SEX <", value, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexLessThanOrEqualTo(Byte value) {
			addCriterion("OWNER_SEX <=", value, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexIn(List<Byte> values) {
			addCriterion("OWNER_SEX in", values, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexNotIn(List<Byte> values) {
			addCriterion("OWNER_SEX not in", values, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexBetween(Byte value1, Byte value2) {
			addCriterion("OWNER_SEX between", value1, value2, "ownerSex");
			return (Criteria) this;
		}

		public Criteria andOwnerSexNotBetween(Byte value1, Byte value2) {
			addCriterion("OWNER_SEX not between", value1, value2, "ownerSex");
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

		public Criteria andThumbpicVerIsNull() {
			addCriterion("THUMBPIC_VER is null");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerIsNotNull() {
			addCriterion("THUMBPIC_VER is not null");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerEqualTo(String value) {
			addCriterion("THUMBPIC_VER =", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerNotEqualTo(String value) {
			addCriterion("THUMBPIC_VER <>", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerGreaterThan(String value) {
			addCriterion("THUMBPIC_VER >", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerGreaterThanOrEqualTo(String value) {
			addCriterion("THUMBPIC_VER >=", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerLessThan(String value) {
			addCriterion("THUMBPIC_VER <", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerLessThanOrEqualTo(String value) {
			addCriterion("THUMBPIC_VER <=", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerLike(String value) {
			addCriterion("THUMBPIC_VER like", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerNotLike(String value) {
			addCriterion("THUMBPIC_VER not like", value, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerIn(List<String> values) {
			addCriterion("THUMBPIC_VER in", values, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerNotIn(List<String> values) {
			addCriterion("THUMBPIC_VER not in", values, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerBetween(String value1, String value2) {
			addCriterion("THUMBPIC_VER between", value1, value2, "thumbpicVer");
			return (Criteria) this;
		}

		public Criteria andThumbpicVerNotBetween(String value1, String value2) {
			addCriterion("THUMBPIC_VER not between", value1, value2, "thumbpicVer");
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

		public Criteria andLeaseRoomTypeIsNull() {
			addCriterion("LEASE_ROOM_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeIsNotNull() {
			addCriterion("LEASE_ROOM_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_TYPE =", value, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeNotEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_TYPE <>", value, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeGreaterThan(Byte value) {
			addCriterion("LEASE_ROOM_TYPE >", value, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_TYPE >=", value, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeLessThan(Byte value) {
			addCriterion("LEASE_ROOM_TYPE <", value, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_TYPE <=", value, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeIn(List<Byte> values) {
			addCriterion("LEASE_ROOM_TYPE in", values, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeNotIn(List<Byte> values) {
			addCriterion("LEASE_ROOM_TYPE not in", values, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROOM_TYPE between", value1, value2, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROOM_TYPE not between", value1, value2, "leaseRoomType");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicIsNull() {
			addCriterion("LEASE_ROOM_CLASSIC is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicIsNotNull() {
			addCriterion("LEASE_ROOM_CLASSIC is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_CLASSIC =", value, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicNotEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_CLASSIC <>", value, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicGreaterThan(Byte value) {
			addCriterion("LEASE_ROOM_CLASSIC >", value, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_CLASSIC >=", value, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicLessThan(Byte value) {
			addCriterion("LEASE_ROOM_CLASSIC <", value, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_ROOM_CLASSIC <=", value, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicIn(List<Byte> values) {
			addCriterion("LEASE_ROOM_CLASSIC in", values, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicNotIn(List<Byte> values) {
			addCriterion("LEASE_ROOM_CLASSIC not in", values, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROOM_CLASSIC between", value1, value2, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andLeaseRoomClassicNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_ROOM_CLASSIC not between", value1, value2, "leaseRoomClassic");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexIsNull() {
			addCriterion("FLAT_SHARE_SEX is null");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexIsNotNull() {
			addCriterion("FLAT_SHARE_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexEqualTo(Byte value) {
			addCriterion("FLAT_SHARE_SEX =", value, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexNotEqualTo(Byte value) {
			addCriterion("FLAT_SHARE_SEX <>", value, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexGreaterThan(Byte value) {
			addCriterion("FLAT_SHARE_SEX >", value, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexGreaterThanOrEqualTo(Byte value) {
			addCriterion("FLAT_SHARE_SEX >=", value, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexLessThan(Byte value) {
			addCriterion("FLAT_SHARE_SEX <", value, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexLessThanOrEqualTo(Byte value) {
			addCriterion("FLAT_SHARE_SEX <=", value, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexIn(List<Byte> values) {
			addCriterion("FLAT_SHARE_SEX in", values, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexNotIn(List<Byte> values) {
			addCriterion("FLAT_SHARE_SEX not in", values, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexBetween(Byte value1, Byte value2) {
			addCriterion("FLAT_SHARE_SEX between", value1, value2, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andFlatShareSexNotBetween(Byte value1, Byte value2) {
			addCriterion("FLAT_SHARE_SEX not between", value1, value2, "flatShareSex");
			return (Criteria) this;
		}

		public Criteria andAddrMd5IsNull() {
			addCriterion("ADDR_MD5 is null");
			return (Criteria) this;
		}

		public Criteria andAddrMd5IsNotNull() {
			addCriterion("ADDR_MD5 is not null");
			return (Criteria) this;
		}

		public Criteria andAddrMd5EqualTo(String value) {
			addCriterion("ADDR_MD5 =", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5NotEqualTo(String value) {
			addCriterion("ADDR_MD5 <>", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5GreaterThan(String value) {
			addCriterion("ADDR_MD5 >", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5GreaterThanOrEqualTo(String value) {
			addCriterion("ADDR_MD5 >=", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5LessThan(String value) {
			addCriterion("ADDR_MD5 <", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5LessThanOrEqualTo(String value) {
			addCriterion("ADDR_MD5 <=", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5Like(String value) {
			addCriterion("ADDR_MD5 like", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5NotLike(String value) {
			addCriterion("ADDR_MD5 not like", value, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5In(List<String> values) {
			addCriterion("ADDR_MD5 in", values, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5NotIn(List<String> values) {
			addCriterion("ADDR_MD5 not in", values, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5Between(String value1, String value2) {
			addCriterion("ADDR_MD5 between", value1, value2, "addrMd5");
			return (Criteria) this;
		}

		public Criteria andAddrMd5NotBetween(String value1, String value2) {
			addCriterion("ADDR_MD5 not between", value1, value2, "addrMd5");
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

		public Criteria andYoujiaStatisticFlagIsNull() {
			addCriterion("YOUJIA_STATISTIC_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagIsNotNull() {
			addCriterion("YOUJIA_STATISTIC_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagEqualTo(Byte value) {
			addCriterion("YOUJIA_STATISTIC_FLAG =", value, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagNotEqualTo(Byte value) {
			addCriterion("YOUJIA_STATISTIC_FLAG <>", value, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagGreaterThan(Byte value) {
			addCriterion("YOUJIA_STATISTIC_FLAG >", value, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_STATISTIC_FLAG >=", value, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagLessThan(Byte value) {
			addCriterion("YOUJIA_STATISTIC_FLAG <", value, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_STATISTIC_FLAG <=", value, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagIn(List<Byte> values) {
			addCriterion("YOUJIA_STATISTIC_FLAG in", values, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagNotIn(List<Byte> values) {
			addCriterion("YOUJIA_STATISTIC_FLAG not in", values, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_STATISTIC_FLAG between", value1, value2, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andYoujiaStatisticFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_STATISTIC_FLAG not between", value1, value2, "youjiaStatisticFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagIsNull() {
			addCriterion("ADS_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andAdsFlagIsNotNull() {
			addCriterion("ADS_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andAdsFlagEqualTo(Byte value) {
			addCriterion("ADS_FLAG =", value, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagNotEqualTo(Byte value) {
			addCriterion("ADS_FLAG <>", value, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagGreaterThan(Byte value) {
			addCriterion("ADS_FLAG >", value, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("ADS_FLAG >=", value, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagLessThan(Byte value) {
			addCriterion("ADS_FLAG <", value, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagLessThanOrEqualTo(Byte value) {
			addCriterion("ADS_FLAG <=", value, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagIn(List<Byte> values) {
			addCriterion("ADS_FLAG in", values, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagNotIn(List<Byte> values) {
			addCriterion("ADS_FLAG not in", values, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagBetween(Byte value1, Byte value2) {
			addCriterion("ADS_FLAG between", value1, value2, "adsFlag");
			return (Criteria) this;
		}

		public Criteria andAdsFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("ADS_FLAG not between", value1, value2, "adsFlag");
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

		public Criteria andVideoReviewFlagIsNull() {
			addCriterion("VIDEO_REVIEW_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagIsNotNull() {
			addCriterion("VIDEO_REVIEW_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagEqualTo(Byte value) {
			addCriterion("VIDEO_REVIEW_FLAG =", value, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagNotEqualTo(Byte value) {
			addCriterion("VIDEO_REVIEW_FLAG <>", value, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagGreaterThan(Byte value) {
			addCriterion("VIDEO_REVIEW_FLAG >", value, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("VIDEO_REVIEW_FLAG >=", value, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagLessThan(Byte value) {
			addCriterion("VIDEO_REVIEW_FLAG <", value, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagLessThanOrEqualTo(Byte value) {
			addCriterion("VIDEO_REVIEW_FLAG <=", value, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagIn(List<Byte> values) {
			addCriterion("VIDEO_REVIEW_FLAG in", values, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagNotIn(List<Byte> values) {
			addCriterion("VIDEO_REVIEW_FLAG not in", values, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagBetween(Byte value1, Byte value2) {
			addCriterion("VIDEO_REVIEW_FLAG between", value1, value2, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVideoReviewFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("VIDEO_REVIEW_FLAG not between", value1, value2, "videoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaIsNull() {
			addCriterion("HAS_PANORAMA is null");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaIsNotNull() {
			addCriterion("HAS_PANORAMA is not null");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaEqualTo(Byte value) {
			addCriterion("HAS_PANORAMA =", value, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaNotEqualTo(Byte value) {
			addCriterion("HAS_PANORAMA <>", value, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaGreaterThan(Byte value) {
			addCriterion("HAS_PANORAMA >", value, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_PANORAMA >=", value, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaLessThan(Byte value) {
			addCriterion("HAS_PANORAMA <", value, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_PANORAMA <=", value, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaIn(List<Byte> values) {
			addCriterion("HAS_PANORAMA in", values, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaNotIn(List<Byte> values) {
			addCriterion("HAS_PANORAMA not in", values, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaBetween(Byte value1, Byte value2) {
			addCriterion("HAS_PANORAMA between", value1, value2, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andHasPanoramaNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_PANORAMA not between", value1, value2, "hasPanorama");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagIsNull() {
			addCriterion("BIDDING_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagIsNotNull() {
			addCriterion("BIDDING_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagEqualTo(Boolean value) {
			addCriterion("BIDDING_FLAG =", value, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagNotEqualTo(Boolean value) {
			addCriterion("BIDDING_FLAG <>", value, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagGreaterThan(Boolean value) {
			addCriterion("BIDDING_FLAG >", value, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("BIDDING_FLAG >=", value, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagLessThan(Boolean value) {
			addCriterion("BIDDING_FLAG <", value, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("BIDDING_FLAG <=", value, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagIn(List<Boolean> values) {
			addCriterion("BIDDING_FLAG in", values, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagNotIn(List<Boolean> values) {
			addCriterion("BIDDING_FLAG not in", values, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("BIDDING_FLAG between", value1, value2, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andBiddingFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("BIDDING_FLAG not between", value1, value2, "biddingFlag");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeIsNull() {
			addCriterion("COMPETE_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeIsNotNull() {
			addCriterion("COMPETE_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeEqualTo(Date value) {
			addCriterion("COMPETE_END_TIME =", value, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeNotEqualTo(Date value) {
			addCriterion("COMPETE_END_TIME <>", value, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeGreaterThan(Date value) {
			addCriterion("COMPETE_END_TIME >", value, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("COMPETE_END_TIME >=", value, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeLessThan(Date value) {
			addCriterion("COMPETE_END_TIME <", value, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("COMPETE_END_TIME <=", value, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeIn(List<Date> values) {
			addCriterion("COMPETE_END_TIME in", values, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeNotIn(List<Date> values) {
			addCriterion("COMPETE_END_TIME not in", values, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeBetween(Date value1, Date value2) {
			addCriterion("COMPETE_END_TIME between", value1, value2, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompeteEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("COMPETE_END_TIME not between", value1, value2, "competeEndTime");
			return (Criteria) this;
		}

		public Criteria andCompetePriceIsNull() {
			addCriterion("COMPETE_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andCompetePriceIsNotNull() {
			addCriterion("COMPETE_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andCompetePriceEqualTo(BigDecimal value) {
			addCriterion("COMPETE_PRICE =", value, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceNotEqualTo(BigDecimal value) {
			addCriterion("COMPETE_PRICE <>", value, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceGreaterThan(BigDecimal value) {
			addCriterion("COMPETE_PRICE >", value, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("COMPETE_PRICE >=", value, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceLessThan(BigDecimal value) {
			addCriterion("COMPETE_PRICE <", value, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("COMPETE_PRICE <=", value, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceIn(List<BigDecimal> values) {
			addCriterion("COMPETE_PRICE in", values, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceNotIn(List<BigDecimal> values) {
			addCriterion("COMPETE_PRICE not in", values, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMPETE_PRICE between", value1, value2, "competePrice");
			return (Criteria) this;
		}

		public Criteria andCompetePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMPETE_PRICE not between", value1, value2, "competePrice");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateIsNull() {
			addCriterion("YOU_SHARE_MONEY_STATE is null");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateIsNotNull() {
			addCriterion("YOU_SHARE_MONEY_STATE is not null");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateEqualTo(Byte value) {
			addCriterion("YOU_SHARE_MONEY_STATE =", value, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateNotEqualTo(Byte value) {
			addCriterion("YOU_SHARE_MONEY_STATE <>", value, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateGreaterThan(Byte value) {
			addCriterion("YOU_SHARE_MONEY_STATE >", value, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOU_SHARE_MONEY_STATE >=", value, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateLessThan(Byte value) {
			addCriterion("YOU_SHARE_MONEY_STATE <", value, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateLessThanOrEqualTo(Byte value) {
			addCriterion("YOU_SHARE_MONEY_STATE <=", value, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateIn(List<Byte> values) {
			addCriterion("YOU_SHARE_MONEY_STATE in", values, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateNotIn(List<Byte> values) {
			addCriterion("YOU_SHARE_MONEY_STATE not in", values, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateBetween(Byte value1, Byte value2) {
			addCriterion("YOU_SHARE_MONEY_STATE between", value1, value2, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andYouShareMoneyStateNotBetween(Byte value1, Byte value2) {
			addCriterion("YOU_SHARE_MONEY_STATE not between", value1, value2, "youShareMoneyState");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianIsNull() {
			addCriterion("SENDTO_WEIDIAN is null");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianIsNotNull() {
			addCriterion("SENDTO_WEIDIAN is not null");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianEqualTo(Byte value) {
			addCriterion("SENDTO_WEIDIAN =", value, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianNotEqualTo(Byte value) {
			addCriterion("SENDTO_WEIDIAN <>", value, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianGreaterThan(Byte value) {
			addCriterion("SENDTO_WEIDIAN >", value, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianGreaterThanOrEqualTo(Byte value) {
			addCriterion("SENDTO_WEIDIAN >=", value, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianLessThan(Byte value) {
			addCriterion("SENDTO_WEIDIAN <", value, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianLessThanOrEqualTo(Byte value) {
			addCriterion("SENDTO_WEIDIAN <=", value, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianIn(List<Byte> values) {
			addCriterion("SENDTO_WEIDIAN in", values, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianNotIn(List<Byte> values) {
			addCriterion("SENDTO_WEIDIAN not in", values, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianBetween(Byte value1, Byte value2) {
			addCriterion("SENDTO_WEIDIAN between", value1, value2, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoWeidianNotBetween(Byte value1, Byte value2) {
			addCriterion("SENDTO_WEIDIAN not between", value1, value2, "sendtoWeidian");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouIsNull() {
			addCriterion("SENDTO_YOUYOU is null");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouIsNotNull() {
			addCriterion("SENDTO_YOUYOU is not null");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouEqualTo(Byte value) {
			addCriterion("SENDTO_YOUYOU =", value, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouNotEqualTo(Byte value) {
			addCriterion("SENDTO_YOUYOU <>", value, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouGreaterThan(Byte value) {
			addCriterion("SENDTO_YOUYOU >", value, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouGreaterThanOrEqualTo(Byte value) {
			addCriterion("SENDTO_YOUYOU >=", value, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouLessThan(Byte value) {
			addCriterion("SENDTO_YOUYOU <", value, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouLessThanOrEqualTo(Byte value) {
			addCriterion("SENDTO_YOUYOU <=", value, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouIn(List<Byte> values) {
			addCriterion("SENDTO_YOUYOU in", values, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouNotIn(List<Byte> values) {
			addCriterion("SENDTO_YOUYOU not in", values, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouBetween(Byte value1, Byte value2) {
			addCriterion("SENDTO_YOUYOU between", value1, value2, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andSendtoYouyouNotBetween(Byte value1, Byte value2) {
			addCriterion("SENDTO_YOUYOU not between", value1, value2, "sendtoYouyou");
			return (Criteria) this;
		}

		public Criteria andYouyouDealIsNull() {
			addCriterion("YOUYOU_DEAL is null");
			return (Criteria) this;
		}

		public Criteria andYouyouDealIsNotNull() {
			addCriterion("YOUYOU_DEAL is not null");
			return (Criteria) this;
		}

		public Criteria andYouyouDealEqualTo(Byte value) {
			addCriterion("YOUYOU_DEAL =", value, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealNotEqualTo(Byte value) {
			addCriterion("YOUYOU_DEAL <>", value, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealGreaterThan(Byte value) {
			addCriterion("YOUYOU_DEAL >", value, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUYOU_DEAL >=", value, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealLessThan(Byte value) {
			addCriterion("YOUYOU_DEAL <", value, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealLessThanOrEqualTo(Byte value) {
			addCriterion("YOUYOU_DEAL <=", value, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealIn(List<Byte> values) {
			addCriterion("YOUYOU_DEAL in", values, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealNotIn(List<Byte> values) {
			addCriterion("YOUYOU_DEAL not in", values, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealBetween(Byte value1, Byte value2) {
			addCriterion("YOUYOU_DEAL between", value1, value2, "youyouDeal");
			return (Criteria) this;
		}

		public Criteria andYouyouDealNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUYOU_DEAL not between", value1, value2, "youyouDeal");
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

		public Criteria andProxyUrlIsNull() {
			addCriterion("PROXY_URL is null");
			return (Criteria) this;
		}

		public Criteria andProxyUrlIsNotNull() {
			addCriterion("PROXY_URL is not null");
			return (Criteria) this;
		}

		public Criteria andProxyUrlEqualTo(String value) {
			addCriterion("PROXY_URL =", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlNotEqualTo(String value) {
			addCriterion("PROXY_URL <>", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlGreaterThan(String value) {
			addCriterion("PROXY_URL >", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlGreaterThanOrEqualTo(String value) {
			addCriterion("PROXY_URL >=", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlLessThan(String value) {
			addCriterion("PROXY_URL <", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlLessThanOrEqualTo(String value) {
			addCriterion("PROXY_URL <=", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlLike(String value) {
			addCriterion("PROXY_URL like", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlNotLike(String value) {
			addCriterion("PROXY_URL not like", value, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlIn(List<String> values) {
			addCriterion("PROXY_URL in", values, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlNotIn(List<String> values) {
			addCriterion("PROXY_URL not in", values, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlBetween(String value1, String value2) {
			addCriterion("PROXY_URL between", value1, value2, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andProxyUrlNotBetween(String value1, String value2) {
			addCriterion("PROXY_URL not between", value1, value2, "proxyUrl");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserIsNull() {
			addCriterion("UPLOAD_PROXY_USER is null");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserIsNotNull() {
			addCriterion("UPLOAD_PROXY_USER is not null");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserEqualTo(String value) {
			addCriterion("UPLOAD_PROXY_USER =", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserNotEqualTo(String value) {
			addCriterion("UPLOAD_PROXY_USER <>", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserGreaterThan(String value) {
			addCriterion("UPLOAD_PROXY_USER >", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserGreaterThanOrEqualTo(String value) {
			addCriterion("UPLOAD_PROXY_USER >=", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserLessThan(String value) {
			addCriterion("UPLOAD_PROXY_USER <", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserLessThanOrEqualTo(String value) {
			addCriterion("UPLOAD_PROXY_USER <=", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserLike(String value) {
			addCriterion("UPLOAD_PROXY_USER like", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserNotLike(String value) {
			addCriterion("UPLOAD_PROXY_USER not like", value, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserIn(List<String> values) {
			addCriterion("UPLOAD_PROXY_USER in", values, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserNotIn(List<String> values) {
			addCriterion("UPLOAD_PROXY_USER not in", values, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserBetween(String value1, String value2) {
			addCriterion("UPLOAD_PROXY_USER between", value1, value2, "uploadProxyUser");
			return (Criteria) this;
		}

		public Criteria andUploadProxyUserNotBetween(String value1, String value2) {
			addCriterion("UPLOAD_PROXY_USER not between", value1, value2, "uploadProxyUser");
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

		public Criteria andBrandCompIdIsNull() {
			addCriterion("BRAND_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdIsNotNull() {
			addCriterion("BRAND_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdEqualTo(Integer value) {
			addCriterion("BRAND_COMP_ID =", value, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdNotEqualTo(Integer value) {
			addCriterion("BRAND_COMP_ID <>", value, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdGreaterThan(Integer value) {
			addCriterion("BRAND_COMP_ID >", value, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BRAND_COMP_ID >=", value, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdLessThan(Integer value) {
			addCriterion("BRAND_COMP_ID <", value, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("BRAND_COMP_ID <=", value, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdIn(List<Integer> values) {
			addCriterion("BRAND_COMP_ID in", values, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdNotIn(List<Integer> values) {
			addCriterion("BRAND_COMP_ID not in", values, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdBetween(Integer value1, Integer value2) {
			addCriterion("BRAND_COMP_ID between", value1, value2, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andBrandCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BRAND_COMP_ID not between", value1, value2, "brandCompId");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunIsNull() {
			addCriterion("CHECK_CODE_FUN is null");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunIsNotNull() {
			addCriterion("CHECK_CODE_FUN is not null");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunEqualTo(String value) {
			addCriterion("CHECK_CODE_FUN =", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunNotEqualTo(String value) {
			addCriterion("CHECK_CODE_FUN <>", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunGreaterThan(String value) {
			addCriterion("CHECK_CODE_FUN >", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunGreaterThanOrEqualTo(String value) {
			addCriterion("CHECK_CODE_FUN >=", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunLessThan(String value) {
			addCriterion("CHECK_CODE_FUN <", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunLessThanOrEqualTo(String value) {
			addCriterion("CHECK_CODE_FUN <=", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunLike(String value) {
			addCriterion("CHECK_CODE_FUN like", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunNotLike(String value) {
			addCriterion("CHECK_CODE_FUN not like", value, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunIn(List<String> values) {
			addCriterion("CHECK_CODE_FUN in", values, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunNotIn(List<String> values) {
			addCriterion("CHECK_CODE_FUN not in", values, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunBetween(String value1, String value2) {
			addCriterion("CHECK_CODE_FUN between", value1, value2, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andCheckCodeFunNotBetween(String value1, String value2) {
			addCriterion("CHECK_CODE_FUN not between", value1, value2, "checkCodeFun");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeIsNull() {
			addCriterion("OWNERSHIP_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeIsNotNull() {
			addCriterion("OWNERSHIP_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeEqualTo(Byte value) {
			addCriterion("OWNERSHIP_TYPE =", value, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeNotEqualTo(Byte value) {
			addCriterion("OWNERSHIP_TYPE <>", value, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeGreaterThan(Byte value) {
			addCriterion("OWNERSHIP_TYPE >", value, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("OWNERSHIP_TYPE >=", value, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeLessThan(Byte value) {
			addCriterion("OWNERSHIP_TYPE <", value, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeLessThanOrEqualTo(Byte value) {
			addCriterion("OWNERSHIP_TYPE <=", value, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeIn(List<Byte> values) {
			addCriterion("OWNERSHIP_TYPE in", values, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeNotIn(List<Byte> values) {
			addCriterion("OWNERSHIP_TYPE not in", values, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeBetween(Byte value1, Byte value2) {
			addCriterion("OWNERSHIP_TYPE between", value1, value2, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andOwnershipTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("OWNERSHIP_TYPE not between", value1, value2, "ownershipType");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateIsNull() {
			addCriterion("EFFECTIVE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateIsNotNull() {
			addCriterion("EFFECTIVE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateEqualTo(Date value) {
			addCriterion("EFFECTIVE_DATE =", value, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateNotEqualTo(Date value) {
			addCriterion("EFFECTIVE_DATE <>", value, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateGreaterThan(Date value) {
			addCriterion("EFFECTIVE_DATE >", value, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateGreaterThanOrEqualTo(Date value) {
			addCriterion("EFFECTIVE_DATE >=", value, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateLessThan(Date value) {
			addCriterion("EFFECTIVE_DATE <", value, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateLessThanOrEqualTo(Date value) {
			addCriterion("EFFECTIVE_DATE <=", value, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateIn(List<Date> values) {
			addCriterion("EFFECTIVE_DATE in", values, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateNotIn(List<Date> values) {
			addCriterion("EFFECTIVE_DATE not in", values, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateBetween(Date value1, Date value2) {
			addCriterion("EFFECTIVE_DATE between", value1, value2, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andEffectiveDateNotBetween(Date value1, Date value2) {
			addCriterion("EFFECTIVE_DATE not between", value1, value2, "effectiveDate");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunIsNull() {
			addCriterion("QZ_CODE_FUN is null");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunIsNotNull() {
			addCriterion("QZ_CODE_FUN is not null");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunEqualTo(String value) {
			addCriterion("QZ_CODE_FUN =", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunNotEqualTo(String value) {
			addCriterion("QZ_CODE_FUN <>", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunGreaterThan(String value) {
			addCriterion("QZ_CODE_FUN >", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunGreaterThanOrEqualTo(String value) {
			addCriterion("QZ_CODE_FUN >=", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunLessThan(String value) {
			addCriterion("QZ_CODE_FUN <", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunLessThanOrEqualTo(String value) {
			addCriterion("QZ_CODE_FUN <=", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunLike(String value) {
			addCriterion("QZ_CODE_FUN like", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunNotLike(String value) {
			addCriterion("QZ_CODE_FUN not like", value, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunIn(List<String> values) {
			addCriterion("QZ_CODE_FUN in", values, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunNotIn(List<String> values) {
			addCriterion("QZ_CODE_FUN not in", values, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunBetween(String value1, String value2) {
			addCriterion("QZ_CODE_FUN between", value1, value2, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andQzCodeFunNotBetween(String value1, String value2) {
			addCriterion("QZ_CODE_FUN not between", value1, value2, "qzCodeFun");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusIsNull() {
			addCriterion("FUNMANAGER_SALESTATUS is null");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusIsNotNull() {
			addCriterion("FUNMANAGER_SALESTATUS is not null");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusEqualTo(Byte value) {
			addCriterion("FUNMANAGER_SALESTATUS =", value, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusNotEqualTo(Byte value) {
			addCriterion("FUNMANAGER_SALESTATUS <>", value, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusGreaterThan(Byte value) {
			addCriterion("FUNMANAGER_SALESTATUS >", value, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("FUNMANAGER_SALESTATUS >=", value, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusLessThan(Byte value) {
			addCriterion("FUNMANAGER_SALESTATUS <", value, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusLessThanOrEqualTo(Byte value) {
			addCriterion("FUNMANAGER_SALESTATUS <=", value, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusIn(List<Byte> values) {
			addCriterion("FUNMANAGER_SALESTATUS in", values, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusNotIn(List<Byte> values) {
			addCriterion("FUNMANAGER_SALESTATUS not in", values, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusBetween(Byte value1, Byte value2) {
			addCriterion("FUNMANAGER_SALESTATUS between", value1, value2, "funmanagerSalestatus");
			return (Criteria) this;
		}

		public Criteria andFunmanagerSalestatusNotBetween(Byte value1, Byte value2) {
			addCriterion("FUNMANAGER_SALESTATUS not between", value1, value2, "funmanagerSalestatus");
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

		public Criteria andJointCellPhoneIsNull() {
			addCriterion("JOINT_CELL_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneIsNotNull() {
			addCriterion("JOINT_CELL_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneEqualTo(String value) {
			addCriterion("JOINT_CELL_PHONE =", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneNotEqualTo(String value) {
			addCriterion("JOINT_CELL_PHONE <>", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneGreaterThan(String value) {
			addCriterion("JOINT_CELL_PHONE >", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("JOINT_CELL_PHONE >=", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneLessThan(String value) {
			addCriterion("JOINT_CELL_PHONE <", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneLessThanOrEqualTo(String value) {
			addCriterion("JOINT_CELL_PHONE <=", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneLike(String value) {
			addCriterion("JOINT_CELL_PHONE like", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneNotLike(String value) {
			addCriterion("JOINT_CELL_PHONE not like", value, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneIn(List<String> values) {
			addCriterion("JOINT_CELL_PHONE in", values, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneNotIn(List<String> values) {
			addCriterion("JOINT_CELL_PHONE not in", values, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneBetween(String value1, String value2) {
			addCriterion("JOINT_CELL_PHONE between", value1, value2, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointCellPhoneNotBetween(String value1, String value2) {
			addCriterion("JOINT_CELL_PHONE not between", value1, value2, "jointCellPhone");
			return (Criteria) this;
		}

		public Criteria andJointUserNameIsNull() {
			addCriterion("JOINT_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andJointUserNameIsNotNull() {
			addCriterion("JOINT_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andJointUserNameEqualTo(String value) {
			addCriterion("JOINT_USER_NAME =", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameNotEqualTo(String value) {
			addCriterion("JOINT_USER_NAME <>", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameGreaterThan(String value) {
			addCriterion("JOINT_USER_NAME >", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("JOINT_USER_NAME >=", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameLessThan(String value) {
			addCriterion("JOINT_USER_NAME <", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameLessThanOrEqualTo(String value) {
			addCriterion("JOINT_USER_NAME <=", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameLike(String value) {
			addCriterion("JOINT_USER_NAME like", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameNotLike(String value) {
			addCriterion("JOINT_USER_NAME not like", value, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameIn(List<String> values) {
			addCriterion("JOINT_USER_NAME in", values, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameNotIn(List<String> values) {
			addCriterion("JOINT_USER_NAME not in", values, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameBetween(String value1, String value2) {
			addCriterion("JOINT_USER_NAME between", value1, value2, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserNameNotBetween(String value1, String value2) {
			addCriterion("JOINT_USER_NAME not between", value1, value2, "jointUserName");
			return (Criteria) this;
		}

		public Criteria andJointUserSexIsNull() {
			addCriterion("JOINT_USER_SEX is null");
			return (Criteria) this;
		}

		public Criteria andJointUserSexIsNotNull() {
			addCriterion("JOINT_USER_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andJointUserSexEqualTo(Byte value) {
			addCriterion("JOINT_USER_SEX =", value, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexNotEqualTo(Byte value) {
			addCriterion("JOINT_USER_SEX <>", value, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexGreaterThan(Byte value) {
			addCriterion("JOINT_USER_SEX >", value, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexGreaterThanOrEqualTo(Byte value) {
			addCriterion("JOINT_USER_SEX >=", value, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexLessThan(Byte value) {
			addCriterion("JOINT_USER_SEX <", value, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexLessThanOrEqualTo(Byte value) {
			addCriterion("JOINT_USER_SEX <=", value, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexIn(List<Byte> values) {
			addCriterion("JOINT_USER_SEX in", values, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexNotIn(List<Byte> values) {
			addCriterion("JOINT_USER_SEX not in", values, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexBetween(Byte value1, Byte value2) {
			addCriterion("JOINT_USER_SEX between", value1, value2, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointUserSexNotBetween(Byte value1, Byte value2) {
			addCriterion("JOINT_USER_SEX not between", value1, value2, "jointUserSex");
			return (Criteria) this;
		}

		public Criteria andJointIdCardIsNull() {
			addCriterion("JOINT_ID_CARD is null");
			return (Criteria) this;
		}

		public Criteria andJointIdCardIsNotNull() {
			addCriterion("JOINT_ID_CARD is not null");
			return (Criteria) this;
		}

		public Criteria andJointIdCardEqualTo(String value) {
			addCriterion("JOINT_ID_CARD =", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardNotEqualTo(String value) {
			addCriterion("JOINT_ID_CARD <>", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardGreaterThan(String value) {
			addCriterion("JOINT_ID_CARD >", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("JOINT_ID_CARD >=", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardLessThan(String value) {
			addCriterion("JOINT_ID_CARD <", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardLessThanOrEqualTo(String value) {
			addCriterion("JOINT_ID_CARD <=", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardLike(String value) {
			addCriterion("JOINT_ID_CARD like", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardNotLike(String value) {
			addCriterion("JOINT_ID_CARD not like", value, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardIn(List<String> values) {
			addCriterion("JOINT_ID_CARD in", values, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardNotIn(List<String> values) {
			addCriterion("JOINT_ID_CARD not in", values, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardBetween(String value1, String value2) {
			addCriterion("JOINT_ID_CARD between", value1, value2, "jointIdCard");
			return (Criteria) this;
		}

		public Criteria andJointIdCardNotBetween(String value1, String value2) {
			addCriterion("JOINT_ID_CARD not between", value1, value2, "jointIdCard");
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

		public Criteria andSaleLeaseIdIsNull() {
			addCriterion("SALE_LEASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdIsNotNull() {
			addCriterion("SALE_LEASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdEqualTo(Integer value) {
			addCriterion("SALE_LEASE_ID =", value, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdNotEqualTo(Integer value) {
			addCriterion("SALE_LEASE_ID <>", value, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdGreaterThan(Integer value) {
			addCriterion("SALE_LEASE_ID >", value, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_LEASE_ID >=", value, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdLessThan(Integer value) {
			addCriterion("SALE_LEASE_ID <", value, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_LEASE_ID <=", value, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdIn(List<Integer> values) {
			addCriterion("SALE_LEASE_ID in", values, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdNotIn(List<Integer> values) {
			addCriterion("SALE_LEASE_ID not in", values, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdBetween(Integer value1, Integer value2) {
			addCriterion("SALE_LEASE_ID between", value1, value2, "saleLeaseId");
			return (Criteria) this;
		}

		public Criteria andSaleLeaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_LEASE_ID not between", value1, value2, "saleLeaseId");
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

		public Criteria andEntrustEndTimeIsNull() {
			addCriterion("ENTRUST_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeIsNotNull() {
			addCriterion("ENTRUST_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeEqualTo(Date value) {
			addCriterion("ENTRUST_END_TIME =", value, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeNotEqualTo(Date value) {
			addCriterion("ENTRUST_END_TIME <>", value, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeGreaterThan(Date value) {
			addCriterion("ENTRUST_END_TIME >", value, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ENTRUST_END_TIME >=", value, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeLessThan(Date value) {
			addCriterion("ENTRUST_END_TIME <", value, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("ENTRUST_END_TIME <=", value, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeIn(List<Date> values) {
			addCriterion("ENTRUST_END_TIME in", values, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeNotIn(List<Date> values) {
			addCriterion("ENTRUST_END_TIME not in", values, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeBetween(Date value1, Date value2) {
			addCriterion("ENTRUST_END_TIME between", value1, value2, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("ENTRUST_END_TIME not between", value1, value2, "entrustEndTime");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserIsNull() {
			addCriterion("ENTRUST_CREATE_USER is null");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserIsNotNull() {
			addCriterion("ENTRUST_CREATE_USER is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserEqualTo(Integer value) {
			addCriterion("ENTRUST_CREATE_USER =", value, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserNotEqualTo(Integer value) {
			addCriterion("ENTRUST_CREATE_USER <>", value, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserGreaterThan(Integer value) {
			addCriterion("ENTRUST_CREATE_USER >", value, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_CREATE_USER >=", value, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserLessThan(Integer value) {
			addCriterion("ENTRUST_CREATE_USER <", value, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserLessThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_CREATE_USER <=", value, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserIn(List<Integer> values) {
			addCriterion("ENTRUST_CREATE_USER in", values, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserNotIn(List<Integer> values) {
			addCriterion("ENTRUST_CREATE_USER not in", values, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_CREATE_USER between", value1, value2, "entrustCreateUser");
			return (Criteria) this;
		}

		public Criteria andEntrustCreateUserNotBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_CREATE_USER not between", value1, value2, "entrustCreateUser");
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

		public Criteria andModifyPriceEndIsNull() {
			addCriterion("MODIFY_PRICE_END is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndIsNotNull() {
			addCriterion("MODIFY_PRICE_END is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END =", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndNotEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END <>", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndGreaterThan(Date value) {
			addCriterion("MODIFY_PRICE_END >", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndGreaterThanOrEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END >=", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndLessThan(Date value) {
			addCriterion("MODIFY_PRICE_END <", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndLessThanOrEqualTo(Date value) {
			addCriterion("MODIFY_PRICE_END <=", value, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndIn(List<Date> values) {
			addCriterion("MODIFY_PRICE_END in", values, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndNotIn(List<Date> values) {
			addCriterion("MODIFY_PRICE_END not in", values, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndBetween(Date value1, Date value2) {
			addCriterion("MODIFY_PRICE_END between", value1, value2, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceEndNotBetween(Date value1, Date value2) {
			addCriterion("MODIFY_PRICE_END not between", value1, value2, "modifyPriceEnd");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendIsNull() {
			addCriterion("MODIFY_PRICE_TREND is null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendIsNotNull() {
			addCriterion("MODIFY_PRICE_TREND is not null");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_TREND =", value, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendNotEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_TREND <>", value, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendGreaterThan(Byte value) {
			addCriterion("MODIFY_PRICE_TREND >", value, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendGreaterThanOrEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_TREND >=", value, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendLessThan(Byte value) {
			addCriterion("MODIFY_PRICE_TREND <", value, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendLessThanOrEqualTo(Byte value) {
			addCriterion("MODIFY_PRICE_TREND <=", value, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendIn(List<Byte> values) {
			addCriterion("MODIFY_PRICE_TREND in", values, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendNotIn(List<Byte> values) {
			addCriterion("MODIFY_PRICE_TREND not in", values, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendBetween(Byte value1, Byte value2) {
			addCriterion("MODIFY_PRICE_TREND between", value1, value2, "modifyPriceTrend");
			return (Criteria) this;
		}

		public Criteria andModifyPriceTrendNotBetween(Byte value1, Byte value2) {
			addCriterion("MODIFY_PRICE_TREND not between", value1, value2, "modifyPriceTrend");
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

		public Criteria andOldTrueFlagIsNull() {
			addCriterion("OLD_TRUE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagIsNotNull() {
			addCriterion("OLD_TRUE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagEqualTo(Byte value) {
			addCriterion("OLD_TRUE_FLAG =", value, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagNotEqualTo(Byte value) {
			addCriterion("OLD_TRUE_FLAG <>", value, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagGreaterThan(Byte value) {
			addCriterion("OLD_TRUE_FLAG >", value, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("OLD_TRUE_FLAG >=", value, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagLessThan(Byte value) {
			addCriterion("OLD_TRUE_FLAG <", value, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagLessThanOrEqualTo(Byte value) {
			addCriterion("OLD_TRUE_FLAG <=", value, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagIn(List<Byte> values) {
			addCriterion("OLD_TRUE_FLAG in", values, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagNotIn(List<Byte> values) {
			addCriterion("OLD_TRUE_FLAG not in", values, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagBetween(Byte value1, Byte value2) {
			addCriterion("OLD_TRUE_FLAG between", value1, value2, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andOldTrueFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("OLD_TRUE_FLAG not between", value1, value2, "oldTrueFlag");
			return (Criteria) this;
		}

		public Criteria andInnerNoIsNull() {
			addCriterion("INNER_NO is null");
			return (Criteria) this;
		}

		public Criteria andInnerNoIsNotNull() {
			addCriterion("INNER_NO is not null");
			return (Criteria) this;
		}

		public Criteria andInnerNoEqualTo(Integer value) {
			addCriterion("INNER_NO =", value, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoNotEqualTo(Integer value) {
			addCriterion("INNER_NO <>", value, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoGreaterThan(Integer value) {
			addCriterion("INNER_NO >", value, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("INNER_NO >=", value, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoLessThan(Integer value) {
			addCriterion("INNER_NO <", value, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoLessThanOrEqualTo(Integer value) {
			addCriterion("INNER_NO <=", value, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoIn(List<Integer> values) {
			addCriterion("INNER_NO in", values, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoNotIn(List<Integer> values) {
			addCriterion("INNER_NO not in", values, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoBetween(Integer value1, Integer value2) {
			addCriterion("INNER_NO between", value1, value2, "innerNo");
			return (Criteria) this;
		}

		public Criteria andInnerNoNotBetween(Integer value1, Integer value2) {
			addCriterion("INNER_NO not between", value1, value2, "innerNo");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeIsNull() {
			addCriterion("JOINT_ID_CARD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeIsNotNull() {
			addCriterion("JOINT_ID_CARD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeEqualTo(Integer value) {
			addCriterion("JOINT_ID_CARD_TYPE =", value, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeNotEqualTo(Integer value) {
			addCriterion("JOINT_ID_CARD_TYPE <>", value, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeGreaterThan(Integer value) {
			addCriterion("JOINT_ID_CARD_TYPE >", value, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("JOINT_ID_CARD_TYPE >=", value, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeLessThan(Integer value) {
			addCriterion("JOINT_ID_CARD_TYPE <", value, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("JOINT_ID_CARD_TYPE <=", value, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeIn(List<Integer> values) {
			addCriterion("JOINT_ID_CARD_TYPE in", values, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeNotIn(List<Integer> values) {
			addCriterion("JOINT_ID_CARD_TYPE not in", values, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeBetween(Integer value1, Integer value2) {
			addCriterion("JOINT_ID_CARD_TYPE between", value1, value2, "jointIdCardType");
			return (Criteria) this;
		}

		public Criteria andJointIdCardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("JOINT_ID_CARD_TYPE not between", value1, value2, "jointIdCardType");
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

		public Criteria andOfficeCharacterIsNull() {
			addCriterion("OFFICE_CHARACTER is null");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterIsNotNull() {
			addCriterion("OFFICE_CHARACTER is not null");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterEqualTo(Byte value) {
			addCriterion("OFFICE_CHARACTER =", value, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterNotEqualTo(Byte value) {
			addCriterion("OFFICE_CHARACTER <>", value, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterGreaterThan(Byte value) {
			addCriterion("OFFICE_CHARACTER >", value, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterGreaterThanOrEqualTo(Byte value) {
			addCriterion("OFFICE_CHARACTER >=", value, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterLessThan(Byte value) {
			addCriterion("OFFICE_CHARACTER <", value, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterLessThanOrEqualTo(Byte value) {
			addCriterion("OFFICE_CHARACTER <=", value, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterIn(List<Byte> values) {
			addCriterion("OFFICE_CHARACTER in", values, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterNotIn(List<Byte> values) {
			addCriterion("OFFICE_CHARACTER not in", values, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterBetween(Byte value1, Byte value2) {
			addCriterion("OFFICE_CHARACTER between", value1, value2, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeCharacterNotBetween(Byte value1, Byte value2) {
			addCriterion("OFFICE_CHARACTER not between", value1, value2, "officeCharacter");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxIsNull() {
			addCriterion("OFFICE_TAX is null");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxIsNotNull() {
			addCriterion("OFFICE_TAX is not null");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxEqualTo(Boolean value) {
			addCriterion("OFFICE_TAX =", value, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxNotEqualTo(Boolean value) {
			addCriterion("OFFICE_TAX <>", value, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxGreaterThan(Boolean value) {
			addCriterion("OFFICE_TAX >", value, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxGreaterThanOrEqualTo(Boolean value) {
			addCriterion("OFFICE_TAX >=", value, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxLessThan(Boolean value) {
			addCriterion("OFFICE_TAX <", value, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxLessThanOrEqualTo(Boolean value) {
			addCriterion("OFFICE_TAX <=", value, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxIn(List<Boolean> values) {
			addCriterion("OFFICE_TAX in", values, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxNotIn(List<Boolean> values) {
			addCriterion("OFFICE_TAX not in", values, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxBetween(Boolean value1, Boolean value2) {
			addCriterion("OFFICE_TAX between", value1, value2, "officeTax");
			return (Criteria) this;
		}

		public Criteria andOfficeTaxNotBetween(Boolean value1, Boolean value2) {
			addCriterion("OFFICE_TAX not between", value1, value2, "officeTax");
			return (Criteria) this;
		}

		public Criteria andLeaseBayIsNull() {
			addCriterion("LEASE_BAY is null");
			return (Criteria) this;
		}

		public Criteria andLeaseBayIsNotNull() {
			addCriterion("LEASE_BAY is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseBayEqualTo(BigDecimal value) {
			addCriterion("LEASE_BAY =", value, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_BAY <>", value, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayGreaterThan(BigDecimal value) {
			addCriterion("LEASE_BAY >", value, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_BAY >=", value, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayLessThan(BigDecimal value) {
			addCriterion("LEASE_BAY <", value, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_BAY <=", value, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayIn(List<BigDecimal> values) {
			addCriterion("LEASE_BAY in", values, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_BAY not in", values, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_BAY between", value1, value2, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseBayNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_BAY not between", value1, value2, "leaseBay");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthIsNull() {
			addCriterion("LEASE_DEPTH is null");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthIsNotNull() {
			addCriterion("LEASE_DEPTH is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthEqualTo(BigDecimal value) {
			addCriterion("LEASE_DEPTH =", value, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_DEPTH <>", value, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthGreaterThan(BigDecimal value) {
			addCriterion("LEASE_DEPTH >", value, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_DEPTH >=", value, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthLessThan(BigDecimal value) {
			addCriterion("LEASE_DEPTH <", value, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_DEPTH <=", value, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthIn(List<BigDecimal> values) {
			addCriterion("LEASE_DEPTH in", values, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_DEPTH not in", values, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_DEPTH between", value1, value2, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseDepthNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_DEPTH not between", value1, value2, "leaseDepth");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyIsNull() {
			addCriterion("LEASE_STOREY is null");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyIsNotNull() {
			addCriterion("LEASE_STOREY is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyEqualTo(BigDecimal value) {
			addCriterion("LEASE_STOREY =", value, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_STOREY <>", value, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyGreaterThan(BigDecimal value) {
			addCriterion("LEASE_STOREY >", value, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_STOREY >=", value, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyLessThan(BigDecimal value) {
			addCriterion("LEASE_STOREY <", value, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_STOREY <=", value, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyIn(List<BigDecimal> values) {
			addCriterion("LEASE_STOREY in", values, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_STOREY not in", values, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_STOREY between", value1, value2, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andLeaseStoreyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_STOREY not between", value1, value2, "leaseStorey");
			return (Criteria) this;
		}

		public Criteria andCheckTimeIsNull() {
			addCriterion("CHECK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCheckTimeIsNotNull() {
			addCriterion("CHECK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCheckTimeEqualTo(String value) {
			addCriterion("CHECK_TIME =", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotEqualTo(String value) {
			addCriterion("CHECK_TIME <>", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeGreaterThan(String value) {
			addCriterion("CHECK_TIME >", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeGreaterThanOrEqualTo(String value) {
			addCriterion("CHECK_TIME >=", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLessThan(String value) {
			addCriterion("CHECK_TIME <", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLessThanOrEqualTo(String value) {
			addCriterion("CHECK_TIME <=", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLike(String value) {
			addCriterion("CHECK_TIME like", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotLike(String value) {
			addCriterion("CHECK_TIME not like", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeIn(List<String> values) {
			addCriterion("CHECK_TIME in", values, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotIn(List<String> values) {
			addCriterion("CHECK_TIME not in", values, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeBetween(String value1, String value2) {
			addCriterion("CHECK_TIME between", value1, value2, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotBetween(String value1, String value2) {
			addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeIsNull() {
			addCriterion("FOCUS_TIME is null");
			return (Criteria) this;
		}

		public Criteria andFocusTimeIsNotNull() {
			addCriterion("FOCUS_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andFocusTimeEqualTo(Date value) {
			addCriterion("FOCUS_TIME =", value, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeNotEqualTo(Date value) {
			addCriterion("FOCUS_TIME <>", value, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeGreaterThan(Date value) {
			addCriterion("FOCUS_TIME >", value, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("FOCUS_TIME >=", value, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeLessThan(Date value) {
			addCriterion("FOCUS_TIME <", value, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeLessThanOrEqualTo(Date value) {
			addCriterion("FOCUS_TIME <=", value, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeIn(List<Date> values) {
			addCriterion("FOCUS_TIME in", values, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeNotIn(List<Date> values) {
			addCriterion("FOCUS_TIME not in", values, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeBetween(Date value1, Date value2) {
			addCriterion("FOCUS_TIME between", value1, value2, "focusTime");
			return (Criteria) this;
		}

		public Criteria andFocusTimeNotBetween(Date value1, Date value2) {
			addCriterion("FOCUS_TIME not between", value1, value2, "focusTime");
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

		public Criteria andFunkanUserIdIsNull() {
			addCriterion("FUNKAN_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdIsNotNull() {
			addCriterion("FUNKAN_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdEqualTo(Integer value) {
			addCriterion("FUNKAN_USER_ID =", value, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdNotEqualTo(Integer value) {
			addCriterion("FUNKAN_USER_ID <>", value, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdGreaterThan(Integer value) {
			addCriterion("FUNKAN_USER_ID >", value, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FUNKAN_USER_ID >=", value, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdLessThan(Integer value) {
			addCriterion("FUNKAN_USER_ID <", value, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("FUNKAN_USER_ID <=", value, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdIn(List<Integer> values) {
			addCriterion("FUNKAN_USER_ID in", values, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdNotIn(List<Integer> values) {
			addCriterion("FUNKAN_USER_ID not in", values, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdBetween(Integer value1, Integer value2) {
			addCriterion("FUNKAN_USER_ID between", value1, value2, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andFunkanUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FUNKAN_USER_ID not between", value1, value2, "funkanUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdIsNull() {
			addCriterion("LEASE_KEY_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdIsNotNull() {
			addCriterion("LEASE_KEY_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdEqualTo(Integer value) {
			addCriterion("LEASE_KEY_USER_ID =", value, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdNotEqualTo(Integer value) {
			addCriterion("LEASE_KEY_USER_ID <>", value, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdGreaterThan(Integer value) {
			addCriterion("LEASE_KEY_USER_ID >", value, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_KEY_USER_ID >=", value, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdLessThan(Integer value) {
			addCriterion("LEASE_KEY_USER_ID <", value, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_KEY_USER_ID <=", value, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdIn(List<Integer> values) {
			addCriterion("LEASE_KEY_USER_ID in", values, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdNotIn(List<Integer> values) {
			addCriterion("LEASE_KEY_USER_ID not in", values, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_KEY_USER_ID between", value1, value2, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andLeaseKeyUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_KEY_USER_ID not between", value1, value2, "leaseKeyUserId");
			return (Criteria) this;
		}

		public Criteria andFileCodingIsNull() {
			addCriterion("FILE_CODING is null");
			return (Criteria) this;
		}

		public Criteria andFileCodingIsNotNull() {
			addCriterion("FILE_CODING is not null");
			return (Criteria) this;
		}

		public Criteria andFileCodingEqualTo(String value) {
			addCriterion("FILE_CODING =", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingNotEqualTo(String value) {
			addCriterion("FILE_CODING <>", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingGreaterThan(String value) {
			addCriterion("FILE_CODING >", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingGreaterThanOrEqualTo(String value) {
			addCriterion("FILE_CODING >=", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingLessThan(String value) {
			addCriterion("FILE_CODING <", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingLessThanOrEqualTo(String value) {
			addCriterion("FILE_CODING <=", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingLike(String value) {
			addCriterion("FILE_CODING like", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingNotLike(String value) {
			addCriterion("FILE_CODING not like", value, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingIn(List<String> values) {
			addCriterion("FILE_CODING in", values, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingNotIn(List<String> values) {
			addCriterion("FILE_CODING not in", values, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingBetween(String value1, String value2) {
			addCriterion("FILE_CODING between", value1, value2, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andFileCodingNotBetween(String value1, String value2) {
			addCriterion("FILE_CODING not between", value1, value2, "fileCoding");
			return (Criteria) this;
		}

		public Criteria andLessorIsNull() {
			addCriterion("LESSOR is null");
			return (Criteria) this;
		}

		public Criteria andLessorIsNotNull() {
			addCriterion("LESSOR is not null");
			return (Criteria) this;
		}

		public Criteria andLessorEqualTo(Byte value) {
			addCriterion("LESSOR =", value, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorNotEqualTo(Byte value) {
			addCriterion("LESSOR <>", value, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorGreaterThan(Byte value) {
			addCriterion("LESSOR >", value, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorGreaterThanOrEqualTo(Byte value) {
			addCriterion("LESSOR >=", value, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorLessThan(Byte value) {
			addCriterion("LESSOR <", value, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorLessThanOrEqualTo(Byte value) {
			addCriterion("LESSOR <=", value, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorIn(List<Byte> values) {
			addCriterion("LESSOR in", values, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorNotIn(List<Byte> values) {
			addCriterion("LESSOR not in", values, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorBetween(Byte value1, Byte value2) {
			addCriterion("LESSOR between", value1, value2, "lessor");
			return (Criteria) this;
		}

		public Criteria andLessorNotBetween(Byte value1, Byte value2) {
			addCriterion("LESSOR not between", value1, value2, "lessor");
			return (Criteria) this;
		}

		public Criteria andTransferFeeIsNull() {
			addCriterion("TRANSFER_FEE is null");
			return (Criteria) this;
		}

		public Criteria andTransferFeeIsNotNull() {
			addCriterion("TRANSFER_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andTransferFeeEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE =", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeNotEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE <>", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeGreaterThan(BigDecimal value) {
			addCriterion("TRANSFER_FEE >", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE >=", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeLessThan(BigDecimal value) {
			addCriterion("TRANSFER_FEE <", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_FEE <=", value, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_FEE in", values, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeNotIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_FEE not in", values, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_FEE between", value1, value2, "transferFee");
			return (Criteria) this;
		}

		public Criteria andTransferFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_FEE not between", value1, value2, "transferFee");
			return (Criteria) this;
		}

		public Criteria andReturnRateIsNull() {
			addCriterion("RETURN_RATE is null");
			return (Criteria) this;
		}

		public Criteria andReturnRateIsNotNull() {
			addCriterion("RETURN_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andReturnRateEqualTo(BigDecimal value) {
			addCriterion("RETURN_RATE =", value, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateNotEqualTo(BigDecimal value) {
			addCriterion("RETURN_RATE <>", value, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateGreaterThan(BigDecimal value) {
			addCriterion("RETURN_RATE >", value, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("RETURN_RATE >=", value, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateLessThan(BigDecimal value) {
			addCriterion("RETURN_RATE <", value, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("RETURN_RATE <=", value, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateIn(List<BigDecimal> values) {
			addCriterion("RETURN_RATE in", values, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateNotIn(List<BigDecimal> values) {
			addCriterion("RETURN_RATE not in", values, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RETURN_RATE between", value1, value2, "returnRate");
			return (Criteria) this;
		}

		public Criteria andReturnRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RETURN_RATE not between", value1, value2, "returnRate");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompIsNull() {
			addCriterion("ML_RESERVED_COMP is null");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompIsNotNull() {
			addCriterion("ML_RESERVED_COMP is not null");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompEqualTo(String value) {
			addCriterion("ML_RESERVED_COMP =", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompNotEqualTo(String value) {
			addCriterion("ML_RESERVED_COMP <>", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompGreaterThan(String value) {
			addCriterion("ML_RESERVED_COMP >", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompGreaterThanOrEqualTo(String value) {
			addCriterion("ML_RESERVED_COMP >=", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompLessThan(String value) {
			addCriterion("ML_RESERVED_COMP <", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompLessThanOrEqualTo(String value) {
			addCriterion("ML_RESERVED_COMP <=", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompLike(String value) {
			addCriterion("ML_RESERVED_COMP like", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompNotLike(String value) {
			addCriterion("ML_RESERVED_COMP not like", value, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompIn(List<String> values) {
			addCriterion("ML_RESERVED_COMP in", values, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompNotIn(List<String> values) {
			addCriterion("ML_RESERVED_COMP not in", values, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompBetween(String value1, String value2) {
			addCriterion("ML_RESERVED_COMP between", value1, value2, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andMlReservedCompNotBetween(String value1, String value2) {
			addCriterion("ML_RESERVED_COMP not between", value1, value2, "mlReservedComp");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyIsNull() {
			addCriterion("HOUSE_VERIFY is null");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyIsNotNull() {
			addCriterion("HOUSE_VERIFY is not null");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyEqualTo(Byte value) {
			addCriterion("HOUSE_VERIFY =", value, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyNotEqualTo(Byte value) {
			addCriterion("HOUSE_VERIFY <>", value, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyGreaterThan(Byte value) {
			addCriterion("HOUSE_VERIFY >", value, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_VERIFY >=", value, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyLessThan(Byte value) {
			addCriterion("HOUSE_VERIFY <", value, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_VERIFY <=", value, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyIn(List<Byte> values) {
			addCriterion("HOUSE_VERIFY in", values, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyNotIn(List<Byte> values) {
			addCriterion("HOUSE_VERIFY not in", values, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_VERIFY between", value1, value2, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andHouseVerifyNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_VERIFY not between", value1, value2, "houseVerify");
			return (Criteria) this;
		}

		public Criteria andKitchenIsNull() {
			addCriterion("KITCHEN is null");
			return (Criteria) this;
		}

		public Criteria andKitchenIsNotNull() {
			addCriterion("KITCHEN is not null");
			return (Criteria) this;
		}

		public Criteria andKitchenEqualTo(Byte value) {
			addCriterion("KITCHEN =", value, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenNotEqualTo(Byte value) {
			addCriterion("KITCHEN <>", value, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenGreaterThan(Byte value) {
			addCriterion("KITCHEN >", value, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenGreaterThanOrEqualTo(Byte value) {
			addCriterion("KITCHEN >=", value, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenLessThan(Byte value) {
			addCriterion("KITCHEN <", value, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenLessThanOrEqualTo(Byte value) {
			addCriterion("KITCHEN <=", value, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenIn(List<Byte> values) {
			addCriterion("KITCHEN in", values, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenNotIn(List<Byte> values) {
			addCriterion("KITCHEN not in", values, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenBetween(Byte value1, Byte value2) {
			addCriterion("KITCHEN between", value1, value2, "kitchen");
			return (Criteria) this;
		}

		public Criteria andKitchenNotBetween(Byte value1, Byte value2) {
			addCriterion("KITCHEN not between", value1, value2, "kitchen");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerIsNull() {
			addCriterion("ML_WHOLE_LAYER is null");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerIsNotNull() {
			addCriterion("ML_WHOLE_LAYER is not null");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerEqualTo(Byte value) {
			addCriterion("ML_WHOLE_LAYER =", value, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerNotEqualTo(Byte value) {
			addCriterion("ML_WHOLE_LAYER <>", value, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerGreaterThan(Byte value) {
			addCriterion("ML_WHOLE_LAYER >", value, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerGreaterThanOrEqualTo(Byte value) {
			addCriterion("ML_WHOLE_LAYER >=", value, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerLessThan(Byte value) {
			addCriterion("ML_WHOLE_LAYER <", value, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerLessThanOrEqualTo(Byte value) {
			addCriterion("ML_WHOLE_LAYER <=", value, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerIn(List<Byte> values) {
			addCriterion("ML_WHOLE_LAYER in", values, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerNotIn(List<Byte> values) {
			addCriterion("ML_WHOLE_LAYER not in", values, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerBetween(Byte value1, Byte value2) {
			addCriterion("ML_WHOLE_LAYER between", value1, value2, "mlWholeLayer");
			return (Criteria) this;
		}

		public Criteria andMlWholeLayerNotBetween(Byte value1, Byte value2) {
			addCriterion("ML_WHOLE_LAYER not between", value1, value2, "mlWholeLayer");
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

		public Criteria andLeaseNatureIsNull() {
			addCriterion("LEASE_NATURE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureIsNotNull() {
			addCriterion("LEASE_NATURE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureEqualTo(Byte value) {
			addCriterion("LEASE_NATURE =", value, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureNotEqualTo(Byte value) {
			addCriterion("LEASE_NATURE <>", value, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureGreaterThan(Byte value) {
			addCriterion("LEASE_NATURE >", value, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_NATURE >=", value, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureLessThan(Byte value) {
			addCriterion("LEASE_NATURE <", value, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_NATURE <=", value, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureIn(List<Byte> values) {
			addCriterion("LEASE_NATURE in", values, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureNotIn(List<Byte> values) {
			addCriterion("LEASE_NATURE not in", values, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_NATURE between", value1, value2, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseNatureNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_NATURE not between", value1, value2, "leaseNature");
			return (Criteria) this;
		}

		public Criteria andLeaseStructIsNull() {
			addCriterion("LEASE_STRUCT is null");
			return (Criteria) this;
		}

		public Criteria andLeaseStructIsNotNull() {
			addCriterion("LEASE_STRUCT is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseStructEqualTo(Byte value) {
			addCriterion("LEASE_STRUCT =", value, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructNotEqualTo(Byte value) {
			addCriterion("LEASE_STRUCT <>", value, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructGreaterThan(Byte value) {
			addCriterion("LEASE_STRUCT >", value, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_STRUCT >=", value, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructLessThan(Byte value) {
			addCriterion("LEASE_STRUCT <", value, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_STRUCT <=", value, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructIn(List<Byte> values) {
			addCriterion("LEASE_STRUCT in", values, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructNotIn(List<Byte> values) {
			addCriterion("LEASE_STRUCT not in", values, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_STRUCT between", value1, value2, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseStructNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_STRUCT not between", value1, value2, "leaseStruct");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeIsNull() {
			addCriterion("LEASE_EXPIRATION_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeIsNotNull() {
			addCriterion("LEASE_EXPIRATION_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeEqualTo(Date value) {
			addCriterion("LEASE_EXPIRATION_TIME =", value, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeNotEqualTo(Date value) {
			addCriterion("LEASE_EXPIRATION_TIME <>", value, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeGreaterThan(Date value) {
			addCriterion("LEASE_EXPIRATION_TIME >", value, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LEASE_EXPIRATION_TIME >=", value, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeLessThan(Date value) {
			addCriterion("LEASE_EXPIRATION_TIME <", value, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeLessThanOrEqualTo(Date value) {
			addCriterion("LEASE_EXPIRATION_TIME <=", value, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeIn(List<Date> values) {
			addCriterion("LEASE_EXPIRATION_TIME in", values, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeNotIn(List<Date> values) {
			addCriterion("LEASE_EXPIRATION_TIME not in", values, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeBetween(Date value1, Date value2) {
			addCriterion("LEASE_EXPIRATION_TIME between", value1, value2, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andLeaseExpirationTimeNotBetween(Date value1, Date value2) {
			addCriterion("LEASE_EXPIRATION_TIME not between", value1, value2, "leaseExpirationTime");
			return (Criteria) this;
		}

		public Criteria andHouseSituationIsNull() {
			addCriterion("HOUSE_SITUATION is null");
			return (Criteria) this;
		}

		public Criteria andHouseSituationIsNotNull() {
			addCriterion("HOUSE_SITUATION is not null");
			return (Criteria) this;
		}

		public Criteria andHouseSituationEqualTo(Byte value) {
			addCriterion("HOUSE_SITUATION =", value, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationNotEqualTo(Byte value) {
			addCriterion("HOUSE_SITUATION <>", value, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationGreaterThan(Byte value) {
			addCriterion("HOUSE_SITUATION >", value, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SITUATION >=", value, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationLessThan(Byte value) {
			addCriterion("HOUSE_SITUATION <", value, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SITUATION <=", value, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationIn(List<Byte> values) {
			addCriterion("HOUSE_SITUATION in", values, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationNotIn(List<Byte> values) {
			addCriterion("HOUSE_SITUATION not in", values, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SITUATION between", value1, value2, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andHouseSituationNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SITUATION not between", value1, value2, "houseSituation");
			return (Criteria) this;
		}

		public Criteria andCurrentRentIsNull() {
			addCriterion("CURRENT_RENT is null");
			return (Criteria) this;
		}

		public Criteria andCurrentRentIsNotNull() {
			addCriterion("CURRENT_RENT is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentRentEqualTo(BigDecimal value) {
			addCriterion("CURRENT_RENT =", value, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentNotEqualTo(BigDecimal value) {
			addCriterion("CURRENT_RENT <>", value, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentGreaterThan(BigDecimal value) {
			addCriterion("CURRENT_RENT >", value, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("CURRENT_RENT >=", value, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentLessThan(BigDecimal value) {
			addCriterion("CURRENT_RENT <", value, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("CURRENT_RENT <=", value, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentIn(List<BigDecimal> values) {
			addCriterion("CURRENT_RENT in", values, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentNotIn(List<BigDecimal> values) {
			addCriterion("CURRENT_RENT not in", values, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CURRENT_RENT between", value1, value2, "currentRent");
			return (Criteria) this;
		}

		public Criteria andCurrentRentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CURRENT_RENT not between", value1, value2, "currentRent");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusIsNull() {
			addCriterion("TRANSACTION_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusIsNotNull() {
			addCriterion("TRANSACTION_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusEqualTo(Byte value) {
			addCriterion("TRANSACTION_STATUS =", value, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusNotEqualTo(Byte value) {
			addCriterion("TRANSACTION_STATUS <>", value, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusGreaterThan(Byte value) {
			addCriterion("TRANSACTION_STATUS >", value, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRANSACTION_STATUS >=", value, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusLessThan(Byte value) {
			addCriterion("TRANSACTION_STATUS <", value, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusLessThanOrEqualTo(Byte value) {
			addCriterion("TRANSACTION_STATUS <=", value, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusIn(List<Byte> values) {
			addCriterion("TRANSACTION_STATUS in", values, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusNotIn(List<Byte> values) {
			addCriterion("TRANSACTION_STATUS not in", values, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusBetween(Byte value1, Byte value2) {
			addCriterion("TRANSACTION_STATUS between", value1, value2, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andTransactionStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("TRANSACTION_STATUS not between", value1, value2, "transactionStatus");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceIsNull() {
			addCriterion("LEASE_UNIT_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceIsNotNull() {
			addCriterion("LEASE_UNIT_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceEqualTo(BigDecimal value) {
			addCriterion("LEASE_UNIT_PRICE =", value, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_UNIT_PRICE <>", value, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_UNIT_PRICE >", value, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_UNIT_PRICE >=", value, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceLessThan(BigDecimal value) {
			addCriterion("LEASE_UNIT_PRICE <", value, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_UNIT_PRICE <=", value, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceIn(List<BigDecimal> values) {
			addCriterion("LEASE_UNIT_PRICE in", values, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_UNIT_PRICE not in", values, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_UNIT_PRICE between", value1, value2, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_UNIT_PRICE not between", value1, value2, "leaseUnitPrice");
			return (Criteria) this;
		}

		public Criteria andHasRecordedIsNull() {
			addCriterion("HAS_RECORDED is null");
			return (Criteria) this;
		}

		public Criteria andHasRecordedIsNotNull() {
			addCriterion("HAS_RECORDED is not null");
			return (Criteria) this;
		}

		public Criteria andHasRecordedEqualTo(Byte value) {
			addCriterion("HAS_RECORDED =", value, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedNotEqualTo(Byte value) {
			addCriterion("HAS_RECORDED <>", value, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedGreaterThan(Byte value) {
			addCriterion("HAS_RECORDED >", value, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_RECORDED >=", value, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedLessThan(Byte value) {
			addCriterion("HAS_RECORDED <", value, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_RECORDED <=", value, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedIn(List<Byte> values) {
			addCriterion("HAS_RECORDED in", values, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedNotIn(List<Byte> values) {
			addCriterion("HAS_RECORDED not in", values, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedBetween(Byte value1, Byte value2) {
			addCriterion("HAS_RECORDED between", value1, value2, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andHasRecordedNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_RECORDED not between", value1, value2, "hasRecorded");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceIsNull() {
			addCriterion("LEASE_ENTRUST_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceIsNotNull() {
			addCriterion("LEASE_ENTRUST_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE =", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE <>", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE >", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE >=", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceLessThan(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE <", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_ENTRUST_PRICE <=", value, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceIn(List<BigDecimal> values) {
			addCriterion("LEASE_ENTRUST_PRICE in", values, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_ENTRUST_PRICE not in", values, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_ENTRUST_PRICE between", value1, value2, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andLeaseEntrustPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_ENTRUST_PRICE not between", value1, value2, "leaseEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andHasEntrustIsNull() {
			addCriterion("HAS_ENTRUST is null");
			return (Criteria) this;
		}

		public Criteria andHasEntrustIsNotNull() {
			addCriterion("HAS_ENTRUST is not null");
			return (Criteria) this;
		}

		public Criteria andHasEntrustEqualTo(Byte value) {
			addCriterion("HAS_ENTRUST =", value, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustNotEqualTo(Byte value) {
			addCriterion("HAS_ENTRUST <>", value, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustGreaterThan(Byte value) {
			addCriterion("HAS_ENTRUST >", value, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustGreaterThanOrEqualTo(Byte value) {
			addCriterion("HAS_ENTRUST >=", value, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustLessThan(Byte value) {
			addCriterion("HAS_ENTRUST <", value, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustLessThanOrEqualTo(Byte value) {
			addCriterion("HAS_ENTRUST <=", value, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustIn(List<Byte> values) {
			addCriterion("HAS_ENTRUST in", values, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustNotIn(List<Byte> values) {
			addCriterion("HAS_ENTRUST not in", values, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustBetween(Byte value1, Byte value2) {
			addCriterion("HAS_ENTRUST between", value1, value2, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andHasEntrustNotBetween(Byte value1, Byte value2) {
			addCriterion("HAS_ENTRUST not between", value1, value2, "hasEntrust");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeIsNull() {
			addCriterion("OFFEREE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeIsNotNull() {
			addCriterion("OFFEREE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeEqualTo(Date value) {
			addCriterion("OFFEREE_TIME =", value, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeNotEqualTo(Date value) {
			addCriterion("OFFEREE_TIME <>", value, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeGreaterThan(Date value) {
			addCriterion("OFFEREE_TIME >", value, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("OFFEREE_TIME >=", value, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeLessThan(Date value) {
			addCriterion("OFFEREE_TIME <", value, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeLessThanOrEqualTo(Date value) {
			addCriterion("OFFEREE_TIME <=", value, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeIn(List<Date> values) {
			addCriterion("OFFEREE_TIME in", values, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeNotIn(List<Date> values) {
			addCriterion("OFFEREE_TIME not in", values, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeBetween(Date value1, Date value2) {
			addCriterion("OFFEREE_TIME between", value1, value2, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andOffereeTimeNotBetween(Date value1, Date value2) {
			addCriterion("OFFEREE_TIME not between", value1, value2, "offereeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeIsNull() {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeIsNotNull() {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeEqualTo(Date value) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME =", value, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeNotEqualTo(Date value) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME <>", value, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeGreaterThan(Date value) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME >", value, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME >=", value, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeLessThan(Date value) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME <", value, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeLessThanOrEqualTo(Date value) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME <=", value, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeIn(List<Date> values) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME in", values, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeNotIn(List<Date> values) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME not in", values, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeBetween(Date value1, Date value2) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME between", value1, value2, "leaseAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andLeaseAmountChangeTimeNotBetween(Date value1, Date value2) {
			addCriterion("LEASE_AMOUNT_CHANGE_TIME not between", value1, value2, "leaseAmountChangeTime");
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