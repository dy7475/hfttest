package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunSaleExample extends ShardDb {
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
	public ErpFunSaleExample() {
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

		public Criteria andSaleIdIsNull() {
			addCriterion("SALE_ID is null");
			return (Criteria) this;
		}

		public Criteria andSaleIdIsNotNull() {
			addCriterion("SALE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSaleIdEqualTo(Integer value) {
			addCriterion("SALE_ID =", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotEqualTo(Integer value) {
			addCriterion("SALE_ID <>", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdGreaterThan(Integer value) {
			addCriterion("SALE_ID >", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_ID >=", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdLessThan(Integer value) {
			addCriterion("SALE_ID <", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_ID <=", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdIn(List<Integer> values) {
			addCriterion("SALE_ID in", values, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotIn(List<Integer> values) {
			addCriterion("SALE_ID not in", values, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdBetween(Integer value1, Integer value2) {
			addCriterion("SALE_ID between", value1, value2, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_ID not between", value1, value2, "saleId");
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

		public Criteria andSaleNoIsNull() {
			addCriterion("SALE_NO is null");
			return (Criteria) this;
		}

		public Criteria andSaleNoIsNotNull() {
			addCriterion("SALE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSaleNoEqualTo(String value) {
			addCriterion("SALE_NO =", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoNotEqualTo(String value) {
			addCriterion("SALE_NO <>", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoGreaterThan(String value) {
			addCriterion("SALE_NO >", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_NO >=", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoLessThan(String value) {
			addCriterion("SALE_NO <", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoLessThanOrEqualTo(String value) {
			addCriterion("SALE_NO <=", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoLike(String value) {
			addCriterion("SALE_NO like", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoNotLike(String value) {
			addCriterion("SALE_NO not like", value, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoIn(List<String> values) {
			addCriterion("SALE_NO in", values, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoNotIn(List<String> values) {
			addCriterion("SALE_NO not in", values, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoBetween(String value1, String value2) {
			addCriterion("SALE_NO between", value1, value2, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleNoNotBetween(String value1, String value2) {
			addCriterion("SALE_NO not between", value1, value2, "saleNo");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerIsNull() {
			addCriterion("SALE_OWNER is null");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerIsNotNull() {
			addCriterion("SALE_OWNER is not null");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerEqualTo(String value) {
			addCriterion("SALE_OWNER =", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerNotEqualTo(String value) {
			addCriterion("SALE_OWNER <>", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerGreaterThan(String value) {
			addCriterion("SALE_OWNER >", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_OWNER >=", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerLessThan(String value) {
			addCriterion("SALE_OWNER <", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerLessThanOrEqualTo(String value) {
			addCriterion("SALE_OWNER <=", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerLike(String value) {
			addCriterion("SALE_OWNER like", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerNotLike(String value) {
			addCriterion("SALE_OWNER not like", value, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerIn(List<String> values) {
			addCriterion("SALE_OWNER in", values, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerNotIn(List<String> values) {
			addCriterion("SALE_OWNER not in", values, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerBetween(String value1, String value2) {
			addCriterion("SALE_OWNER between", value1, value2, "saleOwner");
			return (Criteria) this;
		}

		public Criteria andSaleOwnerNotBetween(String value1, String value2) {
			addCriterion("SALE_OWNER not between", value1, value2, "saleOwner");
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

		public Criteria andSaleSubjectIsNull() {
			addCriterion("SALE_SUBJECT is null");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectIsNotNull() {
			addCriterion("SALE_SUBJECT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectEqualTo(String value) {
			addCriterion("SALE_SUBJECT =", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectNotEqualTo(String value) {
			addCriterion("SALE_SUBJECT <>", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectGreaterThan(String value) {
			addCriterion("SALE_SUBJECT >", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_SUBJECT >=", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectLessThan(String value) {
			addCriterion("SALE_SUBJECT <", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectLessThanOrEqualTo(String value) {
			addCriterion("SALE_SUBJECT <=", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectLike(String value) {
			addCriterion("SALE_SUBJECT like", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectNotLike(String value) {
			addCriterion("SALE_SUBJECT not like", value, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectIn(List<String> values) {
			addCriterion("SALE_SUBJECT in", values, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectNotIn(List<String> values) {
			addCriterion("SALE_SUBJECT not in", values, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectBetween(String value1, String value2) {
			addCriterion("SALE_SUBJECT between", value1, value2, "saleSubject");
			return (Criteria) this;
		}

		public Criteria andSaleSubjectNotBetween(String value1, String value2) {
			addCriterion("SALE_SUBJECT not between", value1, value2, "saleSubject");
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

		public Criteria andSaleRegIsNull() {
			addCriterion("SALE_REG is null");
			return (Criteria) this;
		}

		public Criteria andSaleRegIsNotNull() {
			addCriterion("SALE_REG is not null");
			return (Criteria) this;
		}

		public Criteria andSaleRegEqualTo(Integer value) {
			addCriterion("SALE_REG =", value, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegNotEqualTo(Integer value) {
			addCriterion("SALE_REG <>", value, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegGreaterThan(Integer value) {
			addCriterion("SALE_REG >", value, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_REG >=", value, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegLessThan(Integer value) {
			addCriterion("SALE_REG <", value, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_REG <=", value, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegIn(List<Integer> values) {
			addCriterion("SALE_REG in", values, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegNotIn(List<Integer> values) {
			addCriterion("SALE_REG not in", values, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegBetween(Integer value1, Integer value2) {
			addCriterion("SALE_REG between", value1, value2, "saleReg");
			return (Criteria) this;
		}

		public Criteria andSaleRegNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_REG not between", value1, value2, "saleReg");
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

		public Criteria andSaleRoundIsNull() {
			addCriterion("SALE_ROUND is null");
			return (Criteria) this;
		}

		public Criteria andSaleRoundIsNotNull() {
			addCriterion("SALE_ROUND is not null");
			return (Criteria) this;
		}

		public Criteria andSaleRoundEqualTo(Byte value) {
			addCriterion("SALE_ROUND =", value, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundNotEqualTo(Byte value) {
			addCriterion("SALE_ROUND <>", value, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundGreaterThan(Byte value) {
			addCriterion("SALE_ROUND >", value, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_ROUND >=", value, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundLessThan(Byte value) {
			addCriterion("SALE_ROUND <", value, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_ROUND <=", value, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundIn(List<Byte> values) {
			addCriterion("SALE_ROUND in", values, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundNotIn(List<Byte> values) {
			addCriterion("SALE_ROUND not in", values, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundBetween(Byte value1, Byte value2) {
			addCriterion("SALE_ROUND between", value1, value2, "saleRound");
			return (Criteria) this;
		}

		public Criteria andSaleRoundNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_ROUND not between", value1, value2, "saleRound");
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

		public Criteria andSaleRoofIsNull() {
			addCriterion("SALE_ROOF is null");
			return (Criteria) this;
		}

		public Criteria andSaleRoofIsNotNull() {
			addCriterion("SALE_ROOF is not null");
			return (Criteria) this;
		}

		public Criteria andSaleRoofEqualTo(String value) {
			addCriterion("SALE_ROOF =", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofNotEqualTo(String value) {
			addCriterion("SALE_ROOF <>", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofGreaterThan(String value) {
			addCriterion("SALE_ROOF >", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_ROOF >=", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofLessThan(String value) {
			addCriterion("SALE_ROOF <", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofLessThanOrEqualTo(String value) {
			addCriterion("SALE_ROOF <=", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofLike(String value) {
			addCriterion("SALE_ROOF like", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofNotLike(String value) {
			addCriterion("SALE_ROOF not like", value, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofIn(List<String> values) {
			addCriterion("SALE_ROOF in", values, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofNotIn(List<String> values) {
			addCriterion("SALE_ROOF not in", values, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofBetween(String value1, String value2) {
			addCriterion("SALE_ROOF between", value1, value2, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleRoofNotBetween(String value1, String value2) {
			addCriterion("SALE_ROOF not between", value1, value2, "saleRoof");
			return (Criteria) this;
		}

		public Criteria andSaleUnitIsNull() {
			addCriterion("SALE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitIsNotNull() {
			addCriterion("SALE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitEqualTo(String value) {
			addCriterion("SALE_UNIT =", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitNotEqualTo(String value) {
			addCriterion("SALE_UNIT <>", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitGreaterThan(String value) {
			addCriterion("SALE_UNIT >", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_UNIT >=", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitLessThan(String value) {
			addCriterion("SALE_UNIT <", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitLessThanOrEqualTo(String value) {
			addCriterion("SALE_UNIT <=", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitLike(String value) {
			addCriterion("SALE_UNIT like", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitNotLike(String value) {
			addCriterion("SALE_UNIT not like", value, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitIn(List<String> values) {
			addCriterion("SALE_UNIT in", values, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitNotIn(List<String> values) {
			addCriterion("SALE_UNIT not in", values, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitBetween(String value1, String value2) {
			addCriterion("SALE_UNIT between", value1, value2, "saleUnit");
			return (Criteria) this;
		}

		public Criteria andSaleUnitNotBetween(String value1, String value2) {
			addCriterion("SALE_UNIT not between", value1, value2, "saleUnit");
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

		public Criteria andSaleNumIsNull() {
			addCriterion("SALE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andSaleNumIsNotNull() {
			addCriterion("SALE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andSaleNumEqualTo(String value) {
			addCriterion("SALE_NUM =", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumNotEqualTo(String value) {
			addCriterion("SALE_NUM <>", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumGreaterThan(String value) {
			addCriterion("SALE_NUM >", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_NUM >=", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumLessThan(String value) {
			addCriterion("SALE_NUM <", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumLessThanOrEqualTo(String value) {
			addCriterion("SALE_NUM <=", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumLike(String value) {
			addCriterion("SALE_NUM like", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumNotLike(String value) {
			addCriterion("SALE_NUM not like", value, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumIn(List<String> values) {
			addCriterion("SALE_NUM in", values, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumNotIn(List<String> values) {
			addCriterion("SALE_NUM not in", values, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumBetween(String value1, String value2) {
			addCriterion("SALE_NUM between", value1, value2, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleNumNotBetween(String value1, String value2) {
			addCriterion("SALE_NUM not between", value1, value2, "saleNum");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRIsNull() {
			addCriterion("SALE_ROOF_R is null");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRIsNotNull() {
			addCriterion("SALE_ROOF_R is not null");
			return (Criteria) this;
		}

		public Criteria andSaleRoofREqualTo(String value) {
			addCriterion("SALE_ROOF_R =", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRNotEqualTo(String value) {
			addCriterion("SALE_ROOF_R <>", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRGreaterThan(String value) {
			addCriterion("SALE_ROOF_R >", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_ROOF_R >=", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRLessThan(String value) {
			addCriterion("SALE_ROOF_R <", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRLessThanOrEqualTo(String value) {
			addCriterion("SALE_ROOF_R <=", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRLike(String value) {
			addCriterion("SALE_ROOF_R like", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRNotLike(String value) {
			addCriterion("SALE_ROOF_R not like", value, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRIn(List<String> values) {
			addCriterion("SALE_ROOF_R in", values, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRNotIn(List<String> values) {
			addCriterion("SALE_ROOF_R not in", values, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRBetween(String value1, String value2) {
			addCriterion("SALE_ROOF_R between", value1, value2, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleRoofRNotBetween(String value1, String value2) {
			addCriterion("SALE_ROOF_R not between", value1, value2, "saleRoofR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRIsNull() {
			addCriterion("SALE_UNIT_R is null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRIsNotNull() {
			addCriterion("SALE_UNIT_R is not null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitREqualTo(String value) {
			addCriterion("SALE_UNIT_R =", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRNotEqualTo(String value) {
			addCriterion("SALE_UNIT_R <>", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRGreaterThan(String value) {
			addCriterion("SALE_UNIT_R >", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_UNIT_R >=", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRLessThan(String value) {
			addCriterion("SALE_UNIT_R <", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRLessThanOrEqualTo(String value) {
			addCriterion("SALE_UNIT_R <=", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRLike(String value) {
			addCriterion("SALE_UNIT_R like", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRNotLike(String value) {
			addCriterion("SALE_UNIT_R not like", value, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRIn(List<String> values) {
			addCriterion("SALE_UNIT_R in", values, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRNotIn(List<String> values) {
			addCriterion("SALE_UNIT_R not in", values, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRBetween(String value1, String value2) {
			addCriterion("SALE_UNIT_R between", value1, value2, "saleUnitR");
			return (Criteria) this;
		}

		public Criteria andSaleUnitRNotBetween(String value1, String value2) {
			addCriterion("SALE_UNIT_R not between", value1, value2, "saleUnitR");
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

		public Criteria andSaleNumRIsNull() {
			addCriterion("SALE_NUM_R is null");
			return (Criteria) this;
		}

		public Criteria andSaleNumRIsNotNull() {
			addCriterion("SALE_NUM_R is not null");
			return (Criteria) this;
		}

		public Criteria andSaleNumREqualTo(String value) {
			addCriterion("SALE_NUM_R =", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRNotEqualTo(String value) {
			addCriterion("SALE_NUM_R <>", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRGreaterThan(String value) {
			addCriterion("SALE_NUM_R >", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_NUM_R >=", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRLessThan(String value) {
			addCriterion("SALE_NUM_R <", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRLessThanOrEqualTo(String value) {
			addCriterion("SALE_NUM_R <=", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRLike(String value) {
			addCriterion("SALE_NUM_R like", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRNotLike(String value) {
			addCriterion("SALE_NUM_R not like", value, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRIn(List<String> values) {
			addCriterion("SALE_NUM_R in", values, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRNotIn(List<String> values) {
			addCriterion("SALE_NUM_R not in", values, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRBetween(String value1, String value2) {
			addCriterion("SALE_NUM_R between", value1, value2, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleNumRNotBetween(String value1, String value2) {
			addCriterion("SALE_NUM_R not between", value1, value2, "saleNumR");
			return (Criteria) this;
		}

		public Criteria andSaleLadderIsNull() {
			addCriterion("SALE_LADDER is null");
			return (Criteria) this;
		}

		public Criteria andSaleLadderIsNotNull() {
			addCriterion("SALE_LADDER is not null");
			return (Criteria) this;
		}

		public Criteria andSaleLadderEqualTo(Integer value) {
			addCriterion("SALE_LADDER =", value, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderNotEqualTo(Integer value) {
			addCriterion("SALE_LADDER <>", value, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderGreaterThan(Integer value) {
			addCriterion("SALE_LADDER >", value, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_LADDER >=", value, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderLessThan(Integer value) {
			addCriterion("SALE_LADDER <", value, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_LADDER <=", value, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderIn(List<Integer> values) {
			addCriterion("SALE_LADDER in", values, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderNotIn(List<Integer> values) {
			addCriterion("SALE_LADDER not in", values, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderBetween(Integer value1, Integer value2) {
			addCriterion("SALE_LADDER between", value1, value2, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleLadderNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_LADDER not between", value1, value2, "saleLadder");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsIsNull() {
			addCriterion("SALE_DOORS is null");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsIsNotNull() {
			addCriterion("SALE_DOORS is not null");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsEqualTo(Integer value) {
			addCriterion("SALE_DOORS =", value, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsNotEqualTo(Integer value) {
			addCriterion("SALE_DOORS <>", value, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsGreaterThan(Integer value) {
			addCriterion("SALE_DOORS >", value, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_DOORS >=", value, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsLessThan(Integer value) {
			addCriterion("SALE_DOORS <", value, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_DOORS <=", value, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsIn(List<Integer> values) {
			addCriterion("SALE_DOORS in", values, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsNotIn(List<Integer> values) {
			addCriterion("SALE_DOORS not in", values, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsBetween(Integer value1, Integer value2) {
			addCriterion("SALE_DOORS between", value1, value2, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleDoorsNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_DOORS not between", value1, value2, "saleDoors");
			return (Criteria) this;
		}

		public Criteria andSaleRoomIsNull() {
			addCriterion("SALE_ROOM is null");
			return (Criteria) this;
		}

		public Criteria andSaleRoomIsNotNull() {
			addCriterion("SALE_ROOM is not null");
			return (Criteria) this;
		}

		public Criteria andSaleRoomEqualTo(Byte value) {
			addCriterion("SALE_ROOM =", value, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomNotEqualTo(Byte value) {
			addCriterion("SALE_ROOM <>", value, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomGreaterThan(Byte value) {
			addCriterion("SALE_ROOM >", value, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_ROOM >=", value, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomLessThan(Byte value) {
			addCriterion("SALE_ROOM <", value, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_ROOM <=", value, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomIn(List<Byte> values) {
			addCriterion("SALE_ROOM in", values, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomNotIn(List<Byte> values) {
			addCriterion("SALE_ROOM not in", values, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomBetween(Byte value1, Byte value2) {
			addCriterion("SALE_ROOM between", value1, value2, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleRoomNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_ROOM not between", value1, value2, "saleRoom");
			return (Criteria) this;
		}

		public Criteria andSaleHallIsNull() {
			addCriterion("SALE_HALL is null");
			return (Criteria) this;
		}

		public Criteria andSaleHallIsNotNull() {
			addCriterion("SALE_HALL is not null");
			return (Criteria) this;
		}

		public Criteria andSaleHallEqualTo(Byte value) {
			addCriterion("SALE_HALL =", value, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallNotEqualTo(Byte value) {
			addCriterion("SALE_HALL <>", value, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallGreaterThan(Byte value) {
			addCriterion("SALE_HALL >", value, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_HALL >=", value, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallLessThan(Byte value) {
			addCriterion("SALE_HALL <", value, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_HALL <=", value, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallIn(List<Byte> values) {
			addCriterion("SALE_HALL in", values, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallNotIn(List<Byte> values) {
			addCriterion("SALE_HALL not in", values, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallBetween(Byte value1, Byte value2) {
			addCriterion("SALE_HALL between", value1, value2, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleHallNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_HALL not between", value1, value2, "saleHall");
			return (Criteria) this;
		}

		public Criteria andSaleWeiIsNull() {
			addCriterion("SALE_WEI is null");
			return (Criteria) this;
		}

		public Criteria andSaleWeiIsNotNull() {
			addCriterion("SALE_WEI is not null");
			return (Criteria) this;
		}

		public Criteria andSaleWeiEqualTo(Byte value) {
			addCriterion("SALE_WEI =", value, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiNotEqualTo(Byte value) {
			addCriterion("SALE_WEI <>", value, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiGreaterThan(Byte value) {
			addCriterion("SALE_WEI >", value, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_WEI >=", value, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiLessThan(Byte value) {
			addCriterion("SALE_WEI <", value, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_WEI <=", value, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiIn(List<Byte> values) {
			addCriterion("SALE_WEI in", values, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiNotIn(List<Byte> values) {
			addCriterion("SALE_WEI not in", values, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiBetween(Byte value1, Byte value2) {
			addCriterion("SALE_WEI between", value1, value2, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleWeiNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_WEI not between", value1, value2, "saleWei");
			return (Criteria) this;
		}

		public Criteria andSaleYangIsNull() {
			addCriterion("SALE_YANG is null");
			return (Criteria) this;
		}

		public Criteria andSaleYangIsNotNull() {
			addCriterion("SALE_YANG is not null");
			return (Criteria) this;
		}

		public Criteria andSaleYangEqualTo(Byte value) {
			addCriterion("SALE_YANG =", value, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangNotEqualTo(Byte value) {
			addCriterion("SALE_YANG <>", value, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangGreaterThan(Byte value) {
			addCriterion("SALE_YANG >", value, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_YANG >=", value, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangLessThan(Byte value) {
			addCriterion("SALE_YANG <", value, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_YANG <=", value, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangIn(List<Byte> values) {
			addCriterion("SALE_YANG in", values, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangNotIn(List<Byte> values) {
			addCriterion("SALE_YANG not in", values, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangBetween(Byte value1, Byte value2) {
			addCriterion("SALE_YANG between", value1, value2, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleYangNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_YANG not between", value1, value2, "saleYang");
			return (Criteria) this;
		}

		public Criteria andSaleTypeIsNull() {
			addCriterion("SALE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSaleTypeIsNotNull() {
			addCriterion("SALE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleTypeEqualTo(Byte value) {
			addCriterion("SALE_TYPE =", value, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeNotEqualTo(Byte value) {
			addCriterion("SALE_TYPE <>", value, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeGreaterThan(Byte value) {
			addCriterion("SALE_TYPE >", value, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_TYPE >=", value, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeLessThan(Byte value) {
			addCriterion("SALE_TYPE <", value, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_TYPE <=", value, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeIn(List<Byte> values) {
			addCriterion("SALE_TYPE in", values, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeNotIn(List<Byte> values) {
			addCriterion("SALE_TYPE not in", values, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeBetween(Byte value1, Byte value2) {
			addCriterion("SALE_TYPE between", value1, value2, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_TYPE not between", value1, value2, "saleType");
			return (Criteria) this;
		}

		public Criteria andSaleFloorIsNull() {
			addCriterion("SALE_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andSaleFloorIsNotNull() {
			addCriterion("SALE_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andSaleFloorEqualTo(Short value) {
			addCriterion("SALE_FLOOR =", value, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorNotEqualTo(Short value) {
			addCriterion("SALE_FLOOR <>", value, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorGreaterThan(Short value) {
			addCriterion("SALE_FLOOR >", value, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorGreaterThanOrEqualTo(Short value) {
			addCriterion("SALE_FLOOR >=", value, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorLessThan(Short value) {
			addCriterion("SALE_FLOOR <", value, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorLessThanOrEqualTo(Short value) {
			addCriterion("SALE_FLOOR <=", value, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorIn(List<Short> values) {
			addCriterion("SALE_FLOOR in", values, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorNotIn(List<Short> values) {
			addCriterion("SALE_FLOOR not in", values, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorBetween(Short value1, Short value2) {
			addCriterion("SALE_FLOOR between", value1, value2, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorNotBetween(Short value1, Short value2) {
			addCriterion("SALE_FLOOR not between", value1, value2, "saleFloor");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsIsNull() {
			addCriterion("SALE_FLOORS is null");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsIsNotNull() {
			addCriterion("SALE_FLOORS is not null");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsEqualTo(Integer value) {
			addCriterion("SALE_FLOORS =", value, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsNotEqualTo(Integer value) {
			addCriterion("SALE_FLOORS <>", value, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsGreaterThan(Integer value) {
			addCriterion("SALE_FLOORS >", value, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_FLOORS >=", value, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsLessThan(Integer value) {
			addCriterion("SALE_FLOORS <", value, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_FLOORS <=", value, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsIn(List<Integer> values) {
			addCriterion("SALE_FLOORS in", values, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsNotIn(List<Integer> values) {
			addCriterion("SALE_FLOORS not in", values, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsBetween(Integer value1, Integer value2) {
			addCriterion("SALE_FLOORS between", value1, value2, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFloorsNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_FLOORS not between", value1, value2, "saleFloors");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentIsNull() {
			addCriterion("SALE_FITMENT is null");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentIsNotNull() {
			addCriterion("SALE_FITMENT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentEqualTo(Byte value) {
			addCriterion("SALE_FITMENT =", value, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentNotEqualTo(Byte value) {
			addCriterion("SALE_FITMENT <>", value, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentGreaterThan(Byte value) {
			addCriterion("SALE_FITMENT >", value, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_FITMENT >=", value, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentLessThan(Byte value) {
			addCriterion("SALE_FITMENT <", value, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_FITMENT <=", value, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentIn(List<Byte> values) {
			addCriterion("SALE_FITMENT in", values, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentNotIn(List<Byte> values) {
			addCriterion("SALE_FITMENT not in", values, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentBetween(Byte value1, Byte value2) {
			addCriterion("SALE_FITMENT between", value1, value2, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleFitmentNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_FITMENT not between", value1, value2, "saleFitment");
			return (Criteria) this;
		}

		public Criteria andSaleDirectIsNull() {
			addCriterion("SALE_DIRECT is null");
			return (Criteria) this;
		}

		public Criteria andSaleDirectIsNotNull() {
			addCriterion("SALE_DIRECT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleDirectEqualTo(Byte value) {
			addCriterion("SALE_DIRECT =", value, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectNotEqualTo(Byte value) {
			addCriterion("SALE_DIRECT <>", value, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectGreaterThan(Byte value) {
			addCriterion("SALE_DIRECT >", value, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_DIRECT >=", value, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectLessThan(Byte value) {
			addCriterion("SALE_DIRECT <", value, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_DIRECT <=", value, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectIn(List<Byte> values) {
			addCriterion("SALE_DIRECT in", values, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectNotIn(List<Byte> values) {
			addCriterion("SALE_DIRECT not in", values, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectBetween(Byte value1, Byte value2) {
			addCriterion("SALE_DIRECT between", value1, value2, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleDirectNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_DIRECT not between", value1, value2, "saleDirect");
			return (Criteria) this;
		}

		public Criteria andSaleYearIsNull() {
			addCriterion("SALE_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andSaleYearIsNotNull() {
			addCriterion("SALE_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andSaleYearEqualTo(Short value) {
			addCriterion("SALE_YEAR =", value, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearNotEqualTo(Short value) {
			addCriterion("SALE_YEAR <>", value, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearGreaterThan(Short value) {
			addCriterion("SALE_YEAR >", value, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearGreaterThanOrEqualTo(Short value) {
			addCriterion("SALE_YEAR >=", value, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearLessThan(Short value) {
			addCriterion("SALE_YEAR <", value, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearLessThanOrEqualTo(Short value) {
			addCriterion("SALE_YEAR <=", value, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearIn(List<Short> values) {
			addCriterion("SALE_YEAR in", values, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearNotIn(List<Short> values) {
			addCriterion("SALE_YEAR not in", values, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearBetween(Short value1, Short value2) {
			addCriterion("SALE_YEAR between", value1, value2, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleYearNotBetween(Short value1, Short value2) {
			addCriterion("SALE_YEAR not between", value1, value2, "saleYear");
			return (Criteria) this;
		}

		public Criteria andSaleStructIsNull() {
			addCriterion("SALE_STRUCT is null");
			return (Criteria) this;
		}

		public Criteria andSaleStructIsNotNull() {
			addCriterion("SALE_STRUCT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleStructEqualTo(Byte value) {
			addCriterion("SALE_STRUCT =", value, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructNotEqualTo(Byte value) {
			addCriterion("SALE_STRUCT <>", value, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructGreaterThan(Byte value) {
			addCriterion("SALE_STRUCT >", value, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_STRUCT >=", value, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructLessThan(Byte value) {
			addCriterion("SALE_STRUCT <", value, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_STRUCT <=", value, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructIn(List<Byte> values) {
			addCriterion("SALE_STRUCT in", values, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructNotIn(List<Byte> values) {
			addCriterion("SALE_STRUCT not in", values, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructBetween(Byte value1, Byte value2) {
			addCriterion("SALE_STRUCT between", value1, value2, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleStructNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_STRUCT not between", value1, value2, "saleStruct");
			return (Criteria) this;
		}

		public Criteria andSaleUseageIsNull() {
			addCriterion("SALE_USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andSaleUseageIsNotNull() {
			addCriterion("SALE_USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleUseageEqualTo(Byte value) {
			addCriterion("SALE_USEAGE =", value, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageNotEqualTo(Byte value) {
			addCriterion("SALE_USEAGE <>", value, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageGreaterThan(Byte value) {
			addCriterion("SALE_USEAGE >", value, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_USEAGE >=", value, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageLessThan(Byte value) {
			addCriterion("SALE_USEAGE <", value, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_USEAGE <=", value, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageIn(List<Byte> values) {
			addCriterion("SALE_USEAGE in", values, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageNotIn(List<Byte> values) {
			addCriterion("SALE_USEAGE not in", values, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageBetween(Byte value1, Byte value2) {
			addCriterion("SALE_USEAGE between", value1, value2, "saleUseage");
			return (Criteria) this;
		}

		public Criteria andSaleUseageNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_USEAGE not between", value1, value2, "saleUseage");
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

		public Criteria andSaleStreetIsNull() {
			addCriterion("SALE_STREET is null");
			return (Criteria) this;
		}

		public Criteria andSaleStreetIsNotNull() {
			addCriterion("SALE_STREET is not null");
			return (Criteria) this;
		}

		public Criteria andSaleStreetEqualTo(Boolean value) {
			addCriterion("SALE_STREET =", value, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetNotEqualTo(Boolean value) {
			addCriterion("SALE_STREET <>", value, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetGreaterThan(Boolean value) {
			addCriterion("SALE_STREET >", value, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SALE_STREET >=", value, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetLessThan(Boolean value) {
			addCriterion("SALE_STREET <", value, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetLessThanOrEqualTo(Boolean value) {
			addCriterion("SALE_STREET <=", value, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetIn(List<Boolean> values) {
			addCriterion("SALE_STREET in", values, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetNotIn(List<Boolean> values) {
			addCriterion("SALE_STREET not in", values, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_STREET between", value1, value2, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleStreetNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_STREET not between", value1, value2, "saleStreet");
			return (Criteria) this;
		}

		public Criteria andSaleRightIsNull() {
			addCriterion("SALE_RIGHT is null");
			return (Criteria) this;
		}

		public Criteria andSaleRightIsNotNull() {
			addCriterion("SALE_RIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleRightEqualTo(Byte value) {
			addCriterion("SALE_RIGHT =", value, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightNotEqualTo(Byte value) {
			addCriterion("SALE_RIGHT <>", value, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightGreaterThan(Byte value) {
			addCriterion("SALE_RIGHT >", value, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_RIGHT >=", value, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightLessThan(Byte value) {
			addCriterion("SALE_RIGHT <", value, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_RIGHT <=", value, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightIn(List<Byte> values) {
			addCriterion("SALE_RIGHT in", values, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightNotIn(List<Byte> values) {
			addCriterion("SALE_RIGHT not in", values, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightBetween(Byte value1, Byte value2) {
			addCriterion("SALE_RIGHT between", value1, value2, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleRightNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_RIGHT not between", value1, value2, "saleRight");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageIsNull() {
			addCriterion("SALE_MORTGAGE is null");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageIsNotNull() {
			addCriterion("SALE_MORTGAGE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageEqualTo(String value) {
			addCriterion("SALE_MORTGAGE =", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageNotEqualTo(String value) {
			addCriterion("SALE_MORTGAGE <>", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageGreaterThan(String value) {
			addCriterion("SALE_MORTGAGE >", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_MORTGAGE >=", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageLessThan(String value) {
			addCriterion("SALE_MORTGAGE <", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageLessThanOrEqualTo(String value) {
			addCriterion("SALE_MORTGAGE <=", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageLike(String value) {
			addCriterion("SALE_MORTGAGE like", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageNotLike(String value) {
			addCriterion("SALE_MORTGAGE not like", value, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageIn(List<String> values) {
			addCriterion("SALE_MORTGAGE in", values, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageNotIn(List<String> values) {
			addCriterion("SALE_MORTGAGE not in", values, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageBetween(String value1, String value2) {
			addCriterion("SALE_MORTGAGE between", value1, value2, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleMortgageNotBetween(String value1, String value2) {
			addCriterion("SALE_MORTGAGE not between", value1, value2, "saleMortgage");
			return (Criteria) this;
		}

		public Criteria andSaleAccountIsNull() {
			addCriterion("SALE_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andSaleAccountIsNotNull() {
			addCriterion("SALE_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleAccountEqualTo(String value) {
			addCriterion("SALE_ACCOUNT =", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountNotEqualTo(String value) {
			addCriterion("SALE_ACCOUNT <>", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountGreaterThan(String value) {
			addCriterion("SALE_ACCOUNT >", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_ACCOUNT >=", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountLessThan(String value) {
			addCriterion("SALE_ACCOUNT <", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountLessThanOrEqualTo(String value) {
			addCriterion("SALE_ACCOUNT <=", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountLike(String value) {
			addCriterion("SALE_ACCOUNT like", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountNotLike(String value) {
			addCriterion("SALE_ACCOUNT not like", value, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountIn(List<String> values) {
			addCriterion("SALE_ACCOUNT in", values, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountNotIn(List<String> values) {
			addCriterion("SALE_ACCOUNT not in", values, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountBetween(String value1, String value2) {
			addCriterion("SALE_ACCOUNT between", value1, value2, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAccountNotBetween(String value1, String value2) {
			addCriterion("SALE_ACCOUNT not between", value1, value2, "saleAccount");
			return (Criteria) this;
		}

		public Criteria andSaleAreaIsNull() {
			addCriterion("SALE_AREA is null");
			return (Criteria) this;
		}

		public Criteria andSaleAreaIsNotNull() {
			addCriterion("SALE_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andSaleAreaEqualTo(BigDecimal value) {
			addCriterion("SALE_AREA =", value, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaNotEqualTo(BigDecimal value) {
			addCriterion("SALE_AREA <>", value, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaGreaterThan(BigDecimal value) {
			addCriterion("SALE_AREA >", value, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_AREA >=", value, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaLessThan(BigDecimal value) {
			addCriterion("SALE_AREA <", value, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_AREA <=", value, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaIn(List<BigDecimal> values) {
			addCriterion("SALE_AREA in", values, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaNotIn(List<BigDecimal> values) {
			addCriterion("SALE_AREA not in", values, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_AREA between", value1, value2, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_AREA not between", value1, value2, "saleArea");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceIsNull() {
			addCriterion("SALE_TOTAL_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceIsNotNull() {
			addCriterion("SALE_TOTAL_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceEqualTo(BigDecimal value) {
			addCriterion("SALE_TOTAL_PRICE =", value, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceNotEqualTo(BigDecimal value) {
			addCriterion("SALE_TOTAL_PRICE <>", value, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceGreaterThan(BigDecimal value) {
			addCriterion("SALE_TOTAL_PRICE >", value, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_TOTAL_PRICE >=", value, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceLessThan(BigDecimal value) {
			addCriterion("SALE_TOTAL_PRICE <", value, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_TOTAL_PRICE <=", value, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceIn(List<BigDecimal> values) {
			addCriterion("SALE_TOTAL_PRICE in", values, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceNotIn(List<BigDecimal> values) {
			addCriterion("SALE_TOTAL_PRICE not in", values, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_TOTAL_PRICE between", value1, value2, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_TOTAL_PRICE not between", value1, value2, "saleTotalPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceIsNull() {
			addCriterion("SALE_UNIT_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceIsNotNull() {
			addCriterion("SALE_UNIT_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceEqualTo(BigDecimal value) {
			addCriterion("SALE_UNIT_PRICE =", value, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceNotEqualTo(BigDecimal value) {
			addCriterion("SALE_UNIT_PRICE <>", value, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceGreaterThan(BigDecimal value) {
			addCriterion("SALE_UNIT_PRICE >", value, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_UNIT_PRICE >=", value, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceLessThan(BigDecimal value) {
			addCriterion("SALE_UNIT_PRICE <", value, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_UNIT_PRICE <=", value, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceIn(List<BigDecimal> values) {
			addCriterion("SALE_UNIT_PRICE in", values, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceNotIn(List<BigDecimal> values) {
			addCriterion("SALE_UNIT_PRICE not in", values, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_UNIT_PRICE between", value1, value2, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_UNIT_PRICE not between", value1, value2, "saleUnitPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceIsNull() {
			addCriterion("SALE_LOWEST_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceIsNotNull() {
			addCriterion("SALE_LOWEST_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceEqualTo(BigDecimal value) {
			addCriterion("SALE_LOWEST_PRICE =", value, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceNotEqualTo(BigDecimal value) {
			addCriterion("SALE_LOWEST_PRICE <>", value, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceGreaterThan(BigDecimal value) {
			addCriterion("SALE_LOWEST_PRICE >", value, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_LOWEST_PRICE >=", value, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceLessThan(BigDecimal value) {
			addCriterion("SALE_LOWEST_PRICE <", value, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_LOWEST_PRICE <=", value, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceIn(List<BigDecimal> values) {
			addCriterion("SALE_LOWEST_PRICE in", values, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceNotIn(List<BigDecimal> values) {
			addCriterion("SALE_LOWEST_PRICE not in", values, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_LOWEST_PRICE between", value1, value2, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSaleLowestPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_LOWEST_PRICE not between", value1, value2, "saleLowestPrice");
			return (Criteria) this;
		}

		public Criteria andSalePropertyIsNull() {
			addCriterion("SALE_PROPERTY is null");
			return (Criteria) this;
		}

		public Criteria andSalePropertyIsNotNull() {
			addCriterion("SALE_PROPERTY is not null");
			return (Criteria) this;
		}

		public Criteria andSalePropertyEqualTo(BigDecimal value) {
			addCriterion("SALE_PROPERTY =", value, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyNotEqualTo(BigDecimal value) {
			addCriterion("SALE_PROPERTY <>", value, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyGreaterThan(BigDecimal value) {
			addCriterion("SALE_PROPERTY >", value, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_PROPERTY >=", value, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyLessThan(BigDecimal value) {
			addCriterion("SALE_PROPERTY <", value, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_PROPERTY <=", value, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyIn(List<BigDecimal> values) {
			addCriterion("SALE_PROPERTY in", values, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyNotIn(List<BigDecimal> values) {
			addCriterion("SALE_PROPERTY not in", values, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_PROPERTY between", value1, value2, "saleProperty");
			return (Criteria) this;
		}

		public Criteria andSalePropertyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_PROPERTY not between", value1, value2, "saleProperty");
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

		public Criteria andSaleLeaveTimeIsNull() {
			addCriterion("SALE_LEAVE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeIsNotNull() {
			addCriterion("SALE_LEAVE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeEqualTo(String value) {
			addCriterion("SALE_LEAVE_TIME =", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeNotEqualTo(String value) {
			addCriterion("SALE_LEAVE_TIME <>", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeGreaterThan(String value) {
			addCriterion("SALE_LEAVE_TIME >", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_LEAVE_TIME >=", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeLessThan(String value) {
			addCriterion("SALE_LEAVE_TIME <", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeLessThanOrEqualTo(String value) {
			addCriterion("SALE_LEAVE_TIME <=", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeLike(String value) {
			addCriterion("SALE_LEAVE_TIME like", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeNotLike(String value) {
			addCriterion("SALE_LEAVE_TIME not like", value, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeIn(List<String> values) {
			addCriterion("SALE_LEAVE_TIME in", values, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeNotIn(List<String> values) {
			addCriterion("SALE_LEAVE_TIME not in", values, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeBetween(String value1, String value2) {
			addCriterion("SALE_LEAVE_TIME between", value1, value2, "saleLeaveTime");
			return (Criteria) this;
		}

		public Criteria andSaleLeaveTimeNotBetween(String value1, String value2) {
			addCriterion("SALE_LEAVE_TIME not between", value1, value2, "saleLeaveTime");
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

		public Criteria andUgTypeEqualTo(Byte value) {
			addCriterion("UG_TYPE =", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeNotEqualTo(Byte value) {
			addCriterion("UG_TYPE <>", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeGreaterThan(Byte value) {
			addCriterion("UG_TYPE >", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("UG_TYPE >=", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeLessThan(Byte value) {
			addCriterion("UG_TYPE <", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeLessThanOrEqualTo(Byte value) {
			addCriterion("UG_TYPE <=", value, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeIn(List<Byte> values) {
			addCriterion("UG_TYPE in", values, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeNotIn(List<Byte> values) {
			addCriterion("UG_TYPE not in", values, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeBetween(Byte value1, Byte value2) {
			addCriterion("UG_TYPE between", value1, value2, "ugType");
			return (Criteria) this;
		}

		public Criteria andUgTypeNotBetween(Byte value1, Byte value2) {
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

		public Criteria andGarageAmountEqualTo(Byte value) {
			addCriterion("GARAGE_AMOUNT =", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountNotEqualTo(Byte value) {
			addCriterion("GARAGE_AMOUNT <>", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountGreaterThan(Byte value) {
			addCriterion("GARAGE_AMOUNT >", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountGreaterThanOrEqualTo(Byte value) {
			addCriterion("GARAGE_AMOUNT >=", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountLessThan(Byte value) {
			addCriterion("GARAGE_AMOUNT <", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountLessThanOrEqualTo(Byte value) {
			addCriterion("GARAGE_AMOUNT <=", value, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountIn(List<Byte> values) {
			addCriterion("GARAGE_AMOUNT in", values, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountNotIn(List<Byte> values) {
			addCriterion("GARAGE_AMOUNT not in", values, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountBetween(Byte value1, Byte value2) {
			addCriterion("GARAGE_AMOUNT between", value1, value2, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andGarageAmountNotBetween(Byte value1, Byte value2) {
			addCriterion("GARAGE_AMOUNT not between", value1, value2, "garageAmount");
			return (Criteria) this;
		}

		public Criteria andSaleCharactIsNull() {
			addCriterion("SALE_CHARACT is null");
			return (Criteria) this;
		}

		public Criteria andSaleCharactIsNotNull() {
			addCriterion("SALE_CHARACT is not null");
			return (Criteria) this;
		}

		public Criteria andSaleCharactEqualTo(String value) {
			addCriterion("SALE_CHARACT =", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactNotEqualTo(String value) {
			addCriterion("SALE_CHARACT <>", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactGreaterThan(String value) {
			addCriterion("SALE_CHARACT >", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_CHARACT >=", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactLessThan(String value) {
			addCriterion("SALE_CHARACT <", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactLessThanOrEqualTo(String value) {
			addCriterion("SALE_CHARACT <=", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactLike(String value) {
			addCriterion("SALE_CHARACT like", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactNotLike(String value) {
			addCriterion("SALE_CHARACT not like", value, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactIn(List<String> values) {
			addCriterion("SALE_CHARACT in", values, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactNotIn(List<String> values) {
			addCriterion("SALE_CHARACT not in", values, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactBetween(String value1, String value2) {
			addCriterion("SALE_CHARACT between", value1, value2, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleCharactNotBetween(String value1, String value2) {
			addCriterion("SALE_CHARACT not between", value1, value2, "saleCharact");
			return (Criteria) this;
		}

		public Criteria andSaleMemoIsNull() {
			addCriterion("SALE_MEMO is null");
			return (Criteria) this;
		}

		public Criteria andSaleMemoIsNotNull() {
			addCriterion("SALE_MEMO is not null");
			return (Criteria) this;
		}

		public Criteria andSaleMemoEqualTo(String value) {
			addCriterion("SALE_MEMO =", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoNotEqualTo(String value) {
			addCriterion("SALE_MEMO <>", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoGreaterThan(String value) {
			addCriterion("SALE_MEMO >", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_MEMO >=", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoLessThan(String value) {
			addCriterion("SALE_MEMO <", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoLessThanOrEqualTo(String value) {
			addCriterion("SALE_MEMO <=", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoLike(String value) {
			addCriterion("SALE_MEMO like", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoNotLike(String value) {
			addCriterion("SALE_MEMO not like", value, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoIn(List<String> values) {
			addCriterion("SALE_MEMO in", values, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoNotIn(List<String> values) {
			addCriterion("SALE_MEMO not in", values, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoBetween(String value1, String value2) {
			addCriterion("SALE_MEMO between", value1, value2, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleMemoNotBetween(String value1, String value2) {
			addCriterion("SALE_MEMO not between", value1, value2, "saleMemo");
			return (Criteria) this;
		}

		public Criteria andSaleSourceIsNull() {
			addCriterion("SALE_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andSaleSourceIsNotNull() {
			addCriterion("SALE_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleSourceEqualTo(Byte value) {
			addCriterion("SALE_SOURCE =", value, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceNotEqualTo(Byte value) {
			addCriterion("SALE_SOURCE <>", value, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceGreaterThan(Byte value) {
			addCriterion("SALE_SOURCE >", value, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_SOURCE >=", value, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceLessThan(Byte value) {
			addCriterion("SALE_SOURCE <", value, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_SOURCE <=", value, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceIn(List<Byte> values) {
			addCriterion("SALE_SOURCE in", values, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceNotIn(List<Byte> values) {
			addCriterion("SALE_SOURCE not in", values, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceBetween(Byte value1, Byte value2) {
			addCriterion("SALE_SOURCE between", value1, value2, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_SOURCE not between", value1, value2, "saleSource");
			return (Criteria) this;
		}

		public Criteria andSaleKeyIsNull() {
			addCriterion("SALE_KEY is null");
			return (Criteria) this;
		}

		public Criteria andSaleKeyIsNotNull() {
			addCriterion("SALE_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andSaleKeyEqualTo(Boolean value) {
			addCriterion("SALE_KEY =", value, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNotEqualTo(Boolean value) {
			addCriterion("SALE_KEY <>", value, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyGreaterThan(Boolean value) {
			addCriterion("SALE_KEY >", value, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SALE_KEY >=", value, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyLessThan(Boolean value) {
			addCriterion("SALE_KEY <", value, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyLessThanOrEqualTo(Boolean value) {
			addCriterion("SALE_KEY <=", value, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyIn(List<Boolean> values) {
			addCriterion("SALE_KEY in", values, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNotIn(List<Boolean> values) {
			addCriterion("SALE_KEY not in", values, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_KEY between", value1, value2, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_KEY not between", value1, value2, "saleKey");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumIsNull() {
			addCriterion("SALE_KEY_NUM is null");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumIsNotNull() {
			addCriterion("SALE_KEY_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumEqualTo(String value) {
			addCriterion("SALE_KEY_NUM =", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumNotEqualTo(String value) {
			addCriterion("SALE_KEY_NUM <>", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumGreaterThan(String value) {
			addCriterion("SALE_KEY_NUM >", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_KEY_NUM >=", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumLessThan(String value) {
			addCriterion("SALE_KEY_NUM <", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumLessThanOrEqualTo(String value) {
			addCriterion("SALE_KEY_NUM <=", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumLike(String value) {
			addCriterion("SALE_KEY_NUM like", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumNotLike(String value) {
			addCriterion("SALE_KEY_NUM not like", value, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumIn(List<String> values) {
			addCriterion("SALE_KEY_NUM in", values, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumNotIn(List<String> values) {
			addCriterion("SALE_KEY_NUM not in", values, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumBetween(String value1, String value2) {
			addCriterion("SALE_KEY_NUM between", value1, value2, "saleKeyNum");
			return (Criteria) this;
		}

		public Criteria andSaleKeyNumNotBetween(String value1, String value2) {
			addCriterion("SALE_KEY_NUM not between", value1, value2, "saleKeyNum");
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

		public Criteria andSaleExplrthIsNull() {
			addCriterion("SALE_EXPLRTH is null");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthIsNotNull() {
			addCriterion("SALE_EXPLRTH is not null");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthEqualTo(Boolean value) {
			addCriterion("SALE_EXPLRTH =", value, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthNotEqualTo(Boolean value) {
			addCriterion("SALE_EXPLRTH <>", value, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthGreaterThan(Boolean value) {
			addCriterion("SALE_EXPLRTH >", value, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SALE_EXPLRTH >=", value, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthLessThan(Boolean value) {
			addCriterion("SALE_EXPLRTH <", value, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthLessThanOrEqualTo(Boolean value) {
			addCriterion("SALE_EXPLRTH <=", value, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthIn(List<Boolean> values) {
			addCriterion("SALE_EXPLRTH in", values, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthNotIn(List<Boolean> values) {
			addCriterion("SALE_EXPLRTH not in", values, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_EXPLRTH between", value1, value2, "saleExplrth");
			return (Criteria) this;
		}

		public Criteria andSaleExplrthNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_EXPLRTH not between", value1, value2, "saleExplrth");
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

		public Criteria andSaleConsignIsNull() {
			addCriterion("SALE_CONSIGN is null");
			return (Criteria) this;
		}

		public Criteria andSaleConsignIsNotNull() {
			addCriterion("SALE_CONSIGN is not null");
			return (Criteria) this;
		}

		public Criteria andSaleConsignEqualTo(Byte value) {
			addCriterion("SALE_CONSIGN =", value, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNotEqualTo(Byte value) {
			addCriterion("SALE_CONSIGN <>", value, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignGreaterThan(Byte value) {
			addCriterion("SALE_CONSIGN >", value, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_CONSIGN >=", value, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignLessThan(Byte value) {
			addCriterion("SALE_CONSIGN <", value, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_CONSIGN <=", value, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignIn(List<Byte> values) {
			addCriterion("SALE_CONSIGN in", values, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNotIn(List<Byte> values) {
			addCriterion("SALE_CONSIGN not in", values, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignBetween(Byte value1, Byte value2) {
			addCriterion("SALE_CONSIGN between", value1, value2, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_CONSIGN not between", value1, value2, "saleConsign");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoIsNull() {
			addCriterion("SALE_CONSIGN_NO is null");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoIsNotNull() {
			addCriterion("SALE_CONSIGN_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoEqualTo(String value) {
			addCriterion("SALE_CONSIGN_NO =", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoNotEqualTo(String value) {
			addCriterion("SALE_CONSIGN_NO <>", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoGreaterThan(String value) {
			addCriterion("SALE_CONSIGN_NO >", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_CONSIGN_NO >=", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoLessThan(String value) {
			addCriterion("SALE_CONSIGN_NO <", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoLessThanOrEqualTo(String value) {
			addCriterion("SALE_CONSIGN_NO <=", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoLike(String value) {
			addCriterion("SALE_CONSIGN_NO like", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoNotLike(String value) {
			addCriterion("SALE_CONSIGN_NO not like", value, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoIn(List<String> values) {
			addCriterion("SALE_CONSIGN_NO in", values, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoNotIn(List<String> values) {
			addCriterion("SALE_CONSIGN_NO not in", values, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoBetween(String value1, String value2) {
			addCriterion("SALE_CONSIGN_NO between", value1, value2, "saleConsignNo");
			return (Criteria) this;
		}

		public Criteria andSaleConsignNoNotBetween(String value1, String value2) {
			addCriterion("SALE_CONSIGN_NO not between", value1, value2, "saleConsignNo");
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

		public Criteria andSaleCooperateIsNull() {
			addCriterion("SALE_COOPERATE is null");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateIsNotNull() {
			addCriterion("SALE_COOPERATE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateEqualTo(Boolean value) {
			addCriterion("SALE_COOPERATE =", value, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateNotEqualTo(Boolean value) {
			addCriterion("SALE_COOPERATE <>", value, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateGreaterThan(Boolean value) {
			addCriterion("SALE_COOPERATE >", value, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SALE_COOPERATE >=", value, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateLessThan(Boolean value) {
			addCriterion("SALE_COOPERATE <", value, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateLessThanOrEqualTo(Boolean value) {
			addCriterion("SALE_COOPERATE <=", value, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateIn(List<Boolean> values) {
			addCriterion("SALE_COOPERATE in", values, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateNotIn(List<Boolean> values) {
			addCriterion("SALE_COOPERATE not in", values, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_COOPERATE between", value1, value2, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSaleCooperateNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_COOPERATE not between", value1, value2, "saleCooperate");
			return (Criteria) this;
		}

		public Criteria andSalePublishIsNull() {
			addCriterion("SALE_PUBLISH is null");
			return (Criteria) this;
		}

		public Criteria andSalePublishIsNotNull() {
			addCriterion("SALE_PUBLISH is not null");
			return (Criteria) this;
		}

		public Criteria andSalePublishEqualTo(Boolean value) {
			addCriterion("SALE_PUBLISH =", value, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishNotEqualTo(Boolean value) {
			addCriterion("SALE_PUBLISH <>", value, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishGreaterThan(Boolean value) {
			addCriterion("SALE_PUBLISH >", value, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SALE_PUBLISH >=", value, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishLessThan(Boolean value) {
			addCriterion("SALE_PUBLISH <", value, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishLessThanOrEqualTo(Boolean value) {
			addCriterion("SALE_PUBLISH <=", value, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishIn(List<Boolean> values) {
			addCriterion("SALE_PUBLISH in", values, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishNotIn(List<Boolean> values) {
			addCriterion("SALE_PUBLISH not in", values, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_PUBLISH between", value1, value2, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSalePublishNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SALE_PUBLISH not between", value1, value2, "salePublish");
			return (Criteria) this;
		}

		public Criteria andSaleMapIsNull() {
			addCriterion("SALE_MAP is null");
			return (Criteria) this;
		}

		public Criteria andSaleMapIsNotNull() {
			addCriterion("SALE_MAP is not null");
			return (Criteria) this;
		}

		public Criteria andSaleMapEqualTo(Byte value) {
			addCriterion("SALE_MAP =", value, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapNotEqualTo(Byte value) {
			addCriterion("SALE_MAP <>", value, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapGreaterThan(Byte value) {
			addCriterion("SALE_MAP >", value, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_MAP >=", value, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapLessThan(Byte value) {
			addCriterion("SALE_MAP <", value, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_MAP <=", value, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapIn(List<Byte> values) {
			addCriterion("SALE_MAP in", values, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapNotIn(List<Byte> values) {
			addCriterion("SALE_MAP not in", values, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapBetween(Byte value1, Byte value2) {
			addCriterion("SALE_MAP between", value1, value2, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleMapNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_MAP not between", value1, value2, "saleMap");
			return (Criteria) this;
		}

		public Criteria andSaleLevelIsNull() {
			addCriterion("SALE_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andSaleLevelIsNotNull() {
			addCriterion("SALE_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andSaleLevelEqualTo(Byte value) {
			addCriterion("SALE_LEVEL =", value, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelNotEqualTo(Byte value) {
			addCriterion("SALE_LEVEL <>", value, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelGreaterThan(Byte value) {
			addCriterion("SALE_LEVEL >", value, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_LEVEL >=", value, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelLessThan(Byte value) {
			addCriterion("SALE_LEVEL <", value, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_LEVEL <=", value, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelIn(List<Byte> values) {
			addCriterion("SALE_LEVEL in", values, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelNotIn(List<Byte> values) {
			addCriterion("SALE_LEVEL not in", values, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelBetween(Byte value1, Byte value2) {
			addCriterion("SALE_LEVEL between", value1, value2, "saleLevel");
			return (Criteria) this;
		}

		public Criteria andSaleLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_LEVEL not between", value1, value2, "saleLevel");
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

		public Criteria andSaleStatusIsNull() {
			addCriterion("SALE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andSaleStatusIsNotNull() {
			addCriterion("SALE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andSaleStatusEqualTo(Byte value) {
			addCriterion("SALE_STATUS =", value, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusNotEqualTo(Byte value) {
			addCriterion("SALE_STATUS <>", value, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusGreaterThan(Byte value) {
			addCriterion("SALE_STATUS >", value, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_STATUS >=", value, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusLessThan(Byte value) {
			addCriterion("SALE_STATUS <", value, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_STATUS <=", value, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusIn(List<Byte> values) {
			addCriterion("SALE_STATUS in", values, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusNotIn(List<Byte> values) {
			addCriterion("SALE_STATUS not in", values, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusBetween(Byte value1, Byte value2) {
			addCriterion("SALE_STATUS between", value1, value2, "saleStatus");
			return (Criteria) this;
		}

		public Criteria andSaleStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_STATUS not between", value1, value2, "saleStatus");
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

		public Criteria andSaleCertTimeIsNull() {
			addCriterion("SALE_CERT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeIsNotNull() {
			addCriterion("SALE_CERT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeEqualTo(Date value) {
			addCriterion("SALE_CERT_TIME =", value, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeNotEqualTo(Date value) {
			addCriterion("SALE_CERT_TIME <>", value, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeGreaterThan(Date value) {
			addCriterion("SALE_CERT_TIME >", value, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SALE_CERT_TIME >=", value, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeLessThan(Date value) {
			addCriterion("SALE_CERT_TIME <", value, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeLessThanOrEqualTo(Date value) {
			addCriterion("SALE_CERT_TIME <=", value, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeIn(List<Date> values) {
			addCriterion("SALE_CERT_TIME in", values, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeNotIn(List<Date> values) {
			addCriterion("SALE_CERT_TIME not in", values, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeBetween(Date value1, Date value2) {
			addCriterion("SALE_CERT_TIME between", value1, value2, "saleCertTime");
			return (Criteria) this;
		}

		public Criteria andSaleCertTimeNotBetween(Date value1, Date value2) {
			addCriterion("SALE_CERT_TIME not between", value1, value2, "saleCertTime");
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

		public Criteria andSaleRoofTIsNull() {
			addCriterion("SALE_ROOF_T is null");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTIsNotNull() {
			addCriterion("SALE_ROOF_T is not null");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTEqualTo(String value) {
			addCriterion("SALE_ROOF_T =", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTNotEqualTo(String value) {
			addCriterion("SALE_ROOF_T <>", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTGreaterThan(String value) {
			addCriterion("SALE_ROOF_T >", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_ROOF_T >=", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTLessThan(String value) {
			addCriterion("SALE_ROOF_T <", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTLessThanOrEqualTo(String value) {
			addCriterion("SALE_ROOF_T <=", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTLike(String value) {
			addCriterion("SALE_ROOF_T like", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTNotLike(String value) {
			addCriterion("SALE_ROOF_T not like", value, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTIn(List<String> values) {
			addCriterion("SALE_ROOF_T in", values, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTNotIn(List<String> values) {
			addCriterion("SALE_ROOF_T not in", values, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTBetween(String value1, String value2) {
			addCriterion("SALE_ROOF_T between", value1, value2, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleRoofTNotBetween(String value1, String value2) {
			addCriterion("SALE_ROOF_T not between", value1, value2, "saleRoofT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTIsNull() {
			addCriterion("SALE_NUM_T is null");
			return (Criteria) this;
		}

		public Criteria andSaleNumTIsNotNull() {
			addCriterion("SALE_NUM_T is not null");
			return (Criteria) this;
		}

		public Criteria andSaleNumTEqualTo(String value) {
			addCriterion("SALE_NUM_T =", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTNotEqualTo(String value) {
			addCriterion("SALE_NUM_T <>", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTGreaterThan(String value) {
			addCriterion("SALE_NUM_T >", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_NUM_T >=", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTLessThan(String value) {
			addCriterion("SALE_NUM_T <", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTLessThanOrEqualTo(String value) {
			addCriterion("SALE_NUM_T <=", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTLike(String value) {
			addCriterion("SALE_NUM_T like", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTNotLike(String value) {
			addCriterion("SALE_NUM_T not like", value, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTIn(List<String> values) {
			addCriterion("SALE_NUM_T in", values, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTNotIn(List<String> values) {
			addCriterion("SALE_NUM_T not in", values, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTBetween(String value1, String value2) {
			addCriterion("SALE_NUM_T between", value1, value2, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleNumTNotBetween(String value1, String value2) {
			addCriterion("SALE_NUM_T not between", value1, value2, "saleNumT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTIsNull() {
			addCriterion("SALE_UNIT_T is null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTIsNotNull() {
			addCriterion("SALE_UNIT_T is not null");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTEqualTo(String value) {
			addCriterion("SALE_UNIT_T =", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTNotEqualTo(String value) {
			addCriterion("SALE_UNIT_T <>", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTGreaterThan(String value) {
			addCriterion("SALE_UNIT_T >", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_UNIT_T >=", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTLessThan(String value) {
			addCriterion("SALE_UNIT_T <", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTLessThanOrEqualTo(String value) {
			addCriterion("SALE_UNIT_T <=", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTLike(String value) {
			addCriterion("SALE_UNIT_T like", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTNotLike(String value) {
			addCriterion("SALE_UNIT_T not like", value, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTIn(List<String> values) {
			addCriterion("SALE_UNIT_T in", values, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTNotIn(List<String> values) {
			addCriterion("SALE_UNIT_T not in", values, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTBetween(String value1, String value2) {
			addCriterion("SALE_UNIT_T between", value1, value2, "saleUnitT");
			return (Criteria) this;
		}

		public Criteria andSaleUnitTNotBetween(String value1, String value2) {
			addCriterion("SALE_UNIT_T not between", value1, value2, "saleUnitT");
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

		public Criteria andVideoNumEqualTo(Byte value) {
			addCriterion("VIDEO_NUM =", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumNotEqualTo(Byte value) {
			addCriterion("VIDEO_NUM <>", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumGreaterThan(Byte value) {
			addCriterion("VIDEO_NUM >", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumGreaterThanOrEqualTo(Byte value) {
			addCriterion("VIDEO_NUM >=", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumLessThan(Byte value) {
			addCriterion("VIDEO_NUM <", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumLessThanOrEqualTo(Byte value) {
			addCriterion("VIDEO_NUM <=", value, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumIn(List<Byte> values) {
			addCriterion("VIDEO_NUM in", values, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumNotIn(List<Byte> values) {
			addCriterion("VIDEO_NUM not in", values, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumBetween(Byte value1, Byte value2) {
			addCriterion("VIDEO_NUM between", value1, value2, "videoNum");
			return (Criteria) this;
		}

		public Criteria andVideoNumNotBetween(Byte value1, Byte value2) {
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

		public Criteria andSaleIdOldIsNull() {
			addCriterion("sale_id_old is null");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldIsNotNull() {
			addCriterion("sale_id_old is not null");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldEqualTo(Integer value) {
			addCriterion("sale_id_old =", value, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldNotEqualTo(Integer value) {
			addCriterion("sale_id_old <>", value, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldGreaterThan(Integer value) {
			addCriterion("sale_id_old >", value, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldGreaterThanOrEqualTo(Integer value) {
			addCriterion("sale_id_old >=", value, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldLessThan(Integer value) {
			addCriterion("sale_id_old <", value, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldLessThanOrEqualTo(Integer value) {
			addCriterion("sale_id_old <=", value, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldIn(List<Integer> values) {
			addCriterion("sale_id_old in", values, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldNotIn(List<Integer> values) {
			addCriterion("sale_id_old not in", values, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldBetween(Integer value1, Integer value2) {
			addCriterion("sale_id_old between", value1, value2, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleIdOldNotBetween(Integer value1, Integer value2) {
			addCriterion("sale_id_old not between", value1, value2, "saleIdOld");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaIsNull() {
			addCriterion("SALE_INNERAREA is null");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaIsNotNull() {
			addCriterion("SALE_INNERAREA is not null");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaEqualTo(BigDecimal value) {
			addCriterion("SALE_INNERAREA =", value, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaNotEqualTo(BigDecimal value) {
			addCriterion("SALE_INNERAREA <>", value, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaGreaterThan(BigDecimal value) {
			addCriterion("SALE_INNERAREA >", value, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_INNERAREA >=", value, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaLessThan(BigDecimal value) {
			addCriterion("SALE_INNERAREA <", value, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_INNERAREA <=", value, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaIn(List<BigDecimal> values) {
			addCriterion("SALE_INNERAREA in", values, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaNotIn(List<BigDecimal> values) {
			addCriterion("SALE_INNERAREA not in", values, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_INNERAREA between", value1, value2, "saleInnerarea");
			return (Criteria) this;
		}

		public Criteria andSaleInnerareaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_INNERAREA not between", value1, value2, "saleInnerarea");
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

		public Criteria andCheckCodeUrlIsNull() {
			addCriterion("CHECK_CODE_URL is null");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlIsNotNull() {
			addCriterion("CHECK_CODE_URL is not null");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlEqualTo(String value) {
			addCriterion("CHECK_CODE_URL =", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlNotEqualTo(String value) {
			addCriterion("CHECK_CODE_URL <>", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlGreaterThan(String value) {
			addCriterion("CHECK_CODE_URL >", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlGreaterThanOrEqualTo(String value) {
			addCriterion("CHECK_CODE_URL >=", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlLessThan(String value) {
			addCriterion("CHECK_CODE_URL <", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlLessThanOrEqualTo(String value) {
			addCriterion("CHECK_CODE_URL <=", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlLike(String value) {
			addCriterion("CHECK_CODE_URL like", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlNotLike(String value) {
			addCriterion("CHECK_CODE_URL not like", value, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlIn(List<String> values) {
			addCriterion("CHECK_CODE_URL in", values, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlNotIn(List<String> values) {
			addCriterion("CHECK_CODE_URL not in", values, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlBetween(String value1, String value2) {
			addCriterion("CHECK_CODE_URL between", value1, value2, "checkCodeUrl");
			return (Criteria) this;
		}

		public Criteria andCheckCodeUrlNotBetween(String value1, String value2) {
			addCriterion("CHECK_CODE_URL not between", value1, value2, "checkCodeUrl");
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

		public Criteria andCompId2IsNull() {
			addCriterion("COMP_ID2 is null");
			return (Criteria) this;
		}

		public Criteria andCompId2IsNotNull() {
			addCriterion("COMP_ID2 is not null");
			return (Criteria) this;
		}

		public Criteria andCompId2EqualTo(Integer value) {
			addCriterion("COMP_ID2 =", value, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2NotEqualTo(Integer value) {
			addCriterion("COMP_ID2 <>", value, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2GreaterThan(Integer value) {
			addCriterion("COMP_ID2 >", value, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2GreaterThanOrEqualTo(Integer value) {
			addCriterion("COMP_ID2 >=", value, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2LessThan(Integer value) {
			addCriterion("COMP_ID2 <", value, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2LessThanOrEqualTo(Integer value) {
			addCriterion("COMP_ID2 <=", value, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2In(List<Integer> values) {
			addCriterion("COMP_ID2 in", values, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2NotIn(List<Integer> values) {
			addCriterion("COMP_ID2 not in", values, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2Between(Integer value1, Integer value2) {
			addCriterion("COMP_ID2 between", value1, value2, "compId2");
			return (Criteria) this;
		}

		public Criteria andCompId2NotBetween(Integer value1, Integer value2) {
			addCriterion("COMP_ID2 not between", value1, value2, "compId2");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeIsNull() {
			addCriterion("FILE_SYSTEM_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeIsNotNull() {
			addCriterion("FILE_SYSTEM_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE =", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeNotEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE <>", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeGreaterThan(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE >", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE >=", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeLessThan(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE <", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeLessThanOrEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE <=", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeIn(List<Byte> values) {
			addCriterion("FILE_SYSTEM_TYPE in", values, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeNotIn(List<Byte> values) {
			addCriterion("FILE_SYSTEM_TYPE not in", values, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeBetween(Byte value1, Byte value2) {
			addCriterion("FILE_SYSTEM_TYPE between", value1, value2, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("FILE_SYSTEM_TYPE not between", value1, value2, "fileSystemType");
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

		public Criteria andSaleBayIsNull() {
			addCriterion("SALE_BAY is null");
			return (Criteria) this;
		}

		public Criteria andSaleBayIsNotNull() {
			addCriterion("SALE_BAY is not null");
			return (Criteria) this;
		}

		public Criteria andSaleBayEqualTo(BigDecimal value) {
			addCriterion("SALE_BAY =", value, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayNotEqualTo(BigDecimal value) {
			addCriterion("SALE_BAY <>", value, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayGreaterThan(BigDecimal value) {
			addCriterion("SALE_BAY >", value, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_BAY >=", value, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayLessThan(BigDecimal value) {
			addCriterion("SALE_BAY <", value, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_BAY <=", value, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayIn(List<BigDecimal> values) {
			addCriterion("SALE_BAY in", values, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayNotIn(List<BigDecimal> values) {
			addCriterion("SALE_BAY not in", values, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_BAY between", value1, value2, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleBayNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_BAY not between", value1, value2, "saleBay");
			return (Criteria) this;
		}

		public Criteria andSaleDepthIsNull() {
			addCriterion("SALE_DEPTH is null");
			return (Criteria) this;
		}

		public Criteria andSaleDepthIsNotNull() {
			addCriterion("SALE_DEPTH is not null");
			return (Criteria) this;
		}

		public Criteria andSaleDepthEqualTo(BigDecimal value) {
			addCriterion("SALE_DEPTH =", value, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthNotEqualTo(BigDecimal value) {
			addCriterion("SALE_DEPTH <>", value, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthGreaterThan(BigDecimal value) {
			addCriterion("SALE_DEPTH >", value, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_DEPTH >=", value, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthLessThan(BigDecimal value) {
			addCriterion("SALE_DEPTH <", value, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_DEPTH <=", value, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthIn(List<BigDecimal> values) {
			addCriterion("SALE_DEPTH in", values, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthNotIn(List<BigDecimal> values) {
			addCriterion("SALE_DEPTH not in", values, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_DEPTH between", value1, value2, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleDepthNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_DEPTH not between", value1, value2, "saleDepth");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyIsNull() {
			addCriterion("SALE_STOREY is null");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyIsNotNull() {
			addCriterion("SALE_STOREY is not null");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyEqualTo(BigDecimal value) {
			addCriterion("SALE_STOREY =", value, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyNotEqualTo(BigDecimal value) {
			addCriterion("SALE_STOREY <>", value, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyGreaterThan(BigDecimal value) {
			addCriterion("SALE_STOREY >", value, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_STOREY >=", value, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyLessThan(BigDecimal value) {
			addCriterion("SALE_STOREY <", value, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_STOREY <=", value, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyIn(List<BigDecimal> values) {
			addCriterion("SALE_STOREY in", values, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyNotIn(List<BigDecimal> values) {
			addCriterion("SALE_STOREY not in", values, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_STOREY between", value1, value2, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleStoreyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_STOREY not between", value1, value2, "saleStorey");
			return (Criteria) this;
		}

		public Criteria andSaleGradationIsNull() {
			addCriterion("SALE_GRADATION is null");
			return (Criteria) this;
		}

		public Criteria andSaleGradationIsNotNull() {
			addCriterion("SALE_GRADATION is not null");
			return (Criteria) this;
		}

		public Criteria andSaleGradationEqualTo(Byte value) {
			addCriterion("SALE_GRADATION =", value, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationNotEqualTo(Byte value) {
			addCriterion("SALE_GRADATION <>", value, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationGreaterThan(Byte value) {
			addCriterion("SALE_GRADATION >", value, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_GRADATION >=", value, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationLessThan(Byte value) {
			addCriterion("SALE_GRADATION <", value, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_GRADATION <=", value, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationIn(List<Byte> values) {
			addCriterion("SALE_GRADATION in", values, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationNotIn(List<Byte> values) {
			addCriterion("SALE_GRADATION not in", values, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationBetween(Byte value1, Byte value2) {
			addCriterion("SALE_GRADATION between", value1, value2, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleGradationNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_GRADATION not between", value1, value2, "saleGradation");
			return (Criteria) this;
		}

		public Criteria andSaleNatureIsNull() {
			addCriterion("SALE_NATURE is null");
			return (Criteria) this;
		}

		public Criteria andSaleNatureIsNotNull() {
			addCriterion("SALE_NATURE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleNatureEqualTo(Byte value) {
			addCriterion("SALE_NATURE =", value, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureNotEqualTo(Byte value) {
			addCriterion("SALE_NATURE <>", value, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureGreaterThan(Byte value) {
			addCriterion("SALE_NATURE >", value, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_NATURE >=", value, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureLessThan(Byte value) {
			addCriterion("SALE_NATURE <", value, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_NATURE <=", value, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureIn(List<Byte> values) {
			addCriterion("SALE_NATURE in", values, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureNotIn(List<Byte> values) {
			addCriterion("SALE_NATURE not in", values, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureBetween(Byte value1, Byte value2) {
			addCriterion("SALE_NATURE between", value1, value2, "saleNature");
			return (Criteria) this;
		}

		public Criteria andSaleNatureNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_NATURE not between", value1, value2, "saleNature");
			return (Criteria) this;
		}

		public Criteria andVillaTypeIsNull() {
			addCriterion("VILLA_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andVillaTypeIsNotNull() {
			addCriterion("VILLA_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andVillaTypeEqualTo(Byte value) {
			addCriterion("VILLA_TYPE =", value, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeNotEqualTo(Byte value) {
			addCriterion("VILLA_TYPE <>", value, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeGreaterThan(Byte value) {
			addCriterion("VILLA_TYPE >", value, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("VILLA_TYPE >=", value, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeLessThan(Byte value) {
			addCriterion("VILLA_TYPE <", value, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeLessThanOrEqualTo(Byte value) {
			addCriterion("VILLA_TYPE <=", value, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeIn(List<Byte> values) {
			addCriterion("VILLA_TYPE in", values, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeNotIn(List<Byte> values) {
			addCriterion("VILLA_TYPE not in", values, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeBetween(Byte value1, Byte value2) {
			addCriterion("VILLA_TYPE between", value1, value2, "villaType");
			return (Criteria) this;
		}

		public Criteria andVillaTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("VILLA_TYPE not between", value1, value2, "villaType");
			return (Criteria) this;
		}

		public Criteria andSaleStyleIsNull() {
			addCriterion("SALE_STYLE is null");
			return (Criteria) this;
		}

		public Criteria andSaleStyleIsNotNull() {
			addCriterion("SALE_STYLE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleStyleEqualTo(Byte value) {
			addCriterion("SALE_STYLE =", value, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleNotEqualTo(Byte value) {
			addCriterion("SALE_STYLE <>", value, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleGreaterThan(Byte value) {
			addCriterion("SALE_STYLE >", value, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_STYLE >=", value, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleLessThan(Byte value) {
			addCriterion("SALE_STYLE <", value, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_STYLE <=", value, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleIn(List<Byte> values) {
			addCriterion("SALE_STYLE in", values, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleNotIn(List<Byte> values) {
			addCriterion("SALE_STYLE not in", values, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleBetween(Byte value1, Byte value2) {
			addCriterion("SALE_STYLE between", value1, value2, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andSaleStyleNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_STYLE not between", value1, value2, "saleStyle");
			return (Criteria) this;
		}

		public Criteria andActionTypeIsNull() {
			addCriterion("ACTION_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andActionTypeIsNotNull() {
			addCriterion("ACTION_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andActionTypeEqualTo(Byte value) {
			addCriterion("ACTION_TYPE =", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeNotEqualTo(Byte value) {
			addCriterion("ACTION_TYPE <>", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeGreaterThan(Byte value) {
			addCriterion("ACTION_TYPE >", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ACTION_TYPE >=", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeLessThan(Byte value) {
			addCriterion("ACTION_TYPE <", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ACTION_TYPE <=", value, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeIn(List<Byte> values) {
			addCriterion("ACTION_TYPE in", values, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeNotIn(List<Byte> values) {
			addCriterion("ACTION_TYPE not in", values, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeBetween(Byte value1, Byte value2) {
			addCriterion("ACTION_TYPE between", value1, value2, "actionType");
			return (Criteria) this;
		}

		public Criteria andActionTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ACTION_TYPE not between", value1, value2, "actionType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeIsNull() {
			addCriterion("SCENERY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeIsNotNull() {
			addCriterion("SCENERY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeEqualTo(Byte value) {
			addCriterion("SCENERY_TYPE =", value, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeNotEqualTo(Byte value) {
			addCriterion("SCENERY_TYPE <>", value, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeGreaterThan(Byte value) {
			addCriterion("SCENERY_TYPE >", value, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SCENERY_TYPE >=", value, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeLessThan(Byte value) {
			addCriterion("SCENERY_TYPE <", value, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SCENERY_TYPE <=", value, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeIn(List<Byte> values) {
			addCriterion("SCENERY_TYPE in", values, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeNotIn(List<Byte> values) {
			addCriterion("SCENERY_TYPE not in", values, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeBetween(Byte value1, Byte value2) {
			addCriterion("SCENERY_TYPE between", value1, value2, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andSceneryTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SCENERY_TYPE not between", value1, value2, "sceneryType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeIsNull() {
			addCriterion("RECEIPT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeIsNotNull() {
			addCriterion("RECEIPT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeEqualTo(Byte value) {
			addCriterion("RECEIPT_TYPE =", value, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeNotEqualTo(Byte value) {
			addCriterion("RECEIPT_TYPE <>", value, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeGreaterThan(Byte value) {
			addCriterion("RECEIPT_TYPE >", value, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("RECEIPT_TYPE >=", value, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeLessThan(Byte value) {
			addCriterion("RECEIPT_TYPE <", value, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeLessThanOrEqualTo(Byte value) {
			addCriterion("RECEIPT_TYPE <=", value, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeIn(List<Byte> values) {
			addCriterion("RECEIPT_TYPE in", values, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeNotIn(List<Byte> values) {
			addCriterion("RECEIPT_TYPE not in", values, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeBetween(Byte value1, Byte value2) {
			addCriterion("RECEIPT_TYPE between", value1, value2, "receiptType");
			return (Criteria) this;
		}

		public Criteria andReceiptTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("RECEIPT_TYPE not between", value1, value2, "receiptType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeIsNull() {
			addCriterion("GUARANTY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeIsNotNull() {
			addCriterion("GUARANTY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeEqualTo(Byte value) {
			addCriterion("GUARANTY_TYPE =", value, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeNotEqualTo(Byte value) {
			addCriterion("GUARANTY_TYPE <>", value, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeGreaterThan(Byte value) {
			addCriterion("GUARANTY_TYPE >", value, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("GUARANTY_TYPE >=", value, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeLessThan(Byte value) {
			addCriterion("GUARANTY_TYPE <", value, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeLessThanOrEqualTo(Byte value) {
			addCriterion("GUARANTY_TYPE <=", value, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeIn(List<Byte> values) {
			addCriterion("GUARANTY_TYPE in", values, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeNotIn(List<Byte> values) {
			addCriterion("GUARANTY_TYPE not in", values, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeBetween(Byte value1, Byte value2) {
			addCriterion("GUARANTY_TYPE between", value1, value2, "guarantyType");
			return (Criteria) this;
		}

		public Criteria andGuarantyTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("GUARANTY_TYPE not between", value1, value2, "guarantyType");
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

		public Criteria andSaleBuyPriceIsNull() {
			addCriterion("SALE_BUY_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceIsNotNull() {
			addCriterion("SALE_BUY_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceEqualTo(BigDecimal value) {
			addCriterion("SALE_BUY_PRICE =", value, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceNotEqualTo(BigDecimal value) {
			addCriterion("SALE_BUY_PRICE <>", value, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceGreaterThan(BigDecimal value) {
			addCriterion("SALE_BUY_PRICE >", value, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_BUY_PRICE >=", value, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceLessThan(BigDecimal value) {
			addCriterion("SALE_BUY_PRICE <", value, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_BUY_PRICE <=", value, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceIn(List<BigDecimal> values) {
			addCriterion("SALE_BUY_PRICE in", values, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceNotIn(List<BigDecimal> values) {
			addCriterion("SALE_BUY_PRICE not in", values, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_BUY_PRICE between", value1, value2, "saleBuyPrice");
			return (Criteria) this;
		}

		public Criteria andSaleBuyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_BUY_PRICE not between", value1, value2, "saleBuyPrice");
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

		public Criteria andSaleKeyUserIdIsNull() {
			addCriterion("SALE_KEY_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdIsNotNull() {
			addCriterion("SALE_KEY_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdEqualTo(Integer value) {
			addCriterion("SALE_KEY_USER_ID =", value, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdNotEqualTo(Integer value) {
			addCriterion("SALE_KEY_USER_ID <>", value, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdGreaterThan(Integer value) {
			addCriterion("SALE_KEY_USER_ID >", value, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_KEY_USER_ID >=", value, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdLessThan(Integer value) {
			addCriterion("SALE_KEY_USER_ID <", value, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_KEY_USER_ID <=", value, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdIn(List<Integer> values) {
			addCriterion("SALE_KEY_USER_ID in", values, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdNotIn(List<Integer> values) {
			addCriterion("SALE_KEY_USER_ID not in", values, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdBetween(Integer value1, Integer value2) {
			addCriterion("SALE_KEY_USER_ID between", value1, value2, "saleKeyUserId");
			return (Criteria) this;
		}

		public Criteria andSaleKeyUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_KEY_USER_ID not between", value1, value2, "saleKeyUserId");
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

		public Criteria andMortgageBankIsNull() {
			addCriterion("MORTGAGE_BANK is null");
			return (Criteria) this;
		}

		public Criteria andMortgageBankIsNotNull() {
			addCriterion("MORTGAGE_BANK is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageBankEqualTo(String value) {
			addCriterion("MORTGAGE_BANK =", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNotEqualTo(String value) {
			addCriterion("MORTGAGE_BANK <>", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankGreaterThan(String value) {
			addCriterion("MORTGAGE_BANK >", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankGreaterThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_BANK >=", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankLessThan(String value) {
			addCriterion("MORTGAGE_BANK <", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankLessThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_BANK <=", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankLike(String value) {
			addCriterion("MORTGAGE_BANK like", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNotLike(String value) {
			addCriterion("MORTGAGE_BANK not like", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankIn(List<String> values) {
			addCriterion("MORTGAGE_BANK in", values, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNotIn(List<String> values) {
			addCriterion("MORTGAGE_BANK not in", values, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankBetween(String value1, String value2) {
			addCriterion("MORTGAGE_BANK between", value1, value2, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNotBetween(String value1, String value2) {
			addCriterion("MORTGAGE_BANK not between", value1, value2, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andArrearsIsNull() {
			addCriterion("ARREARS is null");
			return (Criteria) this;
		}

		public Criteria andArrearsIsNotNull() {
			addCriterion("ARREARS is not null");
			return (Criteria) this;
		}

		public Criteria andArrearsEqualTo(BigDecimal value) {
			addCriterion("ARREARS =", value, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsNotEqualTo(BigDecimal value) {
			addCriterion("ARREARS <>", value, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsGreaterThan(BigDecimal value) {
			addCriterion("ARREARS >", value, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ARREARS >=", value, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsLessThan(BigDecimal value) {
			addCriterion("ARREARS <", value, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ARREARS <=", value, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsIn(List<BigDecimal> values) {
			addCriterion("ARREARS in", values, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsNotIn(List<BigDecimal> values) {
			addCriterion("ARREARS not in", values, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ARREARS between", value1, value2, "arrears");
			return (Criteria) this;
		}

		public Criteria andArrearsNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ARREARS not between", value1, value2, "arrears");
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

		public Criteria andTurnRateIsNull() {
			addCriterion("TURN_RATE is null");
			return (Criteria) this;
		}

		public Criteria andTurnRateIsNotNull() {
			addCriterion("TURN_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andTurnRateEqualTo(BigDecimal value) {
			addCriterion("TURN_RATE =", value, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateNotEqualTo(BigDecimal value) {
			addCriterion("TURN_RATE <>", value, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateGreaterThan(BigDecimal value) {
			addCriterion("TURN_RATE >", value, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TURN_RATE >=", value, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateLessThan(BigDecimal value) {
			addCriterion("TURN_RATE <", value, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TURN_RATE <=", value, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateIn(List<BigDecimal> values) {
			addCriterion("TURN_RATE in", values, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateNotIn(List<BigDecimal> values) {
			addCriterion("TURN_RATE not in", values, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TURN_RATE between", value1, value2, "turnRate");
			return (Criteria) this;
		}

		public Criteria andTurnRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TURN_RATE not between", value1, value2, "turnRate");
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

		public Criteria andSaleEntrustPriceIsNull() {
			addCriterion("SALE_ENTRUST_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceIsNotNull() {
			addCriterion("SALE_ENTRUST_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE =", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceNotEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE <>", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceGreaterThan(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE >", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE >=", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceLessThan(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE <", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALE_ENTRUST_PRICE <=", value, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceIn(List<BigDecimal> values) {
			addCriterion("SALE_ENTRUST_PRICE in", values, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceNotIn(List<BigDecimal> values) {
			addCriterion("SALE_ENTRUST_PRICE not in", values, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_ENTRUST_PRICE between", value1, value2, "saleEntrustPrice");
			return (Criteria) this;
		}

		public Criteria andSaleEntrustPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALE_ENTRUST_PRICE not between", value1, value2, "saleEntrustPrice");
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

		public Criteria andSaleAmountChangeTimeIsNull() {
			addCriterion("SALE_AMOUNT_CHANGE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeIsNotNull() {
			addCriterion("SALE_AMOUNT_CHANGE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeEqualTo(Date value) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME =", value, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeNotEqualTo(Date value) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME <>", value, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeGreaterThan(Date value) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME >", value, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME >=", value, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeLessThan(Date value) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME <", value, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeLessThanOrEqualTo(Date value) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME <=", value, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeIn(List<Date> values) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME in", values, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeNotIn(List<Date> values) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME not in", values, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeBetween(Date value1, Date value2) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME between", value1, value2, "saleAmountChangeTime");
			return (Criteria) this;
		}

		public Criteria andSaleAmountChangeTimeNotBetween(Date value1, Date value2) {
			addCriterion("SALE_AMOUNT_CHANGE_TIME not between", value1, value2, "saleAmountChangeTime");
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